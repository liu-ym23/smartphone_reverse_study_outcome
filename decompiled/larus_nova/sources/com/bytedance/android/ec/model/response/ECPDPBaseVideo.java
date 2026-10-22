package com.bytedance.android.ec.model.response;

import com.bytedance.android.ec.model.video.ECBaseVideo;
import com.bytedance.android.livesdkapi.performance.ILoadStallMonitor;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 \"2\u00020\u0001:\u0001#B\u0007¢\u0006\u0004\b \u0010!R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0010\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u0010\u0010\r\"\u0004\b\u0011\u0010\u000fR$\u0010\u0013\u001a\u0004\u0018\u00010\u00128\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R$\u0010\u001a\u001a\u0004\u0018\u00010\u00198\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001f¨\u0006$"}, d2 = {"Lcom/bytedance/android/ec/model/response/ECPDPBaseVideo;", "Lcom/bytedance/android/ec/model/video/ECBaseVideo;", "", "initialStartTimeMs", "J", "getInitialStartTimeMs", "()J", "setInitialStartTimeMs", "(J)V", "", "autoPlay", "Z", "getAutoPlay", "()Z", "setAutoPlay", "(Z)V", "isMute", "setMute", "", "itemId", "Ljava/lang/String;", "getItemId", "()Ljava/lang/String;", "setItemId", "(Ljava/lang/String;)V", "Lcom/bytedance/android/ec/model/response/u1;", "extraInfo", "Lcom/bytedance/android/ec/model/response/u1;", "getExtraInfo", "()Lcom/bytedance/android/ec/model/response/u1;", "setExtraInfo", "(Lcom/bytedance/android/ec/model/response/u1;)V", "<init>", "()V", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ec-model_release"}, k = 1, mv = {1, 4, 3})
public final class ECPDPBaseVideo extends ECBaseVideo {
    public static final a Companion = null;
    private static final long serialVersionUID = -12;

    @SerializedName("auto_play")
    private boolean autoPlay;

    @SerializedName("extra_info")
    private u1 extraInfo;

    @SerializedName(ILoadStallMonitor.START_TIME)
    private long initialStartTimeMs;

    @SerializedName("is_mute")
    private boolean isMute;

    @SerializedName("item_id")
    private String itemId;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public ECPDPBaseVideo() {
        this.isMute = true;
    }

    public final boolean getAutoPlay() {
        return this.autoPlay;
    }

    public final u1 getExtraInfo() {
        return this.extraInfo;
    }

    public final long getInitialStartTimeMs() {
        return this.initialStartTimeMs;
    }

    public final String getItemId() {
        return this.itemId;
    }

    public final boolean isMute() {
        return this.isMute;
    }

    public final void setAutoPlay(boolean r100) {
        this.autoPlay = r100;
    }

    public final void setExtraInfo(u1 r100) {
        this.extraInfo = r100;
    }

    public final void setInitialStartTimeMs(long r100) {
        this.initialStartTimeMs = r100;
    }

    public final void setItemId(String r100) {
        this.itemId = r100;
    }

    public final void setMute(boolean r100) {
        this.isMute = r100;
    }
}
