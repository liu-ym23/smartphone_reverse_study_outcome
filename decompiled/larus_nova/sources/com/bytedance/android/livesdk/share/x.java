package com.bytedance.android.livesdk.share;

import com.bytedance.android.live.core.utils.f2;
import com.larus.nova.R;
import com.ss.android.downloadlib.addownload.compliance.ComplianceResult;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class x implements o60.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ShareTicketFragment f158112a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Function0 f158113b;

    @Override // o60.e
    public final void onPermissionDenied(String... r100) {
        Intrinsics.checkNotNullParameter(r100, ComplianceResult.JsonKey.PERMISSIONS);
        f2.b(R.string.ttlive_save_ticket_no_permission, 0);
    }

    @Override // o60.e
    public final void onPermissionGrant(String... r100) {
        Intrinsics.checkNotNullParameter(r100, ComplianceResult.JsonKey.PERMISSIONS);
        ShareTicketFragment r101 = this.f158112a;
        Function0<Unit> r102 = this.f158113b;
        int r103 = ShareTicketFragment.R;
        r101.V90(r102);
    }

    public x(ShareTicketFragment r100, Function0 r101) {
        this.f158112a = r100;
        this.f158113b = r101;
    }
}
