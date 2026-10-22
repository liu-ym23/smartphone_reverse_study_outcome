package com.bytedance.android.gamecp.hybrid_impl.jsb;

import kotlin.Unit;

/* JADX INFO: loaded from: classes44.dex */
public final class f1 implements com.bytedance.android.gamecp.base.core.service.depend.u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ e1 f57497a;

    public f1(e1 r100) {
        this.f57497a = r100;
    }

    @Override // com.bytedance.android.gamecp.base.core.service.depend.u
    public final void a(boolean r100) {
        if (r100 == false) goto L4;
        com.bytedance.android.gamecp.common.utils.a1.a().putBoolean("live.pref.PREF_SHOW_GAME_PROMOTE_PROP_USAGE", true).apply();
        e1 r101 = this.f57497a;
        CheckGameCPPropConsentPrivacyResultModel r102 = new CheckGameCPPropConsentPrivacyResultModel();
        r102.a(CheckGameCPPropConsentPrivacyResultModel.Code.Success);
        CheckGameCPPropConsentPrivacyResultModel.a r103 = new CheckGameCPPropConsentPrivacyResultModel.a();
        r103.a(1);
        Unit r104 = Unit.INSTANCE;
        r102.b(r103);
        r101.finishWithResult(r102);
        return;
    L4:
        e1 r105 = this.f57497a;
        CheckGameCPPropConsentPrivacyResultModel r106 = new CheckGameCPPropConsentPrivacyResultModel();
        r106.a(CheckGameCPPropConsentPrivacyResultModel.Code.Success);
        CheckGameCPPropConsentPrivacyResultModel.a r107 = new CheckGameCPPropConsentPrivacyResultModel.a();
        r107.a(0);
        Unit r108 = Unit.INSTANCE;
        r106.b(r107);
        r105.finishWithResult(r106);
    }
}
