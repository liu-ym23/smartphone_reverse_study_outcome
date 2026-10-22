package com.obric.event.task.base.report;

import com.obric.autoaction.app.launcherpage.api.ITaskDataApi;
import com.obric.eventkit.task.api.IEventTaskApi;
import com.obric.eventkit.task.model.ConditionTask;
import com.obric.eventkit.task.model.EventTask;
import com.obric.eventkit.task.model.ShortcutTask;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.x;
import kotlinx.coroutines.am;

/* JADX INFO: compiled from: TaskDataApiImpl.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class TaskDataApiImpl implements ITaskDataApi {

    /* JADX INFO: compiled from: TaskDataApiImpl.kt */
    @d.c.b.a.f(b = "TaskDataApiImpl.kt", c = {19}, d = "invokeSuspend", e = "com.obric.event.task.base.report.TaskDataApiImpl$getInstructionType$conditionTask$1")
    static final class a extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super EventTask>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f32752a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f32753b;

        a(String r3, d.c.d<? super a> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f32753b = r3;
            super(2, r5);
        }

        public final Object a(am r3, d.c.d<? super EventTask> r4) {
            return ((a) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), a.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r2, d.c.d<?> r3) {
            d.c.d r4 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new a(this.f32753b, r4), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super EventTask> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r6) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f32752a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            d.o.a(r6);
        L16:
            return (EventTask) ZeusTransformUtils.preCheckCast(r6, EventTask.class, "com.obric.aiagent.plugin");
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            d.o.a(r6);
            IEventTaskApi r7 = (IEventTaskApi) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IEventTaskApi.class), IEventTaskApi.class, "com.obric.aiagent.plugin");
            if (r7 == null) goto L14;
            String r2 = this.f32753b;
            d.c.d<? super EventTask> r4 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f32752a = 1;
            r6 = r7.getEventTask(r2, r4);
            if (r6 != r0) goto L16;
            return r0;
        L14:
            return null;
        }
    }

    /* JADX INFO: compiled from: TaskDataApiImpl.kt */
    @d.c.b.a.f(b = "TaskDataApiImpl.kt", c = {29}, d = "invokeSuspend", e = "com.obric.event.task.base.report.TaskDataApiImpl$getShortcutInstructionType$shortcutTask$1")
    static final class b extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super EventTask>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f32754a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f32755b;

        b(String r3, d.c.d<? super b> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f32755b = r3;
            super(2, r5);
        }

        public final Object a(am r3, d.c.d<? super EventTask> r4) {
            return ((b) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), b.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r2, d.c.d<?> r3) {
            d.c.d r4 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new b(this.f32755b, r4), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super EventTask> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r6) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f32754a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            d.o.a(r6);
        L16:
            return (EventTask) ZeusTransformUtils.preCheckCast(r6, EventTask.class, "com.obric.aiagent.plugin");
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            d.o.a(r6);
            IEventTaskApi r7 = (IEventTaskApi) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IEventTaskApi.class), IEventTaskApi.class, "com.obric.aiagent.plugin");
            if (r7 == null) goto L14;
            String r2 = this.f32755b;
            d.c.d<? super EventTask> r4 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f32754a = 1;
            r6 = r7.getEventTask(r2, r4);
            if (r6 != r0) goto L16;
            return r0;
        L14:
            return null;
        }
    }

    public TaskDataApiImpl() {
    }

    @Override // com.obric.autoaction.app.launcherpage.api.ITaskDataApi
    public String getInstructionType(String r5) {
        d.h.b.o.e(r5, DBDefinition.TASK_ID);
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r5, CharSequence.class, "com.obric.aiagent.plugin")).length() != 0) goto L5;
        boolean r4 = true;
    L7:
        if (r4 == false) goto L9;
        return "";
    L9:
        ConditionTask r3 = null;
        Object r6 = kotlinx.coroutines.i.a(null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new a(r5, null), d.h.a.m.class, "com.obric.aiagent.plugin"), 1, null);
        if (ZeusTransformUtils.instanceOf(r6, ConditionTask.class) == false) goto L12;
        r3 = (ConditionTask) ZeusTransformUtils.preCheckCast(r6, ConditionTask.class, "com.obric.aiagent.plugin");
    L12:
        if (r3 != null) goto L15;
        return "";
    L15:
        return o.f32870a.a(r3);
    L5:
        r4 = false;
        goto L7
    }

    @Override // com.obric.autoaction.app.launcherpage.api.ITaskDataApi
    public String getShortcutInstructionType(String r5) {
        d.h.b.o.e(r5, DBDefinition.TASK_ID);
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r5, CharSequence.class, "com.obric.aiagent.plugin")).length() != 0) goto L5;
        boolean r4 = true;
    L7:
        if (r4 == false) goto L9;
        return "";
    L9:
        String r3 = null;
        Object r6 = kotlinx.coroutines.i.a(null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new b(r5, null), d.h.a.m.class, "com.obric.aiagent.plugin"), 1, null);
        if (ZeusTransformUtils.instanceOf(r6, ShortcutTask.class) == false) goto L12;
        ShortcutTask r7 = (ShortcutTask) ZeusTransformUtils.preCheckCast(r6, ShortcutTask.class, "com.obric.aiagent.plugin");
    L13:
        if (r7 != null) goto L15;
        return "";
    L15:
        String r8 = r7.getShortInstruct();
        if (r7.isShortInstructEnable() == false) goto L19;
        r3 = r8;
    L19:
        return o.f32870a.b(r3);
    L12:
        r7 = null;
        goto L13
    L5:
        r4 = false;
        goto L7
    }

    @Override // com.obric.autoaction.app.launcherpage.api.ITaskDataApi
    public void trySweepConditionalTaskIfNeeded() {
        o.f32870a.a();
    }

    @Override // com.obric.autoaction.app.launcherpage.api.ITaskDataApi
    public void reportTaskCountMobOnForeground() {
        l.f32861a.a();
    }
}
