package com.bytedance.android.livesdk.chatroom.model;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.tencent.qqmusic.third.api.contract.Keys;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes7.dex */
@ProtoMessage("webcast.data.EarlyInitRtcEnginelData")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000f\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0018\u0010\u0019J\b\u0010\u0004\u001a\u00020\u0003H\u0016R\"\u0010\u0006\u001a\u00020\u00058\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\u0006\u0010\b\"\u0004\b\t\u0010\nR$\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R$\u0010\u0012\u001a\u0004\u0018\u00010\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017¨\u0006\u001a"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/model/EarlyInitRtcInfo;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/live/liveinteract/plantform/model/g;", "", "toString", "", "isInWaiting", "Z", "()Z", "setInWaiting", "(Z)V", "Lcom/bytedance/android/livesdk/link/model/bridge/j1;", Keys.API_PARAM_KEY_MEDIA_INFO, "Lcom/bytedance/android/livesdk/link/model/bridge/j1;", "getMediaInfo", "()Lcom/bytedance/android/livesdk/link/model/bridge/j1;", "setMediaInfo", "(Lcom/bytedance/android/livesdk/link/model/bridge/j1;)V", "rtcAppId", "Ljava/lang/String;", "getRtcAppId", "()Ljava/lang/String;", "setRtcAppId", "(Ljava/lang/String;)V", "<init>", "()V", "liveutility_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class EarlyInitRtcInfo extends FlexModelBase<com.bytedance.android.live.liveinteract.plantform.model.g> implements com.bytedance.android.live.liveinteract.plantform.model.g, vh7.h {

    @SerializedName("is_in_waiting")
    protected boolean isInWaiting;

    @SerializedName("media_info")
    protected com.bytedance.android.livesdk.link.model.bridge.j1 mediaInfo;

    @SerializedName("oner_appid")
    protected String rtcAppId;

    public EarlyInitRtcInfo() {
        super(com.bytedance.android.live.liveinteract.plantform.model.g.class);
    }

    /* JADX WARN: Type inference failed for: r2v3, types: [com.bytedance.android.livesdk.link.model.bridge.j1, java.lang.Object] */
    public EarlyInitRtcInfo(am3.g r100) {
        super(com.bytedance.android.live.liveinteract.plantform.model.g.class);
        setThreadSafe(false);
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L15;
        am3.g.a r103 = decodeExtensionFields(r102, r100);
        if (r102 != 1) goto L8;
        this.isInWaiting = am3.h.a(r100);
        goto L3
    L8:
        if (r102 != 2) goto L10;
        this.mediaInfo = vh7.f.a(r100, com.bytedance.android.livesdk.link.model.bridge.j1.class);
        goto L3
    L10:
        if (r102 != 3) goto L11;
        this.rtcAppId = am3.h.c(r100);
        goto L3
    L11:
        am3.h.d(r103, r100);
        goto L3
    L15:
        r100.d(r101);
        setThreadSafe(true);
    }

    public String toString() {
        return "isWaiting " + isInWaiting() + " mediaInfo " + getMediaInfo();
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.g
    public com.bytedance.android.livesdk.link.model.bridge.j1 getMediaInfo() {
        return this.mediaInfo;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.g
    public String getRtcAppId() {
        return this.rtcAppId;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.g
    public boolean isInWaiting() {
        return this.isInWaiting;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.g
    public void setInWaiting(boolean r100) {
        this.isInWaiting = r100;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.g
    public void setMediaInfo(com.bytedance.android.livesdk.link.model.bridge.j1 r100) {
        this.mediaInfo = r100;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.g
    public void setRtcAppId(String r100) {
        this.rtcAppId = r100;
    }
}
