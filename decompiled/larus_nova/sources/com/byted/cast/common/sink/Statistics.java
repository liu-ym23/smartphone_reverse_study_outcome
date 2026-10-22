package com.byted.cast.common.sink;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes39.dex */
public class Statistics {
    public List<AudioRxStatistics> arx;

    /* JADX INFO: renamed from: cx, reason: collision with root package name */
    public List<CodecStatistics> f33717cx;

    /* JADX INFO: renamed from: nx, reason: collision with root package name */
    public List<NetworkStatistics> f33718nx;
    public List<VideoRxStatistics> vrx;

    public static class AudioRxStatistics {
        public String ClientId;
        public float bitrate;
        public float lossRate;
        public long totalBytes;

        public AudioRxStatistics() {
        }

        public String toString() {
            return "AudioRxStatistics{ClientId='" + this.ClientId + "', bitrate=" + this.bitrate + ", lossRate=" + this.lossRate + ", totalBytes=" + this.totalBytes + '}';
        }
    }

    public static class CodecStatistics {
        public String ClientId;
        public float videoDecodeElapse;

        public CodecStatistics() {
        }

        public String toString() {
            return "CodecStatistics{ClientId='" + this.ClientId + "', videoDecodeElapse=" + this.videoDecodeElapse + '}';
        }
    }

    public static class NetworkStatistics {
        public String ClientId;
        public float lossRate;
        public int rtt;

        public NetworkStatistics() {
        }

        public String toString() {
            return "NetworkStatistics{ClientId='" + this.ClientId + "', rtt=" + this.rtt + ", lossRate=" + this.lossRate + '}';
        }
    }

    public static class VideoRxStatistics {
        public String ClientId;
        public float bitrate;
        public float fps;
        public int height;
        public float lossRate;
        public long totalBytes;
        public int width;

        public VideoRxStatistics() {
        }

        public String toString() {
            return "VideoRxStatistics{ClientId='" + this.ClientId + "', width=" + this.width + ", height=" + this.height + ", fps=" + this.fps + ", bitrate=" + this.bitrate + ", lossRate=" + this.lossRate + ", totalBytes=" + this.totalBytes + '}';
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

    public String toString() {
        return "Statistics{nx=" + this.f33718nx + ", cx=" + this.f33717cx + ", arx=" + this.arx + ", vrx=" + this.vrx + '}';
    }

    public Statistics() {
        this.f33718nx = new ArrayList();
        this.f33717cx = new ArrayList();
        this.arx = new ArrayList();
        this.vrx = new ArrayList();
    }
}
