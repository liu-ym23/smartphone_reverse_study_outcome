package com.obric.event.task.base.report;

import com.bytedance.apm.battery.dao.DBHelper;
import com.bytedance.keva.Keva;
import com.obric.autoaction.app.launcherpage.knowledge.KnowledgeActivity;
import com.obric.autogui.common.api.AOBizTracking;
import com.obric.autogui.common.api.platform.tracking.IAutoActionTrackingApi;
import com.obric.eventkit.task.api.IEventTaskApi;
import com.obric.eventkit.task.model.EventTask;
import com.obric.eventkit.task.model.ShortcutTask;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.z;
import d.x;
import java.time.LocalDate;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlinx.coroutines.am;
import kotlinx.coroutines.an;
import kotlinx.coroutines.bd;
import kotlinx.coroutines.ca;
import kotlinx.coroutines.cx;
import org.json.JSONObject;

/* JADX INFO: compiled from: MainMobHelper.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final l f32861a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Keva f32862b = null;

    /* JADX INFO: compiled from: MainMobHelper.kt */
    @d.c.b.a.f(b = "MainMobHelper.kt", c = {93, 103}, d = "invokeSuspend", e = "com.obric.event.task.base.report.MainMobHelper$taskCountMobFromAppForeground$1")
    static final class a extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f32863a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f32864b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Object f32865c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        Object f32866d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        Object f32867e;
        Object f;
        Object g;
        int h;

        a(d.c.d<? super a> r3) {
            super(2, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        public final Object a(am r3, d.c.d<? super x> r4) {
            return ((a) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), a.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r1, d.c.d<?> r2) {
            return (d.c.d) ZeusTransformUtils.preCheckCast(new a((d.c.d) ZeusTransformUtils.wrapperContextForParams(r2, d.c.d.class, "com.obric.aiagent.plugin")), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:17:0x0127 -> B:19:0x012a). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:20:0x0133 -> B:21:0x0134). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:44:0x01bc -> B:46:0x01bf). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:47:0x01c8 -> B:48:0x01ca). Please report as a decompilation issue!!! */
        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r21) {
            Object r1 = d.c.a.b.a();
            int r2 = this.h;
            int r6 = 1;
            if (r2 == 0) goto L10;
            if (r2 == 1) goto L9;
            if (r2 != 2) goto L8;
            int r3 = this.f32863a;
            IEventTaskApi r8 = (IEventTaskApi) ZeusTransformUtils.preCheckCast(this.g, IEventTaskApi.class, "com.obric.aiagent.plugin");
            z.d r9 = (z.d) ZeusTransformUtils.preCheckCast(this.f, z.d.class, "com.obric.aiagent.plugin");
            z.d r10 = (z.d) ZeusTransformUtils.preCheckCast(this.f32867e, z.d.class, "com.obric.aiagent.plugin");
            z.d r11 = (z.d) ZeusTransformUtils.preCheckCast(this.f32866d, z.d.class, "com.obric.aiagent.plugin");
            z.d r12 = (z.d) ZeusTransformUtils.preCheckCast(this.f32865c, z.d.class, "com.obric.aiagent.plugin");
            z.d r13 = (z.d) ZeusTransformUtils.preCheckCast(this.f32864b, z.d.class, "com.obric.aiagent.plugin");
            d.o.a(r21);
            Object r4 = r21;
        L46:
            List r5 = (List) ZeusTransformUtils.preCheckCast(r4, List.class, "com.obric.aiagent.plugin");
        L48:
            if (r5 != null) goto L50;
            r5 = d.a.p.b();
        L50:
            r12.f38502a += r5.size();
            int r7 = r10.f38502a;
            Iterable r14 = (Iterable) ZeusTransformUtils.preCheckCast(r5, Iterable.class, "com.obric.aiagent.plugin");
            if (ZeusTransformUtils.instanceOf(r14, Collection.class) == true) goto L53;
        L56:
            Iterator r15 = r14.iterator();
            int r16 = 0;
        L58:
            if (r15.hasNext() == false) goto L68;
            if (((EventTask) ZeusTransformUtils.preCheckCast(r15.next(), EventTask.class, "com.obric.aiagent.plugin")).getTaskMode() != 1) goto L62;
            boolean r17 = true;
        L63:
            if (r17 == false) goto L58;
            r16 = r16 + 1;
            if (r16 >= 0) goto L58;
            d.a.p.d();
            goto L58
        L62:
            r17 = false;
        L68:
            r10.f38502a = r7 + r16;
            int r18 = r9.f38502a;
            Iterable r19 = (Iterable) ZeusTransformUtils.preCheckCast(r5, Iterable.class, "com.obric.aiagent.plugin");
            if (ZeusTransformUtils.instanceOf(r19, Collection.class) == true) goto L71;
        L73:
            Iterator r20 = r19.iterator();
            int r22 = 0;
        L75:
            if (r20.hasNext() == false) goto L88;
            Integer r110 = ((EventTask) ZeusTransformUtils.preCheckCast(r20.next(), EventTask.class, "com.obric.aiagent.plugin")).getEnableStatus();
            if (r110 != null) goto L80;
        L82:
            boolean r111 = false;
        L83:
            if (r111 == false) goto L75;
            r22 = r22 + 1;
            if (r22 >= 0) goto L75;
            d.a.p.d();
            goto L75
        L80:
            if (r110.intValue() != 0) goto L82;
            r111 = true;
        L88:
            r9.f38502a = r18 + r22;
            if (r5.size() < r3) goto L90;
        L42:
            if (r8 == null) goto L47;
            int r23 = r12.f38502a;
            d.c.d<? super List<? extends EventTask>> r24 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f32864b = r13;
            this.f32865c = r12;
            this.f32866d = r11;
            this.f32867e = r10;
            this.f = r9;
            this.g = r8;
            this.f32863a = r3;
            this.h = 2;
            r4 = r8.getEventTasksByType(2, r23, r3, r24);
            if (r4 != r1) goto L46;
            return r1;
        L47:
            r5 = null;
            goto L48
        L90:
            IAutoActionTrackingApi r25 = (IAutoActionTrackingApi) ZeusTransformUtils.preCheckCast(AOBizTracking.INSTANCE, IAutoActionTrackingApi.class, "com.obric.aiagent.plugin");
            JSONObject r26 = new JSONObject();
            r26.put("shortcut_task_count", r13.f38502a);
            r26.put("shortcut_pro_task_count", r11.f38502a);
            r26.put("condition_task_count", r12.f38502a);
            r26.put("condition_task_enable_count", r9.f38502a);
            r26.put("condition_pro_task_count", r10.f38502a);
            r26.put(DBHelper.BATTERY_COL_SOURCE, "app_foreground");
            x r0 = x.f38692a;
            IAutoActionTrackingApi.DefaultImpls.reportEvent$default(r25, "oauto_task_count", r26, false, false, null, 28, null);
            return x.f38692a;
        L71:
            if (((Collection) ZeusTransformUtils.preCheckCast(r19, Collection.class, "com.obric.aiagent.plugin")).isEmpty() == false) goto L73;
            r22 = 0;
            goto L88
        L53:
            if (((Collection) ZeusTransformUtils.preCheckCast(r14, Collection.class, "com.obric.aiagent.plugin")).isEmpty() == false) goto L56;
            r16 = 0;
            goto L68
        L8:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L9:
            r3 = this.f32863a;
            r8 = (IEventTaskApi) ZeusTransformUtils.preCheckCast(this.g, IEventTaskApi.class, "com.obric.aiagent.plugin");
            r9 = (z.d) ZeusTransformUtils.preCheckCast(this.f, z.d.class, "com.obric.aiagent.plugin");
            r10 = (z.d) ZeusTransformUtils.preCheckCast(this.f32867e, z.d.class, "com.obric.aiagent.plugin");
            r11 = (z.d) ZeusTransformUtils.preCheckCast(this.f32866d, z.d.class, "com.obric.aiagent.plugin");
            r12 = (z.d) ZeusTransformUtils.preCheckCast(this.f32865c, z.d.class, "com.obric.aiagent.plugin");
            r13 = (z.d) ZeusTransformUtils.preCheckCast(this.f32864b, z.d.class, "com.obric.aiagent.plugin");
            d.o.a(r21);
            Object r27 = r21;
        L19:
            List r28 = (List) ZeusTransformUtils.preCheckCast(r27, List.class, "com.obric.aiagent.plugin");
        L21:
            if (r28 != null) goto L23;
            r28 = d.a.p.b();
        L23:
            r13.f38502a += r28.size();
            int r112 = r11.f38502a;
            Iterable r113 = (Iterable) ZeusTransformUtils.preCheckCast(r28, Iterable.class, "com.obric.aiagent.plugin");
            if (ZeusTransformUtils.instanceOf(r113, Collection.class) == true) goto L26;
        L28:
            Iterator r29 = r113.iterator();
            int r114 = 0;
        L30:
            if (r29.hasNext() == false) goto L40;
            if (((EventTask) ZeusTransformUtils.preCheckCast(r29.next(), EventTask.class, "com.obric.aiagent.plugin")).getTaskMode() != 1) goto L34;
            boolean r30 = true;
        L35:
            if (r30 == false) goto L30;
            r114 = r114 + 1;
            if (r114 >= 0) goto L30;
            d.a.p.d();
            goto L30
        L34:
            r30 = false;
        L40:
            r11.f38502a = r112 + r114;
            if (r28.size() < r3) goto L42;
            r6 = 1;
        L15:
            if (r8 == null) goto L20;
            int r115 = r13.f38502a;
            d.c.d<? super List<? extends EventTask>> r31 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f32864b = r13;
            this.f32865c = r12;
            this.f32866d = r11;
            this.f32867e = r10;
            this.f = r9;
            this.g = r8;
            this.f32863a = r3;
            this.h = r6;
            r27 = r8.getEventTasksByType(3, r115, r3, r31);
            if (r27 != r1) goto L19;
            return r1;
        L20:
            r28 = null;
            goto L21
        L26:
            if (((Collection) ZeusTransformUtils.preCheckCast(r113, Collection.class, "com.obric.aiagent.plugin")).isEmpty() == false) goto L28;
            r114 = 0;
            goto L40
        L10:
            d.o.a(r21);
            long r32 = LocalDate.now().toEpochDay();
            if (l.b().getLong("task_count_report_time", 0) == r32) goto L13;
            l.b().storeLong("task_count_report_time", r32);
            r3 = 100;
            z.d r33 = new z.d();
            z.d r34 = new z.d();
            z.d r116 = new z.d();
            z.d r117 = new z.d();
            z.d r118 = new z.d();
            r13 = r33;
            r8 = (IEventTaskApi) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IEventTaskApi.class), IEventTaskApi.class, "com.obric.aiagent.plugin");
            r12 = r34;
            r9 = r118;
            r11 = r116;
            r10 = r117;
            goto L15
        L13:
            return x.f38692a;
        }
    }

    private l() {
    }

    public static final /* synthetic */ Keva b() {
        return f32862b;
    }

    static {
        f32861a = new l();
        f32862b = Keva.getRepo("obric_mob_launcher");
    }

    public final void a(long r9) {
        IAutoActionTrackingApi r0 = (IAutoActionTrackingApi) ZeusTransformUtils.preCheckCast(AOBizTracking.INSTANCE, IAutoActionTrackingApi.class, "com.obric.aiagent.plugin");
        JSONObject r2 = new JSONObject();
        r2.put("duration", r9);
        x r8 = x.f38692a;
        IAutoActionTrackingApi.DefaultImpls.reportEvent$default(r0, "oauto_shortcut_list_render_duration", r2, false, false, null, 28, null);
    }

    public final void b(long r9) {
        IAutoActionTrackingApi r0 = (IAutoActionTrackingApi) ZeusTransformUtils.preCheckCast(AOBizTracking.INSTANCE, IAutoActionTrackingApi.class, "com.obric.aiagent.plugin");
        JSONObject r2 = new JSONObject();
        r2.put("duration", r9);
        x r8 = x.f38692a;
        IAutoActionTrackingApi.DefaultImpls.reportEvent$default(r0, "oauto_repeated_task_list_render_duration", r2, false, false, null, 28, null);
    }

    public final void a(String r9) {
        d.h.b.o.e(r9, "enterFrom");
        IAutoActionTrackingApi r0 = (IAutoActionTrackingApi) ZeusTransformUtils.preCheckCast(AOBizTracking.INSTANCE, IAutoActionTrackingApi.class, "com.obric.aiagent.plugin");
        JSONObject r2 = new JSONObject();
        r2.put("enter_from", r9);
        x r8 = x.f38692a;
        IAutoActionTrackingApi.DefaultImpls.reportEvent$default(r0, "oauto_main_page_tab_switch", r2, false, false, null, 28, null);
    }

    public final ca a() {
        return kotlinx.coroutines.i.a(an.a(bd.c().plus((d.c.g) ZeusTransformUtils.preCheckCast(cx.a(null, 1, null), d.c.g.class, "com.obric.aiagent.plugin"))), null, null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new a(null), d.h.a.m.class, "com.obric.aiagent.plugin"), 3, null);
    }

    public static /* synthetic */ void a(l r1, List r2, List r3, String r4, int r5, Object r6) {
        List<ShortcutTask> r7 = (List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.aiagent.plugin");
        List<? extends EventTask> r8 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
        if ((r5 & 1) == 0) goto L6;
        r7 = null;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r8 = null;
    L9:
        if ((r5 & 4) == 0) goto L11;
        r4 = "page";
    L11:
        r1.a(r7, r8, r4);
    }

    public final void a(List<ShortcutTask> r11, List<? extends EventTask> r12, String r13) {
        List r10 = (List) ZeusTransformUtils.wrapperContextForParams(r11, List.class, "com.obric.aiagent.plugin");
        List r14 = (List) ZeusTransformUtils.wrapperContextForParams(r12, List.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r13, DBHelper.BATTERY_COL_SOURCE);
        IAutoActionTrackingApi r2 = (IAutoActionTrackingApi) ZeusTransformUtils.preCheckCast(AOBizTracking.INSTANCE, IAutoActionTrackingApi.class, "com.obric.aiagent.plugin");
        JSONObject r4 = new JSONObject();
        int r3 = 0;
        if (r10 == null) goto L21;
        r4.put("shortcut_task_count", r10.size());
        Iterable r15 = (Iterable) ZeusTransformUtils.preCheckCast(r10, Iterable.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r15, Collection.class) == true) goto L7;
    L9:
        Iterator r16 = r15.iterator();
        int r5 = 0;
    L11:
        if (r16.hasNext() == false) goto L20;
        if (((ShortcutTask) ZeusTransformUtils.preCheckCast(r16.next(), ShortcutTask.class, "com.obric.aiagent.plugin")).getTaskMode() != 1) goto L15;
        boolean r6 = true;
    L16:
        if (r6 == false) goto L11;
        r5 = r5 + 1;
        if (r5 >= 0) goto L11;
        d.a.p.d();
        goto L11
    L15:
        r6 = false;
    L20:
        r4.put("shortcut_pro_task_count", r5);
        goto L21
    L7:
        if (((Collection) ZeusTransformUtils.preCheckCast(r15, Collection.class, "com.obric.aiagent.plugin")).isEmpty() == false) goto L9;
        r5 = 0;
    L21:
        if (r14 == null) goto L59;
        r4.put("condition_task_count", r14.size());
        Iterable r17 = (Iterable) ZeusTransformUtils.preCheckCast(r14, Iterable.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r17, Collection.class) == true) goto L25;
    L27:
        Iterator r18 = r17.iterator();
        int r7 = 0;
    L29:
        if (r18.hasNext() == false) goto L41;
        Integer r8 = ((EventTask) ZeusTransformUtils.preCheckCast(r18.next(), EventTask.class, "com.obric.aiagent.plugin")).getEnableStatus();
        if (r8 != null) goto L34;
    L36:
        boolean r9 = false;
    L37:
        if (r9 == false) goto L29;
        r7 = r7 + 1;
        if (r7 >= 0) goto L29;
        d.a.p.d();
        goto L29
    L34:
        if (r8.intValue() != 0) goto L36;
        r9 = true;
    L41:
        r4.put("condition_task_enable_count", r7);
        Iterable r19 = (Iterable) ZeusTransformUtils.preCheckCast(r14, Iterable.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r19, Collection.class) == true) goto L44;
    L46:
        Iterator r110 = r19.iterator();
        int r111 = 0;
    L48:
        if (r110.hasNext() == false) goto L57;
        if (((EventTask) ZeusTransformUtils.preCheckCast(r110.next(), EventTask.class, "com.obric.aiagent.plugin")).getTaskMode() != 1) goto L52;
        boolean r20 = true;
    L53:
        if (r20 == false) goto L48;
        r111 = r111 + 1;
        if (r111 >= 0) goto L48;
        d.a.p.d();
        goto L48
    L52:
        r20 = false;
        goto L53
    L57:
        r3 = r111;
    L58:
        r4.put("condition_pro_task_count", r3);
        goto L59
    L44:
        if (((Collection) ZeusTransformUtils.preCheckCast(r19, Collection.class, "com.obric.aiagent.plugin")).isEmpty() == false) goto L46;
    L25:
        if (((Collection) ZeusTransformUtils.preCheckCast(r17, Collection.class, "com.obric.aiagent.plugin")).isEmpty() == false) goto L27;
        r7 = 0;
    L59:
        r4.put(DBHelper.BATTERY_COL_SOURCE, r13);
        x r112 = x.f38692a;
        IAutoActionTrackingApi.DefaultImpls.reportEvent$default(r2, "oauto_task_count", r4, false, false, null, 28, null);
    }

    public final void a(boolean r11, Integer r12) {
        IAutoActionTrackingApi r2 = (IAutoActionTrackingApi) ZeusTransformUtils.preCheckCast(AOBizTracking.INSTANCE, IAutoActionTrackingApi.class, "com.obric.aiagent.plugin");
        JSONObject r4 = new JSONObject();
        r4.put("enable", r11);
        if (r12 == null) goto L5;
        r4.put("task_mode", ((Number) ZeusTransformUtils.preCheckCast(r12, Number.class, "com.obric.aiagent.plugin")).intValue());
    L5:
        x r10 = x.f38692a;
        IAutoActionTrackingApi.DefaultImpls.reportEvent$default(r2, "oauto_condition_task_switch", r4, false, false, null, 28, null);
    }

    public final void a(String r11, Integer r12) {
        IAutoActionTrackingApi r2 = (IAutoActionTrackingApi) ZeusTransformUtils.preCheckCast(AOBizTracking.INSTANCE, IAutoActionTrackingApi.class, "com.obric.aiagent.plugin");
        JSONObject r4 = new JSONObject();
        if (r11 == null) goto L5;
        r4.put(KnowledgeActivity.KEY_TASK_TYPE, r11);
    L5:
        if (r12 == null) goto L7;
        r4.put("task_mode", ((Number) ZeusTransformUtils.preCheckCast(r12, Number.class, "com.obric.aiagent.plugin")).intValue());
    L7:
        x r10 = x.f38692a;
        IAutoActionTrackingApi.DefaultImpls.reportEvent$default(r2, "oauto_delete_task", r4, false, false, null, 28, null);
    }
}
