package com.bytedance.android.gamecp.business.download;

import android.app.NotificationManager;
import androidx.core.app.NotificationCompat;
import com.ss.android.downloadlib.addownload.compliance.ComplianceResult;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class r0 implements uu.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ NotificationCompat.Builder f52891a;

    @Override // uu.d
    public final void onPermissionDenied(String... r100) {
        Intrinsics.checkNotNullParameter(r100, ComplianceResult.JsonKey.PERMISSIONS);
    }

    public r0(NotificationCompat.Builder r100) {
        this.f52891a = r100;
    }

    @Override // uu.d
    public final void onPermissionGrant(String... r100) {
        Intrinsics.checkNotNullParameter(r100, ComplianceResult.JsonKey.PERMISSIONS);
        NotificationManager r101 = t0.f52932a;
        NotificationManager r102 = t0.f52932a;
        if (r102 == null) goto L6;
        r102.notify(6000, this.f52891a.build());
        return;
    }
}
