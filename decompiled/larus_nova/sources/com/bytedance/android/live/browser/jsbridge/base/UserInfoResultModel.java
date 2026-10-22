package com.bytedance.android.live.browser.jsbridge.base;

import com.amap.api.col.s.ce;
import com.bytedance.android.gamecp.business.instantplay.InstantPlayContext;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import e7.j0;
import e7.k0;
import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0004\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u001b\u0018\u00002\u00020\u0001:\u0001)B\u0007¢\u0006\u0004\b'\u0010(R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\n\u0010\f\"\u0004\b\r\u0010\u000eR$\u0010\u0010\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R$\u0010\u0016\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u0011\u001a\u0004\b\u0017\u0010\u0013\"\u0004\b\u0018\u0010\u0015R$\u0010\u0019\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u0011\u001a\u0004\b\u001a\u0010\u0013\"\u0004\b\u001b\u0010\u0015R$\u0010\u001c\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010\u0011\u001a\u0004\b\u001d\u0010\u0013\"\u0004\b\u001e\u0010\u0015R$\u0010\u001f\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010\u0011\u001a\u0004\b \u0010\u0013\"\u0004\b!\u0010\u0015R$\u0010\"\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\"\u0010\u000b\u001a\u0004\b\"\u0010\f\"\u0004\b#\u0010\u000eR$\u0010$\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b$\u0010\u000b\u001a\u0004\b%\u0010\f\"\u0004\b&\u0010\u000e¨\u0006*"}, d2 = {"Lcom/bytedance/android/live/browser/jsbridge/base/UserInfoResultModel;", "Le7/k0;", "Lcom/bytedance/android/live/browser/jsbridge/base/UserInfoResultModel$Code;", "code", "Lcom/bytedance/android/live/browser/jsbridge/base/UserInfoResultModel$Code;", "getCode", "()Lcom/bytedance/android/live/browser/jsbridge/base/UserInfoResultModel$Code;", "b", "(Lcom/bytedance/android/live/browser/jsbridge/base/UserInfoResultModel$Code;)V", "", "is_login", "Ljava/lang/Number;", "()Ljava/lang/Number;", ce.f26391f, "(Ljava/lang/Number;)V", "", "user_id", "Ljava/lang/String;", "getUser_id", "()Ljava/lang/String;", "f", "(Ljava/lang/String;)V", "short_id", "getShort_id", "e", "sec_user_id", "getSec_user_id", "d", InstantPlayContext.NICKNAME, "getNickname", "c", "avatar", "getAvatar", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "is_silent", "h", "douyin_uid", "getDouyin_uid", "setDouyin_uid", "<init>", "()V", "Code", "livehybrid-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class UserInfoResultModel implements k0 {

    @SerializedName("avatar")
    private String avatar;

    @SerializedName("code")
    private Code code;

    @SerializedName("douyin_uid")
    private Number douyin_uid;

    @SerializedName("is_login")
    private Number is_login;

    @SerializedName("is_silent")
    private Number is_silent;

    @SerializedName(InstantPlayContext.NICKNAME)
    private String nickname;

    @SerializedName("sec_user_id")
    private String sec_user_id;

    @SerializedName("short_id")
    private String short_id;

    @SerializedName("user_id")
    private String user_id;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002J\b\u0010\u0004\u001a\u00020\u0003H\u0016R\u0017\u0010\u0005\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/live/browser/jsbridge/base/UserInfoResultModel$Code;", "", "Le7/j0;", "", "getCode", "value", "I", "getValue", "()I", "Success", "Failed", "livehybrid-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum Code extends Enum<Code> implements j0 {
        public static final Code Failed = null;
        public static final Code Success = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Code[] f63187a = null;
        private final int value;

        static {
            Code r100 = new Code("Success", 0, 1);
            Success = r100;
            Code r101 = new Code("Failed", 1, 0);
            Failed = r101;
            f63187a = new Code[]{r100, r101};
        }

        public static Code valueOf(String r100) {
            return (Code) a.a(Code.class, r100);
        }

        public static Code[] values() {
            return (Code[]) f63187a.clone();
        }

        @Override // e7.j0
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

    public UserInfoResultModel() {
    }

    public final void a(String r100) {
        this.avatar = r100;
    }

    public final void b(Code r100) {
        this.code = r100;
    }

    public final void c(String r100) {
        this.nickname = r100;
    }

    public final void d(String r100) {
        this.sec_user_id = r100;
    }

    public final void e(String r100) {
        this.short_id = r100;
    }

    public final void f(String r100) {
        this.user_id = r100;
    }

    public final void g(Number r100) {
        this.is_login = r100;
    }

    public final void h(Number r100) {
        this.is_silent = r100;
    }
}
