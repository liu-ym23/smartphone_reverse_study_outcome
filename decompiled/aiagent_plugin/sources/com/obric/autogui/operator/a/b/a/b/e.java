package com.obric.autogui.operator.a.b.a.b;

import android.content.Context;
import com.obric.autogui.common.api.logging.Loog;
import com.obric.autogui.common.api.platform.AOPlatformTools;
import com.obric.autogui.common.api.platform.packages.IAutoActionPackagesApi;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;
import d.m;
import d.s;

/* JADX INFO: compiled from: PackageOpener.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class e implements com.obric.autogui.operator.a.b.a.b.a, c {
    private static final String TAG = "Op-OpenApp/PkgOpener";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f29497a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f29498b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private com.obric.autogui.operator.a.b.a.b.a f29499c;

    /* JADX INFO: compiled from: PackageOpener.kt */
    public static final class a {
        public /* synthetic */ a(h r1) {
            this();
        }

        private a() {
        }
    }

    /* JADX INFO: compiled from: PackageOpener.kt */
    @d.c.b.a.f(b = "PackageOpener.kt", c = {74}, d = "maybeKillApp", e = "com.obric.autogui.operator.impl.op.openapp.opener.PackageOpener")
    static final class b extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f29500a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        /* synthetic */ Object f29501b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ e f29502c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        int f29503d;

        b(e r3, d.c.d<? super b> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f29502c = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f29501b = r3;
            this.f29503d |= Integer.MIN_VALUE;
            return this.f29502c.b(null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    static {
        f29497a = new a(null);
    }

    public e(Context r3, String r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        o.e(r5, "context");
        o.e(r4, "expectedPackageName");
        this.f29498b = r4;
        com.obric.autogui.operator.a.b.a.d.a r6 = com.obric.autogui.operator.a.b.a.d.f29526a.a(r5, r4, null);
        if (r6 == null) goto L5;
        this.f29499c = r6.a();
        return;
    L5:
        Loog.INSTANCE.w(TAG, " - [PkgOpener] resolved no AppOpener for `" + r4 + "`!");
    }

    @Override // com.obric.autogui.operator.a.b.a.b.a
    public Object a(Context r11, d.c.d<? super com.obric.autogui.operator.a.b.a.c> r12) {
        Context r13 = (Context) ZeusTransformUtils.wrapperContextForParams(r11, Context.class, "com.obric.aiagent.plugin");
        d.c.d<? super com.obric.autogui.operator.a.b.a.c> r14 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r12, d.c.d.class, "com.obric.aiagent.plugin");
        com.obric.autogui.operator.a.b.a.b.a r0 = this.f29499c;
        if (r0 != null) goto L7;
        Loog.INSTANCE.e(TAG, " - [PkgOpener] no resolved AppOpener for `" + this.f29498b + "`!");
        return new com.obric.autogui.operator.a.b.a.c(com.obric.autogui.operator.a.b.a.b.g, null, null, null, null, false, null, 126, null);
    L7:
        return r0.a(r13, r14);
    }

    @Override // com.obric.autogui.operator.a.b.a.b.c
    public String b() {
        com.obric.autogui.operator.a.b.a.b.a r0 = this.f29499c;
        if (ZeusTransformUtils.instanceOf(r0, c.class) == false) goto L7;
        return ((c) ZeusTransformUtils.preCheckCast(r0, c.class, "com.obric.aiagent.plugin")).b();
    L7:
        return this.f29498b;
    }

    @Override // com.obric.autogui.operator.a.b.a.b.a
    public Object b(Context r11, d.c.d<? super m<Boolean, String>> r12) {
        Context r13 = (Context) ZeusTransformUtils.wrapperContextForParams(r11, Context.class, "com.obric.aiagent.plugin");
        d.c.d r14 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r12, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r14, b.class) == false) goto L7;
        b r15 = (b) ZeusTransformUtils.preCheckCast(r14, b.class, "com.obric.aiagent.plugin");
        if ((r15.f29503d & Integer.MIN_VALUE) == 0) goto L7;
        r15.f29503d -= Integer.MIN_VALUE;
    L8:
        b r7 = r15;
        Object r16 = r7.f29501b;
        Object r17 = d.c.a.b.a();
        int r0 = r7.f29503d;
        if (r0 == 0) goto L14;
        if (r0 != 1) goto L13;
        e this = (e) ZeusTransformUtils.preCheckCast(r7.f29500a, e.class, "com.obric.aiagent.plugin");
        d.o.a(r16);
    L18:
        return s.a(d.c.b.a.b.a(((Boolean) ZeusTransformUtils.preCheckCast(r16, Boolean.class, "com.obric.aiagent.plugin")).booleanValue()), this.b());
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        d.o.a(r16);
        IAutoActionPackagesApi r18 = AOPlatformTools.INSTANCE.packages();
        String r3 = b();
        r7.f29500a = this;
        r7.f29503d = 1;
        r16 = IAutoActionPackagesApi.DefaultImpls.killAppAndDelay$default(r18, r3, true, 0, r7, 4, null);
        if (r16 != r17) goto L18;
        return r17;
    L7:
        r15 = new b(this, r14);
        goto L8
    }
}
