package ch.qos.logback.core.helpers;

/* loaded from: classes.dex */
public class Transform {
    private static final String CDATA_EMBEDED_END = "]]>]]&gt;<![CDATA[";
    private static final String CDATA_END = "]]>";
    private static final int CDATA_END_LEN = 3;
    private static final String CDATA_PSEUDO_END = "]]&gt;";
    private static final String CDATA_START = "<![CDATA[";

    public static void appendEscapingCDATA(StringBuilder sb, String str) {
        if (str == null) {
            return;
        }
        int iIndexOf = str.indexOf(CDATA_END);
        if (iIndexOf < 0) {
            sb.append(str);
            return;
        }
        int i4 = 0;
        while (iIndexOf > -1) {
            sb.append(str.substring(i4, iIndexOf));
            sb.append(CDATA_EMBEDED_END);
            i4 = CDATA_END_LEN + iIndexOf;
            if (i4 >= str.length()) {
                return;
            } else {
                iIndexOf = str.indexOf(CDATA_END, i4);
            }
        }
        sb.append(str.substring(i4));
    }

    public static String escapeTags(String str) {
        return (str == null || str.length() == 0) ? str : (str.indexOf("<") == -1 && str.indexOf(">") == -1) ? str : escapeTags(new StringBuffer(str));
    }

    public static String escapeTags(StringBuffer stringBuffer) {
        for (int i4 = 0; i4 < stringBuffer.length(); i4++) {
            char cCharAt = stringBuffer.charAt(i4);
            if (cCharAt == '<') {
                stringBuffer.replace(i4, i4 + 1, "&lt;");
            } else if (cCharAt == '>') {
                stringBuffer.replace(i4, i4 + 1, "&gt;");
            }
        }
        return stringBuffer.toString();
    }
}
