package com.bytedance.android.livesdk.interactivity.api.monitor;

import android.util.Log;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdk.interactivity.api.settings.config.s0;
import com.bytedance.android.livesdk.interactivity.service.monitor.f;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.lynx.tasm.LynxError;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Queue;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import r52.w3;

/* JADX INFO: loaded from: classes9.dex */
public final class PublicScreenTraceMonitor implements f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final s0 f133304a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Map<String, String> f133305b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final SimpleDateFormat f133306c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Map<String, String> f133307d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Lazy f133308e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Lazy f133309f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final Lazy f133310g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final PublicScreenTraceMonitor f133311h = null;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/api/monitor/PublicScreenTraceMonitor$AdjustStep;", "", "", "step", "Ljava/lang/String;", "getStep", "()Ljava/lang/String;", "REQUEST", "INTERCEPT", "CALCUATE", "DROP", "RESULT", "POST_PROCESSOR", "interactivity-platform-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum AdjustStep extends Enum<AdjustStep> {
        public static final AdjustStep CALCUATE = null;
        public static final AdjustStep DROP = null;
        public static final AdjustStep INTERCEPT = null;
        public static final AdjustStep POST_PROCESSOR = null;
        public static final AdjustStep REQUEST = null;
        public static final AdjustStep RESULT = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ AdjustStep[] f133312a = null;
        private final String step;

        static {
            AdjustStep r100 = new AdjustStep("REQUEST", 0, "request");
            REQUEST = r100;
            AdjustStep r101 = new AdjustStep("INTERCEPT", 1, "intercept");
            INTERCEPT = r101;
            AdjustStep r102 = new AdjustStep("CALCUATE", 2, "caculate");
            CALCUATE = r102;
            AdjustStep r103 = new AdjustStep("DROP", 3, "drop");
            DROP = r103;
            AdjustStep r104 = new AdjustStep("RESULT", 4, "result");
            RESULT = r104;
            AdjustStep r105 = new AdjustStep("POST_PROCESSOR", 5, "post_processor");
            POST_PROCESSOR = r105;
            f133312a = new AdjustStep[]{r100, r101, r102, r103, r104, r105};
        }

        public static AdjustStep valueOf(String r100) {
            return (AdjustStep) r27.a.a(AdjustStep.class, r100);
        }

        public static AdjustStep[] values() {
            return (AdjustStep[]) f133312a.clone();
        }

        public final String getStep() {
            return this.step;
        }

        public AdjustStep(String r100, int r101, String r102) {
            super(r100, r101);
            this.step = r102;
        }
    }

    public PublicScreenTraceMonitor() {
    }

    public static Queue b() {
        return (Queue) f133308e.getValue();
    }

    public static Queue c() {
        return (Queue) f133309f.getValue();
    }

    public static Queue d() {
        return (Queue) f133310g.getValue();
    }

    static {
        f133311h = new PublicScreenTraceMonitor();
        f133304a = w3.f536280a.getValue();
        f133305b = new LinkedHashMap();
        f133306c = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS", Locale.CHINA);
        f133307d = new LinkedHashMap();
        f133308e = LazyKt.lazy(PublicScreenTraceMonitor$fifoQueue$2.INSTANCE);
        f133309f = LazyKt.lazy(PublicScreenTraceMonitor$giftMaskRecordQueue$2.INSTANCE);
        f133310g = LazyKt.lazy(PublicScreenTraceMonitor$giftMessageRecordQueue$2.INSTANCE);
    }

    @Override // com.bytedance.android.livesdk.interactivity.service.monitor.f
    public final void a() {
        if (f133304a.monitorAdjustLayout == false) goto L13;
        if (b().isEmpty() == true) goto L13;
        String r100 = CollectionsKt.joinToString$default(b(), null, null, null, 0, null, null, 63, null);     // Catch: Exception -> L10
        LinkedHashMap r101 = new LinkedHashMap();     // Catch: Exception -> L10
        r101.put("info", r100);     // Catch: Exception -> L10
        Unit r102 = Unit.INSTANCE;     // Catch: Exception -> L10
        c r103 = new c(0, null, 0, r101, 7);     // Catch: Exception -> L10
        b().clear();     // Catch: Exception -> L10
        ALogger.i("ttlive_public_screen_adjust_layout", r103.toString());     // Catch: Exception -> L10
        r103.b(InteractivityTraceMonitor.Event.PublicScreenAdjustLayout);     // Catch: Exception -> L10
    L10:
        e = move-exception;
        ALogger.e("ttlive_public_screen_adjust_layout_error", e);
    L13:
        if (f133304a.monitorGiftTrayMask == false) goto L23;
        if (c().isEmpty() == true) goto L23;
        String r104 = CollectionsKt.joinToString$default(c(), null, null, null, 0, null, null, 63, null);     // Catch: Exception -> L20
        LinkedHashMap r105 = new LinkedHashMap();     // Catch: Exception -> L20
        r105.put("maskRecord", r104);     // Catch: Exception -> L20
        Unit r106 = Unit.INSTANCE;     // Catch: Exception -> L20
        c r107 = new c(0, null, 0, r105, 7);     // Catch: Exception -> L20
        c().clear();     // Catch: Exception -> L20
        ALogger.i("ttlive_public_screen_mask_event_record", r107.toString());     // Catch: Exception -> L20
        r107.b(InteractivityTraceMonitor.Event.PublicScreenMaskEvent);     // Catch: Exception -> L20
    L20:
        e = move-exception;
        ALogger.e("ttlive_public_screen_record_mask_event", e);
    L23:
        if (f133304a.monitorSelfGiftEvent == true) goto L26;
        return;
    L26:
        if (d().isEmpty() == true) goto L35;
        LinkedHashMap r108 = new LinkedHashMap();
        r108.put("info", CollectionsKt.joinToString$default(d(), null, null, null, 0, null, null, 63, null));
        Unit r109 = Unit.INSTANCE;
        c r110 = new c(0, null, 0, r108, 7);
        d().clear();
        r110.b(InteractivityTraceMonitor.Event.PublicScreenSelfGiftEvent);
        return;
    }

    public static void e(String r100) {
        if (f133304a.monitorAudioComment == true) goto L5;
        return;
    L5:
        LinkedHashMap r101 = new LinkedHashMap();
        r101.put("errorMsg", r100);
        Unit r102 = Unit.INSTANCE;
        new c(-1, null, 0, r101, 6).b(InteractivityTraceMonitor.Event.PublicScreenAudioPlayEvent);
    }

    public static void h(String r100) {
        Intrinsics.checkNotNullParameter(r100, "reason");
        if (f133304a.monitorPSContextEmpty == true) goto L5;
        return;
    L5:
        new c(0, r100, 0, null, 13).b(InteractivityTraceMonitor.Event.PublicScreenContextEmpty);
    }

    @JvmStatic
    public static final void m(String r100) {
        Intrinsics.checkNotNullParameter(r100, "key");
        if (f133304a.monitorPublicScreenLiftUp == true) goto L5;
        return;
    L5:
        f133307d.put(r100, f133306c.format(Long.valueOf(System.currentTimeMillis())));
    }

    @JvmStatic
    public static final void l(String r100, long r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        if (f133304a.monitorFirstMessageDelay == true) goto L5;
        return;
    L5:
        f133305b.put(r100, f133306c.format(Long.valueOf(r101)));
    }

    @JvmStatic
    public static final void n(String r100, Function0<String> r101) {
        Intrinsics.checkNotNullParameter(r100, "step");
        Intrinsics.checkNotNullParameter(r101, "extra");
        s0 r102 = f133304a;
        if (r102.monitorSelfGiftEvent == true) goto L5;
        return;
    L5:
        d().add(f133306c.format(Long.valueOf(System.currentTimeMillis())) + ',' + r100 + ',' + r101.invoke() + ';');
        if (d().size() <= r102.maxLogSize) goto L9;
        d().poll();
        return;
    }

    public static void f(long r110, String r111, long r112) {
        Intrinsics.checkNotNullParameter(r111, "status");
        if (f133304a.monitorFirstMessageDelay == true) goto L5;
        return;
    L5:
        StringBuilder r100 = new StringBuilder();
        ArrayList r101 = new ArrayList();
        Iterator r102 = ((LinkedHashMap) f133305b).entrySet().iterator();
    L7:
        if (r102.hasNext() == false) goto L9;
        Map.Entry r103 = (Map.Entry) r102.next();
        r100.append((String) r103.getValue());
        r100.append(":");
        r100.append((String) r103.getKey());
        r101.add(r100.toString());
        StringsKt.clear(r100);
        goto L7
    L9:
        LinkedHashMap r113 = new LinkedHashMap();
        r113.put("timeStep", CollectionsKt.joinToString$default(r101, ",", null, null, 0, null, null, 62, null));
        r113.put("totalCnt", String.valueOf(r112));
        Unit r114 = Unit.INSTANCE;
        c r115 = new c(0, r111, r110, r113, 1);
        ALogger.i("ttlive_public_screen_first_message_show_delay", r115.toString());
        r115.b(InteractivityTraceMonitor.Event.FirstMessageShowDelay);
        ((LinkedHashMap) f133305b).clear();
    }

    public static void j(String r100, String r110, Throwable r111) {
        Intrinsics.checkNotNullParameter(r100, "type");
        if (f133304a.monitorEngineError == true) goto L5;
        return;
    L5:
        int r101 = 0;
        String r102 = null;
        long r103 = 0;
        LinkedHashMap r104 = new LinkedHashMap();
        r104.put("type", r100);
        if (r110 == null) goto L8;
        String r105 = (String) r104.put("msg", r110);
    L8:
        if (r111 == null) goto L10;
        r104.put("error", Log.getStackTraceString(r111));
    L10:
        Unit r106 = Unit.INSTANCE;
        new c(r101, r102, r103, r104, 7).b(InteractivityTraceMonitor.Event.RichContentEngineError);
    }

    public static void k(long r100, String r110, Throwable r111) {
        if (f133304a.monitorTopMsgBackendFail == true) goto L5;
        return;
    L5:
        int r101 = (int) r100;
        if (r110 != null) goto L8;
        String r102 = "";
    L9:
        long r103 = 0;
        LinkedHashMap r104 = new LinkedHashMap();
        if (r110 == null) goto L12;
        String r105 = (String) r104.put("errorMsg", r110);
    L12:
        if (r111 == null) goto L14;
        r104.put(LynxError.LYNX_THROWABLE, Log.getStackTraceString(r111));
    L14:
        Unit r106 = Unit.INSTANCE;
        new c(r101, r102, r103, r104, 4).b(InteractivityTraceMonitor.Event.PublicScreenTopMsgEvent);
        return;
    L8:
        r102 = r110;
        goto L9
    }

    @JvmStatic
    public static final void i(String r100, String r110, boolean r111, String r112) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_LAYER);
        if (f133304a.monitorPublicScreenVis == true) goto L5;
        return;
    L5:
        int r101 = 0;
        if (r111 == false) goto L8;
        String r102 = "Visiable";
    L9:
        String r103 = r102;
        long r104 = 0;
        LinkedHashMap r105 = new LinkedHashMap();
        r105.put(GXTemplateKey.GAIAX_LAYER, r100);
        if (r110 == null) goto L12;
        String r106 = (String) r105.put("reason", r110);
    L12:
        if (r111 == false) goto L14;
        String r107 = BdpAppEventConstant.YES;
    L15:
        r105.put(RemoteMessageConst.Notification.VISIBILITY, r107);
        if (r112 == null) goto L18;
        r105.put("extra", r112);
    L18:
        Unit r108 = Unit.INSTANCE;
        c r109 = new c(r101, r103, r104, r105, 5);
        r109.a(InteractivityMonitor.Event.PublicScreenVisibilityChange);
        r109.b(InteractivityTraceMonitor.Event.PublicScreenVisibilityChange);
        return;
    L14:
        r107 = BdpAppEventConstant.NO;
        goto L15
    L8:
        r102 = "InVisiable";
        goto L9
    }

    @JvmStatic
    public static final void g(String r100, Boolean r101, Boolean r102, AdjustStep r103, String r104) {
        Intrinsics.checkNotNullParameter(r103, "status");
        s0 r105 = f133304a;
        if (r105.monitorAdjustLayout == true) goto L5;
        return;
    L5:
        Boolean r106 = Boolean.TRUE;
        if (Intrinsics.areEqual(r102, r106) == false) goto L11;
        if (Intrinsics.areEqual(r101, r106) == false) goto L11;
        String r107 = "AdjustBoth";
    L17:
        String r108 = f133306c.format(Long.valueOf(System.currentTimeMillis()));
        String r109 = r103.getStep();
        Intrinsics.checkNotNullParameter(r108, "timestamp");
        Intrinsics.checkNotNullParameter(r109, "step");
        Intrinsics.checkNotNullParameter(r107, "adjustType");
        if (b().size() < r105.maxLogSize) goto L20;
        b().poll();
    L20:
        b().offer("timeStamp:" + r108 + ",step:" + r109 + ",source:" + r100 + ",type:" + r107 + ",info:" + r104 + '\n');
        return;
    L11:
        if (Intrinsics.areEqual(r102, r106) == false) goto L14;
        r107 = "AdjustHeight";
        goto L17
    L14:
        if (Intrinsics.areEqual(r101, r106) == false) goto L16;
        r107 = "AdjustWidth";
        goto L17
    L16:
        r107 = "empty";
        goto L17
    }
}
