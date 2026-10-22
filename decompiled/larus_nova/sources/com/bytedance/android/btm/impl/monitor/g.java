package com.bytedance.android.btm.impl.monitor;

import kotlin.Deprecated;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes3.dex */
@Deprecated(message = "use ALogger")
public final class g implements com.bytedance.android.btm.api.inner.f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final g f42208a = null;

    public g() {
    }

    static {
        f42208a = new g();
    }

    @Override // com.bytedance.android.btm.api.inner.f
    public final void a(Function0 r100) {
        com.bytedance.android.btm.impl.thread.b.f42488e.a(new f(r100), true);
    }
}
