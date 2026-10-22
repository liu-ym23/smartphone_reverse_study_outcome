package com.obric.aiagent.executionengine.scheduler.impl.a;

import android.app.Application;
import android.app.KeyguardManager;
import android.content.ComponentName;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Parcelable;
import android.os.SystemClock;
import com.bytedance.common.wschannel.WsChannelMultiProcessSharedProvider;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.obric.agent.trace.IIntentMetricsService;
import com.obric.agent.trace.IOmniReportService;
import com.obric.agent.trace.toolmetrics.OmniClientToolTraceServiceImpl;
import com.obric.aiagent.assistant.idl.IFlowVoiceInteractionIDL;
import com.obric.aiagent.assistant.idl.ax;
import com.obric.aiagent.platform.depend.IAppContext;
import com.obric.aiagent.platform.depend.ILogDepend;
import com.obric.aiagent.plugin.R;
import com.obric.autogui.common.api.logging.Loog;
import com.obric.autogui.common.api.platform.AOPlatformTools;
import com.obric.autogui.common.api.platform.display.DisplayedAppInfo;
import com.obric.autogui.common.api.platform.packages.IAutoActionPackagesApi;
import com.obric.autogui.common.api.presentation.api.IAssistInputHost;
import com.obric.autogui.common.api.virtualdisplay.AutoActionVirtualDisplay;
import com.obric.capabilitykit.ActionDispatcher;
import com.obric.capabilitykit.common.AppAction;
import com.obric.capabilitykit.common.ErrorCode;
import com.obric.capabilitykit.common.Ext;
import com.obric.capabilitykit.common.FeedbackResult;
import com.obric.capabilitykit.common.IMAppAction;
import com.obric.capabilitykit.common.IMAppActionExt;
import com.obric.capabilitykit.common.execution.IntentCalling;
import com.obric.capabilitykit.common.intent.IntentFunction;
import com.obric.capabilitykit.common.intent.IntentParams;
import com.obric.capabilitykit.common.intent.IntentResult;
import com.obric.capabilitykit.common.intent.RecorderOperateParams;
import com.obric.capabilitykit.entity.UriTypeAdapter;
import com.obric.capabilitykit.entity.app.AppEntity;
import com.obric.capabilitykit.entity.app.EntityType;
import com.ss.android.socialbase.downloader.constants.DownloadErrorCode;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.ss.bduploader.BDImageUploader;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.ao;
import d.a.p;
import d.h.b.aa;
import d.h.b.z;
import d.n;
import d.o;
import d.s;
import d.x;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.UUID;
import kotlinx.coroutines.am;
import kotlinx.coroutines.dg;

/* JADX INFO: compiled from: AtomExecutorUtils.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class d {
    private static final String TAG = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d f18035a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static Object f18036b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final d.f f18037c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final d.f f18038d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final Gson f18039e = null;

    /* JADX INFO: compiled from: AtomExecutorUtils.kt */
    @d.c.b.a.f(b = "AtomExecutorUtils.kt", c = {189, 202, 208}, d = "dispatchIntent", e = "com.obric.aiagent.executionengine.scheduler.impl.action.AtomExecutorUtils")
    static final class a extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f18040a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f18041b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Object f18042c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        Object f18043d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        long f18044e;
        long f;
        long g;
        /* synthetic */ Object h;
        final /* synthetic */ d i;
        int j;

        a(d r3, d.c.d<? super a> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.i = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.h = r3;
            this.j |= Integer.MIN_VALUE;
            return this.i.a(null, null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: AtomExecutorUtils.kt */
    @d.c.b.a.f(b = "AtomExecutorUtils.kt", c = {EntityType.SIM_CARD}, d = "invokeSuspend", e = "com.obric.aiagent.executionengine.scheduler.impl.action.AtomExecutorUtils$dispatchIntent$result$result$1")
    static final class b extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super com.obric.aiagent.executionengine.scheduler.impl.job.c.C0383c>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f18045a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ kotlinx.coroutines.a.d<com.obric.aiagent.executionengine.scheduler.impl.job.c.C0383c> f18046b;

        b(kotlinx.coroutines.a.d<com.obric.aiagent.executionengine.scheduler.impl.job.c.C0383c> r3, d.c.d<? super b> r4) {
            kotlinx.coroutines.a.d<com.obric.aiagent.executionengine.scheduler.impl.job.c.C0383c> r5 = (kotlinx.coroutines.a.d) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.a.d.class, "com.obric.aiagent.plugin");
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f18046b = r5;
            super(2, r6);
        }

        public final Object a(am r3, d.c.d<? super com.obric.aiagent.executionengine.scheduler.impl.job.c.C0383c> r4) {
            return ((b) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), b.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r2, d.c.d<?> r3) {
            d.c.d r4 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new b(this.f18046b, r4), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super com.obric.aiagent.executionengine.scheduler.impl.job.c.C0383c> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r5) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f18045a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            o.a(r5);
        L16:
            return (com.obric.aiagent.executionengine.scheduler.impl.job.c.C0383c) ZeusTransformUtils.preCheckCast(r5, com.obric.aiagent.executionengine.scheduler.impl.job.c.C0383c.class, "com.obric.aiagent.plugin");
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            o.a(r5);
            kotlinx.coroutines.a.d<com.obric.aiagent.executionengine.scheduler.impl.job.c.C0383c> r6 = this.f18046b;
            if (r6 == null) goto L14;
            d.c.d<? super com.obric.aiagent.executionengine.scheduler.impl.job.c.C0383c> r2 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f18045a = 1;
            r5 = r6.a(r2);
            if (r5 != r0) goto L16;
            return r0;
        L14:
            return null;
        }
    }

    /* JADX INFO: compiled from: AtomExecutorUtils.kt */
    @d.c.b.a.f(b = "AtomExecutorUtils.kt", c = {113, BDImageUploader.MessageIsPreHeatResultUsed}, d = "dispatchServerAction", e = "com.obric.aiagent.executionengine.scheduler.impl.action.AtomExecutorUtils")
    static final class c extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f18047a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f18048b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        long f18049c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        long f18050d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        /* synthetic */ Object f18051e;
        final /* synthetic */ d f;
        int g;

        c(d r3, d.c.d<? super c> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f18051e = r3;
            this.g |= Integer.MIN_VALUE;
            return this.f.a(null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: renamed from: com.obric.aiagent.executionengine.scheduler.impl.a.d$d, reason: collision with other inner class name */
    /* JADX INFO: compiled from: AtomExecutorUtils.kt */
    @d.c.b.a.f(b = "AtomExecutorUtils.kt", c = {126}, d = "invokeSuspend", e = "com.obric.aiagent.executionengine.scheduler.impl.action.AtomExecutorUtils$dispatchServerAction$result$result$1")
    static final class C0372d extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super IMAppAction>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f18052a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ kotlinx.coroutines.a.d<IMAppAction> f18053b;

        C0372d(kotlinx.coroutines.a.d<IMAppAction> r3, d.c.d<? super C0372d> r4) {
            kotlinx.coroutines.a.d<IMAppAction> r5 = (kotlinx.coroutines.a.d) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.a.d.class, "com.obric.aiagent.plugin");
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f18053b = r5;
            super(2, r6);
        }

        public final Object a(am r3, d.c.d<? super IMAppAction> r4) {
            return ((C0372d) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), C0372d.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r2, d.c.d<?> r3) {
            d.c.d r4 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new C0372d(this.f18053b, r4), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super IMAppAction> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r5) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f18052a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            o.a(r5);
        L16:
            return (IMAppAction) ZeusTransformUtils.preCheckCast(r5, IMAppAction.class, "com.obric.aiagent.plugin");
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            o.a(r5);
            kotlinx.coroutines.a.d<IMAppAction> r6 = this.f18053b;
            if (r6 == null) goto L14;
            d.c.d<? super IMAppAction> r2 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f18052a = 1;
            r5 = r6.a(r2);
            if (r5 != r0) goto L16;
            return r0;
        L14:
            return null;
        }
    }

    /* JADX INFO: compiled from: AtomExecutorUtils.kt */
    @d.c.b.a.f(b = "AtomExecutorUtils.kt", c = {395, 460, 510}, d = "execIntentAsync", e = "com.obric.aiagent.executionengine.scheduler.impl.action.AtomExecutorUtils")
    static final class e extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f18054a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f18055b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Object f18056c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        Object f18057d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        Object f18058e;
        Object f;
        Object g;
        Object h;
        Object i;
        Object j;
        Object k;
        Object l;
        Object m;
        long n;
        long o;
        boolean p;
        boolean q;
        boolean r;
        boolean s;
        boolean t;
        int u;
        /* synthetic */ Object v;
        final /* synthetic */ d w;
        int x;

        e(d r3, d.c.d<? super e> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.w = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r7) {
            this.v = r7;
            this.x |= Integer.MIN_VALUE;
            return this.w.a(null, null, 0, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    public static /* synthetic */ KeyguardManager lambda$4B4jlyHTP0epsE2EDcZBCIkjSeM() {
        return d();
    }

    public static /* synthetic */ PackageManager lambda$DlFWSa2eMN5b1iqgHVqVJop8AUU() {
        return e();
    }

    private d() {
    }

    static {
        f18035a = new d();
        TAG = "AtomExecutorUtils";
        f18037c = d.g.a($$Lambda$d$4B4jlyHTP0epsE2EDcZBCIkjSeM.INSTANCE);
        f18038d = d.g.a($$Lambda$d$DlFWSa2eMN5b1iqgHVqVJop8AUU.INSTANCE);
        f18039e = new GsonBuilder().registerTypeAdapter((Type) ZeusTransformUtils.preCheckCast(Uri.class, Type.class, "com.obric.aiagent.plugin"), new UriTypeAdapter()).registerTypeAdapter((Type) ZeusTransformUtils.preCheckCast(AppEntity.class, Type.class, "com.obric.aiagent.plugin"), new com.obric.aiagent.executionengine.scheduler.impl.a.b()).create();
    }

    private final KeyguardManager a() {
        return (KeyguardManager) ZeusTransformUtils.preCheckCast(f18037c.b(), KeyguardManager.class, "com.obric.aiagent.plugin");
    }

    private static final KeyguardManager d() {
        Object r0 = ((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(IAppContext.Companion.getApplication(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin")).getSystemService("keyguard");
        d.h.b.o.a(r0, "null cannot be cast to non-null type android.app.KeyguardManager");
        return (KeyguardManager) ZeusTransformUtils.preCheckCast(r0, KeyguardManager.class, "com.obric.aiagent.plugin");
    }

    private final PackageManager b() {
        return (PackageManager) ZeusTransformUtils.preCheckCast(f18038d.b(), PackageManager.class, "com.obric.aiagent.plugin");
    }

    private static final PackageManager e() {
        return ((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(IAppContext.Companion.getApplication(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin")).getPackageManager();
    }

    public final List<String> a(PackageManager r1) {
        d.h.b.o.e(r1, "pm");
        return p.b();
    }

    public final Object a(IMAppAction r18, d.c.d<? super IMAppAction> r19) {
        IMAppAction r0 = r18;
        d.c.d r1 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r19, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r1, c.class) == false) goto L7;
        c r3 = (c) ZeusTransformUtils.preCheckCast(r1, c.class, "com.obric.aiagent.plugin");
        if ((r3.g & Integer.MIN_VALUE) == 0) goto L7;
        r3.g -= Integer.MIN_VALUE;
    L8:
        Object r2 = r3.f18051e;
        Object r4 = d.c.a.b.a();
        int r5 = r3.g;
        if (r5 == 0) goto L16;
        if (r5 == 1) goto L15;
        if (r5 != 2) goto L14;
        long r6 = r3.f18050d;
        long r7 = r3.f18049c;
        r0 = (IMAppAction) ZeusTransformUtils.preCheckCast(r3.f18047a, IMAppAction.class, "com.obric.aiagent.plugin");
        o.a(r2);
    L39:
        IMAppAction r8 = (IMAppAction) ZeusTransformUtils.preCheckCast(r2, IMAppAction.class, "com.obric.aiagent.plugin");
        com.obric.aiagent.executionengine.scheduler.impl.job.d.f18489a.b(d.c.b.a.b.a(r7), r6);
        String r9 = ((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(IAppContext.Companion.getApplication(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin")).getString(ZeusTransformUtils.mapRes(R.string.obric_action_exe_timeout, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_action_exe_timeout"));
        d.h.b.o.c(r9, "getString(...)");
        if (r8 != null) goto L43;
        r8 = ActionDispatcher.INSTANCE.getAppActionFailResult(r0, 4, r9);
    L43:
        d.h.b.o.a(r8, "null cannot be cast to non-null type com.obric.capabilitykit.common.IMAppAction");
        return r8;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        long r10 = r3.f18050d;
        long r11 = r3.f18049c;
        kotlinx.coroutines.a.d<IMAppAction> r12 = (kotlinx.coroutines.a.d) ZeusTransformUtils.preCheckCast(r3.f18048b, kotlinx.coroutines.a.d.class, "com.obric.aiagent.plugin");
        IMAppAction r13 = (IMAppAction) ZeusTransformUtils.preCheckCast(r3.f18047a, IMAppAction.class, "com.obric.aiagent.plugin");
        o.a(r2);
        kotlinx.coroutines.a.d<IMAppAction> r14 = r12;
        r0 = r13;
    L26:
        if (((Boolean) ZeusTransformUtils.preCheckCast(r2, Boolean.class, "com.obric.aiagent.plugin")).booleanValue() == true) goto L29;
        ILogDepend.Companion.i(TAG, "dispatchServerAction failed");
    L29:
        if (d.h.b.o.a(r0.getAction().getIntent(), "PC_GlobalSearchIntent") == false) goto L32;
        long r15 = 180010;
    L35:
        d.h.a.m r16 = (d.h.a.m) ZeusTransformUtils.preCheckCast(new C0372d(r14, null), d.h.a.m.class, "com.obric.aiagent.plugin");
        r3.f18047a = r0;
        r3.f18048b = null;
        r3.f18049c = r11;
        r3.f18050d = r10;
        r3.g = 2;
        r2 = dg.b(r15, r16, r3);
        if (r2 != r4) goto L38;
        return r4;
    L38:
        r6 = r10;
        r7 = r11;
        goto L39
    L32:
        if (d.h.b.o.a(r0.getAction().getIntent(), "System_LocationRequest") == false) goto L34;
        r15 = 180000;
        goto L35
    L34:
        r15 = OmniClientToolTraceServiceImpl.WATCHDOG_INTERVAL_MS;
        goto L35
    L16:
        o.a(r2);
        ILogDepend.Companion.i(TAG, "dispatchServerAction. action: " + r0);
        String r17 = r18.getAction().getPackageName();
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r17, CharSequence.class, "com.obric.aiagent.plugin")).length() <= 0) goto L19;
        boolean r20 = true;
    L20:
        if (r20 == false) goto L42;
        long r21 = r18.getJobId();
        long r110 = r18.getActionId();
        r14 = com.obric.aiagent.executionengine.scheduler.impl.job.d.f18489a.a(d.c.b.a.b.a(r21), r110);
        com.obric.aiagent.executionengine.scheduler.impl.a r111 = com.obric.aiagent.executionengine.scheduler.impl.a.f17967a;
        r3.f18047a = r0;
        r3.f18048b = r14;
        r3.f18049c = r21;
        r3.f18050d = r110;
        r3.g = 1;
        r2 = r111.a(r0, r17, r3);
        if (r2 != r4) goto L24;
        return r4;
    L24:
        r10 = r110;
        r11 = r21;
        goto L26
    L42:
        r8 = ActionDispatcher.INSTANCE.getAppActionFailResult(r0, ErrorCode.DISPATCH_ERROR, ((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(IAppContext.Companion.getApplication(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin")).getString(ZeusTransformUtils.mapRes(R.string.obric_intent_exec_failed_dispatch_error, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_intent_exec_failed_dispatch_error")));
        goto L43
    L19:
        r20 = false;
    L7:
        r3 = new c(this, r1);
        goto L8
    }

    public final Object a(AppAction r22, long r23, long r25, long r27, long r29, d.c.d<? super IMAppAction> r31) {
        d.c.d<? super IMAppAction> r15 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r31, d.c.d.class, "com.obric.aiagent.plugin");
        String r0 = UUID.randomUUID().toString();
        d.h.b.o.c(r0, "toString(...)");
        String r9 = com.obric.aiagent.executionengine.utils.e.a().toJson(r22);
        return a(new IMAppAction(0, d.c.b.a.b.a(r25), r0, 0, d.c.b.a.b.a(r23), null, r9, null, r29, r27, 0, null, 3241, null), r15);
    }

    public final Object a(String r29, IntentCalling r30, d.c.d<? super com.obric.aiagent.executionengine.scheduler.impl.job.c.C0383c> r31) {
        d r0 = this;
        String r1 = r29;
        IntentCalling r2 = r30;
        d.c.d r4 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r31, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r4, a.class) == false) goto L7;
        a r6 = (a) ZeusTransformUtils.preCheckCast(r4, a.class, "com.obric.aiagent.plugin");
        if ((r6.j & Integer.MIN_VALUE) == 0) goto L7;
        r6.j -= Integer.MIN_VALUE;
    L8:
        Object r5 = r6.h;
        Object r7 = d.c.a.b.a();
        int r8 = r6.j;
        String r9 = WsChannelMultiProcessSharedProvider.STRING_TYPE;
        if (r8 == 0) goto L18;
        if (r8 == 1) goto L17;
        if (r8 == 2) goto L16;
        if (r8 != 3) goto L15;
        long r3 = r6.f18044e;
        com.obric.aiagent.executionengine.scheduler.impl.job.c.C0383c r10 = (com.obric.aiagent.executionengine.scheduler.impl.job.c.C0383c) ZeusTransformUtils.preCheckCast(r6.f18043d, com.obric.aiagent.executionengine.scheduler.impl.job.c.C0383c.class, "com.obric.aiagent.plugin");
        IntentCalling r11 = (IntentCalling) ZeusTransformUtils.preCheckCast(r6.f18042c, IntentCalling.class, "com.obric.aiagent.plugin");
        String r12 = (String) ZeusTransformUtils.preCheckCast(r6.f18041b, String.class, "com.obric.aiagent.plugin");
        d r13 = (d) ZeusTransformUtils.preCheckCast(r6.f18040a, d.class, "com.obric.aiagent.plugin");
        o.a(r5);
        r9 = WsChannelMultiProcessSharedProvider.STRING_TYPE;
    L54:
        com.obric.aiagent.executionengine.scheduler.impl.execution.a.b.f18397a.b(r12, r11);
        if (r10 == null) goto L60;
        return r10;
    L60:
        return r13.a(r11, 4, ((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(IAppContext.Companion.getApplication(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin")).getString(ZeusTransformUtils.mapRes(R.string.obric_action_exe_timeout, r9, "obric_action_exe_timeout")), d.c.b.a.b.a(r3));
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        long r14 = r6.g;
        long r15 = r6.f;
        long r16 = r6.f18044e;
        IntentCalling r17 = (IntentCalling) ZeusTransformUtils.preCheckCast(r6.f18042c, IntentCalling.class, "com.obric.aiagent.plugin");
        String r18 = (String) ZeusTransformUtils.preCheckCast(r6.f18041b, String.class, "com.obric.aiagent.plugin");
        r13 = (d) ZeusTransformUtils.preCheckCast(r6.f18040a, d.class, "com.obric.aiagent.plugin");
        o.a(r5);
        IntentResult<?> r19 = null;
        IntentCalling r20 = r17;
        Object r21 = r5;
        String r22 = r18;
    L46:
        r10 = (com.obric.aiagent.executionengine.scheduler.impl.job.c.C0383c) ZeusTransformUtils.preCheckCast(r21, com.obric.aiagent.executionengine.scheduler.impl.job.c.C0383c.class, "com.obric.aiagent.plugin");
        r3 = SystemClock.elapsedRealtime() - r14;
        com.obric.aiagent.executionengine.scheduler.impl.job.d.f18489a.d(d.c.b.a.b.a(r16), r15);
        com.obric.aiagent.executionengine.scheduler.impl.a r110 = com.obric.aiagent.executionengine.scheduler.impl.a.f17967a;
        if (r10 == null) goto L49;
        IntentResult<?> r111 = r10.a();
    L50:
        r6.f18040a = r13;
        r6.f18041b = r22;
        r6.f18042c = r20;
        r6.f18043d = r10;
        r6.f18044e = r3;
        r6.j = 3;
        if (r110.a(r20, r111, r22, r6) != r7) goto L53;
        return r7;
    L53:
        r11 = r20;
        r12 = r22;
        goto L54
    L49:
        r111 = r19;
        goto L50
    L17:
        long r23 = r6.f;
        long r112 = r6.f18044e;
        kotlinx.coroutines.a.d<com.obric.aiagent.executionengine.scheduler.impl.job.c.C0383c> r24 = (kotlinx.coroutines.a.d) ZeusTransformUtils.preCheckCast(r6.f18043d, kotlinx.coroutines.a.d.class, "com.obric.aiagent.plugin");
        IntentCalling r25 = (IntentCalling) ZeusTransformUtils.preCheckCast(r6.f18042c, IntentCalling.class, "com.obric.aiagent.plugin");
        String r113 = (String) ZeusTransformUtils.preCheckCast(r6.f18041b, String.class, "com.obric.aiagent.plugin");
        d r26 = (d) ZeusTransformUtils.preCheckCast(r6.f18040a, d.class, "com.obric.aiagent.plugin");
        o.a(r5);
        kotlinx.coroutines.a.d<com.obric.aiagent.executionengine.scheduler.impl.job.c.C0383c> r27 = r24;
        r2 = r25;
        r0 = r26;
        r1 = r113;
        r16 = r112;
        r15 = r23;
    L32:
        if (((Boolean) ZeusTransformUtils.preCheckCast(r5, Boolean.class, "com.obric.aiagent.plugin")).booleanValue() == true) goto L34;
        ILogDepend.Companion.i(TAG, "dispatchServerAction failed");
    L34:
        long r28 = SystemClock.elapsedRealtime();
        if (d.h.b.o.a(r2.getIntentName(), "PC_GlobalSearchIntent") == false) goto L39;
        long r114 = 180010;
    L37:
        long r210 = r114;
        r19 = null;
        d.h.a.m r32 = (d.h.a.m) ZeusTransformUtils.preCheckCast(new b(r27, null), d.h.a.m.class, "com.obric.aiagent.plugin");
        r6.f18040a = r0;
        r6.f18041b = r1;
        r6.f18042c = r2;
        r6.f18043d = null;
        r6.f18044e = r16;
        r6.f = r15;
        r6.g = r28;
        r6.j = 2;
        d r115 = r0;
        String r116 = r1;
        Object r33 = dg.b(r210, r32, r6);
        if (r33 != r7) goto L45;
        return r7;
    L45:
        r13 = r115;
        IntentCalling r211 = r2;
        r21 = r33;
        r14 = r28;
        r22 = r116;
        r20 = r211;
        goto L46
    L39:
        if (d.h.b.o.a(r2.getIntentName(), "System_LocationRequest") == false) goto L41;
        r114 = 180000;
        goto L37
    L41:
        r114 = OmniClientToolTraceServiceImpl.WATCHDOG_INTERVAL_MS;
        goto L37
    L18:
        o.a(r5);
        ILogDepend.Companion r34 = ILogDepend.Companion;
        String r35 = TAG;
        r34.i(r35, "dispatchIntent. intent/question: " + r30.getIntentName() + '/' + r30.getQuestionId() + "; targetPackage=" + r1 + " actionId=" + r30.getActionId());
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r1, CharSequence.class, "com.obric.aiagent.plugin")).length() <= 0) goto L21;
        boolean r36 = true;
    L22:
        if (r36 == false) goto L58;
        long r117 = r30.getJobId();
        long r118 = r30.getActionId();
        r27 = com.obric.aiagent.executionengine.scheduler.impl.job.d.f18489a.c(d.c.b.a.b.a(r117), r118);
        Parcelable r119 = r30.getInputParamsParcel();
        if (r119 == null) goto L27;
        long r120 = System.currentTimeMillis();
        com.obric.aiagent.executionengine.scheduler.impl.execution.b.b.f18402a.a(r119, r1);
        ILogDepend.Companion.d(r35, "dispatchIntent. UriSharingRecordExtractor latency=" + (System.currentTimeMillis() - r120) + "(ms)");
    L27:
        com.obric.aiagent.executionengine.scheduler.impl.execution.a.b.f18397a.a(r1, r2);
        m.f18144a.a(r30.getMessageId());
        com.obric.aiagent.executionengine.scheduler.impl.a r37 = com.obric.aiagent.executionengine.scheduler.impl.a.f17967a;
        r6.f18040a = r0;
        r6.f18041b = r1;
        r6.f18042c = r2;
        r6.f18043d = r27;
        r6.f18044e = r117;
        r6.f = r118;
        r6.j = 1;
        r5 = r37.a(r2, r1, r6);
        if (r5 != r7) goto L30;
        return r7;
    L30:
        r16 = r117;
        r15 = r118;
        goto L32
    L58:
        return a(this, r30, ErrorCode.DISPATCH_ERROR, ((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(IAppContext.Companion.getApplication(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin")).getString(ZeusTransformUtils.mapRes(R.string.obric_intent_exec_failed_dispatch_error, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_intent_exec_failed_dispatch_error")), null, 8, null);
    L21:
        r36 = false;
    L7:
        r6 = new a(r0, r4);
        goto L8
    }

    private final Type a(String r9) {
        Set r8 = ServiceManager.get().getServices(IntentFunction.class);
        d.h.b.o.b(r8, "ServiceManager.get().getServices(T::class.java)");
        Iterator r10 = ((Iterable) ZeusTransformUtils.preCheckCast(r8, Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L4:
        if (r10.hasNext() == false) goto L8;
        Object r0 = r10.next();
        if (d.h.b.o.a(((IntentFunction) ZeusTransformUtils.preCheckCast(r0, IntentFunction.class, "com.obric.aiagent.plugin")).getName(), r9) == false) goto L4;
    L9:
        IntentFunction r11 = (IntentFunction) ZeusTransformUtils.preCheckCast(r0, IntentFunction.class, "com.obric.aiagent.plugin");
        if (r11 != null) goto L12;
        return null;
    L12:
        Type[] r12 = r11.getClass().getGenericInterfaces();
        d.h.b.o.c(r12, "getGenericInterfaces(...)");
        Object[] r13 = (Object[]) ZeusTransformUtils.preCheckCast(r12, Object[].class, "com.obric.aiagent.plugin");
        int r14 = r13.length;
        int r3 = 0;
    L13:
        if (r3 >= r14) goto L20;
        Object r4 = r13[r3];
        CharSequence r5 = (CharSequence) ZeusTransformUtils.preCheckCast(((Type) ZeusTransformUtils.preCheckCast(r4, Type.class, "com.obric.aiagent.plugin")).toString(), CharSequence.class, "com.obric.aiagent.plugin");
        String r6 = IntentFunction.class.getSimpleName();
        d.h.b.o.c(r6, "getSimpleName(...)");
        if (d.o.o.c(r5, (CharSequence) ZeusTransformUtils.preCheckCast(r6, CharSequence.class, "com.obric.aiagent.plugin"), false, 2, null) == true) goto L16;
        r3 = r3 + 1;
        goto L13
    L16:
        d.h.b.o.a(r4, "null cannot be cast to non-null type java.lang.reflect.ParameterizedType");
        return ((ParameterizedType) ZeusTransformUtils.preCheckCast(r4, ParameterizedType.class, "com.obric.aiagent.plugin")).getActualTypeArguments()[0];
    L20:
        throw new NoSuchElementException("Array contains no element matching the predicate.");
    L8:
        r0 = null;
        goto L9
    }

    private final Object a(String r5, Type r6) {
        Type r4 = (Type) ZeusTransformUtils.wrapperContextForParams(r6, Type.class, "com.obric.aiagent.plugin");
        Object r7 = f18039e.fromJson(r5, r4);     // Catch: Exception -> L5
    L7:
        if (r7 == null) goto L14;
        return r7;
    L14:
        return f18039e.fromJson("{}", r4);
    L11:
        e = move-exception;
        ILogDepend.Companion.e(TAG, "execIntentAsync -- parseJsonInputParam: empty-param jsonException=" + e);
        return null;
    L5:
        e = move-exception;
        ILogDepend.Companion.e(TAG, "execIntentAsync -- parseJsonInputParam: jsonException=" + e);
        r7 = null;
        goto L7
    }

    /* JADX WARN: Type inference failed for: r5v8, types: [T, java.lang.String] */
    public final Object a(AppAction r65, com.obric.aiagent.executionengine.scheduler.impl.job.c r66, long r67, d.c.d<? super com.obric.aiagent.executionengine.scheduler.impl.job.c.C0383c> r69) {
        d.c.d r3 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r69, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r3, e.class) == false) goto L7;
        e r5 = (e) ZeusTransformUtils.preCheckCast(r3, e.class, "com.obric.aiagent.plugin");
        if ((r5.x & Integer.MIN_VALUE) == 0) goto L7;
        r5.x -= Integer.MIN_VALUE;
    L8:
        Object r4 = r5.v;
        Object r15 = d.c.a.b.a();
        int r6 = r5.x;
        boolean r16 = false;
        if (r6 == 0) goto L18;
        if (r6 == 1) goto L17;
        if (r6 == 2) goto L16;
        if (r6 != 3) goto L15;
        com.obric.aiagent.executionengine.scheduler.impl.job.c.C0383c r0 = (com.obric.aiagent.executionengine.scheduler.impl.job.c.C0383c) ZeusTransformUtils.preCheckCast(r5.f18055b, com.obric.aiagent.executionengine.scheduler.impl.job.c.C0383c.class, "com.obric.aiagent.plugin");
        String r1 = (String) ZeusTransformUtils.preCheckCast(r5.f18054a, String.class, "com.obric.aiagent.plugin");
        o.a(r4);
        String r14 = "com.obric.aiagent.plugin";
    L176:
        boolean r2 = ((Boolean) ZeusTransformUtils.preCheckCast(r4, Boolean.class, r14)).booleanValue();
        Loog.INSTANCE.i(TAG, "kill app app result: " + r2);
        if (r2 == false) goto L179;
        f18035a.b(r1);
    L179:
        x r7 = x.f38692a;
        return r0;
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        boolean r8 = r5.t;
        boolean r9 = r5.s;
        boolean r10 = r5.r;
        boolean r11 = r5.q;
        boolean r12 = r5.p;
        long r13 = r5.n;
        String r17 = (String) ZeusTransformUtils.preCheckCast(r5.g, String.class, "com.obric.aiagent.plugin");
        z.f r18 = (z.f) ZeusTransformUtils.preCheckCast(r5.f, z.f.class, "com.obric.aiagent.plugin");
        String r19 = (String) ZeusTransformUtils.preCheckCast(r5.f18058e, String.class, "com.obric.aiagent.plugin");
        String r20 = (String) ZeusTransformUtils.preCheckCast(r5.f18057d, String.class, "com.obric.aiagent.plugin");
        String r21 = (String) ZeusTransformUtils.preCheckCast(r5.f18056c, String.class, "com.obric.aiagent.plugin");
        String r22 = (String) ZeusTransformUtils.preCheckCast(r5.f18055b, String.class, "com.obric.aiagent.plugin");
        String r23 = (String) ZeusTransformUtils.preCheckCast(r5.f18054a, String.class, "com.obric.aiagent.plugin");
        o.a(r4);
        String r27 = r21;
        String r25 = r22;
        String r26 = r23;
        boolean r38 = r9;
        boolean r37 = r10;
        r14 = "com.obric.aiagent.plugin";
        boolean r34 = r11;
        boolean r35 = r12;
        String r28 = r20;
        String r36 = r19;
        String r24 = r17;
        Object r29 = r15;
        boolean r30 = r8;
    L138:
        com.obric.aiagent.executionengine.scheduler.impl.job.c.C0383c r31 = (com.obric.aiagent.executionengine.scheduler.impl.job.c.C0383c) ZeusTransformUtils.preCheckCast(r4, com.obric.aiagent.executionengine.scheduler.impl.job.c.C0383c.class, r14);
        IIntentMetricsService r32 = (IIntentMetricsService) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IIntentMetricsService.class), IIntentMetricsService.class, r14);
        if (r32 == null) goto L157;
        String r210 = (String) ZeusTransformUtils.preCheckCast(r18.f38504a, String.class, r14);
        IntentResult<?> r33 = r31.a();
        if (r33 == null) goto L143;
        Integer r39 = d.c.b.a.b.a(r33.getRet());
    L144:
        IntentResult<?> r40 = r31.a();
        if (r40 != null) goto L147;
    L149:
        boolean r41 = false;
    L150:
        boolean r42 = true;
        boolean r310 = !r41;
        Long r311 = d.c.b.a.b.a(SystemClock.elapsedRealtime() - r13);
        IMAppActionExt r43 = r31.b().getExt();
        if (r43 == null) goto L155;
        String r44 = (String) ZeusTransformUtils.preCheckCast(r43.get("app_cost"), String.class, r14);
        if (r44 == null) goto L155;
        Long r312 = d.o.o.e(r44);
    L156:
        r32.record((com.obric.agent.trace.k) ZeusTransformUtils.preCheckCast(new com.obric.agent.trace.k.b(r25, r26, r27, r28, r210, r39, r310, r311, r312, r34, r35, r36, r37, r38), com.obric.agent.trace.k.class, r14));
        x r45 = x.f38692a;
    L158:
        IntentResult<?> r46 = r31.a();
        if (r46 == null) goto L185;
        Integer r47 = d.c.b.a.b.a(r46.getRet());
        if (((Number) ZeusTransformUtils.preCheckCast(r47, Number.class, r14)).intValue() != 201) goto L168;
        if (r30 == false) goto L168;
        if (AutoActionVirtualDisplay.INSTANCE.isAppVisibleInMd(r24) == true) goto L168;
        if (AutoActionVirtualDisplay.INSTANCE.getOperatingDisplayId() == 0) goto L168;
        r16 = r42;
    L168:
        if (r16 == true) goto L171;
        r47 = null;
    L171:
        if (r47 == null) goto L186;
        ((Number) ZeusTransformUtils.preCheckCast(r47, Number.class, r14)).intValue();
        Loog.INSTANCE.i(TAG, "privacy statement not agree, try to kill app: " + r24);
        IAutoActionPackagesApi r48 = AOPlatformTools.INSTANCE.packages();
        r5.f18054a = r24;
        r5.f18055b = r31;
        r5.f18056c = null;
        r5.f18057d = null;
        r5.f18058e = null;
        r5.f = null;
        r5.g = null;
        r5.x = 3;
        Object r49 = IAutoActionPackagesApi.DefaultImpls.killAppAndDelay$default(r48, r24, true, 0, r5, 4, null);
        if (r49 != r29) goto L175;
        return r29;
    L175:
        r1 = r24;
        r4 = r49;
        r0 = r31;
        goto L176
    L186:
        return r31;
    L185:
        return r31;
    L155:
        r312 = null;
        goto L156
    L147:
        if (r40.isFinal() == true) goto L149;
        r41 = true;
        goto L150
    L143:
        r39 = null;
        goto L144
    L157:
        r42 = true;
        goto L158
    L17:
        int r50 = r5.u;
        boolean r51 = r5.s;
        boolean r52 = r5.r;
        boolean r53 = r5.q;
        boolean r54 = r5.p;
        long r110 = r5.o;
        int r55 = r50;
        long r56 = r5.n;
        Object r57 = r5.m;
        Type r58 = (Type) ZeusTransformUtils.preCheckCast(r5.l, Type.class, "com.obric.aiagent.plugin");
        String r211 = (String) ZeusTransformUtils.preCheckCast(r5.k, String.class, "com.obric.aiagent.plugin");
        String r59 = (String) ZeusTransformUtils.preCheckCast(r5.j, String.class, "com.obric.aiagent.plugin");
        z.f r60 = (z.f) ZeusTransformUtils.preCheckCast(r5.i, z.f.class, "com.obric.aiagent.plugin");
        String r61 = (String) ZeusTransformUtils.preCheckCast(r5.h, String.class, "com.obric.aiagent.plugin");
        String r62 = (String) ZeusTransformUtils.preCheckCast(r5.g, String.class, "com.obric.aiagent.plugin");
        String r63 = (String) ZeusTransformUtils.preCheckCast(r5.f, String.class, "com.obric.aiagent.plugin");
        String r64 = (String) ZeusTransformUtils.preCheckCast(r5.f18058e, String.class, "com.obric.aiagent.plugin");
        String r68 = (String) ZeusTransformUtils.preCheckCast(r5.f18057d, String.class, "com.obric.aiagent.plugin");
        com.obric.aiagent.executionengine.scheduler.impl.job.c r212 = (com.obric.aiagent.executionengine.scheduler.impl.job.c) ZeusTransformUtils.preCheckCast(r5.f18056c, com.obric.aiagent.executionengine.scheduler.impl.job.c.class, "com.obric.aiagent.plugin");
        AppAction r70 = (AppAction) ZeusTransformUtils.preCheckCast(r5.f18055b, AppAction.class, "com.obric.aiagent.plugin");
        d r71 = (d) ZeusTransformUtils.preCheckCast(r5.f18054a, d.class, "com.obric.aiagent.plugin");
        o.a(r4);
        boolean r510 = r51;
        long r410 = r56;
        e r72 = r5;
        boolean r511 = r52;
        boolean r512 = r53;
        boolean r513 = r54;
        String r73 = WsChannelMultiProcessSharedProvider.STRING_TYPE;
        String r74 = "getString(...)";
        long r514 = r110;
        String r411 = "obric_intent_app_exec_failed";
        String r313 = r59;
        z.f r515 = r60;
        String r516 = r61;
        String r517 = r62;
        String r518 = r63;
        String r412 = r64;
        String r75 = r68;
        Object r76 = r57;
        Type r213 = r58;
        Object r77 = r4;
        AppAction r78 = r70;
        Object r79 = r15;
    L83:
        r14 = "com.obric.aiagent.plugin";
        d.m r80 = (d.m) ZeusTransformUtils.preCheckCast(r77, d.m.class, r14);
        if (r80 == null) goto L87;
        ILogDepend.Companion.w(TAG, "execIntentAsync -- the security-check prohibits intent `" + r75 + "` to continue");
        return a(r410, r412, r75, r518, r517, r515, r514, r512, r513, r516, r511, r510, new IntentResult(((Number) ZeusTransformUtils.preCheckCast(r80.a(), Number.class, r14)).intValue(), null, null, (String) ZeusTransformUtils.preCheckCast(r80.b(), String.class, r14), false, false, 0, null, null, null, DownloadErrorCode.ERROR_REMOVE_DOWNLOAD_RUNNABLE, null));
    L87:
        Object r314 = r79;
        String r111 = r75;
        Type r112 = r213;
        String r81 = r313;
        String r82 = r412;
        String r113 = r518;
        String r114 = r517;
        z.f r115 = r515;
        long r610 = r514;
        boolean r611 = r512;
        boolean r612 = r513;
        String r613 = r516;
        boolean r116 = r511;
        boolean r117 = r510;
        String r519 = r211;
        long r520 = r410;
        AppAction r614 = r78;
        d r83 = r71;
        Object r84 = r76;
        AppAction r85 = r614;
    L90:
        if (ZeusTransformUtils.instanceOf(r84, IntentParams.class) == false) goto L99;
        if (((IntentParams) ZeusTransformUtils.preCheckCast(r84, IntentParams.class, r14)).isParamsCompleted() == true) goto L99;
        ILogDepend.Companion r86 = ILogDepend.Companion;
        String r87 = TAG;
        r86.w(r87, "execIntentAsync -- required params are missing; checking if there are intrinsic errors");
        List<String> r88 = r212.k();
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r88, Collection.class, r14)).isEmpty()) == false) goto L99;
        String r89 = p.a((Iterable) ZeusTransformUtils.preCheckCast(r88, Iterable.class, r14), null, null, null, 0, null, null, 63, null);
        ILogDepend.Companion.e(r87, "execIntentAsync -- required params are missing while error messages are set: " + r89);
        return a(r520, r82, r111, r113, r114, r115, r610, r611, r612, r613, r116, r117, r89, -2004);
    L99:
        if (r83.a(r111, r84) == true) goto L102;
        String r90 = ((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(IAppContext.Companion.getApplication(), r14), Application.class, r14)).getString(ZeusTransformUtils.mapRes(R.string.obric_intent_app_exec_failed, r73, r411));
        d.h.b.o.c(r90, r74);
        return a(r520, r82, r111, r113, r114, r115, r610, r611, r612, r613, r116, r117, r90, -2002);
    L102:
        IOmniReportService r91 = (IOmniReportService) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IOmniReportService.class), IOmniReportService.class, r14);
        if (r91 == null) goto L105;
        r91.recordDispatchIntentStart(r82, r111, r85);
        x r92 = x.f38692a;
    L105:
        boolean r93 = com.obric.autogui.common.a.d.f28974a.aa().contains(r81);
        boolean r94 = AutoActionVirtualDisplay.INSTANCE.isAppVisibleInMd(r81);
        if (r93 == false) goto L110;
        if (r94 == true) goto L110;
        r83.b(r81);
    L110:
        if (ZeusTransformUtils.instanceOf(r84, Parcelable.class) == false) goto L112;
        Parcelable r95 = (Parcelable) ZeusTransformUtils.preCheckCast(r84, Parcelable.class, r14);
    L113:
        if (r95 != null) goto L183;
        Parcelable r96 = null;
    L124:
        long r413 = r212.d();
        long r414 = r212.c();
        long r521 = r212.e();
        long r522 = r212.c();
        if (r55 == 0) goto L127;
        String r523 = null;
    L128:
        if (r55 == 0) goto L130;
        String r615 = null;
    L131:
        if (r55 == 0) goto L133;
        Parcelable r616 = r96;
    L134:
        String r524 = r111;
        IntentCalling r97 = new IntentCalling(r413, r414, r520, r521, r522, r524, r519, r523, r615, r616, r83.a(r520, r111, r212.e(), r212.c(), r212.b()));
        r5 = r72;
        r5.f18054a = r111;
        r5.f18055b = r82;
        r5.f18056c = r113;
        r5.f18057d = r114;
        String r98 = r613;
        r5.f18058e = r98;
        r5.f = r115;
        r5.g = r81;
        r5.h = null;
        r5.i = null;
        r5.j = null;
        r5.k = null;
        r5.l = null;
        r5.m = null;
        String r617 = r82;
        long r99 = r610;
        r5.n = r99;
        boolean r100 = r612;
        r5.p = r100;
        boolean r118 = r611;
        r5.q = r118;
        r5.r = r116;
        boolean r101 = r117;
        r5.s = r101;
        r5.t = r93;
        r5.x = 2;
        r4 = r83.a(r81, r97, r5);
        r29 = r314;
        if (r4 != r29) goto L137;
        return r29;
    L137:
        r30 = r93;
        r25 = r617;
        r38 = r101;
        r35 = r100;
        r24 = r81;
        r26 = r111;
        r34 = r118;
        r27 = r113;
        r28 = r114;
        r18 = r115;
        r37 = r116;
        r36 = r98;
        r13 = r99;
        goto L138
    L133:
        r616 = null;
        goto L134
    L130:
        r615 = r85.getParams();
        goto L131
    L127:
        r523 = r112.getTypeName();
        goto L128
    L183:
        n.a r102 = n.f38560a;     // Catch: Throwable -> L116
        Object r103 = n.f(l.f18143a.a(r81, r111, r95));     // Catch: Throwable -> L116
    L118:
        Throwable r104 = n.c(r103);
        if (r104 != null) goto L121;
        Object r105 = r103;
    L122:
        r96 = (Parcelable) ZeusTransformUtils.preCheckCast(r105, Parcelable.class, r14);
        goto L124
    L121:
        ILogDepend.Companion.e(TAG, "Lark schedule params compatibility failed: " + r104);
        r105 = r95;
    L116:
        th = move-exception;
        n.a r106 = n.f38560a;
        r103 = n.f(o.a(th));
        goto L118
    L112:
        r95 = null;
        goto L113
    L18:
        o.a(r4);
        long r119 = SystemClock.elapsedRealtime();
        String r107 = r65.getAction();
        String r108 = String.valueOf(r66.d());
        String r109 = String.valueOf(r66.e());
        String r120 = String.valueOf(r67);
        n.a r121 = n.f38560a;     // Catch: Throwable -> L21
        Object r122 = n.f(((d) ZeusTransformUtils.preCheckCast(this, d.class, "com.obric.aiagent.plugin")).c());     // Catch: Throwable -> L21
    L24:
        if (n.b(r122) == false) goto L26;
        r122 = null;
    L26:
        String r214 = (String) ZeusTransformUtils.preCheckCast(r122, String.class, "com.obric.aiagent.plugin");
        IMAppActionExt r123 = r66.b().getExt();
        if (r123 == null) goto L29;
        String r124 = (String) ZeusTransformUtils.preCheckCast(r123.get("is_obric_continuous_talk"), String.class, "com.obric.aiagent.plugin");
    L30:
        boolean r125 = d.h.b.o.a(r124, "1");
        r314 = r15;
        boolean r126 = a((Map) ZeusTransformUtils.preCheckCast(r66.b().getExt(), Map.class, "com.obric.aiagent.plugin"));
        IMAppActionExt r127 = r66.b().getExt();
        e r315 = r5;
        if (r127 == null) goto L33;
        String r128 = (String) ZeusTransformUtils.preCheckCast(r127.get("to_server"), String.class, "com.obric.aiagent.plugin");
    L34:
        boolean r129 = d.h.b.o.a(r128, "false");
        String r130 = com.obric.agent.trace.l.f15525a.a(r107, r129);
        boolean r131 = com.obric.agent.trace.l.f15525a.b(r107, r129);
        z.f r132 = new z.f();
        IIntentMetricsService r133 = (IIntentMetricsService) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IIntentMetricsService.class), IIntentMetricsService.class, "com.obric.aiagent.plugin");
        if (r133 == null) goto L38;
        r133.record((com.obric.agent.trace.k) ZeusTransformUtils.preCheckCast(new com.obric.agent.trace.k.c(r108, r107, r109, r120, r214, (String) ZeusTransformUtils.preCheckCast(r132.f38504a, String.class, "com.obric.aiagent.plugin"), d.c.b.a.b.a(r119), r126, r125, r130, r129, r131), com.obric.agent.trace.k.class, "com.obric.aiagent.plugin"));
        x r134 = x.f38692a;
    L38:
        CharSequence r135 = (CharSequence) ZeusTransformUtils.preCheckCast(r65.getPackageName(), CharSequence.class, "com.obric.aiagent.plugin");
        if (r135.length() != 0) goto L41;
        boolean r136 = true;
    L42:
        if (r136 == false) goto L45;
        String r137 = ((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(IAppContext.Companion.getApplication(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin")).getString(ZeusTransformUtils.mapRes(R.string.obric_intent_exec_failed_no_impl_found, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_intent_exec_failed_no_impl_found"));
        d.h.b.o.c(r137, "getString(...)");
        return a(r67, r108, r107, r109, r120, r132, r119, r126, r125, r130, r129, r131, r137, -2002);
    L45:
        String r138 = (String) ZeusTransformUtils.preCheckCast(r135, String.class, "com.obric.aiagent.plugin");
        r66.b(r138);
        r132.f38504a = c(r138);
        String r139 = r65.getImplClassName();
        CharSequence r140 = (CharSequence) ZeusTransformUtils.preCheckCast(r139, CharSequence.class, "com.obric.aiagent.plugin");
        if (r140 != null) goto L48;
    L51:
        boolean r141 = true;
    L53:
        if (r141 == false) goto L56;
        ILogDepend.Companion.e(TAG, "execIntentAsync -- no implClassName found for intent: `" + r107 + '`');
        String r142 = ((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(IAppContext.Companion.getApplication(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin")).getString(ZeusTransformUtils.mapRes(R.string.obric_intent_exec_failed_no_impl_class_found, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_intent_exec_failed_no_impl_class_found"));
        d.h.b.o.c(r142, "getString(...)");
        return a(r67, r108, r107, r109, r120, r132, r119, r126, r125, r130, r129, r131, r142, -2002);
    L56:
        r112 = a(r107);
        if (r112 != null) goto L60;
        ILogDepend.Companion.e(TAG, "execIntentAsync -- inputParamType not found for intent: `" + r107 + '`');
        f18036b = null;
        String r143 = ((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(IAppContext.Companion.getApplication(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin")).getString(ZeusTransformUtils.mapRes(R.string.obric_intent_exec_failed_no_impl_class_found, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_intent_exec_failed_no_impl_class_found"));
        d.h.b.o.c(r143, "getString(...)");
        return a(r67, r108, r107, r109, r120, r132, r119, r126, r125, r130, r129, r131, r143, -2002);
    L60:
        r84 = a(r65.getParams(), r112);
        if (r84 != null) goto L64;
        f18036b = null;
        ILogDepend.Companion.e(TAG, "execIntentAsync -- error occurred parsing InputParams for intent: `" + r107 + '`');
        String r144 = ((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(IAppContext.Companion.getApplication(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin")).getString(ZeusTransformUtils.mapRes(R.string.obric_intent_app_exec_failed, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_intent_app_exec_failed"));
        d.h.b.o.c(r144, "getString(...)");
        return a(r67, r108, r107, r109, r120, r132, r119, r126, r125, r130, r129, r131, r144, -2002);
    L64:
        boolean r145 = ZeusTransformUtils.instanceOf(r84, Parcelable.class);
        if (r145 == true) goto L69;
        ILogDepend.Companion.w(TAG, "execIntentAsync -- not a Parcelable InputParams parsed for intent: `" + r107 + "` (type: `" + r112.getTypeName() + "`); using JSON instead.");
    L69:
        if (ZeusTransformUtils.instanceOf(r84, IntentParams.class) == false) goto L77;
        IMAppActionExt r146 = r66.b().getExt();
        if (r146 == null) goto L73;
        String r147 = (String) ZeusTransformUtils.preCheckCast(r146.get("is_inquire_further"), String.class, "com.obric.aiagent.plugin");
    L75:
        if (d.h.b.o.a(r147, "true") == false) goto L77;
        r84 = ((IntentParams) ZeusTransformUtils.preCheckCast(r84, IntentParams.class, "com.obric.aiagent.plugin")).mergeParams(f18036b);
        goto L77
    L73:
        r147 = null;
    L77:
        f18036b = r84;
        if (ZeusTransformUtils.instanceOf(r84, IntentParams.class) == false) goto L88;
        com.obric.aiagent.executionengine.scheduler.impl.execution.security.a r148 = com.obric.aiagent.executionengine.scheduler.impl.execution.security.a.f18428a;
        String r149 = String.valueOf(r66.d());
        IntentParams r150 = (IntentParams) ZeusTransformUtils.preCheckCast(r84, IntentParams.class, "com.obric.aiagent.plugin");
        IMAppActionExt r151 = r66.b().getExt();
        r72 = r315;
        r72.f18054a = this;
        r72.f18055b = r65;
        r72.f18056c = r66;
        r72.f18057d = r107;
        r72.f18058e = r108;
        r72.f = r109;
        r72.g = r120;
        r72.h = r130;
        r72.i = r132;
        r72.j = r138;
        r72.k = r139;
        r72.l = r112;
        r72.m = r84;
        r213 = r112;
        r72.n = r67;
        r72.o = r119;
        r72.p = r125;
        r72.q = r126;
        r72.r = r129;
        r72.s = r131;
        r72.u = r145 ? 1 : 0;
        r72.x = 1;
        r73 = WsChannelMultiProcessSharedProvider.STRING_TYPE;
        r74 = "getString(...)";
        r313 = r138;
        r411 = "obric_intent_app_exec_failed";
        r79 = r314;
        Object r152 = com.obric.aiagent.executionengine.scheduler.impl.execution.security.a.a(r148, r149, r107, r150, r151, r138, null, r72, 32, null);
        if (r152 != r79) goto L82;
        return r79;
    L82:
        r410 = r67;
        r75 = r107;
        r77 = r152;
        r516 = r130;
        r518 = r109;
        r513 = r125;
        r512 = r126;
        r211 = r139;
        r510 = r131;
        r517 = r120;
        r515 = r132;
        r511 = r129;
        r55 = r145 ? 1 : 0;
        r514 = r119;
        r412 = r108;
        r78 = r65;
        r212 = r66;
        r76 = r84;
        r71 = this;
        goto L83
    L88:
        r411 = r6;
        r74 = "getString(...)";
        r73 = r10;
        r14 = "com.obric.aiagent.plugin";
        r72 = r315;
        ILogDepend.Companion.w(TAG, "execIntentAsync -- not an IntentParams parsed for intent: `" + r107 + "`, got: `" + r84.getClass() + "`;security-check is waived for this execution.");
        r85 = r65;
        r520 = r67;
        r111 = r107;
        r613 = r130;
        r113 = r109;
        r612 = r125;
        r519 = r139;
        r117 = r131;
        r114 = r120;
        r115 = r132;
        r116 = r129;
        r55 = r145 ? 1 : 0;
        r82 = r108;
        r81 = r138;
        r83 = this;
        r212 = r66;
        r611 = r126;
        r610 = r119;
        goto L90
    L48:
        if (r140.length() == 0) goto L51;
        r141 = false;
        goto L53
    L41:
        r136 = false;
        goto L42
    L33:
        r128 = null;
        goto L34
    L29:
        r124 = null;
    L21:
        th = move-exception;
        n.a r153 = n.f38560a;
        r122 = n.f(o.a(th));
    L7:
        r5 = new e(this, r3);
        goto L8
    }

    static /* synthetic */ void a(String r15, String r16, String r17, String r18, z.f r19, long r20, boolean r22, boolean r23, String r24, boolean r25, boolean r26, Integer r27, Long r28, int r29, Object r30) {
        if ((r29 & 4096) == 0) goto L5;
        Long r14 = null;
    L6:
        a(r15, r16, r17, r18, r19, r20, r22, r23, r24, r25, r26, r27, r14);
        return;
    L5:
        r14 = r28;
        goto L6
    }

    private static final com.obric.aiagent.executionengine.scheduler.impl.job.c.C0383c a(long r16, String r18, String r19, String r20, String r21, z.f<String> r22, long r23, boolean r25, boolean r26, String r27, boolean r28, boolean r29, String r30, int r31) {
        a(r18, r19, r20, r21, r22, r23, r25, r26, r27, r28, r29, Integer.valueOf(r31), null, 4096, null);
        return f18035a.b(r30, r16, r31);
    }

    private static final com.obric.aiagent.executionengine.scheduler.impl.job.c.C0383c a(long r17, String r19, String r20, String r21, String r22, z.f<String> r23, long r24, boolean r26, boolean r27, String r28, boolean r29, boolean r30, IntentResult<?> r31) {
        a(r19, r20, r21, r22, r23, r24, r26, r27, r28, r29, r30, Integer.valueOf(r31.getRet()), null, 4096, null);
        return a(f18035a, r31, r17, null, 4, null);
    }

    private final boolean a(String r6, Object r7) {
        if (d.h.b.o.a(r6, "Recorder_Operate") == true) goto L5;
    L32:
        return true;
    L5:
        if (ZeusTransformUtils.instanceOf(r7, RecorderOperateParams.class) == false) goto L32;
        String r8 = ((RecorderOperateParams) ZeusTransformUtils.preCheckCast(r7, RecorderOperateParams.class, "com.obric.aiagent.plugin")).getAction();
        if (d.o.o.a(r8, "start", true) == false) goto L10;
    L13:
        boolean r9 = true;
    L14:
        if (r9 == true) goto L33;
        return true;
    L33:
        n.a r10 = n.f38560a;     // Catch: Throwable -> L24
        d r5 = (d) ZeusTransformUtils.preCheckCast(this, d.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L24
        IFlowVoiceInteractionIDL r11 = ax.a(aa.b(IFlowVoiceInteractionIDL.class));     // Catch: Throwable -> L24
        if (r11 != null) goto L19;
        ILogDepend.Companion.w(TAG, "closeContinuousTalkIfStartingRecording -- voice interaction IPC is null, action=" + r8);     // Catch: Throwable -> L24
        boolean r12 = true;
    L22:
        Object r13 = n.f(Boolean.valueOf(r12));     // Catch: Throwable -> L24
    L26:
        Throwable r14 = n.c(r13);
        if (r14 == null) goto L31;
        ILogDepend.Companion.e(TAG, "closeContinuousTalkIfStartingRecording -- close failed, action=" + r8, r14);
        r13 = true;
    L31:
        return ((Boolean) ZeusTransformUtils.preCheckCast(r13, Boolean.class, "com.obric.aiagent.plugin")).booleanValue();
    L19:
        ILogDepend.Companion r15 = ILogDepend.Companion;     // Catch: Throwable -> L24
        String r2 = TAG;     // Catch: Throwable -> L24
        r15.i(r2, "closeContinuousTalkIfStartingRecording -- close continuous talk, action=" + r8);     // Catch: Throwable -> L24
        r12 = r11.closeContinuousTalk();     // Catch: Throwable -> L24
        if (r12 == true) goto L22;
        ILogDepend.Companion.w(r2, "closeContinuousTalkIfStartingRecording -- continuous talk is still active, action=" + r8);     // Catch: Throwable -> L24
    L24:
        th = move-exception;
        n.a r16 = n.f38560a;
        r13 = n.f(o.a(th));
        goto L26
    L10:
        if (d.o.o.a(r8, "resume", true) == true) goto L13;
        r9 = false;
        goto L14
    }

    private final void b(String r5) {
        Collection<DisplayedAppInfo> r4 = AutoActionVirtualDisplay.INSTANCE.fetchMdTopAppInfo(20, false);
        DisplayedAppInfo r0 = null;
        Object r1 = null;
        if (r4 == null) goto L15;
        Iterator r6 = ((Iterable) ZeusTransformUtils.preCheckCast(r4, Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L6:
        if (r6.hasNext() == false) goto L14;
        Object r2 = r6.next();
        ComponentName r3 = ((DisplayedAppInfo) ZeusTransformUtils.preCheckCast(r2, DisplayedAppInfo.class, "com.obric.aiagent.plugin")).getRealActivity();
        if (r3 == null) goto L10;
        String r7 = r3.getPackageName();
    L12:
        if (d.h.b.o.a(r7, r5) == false) goto L6;
        r1 = r2;
        goto L14
    L10:
        r7 = null;
    L14:
        r0 = (DisplayedAppInfo) ZeusTransformUtils.preCheckCast(r1, DisplayedAppInfo.class, "com.obric.aiagent.plugin");
    L15:
        if (r0 == null) goto L17;
        AutoActionVirtualDisplay.INSTANCE.bringMdAppToVd(r0.getTaskId());
        return;
    L17:
        AutoActionVirtualDisplay.INSTANCE.openAppInVd(r5);
    }

    private final String c() {
        if (a().isKeyguardLocked() == false) goto L6;
        return "lock_screen";
    L6:
        boolean r1 = false;
        n.a r4 = n.f38560a;     // Catch: Throwable -> L26
        d r5 = (d) ZeusTransformUtils.preCheckCast(this, d.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L26
        ComponentName r6 = (ComponentName) ZeusTransformUtils.preCheckCast(AutoActionVirtualDisplay.INSTANCE.getMDTopComponent().a(), ComponentName.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L26
        if (r6 == null) goto L11;
        String r7 = r6.getPackageName();     // Catch: Throwable -> L26
        if (r7 == null) goto L11;
    L24:
        Object r8 = n.f(r7);     // Catch: Throwable -> L26
    L29:
        if (n.b(r8) == false) goto L31;
        r8 = null;
    L31:
        String r9 = (String) ZeusTransformUtils.preCheckCast(r8, String.class, "com.obric.aiagent.plugin");
        CharSequence r10 = (CharSequence) ZeusTransformUtils.preCheckCast(r9, CharSequence.class, "com.obric.aiagent.plugin");
        if (r10 != null) goto L34;
    L35:
        r1 = true;
    L36:
        if (r1 == false) goto L39;
        return null;
    L39:
        if (d.h.b.o.a(r9, ((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(IAppContext.Companion.getApplication(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin")).getPackageName()) == false) goto L41;
    L44:
        return "doubao_chat_page";
    L41:
        if (d.h.b.o.a(r9, "com.larus.nova") == true) goto L44;
        return c(r9);
    L34:
        if (d.o.o.d(r10) == false) goto L36;
    L11:
        Collection<DisplayedAppInfo> r11 = AutoActionVirtualDisplay.INSTANCE.fetchMdTopAppInfo(1, false);     // Catch: Throwable -> L26
        if (r11 == null) goto L18;
        DisplayedAppInfo r12 = (DisplayedAppInfo) ZeusTransformUtils.preCheckCast(p.f((Iterable) ZeusTransformUtils.preCheckCast(r11, Iterable.class, "com.obric.aiagent.plugin")), DisplayedAppInfo.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L26
        if (r12 == null) goto L18;
        ComponentName r13 = r12.getTopActivity();     // Catch: Throwable -> L26
        if (r13 == null) goto L18;
        r7 = r13.getPackageName();     // Catch: Throwable -> L26
    L19:
        if (r7 != null) goto L24;
        ComponentName r14 = (ComponentName) ZeusTransformUtils.preCheckCast(AutoActionVirtualDisplay.INSTANCE.getVdTopComponent().a(), ComponentName.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L26
        if (r14 == null) goto L23;
        r7 = r14.getPackageName();     // Catch: Throwable -> L26
        goto L24
    L23:
        r7 = null;
    L18:
        r7 = null;
    L26:
        th = move-exception;
        n.a r15 = n.f38560a;
        r8 = n.f(o.a(th));
        goto L29
    }

    private final String c(String r6) {
        CharSequence r0 = (CharSequence) ZeusTransformUtils.preCheckCast(r6, CharSequence.class, "com.obric.aiagent.plugin");
        if (r0 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        String r3 = null;
        if (r1 == false) goto L31;
        return null;
    L31:
        n.a r2 = n.f38560a;     // Catch: Throwable -> L18
        d r5 = (d) ZeusTransformUtils.preCheckCast(this, d.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L18
        ApplicationInfo r4 = r5.b().getApplicationInfo(r6, 128);     // Catch: Throwable -> L18
        d.h.b.o.c(r4, "getApplicationInfo(...)");     // Catch: Throwable -> L18
        CharSequence r7 = r5.b().getApplicationLabel(r4);     // Catch: Throwable -> L18
        if (r7 == null) goto L15;
        String r8 = r7.toString();     // Catch: Throwable -> L18
    L16:
        Object r9 = n.f(r8);     // Catch: Throwable -> L18
    L21:
        if (n.b(r9) == false) goto L23;
        r9 = null;
    L23:
        String r10 = (String) ZeusTransformUtils.preCheckCast(r9, String.class, "com.obric.aiagent.plugin");
        if (r10 != null) goto L26;
        return r6;
    L26:
        if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r10, CharSequence.class, "com.obric.aiagent.plugin"))) == false) goto L28;
        r3 = r10;
    L28:
        if (r3 != null) goto L30;
        return r6;
    L30:
        return r3;
    L15:
        r8 = null;
    L18:
        th = move-exception;
        n.a r11 = n.f38560a;
        r9 = n.f(o.a(th));
        goto L21
    L5:
        if (d.o.o.d(r0) == true) goto L8;
        r1 = false;
        goto L9
    }

    private final boolean a(Map<String, String> r5) {
        Map r4 = (Map) ZeusTransformUtils.wrapperContextForParams(r5, Map.class, "com.obric.aiagent.plugin");
        String r6 = null;
        if (r4 == null) goto L5;
        String r1 = (String) ZeusTransformUtils.preCheckCast(r4.get("o_task_type"), String.class, "com.obric.aiagent.plugin");
    L6:
        if (r4 == null) goto L8;
        String r2 = (String) ZeusTransformUtils.preCheckCast(r4.get("o_omni_task_id"), String.class, "com.obric.aiagent.plugin");
    L9:
        if (r2 != null) goto L12;
        r2 = "";
    L12:
        if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r2, CharSequence.class, "com.obric.aiagent.plugin"))) == false) goto L14;
        return true;
    L14:
        if (d.h.b.o.a(r1, IAssistInputHost.TaskType.TASK_TYPE_COMPLEX_TASK) == false) goto L16;
        return true;
    L16:
        if (d.h.b.o.a(r1, IAssistInputHost.TaskType.TASK_TYPE_AUTO_GUI) == true) goto L26;
        if (r4 == null) goto L20;
        r6 = (String) ZeusTransformUtils.preCheckCast(r4.get("o_complex_task"), String.class, "com.obric.aiagent.plugin");
    L20:
        if (d.h.b.o.a(r6, "1") == true) goto L27;
        return false;
    L27:
        return true;
    L26:
        return true;
    L8:
        r2 = null;
        goto L9
    L5:
        r1 = null;
        goto L6
    }

    public final Map<String, String> a(long r2, String r4, long r5, long r7, IMAppAction r9) {
        d.h.b.o.e(r4, "intentName");
        d.h.b.o.e(r9, "appAction");
        HashMap r1 = ao.c(new d.m[]{s.a(Ext.KEY_ACTION_ID, String.valueOf(r2)), s.a(Ext.KEY_INTENT_NAME, r4), s.a(Ext.KEY_IS_PARALLEL, String.valueOf(f.f18081a.a().contains(r4))), s.a(Ext.KEY_JOB_ID, String.valueOf(r5)), s.a(Ext.KEY_REQUEST, com.obric.aiagent.executionengine.utils.e.a().toJson(r9))});
        IMAppActionExt r3 = r9.getExt();
        String r6 = null;
        if (r3 == null) goto L12;
        String r8 = (String) ZeusTransformUtils.preCheckCast(r3.get("o_omni_task_id"), String.class, "com.obric.aiagent.plugin");
        if (r8 == null) goto L12;
        if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r8, CharSequence.class, "com.obric.aiagent.plugin"))) == true) goto L10;
        r8 = null;
    L10:
        if (r8 == null) goto L12;
        ((Map) ZeusTransformUtils.preCheckCast(r1, Map.class, "com.obric.aiagent.plugin")).put("o_omni_task_id", r8);
    L12:
        IMAppActionExt r10 = r9.getExt();
        if (r10 == null) goto L22;
        String r11 = (String) ZeusTransformUtils.preCheckCast(r10.get("inner_log_id"), String.class, "com.obric.aiagent.plugin");
        if (r11 == null) goto L22;
        if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r11, CharSequence.class, "com.obric.aiagent.plugin"))) == true) goto L20;
        r11 = null;
    L20:
        if (r11 == null) goto L22;
        ((Map) ZeusTransformUtils.preCheckCast(r1, Map.class, "com.obric.aiagent.plugin")).put("log_id", r11);
    L22:
        IMAppActionExt r12 = r9.getExt();
        if (r12 == null) goto L31;
        String r13 = (String) ZeusTransformUtils.preCheckCast(r12.get("outbound_sensitive_data"), String.class, "com.obric.aiagent.plugin");
        if (r13 == null) goto L31;
        if ((true ^ d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r13, CharSequence.class, "com.obric.aiagent.plugin"))) == false) goto L29;
        r6 = r13;
    L29:
        if (r6 == null) goto L31;
        ((Map) ZeusTransformUtils.preCheckCast(r1, Map.class, "com.obric.aiagent.plugin")).put("outbound_sensitive_data", r6);
    L31:
        String r14 = m.f18144a.b(r7);
        if (r14 == null) goto L35;
        r1.put("omni_client_tool_trace_id", r14);
    L35:
        return (Map) ZeusTransformUtils.preCheckCast(r1, Map.class, "com.obric.aiagent.plugin");
    }

    public final IMAppAction a(String r21, long r22, int r24) {
        d.h.b.o.e(r21, "details");
        String r9 = new Gson().toJson(new FeedbackResult(r24, r21, null, 0, null, false, 60, null));
        return new IMAppAction(0, null, UUID.randomUUID().toString(), 0, null, null, r9, null, r22, 0, 0, null, 3771, null);
    }

    private final com.obric.aiagent.executionengine.scheduler.impl.job.c.C0383c b(String r30, long r31, int r33) {
        Gson r0 = new Gson();
        IntentResult r10 = new IntentResult(r33, null, null, r30, false, false, 0, null, null, null, DownloadErrorCode.ERROR_REMOVE_DOWNLOAD_RUNNABLE, null);
        String r9 = r0.toJson(new FeedbackResult(r10.getRet(), r10.getDetails(), null, 0, null, false, 60, null));
        return new com.obric.aiagent.executionengine.scheduler.impl.job.c.C0383c(r10, new IMAppAction(0, null, UUID.randomUUID().toString(), 0, null, null, r9, null, r31, 0, 0, null, 3771, null));
    }

    public static /* synthetic */ com.obric.aiagent.executionengine.scheduler.impl.job.c.C0383c a(d r1, IntentCalling r2, int r3, String r4, Long r5, int r6, Object r7) {
        if ((r6 & 4) == 0) goto L6;
        r4 = null;
    L6:
        if ((r6 & 8) == 0) goto L9;
        r5 = null;
    L9:
        return r1.a(r2, r3, r4, r5);
    }

    public final com.obric.aiagent.executionengine.scheduler.impl.job.c.C0383c a(IntentCalling r18, int r19, String r20, Long r21) {
        d.h.b.o.e(r18, "intentCalling");
        IMAppAction r3 = ActionDispatcher.INSTANCE.getIntentFailResult(r18, r19, r20, r21);
        Object r4 = null;
        n.a r0 = n.f38560a;     // Catch: Throwable -> L9
        d r1 = (d) ZeusTransformUtils.preCheckCast(this, d.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L9
        FeedbackResult r2 = (FeedbackResult) ZeusTransformUtils.preCheckCast(com.obric.aiagent.executionengine.utils.e.a().fromJson(r3.getContent(), FeedbackResult.class), FeedbackResult.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L9
        if (r2 == null) goto L6;
        String r5 = r2.getMsg();     // Catch: Throwable -> L9
    L7:
        Object r6 = n.f(r5);     // Catch: Throwable -> L9
    L12:
        if (n.b(r6) == true) goto L15;
        r4 = r6;
    L15:
        String r7 = (String) ZeusTransformUtils.preCheckCast(r4, String.class, "com.obric.aiagent.plugin");
        if (r7 != null) goto L20;
        if (r20 != null) goto L19;
        r7 = ((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(IAppContext.Companion.getApplication(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin")).getString(ZeusTransformUtils.mapRes(R.string.obric_action_failed, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_action_failed"));
        d.h.b.o.c(r7, "getString(...)");
        goto L20
    L19:
        String r8 = r20;
    L22:
        return new com.obric.aiagent.executionengine.scheduler.impl.job.c.C0383c(new IntentResult(r19, null, null, r8, false, false, 0, null, null, null, DownloadErrorCode.ERROR_REMOVE_DOWNLOAD_RUNNABLE, null), r3);
    L20:
        r8 = r7;
        goto L22
    L6:
        r5 = null;
    L9:
        th = move-exception;
        n.a r9 = n.f38560a;
        r6 = n.f(o.a(th));
        goto L12
    }

    public static /* synthetic */ com.obric.aiagent.executionengine.scheduler.impl.job.c.C0383c a(d r0, IntentResult r1, long r2, Long r4, int r5, Object r6) {
        if ((r5 & 4) == 0) goto L6;
        r4 = null;
    L6:
        return r0.a(r1, r2, r4);
    }

    public final com.obric.aiagent.executionengine.scheduler.impl.job.c.C0383c a(IntentResult<?> r21, long r22, Long r24) {
        d.h.b.o.e(r21, "intentResult");
        Gson r2 = new Gson();
        FeedbackResult r14 = new FeedbackResult(r21.getRet(), r21.getDetails(), null, 0, null, false, 60, null);
        IMAppAction r15 = new IMAppAction(0, null, UUID.randomUUID().toString(), 0, null, null, r2.toJson(r14), null, r22, 0, 0, null, 3771, null);
        if (r24 == null) goto L8;
        IMAppActionExt r1 = r15.getExt();
        if (r1 != null) goto L7;
        r1 = new IMAppActionExt();
    L7:
        r1.put("app_cost", r24.toString());
        IMAppAction r3 = r15;
        r3.setExt(r1);
    L10:
        return new com.obric.aiagent.executionengine.scheduler.impl.job.c.C0383c(r21, r3);
    L8:
        r3 = r15;
        goto L10
    }

    private static final void a(String r18, String r19, String r20, String r21, z.f<String> r22, long r23, boolean r25, boolean r26, String r27, boolean r28, boolean r29, Integer r30, Long r31) {
        IIntentMetricsService r0 = (IIntentMetricsService) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IIntentMetricsService.class), IIntentMetricsService.class, "com.obric.aiagent.plugin");
        if (r0 == null) goto L6;
        r0.record((com.obric.agent.trace.k) ZeusTransformUtils.preCheckCast(new com.obric.agent.trace.k.b(r18, r19, r20, r21, (String) ZeusTransformUtils.preCheckCast(r22.f38504a, String.class, "com.obric.aiagent.plugin"), r30, true, Long.valueOf(SystemClock.elapsedRealtime() - r23), r31, r25, r26, r27, r28, r29), com.obric.agent.trace.k.class, "com.obric.aiagent.plugin"));
        return;
    }
}
