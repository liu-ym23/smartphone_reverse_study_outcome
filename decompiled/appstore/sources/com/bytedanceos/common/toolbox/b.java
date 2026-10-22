package com.bytedanceos.common.toolbox;

import android.content.Context;

/* JADX INFO: loaded from: classes2.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f9994a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile Context f9995b;

    static {
        f9994a = new b();
    }

    public b() {
    }

    public final Context a() {
        Context r10 = f9995b;
        if (r10 != null) goto L6;
        kotlin.jvm.internal.q.y("application");
        return null;
    L6:
        return r10;
    }

    public final void b(Context r10) {
        kotlin.jvm.internal.q.g(r10, "application");
        f9995b = r10;
    }
}
