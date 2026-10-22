package com.bytedance.android.live.videocapture.control;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/live/videocapture/control/VideoCaptureType;", "", "LIVE_VIDEO_CAPTURE", "BYTE_CAST_SINK_CAPTURE", "livevideocapture_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum VideoCaptureType extends Enum<VideoCaptureType> {
    public static final VideoCaptureType BYTE_CAST_SINK_CAPTURE = null;
    public static final VideoCaptureType LIVE_VIDEO_CAPTURE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ VideoCaptureType[] f102585a = null;

    static {
        VideoCaptureType r100 = new VideoCaptureType("LIVE_VIDEO_CAPTURE", 0);
        LIVE_VIDEO_CAPTURE = r100;
        VideoCaptureType r101 = new VideoCaptureType("BYTE_CAST_SINK_CAPTURE", 1);
        BYTE_CAST_SINK_CAPTURE = r101;
        f102585a = new VideoCaptureType[]{r100, r101};
    }

    public static VideoCaptureType valueOf(String r100) {
        return (VideoCaptureType) a.a(VideoCaptureType.class, r100);
    }

    public static VideoCaptureType[] values() {
        return (VideoCaptureType[]) f102585a.clone();
    }

    public VideoCaptureType(String r100, int r101) {
        super(r100, r101);
    }
}
