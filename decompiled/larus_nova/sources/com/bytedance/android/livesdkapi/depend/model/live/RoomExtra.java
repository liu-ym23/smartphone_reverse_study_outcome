package com.bytedance.android.livesdkapi.depend.model.live;

import am3.g;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import vh7.f;
import vh7.h;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0010\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010#\u001a\u00020\fJ\u0006\u0010$\u001a\u00020\fJ\u0006\u0010%\u001a\u00020\fJ\u0006\u0010&\u001a\u00020\fJ\u0006\u0010'\u001a\u00020\fR\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0016\u0010\u0007\u001a\u00020\b8\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0016\u0010\u000b\u001a\u00020\f8\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\rR\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u000f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u00138\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0016\u0010\u0017\u001a\u00020\u00188\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001b\u001a\u00020\u00188\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001aR\u0016\u0010\u001d\u001a\u00020\f8\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\rR\u0016\u0010\u001f\u001a\u00020\b8\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b \u0010\nR\u0016\u0010!\u001a\u00020\u00188\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u001a¨\u0006("}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/RoomExtra;", "", "()V", "createScene", "", "getCreateScene", "()Ljava/lang/String;", "ecomLiveShopType", "", "getEcomLiveShopType", "()I", "isSandbox", "", "()Z", "payloadStartMicrogameStamp", "Lcom/bytedance/android/livesdkapi/depend/model/live/PayloadStartMicrogameStamp;", "getPayloadStartMicrogameStamp", "()Lcom/bytedance/android/livesdkapi/depend/model/live/PayloadStartMicrogameStamp;", "realTimePlaybackQualities", "", "Lcom/bytedance/android/livesdkapi/depend/model/live/IQuality;", "getRealTimePlaybackQualities", "()Ljava/util/List;", "realTimePlaybackShift", "", "getRealTimePlaybackShift", "()J", "realTimePlaybackShiftStart", "getRealTimePlaybackShiftStart", "realTimeReplayEnable", "getRealTimeReplayEnable", "vsType", "getVsType", "xiguaUid", "getXiguaUid", "isGroupLiveChorus", "isGroupLiveGame", "isGroupLiveScene", "isNewEcomRoom", "supportPlayBack", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class RoomExtra implements h {

    @SerializedName("create_scene")
    protected String createScene;

    @SerializedName("ecom_live_shop_v2")
    protected int ecomLiveShopType;

    @SerializedName("is_sandbox")
    protected boolean isSandbox;

    @SerializedName("payload_start_microgame_stamp")
    protected PayloadStartMicrogameStamp payloadStartMicrogameStamp;

    @SerializedName("realtime_playback_qualities")
    protected List<IQuality> realTimePlaybackQualities;

    @SerializedName("realtime_playback_shift")
    protected long realTimePlaybackShift;

    @SerializedName("realtime_playback_start_shift")
    protected long realTimePlaybackShiftStart;

    @SerializedName("realtime_replay_enabled")
    protected boolean realTimeReplayEnable;

    @SerializedName("vs_type")
    protected int vsType;

    @SerializedName("xigua_uid")
    protected long xiguaUid;

    public final boolean isGroupLiveChorus() {
        return Intrinsics.areEqual(this.createScene, "group_live_chorus");
    }

    public final boolean isGroupLiveGame() {
        return Intrinsics.areEqual(this.createScene, "group_live_game");
    }

    public final boolean isNewEcomRoom() {
        if (this.ecomLiveShopType == 1) goto L7;
        return false;
    L7:
        return true;
    }

    public final boolean supportPlayBack() {
        if (this.realTimeReplayEnable == true) goto L5;
    L7:
        return false;
    L5:
        if (this.realTimePlaybackQualities.isEmpty() == true) goto L7;
        return true;
    }

    public RoomExtra() {
        this.realTimePlaybackShiftStart = 10800;
        this.realTimePlaybackQualities = new ArrayList();
        this.createScene = "";
    }

    public final boolean isGroupLiveScene() {
        if (isGroupLiveGame() == false) goto L5;
    L8:
        return true;
    L5:
        if (isGroupLiveChorus() == true) goto L8;
        return false;
    }

    public final String getCreateScene() {
        return this.createScene;
    }

    public final int getEcomLiveShopType() {
        return this.ecomLiveShopType;
    }

    public final PayloadStartMicrogameStamp getPayloadStartMicrogameStamp() {
        return this.payloadStartMicrogameStamp;
    }

    public final List<IQuality> getRealTimePlaybackQualities() {
        return this.realTimePlaybackQualities;
    }

    public final long getRealTimePlaybackShift() {
        return this.realTimePlaybackShift;
    }

    public final long getRealTimePlaybackShiftStart() {
        return this.realTimePlaybackShiftStart;
    }

    public final boolean getRealTimeReplayEnable() {
        return this.realTimeReplayEnable;
    }

    public final int getVsType() {
        return this.vsType;
    }

    public final long getXiguaUid() {
        return this.xiguaUid;
    }

    public final boolean isSandbox() {
        return this.isSandbox;
    }

    public RoomExtra(g r100) {
        this.realTimePlaybackQualities = new ArrayList();
        long r101 = r100.c();
        boolean r102 = false;
    L3:
        int r103 = r100.f();
        if (r103 == (-1)) goto L26;
        if (r103 != 1) goto L7;
        this.isSandbox = am3.h.a(r100);
        goto L3
    L7:
        if (r103 != 5) goto L9;
        this.xiguaUid = r100.j();
        goto L3
    L9:
        if (r103 != 17) goto L11;
        this.vsType = (int) r100.j();
        goto L3
    L11:
        if (r103 != 21) goto L13;
        this.payloadStartMicrogameStamp = new PayloadStartMicrogameStamp(r100);
        goto L3
    L13:
        if (r103 != 23) goto L14;
        this.ecomLiveShopType = r100.i();
        goto L3
    L14:
        switch(r103) {
            case 11: goto L20;
            case 12: goto L19;
            case 13: goto L18;
            case 14: goto L17;
            case 15: goto L16;
            default: goto L15;
        };
    L16:
        this.realTimePlaybackQualities.add((IQuality) f.a(r100, IQuality.class));
        goto L3
    L17:
        this.realTimePlaybackShiftStart = r100.j();
        r102 = r102 | true;
        goto L3
    L18:
        this.realTimePlaybackShift = r100.j();
        goto L3
    L19:
        this.realTimeReplayEnable = am3.h.a(r100);
        goto L3
    L20:
        this.createScene = am3.h.c(r100);
        goto L3
    L15:
        am3.h.e(r100);
        goto L3
    L26:
        r100.d(r101);
        if ((r102 & true) == true) goto L30;
        this.realTimePlaybackShiftStart = 10800;
    L30:
        if (this.realTimePlaybackQualities.isEmpty() == false) goto L33;
        this.realTimePlaybackQualities = new ArrayList();
    L33:
        if (this.createScene != null) goto L65;
        this.createScene = "";
        return;
    }
}
