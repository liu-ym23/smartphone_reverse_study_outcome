package com.bytedance.android.livesdkapi.depend.message;

import am3.g;
import com.bytedance.android.ec.core.event.a;
import com.bytedance.android.livesdk.message.model.KtvMusic;
import com.bytedance.android.livesdk.message.model.fd;
import com.bytedance.android.livesdk.message.model.od;
import com.google.gson.annotations.SerializedName;
import com.ss.texturerender.VideoSurfaceTexture;
import com.tencent.qqmusic.third.api.contract.Keys;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import vh7.h;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\b\u0007\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u0007¢\u0006\u0004\b\u0015\u0010\u0016R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007R$\u0010\t\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u00128\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014¨\u0006\u0018"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/message/KtvStreamSingSyncData;", "", "Lcom/bytedance/android/livesdk/message/model/KtvMusic;", "songInfo", "Lcom/bytedance/android/livesdk/message/model/KtvMusic;", "Lcom/bytedance/android/livesdk/message/model/fd;", "videoInfo", "Lcom/bytedance/android/livesdk/message/model/fd;", "Lcom/bytedance/android/livesdk/message/model/od;", "mvInfo", "Lcom/bytedance/android/livesdk/message/model/od;", "getMvInfo", "()Lcom/bytedance/android/livesdk/message/model/od;", "setMvInfo", "(Lcom/bytedance/android/livesdk/message/model/od;)V", "", VideoSurfaceTexture.KEY_TIME, "Ljava/lang/Long;", "", "action", "Ljava/lang/Integer;", "<init>", "()V", "Companion", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class KtvStreamSingSyncData implements h {
    public static final Companion Companion = null;
    public static final String SYNC_KEY = "KtvStreamSingSyncData";

    @SerializedName("action")
    public Integer action;

    @SerializedName("mv_info")
    protected od mvInfo;

    @SerializedName(Keys.API_EVENT_KEY_SONG)
    public KtvMusic songInfo;

    @SerializedName("time_stamp")
    public Long timeStamp;

    @SerializedName(a.KEY_VIDEO_INFO)
    public fd videoInfo;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/message/KtvStreamSingSyncData$Companion;", "", "()V", "SYNC_KEY", "", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }
    }

    static {
        Companion = new Companion(null);
    }

    public KtvStreamSingSyncData() {
        this.action = Integer.valueOf(Action.ACTION_START.getValue());
    }

    public final od getMvInfo() {
        return this.mvInfo;
    }

    public KtvStreamSingSyncData(g r100) {
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L21;
        if (r102 != 1) goto L8;
        this.songInfo = new KtvMusic(r100);
        goto L3
    L8:
        if (r102 != 2) goto L10;
        this.videoInfo = new fd(r100);
        goto L3
    L10:
        if (r102 != 3) goto L12;
        this.timeStamp = Long.valueOf(r100.j());
        goto L3
    L12:
        if (r102 != 4) goto L14;
        this.action = Integer.valueOf(r100.i());
        goto L3
    L14:
        if (r102 != 5) goto L15;
        this.mvInfo = new od(r100);
        goto L3
    L15:
        am3.h.e(r100);
        goto L3
    L21:
        r100.d(r101);
        if (this.action != null) goto L43;
        this.action = Integer.valueOf(Action.ACTION_START.getValue());
        return;
    }

    public final void setMvInfo(od r100) {
        this.mvInfo = r100;
    }
}
