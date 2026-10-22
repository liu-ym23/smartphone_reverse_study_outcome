package com.bytedance.android.live.broadcastgame.api.xplay.basic;

import com.bytedance.android.live.liveinteract.hamlet.h0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class b implements a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final b f59443b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a f59444a;

    @Override // com.bytedance.android.live.broadcastgame.api.xplay.basic.a
    public final void a(h0 r100) {
        Intrinsics.checkNotNullParameter(r100, "extension");
        this.f59444a.a(r100);
    }

    @Override // com.bytedance.android.live.broadcastgame.api.xplay.basic.a
    public final void b(boolean r100) {
        this.f59444a.b(r100);
    }

    @Override // com.bytedance.android.live.broadcastgame.api.xplay.basic.a
    public final void c() {
        this.f59444a.c();
    }

    @Override // com.bytedance.android.live.broadcastgame.api.xplay.basic.a
    public final void d(c r100, boolean r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r100, "newEnv");
        this.f59444a.d(r100, r101, r102);
    }

    @Override // com.bytedance.android.live.broadcastgame.api.xplay.basic.a
    public final void e(String r100) {
        Intrinsics.checkNotNullParameter(r100, "stopReason");
        this.f59444a.e(r100);
    }

    @Override // com.bytedance.android.live.broadcastgame.api.xplay.basic.a
    public final void f(h0 r100) {
        Intrinsics.checkNotNullParameter(r100, "extension");
        this.f59444a.f(r100);
    }

    static {
        f59443b = new b();
    }

    public b() {
        this.f59444a = (a) LiveXPlayBasicGlobalServiceKt.f59442a.getValue();
    }
}
