package com.bytedance.android.livesdk.chatroom.model;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes7.dex */
@ProtoMessage("webcast.api.linkmic.JoinChannelResponse.ResponseData")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\b\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\"\u0010#R$\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\"\u0010\u000b\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R$\u0010\u0012\u001a\u0004\u0018\u00010\u00118\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u0016\u0010\u001b\u001a\u0004\u0018\u00010\u00188VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001f\u001a\u00020\u001c8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001eR\u0016\u0010!\u001a\u0004\u0018\u00010\u00118VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b \u0010\u0015¨\u0006$"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/model/AnchorJoinChannelResult;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdk/link/model/bridge/f;", "Lcom/bytedance/android/livesdk/chatroom/model/MultiAnchorLinkmicRtcLiveCoreData;", "mRtcLiveCoreData", "Lcom/bytedance/android/livesdk/chatroom/model/MultiAnchorLinkmicRtcLiveCoreData;", "getMRtcLiveCoreData", "()Lcom/bytedance/android/livesdk/chatroom/model/MultiAnchorLinkmicRtcLiveCoreData;", "setMRtcLiveCoreData", "(Lcom/bytedance/android/livesdk/chatroom/model/MultiAnchorLinkmicRtcLiveCoreData;)V", "", "mMultiDefaultAnchorLayout", "J", "getMMultiDefaultAnchorLayout", "()J", "setMMultiDefaultAnchorLayout", "(J)V", "Lcom/bytedance/android/livesdk/link/model/bridge/h;", "mAnchorLayOutInfo", "Lcom/bytedance/android/livesdk/link/model/bridge/h;", "getMAnchorLayOutInfo", "()Lcom/bytedance/android/livesdk/link/model/bridge/h;", "setMAnchorLayOutInfo", "(Lcom/bytedance/android/livesdk/link/model/bridge/h;)V", "Lcom/bytedance/android/livesdk/link/model/bridge/q1;", "getRtcLiveCoreData", "()Lcom/bytedance/android/livesdk/link/model/bridge/q1;", "rtcLiveCoreData", "", "getMultiDefaultAnchorLayout", "()I", "multiDefaultAnchorLayout", "getAnchorLayOutInfo", "anchorLayOutInfo", "<init>", "()V", "livebase_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AnchorJoinChannelResult extends FlexModelBase<com.bytedance.android.livesdk.link.model.bridge.f> implements com.bytedance.android.livesdk.link.model.bridge.f, vh7.h {

    @SerializedName("layout_info")
    protected com.bytedance.android.livesdk.link.model.bridge.h mAnchorLayOutInfo;

    @SerializedName("anchor_ui_layout")
    protected long mMultiDefaultAnchorLayout;

    @SerializedName("rtc_live_core_data")
    protected MultiAnchorLinkmicRtcLiveCoreData mRtcLiveCoreData;

    public AnchorJoinChannelResult() {
        super(com.bytedance.android.livesdk.link.model.bridge.f.class);
    }

    @Override // com.bytedance.android.livesdk.link.model.bridge.f
    public int getMultiDefaultAnchorLayout() {
        return (int) this.mMultiDefaultAnchorLayout;
    }

    @Override // com.bytedance.android.livesdk.link.model.bridge.f
    public com.bytedance.android.livesdk.link.model.bridge.h getAnchorLayOutInfo() {
        return this.mAnchorLayOutInfo;
    }

    public final com.bytedance.android.livesdk.link.model.bridge.h getMAnchorLayOutInfo() {
        return this.mAnchorLayOutInfo;
    }

    public final long getMMultiDefaultAnchorLayout() {
        return this.mMultiDefaultAnchorLayout;
    }

    public final MultiAnchorLinkmicRtcLiveCoreData getMRtcLiveCoreData() {
        return this.mRtcLiveCoreData;
    }

    @Override // com.bytedance.android.livesdk.link.model.bridge.f
    public com.bytedance.android.livesdk.link.model.bridge.q1 getRtcLiveCoreData() {
        return this.mRtcLiveCoreData;
    }

    /* JADX WARN: Type inference failed for: r2v2, types: [com.bytedance.android.livesdk.link.model.bridge.h, java.lang.Object] */
    public AnchorJoinChannelResult(am3.g r100) {
        super(com.bytedance.android.livesdk.link.model.bridge.f.class);
        setThreadSafe(false);
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L15;
        am3.g.a r103 = decodeExtensionFields(r102, r100);
        if (r102 != 1) goto L8;
        this.mRtcLiveCoreData = new MultiAnchorLinkmicRtcLiveCoreData(r100);
        goto L3
    L8:
        if (r102 != 2) goto L10;
        this.mMultiDefaultAnchorLayout = r100.i();
        goto L3
    L10:
        if (r102 != 3) goto L11;
        this.mAnchorLayOutInfo = vh7.f.a(r100, com.bytedance.android.livesdk.link.model.bridge.h.class);
        goto L3
    L11:
        am3.h.d(r103, r100);
        goto L3
    L15:
        r100.d(r101);
        setThreadSafe(true);
    }

    public final void setMAnchorLayOutInfo(com.bytedance.android.livesdk.link.model.bridge.h r100) {
        this.mAnchorLayOutInfo = r100;
    }

    public final void setMMultiDefaultAnchorLayout(long r100) {
        this.mMultiDefaultAnchorLayout = r100;
    }

    public final void setMRtcLiveCoreData(MultiAnchorLinkmicRtcLiveCoreData r100) {
        this.mRtcLiveCoreData = r100;
    }
}
