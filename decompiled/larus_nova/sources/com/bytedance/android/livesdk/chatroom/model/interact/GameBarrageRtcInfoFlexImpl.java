package com.bytedance.android.livesdk.chatroom.model.interact;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes7.dex */
@ProtoMessage("webcast.data.GameBarrageRtcInfo")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\t\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0013\u0010\u0014R+\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00038V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR/\u0010\u0012\u001a\u0004\u0018\u00010\f2\b\u0010\u0004\u001a\u0004\u0018\u00010\f8V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\r\u0010\u0006\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u0015"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/model/interact/GameBarrageRtcInfoFlexImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdk/chatroom/model/interact/GameBarrageRtcInfo;", "", "<set-?>", "linkerId$delegate", "Ljava/lang/Object;", "getLinkerId", "()J", "setLinkerId", "(J)V", "linkerId", "", "rtcExtInfo$delegate", "getRtcExtInfo", "()Ljava/lang/String;", "setRtcExtInfo", "(Ljava/lang/String;)V", "rtcExtInfo", "<init>", "()V", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class GameBarrageRtcInfoFlexImpl extends FlexModelBase<GameBarrageRtcInfo> implements GameBarrageRtcInfo, vh7.h {

    @SerializedName("linker_id")
    protected long _$$linkerId;

    @SerializedName("rtc_info")
    protected String _$$rtcExtInfo;

    public GameBarrageRtcInfoFlexImpl() {
        super(GameBarrageRtcInfo.class);
    }

    @Override // com.bytedance.android.livesdk.chatroom.model.interact.GameBarrageRtcInfo
    public final long getLinkerId() {
        return this._$$linkerId;
    }

    @Override // com.bytedance.android.livesdk.chatroom.model.interact.GameBarrageRtcInfo
    public final String getRtcExtInfo() {
        return this._$$rtcExtInfo;
    }

    public GameBarrageRtcInfoFlexImpl(am3.g r100) {
        super(GameBarrageRtcInfo.class);
        setThreadSafe(false);
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L12;
        am3.g.a r103 = decodeExtensionFields(r102, r100);
        if (r102 != 1) goto L8;
        this._$$linkerId = r100.j();
        goto L3
    L8:
        if (r102 != 2) goto L9;
        this._$$rtcExtInfo = am3.h.c(r100);
        goto L3
    L9:
        am3.h.d(r103, r100);
        goto L3
    L12:
        r100.d(r101);
        setThreadSafe(true);
    }

    @Override // com.bytedance.android.livesdk.chatroom.model.interact.GameBarrageRtcInfo
    public final void setLinkerId(long r100) {
        this._$$linkerId = r100;
    }

    @Override // com.bytedance.android.livesdk.chatroom.model.interact.GameBarrageRtcInfo
    public final void setRtcExtInfo(String r100) {
        this._$$rtcExtInfo = r100;
    }
}
