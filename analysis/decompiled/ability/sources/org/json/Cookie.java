package org.json;

import androidx.autofill.HintConstants;
import java.io.IOException;
import java.util.Locale;

/* loaded from: classes4.dex */
public class Cookie {
    public static String escape(String str) {
        String strTrim = str.trim();
        int length = strTrim.length();
        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            char cCharAt = strTrim.charAt(i);
            if (cCharAt < ' ' || cCharAt == '+' || cCharAt == '%' || cCharAt == '=' || cCharAt == ';') {
                sb.append('%');
                sb.append(Character.forDigit((char) ((cCharAt >>> 4) & 15), 16));
                sb.append(Character.forDigit((char) (cCharAt & 15), 16));
            } else {
                sb.append(cCharAt);
            }
        }
        return sb.toString();
    }

    public static JSONObject toJSONObject(String str) throws JSONException, IOException {
        Object objTrim;
        JSONObject jSONObject = new JSONObject();
        JSONTokener jSONTokener = new JSONTokener(str);
        String strUnescape = unescape(jSONTokener.nextTo('=').trim());
        if ("".equals(strUnescape)) {
            throw new JSONException("Cookies must have a 'name'");
        }
        jSONObject.put(HintConstants.AUTOFILL_HINT_NAME, strUnescape);
        jSONTokener.next('=');
        jSONObject.put("value", unescape(jSONTokener.nextTo(';')).trim());
        jSONTokener.next();
        while (jSONTokener.more()) {
            String lowerCase = unescape(jSONTokener.nextTo("=;")).trim().toLowerCase(Locale.ROOT);
            if (HintConstants.AUTOFILL_HINT_NAME.equalsIgnoreCase(lowerCase)) {
                throw new JSONException("Illegal attribute name: 'name'");
            }
            if ("value".equalsIgnoreCase(lowerCase)) {
                throw new JSONException("Illegal attribute name: 'value'");
            }
            if (jSONTokener.next() != '=') {
                objTrim = Boolean.TRUE;
            } else {
                objTrim = unescape(jSONTokener.nextTo(';')).trim();
                jSONTokener.next();
            }
            if (!"".equals(lowerCase) && !"".equals(objTrim)) {
                jSONObject.put(lowerCase, objTrim);
            }
        }
        return jSONObject;
    }

    public static String toString(JSONObject jSONObject) throws JSONException {
        StringBuilder sb = new StringBuilder();
        String strTrim = null;
        String strTrim2 = null;
        for (String str : jSONObject.keySet()) {
            if (HintConstants.AUTOFILL_HINT_NAME.equalsIgnoreCase(str)) {
                strTrim = jSONObject.getString(str).trim();
            }
            if ("value".equalsIgnoreCase(str)) {
                strTrim2 = jSONObject.getString(str).trim();
            }
            if (strTrim != null && strTrim2 != null) {
                break;
            }
        }
        if (strTrim == null || "".equals(strTrim.trim())) {
            throw new JSONException("Cookie does not have a name");
        }
        if (strTrim2 == null) {
            strTrim2 = "";
        }
        sb.append(escape(strTrim));
        sb.append("=");
        sb.append(escape(strTrim2));
        for (String str2 : jSONObject.keySet()) {
            if (!HintConstants.AUTOFILL_HINT_NAME.equalsIgnoreCase(str2) && !"value".equalsIgnoreCase(str2)) {
                Object objOpt = jSONObject.opt(str2);
                if (!(objOpt instanceof Boolean)) {
                    sb.append(';');
                    sb.append(escape(str2));
                    sb.append('=');
                    sb.append(escape(objOpt.toString()));
                } else if (Boolean.TRUE.equals(objOpt)) {
                    sb.append(';');
                    sb.append(escape(str2));
                }
            }
        }
        return sb.toString();
    }

    public static String unescape(String str) {
        int i;
        int length = str.length();
        StringBuilder sb = new StringBuilder(length);
        int i6 = 0;
        while (i6 < length) {
            char cCharAt = str.charAt(i6);
            if (cCharAt == '+') {
                cCharAt = ' ';
            } else if (cCharAt == '%' && (i = i6 + 2) < length) {
                int iDehexchar = JSONTokener.dehexchar(str.charAt(i6 + 1));
                int iDehexchar2 = JSONTokener.dehexchar(str.charAt(i));
                if (iDehexchar >= 0 && iDehexchar2 >= 0) {
                    cCharAt = (char) ((iDehexchar * 16) + iDehexchar2);
                    i6 = i;
                }
            }
            sb.append(cCharAt);
            i6++;
        }
        return sb.toString();
    }
}
