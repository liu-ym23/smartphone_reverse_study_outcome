package com.bytedance.android.livesdk.chatroom.model.interact;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.badger.collect.impl.constants.Constants;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes7.dex */
@ProtoMessage("webcast.api.linkmic_audience.PermitResponse.ResponseData")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u001d\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b.\u0010/R/\u0010\u000b\u001a\u0004\u0018\u00010\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00038V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR+\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0004\u001a\u00020\f8V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\r\u0010\u0006\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R+\u0010\u0019\u001a\u00020\u00132\u0006\u0010\u0004\u001a\u00020\u00138V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u0014\u0010\u0006\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R/\u0010\u001d\u001a\u0004\u0018\u00010\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00038V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u001a\u0010\u0006\u001a\u0004\b\u001b\u0010\b\"\u0004\b\u001c\u0010\nR+\u0010!\u001a\u00020\f2\u0006\u0010\u0004\u001a\u00020\f8V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u001e\u0010\u0006\u001a\u0004\b\u001f\u0010\u000f\"\u0004\b \u0010\u0011R/\u0010%\u001a\u0004\u0018\u00010\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00038V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\"\u0010\u0006\u001a\u0004\b#\u0010\b\"\u0004\b$\u0010\nR/\u0010)\u001a\u0004\u0018\u00010\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00038V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b&\u0010\u0006\u001a\u0004\b'\u0010\b\"\u0004\b(\u0010\nR/\u0010-\u001a\u0004\u0018\u00010\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00038V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b*\u0010\u0006\u001a\u0004\b+\u0010\b\"\u0004\b,\u0010\n¨\u00060"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/model/interact/PermitResponseFlexImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdk/chatroom/model/interact/t2;", "", "<set-?>", "accessToken$delegate", "Ljava/lang/Object;", "getAccessToken", "()Ljava/lang/String;", "setAccessToken", "(Ljava/lang/String;)V", "accessToken", "", "linkMicId$delegate", "getLinkMicId", "()J", "setLinkMicId", "(J)V", "linkMicId", "", "vendor$delegate", "getVendor", "()I", "setVendor", "(I)V", Constants.OperatorKey.KEY_VENDOR, "linkMicIdStr$delegate", "getLinkMicIdStr", "setLinkMicIdStr", "linkMicIdStr", "rivalLinkmicId$delegate", "getRivalLinkmicId", "setRivalLinkmicId", "rivalLinkmicId", "rivalLinkmicIdStr$delegate", "getRivalLinkmicIdStr", "setRivalLinkmicIdStr", "rivalLinkmicIdStr", "rtcExtInfo$delegate", "getRtcExtInfo", "setRtcExtInfo", "rtcExtInfo", "remoteLinkerSessionId$delegate", "getRemoteLinkerSessionId", "setRemoteLinkerSessionId", "remoteLinkerSessionId", "<init>", "()V", "multilink-base_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class PermitResponseFlexImpl extends FlexModelBase<t2> implements t2, vh7.h {

    @SerializedName("access_key")
    protected String _$$accessToken;

    @SerializedName("linkmic_id")
    protected long _$$linkMicId;

    @SerializedName("linkmic_id_str")
    protected String _$$linkMicIdStr;

    @SerializedName("remote_linker_session_id")
    protected String _$$remoteLinkerSessionId;

    @SerializedName("rival_linkmic_id")
    protected long _$$rivalLinkmicId;

    @SerializedName("rival_linkmic_id_str")
    protected String _$$rivalLinkmicIdStr;

    @SerializedName("rtc_ext_info")
    protected String _$$rtcExtInfo;

    @SerializedName(Constants.OperatorKey.KEY_VENDOR)
    protected int _$$vendor;

    public PermitResponseFlexImpl() {
        super(t2.class);
    }

    @Override // com.bytedance.android.livesdk.chatroom.model.interact.t2
    public final String getAccessToken() {
        return this._$$accessToken;
    }

    @Override // com.bytedance.android.livesdk.chatroom.model.interact.t2
    public final long getLinkMicId() {
        return this._$$linkMicId;
    }

    @Override // com.bytedance.android.livesdk.chatroom.model.interact.t2
    public final String getLinkMicIdStr() {
        return this._$$linkMicIdStr;
    }

    @Override // com.bytedance.android.livesdk.chatroom.model.interact.t2
    public final String getRemoteLinkerSessionId() {
        return this._$$remoteLinkerSessionId;
    }

    @Override // com.bytedance.android.livesdk.chatroom.model.interact.t2
    public final long getRivalLinkmicId() {
        return this._$$rivalLinkmicId;
    }

    @Override // com.bytedance.android.livesdk.chatroom.model.interact.t2
    public final String getRivalLinkmicIdStr() {
        return this._$$rivalLinkmicIdStr;
    }

    @Override // com.bytedance.android.livesdk.chatroom.model.interact.t2
    public final String getRtcExtInfo() {
        return this._$$rtcExtInfo;
    }

    @Override // com.bytedance.android.livesdk.chatroom.model.interact.t2
    public final int getVendor() {
        return this._$$vendor;
    }

    public PermitResponseFlexImpl(am3.g r100) {
        super(t2.class);
        setThreadSafe(false);
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L16;
        am3.g.a r103 = decodeExtensionFields(r102, r100);
        switch(r102) {
            case 1: goto L15;
            case 2: goto L14;
            case 3: goto L13;
            case 4: goto L7;
            case 5: goto L7;
            case 6: goto L12;
            case 7: goto L11;
            case 8: goto L10;
            case 9: goto L9;
            case 10: goto L8;
            default: goto L7;
        };
    L8:
        this._$$remoteLinkerSessionId = am3.h.c(r100);
        goto L3
    L9:
        this._$$rtcExtInfo = am3.h.c(r100);
        goto L3
    L10:
        this._$$rivalLinkmicIdStr = am3.h.c(r100);
        goto L3
    L11:
        this._$$rivalLinkmicId = r100.j();
        goto L3
    L12:
        this._$$linkMicIdStr = am3.h.c(r100);
        goto L3
    L13:
        this._$$vendor = r100.i();
        goto L3
    L14:
        this._$$linkMicId = r100.j();
        goto L3
    L15:
        this._$$accessToken = am3.h.c(r100);
        goto L3
    L7:
        am3.h.d(r103, r100);
        goto L3
    L16:
        r100.d(r101);
        setThreadSafe(true);
    }

    @Override // com.bytedance.android.livesdk.chatroom.model.interact.t2
    public final void setAccessToken(String r100) {
        this._$$accessToken = r100;
    }

    @Override // com.bytedance.android.livesdk.chatroom.model.interact.t2
    public final void setLinkMicId(long r100) {
        this._$$linkMicId = r100;
    }

    @Override // com.bytedance.android.livesdk.chatroom.model.interact.t2
    public final void setLinkMicIdStr(String r100) {
        this._$$linkMicIdStr = r100;
    }

    @Override // com.bytedance.android.livesdk.chatroom.model.interact.t2
    public final void setRemoteLinkerSessionId(String r100) {
        this._$$remoteLinkerSessionId = r100;
    }

    @Override // com.bytedance.android.livesdk.chatroom.model.interact.t2
    public final void setRivalLinkmicId(long r100) {
        this._$$rivalLinkmicId = r100;
    }

    @Override // com.bytedance.android.livesdk.chatroom.model.interact.t2
    public final void setRivalLinkmicIdStr(String r100) {
        this._$$rivalLinkmicIdStr = r100;
    }

    @Override // com.bytedance.android.livesdk.chatroom.model.interact.t2
    public final void setRtcExtInfo(String r100) {
        this._$$rtcExtInfo = r100;
    }

    @Override // com.bytedance.android.livesdk.chatroom.model.interact.t2
    public final void setVendor(int r100) {
        this._$$vendor = r100;
    }
}
