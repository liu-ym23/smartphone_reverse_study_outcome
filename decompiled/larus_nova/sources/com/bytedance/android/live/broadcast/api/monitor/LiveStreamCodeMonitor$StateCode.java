package com.bytedance.android.live.broadcast.api.monitor;

import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes45.dex */
@Retention(RetentionPolicy.RUNTIME)
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u001b\n\u0002\b\u0003\b\u0086\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0003B\u0000¨\u0006\u0004"}, d2 = {"com/bytedance/android/live/broadcast/api/monitor/LiveStreamCodeMonitor$StateCode", "", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "livebroadcast-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public @interface LiveStreamCodeMonitor$StateCode {
    public static final a Companion = null;
    public static final int STATE_LIVE_CODE_INFO_ADD_V3 = 10;
    public static final int STATE_LIVE_CODE_INFO_FIRST_FRAME = 9;
    public static final int STATE_LIVE_CODE_INFO_RECONNECT = 3;
    public static final int STATE_LIVE_CODE_INFO_RECONNECTED = 3;
    public static final int STATE_LIVE_CODE_INFO_RTMP_CONNECT = 4;
    public static final int STATE_LIVE_CODE_INFO_STARTED = 2;
    public static final int STATE_LIVE_CODE_INFO_STARTING = 1;
    public static final int STATE_LIVE_CODE_INFO_STOP = 5;
    public static final int STATE_LIVE_CODE_INFO_TOGGLE_CAMERA = 8;
    public static final int STATE_PUSH_STREAM_END = 5;
    public static final int STATE_PUSH_STREAM_ERROR = 6;
    public static final int STATE_PUSH_STREAM_RECONNECT = 3;
    public static final int STATE_PUSH_STREAM_RECONNECTED = 4;
    public static final int STATE_PUSH_STREAM_RTMP_CONNECT = 8;
    public static final int STATE_PUSH_STREAM_STARTED = 2;
    public static final int STATE_PUSH_STREAM_STARTING = 1;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f59057a = null;

        public a() {
        }

        static {
            f59057a = new a();
        }
    }

    static {
        Companion = a.f59057a;
    }
}
