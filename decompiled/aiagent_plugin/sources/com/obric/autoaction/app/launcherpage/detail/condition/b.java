package com.obric.autoaction.app.launcherpage.detail.condition;

import com.obric.autogui.common.api.configs.AutoActionConfigs;
import com.obric.eventkit.ITaskManagerApi;
import com.obric.eventkit.task.api.IEventTaskApi;
import com.obric.eventkit.task.model.EventTask;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.p;
import d.c.b.a.f;
import d.c.b.a.l;
import d.c.d;
import d.c.g;
import d.h.a.m;
import d.o;
import d.x;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlinx.coroutines.am;
import kotlinx.coroutines.bd;
import kotlinx.coroutines.i;

/* JADX INFO: compiled from: TaskCountUtils.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class b {

    /* JADX INFO: compiled from: TaskCountUtils.kt */
    @f(b = "TaskCountUtils.kt", c = {42, 44}, d = "invokeSuspend", e = "com.obric.autoaction.app.launcherpage.detail.condition.TaskCountUtilsKt$getAvailableTask$2")
    static final class a extends l implements m<am, d<? super Integer>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f23401a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f23402b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        int f23403c;

        a(d<? super a> r3) {
            super(2, (d) ZeusTransformUtils.wrapperContextForParams(r3, d.class, "com.obric.aiagent.plugin"));
        }

        public final Object a(am r3, d<? super Integer> r4) {
            return ((a) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d) ZeusTransformUtils.wrapperContextForParams(r4, d.class, "com.obric.aiagent.plugin")), a.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d<x> create(Object r1, d<?> r2) {
            return (d) ZeusTransformUtils.preCheckCast(new a((d) ZeusTransformUtils.wrapperContextForParams(r2, d.class, "com.obric.aiagent.plugin")), d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d<? super Integer> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d) ZeusTransformUtils.preCheckCast(r4, d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r11) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f23403c;
            int r5 = 0;
            if (r1 == 0) goto L10;
            if (r1 == 1) goto L9;
            if (r1 != 2) goto L8;
            int r10 = this.f23402b;
            o.a(r11);
        L42:
            List r12 = (List) ZeusTransformUtils.preCheckCast(r11, List.class, "com.obric.aiagent.plugin");
            if (r12 == null) goto L64;
            Iterable r13 = (Iterable) ZeusTransformUtils.preCheckCast(r12, Iterable.class, "com.obric.aiagent.plugin");
            if (ZeusTransformUtils.instanceOf(r13, Collection.class) == true) goto L47;
        L49:
            Iterator r14 = r13.iterator();
            int r2 = 0;
        L51:
            if (r14.hasNext() == false) goto L63;
            Integer r3 = ((EventTask) ZeusTransformUtils.preCheckCast(r14.next(), EventTask.class, "com.obric.aiagent.plugin")).getEnableStatus();
            if (r3 != null) goto L56;
        L58:
            boolean r4 = false;
        L59:
            if (r4 == false) goto L51;
            r2 = r2 + 1;
            if (r2 >= 0) goto L51;
            p.d();
            goto L51
        L56:
            if (r3.intValue() != 0) goto L58;
            r4 = true;
            goto L59
        L63:
            r5 = r2;
        L67:
            return d.c.b.a.b.a(r10 + r5);
        L47:
            if (((Collection) ZeusTransformUtils.preCheckCast(r13, Collection.class, "com.obric.aiagent.plugin")).isEmpty() == false) goto L49;
        L64:
            int r7 = r10;
        L65:
            r10 = r7;
            goto L67
        L8:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L9:
            IEventTaskApi r6 = (IEventTaskApi) ZeusTransformUtils.preCheckCast(this.f23401a, IEventTaskApi.class, "com.obric.aiagent.plugin");
            o.a(r11);
        L15:
            List r15 = (List) ZeusTransformUtils.preCheckCast(r11, List.class, "com.obric.aiagent.plugin");
            if (r15 == null) goto L36;
            Iterable r16 = (Iterable) ZeusTransformUtils.preCheckCast(r15, Iterable.class, "com.obric.aiagent.plugin");
            if (ZeusTransformUtils.instanceOf(r16, Collection.class) == true) goto L20;
        L22:
            Iterator r17 = r16.iterator();
            r7 = 0;
        L24:
            if (r17.hasNext() == false) goto L37;
            Integer r8 = ((EventTask) ZeusTransformUtils.preCheckCast(r17.next(), EventTask.class, "com.obric.aiagent.plugin")).getEnableStatus();
            if (r8 != null) goto L29;
        L31:
            boolean r9 = false;
        L32:
            if (r9 == false) goto L24;
            r7 = r7 + 1;
            if (r7 >= 0) goto L24;
            p.d();
            goto L24
        L29:
            if (r8.intValue() != 0) goto L31;
            r9 = true;
        L37:
            if (r6 == null) goto L65;
            d<? super List<? extends EventTask>> r18 = (d) ZeusTransformUtils.preCheckCast(this, d.class, "com.obric.aiagent.plugin");
            this.f23401a = null;
            this.f23402b = r7;
            this.f23403c = 2;
            r11 = r6.getEventTasksByType(2, 0, Integer.MAX_VALUE, r18);
            if (r11 != r0) goto L41;
            return r0;
        L41:
            r10 = r7;
            goto L42
        L20:
            if (((Collection) ZeusTransformUtils.preCheckCast(r16, Collection.class, "com.obric.aiagent.plugin")).isEmpty() == false) goto L22;
        L36:
            r7 = 0;
            goto L37
        L10:
            o.a(r11);
            r6 = (IEventTaskApi) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IEventTaskApi.class), IEventTaskApi.class, "com.obric.aiagent.plugin");
            if (r6 == null) goto L36;
            d<? super List<? extends EventTask>> r19 = (d) ZeusTransformUtils.preCheckCast(this, d.class, "com.obric.aiagent.plugin");
            this.f23401a = r6;
            this.f23403c = 1;
            r11 = r6.getEventTasksByType(1, 0, Integer.MAX_VALUE, r19);
            if (r11 != r0) goto L15;
            return r0;
        }
    }

    public static final int a() {
        ITaskManagerApi r0 = (ITaskManagerApi) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(ITaskManagerApi.class), ITaskManagerApi.class, "com.obric.aiagent.plugin");
        if (r0 == null) goto L5;
        String r1 = r0.getConditionTaskV2();
    L7:
        if (d.h.b.o.a(r1, "true") == false) goto L9;
        int r2 = 10;
    L11:
        return AutoActionConfigs.INSTANCE.getIntCfg("vlm.task.max_number", r2);
    L9:
        r2 = 5;
        goto L11
    L5:
        r1 = null;
        goto L7
    }

    public static final Object a(d<? super Integer> r4) {
        d r5 = (d) ZeusTransformUtils.wrapperContextForParams(r4, d.class, "com.obric.aiagent.plugin");
        return i.a((g) ZeusTransformUtils.preCheckCast(bd.c(), g.class, "com.obric.aiagent.plugin"), (m) ZeusTransformUtils.preCheckCast(new a(null), m.class, "com.obric.aiagent.plugin"), r5);
    }
}
