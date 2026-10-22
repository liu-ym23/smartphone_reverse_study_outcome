package com.bytedance.android.livesdk.jsbridge.methods;

import android.content.Context;
import android.os.Build;
import com.ss.android.downloadlib.addownload.compliance.ComplianceResult;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class x2 implements o60.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ w2.a f142241a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Context f142242b;

    @Override // o60.e
    public final void onPermissionDenied(String... r100) {
        Intrinsics.checkNotNullParameter(r100, ComplianceResult.JsonKey.PERMISSIONS);
        if (Build.VERSION.SDK_INT >= 34) goto L5;
    L7:
        this.f142241a.a();
        return;
    L5:
        if (m60.c.d(this.f142242b, new String[]{"android.permission.READ_MEDIA_VISUAL_USER_SELECTED"}) == false) goto L7;
        this.f142241a.b();
    }

    @Override // o60.e
    public final void onPermissionGrant(String... r100) {
        Intrinsics.checkNotNullParameter(r100, ComplianceResult.JsonKey.PERMISSIONS);
        this.f142241a.b();
    }

    public x2(a3 r100, Context r101) {
        this.f142241a = r100;
        this.f142242b = r101;
    }
}
