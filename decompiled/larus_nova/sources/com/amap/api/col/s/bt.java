package com.amap.api.col.s;

import android.content.Context;

/* JADX INFO: loaded from: classes28.dex */
public class bt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static bt f26334a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Context f26335b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f26336c;

    private bt(Context r100) {
        this.f26335b = r100.getApplicationContext();
        this.f26336c = ca.a(bs.c("RYW1hcF9kZXZpY2VfYWRpdQ"));
    }

    public static bt a(Context r100) {
        if (f26334a != null) goto L15;
        monitor-enter(bt.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f26334a != null) goto L9;
        f26334a = new bt(r100);     // Catch: Throwable -> L11
    L9:
        monitor-exit(bt.class);     // Catch: Throwable -> L11
    L15:
        return f26334a;
    }

    public final void a(String r100) {
        bu.a(this.f26335b).a(this.f26336c);
        bu.a(this.f26335b).b(r100);
    }
}
