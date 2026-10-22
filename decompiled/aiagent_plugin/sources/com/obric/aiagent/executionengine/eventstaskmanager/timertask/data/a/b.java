package com.obric.aiagent.executionengine.eventstaskmanager.timertask.data.a;

import com.obric.aiagent.executionengine.eventstaskmanager.common.data.e;
import com.obric.aiagent.executionengine.eventstaskmanager.timertask.data.b.d;
import com.obric.aiagent.executionengine.eventstaskmanager.timertask.data.bean.TimerTaskRecordBean;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.f;
import d.g;
import d.h.b.h;
import d.h.b.o;
import d.j;
import java.util.List;

/* JADX INFO: compiled from: ITimerTaskRecordDao.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class b {
    private static final String TAG = "ITimerTaskRecordDao";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f17918a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final f<b> f17919b = null;

    /* JADX INFO: compiled from: ITimerTaskRecordDao.kt */
    public static final class a {
        public /* synthetic */ a(h r1) {
            this();
        }

        private a() {
        }

        private final b b() {
            return (b) ZeusTransformUtils.preCheckCast(b.a().b(), b.class, "com.obric.aiagent.plugin");
        }

        public final b a() {
            return b();
        }
    }

    /* JADX INFO: renamed from: lambda$cjqeFFN6n-alJjhxggniCk2hNVg, reason: not valid java name */
    public static /* synthetic */ b m178lambda$cjqeFFN6nalJjhxggniCk2hNVg() {
        return c();
    }

    private b() {
    }

    public static final /* synthetic */ f a() {
        return f17919b;
    }

    static {
        f17918a = new a(null);
        f17919b = g.a(j.f38505a, $$Lambda$b$cjqeFFN6nalJjhxggniCk2hNVg.INSTANCE);
    }

    private static final b c() {
        return new b();
    }

    private final d b() {
        return e.f16691a.c();
    }

    public final Long insert(TimerTaskRecordBean r2) {
        o.e(r2, "record");
        d r1 = b();
        if (r1 != null) goto L7;
        return null;
    L7:
        return Long.valueOf(r1.insert(r2));
    }

    public final List<TimerTaskRecordBean> a(long r8, long r10, String r12) {
        o.e(r12, "packageName");
        d r1 = b();
        if (r1 != null) goto L7;
        return null;
    L7:
        return r1.a(r8, r10, r12);
    }

    public final List<TimerTaskRecordBean> a(int r9, long r10, long r12, String r14) {
        o.e(r14, "packageName");
        d r1 = b();
        if (r1 != null) goto L7;
        return null;
    L7:
        return r1.a(r9, r10, r12, r14);
    }

    public final Integer a(String r2) {
        o.e(r2, "packageName");
        d r1 = b();
        if (r1 != null) goto L7;
        return null;
    L7:
        return Integer.valueOf(r1.a(r2));
    }

    public final Integer a(List<Integer> r3, String r4) {
        List<Integer> r5 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
        o.e(r5, "ids");
        o.e(r4, "packageName");
        d r2 = b();
        if (r2 != null) goto L7;
        return null;
    L7:
        return Integer.valueOf(r2.a(r5, r4));
    }

    public final Integer a(int r1) {
        d r0 = b();
        if (r0 != null) goto L7;
        return null;
    L7:
        return Integer.valueOf(r0.a(r1));
    }
}
