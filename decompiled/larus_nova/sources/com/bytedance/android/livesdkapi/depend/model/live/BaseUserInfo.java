package com.bytedance.android.livesdkapi.depend.model.live;

import am3.g;
import com.bytedance.android.live.base.model.ImageModel;
import com.bytedance.android.live.base.model.x;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import com.tencent.connect.common.Constants;
import kotlin.Metadata;
import vh7.h;

/* JADX INFO: loaded from: classes12.dex */
@ProtoMessage("webcast.data.BattleUserInfo.BaseUserInfo")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u001e\u001a\u00020\u0010H\u0016R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR \u0010\u000f\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R \u0010\u0015\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0012\"\u0004\b\u0017\u0010\u0014R\u001e\u0010\u0018\u001a\u00020\u00198\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001d¨\u0006\u001f"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/BaseUserInfo;", "", "()V", "avatarThumb", "Lcom/bytedance/android/live/base/model/ImageModel;", "getAvatarThumb", "()Lcom/bytedance/android/live/base/model/ImageModel;", "setAvatarThumb", "(Lcom/bytedance/android/live/base/model/ImageModel;)V", "gender", "", "getGender", "()I", "setGender", "(I)V", "nickName", "", "getNickName", "()Ljava/lang/String;", "setNickName", "(Ljava/lang/String;)V", "openUserId", "getOpenUserId", "setOpenUserId", "userId", "", "getUserId", "()J", "setUserId", "(J)V", "toString", "livebase-model_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class BaseUserInfo implements h {

    @SerializedName("avatar_thumb")
    protected ImageModel avatarThumb;

    @SerializedName("gender")
    protected int gender;

    @SerializedName("nick_name")
    protected String nickName;

    @SerializedName(Constants.JumpUrlConstants.URL_KEY_OPENID)
    protected String openUserId;

    @SerializedName("user_id")
    protected long userId;

    public BaseUserInfo() {
    }

    public String toString() {
        return "User{uid=" + this.userId + ", name='" + this.nickName + "'}";
    }

    public final ImageModel getAvatarThumb() {
        return this.avatarThumb;
    }

    public final int getGender() {
        return this.gender;
    }

    public final String getNickName() {
        return this.nickName;
    }

    public final String getOpenUserId() {
        return this.openUserId;
    }

    public final long getUserId() {
        return this.userId;
    }

    public BaseUserInfo(g r100) {
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L21;
        if (r102 != 1) goto L8;
        this.userId = r100.j();
        goto L3
    L8:
        if (r102 != 2) goto L10;
        this.nickName = am3.h.c(r100);
        goto L3
    L10:
        if (r102 != 3) goto L12;
        this.avatarThumb = x.a(r100);
        goto L3
    L12:
        if (r102 != 4) goto L14;
        this.gender = r100.i();
        goto L3
    L14:
        if (r102 != 5000) goto L15;
        this.openUserId = am3.h.c(r100);
        goto L3
    L15:
        am3.h.e(r100);
        goto L3
    L21:
        r100.d(r101);
    }

    public final void setAvatarThumb(ImageModel r100) {
        this.avatarThumb = r100;
    }

    public final void setGender(int r100) {
        this.gender = r100;
    }

    public final void setNickName(String r100) {
        this.nickName = r100;
    }

    public final void setOpenUserId(String r100) {
        this.openUserId = r100;
    }

    public final void setUserId(long r100) {
        this.userId = r100;
    }
}
