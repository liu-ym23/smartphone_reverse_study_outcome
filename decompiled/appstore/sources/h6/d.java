package h6;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes.dex */
public abstract class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Pattern f20351a = null;

    static {
        f20351a = Pattern.compile("\\Wcharset=([^\\s;]+)", 2);
    }

    public static String a(String r10, String r11) {
        Matcher r12 = f20351a.matcher(r10);
        if (r12.find() == true) goto L5;
        return r11;
    L5:
        return r12.group(1).replaceAll("[\"\\\\]", "");
    }
}
