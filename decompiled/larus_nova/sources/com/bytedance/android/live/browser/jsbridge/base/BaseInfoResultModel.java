package com.bytedance.android.live.browser.jsbridge.base;

import com.amap.api.col.s.ce;
import com.bytedance.android.gamecp.business.instantplay.InstantPlayContext;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.bytedance.android.livesdkapi.performance.ILoadStallMonitor;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import w20.aa;
import w20.z9;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\n\u0018\u00002\u00020\u0001:\u0004\u001c\u0007\u0015'B\u0007¢\u0006\u0004\b%\u0010&R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R$\u0010\u0018\u001a\u0004\u0018\u00010\u00178\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR$\u0010\u001f\u001a\u0004\u0018\u00010\u001e8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$¨\u0006("}, d2 = {"Lcom/bytedance/android/live/browser/jsbridge/base/BaseInfoResultModel;", "Lw20/aa;", "Lcom/bytedance/android/live/browser/jsbridge/base/BaseInfoResultModel$Code;", "code", "Lcom/bytedance/android/live/browser/jsbridge/base/BaseInfoResultModel$Code;", "getCode", "()Lcom/bytedance/android/live/browser/jsbridge/base/BaseInfoResultModel$Code;", "b", "(Lcom/bytedance/android/live/browser/jsbridge/base/BaseInfoResultModel$Code;)V", "Lcom/bytedance/android/live/browser/jsbridge/base/BaseInfoResultModel$c;", "user_info", "Lcom/bytedance/android/live/browser/jsbridge/base/BaseInfoResultModel$c;", "getUser_info", "()Lcom/bytedance/android/live/browser/jsbridge/base/BaseInfoResultModel$c;", "e", "(Lcom/bytedance/android/live/browser/jsbridge/base/BaseInfoResultModel$c;)V", "Lcom/bytedance/android/live/browser/jsbridge/base/BaseInfoResultModel$b;", "room_info", "Lcom/bytedance/android/live/browser/jsbridge/base/BaseInfoResultModel$b;", "getRoom_info", "()Lcom/bytedance/android/live/browser/jsbridge/base/BaseInfoResultModel$b;", "c", "(Lcom/bytedance/android/live/browser/jsbridge/base/BaseInfoResultModel$b;)V", "Lcom/bytedance/android/live/browser/jsbridge/base/BaseInfoResultModel$a;", "anchor_info", "Lcom/bytedance/android/live/browser/jsbridge/base/BaseInfoResultModel$a;", "getAnchor_info", "()Lcom/bytedance/android/live/browser/jsbridge/base/BaseInfoResultModel$a;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "(Lcom/bytedance/android/live/browser/jsbridge/base/BaseInfoResultModel$a;)V", "", ILoadStallMonitor.START_TIME, "Ljava/lang/String;", "getStart_time", "()Ljava/lang/String;", "d", "(Ljava/lang/String;)V", "<init>", "()V", "Code", "livehybrid-middleware-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class BaseInfoResultModel implements aa {

    @SerializedName("anchor_info")
    private a anchor_info;

    @SerializedName("code")
    private Code code;

    @SerializedName("room_info")
    private b room_info;

    @SerializedName(ILoadStallMonitor.START_TIME)
    private String start_time;

    @SerializedName("user_info")
    private c user_info;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002J\b\u0010\u0004\u001a\u00020\u0003H\u0016R\u0017\u0010\u0005\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/live/browser/jsbridge/base/BaseInfoResultModel$Code;", "", "Lw20/z9;", "", "getCode", "value", "I", "getValue", "()I", "Success", "Failed", "livehybrid-middleware-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum Code extends Enum<Code> implements z9 {
        public static final Code Failed = null;
        public static final Code Success = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Code[] f62959a = null;
        private final int value;

        static {
            Code r100 = new Code("Success", 0, 1);
            Success = r100;
            Code r101 = new Code("Failed", 1, 0);
            Failed = r101;
            f62959a = new Code[]{r100, r101};
        }

        public static Code valueOf(String r100) {
            return (Code) r27.a.a(Code.class, r100);
        }

        public static Code[] values() {
            return (Code[]) f62959a.clone();
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

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0012\n\u0002\u0010\u0004\n\u0002\b\u000f\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\"\u0010#R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR$\u0010\f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR$\u0010\u000f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0004\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR$\u0010\u0012\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0004\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\bR$\u0010\u0016\u001a\u0004\u0018\u00010\u00158\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR$\u0010\u001c\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010\u0004\u001a\u0004\b\u001d\u0010\u0006\"\u0004\b\u001e\u0010\bR$\u0010\u001f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010\u0004\u001a\u0004\b \u0010\u0006\"\u0004\b!\u0010\b¨\u0006$"}, d2 = {"Lcom/bytedance/android/live/browser/jsbridge/base/BaseInfoResultModel$a;", "", "", "avatar", "Ljava/lang/String;", "getAvatar", "()Ljava/lang/String;", "c", "(Ljava/lang/String;)V", InstantPlayContext.NICKNAME, "getNickname", "e", "short_id", "getShort_id", ce.f26391f, "user_id", "getUser_id", "h", "sec_user_id", "getSec_user_id", "f", "", "anchor_level", "Ljava/lang/Number;", "getAnchor_level", "()Ljava/lang/Number;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "(Ljava/lang/Number;)V", "anchor_type", "getAnchor_type", "b", "display_id", "getDisplay_id", "d", "<init>", "()V", "livehybrid-middleware-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class a {

        @SerializedName("anchor_level")
        private Number anchor_level;

        @SerializedName("anchor_type")
        private String anchor_type;

        @SerializedName("avatar")
        private String avatar;

        @SerializedName("display_id")
        private String display_id;

        @SerializedName(InstantPlayContext.NICKNAME)
        private String nickname;

        @SerializedName("sec_user_id")
        private String sec_user_id;

        @SerializedName("short_id")
        private String short_id;

        @SerializedName("user_id")
        private String user_id;

        public a() {
        }

        public final void a(Number r100) {
            this.anchor_level = r100;
        }

        public final void b(String r100) {
            this.anchor_type = r100;
        }

        public final void c(String r100) {
            this.avatar = r100;
        }

        public final void d(String r100) {
            this.display_id = r100;
        }

        public final void e(String r100) {
            this.nickname = r100;
        }

        public final void f(String r100) {
            this.sec_user_id = r100;
        }

        public final void g(String r100) {
            this.short_id = r100;
        }

        public final void h(String r100) {
            this.user_id = r100;
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u0004\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0013\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b!\u0010\"R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0011\u0010\u0013\"\u0004\b\u0014\u0010\u0015R$\u0010\u0016\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u000b\u001a\u0004\b\u0017\u0010\r\"\u0004\b\u0018\u0010\u000fR$\u0010\u0019\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u000b\u001a\u0004\b\u001a\u0010\r\"\u0004\b\u001b\u0010\u000fR$\u0010\u001c\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010\u000b\u001a\u0004\b\u001d\u0010\r\"\u0004\b\u001e\u0010\u000fR$\u0010\u001f\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010\u0012\u001a\u0004\b\u001f\u0010\u0013\"\u0004\b \u0010\u0015¨\u0006#"}, d2 = {"Lcom/bytedance/android/live/browser/jsbridge/base/BaseInfoResultModel$b;", "", "", "room_id", "Ljava/lang/String;", "getRoom_id", "()Ljava/lang/String;", "d", "(Ljava/lang/String;)V", "", ILiveRoomPlayFragmentConstant.EXTRA_ROOM_LAYOUT, "Ljava/lang/Number;", "getRoom_layout", "()Ljava/lang/Number;", "e", "(Ljava/lang/Number;)V", "", "is_paidlive", "Ljava/lang/Boolean;", "()Ljava/lang/Boolean;", ce.f26391f, "(Ljava/lang/Boolean;)V", "live_room_mode", "getLive_room_mode", "b", "game_points_playing", "getGame_points_playing", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "quiz_game_points_playing", "getQuiz_game_points_playing", "c", "is_life", "f", "<init>", "()V", "livehybrid-middleware-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class b {

        @SerializedName("game_points_playing")
        private Number game_points_playing;

        @SerializedName("is_life")
        private Boolean is_life;

        @SerializedName("is_paidlive")
        private Boolean is_paidlive;

        @SerializedName("live_room_mode")
        private Number live_room_mode;

        @SerializedName("quiz_game_points_playing")
        private Number quiz_game_points_playing;

        @SerializedName("room_id")
        private String room_id;

        @SerializedName(ILiveRoomPlayFragmentConstant.EXTRA_ROOM_LAYOUT)
        private Number room_layout;

        public b() {
        }

        public final void a(Number r100) {
            this.game_points_playing = r100;
        }

        public final void b(Number r100) {
            this.live_room_mode = r100;
        }

        public final void c(Number r100) {
            this.quiz_game_points_playing = r100;
        }

        public final void d(String r100) {
            this.room_id = r100;
        }

        public final void e(Number r100) {
            this.room_layout = r100;
        }

        public final void f(Boolean r100) {
            this.is_life = r100;
        }

        public final void g(Boolean r100) {
            this.is_paidlive = r100;
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0012\n\u0002\u0010\u0004\n\u0002\b\u000f\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\"\u0010#R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR$\u0010\f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR$\u0010\u000f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0004\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR$\u0010\u0012\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0004\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\bR$\u0010\u0016\u001a\u0004\u0018\u00010\u00158\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR$\u0010\u001c\u001a\u0004\u0018\u00010\u00158\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010\u0017\u001a\u0004\b\u001d\u0010\u0019\"\u0004\b\u001e\u0010\u001bR$\u0010\u001f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010\u0004\u001a\u0004\b \u0010\u0006\"\u0004\b!\u0010\b¨\u0006$"}, d2 = {"Lcom/bytedance/android/live/browser/jsbridge/base/BaseInfoResultModel$c;", "", "", "avatar", "Ljava/lang/String;", "getAvatar", "()Ljava/lang/String;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "(Ljava/lang/String;)V", InstantPlayContext.NICKNAME, "getNickname", "c", "sec_user_id", "getSec_user_id", "d", "short_id", "getShort_id", "e", "user_id", "getUser_id", "f", "", "user_level", "Ljava/lang/Number;", "getUser_level", "()Ljava/lang/Number;", ce.f26391f, "(Ljava/lang/Number;)V", "user_type", "getUser_type", "h", "display_id", "getDisplay_id", "b", "<init>", "()V", "livehybrid-middleware-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class c {

        @SerializedName("avatar")
        private String avatar;

        @SerializedName("display_id")
        private String display_id;

        @SerializedName(InstantPlayContext.NICKNAME)
        private String nickname;

        @SerializedName("sec_user_id")
        private String sec_user_id;

        @SerializedName("short_id")
        private String short_id;

        @SerializedName("user_id")
        private String user_id;

        @SerializedName("user_level")
        private Number user_level;

        @SerializedName("user_type")
        private Number user_type;

        public c() {
        }

        public final void a(String r100) {
            this.avatar = r100;
        }

        public final void b(String r100) {
            this.display_id = r100;
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
            this.user_level = r100;
        }

        public final void h(Number r100) {
            this.user_type = r100;
        }
    }

    public BaseInfoResultModel() {
    }

    public final void a(a r100) {
        this.anchor_info = r100;
    }

    public final void b(Code r100) {
        this.code = r100;
    }

    public final void c(b r100) {
        this.room_info = r100;
    }

    public final void d(String r100) {
        this.start_time = r100;
    }

    public final void e(c r100) {
        this.user_info = r100;
    }
}
