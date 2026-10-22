package net.sourceforge.jeval;

/* loaded from: classes2.dex */
public class EvaluationHelper {
    public static boolean isSpace(char c4) {
        return c4 == ' ' || c4 == '\t' || c4 == '\n' || c4 == '\r' || c4 == '\f';
    }

    public static String replaceAll(String str, String str2, String str3) {
        if (str != null) {
            int iIndexOf = str.indexOf(str2, 0);
            while (iIndexOf > -1) {
                StringBuffer stringBuffer = new StringBuffer(str.substring(0, iIndexOf) + str.substring(str2.length() + iIndexOf));
                stringBuffer.insert(iIndexOf, str3);
                str = stringBuffer.toString();
                int length = str3.length() + iIndexOf;
                iIndexOf = length < str.length() ? str.indexOf(str2, length) : -1;
            }
        }
        return str;
    }
}
