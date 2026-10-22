package androidx.core.util;

/* JADX INFO: loaded from: classes.dex */
public abstract class a {
    public static void a(Object r10, StringBuilder r11) {
        if (r10 != null) goto L4;
        r11.append("null");
        return;
    L4:
        String r12 = r10.getClass().getSimpleName();
        if (r12.length() > 0) goto L9;
        r12 = r10.getClass().getName();
        int r13 = r12.lastIndexOf(46);
        if (r13 <= 0) goto L9;
        r12 = r12.substring(r13 + 1);
    L9:
        r11.append(r12);
        r11.append('{');
        r11.append(Integer.toHexString(System.identityHashCode(r10)));
    }
}
