package com.bytedance.android.live.broadcast.api.monitor;

import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes45.dex */
@Retention(RetentionPolicy.RUNTIME)
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u001b\n\u0002\b\u0003\b\u0086\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0003B\u0000¨\u0006\u0004"}, d2 = {"com/bytedance/android/live/broadcast/api/monitor/LiveStreamCodeMonitor$OnInfoType", "", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "livebroadcast-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public @interface LiveStreamCodeMonitor$OnInfoType {
    public static final a Companion = null;
    public static final String MSG_INFO_AUDIO_STARTED_CAPTURE = "AUDIO_STARTED_CAPTURE";
    public static final String MSG_INFO_AUDIO_STARTING_CAPTURE = "AUDIO_STARTING_CAPTURE";
    public static final String MSG_INFO_AUDIO_STOPED_CAPTURE = "AUDIO_STOPED_CAPTURE";
    public static final String MSG_INFO_CAPTURE_FIRST_FRAME = "CAPTURE_FIRST_FRAME";
    public static final String MSG_INFO_RESOLUTION_CHANGED = "RESOLUTION_CHANGED";
    public static final String MSG_INFO_RTMP_CONNECTED = "RTMP_CONNECTED";
    public static final String MSG_INFO_VIDEO_STARTED_CAPTURE = "VIDEO_STARTED_CAPTURE";
    public static final String MSG_INFO_VIDEO_STARTING_CAPTURE = "VIDEO_STARTING_CAPTURE";
    public static final String MSG_INFO_VIDEO_STOPED_CAPTURE = "VIDEO_STOPED_CAPTURE";
    public static final String MSG_NOTIFY_TOGGLE_CAMERA = "NOTIFY_TOGGLE_CAMERA";

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f59056a = null;

        public a() {
        }

        static {
            f59056a = new a();
        }
    }

    static {
        Companion = a.f59056a;
    }
}
