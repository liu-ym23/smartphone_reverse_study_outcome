package com.bytedance.android.live.browser.jsbridge.newmethods;

import com.bytedance.android.livesdk.event.ISendCommentEvent;
import com.bytedance.android.livesdkapi.service.IPerformanceManager;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes45.dex */
@XBridgeMethod(biz = "webcast", name = "comment")
public final class f2 extends com.bytedance.ies.web.jsbridge2.f<a, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CompositeDisposable f63367a;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001c\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u0004\u001a\u0004\b\f\u0010\u0006R\u001c\u0010\r\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u0004\u001a\u0004\b\u000e\u0010\u0006R\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0004\u001a\u0004\b\u0010\u0010\u0006R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u00118\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, d2 = {"Lcom/bytedance/android/live/browser/jsbridge/newmethods/f2$a;", "", "", "type", "Ljava/lang/String;", "getType", "()Ljava/lang/String;", "content", "b", "requestSource", "c", "version", "f", "roomId", "d", "sender", "e", "Lorg/json/JSONObject;", "args", "Lorg/json/JSONObject;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Lorg/json/JSONObject;", "livehybrid-middleware-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class a {

        @SerializedName("args")
        private final JSONObject args;

        @SerializedName("content")
        private final String content;

        @SerializedName("request_source")
        private final String requestSource;

        @SerializedName("room_id")
        private final String roomId;

        @SerializedName("sender")
        private final String sender;

        @SerializedName("type")
        private final String type;

        @SerializedName("version")
        private final String version;

        public final boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof a) == false) goto L20;
            a r101 = (a) r100;
            if (Intrinsics.areEqual(this.type, r101.type) == true) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.content, r101.content) == true) goto L10;
            return false;
        L10:
            if (Intrinsics.areEqual(this.requestSource, r101.requestSource) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.version, r101.version) == true) goto L14;
            return false;
        L14:
            if (Intrinsics.areEqual(this.roomId, r101.roomId) == true) goto L16;
            return false;
        L16:
            if (Intrinsics.areEqual(this.sender, r101.sender) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.args, r101.args) == true) goto L31;
            return false;
        L31:
            return true;
        L20:
            return false;
        }

        public final int hashCode() {
            String r100 = this.type;
            int r101 = 0;
            if (r100 == null) goto L5;
            int r102 = r100.hashCode();
        L6:
            int r103 = r102 * 31;
            String r104 = this.content;
            if (r104 == null) goto L9;
            int r105 = r104.hashCode();
        L10:
            int r106 = (r103 + r105) * 31;
            String r107 = this.requestSource;
            if (r107 == null) goto L13;
            int r108 = r107.hashCode();
        L14:
            int r109 = (r106 + r108) * 31;
            String r110 = this.version;
            if (r110 == null) goto L17;
            int r111 = r110.hashCode();
        L18:
            int r112 = (r109 + r111) * 31;
            String r113 = this.roomId;
            if (r113 == null) goto L21;
            int r114 = r113.hashCode();
        L22:
            int r115 = (r112 + r114) * 31;
            String r116 = this.sender;
            if (r116 == null) goto L25;
            int r117 = r116.hashCode();
        L26:
            int r118 = (r115 + r117) * 31;
            JSONObject r119 = this.args;
            if (r119 == null) goto L30;
            r101 = r119.hashCode();
        L30:
            return r118 + r101;
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
            return "Params(type=" + this.type + ", content=" + this.content + ", requestSource=" + this.requestSource + ", version=" + this.version + ", roomId=" + this.roomId + ", sender=" + this.sender + ", args=" + this.args + ")";
        }

        public final JSONObject a() {
            return this.args;
        }

        public final String b() {
            return this.content;
        }

        public final String c() {
            return this.requestSource;
        }

        public final String d() {
            return this.roomId;
        }

        public final String e() {
            return this.sender;
        }

        public final String f() {
            return this.version;
        }

        public final String getType() {
            return this.type;
        }
    }

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void onTerminate() {
        this.f63367a.dispose();
    }

    public f2() {
        this.f63367a = new CompositeDisposable();
    }

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void invoke(a r110, CallContext r111) {
        a r112 = r110;
        Intrinsics.checkNotNullParameter(r112, "params");
        Intrinsics.checkNotNullParameter(r111, PerfLog.PARAM_KEY_CONTEXT_ID);
        com.bytedance.android.livesdk.interactivity.api.settings.config.n r113 = com.bytedance.android.livesdk.interactivity.api.monitor.b.f133316a;
        com.bytedance.android.livesdk.interactivity.api.monitor.b.d(r112.c(), r112.b());
        String r114 = r112.e();
        if (r114 != null) goto L6;
    L11:
        ISendCommentEvent.Sender r115 = ISendCommentEvent.Sender.Unknown;
    L12:
        ISendCommentEvent.Sender r100 = r115;
        final JSONObject r116 = r112.a();
        if (r116 == null) goto L16;
        Map r117 = MapsKt.toMap(SequencesKt.map(SequencesKt.asSequence(r116.keys()), new CommentMethod$asMap$1(r116)));
        if (r117 == null) goto L16;
    L17:
        Map r101 = MapsKt.toMutableMap(r117);
        r101.put("request_source", r112.c());
        r101.put("comment_jsb_room_id", r112.d());
        r101.put("comment_jsb_version", r112.f());
        String r118 = r112.getType();
        int r102 = r118.hashCode();
        if (r102 == (-333150752)) goto L25;
        if (r102 != 3556653) goto L43;
        if (r118.equals("text") == false) goto L43;
        Object r119 = new com.bytedance.android.livesdk.event.d0(r112.b(), r100, r101, null, null, true, 24);
    L28:
        if (com.bytedance.android.livesdk.s4.f157858a.getValue().booleanValue() == false) goto L40;
        LinkedHashMap r103 = new LinkedHashMap();
        String r104 = r112.e();
        String r105 = "";
        if (r104 != null) goto L32;
        r104 = "";
    L32:
        r103.put("sender", r104);
        r103.put("type", r112.getType());
        String r106 = r112.c();
        if (r106 != null) goto L35;
        r106 = "";
    L35:
        r103.put("request_source", r106);
        String r120 = r112.f();
        if (r120 == null) goto L39;
        r105 = r120;
    L39:
        r103.put("version", r105);
        r103.put("jsb_name", "comment");
        com.bytedance.android.livesdk.log.j0.l().sendLog("livesdk_comment_jsb_usage_stat", r103, new Object[0]);
    L40:
        xs2.b r121 = xs2.b.a();
        Disposable r107 = r121.b(com.bytedance.android.livesdk.event.z.class).filter(new g2(r119)).firstElement().subscribe(new h2(this, r119));
        this.f63367a.add(r107);
        r121.post(r119);
        return;
    L43:
        throw new IllegalArgumentException("unsupported comment type");
    L25:
        if (r118.equals(IPerformanceManager.MODULE_BARRAGE) == false) goto L43;
        r119 = new com.bytedance.android.livesdk.event.y(r112.b(), r100, r101);
    L16:
        r117 = MapsKt.emptyMap();
        goto L17
    L6:
        if (r114.hashCode() != 354670409) goto L11;
        if (r114.equals("lottery") == false) goto L11;
        r115 = ISendCommentEvent.Sender.Lottery;
        goto L12
    }
}
