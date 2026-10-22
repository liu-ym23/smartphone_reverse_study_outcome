package com.bytedance.android.live.liveinteract.plantform.permission.checker;

import com.alibaba.gaiax.template.GXTemplateKey;
import com.bytedance.android.live.broadcast.api.IMiddlewareBroadcastService;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class w implements js0.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ t f77416a;

    @Override // js0.b
    public final void onSuccess(String r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_TRACK);
        com.bytedance.android.scope.m r101 = com.bytedance.android.scope.m.f163449e;
        f00.a.C5839a r102 = f00.a.f474945b;
        nz.t r103 = (nz.t) r101.d(r102, nz.t.class);
        if (r103 != null) goto L5;
    L9:
        ((IMiddlewareBroadcastService) va1.b.a.f553922a.a(IMiddlewareBroadcastService.class)).init();
    L10:
        this.f77416a.c();
        return;
    L5:
        if (r103.isOpen() != true) goto L9;
        nz.t r104 = (nz.t) r101.d(r102, nz.t.class);
        if (r104 == null) goto L10;
        r104.init();
        goto L10
    }

    public w(t r100, rh0.a r101) {
        this.f77416a = r100;
    }
}
