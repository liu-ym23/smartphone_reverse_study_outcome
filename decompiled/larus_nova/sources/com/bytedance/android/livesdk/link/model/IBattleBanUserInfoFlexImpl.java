package com.bytedance.android.livesdk.link.model;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes10.dex */
@ProtoMessage("webcast.data.BattleUserSettingsList.UserInfo")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0007\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b \u0010!R$\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001b\u0010\u000f\u001a\u00020\n8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u001b\u0010\u0012\u001a\u00020\n8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\f\u001a\u0004\b\u0011\u0010\u000eR\u001b\u0010\u0017\u001a\u00020\u00138VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\f\u001a\u0004\b\u0015\u0010\u0016R\u001b\u0010\u001a\u001a\u00020\u00138VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0018\u0010\f\u001a\u0004\b\u0019\u0010\u0016R\u001b\u0010\u001f\u001a\u00020\u001b8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u001c\u0010\f\u001a\u0004\b\u001d\u0010\u001e¨\u0006\""}, d2 = {"Lcom/bytedance/android/livesdk/link/model/IBattleBanUserInfoFlexImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdk/link/model/u0;", "Lpy/k;", "avatarThumb", "Lpy/k;", "getAvatarThumb", "()Lpy/k;", "setAvatarThumb", "(Lpy/k;)V", "", "userId$delegate", "Ljava/lang/Object;", "getUserId", "()Ljava/lang/String;", "userId", "nickName$delegate", "getNickName", "nickName", "", "autoRemoveTime$delegate", "getAutoRemoveTime", "()J", "autoRemoveTime", "rivalLivingRoomId$delegate", "getRivalLivingRoomId", "rivalLivingRoomId", "", "gender$delegate", "getGender", "()I", "gender", "<init>", "()V", "revenue-model_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class IBattleBanUserInfoFlexImpl extends FlexModelBase<u0> implements u0, vh7.h {

    @SerializedName("auto_remove_time")
    protected long _$$autoRemoveTime;

    @SerializedName("sex")
    protected int _$$gender;

    @SerializedName("nick_name")
    protected String _$$nickName;

    @SerializedName("rival_living_room_id")
    protected long _$$rivalLivingRoomId;

    @SerializedName("user_open_id")
    protected String _$$userId;

    @SerializedName("avatar_thumb")
    protected py.k avatarThumb;

    public IBattleBanUserInfoFlexImpl() {
        super(u0.class);
        this._$$userId = "";
        this._$$nickName = "";
    }

    @Override // com.bytedance.android.livesdk.link.model.u0
    public final long getAutoRemoveTime() {
        return this._$$autoRemoveTime;
    }

    @Override // com.bytedance.android.livesdk.link.model.u0
    public py.k getAvatarThumb() {
        return this.avatarThumb;
    }

    @Override // com.bytedance.android.livesdk.link.model.u0
    public final int getGender() {
        return this._$$gender;
    }

    @Override // com.bytedance.android.livesdk.link.model.u0
    public final String getNickName() {
        return this._$$nickName;
    }

    @Override // com.bytedance.android.livesdk.link.model.u0
    public final long getRivalLivingRoomId() {
        return this._$$rivalLivingRoomId;
    }

    @Override // com.bytedance.android.livesdk.link.model.u0
    public final String getUserId() {
        return this._$$userId;
    }

    /* JADX WARN: Type inference failed for: r2v6, types: [java.lang.Object, py.k] */
    public IBattleBanUserInfoFlexImpl(am3.g r100) {
        super(u0.class);
        setThreadSafe(false);
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L24;
        am3.g.a r103 = decodeExtensionFields(r102, r100);
        if (r102 != 2) goto L8;
        this._$$nickName = am3.h.c(r100);
        goto L3
    L8:
        if (r102 != 3) goto L10;
        this.avatarThumb = vh7.f.a(r100, py.k.class);
        goto L3
    L10:
        if (r102 != 4) goto L12;
        this._$$autoRemoveTime = r100.j();
        goto L3
    L12:
        if (r102 != 5) goto L14;
        this._$$gender = r100.i();
        goto L3
    L14:
        if (r102 != 6) goto L16;
        this._$$rivalLivingRoomId = r100.j();
        goto L3
    L16:
        if (r102 != 5000) goto L17;
        this._$$userId = am3.h.c(r100);
        goto L3
    L17:
        am3.h.d(r103, r100);
        goto L3
    L24:
        r100.d(r101);
        setThreadSafe(true);
        if (this._$$userId != null) goto L28;
        this._$$userId = "";
    L28:
        if (this._$$nickName != null) goto L52;
        this._$$nickName = "";
        return;
    }

    public void setAvatarThumb(py.k r100) {
        this.avatarThumb = r100;
    }
}
