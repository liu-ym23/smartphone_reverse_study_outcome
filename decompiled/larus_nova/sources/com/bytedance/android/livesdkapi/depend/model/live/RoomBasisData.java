package com.bytedance.android.livesdkapi.depend.model.live;

import am3.g;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import vh7.h;

/* JADX INFO: loaded from: classes12.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\t\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003R\"\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0016@\u0016X\u0097\u000e¢\u0006\u0010\n\u0002\u0010\t\u001a\u0004\b\u0004\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\n\u001a\u0004\u0018\u00010\u000b8\u0016@\u0016X\u0097\u000e¢\u0006\u0010\n\u0002\u0010\u0010\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0011\u001a\u0004\u0018\u00010\u000b8\u0016@\u0016X\u0097\u000e¢\u0006\u0010\n\u0002\u0010\u0010\u001a\u0004\b\u0012\u0010\r\"\u0004\b\u0013\u0010\u000f¨\u0006\u0014"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/RoomBasisData;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdkapi/depend/model/live/IRoomBasisData;", "()V", "isCustomizeAudioRoom", "", "()Ljava/lang/Boolean;", "setCustomizeAudioRoom", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "needRequestLuckybox", "", "getNeedRequestLuckybox", "()Ljava/lang/Long;", "setNeedRequestLuckybox", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "nextPing", "getNextPing", "setNextPing", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class RoomBasisData extends FlexModelBase<IRoomBasisData> implements IRoomBasisData, h {

    @SerializedName("is_customize_audio_room")
    protected Boolean isCustomizeAudioRoom;

    @SerializedName("need_request_luckybox")
    protected Long needRequestLuckybox;

    @SerializedName("next_ping")
    protected Long nextPing;

    public RoomBasisData() {
        super(IRoomBasisData.class);
        this.nextPing = 0L;
        this.isCustomizeAudioRoom = Boolean.FALSE;
        this.needRequestLuckybox = 0L;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IRoomBasisData
    public Long getNeedRequestLuckybox() {
        return this.needRequestLuckybox;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IRoomBasisData
    public Long getNextPing() {
        return this.nextPing;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IRoomBasisData
    public Boolean isCustomizeAudioRoom() {
        return this.isCustomizeAudioRoom;
    }

    public RoomBasisData(g r100) {
        super(IRoomBasisData.class);
        setThreadSafe(false);
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L15;
        g.a r103 = decodeExtensionFields(r102, r100);
        if (r102 != 1) goto L8;
        this.nextPing = Long.valueOf(r100.j());
        goto L3
    L8:
        if (r102 != 2) goto L10;
        this.isCustomizeAudioRoom = Boolean.valueOf(am3.h.a(r100));
        goto L3
    L10:
        if (r102 != 3) goto L11;
        this.needRequestLuckybox = Long.valueOf(r100.j());
        goto L3
    L11:
        am3.h.d(r103, r100);
        goto L3
    L15:
        r100.d(r101);
        setThreadSafe(true);
        if (this.nextPing != null) goto L19;
        this.nextPing = 0L;
    L19:
        if (this.isCustomizeAudioRoom != null) goto L22;
        this.isCustomizeAudioRoom = Boolean.FALSE;
    L22:
        if (this.needRequestLuckybox != null) goto L37;
        this.needRequestLuckybox = 0L;
        return;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IRoomBasisData
    public void setCustomizeAudioRoom(Boolean r100) {
        this.isCustomizeAudioRoom = r100;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IRoomBasisData
    public void setNeedRequestLuckybox(Long r100) {
        this.needRequestLuckybox = r100;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IRoomBasisData
    public void setNextPing(Long r100) {
        this.nextPing = r100;
    }
}
