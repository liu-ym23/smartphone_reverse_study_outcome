package com.bytedance.android.live.browser.jsbridge.newmethods;

import android.text.TextUtils;
import com.bytedance.android.live.gson.ILiveGsonService;
import com.bytedance.android.livesdkapi.depend.live.vs.VSConstants;
import com.bytedance.android.livesdkapi.depend.model.live.emoji.ISelfEmoji;
import com.bytedance.android.livesdkapi.depend.model.live.episode.SelectAtUser;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.account.platform.api.IGoogleService;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.officesdk.api.init.OfficeSDKRequestTag;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.aweme.discover.model.ScoreTags;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes45.dex */
@XBridgeMethod(biz = "webcast", name = "openCommentPanel")
public final class p8 extends com.bytedance.ies.web.jsbridge2.f<b, Object> implements b30.i.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f63604a;

    public static final class a {
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b \n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001c\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u0004\u001a\u0004\b\f\u0010\u0006R\u001c\u0010\r\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u0004\u001a\u0004\b\u000e\u0010\u0006R\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0004\u001a\u0004\b\u0010\u0010\u0006R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0004\u001a\u0004\b\u0012\u0010\u0006R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u0004\u001a\u0004\b\u0014\u0010\u0006R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u0004\u001a\u0004\b\u0016\u0010\u0006R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0017\u0010\u0004\u001a\u0004\b\u0018\u0010\u0006R\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0019\u0010\u0004\u001a\u0004\b\u001a\u0010\u0006R\u001c\u0010\u001b\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001b\u0010\u0004\u001a\u0004\b\u001c\u0010\u0006R\u001c\u0010\u001d\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001d\u0010\u0004\u001a\u0004\b\u001e\u0010\u0006R\u001c\u0010\u001f\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001f\u0010\u0004\u001a\u0004\b \u0010\u0006R\u001c\u0010!\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b!\u0010\u0004\u001a\u0004\b\"\u0010\u0006R\u001c\u0010$\u001a\u0004\u0018\u00010#8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'¨\u0006("}, d2 = {"Lcom/bytedance/android/live/browser/jsbridge/newmethods/p8$b;", "", "", "content", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "requestSource", "l", "source", "m", "replyUserId", com.amap.api.col.s.ce.f26395j, "replyUserName", com.amap.api.col.s.ce.f26396k, "switchType", OfficeSDKRequestTag.KEY_NEW_USER, "preAtUserId", com.amap.api.col.s.ce.f26391f, "preAtSecUserId", "f", "preAtUserName", "h", "commentId", "b", "atInfo", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "pageName", "e", "toCommentCategory", "o", "replyClickPosition", RXScreenCaptureService.KEY_INDEX, "defaultPanel", "d", "Lcom/google/gson/JsonObject;", "trackParams", "Lcom/google/gson/JsonObject;", "p", "()Lcom/google/gson/JsonObject;", "livehybrid-middleware-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class b {

        @SerializedName("at_info")
        private final String atInfo;

        @SerializedName("comment_id")
        private final String commentId;

        @SerializedName("content")
        private final String content;

        @SerializedName("default_panel")
        private final String defaultPanel;

        @SerializedName("vs_event_page")
        private final String pageName;

        @SerializedName("pre_at_sec_user_id")
        private final String preAtSecUserId;

        @SerializedName("pre_at_user_id")
        private final String preAtUserId;

        @SerializedName("pre_at_user_name")
        private final String preAtUserName;

        @SerializedName("vs_reply_click_position")
        private final String replyClickPosition;

        @SerializedName("reply_user_id")
        private final String replyUserId;

        @SerializedName("reply_user_name")
        private final String replyUserName;

        @SerializedName("request_source")
        private final String requestSource;

        @SerializedName("message_source")
        private final String source;

        @SerializedName("switch_type")
        private final String switchType;

        @SerializedName(VSConstants.KEY_TO_COMMENT_CATEGORY)
        private final String toCommentCategory;

        @SerializedName("track_params")
        private final JsonObject trackParams;

        public final boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof b) == false) goto L38;
            b r101 = (b) r100;
            if (Intrinsics.areEqual(this.content, r101.content) == true) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.requestSource, r101.requestSource) == true) goto L10;
            return false;
        L10:
            if (Intrinsics.areEqual(this.source, r101.source) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.replyUserId, r101.replyUserId) == true) goto L14;
            return false;
        L14:
            if (Intrinsics.areEqual(this.replyUserName, r101.replyUserName) == true) goto L16;
            return false;
        L16:
            if (Intrinsics.areEqual(this.switchType, r101.switchType) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.preAtUserId, r101.preAtUserId) == true) goto L20;
            return false;
        L20:
            if (Intrinsics.areEqual(this.preAtSecUserId, r101.preAtSecUserId) == true) goto L22;
            return false;
        L22:
            if (Intrinsics.areEqual(this.preAtUserName, r101.preAtUserName) == true) goto L24;
            return false;
        L24:
            if (Intrinsics.areEqual(this.commentId, r101.commentId) == true) goto L26;
            return false;
        L26:
            if (Intrinsics.areEqual(this.atInfo, r101.atInfo) == true) goto L28;
            return false;
        L28:
            if (Intrinsics.areEqual(this.pageName, r101.pageName) == true) goto L30;
            return false;
        L30:
            if (Intrinsics.areEqual(this.toCommentCategory, r101.toCommentCategory) == true) goto L32;
            return false;
        L32:
            if (Intrinsics.areEqual(this.replyClickPosition, r101.replyClickPosition) == true) goto L34;
            return false;
        L34:
            if (Intrinsics.areEqual(this.defaultPanel, r101.defaultPanel) == true) goto L36;
            return false;
        L36:
            if (Intrinsics.areEqual(this.trackParams, r101.trackParams) == true) goto L58;
            return false;
        L58:
            return true;
        L38:
            return false;
        }

        public final int hashCode() {
            String r100 = this.content;
            int r101 = 0;
            if (r100 == null) goto L5;
            int r102 = r100.hashCode();
        L6:
            int r103 = r102 * 31;
            String r104 = this.requestSource;
            if (r104 == null) goto L9;
            int r105 = r104.hashCode();
        L10:
            int r106 = (r103 + r105) * 31;
            String r107 = this.source;
            if (r107 == null) goto L13;
            int r108 = r107.hashCode();
        L14:
            int r109 = (r106 + r108) * 31;
            String r110 = this.replyUserId;
            if (r110 == null) goto L17;
            int r111 = r110.hashCode();
        L18:
            int r112 = (r109 + r111) * 31;
            String r113 = this.replyUserName;
            if (r113 == null) goto L21;
            int r114 = r113.hashCode();
        L22:
            int r115 = (r112 + r114) * 31;
            String r116 = this.switchType;
            if (r116 == null) goto L25;
            int r117 = r116.hashCode();
        L26:
            int r118 = (r115 + r117) * 31;
            String r119 = this.preAtUserId;
            if (r119 == null) goto L29;
            int r120 = r119.hashCode();
        L30:
            int r121 = (r118 + r120) * 31;
            String r122 = this.preAtSecUserId;
            if (r122 == null) goto L33;
            int r123 = r122.hashCode();
        L34:
            int r124 = (r121 + r123) * 31;
            String r125 = this.preAtUserName;
            if (r125 == null) goto L37;
            int r126 = r125.hashCode();
        L38:
            int r127 = (r124 + r126) * 31;
            String r128 = this.commentId;
            if (r128 == null) goto L41;
            int r129 = r128.hashCode();
        L42:
            int r130 = (r127 + r129) * 31;
            String r131 = this.atInfo;
            if (r131 == null) goto L45;
            int r132 = r131.hashCode();
        L46:
            int r133 = (r130 + r132) * 31;
            String r134 = this.pageName;
            if (r134 == null) goto L49;
            int r135 = r134.hashCode();
        L50:
            int r136 = (r133 + r135) * 31;
            String r137 = this.toCommentCategory;
            if (r137 == null) goto L53;
            int r138 = r137.hashCode();
        L54:
            int r139 = (r136 + r138) * 31;
            String r140 = this.replyClickPosition;
            if (r140 == null) goto L57;
            int r141 = r140.hashCode();
        L58:
            int r142 = (r139 + r141) * 31;
            String r143 = this.defaultPanel;
            if (r143 == null) goto L61;
            int r144 = r143.hashCode();
        L62:
            int r145 = (r142 + r144) * 31;
            JsonObject r146 = this.trackParams;
            if (r146 == null) goto L66;
            r101 = r146.hashCode();
        L66:
            return r145 + r101;
        L61:
            r144 = 0;
            goto L62
        L57:
            r141 = 0;
            goto L58
        L53:
            r138 = 0;
            goto L54
        L49:
            r135 = 0;
            goto L50
        L45:
            r132 = 0;
            goto L46
        L41:
            r129 = 0;
            goto L42
        L37:
            r126 = 0;
            goto L38
        L33:
            r123 = 0;
            goto L34
        L29:
            r120 = 0;
            goto L30
        L25:
            r117 = 0;
            goto L26
        L21:
            r114 = 0;
            goto L22
        L17:
            r111 = 0;
            goto L18
        L13:
            r108 = 0;
            goto L14
        L9:
            r105 = 0;
            goto L10
        L5:
            r102 = 0;
            goto L6
        }

        public final String toString() {
            return "Params(content=" + this.content + ", requestSource=" + this.requestSource + ", source=" + this.source + ", replyUserId=" + this.replyUserId + ", replyUserName=" + this.replyUserName + ", switchType=" + this.switchType + ", preAtUserId=" + this.preAtUserId + ", preAtSecUserId=" + this.preAtSecUserId + ", preAtUserName=" + this.preAtUserName + ", commentId=" + this.commentId + ", atInfo=" + this.atInfo + ", pageName=" + this.pageName + ", toCommentCategory=" + this.toCommentCategory + ", replyClickPosition=" + this.replyClickPosition + ", defaultPanel=" + this.defaultPanel + ", trackParams=" + this.trackParams + ")";
        }

        public final String a() {
            return this.atInfo;
        }

        public final String b() {
            return this.commentId;
        }

        public final String c() {
            return this.content;
        }

        public final String d() {
            return this.defaultPanel;
        }

        public final String e() {
            return this.pageName;
        }

        public final String f() {
            return this.preAtSecUserId;
        }

        public final String g() {
            return this.preAtUserId;
        }

        public final String h() {
            return this.preAtUserName;
        }

        public final String i() {
            return this.replyClickPosition;
        }

        public final String j() {
            return this.replyUserId;
        }

        public final String k() {
            return this.replyUserName;
        }

        public final String l() {
            return this.requestSource;
        }

        public final String m() {
            return this.source;
        }

        public final String n() {
            return this.switchType;
        }

        public final String o() {
            return this.toCommentCategory;
        }

        public final JsonObject p() {
            return this.trackParams;
        }
    }

    static {
    }

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void onTerminate() {
    }

    public p8() {
    }

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void invoke(b r210, CallContext r310) {
        b r100 = r210;
        Intrinsics.checkNotNullParameter(r100, "params");
        Intrinsics.checkNotNullParameter(r310, PerfLog.PARAM_KEY_CONTEXT_ID);
        com.bytedance.android.livesdk.interactivity.api.settings.config.n r101 = com.bytedance.android.livesdk.interactivity.api.monitor.b.f133316a;
        com.bytedance.android.livesdk.interactivity.api.monitor.b.d(r100.m(), r100.c());
        long r110 = System.currentTimeMillis();
        String r102 = r100.g();
        String r103 = r100.f();
        String r104 = r100.h();
        if (TextUtils.isEmpty(r102) == true) goto L5;
    L13:
        String r211 = r102;
        String r212 = r103;
        String r213 = r104;
        this.f63604a = !Intrinsics.areEqual(r100.m(), "vs_send_danmaku");
        String r105 = r100.c();
        String r106 = r100.m();
        if (r106 != null) goto L16;
        String r107 = "jsbridge";
    L17:
        xs2.b.a().post(new b30.i(r105, "jsbridge", r107, this, new b30.h(r100.j(), r100.k(), r100.n(), r211, r212, r213, r100.b(), r100.e(), r100.o(), r100.i()), r100.l(), r100.d(), r110, true, r100.p(), null, null, null, 7168));
        if (com.bytedance.android.livesdk.s4.f157858a.getValue().booleanValue() == false) goto L26;
        LinkedHashMap r108 = new LinkedHashMap();
        r108.put("sender", "jsbridge");
        String r109 = r100.l();
        if (r109 != null) goto L22;
        r109 = "";
    L22:
        r108.put("request_source", r109);
        r108.put("jsb_name", "openCommentPanel");
        com.bytedance.android.livesdk.log.j0.l().sendLog("livesdk_comment_jsb_usage_stat", r108, new Object[0]);
        return;
    L26:
        return;
    L16:
        r107 = r106;
        goto L17
    L5:
        if (TextUtils.isEmpty(r103) == false) goto L13;
        if (TextUtils.isEmpty(r104) == false) goto L13;
        if (TextUtils.isEmpty(r100.a()) == true) goto L13;
        JsonObject r111 = (JsonObject) ((ILiveGsonService) jc1.k.n(ILiveGsonService.class)).get().fromJson(r100.a(), JsonObject.class);     // Catch: Exception -> L12
        r102 = r111.get("pre_at_user_id").getAsString();     // Catch: Exception -> L12
        r103 = r111.get("pre_at_sec_user_id").getAsString();     // Catch: Exception -> L12
        r104 = r111.get("pre_at_user_name").getAsString();     // Catch: Exception -> L12
    L12:
        x8.a.d("OpenCommentPanelMethod", "opt params fail", false);
        goto L13
    }

    @Override // b30.i.a
    public final void onCommentSuccess(CharSequence r100, ISelfEmoji r101, List<SelectAtUser> r102) {
        if (this.f63604a == true) goto L5;
        return;
    L5:
        JSONObject r103 = new JSONObject();
        r103.put("status_code", 1);
        String r104 = "";
        Object r105 = "".toString();
        if (r105 != null) goto L8;
        r105 = "";
    L8:
        r103.put("message", r105);
        JSONObject r106 = new JSONObject();
        r106.put("height", null);
        r106.put("width", null);
        r106.put("id", null);
        JSONArray r107 = new JSONArray();
        Unit r108 = Unit.INSTANCE;
        r106.put(ScoreTags.STAR_URL_LIST, r107);
        r106.put("is_gif", null);
        r106.put("web_uri", null);
        r106.put("animate_type", null);
        r106.put(IGoogleService.ResponseKey.DISPLAY_NAME, null);
        r103.put("image", r106);
        r103.put("at_info", new JSONArray());
        String r109 = "".toString();
        if (r109 != null) goto L11;
        r109 = "";
    L11:
        int r110 = r109.length();
        int r111 = 0;
        int r112 = 0;
    L12:
        if (r112 >= r110) goto L17;
        if (com.bytedance.android.livesdk.utils.l1.b(r109.charAt(r112)) == true) goto L15;
        r112 = r112 + 1;
        goto L12
    L15:
        int r113 = 1;
    L18:
        String r114 = "".toString();
        if (r114 == null) goto L22;
        r104 = r114;
    L22:
        boolean r115 = com.bytedance.android.livesdk.utils.l1.a(r104);
        r103.put("has_keyboard_emoji", r115 ? 1 : 0);
        r103.put("has_system_emoji", r113);
        if (r115 == true) goto L26;
        if (r113 != 0) goto L26;
        r111 = 1;
    L26:
        r103.put("is_pure_text", r111);
        r103.put("has_emoji_package", !TextUtils.isEmpty(null) ? 1 : 0);
        JSONObject r116 = new JSONObject();
        r116.put("code", 1);
        r116.put("data", r103);
        finishWithResult(r116);
        return;
    L17:
        r113 = 0;
        goto L18
    }
}
