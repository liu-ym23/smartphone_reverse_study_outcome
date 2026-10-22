package com.obric.autoaction.app.launcherpage.module.datasource;

import com.obric.autogui.common.api.logging.Loog;
import com.obric.autogui.database.AutoActionDatabase;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.p;
import d.c.b.a.l;
import d.h.a.q;
import d.h.a.r;
import d.m;
import d.o;
import java.util.Collection;
import java.util.List;
import kotlinx.coroutines.am;
import kotlinx.coroutines.b.ad;
import kotlinx.coroutines.b.ah;
import kotlinx.coroutines.b.ak;
import kotlinx.coroutines.b.w;
import kotlinx.coroutines.b.x;

/* JADX INFO: compiled from: TaskRepository.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class e implements com.obric.autoaction.app.launcherpage.module.datasource.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f24206a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final am f24207b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final com.obric.autogui.database.a f24208c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final x<String> f24209d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final x<Integer> f24210e;
    private final w<d.x> f;
    private final kotlinx.coroutines.b.h<List<com.obric.autogui.database.entity.a>> g;

    /* JADX INFO: compiled from: TaskRepository.kt */
    public static final class a {
        public /* synthetic */ a(d.h.b.h r1) {
            this();
        }

        private a() {
        }
    }

    /* JADX INFO: compiled from: Merge.kt */
    @d.c.b.a.f(b = "TaskRepository.kt", c = {189}, d = "invokeSuspend", e = "com.obric.autoaction.app.launcherpage.module.datasource.TaskRepositoryImpl$special$$inlined$flatMapLatest$1")
    public static final class b extends l implements q<kotlinx.coroutines.b.i<? super List<? extends com.obric.autogui.database.entity.a>>, m<? extends String, ? extends Integer>, d.c.d<? super d.x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f24211a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        /* synthetic */ Object f24212b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ e f24213c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private /* synthetic */ Object f24214d;

        public b(d.c.d r3, e r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
            this.f24213c = r4;
            super(3, r5);
        }

        public final Object a(kotlinx.coroutines.b.i<? super List<? extends com.obric.autogui.database.entity.a>> r3, m<? extends String, ? extends Integer> r4, d.c.d<? super d.x> r5) {
            kotlinx.coroutines.b.i r6 = (kotlinx.coroutines.b.i) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.b.i.class, "com.obric.aiagent.plugin");
            b r0 = new b((d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin"), this.f24213c);
            r0.f24214d = r6;
            r0.f24212b = r4;
            return r0.invokeSuspend(d.x.f38692a);
        }

        @Override // d.h.a.q
        public /* synthetic */ Object invoke(kotlinx.coroutines.b.i<? super List<? extends com.obric.autogui.database.entity.a>> r3, m<? extends String, ? extends Integer> r4, d.c.d<? super d.x> r5) {
            return a((kotlinx.coroutines.b.i) ZeusTransformUtils.preCheckCast(r3, kotlinx.coroutines.b.i.class, "com.obric.aiagent.plugin"), r4, (d.c.d) ZeusTransformUtils.preCheckCast(r5, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r9) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f24211a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            o.a(r9);
        L12:
            return d.x.f38692a;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            o.a(r9);
            kotlinx.coroutines.b.i r10 = (kotlinx.coroutines.b.i) ZeusTransformUtils.preCheckCast(this.f24214d, kotlinx.coroutines.b.i.class, "com.obric.aiagent.plugin");
            Object r2 = this.f24212b;
            d.c.d r4 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            m r3 = (m) ZeusTransformUtils.preCheckCast(r2, m.class, "com.obric.aiagent.plugin");
            String r5 = (String) ZeusTransformUtils.preCheckCast(r3.c(), String.class, "com.obric.aiagent.plugin");
            int r6 = ((Number) ZeusTransformUtils.preCheckCast(r3.d(), Number.class, "com.obric.aiagent.plugin")).intValue();
            Loog.INSTANCE.i("TaskRepo", "Re-querying DB: id=" + r5 + ", limit=" + r6);
            kotlinx.coroutines.b.h<List<com.obric.autogui.database.entity.a>> r7 = e.a(this.f24213c).a(r6, 0, r5);
            d.c.d r8 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f24211a = 1;
            if (kotlinx.coroutines.b.j.a(r10, r7, r8) != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: compiled from: TaskRepository.kt */
    @d.c.b.a.f(b = "TaskRepository.kt", c = {35}, d = "invokeSuspend", e = "com.obric.autoaction.app.launcherpage.module.datasource.TaskRepositoryImpl$taskList$1")
    static final class c extends l implements d.h.a.m<kotlinx.coroutines.b.i<? super d.x>, d.c.d<? super d.x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f24215a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private /* synthetic */ Object f24216b;

        c(d.c.d<? super c> r3) {
            super(2, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        public final Object a(kotlinx.coroutines.b.i<? super d.x> r3, d.c.d<? super d.x> r4) {
            return ((c) ZeusTransformUtils.preCheckCast(create((kotlinx.coroutines.b.i) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.b.i.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), c.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<d.x> create(Object r2, d.c.d<?> r3) {
            c r4 = new c((d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin"));
            r4.f24216b = r2;
            return (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(kotlinx.coroutines.b.i<? super d.x> r3, d.c.d<? super d.x> r4) {
            return a((kotlinx.coroutines.b.i) ZeusTransformUtils.preCheckCast(r3, kotlinx.coroutines.b.i.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r6) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f24215a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            o.a(r6);
        L12:
            return d.x.f38692a;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            o.a(r6);
            kotlinx.coroutines.b.i r7 = (kotlinx.coroutines.b.i) ZeusTransformUtils.preCheckCast(this.f24216b, kotlinx.coroutines.b.i.class, "com.obric.aiagent.plugin");
            d.x r2 = d.x.f38692a;
            d.c.d<? super d.x> r3 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f24215a = 1;
            if (r7.emit(r2, r3) != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: compiled from: TaskRepository.kt */
    @d.c.b.a.f(b = "TaskRepository.kt", c = {}, d = "invokeSuspend", e = "com.obric.autoaction.app.launcherpage.module.datasource.TaskRepositoryImpl$taskList$2")
    static final class d extends l implements r<String, Integer, d.x, d.c.d<? super m<? extends String, ? extends Integer>>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f24217a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        /* synthetic */ Object f24218b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        /* synthetic */ int f24219c;

        d(d.c.d<? super d> r3) {
            super(4, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.h.a.r
        public /* synthetic */ Object a(String r3, Integer r4, d.x r5, d.c.d<? super m<? extends String, ? extends Integer>> r6) {
            return a((String) ZeusTransformUtils.preCheckCast(r3, String.class, "com.obric.aiagent.plugin"), ((Number) ZeusTransformUtils.preCheckCast(r4, Number.class, "com.obric.aiagent.plugin")).intValue(), (d.x) ZeusTransformUtils.preCheckCast(r5, d.x.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r6, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        public final Object a(String r1, int r2, d.x r3, d.c.d<? super m<String, Integer>> r4) {
            d r5 = new d((d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin"));
            r5.f24218b = r1;
            r5.f24219c = r2;
            return r5.invokeSuspend(d.x.f38692a);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            d.c.a.b.a();
            if (this.f24217a != 0) goto L7;
            o.a(r3);
            return new m((String) ZeusTransformUtils.preCheckCast(this.f24218b, String.class, "com.obric.aiagent.plugin"), d.c.b.a.b.a(this.f24219c));
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.obric.autoaction.app.launcherpage.module.datasource.e$e, reason: collision with other inner class name */
    /* JADX INFO: compiled from: TaskRepository.kt */
    @d.c.b.a.f(b = "TaskRepository.kt", c = {47}, d = "invokeSuspend", e = "com.obric.autoaction.app.launcherpage.module.datasource.TaskRepositoryImpl$taskList$4")
    static final class C0554e extends l implements q<kotlinx.coroutines.b.i<? super List<? extends com.obric.autogui.database.entity.a>>, Throwable, d.c.d<? super d.x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f24220a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        /* synthetic */ Object f24221b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private /* synthetic */ Object f24222c;

        C0554e(d.c.d<? super C0554e> r3) {
            super(3, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        public final Object a(kotlinx.coroutines.b.i<? super List<com.obric.autogui.database.entity.a>> r2, Throwable r3, d.c.d<? super d.x> r4) {
            kotlinx.coroutines.b.i r1 = (kotlinx.coroutines.b.i) ZeusTransformUtils.wrapperContextForParams(r2, kotlinx.coroutines.b.i.class, "com.obric.aiagent.plugin");
            C0554e r5 = new C0554e((d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin"));
            r5.f24222c = r1;
            r5.f24221b = r3;
            return r5.invokeSuspend(d.x.f38692a);
        }

        @Override // d.h.a.q
        public /* synthetic */ Object invoke(kotlinx.coroutines.b.i<? super List<? extends com.obric.autogui.database.entity.a>> r3, Throwable r4, d.c.d<? super d.x> r5) {
            return a((kotlinx.coroutines.b.i) ZeusTransformUtils.preCheckCast(r3, kotlinx.coroutines.b.i.class, "com.obric.aiagent.plugin"), (Throwable) ZeusTransformUtils.preCheckCast(r4, Throwable.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r5, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r8) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f24220a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            o.a(r8);
        L12:
            return d.x.f38692a;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            o.a(r8);
            kotlinx.coroutines.b.i r9 = (kotlinx.coroutines.b.i) ZeusTransformUtils.preCheckCast(this.f24222c, kotlinx.coroutines.b.i.class, "com.obric.aiagent.plugin");
            Loog.INSTANCE.e("TaskRepo", "Error in task flow: " + ((Throwable) ZeusTransformUtils.preCheckCast(this.f24221b, Throwable.class, "com.obric.aiagent.plugin")).getMessage());
            List r2 = p.b();
            d.c.d<? super d.x> r3 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f24222c = null;
            this.f24220a = 1;
            if (r9.emit(r2, r3) != r0) goto L12;
            return r0;
        }
    }

    static {
        f24206a = new a(null);
    }

    public e(am r8) {
        am r9 = (am) ZeusTransformUtils.wrapperContextForParams(r8, am.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r9, "scope");
        this.f24207b = r9;
        this.f24208c = new com.obric.autogui.database.a(AutoActionDatabase.f29019e.a());
        x<String> r2 = kotlinx.coroutines.b.am.a(null);
        this.f24209d = r2;
        x<Integer> r3 = kotlinx.coroutines.b.am.a(90);
        this.f24210e = r3;
        w<d.x> r4 = ad.a(0, 1, null, 5, null);
        this.f = r4;
        this.g = (kotlinx.coroutines.b.h) ZeusTransformUtils.preCheckCast(kotlinx.coroutines.b.j.a(kotlinx.coroutines.b.j.a(kotlinx.coroutines.b.j.b(kotlinx.coroutines.b.j.a((kotlinx.coroutines.b.h) ZeusTransformUtils.preCheckCast(r2, kotlinx.coroutines.b.h.class, "com.obric.aiagent.plugin"), (kotlinx.coroutines.b.h) ZeusTransformUtils.preCheckCast(r3, kotlinx.coroutines.b.h.class, "com.obric.aiagent.plugin"), kotlinx.coroutines.b.j.a((kotlinx.coroutines.b.h) ZeusTransformUtils.preCheckCast(r4, kotlinx.coroutines.b.h.class, "com.obric.aiagent.plugin"), (d.h.a.m) ZeusTransformUtils.preCheckCast(new c(null), d.h.a.m.class, "com.obric.aiagent.plugin")), (r) ZeusTransformUtils.preCheckCast(new d(null), r.class, "com.obric.aiagent.plugin")), (q) ZeusTransformUtils.preCheckCast(new b(null, this), q.class, "com.obric.aiagent.plugin")), (q) ZeusTransformUtils.preCheckCast(new C0554e(null), q.class, "com.obric.aiagent.plugin")), r9, ah.f38981a.b(), p.b()), kotlinx.coroutines.b.h.class, "com.obric.aiagent.plugin");
    }

    public static final /* synthetic */ com.obric.autogui.database.a a(e r0) {
        return r0.f24208c;
    }

    @Override // com.obric.autoaction.app.launcherpage.module.datasource.a
    public kotlinx.coroutines.b.h<List<com.obric.autogui.database.entity.a>> a() {
        return this.g;
    }

    @Override // com.obric.autoaction.app.launcherpage.module.datasource.a
    public void a(String r3) {
        if (d.h.b.o.a(this.f24209d.c(), r3) == true) goto L6;
        this.f24210e.b(90);
        this.f24209d.b(r3);
        return;
    }

    @Override // com.obric.autoaction.app.launcherpage.module.datasource.a
    public void b() {
        this.f24210e.b(90);
    }

    @Override // com.obric.autoaction.app.launcherpage.module.datasource.a
    public void c() {
        kotlinx.coroutines.b.h<List<com.obric.autogui.database.entity.a>> r0 = a();
        if (ZeusTransformUtils.instanceOf(r0, ak.class) == false) goto L5;
        ak r1 = (ak) ZeusTransformUtils.preCheckCast(r0, ak.class, "com.obric.aiagent.plugin");
    L6:
        if (r1 == null) goto L9;
        List r2 = (List) ZeusTransformUtils.preCheckCast(r1.c(), List.class, "com.obric.aiagent.plugin");
        if (r2 == null) goto L9;
    L10:
        int r3 = ((Number) ZeusTransformUtils.preCheckCast(this.f24210e.c(), Number.class, "com.obric.aiagent.plugin")).intValue();
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r2, Collection.class, "com.obric.aiagent.plugin")).isEmpty()) == true) goto L13;
    L16:
        Loog.INSTANCE.i("TaskRepo", "Loading more tasks... New Limit: " + (r3 + 30));
        x<Integer> r6 = this.f24210e;
    L17:
        Integer r4 = r6.c();
        if (r6.a(r4, Integer.valueOf(((Number) ZeusTransformUtils.preCheckCast(r4, Number.class, "com.obric.aiagent.plugin")).intValue() + 30)) == false) goto L17;
        return;
    L13:
        if (r2.size() >= r3) goto L16;
        Loog.INSTANCE.i("TaskRepo", "Has no more data. Loaded: " + r2.size() + ", Limit: " + r3);
        return;
    L9:
        r2 = p.b();
        goto L10
    L5:
        r1 = null;
        goto L6
    }

    @Override // com.obric.autoaction.app.launcherpage.module.datasource.a
    public Object a(List<Long> r3, d.c.d<? super d.x> r4) {
        List<Long> r5 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
        d.c.d<? super d.x> r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
        Object r2 = this.f24208c.a(r5, r6);
        if (r2 != d.c.a.b.a()) goto L6;
        return r2;
    L6:
        return d.x.f38692a;
    }

    @Override // com.obric.autoaction.app.launcherpage.module.datasource.a
    public Object b(List<String> r3, d.c.d<? super d.x> r4) {
        List<String> r5 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
        d.c.d<? super d.x> r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
        Object r2 = this.f24208c.b(r5, r6);
        if (r2 != d.c.a.b.a()) goto L6;
        return r2;
    L6:
        return d.x.f38692a;
    }
}
