package com.obric.autoaction.app.launcherpage.service.impl;

import android.content.Context;
import com.obric.autoaction.app.launcherpage.api.IAutoTaskApi;
import com.obric.autoaction.app.launcherpage.utils.g;
import com.obric.autoaction.app.launcherpage.utils.h;
import com.obric.autoaction.app.launcherpage.utils.k;
import com.obric.autogui.common.api.app.AOHostAppTools;
import com.obric.autogui.common.api.presentation.ITimerTaskListener;
import com.obric.eventkit.task.model.ConditionTask;
import com.obric.eventkit.task.model.EventTask;
import com.obric.eventkit.task.model.ShortcutTask;
import com.obric.eventkit.task.model.TimerTask;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.p;
import d.c.a.b;
import d.c.b.a.d;
import d.c.b.a.f;
import d.o;
import d.x;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: AutoTaskImpl.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class AutoTaskImpl implements IAutoTaskApi {

    /* JADX INFO: compiled from: AutoTaskImpl.kt */
    @f(b = "AutoTaskImpl.kt", c = {24}, d = "onTaskDelete", e = "com.obric.autoaction.app.launcherpage.service.impl.AutoTaskImpl")
    static final class a extends d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f24368a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        /* synthetic */ Object f24369b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ AutoTaskImpl f24370c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        int f24371d;

        a(AutoTaskImpl r3, d.c.d<? super a> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f24370c = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f24369b = r3;
            this.f24371d |= Integer.MIN_VALUE;
            return this.f24370c.onTaskDelete(null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    public AutoTaskImpl() {
    }

    @Override // com.obric.autoaction.app.launcherpage.api.IAutoTaskApi
    public Object onTaskDelete(EventTask r5, d.c.d<? super x> r6) {
        d.c.d r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r6, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r7, a.class) == false) goto L7;
        a r0 = (a) ZeusTransformUtils.preCheckCast(r7, a.class, "com.obric.aiagent.plugin");
        if ((r0.f24371d & Integer.MIN_VALUE) == 0) goto L7;
        r0.f24371d -= Integer.MIN_VALUE;
    L8:
        Object r4 = r0.f24369b;
        Object r8 = b.a();
        int r2 = r0.f24371d;
        if (r2 == 0) goto L14;
        if (r2 != 1) goto L13;
        r5 = (EventTask) ZeusTransformUtils.preCheckCast(r0.f24368a, EventTask.class, "com.obric.aiagent.plugin");
        o.a(r4);
    L20:
        if (ZeusTransformUtils.instanceOf(r5, ShortcutTask.class) == false) goto L23;
        g.f24481a.b((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AOHostAppTools.INSTANCE.getAppContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), ((ShortcutTask) ZeusTransformUtils.preCheckCast(r5, ShortcutTask.class, "com.obric.aiagent.plugin")).getId());
    L23:
        return x.f38692a;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        o.a(r4);
        if (ZeusTransformUtils.instanceOf(r5, ConditionTask.class) == false) goto L20;
        com.obric.autoaction.app.launcherpage.query.task.a r9 = com.obric.autoaction.app.launcherpage.query.task.a.f24297a;
        ConditionTask r3 = (ConditionTask) ZeusTransformUtils.preCheckCast(r5, ConditionTask.class, "com.obric.aiagent.plugin");
        r0.f24368a = r5;
        r0.f24371d = 1;
        if (r9.b(r3, r0) != r8) goto L20;
        return r8;
    L7:
        r0 = new a(this, r7);
        goto L8
    }

    @Override // com.obric.autoaction.app.launcherpage.api.IAutoTaskApi
    public Object appendSemanticIconExt(String r2, Map<String, String> r3, d.c.d<? super Map<String, String>> r4) {
        Map<String, String> r1 = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.aiagent.plugin");
        d.c.d<? super Map<String, String>> r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
        return k.f24509a.a(r2, r1, r5);
    }

    @Override // com.obric.autoaction.app.launcherpage.api.IAutoTaskApi
    public boolean hasSemanticIconExt(Map<String, String> r2) {
        Map<String, String> r1 = (Map) ZeusTransformUtils.wrapperContextForParams(r2, Map.class, "com.obric.aiagent.plugin");
        return k.f24509a.b(r1);
    }

    @Override // com.obric.autoaction.app.launcherpage.api.IAutoTaskApi
    public void reportTimerTaskUpgradeMob(boolean r1, String r2) {
        com.obric.event.task.base.report.b.f32757a.a(r1, r2);
    }

    @Override // com.obric.autoaction.app.launcherpage.api.IAutoTaskApi
    public void onTimerTasksRemoved(List<TimerTask> r7, boolean r8) {
        List r6 = (List) ZeusTransformUtils.wrapperContextForParams(r7, List.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r6, "timerTasks");
        ITimerTaskListener r9 = (ITimerTaskListener) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(ITimerTaskListener.class), ITimerTaskListener.class, "com.obric.aiagent.plugin");
        if (r9 != null) goto L5;
        return;
    L5:
        Iterable r10 = (Iterable) ZeusTransformUtils.preCheckCast(r6, Iterable.class, "com.obric.aiagent.plugin");
        Collection r1 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(p.a(r10, 10)), Collection.class, "com.obric.aiagent.plugin");
        Iterator r11 = r10.iterator();
    L7:
        if (r11.hasNext() == false) goto L15;
        TimerTask r2 = (TimerTask) ZeusTransformUtils.preCheckCast(r11.next(), TimerTask.class, "com.obric.aiagent.plugin");
        Integer r4 = r2.getId();
        if (r4 == null) goto L11;
        String r5 = r4.toString();
    L12:
        if (r5 != null) goto L14;
        r5 = "";
    L14:
        r1.add(new ITimerTaskListener.TimerTask(r5, r2.getAction(), r2.getExt()));
        goto L7
    L11:
        r5 = null;
        goto L12
    L15:
        r9.onTimerTaskRemoved((List) ZeusTransformUtils.preCheckCast(r1, List.class, "com.obric.aiagent.plugin"), r8);
    }

    @Override // com.obric.autoaction.app.launcherpage.api.IAutoTaskApi
    public void syncPinShortcut(Context r2) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r1, "context");
        h.f24490a.a(r1);
    }
}
