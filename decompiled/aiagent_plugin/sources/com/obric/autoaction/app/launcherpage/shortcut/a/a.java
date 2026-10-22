package com.obric.autoaction.app.launcherpage.shortcut.a;

import com.obric.autogui.common.api.logging.Loog;
import com.obric.eventkit.task.api.IEventTaskApi;
import com.obric.eventkit.task.model.EventTask;
import com.obric.eventkit.task.model.ShortcutTask;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.p;
import d.c.b.a.l;
import d.c.g;
import d.h.a.m;
import d.h.a.q;
import d.h.b.h;
import d.o;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlinx.coroutines.am;
import kotlinx.coroutines.b.ad;
import kotlinx.coroutines.b.ah;
import kotlinx.coroutines.b.ak;
import kotlinx.coroutines.b.i;
import kotlinx.coroutines.b.j;
import kotlinx.coroutines.b.w;
import kotlinx.coroutines.b.x;
import kotlinx.coroutines.bd;

/* JADX INFO: compiled from: ShortCutRepo.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C0560a f24398a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final am f24399b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f24400c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final x<Integer> f24401d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final w<d.x> f24402e;
    private final x<Boolean> f;
    private final ak<Boolean> g;
    private final ak<List<com.obric.autoaction.app.launcherpage.module.datasource.f.b>> h;

    /* JADX INFO: renamed from: com.obric.autoaction.app.launcherpage.shortcut.a.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: ShortCutRepo.kt */
    public static final class C0560a {
        public /* synthetic */ C0560a(h r1) {
            this();
        }

        private C0560a() {
        }
    }

    /* JADX INFO: compiled from: ShortCutRepo.kt */
    @d.c.b.a.f(b = "ShortCutRepo.kt", c = {78}, d = "loadCombinedData", e = "com.obric.autoaction.app.launcherpage.shortcut.datasource.ShortCutRepo")
    static final class b extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f24403a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        /* synthetic */ Object f24404b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ a f24405c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        int f24406d;

        b(a r3, d.c.d<? super b> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f24405c = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f24404b = r3;
            this.f24406d |= Integer.MIN_VALUE;
            return a.a(this.f24405c, 0, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: ShortCutRepo.kt */
    @d.c.b.a.f(b = "ShortCutRepo.kt", c = {85}, d = "loadShortcutTasks", e = "com.obric.autoaction.app.launcherpage.shortcut.datasource.ShortCutRepo")
    static final class c extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        /* synthetic */ Object f24407a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ a f24408b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        int f24409c;

        c(a r3, d.c.d<? super c> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f24408b = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f24407a = r3;
            this.f24409c |= Integer.MIN_VALUE;
            return a.b(this.f24408b, 0, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: ShortCutRepo.kt */
    @d.c.b.a.f(b = "ShortCutRepo.kt", c = {55}, d = "invokeSuspend", e = "com.obric.autoaction.app.launcherpage.shortcut.datasource.ShortCutRepo$shortCutList$1")
    static final class d extends l implements m<i<? super d.x>, d.c.d<? super d.x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f24410a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private /* synthetic */ Object f24411b;

        d(d.c.d<? super d> r3) {
            super(2, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        public final Object a(i<? super d.x> r3, d.c.d<? super d.x> r4) {
            return ((d) ZeusTransformUtils.preCheckCast(create((i) ZeusTransformUtils.wrapperContextForParams(r3, i.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), d.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<d.x> create(Object r2, d.c.d<?> r3) {
            d r4 = new d((d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin"));
            r4.f24411b = r2;
            return (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(i<? super d.x> r3, d.c.d<? super d.x> r4) {
            return a((i) ZeusTransformUtils.preCheckCast(r3, i.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r6) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f24410a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            o.a(r6);
        L12:
            return d.x.f38692a;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            o.a(r6);
            i r7 = (i) ZeusTransformUtils.preCheckCast(this.f24411b, i.class, "com.obric.aiagent.plugin");
            d.x r2 = d.x.f38692a;
            d.c.d<? super d.x> r3 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f24410a = 1;
            if (r7.emit(r2, r3) != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: compiled from: ShortCutRepo.kt */
    @d.c.b.a.f(b = "ShortCutRepo.kt", c = {}, d = "invokeSuspend", e = "com.obric.autoaction.app.launcherpage.shortcut.datasource.ShortCutRepo$shortCutList$2")
    static final class e extends l implements q<Integer, d.x, d.c.d<? super Integer>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f24412a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        /* synthetic */ int f24413b;

        e(d.c.d<? super e> r3) {
            super(3, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        public final Object a(int r1, d.x r2, d.c.d<? super Integer> r3) {
            e r4 = new e((d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin"));
            r4.f24413b = r1;
            return r4.invokeSuspend(d.x.f38692a);
        }

        @Override // d.h.a.q
        public /* synthetic */ Object invoke(Integer r3, d.x r4, d.c.d<? super Integer> r5) {
            return a(((Number) ZeusTransformUtils.preCheckCast(r3, Number.class, "com.obric.aiagent.plugin")).intValue(), (d.x) ZeusTransformUtils.preCheckCast(r4, d.x.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r5, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r2) {
            d.c.a.b.a();
            if (this.f24412a != 0) goto L7;
            o.a(r2);
            return d.c.b.a.b.a(this.f24413b);
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: compiled from: ShortCutRepo.kt */
    @d.c.b.a.f(b = "ShortCutRepo.kt", c = {59}, d = "invokeSuspend", e = "com.obric.autoaction.app.launcherpage.shortcut.datasource.ShortCutRepo$shortCutList$3")
    static final class f extends l implements m<Integer, d.c.d<? super List<? extends com.obric.autoaction.app.launcherpage.module.datasource.f.b>>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f24414a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        /* synthetic */ int f24415b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ a f24416c;

        f(a r3, d.c.d<? super f> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f24416c = r3;
            super(2, r5);
        }

        public final Object a(int r3, d.c.d<? super List<com.obric.autoaction.app.launcherpage.module.datasource.f.b>> r4) {
            d.c.d<?> r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            return ((f) ZeusTransformUtils.preCheckCast(create(Integer.valueOf(r3), r5), f.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<d.x> create(Object r3, d.c.d<?> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            f r0 = new f(this.f24416c, r5);
            r0.f24415b = ((Number) ZeusTransformUtils.preCheckCast(r3, Number.class, "com.obric.aiagent.plugin")).intValue();
            return (d.c.d) ZeusTransformUtils.preCheckCast(r0, d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(Integer r3, d.c.d<? super List<? extends com.obric.autoaction.app.launcherpage.module.datasource.f.b>> r4) {
            return a(((Number) ZeusTransformUtils.preCheckCast(r3, Number.class, "com.obric.aiagent.plugin")).intValue(), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r6) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f24414a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            o.a(r6);
        L11:
            return r6;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            o.a(r6);
            int r7 = this.f24415b;
            a r2 = this.f24416c;
            d.c.d r3 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f24414a = 1;
            r6 = a.a(r2, r7, r3);
            if (r6 != r0) goto L11;
            return r0;
        }
    }

    static {
        f24398a = new C0560a(null);
    }

    public a(am r7) {
        am r8 = (am) ZeusTransformUtils.wrapperContextForParams(r7, am.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r8, "scope");
        this.f24399b = r8;
        this.f24400c = "ShortCutRepo";
        x<Integer> r0 = kotlinx.coroutines.b.am.a(200);
        this.f24401d = r0;
        w<d.x> r3 = ad.a(0, 1, null, 5, null);
        this.f24402e = r3;
        x<Boolean> r2 = kotlinx.coroutines.b.am.a(false);
        this.f = r2;
        this.g = (ak) ZeusTransformUtils.preCheckCast(r2, ak.class, "com.obric.aiagent.plugin");
        this.h = j.a(j.a(j.b(j.b((kotlinx.coroutines.b.h) ZeusTransformUtils.preCheckCast(r0, kotlinx.coroutines.b.h.class, "com.obric.aiagent.plugin"), j.a((kotlinx.coroutines.b.h) ZeusTransformUtils.preCheckCast(r3, kotlinx.coroutines.b.h.class, "com.obric.aiagent.plugin"), (m) ZeusTransformUtils.preCheckCast(new d(null), m.class, "com.obric.aiagent.plugin")), (q) ZeusTransformUtils.preCheckCast(new e(null), q.class, "com.obric.aiagent.plugin")), (m) ZeusTransformUtils.preCheckCast(new f(this, null), m.class, "com.obric.aiagent.plugin")), (g) ZeusTransformUtils.preCheckCast(bd.c(), g.class, "com.obric.aiagent.plugin")), r8, ah.f38981a.b(), p.b());
    }

    public static final /* synthetic */ Object a(a r2, int r3, d.c.d r4) {
        return r2.a(r3, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    public static final /* synthetic */ Object b(a r2, int r3, d.c.d r4) {
        return r2.b(r3, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    public ak<Boolean> a() {
        return this.g;
    }

    public ak<List<com.obric.autoaction.app.launcherpage.module.datasource.f.b>> b() {
        return this.h;
    }

    public void c() {
        int r0 = ((Number) ZeusTransformUtils.preCheckCast(this.f24401d.c(), Number.class, "com.obric.aiagent.plugin")).intValue();
        int r1 = ((List) ZeusTransformUtils.preCheckCast(b().c(), List.class, "com.obric.aiagent.plugin")).size();
        if (r1 <= 0) goto L6;
        if (r1 >= r0) goto L6;
        return;
    L6:
        x<Integer> r4 = this.f24401d;
    L7:
        Integer r2 = r4.c();
        if (r4.a(r2, Integer.valueOf(((Number) ZeusTransformUtils.preCheckCast(r2, Number.class, "com.obric.aiagent.plugin")).intValue() + 200)) == false) goto L7;
    }

    public void d() {
        this.f24402e.a(d.x.f38692a);
    }

    private final Object a(int r6, d.c.d<? super List<com.obric.autoaction.app.launcherpage.module.datasource.f.b>> r7) {
        d.c.d r8 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r7, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r8, b.class) == false) goto L7;
        b r0 = (b) ZeusTransformUtils.preCheckCast(r8, b.class, "com.obric.aiagent.plugin");
        if ((r0.f24406d & Integer.MIN_VALUE) == 0) goto L7;
        r0.f24406d -= Integer.MIN_VALUE;
    L8:
        Object r9 = r0.f24404b;
        Object r2 = d.c.a.b.a();
        int r3 = r0.f24406d;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        a this = (a) ZeusTransformUtils.preCheckCast(r0.f24403a, a.class, "com.obric.aiagent.plugin");
        o.a(r9);
    L17:
        List r10 = (List) ZeusTransformUtils.preCheckCast(r9, List.class, "com.obric.aiagent.plugin");
        Loog.INSTANCE.i(this.f24400c, "shortcut size = " + r10.size());
        this.f.b(d.c.b.a.b.a(true));
        return r10;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        o.a(r9);
        r0.f24403a = this;
        r0.f24406d = 1;
        r9 = b(r6, r0);
        if (r9 != r2) goto L17;
        return r2;
    L7:
        r0 = new b(this, r8);
        goto L8
    }

    private final Object b(int r7, d.c.d<? super List<com.obric.autoaction.app.launcherpage.module.datasource.f.b>> r8) {
        d.c.d r9 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r8, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r9, c.class) == false) goto L7;
        c r0 = (c) ZeusTransformUtils.preCheckCast(r9, c.class, "com.obric.aiagent.plugin");
        if ((r0.f24409c & Integer.MIN_VALUE) == 0) goto L7;
        r0.f24409c -= Integer.MIN_VALUE;
    L8:
        Object r6 = r0.f24407a;
        Object r10 = d.c.a.b.a();
        int r2 = r0.f24409c;
        List r3 = null;
        if (r2 == 0) goto L14;
        if (r2 != 1) goto L13;
        o.a(r6);
    L19:
        List r11 = (List) ZeusTransformUtils.preCheckCast(r6, List.class, "com.obric.aiagent.plugin");
        if (r11 == null) goto L37;
        Iterable r12 = (Iterable) ZeusTransformUtils.preCheckCast(r11, Iterable.class, "com.obric.aiagent.plugin");
        Collection r13 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");
        Iterator r14 = r12.iterator();
    L23:
        if (r14.hasNext() == false) goto L27;
        Object r15 = r14.next();
        if (ZeusTransformUtils.instanceOf(r15, ShortcutTask.class) == false) goto L23;
        r13.add(r15);
        goto L23
    L27:
        Iterable r16 = (Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r13, List.class, "com.obric.aiagent.plugin"), Iterable.class, "com.obric.aiagent.plugin");
        Collection r17 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");
        Iterator r18 = r16.iterator();
    L29:
        if (r18.hasNext() == false) goto L36;
        com.obric.autoaction.app.launcherpage.module.datasource.f r19 = com.obric.autoaction.app.launcherpage.module.datasource.g.a((EventTask) ZeusTransformUtils.preCheckCast((ShortcutTask) ZeusTransformUtils.preCheckCast(r18.next(), ShortcutTask.class, "com.obric.aiagent.plugin"), EventTask.class, "com.obric.aiagent.plugin"));
        if (ZeusTransformUtils.instanceOf(r19, com.obric.autoaction.app.launcherpage.module.datasource.f.b.class) == false) goto L33;
        com.obric.autoaction.app.launcherpage.module.datasource.f.b r20 = (com.obric.autoaction.app.launcherpage.module.datasource.f.b) ZeusTransformUtils.preCheckCast(r19, com.obric.autoaction.app.launcherpage.module.datasource.f.b.class, "com.obric.aiagent.plugin");
    L34:
        if (r20 == null) goto L29;
        r17.add(r20);
        goto L29
    L33:
        r20 = null;
        goto L34
    L36:
        r3 = (List) ZeusTransformUtils.preCheckCast(r17, List.class, "com.obric.aiagent.plugin");
    L37:
        if (r3 == null) goto L39;
        return r3;
    L39:
        return p.b();
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        o.a(r6);
        IEventTaskApi r21 = (IEventTaskApi) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IEventTaskApi.class), IEventTaskApi.class, "com.obric.aiagent.plugin");
        if (r21 == null) goto L37;
        r0.f24409c = 1;
        r6 = r21.getEventTasksByType(3, 0, r7, r0);
        if (r6 != r10) goto L19;
        return r10;
    L7:
        r0 = new c(this, r9);
        goto L8
    }
}
