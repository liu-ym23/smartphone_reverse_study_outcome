package org.bouncycastle.asn1.x500.style;

import java.io.IOException;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Vector;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import m0.f;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1Encoding;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1String;
import org.bouncycastle.asn1.ASN1UniversalString;
import org.bouncycastle.asn1.x500.AttributeTypeAndValue;
import org.bouncycastle.asn1.x500.RDN;
import org.bouncycastle.asn1.x500.X500NameBuilder;
import org.bouncycastle.asn1.x500.X500NameStyle;
import org.bouncycastle.util.Strings;
import org.bouncycastle.util.encoders.Hex;

/* loaded from: classes.dex */
public class IETFUtils {
    private static void addMultiValuedRDN(X500NameStyle x500NameStyle, X500NameBuilder x500NameBuilder, X500NameTokenizer x500NameTokenizer) {
        String strNextToken = x500NameTokenizer.nextToken();
        if (strNextToken == null) {
            throw new IllegalArgumentException("badly formatted directory string");
        }
        if (!x500NameTokenizer.hasMoreTokens()) {
            addRDN(x500NameStyle, x500NameBuilder, strNextToken);
            return;
        }
        Vector vector = new Vector();
        Vector vector2 = new Vector();
        do {
            collectAttributeTypeAndValue(x500NameStyle, vector, vector2, strNextToken);
            strNextToken = x500NameTokenizer.nextToken();
        } while (strNextToken != null);
        x500NameBuilder.addMultiValuedRDN(toOIDArray(vector), toValueArray(vector2));
    }

    private static void addRDN(X500NameStyle x500NameStyle, X500NameBuilder x500NameBuilder, String str) {
        X500NameTokenizer x500NameTokenizer = new X500NameTokenizer(str, '=');
        x500NameBuilder.addRDN(x500NameStyle.attrNameToOID(nextToken(x500NameTokenizer, true).trim()), unescape(nextToken(x500NameTokenizer, false)));
    }

    private static void addRDNs(X500NameStyle x500NameStyle, X500NameBuilder x500NameBuilder, X500NameTokenizer x500NameTokenizer) {
        while (true) {
            String strNextToken = x500NameTokenizer.nextToken();
            if (strNextToken == null) {
                return;
            }
            if (strNextToken.indexOf(43) >= 0) {
                addMultiValuedRDN(x500NameStyle, x500NameBuilder, new X500NameTokenizer(strNextToken, '+'));
            } else {
                addRDN(x500NameStyle, x500NameBuilder, strNextToken);
            }
        }
    }

    public static void appendRDN(StringBuffer stringBuffer, RDN rdn, Hashtable hashtable) {
        if (!rdn.isMultiValued()) {
            if (rdn.getFirst() != null) {
                appendTypeAndValue(stringBuffer, rdn.getFirst(), hashtable);
                return;
            }
            return;
        }
        AttributeTypeAndValue[] typesAndValues = rdn.getTypesAndValues();
        boolean z = true;
        for (int i8 = 0; i8 != typesAndValues.length; i8++) {
            if (z) {
                z = false;
            } else {
                stringBuffer.append('+');
            }
            appendTypeAndValue(stringBuffer, typesAndValues[i8], hashtable);
        }
    }

    public static void appendTypeAndValue(StringBuffer stringBuffer, AttributeTypeAndValue attributeTypeAndValue, Hashtable hashtable) {
        String id = (String) hashtable.get(attributeTypeAndValue.getType());
        if (id == null) {
            id = attributeTypeAndValue.getType().getId();
        }
        stringBuffer.append(id);
        stringBuffer.append('=');
        stringBuffer.append(valueToString(attributeTypeAndValue.getValue()));
    }

    private static boolean atvAreEqual(AttributeTypeAndValue attributeTypeAndValue, AttributeTypeAndValue attributeTypeAndValue2) {
        if (attributeTypeAndValue == attributeTypeAndValue2) {
            return true;
        }
        return attributeTypeAndValue != null && attributeTypeAndValue2 != null && attributeTypeAndValue.getType().equals((ASN1Primitive) attributeTypeAndValue2.getType()) && canonicalString(attributeTypeAndValue.getValue()).equals(canonicalString(attributeTypeAndValue2.getValue()));
    }

    public static String canonicalString(ASN1Encodable aSN1Encodable) {
        return canonicalize(valueToString(aSN1Encodable));
    }

    public static String canonicalize(String str) {
        int i8 = 0;
        if (str.length() > 0 && str.charAt(0) == '#') {
            ASN1Encodable aSN1EncodableDecodeObject = decodeObject(str);
            if (aSN1EncodableDecodeObject instanceof ASN1String) {
                str = ((ASN1String) aSN1EncodableDecodeObject).getString();
            }
        }
        String lowerCase = Strings.toLowerCase(str);
        int length = lowerCase.length();
        if (length < 2) {
            return lowerCase;
        }
        int i9 = length - 1;
        while (i8 < i9 && lowerCase.charAt(i8) == '\\' && lowerCase.charAt(i8 + 1) == ' ') {
            i8 += 2;
        }
        int i10 = i8 + 1;
        int i11 = i9;
        while (i11 > i10 && lowerCase.charAt(i11 - 1) == '\\' && lowerCase.charAt(i11) == ' ') {
            i11 -= 2;
        }
        if (i8 > 0 || i11 < i9) {
            lowerCase = lowerCase.substring(i8, i11 + 1);
        }
        return stripInternalSpaces(lowerCase);
    }

    private static void collectAttributeTypeAndValue(X500NameStyle x500NameStyle, Vector vector, Vector vector2, String str) {
        X500NameTokenizer x500NameTokenizer = new X500NameTokenizer(str, '=');
        String strNextToken = nextToken(x500NameTokenizer, true);
        String strNextToken2 = nextToken(x500NameTokenizer, false);
        ASN1ObjectIdentifier aSN1ObjectIdentifierAttrNameToOID = x500NameStyle.attrNameToOID(strNextToken.trim());
        String strUnescape = unescape(strNextToken2);
        vector.addElement(aSN1ObjectIdentifierAttrNameToOID);
        vector2.addElement(strUnescape);
    }

    private static int convertHex(char c3) {
        return ('0' > c3 || c3 > '9') ? ('a' > c3 || c3 > 'f') ? c3 - '7' : c3 - 'W' : c3 - '0';
    }

    public static ASN1ObjectIdentifier decodeAttrName(String str, Hashtable hashtable) throws NumberFormatException {
        if (str.regionMatches(true, 0, "OID.", 0, 4)) {
            return new ASN1ObjectIdentifier(str.substring(4));
        }
        ASN1ObjectIdentifier aSN1ObjectIdentifierTryFromID = ASN1ObjectIdentifier.tryFromID(str);
        if (aSN1ObjectIdentifierTryFromID != null) {
            return aSN1ObjectIdentifierTryFromID;
        }
        ASN1ObjectIdentifier aSN1ObjectIdentifier = (ASN1ObjectIdentifier) hashtable.get(Strings.toLowerCase(str));
        if (aSN1ObjectIdentifier != null) {
            return aSN1ObjectIdentifier;
        }
        throw new IllegalArgumentException(f.d("Unknown object id - ", str, " - passed to distinguished name"));
    }

    private static ASN1Primitive decodeObject(String str) {
        try {
            return ASN1Primitive.fromByteArray(Hex.decodeStrict(str, 1, str.length() - 1));
        } catch (IOException e9) {
            throw new IllegalStateException("unknown encoding in name: " + e9);
        }
    }

    public static String[] findAttrNamesForOID(ASN1ObjectIdentifier aSN1ObjectIdentifier, Hashtable hashtable) {
        Enumeration enumerationElements = hashtable.elements();
        int i8 = 0;
        int i9 = 0;
        while (enumerationElements.hasMoreElements()) {
            if (aSN1ObjectIdentifier.equals(enumerationElements.nextElement())) {
                i9++;
            }
        }
        String[] strArr = new String[i9];
        Enumeration enumerationKeys = hashtable.keys();
        while (enumerationKeys.hasMoreElements()) {
            String str = (String) enumerationKeys.nextElement();
            if (aSN1ObjectIdentifier.equals(hashtable.get(str))) {
                strArr[i8] = str;
                i8++;
            }
        }
        return strArr;
    }

    private static boolean isHexDigit(char c3) {
        if ('0' <= c3 && c3 <= '9') {
            return true;
        }
        if ('a' > c3 || c3 > 'f') {
            return 'A' <= c3 && c3 <= 'F';
        }
        return true;
    }

    private static String nextToken(X500NameTokenizer x500NameTokenizer, boolean z) {
        String strNextToken = x500NameTokenizer.nextToken();
        if (strNextToken == null || x500NameTokenizer.hasMoreTokens() != z) {
            throw new IllegalArgumentException("badly formatted directory string");
        }
        return strNextToken;
    }

    public static boolean rDNAreEqual(RDN rdn, RDN rdn2) {
        if (rdn.size() != rdn2.size()) {
            return false;
        }
        AttributeTypeAndValue[] typesAndValues = rdn.getTypesAndValues();
        AttributeTypeAndValue[] typesAndValues2 = rdn2.getTypesAndValues();
        if (typesAndValues.length != typesAndValues2.length) {
            return false;
        }
        for (int i8 = 0; i8 != typesAndValues.length; i8++) {
            if (!atvAreEqual(typesAndValues[i8], typesAndValues2[i8])) {
                return false;
            }
        }
        return true;
    }

    public static RDN[] rDNsFromString(String str, X500NameStyle x500NameStyle) {
        X500NameTokenizer x500NameTokenizer = new X500NameTokenizer(str);
        X500NameBuilder x500NameBuilder = new X500NameBuilder(x500NameStyle);
        addRDNs(x500NameStyle, x500NameBuilder, x500NameTokenizer);
        return x500NameBuilder.build().getRDNs();
    }

    public static String stripInternalSpaces(String str) {
        if (str.indexOf("  ") < 0) {
            return str;
        }
        StringBuilder sb = new StringBuilder();
        char cCharAt = str.charAt(0);
        sb.append(cCharAt);
        for (int i8 = 1; i8 < str.length(); i8++) {
            char cCharAt2 = str.charAt(i8);
            if (cCharAt != ' ' || cCharAt2 != ' ') {
                sb.append(cCharAt2);
                cCharAt = cCharAt2;
            }
        }
        return sb.toString();
    }

    private static ASN1ObjectIdentifier[] toOIDArray(Vector vector) {
        int size = vector.size();
        ASN1ObjectIdentifier[] aSN1ObjectIdentifierArr = new ASN1ObjectIdentifier[size];
        for (int i8 = 0; i8 != size; i8++) {
            aSN1ObjectIdentifierArr[i8] = (ASN1ObjectIdentifier) vector.elementAt(i8);
        }
        return aSN1ObjectIdentifierArr;
    }

    private static String[] toValueArray(Vector vector) {
        int size = vector.size();
        String[] strArr = new String[size];
        for (int i8 = 0; i8 != size; i8++) {
            strArr[i8] = (String) vector.elementAt(i8);
        }
        return strArr;
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0058  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static java.lang.String unescape(java.lang.String r13) {
        /*
            int r0 = r13.length()
            if (r0 != 0) goto L7
            return r13
        L7:
            r0 = 92
            int r1 = r13.indexOf(r0)
            r2 = 34
            if (r1 >= 0) goto L1c
            int r1 = r13.indexOf(r2)
            if (r1 >= 0) goto L1c
            java.lang.String r13 = r13.trim()
            return r13
        L1c:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            int r3 = r13.length()
            r1.<init>(r3)
            r3 = 0
            char r4 = r13.charAt(r3)
            r5 = 1
            if (r4 != r0) goto L3c
            char r4 = r13.charAt(r5)
            r6 = 35
            if (r4 != r6) goto L3c
            java.lang.String r4 = "\\#"
            r1.append(r4)
            r4 = 2
            goto L3d
        L3c:
            r4 = r3
        L3d:
            r6 = r3
            r7 = r6
            r8 = r7
            r9 = r8
            r10 = r9
        L42:
            int r11 = r13.length()
            r12 = 32
            if (r4 == r11) goto L90
            char r11 = r13.charAt(r4)
            if (r11 == r12) goto L51
            r9 = r5
        L51:
            if (r11 != r2) goto L5d
            if (r6 != 0) goto L58
            r8 = r8 ^ 1
            goto L8d
        L58:
            r1.append(r11)
            r6 = r3
            goto L8d
        L5d:
            if (r11 != r0) goto L69
            if (r6 != 0) goto L69
            if (r8 != 0) goto L69
            int r7 = r1.length()
            r6 = r5
            goto L8d
        L69:
            if (r11 != r12) goto L70
            if (r6 != 0) goto L70
            if (r9 != 0) goto L70
            goto L8d
        L70:
            if (r6 == 0) goto L58
            boolean r12 = isHexDigit(r11)
            if (r12 == 0) goto L58
            if (r10 == 0) goto L8c
            int r6 = convertHex(r10)
            int r6 = r6 * 16
            int r10 = convertHex(r11)
            int r6 = r6 + r10
            char r6 = (char) r6
            r1.append(r6)
            r6 = r3
            r10 = r6
            goto L8d
        L8c:
            r10 = r11
        L8d:
            int r4 = r4 + 1
            goto L42
        L90:
            int r13 = r1.length()
            if (r13 <= 0) goto Lb1
        L96:
            int r13 = r1.length()
            int r13 = r13 - r5
            char r13 = r1.charAt(r13)
            if (r13 != r12) goto Lb1
            int r13 = r1.length()
            int r13 = r13 - r5
            if (r7 == r13) goto Lb1
            int r13 = r1.length()
            int r13 = r13 - r5
            r1.setLength(r13)
            goto L96
        Lb1:
            java.lang.String r13 = r1.toString()
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: org.bouncycastle.asn1.x500.style.IETFUtils.unescape(java.lang.String):java.lang.String");
    }

    public static ASN1Encodable valueFromHexString(String str, int i8) {
        int length = (str.length() - i8) / 2;
        byte[] bArr = new byte[length];
        for (int i9 = 0; i9 != length; i9++) {
            int i10 = (i9 * 2) + i8;
            char cCharAt = str.charAt(i10);
            char cCharAt2 = str.charAt(i10 + 1);
            bArr[i9] = (byte) (convertHex(cCharAt2) | (convertHex(cCharAt) << 4));
        }
        return ASN1Primitive.fromByteArray(bArr);
    }

    public static String valueToString(ASN1Encodable aSN1Encodable) {
        StringBuilder sb = new StringBuilder();
        int i8 = 0;
        if (!(aSN1Encodable instanceof ASN1String) || (aSN1Encodable instanceof ASN1UniversalString)) {
            try {
                sb.append('#');
                sb.append(Hex.toHexString(aSN1Encodable.toASN1Primitive().getEncoded(ASN1Encoding.DER)));
            } catch (IOException unused) {
                throw new IllegalArgumentException("Other value has no encoded form");
            }
        } else {
            String string = ((ASN1String) aSN1Encodable).getString();
            if (string.length() > 0 && string.charAt(0) == '#') {
                sb.append(AbstractJsonLexerKt.STRING_ESC);
            }
            sb.append(string);
        }
        int length = sb.length();
        int i9 = (sb.length() >= 2 && sb.charAt(0) == '\\' && sb.charAt(1) == '#') ? 2 : 0;
        while (i9 != length) {
            char cCharAt = sb.charAt(i9);
            if (cCharAt != '\"' && cCharAt != '\\' && cCharAt != '+' && cCharAt != ',') {
                switch (cCharAt) {
                    case ';':
                    case '<':
                    case '=':
                    case '>':
                        break;
                    default:
                        i9++;
                }
            }
            sb.insert(i9, "\\");
            i9 += 2;
            length++;
        }
        if (sb.length() > 0) {
            while (sb.length() > i8 && sb.charAt(i8) == ' ') {
                sb.insert(i8, "\\");
                i8 += 2;
            }
        }
        for (int length2 = sb.length() - 1; length2 >= i8 && sb.charAt(length2) == ' '; length2--) {
            sb.insert(length2, AbstractJsonLexerKt.STRING_ESC);
        }
        return sb.toString();
    }

    public static void appendRDN(StringBuilder sb, RDN rdn, Hashtable hashtable) {
        if (!rdn.isMultiValued()) {
            if (rdn.getFirst() != null) {
                appendTypeAndValue(sb, rdn.getFirst(), hashtable);
                return;
            }
            return;
        }
        AttributeTypeAndValue[] typesAndValues = rdn.getTypesAndValues();
        boolean z = true;
        for (int i8 = 0; i8 != typesAndValues.length; i8++) {
            if (z) {
                z = false;
            } else {
                sb.append('+');
            }
            appendTypeAndValue(sb, typesAndValues[i8], hashtable);
        }
    }

    public static void appendTypeAndValue(StringBuilder sb, AttributeTypeAndValue attributeTypeAndValue, Hashtable hashtable) {
        String id = (String) hashtable.get(attributeTypeAndValue.getType());
        if (id == null) {
            id = attributeTypeAndValue.getType().getId();
        }
        sb.append(id);
        sb.append('=');
        sb.append(valueToString(attributeTypeAndValue.getValue()));
    }
}
