package com.obric.autogui.operator.a.b.a.a;

import android.content.Context;
import com.bytedance.common.wschannel.WsChannelMultiProcessSharedProvider;
import com.obric.aiagent.plugin.R;
import com.obric.autogui.common.api.logging.Loog;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.p;
import d.c.b.a.f;
import d.h.a.m;
import d.h.b.h;
import d.h.b.z;
import d.o;
import d.x;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: AppNameResolver.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class b {
    private static final String TAG = "Op-OpenApp/ANRes";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f29428a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final List<d> f29429b;

    /* JADX INFO: compiled from: AppNameResolver.kt */
    public static final class a {
        public /* synthetic */ a(h r1) {
            this();
        }

        private a() {
        }
    }

    /* JADX INFO: renamed from: com.obric.autogui.operator.a.b.a.a.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: AppNameResolver.kt */
    public /* synthetic */ class C0757b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f29430a = null;

        static {
            int[] r0 = new int[com.obric.autogui.operator.a.b.a.b.values().length];
            r0[com.obric.autogui.operator.a.b.a.b.f29448d.ordinal()] = 1;     // Catch: NoSuchFieldError -> L6
        L4:
            f29430a = r0;
        }
    }

    /* JADX INFO: compiled from: AppNameResolver.kt */
    @f(b = "AppNameResolver.kt", c = {93, 98, 100}, d = "openByName", e = "com.obric.autogui.operator.impl.op.openapp.appname.AppNameResolver")
    static final class c extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f29431a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f29432b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Object f29433c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        Object f29434d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        Object f29435e;
        Object f;
        Object g;
        Object h;
        /* synthetic */ Object i;
        final /* synthetic */ b j;
        int k;

        c(b r3, d.c.d<? super c> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.j = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r7) {
            this.i = r7;
            this.k |= Integer.MIN_VALUE;
            return this.j.a(null, null, null, null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    static {
        f29428a = new a(null);
    }

    /* JADX INFO: renamed from: lambda$1y-w-sdy7rdEwdIlb2GaJIl2QII, reason: not valid java name */
    public static /* synthetic */ String m829lambda$1ywsdy7rdEwdIlb2GaJIl2QII(com.obric.autogui.operator.a.b.a.c r0) {
        return a(r0);
    }

    public b() {
        this.f29429b = p.b(new d[]{new com.obric.autogui.operator.a.b.a.a.c(), new com.obric.autogui.operator.a.b.a.a.a()});
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:32:0x0235 -> B:65:0x038a). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:33:0x023e -> B:34:0x0251). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:53:0x02db -> B:14:0x00b7). Please report as a decompilation issue!!! */
    public final Object a(Context r25, String r26, m<? super com.obric.autogui.operator.a.b.a.b.a, ? super d.c.d<? super x>, ? extends Object> r27, m<? super com.obric.autogui.operator.a.b.a.b.a, ? super d.c.d<? super com.obric.autogui.operator.a.b.a.c>, ? extends Object> r28, d.c.d<? super com.obric.autogui.operator.a.b.a.c> r29) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r25, Context.class, "com.obric.aiagent.plugin");
        m r3 = (m) ZeusTransformUtils.wrapperContextForParams(r27, m.class, "com.obric.aiagent.plugin");
        m r4 = (m) ZeusTransformUtils.wrapperContextForParams(r28, m.class, "com.obric.aiagent.plugin");
        d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r29, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r5, c.class) == false) goto L7;
        c r6 = (c) ZeusTransformUtils.preCheckCast(r5, c.class, "com.obric.aiagent.plugin");
        if ((r6.k & Integer.MIN_VALUE) == 0) goto L7;
        r6.k -= Integer.MIN_VALUE;
    L8:
        Object r7 = r6.i;
        Object r8 = d.c.a.b.a();
        int r9 = r6.k;
        int r11 = 1;
        if (r9 == 0) goto L19;
        if (r9 == 1) goto L18;
        if (r9 == 2) goto L17;
        if (r9 != 3) goto L16;
        com.obric.autogui.operator.a.b.a.b.a r0 = (com.obric.autogui.operator.a.b.a.b.a) ZeusTransformUtils.preCheckCast(r6.h, com.obric.autogui.operator.a.b.a.b.a.class, "com.obric.aiagent.plugin");
        Iterator<com.obric.autogui.operator.a.b.a.b.a> r2 = (Iterator) ZeusTransformUtils.preCheckCast(r6.g, Iterator.class, "com.obric.aiagent.plugin");
        Iterator<d> r10 = (Iterator) ZeusTransformUtils.preCheckCast(r6.f, Iterator.class, "com.obric.aiagent.plugin");
        z.f r12 = (z.f) ZeusTransformUtils.preCheckCast(r6.f29435e, z.f.class, "com.obric.aiagent.plugin");
        m r13 = (m) ZeusTransformUtils.preCheckCast(r6.f29434d, m.class, "com.obric.aiagent.plugin");
        m r14 = (m) ZeusTransformUtils.preCheckCast(r6.f29433c, m.class, "com.obric.aiagent.plugin");
        String r15 = (String) ZeusTransformUtils.preCheckCast(r6.f29432b, String.class, "com.obric.aiagent.plugin");
        Context r16 = (Context) ZeusTransformUtils.preCheckCast(r6.f29431a, Context.class, "com.obric.aiagent.plugin");
        o.a(r7);
    L14:
        c r23 = r6;
        z.f r17 = r12;
        m r18 = r14;
        Object r19 = r8;
        c r20 = r23;
        com.obric.autogui.operator.a.b.a.c r21 = (com.obric.autogui.operator.a.b.a.c) ZeusTransformUtils.preCheckCast(r7, com.obric.autogui.operator.a.b.a.c.class, "com.obric.aiagent.plugin");
        if (r21.a().c() == false) goto L59;
        Loog.INSTANCE.d(TAG, " - [OpenApp-Collect] opened (" + r0 + "), status=" + r21.a());
        return r21;
    L59:
        Iterator<com.obric.autogui.operator.a.b.a.b.a> r24 = r2;
        if (C0757b.f29430a[r21.a().ordinal()] != r11) goto L63;
        Loog.INSTANCE.w(TAG, " - [OpenApp-Collect] stop on user interrupt from " + r0 + ": " + r21 + '.');
        return r21;
    L63:
        Loog.INSTANCE.w(TAG, " - [OpenApp-Collect] failed (" + r0 + "), status=" + r21 + '.');
        a(r17, r21);
        r2 = r24;
        Iterator<d> r22 = r10;
        m r30 = r13;
        Context r31 = r16;
        Object r32 = r19;
        String r33 = r15;
        r11 = 1;
    L35:
        if (r2.hasNext() == false) goto L64;
        com.obric.autogui.operator.a.b.a.b.a r110 = (com.obric.autogui.operator.a.b.a.b.a) ZeusTransformUtils.preCheckCast(r2.next(), com.obric.autogui.operator.a.b.a.b.a.class, "com.obric.aiagent.plugin");
        if (r30 == null) goto L45;
        r20.f29431a = r31;
        r20.f29432b = r33;
        r20.f29433c = r18;
        r20.f29434d = r30;
        r20.f29435e = r17;
        r20.f = r22;
        r20.g = r2;
        r20.h = r110;
        r20.k = r11;
        Object r111 = r30.invoke(r110, r20);
        if (r111 != r32) goto L41;
        return r32;
    L41:
        Context r112 = r31;
        r10 = r22;
        r0 = r110;
        String r210 = r33;
        m r34 = r18;
        r12 = r17;
        r6 = r20;
        r8 = r32;
        r13 = r30;
        r7 = r111;
        String r113 = r210;
    L42:
        com.obric.autogui.operator.a.b.a.c r35 = (com.obric.autogui.operator.a.b.a.c) ZeusTransformUtils.preCheckCast(r7, com.obric.autogui.operator.a.b.a.c.class, "com.obric.aiagent.plugin");
        if (r35 == null) goto L46;
        return r35;
    L46:
        if (r34 == null) goto L50;
        r6.f29431a = r112;
        r6.f29432b = r113;
        r6.f29433c = r34;
        r6.f29434d = r13;
        r6.f29435e = r12;
        r6.f = r10;
        r6.g = r2;
        r6.h = r0;
        r6.k = 2;
        if (r34.invoke(r0, r6) != r8) goto L50;
        return r8;
    L50:
        String r211 = r113;
        r14 = r34;
        r16 = r112;
        r15 = r211;
        r6.f29431a = r16;
        r6.f29432b = r15;
        r6.f29433c = r14;
        r6.f29434d = r13;
        r6.f29435e = r12;
        r6.f = r10;
        r6.g = r2;
        r6.h = r0;
        r6.k = 3;
        r7 = r0.a(r16, r6);
        if (r7 != r8) goto L14;
        return r8;
    L45:
        r112 = r31;
        r113 = r33;
        r10 = r22;
        r34 = r18;
        r12 = r17;
        r6 = r20;
        r8 = r32;
        r0 = r110;
        r13 = r30;
        goto L46
    L64:
        r1 = r31;
        r3 = r18;
        r4 = r30;
        z.f r36 = r17;
        r6 = r20;
        r8 = r32;
        String r37 = r33;
    L25:
        if (r22.hasNext() == false) goto L66;
        d r38 = (d) ZeusTransformUtils.preCheckCast(r22.next(), d.class, "com.obric.aiagent.plugin");
        d.a r114 = r38.a(r1, r37);
        if (r114.a().a().c() == true) goto L33;
        Loog.INSTANCE.w(TAG, " - [OpenApp-Collect] collect via `" + r38 + "` failed: " + r114.a().a());
        if (r114.a().a() != com.obric.autogui.operator.a.b.a.b.f29448d) goto L32;
        Loog.INSTANCE.w(TAG, " - [OpenApp-Collect] stop on user interrupt: " + r114.a());
        return r114.a();
    L32:
        a(r36, r114.a());
        goto L25
    L33:
        m r212 = r3;
        r31 = r1;
        r2 = r114.b().a();
        r33 = r37;
        r32 = r8;
        r20 = r6;
        r17 = r36;
        r30 = r4;
        r18 = r212;
        goto L35
    L66:
        com.obric.autogui.operator.a.b.a.c r39 = (com.obric.autogui.operator.a.b.a.c) ZeusTransformUtils.preCheckCast(r36.f38504a, com.obric.autogui.operator.a.b.a.c.class, "com.obric.aiagent.plugin");
        if (r39 == null) goto L70;
        Loog.INSTANCE.e(TAG, " - [OpenApp-Collect] no success; result=" + r39);
        return r39;
    L70:
        Loog.INSTANCE.e(TAG, " - [OpenApp-Collect] no candidates collected");
        return new com.obric.autogui.operator.a.b.a.c(com.obric.autogui.operator.a.b.a.b.g, null, null, null, null, false, null, 126, null);
    L16:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L17:
        r0 = (com.obric.autogui.operator.a.b.a.b.a) ZeusTransformUtils.preCheckCast(r6.h, com.obric.autogui.operator.a.b.a.b.a.class, "com.obric.aiagent.plugin");
        r2 = (Iterator) ZeusTransformUtils.preCheckCast(r6.g, Iterator.class, "com.obric.aiagent.plugin");
        r10 = (Iterator) ZeusTransformUtils.preCheckCast(r6.f, Iterator.class, "com.obric.aiagent.plugin");
        r12 = (z.f) ZeusTransformUtils.preCheckCast(r6.f29435e, z.f.class, "com.obric.aiagent.plugin");
        r13 = (m) ZeusTransformUtils.preCheckCast(r6.f29434d, m.class, "com.obric.aiagent.plugin");
        r34 = (m) ZeusTransformUtils.preCheckCast(r6.f29433c, m.class, "com.obric.aiagent.plugin");
        r113 = (String) ZeusTransformUtils.preCheckCast(r6.f29432b, String.class, "com.obric.aiagent.plugin");
        r112 = (Context) ZeusTransformUtils.preCheckCast(r6.f29431a, Context.class, "com.obric.aiagent.plugin");
        o.a(r7);
        goto L50
    L18:
        r0 = (com.obric.autogui.operator.a.b.a.b.a) ZeusTransformUtils.preCheckCast(r6.h, com.obric.autogui.operator.a.b.a.b.a.class, "com.obric.aiagent.plugin");
        r2 = (Iterator) ZeusTransformUtils.preCheckCast(r6.g, Iterator.class, "com.obric.aiagent.plugin");
        r10 = (Iterator) ZeusTransformUtils.preCheckCast(r6.f, Iterator.class, "com.obric.aiagent.plugin");
        r12 = (z.f) ZeusTransformUtils.preCheckCast(r6.f29435e, z.f.class, "com.obric.aiagent.plugin");
        r13 = (m) ZeusTransformUtils.preCheckCast(r6.f29434d, m.class, "com.obric.aiagent.plugin");
        r34 = (m) ZeusTransformUtils.preCheckCast(r6.f29433c, m.class, "com.obric.aiagent.plugin");
        r113 = (String) ZeusTransformUtils.preCheckCast(r6.f29432b, String.class, "com.obric.aiagent.plugin");
        r112 = (Context) ZeusTransformUtils.preCheckCast(r6.f29431a, Context.class, "com.obric.aiagent.plugin");
        o.a(r7);
        goto L42
    L19:
        o.a(r7);
        r37 = r26;
        if (d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r37, CharSequence.class, "com.obric.aiagent.plugin")) == false) goto L23;
        com.obric.autogui.operator.a.b.a.b r115 = com.obric.autogui.operator.a.b.a.b.f29447c;
        String r116 = r1.getString(ZeusTransformUtils.mapRes(R.string.agent_task_open_app_failed_no_app_name, WsChannelMultiProcessSharedProvider.STRING_TYPE, "agent_task_open_app_failed_no_app_name"));
        d.h.b.o.c(r116, "getString(...)");
        return new com.obric.autogui.operator.a.b.a.c(r115, r116, "no app-name provided", null, null, false, null, 120, null);
    L23:
        r36 = new z.f();
        r22 = this.f29429b.iterator();
    L7:
        r6 = new c(this, r5);
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static final void a(z.f<com.obric.autogui.operator.a.b.a.c> r3, final com.obric.autogui.operator.a.b.a.c r4) {
        com.obric.autogui.operator.a.b.a.c r0 = (com.obric.autogui.operator.a.b.a.c) ZeusTransformUtils.preCheckCast(r3.f38504a, com.obric.autogui.operator.a.b.a.c.class, "com.obric.aiagent.plugin");
        if (r0 == null) goto L5;
        com.obric.autogui.operator.a.b.a.b r1 = r0.a();
    L7:
        if (r1 != com.obric.autogui.operator.a.b.a.b.f29448d) goto L9;
        return;
    L9:
        r3.f38504a = r4;
        Loog.INSTANCE.dp(TAG, new $$Lambda$b$1ywsdy7rdEwdIlb2GaJIl2QII(r4));
        return;
    L5:
        r1 = null;
        goto L7
    }

    private static final String a(com.obric.autogui.operator.a.b.a.c r2) {
        return " - [Collect] skipped (" + r2 + ')';
    }
}
