package com.bytedance.android.livesdk.link.model.bridge;

import com.bytedance.android.gamecp.business.instantplay.InstantPlayContext;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes10.dex */
@ProtoMessage("webcast.data.LinkmicAIUser")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0014\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u001c\u0010\u001dR$\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001d\u0010\u000f\u001a\u0004\u0018\u00010\n8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u001d\u0010\u0012\u001a\u0004\u0018\u00010\n8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\f\u001a\u0004\b\u0011\u0010\u000eR\u001d\u0010\u0015\u001a\u0004\u0018\u00010\n8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0013\u0010\f\u001a\u0004\b\u0014\u0010\u000eR\u001d\u0010\u0018\u001a\u0004\u0018\u00010\n8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0016\u0010\f\u001a\u0004\b\u0017\u0010\u000eR\u001d\u0010\u001b\u001a\u0004\u0018\u00010\n8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0019\u0010\f\u001a\u0004\b\u001a\u0010\u000e¨\u0006\u001e"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/bridge/IAIAssistantUserBridgeFlexImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdk/link/model/bridge/d;", "Lpy/k;", "avatar", "Lpy/k;", "getAvatar", "()Lpy/k;", "setAvatar", "(Lpy/k;)V", "", "id$delegate", "Ljava/lang/Object;", "getId", "()Ljava/lang/String;", "id", "nickName$delegate", "getNickName", "nickName", "belongUserId$delegate", "getBelongUserId", "belongUserId", "belongRoomId$delegate", "getBelongRoomId", "belongRoomId", "linkmicIdStr$delegate", "getLinkmicIdStr", "linkmicIdStr", "<init>", "()V", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class IAIAssistantUserBridgeFlexImpl extends FlexModelBase<d> implements d, vh7.h {

    @SerializedName("belong_room_id")
    protected String _$$belongRoomId;

    @SerializedName("belong_open_id")
    protected String _$$belongUserId;

    @SerializedName("id")
    protected String _$$id;

    @SerializedName("linkmic_id_str")
    protected String _$$linkmicIdStr;

    @SerializedName(InstantPlayContext.NICKNAME)
    protected String _$$nickName;

    @SerializedName("avatar_medium")
    protected py.k avatar;

    public IAIAssistantUserBridgeFlexImpl() {
        super(d.class);
    }

    /* JADX WARN: Type inference failed for: r2v5, types: [java.lang.Object, py.k] */
    public IAIAssistantUserBridgeFlexImpl(am3.g r100) {
        super(d.class);
        setThreadSafe(false);
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L24;
        am3.g.a r103 = decodeExtensionFields(r102, r100);
        if (r102 != 1) goto L8;
        this._$$id = am3.h.c(r100);
        goto L3
    L8:
        if (r102 != 2) goto L10;
        this._$$nickName = am3.h.c(r100);
        goto L3
    L10:
        if (r102 != 3) goto L12;
        this.avatar = vh7.f.a(r100, py.k.class);
        goto L3
    L12:
        if (r102 != 5) goto L14;
        this._$$belongRoomId = am3.h.c(r100);
        goto L3
    L14:
        if (r102 != 6) goto L16;
        this._$$linkmicIdStr = am3.h.c(r100);
        goto L3
    L16:
        if (r102 != 5000) goto L17;
        this._$$belongUserId = am3.h.c(r100);
        goto L3
    L17:
        am3.h.d(r103, r100);
        goto L3
    L24:
        r100.d(r101);
        setThreadSafe(true);
    }

    @Override // com.bytedance.android.livesdk.link.model.bridge.d
    public py.k getAvatar() {
        return this.avatar;
    }

    @Override // com.bytedance.android.livesdk.link.model.bridge.d
    public final String getBelongRoomId() {
        return this._$$belongRoomId;
    }

    @Override // com.bytedance.android.livesdk.link.model.bridge.d
    public final String getBelongUserId() {
        return this._$$belongUserId;
    }

    @Override // com.bytedance.android.livesdk.link.model.bridge.d
    public final String getId() {
        return this._$$id;
    }

    @Override // com.bytedance.android.livesdk.link.model.bridge.d
    public final String getLinkmicIdStr() {
        return this._$$linkmicIdStr;
    }

    @Override // com.bytedance.android.livesdk.link.model.bridge.d
    public final String getNickName() {
        return this._$$nickName;
    }

    public void setAvatar(py.k r100) {
        this.avatar = r100;
    }
}
