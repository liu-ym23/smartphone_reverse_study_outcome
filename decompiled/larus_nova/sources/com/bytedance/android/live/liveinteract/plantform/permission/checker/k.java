package com.bytedance.android.live.liveinteract.plantform.permission.checker;

import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.liveinteract.plantform.permission.model.BaseCheckException;
import com.bytedance.bpea.basics.Cert;
import com.bytedance.bpea.cert.token.TokenCert;
import com.larus.nova.R;
import com.ss.android.downloadlib.addownload.compliance.ComplianceResult;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class k implements o60.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ i f77377a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Cert f77378b;

    @Override // o60.e
    public final void onPermissionDenied(String... r110) {
        Intrinsics.checkNotNullParameter(r110, ComplianceResult.JsonKey.PERMISSIONS);
        qh0.d<rh0.a> r100 = this.f77377a.f77372a;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("consumer");
    L5:
        qh0.f.c r101 = this.f77377a.f77373b;
        r100.b(new BaseCheckException(r101.f532896c, r101.f532895b, BaseCheckException.CheckType.AndroidPermission, "android permission denied.", null, 16, null));
        if (ArraysKt.contains(r110, "android.permission.RECORD_AUDIO") != true) goto L8;
        boolean r102 = true;
    L10:
        if (ArraysKt.contains(r110, "android.permission.CAMERA") != true) goto L12;
        boolean r111 = true;
    L13:
        int r103 = this.f77377a.f77373b.f532896c;
        if (r103 != 1) goto L23;
        if (r102 == false) goto L18;
        if (r111 == false) goto L18;
        f2.b(R.string.ttlive_interact_audio_camera_permission, 0);
        return;
    L18:
        if (r111 == false) goto L20;
        f2.b(R.string.ttlive_interact_camera_permission, 0);
        return;
    L20:
        if (r102 == false) goto L29;
        f2.b(R.string.ttlive_interact_audio_permission, 0);
        return;
    L29:
        return;
    L23:
        if (r103 != 2) goto L31;
        if (r102 == false) goto L32;
        f2.b(R.string.ttlive_interact_audio_link_permission, 0);
        return;
    L32:
        return;
    L31:
        return;
    L12:
        r111 = false;
        goto L13
    L8:
        r102 = false;
        goto L10
    }

    @Override // o60.e
    public final void onPermissionGrant(String... r100) {
        Intrinsics.checkNotNullParameter(r100, ComplianceResult.JsonKey.PERMISSIONS);
        qh0.d<rh0.a> r101 = this.f77377a.f77372a;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("consumer");
    L5:
        r101.onResult(null);
    }

    public k(i r100, TokenCert r101) {
        this.f77377a = r100;
        this.f77378b = r101;
    }
}
