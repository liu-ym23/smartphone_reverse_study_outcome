package com.byted.cast.common.source;

/* JADX INFO: loaded from: classes39.dex */
public class Statistics {
    public AudioTxStatistics atx;

    /* JADX INFO: renamed from: cx, reason: collision with root package name */
    public CodecStatistics f33720cx;

    /* JADX INFO: renamed from: nx, reason: collision with root package name */
    public NetworkStatistics f33721nx;
    public VideoTxStatistics vtx;

    public static class AudioTxStatistics {
        public float bitrate;
        public long totalBytes;

        public AudioTxStatistics() {
        }

        public String toString() {
            return "AudioTxStatistics{, bitrate=" + this.bitrate + ", totalBytes=" + this.totalBytes + '}';
        }
    }

    public static class CodecStatistics {
        public float videoEncodeElapse;

        public CodecStatistics() {
        }

        public String toString() {
            return "CodecStatistics{, videoEncodeElapse=" + this.videoEncodeElapse + '}';
        }
    }

    public static class NetworkStatistics {
        public float lossRate;
        public int rtt;

        public NetworkStatistics() {
        }

        public String toString() {
            return "NetworkStatistics{, rtt=" + this.rtt + ", lossRate=" + this.lossRate + '}';
        }
    }

    public static class VideoTxStatistics {
        public float bitrate;
        public float fps;
        public int height;
        public long totalBytes;
        public int width;

        public VideoTxStatistics() {
        }

        public String toString() {
            return "VideoTxStatistics{, width=" + this.width + ", height=" + this.height + ", fps=" + this.fps + ", bitrate=" + this.bitrate + ", totalBytes=" + this.totalBytes + '}';
        }
    }

    public String toString() {
        return "Statistics{nx=" + this.f33721nx + ", cx=" + this.f33720cx + ", atx=" + this.atx + ", vtx=" + this.vtx + '}';
    }

    public Statistics() {
        this.f33721nx = new NetworkStatistics();
        this.f33720cx = new CodecStatistics();
        this.atx = new AudioTxStatistics();
        this.vtx = new VideoTxStatistics();
    }
}
