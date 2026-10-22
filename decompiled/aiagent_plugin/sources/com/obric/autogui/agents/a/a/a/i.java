package com.obric.autogui.agents.a.a.a;

import android.content.ComponentName;
import android.content.Context;
import com.obric.autogui.common.api.AOPackagesTools;
import com.obric.autogui.common.api.logging.Loog;
import com.obric.autogui.common.api.platform.packages.IAutoActionPackagesApi;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.ax;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

/* JADX INFO: compiled from: OpenAppActionEffectHandler.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class i extends b {
    private static final String TAG = "OpenAppActionEffectHandler";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f26185a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Set<String> f26186b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private volatile String f26187c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private volatile boolean f26188d;

    /* JADX INFO: compiled from: OpenAppActionEffectHandler.kt */
    public static final class a {
        public /* synthetic */ a(d.h.b.h r1) {
            this();
        }

        private a() {
        }
    }

    static {
        f26185a = new a(null);
    }

    public i(Context r6, com.obric.autogui.operator.e r7, String r8, String r9) {
        Context r10 = (Context) ZeusTransformUtils.wrapperContextForParams(r6, Context.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r10, "context");
        d.h.b.o.e(r7, "step");
        d.h.b.o.e(r8, "actionKey");
        d.h.b.o.e(r9, "attemptId");
        super(com.obric.autogui.operator.b.EnumC0777b.f29869a);
        Iterator r11 = ((Iterable) ZeusTransformUtils.preCheckCast(r7.Q(), Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L3:
        com.obric.autogui.operator.a.b.a.a.b r2 = null;
        if (r11.hasNext() == false) goto L11;
        Object r0 = r11.next();
        if (((com.obric.autogui.operator.e.C0780e) ZeusTransformUtils.preCheckCast(r0, com.obric.autogui.operator.e.C0780e.class, "com.obric.aiagent.plugin")).a() != com.obric.autogui.operator.b.EnumC0777b.f29869a) goto L8;
        boolean r3 = true;
    L9:
        if (r3 == false) goto L3;
    L12:
        com.obric.autogui.operator.e.C0780e r12 = (com.obric.autogui.operator.e.C0780e) ZeusTransformUtils.preCheckCast(r0, com.obric.autogui.operator.e.C0780e.class, "com.obric.aiagent.plugin");
        if (r12 == null) goto L15;
        com.obric.autogui.operator.b.a r13 = r12.b();
    L17:
        if (ZeusTransformUtils.instanceOf(r13, com.obric.autogui.operator.a.b.a.a.b.class) == false) goto L19;
        r2 = (com.obric.autogui.operator.a.b.a.a.b) ZeusTransformUtils.preCheckCast(r13, com.obric.autogui.operator.a.b.a.a.b.class, "com.obric.aiagent.plugin");
    L19:
        this.f26186b = a(r10, r2, r8, r9);
        return;
    L15:
        r13 = null;
        goto L17
    L8:
        r3 = false;
        goto L9
    L11:
        r0 = null;
        goto L12
    }

    @Override // com.obric.autogui.agents.a.a.a.b
    public com.obric.autogui.agents.a.a.a.a b() {
        return (com.obric.autogui.agents.a.a.a.a) ZeusTransformUtils.preCheckCast(new h(this.f26186b, this.f26187c, this.f26188d), com.obric.autogui.agents.a.a.a.a.class, "com.obric.aiagent.plugin");
    }

    @Override // com.obric.autogui.agents.a.a.a.b
    public void a(d r5, com.obric.autogui.operator.e.C0780e r6, com.obric.autogui.operator.c r7) {
        d r8 = (d) ZeusTransformUtils.wrapperContextForParams(r5, d.class, "com.obric.aiagent.plugin");
        com.obric.autogui.operator.c r9 = (com.obric.autogui.operator.c) ZeusTransformUtils.wrapperContextForParams(r7, com.obric.autogui.operator.c.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r8, "scope");
        d.h.b.o.e(r6, "operation");
        d.h.b.o.e(r9, "result");
        if (r6.a() == com.obric.autogui.operator.b.EnumC0777b.f29869a) goto L5;
        return;
    L5:
        String r0 = null;
        if (ZeusTransformUtils.instanceOf(r9, com.obric.autogui.operator.a.b.a.a.c.class) == false) goto L8;
        com.obric.autogui.operator.a.b.a.a.c r10 = (com.obric.autogui.operator.a.b.a.a.c) ZeusTransformUtils.preCheckCast(r9, com.obric.autogui.operator.a.b.a.a.c.class, "com.obric.aiagent.plugin");
    L9:
        if (r10 == null) goto L11;
        r0 = r10.g();
    L11:
        this.f26187c = r0;
        this.f26188d = !r9.a();
        Loog r11 = Loog.INSTANCE;
        StringBuilder r12 = new StringBuilder().append("[OAutoActionEffect] open app target resolved ").append(r8.g()).append(", has_runtime_package=");
        CharSequence r1 = (CharSequence) ZeusTransformUtils.preCheckCast(this.f26187c, CharSequence.class, "com.obric.aiagent.plugin");
        if (r1 != null) goto L14;
    L17:
        boolean r2 = true;
    L18:
        r11.i(TAG, r12.append(true ^ r2).append(", candidate_count=").append(this.f26186b.size()).append(", failed=").append(r9.a()).toString());
        return;
    L14:
        if (d.o.o.d(r1) == true) goto L17;
        r2 = false;
        goto L18
    L8:
        r10 = null;
        goto L9
    }

    private final Set<String> a(Context r11, com.obric.autogui.operator.a.b.a.a.b r12, String r13, String r14) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r11, Context.class, "com.obric.aiagent.plugin");
        if (r12 == null) goto L5;
        LinkedHashSet r15 = new LinkedHashSet();
        String r0 = r12.b();
        if (r0 != null) goto L9;
    L14:
        String r1 = r12.d();
        if (r1 != null) goto L17;
    L37:
        String r16 = r12.c();
        if (r16 == null) goto L62;
        if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r16, CharSequence.class, "com.obric.aiagent.plugin"))) == false) goto L42;
        String r4 = r16;
    L43:
        if (r4 == null) goto L62;
        d.n.a r17 = d.n.f38560a;     // Catch: Throwable -> L46
        i r10 = (i) ZeusTransformUtils.preCheckCast(this, i.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L46
        Object r18 = d.n.f(IAutoActionPackagesApi.DefaultImpls.getPackageNamesForLabel$default((IAutoActionPackagesApi) ZeusTransformUtils.preCheckCast(AOPackagesTools.INSTANCE, IAutoActionPackagesApi.class, "com.obric.aiagent.plugin"), r3, r4, false, 4, null));     // Catch: Throwable -> L46
    L48:
        Throwable r19 = d.n.c(r18);
        if (r19 == null) goto L51;
        Loog.INSTANCE.w(TAG, "[OAutoActionEffect] resolve app package failed " + com.obric.autogui.agents.a.c.f26286a.a(r13, r14) + ", app_name_present=true, error_type=" + com.obric.autogui.agents.a.b.a(r19));
    L51:
        List r110 = d.a.p.b();
        if (d.n.b(r18) == false) goto L54;
        r18 = r110;
    L54:
        Iterator r111 = ((Iterable) ZeusTransformUtils.preCheckCast(r18, Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L56:
        if (r111.hasNext() == false) goto L60;
        Object r112 = r111.next();
        if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast((String) ZeusTransformUtils.preCheckCast(r112, String.class, "com.obric.aiagent.plugin"), CharSequence.class, "com.obric.aiagent.plugin"))) == false) goto L56;
        ((Collection) ZeusTransformUtils.preCheckCast(r15, Collection.class, "com.obric.aiagent.plugin")).add(r112);
        goto L56
    L60:
        LinkedHashSet r113 = (LinkedHashSet) ZeusTransformUtils.preCheckCast((Collection) ZeusTransformUtils.preCheckCast(r15, Collection.class, "com.obric.aiagent.plugin"), LinkedHashSet.class, "com.obric.aiagent.plugin");
    L46:
        th = move-exception;
        d.n.a r114 = d.n.f38560a;
        r18 = d.n.f(d.o.a(th));
        goto L48
    L42:
        r4 = null;
    L62:
        return (Set) ZeusTransformUtils.preCheckCast(r15, Set.class, "com.obric.aiagent.plugin");
    L17:
        if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r1, CharSequence.class, "com.obric.aiagent.plugin"))) == true) goto L20;
        r1 = null;
    L20:
        if (r1 == null) goto L37;
        ComponentName r5 = ComponentName.unflattenFromString(r1);
        if (r5 == null) goto L24;
        String r6 = r5.getPackageName();
    L25:
        String r7 = d.o.o.a(r1, '/', null, 2, null);
        boolean r9 = false;
        if (d.o.o.c((CharSequence) ZeusTransformUtils.preCheckCast(r1, CharSequence.class, "com.obric.aiagent.plugin"), '/', false, 2, null) == true) goto L28;
    L30:
        if (r9 == true) goto L33;
        r7 = null;
    L33:
        if (r6 != null) goto L35;
        r6 = r7;
    L35:
        if (r6 == null) goto L37;
        r15.add(r6);
        goto L37
    L28:
        if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r7, CharSequence.class, "com.obric.aiagent.plugin"))) == false) goto L30;
        r9 = true;
        goto L30
    L24:
        r6 = null;
        goto L25
    L9:
        if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r0, CharSequence.class, "com.obric.aiagent.plugin"))) == true) goto L12;
        r0 = null;
    L12:
        if (r0 == null) goto L14;
        r15.add(r0);
        goto L14
    L5:
        return ax.b();
    }
}
