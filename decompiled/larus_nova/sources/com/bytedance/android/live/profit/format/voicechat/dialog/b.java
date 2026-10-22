package com.bytedance.android.live.profit.format.voicechat.dialog;

import com.ss.android.downloadlib.addownload.compliance.ComplianceResult;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import o60.e;

/* JADX INFO: loaded from: classes47.dex */
public final class b implements e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function1 f87613a;

    public b(Function1 r100) {
        this.f87613a = r100;
    }

    @Override // o60.e
    public final void onPermissionDenied(String... r100) {
        Intrinsics.checkNotNullParameter(r100, ComplianceResult.JsonKey.PERMISSIONS);
        this.f87613a.invoke(Boolean.FALSE);
    }

    @Override // o60.e
    public final void onPermissionGrant(String... r100) {
        Intrinsics.checkNotNullParameter(r100, ComplianceResult.JsonKey.PERMISSIONS);
        this.f87613a.invoke(Boolean.TRUE);
    }
}
