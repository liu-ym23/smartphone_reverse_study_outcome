package com.byted.cast.proxy;

import android.content.Context;

/* JADX INFO: loaded from: classes39.dex */
public class Event {
    public static final String BYTECASTSDK_INDICATOR_CASTPROXY_START_DISCARD_PKT = "bytecastsdk_indicator_castproxy_start_discard_pkt";
    public static final String BYTECASTSDK_INDICATOR_CASTPROXY_STOP_DISCARD_PKT = "bytecastsdk_indicator_castproxy_stop_discard_pkt";
    public static final String BYTECASTSDK_INDICATOR_MEDIACODEC_ENCODE_ERROR = "bytecastsdk_indicator_mediacodec_encode_error";
    public static final String BYTECASTSDK_INDICATOR_RESIZE_FPS = "bytecastsdk_indicator_resize_fps";
    public static final String BYTECASTSDK_INDICATOR_RESIZE_INIT_MEDIACODEC = "bytecastsdk_indicator_resize_init_mediacodec";
    public static final String BYTECAST_CASTPROXY_DECODE_DATA = "bytecastsdk_indicator_decode_data";
    public static final String BYTECAST_CASTPROXY_PROXY_URL = "bytecastsdk_indicator_castproxy_proxy_url";
    public static final String BYTECAST_CASTPROXY_RECEIVE_URL = "bytecastsdk_indicator_receive_url";
    public static final String BYTECAST_CASTPROXY_RETURN_DATA = "bytecastsdk_indicator_return_data";
    public static final String BYTECAST_CASTPROXY_START = "bytecastsdk_indicator_castproxy_start";
    public static final String BYTECAST_CASTPROXY_STOP = "bytecastsdk_indicator_castproxy_stop";
    public static final String BYTECAST_INDICATOR_CASTPROXY_ERROR = "bytecastsdk_indicator_castproxy_error";
    public static final String BYTECAST_INDICATOR_FFMPEG_DATA = "bytecastsdk_indicator_ffmpeg_data";
    public static final String BYTECAST_INDICATOR_RESPONSE = "bytecastsdk_indicator_response";
    public static final String BYTECAST_INDICATOR_RESPONSE_OVER = "bytecastsdk_indicator_response_over";
    public static final String PLAY_PROTOCOL = "bytecastsdk_indicator_play_protocol";
    public String appId;
    public String castProtocol;
    public long costTime;
    public String packageName;
    public String proxyUrlType;
    public boolean success;
    public long timestamp;
    public String urlEncryptType;

    public String toString() {
        return "Event{appId='" + this.appId + "', packageName='" + this.packageName + "', timestamp=" + this.timestamp + ", costTime=" + this.costTime + ", success=" + this.success + ", proxyUrlType=" + this.proxyUrlType + ", urlEncryptType=" + this.urlEncryptType + ", castProtocol=" + this.castProtocol + '}';
    }

    public Event(Context r100, String r101) {
        this.castProtocol = "castproxy";
        this.appId = r101;
        this.packageName = r100.getPackageName();
        this.timestamp = System.currentTimeMillis();
    }

    public Event(Context r100, String r101, String r102, boolean r103) {
        this.castProtocol = "castproxy";
        this.appId = r101;
        this.packageName = r100.getPackageName();
        this.proxyUrlType = r102;
        this.timestamp = System.currentTimeMillis();
        if (r103 == false) goto L5;
        String r104 = "encrypted";
    L6:
        this.urlEncryptType = r104;
        return;
    L5:
        r104 = "unencrypted";
        goto L6
    }

    public Event(Context r100, String r101, long r102, boolean r103) {
        this.castProtocol = "castproxy";
        this.appId = r101;
        this.packageName = r100.getPackageName();
        this.timestamp = System.currentTimeMillis();
        this.costTime = r102;
        this.success = r103;
    }

    public Event(Context r100, String r101, long r102, String r103, boolean r104, boolean r105) {
        this.castProtocol = "castproxy";
        this.appId = r101;
        this.packageName = r100.getPackageName();
        this.timestamp = System.currentTimeMillis();
        this.costTime = r102;
        this.proxyUrlType = r103;
        this.success = r105;
        if (r104 == false) goto L5;
        String r106 = "encrypted";
    L6:
        this.urlEncryptType = r106;
        return;
    L5:
        r106 = "unencrypted";
        goto L6
    }
}
