package com.obric.autogui.operator.a.b.a.b;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import com.obric.autogui.common.api.logging.Loog;
import com.obric.autogui.common.api.platform.AOPlatformTools;
import com.obric.autogui.common.api.platform.packages.IAutoActionPackagesApi;
import com.obric.autogui.common.api.platform.packages.StartActivityResult;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.c.b.a.k;
import d.h.a.m;
import d.h.b.h;
import d.n.j;
import d.n.l;
import d.o;
import d.s;
import d.x;

/* JADX INFO: compiled from: IntentOpener.kt */
/* JADX INFO: loaded from: classes3.dex */
public class d extends com.obric.autogui.operator.a.b.a.b.b implements com.obric.autogui.operator.a.b.a.b.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f29487a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Intent f29488b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f29489c;

    /* JADX INFO: compiled from: IntentOpener.kt */
    public static final class a {
        public /* synthetic */ a(h r1) {
            this();
        }

        private a() {
        }
    }

    /* JADX INFO: compiled from: IntentOpener.kt */
    @d.c.b.a.f(b = "IntentOpener.kt", c = {116}, d = "maybeKillApp$suspendImpl", e = "com.obric.autogui.operator.impl.op.openapp.opener.IntentOpener")
    static final class b extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f29490a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        /* synthetic */ Object f29491b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ d f29492c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        int f29493d;

        b(d r3, d.c.d<? super b> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f29492c = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f29491b = r3;
            this.f29493d |= Integer.MIN_VALUE;
            return d.b(this.f29492c, null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: IntentOpener.kt */
    @d.c.b.a.f(b = "IntentOpener.kt", c = {40, 41, 47}, d = "invokeSuspend", e = "com.obric.autogui.operator.impl.op.openapp.opener.IntentOpener$providePreChecks$1")
    static final class c extends k implements m<l<? super com.obric.autogui.operator.a.b.a.b.b.b>, d.c.d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f29494a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ d f29495b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private /* synthetic */ Object f29496c;

        c(d r3, d.c.d<? super c> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f29495b = r3;
            super(2, r5);
        }

        public final Object a(l<? super com.obric.autogui.operator.a.b.a.b.b.b> r3, d.c.d<? super x> r4) {
            return ((c) ZeusTransformUtils.preCheckCast(create(r3, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), c.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r3, d.c.d<?> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            c r0 = new c(this.f29495b, r5);
            r0.f29496c = r3;
            return (d.c.d) ZeusTransformUtils.preCheckCast(r0, d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(l<? super com.obric.autogui.operator.a.b.a.b.b.b> r3, d.c.d<? super x> r4) {
            return a((l) ZeusTransformUtils.preCheckCast(r3, l.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r9) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f29494a;
            int r4 = 2;
            String r5 = null;
            Object[] r6 = 0;
            if (r1 == 0) goto L12;
            if (r1 == 1) goto L11;
            if (r1 == 2) goto L10;
            if (r1 != 3) goto L9;
            o.a(r9);
        L27:
            return x.f38692a;
        L9:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L10:
            l r2 = (l) ZeusTransformUtils.preCheckCast(this.f29496c, l.class, "com.obric.aiagent.plugin");
            o.a(r9);
        L23:
            com.obric.autogui.operator.a.b.a.b.b.d r10 = new com.obric.autogui.operator.a.b.a.b.b.d(this.f29495b.b(), this.f29495b.c());
            d.c.d<? super x> r3 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f29496c = null;
            this.f29494a = 3;
            if (r2.a(r10, r3) != r0) goto L27;
            return r0;
        L11:
            r2 = (l) ZeusTransformUtils.preCheckCast(this.f29496c, l.class, "com.obric.aiagent.plugin");
            o.a(r9);
        L16:
            String r7 = this.f29495b.b();
            ComponentName r8 = this.f29495b.d();
            if (r8 == null) goto L19;
            String r11 = r8.getClassName();
        L20:
            com.obric.autogui.operator.a.b.a.b.b.a r12 = new com.obric.autogui.operator.a.b.a.b.b.a(r7, r11);
            d.c.d<? super x> r13 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f29496c = r2;
            this.f29494a = 2;
            if (r2.a(r12, r13) != r0) goto L23;
            return r0;
        L19:
            r11 = null;
            goto L20
        L12:
            o.a(r9);
            l r14 = (l) ZeusTransformUtils.preCheckCast(this.f29496c, l.class, "com.obric.aiagent.plugin");
            com.obric.autogui.operator.a.b.a.b.b.c r15 = new com.obric.autogui.operator.a.b.a.b.b.c(this.f29495b.d(), r5, r4, r6 == true ? 1 : 0);
            d.c.d<? super x> r16 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f29496c = r14;
            this.f29494a = 1;
            if (r14.a(r15, r16) != r0) goto L15;
            return r0;
        L15:
            r2 = r14;
            goto L16
        }
    }

    static {
        f29487a = new a(null);
    }

    @Override // com.obric.autogui.operator.a.b.a.b.a
    public Object b(Context r3, d.c.d<? super d.m<Boolean, String>> r4) {
        return b(this, (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    @Override // com.obric.autogui.operator.a.b.a.b.b
    public Object c(Context r3, d.c.d<? super com.obric.autogui.operator.a.b.a.c> r4) {
        return a(this, (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    public final String c() {
        return this.f29489c;
    }

    public d(Intent r2, String r3) {
        d.h.b.o.e(r2, "candidateIntent");
        this.f29488b = r2;
        this.f29489c = r3;
    }

    @Override // com.obric.autogui.operator.a.b.a.b.b
    public j<com.obric.autogui.operator.a.b.a.b.b.b> a() {
        return d.n.m.a((m) ZeusTransformUtils.preCheckCast(new c(this, null), m.class, "com.obric.aiagent.plugin"));
    }

    static /* synthetic */ Object a(d r22, Context r23, d.c.d<? super com.obric.autogui.operator.a.b.a.c> r24) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r23, Context.class, "com.obric.aiagent.plugin");
        d.c.d r1 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r24, d.c.d.class, "com.obric.aiagent.plugin");
        if (d.h.b.o.a(r22.b(), "com.android.settings") == false) goto L5;
        r22.f29488b.addFlags(67108864);
    L5:
        String r2 = r22.b();
        boolean r3 = r22.e();
        if (r3 == false) goto L8;
        String r5 = "launchApplication";
    L9:
        Loog.INSTANCE.i("Op-OpenApp/IntentOpener", "appPackage=" + r2 + ", route=" + r5 + ", addFlags=" + r22.f29488b.getFlags());
        if (r3 == false) goto L15;
        com.obric.autogui.operator.a.c r6 = com.obric.autogui.operator.a.c.f29713a;
        if (r2 != null) goto L14;
        r2 = "";
    L14:
        StartActivityResult r7 = com.obric.autogui.operator.a.c.a(r6, r4, r2, r22.f29488b, null, 8, null);
    L17:
        if (r7.getOk() == true) goto L21;
        return new com.obric.autogui.operator.a.b.a.c(com.obric.autogui.operator.a.b.a.b.l, null, "c=" + r22.d(), null, null, false, null, 122, null);
    L21:
        return new com.obric.autogui.operator.a.b.a.c(com.obric.autogui.operator.a.b.a.b.f29445a, null, null, null, r22.b(), false, null, 110, null);
    L15:
        r7 = com.obric.autogui.operator.a.c.a(com.obric.autogui.operator.a.c.f29713a, r4, r22.f29488b, null, 4, null);
        goto L17
    L8:
        r5 = "startActivity";
        goto L9
    }

    public String b() {
        String r0 = this.f29488b.getPackage();
        if (r0 != null) goto L9;
        ComponentName r1 = this.f29488b.getComponent();
        if (r1 != null) goto L10;
        return null;
    L10:
        return r1.getPackageName();
    L9:
        return r0;
    }

    public ComponentName d() {
        return this.f29488b.getComponent();
    }

    public final boolean e() {
        CharSequence r0 = (CharSequence) ZeusTransformUtils.preCheckCast(b(), CharSequence.class, "com.obric.aiagent.plugin");
        if (r0 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == false) goto L11;
        return false;
    L11:
        if (a(this.f29488b) == true) goto L13;
        return false;
    L13:
        return true;
    L5:
        if (d.o.o.d(r0) == true) goto L8;
        r1 = false;
        goto L9
    }

    static /* synthetic */ Object b(d r10, Context r11, d.c.d<? super d.m<Boolean, String>> r12) {
        Context r13 = (Context) ZeusTransformUtils.wrapperContextForParams(r11, Context.class, "com.obric.aiagent.plugin");
        d.c.d r14 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r12, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r14, b.class) == false) goto L7;
        b r15 = (b) ZeusTransformUtils.preCheckCast(r14, b.class, "com.obric.aiagent.plugin");
        if ((r15.f29493d & Integer.MIN_VALUE) == 0) goto L7;
        r15.f29493d -= Integer.MIN_VALUE;
    L8:
        b r7 = r15;
        Object r16 = r7.f29491b;
        Object r17 = d.c.a.b.a();
        int r0 = r7.f29493d;
        if (r0 == 0) goto L14;
        if (r0 != 1) goto L13;
        r10 = (d) ZeusTransformUtils.preCheckCast(r7.f29490a, d.class, "com.obric.aiagent.plugin");
        o.a(r16);
    L18:
        return s.a(d.c.b.a.b.a(((Boolean) ZeusTransformUtils.preCheckCast(r16, Boolean.class, "com.obric.aiagent.plugin")).booleanValue()), r10.b());
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        o.a(r16);
        IAutoActionPackagesApi r18 = AOPlatformTools.INSTANCE.packages();
        String r3 = r10.b();
        r7.f29490a = r10;
        r7.f29493d = 1;
        r16 = IAutoActionPackagesApi.DefaultImpls.killAppAndDelay$default(r18, r3, true, 0, r7, 4, null);
        if (r16 != r17) goto L18;
        return r17;
    L7:
        r15 = new b(r10, r14);
        goto L8
    }

    private final boolean a(Intent r2) {
        if (d.h.b.o.a(r2.getAction(), "android.intent.action.MAIN") == true) goto L6;
        return false;
    L6:
        if (r2.hasCategory("android.intent.category.LAUNCHER") == false) goto L8;
    L11:
        return true;
    L8:
        if (r2.hasCategory("android.intent.category.INFO") == true) goto L11;
        if (r2.hasCategory("android.intent.category.LEANBACK_LAUNCHER") == true) goto L11;
        return false;
    }
}
