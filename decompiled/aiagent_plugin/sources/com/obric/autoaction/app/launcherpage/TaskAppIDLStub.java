package com.obric.autoaction.app.launcherpage;

import android.app.Application;
import android.app.PendingIntent;
import android.content.Context;
import android.os.IBinder;
import com.obric.agent.auth.IAgentAuthService;
import com.obric.aiagent.assistant.idl.IAgentTaskAppIDLSPI;
import com.obric.aiagent.assistant.idl.bean.ShortcutRecommendItem;
import com.obric.autogui.common.api.logging.Loog;
import com.obric.capabilitykit.apphost.AppHost;
import com.obric.capabilitykit.common.intent.BaseEventTaskSubmitTaskIntent;
import com.obric.capabilitykit.common.intent.IntentParams;
import com.obric.capabilitykit.common.intent.SystemAutoActionParams;
import com.obric.eventkit.task.api.IEventTaskApi;
import com.obric.eventkit.task.api.IEventTaskExecutionApi;
import com.obric.eventkit.task.model.ConditionTask;
import com.obric.eventkit.task.model.ConditionTaskAction;
import com.obric.eventkit.task.model.EventTask;
import com.obric.eventkit.task.model.ShortcutTask;
import com.obric.eventkit.task.model.ShortcutTaskAction;
import com.obric.eventkit.task.model.TaskKnowledge;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.p;
import d.c.b.a.l;
import d.h.a.m;
import d.n;
import d.o;
import d.x;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlinx.coroutines.am;
import kotlinx.coroutines.an;
import kotlinx.coroutines.bd;

/* JADX INFO: compiled from: TaskAppIDLStub.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class TaskAppIDLStub implements IAgentTaskAppIDLSPI {
    public static final a Companion = null;
    private static final List<Integer> EVENT_TASK_TYPES_FOR_GUIDE = null;
    private static final int HAS_SHORTCUT_QUERY_PAGE_SIZE = 20;
    public static final String TAG = "IAgentTaskAppIDL";

    /* JADX INFO: compiled from: TaskAppIDLStub.kt */
    public static final class a {
        public /* synthetic */ a(d.h.b.h r1) {
            this();
        }

        private a() {
        }
    }

    /* JADX INFO: compiled from: TaskAppIDLStub.kt */
    @d.c.b.a.f(b = "TaskAppIDLStub.kt", c = {}, d = "invokeSuspend", e = "com.obric.autoaction.app.launcherpage.TaskAppIDLStub$addTaskManagerShortcut$1")
    static final class b extends l implements m<am, d.c.d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f22666a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ PendingIntent f22667b;

        b(PendingIntent r3, d.c.d<? super b> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f22667b = r3;
            super(2, r5);
        }

        public final Object a(am r3, d.c.d<? super x> r4) {
            return ((b) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), b.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r2, d.c.d<?> r3) {
            d.c.d r4 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new b(this.f22667b, r4), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r4) {
            d.c.a.b.a();
            if (this.f22666a != 0) goto L7;
            o.a(r4);
            com.obric.autoaction.app.launcherpage.utils.e r5 = com.obric.autoaction.app.launcherpage.utils.e.f24474a;
            Context r0 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppHost.Companion.getApplication(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin")).getApplicationContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
            d.h.b.o.c(r0, "getApplicationContext(...)");
            r5.a(r0, this.f22667b);
            return x.f38692a;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: compiled from: TaskAppIDLStub.kt */
    @d.c.b.a.f(b = "TaskAppIDLStub.kt", c = {153, 158}, d = "anyShortcutMatchesFrom", e = "com.obric.autoaction.app.launcherpage.TaskAppIDLStub")
    static final class c extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f22668a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f22669b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        int f22670c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        /* synthetic */ Object f22671d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ TaskAppIDLStub f22672e;
        int f;

        c(TaskAppIDLStub r3, d.c.d<? super c> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f22672e = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f22671d = r3;
            this.f |= Integer.MIN_VALUE;
            return TaskAppIDLStub.access$anyShortcutMatchesFrom(this.f22672e, null, 0, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: TaskAppIDLStub.kt */
    @d.c.b.a.f(b = "TaskAppIDLStub.kt", c = {165}, d = "invokeSuspend", e = "com.obric.autoaction.app.launcherpage.TaskAppIDLStub$getShortcutRecommendItems$1$1")
    static final class d extends l implements m<am, d.c.d<? super List<? extends ShortcutRecommendItem>>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f22673a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f22674b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ TaskAppIDLStub f22675c;

        d(int r3, TaskAppIDLStub r4, d.c.d<? super d> r5) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            this.f22674b = r3;
            this.f22675c = r4;
            super(2, r6);
        }

        public final Object a(am r3, d.c.d<? super List<ShortcutRecommendItem>> r4) {
            return ((d) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), d.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r3, d.c.d<?> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new d(this.f22674b, this.f22675c, r5), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super List<? extends ShortcutRecommendItem>> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r8) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f22673a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            o.a(r8);
        L13:
            List r9 = (List) ZeusTransformUtils.preCheckCast(r8, List.class, "com.obric.aiagent.plugin");
            if (r9 == null) goto L28;
            Iterable r10 = (Iterable) ZeusTransformUtils.preCheckCast(r9, Iterable.class, "com.obric.aiagent.plugin");
            Collection r2 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");
            Iterator r11 = r10.iterator();
        L17:
            if (r11.hasNext() == false) goto L21;
            Object r3 = r11.next();
            if (ZeusTransformUtils.instanceOf(r3, ShortcutTask.class) == false) goto L17;
            r2.add(r3);
            goto L17
        L21:
            Iterable r12 = (Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r2, List.class, "com.obric.aiagent.plugin"), Iterable.class, "com.obric.aiagent.plugin");
            TaskAppIDLStub r7 = this.f22675c;
            Collection r4 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");
            Iterator r13 = r12.iterator();
        L23:
            if (r13.hasNext() == false) goto L27;
            ShortcutRecommendItem r5 = TaskAppIDLStub.access$toRecommendItem(r7, (ShortcutTask) ZeusTransformUtils.preCheckCast(r13.next(), ShortcutTask.class, "com.obric.aiagent.plugin"));
            if (r5 == null) goto L23;
            r4.add(r5);
            goto L23
        L27:
            List r14 = (List) ZeusTransformUtils.preCheckCast(r4, List.class, "com.obric.aiagent.plugin");
        L29:
            if (r14 == null) goto L31;
            return r14;
        L31:
            return p.b();
        L28:
            r14 = null;
            goto L29
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            o.a(r8);
            IEventTaskApi r15 = (IEventTaskApi) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IEventTaskApi.class), IEventTaskApi.class, "com.obric.aiagent.plugin");
            if (r15 == null) goto L28;
            int r6 = this.f22674b;
            d.c.d<? super List<? extends EventTask>> r16 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f22673a = 1;
            r8 = r15.getEventTasksByType(3, 0, r6, r16);
            if (r8 != r0) goto L13;
            return r0;
        }
    }

    /* JADX INFO: compiled from: TaskAppIDLStub.kt */
    @d.c.b.a.f(b = "TaskAppIDLStub.kt", c = {128}, d = "hasAnyEventTask", e = "com.obric.autoaction.app.launcherpage.TaskAppIDLStub")
    static final class e extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f22676a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        /* synthetic */ Object f22677b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ TaskAppIDLStub f22678c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        int f22679d;

        e(TaskAppIDLStub r3, d.c.d<? super e> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f22678c = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f22677b = r3;
            this.f22679d |= Integer.MIN_VALUE;
            return TaskAppIDLStub.access$hasAnyEventTask(this.f22678c, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: TaskAppIDLStub.kt */
    @d.c.b.a.f(b = "TaskAppIDLStub.kt", c = {143}, d = "invokeSuspend", e = "com.obric.autoaction.app.launcherpage.TaskAppIDLStub$hasShortcutForMessage$1")
    static final class f extends l implements m<am, d.c.d<? super Boolean>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f22680a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ TaskAppIDLStub f22681b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f22682c;

        f(TaskAppIDLStub r3, String r4, d.c.d<? super f> r5) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            this.f22681b = r3;
            this.f22682c = r4;
            super(2, r6);
        }

        public final Object a(am r3, d.c.d<? super Boolean> r4) {
            return ((f) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), f.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r3, d.c.d<?> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new f(this.f22681b, this.f22682c, r5), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super Boolean> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r7) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f22680a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            o.a(r7);
        L11:
            return r7;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            o.a(r7);
            TaskAppIDLStub r8 = this.f22681b;
            String r2 = this.f22682c;
            d.c.d r4 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f22680a = 1;
            r7 = TaskAppIDLStub.access$anyShortcutMatchesFrom(r8, r2, 0, r4);
            if (r7 != r0) goto L11;
            return r0;
        }
    }

    /* JADX INFO: compiled from: TaskAppIDLStub.kt */
    @d.c.b.a.f(b = "TaskAppIDLStub.kt", c = {57, 58, 59}, d = "invokeSuspend", e = "com.obric.autoaction.app.launcherpage.TaskAppIDLStub$openEventTaskDetailPage$1")
    static final class g extends l implements m<am, d.c.d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f22683a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f22684b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f22685c;

        /* JADX INFO: renamed from: com.obric.autoaction.app.launcherpage.TaskAppIDLStub$g$1, reason: invalid class name */
        /* JADX INFO: compiled from: TaskAppIDLStub.kt */
        @d.c.b.a.f(b = "TaskAppIDLStub.kt", c = {}, d = "invokeSuspend", e = "com.obric.autoaction.app.launcherpage.TaskAppIDLStub$openEventTaskDetailPage$1$1")
        static final class AnonymousClass1 extends l implements m<am, d.c.d<? super x>, Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            int f22686a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ EventTask f22687b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            final /* synthetic */ String f22688c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            final /* synthetic */ String f22689d;

            AnonymousClass1(EventTask r3, String r4, String r5, d.c.d<? super AnonymousClass1> r6) {
                d.c.d r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r6, d.c.d.class, "com.obric.aiagent.plugin");
                this.f22687b = r3;
                this.f22688c = r4;
                this.f22689d = r5;
                super(2, r7);
            }

            public final Object a(am r3, d.c.d<? super x> r4) {
                return ((AnonymousClass1) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), AnonymousClass1.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
            }

            @Override // d.c.b.a.a
            public final d.c.d<x> create(Object r4, d.c.d<?> r5) {
                d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
                return (d.c.d) ZeusTransformUtils.preCheckCast(new AnonymousClass1(this.f22687b, this.f22688c, this.f22689d, r6), d.c.d.class, "com.obric.aiagent.plugin");
            }

            @Override // d.h.a.m
            public /* synthetic */ Object invoke(am r3, d.c.d<? super x> r4) {
                return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
            }

            @Override // d.c.b.a.a
            public final Object invokeSuspend(Object r13) {
                d.c.a.b.a();
                if (this.f22686a != 0) goto L17;
                o.a(r13);
                EventTask r14 = this.f22687b;
                if (r14 != null) goto L8;
                Loog.INSTANCE.e(TaskAppIDLStub.TAG, "openEventTaskDetailPage " + this.f22688c + " eventTask is null");
            L15:
                return x.f38692a;
            L8:
                if (com.obric.autoaction.app.launcherpage.utils.m.b(r14) == false) goto L11;
                com.obric.autoaction.app.launcherpage.detail.condition.a r15 = com.obric.autoaction.app.launcherpage.detail.condition.a.f23400a;
                Context r0 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppHost.Companion.getApplication(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin")).getApplicationContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
                d.h.b.o.c(r0, "getApplicationContext(...)");
                r15.a(r0, this.f22689d, this.f22688c, this.f22687b);
                goto L15
            L11:
                if (com.obric.autoaction.app.launcherpage.utils.m.a(this.f22687b) == false) goto L13;
                com.obric.autoaction.app.launcherpage.detail.shortcut.a r4 = com.obric.autoaction.app.launcherpage.detail.shortcut.a.f23480a;
                Context r5 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppHost.Companion.getApplication(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin")).getApplicationContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
                d.h.b.o.c(r5, "getApplicationContext(...)");
                com.obric.autoaction.app.launcherpage.detail.shortcut.a.a(r4, r5, this.f22689d, this.f22688c, this.f22687b, null, 16, null);
                goto L15
            L13:
                Loog.INSTANCE.e(TaskAppIDLStub.TAG, "openEventTaskDetailPage " + this.f22688c + " eventTask is not condition task or shortcut task");
                goto L15
            L17:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        g(String r3, String r4, d.c.d<? super g> r5) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            this.f22684b = r3;
            this.f22685c = r4;
            super(2, r6);
        }

        public final Object a(am r3, d.c.d<? super x> r4) {
            return ((g) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), g.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r3, d.c.d<?> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new g(this.f22684b, this.f22685c, r5), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r18) {
            Object r1 = d.c.a.b.a();
            int r2 = this.f22683a;
            boolean r4 = false;
            if (r2 == 0) goto L12;
            if (r2 == 1) goto L11;
            if (r2 == 2) goto L10;
            if (r2 != 3) goto L9;
            o.a(r18);
        L32:
            return x.f38692a;
        L9:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L10:
            o.a(r18);
            Object r3 = r18;
        L26:
            EventTask r5 = (EventTask) ZeusTransformUtils.preCheckCast(r3, EventTask.class, "com.obric.aiagent.plugin");
        L28:
            d.c.g r6 = (d.c.g) ZeusTransformUtils.preCheckCast(bd.b(), d.c.g.class, "com.obric.aiagent.plugin");
            m r7 = (m) ZeusTransformUtils.preCheckCast(new AnonymousClass1(r5, this.f22684b, this.f22685c, null), m.class, "com.obric.aiagent.plugin");
            d.c.d r8 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f22683a = 3;
            if (kotlinx.coroutines.i.a(r6, r7, r8) != r1) goto L32;
            return r1;
        L11:
            o.a(r18);
            Object r9 = r18;
        L18:
            if (((Boolean) ZeusTransformUtils.preCheckCast(r9, Boolean.class, "com.obric.aiagent.plugin")).booleanValue() != true) goto L20;
            r4 = true;
        L20:
            if (r4 == false) goto L32;
            IEventTaskApi r10 = (IEventTaskApi) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IEventTaskApi.class), IEventTaskApi.class, "com.obric.aiagent.plugin");
            if (r10 == null) goto L27;
            String r11 = this.f22684b;
            d.c.d<? super EventTask> r12 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f22683a = 2;
            r3 = r10.getEventTask(r11, r12);
            if (r3 != r1) goto L26;
            return r1;
        L27:
            r5 = null;
            goto L28
        L12:
            o.a(r18);
            IAgentAuthService r13 = (IAgentAuthService) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IAgentAuthService.class), IAgentAuthService.class, "com.obric.aiagent.plugin");
            if (r13 == null) goto L20;
            String r14 = new BaseEventTaskSubmitTaskIntent().getName();
            d.c.d r15 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f22683a = 1;
            r9 = IAgentAuthService.b.a(r13, r14, null, false, null, r15, 14, null);
            if (r9 != r1) goto L18;
            return r1;
        }
    }

    /* JADX INFO: compiled from: TaskAppIDLStub.kt */
    @d.c.b.a.f(b = "TaskAppIDLStub.kt", c = {181}, d = "invokeSuspend", e = "com.obric.autoaction.app.launcherpage.TaskAppIDLStub$runShortcutTaskFromRecommendPanel$1")
    static final class h extends l implements m<am, d.c.d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f22690a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f22691b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f22692c;

        h(String r3, String r4, d.c.d<? super h> r5) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            this.f22691b = r3;
            this.f22692c = r4;
            super(2, r6);
        }

        public final Object a(am r3, d.c.d<? super x> r4) {
            return ((h) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), h.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r3, d.c.d<?> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new h(this.f22691b, this.f22692c, r5), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r7) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f22690a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            o.a(r7);
        L16:
            return x.f38692a;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            o.a(r7);
            IEventTaskExecutionApi r8 = (IEventTaskExecutionApi) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IEventTaskExecutionApi.class), IEventTaskExecutionApi.class, "com.obric.aiagent.plugin");
            if (r8 == null) goto L14;
            String r2 = this.f22691b;
            String r4 = this.f22692c;
            d.c.d<? super x> r3 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f22690a = 1;
            if (r8.scheduleShortcutTask(r2, r4, r3) != r0) goto L16;
            return r0;
        L14:
            return null;
        }
    }

    /* JADX INFO: compiled from: TaskAppIDLStub.kt */
    @d.c.b.a.f(b = "TaskAppIDLStub.kt", c = {117}, d = "invokeSuspend", e = "com.obric.autoaction.app.launcherpage.TaskAppIDLStub$shouldShowAddTaskManagerIconGuide$1")
    static final class i extends l implements m<am, d.c.d<? super Boolean>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f22693a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ TaskAppIDLStub f22694b;

        i(TaskAppIDLStub r3, d.c.d<? super i> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f22694b = r3;
            super(2, r5);
        }

        public final Object a(am r3, d.c.d<? super Boolean> r4) {
            return ((i) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), i.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r2, d.c.d<?> r3) {
            d.c.d r4 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new i(this.f22694b, r4), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super Boolean> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r5) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f22693a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            o.a(r5);
        L11:
            return r5;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            o.a(r5);
            TaskAppIDLStub r6 = this.f22694b;
            d.c.d r2 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f22693a = 1;
            r5 = TaskAppIDLStub.access$hasAnyEventTask(r6, r2);
            if (r5 != r0) goto L11;
            return r0;
        }
    }

    /* JADX INFO: compiled from: TaskAppIDLStub.kt */
    @d.c.b.a.f(b = "TaskAppIDLStub.kt", c = {81, 84}, d = "invokeSuspend", e = "com.obric.autoaction.app.launcherpage.TaskAppIDLStub$testRunConditionTask$1")
    static final class j extends l implements m<am, d.c.d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f22695a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f22696b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f22697c;

        j(String r3, String r4, d.c.d<? super j> r5) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            this.f22696b = r3;
            this.f22697c = r4;
            super(2, r6);
        }

        public final Object a(am r3, d.c.d<? super x> r4) {
            return ((j) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), j.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r3, d.c.d<?> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new j(this.f22696b, this.f22697c, r5), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r14) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f22695a;
            ConditionTask r2 = null;
            if (r1 == 0) goto L10;
            if (r1 == 1) goto L9;
            if (r1 != 2) goto L8;
            o.a(r14);
        L33:
            return x.f38692a;
        L8:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L9:
            o.a(r14);
        L15:
            EventTask r15 = (EventTask) ZeusTransformUtils.preCheckCast(r14, EventTask.class, "com.obric.aiagent.plugin");
        L17:
            if (r15 == null) goto L35;
            if (com.obric.autoaction.app.launcherpage.utils.m.b(r15) == false) goto L35;
            if (ZeusTransformUtils.instanceOf(r15, ConditionTask.class) == false) goto L24;
            r2 = (ConditionTask) ZeusTransformUtils.preCheckCast(r15, ConditionTask.class, "com.obric.aiagent.plugin");
        L24:
            if (r2 == null) goto L26;
            IEventTaskExecutionApi r6 = (IEventTaskExecutionApi) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IEventTaskExecutionApi.class), IEventTaskExecutionApi.class, "com.obric.aiagent.plugin");
            if (r6 == null) goto L33;
            String r7 = this.f22696b;
            List<ConditionTaskAction> r8 = r2.getActions();
            TaskKnowledge r9 = r2.getTaskKnowledge();
            int r10 = r2.getTaskMode();
            String r11 = this.f22697c;
            d.c.d<? super x> r12 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f22695a = 2;
            if (r6.tryScheduleConditionTask(r7, r8, r9, r10, r11, r12) != r0) goto L33;
            return r0;
        L26:
            return x.f38692a;
        L35:
            return x.f38692a;
        L10:
            o.a(r14);
            IEventTaskApi r16 = (IEventTaskApi) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IEventTaskApi.class), IEventTaskApi.class, "com.obric.aiagent.plugin");
            if (r16 == null) goto L16;
            String r3 = this.f22696b;
            d.c.d<? super EventTask> r13 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f22695a = 1;
            r14 = r16.getEventTask(r3, r13);
            if (r14 != r0) goto L15;
            return r0;
        L16:
            r15 = null;
            goto L17
        }
    }

    public TaskAppIDLStub() {
    }

    public static final /* synthetic */ Object access$anyShortcutMatchesFrom(TaskAppIDLStub r2, String r3, int r4, d.c.d r5) {
        return r2.anyShortcutMatchesFrom(r3, r4, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    public static final /* synthetic */ Object access$hasAnyEventTask(TaskAppIDLStub r2, d.c.d r3) {
        return r2.hasAnyEventTask((d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    public static final /* synthetic */ ShortcutRecommendItem access$toRecommendItem(TaskAppIDLStub r0, ShortcutTask r1) {
        return r0.toRecommendItem(r1);
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentTaskAppIDLSPI, android.os.IInterface
    public IBinder asBinder() {
        return IAgentTaskAppIDLSPI.b.a(this);
    }

    static {
        Companion = new a(null);
        EVENT_TASK_TYPES_FOR_GUIDE = p.b(new Integer[]{2, 1, 3});
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentTaskAppIDL
    public void openEventTaskDetailPage(String r8, String r9) {
        d.h.b.o.e(r8, DBDefinition.TASK_ID);
        CharSequence r7 = (CharSequence) ZeusTransformUtils.preCheckCast(r9, CharSequence.class, "com.obric.aiagent.plugin");
        if (r7 != null) goto L5;
    L8:
        boolean r10 = true;
    L9:
        if (r10 == false) goto L11;
        r9 = "flow_card";
    L11:
        kotlinx.coroutines.i.a(an.a((d.c.g) ZeusTransformUtils.preCheckCast(bd.c(), d.c.g.class, "com.obric.aiagent.plugin")), null, null, (m) ZeusTransformUtils.preCheckCast(new g(r8, r9, null), m.class, "com.obric.aiagent.plugin"), 3, null);
        return;
    L5:
        if (r7.length() == 0) goto L8;
        r10 = false;
        goto L9
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentTaskAppIDL
    public void testRunConditionTask(String r9, String r10) {
        d.h.b.o.e(r9, DBDefinition.TASK_ID);
        kotlinx.coroutines.i.a(an.a((d.c.g) ZeusTransformUtils.preCheckCast(bd.c(), d.c.g.class, "com.obric.aiagent.plugin")), null, null, (m) ZeusTransformUtils.preCheckCast(new j(r9, r10, null), m.class, "com.obric.aiagent.plugin"), 3, null);
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentTaskAppIDL
    public void addTaskManagerShortcut(PendingIntent r9) {
        kotlinx.coroutines.i.a(an.a((d.c.g) ZeusTransformUtils.preCheckCast(bd.b(), d.c.g.class, "com.obric.aiagent.plugin")), null, null, (m) ZeusTransformUtils.preCheckCast(new b(r9, null), m.class, "com.obric.aiagent.plugin"), 3, null);
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentTaskAppIDL
    public boolean shouldShowAddTaskManagerIconGuide() {
        com.obric.autoaction.app.launcherpage.utils.e r0 = com.obric.autoaction.app.launcherpage.utils.e.f24474a;
        Context r1 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppHost.Companion.getApplication(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin")).getApplicationContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        d.h.b.o.c(r1, "getApplicationContext(...)");
        if (r0.b(r1) == false) goto L7;
        return false;
    L7:
        return ((Boolean) ZeusTransformUtils.preCheckCast(kotlinx.coroutines.i.a(null, (m) ZeusTransformUtils.preCheckCast(new i(this, null), m.class, "com.obric.aiagent.plugin"), 1, null), Boolean.class, "com.obric.aiagent.plugin")).booleanValue();
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:25:0x00ab -> B:27:0x00ae). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:28:0x00b7 -> B:29:0x00b8). Please report as a decompilation issue!!! */
    private final Object hasAnyEventTask(d.c.d<? super Boolean> r8) {
        d.c.d r9 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r8, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r9, e.class) == false) goto L7;
        e r0 = (e) ZeusTransformUtils.preCheckCast(r9, e.class, "com.obric.aiagent.plugin");
        if ((r0.f22679d & Integer.MIN_VALUE) == 0) goto L7;
        r0.f22679d -= Integer.MIN_VALUE;
    L8:
        Object r7 = r0.f22677b;
        Object r10 = d.c.a.b.a();
        int r2 = r0.f22679d;
        boolean r3 = false;
        if (r2 == 0) goto L14;
        if (r2 != 1) goto L13;
        Iterator r4 = (Iterator) ZeusTransformUtils.preCheckCast(r0.f22676a, Iterator.class, "com.obric.aiagent.plugin");
        o.a(r7);
    L27:
        List r11 = (List) ZeusTransformUtils.preCheckCast(r7, List.class, "com.obric.aiagent.plugin");
    L29:
        Collection r12 = (Collection) ZeusTransformUtils.preCheckCast(r11, Collection.class, "com.obric.aiagent.plugin");
        if (r12 != null) goto L32;
    L35:
        boolean r13 = true;
    L37:
        if ((!r13) == false) goto L21;
        r3 = true;
    L40:
        return d.c.b.a.b.a(r3);
    L21:
        if (r4.hasNext() == false) goto L40;
        int r14 = ((Number) ZeusTransformUtils.preCheckCast(r4.next(), Number.class, "com.obric.aiagent.plugin")).intValue();
        IEventTaskApi r5 = (IEventTaskApi) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IEventTaskApi.class), IEventTaskApi.class, "com.obric.aiagent.plugin");
        if (r5 == null) goto L28;
        r0.f22676a = r4;
        r0.f22679d = 1;
        r7 = r5.getEventTasksByType(r14, 0, 1, r0);
        if (r7 != r10) goto L27;
        return r10;
    L28:
        r11 = null;
        goto L29
    L32:
        if (r12.isEmpty() == true) goto L35;
        r13 = false;
        goto L37
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        o.a(r7);
        Iterable r15 = (Iterable) ZeusTransformUtils.preCheckCast(EVENT_TASK_TYPES_FOR_GUIDE, Iterable.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r15, Collection.class) == true) goto L17;
    L19:
        r4 = r15.iterator();
        goto L21
    L17:
        if (((Collection) ZeusTransformUtils.preCheckCast(r15, Collection.class, "com.obric.aiagent.plugin")).isEmpty() == false) goto L19;
    L7:
        r0 = new e(this, r9);
        goto L8
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentTaskAppIDL
    public boolean hasShortcutForMessage(String r5) {
        CharSequence r0 = (CharSequence) ZeusTransformUtils.preCheckCast(r5, CharSequence.class, "com.obric.aiagent.plugin");
        if (r0 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == false) goto L12;
        return false;
    L12:
        return ((Boolean) ZeusTransformUtils.preCheckCast(kotlinx.coroutines.i.a(null, (m) ZeusTransformUtils.preCheckCast(new f(this, r5, null), m.class, "com.obric.aiagent.plugin"), 1, null), Boolean.class, "com.obric.aiagent.plugin")).booleanValue();
    L5:
        if (r0.length() == 0) goto L8;
        r1 = false;
        goto L9
    }

    private final Object anyShortcutMatchesFrom(String r11, int r12, d.c.d<? super Boolean> r13) {
        d.c.d r14 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r13, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r14, c.class) == false) goto L7;
        c r0 = (c) ZeusTransformUtils.preCheckCast(r14, c.class, "com.obric.aiagent.plugin");
        if ((r0.f & Integer.MIN_VALUE) == 0) goto L7;
        r0.f -= Integer.MIN_VALUE;
    L8:
        Object r15 = r0.f22671d;
        Object r2 = d.c.a.b.a();
        int r3 = r0.f;
        if (r3 == 0) goto L16;
        if (r3 == 1) goto L15;
        if (r3 != 2) goto L14;
        o.a(r15);
    L57:
        return r15;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        r12 = r0.f22670c;
        r11 = (String) ZeusTransformUtils.preCheckCast(r0.f22669b, String.class, "com.obric.aiagent.plugin");
        TaskAppIDLStub this = (TaskAppIDLStub) ZeusTransformUtils.preCheckCast(r0.f22668a, TaskAppIDLStub.class, "com.obric.aiagent.plugin");
        o.a(r15);
    L21:
        List r16 = (List) ZeusTransformUtils.preCheckCast(r15, List.class, "com.obric.aiagent.plugin");
    L23:
        Collection r4 = (Collection) ZeusTransformUtils.preCheckCast(r16, Collection.class, "com.obric.aiagent.plugin");
        boolean r7 = false;
        if (r4 != null) goto L26;
    L29:
        boolean r5 = true;
    L30:
        if (r5 == true) goto L32;
        Iterable r6 = (Iterable) ZeusTransformUtils.preCheckCast(r16, Iterable.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r6, Collection.class) == true) goto L36;
    L38:
        Iterator r8 = r6.iterator();
    L40:
        if (r8.hasNext() == false) goto L51;
        EventTask r9 = (EventTask) ZeusTransformUtils.preCheckCast(r8.next(), EventTask.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r9, ShortcutTask.class) == false) goto L44;
        ShortcutTask r10 = (ShortcutTask) ZeusTransformUtils.preCheckCast(r9, ShortcutTask.class, "com.obric.aiagent.plugin");
    L45:
        if (r10 == null) goto L47;
        String r17 = com.obric.autoaction.app.launcherpage.utils.m.a(r10);
    L49:
        if (d.h.b.o.a(r17, r11) == false) goto L40;
        r7 = true;
        goto L51
    L47:
        r17 = null;
        goto L49
    L44:
        r10 = null;
    L51:
        if (r7 == true) goto L53;
        int r18 = r12 + r16.size();
        r0.f22668a = null;
        r0.f22669b = null;
        r0.f = 2;
        r15 = this.anyShortcutMatchesFrom(r11, r18, r0);
        if (r15 != r2) goto L57;
        return r2;
    L53:
        return d.c.b.a.b.a(true);
    L36:
        if (((Collection) ZeusTransformUtils.preCheckCast(r6, Collection.class, "com.obric.aiagent.plugin")).isEmpty() == false) goto L38;
    L32:
        return d.c.b.a.b.a(false);
    L26:
        if (r4.isEmpty() == true) goto L29;
        r5 = false;
        goto L30
    L16:
        o.a(r15);
        IEventTaskApi r19 = (IEventTaskApi) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IEventTaskApi.class), IEventTaskApi.class, "com.obric.aiagent.plugin");
        if (r19 == null) goto L22;
        r0.f22668a = this;
        r0.f22669b = r11;
        r0.f22670c = r12;
        r0.f = 1;
        r15 = r19.getEventTasksByType(3, r12, 20, r0);
        if (r15 != r2) goto L21;
        return r2;
    L22:
        r16 = null;
    L7:
        r0 = new c(this, r14);
        goto L8
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentTaskAppIDL
    public List<ShortcutRecommendItem> getShortcutRecommendItems(int r5) {
        if (r5 <= 0) goto L5;
        n.a r1 = n.f38560a;     // Catch: Throwable -> L8
        Object r4 = n.f((List) ZeusTransformUtils.preCheckCast(kotlinx.coroutines.i.a(null, (m) ZeusTransformUtils.preCheckCast(new d(r5, (TaskAppIDLStub) ZeusTransformUtils.preCheckCast(this, TaskAppIDLStub.class, "com.obric.aiagent.plugin"), null), m.class, "com.obric.aiagent.plugin"), 1, null), List.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L8
    L10:
        Throwable r6 = n.c(r4);
        if (r6 == null) goto L13;
        Loog.INSTANCE.e(TAG, "getShortcutRecommendItems failed: " + r6.getMessage());
    L13:
        List r7 = p.b();
        if (n.b(r4) == false) goto L17;
        r4 = r7;
    L17:
        return (List) ZeusTransformUtils.preCheckCast(r4, List.class, "com.obric.aiagent.plugin");
    L8:
        th = move-exception;
        n.a r8 = n.f38560a;
        r4 = n.f(o.a(th));
        goto L10
    L5:
        return p.b();
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentTaskAppIDL
    public void runShortcutTaskFromRecommendPanel(String r3, String r4) {
        d.h.b.o.e(r3, DBDefinition.TASK_ID);
        if (d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r3, CharSequence.class, "com.obric.aiagent.plugin")) == false) goto L6;
        Loog.INSTANCE.e(TAG, "runShortcutTaskFromRecommendPanel taskId is blank");
        return;
    L6:
        kotlinx.coroutines.i.a(null, (m) ZeusTransformUtils.preCheckCast(new h(r3, r4, null), m.class, "com.obric.aiagent.plugin"), 1, null);
    }

    private final ShortcutRecommendItem toRecommendItem(ShortcutTask r11) {
        String r10 = r11.getId();
        if (r10 != null) goto L5;
    L30:
        return null;
    L5:
        if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r10, CharSequence.class, "com.obric.aiagent.plugin"))) == false) goto L7;
        String r4 = r10;
    L8:
        if (r4 == null) goto L30;
        ShortcutTaskAction r12 = (ShortcutTaskAction) ZeusTransformUtils.preCheckCast(p.l(r11.getActions()), ShortcutTaskAction.class, "com.obric.aiagent.plugin");
        if (r12 == null) goto L13;
        IntentParams r13 = r12.getParams();
    L15:
        if (ZeusTransformUtils.instanceOf(r13, SystemAutoActionParams.class) == false) goto L17;
        SystemAutoActionParams r14 = (SystemAutoActionParams) ZeusTransformUtils.preCheckCast(r13, SystemAutoActionParams.class, "com.obric.aiagent.plugin");
    L18:
        if (r14 == null) goto L21;
        String r15 = r14.getInstruction();
        if (r15 == null) goto L21;
    L22:
        String r5 = r15;
        String r6 = r11.getShortInstruct();
        boolean r7 = r11.isShortInstructEnable();
        Long r16 = r11.getCreateTime();
        if (r16 == null) goto L25;
        long r8 = r16.longValue();
    L26:
        ShortcutRecommendItem r17 = new ShortcutRecommendItem(r4, r5, r6, r7, r8);
        if (d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r17.getDisplayText(), CharSequence.class, "com.obric.aiagent.plugin")) == false) goto L29;
        return null;
    L29:
        return r17;
    L25:
        r8 = 0;
    L21:
        r15 = "";
        goto L22
    L17:
        r14 = null;
        goto L18
    L13:
        r13 = null;
        goto L15
    L7:
        r4 = null;
        goto L8
    }
}
