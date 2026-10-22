package com.bytedance.android.live.effect.api;

import com.bytedance.android.live.effect.utils.LiveEffectBaseProxy;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0017\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u000b\u001a\u00020\nH\u0016¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/live/effect/api/MiddlewareEffectServiceDelegate;", "Lcom/bytedance/android/live/effect/api/IMiddlewareEffectServiceDelegate;", "Lcom/bytedance/android/live/effect/api/LiveEffectContextFactoryDelegate$Type;", "type", "Lcom/bytedance/android/live/effect/api/e;", "baseEffectContext", "Lcom/bytedance/android/live/effect/api/g;", "baseEffectService", "Lcom/bytedance/android/live/effect/api/ILiveEffectComposerManager;", "composerManager", "Lcom/bytedance/android/live/effect/api/f;", "baseEffectProxy", "<init>", "()V", "liveeffect-middleware-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public class MiddlewareEffectServiceDelegate implements IMiddlewareEffectServiceDelegate {
    @Override // com.bytedance.android.live.effect.api.IMiddlewareEffectServiceDelegate
    public f baseEffectProxy() {
        LiveEffectBaseProxy.f68859b.getClass();
        return (LiveEffectBaseProxy) LiveEffectBaseProxy.f68858a.getValue();
    }

    public MiddlewareEffectServiceDelegate() {
        jc1.k.l(IMiddlewareEffectServiceDelegate.class, this);
    }

    @Override // com.bytedance.android.live.effect.api.IMiddlewareEffectServiceDelegate
    public e baseEffectContext(LiveEffectContextFactoryDelegate$Type r100) {
        Intrinsics.checkNotNullParameter(r100, "type");
        return u.a(r100);
    }

    @Override // com.bytedance.android.live.effect.api.IMiddlewareEffectServiceDelegate
    public g baseEffectService(LiveEffectContextFactoryDelegate$Type r100) {
        Intrinsics.checkNotNullParameter(r100, "type");
        return u.b(r100);
    }

    @Override // com.bytedance.android.live.effect.api.IMiddlewareEffectServiceDelegate
    public ILiveEffectComposerManager composerManager(LiveEffectContextFactoryDelegate$Type r100) {
        Intrinsics.checkNotNullParameter(r100, "type");
        return u.c(r100);
    }
}
