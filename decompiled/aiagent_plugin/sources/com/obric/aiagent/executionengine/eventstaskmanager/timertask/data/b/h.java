package com.obric.aiagent.executionengine.eventstaskmanager.timertask.data.b;

import com.obric.aiagent.executionengine.eventstaskmanager.timertask.data.bean.TimerTaskBean;
import com.obric.aiagent.platform.depend.ISecureLogDepend;
import com.obric.eventkit.task.model.TimerTask;
import com.obric.eventkit.task.model.TimerTaskAction;
import com.obric.eventkit.task.utils.CronHelper;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.p;
import d.h.b.o;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlinx.coroutines.am;
import kotlinx.coroutines.an;

/* JADX INFO: compiled from: TimerTaskRepo.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class h {
    private static final String TAG = "TimerTaskRepo";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f17948a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final am f17949b;

    /* JADX INFO: compiled from: TimerTaskRepo.kt */
    public static final class a {
        public /* synthetic */ a(d.h.b.h r1) {
            this();
        }

        private a() {
        }
    }

    static {
        f17948a = new a(null);
    }

    public h() {
        this.f17949b = an.a((d.c.g) ZeusTransformUtils.preCheckCast(com.obric.aiagent.executionengine.eventstaskmanager.timertask.c.f17908a.a(), d.c.g.class, "com.obric.aiagent.plugin"));
    }

    private final com.obric.aiagent.executionengine.eventstaskmanager.timertask.data.a.a b() {
        return com.obric.aiagent.executionengine.eventstaskmanager.timertask.data.a.a.f17916a.a();
    }

    public final TimerTask a(int r3, String r4) {
        o.e(r4, "checkPackage");
        TimerTaskBean r2 = b().a(r3);
        if (r2 == null) goto L5;
        String r0 = r2.getSourceFrom();
    L7:
        if (o.a(r0, r4) == true) goto L11;
        com.obric.aiagent.executionengine.eventstaskmanager.b.a.f16675a.d(TAG, "search bean is not equal, checkPackage = " + r4);
        return null;
    L11:
        return r2.toTimerTask();
    L5:
        r0 = null;
        goto L7
    }

    public final List<TimerTask> a(List<Integer> r22, String r23) {
        List r1 = (List) ZeusTransformUtils.wrapperContextForParams(r22, List.class, "com.obric.aiagent.plugin");
        o.e(r1, "taskIdList");
        o.e(r23, "checkPackage");
        List<TimerTask> r3 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.aiagent.plugin");
        Iterator r2 = ((Iterable) ZeusTransformUtils.preCheckCast(r1, Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L4:
        if (r2.hasNext() == false) goto L18;
        int r4 = ((Number) ZeusTransformUtils.preCheckCast(r2.next(), Number.class, "com.obric.aiagent.plugin")).intValue();
        TimerTaskBean r6 = b().a(r4);
        if (r6 == null) goto L8;
        String r5 = r6.getSourceFrom();
    L10:
        if (o.a(r5, r23) == false) goto L4;
        Integer r7 = b().b(r6);
        if (r7 == null) goto L15;
        int r8 = r7.intValue();
    L16:
        if (r8 <= 0) goto L4;
        r3.add(TimerTaskBean.copy$default(r6, null, false, null, null, null, 0, null, 0, 3, null, null, null, 3839, null).toTimerTask());
        goto L4
    L15:
        r8 = 0;
        goto L16
    L8:
        r5 = null;
        goto L10
    L18:
        return r3;
    }

    public final TimerTaskBean a(int r1) {
        return b().a(r1);
    }

    public final Long b(int r3, String r4) {
        o.e(r4, "checkPackage");
        TimerTaskBean r2 = b().a(r3);
        if (r2 == null) goto L5;
        String r0 = r2.getSourceFrom();
    L7:
        if (o.a(r0, r4) == true) goto L11;
        com.obric.aiagent.executionengine.eventstaskmanager.b.a.f16675a.d(TAG, "search bean is not equal, checkPackage = " + r4);
        return null;
    L11:
        return r2.getNextScheduleTime();
    L5:
        r0 = null;
        goto L7
    }

    public final int a(TimerTask r20, String r21, TimerTaskAction r22, long r23, String r25) {
        o.e(r20, "task");
        o.e(r21, "cron");
        o.e(r22, "timerAction");
        o.e(r25, "packageName");
        String r6 = r20.getName();
        String r4 = r20.getCronExpr();
        String r7 = r22.getQuery();
        String r8 = r22.getIntent();
        boolean r5 = CronHelper.INSTANCE.isTimeRecurring(r21);
        Integer r1 = r20.getTaskStatus();
        if (r1 == null) goto L5;
        int r11 = r1.intValue();
    L6:
        Integer r2 = r20.getEnableStatus();
        if (r2 == null) goto L9;
        int r12 = r2.intValue();
    L10:
        Long r3 = r20.getCreateTime();
        if (r3 == null) goto L13;
        long r13 = r3.longValue();
    L14:
        Map<String, String> r9 = r20.getExt();
        if (r9 == null) goto L17;
        String r10 = com.obric.eventkit.task.model.b.a().toJson(r9);
    L18:
        TimerTaskBean r14 = new TimerTaskBean(r4, r5, r6, r7, r8, 0, r25, r11, r12, Long.valueOf(r23), Long.valueOf(r13), r10, 32, null);
        ISecureLogDepend.Companion.i(TAG, "addTimerTask " + r20);
        Long r0 = b().insert(r14);
        if (r0 != null) goto L21;
        return 0;
    L21:
        return (int) r0.longValue();
    L17:
        r10 = null;
        goto L18
    L13:
        r13 = System.currentTimeMillis();
        goto L14
    L9:
        r12 = 0;
        goto L10
    L5:
        r11 = 0;
        goto L6
    }

    public final List<TimerTask> a(androidx.sqlite.db.f r3) {
        androidx.sqlite.db.f r4 = (androidx.sqlite.db.f) ZeusTransformUtils.wrapperContextForParams(r3, androidx.sqlite.db.f.class, "com.obric.aiagent.plugin");
        o.e(r4, "sql");
        List<TimerTaskBean> r5 = b().a(r4);
        if (r5 != null) goto L7;
        return (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.aiagent.plugin");
    L7:
        return a(r5);
    }

    public final List<TimerTask> a() {
        List<TimerTaskBean> r0 = b().a();
        if (r0 != null) goto L7;
        return (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.aiagent.plugin");
    L7:
        return a(r0);
    }

    public final List<TimerTask> a(String r2) {
        o.e(r2, "uid");
        List<TimerTaskBean> r3 = b().b(r2);
        if (r3 != null) goto L7;
        return (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.aiagent.plugin");
    L7:
        return a(r3);
    }

    private final List<TimerTask> a(List<TimerTaskBean> r4) {
        Iterable r3 = (Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.aiagent.plugin"), Iterable.class, "com.obric.aiagent.plugin");
        Collection r5 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(p.a(r3, 10)), Collection.class, "com.obric.aiagent.plugin");
        Iterator r6 = r3.iterator();
    L4:
        if (r6.hasNext() == false) goto L7;
        r5.add(((TimerTaskBean) ZeusTransformUtils.preCheckCast(r6.next(), TimerTaskBean.class, "com.obric.aiagent.plugin")).toTimerTask());
        goto L4
    L7:
        return p.g((Collection) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r5, List.class, "com.obric.aiagent.plugin"), Collection.class, "com.obric.aiagent.plugin"));
    }

    public final List<TimerTask> a(TimerTaskBean r17, long r18) {
        o.e(r17, "timerTaskBean");
        TimerTaskBean r0 = TimerTaskBean.copy$default(r17, null, false, null, null, null, 0, null, 0, 0, CronHelper.INSTANCE.getNextScheduleTime(r17.getCronTime(), Long.valueOf(r18)), null, null, 3199, null);
        Integer r1 = b().a(r0);
        if (r1 == null) goto L5;
        int r2 = r1.intValue();
    L6:
        if (r2 <= 0) goto L10;
        return p.a(r0.toTimerTask());
    L10:
        return p.b();
    L5:
        r2 = 0;
        goto L6
    }

    public final int a(TimerTaskBean r2) {
        o.e(r2, "task");
        Integer r1 = b().a(r2);
        if (r1 != null) goto L7;
        return 0;
    L7:
        return r1.intValue();
    }

    public final List<TimerTask> b(String r4) {
        o.e(r4, "packageName");
        List<TimerTaskBean> r3 = b().a(r4);
        if (r3 == null) goto L11;
        Iterable r5 = (Iterable) ZeusTransformUtils.preCheckCast(r3, Iterable.class, "com.obric.aiagent.plugin");
        Collection r0 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(p.a(r5, 10)), Collection.class, "com.obric.aiagent.plugin");
        Iterator r6 = r5.iterator();
    L6:
        if (r6.hasNext() == false) goto L8;
        r0.add(((TimerTaskBean) ZeusTransformUtils.preCheckCast(r6.next(), TimerTaskBean.class, "com.obric.aiagent.plugin")).toTimerTask());
        goto L6
    L8:
        List<TimerTask> r7 = p.g((Collection) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r0, List.class, "com.obric.aiagent.plugin"), Collection.class, "com.obric.aiagent.plugin"));
        if (r7 == null) goto L11;
        return r7;
    L11:
        return (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.aiagent.plugin");
    }

    public final List<TimerTask> a(String r2, int r3, int r4) {
        o.e(r2, "packageName");
        List<TimerTaskBean> r1 = b().a(r2, r3, r4);
        if (r1 == null) goto L11;
        Iterable r5 = (Iterable) ZeusTransformUtils.preCheckCast(r1, Iterable.class, "com.obric.aiagent.plugin");
        Collection r6 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(p.a(r5, 10)), Collection.class, "com.obric.aiagent.plugin");
        Iterator r7 = r5.iterator();
    L6:
        if (r7.hasNext() == false) goto L8;
        r6.add(((TimerTaskBean) ZeusTransformUtils.preCheckCast(r7.next(), TimerTaskBean.class, "com.obric.aiagent.plugin")).toTimerTask());
        goto L6
    L8:
        List<TimerTask> r8 = p.g((Collection) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r6, List.class, "com.obric.aiagent.plugin"), Collection.class, "com.obric.aiagent.plugin"));
        if (r8 == null) goto L11;
        return r8;
    L11:
        return (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.aiagent.plugin");
    }
}
