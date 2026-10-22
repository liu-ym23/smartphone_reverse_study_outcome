package com.bytedance.android.livesdkapi.depend.model.live.roomchannel;

import am3.g;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import vh7.h;

/* JADX INFO: loaded from: classes12.dex */
@ProtoMessage("webcast.data.RtcExtInfo")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0016\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\n\u0010\u0016\u001a\u0004\u0018\u00010\u0005H\u0016J\n\u0010\u0017\u001a\u0004\u0018\u00010\u0005H\u0016J\n\u0010\u0018\u001a\u0004\u0018\u00010\u0005H\u0016J\n\u0010\u0019\u001a\u0004\u0018\u00010\u0005H\u0016J\n\u0010\u001a\u001a\u0004\u0018\u00010\u0005H\u0016R \u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR \u0010\n\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR \u0010\r\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u0007\"\u0004\b\u000f\u0010\tR \u0010\u0010\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0007\"\u0004\b\u0012\u0010\tR \u0010\u0013\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0007\"\u0004\b\u0015\u0010\t¨\u0006\u001b"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/roomchannel/RoomChannelRtcExtInfo;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdkapi/depend/model/live/roomchannel/IRoomChannelRtcExtInfo;", "()V", "_linkMicIdStr", "", "get_linkMicIdStr", "()Ljava/lang/String;", "set_linkMicIdStr", "(Ljava/lang/String;)V", "_liveCoreExrInfo", "get_liveCoreExrInfo", "set_liveCoreExrInfo", "_publicStreamId", "get_publicStreamId", "set_publicStreamId", "_rtcExtInfo", "get_rtcExtInfo", "set_rtcExtInfo", "_rtcStrategy", "get_rtcStrategy", "set_rtcStrategy", "getLinkMicIdStr", "getLiveCoreExrInfo", "getPublicStreamId", "getRtcExtInfo", "getRtcStrategy", "livebase-model_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class RoomChannelRtcExtInfo extends FlexModelBase<IRoomChannelRtcExtInfo> implements IRoomChannelRtcExtInfo, h {

    @SerializedName("link_mic_id_str")
    protected String _linkMicIdStr;

    @SerializedName("live_core_exr_info")
    protected String _liveCoreExrInfo;

    @SerializedName("public_stream_id")
    protected String _publicStreamId;

    @SerializedName("rtc_ext_info")
    protected String _rtcExtInfo;

    @SerializedName("rtc_strategy")
    protected String _rtcStrategy;

    public RoomChannelRtcExtInfo() {
        super(IRoomChannelRtcExtInfo.class);
    }

    public RoomChannelRtcExtInfo(g r100) {
        super(IRoomChannelRtcExtInfo.class);
        setThreadSafe(false);
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L21;
        g.a r103 = decodeExtensionFields(r102, r100);
        if (r102 != 1) goto L8;
        this._linkMicIdStr = am3.h.c(r100);
        goto L3
    L8:
        if (r102 != 2) goto L10;
        this._rtcExtInfo = am3.h.c(r100);
        goto L3
    L10:
        if (r102 != 3) goto L12;
        this._liveCoreExrInfo = am3.h.c(r100);
        goto L3
    L12:
        if (r102 != 4) goto L14;
        this._rtcStrategy = am3.h.c(r100);
        goto L3
    L14:
        if (r102 != 5) goto L15;
        this._publicStreamId = am3.h.c(r100);
        goto L3
    L15:
        am3.h.d(r103, r100);
        goto L3
    L21:
        r100.d(r101);
        setThreadSafe(true);
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.roomchannel.IRoomChannelRtcExtInfo
    public String getLinkMicIdStr() {
        return this._linkMicIdStr;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.roomchannel.IRoomChannelRtcExtInfo
    public String getLiveCoreExrInfo() {
        return this._liveCoreExrInfo;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.roomchannel.IRoomChannelRtcExtInfo
    public String getPublicStreamId() {
        return this._publicStreamId;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.roomchannel.IRoomChannelRtcExtInfo
    public String getRtcExtInfo() {
        return this._rtcExtInfo;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.roomchannel.IRoomChannelRtcExtInfo
    public String getRtcStrategy() {
        return this._rtcStrategy;
    }

    public final String get_linkMicIdStr() {
        return this._linkMicIdStr;
    }

    public final String get_liveCoreExrInfo() {
        return this._liveCoreExrInfo;
    }

    public final String get_publicStreamId() {
        return this._publicStreamId;
    }

    public final String get_rtcExtInfo() {
        return this._rtcExtInfo;
    }

    public final String get_rtcStrategy() {
        return this._rtcStrategy;
    }

    public final void set_linkMicIdStr(String r100) {
        this._linkMicIdStr = r100;
    }

    public final void set_liveCoreExrInfo(String r100) {
        this._liveCoreExrInfo = r100;
    }

    public final void set_publicStreamId(String r100) {
        this._publicStreamId = r100;
    }

    public final void set_rtcExtInfo(String r100) {
        this._rtcExtInfo = r100;
    }

    public final void set_rtcStrategy(String r100) {
        this._rtcStrategy = r100;
    }
}
