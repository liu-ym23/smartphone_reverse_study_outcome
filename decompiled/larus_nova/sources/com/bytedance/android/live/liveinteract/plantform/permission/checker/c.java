package com.bytedance.android.live.liveinteract.plantform.permission.checker;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.bpea.basics.Cert;
import com.bytedance.bpea.cert.token.TokenCert;
import com.ss.android.downloadlib.addownload.compliance.ComplianceResult;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class c implements o60.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a f77357a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Cert f77358b;

    @Override // o60.e
    public final void onPermissionDenied(String... r100) {
        Intrinsics.checkNotNullParameter(r100, ComplianceResult.JsonKey.PERMISSIONS);
        ALogger.d("ttlive_link", "skip bluetooth permission denied");
        qh0.d<rh0.a> r101 = this.f77357a.f77352a;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("consumer");
    L5:
        r101.onResult(null);
    }

    @Override // o60.e
    public final void onPermissionGrant(String... r100) {
        Intrinsics.checkNotNullParameter(r100, ComplianceResult.JsonKey.PERMISSIONS);
        ALogger.d("ttlive_link", "check bluetooth permission denied");
        qh0.d<rh0.a> r101 = this.f77357a.f77352a;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("consumer");
    L5:
        r101.onResult(null);
    }

    public c(a r100, TokenCert r101) {
        this.f77357a = r100;
        this.f77358b = r101;
    }
}
