package com.obric.autogui.agents.vlm.models.impl.applist;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import com.bytedance.common.wschannel.WsChannelMultiProcessSharedProvider;
import com.bytedance.security.zenmobile.io.SensitiveType;
import com.obric.aiagent.plugin.R;
import com.obric.autogui.agents.vlm.models.impl.applist.black.i;
import com.obric.autogui.agents.vlm.models.impl.applist.black.j;
import com.obric.autogui.agents.vlm.models.impl.p;
import com.obric.autogui.agents.vlm.models.omni.r;
import com.obric.autogui.agents.vlm.models.omni.t;
import com.obric.autogui.common.api.AOAgentRobotsTools;
import com.obric.autogui.common.api.AOPackagesTools;
import com.obric.autogui.common.api.agent.AutoActionAgent;
import com.obric.autogui.common.api.agent.IAutoActionAgentApi;
import com.obric.autogui.common.api.agent.blacklist.AppBlackListEvent;
import com.obric.autogui.common.api.agent.blacklist.AppBlackListEventHolder;
import com.obric.autogui.common.api.agent.blacklist.AppBlackListState;
import com.obric.autogui.common.api.app.AOHostAppTools;
import com.obric.autogui.common.api.logging.Loog;
import com.obric.autogui.common.api.platform.display.DisplayedAppInfo;
import com.obric.autogui.common.api.platform.packages.appinfo.AppInfoEntry;
import com.obric.autogui.common.api.threading.AOThreadingTools;
import com.obric.autogui.common.api.virtualdisplay.AutoActionVirtualDisplay;
import com.obric.eventkit.eventstaskmanager.ITaskManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.c.b.a.l;
import d.h.a.m;
import d.h.b.o;
import d.h.b.z;
import d.k;
import d.x;
import java.util.Set;
import kotlinx.coroutines.am;

/* JADX INFO: compiled from: StdModelAppBlackListHelper.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class a {
    private static final String TAG = "StdModel/AppBLHelper";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C0685a f27315a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final i f27316b = null;

    /* JADX INFO: renamed from: com.obric.autogui.agents.vlm.models.impl.applist.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: StdModelAppBlackListHelper.kt */
    public static final class C0685a {
        public /* synthetic */ C0685a(d.h.b.h r1) {
            this();
        }

        private C0685a() {
        }

        public final i a() {
            return a.a();
        }

        public final String a(String r5, String r6, String r7, m<? super String, ? super String, String> r8) {
            m r4 = (m) ZeusTransformUtils.wrapperContextForParams(r8, m.class, "com.obric.aiagent.plugin");
            o.e(r5, "fallbackAppName");
            o.e(r4, "subAppNameFormatter");
            if (r6 == null) goto L35;
            String r9 = d.o.o.a((CharSequence) ZeusTransformUtils.preCheckCast(r6, CharSequence.class, "com.obric.aiagent.plugin")).toString();
            if (r9 == null) goto L35;
            boolean r1 = false;
            if (((CharSequence) ZeusTransformUtils.preCheckCast(r9, CharSequence.class, "com.obric.aiagent.plugin")).length() <= 0) goto L9;
            boolean r10 = true;
        L10:
            String r3 = null;
            if (r10 == true) goto L14;
            r9 = null;
        L14:
            if (r9 == null) goto L35;
            if (r7 == null) goto L29;
            String r11 = d.o.o.a((CharSequence) ZeusTransformUtils.preCheckCast(r7, CharSequence.class, "com.obric.aiagent.plugin")).toString();
            if (r11 == null) goto L29;
            if (((CharSequence) ZeusTransformUtils.preCheckCast(r11, CharSequence.class, "com.obric.aiagent.plugin")).length() <= 0) goto L22;
            boolean r12 = true;
        L23:
            if (r12 == true) goto L25;
        L27:
            if (r1 == false) goto L29;
            r3 = r11;
            goto L29
        L25:
            if (d.o.o.a(r11, r9, true) == true) goto L27;
            r1 = true;
            goto L27
        L22:
            r12 = false;
        L29:
            if (r3 == null) goto L36;
            String r13 = (String) ZeusTransformUtils.preCheckCast(r4.invoke(r9, r3), String.class, "com.obric.aiagent.plugin");
            if (r13 != null) goto L34;
            return r9;
        L34:
            return r13;
        L36:
            return r9;
        L9:
            r10 = false;
        L35:
            return r5;
        }
    }

    /* JADX INFO: compiled from: StdModelAppBlackListHelper.kt */
    private final class b extends p {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ a f27317e;
        private final com.obric.autogui.agents.vlm.b.C0677b g;
        private final AppBlackListEvent h;
        private final String i;
        private final String j;
        private final p.a.EnumC0701a k;
        private final Set<String> l;
        private final Set<String> m;

        public b(a r8, com.obric.autogui.agents.vlm.b.C0677b r9, AppBlackListEvent r10, AppInfoEntry r11, String r12) {
            o.e(r9, SensitiveType.SESSION);
            o.e(r10, "event");
            o.e(r12, "logName");
            this.f27317e = r8;
            this.g = r9;
            this.h = r10;
            this.i = r12;
            l(a.a(r8, (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r9.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), r11).toString());
            String r13 = I();
            if (r13 != null) goto L5;
            r13 = "";
        L5:
            this.j = a.a(r8, r9, r10, r11, r13);
            j(a.f27315a.a().a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r9.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), "blcl_uc4_b", ZeusTransformUtils.mapRes(R.string.std_model_blcl_uc4_b, WsChannelMultiProcessSharedProvider.STRING_TYPE, "std_model_blcl_uc4_b"), new Object[]{I()}));
            a(d.a.p.b(new String[]{a.f27315a.a().a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r9.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), "blcl_uc4_b_negative", ZeusTransformUtils.mapRes(R.string.std_model_blcl_uc4_b_negative, WsChannelMultiProcessSharedProvider.STRING_TYPE, "std_model_blcl_uc4_b_negative"), new Object[0]), a.f27315a.a().a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r9.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), "blcl_uc4_b_active", ZeusTransformUtils.mapRes(R.string.std_model_blcl_uc4_b_active, WsChannelMultiProcessSharedProvider.STRING_TYPE, "std_model_blcl_uc4_b_active"), new Object[0])}));
            b(d.a.p.b(new Boolean[]{false, true}));
            this.k = p.a.EnumC0701a.f27979a;
            String[] r14 = a.f27315a.a().a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r9.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), "blcl_uc4_b_positive_synonym");
            if (r14 == null) goto L10;
            Set<String> r15 = d.a.i.i(r14);
            if (r15 == null) goto L10;
        L11:
            this.l = r15;
            String[] r16 = a.f27315a.a().a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r9.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), "blcl_uc4_b_negative_synonym");
            if (r16 == null) goto L16;
            Set<String> r17 = d.a.i.i(r16);
            if (r17 == null) goto L16;
        L17:
            this.m = r17;
            return;
        L16:
            String[] r18 = ZeusTransformUtils.getResources((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r9.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), "com.obric.aiagent.plugin").getStringArray(ZeusTransformUtils.mapRes(R.array.obric_blcl_uc4_b_negative_synonyms, "array", "obric_blcl_uc4_b_negative_synonyms"));
            o.c(r18, "getStringArray(...)");
            r17 = d.a.i.i((Object[]) ZeusTransformUtils.preCheckCast(r18, Object[].class, "com.obric.aiagent.plugin"));
        L10:
            String[] r19 = ZeusTransformUtils.getResources((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r9.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), "com.obric.aiagent.plugin").getStringArray(ZeusTransformUtils.mapRes(R.array.obric_blcl_uc4_b_positive_synonyms, "array", "obric_blcl_uc4_b_positive_synonyms"));
            o.c(r19, "getStringArray(...)");
            r15 = d.a.i.i((Object[]) ZeusTransformUtils.preCheckCast(r19, Object[].class, "com.obric.aiagent.plugin"));
            goto L11
        }

        public /* synthetic */ b(a r7, com.obric.autogui.agents.vlm.b.C0677b r8, AppBlackListEvent r9, AppInfoEntry r10, String r11, int r12, d.h.b.h r13) {
            if ((r12 & 8) == 0) goto L5;
            r11 = "SoftBL";
        L5:
            this(r7, r8, r9, r10, r11);
        }

        @Override // com.obric.autogui.agents.vlm.models.impl.p
        public p.a.EnumC0701a getType() {
            return this.k;
        }

        @Override // com.obric.autogui.agents.vlm.models.impl.p
        public Set<String> J() {
            return this.l;
        }

        @Override // com.obric.autogui.agents.vlm.models.impl.p
        public Set<String> K() {
            return this.m;
        }

        @Override // com.obric.autogui.agents.vlm.models.impl.p
        public void c(boolean r13) {
            if (r13 == false) goto L5;
            com.obric.autogui.agents.vlm.b.C0677b.a r14 = this.g.o();
            com.obric.autogui.agents.vlm.b.C0677b.a.EnumC0679b r4 = com.obric.autogui.agents.vlm.b.C0677b.a.EnumC0679b.f27123c;
            String r5 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.g.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getString(ZeusTransformUtils.mapRes(R.string.obric_blcl_uc4_b_system_hint, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_blcl_uc4_b_system_hint"), new Object[]{this.j});
            o.c(r5, "getString(...)");
            r14.a(r4, r5);
            Loog.INSTANCE.d("M-Std-Step/A", "actionAsClearAttitude, SystemHint: " + ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.g.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getString(ZeusTransformUtils.mapRes(R.string.obric_blcl_uc4_b_system_hint, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_blcl_uc4_b_system_hint"), new Object[]{this.j}));
            return;
        L5:
            IAutoActionAgentApi.DefaultImpls.systemTerminateQuery$default((IAutoActionAgentApi) ZeusTransformUtils.preCheckCast(AutoActionAgent.INSTANCE, IAutoActionAgentApi.class, "com.obric.aiagent.plugin"), null, a.f27315a.a().a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.g.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), "blcl_uc4_b_reply", ZeusTransformUtils.mapRes(R.string.std_model_blcl_uc4_b_reply, WsChannelMultiProcessSharedProvider.STRING_TYPE, "std_model_blcl_uc4_b_reply"), new Object[]{I()}), 106002, null, null, 24, null);
        }

        @Override // com.obric.autogui.agents.vlm.models.impl.p
        public void b(Context r11) {
            o.e((Context) ZeusTransformUtils.wrapperContextForParams(r11, Context.class, "com.obric.aiagent.plugin"), "context");
            IAutoActionAgentApi.DefaultImpls.systemTerminateQuery$default((IAutoActionAgentApi) ZeusTransformUtils.preCheckCast(AutoActionAgent.INSTANCE, IAutoActionAgentApi.class, "com.obric.aiagent.plugin"), null, a.f27315a.a().a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.g.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), "blcl_uc4_b_reply_unclear", ZeusTransformUtils.mapRes(R.string.std_model_blcl_uc4_b_reply_unclear, WsChannelMultiProcessSharedProvider.STRING_TYPE, "std_model_blcl_uc4_b_reply_unclear"), new Object[]{I()}), 106003, null, null, 24, null);
        }

        @Override // com.obric.autogui.agents.vlm.models.impl.e
        public String toString() {
            return this.i + '(' + this.h.getActivityName() + ')';
        }
    }

    /* JADX INFO: compiled from: StdModelAppBlackListHelper.kt */
    private final class c extends p {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ a f27318e;
        private final com.obric.autogui.agents.vlm.b.C0677b g;
        private final AppBlackListEvent h;
        private final String i;
        private final p.a.EnumC0701a j;
        private final Set<String> k;
        private final Set<String> l;

        /* JADX INFO: renamed from: com.obric.autogui.agents.vlm.models.impl.applist.a$c$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: StdModelAppBlackListHelper.kt */
        @d.c.b.a.f(b = "StdModelAppBlackListHelper.kt", c = {585, 603, 613}, d = "invokeSuspend", e = "com.obric.autogui.agents.vlm.models.impl.applist.StdModelAppBlackListHelper$UserDefinedBLHandlingStep$actionAsClearAttitude$1")
        static final class C0686a extends l implements m<am, d.c.d<? super x>, Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            int f27319a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ c f27320b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            final /* synthetic */ a f27321c;

            C0686a(c r3, a r4, d.c.d<? super C0686a> r5) {
                d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
                this.f27320b = r3;
                this.f27321c = r4;
                super(2, r6);
            }

            private static final String a() {
                return "not updatable app";
            }

            private static final String b() {
                return "Updated: UserBL";
            }

            private static final String c() {
                return "Update Failed: UserBL";
            }

            public static /* synthetic */ String lambda$6HktZkMtm7b3fm4QEeTfY5Xi56E() {
                return a();
            }

            /* JADX INFO: renamed from: lambda$D0pRfEIbjhiNNvPcQLR8Qp9x-SY, reason: not valid java name */
            public static /* synthetic */ String m745lambda$D0pRfEIbjhiNNvPcQLR8Qp9xSY() {
                return b();
            }

            public static /* synthetic */ String lambda$H_rJZCTs8JqCQFzFct8735ITKMA(c r0) {
                return c(r0);
            }

            public static /* synthetic */ String lambda$LeNREF4faPTMWHMYDjWCoexPYJs(c r0) {
                return a(r0);
            }

            public static /* synthetic */ String lambda$VG0QXsrlU4oTuAgGizCypykSuYc() {
                return c();
            }

            public static /* synthetic */ String lambda$fOwL2CNuj7repwcJ_7BTJrcPlpY(c r0) {
                return b(r0);
            }

            public final Object a(am r3, d.c.d<? super x> r4) {
                return ((C0686a) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), C0686a.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
            }

            @Override // d.c.b.a.a
            public final d.c.d<x> create(Object r3, d.c.d<?> r4) {
                d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
                return (d.c.d) ZeusTransformUtils.preCheckCast(new C0686a(this.f27320b, this.f27321c, r5), d.c.d.class, "com.obric.aiagent.plugin");
            }

            @Override // d.h.a.m
            public /* synthetic */ Object invoke(am r3, d.c.d<? super x> r4) {
                return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
            }

            @Override // d.c.b.a.a
            public final Object invokeSuspend(Object r11) {
                Object r0 = d.c.a.b.a();
                int r1 = this.f27319a;
                if (r1 == 0) goto L15;
                if (r1 == 1) goto L14;
                if (r1 == 2) goto L10;
                if (r1 != 3) goto L9;
                d.o.a(r11);
            L34:
                return x.f38692a;
            L9:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            L10:
                d.o.a(r11);     // Catch: Throwable -> L12
            L35:
            L29:
                a r12 = this.f27321c;
                com.obric.autogui.agents.vlm.b.C0677b r2 = this.f27320b.L();
                d.c.d r3 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
                this.f27319a = 3;
                if (a.a(r12, r2, r3) != r0) goto L34;
                return r0;
            L14:
                d.o.a(r11);
            L23:
                if (((Boolean) ZeusTransformUtils.preCheckCast(r11, Boolean.class, "com.obric.aiagent.plugin")).booleanValue() == false) goto L32;
                AppBlackListEventHolder.INSTANCE.clearBlackListEvent();
                Loog r13 = Loog.INSTANCE;
                final c r4 = this.f27320b;
                r13.dp("M-Std-Step/A", new $$Lambda$a$c$a$fOwL2CNuj7repwcJ_7BTJrcPlpY(r4), $$Lambda$a$c$a$D0pRfEIbjhiNNvPcQLR8Qp9xSY.INSTANCE);
                com.obric.autogui.agents.vlm.models.impl.applist.black.g r14 = com.obric.autogui.agents.vlm.models.impl.applist.black.g.f27362a;     // Catch: Throwable -> L12
                Context r5 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AOHostAppTools.INSTANCE.getAppContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L12
                d.c.d<? super x> r7 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L12
                this.f27319a = 2;     // Catch: Throwable -> L12
                if (r14.a(r5, true, r7) != r0) goto L35;
                return r0;
            L32:
                Loog r15 = Loog.INSTANCE;
                final c r10 = this.f27320b;
                r15.ep("M-Std-Step/A", new $$Lambda$a$c$a$H_rJZCTs8JqCQFzFct8735ITKMA(r10), $$Lambda$a$c$a$VG0QXsrlU4oTuAgGizCypykSuYc.INSTANCE);
                goto L34
            L15:
                d.o.a(r11);
                if (c.a(this.f27320b) != null) goto L19;
                Loog r16 = Loog.INSTANCE;
                final c r17 = this.f27320b;
                r16.ep("M-Std-Step/A", new $$Lambda$a$c$a$LeNREF4faPTMWHMYDjWCoexPYJs(r17), $$Lambda$a$c$a$6HktZkMtm7b3fm4QEeTfY5Xi56E.INSTANCE);
                return x.f38692a;
            L19:
                com.obric.autogui.agents.vlm.models.impl.applist.black.g r18 = com.obric.autogui.agents.vlm.models.impl.applist.black.g.f27362a;
                Context r6 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AOHostAppTools.INSTANCE.getAppContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
                String r8 = c.a(this.f27320b);
                j.e r9 = j.e.f27428a;
                d.c.d<? super Boolean> r19 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
                this.f27319a = 1;
                r11 = r18.a(r6, r8, r9, r19);
                if (r11 != r0) goto L23;
                return r0;
            L12:
                th = move-exception;
                Loog.INSTANCE.e("M-Std-Step/A", "[BL-Sync] failed before replay OpenApp: e=" + th, th);
                goto L29
            }

            private static final String a(c r2) {
                return "Cannot find packageName for " + r2.I() + "; Not updatable.";
            }

            private static final String b(c r2) {
                return "Updated: UserBL for " + r2.I() + " -> Enabled.";
            }

            private static final String c(c r2) {
                return "Update Failed: UserBL for " + r2.I();
            }
        }

        public c(a r9, com.obric.autogui.agents.vlm.b.C0677b r10, AppBlackListEvent r11, AppInfoEntry r12) {
            o.e(r10, SensitiveType.SESSION);
            o.e(r11, "event");
            this.f27318e = r9;
            this.g = r10;
            this.h = r11;
            if (r12 == null) goto L7;
            ApplicationInfo r13 = r12.getAppInfo();
            if (r13 == null) goto L7;
            String r14 = r13.packageName;
        L8:
            this.i = r14;
            l(a.a(r9, (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r10.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), r12).toString());
            j(a.f27315a.a().a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r10.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), "blcl_uc4_c", ZeusTransformUtils.mapRes(R.string.std_model_blcl_uc4_c, WsChannelMultiProcessSharedProvider.STRING_TYPE, "std_model_blcl_uc4_c"), new Object[]{I()}));
            a(d.a.p.b(new String[]{a.f27315a.a().a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r10.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), "blcl_uc4_c_negative", ZeusTransformUtils.mapRes(R.string.std_model_blcl_uc4_c_negative, WsChannelMultiProcessSharedProvider.STRING_TYPE, "std_model_blcl_uc4_c_negative"), new Object[0]), a.f27315a.a().a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r10.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), "blcl_uc4_c_active", ZeusTransformUtils.mapRes(R.string.std_model_blcl_uc4_c_active, WsChannelMultiProcessSharedProvider.STRING_TYPE, "std_model_blcl_uc4_c_active"), new Object[0])}));
            b(d.a.p.b(new Boolean[]{false, true}));
            this.j = p.a.EnumC0701a.f27980b;
            String[] r15 = a.f27315a.a().a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r10.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), "blcl_uc4_c_positive_synonym");
            if (r15 == null) goto L13;
            Set<String> r16 = d.a.i.i(r15);
            if (r16 == null) goto L13;
        L14:
            this.k = r16;
            String[] r17 = a.f27315a.a().a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r10.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), "blcl_uc4_c_negative_synonym");
            if (r17 == null) goto L19;
            Set<String> r18 = d.a.i.i(r17);
            if (r18 == null) goto L19;
        L20:
            this.l = r18;
            return;
        L19:
            String[] r19 = ZeusTransformUtils.getResources((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r10.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), "com.obric.aiagent.plugin").getStringArray(ZeusTransformUtils.mapRes(R.array.obric_blcl_uc4_c_negative_synonyms, "array", "obric_blcl_uc4_c_negative_synonyms"));
            o.c(r19, "getStringArray(...)");
            r18 = d.a.i.i((Object[]) ZeusTransformUtils.preCheckCast(r19, Object[].class, "com.obric.aiagent.plugin"));
        L13:
            String[] r20 = ZeusTransformUtils.getResources((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r10.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), "com.obric.aiagent.plugin").getStringArray(ZeusTransformUtils.mapRes(R.array.obric_blcl_uc4_c_positive_synonyms, "array", "obric_blcl_uc4_c_positive_synonyms"));
            o.c(r20, "getStringArray(...)");
            r16 = d.a.i.i((Object[]) ZeusTransformUtils.preCheckCast(r20, Object[].class, "com.obric.aiagent.plugin"));
        L7:
            r14 = null;
            goto L8
        }

        public static final /* synthetic */ String a(c r0) {
            return r0.i;
        }

        public final com.obric.autogui.agents.vlm.b.C0677b L() {
            return this.g;
        }

        @Override // com.obric.autogui.agents.vlm.models.impl.p
        public p.a.EnumC0701a getType() {
            return this.j;
        }

        @Override // com.obric.autogui.agents.vlm.models.impl.p
        public Set<String> J() {
            return this.k;
        }

        @Override // com.obric.autogui.agents.vlm.models.impl.p
        public Set<String> K() {
            return this.l;
        }

        @Override // com.obric.autogui.agents.vlm.models.impl.p
        public void c(boolean r13) {
            d(r13);
            if (r13 == false) goto L5;
            com.obric.autogui.agents.vlm.b.C0677b.a r14 = this.g.o();
            com.obric.autogui.agents.vlm.b.C0677b.a.EnumC0679b r4 = com.obric.autogui.agents.vlm.b.C0677b.a.EnumC0679b.f27123c;
            String r0 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.g.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getString(ZeusTransformUtils.mapRes(R.string.obric_blcl_uc4_c_system_hint, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_blcl_uc4_c_system_hint"), new Object[]{I()});
            o.c(r0, "getString(...)");
            r14.a(r4, r0);
            AOThreadingTools.INSTANCE.launchIO((m) ZeusTransformUtils.preCheckCast(new C0686a(this, this.f27318e, null), m.class, "com.obric.aiagent.plugin"));
            return;
        L5:
            IAutoActionAgentApi.DefaultImpls.systemTerminateQuery$default((IAutoActionAgentApi) ZeusTransformUtils.preCheckCast(AutoActionAgent.INSTANCE, IAutoActionAgentApi.class, "com.obric.aiagent.plugin"), null, a.f27315a.a().a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.g.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), "blcl_uc4_c_reply", ZeusTransformUtils.mapRes(R.string.std_model_blcl_uc4_c_reply, WsChannelMultiProcessSharedProvider.STRING_TYPE, "std_model_blcl_uc4_c_reply"), new Object[]{I()}), 106004, null, null, 24, null);
        }

        private final void d(boolean r8) {
            String r0 = this.h.getActivityName().getPackageName();
            o.c(r0, "getPackageName(...)");
            String r1 = E();
            r r2 = t.f28523a.a(this.g.b());
            if (r2 == null) goto L5;
            com.obric.autogui.agents.vlm.models.omni.l r3 = r2.e();
        L7:
            if (r3 != null) goto L10;
            Loog.INSTANCE.w("M-Std-Step/A", "Target App grant not bound: original Omni action unavailable, sessionId=" + this.g.b() + ", targetPackage=" + r0);
            return;
        L10:
            if (r8 == false) goto L12;
            AOAgentRobotsTools.TargetAppGrantStatus r9 = AOAgentRobotsTools.TargetAppGrantStatus.GRANT;
        L14:
            if (r3.a(r0, r1, r9) == true) goto L24;
            Loog r10 = Loog.INSTANCE;
            StringBuilder r7 = new StringBuilder().append("Target App grant not bound: incomplete fields, sessionId=").append(this.g.b()).append(", targetPackage=").append(r0).append(", hasContent=");
            CharSequence r4 = (CharSequence) ZeusTransformUtils.preCheckCast(r1, CharSequence.class, "com.obric.aiagent.plugin");
            if (r4 != null) goto L18;
        L21:
            boolean r5 = true;
        L22:
            r10.w("M-Std-Step/A", r7.append(!r5).toString());
            return;
        L18:
            if (d.o.o.d(r4) == true) goto L21;
            r5 = false;
            goto L22
        L24:
            Loog.INSTANCE.i("M-Std-Step/A", "Target App grant bound to original Omni action, sessionId=" + this.g.b() + ", toolId=" + r3.a().g() + ", targetPackage=" + r0 + ", status=" + r9.getWireValue());
            return;
        L12:
            r9 = AOAgentRobotsTools.TargetAppGrantStatus.DENY;
            goto L14
        L5:
            r3 = null;
            goto L7
        }

        @Override // com.obric.autogui.agents.vlm.models.impl.p
        public void b(Context r11) {
            o.e((Context) ZeusTransformUtils.wrapperContextForParams(r11, Context.class, "com.obric.aiagent.plugin"), "context");
            IAutoActionAgentApi.DefaultImpls.systemTerminateQuery$default((IAutoActionAgentApi) ZeusTransformUtils.preCheckCast(AutoActionAgent.INSTANCE, IAutoActionAgentApi.class, "com.obric.aiagent.plugin"), null, a.f27315a.a().a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.g.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), "blcl_uc4_c_reply_unclear", ZeusTransformUtils.mapRes(R.string.std_model_blcl_uc4_c_reply_unclear, WsChannelMultiProcessSharedProvider.STRING_TYPE, "std_model_blcl_uc4_c_reply_unclear"), new Object[]{I()}), 106005, null, null, 24, null);
        }

        @Override // com.obric.autogui.agents.vlm.models.impl.e
        public String toString() {
            return "UserBL(" + this.h.getActivityName() + ')';
        }
    }

    /* JADX INFO: compiled from: StdModelAppBlackListHelper.kt */
    private final class d extends p {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ a f27322e;
        private final com.obric.autogui.agents.vlm.b.C0677b g;
        private final AppBlackListEvent h;
        private final p.a.EnumC0701a i;
        private final Set<String> j;
        private final Set<String> k;

        public d(a r9, com.obric.autogui.agents.vlm.b.C0677b r10, AppBlackListEvent r11, AppInfoEntry r12) {
            o.e(r10, SensitiveType.SESSION);
            o.e(r11, "event");
            this.f27322e = r9;
            this.g = r10;
            this.h = r11;
            l(a.a(r9, (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r10.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), r12).toString());
            j(a.f27315a.a().a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r10.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), "blcl_uc4_ext_virus", ZeusTransformUtils.mapRes(R.string.std_model_blcl_uc4_ext_virus, WsChannelMultiProcessSharedProvider.STRING_TYPE, "std_model_blcl_uc4_ext_virus"), new Object[]{I()}));
            a(d.a.p.b(new String[]{a.f27315a.a().a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r10.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), "blcl_uc4_b_negative", ZeusTransformUtils.mapRes(R.string.std_model_blcl_uc4_b_ext_virus_negative, WsChannelMultiProcessSharedProvider.STRING_TYPE, "std_model_blcl_uc4_b_ext_virus_negative"), new Object[0]), a.f27315a.a().a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r10.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), "blcl_uc4_b_active", ZeusTransformUtils.mapRes(R.string.std_model_blcl_uc4_b_active, WsChannelMultiProcessSharedProvider.STRING_TYPE, "std_model_blcl_uc4_b_active"), new Object[0])}));
            b(d.a.p.b(new Boolean[]{false, true}));
            this.i = p.a.EnumC0701a.f27979a;
            String[] r13 = a.f27315a.a().a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r10.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), "blcl_uc4_b_positive_synonym");
            if (r13 == null) goto L7;
            Set<String> r14 = d.a.i.i(r13);
            if (r14 == null) goto L7;
        L8:
            this.j = r14;
            String[] r15 = a.f27315a.a().a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r10.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), "blcl_uc4_b_negative_synonym");
            if (r15 == null) goto L13;
            Set<String> r16 = d.a.i.i(r15);
            if (r16 == null) goto L13;
        L14:
            this.k = r16;
            return;
        L13:
            String[] r17 = ZeusTransformUtils.getResources((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r10.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), "com.obric.aiagent.plugin").getStringArray(ZeusTransformUtils.mapRes(R.array.obric_blcl_virus_negative_synonyms, "array", "obric_blcl_virus_negative_synonyms"));
            o.c(r17, "getStringArray(...)");
            r16 = d.a.i.i((Object[]) ZeusTransformUtils.preCheckCast(r17, Object[].class, "com.obric.aiagent.plugin"));
        L7:
            String[] r18 = ZeusTransformUtils.getResources((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r10.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), "com.obric.aiagent.plugin").getStringArray(ZeusTransformUtils.mapRes(R.array.obric_blcl_virus_positive_synonyms, "array", "obric_blcl_virus_positive_synonyms"));
            o.c(r18, "getStringArray(...)");
            r14 = d.a.i.i((Object[]) ZeusTransformUtils.preCheckCast(r18, Object[].class, "com.obric.aiagent.plugin"));
            goto L8
        }

        @Override // com.obric.autogui.agents.vlm.models.impl.p
        public p.a.EnumC0701a getType() {
            return this.i;
        }

        @Override // com.obric.autogui.agents.vlm.models.impl.p
        public Set<String> J() {
            return this.j;
        }

        @Override // com.obric.autogui.agents.vlm.models.impl.p
        public Set<String> K() {
            return this.k;
        }

        @Override // com.obric.autogui.agents.vlm.models.impl.p
        public void c(boolean r11) {
            if (r11 == false) goto L5;
            com.obric.autogui.agents.vlm.b.C0677b.a r12 = this.g.o();
            com.obric.autogui.agents.vlm.b.C0677b.a.EnumC0679b r2 = com.obric.autogui.agents.vlm.b.C0677b.a.EnumC0679b.f27123c;
            String r10 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.g.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getString(ZeusTransformUtils.mapRes(R.string.obric_blcl_virus_system_hint, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_blcl_virus_system_hint"));
            o.c(r10, "getString(...)");
            r12.a(r2, r10);
            return;
        L5:
            IAutoActionAgentApi.DefaultImpls.systemTerminateQuery$default((IAutoActionAgentApi) ZeusTransformUtils.preCheckCast(AutoActionAgent.INSTANCE, IAutoActionAgentApi.class, "com.obric.aiagent.plugin"), null, a.f27315a.a().a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.g.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), "blcl_uc4_b_reply", ZeusTransformUtils.mapRes(R.string.std_model_blcl_uc4_b_reply, WsChannelMultiProcessSharedProvider.STRING_TYPE, "std_model_blcl_uc4_b_reply"), new Object[]{I()}), 106006, null, null, 24, null);
        }

        @Override // com.obric.autogui.agents.vlm.models.impl.p
        public void b(Context r11) {
            o.e((Context) ZeusTransformUtils.wrapperContextForParams(r11, Context.class, "com.obric.aiagent.plugin"), "context");
            IAutoActionAgentApi.DefaultImpls.systemTerminateQuery$default((IAutoActionAgentApi) ZeusTransformUtils.preCheckCast(AutoActionAgent.INSTANCE, IAutoActionAgentApi.class, "com.obric.aiagent.plugin"), null, a.f27315a.a().a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.g.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), "blcl_uc4_b_reply_unclear", ZeusTransformUtils.mapRes(R.string.std_model_blcl_uc4_b_ext_virus_reply_unclear, WsChannelMultiProcessSharedProvider.STRING_TYPE, "std_model_blcl_uc4_b_ext_virus_reply_unclear"), new Object[]{I()}), 106007, null, null, 24, null);
        }

        @Override // com.obric.autogui.agents.vlm.models.impl.e
        public String toString() {
            return "VirusBL(" + this.h.getActivityName() + ')';
        }
    }

    /* JADX INFO: compiled from: StdModelAppBlackListHelper.kt */
    public /* synthetic */ class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f27323a = null;

        static {
            int[] r0 = new int[AppBlackListState.values().length];
            r0[AppBlackListState.Usable.ordinal()] = 1;     // Catch: NoSuchFieldError -> L12
        L21:
            r0[AppBlackListState.SoftBlackList.ordinal()] = 2;     // Catch: NoSuchFieldError -> L13
        L31:
            r0[AppBlackListState.SAEPBlackList.ordinal()] = 3;     // Catch: NoSuchFieldError -> L14
        L23:
            r0[AppBlackListState.Virus.ordinal()] = 4;     // Catch: NoSuchFieldError -> L15
        L25:
            r0[AppBlackListState.UserDefinedBlackList.ordinal()] = 5;     // Catch: NoSuchFieldError -> L16
        L19:
            r0[AppBlackListState.CannotObtain.ordinal()] = 6;     // Catch: NoSuchFieldError -> L17
        L27:
            r0[AppBlackListState.HardBlackList.ordinal()] = 7;     // Catch: NoSuchFieldError -> L18
        L10:
            f27323a = r0;
        }
    }

    /* JADX INFO: compiled from: StdModelAppBlackListHelper.kt */
    @d.c.b.a.f(b = "StdModelAppBlackListHelper.kt", c = {70, ITaskManager.Stub.TRANSACTION_removeEventTaskExecutionDetailRecordsBySessionId}, d = "maybeGenerateBlackListHandlingStep", e = "com.obric.autogui.agents.vlm.models.impl.applist.StdModelAppBlackListHelper")
    static final class f extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f27324a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f27325b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Object f27326c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        /* synthetic */ Object f27327d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ a f27328e;
        int f;

        f(a r3, d.c.d<? super f> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f27328e = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f27327d = r3;
            this.f |= Integer.MIN_VALUE;
            return this.f27328e.a(null, null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: StdModelAppBlackListHelper.kt */
    @d.c.b.a.f(b = "StdModelAppBlackListHelper.kt", c = {118}, d = "maybeGenerateBlackListHandlingStepLocked", e = "com.obric.autogui.agents.vlm.models.impl.applist.StdModelAppBlackListHelper")
    static final class g extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f27329a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f27330b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Object f27331c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        Object f27332d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        Object f27333e;
        /* synthetic */ Object f;
        final /* synthetic */ a g;
        int h;

        g(a r3, d.c.d<? super g> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.g = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f = r3;
            this.h |= Integer.MIN_VALUE;
            return a.a(this.g, null, null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: StdModelAppBlackListHelper.kt */
    @d.c.b.a.f(b = "StdModelAppBlackListHelper.kt", c = {723}, d = "replayPendingOpenAppIfAny", e = "com.obric.autogui.agents.vlm.models.impl.applist.StdModelAppBlackListHelper")
    static final class h extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        /* synthetic */ Object f27334a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ a f27335b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        int f27336c;

        h(a r3, d.c.d<? super h> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f27335b = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f27334a = r3;
            this.f27336c |= Integer.MIN_VALUE;
            return a.a(this.f27335b, null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: renamed from: lambda$qjy5EFlPihjKQvpzMwSukXQ-4QE, reason: not valid java name */
    public static /* synthetic */ String m744lambda$qjy5EFlPihjKQvpzMwSukXQ4QE(com.obric.autogui.agents.vlm.b.C0677b r0, String r1, String r2) {
        return a(r0, r1, r2);
    }

    public a() {
    }

    public static final /* synthetic */ i a() {
        return f27316b;
    }

    public static final /* synthetic */ CharSequence a(a r2, Context r3, AppInfoEntry r4) {
        return r2.a((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin"), r4);
    }

    public static final /* synthetic */ Object a(a r2, com.obric.autogui.agents.vlm.b.C0677b r3, com.obric.autogui.agents.a.d r4, d.c.d r5) {
        return r2.b(r3, r4, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    public static final /* synthetic */ Object a(a r2, com.obric.autogui.agents.vlm.b.C0677b r3, d.c.d r4) {
        return r2.a(r3, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    public static final /* synthetic */ String a(a r0, com.obric.autogui.agents.vlm.b.C0677b r1, AppBlackListEvent r2, AppInfoEntry r3, String r4) {
        return r0.a(r1, r2, r3, r4);
    }

    static {
        f27315a = new C0685a(null);
        f27316b = new i("app_black_list", 0, 2, null);
    }

    public final Object a(com.obric.autogui.agents.vlm.b.C0677b r7, com.obric.autogui.agents.a.d r8, d.c.d<? super p> r9) {
        d.c.d r10 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r9, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r10, f.class) == false) goto L7;
        f r0 = (f) ZeusTransformUtils.preCheckCast(r10, f.class, "com.obric.aiagent.plugin");
        if ((r0.f & Integer.MIN_VALUE) == 0) goto L7;
        r0.f -= Integer.MIN_VALUE;
    L8:
        Object r11 = r0.f27327d;
        Object r2 = d.c.a.b.a();
        int r3 = r0.f;
        if (r3 == 0) goto L19;
        if (r3 == 1) goto L18;
        if (r3 != 2) goto L17;
        d.o.a(r11);     // Catch: Throwable -> L14
    L26:
        AppBlackListEventHolder.INSTANCE.unlock();
        return r11;
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        r8 = (com.obric.autogui.agents.a.d) ZeusTransformUtils.preCheckCast(r0.f27326c, com.obric.autogui.agents.a.d.class, "com.obric.aiagent.plugin");
        r7 = (com.obric.autogui.agents.vlm.b.C0677b) ZeusTransformUtils.preCheckCast(r0.f27325b, com.obric.autogui.agents.vlm.b.C0677b.class, "com.obric.aiagent.plugin");
        a this = (a) ZeusTransformUtils.preCheckCast(r0.f27324a, a.class, "com.obric.aiagent.plugin");
        d.o.a(r11);
    L23:
        r0.f27324a = null;     // Catch: Throwable -> L14
        r0.f27325b = null;     // Catch: Throwable -> L14
        r0.f27326c = null;     // Catch: Throwable -> L14
        r0.f = 2;     // Catch: Throwable -> L14
        r11 = this.b(r7, r8, r0);     // Catch: Throwable -> L14
        if (r11 != r2) goto L26;
        return r2;
    L19:
        d.o.a(r11);
        AppBlackListEventHolder r12 = AppBlackListEventHolder.INSTANCE;
        r0.f27324a = this;
        r0.f27325b = r7;
        r0.f27326c = r8;
        r0.f = 1;
        if (r12.lock(r0) != r2) goto L23;
        return r2;
    L14:
        th = move-exception;
        AppBlackListEventHolder.INSTANCE.unlock();
        throw th;
    L7:
        r0 = new f(this, r10);
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v48, types: [T, com.obric.autogui.common.api.agent.blacklist.AppBlackListEvent] */
    /* JADX WARN: Type inference failed for: r5v2, types: [T, com.obric.autogui.common.api.agent.blacklist.AppBlackListEvent] */
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
    private final Object b(com.obric.autogui.agents.vlm.b.C0677b r24, com.obric.autogui.agents.a.d r25, d.c.d<? super p> r26) {
        a r0 = this;
        d.c.d r1 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r26, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r1, g.class) == false) goto L7;
        g r3 = (g) ZeusTransformUtils.preCheckCast(r1, g.class, "com.obric.aiagent.plugin");
        if ((r3.h & Integer.MIN_VALUE) == 0) goto L7;
        r3.h -= Integer.MIN_VALUE;
    L8:
        Object r2 = r3.f;
        Object r4 = d.c.a.b.a();
        int r5 = r3.h;
        if (r5 == 0) goto L14;
        if (r5 != 1) goto L13;
        ComponentName r6 = (ComponentName) ZeusTransformUtils.preCheckCast(r3.f27333e, ComponentName.class, "com.obric.aiagent.plugin");
        z.f r7 = (z.f) ZeusTransformUtils.preCheckCast(r3.f27332d, z.f.class, "com.obric.aiagent.plugin");
        com.obric.autogui.agents.a.d r8 = (com.obric.autogui.agents.a.d) ZeusTransformUtils.preCheckCast(r3.f27331c, com.obric.autogui.agents.a.d.class, "com.obric.aiagent.plugin");
        com.obric.autogui.agents.vlm.b.C0677b r10 = (com.obric.autogui.agents.vlm.b.C0677b) ZeusTransformUtils.preCheckCast(r3.f27330b, com.obric.autogui.agents.vlm.b.C0677b.class, "com.obric.aiagent.plugin");
        a r9 = (a) ZeusTransformUtils.preCheckCast(r3.f27329a, a.class, "com.obric.aiagent.plugin");
        d.o.a(r2);
        ComponentName r16 = r6;
        r0 = r9;
        com.obric.autogui.agents.a.d r14 = r8;
        com.obric.autogui.agents.vlm.b.C0677b r13 = r10;
    L38:
        AppBlackListState r11 = (AppBlackListState) ZeusTransformUtils.preCheckCast(r2, AppBlackListState.class, "com.obric.aiagent.plugin");
        if (r11 != AppBlackListState.UserDefinedBlackList) goto L41;
    L44:
        ?? r12 = new AppBlackListEvent(r16, r11, 0, 0, false, 28, null);
        AppBlackListEventHolder.INSTANCE.setBlackListEvent(r12);
        r7.f38504a = r12;
    L45:
        z.f r15 = r7;
    L48:
        if (r15.f38504a != 0) goto L52;
        Loog.INSTANCE.d(TAG, "No ongoing BlackList event.");
        return null;
    L52:
        if (((AppBlackListEvent) ZeusTransformUtils.preCheckCast(r15.f38504a, AppBlackListEvent.class, "com.obric.aiagent.plugin")).getLoopNumber() < 0) goto L58;
        if (((AppBlackListEvent) ZeusTransformUtils.preCheckCast(r15.f38504a, AppBlackListEvent.class, "com.obric.aiagent.plugin")).getLoopNumber() < r13.a().N().get()) goto L58;
        Loog.INSTANCE.w(TAG, "BLHandlingStep is scheduled for a further loop. createdLoop=" + (((AppBlackListEvent) ZeusTransformUtils.preCheckCast(r15.f38504a, AppBlackListEvent.class, "com.obric.aiagent.plugin")).getLoopNumber() - 1) + ". currentLoop=" + (r13.a().N().get() - 1) + ". event=" + r15.f38504a);
        return null;
    L58:
        if (((AppBlackListEvent) ZeusTransformUtils.preCheckCast(r15.f38504a, AppBlackListEvent.class, "com.obric.aiagent.plugin")).isAcknowledged() == false) goto L62;
        Loog.INSTANCE.d(TAG, "BLHandlingStep for " + r15.f38504a + " have been acknowledged.");
        return null;
    L62:
        if (((AppBlackListEvent) ZeusTransformUtils.preCheckCast(r15.f38504a, AppBlackListEvent.class, "com.obric.aiagent.plugin")).getStepNumber() < r14.a()) goto L65;
        Loog.INSTANCE.e(TAG, "BLHandlingStep for " + r15.f38504a + " is already associated with stepId=" + ((AppBlackListEvent) ZeusTransformUtils.preCheckCast(r15.f38504a, AppBlackListEvent.class, "com.obric.aiagent.plugin")).getStepNumber() + " (requestingStepNum=" + r14.a() + ").");
        return null;
    L65:
        AOPackagesTools r17 = AOPackagesTools.INSTANCE;
        Context r18 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r13.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        String r19 = ((AppBlackListEvent) ZeusTransformUtils.preCheckCast(r15.f38504a, AppBlackListEvent.class, "com.obric.aiagent.plugin")).getActivityName().getPackageName();
        o.c(r19, "getPackageName(...)");
        AppInfoEntry r20 = r17.getAppInfo(r18, r19);
        Loog.INSTANCE.d(TAG, "BLHandlingStep for " + r15.f38504a + ", stepId=" + r14.b() + ", origStepNum=" + ((AppBlackListEvent) ZeusTransformUtils.preCheckCast(r15.f38504a, AppBlackListEvent.class, "com.obric.aiagent.plugin")).getStepNumber() + ", will be generated.");
        ((AppBlackListEvent) ZeusTransformUtils.preCheckCast(r15.f38504a, AppBlackListEvent.class, "com.obric.aiagent.plugin")).setStepNumber(r14.a());
        switch(e.f27323a[((AppBlackListEvent) ZeusTransformUtils.preCheckCast(r15.f38504a, AppBlackListEvent.class, "com.obric.aiagent.plugin")).getBlackListState().ordinal()]) {
            case 1: goto L75;
            case 2: goto L74;
            case 3: goto L73;
            case 4: goto L72;
            case 5: goto L71;
            case 6: goto L70;
            case 7: goto L69;
            default: goto L68;
        };
    L69:
        Loog.INSTANCE.e(TAG, "Cannot generate a BLHandlingStep for " + r15.f38504a);
        goto L75
    L70:
        Loog.INSTANCE.e(TAG, "CannotObtain a BLHandlingStep for " + r15.f38504a);
        goto L75
    L71:
        p r21 = r0.d(r13, (AppBlackListEvent) ZeusTransformUtils.preCheckCast(r15.f38504a, AppBlackListEvent.class, "com.obric.aiagent.plugin"), r20);
    L76:
        if (r21 == null) goto L79;
        r21.m(((AppBlackListEvent) ZeusTransformUtils.preCheckCast(r15.f38504a, AppBlackListEvent.class, "com.obric.aiagent.plugin")).getActivityName().getPackageName());
        return r21;
    L79:
        return null;
    L72:
        r21 = r0.c(r13, (AppBlackListEvent) ZeusTransformUtils.preCheckCast(r15.f38504a, AppBlackListEvent.class, "com.obric.aiagent.plugin"), r20);
        goto L76
    L73:
        r21 = r0.b(r13, (AppBlackListEvent) ZeusTransformUtils.preCheckCast(r15.f38504a, AppBlackListEvent.class, "com.obric.aiagent.plugin"), r20);
        goto L76
    L74:
        r21 = r0.a(r13, (AppBlackListEvent) ZeusTransformUtils.preCheckCast(r15.f38504a, AppBlackListEvent.class, "com.obric.aiagent.plugin"), r20);
    L75:
        r21 = null;
        goto L76
    L68:
        throw new k();
    L41:
        if (r11 == AppBlackListState.SAEPBlackList) goto L44;
        if (r11 != AppBlackListState.Virus) goto L45;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        d.o.a(r2);
        r15 = new z.f();
        r15.f38504a = AppBlackListEventHolder.INSTANCE.getBlackListEvent();
        AppBlackListEvent r22 = (AppBlackListEvent) ZeusTransformUtils.preCheckCast(r15.f38504a, AppBlackListEvent.class, "com.obric.aiagent.plugin");
        if (r22 == null) goto L17;
        AppBlackListState r23 = r22.getBlackListState();
    L19:
        if (r23 != AppBlackListState.UserDefinedBlackList) goto L24;
        if (com.obric.autogui.agents.vlm.models.impl.applist.black.g.f27362a.a() == true) goto L24;
        Loog.INSTANCE.i(TAG, "[CC-Auth] discard legacy UserDefined event: " + r15.f38504a);
        AppBlackListEventHolder.INSTANCE.clearBlackListEvent();
        r15.f38504a = null;
    L24:
        if (r15.f38504a != 0) goto L46;
        DisplayedAppInfo r27 = AutoActionVirtualDisplay.INSTANCE.fetchVdTopAppInfo();
        if (r27 == null) goto L46;
        ComponentName r110 = r27.getTopActivity();
        if (r110 != null) goto L30;
        ComponentName r28 = r27.getRealActivity();
    L31:
        if (r28 != null) goto L34;
        Loog.INSTANCE.d(TAG, "[BL] OperatingActivity empty. Not checking BList event.");
        return null;
    L34:
        com.obric.autogui.agents.vlm.models.impl.applist.black.g r111 = com.obric.autogui.agents.vlm.models.impl.applist.black.g.f27362a;
        Context r112 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AOHostAppTools.INSTANCE.getAppContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        String r113 = r28.getPackageName();
        o.c(r113, "getPackageName(...)");
        r3.f27329a = r0;
        r13 = r24;
        r3.f27330b = r13;
        r14 = r25;
        r3.f27331c = r14;
        r3.f27332d = r15;
        r3.f27333e = r28;
        r3.h = 1;
        Object r29 = r111.a(r112, r113, r3);
        if (r29 != r4) goto L37;
        return r4;
    L37:
        r7 = r15;
        r2 = r29;
        r16 = r28;
        goto L38
    L30:
        r28 = r110;
    L46:
        r13 = r24;
        r14 = r25;
        goto L48
    L17:
        r23 = null;
    L7:
        r3 = new g(r0, r1);
        goto L8
    }

    private final CharSequence a(Context r4, AppInfoEntry r5) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.aiagent.plugin");
        if (r5 == null) goto L5;
        CharSequence r6 = r5.getAppLabel();
    L6:
        if (r6 != null) goto L8;
    L11:
        boolean r1 = true;
    L12:
        if (r1 == false) goto L15;
        Loog.INSTANCE.w(TAG, "Trying to acquire an appName for " + r5);
        String r7 = r3.getString(ZeusTransformUtils.mapRes(R.string.std_model_blcl_appname_nil, WsChannelMultiProcessSharedProvider.STRING_TYPE, "std_model_blcl_appname_nil"));
        o.c(r7, "getString(...)");
        return (CharSequence) ZeusTransformUtils.preCheckCast(r7, CharSequence.class, "com.obric.aiagent.plugin");
    L15:
        return r6;
    L8:
        if (d.o.o.d(r6) == true) goto L11;
        r1 = false;
        goto L12
    L5:
        r6 = null;
        goto L6
    }

    private final String a(final com.obric.autogui.agents.vlm.b.C0677b r16, AppBlackListEvent r17, AppInfoEntry r18, String r19) {
        Object r0 = r16.a().F().remove("op_openapp_shortcut_open_context");
        CharSequence r3 = null;
        if (ZeusTransformUtils.instanceOf(r0, com.obric.autogui.operator.a.b.a.a.i.class) == false) goto L5;
        com.obric.autogui.operator.a.b.a.a.i r1 = (com.obric.autogui.operator.a.b.a.a.i) ZeusTransformUtils.preCheckCast(r0, com.obric.autogui.operator.a.b.a.a.i.class, "com.obric.aiagent.plugin");
    L6:
        com.obric.autogui.operator.e r4 = r16.a().r();
        if (r4 == null) goto L9;
        String r5 = r4.W();
    L10:
        int r6 = r16.a().N().get();
        boolean r7 = false;
        if (r17.getLoopNumber() >= 0) goto L13;
    L15:
        boolean r8 = false;
    L16:
        if (r1 != null) goto L18;
    L23:
        boolean r9 = false;
    L24:
        if (r1 == null) goto L33;
        if (r8 == false) goto L30;
        if (r9 == false) goto L30;
        if (r17.getLoopNumber() < r1.d()) goto L30;
        boolean r10 = true;
    L31:
        if (r10 != true) goto L33;
        boolean r11 = true;
    L34:
        if (r1 != null) goto L36;
    L43:
        boolean r2 = false;
    L44:
        if (r1 == null) goto L46;
        String r12 = r1.c();
    L47:
        boolean r13 = o.a(r12, r17.getActivityName().getPackageName());
        Loog r14 = Loog.INSTANCE;
        StringBuilder r15 = new StringBuilder().append("[ShortcutBLTrace] consume shortcut context: rawType=");
        if (r0 == null) goto L52;
        Class<?> r20 = r0.getClass();
        if (r20 == null) goto L52;
        String r21 = r20.getName();
    L53:
        r14.i(TAG, r15.append(r21).append(", context=").append(r1).append(", eventLoop=").append(r17.getLoopNumber()).append(", currentResumedCount=").append(r6).append(", currentStepId=").append(r5).append(", eventPackage=").append(r17.getActivityName().getPackageName()).append(", eventLoopValid=").append(r8).append(", shortcutLoopValid=").append(r9).append(", loopCompatible=").append(r11).append(", stepMatched=").append(r2).append(", hostMatched=").append(r13).toString());
        if (r1 == null) goto L65;
        if (r11 == false) goto L59;
        if (r2 == false) goto L59;
        if (r13 == false) goto L59;
        boolean r22 = true;
    L60:
        if (r22 == true) goto L63;
        r1 = null;
    L63:
        if (r1 == null) goto L65;
        String r23 = r1.b();
    L66:
        C0685a r24 = f27315a;
        if (r18 == null) goto L71;
        CharSequence r25 = r18.getAppLabel();
        if (r25 == null) goto L71;
        String r26 = r25.toString();
    L72:
        String r27 = r24.a(r19, r23, r26, new $$Lambda$a$qjy5EFlPihjKQvpzMwSukXQ4QE(r16));
        Loog r28 = Loog.INSTANCE;
        StringBuilder r29 = new StringBuilder().append("[BL] SystemHint appName resolved: package=").append(r17.getActivityName().getPackageName()).append(", parent=");
        if (r18 == null) goto L75;
        r3 = r18.getAppLabel();
    L75:
        StringBuilder r30 = r29.append(r3).append(", target=").append(r23).append(", isSubApp=");
        if (r23 == null) goto L78;
        r7 = true;
    L78:
        r28.i(TAG, r30.append(r7).append(", result=").append(r27).toString());
        return r27;
    L71:
        r26 = null;
    L59:
        r22 = false;
    L65:
        r23 = null;
    L52:
        r21 = null;
        goto L53
    L46:
        r12 = null;
        goto L47
    L36:
        if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r1.a(), CharSequence.class, "com.obric.aiagent.plugin"))) == true) goto L38;
    L40:
        boolean r31 = false;
    L41:
        if (r31 != true) goto L43;
        r2 = true;
        goto L44
    L38:
        if (o.a(r1.a(), r5) == false) goto L40;
        r31 = true;
    L30:
        r10 = false;
    L33:
        r11 = false;
        goto L34
    L18:
        if (r1.d() < 0) goto L20;
        boolean r32 = true;
    L21:
        if (r32 != true) goto L23;
        r9 = true;
        goto L24
    L20:
        r32 = false;
        goto L21
    L13:
        if (r17.getLoopNumber() >= r6) goto L15;
        r8 = true;
        goto L16
    L9:
        r5 = null;
        goto L10
    L5:
        r1 = null;
        goto L6
    }

    private static final String a(com.obric.autogui.agents.vlm.b.C0677b r3, String r4, String r5) {
        o.e(r4, "target");
        o.e(r5, "parent");
        String r6 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r3.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getString(ZeusTransformUtils.mapRes(R.string.obric_blcl_sub_app_name, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_blcl_sub_app_name"), new Object[]{r4, r5});
        o.c(r6, "getString(...)");
        return r6;
    }

    private final p a(com.obric.autogui.agents.vlm.b.C0677b r10, AppBlackListEvent r11, AppInfoEntry r12) {
        return (p) ZeusTransformUtils.preCheckCast(new b(this, r10, r11, r12, null, 8, null), p.class, "com.obric.aiagent.plugin");
    }

    private final p b(com.obric.autogui.agents.vlm.b.C0677b r8, AppBlackListEvent r9, AppInfoEntry r10) {
        return (p) ZeusTransformUtils.preCheckCast(new b(this, r8, r9, r10, "SAEPBL"), p.class, "com.obric.aiagent.plugin");
    }

    private final p c(com.obric.autogui.agents.vlm.b.C0677b r2, AppBlackListEvent r3, AppInfoEntry r4) {
        return (p) ZeusTransformUtils.preCheckCast(new d(this, r2, r3, r4), p.class, "com.obric.aiagent.plugin");
    }

    private final p d(com.obric.autogui.agents.vlm.b.C0677b r2, AppBlackListEvent r3, AppInfoEntry r4) {
        return (p) ZeusTransformUtils.preCheckCast(new c(this, r2, r3, r4), p.class, "com.obric.aiagent.plugin");
    }

    private final Object a(com.obric.autogui.agents.vlm.b.C0677b r7, d.c.d<? super x> r8) {
        d.c.d r9 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r8, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r9, h.class) == false) goto L7;
        h r0 = (h) ZeusTransformUtils.preCheckCast(r9, h.class, "com.obric.aiagent.plugin");
        if ((r0.f27336c & Integer.MIN_VALUE) == 0) goto L7;
        r0.f27336c -= Integer.MIN_VALUE;
    L8:
        Object r6 = r0.f27334a;
        Object r10 = d.c.a.b.a();
        int r2 = r0.f27336c;
        if (r2 == 0) goto L14;
        if (r2 != 1) goto L13;
        d.o.a(r6);
    L28:
        Loog.INSTANCE.i(TAG, "Replay OpenApp done; failed=" + ((com.obric.autogui.operator.c) ZeusTransformUtils.preCheckCast(r6, com.obric.autogui.operator.c.class, "com.obric.aiagent.plugin")).a());
        return x.f38692a;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        d.o.a(r6);
        com.obric.autogui.session.a r11 = r7.a();
        Object r12 = r11.F().remove("op_openapp_pending_auth");
        if (ZeusTransformUtils.instanceOf(r12, com.obric.autogui.operator.a.b.a.a.b.class) == false) goto L17;
        com.obric.autogui.operator.a.b.a.a.b r13 = (com.obric.autogui.operator.a.b.a.a.b) ZeusTransformUtils.preCheckCast(r12, com.obric.autogui.operator.a.b.a.a.b.class, "com.obric.aiagent.plugin");
    L18:
        if (r13 != null) goto L21;
        Loog.INSTANCE.d(TAG, "No pending OpenApp to replay.");
        return x.f38692a;
    L21:
        Loog.INSTANCE.i(TAG, "Replaying OpenApp after user granted permission.");
        com.obric.autogui.operator.a.b.a.a r3 = new com.obric.autogui.operator.a.b.a.a();
        if (r3.b((com.obric.autogui.operator.b.a) ZeusTransformUtils.preCheckCast(r13, com.obric.autogui.operator.b.a.class, "com.obric.aiagent.plugin")) == true) goto L25;
        Loog.INSTANCE.e(TAG, "Replay OpenApp failed: invalid input");
        return x.f38692a;
    L25:
        Context r14 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r11.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        r0.f27336c = 1;
        r6 = r3.b(r14, r0);
        if (r6 != r10) goto L28;
        return r10;
    L17:
        r13 = null;
    L7:
        r0 = new h(this, r9);
        goto L8
    }
}
