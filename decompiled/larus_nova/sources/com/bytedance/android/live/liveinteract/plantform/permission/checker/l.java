package com.bytedance.android.live.liveinteract.plantform.permission.checker;

import com.bytedance.android.live.liveinteract.plantform.permission.model.BaseCheckException;
import com.bytedance.bpea.basics.Cert;
import com.bytedance.bpea.cert.token.TokenCert;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class l implements o60.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ i f77379a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Cert f77380b;

    public l(i r100, TokenCert r101) {
        this.f77379a = r100;
        this.f77380b = r101;
    }

    @Override // o60.d
    public final void a() {
        qh0.d<rh0.a> r100 = this.f77379a.f77372a;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("consumer");
    L5:
        qh0.f.c r101 = this.f77379a.f77373b;
        r100.b(new BaseCheckException(r101.f532896c, r101.f532895b, BaseCheckException.CheckType.AndroidPermission, "android permission denied and go to settings.", null, 16, null));
    }
}
