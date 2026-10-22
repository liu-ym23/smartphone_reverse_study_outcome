package com.bytedance.android.live.effect.api;

import com.bytedance.android.livesdkapi.depend.model.Sticker;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class h0 implements o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ILiveEffectComposerManager f66767a;

    @Override // com.bytedance.android.live.effect.api.o
    public final List c() {
        Intrinsics.checkNotNullParameter("livedigitavatar", "panel");
        return this.f66767a.o("livedigitavatar");
    }

    public h0(ILiveEffectComposerManager r100) {
        Intrinsics.checkNotNullParameter(r100, "manager");
        this.f66767a = r100;
    }

    @Override // com.bytedance.android.live.effect.api.o
    public final void d(kh0.a.d r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        this.f66767a.V(new f0(r100));
    }

    @Override // com.bytedance.android.live.effect.api.o
    public final void e(Sticker r100) {
        Intrinsics.checkNotNullParameter("livedigitavatar", "panel");
        Intrinsics.checkNotNullParameter(r100, "sticker");
        Intrinsics.checkNotNullParameter("KtvDigitAvatar_showAvatarPreviewView", "trace");
        this.f66767a.O("livedigitavatar", r100, "KtvDigitAvatar_showAvatarPreviewView");
    }

    @Override // com.bytedance.android.live.effect.api.o
    public final void f(kh0.a.d r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        this.f66767a.g(new g0(r100));
    }

    @Override // com.bytedance.android.live.effect.api.o
    public final void b(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "panel");
        Intrinsics.checkNotNullParameter(r101, "trace");
        this.f66767a.b(r100, r101);
    }

    @Override // com.bytedance.android.live.effect.api.o
    public final void a(String r100, Sticker r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "panel");
        Intrinsics.checkNotNullParameter(r101, "sticker");
        Intrinsics.checkNotNullParameter(r102, "trace");
        this.f66767a.a(r100, r101, r102);
    }
}
