package com.bytedance.android.live.liveinteract.plantform.permission.checker;

import android.content.Context;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.liveinteract.plantform.permission.model.BaseCheckException;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livehostapi.foundation.IHostPlugin;
import com.larus.nova.R;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class o implements qh0.a<rh0.a>, qh0.d<rh0.a> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public qh0.d<rh0.a> f77388a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final qh0.f.g f77389b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final qh0.a<rh0.a> f77390c;

    @Override // qh0.a
    public final void a(qh0.d<rh0.a> r100) {
        Intrinsics.checkNotNullParameter(r100, "consumer");
        this.f77388a = r100;
        qh0.a<rh0.a> r101 = this.f77390c;
        if (r101 == null) goto L5;
        r101.a(this);
        return;
    L5:
        c(null);
    }

    @Override // qh0.d
    public final void b(BaseCheckException r100) {
        Intrinsics.checkNotNullParameter(r100, com.bytedance.android.ec.core.event.a.KEY_EXCEPTION);
        qh0.d<rh0.a> r101 = this.f77388a;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("consumer");
    L5:
        r101.b(r100);
    }

    public final void c(rh0.a r100) {
        if (((IMiddlewareUserService) jc1.k.n(IMiddlewareUserService.class)).user().isLogin() == false) goto L8;
        qh0.d<rh0.a> r101 = this.f77388a;
        if (r101 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("consumer");
    L7:
        r101.onResult(null);
        return;
    L8:
        com.bytedance.android.livesdk.user.e r102 = ((IMiddlewareUserService) jc1.k.n(IMiddlewareUserService.class)).user();
        Context r103 = this.f77389b.getContext();
        com.bytedance.android.livesdk.user.l.a r104 = new com.bytedance.android.livesdk.user.l.a();
        r104.f158685a = s1.B(R.string.ttlive_live_interact_login_tip);
        r104.f158688d = IHostPlugin.ENTER_FROM_LINKMIC_TYPE;
        r104.f158687c = 0;
        r102.login(r103, new com.bytedance.android.livesdk.user.l(r104)).subscribe(new n(this));
    }

    @Override // qh0.d
    public final /* bridge */ /* synthetic */ void onResult(rh0.a r100) {
        c(r100);
    }

    public o(qh0.f.g r100, qh0.a<rh0.a> r101) {
        Intrinsics.checkNotNullParameter(r100, "createConfig");
        this.f77389b = r100;
        this.f77390c = r101;
    }
}
