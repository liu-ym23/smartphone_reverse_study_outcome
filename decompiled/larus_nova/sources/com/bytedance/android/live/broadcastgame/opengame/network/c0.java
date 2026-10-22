package com.bytedance.android.live.broadcastgame.opengame.network;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.tencent.connect.common.Constants;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes45.dex */
@ProtoMessage("webcast.open.api.GetMineInfoResponse.Data")
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001:\u0001\u0005B\u0007¢\u0006\u0004\b\t\u0010\nR$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/live/broadcastgame/opengame/network/c0;", "", "Lcom/bytedance/android/live/broadcastgame/opengame/network/c0$a;", "userInfo", "Lcom/bytedance/android/live/broadcastgame/opengame/network/c0$a;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Lcom/bytedance/android/live/broadcastgame/opengame/network/c0$a;", "setUserInfo", "(Lcom/bytedance/android/live/broadcastgame/opengame/network/c0$a;)V", "<init>", "()V", "livebroadcastgame-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class c0 implements vh7.h {

    @SerializedName("user_info")
    protected a userInfo;

    @ProtoMessage("webcast.open.api.GetMineInfoResponse.Data.UserInfo")
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0012\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0012\u0010\u0013R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\"\u0010\f\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\"\u0010\u000f\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0004\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\b¨\u0006\u0014"}, d2 = {"Lcom/bytedance/android/live/broadcastgame/opengame/network/c0$a;", "", "", "secNickName", "Ljava/lang/String;", "d", "()Ljava/lang/String;", "setSecNickName", "(Ljava/lang/String;)V", "secAvatar", "c", "setSecAvatar", "openId", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "setOpenId", "role", "b", "setRole", "<init>", "()V", "livebroadcastgame-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class a implements vh7.h {

        @SerializedName(Constants.JumpUrlConstants.URL_KEY_OPENID)
        protected String openId;

        @SerializedName("role")
        protected String role;

        @SerializedName("sec_avatar_url")
        protected String secAvatar;

        @SerializedName("sec_nick_name")
        protected String secNickName;

        public a() {
            this.secNickName = "";
            this.secAvatar = "";
            this.openId = "";
            this.role = "";
        }

        public final String a() {
            return this.openId;
        }

        public final String b() {
            return this.role;
        }

        public final String c() {
            return this.secAvatar;
        }

        public final String d() {
            return this.secNickName;
        }

        public a(am3.g r100) {
            long r101 = r100.c();
        L3:
            int r102 = r100.f();
            if (r102 == (-1)) goto L18;
            if (r102 != 1) goto L8;
            this.openId = am3.h.c(r100);
            goto L3
        L8:
            if (r102 != 2) goto L10;
            this.secNickName = am3.h.c(r100);
            goto L3
        L10:
            if (r102 != 3) goto L12;
            this.secAvatar = am3.h.c(r100);
            goto L3
        L12:
            if (r102 != 4) goto L13;
            this.role = am3.h.c(r100);
            goto L3
        L13:
            am3.h.e(r100);
            goto L3
        L18:
            r100.d(r101);
            if (this.secNickName != null) goto L22;
            this.secNickName = "";
        L22:
            if (this.secAvatar != null) goto L25;
            this.secAvatar = "";
        L25:
            if (this.openId != null) goto L28;
            this.openId = "";
        L28:
            if (this.role != null) goto L46;
            this.role = "";
            return;
        }
    }

    public c0() {
    }

    public c0(am3.g r100) {
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L9;
        if (r102 != 1) goto L7;
        this.userInfo = new a(r100);
        goto L3
    L7:
        am3.h.e(r100);
        goto L3
    L9:
        r100.d(r101);
    }

    public final a a() {
        return this.userInfo;
    }
}
