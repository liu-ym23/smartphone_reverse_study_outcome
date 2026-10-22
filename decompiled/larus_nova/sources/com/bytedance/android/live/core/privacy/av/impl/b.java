package com.bytedance.android.live.core.privacy.av.impl;

import android.hardware.camera2.CameraManager;
import com.ss.android.ugc.aweme.shortvideo.ShortVideoSegments;
import java.util.List;
import kotlin.Pair;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class b extends CameraManager.AvailabilityCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ c f65154a;

    public b(c r100) {
        this.f65154a = r100;
    }

    @Override // android.hardware.camera2.CameraManager.AvailabilityCallback
    public final void onCameraAvailable(String r110) {
        Intrinsics.checkNotNullParameter(r110, ShortVideoSegments.KEY_CAMERA_ID);
        c.f(this.f65154a, r110, false);
        this.f65154a.f65164i.a("onCameraStatusChanged; isPermissionOnUse=" + this.f65154a.f65157b + ", cameraId=" + r110);
        super.onCameraAvailable(r110);
        if (this.f65154a.f65163h.h() == false) goto L10;
        List<String> r100 = this.f65154a.f65163h.d();
        if (r100 != null) goto L7;
        return;
    L7:
        if (r100.contains("av_status_change") != true) goto L12;
        this.f65154a.f65164i.c(new com.bytedance.android.live.core.privacy.av.api.i("av_status_change", "onCameraAvailable", 0, "", "", "", "", MapsKt.mapOf(new Pair[]{new Pair(ShortVideoSegments.KEY_CAMERA_ID, String.valueOf(r110)), new Pair("isCapturePermissionOnUse", String.valueOf(this.f65154a.f65157b))})));
        return;
    L12:
        return;
    }

    @Override // android.hardware.camera2.CameraManager.AvailabilityCallback
    public final void onCameraUnavailable(String r110) {
        Intrinsics.checkNotNullParameter(r110, ShortVideoSegments.KEY_CAMERA_ID);
        c r100 = this.f65154a;
        if (r100.f65158c == false) goto L6;
        r100.f65164i.a("onCameraStatusChanged; onCameraUnavailable cant change when releasing");
        return;
    L6:
        c.f(r100, r110, true);
        this.f65154a.f65164i.a("onCameraStatusChanged; isPermissionOnUse=" + this.f65154a.f65157b + ", cameraId=" + r110);
        super.onCameraUnavailable(r110);
        if (this.f65154a.f65163h.h() == false) goto L14;
        List<String> r101 = this.f65154a.f65163h.d();
        if (r101 != null) goto L11;
        return;
    L11:
        if (r101.contains("av_status_change") != true) goto L16;
        this.f65154a.f65164i.c(new com.bytedance.android.live.core.privacy.av.api.i("av_status_change", "onCameraUnavailable", 0, "", "", "", "", MapsKt.mapOf(new Pair[]{new Pair(ShortVideoSegments.KEY_CAMERA_ID, String.valueOf(r110)), new Pair("isCapturePermissionOnUse", String.valueOf(this.f65154a.f65157b))})));
        return;
    L16:
        return;
    }
}
