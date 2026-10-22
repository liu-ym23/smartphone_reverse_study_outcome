package com.bytedance.android.live.anchorlink.linksecurity;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"com/bytedance/android/live/anchorlink/linksecurity/LinkSecurityApi$VideoCaptureType", "", "Lcom/bytedance/android/live/anchorlink/linksecurity/LinkSecurityApi$VideoCaptureType;", "VIDEO_CAPTURE_DEVICE_UNKNOWN", "VIDEO_CAPTURE_DEVICE_NONE", "VIDEO_CAPTURE_VIDEO", "VIDEO_CAPTURE_RADIO_MODE", "VIDEO_CAPTURE_RTC_BLACK_FRAME_MODE", "revenue-link-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum LinkSecurityApi$VideoCaptureType extends Enum<LinkSecurityApi$VideoCaptureType> {
    public static final LinkSecurityApi$VideoCaptureType VIDEO_CAPTURE_DEVICE_NONE = null;
    public static final LinkSecurityApi$VideoCaptureType VIDEO_CAPTURE_DEVICE_UNKNOWN = null;
    public static final LinkSecurityApi$VideoCaptureType VIDEO_CAPTURE_RADIO_MODE = null;
    public static final LinkSecurityApi$VideoCaptureType VIDEO_CAPTURE_RTC_BLACK_FRAME_MODE = null;
    public static final LinkSecurityApi$VideoCaptureType VIDEO_CAPTURE_VIDEO = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ LinkSecurityApi$VideoCaptureType[] f58565a = null;

    static {
        LinkSecurityApi$VideoCaptureType r100 = new LinkSecurityApi$VideoCaptureType("VIDEO_CAPTURE_DEVICE_UNKNOWN", 0);
        VIDEO_CAPTURE_DEVICE_UNKNOWN = r100;
        LinkSecurityApi$VideoCaptureType r101 = new LinkSecurityApi$VideoCaptureType("VIDEO_CAPTURE_DEVICE_NONE", 1);
        VIDEO_CAPTURE_DEVICE_NONE = r101;
        LinkSecurityApi$VideoCaptureType r102 = new LinkSecurityApi$VideoCaptureType("VIDEO_CAPTURE_VIDEO", 2);
        VIDEO_CAPTURE_VIDEO = r102;
        LinkSecurityApi$VideoCaptureType r103 = new LinkSecurityApi$VideoCaptureType("VIDEO_CAPTURE_RADIO_MODE", 3);
        VIDEO_CAPTURE_RADIO_MODE = r103;
        LinkSecurityApi$VideoCaptureType r104 = new LinkSecurityApi$VideoCaptureType("VIDEO_CAPTURE_RTC_BLACK_FRAME_MODE", 4);
        VIDEO_CAPTURE_RTC_BLACK_FRAME_MODE = r104;
        f58565a = new LinkSecurityApi$VideoCaptureType[]{r100, r101, r102, r103, r104};
    }

    public static LinkSecurityApi$VideoCaptureType valueOf(String r100) {
        return (LinkSecurityApi$VideoCaptureType) a.a(LinkSecurityApi$VideoCaptureType.class, r100);
    }

    public static LinkSecurityApi$VideoCaptureType[] values() {
        return (LinkSecurityApi$VideoCaptureType[]) f58565a.clone();
    }

    public LinkSecurityApi$VideoCaptureType(String r100, int r101) {
        super(r100, r101);
    }
}
