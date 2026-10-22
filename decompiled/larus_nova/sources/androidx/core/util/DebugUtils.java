package androidx.core.util;

/* JADX INFO: loaded from: classes17.dex */
public class DebugUtils {
    private DebugUtils() {
    }

    public static void buildShortClassTag(Object r100, StringBuilder r101) {
        if (r100 != null) goto L4;
        r101.append("null");
        return;
    L4:
        String r102 = r100.getClass().getSimpleName();
        if (r102.length() > 0) goto L9;
        r102 = r100.getClass().getName();
        int r103 = r102.lastIndexOf(46);
        if (r103 <= 0) goto L9;
        r102 = r102.substring(r103 + 1);
    L9:
        r101.append(r102);
        r101.append('{');
        r101.append(Integer.toHexString(System.identityHashCode(r100)));
    }
}
