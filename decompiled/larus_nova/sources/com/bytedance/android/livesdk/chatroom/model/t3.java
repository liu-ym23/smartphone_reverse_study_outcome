package com.bytedance.android.livesdk.chatroom.model;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.tencent.qqmusic.third.api.contract.Keys;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0015\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u001c\u0010\u001dR\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0010\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR$\u0010\u0013\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u000b\u001a\u0004\b\u0014\u0010\r\"\u0004\b\u0015\u0010\u000fR$\u0010\u0016\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u000b\u001a\u0004\b\u0017\u0010\r\"\u0004\b\u0018\u0010\u000fR$\u0010\u0019\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u000b\u001a\u0004\b\u001a\u0010\r\"\u0004\b\u001b\u0010\u000f¨\u0006\u001e"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/model/t3;", "", "", Keys.API_RETURN_KEY_IS_LOGIN, "Z", "d", "()Z", "setLogin", "(Z)V", "", "roleName", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "setRoleName", "(Ljava/lang/String;)V", "roleIcon", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "setRoleIcon", "roleTag", "c", "setRoleTag", "unLoginIcon", "getUnLoginIcon", "setUnLoginIcon", "unLoginTitle", "getUnLoginTitle", "setUnLoginTitle", "<init>", "()V", "livebase-model_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class t3 {

    @SerializedName("is_login")
    private boolean isLogin;

    @SerializedName("role_icon")
    private String roleIcon;

    @SerializedName("role_name")
    private String roleName;

    @SerializedName("role_tag")
    private String roleTag;

    @SerializedName("un_login_icon")
    private String unLoginIcon;

    @SerializedName("un_login_title")
    private String unLoginTitle;

    public t3() {
    }

    public final int hashCode() {
        String r100 = this.roleName;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.roleIcon;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.roleTag;
        if (r107 == null) goto L14;
        r101 = r107.hashCode();
    L14:
        return r106 + r101;
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public final String a() {
        return this.roleIcon;
    }

    public final String b() {
        return this.roleName;
    }

    public final String c() {
        return this.roleTag;
    }

    public final boolean d() {
        return this.isLogin;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if (r100 == null) goto L8;
        Class<?> r101 = r100.getClass();
    L10:
        if ((!Intrinsics.areEqual(t3.class, r101)) == false) goto L12;
        return false;
    L12:
        if (r100 == null) goto L24;
        t3 r102 = (t3) r100;
        if ((!Intrinsics.areEqual(this.roleName, r102.roleName)) == false) goto L17;
        return false;
    L17:
        if ((!Intrinsics.areEqual(this.roleIcon, r102.roleIcon)) == false) goto L20;
        return false;
    L20:
        if ((!Intrinsics.areEqual(this.roleTag, r102.roleTag)) == false) goto L22;
        return false;
    L22:
        return true;
    L24:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.chatroom.model.T01RoleInfo");
    L8:
        r101 = null;
        goto L10
    }
}
