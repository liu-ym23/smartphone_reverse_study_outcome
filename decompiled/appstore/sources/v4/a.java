package v4;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes.dex */
public abstract class a {
    public static String a(String r10, String r11) {
        Matcher r12 = Pattern.compile(".*(((" + r11 + "=[^;]*)|(" + r11 + "=\"[\";]*))|(" + r11 + "=.*$)).*").matcher(r10);
        if (r12.matches() == true) goto L7;
        return null;
    L7:
        return r12.group(1);
    }
}
