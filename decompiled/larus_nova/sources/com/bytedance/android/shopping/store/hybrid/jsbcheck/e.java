package com.bytedance.android.shopping.store.hybrid.jsbcheck;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class e implements jh.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final et3.c f184874a;

    public final void a() {
        this.f184874a.d();
    }

    @Override // jh.a
    public final void stop() {
        this.f184874a.f();
    }

    public e(Function1 r100) {
        Intrinsics.checkNotNullParameter("ec_store_fps_preview", "sceneName");
        Intrinsics.checkNotNullParameter(r100, "callback");
        et3.c r101 = new et3.c("ec_store_fps_preview", true, null);
        r101.c(new d(r100));
        Unit r102 = Unit.INSTANCE;
        this.f184874a = r101;
    }
}
