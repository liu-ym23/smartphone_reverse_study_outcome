package com.bytedance.android.live.browser.jsbridge.base;

import com.amap.api.col.s.ce;
import com.bytedance.android.gamecp.business.instantplay.InstantPlayContext;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.List;
import kotlin.Metadata;
import w20.aa;
import w20.z9;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u000b\u0018\u00002\u00020\u0001:\u0004\u0019\u0007\u000e\u001aB\u0007¢\u0006\u0004\b\u0017\u0010\u0018R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016¨\u0006\u001b"}, d2 = {"Lcom/bytedance/android/live/browser/jsbridge/base/SearchFriendResultModel;", "Lw20/aa;", "Lcom/bytedance/android/live/browser/jsbridge/base/SearchFriendResultModel$Code;", "code", "Lcom/bytedance/android/live/browser/jsbridge/base/SearchFriendResultModel$Code;", "getCode", "()Lcom/bytedance/android/live/browser/jsbridge/base/SearchFriendResultModel$Code;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "(Lcom/bytedance/android/live/browser/jsbridge/base/SearchFriendResultModel$Code;)V", "Lcom/bytedance/android/live/browser/jsbridge/base/SearchFriendResultModel$a;", "data", "Lcom/bytedance/android/live/browser/jsbridge/base/SearchFriendResultModel$a;", "getData", "()Lcom/bytedance/android/live/browser/jsbridge/base/SearchFriendResultModel$a;", "b", "(Lcom/bytedance/android/live/browser/jsbridge/base/SearchFriendResultModel$a;)V", "", "msg", "Ljava/lang/String;", "getMsg", "()Ljava/lang/String;", "setMsg", "(Ljava/lang/String;)V", "<init>", "()V", "Code", "c", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class SearchFriendResultModel implements aa {

    @SerializedName("code")
    private Code code;

    @SerializedName("data")
    private a data;

    @SerializedName("msg")
    private String msg;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\n\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002J\b\u0010\u0004\u001a\u00020\u0003H\u0016R\u0017\u0010\u0005\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/bytedance/android/live/browser/jsbridge/base/SearchFriendResultModel$Code;", "", "Lw20/z9;", "", "getCode", "value", "I", "getValue", "()I", "Success", "Failed", "NO_PERMISSION", "NOT_REGISTER", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final enum Code extends Enum<Code> implements z9 {
        public static final Code Failed = null;
        public static final Code NOT_REGISTER = null;
        public static final Code NO_PERMISSION = null;
        public static final Code Success = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Code[] f63145a = null;
        private final int value;

        static {
            Code r100 = new Code("Success", 0, 1);
            Success = r100;
            Code r101 = new Code("Failed", 1, 0);
            Failed = r101;
            Code r102 = new Code("NO_PERMISSION", 2, -1);
            NO_PERMISSION = r102;
            Code r103 = new Code("NOT_REGISTER", 3, -2);
            NOT_REGISTER = r103;
            f63145a = new Code[]{r100, r101, r102, r103};
        }

        public static Code valueOf(String r100) {
            return (Code) r27.a.a(Code.class, r100);
        }

        public static Code[] values() {
            return (Code[]) f63145a.clone();
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

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\n\u0010\u000bR*\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\f"}, d2 = {"Lcom/bytedance/android/live/browser/jsbridge/base/SearchFriendResultModel$a;", "", "", "Lcom/bytedance/android/live/browser/jsbridge/base/SearchFriendResultModel$c;", "users", "Ljava/util/List;", "getUsers", "()Ljava/util/List;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "(Ljava/util/List;)V", "<init>", "()V", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class a {

        @SerializedName("users")
        private List<c> users;

        public a() {
        }

        public final void a(List<c> r100) {
            this.users = r100;
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0004\n\u0002\b\f\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\f\u0010\rR$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\b¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/live/browser/jsbridge/base/SearchFriendResultModel$b;", "", "", "location", "Ljava/lang/Number;", "getLocation", "()Ljava/lang/Number;", "b", "(Ljava/lang/Number;)V", "length", "getLength", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "<init>", "()V", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class b {

        @SerializedName("length")
        private Number length;

        @SerializedName("location")
        private Number location;

        public b() {
        }

        public final void a(Number r100) {
            this.length = r100;
        }

        public final void b(Number r100) {
            this.location = r100;
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u0004\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b#\u0010$R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0010\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0004\u001a\u0004\b\u0011\u0010\u0006\"\u0004\b\u0012\u0010\bR$\u0010\u0013\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u0004\u001a\u0004\b\u0014\u0010\u0006\"\u0004\b\u0015\u0010\bR$\u0010\u0016\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u0004\u001a\u0004\b\u0017\u0010\u0006\"\u0004\b\u0018\u0010\bR$\u0010\u001a\u001a\u0004\u0018\u00010\u00198\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR$\u0010 \u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b \u0010\u000b\u001a\u0004\b!\u0010\r\"\u0004\b\"\u0010\u000f¨\u0006%"}, d2 = {"Lcom/bytedance/android/live/browser/jsbridge/base/SearchFriendResultModel$c;", "", "", InstantPlayContext.NICKNAME, "Ljava/lang/String;", "getNickname", "()Ljava/lang/String;", "e", "(Ljava/lang/String;)V", "", "userId", "Ljava/lang/Number;", "getUserId", "()Ljava/lang/Number;", ce.f26391f, "(Ljava/lang/Number;)V", "secUid", "getSecUid", "f", "avatarUrl", "getAvatarUrl", "b", "account", "getAccount", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "Lcom/bytedance/android/live/browser/jsbridge/base/SearchFriendResultModel$b;", "highlightRange", "Lcom/bytedance/android/live/browser/jsbridge/base/SearchFriendResultModel$b;", "getHighlightRange", "()Lcom/bytedance/android/live/browser/jsbridge/base/SearchFriendResultModel$b;", "c", "(Lcom/bytedance/android/live/browser/jsbridge/base/SearchFriendResultModel$b;)V", "hitType", "getHitType", "d", "<init>", "()V", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class c {

        @SerializedName("account")
        private String account;

        @SerializedName("avatarUrl")
        private String avatarUrl;

        @SerializedName("highlightRange")
        private b highlightRange;

        @SerializedName("hitType")
        private Number hitType;

        @SerializedName(InstantPlayContext.NICKNAME)
        private String nickname;

        @SerializedName("secUid")
        private String secUid;

        @SerializedName("userId")
        private Number userId;

        public c() {
        }

        public final void a(String r100) {
            this.account = r100;
        }

        public final void b(String r100) {
            this.avatarUrl = r100;
        }

        public final void c(b r100) {
            this.highlightRange = r100;
        }

        public final void d(Number r100) {
            this.hitType = r100;
        }

        public final void e(String r100) {
            this.nickname = r100;
        }

        public final void f(String r100) {
            this.secUid = r100;
        }

        public final void g(Number r100) {
            this.userId = r100;
        }
    }

    public SearchFriendResultModel() {
    }

    public final void a(Code r100) {
        this.code = r100;
    }

    public final void b(a r100) {
        this.data = r100;
    }
}
