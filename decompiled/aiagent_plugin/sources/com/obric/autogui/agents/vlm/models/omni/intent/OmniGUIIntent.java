package com.obric.autogui.agents.vlm.models.omni.intent;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Parcelable;
import com.bytedance.common.wschannel.WsChannelMultiProcessSharedProvider;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.obric.aiagent.plugin.R;
import com.obric.autogui.agents.vlm.models.omni.c.k;
import com.obric.autogui.agents.vlm.models.omni.r;
import com.obric.autogui.agents.vlm.models.omni.t;
import com.obric.autogui.agents.vlm.models.omni.upload.v;
import com.obric.autogui.common.api.AOBizTracking;
import com.obric.autogui.common.api.agent.AutoActionAgent;
import com.obric.autogui.common.api.agent.BizStatus;
import com.obric.autogui.common.api.agent.IAutoActionAgentApi;
import com.obric.autogui.common.api.agent.IAutoActionAgentEventListener;
import com.obric.autogui.common.api.agent.model.EndStepParams;
import com.obric.autogui.common.api.app.AOHostAppTools;
import com.obric.autogui.common.api.app.HostAppInfo;
import com.obric.autogui.common.api.logging.Loog;
import com.obric.autogui.common.api.platform.tracking.IAutoActionTrackingApi;
import com.obric.autogui.common.api.threading.AOThreadingTools;
import com.obric.capabilitykit.common.DispatchContext;
import com.obric.capabilitykit.common.intent.BaseGUIActionIntent;
import com.obric.capabilitykit.common.intent.GUIActionParams;
import com.obric.capabilitykit.common.intent.IntentResult;
import com.ss.android.socialbase.downloader.constants.DownloadConstants;
import com.ss.android.socialbase.downloader.constants.DownloadErrorCode;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.al;
import d.a.p;
import d.c.b.a.l;
import d.h.a.m;
import d.l.n;
import d.o;
import d.x;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ConcurrentHashMap;
import kotlinx.coroutines.am;
import kotlinx.coroutines.an;
import kotlinx.coroutines.ax;
import kotlinx.coroutines.bd;
import kotlinx.coroutines.ca;
import kotlinx.coroutines.ce;
import org.json.JSONObject;

/* JADX INFO: compiled from: OmniGUIIntent.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class OmniGUIIntent extends BaseGUIActionIntent {
    private static final String ACTION_INTENT_HANG_UP = "intent_hang_up";
    private static final String ACTION_INTENT_REPLY = "intent_reply";
    private static final String ACTION_STOP = "stop";
    public static final a Companion = null;
    private static final String KEY_INSTRUCTION_ID = "instruction_id";
    private static final String KEY_OMNI_TASK_ID = "o_omni_task_id";
    private static final long STALE_SESSION_FORCE_RELEASE_DELAY_MS = 1000;
    private static final String TAG = "OmniGUIIntent";

    /* JADX INFO: compiled from: OmniGUIIntent.kt */
    public static final class a {
        public /* synthetic */ a(d.h.b.h r1) {
            this();
        }

        private a() {
        }
    }

    /* JADX INFO: compiled from: OmniGUIIntent.kt */
    @d.c.b.a.f(b = "OmniGUIIntent.kt", c = {279, 281}, d = "clearTerminatedSessionAndStartNew", e = "com.obric.autogui.agents.vlm.models.omni.intent.OmniGUIIntent")
    static final class b extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f28370a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f28371b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        /* synthetic */ Object f28372c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ OmniGUIIntent f28373d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        int f28374e;

        b(OmniGUIIntent r3, d.c.d<? super b> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f28373d = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f28372c = r3;
            this.f28374e |= Integer.MIN_VALUE;
            return OmniGUIIntent.access$clearTerminatedSessionAndStartNew(this.f28373d, null, null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: OmniGUIIntent.kt */
    @d.c.b.a.f(b = "OmniGUIIntent.kt", c = {436}, d = "dispatchToSession", e = "com.obric.autogui.agents.vlm.models.omni.intent.OmniGUIIntent")
    static final class c extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f28375a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f28376b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Object f28377c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        /* synthetic */ Object f28378d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ OmniGUIIntent f28379e;
        int f;

        c(OmniGUIIntent r3, d.c.d<? super c> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f28379e = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r8) {
            this.f28378d = r8;
            this.f |= Integer.MIN_VALUE;
            return OmniGUIIntent.access$dispatchToSession(this.f28379e, null, null, null, null, null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: OmniGUIIntent.kt */
    @d.c.b.a.f(b = "OmniGUIIntent.kt", c = {}, d = "invokeSuspend", e = "com.obric.autogui.agents.vlm.models.omni.intent.OmniGUIIntent$dispatchToSessionInScope$2")
    static final class d extends l implements m<am, d.c.d<? super IntentResult<Bitmap>>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f28380a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ r f28381b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ DispatchContext f28382c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ com.obric.autogui.agents.vlm.models.omni.intent.g f28383d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ OmniGUIIntent f28384e;
        final /* synthetic */ com.obric.autogui.agents.vlm.models.omni.b.b f;
        final /* synthetic */ com.obric.autogui.session.a g;

        d(r r3, DispatchContext r4, com.obric.autogui.agents.vlm.models.omni.intent.g r5, OmniGUIIntent r6, com.obric.autogui.agents.vlm.models.omni.b.b r7, com.obric.autogui.session.a r8, d.c.d<? super d> r9) {
            d.c.d r10 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r9, d.c.d.class, "com.obric.aiagent.plugin");
            this.f28381b = r3;
            this.f28382c = r4;
            this.f28383d = r5;
            this.f28384e = r6;
            this.f = r7;
            this.g = r8;
            super(2, r10);
        }

        public final Object a(am r3, d.c.d<? super IntentResult<Bitmap>> r4) {
            return ((d) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), d.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r10, d.c.d<?> r11) {
            d.c.d r8 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r11, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new d(this.f28381b, this.f28382c, this.f28383d, this.f28384e, this.f, this.g, r8), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super IntentResult<Bitmap>> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r23) {
            d.c.a.b.a();
            if (this.f28380a != 0) goto L97;
            o.a(r23);
            if (this.f28381b.a(this.f28382c.getQuestionId()) == true) goto L8;
            Loog.INSTANCE.i(OmniGUIIntent.TAG, "Refusing dispatch on closed session: " + this.f28383d.b());
            return OmniGUIIntent.access$error(this.f28384e, com.obric.autogui.agents.vlm.models.omni.intent.c.f28410e);
        L8:
            com.obric.autogui.agents.vlm.models.omni.l r1 = new com.obric.autogui.agents.vlm.models.omni.l(this.f28383d, this.f28382c, false, this.f, 4, null);
            Loog r3 = Loog.INSTANCE;
            StringBuilder r4 = new StringBuilder().append("Dispatch begin: session=").append(this.f28383d.b()).append(", currentSession=");
            com.obric.autogui.session.a r5 = this.g;
            String r6 = null;
            if (r5 == null) goto L11;
            String r7 = r5.a();
        L12:
            StringBuilder r8 = r4.append(r7).append(", toolId=").append(this.f28383d.g()).append(", action=");
            j r9 = this.f28383d.c();
            if (r9 == null) goto L15;
            String r10 = r9.a();
        L16:
            StringBuilder r11 = r8.append(r10).append(", questionId=").append(this.f28382c.getQuestionId()).append(", hasLastOmniAction=");
            int r12 = 0;
            if (this.f28381b.e() == null) goto L19;
            boolean r13 = true;
        L20:
            StringBuilder r14 = r11.append(r13).append(", lastToolId=");
            com.obric.autogui.agents.vlm.models.omni.l r15 = this.f28381b.e();
            if (r15 == null) goto L25;
            com.obric.autogui.agents.vlm.models.omni.intent.g r16 = r15.a();
            if (r16 == null) goto L25;
            String r17 = r16.g();
        L26:
            r3.i(OmniGUIIntent.TAG, r14.append(r17).toString());
            if (this.f28383d.c() != null) goto L29;
        L34:
            com.obric.autogui.session.a r18 = this.g;
            if (r18 == null) goto L54;
            if (r18.M() == false) goto L54;
            this.f28381b.k();
            this.f28381b.a(r1);
            this.f28381b.b(r1);
            IntentResult r19 = OmniGUIIntent.access$handleActionDispatchOnSessionPaused(this.f28384e, this.g);
            String r20 = com.obric.autogui.agents.vlm.models.omni.intent.c.f28406a.a(r19.getRet(), r19.getDetails());
            Iterable r21 = (Iterable) ZeusTransformUtils.preCheckCast(n.b(0, r1.e()), Iterable.class, "com.obric.aiagent.plugin");
            if (ZeusTransformUtils.instanceOf(r21, Collection.class) == true) goto L41;
        L43:
            Iterator r22 = r21.iterator();
        L45:
            if (r22.hasNext() == false) goto L51;
            if (r1.h().a(((al) ZeusTransformUtils.preCheckCast(r22, al.class, "com.obric.aiagent.plugin")).a(), r19.getRet(), r20) == false) goto L45;
            r12 = r12 + 1;
            if (r12 >= 0) goto L45;
            p.d();
        L51:
            Loog.INSTANCE.i(OmniGUIIntent.TAG, "[OAutoActionEffect] action result captured source=paused_dispatch, tool_id=" + this.f28383d.g() + ", action=" + r1.f() + ", action_result_code=" + r19.getRet() + ", action_result_reason=" + r20 + ", action_count=" + r1.e() + ", recorded_count=" + r12 + ", detector_skipped=true");
            return r19;
        L41:
            if (((Collection) ZeusTransformUtils.preCheckCast(r21, Collection.class, "com.obric.aiagent.plugin")).isEmpty() == false) goto L43;
        L54:
            if (this.f28381b.e() == null) goto L80;
            com.obric.autogui.agents.vlm.models.omni.l r24 = this.f28381b.e();
            Loog r25 = Loog.INSTANCE;
            StringBuilder r26 = new StringBuilder().append("Dispatch failed: Pipeline clogged. lastOmniAction exists. session=").append(this.f28383d.b()).append(", oldToolId=");
            if (r24 == null) goto L60;
            com.obric.autogui.agents.vlm.models.omni.intent.g r27 = r24.a();
            if (r27 == null) goto L60;
            String r28 = r27.g();
        L61:
            StringBuilder r29 = r26.append(r28).append(", oldAction=");
            if (r24 == null) goto L68;
            com.obric.autogui.agents.vlm.models.omni.intent.g r30 = r24.a();
            if (r30 == null) goto L68;
            j r31 = r30.c();
            if (r31 == null) goto L68;
            String r32 = r31.a();
        L69:
            StringBuilder r33 = r29.append(r32).append(", oldQuestionId=");
            if (r24 == null) goto L74;
            DispatchContext r34 = r24.b();
            if (r34 == null) goto L74;
            Long r35 = r34.getQuestionId();
        L75:
            StringBuilder r36 = r33.append(r35).append(", newToolId=").append(this.f28383d.g()).append(", newAction=");
            j r37 = this.f28383d.c();
            if (r37 == null) goto L78;
            r6 = r37.a();
        L78:
            r25.e(OmniGUIIntent.TAG, r36.append(r6).append(", newQuestionId=").append(this.f28382c.getQuestionId()).toString());
            this.f28381b.k();
            this.f28381b.a(r1);
            this.f28381b.b(r1);
            return OmniGUIIntent.access$error(this.f28384e, com.obric.autogui.agents.vlm.models.omni.intent.c.j);
        L74:
            r35 = null;
        L68:
            r32 = null;
        L60:
            r28 = null;
            goto L61
        L80:
            this.f28381b.a(r1);
            this.f28381b.b(r1);
            if (this.f28381b.d(r1) == true) goto L84;
            Loog.INSTANCE.e(OmniGUIIntent.TAG, "Dispatch failed: Queue full.");
            this.f28381b.a(null);
            return OmniGUIIntent.access$error(this.f28384e, com.obric.autogui.agents.vlm.models.omni.intent.c.i);
        L84:
            Loog r38 = Loog.INSTANCE;
            StringBuilder r39 = new StringBuilder().append("Dispatch success: ");
            j r40 = r1.a().c();
            if (r40 == null) goto L88;
            String r41 = r40.a();
            if (r41 == null) goto L88;
        L89:
            r38.i(OmniGUIIntent.TAG, r39.append(r41).append(' ').append(r1.b().getQuestionId()).toString());
            IntentResult r2 = new IntentResult(com.obric.autogui.agents.vlm.models.omni.intent.c.f28407b.a(), null, null, com.obric.autogui.agents.vlm.models.omni.intent.c.f28407b.b(), false, false, 0, null, null, null, DownloadErrorCode.ERROR_REMOVE_DOWNLOAD_RUNNABLE, null);
            com.obric.autogui.agents.vlm.models.omni.intent.g r0 = this.f28383d;
            r2.setFinal(false);
            ConcurrentHashMap<String, String> r42 = new ConcurrentHashMap();
            j r43 = r0.c();
            if (r43 == null) goto L93;
            String r44 = r43.a();
            if (r44 == null) goto L93;
        L94:
            r42.put("action_type", r44);
            r2.setExt(r42);
            return r2;
        L93:
            r44 = "";
        L88:
            r41 = "multi-steps";
            goto L89
        L29:
            if (d.h.b.o.a(this.f28383d.c().a(), OmniGUIIntent.ACTION_STOP) == false) goto L34;
            if (this.g == null) goto L34;
            v.f28855a.b(this.f28383d.b());
            this.f28381b.k();
            OmniGUIIntent.access$ensureSessionClosed(this.f28384e, this.f28383d.c(), this.g, this.f28381b);
            this.f28381b.a(r1);
            this.f28381b.b(r1);
            this.f28381b.d(r1);
            IntentResult r45 = new IntentResult(com.obric.autogui.agents.vlm.models.omni.intent.c.f28407b.a(), null, null, com.obric.autogui.agents.vlm.models.omni.intent.c.f28407b.b(), false, false, 0, null, null, null, DownloadErrorCode.ERROR_REMOVE_DOWNLOAD_RUNNABLE, null);
            r45.setFinal(false);
            return r45;
        L25:
            r17 = null;
            goto L26
        L19:
            r13 = false;
            goto L20
        L15:
            r10 = null;
            goto L16
        L11:
            r7 = null;
            goto L12
        L97:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: compiled from: OmniGUIIntent.kt */
    @d.c.b.a.f(b = "OmniGUIIntent.kt", c = {92, 102, 112}, d = "doAction", e = "com.obric.autogui.agents.vlm.models.omni.intent.OmniGUIIntent")
    static final class e extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f28385a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f28386b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Object f28387c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        Object f28388d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        Object f28389e;
        Object f;
        /* synthetic */ Object g;
        final /* synthetic */ OmniGUIIntent h;
        int i;

        e(OmniGUIIntent r3, d.c.d<? super e> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.h = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.g = r3;
            this.i |= Integer.MIN_VALUE;
            return this.h.doAction(null, null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: OmniGUIIntent.kt */
    @d.c.b.a.f(b = "OmniGUIIntent.kt", c = {202}, d = "invokeSuspend", e = "com.obric.autogui.agents.vlm.models.omni.intent.OmniGUIIntent$ensureSessionClosed$1")
    static final class f extends l implements m<am, d.c.d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f28390a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ com.obric.autogui.session.a f28391b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ Object f28392c;

        f(com.obric.autogui.session.a r3, Object r4, d.c.d<? super f> r5) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            this.f28391b = r3;
            this.f28392c = r4;
            super(2, r6);
        }

        public final Object a(am r3, d.c.d<? super x> r4) {
            return ((f) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), f.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r3, d.c.d<?> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new f(this.f28391b, this.f28392c, r5), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r13) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f28390a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            o.a(r13);
        L11:
            com.obric.autogui.session.a r14 = com.obric.autogui.session.c.f30777a.b();
            if (r14 == null) goto L29;
            if (d.h.b.o.a(r14.a(), this.f28391b.a()) == false) goto L29;
            Loog.INSTANCE.e(OmniGUIIntent.TAG, "session still exist, force stop it: " + this.f28391b.a());
            IAutoActionAgentApi r4 = (IAutoActionAgentApi) ZeusTransformUtils.preCheckCast(AutoActionAgent.INSTANCE, IAutoActionAgentApi.class, "com.obric.aiagent.plugin");
            String r5 = this.f28391b.a();
            Object r15 = this.f28392c;
            Object r2 = null;
            if (d.n.b(r15) == false) goto L18;
            r15 = null;
        L18:
            EndStepParams r16 = (EndStepParams) ZeusTransformUtils.preCheckCast(r15, EndStepParams.class, "com.obric.aiagent.plugin");
            if (r16 == null) goto L22;
            String r17 = r16.getAction();
            if (r17 == null) goto L22;
        L23:
            String r6 = r17;
            Object r12 = this.f28392c;
            if (d.n.b(r12) == true) goto L27;
            r2 = r12;
        L27:
            IAutoActionAgentApi.DefaultImpls.systemTerminateQuery$default(r4, r5, r6, 0, (EndStepParams) ZeusTransformUtils.preCheckCast(r2, EndStepParams.class, "com.obric.aiagent.plugin"), null, 16, null);
        L22:
            r17 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AOHostAppTools.INSTANCE.getAppContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getString(ZeusTransformUtils.mapRes(R.string.obric_agent_task_finished, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_agent_task_finished"));
            d.h.b.o.c(r17, "getString(...)");
        L29:
            return x.f38692a;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            o.a(r13);
            d.c.d r18 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f28390a = 1;
            if (ax.a(2000, r18) != r0) goto L11;
            return r0;
        }
    }

    /* JADX INFO: compiled from: OmniGUIIntent.kt */
    @d.c.b.a.f(b = "OmniGUIIntent.kt", c = {143}, d = "handleSystemInterception", e = "com.obric.autogui.agents.vlm.models.omni.intent.OmniGUIIntent")
    static final class g extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        /* synthetic */ Object f28393a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ OmniGUIIntent f28394b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        int f28395c;

        g(OmniGUIIntent r3, d.c.d<? super g> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f28394b = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f28393a = r3;
            this.f28395c |= Integer.MIN_VALUE;
            return OmniGUIIntent.access$handleSystemInterception(this.f28394b, null, null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: OmniGUIIntent.kt */
    @d.c.b.a.f(b = "OmniGUIIntent.kt", c = {298, 303, 315, 317}, d = "terminateRunningSessionAndStartNew", e = "com.obric.autogui.agents.vlm.models.omni.intent.OmniGUIIntent")
    static final class h extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f28396a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f28397b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Object f28398c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        /* synthetic */ Object f28399d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ OmniGUIIntent f28400e;
        int f;

        h(OmniGUIIntent r3, d.c.d<? super h> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f28400e = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f28399d = r3;
            this.f |= Integer.MIN_VALUE;
            return OmniGUIIntent.access$terminateRunningSessionAndStartNew(this.f28400e, null, null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: OmniGUIIntent.kt */
    @d.c.b.a.f(b = "OmniGUIIntent.kt", c = {402}, d = "validateNewSession", e = "com.obric.autogui.agents.vlm.models.omni.intent.OmniGUIIntent")
    static final class i extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f28401a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f28402b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Object f28403c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        /* synthetic */ Object f28404d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ OmniGUIIntent f28405e;
        int f;

        i(OmniGUIIntent r3, d.c.d<? super i> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f28405e = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f28404d = r3;
            this.f |= Integer.MIN_VALUE;
            return OmniGUIIntent.access$validateNewSession(this.f28405e, null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    static {
        Companion = new a(null);
    }

    /* JADX INFO: renamed from: lambda$oGYEap7I03ooK5dwab99krtZ-kE, reason: not valid java name */
    public static /* synthetic */ x m779lambda$oGYEap7I03ooK5dwab99krtZkE(JSONObject r0) {
        return reportSessionMismatch$lambda$11(r0);
    }

    @Override // com.obric.capabilitykit.common.intent.BaseGUIActionIntent, com.obric.capabilitykit.common.intent.IntentFunction
    public boolean isBlock() {
        return true;
    }

    public OmniGUIIntent() {
    }

    public static final /* synthetic */ Object access$clearTerminatedSessionAndStartNew(OmniGUIIntent r2, com.obric.autogui.session.a r3, com.obric.autogui.agents.vlm.models.omni.intent.g r4, d.c.d r5) {
        return r2.clearTerminatedSessionAndStartNew(r3, r4, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    public static final /* synthetic */ Object access$dispatchToSession(OmniGUIIntent r7, com.obric.autogui.agents.vlm.models.omni.intent.g r8, com.obric.autogui.session.a r9, r r10, DispatchContext r11, com.obric.autogui.agents.vlm.models.omni.b.b r12, d.c.d r13) {
        return r7.dispatchToSession(r8, r9, r10, r11, r12, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r13, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    public static final /* synthetic */ Object access$dispatchToSessionInScope(OmniGUIIntent r7, com.obric.autogui.agents.vlm.models.omni.intent.g r8, com.obric.autogui.session.a r9, r r10, DispatchContext r11, com.obric.autogui.agents.vlm.models.omni.b.b r12, d.c.d r13) {
        return r7.dispatchToSessionInScope(r8, r9, r10, r11, r12, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r13, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    public static final /* synthetic */ Object access$ensureSessionActive(OmniGUIIntent r2, com.obric.autogui.session.a r3, com.obric.autogui.agents.vlm.models.omni.intent.g r4, d.c.d r5) {
        return r2.ensureSessionActive(r3, r4, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    public static final /* synthetic */ void access$ensureSessionClosed(OmniGUIIntent r0, j r1, com.obric.autogui.session.a r2, r r3) {
        r0.ensureSessionClosed(r1, r2, r3);
    }

    public static final /* synthetic */ IntentResult access$error(OmniGUIIntent r0, com.obric.autogui.agents.vlm.models.omni.intent.c r1) {
        return r0.error(r1);
    }

    public static final /* synthetic */ IntentResult access$handleActionDispatchOnSessionPaused(OmniGUIIntent r0, com.obric.autogui.session.a r1) {
        return r0.handleActionDispatchOnSessionPaused(r1);
    }

    public static final /* synthetic */ Object access$handleSessionIdMismatch(OmniGUIIntent r2, com.obric.autogui.session.a r3, com.obric.autogui.agents.vlm.models.omni.intent.g r4, d.c.d r5) {
        return r2.handleSessionIdMismatch(r3, r4, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    public static final /* synthetic */ Object access$handleSystemInterception(OmniGUIIntent r2, com.obric.autogui.agents.vlm.models.omni.intent.g r3, com.obric.autogui.session.a r4, d.c.d r5) {
        return r2.handleSystemInterception(r3, r4, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    public static final /* synthetic */ Object access$performSessionCreation(OmniGUIIntent r2, com.obric.autogui.agents.vlm.models.omni.intent.g r3, d.c.d r4) {
        return r2.performSessionCreation(r3, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    public static final /* synthetic */ Object access$terminateRunningSessionAndStartNew(OmniGUIIntent r2, com.obric.autogui.session.a r3, com.obric.autogui.agents.vlm.models.omni.intent.g r4, d.c.d r5) {
        return r2.terminateRunningSessionAndStartNew(r3, r4, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    public static final /* synthetic */ Object access$validateExistingSession(OmniGUIIntent r2, com.obric.autogui.session.a r3, com.obric.autogui.agents.vlm.models.omni.intent.g r4, d.c.d r5) {
        return r2.validateExistingSession(r3, r4, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    public static final /* synthetic */ Object access$validateNewSession(OmniGUIIntent r2, com.obric.autogui.agents.vlm.models.omni.intent.g r3, d.c.d r4) {
        return r2.validateNewSession(r3, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    @Override // com.obric.capabilitykit.common.intent.BaseGUIActionIntent, com.obric.capabilitykit.common.intent.IntentFunction
    public /* synthetic */ Object doAction(Parcelable r3, DispatchContext r4, d.c.d<? super IntentResult<Bitmap>> r5) {
        Parcelable r6 = (Parcelable) ZeusTransformUtils.wrapperContextForParams(r3, Parcelable.class, "com.obric.aiagent.plugin");
        d.c.d<? super IntentResult<Bitmap>> r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
        return doAction((GUIActionParams) ZeusTransformUtils.preCheckCast(r6, GUIActionParams.class, "com.obric.aiagent.plugin"), r4, r7);
    }

    @Override // com.obric.capabilitykit.common.intent.BaseGUIActionIntent
    public Object doAction(GUIActionParams r18, DispatchContext r19, d.c.d<? super IntentResult<Bitmap>> r20) {
        OmniGUIIntent r0 = this;
        d.c.d r3 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r20, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r3, e.class) == false) goto L7;
        e r5 = (e) ZeusTransformUtils.preCheckCast(r3, e.class, "com.obric.aiagent.plugin");
        if ((r5.i & Integer.MIN_VALUE) == 0) goto L7;
        r5.i -= Integer.MIN_VALUE;
    L8:
        e r12 = r5;
        Object r4 = r12.g;
        Object r6 = d.c.a.b.a();
        int r7 = r12.i;
        String r11 = null;
        if (r7 == 0) goto L18;
        if (r7 == 1) goto L17;
        if (r7 == 2) goto L16;
        if (r7 != 3) goto L15;
        com.obric.autogui.agents.vlm.models.omni.c.j r1 = (com.obric.autogui.agents.vlm.models.omni.c.j) ZeusTransformUtils.preCheckCast(r12.f28387c, com.obric.autogui.agents.vlm.models.omni.c.j.class, "com.obric.aiagent.plugin");
        com.obric.autogui.agents.vlm.models.omni.intent.g r2 = (com.obric.autogui.agents.vlm.models.omni.intent.g) ZeusTransformUtils.preCheckCast(r12.f28386b, com.obric.autogui.agents.vlm.models.omni.intent.g.class, "com.obric.aiagent.plugin");
        com.obric.autogui.agents.vlm.models.omni.b.b r8 = (com.obric.autogui.agents.vlm.models.omni.b.b) ZeusTransformUtils.preCheckCast(r12.f28385a, com.obric.autogui.agents.vlm.models.omni.b.b.class, "com.obric.aiagent.plugin");
        o.a(r4);
    L81:
        IntentResult<Bitmap> r9 = (IntentResult) ZeusTransformUtils.preCheckCast(r4, IntentResult.class, "com.obric.aiagent.plugin");
    L83:
        if (r9.isFinal() == false) goto L90;
        if (r1 == null) goto L88;
        k r10 = r1.a();
        if (r10 == null) goto L88;
        r10.a(r2);
    L88:
        if (r8 == null) goto L90;
        r8.b();
    L90:
        return r9;
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        r1 = (com.obric.autogui.agents.vlm.models.omni.c.j) ZeusTransformUtils.preCheckCast(r12.f28389e, com.obric.autogui.agents.vlm.models.omni.c.j.class, "com.obric.aiagent.plugin");
        r2 = (com.obric.autogui.agents.vlm.models.omni.intent.g) ZeusTransformUtils.preCheckCast(r12.f28388d, com.obric.autogui.agents.vlm.models.omni.intent.g.class, "com.obric.aiagent.plugin");
        com.obric.autogui.agents.vlm.models.omni.b.b r13 = (com.obric.autogui.agents.vlm.models.omni.b.b) ZeusTransformUtils.preCheckCast(r12.f28387c, com.obric.autogui.agents.vlm.models.omni.b.b.class, "com.obric.aiagent.plugin");
        DispatchContext r14 = (DispatchContext) ZeusTransformUtils.preCheckCast(r12.f28386b, DispatchContext.class, "com.obric.aiagent.plugin");
        OmniGUIIntent r15 = (OmniGUIIntent) ZeusTransformUtils.preCheckCast(r12.f28385a, OmniGUIIntent.class, "com.obric.aiagent.plugin");
        o.a(r4);
        DispatchContext r16 = r14;
        OmniGUIIntent r17 = r15;
        r8 = r13;
    L67:
        com.obric.autogui.agents.vlm.models.omni.intent.i r21 = (com.obric.autogui.agents.vlm.models.omni.intent.i) ZeusTransformUtils.preCheckCast(r4, com.obric.autogui.agents.vlm.models.omni.intent.i.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r21, com.obric.autogui.agents.vlm.models.omni.intent.i.a.class) == false) goto L71;
        r9 = ((com.obric.autogui.agents.vlm.models.omni.intent.i.a) ZeusTransformUtils.preCheckCast(r21, com.obric.autogui.agents.vlm.models.omni.intent.i.a.class, "com.obric.aiagent.plugin")).a();
        goto L83
    L71:
        if (ZeusTransformUtils.instanceOf(r21, com.obric.autogui.agents.vlm.models.omni.intent.i.b.class) == false) goto L92;
        com.obric.autogui.session.a r22 = com.obric.autogui.session.c.f30777a.b();
        if (r22 != null) goto L75;
    L77:
        r22 = null;
    L78:
        r r23 = ((com.obric.autogui.agents.vlm.models.omni.intent.i.b) ZeusTransformUtils.preCheckCast(r21, com.obric.autogui.agents.vlm.models.omni.intent.i.b.class, "com.obric.aiagent.plugin")).a();
        r12.f28385a = r8;
        r12.f28386b = r2;
        r12.f28387c = r1;
        r12.f28388d = null;
        r12.f28389e = null;
        r12.i = 3;
        r4 = r17.dispatchToSession(r2, r22, r23, r16, r8, r12);
        if (r4 != r6) goto L81;
        return r6;
    L75:
        if (d.h.b.o.a(r22.b(), r2.b()) == false) goto L77;
    L92:
        throw new d.k();
    L17:
        com.obric.autogui.session.a r24 = (com.obric.autogui.session.a) ZeusTransformUtils.preCheckCast(r12.f, com.obric.autogui.session.a.class, "com.obric.aiagent.plugin");
        com.obric.autogui.agents.vlm.models.omni.c.j r25 = (com.obric.autogui.agents.vlm.models.omni.c.j) ZeusTransformUtils.preCheckCast(r12.f28389e, com.obric.autogui.agents.vlm.models.omni.c.j.class, "com.obric.aiagent.plugin");
        com.obric.autogui.agents.vlm.models.omni.intent.g r26 = (com.obric.autogui.agents.vlm.models.omni.intent.g) ZeusTransformUtils.preCheckCast(r12.f28388d, com.obric.autogui.agents.vlm.models.omni.intent.g.class, "com.obric.aiagent.plugin");
        com.obric.autogui.agents.vlm.models.omni.b.b r110 = (com.obric.autogui.agents.vlm.models.omni.b.b) ZeusTransformUtils.preCheckCast(r12.f28387c, com.obric.autogui.agents.vlm.models.omni.b.b.class, "com.obric.aiagent.plugin");
        DispatchContext r111 = (DispatchContext) ZeusTransformUtils.preCheckCast(r12.f28386b, DispatchContext.class, "com.obric.aiagent.plugin");
        OmniGUIIntent r27 = (OmniGUIIntent) ZeusTransformUtils.preCheckCast(r12.f28385a, OmniGUIIntent.class, "com.obric.aiagent.plugin");
        o.a(r4);
        com.obric.autogui.session.a r28 = r24;
        r0 = r27;
        r8 = r110;
        Object r112 = r4;
        com.obric.autogui.agents.vlm.models.omni.c.j r29 = r25;
    L49:
        IntentResult r113 = (IntentResult) ZeusTransformUtils.preCheckCast(r112, IntentResult.class, "com.obric.aiagent.plugin");
        if (r113 == null) goto L63;
        Loog r30 = Loog.INSTANCE;
        StringBuilder r31 = new StringBuilder().append("doAction system interception ");
        j r32 = r26.c();
        if (r32 == null) goto L54;
        r11 = r32.a();
    L54:
        r30.i(TAG, r31.append(r11).toString());
        if (r113.isFinal() == false) goto L62;
        if (r29 == null) goto L60;
        k r33 = r29.a();
        if (r33 == null) goto L60;
        r33.a(r26);
    L60:
        if (r8 == null) goto L62;
        r8.b();
    L62:
        return r113;
    L63:
        r12.f28385a = r0;
        r12.f28386b = r111;
        r12.f28387c = r8;
        r12.f28388d = r26;
        r12.f28389e = r29;
        r12.f = null;
        r12.i = 2;
        Object r34 = r0.ensureSessionActive(r28, r26, r12);
        if (r34 != r6) goto L66;
        return r6;
    L66:
        r16 = r111;
        com.obric.autogui.agents.vlm.models.omni.intent.g r114 = r26;
        r17 = r0;
        r1 = r29;
        r4 = r34;
        r2 = r114;
        goto L67
    L18:
        o.a(r4);
        r8 = com.obric.autogui.agents.vlm.models.omni.b.b.f28214a.a(r19);
        r26 = parseAndValidate(r18, r19);
        if (r26 != null) goto L24;
        Loog.INSTANCE.e(TAG, "doAction failed  params invalid");
        IntentResult<Bitmap> r35 = r0.error(com.obric.autogui.agents.vlm.models.omni.intent.c.f28408c);
        if (r8 == null) goto L23;
        r8.b();
    L23:
        return r35;
    L24:
        r r36 = t.f28523a.a(r26.b());
        if (r36 == null) goto L27;
        r29 = r36.d();
    L28:
        if (r29 == null) goto L30;
        r29.a(r26);
    L30:
        if (r8 == null) goto L32;
        r8.a(r26);
    L32:
        com.obric.autogui.agents.vlm.models.omni.d.e r115 = com.obric.autogui.agents.vlm.models.omni.d.e.f28334a;
        r r116 = t.f28523a.a(r26.b());
        if (r116 == null) goto L39;
        String r117 = r116.b();
        if (r117 == null) goto L39;
        if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r117, CharSequence.class, "com.obric.aiagent.plugin"))) == false) goto L39;
    L40:
        r115.a(r26, r117);
        Loog r118 = Loog.INSTANCE;
        StringBuilder r119 = new StringBuilder().append("doAction start ");
        j r120 = r26.c();
        if (r120 == null) goto L44;
        String r121 = r120.a();
        if (r121 == null) goto L44;
    L45:
        r118.i(TAG, r119.append(r121).toString());
        com.obric.autogui.session.a r122 = com.obric.autogui.session.c.f30777a.b();
        r12.f28385a = r0;
        r12.f28386b = r19;
        r12.f28387c = r8;
        r12.f28388d = r26;
        r12.f28389e = r29;
        r12.f = r122;
        r12.i = 1;
        r112 = r0.handleSystemInterception(r26, r122, r12);
        if (r112 != r6) goto L48;
        return r6;
    L48:
        r111 = r19;
        r28 = r122;
    L44:
        r121 = "multi-steps";
    L39:
        r117 = null;
        goto L40
    L27:
        r29 = null;
    L7:
        r5 = new e(r0, r3);
        goto L8
    }

    private final Object handleSystemInterception(com.obric.autogui.agents.vlm.models.omni.intent.g r17, com.obric.autogui.session.a r18, d.c.d<? super IntentResult<Bitmap>> r19) {
        d.c.d r0 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r19, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r0, g.class) == false) goto L7;
        g r1 = (g) ZeusTransformUtils.preCheckCast(r0, g.class, "com.obric.aiagent.plugin");
        if ((r1.f28395c & Integer.MIN_VALUE) == 0) goto L7;
        r1.f28395c -= Integer.MIN_VALUE;
    L8:
        Object r2 = r1.f28393a;
        Object r3 = d.c.a.b.a();
        int r4 = r1.f28395c;
        if (r4 == 0) goto L14;
        if (r4 != 1) goto L13;
        o.a(r2);
    L27:
        IntentResult r5 = new IntentResult(0, null, null, "成功", false, false, 0, null, null, null, DownloadErrorCode.ERROR_CANCELED, null);
    L36:
        return r5;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        o.a(r2);
        j r6 = r17.c();
        if (r6 != null) goto L17;
        return null;
    L17:
        String r7 = r6.a();
        if (d.h.b.o.a(r7, ACTION_INTENT_REPLY) == false) goto L30;
        if (r18 == null) goto L27;
        if (r18.M() == false) goto L27;
        if (d.h.b.o.a(r18.b(), r17.b()) == false) goto L27;
        Loog.INSTANCE.i(TAG, " - [intent_reply] received");
        String r8 = r6.b().get(0).getAsString();
        AutoActionAgent r9 = AutoActionAgent.INSTANCE;
        r1.f28395c = 1;
        if (r9.intentReply(r8, r1) != r3) goto L27;
        return r3;
    L30:
        if (d.h.b.o.a(r7, ACTION_INTENT_HANG_UP) == false) goto L37;
        if (r18 == null) goto L35;
        IAutoActionAgentEventListener.SessionInfo r10 = r18.d();
        if (r10 == null) goto L35;
        com.obric.autogui.b.a.f28928a.onUIOperationHangup(r10);
    L35:
        r5 = new IntentResult(0, null, null, "设置成功", false, false, 0, null, null, null, DownloadErrorCode.ERROR_CANCELED, null);
        goto L36
    L37:
        return null;
    L7:
        r1 = new g(this, r0);
        goto L8
    }

    private final void ensureSessionClosed(j r13, com.obric.autogui.session.a r14, r r15) {
        boolean r2 = true;
        r14.J().a(true);
        r15.i();
        Object r3 = null;
        d.n.a r4 = d.n.f38560a;     // Catch: Throwable -> L56
        OmniGUIIntent r12 = (OmniGUIIntent) ZeusTransformUtils.preCheckCast(this, OmniGUIIntent.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L56
        JsonElement r16 = r13.b().get(0);     // Catch: Throwable -> L56
        if (r16 == null) goto L7;
        String r17 = r16.getAsString();     // Catch: Throwable -> L56
    L87:
        d.n.a r5 = d.n.f38560a;     // Catch: Throwable -> L14
        JsonElement r6 = r13.b().get(1);     // Catch: Throwable -> L14
        if (r6 == null) goto L11;
        String r7 = r6.getAsString();     // Catch: Throwable -> L14
    L12:
        Object r8 = d.n.f(Boolean.valueOf(d.h.b.o.a(r7, "success")));     // Catch: Throwable -> L14
    L17:
        if (d.n.b(r8) == false) goto L19;
        r8 = null;
    L19:
        Boolean r9 = (Boolean) ZeusTransformUtils.preCheckCast(r8, Boolean.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L56
        if (r9 == null) goto L23;
        boolean r10 = r9.booleanValue();     // Catch: Throwable -> L56
    L85:
        d.n.a r11 = d.n.f38560a;     // Catch: Throwable -> L30
        JsonElement r18 = r13.b().get(2);     // Catch: Throwable -> L30
        if (r18 == null) goto L27;
        Boolean r19 = Boolean.valueOf(r18.getAsBoolean());     // Catch: Throwable -> L30
    L28:
        Object r20 = d.n.f(r19);     // Catch: Throwable -> L30
    L33:
        if (d.n.b(r20) == false) goto L35;
        r20 = null;
    L35:
        Boolean r21 = (Boolean) ZeusTransformUtils.preCheckCast(r20, Boolean.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L56
        if (r21 == null) goto L39;
        boolean r22 = r21.booleanValue();     // Catch: Throwable -> L56
    L83:
        d.n.a r23 = d.n.f38560a;     // Catch: Throwable -> L46
        JsonElement r110 = r13.b().get(3);     // Catch: Throwable -> L46
        if (r110 == null) goto L43;
        String r111 = r110.getAsString();     // Catch: Throwable -> L46
    L44:
        Object r112 = d.n.f(r111);     // Catch: Throwable -> L46
    L49:
        if (d.n.b(r112) == false) goto L51;
        r112 = null;
    L51:
        String r113 = (String) ZeusTransformUtils.preCheckCast(r112, String.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L56
        if (r17 != null) goto L54;
        r17 = "";
    L54:
        Object r114 = d.n.f(new EndStepParams(r17, r22, r10));     // Catch: Throwable -> L56
    L59:
        if (r14.M() == false) goto L61;
    L64:
        Loog r115 = Loog.INSTANCE;
        StringBuilder r24 = new StringBuilder().append("received stop command, stop the task immediately because isPaused=").append(r14.M()).append(" lastOmniActionNotNull=");
        if (r15.e() != null) goto L68;
        r2 = false;
    L68:
        r115.i(TAG, r24.append(r2).toString());
        IAutoActionAgentApi r25 = (IAutoActionAgentApi) ZeusTransformUtils.preCheckCast(AutoActionAgent.INSTANCE, IAutoActionAgentApi.class, "com.obric.aiagent.plugin");
        String r26 = r14.a();
        if (d.n.b(r114) == false) goto L71;
        Object r116 = null;
    L72:
        EndStepParams r117 = (EndStepParams) ZeusTransformUtils.preCheckCast(r116, EndStepParams.class, "com.obric.aiagent.plugin");
        if (r117 == null) goto L76;
        String r118 = r117.getAction();
        if (r118 == null) goto L76;
    L77:
        String r27 = r118;
        if (d.n.b(r114) == true) goto L81;
        r3 = r114;
    L81:
        IAutoActionAgentApi.DefaultImpls.systemTerminateQuery$default(r25, r26, r27, 0, (EndStepParams) ZeusTransformUtils.preCheckCast(r3, EndStepParams.class, "com.obric.aiagent.plugin"), null, 16, null);
        return;
    L76:
        r118 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AOHostAppTools.INSTANCE.getAppContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getString(ZeusTransformUtils.mapRes(R.string.obric_agent_task_finished, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_agent_task_finished"));
        d.h.b.o.c(r118, "getString(...)");
        goto L77
    L71:
        r116 = r114;
        goto L72
    L61:
        if (r15.e() != null) goto L64;
        kotlinx.coroutines.i.a(an.a((d.c.g) ZeusTransformUtils.preCheckCast(bd.a(), d.c.g.class, "com.obric.aiagent.plugin")), null, null, (m) ZeusTransformUtils.preCheckCast(new f(r14, r114, null), m.class, "com.obric.aiagent.plugin"), 3, null);
        return;
    L43:
        r111 = null;
    L46:
        th = move-exception;
        d.n.a r28 = d.n.f38560a;     // Catch: Throwable -> L56
        r112 = d.n.f(o.a(th));     // Catch: Throwable -> L56
        goto L49
    L39:
        r22 = false;
        goto L83
    L27:
        r19 = null;
    L30:
        th = move-exception;
        d.n.a r29 = d.n.f38560a;     // Catch: Throwable -> L56
        r20 = d.n.f(o.a(th));     // Catch: Throwable -> L56
        goto L33
    L23:
        r10 = true;
        goto L85
    L11:
        r7 = null;
    L14:
        th = move-exception;
        d.n.a r30 = d.n.f38560a;     // Catch: Throwable -> L56
        r8 = d.n.f(o.a(th));     // Catch: Throwable -> L56
        goto L17
    L7:
        r17 = null;
    L56:
        th = move-exception;
        d.n.a r119 = d.n.f38560a;
        r114 = d.n.f(o.a(th));
        goto L59
    }

    private final Object ensureSessionActive(com.obric.autogui.session.a r3, com.obric.autogui.agents.vlm.models.omni.intent.g r4, d.c.d<? super com.obric.autogui.agents.vlm.models.omni.intent.i> r5) {
        d.c.d<? super com.obric.autogui.agents.vlm.models.omni.intent.i> r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
        if (r3 == null) goto L7;
        return validateExistingSession(r3, r4, r6);
    L7:
        return validateNewSession(r4, r6);
    }

    private final Object validateExistingSession(com.obric.autogui.session.a r4, com.obric.autogui.agents.vlm.models.omni.intent.g r5, d.c.d<? super com.obric.autogui.agents.vlm.models.omni.intent.i> r6) {
        d.c.d<? super com.obric.autogui.agents.vlm.models.omni.intent.i> r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r6, d.c.d.class, "com.obric.aiagent.plugin");
        if (d.h.b.o.a(r4.b(), r5.b()) == false) goto L5;
        r r8 = t.f28523a.a(r5.b());
        if (r8 != null) goto L11;
        Loog.INSTANCE.e(TAG, "Conflict: Running=" + r4.b() + ", Request=" + r5.b());
        return new com.obric.autogui.agents.vlm.models.omni.intent.i.a(error(com.obric.autogui.agents.vlm.models.omni.intent.c.g));
    L11:
        if (r8.h() == false) goto L15;
        Loog.INSTANCE.i(TAG, "Refusing action on closed active session: " + r5.b());
        return new com.obric.autogui.agents.vlm.models.omni.intent.i.a(error(com.obric.autogui.agents.vlm.models.omni.intent.c.f28410e));
    L15:
        return new com.obric.autogui.agents.vlm.models.omni.intent.i.b(r8);
    L5:
        return handleSessionIdMismatch(r4, r5, r7);
    }

    private final Object handleSessionIdMismatch(com.obric.autogui.session.a r7, com.obric.autogui.agents.vlm.models.omni.intent.g r8, d.c.d<? super com.obric.autogui.agents.vlm.models.omni.intent.i> r9) {
        d.c.d<? super com.obric.autogui.agents.vlm.models.omni.intent.i> r10 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r9, d.c.d.class, "com.obric.aiagent.plugin");
        reportSessionMismatch$default(this, r7, r8, null, 4, null);
        Loog r0 = Loog.INSTANCE;
        StringBuilder r1 = new StringBuilder().append("Conflict: Running=").append(r7.b()).append(", Request=").append(r8.b()).append(", runningKey=").append(r7.a()).append(", requestToolId=").append(r8.g()).append(", requestMsgId=").append(r8.a()).append(", terminated=").append(r7.J().d()).append(", currentState=").append(r7.m().e().b()).append(", pendingState=").append(r7.m().c()).append(", loopActive=");
        AOThreadingTools.LaunchedJob r2 = r7.i();
        if (r2 == null) goto L7;
        ca r3 = r2.getJob();
        if (r3 == null) goto L7;
        Boolean r4 = d.c.b.a.b.a(r3.b());
    L8:
        r0.e(TAG, r1.append(r4).toString());
        if (r7.J().d() == false) goto L13;
        return clearTerminatedSessionAndStartNew(r7, r8, r10);
    L13:
        return terminateRunningSessionAndStartNew(r7, r8, r10);
    L7:
        r4 = null;
        goto L8
    }

    private final Object clearTerminatedSessionAndStartNew(com.obric.autogui.session.a r9, com.obric.autogui.agents.vlm.models.omni.intent.g r10, d.c.d<? super com.obric.autogui.agents.vlm.models.omni.intent.i> r11) {
        d.c.d r12 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r11, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r12, b.class) == false) goto L7;
        b r0 = (b) ZeusTransformUtils.preCheckCast(r12, b.class, "com.obric.aiagent.plugin");
        if ((r0.f28374e & Integer.MIN_VALUE) == 0) goto L7;
        r0.f28374e -= Integer.MIN_VALUE;
    L8:
        Object r13 = r0.f28372c;
        Object r2 = d.c.a.b.a();
        int r3 = r0.f28374e;
        if (r3 == 0) goto L16;
        if (r3 == 1) goto L15;
        if (r3 != 2) goto L14;
        o.a(r13);
    L24:
        return r13;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        r10 = (com.obric.autogui.agents.vlm.models.omni.intent.g) ZeusTransformUtils.preCheckCast(r0.f28371b, com.obric.autogui.agents.vlm.models.omni.intent.g.class, "com.obric.aiagent.plugin");
        OmniGUIIntent this = (OmniGUIIntent) ZeusTransformUtils.preCheckCast(r0.f28370a, OmniGUIIntent.class, "com.obric.aiagent.plugin");
        o.a(r13);
    L20:
        if (((Boolean) ZeusTransformUtils.preCheckCast(r13, Boolean.class, "com.obric.aiagent.plugin")).booleanValue() == false) goto L26;
        r0.f28370a = null;
        r0.f28371b = null;
        r0.f28374e = 2;
        r13 = this.validateNewSession(r10, r0);
        if (r13 != r2) goto L24;
        return r2;
    L26:
        return this.sessionMismatch();
    L16:
        o.a(r13);
        String r14 = "terminated_stale_session_before_new_request:running=" + r9.b() + ",request=" + r10.b() + ",toolId=" + r10.g() + ",msgId=" + r10.a();
        Loog.INSTANCE.w(TAG, "Clean stale terminated session before new request: running=" + r9.b() + ", request=" + r10.b() + ", runningKey=" + r9.a() + ", reason=" + r14);
        com.obric.autogui.session.c r4 = com.obric.autogui.session.c.f30777a;
        r0.f28370a = this;
        r0.f28371b = r10;
        r0.f28374e = 1;
        r13 = r4.a(r9, r14, r0);
        if (r13 != r2) goto L20;
        return r2;
    L7:
        r0 = new b(this, r12);
        goto L8
    }

    private final Object terminateRunningSessionAndStartNew(com.obric.autogui.session.a r23, com.obric.autogui.agents.vlm.models.omni.intent.g r24, d.c.d<? super com.obric.autogui.agents.vlm.models.omni.intent.i> r25) {
        OmniGUIIntent r0 = this;
        d.c.d r2 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r25, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r2, h.class) == false) goto L7;
        h r4 = (h) ZeusTransformUtils.preCheckCast(r2, h.class, "com.obric.aiagent.plugin");
        if ((r4.f & Integer.MIN_VALUE) == 0) goto L7;
        r4.f -= Integer.MIN_VALUE;
    L8:
        Object r3 = r4.f28399d;
        Object r5 = d.c.a.b.a();
        int r6 = r4.f;
        if (r6 == 0) goto L20;
        if (r6 == 1) goto L19;
        if (r6 == 2) goto L18;
        if (r6 == 3) goto L17;
        if (r6 != 4) goto L16;
        o.a(r3);
    L47:
        return r3;
    L16:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L17:
        com.obric.autogui.agents.vlm.models.omni.intent.g r1 = (com.obric.autogui.agents.vlm.models.omni.intent.g) ZeusTransformUtils.preCheckCast(r4.f28397b, com.obric.autogui.agents.vlm.models.omni.intent.g.class, "com.obric.aiagent.plugin");
        OmniGUIIntent r7 = (OmniGUIIntent) ZeusTransformUtils.preCheckCast(r4.f28396a, OmniGUIIntent.class, "com.obric.aiagent.plugin");
        o.a(r3);
    L43:
        if (((Boolean) ZeusTransformUtils.preCheckCast(r3, Boolean.class, "com.obric.aiagent.plugin")).booleanValue() == false) goto L49;
        r4.f28396a = null;
        r4.f28397b = null;
        r4.f = 4;
        r3 = r7.validateNewSession(r1, r4);
        if (r3 != r5) goto L47;
        return r5;
    L49:
        return r7.sessionMismatch();
    L18:
        o.a(r3);
    L28:
        return r3;
    L19:
        com.obric.autogui.agents.vlm.models.omni.intent.g r8 = (com.obric.autogui.agents.vlm.models.omni.intent.g) ZeusTransformUtils.preCheckCast(r4.f28398c, com.obric.autogui.agents.vlm.models.omni.intent.g.class, "com.obric.aiagent.plugin");
        com.obric.autogui.session.a r9 = (com.obric.autogui.session.a) ZeusTransformUtils.preCheckCast(r4.f28397b, com.obric.autogui.session.a.class, "com.obric.aiagent.plugin");
        OmniGUIIntent r10 = (OmniGUIIntent) ZeusTransformUtils.preCheckCast(r4.f28396a, OmniGUIIntent.class, "com.obric.aiagent.plugin");
        o.a(r3);
        com.obric.autogui.agents.vlm.models.omni.intent.g r11 = r8;
        r0 = r10;
    L23:
        com.obric.autogui.session.a r12 = com.obric.autogui.session.c.f30777a.b();
        if (r12 != null) goto L29;
        Loog.INSTANCE.w(TAG, "Old session released after terminate request: running=" + r9.b() + ", request=" + r11.b());
        r4.f28396a = null;
        r4.f28397b = null;
        r4.f28398c = null;
        r4.f = 2;
        r3 = r0.validateNewSession(r11, r4);
        if (r3 != r5) goto L28;
        return r5;
    L29:
        if (r12 == r9) goto L32;
        Loog.INSTANCE.e(TAG, "Old session switched while waiting terminate: expected=" + r9.b() + ", actual=" + r12.b() + ", request=" + r11.b());
        return r0.sessionMismatch();
    L32:
        String r13 = "new_intent_force_release_after_terminate_timeout:running=" + r9.b() + ",request=" + r11.b() + ",toolId=" + r11.g() + ",msgId=" + r11.a();
        Loog r14 = Loog.INSTANCE;
        StringBuilder r15 = new StringBuilder().append("Old session still occupies ongoing slot after terminate, force release before new request: running=").append(r9.b()).append(", request=").append(r11.b()).append(", runningKey=").append(r9.a()).append(", terminated=").append(r9.J().d()).append(", currentState=").append(r9.m().e().b()).append(", pendingState=").append(r9.m().c()).append(", loopActive=");
        AOThreadingTools.LaunchedJob r16 = r9.i();
        if (r16 == null) goto L37;
        ca r17 = r16.getJob();
        if (r17 == null) goto L37;
        Boolean r18 = d.c.b.a.b.a(r17.b());
    L38:
        r14.e(TAG, r15.append(r18).toString());
        com.obric.autogui.session.c r19 = com.obric.autogui.session.c.f30777a;
        r4.f28396a = r0;
        r4.f28397b = r11;
        r4.f28398c = null;
        r4.f = 3;
        r3 = r19.a(r9, r13, r4);
        if (r3 != r5) goto L41;
        return r5;
    L41:
        r7 = r0;
        r1 = r11;
    L37:
        r18 = null;
        goto L38
    L20:
        o.a(r3);
        com.obric.autogui.common.e r20 = com.obric.autogui.session.state.termination.a.a(r23.J(), com.obric.autogui.common.e.a.a(com.obric.autogui.common.e.f29014b, ZeusTransformUtils.mapRes(R.string.agent_internal_error, WsChannelMultiProcessSharedProvider.STRING_TYPE, "agent_internal_error"), null, 2, null), 108001, null, null, 12, null);
        Loog.INSTANCE.w(TAG, "Terminate old session for new request: running=" + r23.b() + ", request=" + r24.b() + ", runningKey=" + r23.a() + ", terminateOk=" + r20.g() + ", terminateMsg=" + r20.h());
        r4.f28396a = r0;
        r9 = r23;
        r4.f28397b = r9;
        r11 = r24;
        r4.f28398c = r11;
        r4.f = 1;
        if (ax.a(1000, r4) != r5) goto L23;
        return r5;
    L7:
        r4 = new h(r0, r2);
        goto L8
    }

    static /* synthetic */ void reportSessionMismatch$default(OmniGUIIntent r1, com.obric.autogui.session.a r2, com.obric.autogui.agents.vlm.models.omni.intent.g r3, d.h.a.b r4, int r5, Object r6) {
        d.h.a.b<? super JSONObject, x> r7 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r4, d.h.a.b.class, "com.obric.aiagent.plugin");
        if ((r5 & 4) == 0) goto L5;
        r7 = $$Lambda$OmniGUIIntent$oGYEap7I03ooK5dwab99krtZkE.INSTANCE;
    L5:
        r1.reportSessionMismatch(r2, r3, r7);
    }

    private static final x reportSessionMismatch$lambda$11(JSONObject r1) {
        d.h.b.o.e(r1, "<this>");
        return x.f38692a;
    }

    private final void reportSessionMismatch(com.obric.autogui.session.a r17, com.obric.autogui.agents.vlm.models.omni.intent.g r18, d.h.a.b<? super JSONObject, x> r19) {
        d.h.a.b r4 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r19, d.h.a.b.class, "com.obric.aiagent.plugin");
        boolean r5 = r17.J().d();
        d.n.a r0 = d.n.f38560a;     // Catch: Throwable -> L5
        OmniGUIIntent r1 = (OmniGUIIntent) ZeusTransformUtils.preCheckCast(this, OmniGUIIntent.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L5
        Object r2 = d.n.f(AOHostAppTools.INSTANCE.getHostAppInfo());     // Catch: Throwable -> L5
    L7:
        Boolean r7 = null;
        if (d.n.b(r2) == false) goto L10;
        r2 = null;
    L10:
        HostAppInfo r6 = (HostAppInfo) ZeusTransformUtils.preCheckCast(r2, HostAppInfo.class, "com.obric.aiagent.plugin");
        d.n.a r3 = d.n.f38560a;     // Catch: Throwable -> L13
        OmniGUIIntent r8 = (OmniGUIIntent) ZeusTransformUtils.preCheckCast(this, OmniGUIIntent.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L13
        Object r9 = d.n.f(AOHostAppTools.INSTANCE.getHostAppPackage());     // Catch: Throwable -> L13
    L15:
        String r10 = "";
        if (d.n.b(r9) == false) goto L18;
        r9 = "";
    L18:
        String r11 = (String) ZeusTransformUtils.preCheckCast(r9, String.class, "com.obric.aiagent.plugin");
        IAutoActionTrackingApi r12 = (IAutoActionTrackingApi) ZeusTransformUtils.preCheckCast(AOBizTracking.INSTANCE, IAutoActionTrackingApi.class, "com.obric.aiagent.plugin");
        JSONObject r13 = new JSONObject();
        r13.put("is_terminated", r5);
        r13.put("is_omni", r17.c());
        r13.put("session_id", r17.b());
        r13.put("request_session_id", r18.b());
        r13.put("session_key", r17.a());
        r13.put("request_tool_id", r18.g());
        r13.put("request_tool_name", r18.h());
        r13.put("request_instruction_type", r18.i());
        j r14 = r18.c();
        if (r14 == null) goto L22;
        String r15 = r14.a();
        if (r15 == null) goto L22;
    L23:
        r13.put("request_action_type", r15);
        Long r16 = r18.a();
        if (r16 == null) goto L26;
        String r20 = r16.toString();
    L27:
        if (r20 != null) goto L29;
        r20 = "";
    L29:
        r13.put("request_msg_id", r20);
        r13.put("device_id", r17.R().a());
        r13.put("plugin_version_code", AOHostAppTools.INSTANCE.getAppVersionCode());
        r13.put("host_app_package", r11);
        if (r6 == null) goto L32;
        String r21 = r6.getVersionName();
    L33:
        if (r21 != null) goto L35;
        r21 = "";
    L35:
        r13.put("host_app_version_name", r21);
        if (r6 == null) goto L38;
        int r22 = r6.getVersionCode();
    L39:
        r13.put("host_app_version_code", r22);
        r13.put("current_state", r17.m().e().b().toString());
        BizStatus r23 = r17.m().c();
        if (r23 == null) goto L42;
        String r24 = r23.toString();
    L43:
        if (r24 != null) goto L45;
        r24 = "";
    L45:
        r13.put("pending_state", r24);
        AOThreadingTools.LaunchedJob r25 = r17.i();
        if (r25 == null) goto L50;
        ca r26 = r25.getJob();
        if (r26 == null) goto L50;
        Boolean r27 = Boolean.valueOf(r26.b());
    L51:
        r13.put("loop_active", r27);
        AOThreadingTools.LaunchedJob r28 = r17.i();
        if (r28 == null) goto L56;
        ca r29 = r28.getJob();
        if (r29 == null) goto L56;
        Boolean r30 = Boolean.valueOf(r29.j());
    L57:
        r13.put("loop_cancelled", r30);
        AOThreadingTools.LaunchedJob r31 = r17.i();
        if (r31 == null) goto L62;
        ca r32 = r31.getJob();
        if (r32 == null) goto L62;
        r7 = Boolean.valueOf(r32.i());
    L62:
        r13.put("loop_completed", r7);
        r13.put("has_reached_end_step", r17.J().a());
        r13.put("step", r17.s());
        String r33 = r17.v();
        if (r33 == null) goto L66;
        r10 = r33;
    L66:
        r13.put("tracking_step_id", r10);
        r4.invoke(r13);
        x r34 = x.f38692a;
        IAutoActionTrackingApi.DefaultImpls.reportEvent$default(r12, "oauto_omni_session_mismatch", r13, false, false, null, 28, null);
        return;
    L56:
        r30 = null;
    L50:
        r27 = null;
        goto L51
    L42:
        r24 = null;
        goto L43
    L38:
        r22 = -1;
        goto L39
    L32:
        r21 = null;
        goto L33
    L26:
        r20 = null;
    L22:
        r15 = "multi_action";
    L13:
        th = move-exception;
        d.n.a r35 = d.n.f38560a;
        r9 = d.n.f(o.a(th));
    L5:
        th = move-exception;
        d.n.a r36 = d.n.f38560a;
        r2 = d.n.f(o.a(th));
        goto L7
    }

    private final com.obric.autogui.agents.vlm.models.omni.intent.i sessionMismatch() {
        return (com.obric.autogui.agents.vlm.models.omni.intent.i) ZeusTransformUtils.preCheckCast(new com.obric.autogui.agents.vlm.models.omni.intent.i.a(error(com.obric.autogui.agents.vlm.models.omni.intent.c.f28409d)), com.obric.autogui.agents.vlm.models.omni.intent.i.class, "com.obric.aiagent.plugin");
    }

    private final Object validateNewSession(com.obric.autogui.agents.vlm.models.omni.intent.g r19, d.c.d<? super com.obric.autogui.agents.vlm.models.omni.intent.i> r20) {
        OmniGUIIntent r0 = this;
        com.obric.autogui.agents.vlm.models.omni.intent.g r1 = r19;
        d.c.d r2 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r20, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r2, i.class) == false) goto L7;
        i r4 = (i) ZeusTransformUtils.preCheckCast(r2, i.class, "com.obric.aiagent.plugin");
        if ((r4.f & Integer.MIN_VALUE) == 0) goto L7;
        r4.f -= Integer.MIN_VALUE;
    L8:
        Object r3 = r4.f28404d;
        Object r5 = d.c.a.b.a();
        int r6 = r4.f;
        if (r6 == 0) goto L14;
        if (r6 != 1) goto L13;
        r r7 = (r) ZeusTransformUtils.preCheckCast(r4.f28403c, r.class, "com.obric.aiagent.plugin");
        r1 = (com.obric.autogui.agents.vlm.models.omni.intent.g) ZeusTransformUtils.preCheckCast(r4.f28402b, com.obric.autogui.agents.vlm.models.omni.intent.g.class, "com.obric.aiagent.plugin");
        OmniGUIIntent r8 = (OmniGUIIntent) ZeusTransformUtils.preCheckCast(r4.f28401a, OmniGUIIntent.class, "com.obric.aiagent.plugin");
        o.a(r3);
        r r9 = r7;
        r0 = r8;
        Object r10 = r3;
    L42:
        com.obric.autogui.common.e r11 = (com.obric.autogui.common.e) ZeusTransformUtils.preCheckCast(r10, com.obric.autogui.common.e.class, "com.obric.aiagent.plugin");
        if (r11.g() == true) goto L47;
        Loog.INSTANCE.i(TAG, "No active session, init failed: " + r11.h());
        return new com.obric.autogui.agents.vlm.models.omni.intent.i.a(new IntentResult(com.obric.autogui.agents.vlm.models.omni.intent.c.f.a(), null, null, r11.h(), false, false, 0, null, null, null, DownloadErrorCode.ERROR_REMOVE_DOWNLOAD_RUNNABLE, null));
    L47:
        if (r9.h() == false) goto L50;
        Loog.INSTANCE.i(TAG, "Session closed while being created: " + r1.b());
        return new com.obric.autogui.agents.vlm.models.omni.intent.i.a(r0.error(com.obric.autogui.agents.vlm.models.omni.intent.c.f28410e));
    L50:
        Loog.INSTANCE.i(TAG, "No active session, init success");
        return new com.obric.autogui.agents.vlm.models.omni.intent.i.b(r9);
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        o.a(r3);
        r9 = t.f28523a.a(r19.b());
        boolean r12 = false;
        if (r9 != null) goto L17;
    L19:
        if (r12 == false) goto L22;
        Loog.INSTANCE.i(TAG, "Refusing action on closed session: " + r19.b());
        return new com.obric.autogui.agents.vlm.models.omni.intent.i.a(r0.error(com.obric.autogui.agents.vlm.models.omni.intent.c.f28410e));
    L22:
        j r13 = r19.c();
        if (r13 == null) goto L25;
        String r14 = r13.a();
    L27:
        if (d.h.b.o.a(r14, ACTION_STOP) == false) goto L30;
        Loog.INSTANCE.i(TAG, "Refusing stop action on non-existent session: " + r19.b());
        return new com.obric.autogui.agents.vlm.models.omni.intent.i.a(r0.error(com.obric.autogui.agents.vlm.models.omni.intent.c.h));
    L30:
        if (r9 != null) goto L33;
        r9 = t.a(t.f28523a, r19.b(), null, 2, null);
    L33:
        if (r9.a(r19.a()) == true) goto L36;
        Loog.INSTANCE.i(TAG, "Refusing action while session is closing: " + r19.b());
        return new com.obric.autogui.agents.vlm.models.omni.intent.i.a(r0.error(com.obric.autogui.agents.vlm.models.omni.intent.c.f28410e));
    L36:
        com.obric.autogui.session.a r15 = com.obric.autogui.session.d.i.f30907a.b();
        if (r15 == null) goto L39;
        Loog.INSTANCE.i(TAG, "Discarding stale pending session key=" + r15.a() + " before new session creation");
        com.obric.autogui.session.d.i.f30907a.a(r15, "gui_action_without_gui_init");
    L39:
        Loog.INSTANCE.i(TAG, "No active session, initializing... " + r9.a() + ' ' + r9.h());
        r4.f28401a = r0;
        r4.f28402b = r1;
        r4.f28403c = r9;
        r4.f = 1;
        r10 = r0.performSessionCreation(r1, r4);
        if (r10 != r5) goto L42;
        return r5;
    L25:
        r14 = null;
        goto L27
    L17:
        if (r9.h() != true) goto L19;
        r12 = true;
    L7:
        r4 = new i(r0, r2);
        goto L8
    }

    private final Object dispatchToSession(com.obric.autogui.agents.vlm.models.omni.intent.g r15, com.obric.autogui.session.a r16, r r17, DispatchContext r18, com.obric.autogui.agents.vlm.models.omni.b.b r19, d.c.d<? super IntentResult<Bitmap>> r20) {
        OmniGUIIntent r8 = this;
        d.c.d r0 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r20, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r0, c.class) == false) goto L7;
        c r1 = (c) ZeusTransformUtils.preCheckCast(r0, c.class, "com.obric.aiagent.plugin");
        if ((r1.f & Integer.MIN_VALUE) == 0) goto L7;
        r1.f -= Integer.MIN_VALUE;
    L8:
        c r10 = r1;
        Object r2 = r10.f28378d;
        Object r11 = d.c.a.b.a();
        int r3 = r10.f;
        if (r3 == 0) goto L19;
        if (r3 != 1) goto L18;
        r r4 = (r) ZeusTransformUtils.preCheckCast(r10.f28377c, r.class, "com.obric.aiagent.plugin");
        com.obric.autogui.agents.vlm.models.omni.intent.g r5 = (com.obric.autogui.agents.vlm.models.omni.intent.g) ZeusTransformUtils.preCheckCast(r10.f28376b, com.obric.autogui.agents.vlm.models.omni.intent.g.class, "com.obric.aiagent.plugin");
        OmniGUIIntent r6 = (OmniGUIIntent) ZeusTransformUtils.preCheckCast(r10.f28375a, OmniGUIIntent.class, "com.obric.aiagent.plugin");
        o.a(r2);     // Catch: CancellationException -> L14
        r r13 = r4;
        com.obric.autogui.agents.vlm.models.omni.intent.g r12 = r5;
    L50:
        return (IntentResult) ZeusTransformUtils.preCheckCast(r2, IntentResult.class, "com.obric.aiagent.plugin");
    L30:
        e = e;
    L16:
        r8 = r6;
    L39:
        ce.b(r10.getContext());
        if (r13.h() == false) goto L43;
        Loog.INSTANCE.i(TAG, "Dispatch cancelled because session closed: " + r12.b());
        return r8.error(com.obric.autogui.agents.vlm.models.omni.intent.c.f28410e);
    L43:
        throw e;
    L14:
        e = e;
        r13 = r4;
        r12 = r5;
        goto L16
    L18:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L19:
        o.a(r2);
        r10.f28375a = r8;     // Catch: CancellationException -> L36
        r12 = r15;
        r10.f28376b = r12;     // Catch: CancellationException -> L34
        r13 = r17;
        r10.f28377c = r13;     // Catch: CancellationException -> L32
        r10.f = 1;     // Catch: CancellationException -> L32
        r2 = dispatchToSessionInScope(r15, r16, r17, r18, r19, r10);     // Catch: CancellationException -> L32
        if (r2 != r11) goto L27;
        return r11;
    L27:
        r6 = r8;
    L32:
        e = e;
    L34:
        e = e;
    L38:
        r13 = r17;
    L36:
        e = e;
        r12 = r15;
    L7:
        r1 = new c(this, r0);
        goto L8
    }

    private final Object dispatchToSessionInScope(com.obric.autogui.agents.vlm.models.omni.intent.g r13, com.obric.autogui.session.a r14, r r15, DispatchContext r16, com.obric.autogui.agents.vlm.models.omni.b.b r17, d.c.d<? super IntentResult<Bitmap>> r18) {
        d.c.d r0 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r18, d.c.d.class, "com.obric.aiagent.plugin");
        return kotlinx.coroutines.i.a(r15.c().getCoroutineScope().a(), (m) ZeusTransformUtils.preCheckCast(new d(r15, r16, r13, this, r17, r14, null), m.class, "com.obric.aiagent.plugin"), r0);
    }

    private final IntentResult<Bitmap> handleActionDispatchOnSessionPaused(com.obric.autogui.session.a r4) {
        Loog.INSTANCE.i(TAG, "Session is paused during action dispatch: " + r4.b());
        com.obric.autogui.session.state.a r5 = r4.m().e();
        if (ZeusTransformUtils.instanceOf(r5, com.obric.autogui.agents.vlm.models.omni.intent.e.class) == false) goto L5;
        com.obric.autogui.agents.vlm.models.omni.intent.e r6 = (com.obric.autogui.agents.vlm.models.omni.intent.e) ZeusTransformUtils.preCheckCast(r5, com.obric.autogui.agents.vlm.models.omni.intent.e.class, "com.obric.aiagent.plugin");
    L6:
        if (r6 == null) goto L10;
        IntentResult<Bitmap> r7 = r6.a();
        if (r7 == null) goto L10;
        return r7;
    L10:
        return error(com.obric.autogui.agents.vlm.models.omni.intent.c.k);
    L5:
        r6 = null;
        goto L6
    }

    private final Object performSessionCreation(com.obric.autogui.agents.vlm.models.omni.intent.g r7, d.c.d<? super com.obric.autogui.common.e> r8) {
        d.c.d<? super com.obric.autogui.common.e> r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r8, d.c.d.class, "com.obric.aiagent.plugin");
        Bundle r3 = new Bundle();
        r3.putString("session_id", r7.b());
        if (r7.a() == null) goto L5;
        r3.putLong("doubao_message_id", r7.a().longValue());
    L5:
        String r6 = r7.p();
        if (r6 == null) goto L8;
        r3.putString("caller_source", r6);
    L8:
        Boolean r9 = r7.q();
        if (r9 == null) goto L12;
        r3.putBoolean("allow_user_interaction", r9.booleanValue());
    L12:
        if (d.h.b.o.a(r7.p(), "ai_proactive") == false) goto L15;
        r3.putBoolean("start_in_place", false);
    L18:
        return AutoActionAgent.INSTANCE.postUserQuery(r7.f(), false, r3, 36, r5);
    L15:
        if (r7.r() == null) goto L18;
        r3.putBoolean("start_in_place", r7.r().booleanValue());
        goto L18
    }

    private final com.obric.autogui.agents.vlm.models.omni.intent.g parseAndValidate(GUIActionParams r26, DispatchContext r27) {
        String r6 = r26.getUniqueId();
        if (r6 != null) goto L115;
        return null;
    L115:
        JsonObject r8 = (JsonObject) ZeusTransformUtils.preCheckCast(com.obric.autogui.util.b.f31495a.a().fromJson(r26.getStep(), JsonObject.class), JsonObject.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L110
        JsonObject r4 = (JsonObject) ZeusTransformUtils.preCheckCast(com.obric.autogui.util.b.f31495a.a().fromJson(r26.getExt(), JsonObject.class), JsonObject.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L110
        JsonElement r0 = r8.get("action_type");     // Catch: Exception -> L110
        if (r0 == null) goto L8;
        String r5 = r0.getAsString();     // Catch: Exception -> L110
    L9:
        JsonElement r1 = r8.get("action_args");     // Catch: Exception -> L110
        if (r1 == null) goto L13;
        JsonArray r2 = r1.getAsJsonArray();     // Catch: Exception -> L110
        if (r2 == null) goto L13;
    L14:
        JsonArray r7 = r2;
        JsonElement r3 = r4.get(DownloadConstants.QUERY_KEY);     // Catch: Exception -> L110
        if (r3 == null) goto L17;
        String r10 = r3.getAsString();     // Catch: Exception -> L110
    L18:
        JsonElement r9 = r4.get("tool_id");     // Catch: Exception -> L110
        if (r9 == null) goto L21;
        String r11 = r9.getAsString();     // Catch: Exception -> L110
    L22:
        JsonElement r12 = r4.get("tool_name");     // Catch: Exception -> L110
        if (r12 == null) goto L25;
        String r13 = r12.getAsString();     // Catch: Exception -> L110
    L26:
        JsonElement r14 = r4.get("o_omni_instruction_type");     // Catch: Exception -> L110
        if (r14 == null) goto L29;
        String r15 = r14.getAsString();     // Catch: Exception -> L110
    L30:
        d.h.b.o.a(r4);     // Catch: Exception -> L110
        String r21 = com.obric.autogui.agents.vlm.models.omni.intent.b.a(r4, "caller_source");     // Catch: Exception -> L110
        Boolean r22 = com.obric.autogui.agents.vlm.models.omni.intent.b.b(r4, "allow_user_interaction");     // Catch: Exception -> L110
        Boolean r23 = com.obric.autogui.agents.vlm.models.omni.intent.b.b(r4, "start_in_place");     // Catch: Exception -> L110
        d.n.a r16 = d.n.f38560a;     // Catch: Throwable -> L41
        OmniGUIIntent r17 = (OmniGUIIntent) ZeusTransformUtils.preCheckCast(this, OmniGUIIntent.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L41
        JsonElement r18 = r4.get(KEY_OMNI_TASK_ID);     // Catch: Throwable -> L41
        if (r18 == null) goto L35;
        String r19 = r18.getAsString();     // Catch: Throwable -> L41
        if (r19 == null) goto L35;
    L39:
        Object r20 = d.n.f(r19);     // Catch: Throwable -> L41
    L44:
        if (d.n.b(r20) == false) goto L46;
        r20 = null;
    L46:
        String r24 = (String) ZeusTransformUtils.preCheckCast(r20, String.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L110
        boolean r110 = true;
        if (r24 != null) goto L49;
    L54:
        Map<String, String> r25 = r27.getExt();     // Catch: Exception -> L110
        if (r25 == null) goto L61;
        r24 = (String) ZeusTransformUtils.preCheckCast(r25.get(KEY_OMNI_TASK_ID), String.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L110
        if (r24 == null) goto L61;
        if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r24, CharSequence.class, "com.obric.aiagent.plugin"))) == false) goto L61;
    L62:
        if (r24 != null) goto L71;
        Map<String, String> r28 = r27.getExt();     // Catch: Exception -> L110
        if (r28 == null) goto L70;
        r24 = (String) ZeusTransformUtils.preCheckCast(r28.get(KEY_INSTRUCTION_ID), String.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L110
        if (r24 == null) goto L70;
        if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r24, CharSequence.class, "com.obric.aiagent.plugin"))) == true) goto L71;
    L70:
        String r111 = null;
    L72:
        if (r10 == null) goto L109;
        CharSequence r29 = (CharSequence) ZeusTransformUtils.preCheckCast(r11, CharSequence.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L110
        boolean r30 = false;
        if (r29 != null) goto L76;
    L79:
        if (r110 == true) goto L109;
        if (r5 == null) goto L83;
        j r31 = new j(r5, r7);     // Catch: Exception -> L110
    L84:
        if (r31 == null) goto L86;
    L88:
        Long r32 = r27.getQuestionId();     // Catch: Exception -> L110
        d.h.b.o.a(r8);     // Catch: Exception -> L110
        JsonElement r33 = r4.get("prev_step_status");     // Catch: Exception -> L110
        if (r33 == null) goto L92;
        String r34 = r33.getAsString();     // Catch: Exception -> L110
    L93:
        String r35 = "";
        if (r13 != null) goto L96;
        String r112 = "";
    L97:
        if (r15 == null) goto L100;
        r35 = r15;
    L100:
        String r210 = com.obric.autogui.agents.vlm.models.omni.intent.f.a(r4);     // Catch: Exception -> L110
        JsonElement r36 = r4.get("is_gui_idle");     // Catch: Exception -> L110
        if (r36 == null) goto L103;
        boolean r113 = r36.getAsBoolean();     // Catch: Exception -> L110
    L104:
        Context r114 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r27.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L110
        JsonElement r37 = r4.get("o_omni_gui_keep_bitmap");     // Catch: Exception -> L110
        if (r37 == null) goto L107;
        r30 = r37.getAsBoolean();     // Catch: Exception -> L110
    L107:
        return new com.obric.autogui.agents.vlm.models.omni.intent.g(r32, r6, r31, r8, r34, r10, r11, r112, r35, r111, r113, r114, r30, com.obric.autogui.agents.vlm.models.omni.intent.b.a(r4, "app_list_hash"), com.obric.autogui.agents.vlm.models.omni.intent.b.a(r4, "ability_desc_list_hash"), r210, r21, r22, r23);
    L103:
        r113 = false;
        goto L104
    L96:
        r112 = r13;
        goto L97
    L92:
        r34 = null;
        goto L93
    L86:
        if (r8.has("action_list") == true) goto L88;
        return null;
    L83:
        r31 = null;
        goto L84
    L76:
        if (r29.length() == 0) goto L79;
        r110 = false;
    L109:
        return null;
    L71:
        r111 = r24;
    L61:
        r24 = null;
        goto L62
    L49:
        if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r24, CharSequence.class, "com.obric.aiagent.plugin"))) == true) goto L52;
        r24 = null;
    L52:
        if (r24 == null) goto L54;
    L35:
        JsonElement r38 = r4.get(KEY_INSTRUCTION_ID);     // Catch: Throwable -> L41
        if (r38 == null) goto L38;
        r19 = r38.getAsString();     // Catch: Throwable -> L41
        goto L39
    L38:
        r19 = null;
    L41:
        th = move-exception;
        d.n.a r115 = d.n.f38560a;     // Catch: Exception -> L110
        r20 = d.n.f(o.a(th));     // Catch: Exception -> L110
        goto L44
    L29:
        r15 = null;
        goto L30
    L25:
        r13 = null;
        goto L26
    L21:
        r11 = null;
        goto L22
    L17:
        r10 = null;
    L13:
        r2 = new JsonArray();     // Catch: Exception -> L110
        goto L14
    L8:
        r5 = null;
    L110:
        e = move-exception;
        Loog.INSTANCE.e(TAG, "GUIAction Params parse error", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
        return null;
    }

    private final IntentResult<Bitmap> error(com.obric.autogui.agents.vlm.models.omni.intent.c r14) {
        return new IntentResult(r14.a(), null, null, r14.b(), false, false, 0, null, null, null, DownloadErrorCode.ERROR_REMOVE_DOWNLOAD_RUNNABLE, null);
    }
}
