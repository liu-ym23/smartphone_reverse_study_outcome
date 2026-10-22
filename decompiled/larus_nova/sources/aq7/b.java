package aq7;

import android.content.Context;

/* JADX INFO: loaded from: classes3.dex */
public final class b {
    public static bq7.a a(Context r100) {
        if (r100 != null) goto L6;
        return null;
    L6:
        if (bq7.a.f20039g != null) goto L18;
        monitor-enter(bq7.a.class);
    L14:
        th = move-exception;
        throw th;
    L10:
        if (bq7.a.f20039g != null) goto L12;
        bq7.a.f20039g = new bq7.a(r100, a.f15910d);     // Catch: Throwable -> L14
    L12:
        monitor-exit(bq7.a.class);     // Catch: Throwable -> L14
    L18:
        return bq7.a.f20039g;
    }
}
