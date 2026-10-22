package com.bytedance.android.live.liveinteract.plantform.permission.checker;

import com.alibaba.gaiax.template.GXTemplateKey;
import com.bytedance.android.live.broadcast.api.IMiddlewareBroadcastService;
import com.bytedance.android.live.liveinteract.plantform.permission.model.BaseCheckException;
import com.bytedance.android.live.plugin_api.LivePluginSPIManager;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class s implements qh0.a<rh0.a>, qh0.d<rh0.a> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public qh0.d<rh0.a> f77403a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final qh0.a<rh0.a> f77404b;

    public static final class a implements js0.b {
        public a() {
        }

        @Override // js0.b
        public final void onSuccess(String r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_TRACK);
            com.bytedance.android.scope.m r101 = com.bytedance.android.scope.m.f163449e;
            f00.a.C5839a r102 = f00.a.f474945b;
            nz.t r103 = (nz.t) r101.d(r102, nz.t.class);
            if (r103 != null) goto L5;
        L9:
            ((IMiddlewareBroadcastService) va1.b.a.f553922a.a(IMiddlewareBroadcastService.class)).init();
            return;
        L5:
            if (r103.isOpen() != true) goto L9;
            nz.t r104 = (nz.t) r101.d(r102, nz.t.class);
            if (r104 == null) goto L11;
            r104.init();
            return;
        }
    }

    public s(qh0.a<rh0.a> r100) {
        this.f77404b = r100;
    }

    @Override // qh0.a
    public final void a(qh0.d<rh0.a> r100) {
        Intrinsics.checkNotNullParameter(r100, "consumer");
        this.f77403a = r100;
        qh0.a<rh0.a> r101 = this.f77404b;
        if (r101 == null) goto L5;
        r101.a(this);
        return;
    L5:
        c(null);
    }

    @Override // qh0.d
    public final void b(BaseCheckException r100) {
        Intrinsics.checkNotNullParameter(r100, com.bytedance.android.ec.core.event.a.KEY_EXCEPTION);
        qh0.d<rh0.a> r101 = this.f77403a;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("consumer");
    L5:
        r101.b(r100);
    }

    public final void c(rh0.a r100) {
        LivePluginSPIManager.f85856e.getClass();
        LivePluginSPIManager.a().addOnSuccess(new a()).callbackOnMainThread().syncCallbackIfReady(true).justPrepare();
        qh0.d<rh0.a> r101 = this.f77403a;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("consumer");
    L5:
        r101.onResult(r100);
    }

    @Override // qh0.d
    public final /* bridge */ /* synthetic */ void onResult(rh0.a r100) {
        c(r100);
    }
}
