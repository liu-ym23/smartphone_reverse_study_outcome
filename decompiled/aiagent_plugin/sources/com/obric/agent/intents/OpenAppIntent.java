package com.obric.agent.intents;

import android.app.ActivityOptions;
import android.app.Application;
import android.app.KeyguardManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.LauncherApps;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.ShortcutInfo;
import android.os.Build;
import android.os.Parcelable;
import android.os.Process;
import android.os.UserHandle;
import com.bytedance.common.wschannel.WsChannelMultiProcessSharedProvider;
import com.obric.agent.auth.IAgentAuthService;
import com.obric.aiagent.assistant.idl.IFlowAppIntentIDL;
import com.obric.aiagent.assistant.idl.IFlowUiIDL;
import com.obric.aiagent.assistant.idl.aw;
import com.obric.aiagent.assistant.idl.r;
import com.obric.aiagent.executionengine.utils.pkms.PackageInfoCache;
import com.obric.aiagent.platform.depend.IAppContext;
import com.obric.aiagent.platform.depend.ILogDepend;
import com.obric.aiagent.platform.depend.ISecureLogDepend;
import com.obric.aiagent.plugin.R;
import com.obric.capabilitykit.common.DispatchContext;
import com.obric.capabilitykit.common.intent.BaseSystemOpenAppIntent;
import com.obric.capabilitykit.common.intent.Empty;
import com.obric.capabilitykit.common.intent.IntentResult;
import com.obric.capabilitykit.common.intent.SystemOpenAppParams;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.p;
import d.f;
import d.g;
import d.h.b.aa;
import d.h.b.h;
import d.h.b.o;
import d.n.m;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: OpenAppIntent.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class OpenAppIntent extends BaseSystemOpenAppIntent {
    private static final List<String> CAMERA_PACKAGES = null;
    public static final a Companion = null;
    private final f keyguardManager$delegate;

    /* JADX INFO: compiled from: OpenAppIntent.kt */
    public static final class a {
        public /* synthetic */ a(h r1) {
            this();
        }

        private a() {
        }
    }

    /* JADX INFO: compiled from: OpenAppIntent.kt */
    @d.c.b.a.f(b = "OpenAppIntent.kt", c = {46, 47}, d = "doAction", e = "com.obric.agent.intents.OpenAppIntent")
    static final class b extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f14634a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f14635b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Object f14636c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        /* synthetic */ Object f14637d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ OpenAppIntent f14638e;
        int f;

        b(OpenAppIntent r3, d.c.d<? super b> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f14638e = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f14637d = r3;
            this.f |= Integer.MIN_VALUE;
            return this.f14638e.doAction(null, null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: OpenAppIntent.kt */
    @d.c.b.a.f(b = "OpenAppIntent.kt", c = {126}, d = "openAppByName", e = "com.obric.agent.intents.OpenAppIntent")
    static final class c extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f14639a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f14640b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Object f14641c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        Object f14642d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        Object f14643e;
        Object f;
        /* synthetic */ Object g;
        final /* synthetic */ OpenAppIntent h;
        int i;

        c(OpenAppIntent r3, d.c.d<? super c> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.h = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.g = r3;
            this.i |= Integer.MIN_VALUE;
            return OpenAppIntent.access$openAppByName(this.h, null, null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: OpenAppIntent.kt */
    @d.c.b.a.f(b = "OpenAppIntent.kt", c = {64}, d = "tryOpenAppletIfAvailable", e = "com.obric.agent.intents.OpenAppIntent")
    static final class d extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f14644a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f14645b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Object f14646c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        Object f14647d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        /* synthetic */ Object f14648e;
        final /* synthetic */ OpenAppIntent f;
        int g;

        d(OpenAppIntent r3, d.c.d<? super d> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f14648e = r3;
            this.g |= Integer.MIN_VALUE;
            return OpenAppIntent.access$tryOpenAppletIfAvailable(this.f, null, null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: renamed from: lambda$0KUOqqNDUcJf25sTfqus5Y1Ak-E, reason: not valid java name */
    public static /* synthetic */ KeyguardManager m81lambda$0KUOqqNDUcJf25sTfqus5Y1AkE() {
        return keyguardManager_delegate$lambda$0();
    }

    public static /* synthetic */ boolean lambda$4mcHCKvv_cG_CCMUPeYG7wRkKEg(PackageInfoCache.a r0) {
        return getInstalledAppLabels$lambda$5(r0);
    }

    /* JADX INFO: renamed from: lambda$L1cv5ixq-_gzCe9ucCiibBfnTvo, reason: not valid java name */
    public static /* synthetic */ boolean m82lambda$L1cv5ixq_gzCe9ucCiibBfnTvo(String r0) {
        return getInstalledAppLabels$lambda$7(r0);
    }

    public static /* synthetic */ String lambda$oqbVhuC3KZbe2Z678gBlr6EKmKc(PackageInfoCache.a r0) {
        return getInstalledAppLabels$lambda$6(r0);
    }

    public OpenAppIntent() {
        this.keyguardManager$delegate = g.a($$Lambda$OpenAppIntent$0KUOqqNDUcJf25sTfqus5Y1AkE.INSTANCE);
    }

    public static final /* synthetic */ Object access$openAppByName(OpenAppIntent r2, Context r3, SystemOpenAppParams r4, d.c.d r5) {
        return r2.openAppByName((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin"), r4, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    public static final /* synthetic */ Object access$openApplet(OpenAppIntent r2, String r3, d.c.d r4) {
        return r2.openApplet(r3, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    public static final /* synthetic */ Object access$tryOpenAppletIfAvailable(OpenAppIntent r2, Context r3, SystemOpenAppParams r4, d.c.d r5) {
        return r2.tryOpenAppletIfAvailable((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin"), r4, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    @Override // com.obric.capabilitykit.common.intent.BaseSystemOpenAppIntent, com.obric.capabilitykit.common.intent.IntentFunction
    public /* synthetic */ Object doAction(Parcelable r3, DispatchContext r4, d.c.d<? super IntentResult<Empty>> r5) {
        Parcelable r6 = (Parcelable) ZeusTransformUtils.wrapperContextForParams(r3, Parcelable.class, "com.obric.aiagent.plugin");
        d.c.d<? super IntentResult<Empty>> r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
        return doAction((SystemOpenAppParams) ZeusTransformUtils.preCheckCast(r6, SystemOpenAppParams.class, "com.obric.aiagent.plugin"), r4, r7);
    }

    static {
        Companion = new a(null);
        CAMERA_PACKAGES = p.b(new String[]{"com.android.camera", "com.obric.camera2"});
    }

    private final KeyguardManager getKeyguardManager() {
        return (KeyguardManager) ZeusTransformUtils.preCheckCast(this.keyguardManager$delegate.b(), KeyguardManager.class, "com.obric.aiagent.plugin");
    }

    private static final KeyguardManager keyguardManager_delegate$lambda$0() {
        Object r0 = ((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(IAppContext.Companion.getApplication(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin")).getSystemService("keyguard");
        o.a(r0, "null cannot be cast to non-null type android.app.KeyguardManager");
        return (KeyguardManager) ZeusTransformUtils.preCheckCast(r0, KeyguardManager.class, "com.obric.aiagent.plugin");
    }

    @Override // com.obric.capabilitykit.common.intent.BaseSystemOpenAppIntent
    public Object doAction(SystemOpenAppParams r10, DispatchContext r11, d.c.d<? super IntentResult<Empty>> r12) {
        d.c.d r13 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r12, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r13, b.class) == false) goto L7;
        b r1 = (b) ZeusTransformUtils.preCheckCast(r13, b.class, "com.obric.aiagent.plugin");
        if ((r1.f & Integer.MIN_VALUE) == 0) goto L7;
        r1.f -= Integer.MIN_VALUE;
    L8:
        Object r14 = r1.f14637d;
        Object r3 = d.c.a.b.a();
        int r4 = r1.f;
        if (r4 == 0) goto L24;
        if (r4 == 1) goto L19;
        if (r4 != 2) goto L18;
        Context r9 = (Context) ZeusTransformUtils.preCheckCast(r1.f14635b, Context.class, "com.obric.aiagent.plugin");
        OpenAppIntent r15 = (OpenAppIntent) ZeusTransformUtils.preCheckCast(r1.f14634a, OpenAppIntent.class, "com.obric.aiagent.plugin");
        d.o.a(r14);     // Catch: Exception -> L15
    L34:
        return r14;
    L15:
        Exception e2 = e;
        OpenAppIntent r0 = r15;
    L38:
        ILogDepend.Companion.e(r0.getName(), "doAction e=" + e2);
        String r2 = r9.getString(ZeusTransformUtils.mapRes(R.string.obric_open_app_failed_normal, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_open_app_failed_normal"));
        o.c(r2, "getString(...)");
        return genFailedResult$default(r0, r2, 1, false, 4, null);
    L18:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L19:
        r9 = (Context) ZeusTransformUtils.preCheckCast(r1.f14636c, Context.class, "com.obric.aiagent.plugin");
        r10 = (SystemOpenAppParams) ZeusTransformUtils.preCheckCast(r1.f14635b, SystemOpenAppParams.class, "com.obric.aiagent.plugin");
        OpenAppIntent r16 = (OpenAppIntent) ZeusTransformUtils.preCheckCast(r1.f14634a, OpenAppIntent.class, "com.obric.aiagent.plugin");
        d.o.a(r14);     // Catch: Exception -> L22
        Context r17 = r9;
        OpenAppIntent this = r16;
    L28:
        IntentResult r18 = (IntentResult) ZeusTransformUtils.preCheckCast(r14, IntentResult.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L35
        if (r18 == null) goto L31;
        return r18;
    L31:
        r1.f14634a = this;     // Catch: Exception -> L35
        r1.f14635b = r17;     // Catch: Exception -> L35
        r1.f14636c = null;     // Catch: Exception -> L35
        r1.f = 2;     // Catch: Exception -> L35
        r14 = this.openAppByName(r17, r10, r1);     // Catch: Exception -> L35
        if (r14 != r3) goto L34;
        return r3;
    L35:
        Exception e3 = e;
        r0 = this;
        r9 = r17;
    L37:
        e2 = e3;
    L22:
        e3 = e;
        r0 = r16;
        goto L37
    L24:
        d.o.a(r14);
        ISecureLogDepend.Companion.i(getName(), "appName=" + r10.getAppName() + ", appletId=" + r10.getAppletId());
        r17 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r11.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        r1.f14634a = this;     // Catch: Exception -> L35
        r1.f14635b = r10;     // Catch: Exception -> L35
        r1.f14636c = r17;     // Catch: Exception -> L35
        r1.f = 1;     // Catch: Exception -> L35
        r14 = tryOpenAppletIfAvailable(r17, r10, r1);     // Catch: Exception -> L35
        if (r14 != r3) goto L28;
        return r3;
    L7:
        r1 = new b(this, r13);
        goto L8
    }

    private final Object tryOpenAppletIfAvailable(Context r8, SystemOpenAppParams r9, d.c.d<? super IntentResult<Empty>> r10) {
        Context r11 = (Context) ZeusTransformUtils.wrapperContextForParams(r8, Context.class, "com.obric.aiagent.plugin");
        d.c.d r12 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r10, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r12, d.class) == false) goto L7;
        d r0 = (d) ZeusTransformUtils.preCheckCast(r12, d.class, "com.obric.aiagent.plugin");
        if ((r0.g & Integer.MIN_VALUE) == 0) goto L7;
        r0.g -= Integer.MIN_VALUE;
    L8:
        Object r13 = r0.f14648e;
        Object r2 = d.c.a.b.a();
        int r3 = r0.g;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        String r7 = (String) ZeusTransformUtils.preCheckCast(r0.f14647d, String.class, "com.obric.aiagent.plugin");
        String r14 = (String) ZeusTransformUtils.preCheckCast(r0.f14646c, String.class, "com.obric.aiagent.plugin");
        Context r15 = (Context) ZeusTransformUtils.preCheckCast(r0.f14645b, Context.class, "com.obric.aiagent.plugin");
        OpenAppIntent r1 = (OpenAppIntent) ZeusTransformUtils.preCheckCast(r0.f14644a, OpenAppIntent.class, "com.obric.aiagent.plugin");
        d.o.a(r13);
        String r16 = r7;
        OpenAppIntent this = r1;
        Object r4 = r13;
        Context r17 = r15;
    L29:
        if (((Boolean) ZeusTransformUtils.preCheckCast(r4, Boolean.class, "com.obric.aiagent.plugin")).booleanValue() == false) goto L32;
        ISecureLogDepend.Companion.i(this.getName(), "open applet success, appletId=" + r14);
        return this.genSuccessResult(r17, String.valueOf(r16));
    L32:
        ILogDepend.Companion.w(this.getName(), "open applet failed, fallback to open app, appletId=" + r14);
        return null;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        d.o.a(r13);
        String r18 = r9.getAppletId();
        r16 = r9.getAppName();
        CharSequence r5 = (CharSequence) ZeusTransformUtils.preCheckCast(r18, CharSequence.class, "com.obric.aiagent.plugin");
        if (r5 != null) goto L17;
    L20:
        boolean r6 = true;
    L21:
        if (r6 == false) goto L24;
        ILogDepend.Companion.i(getName(), "appletId is null");
        return null;
    L24:
        r0.f14644a = this;
        r0.f14645b = r11;
        r0.f14646c = r18;
        r0.f14647d = r16;
        r0.g = 1;
        r4 = openApplet(r18, r0);
        if (r4 != r2) goto L27;
        return r2;
    L27:
        r17 = r11;
        r14 = r18;
        goto L29
    L17:
        if (d.o.o.d(r5) == true) goto L20;
        r6 = false;
    L7:
        r0 = new d(this, r12);
        goto L8
    }

    private final Object openApplet(String r3, d.c.d<? super Boolean> r4) {
        d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
        ILogDepend.Companion.i(getName(), "openApplet called, appletId=" + r3);
        IFlowAppIntentIDL r2 = r.a(aa.b(IFlowAppIntentIDL.class));
        boolean r6 = true;
        if (r2 != null) goto L5;
    L7:
        r6 = false;
    L9:
        return d.c.b.a.b.a(r6);
    L5:
        if (r2.openMiniApp(r3) != true) goto L7;
        goto L7
    }

    private final Object openAppByName(Context r24, SystemOpenAppParams r25, d.c.d<? super IntentResult<Empty>> r26) {
        SystemOpenAppParams r1 = r25;
        Context r2 = (Context) ZeusTransformUtils.wrapperContextForParams(r24, Context.class, "com.obric.aiagent.plugin");
        d.c.d r4 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r26, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r4, c.class) == false) goto L7;
        c r5 = (c) ZeusTransformUtils.preCheckCast(r4, c.class, "com.obric.aiagent.plugin");
        if ((r5.i & Integer.MIN_VALUE) == 0) goto L7;
        r5.i -= Integer.MIN_VALUE;
    L8:
        c r11 = r5;
        Object r6 = r11.g;
        Object r7 = d.c.a.b.a();
        int r8 = r11.i;
        if (r8 == 0) goto L14;
        if (r8 != 1) goto L13;
        String r0 = (String) ZeusTransformUtils.preCheckCast(r11.f, String.class, "com.obric.aiagent.plugin");
        PackageInfoCache.a r3 = (PackageInfoCache.a) ZeusTransformUtils.preCheckCast(r11.f14643e, PackageInfoCache.a.class, "com.obric.aiagent.plugin");
        PackageManager r9 = (PackageManager) ZeusTransformUtils.preCheckCast(r11.f14642d, PackageManager.class, "com.obric.aiagent.plugin");
        SystemOpenAppParams r10 = (SystemOpenAppParams) ZeusTransformUtils.preCheckCast(r11.f14641c, SystemOpenAppParams.class, "com.obric.aiagent.plugin");
        Context r12 = (Context) ZeusTransformUtils.preCheckCast(r11.f14640b, Context.class, "com.obric.aiagent.plugin");
        OpenAppIntent r13 = (OpenAppIntent) ZeusTransformUtils.preCheckCast(r11.f14639a, OpenAppIntent.class, "com.obric.aiagent.plugin");
        d.o.a(r6);
        String r19 = r0;
        PackageInfoCache.a r16 = r3;
        r1 = r10;
        int r14 = 0;
    L65:
        Boolean r15 = (Boolean) ZeusTransformUtils.preCheckCast(r6, Boolean.class, "com.obric.aiagent.plugin");
        PackageManager r17 = r9;
        r2 = r12;
    L66:
        PackageInfoCache.a r18 = r16;
        String r110 = r19;
        Intent r20 = r17.getLaunchIntentForPackage(r110);
    L69:
        if (r20 != null) goto L71;
        ILogDepend.Companion.e(r13.getName(), "launchIntent is not available for package: " + r110);
        return genFailedResult$default(r13, r13.getOpenAppFailedNotInstallMsg(r2, r1), 1, false, 4, null);
    L71:
        if (Build.VERSION.SDK_INT < 26) goto L73;
        ActivityOptions r21 = ActivityOptions.makeBasic();
        r21.setLaunchDisplayId(r14);
        ZeusTransformUtils.startActivity(r2, r20, r21.toBundle(), "com.obric.aiagent.plugin");
    L74:
        CharSequence r22 = r18.b();
        if (r22 == null) goto L78;
        String r23 = r22.toString();
        if (r23 == null) goto L78;
    L80:
        return r13.genSuccessResult(r2, r23);
    L78:
        r23 = r2.getString(ZeusTransformUtils.mapRes(R.string.obric_open_app_this_app, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_open_app_this_app"));
        o.c(r23, "getString(...)");
        goto L80
    L73:
        ZeusTransformUtils.startActivity(r2, r20, "com.obric.aiagent.plugin");
        goto L74
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        d.o.a(r6);
        CharSequence r27 = (CharSequence) ZeusTransformUtils.preCheckCast(r25.getAppName(), CharSequence.class, "com.obric.aiagent.plugin");
        if (r27 != null) goto L17;
    L20:
        boolean r28 = true;
    L21:
        if (r28 == false) goto L25;
        ILogDepend.Companion.e(getName(), "null AppName: " + r1);
        String r29 = r2.getString(ZeusTransformUtils.mapRes(R.string.obric_open_app_failed_what, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_open_app_failed_what"));
        o.c(r29, "getString(...)");
        return genFailedResult(r29, 0, true);
    L25:
        if (PackageInfoCache.f18569a.a(r2) == true) goto L27;
        ILogDepend.Companion.e(getName(), "PackageInfoCache is not available, do refresh");
        PackageInfoCache.f18569a.b(r2);
    L27:
        r17 = r2.getPackageManager();
        com.obric.aiagent.executionengine.utils.d r30 = com.obric.aiagent.executionengine.utils.d.f18567a;
        String r31 = r25.getAppName();
        o.a(r31);
        r18 = r30.b(r2, r31);
        if (r18 == null) goto L32;
        ApplicationInfo r32 = r18.a();
        if (r32 == null) goto L32;
        String r33 = r32.packageName;
    L33:
        r110 = r33;
        CharSequence r34 = (CharSequence) ZeusTransformUtils.preCheckCast(r110, CharSequence.class, "com.obric.aiagent.plugin");
        if (r34 != null) goto L36;
    L39:
        boolean r35 = true;
    L40:
        if (r35 == false) goto L47;
        ILogDepend.Companion.i(getName(), "no installedPackage available via pm, try searching in Shortcuts");
        String r36 = r25.getAppName();
        o.a(r36);
        if (tryOpenShortcut(r2, r36) == false) goto L45;
        String r37 = r25.getAppName();
        o.a(r37);
        return genSuccessResult(r2, r37);
    L45:
        ILogDepend.Companion.e(getName(), "no installedPackage and no Shortcut available");
        return genFailedResult$default(this, getOpenAppFailedNotInstallMsg(r2, r1), 100, false, 4, null);
    L47:
        ILogDepend.Companion.i(getName(), "candidate package names for " + r25.getAppName() + ": " + r110);
        List<String> r38 = CAMERA_PACKAGES;
        if (r38.contains(r110) == false) goto L56;
        if (getKeyguardManager().isDeviceLocked() == false) goto L56;
        r20 = new Intent("android.media.action.STILL_IMAGE_CAMERA_SECURE");
        r20.addFlags(268435456);
        List<ResolveInfo> r39 = r17.queryIntentActivities(r20, 0);
        o.c(r39, "queryIntentActivities(...)");
        ResolveInfo r40 = (ResolveInfo) ZeusTransformUtils.preCheckCast(p.l(r39), ResolveInfo.class, "com.obric.aiagent.plugin");
        if (r40 == null) goto L54;
        r20.setClassName(r40.activityInfo.packageName, r40.activityInfo.name);
    L54:
        r13 = this;
        r14 = 0;
    L56:
        if (r38.contains(r110) == true) goto L58;
    L67:
        r19 = r110;
        r16 = r18;
        r14 = 0;
        r13 = this;
        goto L66
    L58:
        if (getKeyguardManager().isKeyguardLocked() == false) goto L67;
        IAgentAuthService r41 = (IAgentAuthService) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IAgentAuthService.class), IAgentAuthService.class, "com.obric.aiagent.plugin");
        if (r41 == null) goto L67;
        String r42 = getName();
        r11.f14639a = this;
        r11.f14640b = r2;
        r11.f14641c = r1;
        r11.f14642d = r17;
        r11.f14643e = r18;
        r11.f = r110;
        r11.i = 1;
        r19 = r110;
        r16 = r18;
        r14 = 0;
        Object r43 = IAgentAuthService.b.a(r41, r42, null, false, null, r11, 14, null);
        if (r43 != r7) goto L64;
        return r7;
    L64:
        r13 = this;
        r12 = r2;
        r9 = r17;
        r6 = r43;
        goto L65
    L36:
        if (r34.length() == 0) goto L39;
        r35 = false;
    L32:
        r33 = null;
        goto L33
    L17:
        if (d.o.o.d(r27) == true) goto L20;
        r28 = false;
    L7:
        r5 = new c(this, r4);
        goto L8
    }

    private final boolean tryOpenShortcut(Context r11, String r12) {
        Context r13 = (Context) ZeusTransformUtils.wrapperContextForParams(r11, Context.class, "com.obric.aiagent.plugin");
    L49:
        e = move-exception;
        ILogDepend.Companion.e(getName(), "tryOpenShortcut failed: " + e.getMessage());
        return false;
    L4:
        if (Build.VERSION.SDK_INT >= 25) goto L6;
        return false;
    L6:
        Object r14 = r13.getSystemService("launcherapps");     // Catch: Exception -> L49
        if (ZeusTransformUtils.instanceOf(r14, LauncherApps.class) == false) goto L9;
        LauncherApps r15 = (LauncherApps) ZeusTransformUtils.preCheckCast(r14, LauncherApps.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L49
    L10:
        if (r15 != null) goto L12;
        return false;
    L12:
        UserHandle r6 = Process.myUserHandle();     // Catch: Exception -> L49
        LauncherApps.ShortcutQuery r2 = new LauncherApps.ShortcutQuery();     // Catch: Exception -> L49
        r2.setQueryFlags(1024);     // Catch: Exception -> L49
        List<ShortcutInfo> r3 = r15.getShortcuts(r2, r6);     // Catch: Exception -> L49
        ILogDepend.Companion r4 = ILogDepend.Companion;     // Catch: Exception -> L49
        String r5 = getName();     // Catch: Exception -> L49
        StringBuilder r7 = new StringBuilder().append("query all shortcuts result: count=");     // Catch: Exception -> L49
        if (r3 == null) goto L15;
        int r8 = r3.size();     // Catch: Exception -> L49
    L16:
        r4.i(r5, r7.append(r8).toString());     // Catch: Exception -> L49
        Collection r9 = (Collection) ZeusTransformUtils.preCheckCast(r3, Collection.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L49
        if (r9 != null) goto L19;
    L22:
        boolean r10 = true;
    L23:
        if (r10 == false) goto L26;
        ILogDepend.Companion.w(getName(), "No shortcuts found in global query");     // Catch: Exception -> L49
        return false;
    L26:
        Iterator<ShortcutInfo> r16 = r3.iterator();     // Catch: Exception -> L49
    L28:
        if (r16.hasNext() == false) goto L47;
        ShortcutInfo r17 = (ShortcutInfo) ZeusTransformUtils.preCheckCast(r16.next(), ShortcutInfo.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L49
        CharSequence r18 = r17.getShortLabel();     // Catch: Exception -> L49
        if (r18 == null) goto L32;
        String r19 = r18.toString();     // Catch: Exception -> L49
    L33:
        CharSequence r20 = r17.getLongLabel();     // Catch: Exception -> L49
        if (r20 == null) goto L36;
        String r21 = r20.toString();     // Catch: Exception -> L49
    L38:
        if (d.o.o.a(r19, r12, true) == true) goto L41;
        if (d.o.o.a(r21, r12, true) == false) goto L28;
    L41:
        ILogDepend.Companion.i(getName(), "Matched shortcut: id=" + r17.getId() + ", pkg=" + r17.getPackage() + ", label=" + r19);     // Catch: Exception -> L49
        r15.startShortcut(r17.getPackage(), r17.getId(), null, null, r6);     // Catch: Exception -> L44
        return true;
    L44:
        e = move-exception;
        ILogDepend.Companion.e(getName(), "Failed to start shortcut: " + e.getMessage());     // Catch: Exception -> L49
        return false;
    L36:
        r21 = null;
        goto L38
    L32:
        r19 = null;
        goto L33
    L47:
        ILogDepend.Companion.w(getName(), "No shortcut found matching name: " + r12);     // Catch: Exception -> L49
        return false;
    L19:
        if (r9.isEmpty() == true) goto L22;
        r10 = false;
        goto L23
    L15:
        r8 = 0;
        goto L16
    L9:
        r15 = null;
        goto L10
    }

    private final IntentResult<Empty> genSuccessResult(Context r18, String r19) {
        Context r0 = (Context) ZeusTransformUtils.wrapperContextForParams(r18, Context.class, "com.obric.aiagent.plugin");
        IFlowUiIDL r1 = aw.a(aa.b(IFlowUiIDL.class));
        if (r1 == null) goto L6;
        r1.handleObricAction("obric_action://chat_page.stash_window?data=%7B%22animation%22%3A%22slide%22%7D&key=aiagent_internal", "aiagent_internal", null);
    L6:
        return new IntentResult(0, null, null, r0.getString(ZeusTransformUtils.mapRes(R.string.obric_open_app_success, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_open_app_success"), new Object[]{r19}), false, false, 4194312, null, null, null, 950, null);
    }

    static /* synthetic */ IntentResult genFailedResult$default(OpenAppIntent r0, String r1, int r2, boolean r3, int r4, Object r5) {
        if ((r4 & 2) == 0) goto L6;
        r2 = 1;
    L6:
        if ((r4 & 4) == 0) goto L9;
        r3 = false;
    L9:
        return r0.genFailedResult(r1, r2, r3);
    }

    private final <T> IntentResult<T> genFailedResult(String r15, int r16, boolean r17) {
        return new IntentResult(r16, null, null, r15, r17, false, 1, null, null, null, 416, null);
    }

    private final String getOpenAppFailedNotInstallMsg(Context r18, SystemOpenAppParams r19) {
        Context r0 = (Context) ZeusTransformUtils.wrapperContextForParams(r18, Context.class, "com.obric.aiagent.plugin");
        String r2 = r0.getString(ZeusTransformUtils.mapRes(R.string.obric_open_app_failed_not_install, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_open_app_failed_not_install"), new Object[]{r19.getAppName()});
        o.c(r2, "getString(...)");
        List<String> r5 = getInstalledAppLabels();
        if (r5.isEmpty() == false) goto L6;
        return r2;
    L6:
        return r2 + r0.getString(ZeusTransformUtils.mapRes(R.string.obric_open_app_failed_installed_list, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_open_app_failed_installed_list"), new Object[]{p.a((Iterable) ZeusTransformUtils.preCheckCast(r5, Iterable.class, "com.obric.aiagent.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast("、", CharSequence.class, "com.obric.aiagent.plugin"), null, null, 0, null, null, 62, null)});
    }

    private final List<String> getInstalledAppLabels() {
        return m.g(m.f(m.j(m.a(m.e(m.a(p.y((Iterable) ZeusTransformUtils.preCheckCast(PackageInfoCache.f18569a.b(), Iterable.class, "com.obric.aiagent.plugin")), $$Lambda$OpenAppIntent$4mcHCKvv_cG_CCMUPeYG7wRkKEg.INSTANCE), $$Lambda$OpenAppIntent$oqbVhuC3KZbe2Z678gBlr6EKmKc.INSTANCE), $$Lambda$OpenAppIntent$L1cv5ixq_gzCe9ucCiibBfnTvo.INSTANCE))));
    }

    private static final boolean getInstalledAppLabels$lambda$5(PackageInfoCache.a r1) {
        o.e(r1, "it");
        if (r1.c() == null) goto L5;
        return true;
    L5:
        return false;
    }

    private static final String getInstalledAppLabels$lambda$6(PackageInfoCache.a r2) {
        o.e(r2, "it");
        CharSequence r3 = r2.b();
        if (r3 == null) goto L7;
        String r4 = r3.toString();
        if (r4 == null) goto L7;
        return d.o.o.a((CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.aiagent.plugin")).toString();
    L7:
        return null;
    }

    private static final boolean getInstalledAppLabels$lambda$7(String r2) {
        o.e(r2, "it");
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r2, CharSequence.class, "com.obric.aiagent.plugin")).length() <= 0) goto L5;
        return true;
    L5:
        return false;
    }
}
