package com.obric.autogui.operator.a;

import android.os.SystemClock;
import com.obric.autogui.common.api.AOBizTracking;
import com.obric.autogui.common.api.logging.Loog;
import com.obric.autogui.common.api.platform.input.CoordinateScrollResult;
import com.obric.autogui.common.api.platform.tracking.IAutoActionTrackingApi;
import com.obric.capabilitykit.common.ErrorCode;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import d.m;
import java.util.Locale;
import org.json.JSONObject;

/* JADX INFO: compiled from: SwipeV3BizTracking.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class d {
    private static final String TAG = "SwipeV3BizTracking";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d f29819a = null;

    /* JADX INFO: compiled from: SwipeV3BizTracking.kt */
    public static final enum a extends Enum<a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f29820a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final a f29821b = null;
        private static final /* synthetic */ a[] f = null;
        private static final /* synthetic */ d.d.a g = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final String f29822c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final String f29823d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final int f29824e;

        private static final /* synthetic */ a[] d() {
            return new a[]{f29820a, f29821b};
        }

        private a(String r1, int r2, String r3, String r4, int r5) {
            super(r1, r2);
            this.f29822c = r3;
            this.f29823d = r4;
            this.f29824e = r5;
        }

        public final String a() {
            return this.f29822c;
        }

        public final String b() {
            return this.f29823d;
        }

        public final int c() {
            return this.f29824e;
        }

        static {
            f29820a = new a("TOUCH_TAIL_FAILED", 0, "touch_tail", "touch_tail_failed", 1003);
            f29821b = new a("FRAMEWORK_UNCERTAIN", 1, "framework", "framework_result_uncertain", 1007);
            a[] r0 = d();
            f = r0;
            g = d.d.b.a((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.aiagent.plugin"));
        }

        public static a valueOf(String r2) {
            return (a) ZeusTransformUtils.preCheckCast(Enum.valueOf(a.class, r2), a.class, "com.obric.aiagent.plugin");
        }

        public static a[] values() {
            return (a[]) ZeusTransformUtils.preCheckCast(f.clone(), a[].class, "com.obric.aiagent.plugin");
        }
    }

    /* JADX INFO: compiled from: SwipeV3BizTracking.kt */
    public static final enum b extends Enum<b> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f29825a = null;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private static final /* synthetic */ b[] f29826d = null;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private static final /* synthetic */ d.d.a f29827e = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f29828b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final int f29829c;

        private static final /* synthetic */ b[] c() {
            return new b[]{f29825a};
        }

        private b(String r1, int r2, String r3, int r4) {
            super(r1, r2);
            this.f29828b = r3;
            this.f29829c = r4;
        }

        public final String a() {
            return this.f29828b;
        }

        public final int b() {
            return this.f29829c;
        }

        static {
            f29825a = new b("FRAMEWORK_FALLBACK", 0, "framework_fallback_required", 1006);
            b[] r0 = c();
            f29826d = r0;
            f29827e = d.d.b.a((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.aiagent.plugin"));
        }

        public static b valueOf(String r2) {
            return (b) ZeusTransformUtils.preCheckCast(Enum.valueOf(b.class, r2), b.class, "com.obric.aiagent.plugin");
        }

        public static b[] values() {
            return (b[]) ZeusTransformUtils.preCheckCast(f29826d.clone(), b[].class, "com.obric.aiagent.plugin");
        }
    }

    /* JADX INFO: compiled from: SwipeV3BizTracking.kt */
    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f29830a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f29831b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final String f29832c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final long f29833d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final String f29834e;
        private CoordinateScrollResult f;
        private Long g;
        private Long h;
        private b i;
        private Boolean j;
        private Long k;
        private boolean l;

        public c(int r2, String r3, String r4, m<Float, Float> r5, m<Float, Float> r6) {
            o.e(r3, "packageName");
            o.e(r4, "activityName");
            o.e(r5, "start");
            o.e(r6, "end");
            this.f29830a = r2;
            this.f29831b = r3;
            this.f29832c = r4;
            this.f29833d = SystemClock.elapsedRealtime();
            this.f29834e = d.a(d.f29819a, r5, r6);
        }

        public final void a(CoordinateScrollResult r2, long r3) {
            o.e(r2, "result");
            this.f = r2;
            this.g = Long.valueOf(r3);
        }

        public final void a(long r1) {
            this.h = Long.valueOf(r1);
        }

        public final void a() {
            a("success", "framework", "success", 0, true);
        }

        public final void a(a r8) {
            o.e(r8, "failure");
            a("uncertain", r8.a(), r8.b(), r8.c(), false);
        }

        public final void a(b r7, boolean r8, long r9) {
            o.e(r7, "cause");
            this.i = r7;
            this.j = Boolean.valueOf(r8);
            this.k = Long.valueOf(r9);
            a("fallback", "v2_fallback", r7.a(), r7.b(), r8);
        }

        private final void a(String r21, String r22, String r23, int r24, boolean r25) {
            if (this.l == false) goto L5;
            return;
        L5:
            this.l = true;
            if (r25 == false) goto L9;
            int r11 = 0;
        L52:
            JSONObject r14 = new JSONObject();     // Catch: Exception -> L49
            r14.put("result", r21);     // Catch: Exception -> L49
            r14.put("phase", r22);     // Catch: Exception -> L49
            r14.put("reason", r23);     // Catch: Exception -> L49
            r14.put("error_code", r24);     // Catch: Exception -> L49
            r14.put("final_error_code", r11);     // Catch: Exception -> L49
            r14.put("final_success", r25);     // Catch: Exception -> L49
            r14.put("package_name", this.f29831b);     // Catch: Exception -> L49
            r14.put("activity_name", this.f29832c);     // Catch: Exception -> L49
            r14.put("display_id", this.f29830a);     // Catch: Exception -> L49
            r14.put("direction", this.f29834e);     // Catch: Exception -> L49
            r14.put("total_duration_ms", SystemClock.elapsedRealtime() - this.f29833d);     // Catch: Exception -> L49
            Long r10 = this.g;     // Catch: Exception -> L49
            if (r10 == null) goto L15;
            long r12 = r10.longValue();     // Catch: Exception -> L49
        L16:
            r14.put("framework_duration_ms", r12);     // Catch: Exception -> L49
            CoordinateScrollResult r9 = this.f;     // Catch: Exception -> L49
            if (r9 == null) goto L22;
            String r13 = r9.getStatus().name().toLowerCase(Locale.ROOT);     // Catch: Exception -> L49
            o.c(r13, "toLowerCase(...)");     // Catch: Exception -> L49
            r14.put("framework_status", r13);     // Catch: Exception -> L49
            Integer r15 = r9.getRawCode();     // Catch: Exception -> L49
            if (r15 == null) goto L22;
            r14.put("framework_raw_code", ((Number) ZeusTransformUtils.preCheckCast(r15, Number.class, "com.obric.aiagent.plugin")).intValue());     // Catch: Exception -> L49
        L22:
            if (this.h == null) goto L24;
            boolean r16 = true;
        L25:
            r14.put("touch_tail_executed", r16);     // Catch: Exception -> L49
            Long r17 = this.h;     // Catch: Exception -> L49
            if (r17 == null) goto L28;
            long r18 = r17.longValue();     // Catch: Exception -> L49
        L29:
            r14.put("touch_tail_duration_ms", r18);     // Catch: Exception -> L49
            if (this.i == null) goto L32;
            boolean r19 = true;
        L33:
            r14.put("v2_fallback_triggered", r19);     // Catch: Exception -> L49
            Long r110 = this.k;     // Catch: Exception -> L49
            if (r110 == null) goto L36;
            long r111 = r110.longValue();     // Catch: Exception -> L49
        L37:
            r14.put("v2_fallback_duration_ms", r111);     // Catch: Exception -> L49
            b r20 = this.i;     // Catch: Exception -> L49
            if (r20 == null) goto L40;
            r14.put("v2_fallback_reason", r20.a());     // Catch: Exception -> L49
        L40:
            Boolean r26 = this.j;     // Catch: Exception -> L49
            if (r26 == null) goto L43;
            r14.put("v2_fallback_success", r26.booleanValue());     // Catch: Exception -> L49
        L43:
            IAutoActionTrackingApi.DefaultImpls.reportEvent$default((IAutoActionTrackingApi) ZeusTransformUtils.preCheckCast(AOBizTracking.INSTANCE, IAutoActionTrackingApi.class, "com.obric.aiagent.plugin"), "oauto_swipe_v3", r14, false, false, null, 16, null);     // Catch: Exception -> L49
            Loog r27 = Loog.INSTANCE;     // Catch: Exception -> L49
            StringBuilder r1 = new StringBuilder().append("reported result=").append(r21).append(", phase=").append(r22).append(", reason=").append(r23).append(", errorCode=").append(r24).append(", finalErrorCode=").append(r11).append(", finalSuccess=").append(r25).append(", packageName=").append(this.f29831b).append(", activityName=").append(this.f29832c).append(", v2FallbackTriggered=");     // Catch: Exception -> L49
            if (this.i == null) goto L46;
            boolean r0 = true;
        L47:
            r27.i(d.TAG, r1.append(r0).toString());     // Catch: Exception -> L49
            return;
        L46:
            r0 = false;
            goto L47
        L36:
            r111 = 0;
            goto L37
        L32:
            r19 = false;
            goto L33
        L28:
            r18 = 0;
            goto L29
        L24:
            r16 = false;
            goto L25
        L15:
            r12 = 0;
        L49:
            e = move-exception;
            Loog.INSTANCE.w(d.TAG, "report failed, phase=" + r22 + ", reason=" + r23, (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
            return;
        L9:
            if (this.i == null) goto L11;
            r11 = ErrorCode.Clock.TIMER_NOT_EXIST_ERROR;
            goto L52
        L11:
            r11 = r24;
            goto L52
        }
    }

    static {
        f29819a = new d();
    }

    private d() {
    }

    public static final /* synthetic */ String a(d r0, m r1, m r2) {
        return r0.a(r1, r2);
    }

    private final String a(m<Float, Float> r4, m<Float, Float> r5) {
        float r3 = Math.abs(((Number) ZeusTransformUtils.preCheckCast(r5.a(), Number.class, "com.obric.aiagent.plugin")).floatValue() - ((Number) ZeusTransformUtils.preCheckCast(r4.a(), Number.class, "com.obric.aiagent.plugin")).floatValue());
        float r6 = Math.abs(((Number) ZeusTransformUtils.preCheckCast(r5.b(), Number.class, "com.obric.aiagent.plugin")).floatValue() - ((Number) ZeusTransformUtils.preCheckCast(r4.b(), Number.class, "com.obric.aiagent.plugin")).floatValue());
        if (r3 <= r6) goto L6;
        return "horizontal";
    L6:
        if (r6 <= r3) goto L8;
        return "vertical";
    L8:
        return "diagonal";
    }
}
