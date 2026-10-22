package org.json;

import androidx.appfunctions.metadata.a;
import com.fasterxml.jackson.core.JsonPointer;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes4.dex */
public class JSONPointer {
    private static final String ENCODING = "utf-8";
    private final List<String> refTokens;

    public JSONPointer(String str) throws UnsupportedEncodingException {
        String strSubstring;
        if (str == null) {
            throw new NullPointerException("pointer cannot be null");
        }
        if (str.isEmpty() || str.equals("#")) {
            this.refTokens = Collections.EMPTY_LIST;
            return;
        }
        if (str.startsWith("#/")) {
            try {
                strSubstring = URLDecoder.decode(str.substring(2), ENCODING);
            } catch (UnsupportedEncodingException e) {
                throw new RuntimeException(e);
            }
        } else {
            if (!str.startsWith("/")) {
                throw new IllegalArgumentException("a JSON pointer should start with '/' or '#/'");
            }
            strSubstring = str.substring(1);
        }
        this.refTokens = new ArrayList();
        int i = -1;
        while (true) {
            int i6 = i + 1;
            int iIndexOf = strSubstring.indexOf(47, i6);
            if (i6 == iIndexOf || i6 == strSubstring.length()) {
                this.refTokens.add("");
            } else if (iIndexOf >= 0) {
                this.refTokens.add(unescape(strSubstring.substring(i6, iIndexOf)));
            } else {
                this.refTokens.add(unescape(strSubstring.substring(i6)));
            }
            if (iIndexOf < 0) {
                return;
            } else {
                i = iIndexOf;
            }
        }
    }

    public static Builder builder() {
        return new Builder();
    }

    private static String escape(String str) {
        return str.replace("~", JsonPointer.ESC_TILDE).replace("/", JsonPointer.ESC_SLASH);
    }

    private static Object readByIndexToken(Object obj, String str) throws JSONPointerException, NumberFormatException {
        try {
            int i = Integer.parseInt(str);
            JSONArray jSONArray = (JSONArray) obj;
            if (i >= jSONArray.length()) {
                throw new JSONPointerException(String.format("index %s is out of bounds - the array has %d elements", str, Integer.valueOf(jSONArray.length())));
            }
            try {
                return jSONArray.get(i);
            } catch (JSONException e) {
                throw new JSONPointerException("Error reading value at index position " + i, e);
            }
        } catch (NumberFormatException e6) {
            throw new JSONPointerException(a.l(str, " is not an array index"), e6);
        }
    }

    private static String unescape(String str) {
        return str.replace(JsonPointer.ESC_SLASH, "/").replace(JsonPointer.ESC_TILDE, "~");
    }

    public Object queryFrom(Object obj) throws JSONPointerException, NumberFormatException {
        if (this.refTokens.isEmpty()) {
            return obj;
        }
        for (String str : this.refTokens) {
            if (obj instanceof JSONObject) {
                obj = ((JSONObject) obj).opt(unescape(str));
            } else {
                if (!(obj instanceof JSONArray)) {
                    throw new JSONPointerException(String.format("value [%s] is not an array or object therefore its key %s cannot be resolved", obj, str));
                }
                obj = readByIndexToken(obj, str);
            }
        }
        return obj;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("");
        for (String str : this.refTokens) {
            sb.append(JsonPointer.SEPARATOR);
            sb.append(escape(str));
        }
        return sb.toString();
    }

    public String toURIFragment() {
        try {
            StringBuilder sb = new StringBuilder("#");
            for (String str : this.refTokens) {
                sb.append(JsonPointer.SEPARATOR);
                sb.append(URLEncoder.encode(str, ENCODING));
            }
            return sb.toString();
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }

    public static class Builder {
        private final List<String> refTokens = new ArrayList();

        public Builder append(String str) {
            if (str == null) {
                throw new NullPointerException("token cannot be null");
            }
            this.refTokens.add(str);
            return this;
        }

        public JSONPointer build() {
            return new JSONPointer(this.refTokens);
        }

        public Builder append(int i) {
            this.refTokens.add(String.valueOf(i));
            return this;
        }
    }

    public JSONPointer(List<String> list) {
        this.refTokens = new ArrayList(list);
    }
}
