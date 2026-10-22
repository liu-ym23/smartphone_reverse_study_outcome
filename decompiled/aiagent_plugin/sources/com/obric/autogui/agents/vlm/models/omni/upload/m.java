package com.obric.autogui.agents.vlm.models.omni.upload;

import com.bytedance.apm.battery.dao.DBHelper;
import com.bytedance.security.zenmobile.io.SensitiveType;
import com.obric.autogui.common.api.AOBizTracking;
import com.obric.autogui.common.api.logging.OmniDataFeedbackLog;
import com.obric.autogui.common.api.platform.tracking.TrackingReportTarget;
import com.obric.capabilitykit.common.Ext;
import com.obric.capabilitykit.common.UiType;
import com.obric.oui.texteffects.OProtocolTextEffectTextView;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: compiled from: OmniScreenshotUploadTelemetry.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class m {
    private static final String TAG = "OmniUploadTelemetry";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final m f28813a = null;

    /* JADX INFO: compiled from: OmniScreenshotUploadTelemetry.kt */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f28814a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f28815b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final String f28816c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final String f28817d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final String f28818e;
        private final String f;
        private final String g;
        private final String h;
        private final Boolean i;
        private final Integer j;
        private final Long k;
        private final Long l;
        private final Integer m;
        private final Integer n;
        private final String o;
        private final String p;
        private final Integer q;
        private final Integer r;
        private final Integer s;
        private final Integer t;
        private final Boolean u;
        private final Boolean v;
        private final Integer w;
        private final Integer x;

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, a.class) == true) goto L8;
            return false;
        L8:
            a r6 = (a) ZeusTransformUtils.preCheckCast(r5, a.class, "com.obric.aiagent.plugin");
            if (d.h.b.o.a(this.f28814a, r6.f28814a) == true) goto L12;
            return false;
        L12:
            if (d.h.b.o.a(this.f28815b, r6.f28815b) == true) goto L15;
            return false;
        L15:
            if (d.h.b.o.a(this.f28816c, r6.f28816c) == true) goto L18;
            return false;
        L18:
            if (d.h.b.o.a(this.f28817d, r6.f28817d) == true) goto L21;
            return false;
        L21:
            if (d.h.b.o.a(this.f28818e, r6.f28818e) == true) goto L24;
            return false;
        L24:
            if (d.h.b.o.a(this.f, r6.f) == true) goto L27;
            return false;
        L27:
            if (d.h.b.o.a(this.g, r6.g) == true) goto L30;
            return false;
        L30:
            if (d.h.b.o.a(this.h, r6.h) == true) goto L33;
            return false;
        L33:
            if (d.h.b.o.a(this.i, r6.i) == true) goto L36;
            return false;
        L36:
            if (d.h.b.o.a(this.j, r6.j) == true) goto L39;
            return false;
        L39:
            if (d.h.b.o.a(this.k, r6.k) == true) goto L42;
            return false;
        L42:
            if (d.h.b.o.a(this.l, r6.l) == true) goto L45;
            return false;
        L45:
            if (d.h.b.o.a(this.m, r6.m) == true) goto L48;
            return false;
        L48:
            if (d.h.b.o.a(this.n, r6.n) == true) goto L51;
            return false;
        L51:
            if (d.h.b.o.a(this.o, r6.o) == true) goto L54;
            return false;
        L54:
            if (d.h.b.o.a(this.p, r6.p) == true) goto L57;
            return false;
        L57:
            if (d.h.b.o.a(this.q, r6.q) == true) goto L60;
            return false;
        L60:
            if (d.h.b.o.a(this.r, r6.r) == true) goto L63;
            return false;
        L63:
            if (d.h.b.o.a(this.s, r6.s) == true) goto L66;
            return false;
        L66:
            if (d.h.b.o.a(this.t, r6.t) == true) goto L69;
            return false;
        L69:
            if (d.h.b.o.a(this.u, r6.u) == true) goto L72;
            return false;
        L72:
            if (d.h.b.o.a(this.v, r6.v) == true) goto L75;
            return false;
        L75:
            if (d.h.b.o.a(this.w, r6.w) == true) goto L78;
            return false;
        L78:
            if (d.h.b.o.a(this.x, r6.x) == true) goto L80;
            return false;
        L80:
            return true;
        }

        public int hashCode() {
            int r0 = ((((this.f28814a.hashCode() * 31) + this.f28815b.hashCode()) * 31) + this.f28816c.hashCode()) * 31;
            String r1 = this.f28817d;
            int r2 = 0;
            if (r1 != null) goto L5;
            int r3 = 0;
        L6:
            int r4 = (r0 + r3) * 31;
            String r5 = this.f28818e;
            if (r5 != null) goto L9;
            int r6 = 0;
        L10:
            int r7 = (((r4 + r6) * 31) + this.f.hashCode()) * 31;
            String r8 = this.g;
            if (r8 != null) goto L13;
            int r9 = 0;
        L14:
            int r10 = (r7 + r9) * 31;
            String r11 = this.h;
            if (r11 != null) goto L17;
            int r12 = 0;
        L18:
            int r13 = (r10 + r12) * 31;
            Boolean r14 = this.i;
            if (r14 != null) goto L21;
            int r15 = 0;
        L22:
            int r16 = (r13 + r15) * 31;
            Integer r17 = this.j;
            if (r17 != null) goto L25;
            int r18 = 0;
        L26:
            int r19 = (r16 + r18) * 31;
            Long r20 = this.k;
            if (r20 != null) goto L29;
            int r21 = 0;
        L30:
            int r22 = (r19 + r21) * 31;
            Long r23 = this.l;
            if (r23 != null) goto L33;
            int r24 = 0;
        L34:
            int r25 = (r22 + r24) * 31;
            Integer r26 = this.m;
            if (r26 != null) goto L37;
            int r27 = 0;
        L38:
            int r28 = (r25 + r27) * 31;
            Integer r29 = this.n;
            if (r29 != null) goto L41;
            int r30 = 0;
        L42:
            int r31 = (r28 + r30) * 31;
            String r32 = this.o;
            if (r32 != null) goto L45;
            int r33 = 0;
        L46:
            int r34 = (r31 + r33) * 31;
            String r35 = this.p;
            if (r35 != null) goto L49;
            int r36 = 0;
        L50:
            int r37 = (r34 + r36) * 31;
            Integer r38 = this.q;
            if (r38 != null) goto L53;
            int r39 = 0;
        L54:
            int r40 = (r37 + r39) * 31;
            Integer r41 = this.r;
            if (r41 != null) goto L57;
            int r42 = 0;
        L58:
            int r43 = (r40 + r42) * 31;
            Integer r44 = this.s;
            if (r44 != null) goto L61;
            int r45 = 0;
        L62:
            int r46 = (r43 + r45) * 31;
            Integer r47 = this.t;
            if (r47 != null) goto L65;
            int r48 = 0;
        L66:
            int r49 = (r46 + r48) * 31;
            Boolean r50 = this.u;
            if (r50 != null) goto L69;
            int r51 = 0;
        L70:
            int r52 = (r49 + r51) * 31;
            Boolean r53 = this.v;
            if (r53 != null) goto L73;
            int r54 = 0;
        L74:
            int r55 = (r52 + r54) * 31;
            Integer r56 = this.w;
            if (r56 != null) goto L77;
            int r57 = 0;
        L78:
            int r58 = (r55 + r57) * 31;
            Integer r59 = this.x;
            if (r59 == null) goto L83;
            r2 = r59.hashCode();
        L83:
            return r58 + r2;
        L77:
            r57 = r56.hashCode();
            goto L78
        L73:
            r54 = r53.hashCode();
            goto L74
        L69:
            r51 = r50.hashCode();
            goto L70
        L65:
            r48 = r47.hashCode();
            goto L66
        L61:
            r45 = r44.hashCode();
            goto L62
        L57:
            r42 = r41.hashCode();
            goto L58
        L53:
            r39 = r38.hashCode();
            goto L54
        L49:
            r36 = r35.hashCode();
            goto L50
        L45:
            r33 = r32.hashCode();
            goto L46
        L41:
            r30 = r29.hashCode();
            goto L42
        L37:
            r27 = r26.hashCode();
            goto L38
        L33:
            r24 = r23.hashCode();
            goto L34
        L29:
            r21 = r20.hashCode();
            goto L30
        L25:
            r18 = r17.hashCode();
            goto L26
        L21:
            r15 = r14.hashCode();
            goto L22
        L17:
            r12 = r11.hashCode();
            goto L18
        L13:
            r9 = r8.hashCode();
            goto L14
        L9:
            r6 = r5.hashCode();
            goto L10
        L5:
            r3 = r1.hashCode();
            goto L6
        }

        public String toString() {
            StringBuilder r0 = new StringBuilder();
            r0.append("Event(stage=").append(this.f28814a).append(", outcome=").append(this.f28815b).append(", reasonCode=").append(this.f28816c).append(", instructionId=").append(this.f28817d).append(", trigger=").append(this.f28818e).append(", protocolVersion=").append(this.f).append(", payloadMode=").append(this.g).append(", source=").append(this.h).append(", isFinish=").append(this.i).append(", imageCount=").append(this.j).append(", payloadSizeBytes=").append(this.k).append(", durationMs=");
            r0.append(this.l).append(", retryIndex=").append(this.m).append(", serverCode=").append(this.n).append(", failureStage=").append(this.o).append(", exceptionType=").append(this.p).append(", totalCandidates=").append(this.q).append(", uploadedCount=").append(this.r).append(", failedCount=").append(this.s).append(", skippedCount=").append(this.t).append(", stoppedByOmniRunning=").append(this.u).append(", stoppedByUploadBlocked=").append(this.v).append(", activeTokenCount=").append(this.w);
            r0.append(", queueRemainingCount=").append(this.x).append(')');
            return r0.toString();
        }

        public a(String r7, String r8, String r9, String r10, String r11, String r12, String r13, String r14, Boolean r15, Integer r16, Long r17, Long r18, Integer r19, Integer r20, String r21, String r22, Integer r23, Integer r24, Integer r25, Integer r26, Boolean r27, Boolean r28, Integer r29, Integer r30) {
            d.h.b.o.e(r7, "stage");
            d.h.b.o.e(r8, "outcome");
            d.h.b.o.e(r9, "reasonCode");
            d.h.b.o.e(r12, "protocolVersion");
            this.f28814a = r7;
            this.f28815b = r8;
            this.f28816c = r9;
            this.f28817d = r10;
            this.f28818e = r11;
            this.f = r12;
            this.g = r13;
            this.h = r14;
            this.i = r15;
            this.j = r16;
            this.k = r17;
            this.l = r18;
            this.m = r19;
            this.n = r20;
            this.o = r21;
            this.p = r22;
            this.q = r23;
            this.r = r24;
            this.s = r25;
            this.t = r26;
            this.u = r27;
            this.v = r28;
            this.w = r29;
            this.x = r30;
        }

        public /* synthetic */ a(String r29, String r30, String r31, String r32, String r33, String r34, String r35, String r36, Boolean r37, Integer r38, Long r39, Long r40, Integer r41, Integer r42, String r43, String r44, Integer r45, Integer r46, Integer r47, Integer r48, Boolean r49, Boolean r50, Integer r51, Integer r52, int r53, d.h.b.h r54) {
            if ((r53 & 8) == 0) goto L5;
            String r7 = null;
        L7:
            if ((r53 & 16) == 0) goto L9;
            String r8 = null;
        L11:
            if ((r53 & 32) == 0) goto L13;
            String r9 = SensitiveType.UNKNOWN;
        L15:
            if ((r53 & 64) == 0) goto L17;
            String r10 = null;
        L19:
            if ((r53 & 128) == 0) goto L21;
            String r11 = null;
        L23:
            if ((r53 & 256) == 0) goto L25;
            Boolean r12 = null;
        L27:
            if ((r53 & 512) == 0) goto L29;
            Integer r13 = null;
        L31:
            if ((r53 & 1024) == 0) goto L33;
            Long r14 = null;
        L35:
            if ((r53 & 2048) == 0) goto L37;
            Long r15 = null;
        L39:
            if ((r53 & 4096) == 0) goto L41;
            Integer r16 = null;
        L43:
            if ((r53 & 8192) == 0) goto L45;
            Integer r17 = null;
        L47:
            if ((r53 & 16384) == 0) goto L49;
            String r18 = null;
        L51:
            if ((32768 & r53) == 0) goto L53;
            String r19 = null;
        L55:
            if ((65536 & r53) == 0) goto L57;
            Integer r20 = null;
        L59:
            if ((131072 & r53) == 0) goto L61;
            Integer r21 = null;
        L63:
            if ((262144 & r53) == 0) goto L65;
            Integer r22 = null;
        L67:
            if ((524288 & r53) == 0) goto L69;
            Integer r23 = null;
        L71:
            if ((1048576 & r53) == 0) goto L73;
            Boolean r24 = null;
        L75:
            if ((2097152 & r53) == 0) goto L77;
            Boolean r25 = null;
        L79:
            if ((4194304 & r53) == 0) goto L81;
            Integer r26 = null;
        L83:
            if ((r53 & UiType.FLAG_APPLET_CARD) == 0) goto L85;
            Integer r27 = null;
        L86:
            this(r29, r30, r31, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27);
            return;
        L85:
            r27 = r52;
            goto L86
        L81:
            r26 = r51;
            goto L83
        L77:
            r25 = r50;
            goto L79
        L73:
            r24 = r49;
            goto L75
        L69:
            r23 = r48;
            goto L71
        L65:
            r22 = r47;
            goto L67
        L61:
            r21 = r46;
            goto L63
        L57:
            r20 = r45;
            goto L59
        L53:
            r19 = r44;
            goto L55
        L49:
            r18 = r43;
            goto L51
        L45:
            r17 = r42;
            goto L47
        L41:
            r16 = r41;
            goto L43
        L37:
            r15 = r40;
            goto L39
        L33:
            r14 = r39;
            goto L35
        L29:
            r13 = r38;
            goto L31
        L25:
            r12 = r37;
            goto L27
        L21:
            r11 = r36;
            goto L23
        L17:
            r10 = r35;
            goto L19
        L13:
            r9 = r34;
            goto L15
        L9:
            r8 = r33;
            goto L11
        L5:
            r7 = r32;
            goto L7
        }

        public final String a() {
            return this.f28814a;
        }

        public final String b() {
            return this.f28815b;
        }

        public final String c() {
            return this.f28816c;
        }

        public final String d() {
            return this.f28817d;
        }

        public final String e() {
            return this.f28818e;
        }

        public final String f() {
            return this.f;
        }

        public final String g() {
            return this.g;
        }

        public final String h() {
            return this.h;
        }

        public final Boolean i() {
            return this.i;
        }

        public final Integer j() {
            return this.j;
        }

        public final Long k() {
            return this.k;
        }

        public final Long l() {
            return this.l;
        }

        public final Integer m() {
            return this.m;
        }

        public final Integer n() {
            return this.n;
        }

        public final String o() {
            return this.o;
        }

        public final String p() {
            return this.p;
        }

        public final Integer q() {
            return this.q;
        }

        public final Integer r() {
            return this.r;
        }

        public final Integer s() {
            return this.s;
        }

        public final Integer t() {
            return this.t;
        }

        public final Boolean u() {
            return this.u;
        }

        public final Boolean v() {
            return this.v;
        }

        public final Integer w() {
            return this.w;
        }

        public final Integer x() {
            return this.x;
        }
    }

    static {
        f28813a = new m();
    }

    private m() {
    }

    public final void a(a r7) {
        d.h.b.o.e(r7, "event");
        d.n.a r0 = d.n.f38560a;     // Catch: Throwable -> L5
        AOBizTracking.INSTANCE.reportEvent("oauto_omni_screenshot_upload", ((m) ZeusTransformUtils.preCheckCast(this, m.class, "com.obric.aiagent.plugin")).b(r7), false, false, TrackingReportTarget.DEFAULT);     // Catch: Throwable -> L5
        Object r6 = d.n.f(d.x.f38692a);     // Catch: Throwable -> L5
    L7:
        Throwable r8 = d.n.c(r6);
        if (r8 == null) goto L13;
        OmniDataFeedbackLog.INSTANCE.e(TAG, "report failed, stage=" + r7.a() + ", reason=" + r7.c(), r8);
        return;
    L13:
        return;
    L5:
        th = move-exception;
        d.n.a r1 = d.n.f38560a;
        r6 = d.n.f(d.o.a(th));
        goto L7
    }

    public final void a(com.obric.autogui.agents.vlm.models.omni.a.d r2, long r3) {
        d.h.b.o.e(r2, "summary");
        a r4 = b(r2, r3);
        if (r4 != null) goto L5;
        return;
    L5:
        a(r4);
    }

    public final a b(com.obric.autogui.agents.vlm.models.omni.a.d r30, long r31) {
        d.h.b.o.e(r30, "summary");
        if (a(r30) == true) goto L7;
        return null;
    L7:
        if (r30.e() <= 0) goto L11;
        String r0 = "failure";
    L9:
        String r4 = r0;
        if (r30.e() <= 0) goto L27;
        String r1 = "upload_failed";
    L25:
        String r5 = r1;
        String r3 = "drain_summary";
        String r8 = null;
        String r9 = null;
        return new a(r3, r4, r5, r30.b(), a((Enum) ZeusTransformUtils.preCheckCast(r30.a(), Enum.class, "com.obric.aiagent.plugin")), r8, r9, null, null, null, null, Long.valueOf(d.l.n.a(r31, 0)), null, null, null, null, Integer.valueOf(r30.c()), Integer.valueOf(r30.d()), Integer.valueOf(r30.e()), Integer.valueOf(r30.f()), Boolean.valueOf(r30.g()), Boolean.valueOf(r30.h()), null, null, 12646368, null);
    L27:
        if (r30.g() == false) goto L30;
        r1 = "omni_running";
        goto L25
    L30:
        if (r30.h() == false) goto L33;
        r1 = "upload_blocked";
        goto L25
    L33:
        if (r30.f() <= 0) goto L35;
        r1 = "candidate_skipped";
        goto L25
    L35:
        r1 = OProtocolTextEffectTextView.EffectNameNone;
        goto L25
    L11:
        if (r30.g() == false) goto L13;
    L21:
        r0 = "blocked";
        goto L9
    L13:
        if (r30.h() == true) goto L21;
        if (r30.f() > 0) goto L18;
    L20:
        r0 = "success";
        goto L9
    L18:
        if (r30.d() != 0) goto L20;
        r0 = "skipped";
        goto L9
    }

    public final void a(com.obric.autogui.agents.vlm.models.omni.a.c r32, long r33, Throwable r35) {
        d.h.b.o.e(r32, Ext.KEY_REQUEST);
        d.h.b.o.e(r35, "throwable");
        String r8 = r32.b();
        String r9 = a((Enum) ZeusTransformUtils.preCheckCast(r32.a(), Enum.class, "com.obric.aiagent.plugin"));
        Boolean r13 = r32.e();
        Long r16 = Long.valueOf(d.l.n.a(r33, 0));
        String r20 = a(r35);
        a(new a("drain_summary", "failure", "drain_exception", r8, r9, SensitiveType.UNKNOWN, null, null, r13, null, null, r16, null, null, null, r20, null, null, null, null, null, null, null, null, 16742080, null));
    }

    public final void a(String r29, int r30, String r31) {
        d.h.b.o.e(r31, "trigger");
        if (r30 > 0) goto L5;
        return;
    L5:
        String r2 = "busy_tracker";
        String r3 = "failure";
        String r4 = "stale_token_cleared";
        a(new a(r2, r3, r4, r29, r31, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, Integer.valueOf(r30), null, 12582880, null));
    }

    public final void a(String r2, com.obric.autogui.agents.vlm.models.omni.a.c r3, String r4, int r5) {
        d.h.b.o.e(r2, DBDefinition.TASK_ID);
        d.h.b.o.e(r3, Ext.KEY_REQUEST);
        d.h.b.o.e(r4, "payloadMode");
        a r6 = d(r2, r3, r4, r5);
        if (r6 != null) goto L5;
        return;
    L5:
        a(r6);
    }

    public final void b(String r2, com.obric.autogui.agents.vlm.models.omni.a.c r3, String r4, int r5) {
        d.h.b.o.e(r2, DBDefinition.TASK_ID);
        d.h.b.o.e(r3, Ext.KEY_REQUEST);
        d.h.b.o.e(r4, "payloadMode");
        a(c(r2, r3, r4, r5));
    }

    public final a c(String r31, com.obric.autogui.agents.vlm.models.omni.a.c r32, String r33, int r34) {
        d.h.b.o.e(r31, DBDefinition.TASK_ID);
        d.h.b.o.e(r32, Ext.KEY_REQUEST);
        d.h.b.o.e(r33, "payloadMode");
        String r3 = "local_finalize";
        String r4 = "failure";
        String r5 = "local_delete_failed";
        Long r13 = null;
        Long r14 = null;
        Integer r15 = null;
        Integer r16 = null;
        String r17 = null;
        String r18 = null;
        Integer r19 = null;
        Integer r20 = null;
        Integer r21 = null;
        Integer r22 = null;
        Boolean r23 = null;
        Boolean r24 = null;
        Integer r25 = null;
        return new a(r3, r4, r5, r31, a((Enum) ZeusTransformUtils.preCheckCast(r32.a(), Enum.class, "com.obric.aiagent.plugin")), a(r32), r33, r32.g().a(), r32.e(), Integer.valueOf(r32.h()), r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, Integer.valueOf(r34), 8387584, null);
    }

    public final a d(String r31, com.obric.autogui.agents.vlm.models.omni.a.c r32, String r33, int r34) {
        d.h.b.o.e(r31, DBDefinition.TASK_ID);
        d.h.b.o.e(r32, Ext.KEY_REQUEST);
        d.h.b.o.e(r33, "payloadMode");
        if (r34 > 0) goto L6;
        return null;
    L6:
        String r4 = "local_finalize";
        String r5 = "failure";
        String r6 = "terminal_queue_not_empty";
        return new a(r4, r5, r6, r31, a((Enum) ZeusTransformUtils.preCheckCast(r32.a(), Enum.class, "com.obric.aiagent.plugin")), a(r32), r33, r32.g().a(), r32.e(), Integer.valueOf(r32.h()), null, null, null, null, null, null, null, null, null, null, null, null, null, Integer.valueOf(r34), 8387584, null);
    }

    public final JSONObject b(a r2) {
        d.h.b.o.e(r2, "event");
        return new JSONObject(c(r2));
    }

    public final Map<String, Object> c(a r9) {
        d.h.b.o.e(r9, "event");
        LinkedHashMap r8 = new LinkedHashMap();
        r8.put("schema_version", 1);
        r8.put("stage", r9.a());
        r8.put("outcome", r9.b());
        r8.put("reason_code", r9.c());
        m r0 = f28813a;
        r0.a(r9.d(), (Map) ZeusTransformUtils.preCheckCast(r8, Map.class, "com.obric.aiagent.plugin"), "instruction_id");
        r0.a(r9.e(), (Map) ZeusTransformUtils.preCheckCast(r8, Map.class, "com.obric.aiagent.plugin"), "trigger");
        r8.put("protocol_version", r9.f());
        r0.a(r9.g(), (Map) ZeusTransformUtils.preCheckCast(r8, Map.class, "com.obric.aiagent.plugin"), "payload_mode");
        r0.a(r9.h(), (Map) ZeusTransformUtils.preCheckCast(r8, Map.class, "com.obric.aiagent.plugin"), DBHelper.BATTERY_COL_SOURCE);
        Boolean r1 = r9.i();
        if (r1 == null) goto L5;
        r8.put("is_finish", Boolean.valueOf(r1.booleanValue()));
    L5:
        Integer r2 = r9.j();
        if (r2 == null) goto L8;
        r8.put("image_count", Integer.valueOf(d.l.n.c(((Number) ZeusTransformUtils.preCheckCast(r2, Number.class, "com.obric.aiagent.plugin")).intValue(), 0)));
    L8:
        Long r3 = r9.k();
        if (r3 == null) goto L11;
        r8.put("payload_size_bytes", Long.valueOf(d.l.n.a(((Number) ZeusTransformUtils.preCheckCast(r3, Number.class, "com.obric.aiagent.plugin")).longValue(), 0)));
    L11:
        Long r4 = r9.l();
        if (r4 == null) goto L14;
        r8.put("duration_ms", Long.valueOf(d.l.n.a(((Number) ZeusTransformUtils.preCheckCast(r4, Number.class, "com.obric.aiagent.plugin")).longValue(), 0)));
    L14:
        Integer r5 = r9.m();
        if (r5 == null) goto L17;
        r8.put("retry_index", Integer.valueOf(d.l.n.c(((Number) ZeusTransformUtils.preCheckCast(r5, Number.class, "com.obric.aiagent.plugin")).intValue(), 0)));
    L17:
        Integer r6 = r9.n();
        if (r6 == null) goto L20;
        r8.put("server_code", Integer.valueOf(((Number) ZeusTransformUtils.preCheckCast(r6, Number.class, "com.obric.aiagent.plugin")).intValue()));
    L20:
        r0.a(r9.o(), (Map) ZeusTransformUtils.preCheckCast(r8, Map.class, "com.obric.aiagent.plugin"), "failure_stage");
        r0.a(r9.p(), (Map) ZeusTransformUtils.preCheckCast(r8, Map.class, "com.obric.aiagent.plugin"), "exception_type");
        Integer r7 = r9.q();
        if (r7 == null) goto L23;
        r8.put("total_candidates", Integer.valueOf(d.l.n.c(((Number) ZeusTransformUtils.preCheckCast(r7, Number.class, "com.obric.aiagent.plugin")).intValue(), 0)));
    L23:
        Integer r10 = r9.r();
        if (r10 == null) goto L26;
        r8.put("uploaded_count", Integer.valueOf(d.l.n.c(((Number) ZeusTransformUtils.preCheckCast(r10, Number.class, "com.obric.aiagent.plugin")).intValue(), 0)));
    L26:
        Integer r11 = r9.s();
        if (r11 == null) goto L29;
        r8.put("failed_count", Integer.valueOf(d.l.n.c(((Number) ZeusTransformUtils.preCheckCast(r11, Number.class, "com.obric.aiagent.plugin")).intValue(), 0)));
    L29:
        Integer r12 = r9.t();
        if (r12 == null) goto L32;
        r8.put("skipped_count", Integer.valueOf(d.l.n.c(((Number) ZeusTransformUtils.preCheckCast(r12, Number.class, "com.obric.aiagent.plugin")).intValue(), 0)));
    L32:
        Boolean r13 = r9.u();
        if (r13 == null) goto L35;
        r8.put("stopped_by_omni_running", Boolean.valueOf(r13.booleanValue()));
    L35:
        Boolean r14 = r9.v();
        if (r14 == null) goto L38;
        r8.put("stopped_by_upload_blocked", Boolean.valueOf(r14.booleanValue()));
    L38:
        Integer r15 = r9.w();
        if (r15 == null) goto L41;
        r8.put("active_token_count", Integer.valueOf(d.l.n.c(((Number) ZeusTransformUtils.preCheckCast(r15, Number.class, "com.obric.aiagent.plugin")).intValue(), 0)));
    L41:
        Integer r16 = r9.x();
        if (r16 == null) goto L45;
        r8.put("queue_remaining_count", Integer.valueOf(d.l.n.c(((Number) ZeusTransformUtils.preCheckCast(r16, Number.class, "com.obric.aiagent.plugin")).intValue(), 0)));
    L45:
        return (Map) ZeusTransformUtils.preCheckCast(r8, Map.class, "com.obric.aiagent.plugin");
    }

    public final String a(com.obric.autogui.agents.vlm.models.omni.a.c r1) {
        d.h.b.o.e(r1, "<this>");
        if (r1.e() != null) goto L5;
        return "v1_legacy";
    L5:
        return "v2_explicit_finish";
    }

    public final String a(Throwable r3) {
        d.h.b.o.e(r3, "throwable");
        CharSequence r2 = (CharSequence) ZeusTransformUtils.preCheckCast(r3.getClass().getSimpleName(), CharSequence.class, "com.obric.aiagent.plugin");
        if (d.o.o.d(r2) == false) goto L5;
        r2 = r3.getClass().getName();
    L5:
        d.h.b.o.c(r2, "ifBlank(...)");
        return d.o.o.e((String) ZeusTransformUtils.preCheckCast(r2, String.class, "com.obric.aiagent.plugin"), 128);
    }

    private final boolean a(com.obric.autogui.agents.vlm.models.omni.a.d r1) {
        if (r1.c() <= 0) goto L5;
    L16:
        return true;
    L5:
        if (r1.d() > 0) goto L16;
        if (r1.e() > 0) goto L16;
        if (r1.f() > 0) goto L16;
        if (r1.g() == true) goto L16;
        if (r1.h() == true) goto L16;
        return false;
    }

    private final void a(String r2, Map<String, Object> r3, String r4) {
        Map r1 = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.aiagent.plugin");
        if (r2 != null) goto L5;
        return;
    L5:
        if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r2, CharSequence.class, "com.obric.aiagent.plugin"))) == true) goto L8;
        r2 = null;
    L8:
        if (r2 == null) goto L12;
        r1.put(r4, r2);
        return;
    }

    private final String a(Enum<?> r1) {
        String r0 = r1.name().toLowerCase(Locale.ROOT);
        d.h.b.o.c(r0, "toLowerCase(...)");
        return r0;
    }
}
