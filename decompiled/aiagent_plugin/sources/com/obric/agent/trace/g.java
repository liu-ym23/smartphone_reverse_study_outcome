package com.obric.agent.trace;

import com.bytedance.apm.battery.dao.DBHelper;
import com.bytedance.bdturing.localstorage.DbHelper;
import com.google.gson.Gson;
import com.obric.aiagent.applog.IAppLog;
import com.obric.aiagent.platform.depend.ILogDepend;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import java.util.List;
import kotlinx.coroutines.am;
import kotlinx.coroutines.bd;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: IntentEventReporter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class g {
    private static final String TAG = "IntentEventReporter";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final g f15449a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final am f15450b = null;

    /* JADX INFO: compiled from: IntentEventReporter.kt */
    @d.c.b.a.f(b = "IntentEventReporter.kt", c = {}, d = "invokeSuspend", e = "com.obric.agent.trace.IntentEventReporter$reportAppIntentDuration$1")
    static final class a extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super d.x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f15451a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f15452b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ long f15453c;

        a(String r3, long r4, d.c.d<? super a> r6) {
            d.c.d r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r6, d.c.d.class, "com.obric.aiagent.plugin");
            this.f15452b = r3;
            this.f15453c = r4;
            super(2, r7);
        }

        public final Object a(am r3, d.c.d<? super d.x> r4) {
            return ((a) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), a.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<d.x> create(Object r5, d.c.d<?> r6) {
            d.c.d r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r6, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new a(this.f15452b, this.f15453c, r7), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super d.x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r4) {
            d.c.a.b.a();
            if (this.f15451a != 0) goto L10;
            d.o.a(r4);
            ILogDepend.Companion.i(g.TAG, "reportAppIntentDuration " + this.f15452b + ", " + this.f15453c);
            JSONObject r5 = new JSONObject();
            r5.put("app_intent_state_duration", this.f15453c);
            IAppLog r3 = (IAppLog) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IAppLog.class), IAppLog.class, "com.obric.aiagent.plugin");
            if (r3 == null) goto L8;
            r3.reportToFlow("o_app_intent_state", r5);
        L8:
            return d.x.f38692a;
        L10:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: compiled from: IntentEventReporter.kt */
    @d.c.b.a.f(b = "IntentEventReporter.kt", c = {}, d = "invokeSuspend", e = "com.obric.agent.trace.IntentEventReporter$reportErrorAction$1")
    static final class b extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super d.x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f15454a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f15455b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f15456c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f15457d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ boolean f15458e;

        b(String r3, String r4, String r5, boolean r6, d.c.d<? super b> r7) {
            d.c.d r8 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r7, d.c.d.class, "com.obric.aiagent.plugin");
            this.f15455b = r3;
            this.f15456c = r4;
            this.f15457d = r5;
            this.f15458e = r6;
            super(2, r8);
        }

        public final Object a(am r3, d.c.d<? super d.x> r4) {
            return ((b) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), b.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<d.x> create(Object r8, d.c.d<?> r9) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r9, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new b(this.f15455b, this.f15456c, this.f15457d, this.f15458e, r6), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super d.x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            d.c.a.b.a();
            if (this.f15454a != 0) goto L10;
            d.o.a(r3);
            JSONObject r4 = new JSONObject();
            r4.put("question_id", this.f15455b);
            r4.put("message_id", this.f15456c);
            r4.put("app_intent_intent_name", this.f15457d);
            r4.put("is_complex_task", this.f15458e);
            IAppLog r2 = (IAppLog) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IAppLog.class), IAppLog.class, "com.obric.aiagent.plugin");
            if (r2 == null) goto L8;
            r2.reportToFlow("o_app_intent_action_after_end", r4);
        L8:
            return d.x.f38692a;
        L10:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: compiled from: IntentEventReporter.kt */
    @d.c.b.a.f(b = "IntentEventReporter.kt", c = {}, d = "invokeSuspend", e = "com.obric.agent.trace.IntentEventReporter$reportPermissionGranted$1")
    static final class c extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super d.x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f15459a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f15460b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f15461c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ boolean f15462d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f15463e;

        c(String r3, String r4, boolean r5, String r6, d.c.d<? super c> r7) {
            d.c.d r8 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r7, d.c.d.class, "com.obric.aiagent.plugin");
            this.f15460b = r3;
            this.f15461c = r4;
            this.f15462d = r5;
            this.f15463e = r6;
            super(2, r8);
        }

        public final Object a(am r3, d.c.d<? super d.x> r4) {
            return ((c) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), c.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<d.x> create(Object r8, d.c.d<?> r9) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r9, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new c(this.f15460b, this.f15461c, this.f15462d, this.f15463e, r6), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super d.x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            d.c.a.b.a();
            if (this.f15459a != 0) goto L13;
            d.o.a(r3);
            JSONObject r4 = new JSONObject();
            r4.put("app_intent_permission_name", this.f15460b);
            r4.put("app_intent_scene", this.f15461c);
            r4.put("app_intent_permission_is_granted", this.f15462d);
            String r2 = this.f15463e;
            if (r2 == null) goto L7;
            r4.put("app_intent_permission_reason", r2);
        L7:
            IAppLog r5 = (IAppLog) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IAppLog.class), IAppLog.class, "com.obric.aiagent.plugin");
            if (r5 == null) goto L11;
            r5.reportToFlow("o_app_intent_permission", r4);
        L11:
            return d.x.f38692a;
        L13:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: compiled from: IntentEventReporter.kt */
    @d.c.b.a.f(b = "IntentEventReporter.kt", c = {}, d = "invokeSuspend", e = "com.obric.agent.trace.IntentEventReporter$reportQueryLocalCheck$1")
    static final class d extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super d.x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f15464a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f15465b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ boolean f15466c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ boolean f15467d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f15468e;
        final /* synthetic */ boolean f;
        final /* synthetic */ int g;
        final /* synthetic */ boolean h;
        final /* synthetic */ long i;

        d(String r3, boolean r4, boolean r5, String r6, boolean r7, int r8, boolean r9, long r10, d.c.d<? super d> r12) {
            d.c.d r13 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r12, d.c.d.class, "com.obric.aiagent.plugin");
            this.f15465b = r3;
            this.f15466c = r4;
            this.f15467d = r5;
            this.f15468e = r6;
            this.f = r7;
            this.g = r8;
            this.h = r9;
            this.i = r10;
            super(2, r13);
        }

        public final Object a(am r3, d.c.d<? super d.x> r4) {
            return ((d) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), d.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<d.x> create(Object r13, d.c.d<?> r14) {
            d.c.d r11 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r14, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new d(this.f15465b, this.f15466c, this.f15467d, this.f15468e, this.f, this.g, this.h, this.i, r11), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super d.x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            d.c.a.b.a();
            if (this.f15464a != 0) goto L10;
            d.o.a(r3);
            JSONObject r4 = new JSONObject();
            r4.put("app_intent_query_check_query_id", this.f15465b);
            r4.put("app_intent_query_check_is_continuous_talk", this.f15466c ? 1 : 0);
            r4.put("app_intent_query_check_triggered", this.f15467d ? 1 : 0);
            r4.put("app_intent_query_check_hit_source", this.f15468e);
            r4.put("app_intent_query_check_did_fetch", this.f ? 1 : 0);
            r4.put("app_intent_query_check_fetch_size", this.g);
            r4.put("app_intent_query_check_exist", this.h ? 1 : 0);
            r4.put("app_intent_query_check_cost", this.i);
            IAppLog r2 = (IAppLog) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IAppLog.class), IAppLog.class, "com.obric.aiagent.plugin");
            if (r2 == null) goto L8;
            r2.reportToFlow("o_app_intent_query_local_check", r4);
        L8:
            return d.x.f38692a;
        L10:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: compiled from: IntentEventReporter.kt */
    @d.c.b.a.f(b = "IntentEventReporter.kt", c = {}, d = "invokeSuspend", e = "com.obric.agent.trace.IntentEventReporter$reportRealtimeContextCost$1")
    static final class e extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super d.x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f15469a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ long f15470b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ long f15471c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ boolean f15472d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ int f15473e;
        final /* synthetic */ int f;

        e(long r3, long r5, boolean r7, int r8, int r9, d.c.d<? super e> r10) {
            d.c.d r11 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r10, d.c.d.class, "com.obric.aiagent.plugin");
            this.f15470b = r3;
            this.f15471c = r5;
            this.f15472d = r7;
            this.f15473e = r8;
            this.f = r9;
            super(2, r11);
        }

        public final Object a(am r3, d.c.d<? super d.x> r4) {
            return ((e) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), e.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<d.x> create(Object r11, d.c.d<?> r12) {
            d.c.d r9 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r12, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new e(this.f15470b, this.f15471c, this.f15472d, this.f15473e, this.f, r9), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super d.x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r4) {
            d.c.a.b.a();
            if (this.f15469a != 0) goto L10;
            d.o.a(r4);
            JSONObject r5 = new JSONObject();
            r5.put("app_intent_realtime_context_cost", this.f15470b);
            r5.put("app_intent_realtime_context_timeout", this.f15471c);
            r5.put("app_intent_realtime_context_timed_out", this.f15472d ? 1 : 0);
            r5.put("app_intent_realtime_context_alarm_size", this.f15473e);
            r5.put("app_intent_realtime_context_recording_size", this.f);
            IAppLog r3 = (IAppLog) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IAppLog.class), IAppLog.class, "com.obric.aiagent.plugin");
            if (r3 == null) goto L8;
            r3.reportToFlow("o_realtime_context_cost", r5);
        L8:
            return d.x.f38692a;
        L10:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: compiled from: IntentEventReporter.kt */
    @d.c.b.a.f(b = "IntentEventReporter.kt", c = {}, d = "invokeSuspend", e = "com.obric.agent.trace.IntentEventReporter$reportScreenShotState$1")
    static final class f extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super d.x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f15474a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f15475b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f15476c;

        f(String r3, String r4, d.c.d<? super f> r5) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            this.f15475b = r3;
            this.f15476c = r4;
            super(2, r6);
        }

        public final Object a(am r3, d.c.d<? super d.x> r4) {
            return ((f) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), f.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<d.x> create(Object r3, d.c.d<?> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new f(this.f15475b, this.f15476c, r5), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super d.x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r4) {
            d.c.a.b.a();
            if (this.f15474a != 0) goto L18;
            d.o.a(r4);
            JSONObject r5 = new JSONObject();
            r5.put("o_screenshot_state", this.f15475b);
            String r3 = this.f15476c;
            if (r3 != null) goto L7;
        L12:
            IAppLog r6 = (IAppLog) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IAppLog.class), IAppLog.class, "com.obric.aiagent.plugin");
            if (r6 == null) goto L16;
            r6.reportToFlow("o_screenshot_state", r5);
        L16:
            return d.x.f38692a;
        L7:
            if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r3, CharSequence.class, "com.obric.aiagent.plugin"))) == true) goto L10;
            r3 = null;
        L10:
            if (r3 == null) goto L12;
            r5.put("o_screenshot_state_reason", r3);
            goto L12
        L18:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.obric.agent.trace.g$g, reason: collision with other inner class name */
    /* JADX INFO: compiled from: IntentEventReporter.kt */
    @d.c.b.a.f(b = "IntentEventReporter.kt", c = {}, d = "invokeSuspend", e = "com.obric.agent.trace.IntentEventReporter$reportSendMessageExtInfo$1")
    static final class C0316g extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super d.x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f15477a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ List<d.m<String, Integer>> f15478b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ int f15479c;

        C0316g(List<d.m<String, Integer>> r3, int r4, d.c.d<? super C0316g> r5) {
            List<d.m<String, Integer>> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
            d.c.d r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            this.f15478b = r6;
            this.f15479c = r4;
            super(2, r7);
        }

        public final Object a(am r3, d.c.d<? super d.x> r4) {
            return ((C0316g) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), C0316g.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<d.x> create(Object r3, d.c.d<?> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new C0316g(this.f15478b, this.f15479c, r5), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super d.x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r7) {
            d.c.a.b.a();
            if (this.f15477a != 0) goto L14;
            d.o.a(r7);
            JSONObject r8 = new JSONObject();
            r8.put("map_size", this.f15478b.size());
            r8.put("total_size", this.f15479c);
            JSONArray r0 = new JSONArray();
            Iterator r6 = ((Iterable) ZeusTransformUtils.preCheckCast(this.f15478b, Iterable.class, "com.obric.aiagent.plugin")).iterator();
        L6:
            if (r6.hasNext() == false) goto L8;
            d.m r1 = (d.m) ZeusTransformUtils.preCheckCast(r6.next(), d.m.class, "com.obric.aiagent.plugin");
            String r3 = (String) ZeusTransformUtils.preCheckCast(r1.c(), String.class, "com.obric.aiagent.plugin");
            int r2 = ((Number) ZeusTransformUtils.preCheckCast(r1.d(), Number.class, "com.obric.aiagent.plugin")).intValue();
            JSONObject r4 = new JSONObject();
            r4.put("key", r3);
            r4.put(MonitorConstants.SIZE, r2);
            r0.put(r4);
            goto L6
        L8:
            r8.put("ext_details", r0.toString());
            IAppLog r9 = (IAppLog) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IAppLog.class), IAppLog.class, "com.obric.aiagent.plugin");
            if (r9 == null) goto L12;
            r9.reportToFlow("o_send_message_ext_info", r8);
        L12:
            return d.x.f38692a;
        L14:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: compiled from: IntentEventReporter.kt */
    @d.c.b.a.f(b = "IntentEventReporter.kt", c = {}, d = "invokeSuspend", e = "com.obric.agent.trace.IntentEventReporter$reportSendMessageExtOversized$1")
    static final class h extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super d.x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f15480a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f15481b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ int f15482c;

        h(String r3, int r4, d.c.d<? super h> r5) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            this.f15481b = r3;
            this.f15482c = r4;
            super(2, r6);
        }

        public final Object a(am r3, d.c.d<? super d.x> r4) {
            return ((h) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), h.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<d.x> create(Object r3, d.c.d<?> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new h(this.f15481b, this.f15482c, r5), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super d.x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            d.c.a.b.a();
            if (this.f15480a != 0) goto L10;
            d.o.a(r3);
            JSONObject r4 = new JSONObject();
            r4.put("key", this.f15481b);
            r4.put(MonitorConstants.SIZE, this.f15482c);
            IAppLog r2 = (IAppLog) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IAppLog.class), IAppLog.class, "com.obric.aiagent.plugin");
            if (r2 == null) goto L8;
            r2.reportToFlow("o_send_message_ext_oversized", r4);
        L8:
            return d.x.f38692a;
        L10:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: compiled from: IntentEventReporter.kt */
    @d.c.b.a.f(b = "IntentEventReporter.kt", c = {}, d = "invokeSuspend", e = "com.obric.agent.trace.IntentEventReporter$reportShortcut$1")
    static final class i extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super d.x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f15483a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f15484b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private /* synthetic */ Object f15485c;

        i(String r3, d.c.d<? super i> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f15484b = r3;
            super(2, r5);
        }

        public final Object a(am r3, d.c.d<? super d.x> r4) {
            return ((i) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), i.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<d.x> create(Object r3, d.c.d<?> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            i r0 = new i(this.f15484b, r5);
            r0.f15485c = r3;
            return (d.c.d) ZeusTransformUtils.preCheckCast(r0, d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super d.x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r5) {
            d.c.a.b.a();
            if (this.f15483a != 0) goto L15;
            d.o.a(r5);
            am r6 = (am) ZeusTransformUtils.preCheckCast(this.f15485c, am.class, "com.obric.aiagent.plugin");
            String r4 = this.f15484b;
            if (r4 == null) goto L9;
            com.obric.eventkit.task.model.a r7 = (com.obric.eventkit.task.model.a) ZeusTransformUtils.preCheckCast(new Gson().fromJson(r4, com.obric.eventkit.task.model.a.class), com.obric.eventkit.task.model.a.class, "com.obric.aiagent.plugin");
            JSONObject r0 = new JSONObject();
            r0.put("o_shortcut_from", r7.g());
            r0.put("o_shortcut_task_mode", r7.d());
            r0.put("o_shortcut_task_type", r7.a());
            r0.put("o_shortcut_task_is_try_run", r7.h());
            IAppLog r8 = (IAppLog) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IAppLog.class), IAppLog.class, "com.obric.aiagent.plugin");
            if (r8 == null) goto L13;
            r8.reportToFlow("o_shortcut", r0);
        L13:
            return d.x.f38692a;
        L9:
            JSONObject r9 = new JSONObject();
            IAppLog r1 = (IAppLog) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IAppLog.class), IAppLog.class, "com.obric.aiagent.plugin");
            if (r1 == null) goto L13;
            r1.reportToFlow("o_shortcut", r9);
            goto L13
        L15:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: compiled from: IntentEventReporter.kt */
    @d.c.b.a.f(b = "IntentEventReporter.kt", c = {}, d = "invokeSuspend", e = "com.obric.agent.trace.IntentEventReporter$uploadTaskModeLevel$1")
    static final class j extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super d.x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f15486a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f15487b;

        j(String r3, d.c.d<? super j> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f15487b = r3;
            super(2, r5);
        }

        public final Object a(am r3, d.c.d<? super d.x> r4) {
            return ((j) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), j.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<d.x> create(Object r2, d.c.d<?> r3) {
            d.c.d r4 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new j(this.f15487b, r4), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super d.x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r4) {
            d.c.a.b.a();
            if (this.f15486a != 0) goto L10;
            d.o.a(r4);
            JSONObject r5 = new JSONObject();
            r5.put("o_app_intent_mode_level", this.f15487b);
            IAppLog r3 = (IAppLog) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IAppLog.class), IAppLog.class, "com.obric.aiagent.plugin");
            if (r3 == null) goto L8;
            r3.reportToFlow("o_app_intent_mode_level", r5);
        L8:
            return d.x.f38692a;
        L10:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    private g() {
    }

    static {
        f15449a = new g();
        f15450b = com.obric.agent.e.f14435a.b();
    }

    public final void a(String r7, long r8) {
        d.h.b.o.e(r7, DbHelper.COL_ID);
        kotlinx.coroutines.i.a(f15450b, (d.c.g) ZeusTransformUtils.preCheckCast(bd.c(), d.c.g.class, "com.obric.aiagent.plugin"), null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new a(r7, r8, null), d.h.a.m.class, "com.obric.aiagent.plugin"), 2, null);
    }

    public final void a(String r10, String r11, boolean r12, String r13) {
        d.h.b.o.e(r10, "permission");
        d.h.b.o.e(r11, DBHelper.BATTERY_COL_SCENE);
        kotlinx.coroutines.i.a(f15450b, (d.c.g) ZeusTransformUtils.preCheckCast(bd.c(), d.c.g.class, "com.obric.aiagent.plugin"), null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new c(r10, r11, r12, r13, null), d.h.a.m.class, "com.obric.aiagent.plugin"), 2, null);
    }

    public final void a(String r7, String r8) {
        kotlinx.coroutines.i.a(f15450b, (d.c.g) ZeusTransformUtils.preCheckCast(bd.c(), d.c.g.class, "com.obric.aiagent.plugin"), null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new f(r7, r8, null), d.h.a.m.class, "com.obric.aiagent.plugin"), 2, null);
    }

    public final void a(String r7) {
        kotlinx.coroutines.i.a(f15450b, (d.c.g) ZeusTransformUtils.preCheckCast(bd.c(), d.c.g.class, "com.obric.aiagent.plugin"), null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new i(r7, null), d.h.a.m.class, "com.obric.aiagent.plugin"), 2, null);
    }

    public final void b(String r7) {
        kotlinx.coroutines.i.a(f15450b, (d.c.g) ZeusTransformUtils.preCheckCast(bd.c(), d.c.g.class, "com.obric.aiagent.plugin"), null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new j(r7, null), d.h.a.m.class, "com.obric.aiagent.plugin"), 2, null);
    }

    public final void a(String r10, String r11, String r12, boolean r13) {
        kotlinx.coroutines.i.a(f15450b, (d.c.g) ZeusTransformUtils.preCheckCast(bd.c(), d.c.g.class, "com.obric.aiagent.plugin"), null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new b(r10, r11, r12, r13, null), d.h.a.m.class, "com.obric.aiagent.plugin"), 2, null);
    }

    public final void a(List<d.m<String, Integer>> r8, int r9) {
        List r7 = (List) ZeusTransformUtils.wrapperContextForParams(r8, List.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r7, "extEntries");
        kotlinx.coroutines.i.a(f15450b, (d.c.g) ZeusTransformUtils.preCheckCast(bd.c(), d.c.g.class, "com.obric.aiagent.plugin"), null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new C0316g(r7, r9, null), d.h.a.m.class, "com.obric.aiagent.plugin"), 2, null);
    }

    public final void a(String r7, int r8) {
        d.h.b.o.e(r7, "key");
        kotlinx.coroutines.i.a(f15450b, (d.c.g) ZeusTransformUtils.preCheckCast(bd.c(), d.c.g.class, "com.obric.aiagent.plugin"), null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new h(r7, r8, null), d.h.a.m.class, "com.obric.aiagent.plugin"), 2, null);
    }

    public final void a(long r14, long r16, boolean r18, int r19, int r20) {
        kotlinx.coroutines.i.a(f15450b, (d.c.g) ZeusTransformUtils.preCheckCast(bd.c(), d.c.g.class, "com.obric.aiagent.plugin"), null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new e(r14, r16, r18, r19, r20, null), d.h.a.m.class, "com.obric.aiagent.plugin"), 2, null);
    }

    public final void a(String r16, boolean r17, boolean r18, String r19, boolean r20, int r21, boolean r22, long r23) {
        d.h.b.o.e(r16, "queryId");
        d.h.b.o.e(r19, "hitSource");
        kotlinx.coroutines.i.a(f15450b, (d.c.g) ZeusTransformUtils.preCheckCast(bd.c(), d.c.g.class, "com.obric.aiagent.plugin"), null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new d(r16, r17, r18, r19, r20, r21, r22, r23, null), d.h.a.m.class, "com.obric.aiagent.plugin"), 2, null);
    }
}
