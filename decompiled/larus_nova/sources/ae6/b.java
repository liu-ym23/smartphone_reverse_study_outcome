package ae6;

import java.util.Comparator;

/* JADX INFO: loaded from: classes28.dex */
public final class b<T> implements Comparator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b<T> f3107a = null;

    static {
        f3107a = new b();
    }

    public b() {
    }

    @Override // java.util.Comparator
    public final int compare(Object r100, Object r101) {
        String r102 = (String) r100;
        String r103 = (String) r101;
        if (r102.length() != r103.length()) goto L6;
        return 0;
    L6:
        if (r102.length() <= r103.length()) goto L8;
        return -1;
    L8:
        return 1;
    }
}
