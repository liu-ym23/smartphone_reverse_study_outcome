package com.byted.cast.sdk;

import com.byted.cast.sdk.utils.JsonFormatter;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes43.dex */
public class RTCStatistics {
    public List<AudioRxStatistics> arx;
    public List<AudioTxStatistics> atx;

    /* JADX INFO: renamed from: cx, reason: collision with root package name */
    public List<CodecStatistics> f33734cx;

    /* JADX INFO: renamed from: nx, reason: collision with root package name */
    public List<NetworkStatistics> f33735nx;
    public List<VideoRxStatistics> vrx;
    public List<VideoTxStatistics> vtx;

    public static class AudioRxStatistics {
        public int bitrate;
        public long firstPacketTime;
        public long firstRenderTime;
        public int kind;
        public int loss;
        public long totalBytes;
        public String userId;

        public AudioRxStatistics() {
        }
    }

    public static class AudioTxStatistics {
        public int bitrate;
        public int kind;
        public long totalBytes;

        public AudioTxStatistics() {
        }
    }

    public static class CodecStatistics {
        public String userId;
        public int videoDecodeElapse;
        public int videoEncodeElapse;

        public CodecStatistics() {
        }
    }

    public static class NetworkStatistics {
        public int loss;
        public int rtt;
        public String userId;
        public int videoRtt;

        public NetworkStatistics() {
        }
    }

    public static class VideoRxStatistics {
        public int bitrate;
        public long firstFrameTime;
        public long firstPacketTime;
        public long firstRenderTime;
        public int fps;
        public int height;
        public int kind;
        public int loss;
        public long totalBytes;
        public String userId;
        public int width;

        public VideoRxStatistics() {
        }
    }

    public static class VideoTxStatistics {
        public int bitrate;
        public int fps;
        public int height;
        public int kind;
        public long totalBytes;
        public int width;

        public VideoTxStatistics() {
        }
    }

    public long getTotalRxBytes() {
        Iterator<AudioRxStatistics> r100 = this.arx.iterator();
        long r101 = 0;
    L4:
        if (r100.hasNext() == false) goto L6;
        r101 = r101 + r100.next().totalBytes;
        goto L4
    L6:
        Iterator<VideoRxStatistics> r102 = this.vrx.iterator();
    L8:
        if (r102.hasNext() == false) goto L10;
        r101 = r101 + r102.next().totalBytes;
        goto L8
    L10:
        return r101;
    }

    public long getTotalTxBytes() {
        Iterator<AudioTxStatistics> r100 = this.atx.iterator();
        long r101 = 0;
    L4:
        if (r100.hasNext() == false) goto L6;
        r101 = r101 + r100.next().totalBytes;
        goto L4
    L6:
        Iterator<VideoTxStatistics> r102 = this.vtx.iterator();
    L8:
        if (r102.hasNext() == false) goto L10;
        r101 = r101 + r102.next().totalBytes;
        goto L8
    L10:
        return r101;
    }

    public String toString() {
        return GsonProtectorUtils.toJson(new Gson(), this);
    }

    public RTCStatistics() {
        this.f33735nx = new ArrayList();
        this.f33734cx = new ArrayList();
        this.atx = new ArrayList();
        this.vtx = new ArrayList();
        this.arx = new ArrayList();
        this.vrx = new ArrayList();
    }

    public static RTCStatistics fromJson(String r100) {
        return (RTCStatistics) JsonFormatter.fromJson(r100, RTCStatistics.class);
    }
}
