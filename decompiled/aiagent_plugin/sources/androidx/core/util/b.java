package androidx.core.util;

/* JADX INFO: compiled from: DebugUtils.java */
/* JADX INFO: loaded from: classes.dex */
public class b {
    public static void a(Object r2, StringBuilder r3) {
        if (r2 != null) goto L4;
        r3.append("null");
        return;
    L4:
        String r0 = r2.getClass().getSimpleName();
        if (r0 != null) goto L7;
    L8:
        r0 = r2.getClass().getName();
        int r1 = r0.lastIndexOf(46);
        if (r1 <= 0) goto L11;
        r0 = r0.substring(r1 + 1);
    L11:
        r3.append(r0);
        r3.append('{');
        r3.append(Integer.toHexString(System.identityHashCode(r2)));
        return;
    L7:
        if (r0.length() > 0) goto L11;
        goto L8
    }
}
