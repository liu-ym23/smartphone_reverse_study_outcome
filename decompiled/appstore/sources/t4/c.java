package t4;

import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes.dex */
public abstract class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Pattern f24722a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Pattern f24723b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Pattern f24724c = null;

    static {
        f24722a = Pattern.compile("^(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)\\.(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)\\.(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)\\.(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)$");
        f24723b = Pattern.compile("^(?:[0-9a-fA-F]{1,4}:){7}[0-9a-fA-F]{1,4}$");
        f24724c = Pattern.compile("^((?:[0-9A-Fa-f]{1,4}(?::[0-9A-Fa-f]{1,4})*)?)::((?:[0-9A-Fa-f]{1,4}(?::[0-9A-Fa-f]{1,4})*)?)$");
    }

    public static boolean a(String r10) {
        return f24724c.matcher(r10).matches();
    }

    public static boolean b(String r10) {
        return f24723b.matcher(r10).matches();
    }

    public static boolean c(String r10) {
        if (r10 != null) goto L46;
        return false;
    L46:
        if (r10.length() >= 7) goto L8;
        return false;
    L8:
        if (r10.length() <= 15) goto L10;
        return false;
    L10:
        if (r10.equals("") == true) goto L51;
        if (f24722a.matcher(r10).matches() == true) goto L53;
        return false;
    L53:
        return true;
    L51:
        return false;
    L44:
        int r11 = r10.indexOf(46);     // Catch: Exception -> L43
        if (r11 != (-1)) goto L18;
        return false;
    L18:
        if (r10.charAt(0) != '-') goto L20;
        return false;
    L20:
        if (Integer.parseInt(r10.substring(0, r11)) > 255) goto L56;
        int r12 = r11 + 1;     // Catch: Exception -> L43
        int r13 = r10.indexOf(46, r12);     // Catch: Exception -> L43
        if (r13 != (-1)) goto L25;
        return false;
    L25:
        if (r10.charAt(r12) != '-') goto L27;
        return false;
    L27:
        if (Integer.parseInt(r10.substring(r12, r13)) > 255) goto L59;
        int r14 = r13 + 1;     // Catch: Exception -> L43
        int r15 = r10.indexOf(46, r14);     // Catch: Exception -> L43
        if (r15 != (-1)) goto L32;
        return false;
    L32:
        if (r10.charAt(r14) != '-') goto L34;
        return false;
    L34:
        if (Integer.parseInt(r10.substring(r14, r15)) > 255) goto L62;
        int r16 = r15 + 1;     // Catch: Exception -> L43
        if (r10.charAt(r16) != '-') goto L38;
        return false;
    L38:
        if (Integer.parseInt(r10.substring(r16, r10.length())) > 255) goto L64;
        if (r10.charAt(r10.length() - 1) != '.') goto L42;
        return false;
    L42:
        return true;
    L64:
        return false;
    L62:
        return false;
    L59:
        return false;
    L56:
        return false;
    L66:
        return false;
    }

    public static boolean d(String r10) {
        if (b(r10) == false) goto L5;
    L8:
        return true;
    L5:
        if (a(r10) == true) goto L8;
        return false;
    }
}
