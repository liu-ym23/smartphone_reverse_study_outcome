package com.bytedance.android.livesdkapi.depend.model.live.pay;

import am3.g;
import com.bytedance.android.ec.core.event.a;
import com.bytedance.android.live.base.annotation.ForMain;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import vh7.h;

/* JADX INFO: loaded from: classes12.dex */
@ForMain
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0005\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0007\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\b\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\n\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\f\u001a\u00020\r8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u000f\u001a\u00020\r8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0012\u001a\u00020\r8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/pay/LiveInfo;", "", "()V", "anchorSignTagContent", "", "delivery", "", "episodeStage", "isReplay", "", "liveStatus", "replayIdStr", "roomId", "", "roomIdStr", "roomStartTime", "title", "vid", "viewRight", "vs-model_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveInfo implements h {

    @SerializedName("anchor_sign_tag_content")
    public String anchorSignTagContent;

    @SerializedName("delivery")
    public int delivery;

    @SerializedName("episode_stage")
    public int episodeStage;

    @SerializedName(a.KEY_IS_REPLAY)
    public boolean isReplay;

    @SerializedName("live_status")
    public int liveStatus;

    @SerializedName("replay_id_str")
    public String replayIdStr;

    @SerializedName("room_id")
    public long roomId;

    @SerializedName("room_id_str")
    public String roomIdStr;

    @SerializedName("room_start_time")
    public long roomStartTime;

    @SerializedName("title")
    public String title;

    @SerializedName("vid")
    public String vid;

    @SerializedName("view_right")
    public long viewRight;

    public LiveInfo() {
    }

    public LiveInfo(g r100) {
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L19;
        switch(r102) {
            case 1: goto L18;
            case 2: goto L17;
            case 3: goto L16;
            case 4: goto L15;
            case 5: goto L14;
            case 6: goto L13;
            case 7: goto L12;
            case 8: goto L11;
            case 9: goto L10;
            case 10: goto L9;
            case 11: goto L8;
            case 12: goto L7;
            default: goto L6;
        };
    L7:
        this.roomIdStr = am3.h.c(r100);
        goto L3
    L8:
        this.anchorSignTagContent = am3.h.c(r100);
        goto L3
    L9:
        this.viewRight = r100.j();
        goto L3
    L10:
        this.delivery = r100.i();
        goto L3
    L11:
        this.isReplay = am3.h.a(r100);
        goto L3
    L12:
        this.replayIdStr = am3.h.c(r100);
        goto L3
    L13:
        this.vid = am3.h.c(r100);
        goto L3
    L14:
        this.liveStatus = r100.i();
        goto L3
    L15:
        this.roomStartTime = r100.j();
        goto L3
    L16:
        this.episodeStage = r100.i();
        goto L3
    L17:
        this.title = am3.h.c(r100);
        goto L3
    L18:
        this.roomId = r100.j();
        goto L3
    L6:
        am3.h.e(r100);
        goto L3
    L19:
        r100.d(r101);
    }
}
