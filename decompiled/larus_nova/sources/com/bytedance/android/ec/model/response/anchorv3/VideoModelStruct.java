package com.bytedance.android.ec.model.response.anchorv3;

import com.bytedance.android.ec.model.response.ECPDPBaseVideo;
import com.bytedance.android.livesdkapi.performance.ILoadStallMonitor;
import com.google.gson.annotations.SerializedName;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import java.io.Serializable;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0016\u0010\u0007\u001a\u00020\b8\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0016\u0010\u000b\u001a\u00020\b8\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u001e\u0010\r\u001a\u00020\b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\n\"\u0004\b\u000f\u0010\u0010R\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0006R\u0016\u0010\u0013\u001a\u00020\b8\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\nR\u0018\u0010\u0015\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0006R\u0018\u0010\u0017\u001a\u0004\u0018\u00010\u00188\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001b\u001a\u00020\b8\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\n¨\u0006\u001d"}, d2 = {"Lcom/bytedance/android/ec/model/response/anchorv3/VideoModelStruct;", "Ljava/io/Serializable;", "()V", "backupUrl", "", "getBackupUrl", "()Ljava/lang/String;", "duration", "", "getDuration", "()J", "height", "getHeight", "initialStartTimeMs", "getInitialStartTimeMs", "setInitialStartTimeMs", "(J)V", "mainUrl", "getMainUrl", "urlExpire", "getUrlExpire", "vid", "getVid", "videoV2", "Lcom/bytedance/android/ec/model/response/ECPDPBaseVideo;", "getVideoV2", "()Lcom/bytedance/android/ec/model/response/ECPDPBaseVideo;", "width", "getWidth", "ec-model_release"}, k = 1, mv = {1, 4, 3})
public final class VideoModelStruct implements Serializable {

    @SerializedName(MonitorConstants.EXTRA_DOWNLOAD_BACKUP_URL)
    private final String backupUrl;

    @SerializedName("duration")
    private final long duration;

    @SerializedName("height")
    private final long height;

    @SerializedName(ILoadStallMonitor.START_TIME)
    private long initialStartTimeMs;

    @SerializedName("main_url")
    private final String mainUrl;

    @SerializedName("url_expire")
    private final long urlExpire;

    @SerializedName("vid")
    private final String vid;

    @SerializedName("play_opt_model")
    private final ECPDPBaseVideo videoV2;

    @SerializedName("width")
    private final long width;

    public VideoModelStruct() {
        this.width = 230;
        this.height = 130;
    }

    public final String getBackupUrl() {
        return this.backupUrl;
    }

    public final long getDuration() {
        return this.duration;
    }

    public final long getHeight() {
        return this.height;
    }

    public final long getInitialStartTimeMs() {
        return this.initialStartTimeMs;
    }

    public final String getMainUrl() {
        return this.mainUrl;
    }

    public final long getUrlExpire() {
        return this.urlExpire;
    }

    public final String getVid() {
        return this.vid;
    }

    public final ECPDPBaseVideo getVideoV2() {
        return this.videoV2;
    }

    public final long getWidth() {
        return this.width;
    }

    public final void setInitialStartTimeMs(long r100) {
        this.initialStartTimeMs = r100;
    }
}
