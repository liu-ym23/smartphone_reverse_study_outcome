package com.bytedance.android.live.browser.jsbridge.base;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.tencent.qqmusic.third.api.contract.Keys;
import kotlin.Metadata;
import w20.aa;
import w20.z9;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001:\u0002 \u0013B\u0007¢\u0006\u0004\b\u001e\u0010\u001fR$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R$\u0010\u0018\u001a\u0004\u0018\u00010\u00178\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001d¨\u0006!"}, d2 = {"Lcom/bytedance/android/live/browser/jsbridge/base/GetUserInfoResultModel;", "Lw20/aa;", "Lcom/bytedance/android/live/browser/jsbridge/base/GetUserInfoResultModel$Code;", "code", "Lcom/bytedance/android/live/browser/jsbridge/base/GetUserInfoResultModel$Code;", "getCode", "()Lcom/bytedance/android/live/browser/jsbridge/base/GetUserInfoResultModel$Code;", "b", "(Lcom/bytedance/android/live/browser/jsbridge/base/GetUserInfoResultModel$Code;)V", "", "msg", "Ljava/lang/String;", "getMsg", "()Ljava/lang/String;", "d", "(Ljava/lang/String;)V", "", Keys.API_RETURN_KEY_IS_LOGIN, "Ljava/lang/Boolean;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/lang/Boolean;", "c", "(Ljava/lang/Boolean;)V", "Lcom/bytedance/android/live/browser/jsbridge/base/GetUserInfoResultModel$a;", "userInfo", "Lcom/bytedance/android/live/browser/jsbridge/base/GetUserInfoResultModel$a;", "getUserInfo", "()Lcom/bytedance/android/live/browser/jsbridge/base/GetUserInfoResultModel$a;", "e", "(Lcom/bytedance/android/live/browser/jsbridge/base/GetUserInfoResultModel$a;)V", "<init>", "()V", "Code", "livehybrid-middleware-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class GetUserInfoResultModel implements aa {

    @SerializedName("code")
    private Code code;

    @SerializedName(Keys.API_RETURN_KEY_IS_LOGIN)
    private Boolean isLogin;

    @SerializedName("msg")
    private String msg;

    @SerializedName("userInfo")
    private a userInfo;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002J\b\u0010\u0004\u001a\u00020\u0003H\u0016R\u0017\u0010\u0005\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/live/browser/jsbridge/base/GetUserInfoResultModel$Code;", "", "Lw20/z9;", "", "getCode", "value", "I", "getValue", "()I", "Success", "Failed", "livehybrid-middleware-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum Code extends Enum<Code> implements z9 {
        public static final Code Failed = null;
        public static final Code Success = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Code[] f63031a = null;
        private final int value;

        static {
            Code r100 = new Code("Success", 0, 1);
            Success = r100;
            Code r101 = new Code("Failed", 1, 0);
            Failed = r101;
            f63031a = new Code[]{r100, r101};
        }

        public static Code valueOf(String r100) {
            return (Code) r27.a.a(Code.class, r100);
        }

        public static Code[] values() {
            return (Code[]) f63031a.clone();
        }

        @Override // w20.z9
        public int getCode() {
            return this.value;
        }

        public final int getValue() {
            return this.value;
        }

        public Code(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u001b\u0010\u001cR$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR$\u0010\f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR$\u0010\u000f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0004\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR$\u0010\u0012\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0004\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\bR$\u0010\u0016\u001a\u0004\u0018\u00010\u00158\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0016\u0010\u0018\"\u0004\b\u0019\u0010\u001a¨\u0006\u001d"}, d2 = {"Lcom/bytedance/android/live/browser/jsbridge/base/GetUserInfoResultModel$a;", "", "", "shortID", "Ljava/lang/String;", "getShortID", "()Ljava/lang/String;", "e", "(Ljava/lang/String;)V", "userID", "getUserID", "f", "secUserID", "getSecUserID", "d", "nickName", "getNickName", "c", "avatarURL", "getAvatarURL", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "", "isBoundPhone", "Ljava/lang/Boolean;", "()Ljava/lang/Boolean;", "b", "(Ljava/lang/Boolean;)V", "<init>", "()V", "livehybrid-middleware-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class a {

        @SerializedName("avatarURL")
        private String avatarURL;

        @SerializedName("isBoundPhone")
        private Boolean isBoundPhone;

        @SerializedName("nickName")
        private String nickName;

        @SerializedName("secUserID")
        private String secUserID;

        @SerializedName("shortID")
        private String shortID;

        @SerializedName("userID")
        private String userID;

        public a() {
        }

        public final void a(String r100) {
            this.avatarURL = r100;
        }

        public final void b(Boolean r100) {
            this.isBoundPhone = r100;
        }

        public final void c(String r100) {
            this.nickName = r100;
        }

        public final void d(String r100) {
            this.secUserID = r100;
        }

        public final void e(String r100) {
            this.shortID = r100;
        }

        public final void f(String r100) {
            this.userID = r100;
        }
    }

    public GetUserInfoResultModel() {
    }

    public final Boolean a() {
        return this.isLogin;
    }

    public final void b(Code r100) {
        this.code = r100;
    }

    public final void c(Boolean r100) {
        this.isLogin = r100;
    }

    public final void d(String r100) {
        this.msg = "SUCCESS";
    }

    public final void e(a r100) {
        this.userInfo = r100;
    }
}
