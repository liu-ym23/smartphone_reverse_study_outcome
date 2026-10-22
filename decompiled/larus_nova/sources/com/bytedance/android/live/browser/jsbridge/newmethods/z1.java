package com.bytedance.android.live.browser.jsbridge.newmethods;

import android.content.Context;
import com.ss.android.downloadlib.addownload.compliance.ComplianceResult;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class z1 implements o60.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a2 f63738a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Context f63739b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ b2 f63740c;

    @Override // o60.e
    public final void onPermissionDenied(String... r100) {
        Intrinsics.checkNotNullParameter(r100, ComplianceResult.JsonKey.PERMISSIONS);
        a2 r101 = this.f63738a;
        r101.getClass();
        ClipScreenResultModel r102 = a2.j(false);
        ClipScreenResultModel.a r103 = r102.a();
        if (r103 == null) goto L5;
        r103.b(2);
    L5:
        Unit r104 = Unit.INSTANCE;
        r101.finishWithResult(r102);
    }

    @Override // o60.e
    public final void onPermissionGrant(String... r100) {
        Intrinsics.checkNotNullParameter(r100, ComplianceResult.JsonKey.PERMISSIONS);
        this.f63738a.k(this.f63739b, this.f63740c);
    }

    public z1(a2 r100, Context r101, b2 r102) {
        this.f63738a = r100;
        this.f63739b = r101;
        this.f63740c = r102;
    }
}
