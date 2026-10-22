package com.obric.agent.trace.omni;

import com.obric.agent.trace.IOmniReportService;
import com.obric.aiagent.applog.IAppLog;
import com.obric.aiagent.platform.depend.ILogDepend;
import com.obric.aiagent.platform.depend.ISecureLogDepend;
import com.obric.aiagent.platform.depend.ISysLogDepend;
import com.obric.aiagent.ttnet.ITTNet;
import com.obric.assistant.dm.api.statemachine.manager.IDialogStateManager;
import com.obric.autogui.common.api.AOBizTracking;
import com.obric.autogui.common.api.platform.tracking.TrackingReportTarget;
import com.obric.capabilitykit.common.AppAction;
import com.obric.funcall_api.bean.IntentAppAction;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.ao;
import d.x;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import kotlinx.coroutines.am;
import kotlinx.coroutines.an;
import kotlinx.coroutines.bd;
import kotlinx.coroutines.cx;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: OmniReportServiceImpl.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class OmniReportServiceImpl implements IOmniReportService {
    public static final a Companion = null;
    private static final String TAG = "OmniReportServiceImpl";
    private final ConcurrentHashMap<String, ConcurrentLinkedQueue<d.m<String, JSONObject>>> pendingReportMap;
    private final am scope;

    /* JADX INFO: compiled from: OmniReportServiceImpl.kt */
    public static final class a {
        public /* synthetic */ a(d.h.b.h r1) {
            this();
        }

        private a() {
        }
    }

    /* JADX INFO: compiled from: OmniReportServiceImpl.kt */
    /* synthetic */ class b extends d.h.b.l implements d.h.a.r<String, com.obric.agent.trace.omni.a, Map<String, ? extends String>, Boolean, x> {
        b(Object r8) {
            super(4, r8, OmniReportServiceImpl.class, "doReportWithCommonParams", "doReportWithCommonParams(Ljava/lang/String;Lcom/obric/agent/trace/omni/BucketSnapshot;Ljava/util/Map;Z)V", 0);
        }

        @Override // d.h.a.r
        public /* synthetic */ x a(String r3, com.obric.agent.trace.omni.a r4, Map<String, ? extends String> r5, Boolean r6) {
            a((String) ZeusTransformUtils.preCheckCast(r3, String.class, "com.obric.aiagent.plugin"), (com.obric.agent.trace.omni.a) ZeusTransformUtils.preCheckCast(r4, com.obric.agent.trace.omni.a.class, "com.obric.aiagent.plugin"), (Map) ZeusTransformUtils.preCheckCast(r5, Map.class, "com.obric.aiagent.plugin"), ((Boolean) ZeusTransformUtils.preCheckCast(r6, Boolean.class, "com.obric.aiagent.plugin")).booleanValue());
            return x.f38692a;
        }

        public final void a(String r3, com.obric.agent.trace.omni.a r4, Map<String, String> r5, boolean r6) {
            Map r7 = (Map) ZeusTransformUtils.wrapperContextForParams(r5, Map.class, "com.obric.aiagent.plugin");
            d.h.b.o.e(r3, "p0");
            d.h.b.o.e(r4, "p1");
            d.h.b.o.e(r7, "p2");
            OmniReportServiceImpl.access$doReportWithCommonParams((OmniReportServiceImpl) ZeusTransformUtils.preCheckCast(this.receiver, OmniReportServiceImpl.class, "com.obric.aiagent.plugin"), r3, r4, r7, r6);
        }
    }

    /* JADX INFO: compiled from: OmniReportServiceImpl.kt */
    /* synthetic */ class c extends d.h.b.l implements d.h.a.r<String, com.obric.agent.trace.omni.a, Map<String, ? extends String>, Boolean, x> {
        c(Object r8) {
            super(4, r8, OmniReportServiceImpl.class, "doReportWithCommonParams", "doReportWithCommonParams(Ljava/lang/String;Lcom/obric/agent/trace/omni/BucketSnapshot;Ljava/util/Map;Z)V", 0);
        }

        @Override // d.h.a.r
        public /* synthetic */ x a(String r3, com.obric.agent.trace.omni.a r4, Map<String, ? extends String> r5, Boolean r6) {
            a((String) ZeusTransformUtils.preCheckCast(r3, String.class, "com.obric.aiagent.plugin"), (com.obric.agent.trace.omni.a) ZeusTransformUtils.preCheckCast(r4, com.obric.agent.trace.omni.a.class, "com.obric.aiagent.plugin"), (Map) ZeusTransformUtils.preCheckCast(r5, Map.class, "com.obric.aiagent.plugin"), ((Boolean) ZeusTransformUtils.preCheckCast(r6, Boolean.class, "com.obric.aiagent.plugin")).booleanValue());
            return x.f38692a;
        }

        public final void a(String r3, com.obric.agent.trace.omni.a r4, Map<String, String> r5, boolean r6) {
            Map r7 = (Map) ZeusTransformUtils.wrapperContextForParams(r5, Map.class, "com.obric.aiagent.plugin");
            d.h.b.o.e(r3, "p0");
            d.h.b.o.e(r4, "p1");
            d.h.b.o.e(r7, "p2");
            OmniReportServiceImpl.access$doReportWithCommonParams((OmniReportServiceImpl) ZeusTransformUtils.preCheckCast(this.receiver, OmniReportServiceImpl.class, "com.obric.aiagent.plugin"), r3, r4, r7, r6);
        }
    }

    /* JADX INFO: compiled from: OmniReportServiceImpl.kt */
    @d.c.b.a.f(b = "OmniReportServiceImpl.kt", c = {}, d = "invokeSuspend", e = "com.obric.agent.trace.omni.OmniReportServiceImpl$recordDispatchIntentEnd$1")
    static final class d extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f15592a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f15593b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ Map<String, String> f15594c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f15595d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ long f15596e;
        final /* synthetic */ String f;
        final /* synthetic */ OmniReportServiceImpl g;
        private /* synthetic */ Object h;

        d(String r3, Map<String, String> r4, String r5, long r6, String r8, OmniReportServiceImpl r9, d.c.d<? super d> r10) {
            Map<String, String> r7 = (Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.aiagent.plugin");
            d.c.d r11 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r10, d.c.d.class, "com.obric.aiagent.plugin");
            this.f15593b = r3;
            this.f15594c = r7;
            this.f15595d = r5;
            this.f15596e = r6;
            this.f = r8;
            this.g = r9;
            super(2, r11);
        }

        public final Object a(am r3, d.c.d<? super x> r4) {
            return ((d) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), d.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r12, d.c.d<?> r13) {
            d.c.d r10 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r13, d.c.d.class, "com.obric.aiagent.plugin");
            d r14 = new d(this.f15593b, this.f15594c, this.f15595d, this.f15596e, this.f, this.g, r10);
            r14.h = r12;
            return (d.c.d) ZeusTransformUtils.preCheckCast(r14, d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r37) {
            d.c.a.b.a();
            if (this.f15592a != 0) goto L153;
            d.o.a(r37);
            am r0 = (am) ZeusTransformUtils.preCheckCast(this.h, am.class, "com.obric.aiagent.plugin");
            ISecureLogDepend.Companion.i(OmniReportServiceImpl.TAG, "recordDispatchIntentEnd: msgId: " + this.f15593b);
            Map<String, String> r2 = this.f15594c;
            String r5 = "{}";
            if (r2 == null) goto L8;
            String r3 = (String) ZeusTransformUtils.preCheckCast(r2.get("client_meta"), String.class, "com.obric.aiagent.plugin");
            if (r3 == null) goto L8;
        L9:
            JSONObject r1 = new JSONObject(r3);
            String r6 = r1.optString("tool_id");
            String r7 = "";
            if (r6 != null) goto L12;
            r6 = "";
        L12:
            com.obric.agent.trace.omni.a r8 = k.f15686a.b(this.f15593b);
            if (r8 == null) goto L47;
            Map<String, List<Object>> r12 = r8.b();
            if (r12 == null) goto L47;
            List r13 = (List) ZeusTransformUtils.preCheckCast(r12.get("dispatch_intent_start"), List.class, "com.obric.aiagent.plugin");
            if (r13 == null) goto L47;
            Iterable r14 = (Iterable) ZeusTransformUtils.preCheckCast(r13, Iterable.class, "com.obric.aiagent.plugin");
            Collection r15 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");
            Iterator r16 = r14.iterator();
        L20:
            if (r16.hasNext() == false) goto L24;
            Object r17 = r16.next();
            if (ZeusTransformUtils.instanceOf(r17, t.class) == false) goto L20;
            r15.add(r17);
            goto L20
        L24:
            List r18 = (List) ZeusTransformUtils.preCheckCast(r15, List.class, "com.obric.aiagent.plugin");
            String r19 = this.f15595d;
            ListIterator r110 = r18.listIterator(r18.size());
        L26:
            if (r110.hasPrevious() == false) goto L45;
            Object r111 = r110.previous();
            t r112 = (t) ZeusTransformUtils.preCheckCast(r111, t.class, "com.obric.aiagent.plugin");
            if (d.h.b.o.a(r112.b(), r19) == true) goto L30;
        L42:
            boolean r9 = false;
        L43:
            if (r9 == false) goto L26;
        L46:
            t r113 = (t) ZeusTransformUtils.preCheckCast(r111, t.class, "com.obric.aiagent.plugin");
        L49:
            if (r113 != null) goto L51;
        L150:
            ISecureLogDepend.Companion.e(OmniReportServiceImpl.TAG, "recordDispatchIntentEnd: " + this.f15593b + ", toolName: " + this.f15595d + ", toolId: " + r6 + ", not found in dispatch intent start");
            return x.f38692a;
        L51:
            if (r113.h() != (-1)) goto L150;
            long r11 = this.f15596e - r113.c();
            String r4 = r1.optString("origin_tools_input");
            d.h.b.o.a(r4);
            if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.aiagent.plugin"))) == true) goto L57;
            r4 = null;
        L57:
            if (r4 != null) goto L154;
            r4 = "[]";
        L154:
            d.n.a r114 = d.n.f38560a;     // Catch: Throwable -> L61
            Object r10 = d.n.f(new JSONArray(r4));     // Catch: Throwable -> L61
        L64:
            if (d.n.b(r10) == false) goto L66;
            r10 = null;
        L66:
            JSONArray r20 = (JSONArray) ZeusTransformUtils.preCheckCast(r10, JSONArray.class, "com.obric.aiagent.plugin");
            if (r20 != null) goto L156;
            r20 = new JSONArray();
        L156:
            d.n.a r115 = d.n.f38560a;     // Catch: Throwable -> L88
            if (r20.length() == 0) goto L85;
            String r21 = r20.optString(0);     // Catch: Throwable -> L88
            d.h.b.o.a(r21);     // Catch: Throwable -> L88
            if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r21, CharSequence.class, "com.obric.aiagent.plugin"))) == true) goto L75;
            r21 = null;
        L75:
            if (r21 != null) goto L77;
            r21 = "{}";
        L77:
            String r22 = new JSONObject(r21).optString("step");     // Catch: Throwable -> L88
            d.h.b.o.a(r22);     // Catch: Throwable -> L88
            if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r22, CharSequence.class, "com.obric.aiagent.plugin"))) == true) goto L81;
            r22 = null;
        L81:
            if (r22 == null) goto L84;
            r5 = r22;
        L84:
            JSONObject r23 = new JSONObject(r5);     // Catch: Throwable -> L88
        L86:
            Object r24 = d.n.f(r23);     // Catch: Throwable -> L88
        L91:
            if (d.n.b(r24) == false) goto L93;
            r24 = null;
        L93:
            JSONObject r25 = (JSONObject) ZeusTransformUtils.preCheckCast(r24, JSONObject.class, "com.obric.aiagent.plugin");
            if (r25 != null) goto L96;
            r25 = new JSONObject();
        L96:
            String r26 = r25.optString("action_args");
            if (r26 != null) goto L99;
            r26 = "";
        L99:
            String r27 = r25.optString("action_type");
            if (r27 != null) goto L102;
            r27 = "";
        L102:
            Map<String, String> r116 = this.f15594c;
            if (r116 == null) goto L108;
            String r117 = (String) ZeusTransformUtils.preCheckCast(r116.get("o_execute_id"), String.class, "com.obric.aiagent.plugin");
            if (r117 == null) goto L108;
            r7 = r117;
        L108:
            k r118 = k.f15686a;
            String r119 = this.f15593b;
            Map<String, ? extends Object> r28 = ao.b(new d.m[]{d.s.a("dispatch_intent_end", t.a(r113, null, null, this.f15595d, 0, r7, this.f15596e, r26, r27, r11, this.f, 11, null))});
            String r120 = this.f15595d;
            String r121 = this.f15593b;
            long r122 = this.f15596e;
            String r123 = r7;
            if (r8 == null) goto L120;
            List r124 = (List) ZeusTransformUtils.preCheckCast(r8.b().get("prepare_end"), List.class, "com.obric.aiagent.plugin");
            if (r124 == null) goto L118;
            Object r125 = d.a.p.n(r124);
            if (r125 == null) goto L118;
            if (ZeusTransformUtils.instanceOf(r125, Long.class) == false) goto L118;
        L119:
            Long r126 = (Long) ZeusTransformUtils.preCheckCast(r125, Long.class, "com.obric.aiagent.plugin");
        L121:
            String r127 = r120.toUpperCase(Locale.ROOT);
            d.h.b.o.c(r127, "toUpperCase(...)");
            if (d.h.b.o.a(r127, "GUI_INIT") == false) goto L125;
            if (r126 != null) goto L125;
            ISecureLogDepend.Companion.i(OmniReportServiceImpl.TAG, "recordDispatchIntentEnd: " + r121 + " prepare end time");
            k.f15686a.a(r121, ao.a(d.s.a("prepare_end", d.c.b.a.b.a(r122))));
        L125:
            x r29 = x.f38692a;
            r118.a(r119, r28);
            if (d.h.b.o.a(this.f15595d, "GUI_Action") == false) goto L143;
            if (r8 == null) goto L140;
            List r30 = (List) ZeusTransformUtils.preCheckCast(r8.b().get("is_first_gui_action"), List.class, "com.obric.aiagent.plugin");
            if (r30 == null) goto L136;
            Object r31 = d.a.p.n(r30);
            if (r31 == null) goto L136;
            if (ZeusTransformUtils.instanceOf(r31, Boolean.class) == false) goto L136;
            Object r128 = r31;
        L137:
            Boolean r32 = (Boolean) ZeusTransformUtils.preCheckCast(r128, Boolean.class, "com.obric.aiagent.plugin");
            if (r32 == null) goto L140;
            boolean r33 = r32.booleanValue();
        L141:
            if (r33 == false) goto L143;
            boolean r129 = true;
        L144:
            if (r129 == false) goto L146;
            k.f15686a.a(this.f15593b, ao.a(d.s.a("is_first_gui_action", d.c.b.a.b.a(false))));
        L146:
            if (r8 == null) goto L149;
            OmniReportServiceImpl r34 = this.g;
            String r35 = this.f15595d;
            String r36 = this.f;
            JSONObject r38 = OmniReportServiceImpl.access$getCommonParams(r34, r8);
            r38.put("tool_id", r6);
            r38.put("tool_name", r35);
            r38.put("tool_args", r26);
            r38.put("action_type", r27);
            r38.put("is_server_tool", false);
            r38.put("duration", r11);
            r38.put("execute_id", r123);
            r38.put("error_code", r36);
            r38.put("is_first_gui_action", r129);
            d.s.a("feature", r34.buildFeatureJson());
            x r39 = x.f38692a;
            OmniReportServiceImpl.doReport$default(r34, "obric_omni_tool_exec", r38, false, 4, null);
        L149:
            return x.f38692a;
        L136:
            r128 = null;
        L140:
            r33 = true;
        L143:
            r129 = false;
        L118:
            r125 = null;
            goto L119
        L120:
            r126 = null;
            goto L121
        L85:
            r23 = new JSONObject();     // Catch: Throwable -> L88
        L88:
            th = move-exception;
            d.n.a r40 = d.n.f38560a;
            r24 = d.n.f(d.o.a(th));
        L61:
            th = move-exception;
            d.n.a r130 = d.n.f38560a;
            r10 = d.n.f(d.o.a(th));
            goto L64
        L30:
            if (((CharSequence) ZeusTransformUtils.preCheckCast(r112.a(), CharSequence.class, "com.obric.aiagent.plugin")).length() != 0) goto L32;
            boolean r41 = true;
        L33:
            if (r41 == false) goto L40;
            if (((CharSequence) ZeusTransformUtils.preCheckCast(r6, CharSequence.class, "com.obric.aiagent.plugin")).length() <= 0) goto L37;
            boolean r42 = true;
        L38:
            if (r42 == false) goto L40;
        L41:
            r9 = true;
            goto L43
        L37:
            r42 = false;
        L40:
            if (d.h.b.o.a(r112.a(), r6) == false) goto L42;
        L32:
            r41 = false;
            goto L33
        L45:
            r111 = null;
        L47:
            r113 = null;
        L8:
            r3 = "{}";
            goto L9
        L153:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: compiled from: OmniReportServiceImpl.kt */
    @d.c.b.a.f(b = "OmniReportServiceImpl.kt", c = {}, d = "invokeSuspend", e = "com.obric.agent.trace.omni.OmniReportServiceImpl$recordDispatchIntentStart$1")
    static final class e extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f15597a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f15598b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ long f15599c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f15600d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f15601e;

        e(String r3, long r4, String r6, String r7, d.c.d<? super e> r8) {
            d.c.d r9 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r8, d.c.d.class, "com.obric.aiagent.plugin");
            this.f15598b = r3;
            this.f15599c = r4;
            this.f15600d = r6;
            this.f15601e = r7;
            super(2, r9);
        }

        public final Object a(am r3, d.c.d<? super x> r4) {
            return ((e) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), e.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r9, d.c.d<?> r10) {
            d.c.d r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r10, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new e(this.f15598b, this.f15599c, this.f15600d, this.f15601e, r7), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r21) {
            d.c.a.b.a();
            if (this.f15597a != 0) goto L16;
            d.o.a(r21);
            if (k.f15686a.a(this.f15598b, "prepare_request_server_end") == true) goto L7;
            ISecureLogDepend.Companion.i(OmniReportServiceImpl.TAG, "recordDispatchIntentStart: " + this.f15598b);
            k.f15686a.a(this.f15598b, ao.a(d.s.a("prepare_request_server_end", d.c.b.a.b.a(this.f15599c))));
        L7:
            String r1 = new JSONObject(this.f15600d).optString("ext");
            d.h.b.o.a(r1);
            if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r1, CharSequence.class, "com.obric.aiagent.plugin"))) == true) goto L11;
            r1 = null;
        L11:
            if (r1 != null) goto L13;
            r1 = "{}";
        L13:
            String r6 = new JSONObject(r1).optString("tool_id");
            ISecureLogDepend.Companion.i(OmniReportServiceImpl.TAG, "recordDispatchIntentStart: msgId: " + this.f15598b + ", " + this.f15601e + " toolId: " + r6);
            k r2 = k.f15686a;
            String r3 = this.f15598b;
            String r5 = this.f15598b;
            d.h.b.o.a(r6);
            r2.a(r3, ao.a(d.s.a("dispatch_intent_start", new t(r5, r6, this.f15601e, this.f15599c, null, 0, null, null, 0, null, 1008, null))));
            return x.f38692a;
        L16:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: compiled from: OmniReportServiceImpl.kt */
    @d.c.b.a.f(b = "OmniReportServiceImpl.kt", c = {}, d = "invokeSuspend", e = "com.obric.agent.trace.omni.OmniReportServiceImpl$recordNetworkError$1")
    static final class f extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f15602a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f15603b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f15604c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f15605d;

        f(String r3, String r4, String r5, d.c.d<? super f> r6) {
            d.c.d r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r6, d.c.d.class, "com.obric.aiagent.plugin");
            this.f15603b = r3;
            this.f15604c = r4;
            this.f15605d = r5;
            super(2, r7);
        }

        public final Object a(am r3, d.c.d<? super x> r4) {
            return ((f) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), f.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r4, d.c.d<?> r5) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new f(this.f15603b, this.f15604c, this.f15605d, r6), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r6) {
            d.c.a.b.a();
            if (this.f15602a != 0) goto L21;
            d.o.a(r6);
            if (k.f15686a.a(this.f15603b) == false) goto L7;
            k r7 = k.f15686a;
            String r0 = this.f15603b;
            d.m[] r1 = new d.m[2];
            String r3 = this.f15604c;
            if (d.h.b.o.a(r3, "-118") == false) goto L12;
            String r4 = "100201";
        L15:
            r1[0] = d.s.a("error_code", r4);
            r1[1] = d.s.a("finish_reason", this.f15605d);
            r7.a(r0, ao.a(r1));
            ISysLogDepend.Companion.i(OmniReportServiceImpl.TAG, "O_TASK_RECEIVE_FAILED, TASK_TYPE=" + com.obric.aiagent.ttnet.c.f22212d.a());
            ITTNet r5 = (ITTNet) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(ITTNet.class), ITTNet.class, "com.obric.aiagent.plugin");
            if (r5 == null) goto L19;
            r5.onNetworkError(com.obric.aiagent.ttnet.c.f22212d);
        L19:
            return x.f38692a;
        L12:
            if (d.h.b.o.a(r3, "-106") == false) goto L14;
            r4 = "100202";
            goto L15
        L14:
            r4 = "100200";
            goto L15
        L7:
            return x.f38692a;
        L21:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    static {
        Companion = new a(null);
    }

    public static /* synthetic */ ConcurrentLinkedQueue lambda$RoS2JP2LzHpzz1bD14APXvC4FAU(String r0, JSONObject r1, String r2, ConcurrentLinkedQueue r3) {
        return doReport$lambda$5(r0, r1, r2, r3);
    }

    public static /* synthetic */ ConcurrentLinkedQueue lambda$TGthvoaaVZ3hMyhMD14Wy5NuC5o(d.h.a.m r0, Object r1, Object r2) {
        return doReport$lambda$6(r0, r1, r2);
    }

    /* JADX INFO: renamed from: lambda$iv5giWE_LTSNY-gt5ljhaFoLMHM, reason: not valid java name */
    public static /* synthetic */ ConcurrentLinkedQueue m106lambda$iv5giWE_LTSNYgt5ljhaFoLMHM(d.h.a.m r0, Object r1, Object r2) {
        return doReport$lambda$10(r0, r1, r2);
    }

    public static /* synthetic */ ConcurrentLinkedQueue lambda$modcNubziya9FSfyfiT_JXCHuKM(JSONObject r0, String r1, String r2, String r3, ConcurrentLinkedQueue r4) {
        return doReport$lambda$9(r0, r1, r2, r3, r4);
    }

    public OmniReportServiceImpl() {
        this.pendingReportMap = new ConcurrentHashMap();
        this.scope = an.a(cx.a(null, 1, null).plus((d.c.g) ZeusTransformUtils.preCheckCast(bd.c(), d.c.g.class, "com.obric.aiagent.plugin")));
    }

    public static final /* synthetic */ void access$doReportWithCommonParams(OmniReportServiceImpl r2, String r3, com.obric.agent.trace.omni.a r4, Map r5, boolean r6) {
        r2.doReportWithCommonParams(r3, r4, (Map) ZeusTransformUtils.wrapperContextForParams(r5, Map.class, "com.obric.aiagent.plugin"), r6);
    }

    public static final /* synthetic */ JSONObject access$getCommonParams(OmniReportServiceImpl r0, com.obric.agent.trace.omni.a r1) {
        return r0.getCommonParams(r1);
    }

    @Override // com.obric.agent.trace.IOmniReportService
    public void init() {
        IDialogStateManager r0 = (IDialogStateManager) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IDialogStateManager.class), IDialogStateManager.class, "com.obric.aiagent.plugin");
        if (r0 == null) goto L5;
        r0.registerDMStateListener((com.obric.assistant.dm.api.statemachine.core.b) ZeusTransformUtils.preCheckCast(new com.obric.agent.trace.omni.b(this.scope, (d.h.a.r) ZeusTransformUtils.preCheckCast(new b(this), d.h.a.r.class, "com.obric.aiagent.plugin")), com.obric.assistant.dm.api.statemachine.core.b.class, "com.obric.aiagent.plugin"));
    L5:
        com.obric.agent.k.f15191a.a((com.obric.agent.im.d) ZeusTransformUtils.preCheckCast(new i(this.scope, (d.h.a.r) ZeusTransformUtils.preCheckCast(new c(this), d.h.a.r.class, "com.obric.aiagent.plugin")), com.obric.agent.im.d.class, "com.obric.aiagent.plugin"));
    }

    @Override // com.obric.agent.trace.IOmniReportService
    public void recordDispatchIntentStart(String r15, String r16, AppAction r17) {
        d.h.b.o.e(r15, "messageId");
        d.h.b.o.e(r16, "actionName");
        d.h.b.o.e(r17, "action");
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r15, CharSequence.class, "com.obric.aiagent.plugin")).length() != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L9;
        ISecureLogDepend.Companion.w(TAG, "recordDispatchIntentStart ignored: questionId is blank");
        return;
    L9:
        com.obric.agent.utils.i.f16033a.a();
        long r3 = System.currentTimeMillis();
        String r6 = r17.getParams();
        kotlinx.coroutines.i.a(this.scope, null, null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new e(r15, r3, r6, r16, null), d.h.a.m.class, "com.obric.aiagent.plugin"), 3, null);
        return;
    L5:
        r0 = false;
        goto L6
    }

    @Override // com.obric.agent.trace.IOmniReportService
    public void recordDispatchIntentEnd(String r18, String r19, IntentAppAction r20, String r21) {
        d.h.b.o.e(r18, "messageId");
        d.h.b.o.e(r19, "actionName");
        d.h.b.o.e(r21, "errCode");
        if (r20 != null) goto L6;
        ISecureLogDepend.Companion.w(TAG, "recordDispatchIntentEnd ignored: action is null");
        return;
    L6:
        long r5 = System.currentTimeMillis();
        ConcurrentHashMap<String, String> r0 = r20.getExt();
        if (r0 == null) goto L9;
        Map r1 = ao.d((Map) ZeusTransformUtils.preCheckCast(r0, Map.class, "com.obric.aiagent.plugin"));
    L10:
        kotlinx.coroutines.i.a(this.scope, null, null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new d(r18, r1, r19, r5, r21, this, null), d.h.a.m.class, "com.obric.aiagent.plugin"), 3, null);
        return;
    L9:
        r1 = null;
        goto L10
    }

    public final String buildFeatureJson() {
        JSONObject r2 = new JSONObject();
        if (com.obric.autogui.common.a.d.f28974a.s() == false) goto L5;
        r2.put("heif", 1);
    L5:
        String r3 = r2.toString();
        d.h.b.o.c(r3, "toString(...)");
        return r3;
    }

    @Override // com.obric.agent.trace.IOmniReportService
    public void recordNetworkError(String r8, String r9, String r10) {
        d.h.b.o.e(r8, "messageId");
        d.h.b.o.e(r9, "errCode");
        d.h.b.o.e(r10, "errMsg");
        kotlinx.coroutines.i.a(this.scope, null, null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new f(r8, r9, r10, null), d.h.a.m.class, "com.obric.aiagent.plugin"), 3, null);
    }

    private final JSONObject getCommonParams(com.obric.agent.trace.omni.a r7) {
        JSONObject r6 = new JSONObject();
        IAppLog r0 = (IAppLog) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IAppLog.class), IAppLog.class, "com.obric.aiagent.plugin");
        Object r1 = null;
        if (r0 == null) goto L5;
        String r2 = r0.getFlowDid();
    L6:
        r6.put("device_id", r2);
        r6.put("doubao_message_id", r7.a());
        List r3 = (List) ZeusTransformUtils.preCheckCast(r7.b().get("instruction_id"), List.class, "com.obric.aiagent.plugin");
        if (r3 == null) goto L14;
        Object r4 = d.a.p.n(r3);
        if (r4 == null) goto L14;
        if (ZeusTransformUtils.instanceOf(r4, String.class) == false) goto L14;
    L15:
        String r5 = (String) ZeusTransformUtils.preCheckCast(r4, String.class, "com.obric.aiagent.plugin");
        String r8 = "";
        if (r5 != null) goto L18;
        r5 = "";
    L18:
        r6.put("instruction_id", r5);
        List r9 = (List) ZeusTransformUtils.preCheckCast(r7.b().get("instruction_type"), List.class, "com.obric.aiagent.plugin");
        if (r9 == null) goto L26;
        Object r10 = d.a.p.n(r9);
        if (r10 == null) goto L26;
        if (ZeusTransformUtils.instanceOf(r10, String.class) == false) goto L26;
    L27:
        String r11 = (String) ZeusTransformUtils.preCheckCast(r10, String.class, "com.obric.aiagent.plugin");
        if (r11 != null) goto L30;
        r11 = "";
    L30:
        r6.put("instruction_type", r11);
        List r12 = (List) ZeusTransformUtils.preCheckCast(r7.b().get("instruction_entry"), List.class, "com.obric.aiagent.plugin");
        if (r12 == null) goto L38;
        Object r13 = d.a.p.n(r12);
        if (r13 == null) goto L38;
        if (ZeusTransformUtils.instanceOf(r13, String.class) == false) goto L38;
        r1 = r13;
    L38:
        String r14 = (String) ZeusTransformUtils.preCheckCast(r1, String.class, "com.obric.aiagent.plugin");
        if (r14 == null) goto L42;
        r8 = r14;
    L42:
        r6.put("instruction_entry", r8);
        return r6;
    L26:
        r10 = null;
    L14:
        r4 = null;
        goto L15
    L5:
        r2 = null;
        goto L6
    }

    private final void doReportWithCommonParams(String r5, com.obric.agent.trace.omni.a r6, Map<String, String> r7, boolean r8) {
        Map r9 = (Map) ZeusTransformUtils.wrapperContextForParams(r7, Map.class, "com.obric.aiagent.plugin");
        JSONObject r10 = getCommonParams(r6);
        Iterator r11 = r9.entrySet().iterator();
    L4:
        if (r11.hasNext() == false) goto L6;
        Map.Entry r0 = (Map.Entry) ZeusTransformUtils.preCheckCast(r11.next(), Map.Entry.class, "com.obric.aiagent.plugin");
        r10.put((String) ZeusTransformUtils.preCheckCast(r0.getKey(), String.class, "com.obric.aiagent.plugin"), r0.getValue());
        goto L4
    L6:
        doReport(r5, r10, r8);
    }

    static /* synthetic */ void doReport$default(OmniReportServiceImpl r0, String r1, JSONObject r2, boolean r3, int r4, Object r5) {
        if ((r4 & 4) == 0) goto L5;
        r3 = false;
    L5:
        r0.doReport(r1, r2, r3);
    }

    private final void doReport(final String r4, final JSONObject r5, boolean r6) {
        ILogDepend.Companion.i(TAG, "doReport: " + r4 + ' ' + r5 + ", force: " + r6);
        final String r0 = r5.optString("doubao_message_id");
        d.h.b.o.a(r0);
        if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r0, CharSequence.class, "com.obric.aiagent.plugin"))) == true) goto L6;
        r0 = null;
    L6:
        if (r0 != null) goto L8;
        return;
    L8:
        if (r6 == false) goto L10;
    L13:
        ConcurrentHashMap<String, ConcurrentLinkedQueue<d.m<String, JSONObject>>> r3 = this.pendingReportMap;
        final d.h.a.m r7 = new $$Lambda$OmniReportServiceImpl$modcNubziya9FSfyfiT_JXCHuKM(r5, r4, r0);
        r3.compute(r0, new $$Lambda$OmniReportServiceImpl$iv5giWE_LTSNYgt5ljhaFoLMHM(r7));
        return;
    L10:
        if (isValidParams(r5) == true) goto L13;
        ConcurrentHashMap<String, ConcurrentLinkedQueue<d.m<String, JSONObject>>> r8 = this.pendingReportMap;
        final d.h.a.m r9 = new $$Lambda$OmniReportServiceImpl$RoS2JP2LzHpzz1bD14APXvC4FAU(r4, r5);
        r8.compute(r0, new $$Lambda$OmniReportServiceImpl$TGthvoaaVZ3hMyhMD14Wy5NuC5o(r9));
    }

    private static final ConcurrentLinkedQueue doReport$lambda$6(d.h.a.m r2, Object r3, Object r4) {
        return (ConcurrentLinkedQueue) ZeusTransformUtils.preCheckCast(((d.h.a.m) ZeusTransformUtils.wrapperContextForParams(r2, d.h.a.m.class, "com.obric.aiagent.plugin")).invoke(r3, r4), ConcurrentLinkedQueue.class, "com.obric.aiagent.plugin");
    }

    private static final ConcurrentLinkedQueue doReport$lambda$5(String r1, JSONObject r2, String r3, ConcurrentLinkedQueue r4) {
        d.h.b.o.e(r3, "<unused var>");
        if (r4 != null) goto L5;
        r4 = new ConcurrentLinkedQueue();
    L5:
        r4.add(d.s.a(r1, r2));
        return r4;
    }

    private static final ConcurrentLinkedQueue doReport$lambda$10(d.h.a.m r2, Object r3, Object r4) {
        return (ConcurrentLinkedQueue) ZeusTransformUtils.preCheckCast(((d.h.a.m) ZeusTransformUtils.wrapperContextForParams(r2, d.h.a.m.class, "com.obric.aiagent.plugin")).invoke(r3, r4), ConcurrentLinkedQueue.class, "com.obric.aiagent.plugin");
    }

    private static final ConcurrentLinkedQueue doReport$lambda$9(JSONObject r8, String r9, String r10, String r11, ConcurrentLinkedQueue r12) {
        d.h.b.o.e(r11, "<unused var>");
        CharSequence r0 = (CharSequence) ZeusTransformUtils.preCheckCast(r8.optString("instruction_id"), CharSequence.class, "com.obric.aiagent.plugin");
        if (r0 != null) goto L5;
    L8:
        boolean r1 = true;
    L10:
        if (r1 == false) goto L13;
        ILogDepend.Companion.e(TAG, "doReport: " + r9 + ' ' + r8 + ", messageId: " + r10 + ", instruction_id is null");
        return null;
    L13:
        if (r12 == null) goto L24;
        Iterator r13 = ((Iterable) ZeusTransformUtils.preCheckCast(r12, Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L16:
        if (r13.hasNext() == false) goto L24;
        d.m r2 = (d.m) ZeusTransformUtils.preCheckCast(r13.next(), d.m.class, "com.obric.aiagent.plugin");
        IAppLog r3 = (IAppLog) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IAppLog.class), IAppLog.class, "com.obric.aiagent.plugin");
        if (r3 == null) goto L16;
        String r4 = (String) ZeusTransformUtils.preCheckCast(r2.a(), String.class, "com.obric.aiagent.plugin");
        Object r5 = r2.b();
        JSONObject r6 = (JSONObject) ZeusTransformUtils.preCheckCast(r5, JSONObject.class, "com.obric.aiagent.plugin");
        IAppLog r7 = (IAppLog) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IAppLog.class), IAppLog.class, "com.obric.aiagent.plugin");
        if (r7 == null) goto L22;
        String r14 = r7.getFlowDid();
    L23:
        r6.put("device_id", r14);
        r6.put("doubao_message_id", r10);
        r6.put("instruction_id", r8.optString("instruction_id"));
        r6.put("instruction_type", r8.optString("instruction_type"));
        r6.put("instruction_entry", r8.optString("instruction_entry"));
        x r15 = x.f38692a;
        r3.reportToFlow(r4, (JSONObject) ZeusTransformUtils.preCheckCast(r5, JSONObject.class, "com.obric.aiagent.plugin"));
        goto L16
    L22:
        r14 = null;
    L24:
        IAppLog r16 = (IAppLog) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IAppLog.class), IAppLog.class, "com.obric.aiagent.plugin");
        if (r16 == null) goto L27;
        r16.reportToFlow(r9, r8);
    L27:
        AOBizTracking.INSTANCE.reportEvent(r9, r8, false, false, TrackingReportTarget.TEA_AGENT_ONLY);
        return null;
    L5:
        if (r0.length() == 0) goto L8;
        r1 = false;
        goto L10
    }

    private final boolean isValidParams(JSONObject r1) {
        if (com.obric.aiagent.executionengine.utils.c.a(r1.optString("instruction_id")) == true) goto L5;
    L9:
        return false;
    L5:
        if (com.obric.aiagent.executionengine.utils.c.a(r1.optString("instruction_type")) == false) goto L9;
        if (com.obric.aiagent.executionengine.utils.c.a(r1.optString("instruction_entry")) == false) goto L9;
        return true;
    }
}
