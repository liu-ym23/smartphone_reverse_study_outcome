package com.bytedance.android.livesdkapi.eventbus;

import android.os.Bundle;
import com.ss.android.ugc.aweme.shortvideo.ShortVideoSegments;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000*\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u001a\"\u0010\u0004\u001a\u00020\u0005*\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u000b\u001a\u0012\u0010\f\u001a\u00020\u0005*\u00020\u00062\u0006\u0010\r\u001a\u00020\u000e\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"EXTRA_VS_CAMERA_ID", "", "EXTRA_VS_CAMERA_STYLE", "EXTRA_VS_MATCH_ID", "applyCamera", "", "Landroid/os/Bundle;", ShortVideoSegments.KEY_CAMERA_ID, "", "matchId", "style", "", "applyCameraEvent", "event", "Lcom/bytedance/android/livesdkapi/eventbus/VSJumpCameraEvent;", "live-model-api_saasRelease"}, k = 2, mv = {1, 5, 1})
public final class VSJumpCameraEventKt {
    private static final String EXTRA_VS_CAMERA_ID = "live.intent.extra.EXTRA_VS_CAMERA_ID";
    private static final String EXTRA_VS_CAMERA_STYLE = "live.intent.extra.EXTRA_VS_CAMERA_STYLE";
    private static final String EXTRA_VS_MATCH_ID = "live.intent.extra.EXTRA_VS_MATCH_ID";

    public static final void applyCameraEvent(Bundle r100, VSJumpCameraEvent r101) {
        Intrinsics.checkNotNullParameter(r100, "$this$applyCameraEvent");
        Intrinsics.checkNotNullParameter(r101, "event");
        applyCamera(r100, r101.getCameraId(), r101.getMatchId(), r101.getStyle());
    }

    public static final void applyCamera(Bundle r100, long r101, long r102, int r103) {
        Intrinsics.checkNotNullParameter(r100, "$this$applyCamera");
        r100.putLong("live.intent.extra.EXTRA_VS_CAMERA_ID", r101);
        r100.putLong("live.intent.extra.EXTRA_VS_MATCH_ID", r102);
        r100.putInt("live.intent.extra.EXTRA_VS_CAMERA_STYLE", r103);
    }
}
