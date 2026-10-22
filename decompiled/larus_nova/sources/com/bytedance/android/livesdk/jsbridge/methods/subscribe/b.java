package com.bytedance.android.livesdk.jsbridge.methods.subscribe;

import com.ss.android.downloadlib.addownload.compliance.ComplianceResult;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class b implements o60.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function0 f142191a;

    @Override // o60.e
    public final void onPermissionGrant(String... r100) {
        Intrinsics.checkNotNullParameter(r100, ComplianceResult.JsonKey.PERMISSIONS);
    }

    public b(Function0 r100) {
        this.f142191a = r100;
    }

    @Override // o60.e
    public final void onPermissionDenied(String... r100) {
        Intrinsics.checkNotNullParameter(r100, ComplianceResult.JsonKey.PERMISSIONS);
        this.f142191a.invoke();
    }
}
