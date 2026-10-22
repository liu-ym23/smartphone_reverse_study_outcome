package com.obric.appstore.util;

import android.os.Handler;
import android.os.Looper;
import com.google.gson.Gson;

/* JADX INFO: loaded from: classes3.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final k f11081a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Gson f11082b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Handler f11083c = null;

    static {
        f11081a = new k();
        f11082b = new Gson();
        f11083c = new Handler(Looper.getMainLooper());
    }

    public k() {
    }

    public final void a() {
        if (kotlin.jvm.internal.q.b(Looper.myLooper(), Looper.getMainLooper()) == false) goto L6;
        return;
    L6:
        throw new IllegalStateException("Not in applications main thread");
    }

    public final void b(Runnable r10) {
        kotlin.jvm.internal.q.g(r10, "runnable");
        if (kotlin.jvm.internal.q.b(Looper.myLooper(), Looper.getMainLooper()) == false) goto L5;
        r10.run();
        return;
    L5:
        f11083c.post(r10);
    }

    public final Gson c() {
        return f11082b;
    }

    public final Handler d() {
        return f11083c;
    }
}
