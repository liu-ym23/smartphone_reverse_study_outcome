package com.bytedance.android.livesdk.followtool.api;

import com.google.gson.annotations.SerializedName;
import com.tencent.connect.common.Constants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\b\u0007\u0018\u00002\u00020\u0001B#\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006R\u001e\u0010\u0004\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\b\"\u0004\b\f\u0010\nR\u001e\u0010\u0005\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\b\"\u0004\b\u000e\u0010\n¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/livesdk/followtool/api/UserInfo;", "", "nickName", "", "avatarUrl", "openId", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAvatarUrl", "()Ljava/lang/String;", "setAvatarUrl", "(Ljava/lang/String;)V", "getNickName", "setNickName", "getOpenId", "setOpenId", "live-impl-saas_release"}, k = 1, mv = {1, 4, 3})
public final class UserInfo {

    @SerializedName("avatar_url")
    private String avatarUrl;

    @SerializedName("nick_name")
    private String nickName;

    @SerializedName(Constants.JumpUrlConstants.URL_KEY_OPENID)
    private String openId;

    public UserInfo() {
        this(null, null, null, 7, null);
    }

    public final String getAvatarUrl() {
        return this.avatarUrl;
    }

    public final String getNickName() {
        return this.nickName;
    }

    public final String getOpenId() {
        return this.openId;
    }

    public final void setAvatarUrl(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.avatarUrl = r100;
    }

    public final void setNickName(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.nickName = r100;
    }

    public final void setOpenId(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.openId = r100;
    }

    public UserInfo(String r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "nickName");
        Intrinsics.checkNotNullParameter(r101, "avatarUrl");
        Intrinsics.checkNotNullParameter(r102, "openId");
        this.nickName = r100;
        this.avatarUrl = r101;
        this.openId = r102;
    }

    public /* synthetic */ UserInfo(String r100, String r101, String r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 1) == 0) goto L6;
        r100 = "";
    L6:
        if ((r103 & 2) == 0) goto L9;
        r101 = "";
    L9:
        if ((r103 & 4) == 0) goto L11;
        r102 = "";
    L11:
        this(r100, r101, r102);
    }
}
