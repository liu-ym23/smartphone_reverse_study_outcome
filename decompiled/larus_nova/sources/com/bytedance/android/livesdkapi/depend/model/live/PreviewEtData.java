package com.bytedance.android.livesdkapi.depend.model.live;

import am3.g;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import vh7.h;

/* JADX INFO: loaded from: classes12.dex */
@ProtoMessage("webcast.data.PreviewExposeData.EtData")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0014\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003R \u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR \u0010\n\u001a\u0004\u0018\u00010\u00058\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR \u0010\r\u001a\u0004\u0018\u00010\u00058\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u0007\"\u0004\b\u000f\u0010\tR \u0010\u0010\u001a\u0004\u0018\u00010\u00058\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0007\"\u0004\b\u0012\u0010\tR \u0010\u0013\u001a\u0004\u0018\u00010\u00058\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0007\"\u0004\b\u0015\u0010\tR \u0010\u0016\u001a\u0004\u0018\u00010\u00058\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0007\"\u0004\b\u0018\u0010\t¨\u0006\u0019"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/PreviewEtData;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdkapi/depend/model/live/IPreviewEtData;", "()V", "enterRoom", "", "getEnterRoom", "()Ljava/lang/String;", "setEnterRoom", "(Ljava/lang/String;)V", "firstRoomMobParams", "getFirstRoomMobParams", "setFirstRoomMobParams", "firstRoomParams", "getFirstRoomParams", "setFirstRoomParams", "firstShowRoomParams", "getFirstShowRoomParams", "setFirstShowRoomParams", "mobParams", "getMobParams", "setMobParams", "params", "getParams", "setParams", "livebase-model_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PreviewEtData extends FlexModelBase<IPreviewEtData> implements IPreviewEtData, h {

    @SerializedName("type_enter_room")
    protected String enterRoom;

    @SerializedName("type_first_room_mob_params")
    protected String firstRoomMobParams;

    @SerializedName("type_first_room_params")
    protected String firstRoomParams;

    @SerializedName("type_first_show_room_params")
    protected String firstShowRoomParams;

    @SerializedName("type_mob_params")
    protected String mobParams;

    @SerializedName("type_params")
    protected String params;

    public PreviewEtData() {
        super(IPreviewEtData.class);
    }

    public PreviewEtData(g r100) {
        super(IPreviewEtData.class);
        setThreadSafe(false);
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L14;
        g.a r103 = decodeExtensionFields(r102, r100);
        switch(r102) {
            case 1: goto L13;
            case 2: goto L12;
            case 3: goto L11;
            case 4: goto L10;
            case 5: goto L9;
            case 6: goto L8;
            default: goto L7;
        };
    L8:
        this.firstShowRoomParams = am3.h.c(r100);
        goto L3
    L9:
        this.firstRoomMobParams = am3.h.c(r100);
        goto L3
    L10:
        this.firstRoomParams = am3.h.c(r100);
        goto L3
    L11:
        this.params = am3.h.c(r100);
        goto L3
    L12:
        this.mobParams = am3.h.c(r100);
        goto L3
    L13:
        this.enterRoom = am3.h.c(r100);
        goto L3
    L7:
        am3.h.d(r103, r100);
        goto L3
    L14:
        r100.d(r101);
        setThreadSafe(true);
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IPreviewEtData
    public String getEnterRoom() {
        return this.enterRoom;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IPreviewEtData
    public String getFirstRoomMobParams() {
        return this.firstRoomMobParams;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IPreviewEtData
    public String getFirstRoomParams() {
        return this.firstRoomParams;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IPreviewEtData
    public String getFirstShowRoomParams() {
        return this.firstShowRoomParams;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IPreviewEtData
    public String getMobParams() {
        return this.mobParams;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IPreviewEtData
    public String getParams() {
        return this.params;
    }

    public void setEnterRoom(String r100) {
        this.enterRoom = r100;
    }

    public void setFirstRoomMobParams(String r100) {
        this.firstRoomMobParams = r100;
    }

    public void setFirstRoomParams(String r100) {
        this.firstRoomParams = r100;
    }

    public void setFirstShowRoomParams(String r100) {
        this.firstShowRoomParams = r100;
    }

    public void setMobParams(String r100) {
        this.mobParams = r100;
    }

    public void setParams(String r100) {
        this.params = r100;
    }
}
