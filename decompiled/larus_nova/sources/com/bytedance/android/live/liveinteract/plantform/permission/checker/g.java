package com.bytedance.android.live.liveinteract.plantform.permission.checker;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.liveinteract.plantform.permission.model.BaseCheckException;
import com.bytedance.bpea.basics.Cert;
import com.bytedance.bpea.cert.token.TokenCert;
import com.larus.nova.R;
import com.ss.android.downloadlib.addownload.compliance.ComplianceResult;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class g implements o60.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ e f77365a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ qh0.d f77366b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Cert f77367c;

    @Override // o60.e
    public final void onPermissionDenied(String... r110) {
        Intrinsics.checkNotNullParameter(r110, ComplianceResult.JsonKey.PERMISSIONS);
        ALogger.i("ttlive_link", "checkAndroidSystemPermission failure");
        qh0.d r111 = this.f77366b;
        qh0.f.b r100 = this.f77365a.f77362a;
        r111.b(new BaseCheckException(r100.f532892c, r100.f532891b, BaseCheckException.CheckType.AndroidPermission, "android permission denied.", null, 16, null));
        if (this.f77365a.f77362a.f532893d == false) goto L5;
        f2.c(s1.B(R.string.ttlive_interact_ktv_camera_permission), 0);
        return;
    L5:
        f2.c(s1.B(R.string.ttlive_interact_camera_permission), 0);
    }

    @Override // o60.e
    public final void onPermissionGrant(String... r100) {
        Intrinsics.checkNotNullParameter(r100, ComplianceResult.JsonKey.PERMISSIONS);
        ALogger.i("ttlive_link", "checkAndroidSystemPermission success");
        this.f77366b.onResult(null);
    }

    public g(e r100, qh0.d r101, TokenCert r102) {
        this.f77365a = r100;
        this.f77366b = r101;
        this.f77367c = r102;
    }
}
