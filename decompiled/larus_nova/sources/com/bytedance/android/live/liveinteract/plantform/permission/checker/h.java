package com.bytedance.android.live.liveinteract.plantform.permission.checker;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.liveinteract.plantform.permission.model.BaseCheckException;
import com.bytedance.bpea.basics.Cert;
import com.bytedance.bpea.cert.token.TokenCert;

/* JADX INFO: loaded from: classes46.dex */
public final class h implements o60.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ e f77368a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ qh0.d f77369b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Cert f77370c;

    public h(e r100, qh0.d r101, TokenCert r102) {
        this.f77368a = r100;
        this.f77369b = r101;
        this.f77370c = r102;
    }

    @Override // o60.d
    public final void a() {
        ALogger.i("ttlive_link", "checkAndroidSystemPermission goToSettings");
        qh0.d r100 = this.f77369b;
        qh0.f.b r101 = this.f77368a.f77362a;
        r100.b(new BaseCheckException(r101.f532892c, r101.f532891b, BaseCheckException.CheckType.AndroidPermission, "android permission denied and go to settings.", null, 16, null));
    }
}
