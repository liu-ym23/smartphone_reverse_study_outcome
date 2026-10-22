package com.bytedanceos.common;

import android.app.Activity;
import android.content.Context;
import kotlin.jvm.internal.q;

/* JADX INFO: loaded from: classes2.dex */
public final class e implements ObricAbsInterceptor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final e f9820a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static ObricAbsInterceptor f9821b;

    static {
        f9820a = new e();
    }

    public e() {
    }

    public final synchronized void a(ObricAbsInterceptor r10) {
        monitor-enter(this);
        q.g(r10, "instance");     // Catch: Throwable -> L6
        f9821b = r10;     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // com.bytedanceos.common.ObricAbsInterceptor
    public Class getAppDetailActivityClass() {
        ObricAbsInterceptor r10 = f9821b;
        if (r10 != null) goto L6;
        q.y("interceptor");
        r10 = null;
    L6:
        return r10.getAppDetailActivityClass();
    }

    @Override // com.bytedanceos.common.ObricAbsInterceptor
    public void onInitCacheFinish() {
        ObricAbsInterceptor r10 = f9821b;
        if (r10 != null) goto L5;
        q.y("interceptor");
        r10 = null;
    L5:
        r10.onInitCacheFinish();
    }

    @Override // com.bytedanceos.common.ObricAbsInterceptor
    public void onInitCacheStart() {
        ObricAbsInterceptor r10 = f9821b;
        if (r10 != null) goto L5;
        q.y("interceptor");
        r10 = null;
    L5:
        r10.onInitCacheStart();
    }

    @Override // com.bytedanceos.common.ObricAbsInterceptor
    public void openAppManager(Context r10, int r11) {
        q.g(r10, "context");
        ObricAbsInterceptor r12 = f9821b;
        if (r12 != null) goto L5;
        q.y("interceptor");
        r12 = null;
    L5:
        r12.openAppManager(r10, r11);
    }

    @Override // com.bytedanceos.common.ObricAbsInterceptor
    public void openDebug(Activity r10) {
        ObricAbsInterceptor r11 = f9821b;
        if (r11 != null) goto L5;
        q.y("interceptor");
        r11 = null;
    L5:
        r11.openDebug(r10);
    }
}
