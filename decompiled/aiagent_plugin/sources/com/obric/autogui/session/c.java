package com.obric.autogui.session;

import android.content.Context;
import android.graphics.PointF;
import com.bytedance.apm.battery.dao.DBHelper;
import com.bytedance.applog.et_verify.BuildConfig;
import com.bytedance.common.wschannel.WsChannelMultiProcessSharedProvider;
import com.bytedance.security.zenmobile.io.SensitiveType;
import com.obric.aiagent.plugin.R;
import com.obric.autogui.agents.vlm.models.omni.r;
import com.obric.autogui.agents.vlm.models.omni.upload.v;
import com.obric.autogui.common.api.AOAgentRobotsTools;
import com.obric.autogui.common.api.AOBizTracking;
import com.obric.autogui.common.api.AOSystemTools;
import com.obric.autogui.common.api.agent.BizStatus;
import com.obric.autogui.common.api.agent.IAutoActionAgentEventListener;
import com.obric.autogui.common.api.agent.IAutoActionSessionManager;
import com.obric.autogui.common.api.agent.model.EndStepParams;
import com.obric.autogui.common.api.app.AOHostAppTools;
import com.obric.autogui.common.api.logging.Loog;
import com.obric.autogui.common.api.platform.tracking.IAutoActionTrackingApi;
import com.obric.autogui.common.api.presentation.AOUserInterfaceTools;
import com.obric.autogui.common.api.space.AOOperatingSpace;
import com.obric.autogui.common.api.space.OperatingSpaceManager;
import com.obric.autogui.common.api.threading.AOThreadingTools;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.ao;
import d.a.p;
import d.c.b.a.l;
import d.h.a.m;
import d.h.b.ae;
import d.h.b.z;
import d.n;
import d.o;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.CancellationException;
import kotlinx.coroutines.am;
import kotlinx.coroutines.b.x;
import kotlinx.coroutines.ca;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: SessionManager.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class c implements IAutoActionSessionManager {
    private static final String TAG = "SesMan";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f30777a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final x<List<IAutoActionAgentEventListener.SessionInfo>> f30778b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final com.obric.autogui.operator.a.a f30779c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static volatile com.obric.autogui.session.a f30780d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static com.obric.autogui.session.a f30781e;
    private static IAutoActionAgentEventListener.SessionInfo f;
    private static final List<com.obric.autogui.session.a> g = null;

    /* JADX INFO: compiled from: SessionManager.kt */
    @d.c.b.a.f(b = "SessionManager.kt", c = {891, 893, 894, 903}, d = "cleanseVoidedSession", e = "com.obric.autogui.session.SessionManager")
    static final class a extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f30782a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        boolean f30783b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        /* synthetic */ Object f30784c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ c f30785d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        int f30786e;

        a(c r3, d.c.d<? super a> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f30785d = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f30784c = r3;
            this.f30786e |= Integer.MIN_VALUE;
            return c.c(this.f30785d, null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: SessionManager.kt */
    @d.c.b.a.f(b = "SessionManager.kt", c = {}, d = "invokeSuspend", e = "com.obric.autogui.session.SessionManager$cleanseVoidedSession$2$6")
    static final class b extends l implements m<JSONObject, d.c.d<? super d.x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f30787a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        /* synthetic */ Object f30788b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ com.obric.autogui.session.a f30789c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f30790d;

        b(com.obric.autogui.session.a r3, int r4, d.c.d<? super b> r5) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            this.f30789c = r3;
            this.f30790d = r4;
            super(2, r6);
        }

        public final Object a(JSONObject r3, d.c.d<? super d.x> r4) {
            return ((b) ZeusTransformUtils.preCheckCast(create(r3, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), b.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<d.x> create(Object r4, d.c.d<?> r5) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            b r0 = new b(this.f30789c, this.f30790d, r6);
            r0.f30788b = r4;
            return (d.c.d) ZeusTransformUtils.preCheckCast(r0, d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(JSONObject r3, d.c.d<? super d.x> r4) {
            return a((JSONObject) ZeusTransformUtils.preCheckCast(r3, JSONObject.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r11) {
            d.c.a.b.a();
            if (this.f30787a != 0) goto L7;
            o.a(r11);
            JSONObject r4 = (JSONObject) ZeusTransformUtils.preCheckCast(this.f30788b, JSONObject.class, "com.obric.aiagent.plugin");
            Loog.INSTANCE.i(c.TAG, "[session-metrics] (" + this.f30789c.a() + " - " + this.f30789c.b() + ") metered procedures count: " + r4.length());
            IAutoActionTrackingApi r2 = (IAutoActionTrackingApi) ZeusTransformUtils.preCheckCast(AOBizTracking.INSTANCE, IAutoActionTrackingApi.class, "com.obric.aiagent.plugin");
            com.obric.autogui.session.a r12 = this.f30789c;
            int r10 = this.f30790d;
            com.obric.autogui.session.c.b.a(r4, r12);
            r4.put("exec_steps_count", r10);
            d.x r13 = d.x.f38692a;
            IAutoActionTrackingApi.DefaultImpls.reportEvent$default(r2, "met_task", r4, false, false, null, 28, null);
            return d.x.f38692a;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.obric.autogui.session.c$c, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SessionManager.kt */
    @d.c.b.a.f(b = "SessionManager.kt", c = {819, 828}, d = "forceVoidSessionIfCurrent", e = "com.obric.autogui.session.SessionManager")
    static final class C0836c extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f30791a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f30792b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Object f30793c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        long f30794d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        long f30795e;
        /* synthetic */ Object f;
        final /* synthetic */ c g;
        int h;

        C0836c(c r3, d.c.d<? super C0836c> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.g = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f = r3;
            this.h |= Integer.MIN_VALUE;
            return this.g.a(null, null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: SessionManager.kt */
    @d.c.b.a.f(b = "SessionManager.kt", c = {165}, d = "launchSession", e = "com.obric.autogui.session.SessionManager")
    static final class d extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f30796a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f30797b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        /* synthetic */ Object f30798c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ c f30799d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        int f30800e;

        d(c r3, d.c.d<? super d> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f30799d = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f30798c = r3;
            this.f30800e |= Integer.MIN_VALUE;
            return c.a(this.f30799d, null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: SessionManager.kt */
    @d.c.b.a.f(b = "SessionManager.kt", c = {378, 403, 467, 493, 506, 516, 522, 590, 604}, d = "loopSteps", e = "com.obric.autogui.session.SessionManager")
    static final class e extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f30801a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f30802b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Object f30803c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        Object f30804d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        Object f30805e;
        Object f;
        Object g;
        Object h;
        int i;
        int j;
        int k;
        long l;
        long m;
        /* synthetic */ Object n;
        final /* synthetic */ c o;
        int p;

        e(c r3, d.c.d<? super e> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.o = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.n = r3;
            this.p |= Integer.MIN_VALUE;
            return c.b(this.o, null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: SessionManager.kt */
    @d.c.b.a.f(b = "SessionManager.kt", c = {}, d = "invokeSuspend", e = "com.obric.autogui.session.SessionManager$loopSteps$6")
    static final class f extends l implements m<JSONObject, d.c.d<? super d.x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f30806a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        /* synthetic */ Object f30807b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ com.obric.autogui.session.a f30808c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ com.obric.autogui.operator.e f30809d;

        f(com.obric.autogui.session.a r3, com.obric.autogui.operator.e r4, d.c.d<? super f> r5) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            this.f30808c = r3;
            this.f30809d = r4;
            super(2, r6);
        }

        public final Object a(JSONObject r3, d.c.d<? super d.x> r4) {
            return ((f) ZeusTransformUtils.preCheckCast(create(r3, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), f.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<d.x> create(Object r4, d.c.d<?> r5) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            f r0 = new f(this.f30808c, this.f30809d, r6);
            r0.f30807b = r4;
            return (d.c.d) ZeusTransformUtils.preCheckCast(r0, d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(JSONObject r3, d.c.d<? super d.x> r4) {
            return a((JSONObject) ZeusTransformUtils.preCheckCast(r3, JSONObject.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r11) {
            d.c.a.b.a();
            if (this.f30806a != 0) goto L50;
            o.a(r11);
            JSONObject r4 = (JSONObject) ZeusTransformUtils.preCheckCast(this.f30807b, JSONObject.class, "com.obric.aiagent.plugin");
            Loog.INSTANCE.i(c.TAG, "[step-metrics] (" + this.f30808c.a() + " - " + this.f30809d.W() + ") metered procedures count: " + r4.length());
            IAutoActionTrackingApi r2 = (IAutoActionTrackingApi) ZeusTransformUtils.preCheckCast(AOBizTracking.INSTANCE, IAutoActionTrackingApi.class, "com.obric.aiagent.plugin");
            com.obric.autogui.operator.e r12 = this.f30809d;
            com.obric.autogui.session.a r10 = this.f30808c;
            IAutoActionAgentEventListener.AgentStepInfo r0 = r12.T();
            boolean r5 = true;
            if (r0 != null) goto L7;
        L29:
            r5 = false;
        L30:
            IAutoActionAgentEventListener.AgentStepInfo r1 = r12.T();
            String r6 = "";
            if (r1 == null) goto L34;
            String r3 = r1.getActionProtocolType();
            if (r3 == null) goto L34;
        L35:
            List<com.obric.autogui.operator.e> r7 = r10.p();
            com.obric.autogui.operator.e r8 = (com.obric.autogui.operator.e) ZeusTransformUtils.preCheckCast(p.d(r7, r7.size() - 2), com.obric.autogui.operator.e.class, "com.obric.aiagent.plugin");
            if (r8 == null) goto L41;
            IAutoActionAgentEventListener.AgentStepInfo r9 = r8.T();
            if (r9 == null) goto L41;
            String r13 = r9.getActionProtocolType();
            if (r13 == null) goto L41;
        L42:
            int r14 = c.a(c.f30777a, r10);
            if (d.h.b.o.a(r3, "type") == false) goto L47;
            if (r5 == false) goto L46;
            r6 = "true";
            goto L47
        L46:
            r6 = "false";
        L47:
            com.obric.autogui.session.c.b.a(r4, r10);
            r4.put("step_id", r12.W());
            r4.put("is_retry", r12.V());
            r4.put("open_app_follow_wait_count", r14);
            r4.put("lastType", r13);
            JSONArray r15 = new JSONArray();
            r15.put(r3);
            r15.put(r13);
            r15.put(r6);
            d.x r16 = d.x.f38692a;
            r4.put("action_prev_samepos", r15);
            r12.a(r4);
            d.x r17 = d.x.f38692a;
            IAutoActionTrackingApi.DefaultImpls.reportEvent$default(r2, "met_step", r4, false, false, null, 28, null);
            return d.x.f38692a;
        L41:
            r13 = "";
        L34:
            r3 = "";
            goto L35
        L7:
            if (d.h.b.o.a(r0.getActionProtocolType(), "type") == false) goto L29;
            List<com.obric.autogui.operator.e> r18 = r10.p();
            com.obric.autogui.operator.e r19 = (com.obric.autogui.operator.e) ZeusTransformUtils.preCheckCast(p.d(r18, r18.size() - 2), com.obric.autogui.operator.e.class, "com.obric.aiagent.plugin");
            if (ZeusTransformUtils.instanceOf(r19, com.obric.autogui.agents.vlm.models.impl.e.class) == false) goto L29;
            if (ZeusTransformUtils.instanceOf(r12, com.obric.autogui.agents.vlm.models.impl.e.class) == false) goto L29;
            IAutoActionAgentEventListener.AgentStepInfo r20 = ((com.obric.autogui.agents.vlm.models.impl.e) ZeusTransformUtils.preCheckCast(r19, com.obric.autogui.agents.vlm.models.impl.e.class, "com.obric.aiagent.plugin")).T();
            PointF r21 = (PointF) ZeusTransformUtils.preCheckCast(p.f((Iterable) ZeusTransformUtils.preCheckCast(((com.obric.autogui.agents.vlm.models.impl.e) ZeusTransformUtils.preCheckCast(r19, com.obric.autogui.agents.vlm.models.impl.e.class, "com.obric.aiagent.plugin")).b(), Iterable.class, "com.obric.aiagent.plugin")), PointF.class, "com.obric.aiagent.plugin");
            PointF r22 = (PointF) ZeusTransformUtils.preCheckCast(p.f((Iterable) ZeusTransformUtils.preCheckCast(((com.obric.autogui.agents.vlm.models.impl.e) ZeusTransformUtils.preCheckCast(r12, com.obric.autogui.agents.vlm.models.impl.e.class, "com.obric.aiagent.plugin")).b(), Iterable.class, "com.obric.aiagent.plugin")), PointF.class, "com.obric.aiagent.plugin");
            if (r20 == null) goto L29;
            if (d.h.b.o.a(r20.getActionProtocolType(), "click") == false) goto L29;
            if (r21 == null) goto L29;
            if (r22 == null) goto L29;
            if (r21.x != r22.x) goto L21;
            boolean r23 = true;
        L22:
            if (r23 == false) goto L29;
            if (r21.y != r22.y) goto L26;
            boolean r24 = true;
        L27:
            if (r24 == false) goto L29;
        L26:
            r24 = false;
            goto L27
        L21:
            r23 = false;
            goto L22
        L50:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: compiled from: SessionManager.kt */
    @d.c.b.a.f(b = "SessionManager.kt", c = {BuildConfig.VERSION_CODE, 326}, d = "invokeSuspend", e = "com.obric.autogui.session.SessionManager$loopSteps$blSyncJob$1")
    static final class g extends l implements m<am, d.c.d<? super d.x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        long f30810a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f30811b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ com.obric.autogui.session.a f30812c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ boolean f30813d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ int f30814e;

        g(com.obric.autogui.session.a r3, boolean r4, int r5, d.c.d<? super g> r6) {
            d.c.d r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r6, d.c.d.class, "com.obric.aiagent.plugin");
            this.f30812c = r3;
            this.f30813d = r4;
            this.f30814e = r5;
            super(2, r7);
        }

        public final Object a(am r3, d.c.d<? super d.x> r4) {
            return ((g) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), g.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<d.x> create(Object r4, d.c.d<?> r5) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new g(this.f30812c, this.f30813d, this.f30814e, r6), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super d.x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r10) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f30811b;
            boolean r4 = true;
            if (r1 == 0) goto L14;
            if (r1 == 1) goto L11;
            if (r1 != 2) goto L10;
            long r2 = this.f30810a;
            o.a(r10);     // Catch: Throwable -> L37
        L34:
            long r5 = r2;
        L35:
            Loog.INSTANCE.i(c.TAG, "syncFrameworkDisabledApps cost " + (System.currentTimeMillis() - r5));     // Catch: Throwable -> L37
        L40:
            return d.x.f38692a;
        L10:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L11:
            long r3 = this.f30810a;
            o.a(r10);     // Catch: Throwable -> L37
        L24:
            r5 = r3;
        L25:
            this.f30812c.k().a(null);     // Catch: Throwable -> L37
            goto L35
        L14:
            o.a(r10);
            r5 = System.currentTimeMillis();     // Catch: Throwable -> L37
            if (this.f30812c.k().b() == null) goto L26;
            com.obric.autogui.session.d.f r11 = this.f30812c.k().b();     // Catch: Throwable -> L37
            if (r11 == null) goto L25;
            d.c.d r6 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L37
            this.f30810a = r5;     // Catch: Throwable -> L37
            this.f30811b = 1;     // Catch: Throwable -> L37
            if (r11.a(r6) != r0) goto L23;
            return r0;
        L23:
            r3 = r5;
            goto L24
        L26:
            com.obric.autogui.agents.vlm.models.impl.applist.black.g r12 = com.obric.autogui.agents.vlm.models.impl.applist.black.g.f27362a;     // Catch: Throwable -> L37
            Context r7 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AOHostAppTools.INSTANCE.getAppContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L37
            if (this.f30813d == false) goto L30;
            r4 = false;
        L30:
            d.c.d<? super d.x> r8 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L37
            this.f30810a = r5;     // Catch: Throwable -> L37
            this.f30811b = 2;     // Catch: Throwable -> L37
            if (r12.a(r7, r4, r8) != r0) goto L33;
            return r0;
        L33:
            r2 = r5;
        L37:
            th = move-exception;
            Loog.INSTANCE.e(c.TAG, "[BL-Sync] failed before step #" + this.f30814e + ": e=" + th, th);
            goto L40
        }
    }

    /* JADX INFO: compiled from: SessionManager.kt */
    @d.c.b.a.f(b = "SessionManager.kt", c = {259, 269}, d = "runSession", e = "com.obric.autogui.session.SessionManager")
    static final class h extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f30815a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f30816b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        int f30817c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        /* synthetic */ Object f30818d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ c f30819e;
        int f;

        h(c r3, d.c.d<? super h> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f30819e = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f30818d = r3;
            this.f |= Integer.MIN_VALUE;
            return c.a(this.f30819e, null, false, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: SessionManager.kt */
    @d.c.b.a.f(b = "SessionManager.kt", c = {126}, d = "invokeSuspend", e = "com.obric.autogui.session.SessionManager$scheduleNextSession$1")
    static final class i extends l implements m<am, d.c.d<? super d.x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f30820a;

        i(d.c.d<? super i> r3) {
            super(2, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        public final Object a(am r3, d.c.d<? super d.x> r4) {
            return ((i) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), i.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<d.x> create(Object r1, d.c.d<?> r2) {
            return (d.c.d) ZeusTransformUtils.preCheckCast(new i((d.c.d) ZeusTransformUtils.wrapperContextForParams(r2, d.c.d.class, "com.obric.aiagent.plugin")), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super d.x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r8) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f30820a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            o.a(r8);
        L34:
            c.a(c.f30777a);
            return d.x.f38692a;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            o.a(r8);
            c r9 = c.f30777a;
            monitor-enter(r9);
            com.obric.autogui.session.a r3 = null;
            if (c.e() == null) goto L13;
        L20:
            Loog r2 = Loog.INSTANCE;     // Catch: Throwable -> L36
            StringBuilder r5 = new StringBuilder().append("scheduleNextSession failed: session running or being released; ongoing=");     // Catch: Throwable -> L36
            com.obric.autogui.session.a r6 = c.e();     // Catch: Throwable -> L36
            if (r6 == null) goto L23;
            String r7 = r6.a();     // Catch: Throwable -> L36
        L24:
            StringBuilder r10 = r5.append(r7).append(", forceReleasing=");     // Catch: Throwable -> L36
            com.obric.autogui.session.a r11 = c.f();     // Catch: Throwable -> L36
            if (r11 == null) goto L27;
            String r12 = r11.a();     // Catch: Throwable -> L36
        L28:
            r2.i(c.TAG, r10.append(r12).toString());     // Catch: Throwable -> L36
        L29:
            monitor-exit(r9);
            if (r3 == null) goto L34;
            AOAgentRobotsTools.INSTANCE.startRobotsSessionAsync((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r3.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"));
            Loog.INSTANCE.i(c.TAG, "scheduleNextSession success: try to launch this session " + r3.a());
            c r13 = c.f30777a;
            d.c.d r4 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f30820a = 1;
            if (c.a(r13, r3, r4) != r0) goto L34;
            return r0;
        L27:
            r12 = null;
            goto L28
        L23:
            r7 = null;
            goto L24
        L13:
            if (c.f() != null) goto L20;
            r3 = (com.obric.autogui.session.a) ZeusTransformUtils.preCheckCast(p.f(c.g()), com.obric.autogui.session.a.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L36
            if (r3 != null) goto L19;
            Loog.INSTANCE.i(c.TAG, "scheduleNextSession failed: no session in queue");     // Catch: Throwable -> L36
            d.x r14 = d.x.f38692a;     // Catch: Throwable -> L36
            monitor-exit(r9);
            return r14;
        L19:
            c r15 = c.f30777a;     // Catch: Throwable -> L36
            c.c(r3);     // Catch: Throwable -> L36
        L36:
            th = move-exception;
            throw th;
        }
    }

    /* JADX INFO: compiled from: SessionManager.kt */
    @d.c.b.a.f(b = "SessionManager.kt", c = {220}, d = "invokeSuspend", e = "com.obric.autogui.session.SessionManager$scheduleSession$1")
    static final class j extends l implements d.h.a.b<d.c.d<? super d.x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f30821a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ com.obric.autogui.session.a f30822b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ boolean f30823c;

        j(com.obric.autogui.session.a r3, boolean r4, d.c.d<? super j> r5) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            this.f30822b = r3;
            this.f30823c = r4;
            super(1, r6);
        }

        public final Object a(d.c.d<? super d.x> r3) {
            return ((j) ZeusTransformUtils.preCheckCast(create((d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin")), j.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<d.x> create(d.c.d<?> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new j(this.f30822b, this.f30823c, r5), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.b
        public /* synthetic */ Object invoke(d.c.d<? super d.x> r3) {
            return a((d.c.d) ZeusTransformUtils.preCheckCast(r3, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r7) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f30821a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            o.a(r7);
        L11:
            Loog.INSTANCE.d(c.TAG, "the current-running loop is completed.");
            return d.x.f38692a;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            o.a(r7);
            c r8 = c.f30777a;
            com.obric.autogui.session.a r2 = this.f30822b;
            boolean r3 = this.f30823c;
            d.c.d r4 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f30821a = 1;
            if (c.a(r8, r2, r3, r4) != r0) goto L11;
            return r0;
        }
    }

    /* JADX INFO: compiled from: SessionManager.kt */
    @d.c.b.a.f(b = "SessionManager.kt", c = {750}, d = "voidSessionIfCurrent", e = "com.obric.autogui.session.SessionManager")
    static final class k extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f30824a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f30825b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        /* synthetic */ Object f30826c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ c f30827d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        int f30828e;

        k(c r3, d.c.d<? super k> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f30827d = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f30826c = r3;
            this.f30828e |= Integer.MIN_VALUE;
            return this.f30827d.a(null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    public static /* synthetic */ d.x lambda$CxcmEqoj4JOlUp9Ak3gp5JLeCMo(r r0) {
        return a(r0);
    }

    public static /* synthetic */ boolean lambda$FcyiC2LrXGOajydyMPUnwU4vqHM(String r0, com.obric.autogui.session.a r1) {
        return b(r0, r1);
    }

    public static /* synthetic */ boolean lambda$Jut2DFW4uNhgAmY71BZxOgk7QuM(String r0, com.obric.autogui.session.a r1) {
        return a(r0, r1);
    }

    /* JADX INFO: renamed from: lambda$SjmRxf--lIDWc5En1S44KdOlwXg, reason: not valid java name */
    public static /* synthetic */ boolean m883lambda$SjmRxflIDWc5En1S44KdOlwXg(d.h.a.b r0, Object r1) {
        return a(r0, r1);
    }

    public static /* synthetic */ boolean lambda$hfQl0qOKEoeIdv5j6x58rQY2dYU(d.h.a.b r0, Object r1) {
        return b(r0, r1);
    }

    public static /* synthetic */ d.x lambda$oB_t2ShRaw6YMee9pXyxd8dlgGc(int r0, com.obric.autogui.operator.e.c r1) {
        return a(r0, r1);
    }

    private c() {
    }

    public static final /* synthetic */ int a(c r0, com.obric.autogui.session.a r1) {
        return r0.d(r1);
    }

    public static final /* synthetic */ Object a(c r2, com.obric.autogui.session.a r3, d.c.d r4) {
        return r2.b(r3, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    public static final /* synthetic */ Object a(c r2, com.obric.autogui.session.a r3, boolean r4, d.c.d r5) {
        return r2.a(r3, r4, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    public static final /* synthetic */ void a(c r0) {
        r0.h();
    }

    public static final /* synthetic */ Object b(c r2, com.obric.autogui.session.a r3, d.c.d r4) {
        return r2.c(r3, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    public static final /* synthetic */ Object c(c r2, com.obric.autogui.session.a r3, d.c.d r4) {
        return r2.d(r3, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    public static final /* synthetic */ void c(com.obric.autogui.session.a r0) {
        f30780d = r0;
    }

    public static final /* synthetic */ com.obric.autogui.session.a e() {
        return f30780d;
    }

    public static final /* synthetic */ com.obric.autogui.session.a f() {
        return f30781e;
    }

    public static final /* synthetic */ List g() {
        return g;
    }

    static {
        f30777a = new c();
        f30778b = kotlinx.coroutines.b.am.a(p.b());
        f30779c = new com.obric.autogui.operator.a.a();
        g = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.aiagent.plugin");
    }

    public final boolean a() {
        if (f30780d == null) goto L5;
        return true;
    L5:
        return false;
    }

    public final com.obric.autogui.session.a b() {
        return f30780d;
    }

    public final IAutoActionAgentEventListener.SessionInfo c() {
        return f;
    }

    public final void d() {
        AOThreadingTools.INSTANCE.launchIO((m) ZeusTransformUtils.preCheckCast(new i(null), m.class, "com.obric.aiagent.plugin"));
    }

    public final com.obric.autogui.common.e a(com.obric.autogui.session.a r7) {
        d.h.b.o.e(r7, SensitiveType.SESSION);
        monitor-enter(this);
        List<com.obric.autogui.session.a> r0 = g;     // Catch: Throwable -> L23
        if (r0.contains(r7) == false) goto L10;
        Loog.INSTANCE.e(TAG, "session is already in queue. " + r7.b());     // Catch: Throwable -> L23
        com.obric.autogui.common.e r8 = com.obric.autogui.common.e.a.a(com.obric.autogui.common.e.f29014b, ZeusTransformUtils.mapRes(R.string.agent_internal_error, WsChannelMultiProcessSharedProvider.STRING_TYPE, "agent_internal_error"), null, 2, null);     // Catch: Throwable -> L23
        monitor-exit(this);
        return r8;
    L10:
        if (d.h.b.o.a(f30780d, r7) == false) goto L14;
        Loog.INSTANCE.e(TAG, "session is already running. " + r7.a());     // Catch: Throwable -> L23
        com.obric.autogui.common.e r9 = com.obric.autogui.common.e.a.a(com.obric.autogui.common.e.f29014b, ZeusTransformUtils.mapRes(R.string.agent_internal_error, WsChannelMultiProcessSharedProvider.STRING_TYPE, "agent_internal_error"), null, 2, null);     // Catch: Throwable -> L23
        monitor-exit(this);
        return r9;
    L14:
        r0.add(r7);     // Catch: Throwable -> L23
        Loog r1 = Loog.INSTANCE;     // Catch: Throwable -> L23
        StringBuilder r10 = new StringBuilder().append("enqueued session ").append(r7.a()).append(", onGoingSession=");     // Catch: Throwable -> L23
        com.obric.autogui.session.a r3 = f30780d;     // Catch: Throwable -> L23
        if (r3 == null) goto L18;
        String r4 = r3.a();     // Catch: Throwable -> L23
        if (r4 == null) goto L18;
    L19:
        r1.i(TAG, r10.append(r4).append(",  queuesize=").append(r0.size()).append(' ').toString());     // Catch: Throwable -> L23
        f30777a.h();     // Catch: Throwable -> L23
        d.x r11 = d.x.f38692a;     // Catch: Throwable -> L23
        monitor-exit(this);
        return com.obric.autogui.common.e.f29014b.a();
    L18:
        r4 = "null";
    L23:
        th = move-exception;
        throw th;
    }

    private final Object b(com.obric.autogui.session.a r7, d.c.d<? super com.obric.autogui.common.e> r8) {
        d.c.d r9 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r8, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r9, d.class) == false) goto L7;
        d r0 = (d) ZeusTransformUtils.preCheckCast(r9, d.class, "com.obric.aiagent.plugin");
        if ((r0.f30800e & Integer.MIN_VALUE) == 0) goto L7;
        r0.f30800e -= Integer.MIN_VALUE;
    L8:
        Object r10 = r0.f30798c;
        Object r1 = d.c.a.b.a();
        int r2 = r0.f30800e;
        boolean r3 = true;
        if (r2 == 0) goto L14;
        if (r2 != 1) goto L13;
        r7 = (com.obric.autogui.session.a) ZeusTransformUtils.preCheckCast(r0.f30797b, com.obric.autogui.session.a.class, "com.obric.aiagent.plugin");
        c this = (c) ZeusTransformUtils.preCheckCast(r0.f30796a, c.class, "com.obric.aiagent.plugin");
        o.a(r10);
    L17:
        com.obric.autogui.common.e r11 = (com.obric.autogui.common.e) ZeusTransformUtils.preCheckCast(r10, com.obric.autogui.common.e.class, "com.obric.aiagent.plugin");
        if (r11.g() == true) goto L37;
        Loog.INSTANCE.e(TAG, "launch session failed at entering preparing state.");
        AOUserInterfaceTools.INSTANCE.showAppToast((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r7.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast(r11.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r7.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).toString(), CharSequence.class, "com.obric.aiagent.plugin"));
        monitor-enter(this);
        String r4 = null;
        if (f30780d != r7) goto L25;
        f30780d = null;     // Catch: Throwable -> L34
    L26:
        monitor-exit(this);
        if (r3 == false) goto L29;
        this.f(r7);
    L33:
        this.d();
        goto L37
    L29:
        Loog r5 = Loog.INSTANCE;
        StringBuilder r6 = new StringBuilder().append("skip clearing failed preparing session, ongoing=");
        com.obric.autogui.session.a r12 = f30780d;
        if (r12 == null) goto L32;
        r4 = r12.a();
    L32:
        r5.w(TAG, r6.append(r4).append(", expected=").append(r7.a()).toString());
        goto L33
    L25:
        r3 = false;
    L34:
        th = move-exception;
        throw th;
    L37:
        return r11;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        o.a(r10);
        com.obric.autogui.session.state.b r13 = r7.m();
        BizStatus r14 = BizStatus.PREPARING;
        BizStatus.StatusChangedReasonStruct r15 = BizStatus.StatusChangedReasonStruct.Companion.getDEFAULT();
        r0.f30796a = this;
        r0.f30797b = r7;
        r0.f30800e = 1;
        r10 = r13.a(r14, r15, r0);
        if (r10 != r1) goto L17;
        return r1;
    L7:
        r0 = new d(this, r9);
        goto L8
    }

    public final com.obric.autogui.common.e a(com.obric.autogui.session.a r6, boolean r7) {
        d.h.b.o.e(r6, SensitiveType.SESSION);
        if (d.h.b.o.a(f30780d, r6) == true) goto L7;
        Loog.INSTANCE.e(TAG, "cannot schedule a session that is not ongoing.");
        return com.obric.autogui.common.e.a.a(com.obric.autogui.common.e.f29014b, ZeusTransformUtils.mapRes(R.string.agent_internal_error, WsChannelMultiProcessSharedProvider.STRING_TYPE, "agent_internal_error"), null, 2, null);
    L7:
        if (r6.f() != 0) goto L10;
        r6.a(AOSystemTools.INSTANCE.bootTimeMillis());
    L10:
        if (r7 == true) goto L14;
        AOAgentRobotsTools.INSTANCE.logTopActivityPolicyAsync((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r6.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), "session_start");
        if (r6.c() == false) goto L14;
        com.obric.autogui.agents.vlm.models.omni.upload.a.b.f28535a.a(r6.b());
    L14:
        r6.a(r6.h().launch((d.h.a.b) ZeusTransformUtils.preCheckCast(new j(r6, r7, null), d.h.a.b.class, "com.obric.aiagent.plugin")));
        return com.obric.autogui.common.e.f29014b.a();
    }

    public final void b(com.obric.autogui.session.a r5) {
        d.h.b.o.e(r5, SensitiveType.SESSION);
        if (d.h.b.o.a(f30780d, r5) == true) goto L6;
        Loog.INSTANCE.e(TAG, "cannot relaunch a session that is not ongoing.");
        return;
    L6:
        com.obric.autogui.session.state.termination.a r0 = r5.J();
        if (r0.a() == false) goto L9;
    L15:
        Loog.INSTANCE.e(TAG, "cannot relaunch a session that is terminated or ongoing a termination.");
        return;
    L9:
        if (r0.d() == true) goto L15;
        if (r5.i() == null) goto L17;
        r5.j();
        Loog.INSTANCE.i(TAG, "relaunching the current session: " + r5);
        a(r5, true);
        return;
    }

    private final Object a(com.obric.autogui.session.a r21, boolean r22, d.c.d<? super d.x> r23) {
        c r0 = this;
        com.obric.autogui.session.a r1 = r21;
        d.c.d r2 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r23, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r2, h.class) == false) goto L7;
        h r4 = (h) ZeusTransformUtils.preCheckCast(r2, h.class, "com.obric.aiagent.plugin");
        if ((r4.f & Integer.MIN_VALUE) == 0) goto L7;
        r4.f -= Integer.MIN_VALUE;
    L8:
        Object r3 = r4.f30818d;
        Object r5 = d.c.a.b.a();
        int r6 = r4.f;
        if (r6 == 0) goto L20;
        if (r6 == 1) goto L19;
        if (r6 != 2) goto L18;
        int r7 = r4.f30817c;
        com.obric.autogui.session.a r8 = (com.obric.autogui.session.a) ZeusTransformUtils.preCheckCast(r4.f30815a, com.obric.autogui.session.a.class, "com.obric.aiagent.plugin");
        o.a(r3);     // Catch: Throwable -> L15 CancellationException -> L39
    L37:
        r8.O().b("ses_loop", "round", r7);
        return d.x.f38692a;
    L15:
        th = th;
    L34:
        Loog.INSTANCE.e(TAG, "unexpected exception in session loop (#" + r7 + "): " + th, th);
        com.obric.autogui.session.state.termination.a.a(r8.J(), com.obric.autogui.common.e.f29014b.a(ZeusTransformUtils.mapRes(R.string.agent_internal_error, WsChannelMultiProcessSharedProvider.STRING_TYPE, "agent_internal_error"), "runSession error: " + th), 100001, null, null, 12, null);
    L36:
        Loog.INSTANCE.e(TAG, " - session loop cancelled (#" + r7 + ").");
        goto L37
    L18:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L19:
        com.obric.autogui.session.a r9 = (com.obric.autogui.session.a) ZeusTransformUtils.preCheckCast(r4.f30816b, com.obric.autogui.session.a.class, "com.obric.aiagent.plugin");
        c r10 = (c) ZeusTransformUtils.preCheckCast(r4.f30815a, c.class, "com.obric.aiagent.plugin");
        o.a(r3);
        r1 = r9;
        r0 = r10;
    L25:
        com.obric.autogui.session.c.a.b(r1.O(), "ses_prepare", "coldstart", 0, 4, null);
    L27:
        int r11 = r1.N().getAndIncrement();
        Loog.INSTANCE.i(TAG, "started session loop (#" + r11 + ").");
        r1.O().a("ses_loop", "round", r11);     // Catch: Throwable -> L32 CancellationException -> L35
        r4.f30815a = r1;     // Catch: Throwable -> L32 CancellationException -> L35
        r4.f30816b = null;     // Catch: Throwable -> L32 CancellationException -> L35
        r4.f30817c = r11;     // Catch: Throwable -> L32 CancellationException -> L35
        r4.f = 2;     // Catch: Throwable -> L32 CancellationException -> L35
        if (r0.c(r1, r4) != r5) goto L31;
        return r5;
    L31:
        r8 = r1;
        r7 = r11;
        goto L37
    L35:
        r8 = r1;
        r7 = r11;
    L32:
        th = th;
        r8 = r1;
        r7 = r11;
        goto L34
    L20:
        o.a(r3);
        if (r22 == true) goto L26;
        com.obric.autogui.operator.a.a r12 = f30779c;
        Context r13 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r21.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        r4.f30815a = r0;
        r4.f30816b = r1;
        r4.f = 1;
        if (r12.a(r13, r4) != r5) goto L25;
        return r5;
    L26:
        Object r14 = r1.a(com.obric.autogui.agents.b.f26789a.a());
        d.h.b.o.a(r14, "null cannot be cast to non-null type com.obric.autogui.agents.vlm.VlmAgent.MyVlmSessionExt");
        ((com.obric.autogui.agents.vlm.b.C0677b) ZeusTransformUtils.preCheckCast(r14, com.obric.autogui.agents.vlm.b.C0677b.class, "com.obric.aiagent.plugin")).b(true);
    L7:
        r4 = new h(r0, r2);
        goto L8
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:186:0x0cf5 -> B:187:0x0cfd). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:188:0x0d10 -> B:189:0x0d1e). Please report as a decompilation issue!!! */
    private final Object c(com.obric.autogui.session.a r44, d.c.d<? super Integer> r45) {
        String r2 = "com.obric.aiagent.plugin";
        d.c.d r1 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r45, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r1, e.class) == false) goto L7;
        e r3 = (e) ZeusTransformUtils.preCheckCast(r1, e.class, "com.obric.aiagent.plugin");
        if ((r3.p & Integer.MIN_VALUE) == 0) goto L7;
        r3.p -= Integer.MIN_VALUE;
        c r4 = this;
    L8:
        Object r5 = r3.n;
        Object r6 = d.c.a.b.a();
        int r7 = r3.p;
        String r8 = "; reason=";
        String r11 = TAG;
        switch(r7) {
            case 0: goto L21;
            case 1: goto L20;
            case 2: goto L19;
            case 3: goto L18;
            case 4: goto L17;
            case 5: goto L16;
            case 6: goto L15;
            case 7: goto L14;
            case 8: goto L13;
            case 9: goto L12;
            default: goto L11;
        };
    L12:
        int r9 = r3.k;
        long r12 = r3.l;
        int r10 = r3.j;
        int r14 = r3.i;
        com.obric.autogui.operator.g.e r13 = (com.obric.autogui.operator.g.e) ZeusTransformUtils.preCheckCast(r3.g, com.obric.autogui.operator.g.e.class, "com.obric.aiagent.plugin");
        com.obric.autogui.operator.g r15 = (com.obric.autogui.operator.g) ZeusTransformUtils.preCheckCast(r3.f, com.obric.autogui.operator.g.class, "com.obric.aiagent.plugin");
        com.obric.autogui.session.c.a r16 = (com.obric.autogui.session.c.a) ZeusTransformUtils.preCheckCast(r3.f30805e, com.obric.autogui.session.c.a.class, "com.obric.aiagent.plugin");
        com.obric.autogui.operator.e r17 = (com.obric.autogui.operator.e) ZeusTransformUtils.preCheckCast(r3.f30804d, com.obric.autogui.operator.e.class, "com.obric.aiagent.plugin");
        com.obric.autogui.operator.j r18 = (com.obric.autogui.operator.j) ZeusTransformUtils.preCheckCast(r3.f30803c, com.obric.autogui.operator.j.class, "com.obric.aiagent.plugin");
        com.obric.autogui.session.a r19 = (com.obric.autogui.session.a) ZeusTransformUtils.preCheckCast(r3.f30802b, com.obric.autogui.session.a.class, "com.obric.aiagent.plugin");
        c r0 = (c) ZeusTransformUtils.preCheckCast(r3.f30801a, c.class, "com.obric.aiagent.plugin");
        o.a(r5);
        String r28 = "com.obric.aiagent.plugin";
        com.obric.autogui.session.a r20 = r19;
        String r27 = "; reason=";
        String r24 = TAG;
        int r21 = r14;
        com.obric.autogui.operator.e r22 = r17;
        long r110 = r12;
        com.obric.autogui.operator.g.e r111 = r13;
        final int r23 = r9;
    L187:
        String r112 = r28;
        com.obric.autogui.session.a.d r25 = (com.obric.autogui.session.a.d) ZeusTransformUtils.preCheckCast(r5, com.obric.autogui.session.a.d.class, r112);
        int r26 = r21;
        com.obric.autogui.session.c.a r29 = r16;
        String r113 = r112;
        com.obric.autogui.operator.j r30 = r18;
        com.obric.autogui.operator.e r114 = r22;
        r4 = r0;
        com.obric.autogui.session.a r31 = r20;
    L189:
        int r43 = r26;
        e r210 = r3;
        com.obric.autogui.agents.vlm.models.omni.b.e.f28225a.b(r31.b(), com.obric.autogui.agents.vlm.models.omni.b.c.g);
        if (r29 == null) goto L192;
        com.obric.autogui.session.c.a.b(r29, "stp_finalise", "journal", 0, 4, null);
        d.x r32 = d.x.f38692a;
    L192:
        com.obric.autogui.agents.vlm.models.omni.b.e.f28225a.a(r31.b(), com.obric.autogui.agents.vlm.models.omni.b.f.f28228c);
        r114.D().c(AOSystemTools.INSTANCE.bootTimeMillis() - r110);
        if (r29 == null) goto L195;
        EndStepParams r115 = null;
        r29.a((m) ZeusTransformUtils.preCheckCast(new f(r31, r114, null), m.class, r113));
        d.x r33 = d.x.f38692a;
    L197:
        if (r31.K() == true) goto L199;
        String r116 = r24;
        Loog.INSTANCE.i(r116, "[step-exec] paused/terminated after executing at step #" + r23);
        Loog.INSTANCE.i(r116, " - paused=" + r31.M());
    L205:
        int r34 = r43;
        com.obric.autogui.session.a r35 = r31;
        String r117 = r113;
    L209:
        if (r10 == 0) goto L216;
        com.obric.autogui.session.state.termination.a r118 = r35.J();
        if (ZeusTransformUtils.instanceOf(r30, com.obric.autogui.agents.vlm.models.impl.j.class) == false) goto L213;
        EndStepParams r119 = new EndStepParams(((com.obric.autogui.agents.vlm.models.impl.j) ZeusTransformUtils.preCheckCast(r30, com.obric.autogui.agents.vlm.models.impl.j.class, r117)).z(), ((com.obric.autogui.agents.vlm.models.impl.j) ZeusTransformUtils.preCheckCast(r30, com.obric.autogui.agents.vlm.models.impl.j.class, r117)).F(), ((com.obric.autogui.agents.vlm.models.impl.j) ZeusTransformUtils.preCheckCast(r30, com.obric.autogui.agents.vlm.models.impl.j.class, r117)).E());
    L214:
        com.obric.autogui.session.state.termination.a.a(r118, null, 0, r119, null, 8, null);
        goto L216
    L213:
        r119 = r115;
    L216:
        return d.c.b.a.b.a(r34);
    L199:
        String r120 = r24;
        if (r10 == 0) goto L203;
        Loog.INSTANCE.i(r120, "[step-exec] endStep at step #" + r23);
        goto L205
    L203:
        if (r111 != com.obric.autogui.operator.g.e.f29930c) goto L206;
        String r36 = r27;
        com.obric.autogui.session.state.termination.a.a(r31.J(), com.obric.autogui.common.e.f29014b.b("early-terminated at step #" + r23 + r36 + r15), 100001, null, null, 12, null);
        Loog.INSTANCE.e(r120, "[step-exec] early-terminated at step #" + r23 + r36 + r15);
        goto L205
    L206:
        r34 = r43;
        r2 = r113;
        r11 = r120;
        r3 = r210;
        r8 = r27;
    L23:
        if (r31.K() == false) goto L208;
        long r37 = AOSystemTools.INSTANCE.bootTimeMillis();
        r31.F().put("KEY_PLATFORM_EXTRA_STEP_STARTED_AT", d.c.b.a.b.a(r37));
        r31.a(r31.s() + 1);
        int r121 = r31.s();
        com.obric.autogui.agents.a r122 = com.obric.autogui.agents.b.f26789a.a();
        com.obric.autogui.session.functions.c r123 = r31.n();
        if (r123.a(com.obric.autogui.session.functions.impl.a.a.class) == null) goto L27;
    L30:
        boolean r124 = true;
    L31:
        String r211 = r8;
        Object r46 = r6;
        AOThreadingTools.LaunchedJob r38 = AOThreadingTools.INSTANCE.launchIOJob((m) ZeusTransformUtils.preCheckCast(new g(r31, r124, r121, null), m.class, r2));
        com.obric.autogui.operator.e r39 = (com.obric.autogui.operator.e) ZeusTransformUtils.preCheckCast(p.n(r31.p()), com.obric.autogui.operator.e.class, r2);
        z.a r125 = new z.a();
        if (r39 == null) goto L37;
        com.obric.autogui.operator.e.c r126 = r39.U();
        if (r126 == null) goto L37;
        r125.f38499a = r126.b();
        d.x r127 = d.x.f38692a;
    L37:
        if (r125.f38499a == false) goto L46;
        String r212 = r2;
        Loog.INSTANCE.i(r11, " - [step-RETRY] step #" + r121 + "; retrying=" + r39);
        if (r39 == null) goto L41;
        String r40 = r39.W();
    L42:
        r31.b(r40);
        if (r39 == null) goto L45;
        r39.a(new com.obric.autogui.session.c.a());
        d.x r41 = d.x.f38692a;
    L45:
        com.obric.autogui.common.e r42 = com.obric.autogui.common.e.f29014b.a();
        d.x r47 = d.x.f38692a;
        r35 = r31;
        c r48 = r4;
        int r128 = r10;
        com.obric.autogui.operator.j r129 = r30;
        com.obric.autogui.agents.a r49 = r122;
        r117 = r212;
        r34 = r34;
        com.obric.autogui.common.e r50 = r42;
        AOThreadingTools.LaunchedJob r51 = r38;
        long r213 = r37;
        Object r52 = r46;
    L69:
        if (r50.g() == false) goto L207;
        if (r39 == null) goto L207;
        int r410 = r128;
        if (ZeusTransformUtils.instanceOf(r39, com.obric.autogui.operator.j.class) == false) goto L76;
        r35.J().a(true);
        com.obric.autogui.operator.j r53 = (com.obric.autogui.operator.j) ZeusTransformUtils.preCheckCast(r39, com.obric.autogui.operator.j.class, r117);
        Loog.INSTANCE.i(r11, "[step-fetch] reaches end-step at step #" + r121);
        com.obric.autogui.operator.j r54 = r53;
        int r55 = 1;
    L80:
        int r130 = r55;
        if (r35.K() == true) goto L85;
        Loog.INSTANCE.i(r11, "[step-exec] paused/terminated before executing step #" + r121);
        Loog.INSTANCE.i(r11, " - [paused=" + r35.M() + ']');
        Loog.INSTANCE.i(r11, " - [ignored] generated step #" + r121 + " (" + r39.k_() + ").");
    L83:
        r30 = r54;
    L78:
        r10 = 0;
    L56:
        r115 = null;
        goto L209
    L85:
        if (r35.c() == false) goto L87;
    L96:
        int r214 = r121;
    L97:
        com.obric.autogui.agents.vlm.models.omni.b.e.f28225a.a(r35.b(), com.obric.autogui.agents.vlm.models.omni.b.c.f28219a);
        com.obric.autogui.session.d.m r56 = r35.k().c();
        if (r56 == null) goto L105;
        r3.f30801a = r48;
        r3.f30802b = r35;
        r3.f30803c = r54;
        r3.f30804d = r49;
        r3.f30805e = r51;
        r3.f = r125;
        r3.g = r39;
        r3.h = null;
        r3.i = r34;
        r3.j = r130;
        c r131 = r48;
        r30 = r54;
        r3.l = r213;
        int r132 = r214;
        r3.k = r132;
        r3.p = 3;
        r5 = r56.a(r3);
        Object r57 = r52;
        if (r5 != r57) goto L102;
        return r57;
    L102:
        c r58 = r131;
        int r133 = r132;
        int r134 = r34;
        z.a r135 = r125;
        AOThreadingTools.LaunchedJob r136 = r51;
        com.obric.autogui.operator.e r137 = r39;
        int r59 = r130;
        r6 = r57;
        com.obric.autogui.agents.a r60 = r49;
        com.obric.autogui.session.a r61 = r35;
    L103:
        com.obric.autogui.common.e r138 = (com.obric.autogui.common.e) ZeusTransformUtils.preCheckCast(r5, com.obric.autogui.common.e.class, r117);
        Object r62 = r6;
        int r63 = r59;
        r34 = r134;
        String r215 = r117;
        r23 = r133;
        c r139 = r58;
        com.obric.autogui.agents.a r64 = r60;
        com.obric.autogui.session.a r65 = r61;
    L104:
        e r66 = r3;
        long r67 = r213;
        Object r140 = r62;
        com.obric.autogui.agents.vlm.models.omni.b.e.f28225a.b(r65.b(), com.obric.autogui.agents.vlm.models.omni.b.c.f28219a);
        if (r138 != null) goto L109;
    L111:
        String r141 = r211;
        com.obric.autogui.session.c.a r68 = r137.X();
        if (r68 == null) goto L114;
        com.obric.autogui.session.c.a.a(r68, "stp_exec", "all", 0, 4, null);
        d.x r69 = d.x.f38692a;
    L114:
        if (r68 == null) goto L116;
        com.obric.autogui.session.c.a.a(r68, "stp_exec", "bl_sync_join", 0, 4, null);
        d.x r70 = d.x.f38692a;
    L116:
        r27 = r141;
        com.obric.autogui.agents.vlm.models.omni.b.e.f28225a.a(r65.b(), com.obric.autogui.agents.vlm.models.omni.b.c.f28220b);
        ca r71 = r136.getJob();
        r66.f30801a = r139;
        r66.f30802b = r65;
        r66.f30803c = r30;
        r66.f30804d = r64;
        r66.f30805e = r135;
        r66.f = r137;
        r66.g = r68;
        r66.h = null;
        r66.i = r34;
        r66.j = r63;
        long r142 = r67;
        r66.l = r142;
        r66.k = r23;
        r66.p = 4;
        if (r71.b(r66) != r140) goto L119;
        return r140;
    L119:
        r3 = r66;
        com.obric.autogui.session.a r72 = r65;
        c r73 = r139;
        int r143 = r34;
        int r74 = r63;
        r6 = r140;
        com.obric.autogui.operator.e r411 = r137;
        com.obric.autogui.session.c.a r144 = r68;
        z.a r75 = r135;
        r114 = r411;
    L120:
        r24 = r11;
        Object r216 = r6;
        com.obric.autogui.agents.vlm.models.omni.b.e.f28225a.b(r72.b(), com.obric.autogui.agents.vlm.models.omni.b.c.f28220b);
        if (r144 == null) goto L123;
        com.obric.autogui.session.c.a.b(r144, "stp_exec", "bl_sync_join", 0, 4, null);
        d.x r76 = d.x.f38692a;
    L123:
        if (r144 == null) goto L125;
        com.obric.autogui.session.c.a.a(r144, "stp_exec", "prepare", 0, 4, null);
        d.x r77 = d.x.f38692a;
    L125:
        com.obric.autogui.agents.vlm.models.omni.b.e.f28225a.a(r72.b(), com.obric.autogui.agents.vlm.models.omni.b.c.f28221c);
        r3.f30801a = r73;
        r3.f30802b = r72;
        r3.f30803c = r30;
        r3.f30804d = r64;
        r3.f30805e = r75;
        r3.f = r114;
        r3.g = r144;
        r3.i = r143;
        r3.j = r74;
        r3.l = r142;
        r3.k = r23;
        r3.p = 5;
        if (r114.b(r72, r3) != r216) goto L128;
        return r216;
    L128:
        r6 = r216;
    L129:
        Object r217 = r6;
        com.obric.autogui.agents.vlm.models.omni.b.e.f28225a.b(r72.b(), com.obric.autogui.agents.vlm.models.omni.b.c.f28221c);
        if (r144 == null) goto L132;
        com.obric.autogui.session.c.a.b(r144, "stp_exec", "prepare", 0, 4, null);
        d.x r78 = d.x.f38692a;
    L132:
        if (r144 == null) goto L134;
        com.obric.autogui.session.c.a.a(r144, "stp_exec", DBHelper.BATTERY_COL_PROCESS_NAME, 0, 4, null);
        d.x r79 = d.x.f38692a;
    L134:
        long r145 = r142;
        long r146 = AOSystemTools.INSTANCE.nowTimeMillis();
        r3.f30801a = r73;
        r3.f30802b = r72;
        r3.f30803c = r30;
        r3.f30804d = r64;
        r3.f30805e = r75;
        r3.f = r114;
        r3.g = r144;
        r3.i = r143;
        r3.j = r74;
        c r80 = r73;
        int r81 = r74;
        r3.l = r145;
        r3.k = r23;
        r3.m = r146;
        r3.p = 6;
        if (r64.a(r72, r114, r3) != r217) goto L137;
        return r217;
    L137:
        com.obric.autogui.session.c.a r82 = r144;
        long r147 = r145;
        Object r148 = r217;
        c r83 = r80;
    L138:
        com.obric.autogui.agents.vlm.models.omni.b.e.f28225a.a(r72.b(), com.obric.autogui.agents.vlm.models.omni.b.c.f28222d);
        r3.f30801a = r83;
        r3.f30802b = r72;
        r3.f30803c = r30;
        r3.f30804d = r64;
        r3.f30805e = r75;
        r3.f = r114;
        r3.g = r82;
        r3.i = r143;
        r3.j = r81;
        r3.l = r147;
        r3.k = r23;
        long r149 = r146;
        r3.m = r149;
        r3.p = 7;
        Object r84 = r64.b(r72, r114, r3);
        c r150 = r83;
        Object r85 = r148;
        if (r84 != r85) goto L141;
        return r85;
    L141:
        Object r218 = r85;
        com.obric.autogui.agents.a r219 = r64;
        r0 = r150;
        com.obric.autogui.session.c.a r86 = r82;
        r5 = r84;
    L142:
        long r220 = r147;
        String r151 = r215;
        com.obric.autogui.operator.g r87 = (com.obric.autogui.operator.g) ZeusTransformUtils.preCheckCast(r5, com.obric.autogui.operator.g.class, r151);
        int r221 = r81;
        com.obric.autogui.agents.vlm.models.omni.b.e.f28225a.b(r72.b(), com.obric.autogui.agents.vlm.models.omni.b.c.f28222d);
        long r88 = AOSystemTools.INSTANCE.nowTimeMillis();
        if (r86 == null) goto L145;
        com.obric.autogui.session.c.a.b(r86, "stp_exec", DBHelper.BATTERY_COL_PROCESS_NAME, 0, 4, null);
        d.x r152 = d.x.f38692a;
    L145:
        if (r86 == null) goto L147;
        com.obric.autogui.session.c.a.a(r86, "stp_exec", "finalise", 0, 4, null);
        d.x r153 = d.x.f38692a;
    L147:
        com.obric.autogui.operator.j r310 = r30;
        e r311 = r3;
        com.obric.autogui.agents.vlm.models.omni.b.e.f28225a.a(r72.b(), com.obric.autogui.agents.vlm.models.omni.b.c.f28223e);
        r114.a(r72);
        com.obric.autogui.agents.vlm.models.omni.b.e.f28225a.b(r72.b(), com.obric.autogui.agents.vlm.models.omni.b.c.f28223e);
        if (r86 == null) goto L150;
        com.obric.autogui.session.c.a.b(r86, "stp_exec", "finalise", 0, 4, null);
        d.x r89 = d.x.f38692a;
    L150:
        if (r86 == null) goto L152;
        com.obric.autogui.session.c.a.b(r86, "stp_exec", "all", 0, 4, null);
        d.x r90 = d.x.f38692a;
    L152:
        IAutoActionTrackingApi r312 = (IAutoActionTrackingApi) ZeusTransformUtils.preCheckCast(AOBizTracking.INSTANCE, IAutoActionTrackingApi.class, r151);
        JSONObject r91 = new JSONObject();
        com.obric.autogui.session.c.b.a(r91, r72);
        long r92 = r88 - r149;
        r91.put("step_exec_time", r92);
        r91.put("step_index", r72.s());
        r91.put("step_id", r114.W());
        Iterable r93 = (Iterable) ZeusTransformUtils.preCheckCast(r114.Q(), Iterable.class, r151);
        Collection r154 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(p.a(r93, 10)), Collection.class, r151);
        Iterator r94 = r93.iterator();
    L154:
        if (r94.hasNext() == false) goto L156;
        com.obric.autogui.operator.e.C0780e r155 = (com.obric.autogui.operator.e.C0780e) ZeusTransformUtils.preCheckCast(r94.next(), com.obric.autogui.operator.e.C0780e.class, r151);
        r154.add(r155.a().name() + ' ' + r155.b());
        r94 = r94;
        goto L154
    L156:
        r91.put("operations", (List) ZeusTransformUtils.preCheckCast(r154, List.class, r151));
        com.obric.autogui.agents.vlm.models.a r95 = r114.R();
        if (r95 == null) goto L163;
        r91.put("total_duration", (r95.a() + r95.c()) + r92);
        Iterator<Map.Entry<String, Object>> r96 = r95.d().entrySet().iterator();
    L161:
        if (r96.hasNext() == false) goto L163;
        Map.Entry r97 = (Map.Entry) ZeusTransformUtils.preCheckCast(r96.next(), Map.Entry.class, r151);
        r91.put((String) ZeusTransformUtils.preCheckCast(r97.getKey(), String.class, r151), r97.getValue());
    L163:
        d.x r98 = d.x.f38692a;
        IAutoActionTrackingApi.DefaultImpls.reportEvent$default(r312, "step_exec_done", r91, false, false, null, 28, null);
        if (r86 == null) goto L166;
        com.obric.autogui.session.c.a.a(r86, "stp_finalise", "postprocess", 0, 4, null);
        d.x r99 = d.x.f38692a;
    L166:
        com.obric.autogui.operator.g.e r100 = r87.e();
        if (r100 != com.obric.autogui.operator.g.e.f29928a) goto L169;
        r114.a(new $$Lambda$c$oB_t2ShRaw6YMee9pXyxd8dlgGc(r23));
    L169:
        r114.e(r87.a());
        r114.f(r75.f38499a);
        int r156 = r143 + 1;
        List<com.obric.autogui.operator.e> r101 = r72.p();
        if (ae.e(r101) == false) goto L172;
        r101.add(r114);
    L172:
        r0.a(r72, r114, r87);
        com.obric.autogui.agents.vlm.models.omni.b.e.f28225a.a(r72.b(), com.obric.autogui.agents.vlm.models.omni.b.c.f);
        r311.f30801a = r0;
        r311.f30802b = r72;
        r30 = r310;
        r311.f30803c = r30;
        r311.f30804d = r114;
        r311.f30805e = r86;
        r311.f = r100;
        r311.g = null;
        r311.i = r156;
        r311.j = r221;
        r110 = r220;
        r311.l = r110;
        r311.k = r23;
        r311.p = 8;
        r5 = r219.a(r72, r114, r87, r311);
        Object r157 = r218;
        if (r5 != r157) goto L175;
        return r157;
    L175:
        r111 = r100;
        r3 = r311;
        r10 = r221;
        r29 = r86;
        r6 = r157;
    L176:
        com.obric.autogui.operator.g r102 = (com.obric.autogui.operator.g) ZeusTransformUtils.preCheckCast(r5, com.obric.autogui.operator.g.class, r151);
        r28 = r151;
        Object r222 = r6;
        com.obric.autogui.agents.vlm.models.omni.b.e.f28225a.b(r72.b(), com.obric.autogui.agents.vlm.models.omni.b.c.f);
        if (r29 == null) goto L179;
        com.obric.autogui.session.c.a.b(r29, "stp_finalise", "postprocess", 0, 4, null);
        d.x r103 = d.x.f38692a;
    L179:
        if (r29 == null) goto L181;
        com.obric.autogui.session.c.a.a(r29, "stp_finalise", "journal", 0, 4, null);
        d.x r104 = d.x.f38692a;
    L181:
        com.obric.autogui.agents.vlm.models.omni.b.e.f28225a.a(r72.b(), com.obric.autogui.agents.vlm.models.omni.b.c.g);
        com.obric.autogui.session.a.d r105 = r72.A();
        if (r105 == null) goto L188;
        r3.f30801a = r0;
        r3.f30802b = r72;
        r3.f30803c = r30;
        r3.f30804d = r114;
        r3.f30805e = r29;
        r3.f = r102;
        r3.g = r111;
        r3.i = r156;
        r3.j = r10;
        r3.l = r110;
        r3.k = r23;
        r3.p = 9;
        Object r106 = r105.a(r3);
        r6 = r222;
        if (r106 != r6) goto L186;
        return r6;
    L186:
        r18 = r30;
        r16 = r29;
        r21 = r156;
        r15 = r102;
        r5 = r106;
        r20 = r72;
        r22 = r114;
        goto L187
    L188:
        r6 = r222;
        r113 = r28;
        com.obric.autogui.session.a r412 = r72;
        r4 = r0;
        r31 = r412;
        int r413 = r156;
        r15 = r102;
        r26 = r413;
        goto L189
    L109:
        if (r138.g() == true) goto L111;
        Loog.INSTANCE.e(r11, "[step-exec] space not ready before step #" + r23 + r211 + r138.h());
        com.obric.autogui.session.state.termination.a.a(r65.J(), r138, 100002, null, null, 12, null);
        r35 = r65;
        r10 = r63;
        r117 = r215;
        goto L56
    L105:
        r139 = r48;
        r30 = r54;
        Object r107 = r52;
        r63 = r130;
        r65 = r35;
        r23 = r214;
        r34 = r34;
        r135 = r125;
        r215 = r117;
        r138 = null;
        r136 = r51;
        r137 = r39;
        r62 = r107;
        r64 = r49;
        goto L104
    L87:
        if (ZeusTransformUtils.instanceOf(r39, com.obric.autogui.agents.vlm.models.a.d.class) == false) goto L96;
        r214 = r121;
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r39.W(), CharSequence.class, r117)).length() <= 0) goto L91;
        boolean r108 = true;
    L92:
        if (r108 == false) goto L97;
        if (d.h.b.o.a(r39.W(), r35.v()) == true) goto L97;
        Loog.INSTANCE.i(r11, " - [ignored - stepId unmatched] generated step-id=" + r39.W() + "/tracking=" + r35.v() + " (" + r39.k_() + ").");
        goto L83
    L91:
        r108 = false;
        goto L92
    L76:
        if (ZeusTransformUtils.instanceOf(r39, com.obric.autogui.operator.l.class) == false) goto L79;
        Loog.INSTANCE.i(r11, " - [ignored - suppressed] generated step-id=" + r39.W() + "/tracking=" + r35.v() + " was suppressed during its generation.");
        r30 = r129;
        goto L78
    L79:
        r55 = r410;
        r54 = r129;
    L207:
        r115 = null;
        com.obric.autogui.session.state.termination.a.a(r35.J(), r50, 0, null, null, 14, null);
        Loog.INSTANCE.e(r11, new StringBuilder().append("[step-fetch] early-terminated at step #").append(r121).append(r211).append(r50.h()).toString());
        r10 = r128;
        r117 = r117;
        r34 = r34;
        r30 = r129;
        goto L209
    L41:
        r40 = null;
        goto L42
    L46:
        String r223 = r2;
        String r109 = r121 + '_' + AOSystemTools.INSTANCE.randomId();
        Loog.INSTANCE.i(r11, " - [step-PRED] step #" + r121 + "; newId=" + r109);
        r31.b(r109);
        com.obric.autogui.session.c.a r158 = new com.obric.autogui.session.c.a();
        com.obric.autogui.agents.a.d r159 = new com.obric.autogui.agents.a.d(r121, r109, r158, AOSystemTools.INSTANCE.bootTimeMillis(), null, 16, null);
        com.obric.autogui.session.c.a.a(r158, "stp_prepare", "judge", 0, 4, null);
        com.obric.autogui.agents.vlm.models.omni.b.e.f28225a.a(r31.b(), com.obric.autogui.agents.vlm.models.omni.b.c.h);
        r3.f30801a = r4;
        r3.f30802b = r31;
        r3.f30803c = r30;
        r3.f30804d = r122;
        r3.f30805e = r38;
        r3.f = r125;
        r3.g = r158;
        r3.h = r159;
        r3.i = r34;
        r3.j = r10;
        int r160 = r34;
        r3.l = r37;
        r3.k = r121;
        r3.p = 1;
        Object r161 = r122.a(r31, r159, r3);
        com.obric.autogui.session.a r414 = r31;
        if (r161 != r46) goto L49;
        return r46;
    L49:
        Object r224 = r46;
        long r225 = r37;
        c r162 = r4;
        z.a r163 = r125;
        r5 = r161;
        com.obric.autogui.session.a r164 = r414;
        com.obric.autogui.session.c.a r165 = r158;
        com.obric.autogui.agents.a.d r166 = r159;
        int r167 = r160;
    L50:
        com.obric.autogui.agents.a.b r168 = (com.obric.autogui.agents.a.b) ZeusTransformUtils.preCheckCast(r5, com.obric.autogui.agents.a.b.class, r223);
        int r226 = r10;
        com.obric.autogui.agents.vlm.models.omni.b.e.f28225a.b(r164.b(), com.obric.autogui.agents.vlm.models.omni.b.c.h);
        com.obric.autogui.session.c.a.b(r165, "stp_prepare", "judge", 0, 4, null);
        com.obric.autogui.agents.vlm.models.omni.b.e.f28225a.a(r164.b(), com.obric.autogui.agents.vlm.models.omni.b.f.f28229d);
        if (r168.a() != com.obric.autogui.agents.a.e.f26136b) goto L57;
        Loog.INSTANCE.i(r11, " - [step-PRED-JUDGE] aborted in step #" + r121 + "; jr=" + r168);
        com.obric.autogui.session.state.termination.a r169 = r164.J();
        com.obric.autogui.common.e.a r170 = com.obric.autogui.common.e.f29014b;
        String r171 = r168.b();
        if (r171 != null) goto L55;
        r171 = "";
    L55:
        com.obric.autogui.session.state.termination.a.a(r169, r170.c(r171), r168.c(), null, null, 12, null);
        r35 = r164;
        r34 = r167;
        r117 = r223;
        r10 = r226;
        goto L56
    L57:
        com.obric.autogui.session.c.a.a(r165, "stp_pred", "all", 0, 4, null);
        r3.f30801a = r162;
        r3.f30802b = r164;
        r3.f30803c = r30;
        r3.f30804d = r122;
        r3.f30805e = r38;
        r3.f = r163;
        r3.g = r165;
        r3.h = r166;
        r3.i = r167;
        int r172 = r226;
        r3.j = r172;
        long r173 = r225;
        r3.l = r173;
        r3.k = r121;
        r3.p = 2;
        r5 = r122.b(r164, r166, r3);
        c r174 = r162;
        Object r175 = r224;
        if (r5 != r175) goto L60;
        return r175;
    L60:
        r129 = r30;
        long r176 = r173;
        com.obric.autogui.session.c.a r227 = r165;
        int r177 = r167;
        z.a r415 = r163;
        Object r178 = r175;
        c r179 = r174;
        int r180 = r121;
        com.obric.autogui.agents.a.d r181 = r166;
        r125 = r415;
    L61:
        r117 = r223;
        com.obric.autogui.common.e r182 = (com.obric.autogui.common.e) ZeusTransformUtils.preCheckCast(r5, com.obric.autogui.common.e.class, r117);
        com.obric.autogui.session.c.a.b(r227, "stp_pred", "all", 0, 4, null);
        c r416 = r179;
        com.obric.autogui.operator.e r183 = (com.obric.autogui.operator.e) ZeusTransformUtils.preCheckCast(((com.obric.autogui.common.d) ZeusTransformUtils.preCheckCast(r182, com.obric.autogui.common.d.class, r117)).a(), com.obric.autogui.operator.e.class, r117);
        if (r183 == null) goto L67;
        com.obric.autogui.operator.e.d r184 = r183.D();
        if (r184 == null) goto L67;
        r184.d(AOSystemTools.INSTANCE.bootTimeMillis() - r181.d());
        r184.f(r184.d() - r184.e());
        d.x r185 = d.x.f38692a;
    L67:
        r48 = r416;
        r39 = r183;
        r121 = r180;
        long r417 = r176;
        r50 = r182;
        r35 = r164;
        r49 = r122;
        r34 = r177;
        r128 = r172;
        r51 = r38;
        r52 = r178;
        r213 = r417;
        goto L69
    L27:
        if (r123.a(com.obric.autogui.session.functions.impl.b.class) != null) goto L30;
        r124 = false;
        goto L31
    L208:
        com.obric.autogui.session.a r418 = r31;
        r117 = r2;
        r115 = null;
        r35 = r418;
        goto L209
    L195:
        r115 = null;
        goto L197
    L13:
        int r186 = r3.k;
        long r187 = r3.l;
        r10 = r3.j;
        r156 = r3.i;
        r111 = (com.obric.autogui.operator.g.e) ZeusTransformUtils.preCheckCast(r3.f, com.obric.autogui.operator.g.e.class, "com.obric.aiagent.plugin");
        com.obric.autogui.session.c.a r188 = (com.obric.autogui.session.c.a) ZeusTransformUtils.preCheckCast(r3.f30805e, com.obric.autogui.session.c.a.class, "com.obric.aiagent.plugin");
        com.obric.autogui.operator.e r189 = (com.obric.autogui.operator.e) ZeusTransformUtils.preCheckCast(r3.f30804d, com.obric.autogui.operator.e.class, "com.obric.aiagent.plugin");
        com.obric.autogui.operator.j r190 = (com.obric.autogui.operator.j) ZeusTransformUtils.preCheckCast(r3.f30803c, com.obric.autogui.operator.j.class, "com.obric.aiagent.plugin");
        r72 = (com.obric.autogui.session.a) ZeusTransformUtils.preCheckCast(r3.f30802b, com.obric.autogui.session.a.class, "com.obric.aiagent.plugin");
        r0 = (c) ZeusTransformUtils.preCheckCast(r3.f30801a, c.class, "com.obric.aiagent.plugin");
        o.a(r5);
        r27 = "; reason=";
        r24 = TAG;
        r29 = r188;
        r114 = r189;
        r151 = "com.obric.aiagent.plugin";
        r110 = r187;
        r23 = r186;
        r30 = r190;
        goto L176
    L14:
        long r191 = r3.m;
        int r192 = r3.k;
        long r193 = r3.l;
        int r194 = r3.j;
        r143 = r3.i;
        com.obric.autogui.session.c.a r195 = (com.obric.autogui.session.c.a) ZeusTransformUtils.preCheckCast(r3.g, com.obric.autogui.session.c.a.class, "com.obric.aiagent.plugin");
        com.obric.autogui.operator.e r196 = (com.obric.autogui.operator.e) ZeusTransformUtils.preCheckCast(r3.f, com.obric.autogui.operator.e.class, "com.obric.aiagent.plugin");
        z.a r197 = (z.a) ZeusTransformUtils.preCheckCast(r3.f30805e, z.a.class, "com.obric.aiagent.plugin");
        com.obric.autogui.agents.a r198 = (com.obric.autogui.agents.a) ZeusTransformUtils.preCheckCast(r3.f30804d, com.obric.autogui.agents.a.class, "com.obric.aiagent.plugin");
        com.obric.autogui.operator.j r199 = (com.obric.autogui.operator.j) ZeusTransformUtils.preCheckCast(r3.f30803c, com.obric.autogui.operator.j.class, "com.obric.aiagent.plugin");
        r72 = (com.obric.autogui.session.a) ZeusTransformUtils.preCheckCast(r3.f30802b, com.obric.autogui.session.a.class, "com.obric.aiagent.plugin");
        r0 = (c) ZeusTransformUtils.preCheckCast(r3.f30801a, c.class, "com.obric.aiagent.plugin");
        o.a(r5);
        r215 = "com.obric.aiagent.plugin";
        r218 = r6;
        r27 = "; reason=";
        r24 = TAG;
        r147 = r193;
        r86 = r195;
        r219 = r198;
        r114 = r196;
        r75 = r197;
        r81 = r194;
        r149 = r191;
        r23 = r192;
        r30 = r199;
        goto L142
    L15:
        long r200 = r3.m;
        int r201 = r3.k;
        long r1100 = r3.l;
        int r202 = r3.j;
        r143 = r3.i;
        com.obric.autogui.session.c.a r1101 = (com.obric.autogui.session.c.a) ZeusTransformUtils.preCheckCast(r3.g, com.obric.autogui.session.c.a.class, "com.obric.aiagent.plugin");
        com.obric.autogui.operator.e r203 = (com.obric.autogui.operator.e) ZeusTransformUtils.preCheckCast(r3.f, com.obric.autogui.operator.e.class, "com.obric.aiagent.plugin");
        z.a r204 = (z.a) ZeusTransformUtils.preCheckCast(r3.f30805e, z.a.class, "com.obric.aiagent.plugin");
        com.obric.autogui.agents.a r205 = (com.obric.autogui.agents.a) ZeusTransformUtils.preCheckCast(r3.f30804d, com.obric.autogui.agents.a.class, "com.obric.aiagent.plugin");
        com.obric.autogui.operator.j r206 = (com.obric.autogui.operator.j) ZeusTransformUtils.preCheckCast(r3.f30803c, com.obric.autogui.operator.j.class, "com.obric.aiagent.plugin");
        r72 = (com.obric.autogui.session.a) ZeusTransformUtils.preCheckCast(r3.f30802b, com.obric.autogui.session.a.class, "com.obric.aiagent.plugin");
        r83 = (c) ZeusTransformUtils.preCheckCast(r3.f30801a, c.class, "com.obric.aiagent.plugin");
        o.a(r5);
        r215 = "com.obric.aiagent.plugin";
        r27 = "; reason=";
        r24 = TAG;
        r147 = r1100;
        r82 = r1101;
        r114 = r203;
        r75 = r204;
        r81 = r202;
        r146 = r200;
        r23 = r201;
        r64 = r205;
        r30 = r206;
        r148 = r6;
        goto L138
    L16:
        int r207 = r3.k;
        long r208 = r3.l;
        int r209 = r3.j;
        r143 = r3.i;
        r144 = (com.obric.autogui.session.c.a) ZeusTransformUtils.preCheckCast(r3.g, com.obric.autogui.session.c.a.class, "com.obric.aiagent.plugin");
        r114 = (com.obric.autogui.operator.e) ZeusTransformUtils.preCheckCast(r3.f, com.obric.autogui.operator.e.class, "com.obric.aiagent.plugin");
        z.a r1102 = (z.a) ZeusTransformUtils.preCheckCast(r3.f30805e, z.a.class, "com.obric.aiagent.plugin");
        com.obric.autogui.agents.a r228 = (com.obric.autogui.agents.a) ZeusTransformUtils.preCheckCast(r3.f30804d, com.obric.autogui.agents.a.class, "com.obric.aiagent.plugin");
        com.obric.autogui.operator.j r229 = (com.obric.autogui.operator.j) ZeusTransformUtils.preCheckCast(r3.f30803c, com.obric.autogui.operator.j.class, "com.obric.aiagent.plugin");
        r72 = (com.obric.autogui.session.a) ZeusTransformUtils.preCheckCast(r3.f30802b, com.obric.autogui.session.a.class, "com.obric.aiagent.plugin");
        r73 = (c) ZeusTransformUtils.preCheckCast(r3.f30801a, c.class, "com.obric.aiagent.plugin");
        o.a(r5);
        r215 = "com.obric.aiagent.plugin";
        r74 = r209;
        r27 = "; reason=";
        r24 = TAG;
        r75 = r1102;
        r64 = r228;
        r142 = r208;
        r23 = r207;
        r30 = r229;
        goto L129
    L17:
        int r230 = r3.k;
        long r231 = r3.l;
        int r232 = r3.j;
        r143 = r3.i;
        r144 = (com.obric.autogui.session.c.a) ZeusTransformUtils.preCheckCast(r3.g, com.obric.autogui.session.c.a.class, "com.obric.aiagent.plugin");
        r114 = (com.obric.autogui.operator.e) ZeusTransformUtils.preCheckCast(r3.f, com.obric.autogui.operator.e.class, "com.obric.aiagent.plugin");
        z.a r1103 = (z.a) ZeusTransformUtils.preCheckCast(r3.f30805e, z.a.class, "com.obric.aiagent.plugin");
        com.obric.autogui.agents.a r233 = (com.obric.autogui.agents.a) ZeusTransformUtils.preCheckCast(r3.f30804d, com.obric.autogui.agents.a.class, "com.obric.aiagent.plugin");
        com.obric.autogui.operator.j r234 = (com.obric.autogui.operator.j) ZeusTransformUtils.preCheckCast(r3.f30803c, com.obric.autogui.operator.j.class, "com.obric.aiagent.plugin");
        r72 = (com.obric.autogui.session.a) ZeusTransformUtils.preCheckCast(r3.f30802b, com.obric.autogui.session.a.class, "com.obric.aiagent.plugin");
        r73 = (c) ZeusTransformUtils.preCheckCast(r3.f30801a, c.class, "com.obric.aiagent.plugin");
        o.a(r5);
        r215 = "com.obric.aiagent.plugin";
        r74 = r232;
        r27 = "; reason=";
        r75 = r1103;
        r64 = r233;
        r142 = r231;
        r23 = r230;
        r30 = r234;
        goto L120
    L18:
        int r235 = r3.k;
        long r236 = r3.l;
        r59 = r3.j;
        r134 = r3.i;
        r137 = (com.obric.autogui.operator.e) ZeusTransformUtils.preCheckCast(r3.g, com.obric.autogui.operator.e.class, "com.obric.aiagent.plugin");
        r135 = (z.a) ZeusTransformUtils.preCheckCast(r3.f, z.a.class, "com.obric.aiagent.plugin");
        r136 = (AOThreadingTools.LaunchedJob) ZeusTransformUtils.preCheckCast(r3.f30805e, AOThreadingTools.LaunchedJob.class, "com.obric.aiagent.plugin");
        r133 = r235;
        com.obric.autogui.agents.a r237 = (com.obric.autogui.agents.a) ZeusTransformUtils.preCheckCast(r3.f30804d, com.obric.autogui.agents.a.class, "com.obric.aiagent.plugin");
        com.obric.autogui.operator.j r238 = (com.obric.autogui.operator.j) ZeusTransformUtils.preCheckCast(r3.f30803c, com.obric.autogui.operator.j.class, "com.obric.aiagent.plugin");
        r61 = (com.obric.autogui.session.a) ZeusTransformUtils.preCheckCast(r3.f30802b, com.obric.autogui.session.a.class, "com.obric.aiagent.plugin");
        r58 = (c) ZeusTransformUtils.preCheckCast(r3.f30801a, c.class, "com.obric.aiagent.plugin");
        o.a(r5);
        r117 = "com.obric.aiagent.plugin";
        r211 = "; reason=";
        r213 = r236;
        r60 = r237;
        r30 = r238;
        goto L103
    L19:
        int r239 = r3.k;
        r176 = r3.l;
        r172 = r3.j;
        r177 = r3.i;
        r181 = (com.obric.autogui.agents.a.d) ZeusTransformUtils.preCheckCast(r3.h, com.obric.autogui.agents.a.d.class, "com.obric.aiagent.plugin");
        com.obric.autogui.session.c.a r1104 = (com.obric.autogui.session.c.a) ZeusTransformUtils.preCheckCast(r3.g, com.obric.autogui.session.c.a.class, "com.obric.aiagent.plugin");
        r125 = (z.a) ZeusTransformUtils.preCheckCast(r3.f, z.a.class, "com.obric.aiagent.plugin");
        r180 = r239;
        AOThreadingTools.LaunchedJob r240 = (AOThreadingTools.LaunchedJob) ZeusTransformUtils.preCheckCast(r3.f30805e, AOThreadingTools.LaunchedJob.class, "com.obric.aiagent.plugin");
        com.obric.autogui.agents.a r241 = (com.obric.autogui.agents.a) ZeusTransformUtils.preCheckCast(r3.f30804d, com.obric.autogui.agents.a.class, "com.obric.aiagent.plugin");
        r129 = (com.obric.autogui.operator.j) ZeusTransformUtils.preCheckCast(r3.f30803c, com.obric.autogui.operator.j.class, "com.obric.aiagent.plugin");
        r164 = (com.obric.autogui.session.a) ZeusTransformUtils.preCheckCast(r3.f30802b, com.obric.autogui.session.a.class, "com.obric.aiagent.plugin");
        r179 = (c) ZeusTransformUtils.preCheckCast(r3.f30801a, c.class, "com.obric.aiagent.plugin");
        o.a(r5);
        r223 = "com.obric.aiagent.plugin";
        r178 = r6;
        r211 = "; reason=";
        r227 = r1104;
        r38 = r240;
        r122 = r241;
        goto L61
    L20:
        int r242 = r3.k;
        long r243 = r3.l;
        r10 = r3.j;
        int r1105 = r3.i;
        com.obric.autogui.agents.a.d r1106 = (com.obric.autogui.agents.a.d) ZeusTransformUtils.preCheckCast(r3.h, com.obric.autogui.agents.a.d.class, "com.obric.aiagent.plugin");
        com.obric.autogui.session.c.a r1107 = (com.obric.autogui.session.c.a) ZeusTransformUtils.preCheckCast(r3.g, com.obric.autogui.session.c.a.class, "com.obric.aiagent.plugin");
        z.a r1108 = (z.a) ZeusTransformUtils.preCheckCast(r3.f, z.a.class, "com.obric.aiagent.plugin");
        AOThreadingTools.LaunchedJob r244 = (AOThreadingTools.LaunchedJob) ZeusTransformUtils.preCheckCast(r3.f30805e, AOThreadingTools.LaunchedJob.class, "com.obric.aiagent.plugin");
        com.obric.autogui.agents.a r245 = (com.obric.autogui.agents.a) ZeusTransformUtils.preCheckCast(r3.f30804d, com.obric.autogui.agents.a.class, "com.obric.aiagent.plugin");
        com.obric.autogui.operator.j r246 = (com.obric.autogui.operator.j) ZeusTransformUtils.preCheckCast(r3.f30803c, com.obric.autogui.operator.j.class, "com.obric.aiagent.plugin");
        r164 = (com.obric.autogui.session.a) ZeusTransformUtils.preCheckCast(r3.f30802b, com.obric.autogui.session.a.class, "com.obric.aiagent.plugin");
        r162 = (c) ZeusTransformUtils.preCheckCast(r3.f30801a, c.class, "com.obric.aiagent.plugin");
        o.a(r5);
        r223 = "com.obric.aiagent.plugin";
        r224 = r6;
        r211 = "; reason=";
        r225 = r243;
        r167 = r1105;
        r165 = r1107;
        r163 = r1108;
        r30 = r246;
        r38 = r244;
        r122 = r245;
        r166 = r1106;
        r121 = r242;
        goto L50
    L21:
        o.a(r5);
        r31 = r44;
        r34 = 0;
        r10 = 0;
        r30 = null;
        goto L23
    L11:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L7:
        r4 = this;
        r3 = new e(r4, r1);
        goto L8
    }

    private static final d.x a(int r3, com.obric.autogui.operator.e.c r4) {
        d.h.b.o.e(r4, "$this$updateRetryInfo");
        Loog.INSTANCE.i(TAG, " - [step-exec] posting RETRY for step #" + r3 + "; c=" + r4.a());
        return d.x.f38692a;
    }

    private final int d(com.obric.autogui.session.a r6) {
        c r5 = (c) ZeusTransformUtils.preCheckCast(this, c.class, "com.obric.aiagent.plugin");
        ArrayList r7 = new ArrayList((Collection) ZeusTransformUtils.preCheckCast(r6.p(), Collection.class, "com.obric.aiagent.plugin"));
        int r8 = r7.size() - 2;
        int r2 = 0;
    L4:
        if ((-1) >= r8) goto L29;
        com.obric.autogui.operator.e r3 = (com.obric.autogui.operator.e) ZeusTransformUtils.preCheckCast(r7.get(r8), com.obric.autogui.operator.e.class, "com.obric.aiagent.plugin");
        if (r3 == null) goto L16;
        IAutoActionAgentEventListener.AgentStepInfo r4 = r3.T();
        if (r4 == null) goto L16;
        String r9 = r4.getActionProtocolType();
        if (r9 == null) goto L16;
        String r10 = d.o.o.a((CharSequence) ZeusTransformUtils.preCheckCast(r9, CharSequence.class, "com.obric.aiagent.plugin")).toString();
        if (r10 == null) goto L16;
        String r11 = r10.toLowerCase(Locale.ROOT);
        d.h.b.o.c(r11, "toLowerCase(...)");
        if (r11 == null) goto L16;
    L18:
        if (d.h.b.o.a(r11, "wait") == false) goto L20;
        r2 = r2 + 1;
        r8 = r8 - 1;
        goto L4
    L20:
        if (r2 > 0) goto L22;
        return 0;
    L22:
        if (d.h.b.o.a(r11, "open_app") == true) goto L24;
        return 0;
    L24:
        return r2;
    L16:
        r11 = "";
        goto L18
    L29:
        return 0;
    }

    public final Object a(com.obric.autogui.session.a r7, d.c.d<? super Boolean> r8) {
        d.c.d r9 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r8, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r9, k.class) == false) goto L7;
        k r0 = (k) ZeusTransformUtils.preCheckCast(r9, k.class, "com.obric.aiagent.plugin");
        if ((r0.f30828e & Integer.MIN_VALUE) == 0) goto L7;
        r0.f30828e -= Integer.MIN_VALUE;
    L8:
        Object r10 = r0.f30826c;
        Object r1 = d.c.a.b.a();
        int r2 = r0.f30828e;
        if (r2 == 0) goto L18;
        if (r2 != 1) goto L17;
        com.obric.autogui.session.a r6 = (com.obric.autogui.session.a) ZeusTransformUtils.preCheckCast(r0.f30825b, com.obric.autogui.session.a.class, "com.obric.aiagent.plugin");
        c r11 = (c) ZeusTransformUtils.preCheckCast(r0.f30824a, c.class, "com.obric.aiagent.plugin");
        o.a(r10);     // Catch: Throwable -> L14
        c this = r11;
    L35:
        this.d();
    L41:
        return d.c.b.a.b.a(true);
    L14:
        Throwable th = th;
    L48:
        Loog.INSTANCE.e(TAG, "failed to cleanse expected session: " + r6.a(), th);     // Catch: Throwable -> L42
        r11.d();
    L42:
        th = move-exception;
        r11.d();
        throw th;
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        o.a(r10);
        monitor-enter(this);
        String r3 = null;
        if (f30780d != r7) goto L24;
        f30780d = null;     // Catch: Throwable -> L45
        com.obric.autogui.session.a r12 = r7;
    L25:
        monitor-exit(this);
        if (r12 != null) goto L52;
        Loog r13 = Loog.INSTANCE;
        StringBuilder r4 = new StringBuilder().append("skip voidSessionIfCurrent, ongoing=");
        com.obric.autogui.session.a r5 = f30780d;
        if (r5 == null) goto L30;
        r3 = r5.a();
    L30:
        r13.w(TAG, r4.append(r3).append(", expected=").append(r7.a()).toString());
        return d.c.b.a.b.a(false);
    L52:
        r0.f30824a = this;     // Catch: Throwable -> L36
        r0.f30825b = r12;     // Catch: Throwable -> L36
        r0.f30828e = 1;     // Catch: Throwable -> L36
        if (d(r12, r0) != r1) goto L35;
        return r1;
    L36:
        th = move-exception;
        r11 = this;
        r6 = r12;
        th = th;
        goto L48
    L24:
        r12 = null;
    L45:
        th = move-exception;
        throw th;
    L7:
        r0 = new k(this, r9);
        goto L8
    }

    public final Object a(com.obric.autogui.session.a r20, String r21, d.c.d<? super Boolean> r22) {
        c r1 = this;
        String r2 = r21;
        d.c.d r4 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r22, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r4, C0836c.class) == false) goto L7;
        C0836c r5 = (C0836c) ZeusTransformUtils.preCheckCast(r4, C0836c.class, "com.obric.aiagent.plugin");
        if ((r5.h & Integer.MIN_VALUE) == 0) goto L7;
        r5.h -= Integer.MIN_VALUE;
    L8:
        Object r6 = r5.f;
        Object r7 = d.c.a.b.a();
        int r8 = r5.h;
        String r10 = null;
        if (r8 == 0) goto L24;
        if (r8 == 1) goto L19;
        if (r8 != 2) goto L18;
        long r0 = r5.f30795e;
        long r9 = r5.f30794d;
        com.obric.autogui.session.a r3 = (com.obric.autogui.session.a) ZeusTransformUtils.preCheckCast(r5.f30793c, com.obric.autogui.session.a.class, "com.obric.aiagent.plugin");
        String r11 = (String) ZeusTransformUtils.preCheckCast(r5.f30792b, String.class, "com.obric.aiagent.plugin");
        c r12 = (c) ZeusTransformUtils.preCheckCast(r5.f30791a, c.class, "com.obric.aiagent.plugin");
        o.a(r6);     // Catch: Throwable -> L15
    L69:
        Loog.INSTANCE.e(TAG, "force void cleanse end, reason=" + r11 + ", key=" + r3.a() + ", costMs=" + (AOSystemTools.INSTANCE.bootTimeMillis() - r0) + ", " + r12.e(r3));     // Catch: Throwable -> L15
        monitor-enter(r12);
    L77:
        th = move-exception;
        throw th;
    L72:
        if (f30781e != r3) goto L74;
        f30781e = null;     // Catch: Throwable -> L77
    L74:
        d.x r13 = d.x.f38692a;     // Catch: Throwable -> L77
        monitor-exit(r12);
        r12.d();
        Loog r14 = Loog.INSTANCE;
        String r15 = TAG;
        StringBuilder r16 = new StringBuilder();
    L90:
        r14.e(r15, r16.append("force void complete, reason=").append(r11).append(", key=").append(r3.a()).append(", totalMs=").append(AOSystemTools.INSTANCE.bootTimeMillis() - r9).append(", ").append(r12.e(r3)).toString());
        return d.c.b.a.b.a(true);
    L15:
        th = th;
    L112:
        Loog.INSTANCE.e(TAG, "failed to cleanse force-voided session: " + r3.a(), th);     // Catch: Throwable -> L95
        monitor-enter(r12);
    L92:
        th = move-exception;
        throw th;
    L85:
        if (f30781e != r3) goto L87;
        f30781e = null;     // Catch: Throwable -> L92
    L87:
        d.x r17 = d.x.f38692a;     // Catch: Throwable -> L92
        monitor-exit(r12);
        r12.d();
        r14 = Loog.INSTANCE;
        r15 = TAG;
        r16 = new StringBuilder();
    L95:
        th = move-exception;
        monitor-enter(r12);
    L104:
        th = move-exception;
        throw th;
    L98:
        if (f30781e != r3) goto L100;
        f30781e = null;     // Catch: Throwable -> L104
    L100:
        d.x r18 = d.x.f38692a;     // Catch: Throwable -> L104
        r12.d();
        Loog.INSTANCE.e(TAG, "force void complete, reason=" + r11 + ", key=" + r3.a() + ", totalMs=" + (AOSystemTools.INSTANCE.bootTimeMillis() - r9) + ", " + r12.e(r3));
        throw th;
    L18:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L19:
        long r19 = r5.f30794d;
        com.obric.autogui.session.a r23 = (com.obric.autogui.session.a) ZeusTransformUtils.preCheckCast(r5.f30793c, com.obric.autogui.session.a.class, "com.obric.aiagent.plugin");
        String r110 = (String) ZeusTransformUtils.preCheckCast(r5.f30792b, String.class, "com.obric.aiagent.plugin");
        c r24 = (c) ZeusTransformUtils.preCheckCast(r5.f30791a, c.class, "com.obric.aiagent.plugin");
        o.a(r6);     // Catch: Throwable -> L22
        r1 = r24;
        long r25 = r19;
        r2 = r110;
    L110:
        long r111 = AOSystemTools.INSTANCE.bootTimeMillis();     // Catch: Throwable -> L80
        Loog.INSTANCE.e(TAG, "force void cleanse begin, reason=" + r2 + ", key=" + r23.a() + ", " + r1.e(r23));     // Catch: Throwable -> L80
        r5.f30791a = r1;     // Catch: Throwable -> L80
        r5.f30792b = r2;     // Catch: Throwable -> L80
        r5.f30793c = r23;     // Catch: Throwable -> L80
        r5.f30794d = r25;     // Catch: Throwable -> L80
        r5.f30795e = r111;     // Catch: Throwable -> L80
        r5.h = 2;     // Catch: Throwable -> L80
        if (r1.d(r23, r5) != r7) goto L68;
        return r7;
    L68:
        r11 = r2;
        r3 = r23;
        r9 = r25;
        r12 = r1;
        r0 = r111;
    L80:
        th = th;
        r11 = r2;
        r3 = r23;
        r9 = r25;
        r12 = r1;
    L22:
        th = th;
        r1 = r24;
        r25 = r19;
        r2 = r110;
    L64:
        Loog.INSTANCE.e(TAG, "failed to destroy space for force-voided session: " + r23.a(), th);
        goto L110
    L24:
        o.a(r6);
        monitor-enter(this);
    L107:
        th = move-exception;
        throw th;
    L27:
        if (f30780d != r20) goto L30;
        f30780d = null;     // Catch: Throwable -> L107
        f30781e = r20;     // Catch: Throwable -> L107
        r23 = r20;
    L31:
        monitor-exit(this);
        if (r23 != null) goto L38;
        Loog r26 = Loog.INSTANCE;
        StringBuilder r27 = new StringBuilder().append("skip forceVoidSessionIfCurrent, ongoing=");
        com.obric.autogui.session.a r28 = f30780d;
        if (r28 == null) goto L36;
        r10 = r28.a();
    L36:
        r26.w(TAG, r27.append(r10).append(", expected=").append(r20.a()).append(", reason=").append(r2).toString());
        return d.c.b.a.b.a(false);
    L38:
        r1.f(r23);
        r25 = AOSystemTools.INSTANCE.bootTimeMillis();
        com.obric.autogui.session.d.m r29 = r23.k().c();     // Catch: Throwable -> L44
        if (r29 == null) goto L42;
        AOOperatingSpace r30 = r29.i();     // Catch: Throwable -> L44
    L43:
        AOOperatingSpace r112 = r30;
    L46:
        Loog.INSTANCE.e(TAG, "force void ongoing session, reason=" + r2 + ", " + r1.e(r23));
        com.obric.autogui.agents.vlm.models.impl.applist.black.p.f27502a.a(r23.a());     // Catch: Throwable -> L49
    L119:
        long r113 = AOSystemTools.INSTANCE.bootTimeMillis();     // Catch: Throwable -> L53
        r23.d(r2);     // Catch: Throwable -> L53
        Loog.INSTANCE.e(TAG, "force void shutdown requested, reason=" + r2 + ", key=" + r23.a() + ", costMs=" + (AOSystemTools.INSTANCE.bootTimeMillis() - r113) + ", " + r1.e(r23));     // Catch: Throwable -> L53
    L114:
        r23.c("force_void_" + r2);     // Catch: Throwable -> L57
    L59:
        if (r112 == null) goto L110;
        OperatingSpaceManager r31 = OperatingSpaceManager.INSTANCE;     // Catch: Throwable -> L63
        Context r114 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r23.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L63
        r5.f30791a = r1;     // Catch: Throwable -> L63
        r5.f30792b = r2;     // Catch: Throwable -> L63
        r5.f30793c = r23;     // Catch: Throwable -> L63
        r5.f30794d = r25;     // Catch: Throwable -> L63
        r5.h = 1;     // Catch: Throwable -> L63
        if (r31.destroySpace(r114, r112, r5) != r7) goto L110;
        return r7;
    L63:
        th = th;
    L57:
        th = move-exception;
        Loog.INSTANCE.e(TAG, "failed to dispose resources for force-voided session: " + r23.a(), th);
    L53:
        th = move-exception;
        Loog.INSTANCE.e(TAG, "failed to force shutdown session: " + r23.a(), th);
    L49:
        th = move-exception;
        Loog.INSTANCE.e(TAG, "failed to end record set for force-voided session: " + r23.a(), th);
        goto L119
    L42:
        r30 = OperatingSpaceManager.INSTANCE.getActiveSpace();     // Catch: Throwable -> L44
    L44:
        th = move-exception;
        Loog.INSTANCE.e(TAG, "failed to capture space for force-voided session: " + r23.a(), th);
        r112 = null;
        goto L46
    L30:
        r23 = null;
    L7:
        r5 = new C0836c(r1, r4);
        goto L8
    }

    private final String e(com.obric.autogui.session.a r4) {
        StringBuilder r3 = new StringBuilder();
        StringBuilder r0 = r3.append("key=").append(r4.a()).append(", id=").append(r4.b()).append(", state=").append(r4.m().e().b()).append(", pendingState=").append(r4.m().c()).append(", terminated=").append(r4.J().d()).append(", hasReachedEndStep=").append(r4.J().a()).append(", paused=").append(r4.M()).append(", running=").append(r4.K()).append(", loopActive=");
        AOThreadingTools.LaunchedJob r1 = r4.i();
        Boolean r2 = null;
        if (r1 == null) goto L7;
        ca r5 = r1.getJob();
        if (r5 == null) goto L7;
        Boolean r6 = Boolean.valueOf(r5.b());
    L8:
        StringBuilder r7 = r0.append(r6).append(", loopCancelled=");
        AOThreadingTools.LaunchedJob r8 = r4.i();
        if (r8 == null) goto L13;
        ca r9 = r8.getJob();
        if (r9 == null) goto L13;
        Boolean r10 = Boolean.valueOf(r9.j());
    L14:
        StringBuilder r11 = r7.append(r10).append(", loopCompleted=");
        AOThreadingTools.LaunchedJob r12 = r4.i();
        if (r12 == null) goto L19;
        ca r13 = r12.getJob();
        if (r13 == null) goto L19;
        r2 = Boolean.valueOf(r13.i());
    L19:
        r11.append(r2).append(", worker={");
        r3.append(r4.h().describeState()).append("}, stateThread={").append(r4.m().a().describeState()).append('}');
        return r3.toString();
    L13:
        r10 = null;
    L7:
        r6 = null;
        goto L8
    }

    private final Object d(com.obric.autogui.session.a r21, d.c.d<? super d.x> r22) {
        com.obric.autogui.session.a r1 = r21;
        d.c.d r0 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r22, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r0, a.class) == false) goto L7;
        a r3 = (a) ZeusTransformUtils.preCheckCast(r0, a.class, "com.obric.aiagent.plugin");
        if ((r3.f30786e & Integer.MIN_VALUE) == 0) goto L7;
        r3.f30786e -= Integer.MIN_VALUE;
    L8:
        Object r2 = r3.f30784c;
        Object r4 = d.c.a.b.a();
        int r5 = r3.f30786e;
        if (r5 == 0) goto L20;
        if (r5 == 1) goto L19;
        if (r5 == 2) goto L18;
        if (r5 == 3) goto L17;
        if (r5 != 4) goto L16;
        boolean r6 = r3.f30783b;
        com.obric.autogui.session.a r7 = (com.obric.autogui.session.a) ZeusTransformUtils.preCheckCast(r3.f30782a, com.obric.autogui.session.a.class, "com.obric.aiagent.plugin");
        o.a(r2);
    L57:
        if (r6 == false) goto L60;
        com.obric.autogui.agents.vlm.models.omni.upload.e.f28643a.d(r7.b());
        v.f28855a.c(r7.b());
        com.obric.autogui.agents.vlm.models.omni.upload.e.f28643a.b();
    L60:
        return d.x.f38692a;
    L16:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L17:
        r6 = r3.f30783b;
        com.obric.autogui.session.a r8 = (com.obric.autogui.session.a) ZeusTransformUtils.preCheckCast(r3.f30782a, com.obric.autogui.session.a.class, "com.obric.aiagent.plugin");
        o.a(r2);
    L53:
        int r9 = r8.t();
        r8.P();
        com.obric.autogui.session.c.a.b(r8.O(), "ses_term", "cleanse", 0, 4, null);
        com.obric.autogui.session.c.a.b(r8.O(), "ses_all", "all", 0, 4, null);
        com.obric.autogui.session.c.a r10 = r8.O();
        m<? super JSONObject, ? super d.c.d<? super d.x>, ? extends Object> r11 = (m) ZeusTransformUtils.preCheckCast(new b(r8, r9, null), m.class, "com.obric.aiagent.plugin");
        r3.f30782a = r8;
        r3.f30783b = r6;
        r3.f30786e = 4;
        if (r10.a(r11, r3) != r4) goto L56;
        return r4;
    L56:
        r7 = r8;
        goto L57
    L18:
        boolean r12 = r3.f30783b;
        com.obric.autogui.session.a r13 = (com.obric.autogui.session.a) ZeusTransformUtils.preCheckCast(r3.f30782a, com.obric.autogui.session.a.class, "com.obric.aiagent.plugin");
        o.a(r2);
    L48:
        com.obric.autogui.session.a.d r14 = (com.obric.autogui.session.a.d) ZeusTransformUtils.preCheckCast(r2, com.obric.autogui.session.a.d.class, "com.obric.aiagent.plugin");
        com.obric.autogui.session.a r19 = r13;
        boolean r15 = r12;
        r1 = r19;
    L49:
        c r16 = f30777a;
        r3.f30782a = r1;
        r3.f30783b = r15;
        r3.f30786e = 3;
        if (r16.e(r1, r3) != r4) goto L52;
        return r4;
    L52:
        boolean r110 = r15;
        r8 = r1;
        r6 = r110;
        goto L53
    L19:
        boolean r17 = r3.f30783b;
        com.obric.autogui.session.a r18 = (com.obric.autogui.session.a) ZeusTransformUtils.preCheckCast(r3.f30782a, com.obric.autogui.session.a.class, "com.obric.aiagent.plugin");
        o.a(r2);
        r15 = r17;
        r1 = r18;
    L42:
        com.obric.autogui.session.a.d r20 = r1.z();
        if (r20 == null) goto L49;
        r3.f30782a = r1;
        r3.f30783b = r15;
        r3.f30786e = 2;
        r2 = r20.b(r3);
        if (r2 != r4) goto L47;
        return r4;
    L47:
        boolean r111 = r15;
        r13 = r1;
        r12 = r111;
        goto L48
    L20:
        o.a(r2);
        if (r1 == null) goto L60;
        f30777a.f(r1);
        r1.a($$Lambda$c$CxcmEqoj4JOlUp9Ak3gp5JLeCMo.INSTANCE);
        r15 = r21.c();
        if (r15 == false) goto L61;
        com.obric.autogui.agents.vlm.models.omni.upload.a.b.f28535a.b(r21.b());
    L61:
        n.a r23 = n.f38560a;     // Catch: Throwable -> L27
        AOAgentRobotsTools.INSTANCE.endRobotsSessionAsync((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r21.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L27
        Object r24 = n.f(d.x.f38692a);     // Catch: Throwable -> L27
    L29:
        Throwable r25 = n.c(r24);
        if (r25 == null) goto L63;
        Loog.INSTANCE.e(TAG, "[AgentRobots] end robots session failed", r25);
    L63:
        n.a r26 = n.f38560a;     // Catch: Throwable -> L34
        com.obric.autogui.util.h.f31557a.b(r1);     // Catch: Throwable -> L34
        Object r27 = n.f(d.x.f38692a);     // Catch: Throwable -> L34
    L36:
        Throwable r28 = n.c(r27);
        if (r28 == null) goto L39;
        Loog.INSTANCE.e(TAG, "[ToastHint] stop recorder failed", r28);
    L39:
        com.obric.autogui.session.c.a.a(r21.O(), "ses_term", "cleanse", 0, 4, null);
        f = r21.d();
        com.obric.autogui.session.functions.c r29 = r21.n();
        r3.f30782a = r1;
        r3.f30783b = r15;
        r3.f30786e = 1;
        if (r29.a(r3) != r4) goto L42;
        return r4;
    L34:
        th = move-exception;
        n.a r112 = n.f38560a;
        r27 = n.f(o.a(th));
    L27:
        th = move-exception;
        n.a r113 = n.f38560a;
        r24 = n.f(o.a(th));
    L7:
        r3 = new a(this, r0);
        goto L8
    }

    private static final d.x a(r r1) {
        d.h.b.o.e(r1, "omniSession");
        r1.k();
        return d.x.f38692a;
    }

    private final void f(com.obric.autogui.session.a r4) {
        n.a r0 = n.f38560a;     // Catch: Throwable -> L4
        c r3 = (c) ZeusTransformUtils.preCheckCast(this, c.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L4
        com.obric.autogui.session.state.e.f31397a.a(r4.a());     // Catch: Throwable -> L4
        Object r5 = n.f(d.x.f38692a);     // Catch: Throwable -> L4
    L6:
        Throwable r6 = n.c(r5);
        if (r6 == null) goto L12;
        Loog.INSTANCE.e(TAG, "failed to close agent operation state: " + r4.a(), r6);
        return;
    L12:
        return;
    L4:
        th = move-exception;
        n.a r1 = n.f38560a;
        r5 = n.f(o.a(th));
        goto L6
    }

    private final Object e(com.obric.autogui.session.a r3, d.c.d<? super d.x> r4) {
        d.c.d<? super com.obric.autogui.common.e> r2 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
        Object r5 = f30779c.b((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r3.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), r2);
        if (r5 != d.c.a.b.a()) goto L6;
        return r5;
    L6:
        return d.x.f38692a;
    }

    @Override // com.obric.autogui.common.api.agent.IAutoActionSessionManager
    public kotlinx.coroutines.b.h<List<IAutoActionAgentEventListener.SessionInfo>> sessionQueue() {
        return (kotlinx.coroutines.b.h) ZeusTransformUtils.preCheckCast(f30778b, kotlinx.coroutines.b.h.class, "com.obric.aiagent.plugin");
    }

    @Override // com.obric.autogui.common.api.agent.IAutoActionSessionManager
    public boolean dequeueSession(final String r3) {
        d.h.b.o.e(r3, "sessionKey");
        monitor-enter(this);
        List<com.obric.autogui.session.a> r0 = g;     // Catch: Throwable -> L7
        final d.h.a.b r1 = new $$Lambda$c$Jut2DFW4uNhgAmY71BZxOgk7QuM(r3);     // Catch: Throwable -> L7
        boolean r4 = r0.removeIf(new $$Lambda$c$SjmRxflIDWc5En1S44KdOlwXg(r1));     // Catch: Throwable -> L7
        f30777a.h();     // Catch: Throwable -> L7
        monitor-exit(this);
        return r4;
    L7:
        th = move-exception;
        throw th;
    }

    private static final boolean a(d.h.a.b r2, Object r3) {
        return ((Boolean) ZeusTransformUtils.preCheckCast(((d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r2, d.h.a.b.class, "com.obric.aiagent.plugin")).invoke(r3), Boolean.class, "com.obric.aiagent.plugin")).booleanValue();
    }

    private static final boolean a(String r1, com.obric.autogui.session.a r2) {
        d.h.b.o.e(r2, "it");
        return d.h.b.o.a(r2.a(), r1);
    }

    private final void h() {
        monitor-enter(this);
        x<List<IAutoActionAgentEventListener.SessionInfo>> r0 = f30778b;     // Catch: Throwable -> L10
        Iterable r1 = (Iterable) ZeusTransformUtils.preCheckCast(g, Iterable.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L10
        Collection r2 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(p.a(r1, 10)), Collection.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L10
        Iterator r3 = r1.iterator();     // Catch: Throwable -> L10
    L5:
        if (r3.hasNext() == false) goto L7;
        r2.add(((com.obric.autogui.session.a) ZeusTransformUtils.preCheckCast(r3.next(), com.obric.autogui.session.a.class, "com.obric.aiagent.plugin")).d());     // Catch: Throwable -> L10
        goto L5
    L7:
        r0.b((List) ZeusTransformUtils.preCheckCast(r2, List.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L10
        d.x r4 = d.x.f38692a;     // Catch: Throwable -> L10
        monitor-exit(this);
        return;
    L10:
        th = move-exception;
        throw th;
    }

    @Override // com.obric.autogui.common.api.agent.IAutoActionSessionManager
    public boolean removeSessionByTimerTaskId(final String r3) {
        d.h.b.o.e(r3, "timerTaskId");
        monitor-enter(this);
        List<com.obric.autogui.session.a> r0 = g;     // Catch: Throwable -> L7
        final d.h.a.b r1 = new $$Lambda$c$FcyiC2LrXGOajydyMPUnwU4vqHM(r3);     // Catch: Throwable -> L7
        boolean r4 = r0.removeIf(new $$Lambda$c$hfQl0qOKEoeIdv5j6x58rQY2dYU(r1));     // Catch: Throwable -> L7
        f30777a.h();     // Catch: Throwable -> L7
        monitor-exit(this);
        return r4;
    L7:
        th = move-exception;
        throw th;
    }

    private static final boolean b(d.h.a.b r2, Object r3) {
        return ((Boolean) ZeusTransformUtils.preCheckCast(((d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r2, d.h.a.b.class, "com.obric.aiagent.plugin")).invoke(r3), Boolean.class, "com.obric.aiagent.plugin")).booleanValue();
    }

    private static final boolean b(String r1, com.obric.autogui.session.a r2) {
        d.h.b.o.e(r2, "it");
        return d.h.b.o.a(r2.l().getTimerTaskId(), r1);
    }

    private final void a(com.obric.autogui.session.a r11, com.obric.autogui.operator.e r12, com.obric.autogui.operator.g r13) {
        com.obric.autogui.operator.g r10 = (com.obric.autogui.operator.g) ZeusTransformUtils.wrapperContextForParams(r13, com.obric.autogui.operator.g.class, "com.obric.aiagent.plugin");
        com.obric.autogui.agents.a r14 = com.obric.autogui.agents.b.f26789a.a();
        if (ZeusTransformUtils.instanceOf(r14, com.obric.autogui.agents.vlm.b.class) == false) goto L5;
        com.obric.autogui.agents.vlm.b r15 = (com.obric.autogui.agents.vlm.b) ZeusTransformUtils.preCheckCast(r14, com.obric.autogui.agents.vlm.b.class, "com.obric.aiagent.plugin");
    L6:
        if (r15 == null) goto L9;
        Map<String, String> r16 = r15.b();
        if (r16 == null) goto L9;
    L10:
        IAutoActionAgentEventListener.AgentStepInfo r1 = r12.T();
        if (r1 != null) goto L13;
    L22:
        Loog.INSTANCE.e(TAG, "Not a actioned step (s=" + r12.W() + "); not reportable.");
        return;
    L13:
        if (d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r1.getActionProtocolType(), CharSequence.class, "com.obric.aiagent.plugin")) == true) goto L22;
        String r2 = r1.getActionProtocolType();
        IAutoActionTrackingApi r3 = (IAutoActionTrackingApi) ZeusTransformUtils.preCheckCast(AOBizTracking.INSTANCE, IAutoActionTrackingApi.class, "com.obric.aiagent.plugin");
        JSONObject r4 = new JSONObject();
        r4.put("action_type", r2);
        r4.put("result", !r10.a());
        r4.put("multi_step_size", r12.O());
        r4.put("multi_step_idx", r12.N());
        com.obric.autogui.session.d.a(r4, r16);
        com.obric.autogui.operator.f r17 = r10.g();
        if (r17 == null) goto L20;
        r4.put("reason", r17.a());
        if (r17.b() == null) goto L20;
        r4.put("debug_info", r17.b());
    L20:
        com.obric.autogui.session.c.b.a(r4, r11);
        r4.put("step_id", r12.W());
        d.x r18 = d.x.f38692a;
        IAutoActionTrackingApi.DefaultImpls.reportEvent$default(r3, "action_exec_result", r4, false, false, null, 28, null);
        return;
    L9:
        r16 = ao.b();
        goto L10
    L5:
        r15 = null;
        goto L6
    }
}
