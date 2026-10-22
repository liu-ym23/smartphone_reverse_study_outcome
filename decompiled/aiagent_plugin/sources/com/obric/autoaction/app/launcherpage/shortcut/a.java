package com.obric.autoaction.app.launcherpage.shortcut;

import androidx.lifecycle.aj;
import androidx.lifecycle.ak;
import com.bytedance.bdturing.localstorage.DbHelper;
import com.obric.autoaction.app.launcherpage.ui.h;
import com.obric.autogui.common.api.logging.Loog;
import com.obric.autogui.database.service.EventTaskService;
import com.obric.capabilitykit.common.intent.IntentParams;
import com.obric.capabilitykit.common.intent.SystemAutoActionParams;
import com.obric.eventkit.ITaskManagerApi;
import com.obric.eventkit.task.api.IEventTaskExecutionApi;
import com.obric.eventkit.task.api.IEventTaskListenerApi;
import com.obric.eventkit.task.model.EventTask;
import com.obric.eventkit.task.model.EventTaskResult;
import com.obric.eventkit.task.model.ShortcutTask;
import com.obric.eventkit.task.model.ShortcutTaskAction;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.p;
import d.c.b.a.f;
import d.c.b.a.l;
import d.c.d;
import d.c.g;
import d.h.a.m;
import d.h.a.q;
import d.o;
import d.s;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlinx.coroutines.am;
import kotlinx.coroutines.b.i;
import kotlinx.coroutines.b.j;
import kotlinx.coroutines.b.x;
import kotlinx.coroutines.bd;

/* JADX INFO: compiled from: ShortCutViewModel.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class a extends aj {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f24382a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final com.obric.autoaction.app.launcherpage.shortcut.a.a f24383b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final x<List<h>> f24384c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final com.obric.eventkit.task.api.a f24385d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f24386e;

    /* JADX INFO: renamed from: com.obric.autoaction.app.launcherpage.shortcut.a$1, reason: invalid class name */
    /* JADX INFO: compiled from: ShortCutViewModel.kt */
    @f(b = "ShortCutViewModel.kt", c = {49}, d = "invokeSuspend", e = "com.obric.autoaction.app.launcherpage.shortcut.ShortCutViewModel$1")
    static final class AnonymousClass1 extends l implements m<am, d<? super d.x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f24387a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ a f24388b;

        /* JADX INFO: renamed from: com.obric.autoaction.app.launcherpage.shortcut.a$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: ShortCutViewModel.kt */
        @f(b = "ShortCutViewModel.kt", c = {}, d = "invokeSuspend", e = "com.obric.autoaction.app.launcherpage.shortcut.ShortCutViewModel$1$1")
        static final class C05581 extends l implements q<List<? extends com.obric.autoaction.app.launcherpage.module.datasource.f.b>, Boolean, d<? super d.m<? extends Boolean, ? extends List<? extends com.obric.autoaction.app.launcherpage.module.datasource.f.b>>>, Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            int f24389a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            /* synthetic */ Object f24390b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            /* synthetic */ boolean f24391c;

            C05581(d<? super C05581> r3) {
                super(3, (d) ZeusTransformUtils.wrapperContextForParams(r3, d.class, "com.obric.aiagent.plugin"));
            }

            public final Object a(List<com.obric.autoaction.app.launcherpage.module.datasource.f.b> r2, boolean r3, d<? super d.m<Boolean, ? extends List<com.obric.autoaction.app.launcherpage.module.datasource.f.b>>> r4) {
                List r1 = (List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.aiagent.plugin");
                C05581 r5 = new C05581((d) ZeusTransformUtils.wrapperContextForParams(r4, d.class, "com.obric.aiagent.plugin"));
                r5.f24390b = r1;
                r5.f24391c = r3;
                return r5.invokeSuspend(d.x.f38692a);
            }

            @Override // d.h.a.q
            public /* synthetic */ Object invoke(List<? extends com.obric.autoaction.app.launcherpage.module.datasource.f.b> r3, Boolean r4, d<? super d.m<? extends Boolean, ? extends List<? extends com.obric.autoaction.app.launcherpage.module.datasource.f.b>>> r5) {
                return a((List) ZeusTransformUtils.preCheckCast(r3, List.class, "com.obric.aiagent.plugin"), ((Boolean) ZeusTransformUtils.preCheckCast(r4, Boolean.class, "com.obric.aiagent.plugin")).booleanValue(), (d) ZeusTransformUtils.preCheckCast(r5, d.class, "com.obric.aiagent.plugin"));
            }

            @Override // d.c.b.a.a
            public final Object invokeSuspend(Object r3) {
                d.c.a.b.a();
                if (this.f24389a != 0) goto L7;
                o.a(r3);
                List r4 = (List) ZeusTransformUtils.preCheckCast(this.f24390b, List.class, "com.obric.aiagent.plugin");
                return s.a(d.c.b.a.b.a(this.f24391c), r4);
            L7:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        AnonymousClass1(a r3, d<? super AnonymousClass1> r4) {
            d r5 = (d) ZeusTransformUtils.wrapperContextForParams(r4, d.class, "com.obric.aiagent.plugin");
            this.f24388b = r3;
            super(2, r5);
        }

        public final Object a(am r3, d<? super d.x> r4) {
            return ((AnonymousClass1) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d) ZeusTransformUtils.wrapperContextForParams(r4, d.class, "com.obric.aiagent.plugin")), AnonymousClass1.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d<d.x> create(Object r2, d<?> r3) {
            d r4 = (d) ZeusTransformUtils.wrapperContextForParams(r3, d.class, "com.obric.aiagent.plugin");
            return (d) ZeusTransformUtils.preCheckCast(new AnonymousClass1(this.f24388b, r4), d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d<? super d.x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d) ZeusTransformUtils.preCheckCast(r4, d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r7) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f24387a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            o.a(r7);
        L12:
            return d.x.f38692a;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            o.a(r7);
            kotlinx.coroutines.b.h r8 = j.b((kotlinx.coroutines.b.h) ZeusTransformUtils.preCheckCast(a.a(this.f24388b).b(), kotlinx.coroutines.b.h.class, "com.obric.aiagent.plugin"), (kotlinx.coroutines.b.h) ZeusTransformUtils.preCheckCast(a.a(this.f24388b).a(), kotlinx.coroutines.b.h.class, "com.obric.aiagent.plugin"), (q) ZeusTransformUtils.preCheckCast(new C05581(null), q.class, "com.obric.aiagent.plugin"));
            final a r4 = this.f24388b;
            i r2 = (i) ZeusTransformUtils.preCheckCast(new AnonymousClass2(r4), i.class, "com.obric.aiagent.plugin");
            d<? super d.x> r3 = (d) ZeusTransformUtils.preCheckCast(this, d.class, "com.obric.aiagent.plugin");
            this.f24387a = 1;
            if (r8.collect(r2, r3) != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.obric.autoaction.app.launcherpage.shortcut.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: ShortCutViewModel.kt */
    @f(b = "ShortCutViewModel.kt", c = {118}, d = "invokeSuspend", e = "com.obric.autoaction.app.launcherpage.shortcut.ShortCutViewModel$deleteShortCut$1")
    static final class C0559a extends l implements m<am, d<? super d.x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f24393a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f24394b;

        C0559a(String r3, d<? super C0559a> r4) {
            d r5 = (d) ZeusTransformUtils.wrapperContextForParams(r4, d.class, "com.obric.aiagent.plugin");
            this.f24394b = r3;
            super(2, r5);
        }

        public final Object a(am r3, d<? super d.x> r4) {
            return ((C0559a) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d) ZeusTransformUtils.wrapperContextForParams(r4, d.class, "com.obric.aiagent.plugin")), C0559a.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d<d.x> create(Object r2, d<?> r3) {
            d r4 = (d) ZeusTransformUtils.wrapperContextForParams(r3, d.class, "com.obric.aiagent.plugin");
            return (d) ZeusTransformUtils.preCheckCast(new C0559a(this.f24394b, r4), d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d<? super d.x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d) ZeusTransformUtils.preCheckCast(r4, d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r8) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f24393a;
            Integer r2 = null;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            o.a(r8);
        L13:
            EventTaskResult r9 = (EventTaskResult) ZeusTransformUtils.preCheckCast(r8, EventTaskResult.class, "com.obric.aiagent.plugin");
        L15:
            com.obric.event.task.base.report.l r3 = com.obric.event.task.base.report.l.f32861a;
            if (r9 == null) goto L22;
            List<EventTask> r10 = r9.getData();
            if (r10 == null) goto L22;
            EventTask r11 = (EventTask) ZeusTransformUtils.preCheckCast(p.l(r10), EventTask.class, "com.obric.aiagent.plugin");
            if (r11 == null) goto L22;
            r2 = d.c.b.a.b.a(r11.getTaskMode());
        L22:
            r3.a("shortcut", r2);
            com.obric.event.task.base.report.o.f32870a.a(this.f24394b);
            return d.x.f38692a;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            o.a(r8);
            EventTaskService r12 = (EventTaskService) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(EventTaskService.class), EventTaskService.class, "com.obric.aiagent.plugin");
            if (r12 == null) goto L14;
            String[] r4 = {this.f24394b};
            d<? super EventTaskResult> r5 = (d) ZeusTransformUtils.preCheckCast(this, d.class, "com.obric.aiagent.plugin");
            this.f24393a = 1;
            r8 = r12.removeEventTask(r4, r5);
            if (r8 != r0) goto L13;
            return r0;
        L14:
            r9 = null;
            goto L15
        }
    }

    /* JADX INFO: compiled from: ShortCutViewModel.kt */
    @f(b = "ShortCutViewModel.kt", c = {75}, d = "invokeSuspend", e = "com.obric.autoaction.app.launcherpage.shortcut.ShortCutViewModel$runShortcutTask$1")
    static final class b extends l implements m<am, d<? super d.x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f24395a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f24396b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f24397c;

        b(String r3, String r4, d<? super b> r5) {
            d r6 = (d) ZeusTransformUtils.wrapperContextForParams(r5, d.class, "com.obric.aiagent.plugin");
            this.f24396b = r3;
            this.f24397c = r4;
            super(2, r6);
        }

        public final Object a(am r3, d<? super d.x> r4) {
            return ((b) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d) ZeusTransformUtils.wrapperContextForParams(r4, d.class, "com.obric.aiagent.plugin")), b.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d<d.x> create(Object r3, d<?> r4) {
            d r5 = (d) ZeusTransformUtils.wrapperContextForParams(r4, d.class, "com.obric.aiagent.plugin");
            return (d) ZeusTransformUtils.preCheckCast(new b(this.f24396b, this.f24397c, r5), d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d<? super d.x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d) ZeusTransformUtils.preCheckCast(r4, d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r7) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f24395a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            o.a(r7);
        L14:
            return d.x.f38692a;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            o.a(r7);
            IEventTaskExecutionApi r8 = (IEventTaskExecutionApi) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IEventTaskExecutionApi.class), IEventTaskExecutionApi.class, "com.obric.aiagent.plugin");
            if (r8 == null) goto L14;
            String r2 = this.f24396b;
            String r4 = this.f24397c;
            d<? super d.x> r3 = (d) ZeusTransformUtils.preCheckCast(this, d.class, "com.obric.aiagent.plugin");
            this.f24395a = 1;
            if (r8.scheduleShortcutTask(r2, r4, r3) != r0) goto L14;
            return r0;
        }
    }

    public static /* synthetic */ void lambda$Z5tB8TjpyMJxFfhAq0nJdd4hcgQ(a r0, int r1) {
        a(r0, r1);
    }

    public a() {
        this.f24382a = "ShortCutViewModel";
        this.f24383b = new com.obric.autoaction.app.launcherpage.shortcut.a.a(ak.a((aj) ZeusTransformUtils.preCheckCast(this, aj.class, "com.obric.aiagent.plugin")));
        this.f24384c = kotlinx.coroutines.b.am.a(null);
        com.obric.eventkit.task.api.a r1 = new $$Lambda$a$Z5tB8TjpyMJxFfhAq0nJdd4hcgQ(this);
        this.f24385d = r1;
        IEventTaskListenerApi r3 = (IEventTaskListenerApi) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IEventTaskListenerApi.class), IEventTaskListenerApi.class, "com.obric.aiagent.plugin");
        if (r3 == null) goto L5;
        r3.registerEventTaskChangeListener(r1);
    L5:
        kotlinx.coroutines.i.a(ak.a((aj) ZeusTransformUtils.preCheckCast(this, aj.class, "com.obric.aiagent.plugin")), (g) ZeusTransformUtils.preCheckCast(bd.c(), g.class, "com.obric.aiagent.plugin"), null, (m) ZeusTransformUtils.preCheckCast(new AnonymousClass1(this, null), m.class, "com.obric.aiagent.plugin"), 2, null);
        this.f24386e = true;
    }

    public static final /* synthetic */ com.obric.autoaction.app.launcherpage.shortcut.a.a a(a r0) {
        return r0.f24383b;
    }

    public static final /* synthetic */ List a(a r2, List r3) {
        return r2.a((List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin"));
    }

    public static final /* synthetic */ String b(a r0) {
        return r0.f24382a;
    }

    public final x<List<h>> b() {
        return this.f24384c;
    }

    private static final void a(a r2, int r3) {
        if (r3 != 5) goto L6;
        Loog.INSTANCE.i(r2.f24382a, "onChanged");
        r2.f24383b.d();
        return;
    }

    public final void c() {
        this.f24383b.c();
    }

    public final void a(String r9, String r10) {
        d.h.b.o.e(r9, DBDefinition.TASK_ID);
        kotlinx.coroutines.i.a(ak.a((aj) ZeusTransformUtils.preCheckCast(this, aj.class, "com.obric.aiagent.plugin")), (g) ZeusTransformUtils.preCheckCast(bd.c(), g.class, "com.obric.aiagent.plugin"), null, (m) ZeusTransformUtils.preCheckCast(new b(r9, r10, null), m.class, "com.obric.aiagent.plugin"), 2, null);
    }

    private final List<h> a(List<ShortcutTask> r10) {
        List r11 = (List) ZeusTransformUtils.wrapperContextForParams(r10, List.class, "com.obric.aiagent.plugin");
        if (this.f24386e == true) goto L5;
        com.obric.event.task.base.report.l.a(com.obric.event.task.base.report.l.f32861a, r11, null, null, 6, null);
    L5:
        this.f24386e = false;
        Iterable r9 = (Iterable) ZeusTransformUtils.preCheckCast(r11, Iterable.class, "com.obric.aiagent.plugin");
        Collection r12 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(p.a(r9, 10)), Collection.class, "com.obric.aiagent.plugin");
        Iterator r13 = r9.iterator();
    L7:
        if (r13.hasNext() == false) goto L38;
        ShortcutTask r2 = (ShortcutTask) ZeusTransformUtils.preCheckCast(r13.next(), ShortcutTask.class, "com.obric.aiagent.plugin");
        String r3 = r2.getId();
        String r4 = "";
        if (r3 != null) goto L11;
        r3 = "";
    L11:
        ShortcutTaskAction r5 = (ShortcutTaskAction) ZeusTransformUtils.preCheckCast(p.l(r2.getActions()), ShortcutTaskAction.class, "com.obric.aiagent.plugin");
        String r6 = null;
        if (r5 == null) goto L14;
        IntentParams r7 = r5.getParams();
    L16:
        if (ZeusTransformUtils.instanceOf(r7, SystemAutoActionParams.class) == false) goto L18;
        SystemAutoActionParams r8 = (SystemAutoActionParams) ZeusTransformUtils.preCheckCast(r7, SystemAutoActionParams.class, "com.obric.aiagent.plugin");
    L19:
        if (r8 == null) goto L24;
        String r14 = r8.getInstruction();
        if (r14 == null) goto L24;
        r4 = r14;
    L24:
        String r15 = r2.getShortInstruct();
        boolean r16 = true;
        if (r2.isShortInstructEnable() == false) goto L33;
        if (r15 != null) goto L28;
    L30:
        boolean r17 = false;
    L31:
        if (r17 == false) goto L33;
    L34:
        if (r16 == false) goto L36;
        r6 = r15;
    L36:
        r12.add(new com.obric.autoaction.app.launcherpage.shortcut.cell.b(r3, r4, r6, r2.getExt()));
        goto L7
    L28:
        if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r15, CharSequence.class, "com.obric.aiagent.plugin"))) != true) goto L30;
        r17 = true;
    L33:
        r16 = false;
        goto L34
    L18:
        r8 = null;
        goto L19
    L14:
        r7 = null;
        goto L16
    L38:
        return (List) ZeusTransformUtils.preCheckCast(r12, List.class, "com.obric.aiagent.plugin");
    }

    public final Object a(List<String> r6, d<? super Boolean> r7) {
        List<String> r8 = (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.aiagent.plugin");
        d r9 = (d) ZeusTransformUtils.wrapperContextForParams(r7, d.class, "com.obric.aiagent.plugin");
        Loog.INSTANCE.i(this.f24382a, "update shortcut order request count=" + r8.size() + ", first=" + ((String) ZeusTransformUtils.preCheckCast(p.l(r8), String.class, "com.obric.aiagent.plugin")) + ", last=" + ((String) ZeusTransformUtils.preCheckCast(p.n(r8), String.class, "com.obric.aiagent.plugin")));
        ITaskManagerApi r10 = (ITaskManagerApi) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(ITaskManagerApi.class), ITaskManagerApi.class, "com.obric.aiagent.plugin");
        boolean r0 = true;
        if (r10 != null) goto L5;
    L7:
        r0 = false;
    L8:
        Loog.INSTANCE.i(this.f24382a, "update shortcut order result success=" + r0);
        return d.c.b.a.b.a(r0);
    L5:
        if (r10.updateEventTaskDisplayOrder(3, r8) != true) goto L7;
        goto L7
    }

    public final void e() {
        Loog.INSTANCE.i(this.f24382a, "refresh shortcut order list");
        this.f24383b.d();
    }

    public final void a(String r9) {
        d.h.b.o.e(r9, DbHelper.COL_ID);
        kotlinx.coroutines.i.a(ak.a((aj) ZeusTransformUtils.preCheckCast(this, aj.class, "com.obric.aiagent.plugin")), (g) ZeusTransformUtils.preCheckCast(bd.c(), g.class, "com.obric.aiagent.plugin"), null, (m) ZeusTransformUtils.preCheckCast(new C0559a(r9, null), m.class, "com.obric.aiagent.plugin"), 2, null);
    }

    public final boolean f() {
        Iterable r6 = (Iterable) ZeusTransformUtils.preCheckCast(this.f24383b.b().c(), Iterable.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r6, Collection.class) == true) goto L5;
    L7:
        Iterator r7 = r6.iterator();
        int r0 = 0;
    L9:
        if (r7.hasNext() == false) goto L29;
        com.obric.autoaction.app.launcherpage.module.datasource.f.b r4 = (com.obric.autoaction.app.launcherpage.module.datasource.f.b) ZeusTransformUtils.preCheckCast(r7.next(), com.obric.autoaction.app.launcherpage.module.datasource.f.b.class, "com.obric.aiagent.plugin");
        if (r4.b().isShortInstructEnable() == false) goto L23;
        String r5 = r4.b().getShortInstruct();
        if (r5 != null) goto L15;
    L20:
        boolean r8 = false;
    L21:
        if (r8 == false) goto L23;
        boolean r9 = true;
    L24:
        if (r9 == false) goto L9;
        r0 = r0 + 1;
        if (r0 >= 0) goto L9;
        p.d();
        goto L9
    L15:
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r5, CharSequence.class, "com.obric.aiagent.plugin")).length() <= 0) goto L17;
        boolean r10 = true;
    L18:
        if (r10 != true) goto L20;
        r8 = true;
        goto L21
    L17:
        r10 = false;
    L23:
        r9 = false;
    L29:
        if (r0 > 20) goto L32;
        return true;
    L32:
        return false;
    L5:
        if (((Collection) ZeusTransformUtils.preCheckCast(r6, Collection.class, "com.obric.aiagent.plugin")).isEmpty() == false) goto L7;
        r0 = 0;
        goto L29
    }

    @Override // androidx.lifecycle.aj
    public void a() {
        IEventTaskListenerApi r0 = (IEventTaskListenerApi) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IEventTaskListenerApi.class), IEventTaskListenerApi.class, "com.obric.aiagent.plugin");
        if (r0 == null) goto L5;
        r0.unregisterEventTaskChangeListener(this.f24385d);
    L5:
        super.a();
    }
}
