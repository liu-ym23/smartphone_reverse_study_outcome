package com.bytedance.android.livesdk.interactivity.comment.audio;

import com.ss.android.downloadlib.addownload.compliance.ComplianceResult;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class e implements o60.e {
    public e() {
    }

    @Override // o60.e
    public final void onPermissionDenied(String... r100) {
        Intrinsics.checkNotNullParameter(r100, ComplianceResult.JsonKey.PERMISSIONS);
    }

    @Override // o60.e
    public final void onPermissionGrant(String... r100) {
        Intrinsics.checkNotNullParameter(r100, ComplianceResult.JsonKey.PERMISSIONS);
    }
}
