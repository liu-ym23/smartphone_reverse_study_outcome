package com.bytedance.android.livesdk.chatroom.model.interact;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.tencent.connect.common.Constants;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes7.dex */
@ProtoMessage("webcast.data.TeamfightTeamConfigUser")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0004\u001a\u00020\u00038\u0006X\u0087D¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u001a\u0010\b\u001a\u00020\u00038\u0006X\u0087D¢\u0006\f\n\u0004\b\b\u0010\u0005\u001a\u0004\b\t\u0010\u0007R\u001a\u0010\n\u001a\u00020\u00038\u0016X\u0097D¢\u0006\f\n\u0004\b\n\u0010\u0005\u001a\u0004\b\u000b\u0010\u0007R\u001c\u0010\r\u001a\u0004\u0018\u00010\f8\u0016X\u0097\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0012\u001a\u00020\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0007¨\u0006\u0015"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/model/interact/TeamFightTeamConfigUser;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdk/chatroom/model/interact/z1;", "", "_userId", "Ljava/lang/String;", "get_userId", "()Ljava/lang/String;", "_openId", "get_openId", "nickName", "getNickName", "Lpy/k;", "avatarThumb", "Lpy/k;", "getAvatarThumb", "()Lpy/k;", "getUserId", "userId", "<init>", "()V", "livebase-model_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class TeamFightTeamConfigUser extends FlexModelBase<z1> implements z1, vh7.h {

    @SerializedName(Constants.JumpUrlConstants.URL_KEY_OPENID)
    protected String _openId;

    @SerializedName("user_id")
    protected String _userId;

    @SerializedName("avatar_thumn")
    protected py.k avatarThumb;

    @SerializedName("nick_name")
    protected String nickName;

    public TeamFightTeamConfigUser() {
        super(z1.class);
        this._userId = "";
        this._openId = "";
        this.nickName = "";
    }

    @Override // com.bytedance.android.livesdk.chatroom.model.interact.z1
    public String getUserId() {
        com.bytedance.android.live.base.model.user.o0.a r100 = com.bytedance.android.live.base.model.user.o0.f58946a;
        String r101 = this._openId;
        r100.getClass();
        if (r101 != null) goto L6;
        return "0";
    L6:
        return r101;
    }

    @Override // com.bytedance.android.livesdk.chatroom.model.interact.z1
    public py.k getAvatarThumb() {
        return this.avatarThumb;
    }

    @Override // com.bytedance.android.livesdk.chatroom.model.interact.z1
    public String getNickName() {
        return this.nickName;
    }

    public final String get_openId() {
        return this._openId;
    }

    public final String get_userId() {
        return this._userId;
    }

    /* JADX WARN: Type inference failed for: r2v3, types: [java.lang.Object, py.k] */
    public TeamFightTeamConfigUser(am3.g r100) {
        super(z1.class);
        setThreadSafe(false);
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L18;
        am3.g.a r103 = decodeExtensionFields(r102, r100);
        if (r102 != 1) goto L8;
        this._userId = am3.h.c(r100);
        goto L3
    L8:
        if (r102 != 2) goto L10;
        this.nickName = am3.h.c(r100);
        goto L3
    L10:
        if (r102 != 3) goto L12;
        this.avatarThumb = vh7.f.a(r100, py.k.class);
        goto L3
    L12:
        if (r102 != 5000) goto L13;
        this._openId = am3.h.c(r100);
        goto L3
    L13:
        am3.h.d(r103, r100);
        goto L3
    L18:
        r100.d(r101);
        setThreadSafe(true);
        if (this._userId != null) goto L22;
        this._userId = "";
    L22:
        if (this._openId != null) goto L25;
        this._openId = "";
    L25:
        if (this.nickName != null) goto L43;
        this.nickName = "";
        return;
    }
}
