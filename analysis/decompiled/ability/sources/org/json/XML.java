package org.json;

import B7.a;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonPointer;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Iterator;

/* loaded from: classes4.dex */
public class XML {
    public static final String NULL_ATTR = "xsi:nil";
    public static final String TYPE_ATTR = "xsi:type";
    public static final Character AMP = '&';
    public static final Character APOS = '\'';
    public static final Character BANG = '!';
    public static final Character EQ = '=';
    public static final Character GT = '>';
    public static final Character LT = '<';
    public static final Character QUEST = '?';
    public static final Character QUOT = Character.valueOf(JsonFactory.DEFAULT_QUOTE_CHAR);
    public static final Character SLASH = Character.valueOf(JsonPointer.SEPARATOR);

    private static Iterable<Integer> codePointIterator(final String str) {
        return new Iterable<Integer>() { // from class: org.json.XML.1
            @Override // java.lang.Iterable
            public Iterator<Integer> iterator() {
                return new Iterator<Integer>() { // from class: org.json.XML.1.1
                    private int length;
                    private int nextIndex = 0;

                    {
                        this.length = str.length();
                    }

                    @Override // java.util.Iterator
                    public boolean hasNext() {
                        return this.nextIndex < this.length;
                    }

                    @Override // java.util.Iterator
                    public void remove() {
                        throw new UnsupportedOperationException();
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // java.util.Iterator
                    public Integer next() {
                        int iCodePointAt = str.codePointAt(this.nextIndex);
                        this.nextIndex = Character.charCount(iCodePointAt) + this.nextIndex;
                        return Integer.valueOf(iCodePointAt);
                    }
                };
            }
        };
    }

    public static String escape(String str) {
        StringBuilder sb = new StringBuilder(str.length());
        Iterator<Integer> it = codePointIterator(str).iterator();
        while (it.hasNext()) {
            int iIntValue = it.next().intValue();
            if (iIntValue == 34) {
                sb.append("&quot;");
            } else if (iIntValue == 60) {
                sb.append("&lt;");
            } else if (iIntValue == 62) {
                sb.append("&gt;");
            } else if (iIntValue == 38) {
                sb.append("&amp;");
            } else if (iIntValue == 39) {
                sb.append("&apos;");
            } else if (mustEscape(iIntValue)) {
                sb.append("&#x");
                sb.append(Integer.toHexString(iIntValue));
                sb.append(';');
            } else {
                sb.appendCodePoint(iIntValue);
            }
        }
        return sb.toString();
    }

    private static final String indent(int i) {
        StringBuilder sb = new StringBuilder();
        for (int i6 = 0; i6 < i; i6++) {
            sb.append(' ');
        }
        return sb.toString();
    }

    private static boolean isDecimalNotation(String str) {
        return str.indexOf(46) > -1 || str.indexOf(101) > -1 || str.indexOf(69) > -1 || "-0".equals(str);
    }

    private static boolean isStringAllWhiteSpace(String str) {
        for (int i = 0; i < str.length(); i++) {
            if (!Character.isWhitespace(str.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    private static boolean mustEscape(int i) {
        if (Character.isISOControl(i) && i != 9 && i != 10 && i != 13) {
            return true;
        }
        if (i >= 32 && i <= 55295) {
            return false;
        }
        if (i < 57344 || i > 65533) {
            return i < 65536 || i > 1114111;
        }
        return false;
    }

    public static void noSpace(String str) throws JSONException {
        int length = str.length();
        if (length == 0) {
            throw new JSONException("Empty string.");
        }
        for (int i = 0; i < length; i++) {
            if (Character.isWhitespace(str.charAt(i))) {
                throw new JSONException(a.m("'", str, "' contains a space character."));
            }
        }
    }

    private static boolean parse(XMLTokener xMLTokener, JSONObject jSONObject, String str, XMLParserConfiguration xMLParserConfiguration, int i) throws JSONException, IOException {
        Object objNextToken = xMLTokener.nextToken();
        int i6 = 1;
        if (objNextToken == BANG) {
            char next = xMLTokener.next();
            if (next == '-') {
                if (xMLTokener.next() == '-') {
                    xMLTokener.skipPast("-->");
                    return false;
                }
                xMLTokener.back();
            } else if (next == '[') {
                if (!"CDATA".equals(xMLTokener.nextToken()) || xMLTokener.next() != '[') {
                    throw xMLTokener.syntaxError("Expected 'CDATA['");
                }
                String strNextCDATA = xMLTokener.nextCDATA();
                if (strNextCDATA.length() > 0) {
                    jSONObject.accumulate(xMLParserConfiguration.getcDataTagName(), strNextCDATA);
                }
                return false;
            }
            do {
                Object objNextMeta = xMLTokener.nextMeta();
                if (objNextMeta == null) {
                    throw xMLTokener.syntaxError("Missing '>' after '<!'.");
                }
                if (objNextMeta == LT) {
                    i6++;
                } else if (objNextMeta == GT) {
                    i6--;
                }
            } while (i6 > 0);
            return false;
        }
        if (objNextToken == QUEST) {
            xMLTokener.skipPast("?>");
            return false;
        }
        if (objNextToken == SLASH) {
            Object objNextToken2 = xMLTokener.nextToken();
            if (str == null) {
                throw xMLTokener.syntaxError("Mismatched close tag " + objNextToken2);
            }
            if (objNextToken2.equals(str)) {
                if (xMLTokener.nextToken() == GT) {
                    return true;
                }
                throw xMLTokener.syntaxError("Misshaped close tag");
            }
            throw xMLTokener.syntaxError("Mismatched " + str + " and " + objNextToken2);
        }
        if (objNextToken instanceof Character) {
            throw xMLTokener.syntaxError("Misshaped tag");
        }
        String str2 = (String) objNextToken;
        JSONObject jSONObject2 = new JSONObject();
        boolean z10 = false;
        Object objNextToken3 = null;
        XMLXsiTypeConverter<?> xMLXsiTypeConverter = null;
        while (true) {
            if (objNextToken3 == null) {
                objNextToken3 = xMLTokener.nextToken();
            }
            if (objNextToken3 instanceof String) {
                String str3 = (String) objNextToken3;
                Object objNextToken4 = xMLTokener.nextToken();
                if (objNextToken4 == EQ) {
                    Object objNextToken5 = xMLTokener.nextToken();
                    if (!(objNextToken5 instanceof String)) {
                        throw xMLTokener.syntaxError("Missing value");
                    }
                    if (xMLParserConfiguration.isConvertNilAttributeToNull() && NULL_ATTR.equals(str3) && Boolean.parseBoolean((String) objNextToken5)) {
                        z10 = true;
                    } else if (xMLParserConfiguration.getXsiTypeMap() != null && !xMLParserConfiguration.getXsiTypeMap().isEmpty() && TYPE_ATTR.equals(str3)) {
                        xMLXsiTypeConverter = xMLParserConfiguration.getXsiTypeMap().get(objNextToken5);
                    } else if (!z10) {
                        String str4 = (String) objNextToken5;
                        Object objStringToValue = str4;
                        if (!xMLParserConfiguration.isKeepStrings()) {
                            objStringToValue = stringToValue(str4);
                        }
                        jSONObject2.accumulate(str3, objStringToValue);
                    }
                    objNextToken3 = null;
                } else {
                    jSONObject2.accumulate(str3, "");
                    objNextToken3 = objNextToken4;
                }
            } else {
                if (objNextToken3 == SLASH) {
                    if (xMLTokener.nextToken() != GT) {
                        throw xMLTokener.syntaxError("Misshaped tag");
                    }
                    if (xMLParserConfiguration.getForceList().contains(str2)) {
                        if (z10) {
                            jSONObject.append(str2, JSONObject.NULL);
                        } else if (jSONObject2.length() > 0) {
                            jSONObject.append(str2, jSONObject2);
                        } else {
                            jSONObject.put(str2, new JSONArray());
                        }
                    } else if (z10) {
                        jSONObject.accumulate(str2, JSONObject.NULL);
                    } else if (jSONObject2.length() > 0) {
                        jSONObject.accumulate(str2, jSONObject2);
                    } else {
                        jSONObject.accumulate(str2, "");
                    }
                    return false;
                }
                if (objNextToken3 != GT) {
                    throw xMLTokener.syntaxError("Misshaped tag");
                }
                while (true) {
                    Object objNextContent = xMLTokener.nextContent();
                    if (objNextContent == null) {
                        if (str2 == null) {
                            return false;
                        }
                        throw xMLTokener.syntaxError("Unclosed tag ".concat(str2));
                    }
                    if (objNextContent instanceof String) {
                        String str5 = (String) objNextContent;
                        if (str5.length() > 0) {
                            if (xMLXsiTypeConverter != null) {
                                jSONObject2.accumulate(xMLParserConfiguration.getcDataTagName(), stringToValue(str5, xMLXsiTypeConverter));
                            } else {
                                String str6 = xMLParserConfiguration.getcDataTagName();
                                Object objStringToValue2 = str5;
                                if (!xMLParserConfiguration.isKeepStrings()) {
                                    objStringToValue2 = stringToValue(str5);
                                }
                                jSONObject2.accumulate(str6, objStringToValue2);
                            }
                        }
                    } else if (objNextContent != LT) {
                        continue;
                    } else {
                        if (i == xMLParserConfiguration.getMaxNestingDepth()) {
                            throw xMLTokener.syntaxError("Maximum nesting depth of " + xMLParserConfiguration.getMaxNestingDepth() + " reached");
                        }
                        if (parse(xMLTokener, jSONObject2, str2, xMLParserConfiguration, i + 1)) {
                            if (xMLParserConfiguration.getForceList().contains(str2)) {
                                if (jSONObject2.length() == 0) {
                                    jSONObject.put(str2, new JSONArray());
                                } else if (jSONObject2.length() != 1 || jSONObject2.opt(xMLParserConfiguration.getcDataTagName()) == null) {
                                    jSONObject.append(str2, jSONObject2);
                                } else {
                                    jSONObject.append(str2, jSONObject2.opt(xMLParserConfiguration.getcDataTagName()));
                                }
                            } else if (jSONObject2.length() == 0) {
                                jSONObject.accumulate(str2, "");
                            } else if (jSONObject2.length() != 1 || jSONObject2.opt(xMLParserConfiguration.getcDataTagName()) == null) {
                                if (!xMLParserConfiguration.shouldTrimWhiteSpace()) {
                                    removeEmpty(jSONObject2, xMLParserConfiguration);
                                }
                                jSONObject.accumulate(str2, jSONObject2);
                            } else {
                                jSONObject.accumulate(str2, jSONObject2.opt(xMLParserConfiguration.getcDataTagName()));
                            }
                            return false;
                        }
                    }
                }
            }
        }
    }

    private static void removeEmpty(JSONObject jSONObject, XMLParserConfiguration xMLParserConfiguration) throws JSONException {
        if (jSONObject.has(xMLParserConfiguration.getcDataTagName())) {
            Object obj = jSONObject.get(xMLParserConfiguration.getcDataTagName());
            if (obj instanceof String) {
                if (isStringAllWhiteSpace(obj.toString())) {
                    jSONObject.remove(xMLParserConfiguration.getcDataTagName());
                }
            } else if (obj instanceof JSONArray) {
                JSONArray jSONArray = (JSONArray) obj;
                for (int length = jSONArray.length() - 1; length >= 0; length--) {
                    Object obj2 = jSONArray.get(length);
                    if ((obj2 instanceof String) && isStringAllWhiteSpace((String) obj2)) {
                        jSONArray.remove(length);
                    }
                }
                if (jSONArray.isEmpty()) {
                    jSONObject.remove(xMLParserConfiguration.getcDataTagName());
                }
            }
        }
    }

    private static Number stringToNumber(String str) throws NumberFormatException {
        char cCharAt = str.charAt(0);
        if ((cCharAt < '0' || cCharAt > '9') && cCharAt != '-') {
            throw new NumberFormatException(a.m("val [", str, "] is not a valid number."));
        }
        if (isDecimalNotation(str)) {
            try {
                try {
                    BigDecimal bigDecimal = new BigDecimal(str);
                    return (cCharAt == '-' && BigDecimal.ZERO.compareTo(bigDecimal) == 0) ? Double.valueOf(-0.0d) : bigDecimal;
                } catch (NumberFormatException unused) {
                    throw new NumberFormatException(a.m("val [", str, "] is not a valid number."));
                }
            } catch (NumberFormatException unused2) {
                Double dValueOf = Double.valueOf(str);
                if (!dValueOf.isNaN() && !dValueOf.isInfinite()) {
                    return dValueOf;
                }
                throw new NumberFormatException("val [" + str + "] is not a valid number.");
            }
        }
        if (cCharAt == '0' && str.length() > 1) {
            char cCharAt2 = str.charAt(1);
            if (cCharAt2 >= '0' && cCharAt2 <= '9') {
                throw new NumberFormatException(a.m("val [", str, "] is not a valid number."));
            }
        } else if (cCharAt == '-' && str.length() > 2) {
            char cCharAt3 = str.charAt(1);
            char cCharAt4 = str.charAt(2);
            if (cCharAt3 == '0' && cCharAt4 >= '0' && cCharAt4 <= '9') {
                throw new NumberFormatException(a.m("val [", str, "] is not a valid number."));
            }
        }
        BigInteger bigInteger = new BigInteger(str);
        return bigInteger.bitLength() <= 31 ? Integer.valueOf(bigInteger.intValue()) : bigInteger.bitLength() <= 63 ? Long.valueOf(bigInteger.longValue()) : bigInteger;
    }

    public static Object stringToValue(String str, XMLXsiTypeConverter<?> xMLXsiTypeConverter) {
        return xMLXsiTypeConverter != null ? xMLXsiTypeConverter.convert(str) : stringToValue(str);
    }

    public static JSONObject toJSONObject(String str) throws JSONException {
        return toJSONObject(str, XMLParserConfiguration.ORIGINAL);
    }

    public static String toString(Object obj) throws JSONException {
        return toString(obj, (String) null, XMLParserConfiguration.ORIGINAL);
    }

    public static String unescape(String str) {
        StringBuilder sb = new StringBuilder(str.length());
        int length = str.length();
        int length2 = 0;
        while (length2 < length) {
            char cCharAt = str.charAt(length2);
            if (cCharAt == '&') {
                int iIndexOf = str.indexOf(59, length2);
                if (iIndexOf > length2) {
                    String strSubstring = str.substring(length2 + 1, iIndexOf);
                    sb.append(XMLTokener.unescapeEntity(strSubstring));
                    length2 += strSubstring.length() + 1;
                } else {
                    sb.append(cCharAt);
                }
            } else {
                sb.append(cCharAt);
            }
            length2++;
        }
        return sb.toString();
    }

    public static JSONObject toJSONObject(Reader reader) throws JSONException {
        return toJSONObject(reader, XMLParserConfiguration.ORIGINAL);
    }

    public static String toString(Object obj, String str) {
        return toString(obj, str, XMLParserConfiguration.ORIGINAL);
    }

    public static Object stringToValue(String str) {
        if ("".equals(str)) {
            return str;
        }
        if ("true".equalsIgnoreCase(str)) {
            return Boolean.TRUE;
        }
        if ("false".equalsIgnoreCase(str)) {
            return Boolean.FALSE;
        }
        if ("null".equalsIgnoreCase(str)) {
            return JSONObject.NULL;
        }
        char cCharAt = str.charAt(0);
        if ((cCharAt < '0' || cCharAt > '9') && cCharAt != '-') {
            return str;
        }
        try {
            return stringToNumber(str);
        } catch (Exception unused) {
            return str;
        }
    }

    public static JSONObject toJSONObject(Reader reader, boolean z10) throws JSONException {
        if (z10) {
            return toJSONObject(reader, XMLParserConfiguration.KEEP_STRINGS);
        }
        return toJSONObject(reader, XMLParserConfiguration.ORIGINAL);
    }

    public static String toString(Object obj, String str, XMLParserConfiguration xMLParserConfiguration) throws JSONException {
        return toString(obj, str, xMLParserConfiguration, 0, 0);
    }

    private static String toString(Object obj, String str, XMLParserConfiguration xMLParserConfiguration, int i, int i6) throws JSONException {
        JSONArray jSONArray;
        JSONObject jSONObject;
        char c;
        int i10 = i6;
        StringBuilder sb = new StringBuilder();
        if (obj instanceof JSONObject) {
            char c2 = '<';
            if (str != null) {
                sb.append(indent(i10));
                sb.append('<');
                sb.append(str);
                sb.append('>');
                if (i > 0) {
                    sb.append("\n");
                    i10 += i;
                }
            }
            JSONObject jSONObject2 = (JSONObject) obj;
            for (String str2 : jSONObject2.keySet()) {
                Object objOpt = jSONObject2.opt(str2);
                if (objOpt == null) {
                    objOpt = "";
                } else if (objOpt.getClass().isArray()) {
                    objOpt = new JSONArray(objOpt);
                }
                if (str2.equals(xMLParserConfiguration.getcDataTagName())) {
                    if (objOpt instanceof JSONArray) {
                        JSONArray jSONArray2 = (JSONArray) objOpt;
                        int length = jSONArray2.length();
                        int i11 = 0;
                        while (i11 < length) {
                            if (i11 > 0) {
                                sb.append('\n');
                            }
                            sb.append(escape(jSONArray2.opt(i11).toString()));
                            i11++;
                            c2 = '<';
                        }
                        jSONObject = jSONObject2;
                        c = c2;
                        jSONObject2 = jSONObject;
                        c2 = c;
                    } else {
                        sb.append(escape(objOpt.toString()));
                        jSONObject = jSONObject2;
                    }
                } else if (objOpt instanceof JSONArray) {
                    JSONArray jSONArray3 = (JSONArray) objOpt;
                    int length2 = jSONArray3.length();
                    int i12 = 0;
                    while (i12 < length2) {
                        JSONObject jSONObject3 = jSONObject2;
                        Object objOpt2 = jSONArray3.opt(i12);
                        int i13 = length2;
                        if (objOpt2 instanceof JSONArray) {
                            sb.append('<');
                            sb.append(str2);
                            sb.append('>');
                            sb.append(toString(objOpt2, null, xMLParserConfiguration, i, i10));
                            sb.append("</");
                            sb.append(str2);
                            sb.append('>');
                        } else {
                            sb.append(toString(objOpt2, str2, xMLParserConfiguration, i, i10));
                        }
                        i12++;
                        jSONObject2 = jSONObject3;
                        length2 = i13;
                    }
                    jSONObject = jSONObject2;
                } else {
                    jSONObject = jSONObject2;
                    if ("".equals(objOpt)) {
                        if (xMLParserConfiguration.isCloseEmptyTag()) {
                            sb.append(indent(i10));
                            sb.append('<');
                            sb.append(str2);
                            sb.append("></");
                            sb.append(str2);
                            sb.append(">");
                            if (i > 0) {
                                sb.append("\n");
                            }
                        } else {
                            sb.append(indent(i10));
                            c = '<';
                            sb.append('<');
                            sb.append(str2);
                            sb.append("/>");
                            if (i > 0) {
                                sb.append("\n");
                            }
                        }
                    } else {
                        c = '<';
                        sb.append(toString(objOpt, str2, xMLParserConfiguration, i, i10));
                    }
                    jSONObject2 = jSONObject;
                    c2 = c;
                }
                c = '<';
                jSONObject2 = jSONObject;
                c2 = c;
            }
            if (str != null) {
                sb.append(indent(i10 - i));
                sb.append("</");
                sb.append(str);
                sb.append('>');
                if (i > 0) {
                    sb.append("\n");
                }
            }
            return sb.toString();
        }
        if (obj != null && ((obj instanceof JSONArray) || obj.getClass().isArray())) {
            if (obj.getClass().isArray()) {
                jSONArray = new JSONArray(obj);
            } else {
                jSONArray = (JSONArray) obj;
            }
            int length3 = jSONArray.length();
            for (int i14 = 0; i14 < length3; i14++) {
                sb.append(toString(jSONArray.opt(i14), str == null ? "array" : str, xMLParserConfiguration, i, i10));
            }
            return sb.toString();
        }
        String strEscape = obj == null ? "null" : escape(obj.toString());
        String str3 = i > 0 ? "\n" : "";
        if (str == null) {
            StringBuilder sb2 = new StringBuilder();
            androidx.constraintlayout.core.dsl.a.A(sb2, indent(i10), "\"", strEscape, "\"");
            sb2.append(str3);
            return sb2.toString();
        }
        if (strEscape.length() == 0) {
            StringBuilder sb3 = new StringBuilder();
            androidx.constraintlayout.core.dsl.a.A(sb3, indent(i10), "<", str, "/>");
            sb3.append(str3);
            return sb3.toString();
        }
        StringBuilder sb4 = new StringBuilder();
        androidx.constraintlayout.core.dsl.a.A(sb4, indent(i10), "<", str, ">");
        androidx.constraintlayout.core.dsl.a.A(sb4, strEscape, "</", str, ">");
        sb4.append(str3);
        return sb4.toString();
    }

    public static JSONObject toJSONObject(Reader reader, XMLParserConfiguration xMLParserConfiguration) throws JSONException, IOException {
        JSONObject jSONObject = new JSONObject();
        XMLTokener xMLTokener = new XMLTokener(reader, xMLParserConfiguration);
        while (xMLTokener.more()) {
            xMLTokener.skipPast("<");
            if (xMLTokener.more()) {
                parse(xMLTokener, jSONObject, null, xMLParserConfiguration, 0);
            }
        }
        return jSONObject;
    }

    public static JSONObject toJSONObject(String str, boolean z10) throws JSONException {
        return toJSONObject(new StringReader(str), z10);
    }

    public static JSONObject toJSONObject(String str, XMLParserConfiguration xMLParserConfiguration) throws JSONException {
        return toJSONObject(new StringReader(str), xMLParserConfiguration);
    }

    public static String toString(Object obj, int i) {
        return toString(obj, null, XMLParserConfiguration.ORIGINAL, i);
    }

    public static String toString(Object obj, String str, int i) {
        return toString(obj, str, XMLParserConfiguration.ORIGINAL, i);
    }

    public static String toString(Object obj, String str, XMLParserConfiguration xMLParserConfiguration, int i) throws JSONException {
        return toString(obj, str, xMLParserConfiguration, i, 0);
    }
}
