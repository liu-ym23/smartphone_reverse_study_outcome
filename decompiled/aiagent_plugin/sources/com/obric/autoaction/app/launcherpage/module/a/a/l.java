package com.obric.autoaction.app.launcherpage.module.a.a;

import android.content.Context;
import com.bytedance.common.wschannel.WsChannelMultiProcessSharedProvider;
import com.bytedance.security.zenmobile.io.SensitiveType;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.obric.agent.omnimodel.IOmniModelService;
import com.obric.aiagent.plugin.R;
import com.obric.autogui.common.AutoOperateTask;
import com.obric.autogui.common.api.agent.IAutoActionAgentEventListener;
import com.obric.autogui.common.api.app.AOHostAppTools;
import com.obric.autogui.common.api.logging.Loog;
import com.obric.eventkit.task.api.IEventTaskApi;
import com.obric.eventkit.task.model.EventTask;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.chrono.ChronoLocalDate;

/* JADX INFO: compiled from: TaskListViewObjectCreator.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class l {
    private static final String TAG = "TaskListViewObjectCreator";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final l f24026a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Gson f24027b = null;

    /* JADX INFO: compiled from: TaskListViewObjectCreator.kt */
    @d.c.b.a.f(b = "TaskListViewObjectCreator.kt", c = {63}, d = "convertTaskToListVO", e = "com.obric.autoaction.app.launcherpage.module.cell.viewobject.TaskListViewObjectCreator")
    static final class a extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f24028a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f24029b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Object f24030c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        /* synthetic */ Object f24031d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ l f24032e;
        int f;

        a(l r3, d.c.d<? super a> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f24032e = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f24031d = r3;
            this.f |= Integer.MIN_VALUE;
            return this.f24032e.a(null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    private l() {
    }

    static {
        f24026a = new l();
        f24027b = new GsonBuilder().create();
    }

    public final boolean a(com.obric.autogui.database.entity.a r6) {
        o.e(r6, "task");
        if (r6.g() > 0) goto L7;
        Loog.INSTANCE.d(TAG, "filter-task: " + r6.a() + " (intervalMillis = " + r6.g() + ") " + r6.d());
        return false;
    L7:
        if (com.obric.autogui.common.b.a.f29000a.a(r6.getType(), 1) == true) goto L9;
    L12:
        return true;
    L9:
        if (r6.j() != 1) goto L12;
        Loog.INSTANCE.d(TAG, "filter-task: " + r6.a() + " (task is pure event setup task) " + r6.d());
        return false;
    }

    public final Object a(com.obric.autogui.database.entity.a r39, d.c.d<? super f> r40) {
        l r0 = this;
        d.c.d r1 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r40, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r1, a.class) == false) goto L7;
        a r3 = (a) ZeusTransformUtils.preCheckCast(r1, a.class, "com.obric.aiagent.plugin");
        if ((r3.f & Integer.MIN_VALUE) == 0) goto L7;
        r3.f -= Integer.MIN_VALUE;
    L8:
        Object r2 = r3.f24031d;
        Object r4 = d.c.a.b.a();
        int r5 = r3.f;
        String r7 = null;
        if (r5 == 0) goto L14;
        if (r5 != 1) goto L13;
        i r6 = (i) ZeusTransformUtils.preCheckCast(r3.f24030c, i.class, "com.obric.aiagent.plugin");
        com.obric.autogui.database.entity.a r8 = (com.obric.autogui.database.entity.a) ZeusTransformUtils.preCheckCast(r3.f24029b, com.obric.autogui.database.entity.a.class, "com.obric.aiagent.plugin");
        l r9 = (l) ZeusTransformUtils.preCheckCast(r3.f24028a, l.class, "com.obric.aiagent.plugin");
        d.o.a(r2);
        i r10 = r6;
        r0 = r9;
    L28:
        EventTask r11 = (EventTask) ZeusTransformUtils.preCheckCast(r2, EventTask.class, "com.obric.aiagent.plugin");
        if (r11 == null) goto L32;
        com.obric.autoaction.app.launcherpage.module.datasource.f r12 = com.obric.autoaction.app.launcherpage.module.datasource.g.a(r11);
    L34:
        com.obric.autoaction.app.launcherpage.module.datasource.f r13 = r12;
    L36:
        long r14 = r8.a();
        String r15 = r8.c();
        int r16 = r8.getType();
        String r17 = r8.i();
        if (r10 != null) goto L40;
        h.a r18 = h.a.f24019a;
    L39:
        h.a r19 = r18;
        String r20 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AOHostAppTools.INSTANCE.getAppContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getString(r0.a(r8.getType()));
        if (r20 != null) goto L56;
        r20 = "";
    L56:
        String r110 = r20;
        String r21 = r8.e();
        long r22 = r8.g();
        if (r10 == null) goto L59;
        r7 = r10.a();
    L59:
        String r23 = r7;
        String r111 = r8.f();
        String r30 = r8.l();
        int r31 = r8.k();
        long r25 = r8.d();
        boolean r27 = r0.a(r13);
        int r28 = r8.q();
        String r24 = r8.s();
        if (r24 != null) goto L62;
        r24 = IOmniModelService.Companion.a().defaultDisplayModel();
    L62:
        String r33 = r8.m();
        String r34 = r8.n();
        return new h(r14, r15, null, r13, r16, r17, r111, r8.o(), r19, r110, r21, r22, r23, null, r25, r27, r28, r24, r30, r31, null, r33, r34, r8.p(), 1048576, null);
    L40:
        int r26 = r10.b();
        if (r26 != 1) goto L43;
        r18 = h.a.f24021c;
        goto L39
    L43:
        if (r26 != 2) goto L45;
        r18 = h.a.f24023e;
        goto L39
    L45:
        if (r26 != 3) goto L47;
        r18 = h.a.f24022d;
        goto L39
    L47:
        if (r26 == 4) goto L49;
        r18 = h.a.f24019a;
        goto L39
    L49:
        r18 = h.a.f24022d;
    L32:
        r12 = null;
        goto L34
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        d.o.a(r2);
        String r29 = r39.h();
        if (r29 != null) goto L17;
        r10 = null;
    L18:
        String r32 = r39.c();
        if (r32 == null) goto L35;
        r12 = com.obric.autoaction.app.launcherpage.module.datasource.h.f24228a.a(r32);
        if (r12 != null) goto L33;
        IEventTaskApi r35 = (IEventTaskApi) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IEventTaskApi.class), IEventTaskApi.class, "com.obric.aiagent.plugin");
        if (r35 == null) goto L31;
        r3.f24028a = r0;
        r3.f24029b = r39;
        r3.f24030c = r10;
        r3.f = 1;
        r2 = r35.getEventTask(r32, r3);
        if (r2 != r4) goto L27;
        return r4;
    L27:
        r8 = r39;
        goto L28
    L31:
        r8 = r39;
        goto L32
    L33:
        r8 = r39;
        goto L34
    L35:
        r13 = null;
        r8 = r39;
        goto L36
    L17:
        r10 = new i(r29, r39.j());
    L7:
        r3 = new a(r0, r1);
        goto L8
    }

    public final f a(com.obric.autoaction.app.launcherpage.module.datasource.j r34) {
        o.e(r34, "record");
        if (r34.a() != 0) goto L12;
        LocalDate r0 = LocalDate.now();
        LocalDate r3 = Instant.ofEpochMilli(r34.d()).atZone(ZoneId.systemDefault()).toLocalDate();
        if (r0.isEqual((ChronoLocalDate) ZeusTransformUtils.preCheckCast(r3, ChronoLocalDate.class, "com.obric.aiagent.plugin")) == false) goto L7;
    L10:
        String r14 = r34.b();
        boolean r17 = r34.h();
        String r18 = r34.e();
        long r19 = r34.d();
        Object r1 = new com.obric.autoaction.app.launcherpage.module.a.a.a(r14, com.obric.autoaction.app.launcherpage.module.datasource.h.f24228a.a(r34.b()), null, r17, r18, r19, null, 64, null);
    L14:
        return (f) ZeusTransformUtils.preCheckCast(r1, f.class, "com.obric.aiagent.plugin");
    L7:
        if (r0.plusDays(1).isEqual((ChronoLocalDate) ZeusTransformUtils.preCheckCast(r3, ChronoLocalDate.class, "com.obric.aiagent.plugin")) == true) goto L10;
        String r4 = r34.b();
        boolean r6 = r34.h();
        String r7 = r34.e();
        long r8 = r34.d();
        r1 = new c(r4, com.obric.autoaction.app.launcherpage.module.datasource.h.f24228a.a(r34.b()), r6, r7, r8, null, 32, null);
        goto L14
    L12:
        String r9 = r34.b();
        Long r10 = r34.c();
        h.a r13 = h.a.f24022d;
        String r15 = r34.f();
        String r16 = r34.e();
        boolean r22 = r34.h();
        String r110 = r34.g();
        long r20 = r34.d();
        return (f) ZeusTransformUtils.preCheckCast(new h(-1, r9, r10, com.obric.autoaction.app.launcherpage.module.datasource.h.f24228a.a(r34.b()), 0, "", "", null, r13, r15, r16, -1, r110, null, r20, r22, 0, null, null, 0, null, null, null, null, 15859840, null), f.class, "com.obric.aiagent.plugin");
    }

    private final int a(int r3) {
        Loog.INSTANCE.d(TAG, "getTaskSource: " + Integer.toHexString(r3));
        if (r3 == 0) goto L5;
        int r4 = com.obric.autogui.common.b.a.f29000a.a(r3);
        int r0 = com.obric.autogui.common.b.a.f29000a.b(r4);
        if (r0 == 0) goto L22;
        if (r0 == 16) goto L30;
        if (r0 == 32) goto L14;
        return ZeusTransformUtils.mapRes(R.string.tli_task_source_unknown, WsChannelMultiProcessSharedProvider.STRING_TYPE, "tli_task_source_unknown");
    L14:
        if (r4 == 33) goto L29;
        if (r4 == 34) goto L28;
        return ZeusTransformUtils.mapRes(R.string.tli_task_source_appintent, WsChannelMultiProcessSharedProvider.STRING_TYPE, "tli_task_source_appintent");
    L28:
        return ZeusTransformUtils.mapRes(R.string.tli_task_source_appintent_oauto, WsChannelMultiProcessSharedProvider.STRING_TYPE, "tli_task_source_appintent_oauto");
    L29:
        return ZeusTransformUtils.mapRes(R.string.tli_task_source_appintent_complex, WsChannelMultiProcessSharedProvider.STRING_TYPE, "tli_task_source_appintent_complex");
    L30:
        return ZeusTransformUtils.mapRes(R.string.tli_task_source_debug, WsChannelMultiProcessSharedProvider.STRING_TYPE, "tli_task_source_debug");
    L22:
        if (r4 != 3) goto L25;
        return ZeusTransformUtils.mapRes(R.string.tli_task_source_oauto_userfollow, WsChannelMultiProcessSharedProvider.STRING_TYPE, "tli_task_source_oauto_userfollow");
    L25:
        return ZeusTransformUtils.mapRes(R.string.tli_task_source_oauto, WsChannelMultiProcessSharedProvider.STRING_TYPE, "tli_task_source_oauto");
    L5:
        return ZeusTransformUtils.mapRes(R.string.tli_task_source_oauto_old, WsChannelMultiProcessSharedProvider.STRING_TYPE, "tli_task_source_oauto_old");
    }

    public final f a(IAutoActionAgentEventListener.SessionInfo r13) {
        o.e(r13, SensitiveType.SESSION);
        AutoOperateTask r0 = r13.getTask();
        String r2 = r0.getTimerTaskId();
        com.obric.autoaction.app.launcherpage.module.datasource.f r3 = com.obric.autoaction.app.launcherpage.module.datasource.h.f24228a.a(r2);
        String r4 = r13.getSessionKey();
        String r1 = r0.getUserTask();
        if (r1 != null) goto L5;
        r1 = "";
    L5:
        boolean r5 = a(r3);
        return (f) ZeusTransformUtils.preCheckCast(new com.obric.autoaction.app.launcherpage.module.a.a.a(r2, r3, r4, r5, r1, r13.getCreatedTime().getTime(), null, 64, null), f.class, "com.obric.aiagent.plugin");
    }

    private final boolean a(com.obric.autoaction.app.launcherpage.module.datasource.f r4) {
        if (ZeusTransformUtils.instanceOf(r4, com.obric.autoaction.app.launcherpage.module.datasource.f.b.class) == false) goto L6;
    L14:
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r4, com.obric.autoaction.app.launcherpage.module.datasource.f.a.class) == true) goto L14;
        if (ZeusTransformUtils.instanceOf(r4, com.obric.autoaction.app.launcherpage.module.datasource.f.c.class) == true) goto L11;
        if (r4 != null) goto L16;
        return false;
    L16:
        throw new d.k();
    L11:
        if (((com.obric.autoaction.app.launcherpage.module.datasource.f.c) ZeusTransformUtils.preCheckCast(r4, com.obric.autoaction.app.launcherpage.module.datasource.f.c.class, "com.obric.aiagent.plugin")).b().isRepeat() == true) goto L14;
        return false;
    }
}
