package com.bytedance.ai.miniappevent;

import com.bytedance.ai.applet.app.AppletApplication;
import com.bytedance.ai.applet.app.OnlineAppletApplication;
import com.bytedance.ai.applet.services.AppletAppManagerService;
import com.bytedance.ai.model.AppletRuntime;
import com.bytedance.ai.model.LynxWorkerRuntime;
import com.bytedance.ai.utils.g;
import com.bytedance.ee.bear.middleground.comment.aibot.model.AiBotPollingAuthResult;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonPrimitive;
import com.huawei.hms.push.constant.RemoteMessageConst;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.SupervisorKt;

/* JADX INFO: loaded from: classes43.dex */
public final class AIMiniAppEventCenter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final AIMiniAppEventCenter f36687a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Set<String> f36688b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final CoroutineScope f36689c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Object f36690d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final LinkedHashMap<String, Long> f36691e = null;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f36692a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f36693b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L8;
            return false;
        L8:
            a r101 = (a) r100;
            if (Intrinsics.areEqual(this.f36692a, r101.f36692a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f36693b, r101.f36693b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (this.f36692a.hashCode() * 31) + this.f36693b.hashCode();
        }

        public final String toString() {
            return "MiniAppEvent(name=" + this.f36692a + ", payloadJson=" + this.f36693b + ')';
        }

        public a(String r100, String r101) {
            Intrinsics.checkNotNullParameter(r100, "name");
            Intrinsics.checkNotNullParameter(r101, "payloadJson");
            this.f36692a = r100;
            this.f36693b = r101;
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f36694a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f36695b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final boolean f36696c;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L8;
            return false;
        L8:
            b r101 = (b) r100;
            if (Intrinsics.areEqual(this.f36694a, r101.f36694a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f36695b, r101.f36695b) == true) goto L15;
            return false;
        L15:
            if (this.f36696c == r101.f36696c) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            int r100 = this.f36694a.hashCode() * 31;
            String r101 = this.f36695b;
            if (r101 != null) goto L5;
            int r102 = 0;
        L6:
            int r103 = (r100 + r102) * 31;
            if (this.f36696c == false) goto L9;
            int r104 = 1231;
        L11:
            return r103 + r104;
        L9:
            r104 = 1237;
            goto L11
        L5:
            r102 = r101.hashCode();
            goto L6
        }

        public final String toString() {
            return "MiniAppEventDispatchContext(source=" + this.f36694a + ", nativeTrigger=" + this.f36695b + ", startRuntimeIfNeeded=" + this.f36696c + ')';
        }

        public b(String r100, String r101, boolean r102) {
            Intrinsics.checkNotNullParameter(r100, "source");
            this.f36694a = r100;
            this.f36695b = r101;
            this.f36696c = r102;
        }
    }

    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f36697a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f36698b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f36699c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final String f36700d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final String f36701e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final long f36702f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final long f36703g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final a f36704h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final String f36705i;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof c) == true) goto L8;
            return false;
        L8:
            c r101 = (c) r100;
            if (this.f36697a == r101.f36697a) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f36698b, r101.f36698b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f36699c, r101.f36699c) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.f36700d, r101.f36700d) == true) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(this.f36701e, r101.f36701e) == true) goto L24;
            return false;
        L24:
            if (this.f36702f == r101.f36702f) goto L27;
            return false;
        L27:
            if (this.f36703g == r101.f36703g) goto L30;
            return false;
        L30:
            if (Intrinsics.areEqual(this.f36704h, r101.f36704h) == true) goto L33;
            return false;
        L33:
            if (Intrinsics.areEqual(this.f36705i, r101.f36705i) == true) goto L35;
            return false;
        L35:
            return true;
        }

        public final int hashCode() {
            int r100 = ((((((((this.f36697a * 31) + this.f36698b.hashCode()) * 31) + this.f36699c.hashCode()) * 31) + this.f36700d.hashCode()) * 31) + this.f36701e.hashCode()) * 31;
            long r101 = this.f36702f;
            int r102 = (r100 + ((int) (r101 ^ (r101 >>> 32)))) * 31;
            long r103 = this.f36703g;
            return ((((r102 + ((int) (r103 ^ (r103 >>> 32)))) * 31) + this.f36704h.hashCode()) * 31) + this.f36705i.hashCode();
        }

        public final String toString() {
            return "MiniAppEventNotify(protocolVersion=" + this.f36697a + ", eventType=" + this.f36698b + ", eventId=" + this.f36699c + ", msgId=" + this.f36700d + ", appKey=" + this.f36701e + ", timestamp=" + this.f36702f + ", expireAt=" + this.f36703g + ", event=" + this.f36704h + ", logId=" + this.f36705i + ')';
        }

        public c(int r100, String r101, String r102, String r103, String r104, long r105, long r106, a r110, String r111) {
            Intrinsics.checkNotNullParameter(r101, "eventType");
            Intrinsics.checkNotNullParameter(r102, com.heytap.mcssdk.constant.b.f276361k);
            Intrinsics.checkNotNullParameter(r103, RemoteMessageConst.MSGID);
            Intrinsics.checkNotNullParameter(r104, com.heytap.mcssdk.constant.b.f276376z);
            Intrinsics.checkNotNullParameter(r110, "event");
            Intrinsics.checkNotNullParameter(r111, "logId");
            this.f36697a = r100;
            this.f36698b = r101;
            this.f36699c = r102;
            this.f36700d = r103;
            this.f36701e = r104;
            this.f36702f = r105;
            this.f36703g = r106;
            this.f36704h = r110;
            this.f36705i = r111;
        }
    }

    public AIMiniAppEventCenter() {
    }

    static {
        f36687a = new AIMiniAppEventCenter();
        f36688b = SetsKt.setOf("page_event");
        f36689c = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default(null, 1, null).plus(com.bytedance.ai.infra.thread_pool.b.f36602c));
        f36690d = new Object();
        f36691e = new LinkedHashMap();
    }

    public static void b(String r100) {
        Intrinsics.checkNotNullParameter(r100, "rawValue");
        BuildersKt.launch$default(f36689c, null, null, new AIMiniAppEventCenter$enqueue$1(r100, null), 3, null);
    }

    public static void c(com.bytedance.ai.miniappevent.a r210) {
        Intrinsics.checkNotNullParameter(r210, "event");
        if (r210.f36715h > 0) goto L6;
        g.f37637a.w("AIMiniAppEventCenter", "reject event, stage=native_ingress, reason=invalid_ttl");
        return;
    L6:
        long r100 = System.currentTimeMillis();
        long r101 = Long.MAX_VALUE - r100;
        long r102 = r210.f36715h;
        if (r101 >= r102) goto L9;
        long r110 = Long.MAX_VALUE;
    L10:
        String r103 = r210.f36709b;
        String r104 = r210.f36713f;
        if (r104 != null) goto L13;
    L17:
        r104 = r210.f36709b;
    L18:
        String r105 = r104;
        String r106 = r210.f36708a;
        a r111 = new a(r210.f36710c, r210.f36711d.toString());
        String r107 = r210.f36714g;
        if (r107 != null) goto L21;
    L25:
        r107 = r210.f36709b;
    L26:
        BuildersKt.launch$default(f36689c, null, null, new AIMiniAppEventCenter$enqueueNative$1(new c(1, "page_event", r103, r105, r106, r100, r110, r111, r107), r210, null), 3, null);
        return;
    L21:
        if ((!StringsKt.isBlank(r107)) == true) goto L24;
        r107 = null;
    L24:
        if (r107 != null) goto L26;
    L13:
        if ((!StringsKt.isBlank(r104)) == true) goto L16;
        r104 = null;
    L16:
        if (r104 != null) goto L18;
    L9:
        r110 = r102 + r100;
        goto L10
    }

    public static String d(c r100) {
        return "eventId=" + r100.f36699c + ", appKey=" + r100.f36701e + ", logId=" + r100.f36705i + ", eventName=" + r100.f36704h.f36692a;
    }

    public static JsonPrimitive e(JsonElement r100) {
        if (r100 == null) goto L10;
        if (r100.isJsonPrimitive() == false) goto L8;
        return r100.getAsJsonPrimitive();
    L8:
        throw new IllegalArgumentException("Failed requirement.".toString());
    L10:
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    public static int f(JsonObject r100) {
        JsonPrimitive r101 = e(r100.get("protocol_version"));
        if (r101.isNumber() == false) goto L11;
        Integer r102 = StringsKt.toIntOrNull(r101.getAsString());
        if (r102 == null) goto L9;
        return r102.intValue();
    L9:
        throw new IllegalArgumentException("Required value was null.".toString());
    L11:
        throw new IllegalArgumentException("Failed requirement.".toString());
    }

    public static long g(JsonObject r100, String r101) {
        JsonPrimitive r102 = e(r100.get(r101));
        if (r102.isNumber() == false) goto L11;
        Long r103 = StringsKt.toLongOrNull(r102.getAsString());
        if (r103 == null) goto L9;
        return r103.longValue();
    L9:
        throw new IllegalArgumentException("Required value was null.".toString());
    L11:
        throw new IllegalArgumentException("Failed requirement.".toString());
    }

    public static String h(JsonObject r100, String r101) {
        JsonPrimitive r102 = e(r100.get(r101));
        if (r102.isString() == false) goto L10;
        String r103 = r102.getAsString();
        Intrinsics.checkNotNull(r103);
        if ((!StringsKt.isBlank(r103)) == false) goto L8;
        return r103;
    L8:
        throw new IllegalArgumentException("Failed requirement.".toString());
    L10:
        throw new IllegalArgumentException("Failed requirement.".toString());
    }

    public final Object i(String r110, boolean r111, Continuation<? super AppletRuntime> r112) {
        if ((r112 instanceof AIMiniAppEventCenter$resolveAppletRuntime$1) == false) goto L7;
        AIMiniAppEventCenter$resolveAppletRuntime$1 r100 = (AIMiniAppEventCenter$resolveAppletRuntime$1) r112;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r113 = r100.result;
        Object r102 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r103 = r100.label;
        boolean r104 = false;
        Boolean r105 = null;
        if (r103 == 0) goto L14;
        if (r103 != 1) goto L13;
        r110 = (String) r100.L$0;
        ResultKt.throwOnFailure(r113);
    L19:
        AppletApplication r114 = (AppletApplication) r113;
        g r115 = g.f37637a;
        StringBuilder r106 = new StringBuilder("resolve runtime, stage=provide_app, appletId=");
        r106.append(r110);
        r106.append(", found=");
        if (r114 == null) goto L22;
        boolean r107 = true;
    L23:
        r106.append(r107);
        r115.i("AIMiniAppEventCenter", r106.toString());
        if ((r114 instanceof OnlineAppletApplication) == false) goto L26;
        OnlineAppletApplication r116 = (OnlineAppletApplication) r114;
    L27:
        if (r116 == null) goto L29;
        LynxWorkerRuntime r117 = r116.K();
    L30:
        StringBuilder r108 = new StringBuilder("resolve runtime, stage=wake_runtime, appletId=");
        r108.append(r110);
        r108.append(", found=");
        if (r117 == null) goto L33;
        r104 = true;
    L33:
        r108.append(r104);
        r108.append(", terminated=");
        if (r117 == null) goto L36;
        r105 = Boxing.boxBoolean(r117.H());
    L36:
        r108.append(r105);
        r115.i("AIMiniAppEventCenter", r108.toString());
        return r117;
    L29:
        r117 = null;
        goto L30
    L26:
        r116 = null;
        goto L27
    L22:
        r107 = false;
        goto L23
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r113);
        if (r111 == false) goto L37;
        AppletAppManagerService r118 = AppletAppManagerService.INSTANCE;
        r100.L$0 = r110;
        r100.label = 1;
        r113 = r118.d(r110, r100);
        if (r113 != r102) goto L19;
        return r102;
    L37:
        AppletAppManagerService.INSTANCE.getClass();
        OnlineAppletApplication r119 = AppletAppManagerService.b(r110);
        g r120 = g.f37637a;
        StringBuilder r109 = new StringBuilder("resolve runtime, stage=find_app, appletId=");
        r109.append(r110);
        r109.append(", found=");
        if (r119 == null) goto L40;
        boolean r121 = true;
    L41:
        r109.append(r121);
        r120.i("AIMiniAppEventCenter", r109.toString());
        if (r119 != null) goto L44;
    L46:
        LynxWorkerRuntime r122 = null;
    L47:
        StringBuilder r123 = new StringBuilder("resolve runtime, stage=find_runtime, appletId=");
        r123.append(r110);
        r123.append(", found=");
        if (r122 == null) goto L50;
        r104 = true;
    L50:
        r123.append(r104);
        r123.append(", terminated=");
        if (r122 == null) goto L53;
        Boolean r124 = Boxing.boxBoolean(r122.H());
    L54:
        r123.append(r124);
        r120.i("AIMiniAppEventCenter", r123.toString());
        if (r122 != null) goto L57;
        return null;
    L57:
        if (r122.H() == false) goto L59;
        return null;
    L59:
        return r122;
    L53:
        r124 = null;
        goto L54
    L44:
        if (r119.f34147v.isInitialized() == false) goto L46;
        r122 = r119.f34147v.getValue();
        goto L47
    L40:
        r121 = false;
    L7:
        r100 = new AIMiniAppEventCenter$resolveAppletRuntime$1(this, r112);
        goto L8
    }

    public static final Object a(AIMiniAppEventCenter r110, c r210, b r211, Continuation r212) {
        c r100 = r210;
        b r101 = r211;
        r110.getClass();
        if ((r212 instanceof AIMiniAppEventCenter$process$1) == false) goto L7;
        AIMiniAppEventCenter$process$1 r102 = (AIMiniAppEventCenter$process$1) r212;
        int r103 = r102.label;
        if ((r103 & Integer.MIN_VALUE) == 0) goto L7;
        r102.label = r103 - Integer.MIN_VALUE;
    L8:
        Object r104 = r102.result;
        Object r105 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r106 = r102.label;
        if (r106 == 0) goto L14;
        if (r106 != 1) goto L13;
        JsonObject r107 = (JsonObject) r102.L$2;
        b r108 = (b) r102.L$1;
        c r109 = (c) r102.L$0;
        ResultKt.throwOnFailure(r104);
        r101 = r108;
        r100 = r109;
    L86:
        AppletRuntime r111 = (AppletRuntime) r104;
        if (r100.f36703g > System.currentTimeMillis()) goto L89;
        g.f37637a.i("AIMiniAppEventCenter", "drop event, stage=route, reason=expired, " + d(r100));
    L113:
        return Unit.INSTANCE;
    L89:
        if (r111 != null) goto L91;
    L111:
        g.f37637a.i("AIMiniAppEventCenter", "drop event, stage=route, reason=runtime_not_found, " + d(r100));
        goto L113
    L91:
        if (r111.H() == true) goto L111;
        JsonObject r112 = new JsonObject();
        r112.addProperty("source", r101.f36694a);
        String r113 = r101.f36695b;
        if (r113 == null) goto L96;
        r112.addProperty("native_trigger", r113);
    L96:
        r112.addProperty("event_id", r100.f36699c);
        r112.addProperty("protocol_version", Integer.valueOf(r100.f36697a));
        Result.Companion r114 = Result.Companion;     // Catch: Throwable -> L99
        Object r115 = Result.m9449constructorimpl(Boolean.valueOf(r111.C(r100.f36704h.f36692a, r107, r112)));     // Catch: Throwable -> L99
    L102:
        if (Result.m9452exceptionOrNullimpl(r115) == null) goto L104;
        g r116 = g.f37637a;
        StringBuilder r117 = new StringBuilder("drop event, stage=bridge, reason=send_failed, ");
        f36687a.getClass();
        r117.append(d(r100));
        r116.e("AIMiniAppEventCenter", r117.toString());
        goto L113
    L104:
        if (((Boolean) r115).booleanValue() == true) goto L107;
        g.f37637a.i("AIMiniAppEventCenter", "drop event, stage=route, reason=bridge_not_ready, " + d(r100));
        goto L113
    L107:
        if (Intrinsics.areEqual(r100.f36698b, "page_event") == false) goto L109;
        BuildersKt.launch$default(f36689c, com.bytedance.ai.infra.thread_pool.b.f36604e, null, new AIMiniAppEventCenter$dispatch$1(r100, null), 2, null);
    L109:
        g.f37637a.i("AIMiniAppEventCenter", "dispatch event, stage=bridge, result=scheduled, " + d(r100));
    L99:
        th = move-exception;
        Result.Companion r118 = Result.Companion;
        r115 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L102
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r104);
        if (r100.f36697a == 1) goto L18;
        String r119 = "unsupported_protocol_version";
    L38:
        if (r119 == null) goto L119;
        g.f37637a.w("AIMiniAppEventCenter", "reject event, stage=validate, reason=" + r119 + ", " + d(r210));
        return Unit.INSTANCE;
    L119:
        Result.Companion r120 = Result.Companion;     // Catch: Throwable -> L49
        JsonElement r121 = GsonProtectorUtils.parse(new JsonParser(), r100.f36704h.f36693b);     // Catch: Throwable -> L49
        if (r121.isJsonObject() == true) goto L44;
        r121 = null;
    L44:
        if (r121 == null) goto L46;
        JsonObject r122 = r121.getAsJsonObject();     // Catch: Throwable -> L49
    L47:
        Object r123 = Result.m9449constructorimpl(r122);     // Catch: Throwable -> L49
    L52:
        if (Result.m9455isFailureimpl(r123) == false) goto L54;
        r123 = null;
    L54:
        JsonObject r124 = (JsonObject) r123;
        if (r124 != null) goto L57;
        g.f37637a.w("AIMiniAppEventCenter", "reject event, stage=parse_payload, reason=payload_not_object, " + d(r210));
        return Unit.INSTANCE;
    L57:
        long r125 = System.currentTimeMillis();
        String r126 = r100.f36699c;
        long r127 = r100.f36703g;
        Object r128 = f36690d;
        monitor-enter(r128);
        Iterator<Map.Entry<String, Long>> r129 = f36691e.entrySet().iterator();     // Catch: Throwable -> L114
    L61:
        if (r129.hasNext() == false) goto L65;
        if (r129.next().getValue().longValue() > r125) goto L61;
        r129.remove();     // Catch: Throwable -> L114
        goto L61
    L65:
        LinkedHashMap<String, Long> r130 = f36691e;     // Catch: Throwable -> L114
        if (r130.containsKey(r126) == false) goto L70;
        monitor-exit(r128);
        boolean r131 = false;
    L80:
        if (r131 == true) goto L82;
        g.f37637a.i("AIMiniAppEventCenter", "drop event, stage=deduplicate, reason=duplicate, " + d(r210));
        return Unit.INSTANCE;
    L82:
        g.f37637a.i("AIMiniAppEventCenter", "process event, stage=preprocess, result=accepted, " + d(r210));
        String r132 = r100.f36701e;
        boolean r133 = r101.f36696c;
        r102.L$0 = r100;
        r102.L$1 = r101;
        r102.L$2 = r124;
        r102.label = 1;
        Object r134 = r110.i(r132, r133, r102);
        if (r134 == r105) goto L131;
        r107 = r124;
        r104 = r134;
        goto L86
    L131:
        return r105;
    L70:
        if (r130.size() < 256) goto L77;
        Map.Entry r135 = (Map.Entry) CollectionsKt.firstOrNull(r130.entrySet());     // Catch: Throwable -> L114
        if (r135 == null) goto L74;
        String r136 = (String) r135.getKey();     // Catch: Throwable -> L114
    L75:
        if (r136 == null) goto L77;
        r130.remove(r136);     // Catch: Throwable -> L114
        goto L77
    L74:
        r136 = null;
    L77:
        r130.put(r126, Long.valueOf(r127));     // Catch: Throwable -> L114
        monitor-exit(r128);
        r131 = true;
    L114:
        th = move-exception;
        throw th;
    L46:
        r122 = null;
    L49:
        th = move-exception;
        Result.Companion r137 = Result.Companion;
        r123 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L52
    L18:
        if (f36688b.contains(r100.f36698b) == true) goto L21;
        r119 = "unsupported_event_type";
        goto L38
    L21:
        if (StringsKt.isBlank(r100.f36699c) == false) goto L23;
    L37:
        r119 = "missing_required_field";
        goto L38
    L23:
        if (StringsKt.isBlank(r100.f36700d) == true) goto L37;
        if (StringsKt.isBlank(r100.f36701e) == true) goto L37;
        if (StringsKt.isBlank(r100.f36704h.f36692a) == true) goto L37;
        if (StringsKt.isBlank(r100.f36704h.f36693b) == true) goto L37;
        if (StringsKt.isBlank(r100.f36705i) == true) goto L37;
        if (r100.f36703g > System.currentTimeMillis()) goto L36;
        r119 = AiBotPollingAuthResult.STATUS_EXPIRED;
        goto L38
    L36:
        r119 = null;
    L7:
        r102 = new AIMiniAppEventCenter$process$1(r110, r212);
        goto L8
    }
}
