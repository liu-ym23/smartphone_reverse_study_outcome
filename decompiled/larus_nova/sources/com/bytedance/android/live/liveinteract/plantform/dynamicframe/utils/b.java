package com.bytedance.android.live.liveinteract.plantform.dynamicframe.utils;

import android.content.Context;
import android.graphics.Bitmap;
import com.bytedance.android.live.browser.jsbridge.base.UpdateLinkmicStatusResultModel;
import com.larus.nova.R;
import com.ss.android.downloadlib.addownload.compliance.ComplianceResult;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class b implements o60.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a f77128a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Context f77129b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Bitmap f77130c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ ih0.h f77131d;

    @Override // o60.e
    public final void onPermissionDenied(String... r100) {
        Intrinsics.checkNotNullParameter(r100, ComplianceResult.JsonKey.PERMISSIONS);
        this.f77131d.a(UpdateLinkmicStatusResultModel.Code.Failed, this.f77129b.getResources().getString(R.string.ttlive_save_pic_fail_permission_denied), null);
    }

    @Override // o60.e
    public final void onPermissionGrant(String... r100) {
        Intrinsics.checkNotNullParameter(r100, ComplianceResult.JsonKey.PERMISSIONS);
        a.a(this.f77128a, this.f77129b, this.f77130c, this.f77131d);
    }

    public b(a r100, Context r101, Bitmap r102, com.bytedance.android.live.liveinteract.jsbridge.method.j r103) {
        this.f77128a = r100;
        this.f77129b = r101;
        this.f77130c = r102;
        this.f77131d = r103;
    }
}
