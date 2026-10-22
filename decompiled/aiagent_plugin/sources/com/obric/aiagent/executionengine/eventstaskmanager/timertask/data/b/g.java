package com.obric.aiagent.executionengine.eventstaskmanager.timertask.data.b;

import com.obric.aiagent.executionengine.eventstaskmanager.timertask.data.bean.TimerTaskBean;
import com.obric.aiagent.executionengine.eventstaskmanager.timertask.data.bean.TimerTaskRecordBean;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import java.util.ArrayList;
import java.util.List;
import kotlinx.coroutines.am;
import kotlinx.coroutines.an;

/* JADX INFO: compiled from: TimerTaskRecordRepo.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class g {
    private static final String TAG = "TimerTaskRecordRepo";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f17946a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final am f17947b;

    /* JADX INFO: compiled from: TimerTaskRecordRepo.kt */
    public static final class a {
        public /* synthetic */ a(d.h.b.h r1) {
            this();
        }

        private a() {
        }
    }

    static {
        f17946a = new a(null);
    }

    public g() {
        this.f17947b = an.a((d.c.g) ZeusTransformUtils.preCheckCast(com.obric.aiagent.executionengine.eventstaskmanager.timertask.c.f17908a.a(), d.c.g.class, "com.obric.aiagent.plugin"));
    }

    private final com.obric.aiagent.executionengine.eventstaskmanager.timertask.data.a.b a() {
        return com.obric.aiagent.executionengine.eventstaskmanager.timertask.data.a.b.f17918a.a();
    }

    public final void a(TimerTaskBean r2, long r3, int r5) {
        o.e(r2, "timerTaskBean");
        TimerTaskRecordBean r4 = b(r2, r3, r5);
        a().insert(r4);
    }

    public final List<TimerTaskRecordBean> a(long r8, long r10, String r12) {
        o.e(r12, "packageName");
        List<TimerTaskRecordBean> r7 = a().a(r8, r10, r12);
        if (r7 == null) goto L5;
        return r7;
    L5:
        return (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.aiagent.plugin");
    }

    public final List<TimerTaskRecordBean> a(int r9, long r10, long r12, String r14) {
        o.e(r14, "packageName");
        List<TimerTaskRecordBean> r8 = a().a(r9, r10, r12, r14);
        if (r8 == null) goto L5;
        return r8;
    L5:
        return (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.aiagent.plugin");
    }

    public final int a(String r2) {
        o.e(r2, "packageName");
        Integer r1 = a().a(r2);
        if (r1 != null) goto L7;
        return 0;
    L7:
        return r1.intValue();
    }

    public final int a(List<Integer> r3, String r4) {
        List<Integer> r5 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
        o.e(r5, "ids");
        o.e(r4, "packageName");
        Integer r2 = a().a(r5, r4);
        if (r2 != null) goto L7;
        return 0;
    L7:
        return r2.intValue();
    }

    public final int a(int r1) {
        Integer r0 = a().a(r1);
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.intValue();
    }

    private final TimerTaskRecordBean b(TimerTaskBean r12, long r13, int r15) {
        String r11 = r12.getAction();
        boolean r0 = true;
        if (r11 != null) goto L5;
    L10:
        r0 = false;
    L11:
        if (r0 == false) goto L13;
        String r14 = r12.getSourceFrom();
    L14:
        String r6 = r14;
        int r1 = r12.getTaskId();
        Long r2 = r12.getNextScheduleTime();
        if (r2 == null) goto L17;
        long r3 = r2.longValue();
    L19:
        return new TimerTaskRecordBean(r1, r3, Long.valueOf(r13), r12.getSourceFrom(), r6, 0, r15, 32, null);
    L17:
        r3 = 0;
        goto L19
    L13:
        r14 = "";
        goto L14
    L5:
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r11, CharSequence.class, "com.obric.aiagent.plugin")).length() <= 0) goto L7;
        boolean r16 = true;
    L8:
        if (r16 != true) goto L10;
    L7:
        r16 = false;
        goto L8
    }
}
