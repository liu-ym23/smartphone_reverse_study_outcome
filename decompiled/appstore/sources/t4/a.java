package t4;

import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public abstract class a {
    static {
    }

    public static boolean a(String r10) {
        if (r10 == null) goto L31;
        char[] r11 = r10.toCharArray();
        if (r11.length <= 0) goto L31;
        if (r11.length > 255) goto L31;
        int r12 = r11.length;
        int r13 = 0;
    L10:
        if (r13 >= r12) goto L29;
        char r14 = r11[r13];
        if (r14 < 'A') goto L16;
        if (r14 > 'Z') goto L16;
    L28:
        r13 = r13 + 1;
    L16:
        if (r14 < 'a') goto L20;
        if (r14 <= 'z') goto L28;
    L20:
        if (r14 < '0') goto L24;
        if (r14 <= '9') goto L28;
    L24:
        if (r14 == '.') goto L28;
        if (r14 == '-') goto L28;
        return false;
    L29:
        return true;
    L31:
        return false;
    }

    public static String b(List r10) {
        if (r10 != null) goto L5;
        return null;
    L5:
        StringBuilder r11 = new StringBuilder();
        int r12 = 0;
    L7:
        if (r12 >= r10.size()) goto L13;
        r11.append((String) r10.get(r12));
        if (r12 == (r10.size() - 1)) goto L11;
        r11.append(',');
    L11:
        r12 = r12 + 1;
        goto L7
    L13:
        return r11.toString();
    }
}
