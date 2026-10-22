package com.bytedance.android.live.liveinteract.plantform.commonwindow.wm;

import com.ss.android.downloadlib.constants.ComplianceConstants;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class q implements ne0.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ o f76106a;

    public q(o r100) {
        this.f76106a = r100;
    }

    @Override // ne0.a
    public final void a(ne0.e r100, Object r101) {
        Intrinsics.checkNotNullParameter(r100, ComplianceConstants.ComplianceRequest.MARKET_STORE);
        if (r101 == null) goto L12;
        if (((Boolean) r101).booleanValue() == true) goto L7;
        this.f76106a.getClass();
        return;
    L7:
        if (((Boolean) vm2.d.W6.getValue(null, vm2.d.f555776a[410(0x19a, float:5.75E-43)])).booleanValue() == false) goto L13;
        this.f76106a.getClass();
        return;
    L13:
        return;
    L12:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Boolean");
    }
}
