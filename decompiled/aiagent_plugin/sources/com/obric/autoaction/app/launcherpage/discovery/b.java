package com.obric.autoaction.app.launcherpage.discovery;

import android.content.Context;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.aj;
import androidx.lifecycle.ak;
import com.obric.autogui.common.api.logging.Loog;
import com.obric.event.task.base.report.g;
import com.obric.eventkit.task.model.ConditionGroup;
import com.obric.eventkit.task.model.ConditionTask;
import com.obric.eventkit.task.model.EventTask;
import com.obric.eventkit.task.model.PeriodicPolicy;
import com.obric.eventkit.task.model.ShortcutTask;
import com.obric.eventkit.task.model.TriggerControlPolicy;
import com.ss.android.socialbase.downloader.constants.DownloadErrorCode;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.p;
import d.c.b.a.f;
import d.c.b.a.l;
import d.c.d;
import d.h.a.m;
import d.h.b.h;
import d.k;
import d.o;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlinx.coroutines.am;
import kotlinx.coroutines.b.x;
import kotlinx.coroutines.i;

/* JADX INFO: compiled from: DiscoveryViewModel.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class b extends aj implements com.obric.autoaction.app.launcherpage.discovery.view.b {
    private static final String TAG = "DiscoveryViewModel";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f23651a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final com.obric.autoaction.app.launcherpage.discovery.api.a f23652b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final AtomicBoolean f23653c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final x<List<com.obric.autoaction.app.launcherpage.discovery.a.b>> f23654d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final x<Boolean> f23655e;
    private final x<List<com.obric.autoaction.app.launcherpage.discovery.a.a>> f;
    private final x<Integer> g;

    /* JADX INFO: compiled from: DiscoveryViewModel.kt */
    public static final class a {
        public /* synthetic */ a(h r1) {
            this();
        }

        private a() {
        }
    }

    /* JADX INFO: renamed from: com.obric.autoaction.app.launcherpage.discovery.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: DiscoveryViewModel.kt */
    @f(b = "DiscoveryViewModel.kt", c = {74}, d = "invokeSuspend", e = "com.obric.autoaction.app.launcherpage.discovery.DiscoveryViewModel$fetchInstructionGroup$1")
    static final class C0527b extends l implements m<am, d<? super d.x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f23656a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ b f23657b;

        C0527b(b r3, d<? super C0527b> r4) {
            d r5 = (d) ZeusTransformUtils.wrapperContextForParams(r4, d.class, "com.obric.aiagent.plugin");
            this.f23657b = r3;
            super(2, r5);
        }

        public final Object a(am r3, d<? super d.x> r4) {
            return ((C0527b) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d) ZeusTransformUtils.wrapperContextForParams(r4, d.class, "com.obric.aiagent.plugin")), C0527b.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d<d.x> create(Object r2, d<?> r3) {
            d r4 = (d) ZeusTransformUtils.wrapperContextForParams(r3, d.class, "com.obric.aiagent.plugin");
            return (d) ZeusTransformUtils.preCheckCast(new C0527b(this.f23657b, r4), d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d<? super d.x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d) ZeusTransformUtils.preCheckCast(r4, d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r5) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f23656a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            o.a(r5);
        L11:
            d.m r6 = (d.m) ZeusTransformUtils.preCheckCast(r5, d.m.class, "com.obric.aiagent.plugin");
            boolean r2 = ((Boolean) ZeusTransformUtils.preCheckCast(r6.c(), Boolean.class, "com.obric.aiagent.plugin")).booleanValue();
            List<com.obric.autoaction.app.launcherpage.discovery.a.b> r7 = (List) ZeusTransformUtils.preCheckCast(r6.d(), List.class, "com.obric.aiagent.plugin");
            this.f23657b.c().b(d.c.b.a.b.a(!r2));
            this.f23657b.b().b(r7);
            this.f23657b.e().b(b.a(this.f23657b, r7));
            return d.x.f38692a;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            o.a(r5);
            com.obric.autoaction.app.launcherpage.discovery.api.a r8 = b.a(this.f23657b);
            d<? super d.m<Boolean, ? extends List<? extends com.obric.autoaction.app.launcherpage.discovery.a.b>>> r3 = (d) ZeusTransformUtils.preCheckCast(this, d.class, "com.obric.aiagent.plugin");
            this.f23656a = 1;
            r5 = r8.a(r3);
            if (r5 != r0) goto L11;
            return r0;
        }
    }

    static {
        f23651a = new a(null);
    }

    public b() {
        this.f23652b = new com.obric.autoaction.app.launcherpage.discovery.api.a();
        this.f23653c = new AtomicBoolean(false);
        this.f23654d = kotlinx.coroutines.b.am.a(null);
        this.f23655e = kotlinx.coroutines.b.am.a(false);
        this.f = kotlinx.coroutines.b.am.a(p.b());
        this.g = kotlinx.coroutines.b.am.a(0);
    }

    public static final /* synthetic */ com.obric.autoaction.app.launcherpage.discovery.api.a a(b r0) {
        return r0.f23652b;
    }

    public static final /* synthetic */ List a(b r2, List r3) {
        return r2.a((List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin"));
    }

    public final x<List<com.obric.autoaction.app.launcherpage.discovery.a.b>> b() {
        return this.f23654d;
    }

    public final x<Boolean> c() {
        return this.f23655e;
    }

    public final x<List<com.obric.autoaction.app.launcherpage.discovery.a.a>> e() {
        return this.f;
    }

    public final x<Integer> f() {
        return this.g;
    }

    public final void g() {
        i();
    }

    private final void i() {
        i.a(ak.a((aj) ZeusTransformUtils.preCheckCast(this, aj.class, "com.obric.aiagent.plugin")), null, null, (m) ZeusTransformUtils.preCheckCast(new C0527b(this, null), m.class, "com.obric.aiagent.plugin"), 3, null);
    }

    private final List<com.obric.autoaction.app.launcherpage.discovery.a.a> a(List<? extends com.obric.autoaction.app.launcherpage.discovery.a.b> r4) {
        Iterable r3 = (Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.aiagent.plugin"), Iterable.class, "com.obric.aiagent.plugin");
        Collection r5 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");
        Iterator r6 = r3.iterator();
    L4:
        if (r6.hasNext() == false) goto L8;
        Object r1 = r6.next();
        if (ZeusTransformUtils.instanceOf(r1, com.obric.autoaction.app.launcherpage.discovery.a.b.d.class) == false) goto L4;
        r5.add(r1);
        goto L4
    L8:
        Iterable r7 = (Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r5, List.class, "com.obric.aiagent.plugin"), Iterable.class, "com.obric.aiagent.plugin");
        Collection r8 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(p.a(r7, 10)), Collection.class, "com.obric.aiagent.plugin");
        Iterator r9 = r7.iterator();
    L10:
        if (r9.hasNext() == false) goto L12;
        r8.add(((com.obric.autoaction.app.launcherpage.discovery.a.b.d) ZeusTransformUtils.preCheckCast(r9.next(), com.obric.autoaction.app.launcherpage.discovery.a.b.d.class, "com.obric.aiagent.plugin")).a());
        goto L10
    L12:
        List r10 = p.s((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r8, List.class, "com.obric.aiagent.plugin"), Iterable.class, "com.obric.aiagent.plugin"));
        List r11 = p.a();
        r11.add(com.obric.autoaction.app.launcherpage.discovery.a.a.C0523a.f23571a);
        Iterator r12 = ((Iterable) ZeusTransformUtils.preCheckCast(r10, Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L14:
        if (r12.hasNext() == false) goto L17;
        r11.add(new com.obric.autoaction.app.launcherpage.discovery.a.a.b((String) ZeusTransformUtils.preCheckCast(r12.next(), String.class, "com.obric.aiagent.plugin")));
        goto L14
    L17:
        return p.a(r11);
    }

    public final List<com.obric.autoaction.app.launcherpage.discovery.a.b> a(com.obric.autoaction.app.launcherpage.discovery.a.a r4) {
        d.h.b.o.e(r4, "category");
        List<com.obric.autoaction.app.launcherpage.discovery.a.b> r0 = (List) ZeusTransformUtils.preCheckCast(this.f23654d.c(), List.class, "com.obric.aiagent.plugin");
        if (r0 != null) goto L7;
        return p.b();
    L7:
        if (ZeusTransformUtils.instanceOf(r4, com.obric.autoaction.app.launcherpage.discovery.a.a.C0523a.class) == false) goto L10;
        return r0;
    L10:
        if (ZeusTransformUtils.instanceOf(r4, com.obric.autoaction.app.launcherpage.discovery.a.a.b.class) == false) goto L14;
        return a(r0, ((com.obric.autoaction.app.launcherpage.discovery.a.a.b) ZeusTransformUtils.preCheckCast(r4, com.obric.autoaction.app.launcherpage.discovery.a.a.b.class, "com.obric.aiagent.plugin")).a());
    L14:
        throw new k();
    }

    private final List<com.obric.autoaction.app.launcherpage.discovery.a.b> a(List<? extends com.obric.autoaction.app.launcherpage.discovery.a.b> r5, String r6) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.aiagent.plugin");
        List<com.obric.autoaction.app.launcherpage.discovery.a.b> r7 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.aiagent.plugin");
        Iterator r8 = ((Iterable) ZeusTransformUtils.preCheckCast(r4, Iterable.class, "com.obric.aiagent.plugin")).iterator();
        boolean r1 = false;
    L4:
        if (r8.hasNext() == false) goto L10;
        com.obric.autoaction.app.launcherpage.discovery.a.b r2 = (com.obric.autoaction.app.launcherpage.discovery.a.b) ZeusTransformUtils.preCheckCast(r8.next(), com.obric.autoaction.app.launcherpage.discovery.a.b.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r2, com.obric.autoaction.app.launcherpage.discovery.a.b.d.class) == true) goto L7;
        if (r1 == false) goto L4;
        r7.add(r2);
        goto L4
    L7:
        r1 = d.h.b.o.a(((com.obric.autoaction.app.launcherpage.discovery.a.b.d) ZeusTransformUtils.preCheckCast(r2, com.obric.autoaction.app.launcherpage.discovery.a.b.d.class, "com.obric.aiagent.plugin")).a(), r6);
        goto L4
    L10:
        return r7;
    }

    public final void h() {
        i();
    }

    @Override // com.obric.autoaction.app.launcherpage.discovery.view.b
    public void a(com.obric.autoaction.app.launcherpage.discovery.a.b.AbstractC0524b r7, Context r8) {
        Context r9 = (Context) ZeusTransformUtils.wrapperContextForParams(r8, Context.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r7, "item");
        d.h.b.o.e(r9, "context");
        b(r7, r9);
        com.obric.event.task.base.report.h.f32778a.a(new g(r7.a().a(), r7.a().c(), r7.a().b(), r7.a().d(), r7.a().g()));
    }

    private final void b(com.obric.autoaction.app.launcherpage.discovery.a.b.AbstractC0524b r30, Context r31) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r31, Context.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r1, FragmentActivity.class) == false) goto L5;
        FragmentActivity r6 = (FragmentActivity) ZeusTransformUtils.preCheckCast(r1, FragmentActivity.class, "com.obric.aiagent.plugin");
    L6:
        if (r6 != null) goto L10;
        Loog.INSTANCE.e(TAG, "navigateToCreateInstructionPage: context is not FragmentActivity");
        return;
    L10:
        if (ZeusTransformUtils.instanceOf(r30, com.obric.autoaction.app.launcherpage.discovery.a.b.c.class) == false) goto L13;
        ShortcutTask r2 = new ShortcutTask(null, null, null, null, null, null, ((com.obric.autoaction.app.launcherpage.discovery.a.b.c) ZeusTransformUtils.preCheckCast(r30, com.obric.autoaction.app.launcherpage.discovery.a.b.c.class, "com.obric.aiagent.plugin")).a().g(), d.h.b.o.a(((com.obric.autoaction.app.launcherpage.discovery.a.b.c) ZeusTransformUtils.preCheckCast(r30, com.obric.autoaction.app.launcherpage.discovery.a.b.c.class, "com.obric.aiagent.plugin")).a().h(), true), p.a(((com.obric.autoaction.app.launcherpage.discovery.a.b.c) ZeusTransformUtils.preCheckCast(r30, com.obric.autoaction.app.launcherpage.discovery.a.b.c.class, "com.obric.aiagent.plugin")).a().k()), 32, null);
        r2.setTaskMode(1);
        r2.setTemplateId(((com.obric.autoaction.app.launcherpage.discovery.a.b.c) ZeusTransformUtils.preCheckCast(r30, com.obric.autoaction.app.launcherpage.discovery.a.b.c.class, "com.obric.aiagent.plugin")).a().a());
        com.obric.autoaction.app.launcherpage.detail.shortcut.a.a(com.obric.autoaction.app.launcherpage.detail.shortcut.a.f23480a, r6, "enter_from_discovery_add_instruct", (EventTask) ZeusTransformUtils.preCheckCast(r2, EventTask.class, "com.obric.aiagent.plugin"), null, false, 24, null);
        return;
    L13:
        if (ZeusTransformUtils.instanceOf(r30, com.obric.autoaction.app.launcherpage.discovery.a.b.a.class) == false) goto L26;
        com.obric.autoaction.app.launcherpage.discovery.a.h r3 = ((com.obric.autoaction.app.launcherpage.discovery.a.b.a) ZeusTransformUtils.preCheckCast(r30, com.obric.autoaction.app.launcherpage.discovery.a.b.a.class, "com.obric.aiagent.plugin")).a().i();
        if (r3 == null) goto L18;
        ConditionGroup r4 = r3.a(r1);
        if (r4 == null) goto L18;
    L19:
        ConditionGroup r16 = r4;
        List r15 = p.a(((com.obric.autoaction.app.launcherpage.discovery.a.b.a) ZeusTransformUtils.preCheckCast(r30, com.obric.autoaction.app.launcherpage.discovery.a.b.a.class, "com.obric.aiagent.plugin")).a().j());
        PeriodicPolicy r5 = ((com.obric.autoaction.app.launcherpage.discovery.a.b.a) ZeusTransformUtils.preCheckCast(r30, com.obric.autoaction.app.launcherpage.discovery.a.b.a.class, "com.obric.aiagent.plugin")).a().l();
        if (r5 != null) goto L22;
        PeriodicPolicy r17 = new PeriodicPolicy(false, null, 0, null, false, false, null, false, null, 511, null);
    L23:
        ConditionTask r7 = new ConditionTask(null, null, null, null, null, null, r15, r16, r17, new TriggerControlPolicy(false, null, 2, null), 0, DownloadErrorCode.ERROR_NO_ROUTE_TO_HOST, null);
        r7.setTaskMode(1);
        r7.setTemplateId(((com.obric.autoaction.app.launcherpage.discovery.a.b.a) ZeusTransformUtils.preCheckCast(r30, com.obric.autoaction.app.launcherpage.discovery.a.b.a.class, "com.obric.aiagent.plugin")).a().a());
        com.obric.autoaction.app.launcherpage.detail.condition.a.f23400a.a(r6, "enter_from_discovery_add_instruct", (EventTask) ZeusTransformUtils.preCheckCast(r7, EventTask.class, "com.obric.aiagent.plugin"));
        return;
    L22:
        r17 = r5;
    L18:
        r4 = new ConditionGroup("and", new ArrayList());
        goto L19
    L26:
        return;
    L5:
        r6 = null;
        goto L6
    }
}
