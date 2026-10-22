package com.bytedance.android.live.browser.jsbridge.newmethods;

import com.bytedance.ies.web.jsbridge2.CallContext;
import com.ss.android.downloadlib.addownload.compliance.ComplianceResult;
import java.util.List;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class r0 implements o60.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ q0 f63623a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ CallContext f63624b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ List f63625c;

    @Override // o60.e
    public final void onPermissionDenied(String... r100) {
        Intrinsics.checkNotNullParameter(r100, ComplianceResult.JsonKey.PERMISSIONS);
        this.f63624b.b("H5_authorizationChange", MapsKt.mapOf(new Pair[]{TuplesKt.to("code", 1), TuplesKt.to("type", this.f63625c.toString()), TuplesKt.to("isAuthorization", Boolean.FALSE)}));
        q0 r101 = this.f63623a;
        r101.getClass();
        r101.finishWithResult(q0.j(false));
    }

    @Override // o60.e
    public final void onPermissionGrant(String... r100) {
        Intrinsics.checkNotNullParameter(r100, ComplianceResult.JsonKey.PERMISSIONS);
        this.f63624b.b("H5_authorizationChange", MapsKt.mapOf(new Pair[]{TuplesKt.to("code", 1), TuplesKt.to("type", this.f63625c.toString()), TuplesKt.to("isAuthorization", Boolean.TRUE)}));
        q0 r101 = this.f63623a;
        r101.getClass();
        r101.finishWithResult(q0.j(true));
    }

    public r0(q0 r100, CallContext r101, List r102) {
        this.f63623a = r100;
        this.f63624b = r101;
        this.f63625c = r102;
    }
}
