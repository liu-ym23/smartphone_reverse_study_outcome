package com.byted.cast.common.sink;

import android.os.Parcel;
import com.byted.cast.common.bean.MediaAssetBean;

/* JADX INFO: loaded from: classes39.dex */
public class CastInfo {
    public static final int CASTTYPE_MIRROR = 2;
    public static final int CASTTYPE_URL = 1;
    public static final int STOP_BY_SERVER = 104;
    public static final int STOP_ERROR = 3;
    public static final int STOP_NORMAL = 1;
    public static final int STOP_PREEMPTED = 101;
    public static final int STOP_REMOTE_CONTROL = 102;
    public static final int STOP_TIMEOUT = 2;
    public static final int STOP_USER_EXIT = 103;
    public static final int TYPE_CAST = 101;
    public static final int TYPE_CAST_PAUSE = 104;
    public static final int TYPE_CAST_RESUME = 105;
    public static final int TYPE_CAST_SUCCESS = 108;
    public static final int TYPE_CONNECT = 105;
    public static final int TYPE_DISCONNECT = 106;
    public static final int TYPE_PAUSED = 107;
    public static final int TYPE_SIZE_CHANGED = 103;
    public static final int TYPE_START = 100;
    public static final int TYPE_STOP = 102;
    public String aesIV;
    public String aesKey;
    public int audioSessionId;
    public int castType;
    public String clientID;
    public ClientInfo clientInfo;
    public String connectID;
    public String danmaku;
    public String extra;
    public boolean handleInside;
    public String header;
    public int infoType;
    public String key;
    public String localPath;
    public String loopMode;
    public String mediaAlbum;
    public String mediaAlbumUrl;
    public String mediaArtist;
    public MediaAssetBean mediaAssetBean;
    public String mediaTitle;
    public int mimeType;
    public int protocol;
    public SizeInfo sizeInfo;
    public int sourceDeviceType;
    public String speed;
    public StartInfo startInfo;
    public long startPosition;
    public StopInfo stopInfo;
    public String url;

    public static class SizeInfo {
        public int height;
        public int width;

        public String toString() {
            return "SizeInfo{width=" + this.width + ", height=" + this.height + '}';
        }

        public SizeInfo() {
        }

        public SizeInfo(Parcel r100) {
            this.width = r100.readInt();
            this.height = r100.readInt();
        }
    }

    public static class StartInfo {
        public int bitRate;
        public int frameRate;
        public int height;
        public long startTime;
        public int type;
        public int width;

        public String toString() {
            return "StartInfo{width=" + this.width + ", height=" + this.height + ", frameRate=" + this.frameRate + ", bitRate=" + this.bitRate + ", type=" + this.type + ", startTime=" + this.startTime + '}';
        }

        public StartInfo() {
        }

        public StartInfo(Parcel r100) {
            this.width = r100.readInt();
            this.height = r100.readInt();
            this.frameRate = r100.readInt();
            this.bitRate = r100.readInt();
            this.type = r100.readInt();
            this.startTime = r100.readLong();
        }

        public StartInfo(long r100) {
            this.startTime = r100;
        }
    }

    public static class StopInfo {
        public int stopDetail;
        public int stopReason;
        public long stopTime;

        public String toString() {
            return "StopInfo{stopReason=" + this.stopReason + ", stopDetail=" + this.stopDetail + ", stopTime=" + this.stopTime + '}';
        }

        public StopInfo() {
        }

        public StopInfo(Parcel r100) {
            this.stopReason = r100.readInt();
            this.stopDetail = r100.readInt();
            this.stopTime = r100.readLong();
        }

        public StopInfo(int r100, int r101) {
            this.stopReason = r100;
            this.stopDetail = r101;
        }
    }

    public String toString() {
        return "CastInfo{key='" + this.key + "', url='" + this.url + "', castType=" + this.castType + ", protocol=" + this.protocol + ", mimeType=" + this.mimeType + ", handleInside=" + this.handleInside + ", startPosition=" + this.startPosition + ", clientID='" + this.clientID + "', connectID='" + this.connectID + "', mediaTitle='" + this.mediaTitle + "', mediaArtist='" + this.mediaArtist + "', mediaAlbum='" + this.mediaAlbum + "', mediaAlbumUrl='" + this.mediaAlbumUrl + "', mediaAssetBean=" + this.mediaAssetBean + ", audioSessionId=" + this.audioSessionId + ", infoType=" + this.infoType + ", sourceDeviceType=" + this.sourceDeviceType + ", header='" + this.header + "', aesKey='" + this.aesKey + "', aesIV='" + this.aesIV + "', startInfo=" + this.startInfo + ", stopInfo=" + this.stopInfo + ", sizeInfo=" + this.sizeInfo + ", clientInfo=" + this.clientInfo + '}';
    }

    public CastInfo() {
        this.handleInside = true;
        this.sourceDeviceType = -1;
    }

    public CastInfo(Parcel r100) {
        boolean r101 = true;
        this.handleInside = true;
        this.sourceDeviceType = -1;
        this.key = r100.readString();
        this.url = r100.readString();
        this.castType = r100.readInt();
        this.protocol = r100.readInt();
        this.mimeType = r100.readInt();
        if (r100.readByte() != 0) goto L6;
        r101 = false;
    L6:
        this.handleInside = r101;
        this.startPosition = r100.readLong();
        this.clientID = r100.readString();
        this.connectID = r100.readString();
        this.mediaTitle = r100.readString();
        this.mediaArtist = r100.readString();
        this.mediaAlbum = r100.readString();
        this.mediaAlbumUrl = r100.readString();
        this.mediaAssetBean = (MediaAssetBean) r100.readParcelable(MediaAssetBean.class.getClassLoader());
        this.audioSessionId = r100.readInt();
        this.infoType = r100.readInt();
        this.sourceDeviceType = r100.readInt();
        this.header = r100.readString();
        this.aesKey = r100.readString();
        this.aesIV = r100.readString();
        this.startInfo = (StartInfo) r100.readParcelable(StartInfo.class.getClassLoader());
        this.stopInfo = (StopInfo) r100.readParcelable(StopInfo.class.getClassLoader());
        this.sizeInfo = (SizeInfo) r100.readParcelable(SizeInfo.class.getClassLoader());
    }

    public CastInfo(CastInfo r100) {
        this.handleInside = true;
        this.sourceDeviceType = -1;
        this.key = r100.key;
        this.url = r100.url;
        this.castType = r100.castType;
        this.protocol = r100.protocol;
        this.mimeType = r100.mimeType;
        this.handleInside = r100.handleInside;
        this.mediaAssetBean = r100.mediaAssetBean;
        this.startPosition = r100.startPosition;
        this.clientID = r100.clientID;
        this.mediaTitle = r100.mediaTitle;
        this.mediaArtist = r100.mediaArtist;
        this.mediaAlbum = r100.mediaAlbum;
        this.mediaAlbumUrl = r100.mediaAlbumUrl;
        this.audioSessionId = r100.audioSessionId;
        this.infoType = r100.infoType;
        this.sourceDeviceType = r100.sourceDeviceType;
        this.header = r100.header;
        this.aesKey = r100.aesKey;
        this.aesIV = r100.aesIV;
        this.speed = r100.speed;
        this.danmaku = r100.danmaku;
        this.localPath = r100.localPath;
        this.loopMode = r100.loopMode;
        this.extra = r100.extra;
    }
}
