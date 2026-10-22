package com.obric.aiagent.executionengine.eventstaskmanager.timertask.data.a;

import com.obric.aiagent.executionengine.eventstaskmanager.common.data.e;
import com.obric.aiagent.executionengine.eventstaskmanager.timertask.data.bean.TimerTaskBean;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.f;
import d.g;
import d.h.b.h;
import d.h.b.o;
import d.j;
import java.util.List;

/* JADX INFO: compiled from: ITimerTaskDao.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class a {
    private static final String TAG = "ITimerTaskDao";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C0368a f17916a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final f<a> f17917b = null;

    /* JADX INFO: renamed from: com.obric.aiagent.executionengine.eventstaskmanager.timertask.data.a.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: ITimerTaskDao.kt */
    public static final class C0368a {
        public /* synthetic */ C0368a(h r1) {
            this();
        }

        private C0368a() {
        }

        private final a b() {
            return (a) ZeusTransformUtils.preCheckCast(a.b().b(), a.class, "com.obric.aiagent.plugin");
        }

        public final a a() {
            return b();
        }
    }

    /* JADX INFO: renamed from: lambda$AmVgMe_Ik-ZW4acVd8bqENayI2E, reason: not valid java name */
    public static /* synthetic */ a m177lambda$AmVgMe_IkZW4acVd8bqENayI2E() {
        return d();
    }

    private a() {
    }

    public static final /* synthetic */ f b() {
        return f17917b;
    }

    static {
        f17916a = new C0368a(null);
        f17917b = g.a(j.f38505a, $$Lambda$a$AmVgMe_IkZW4acVd8bqENayI2E.INSTANCE);
    }

    private static final a d() {
        return new a();
    }

    private final com.obric.aiagent.executionengine.eventstaskmanager.timertask.data.b.a c() {
        return e.f16691a.b();
    }

    private final com.obric.aiagent.executionengine.eventstaskmanager.timertask.data.b.a c(String r1) {
        return e.f16691a.b(r1);
    }

    public final TimerTaskBean a(int r1) {
        com.obric.aiagent.executionengine.eventstaskmanager.timertask.data.b.a r0 = c();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.a(r1);
    }

    public final Long insert(TimerTaskBean r2) {
        o.e(r2, "task");
        com.obric.aiagent.executionengine.eventstaskmanager.timertask.data.b.a r1 = c();
        if (r1 != null) goto L7;
        return null;
    L7:
        return Long.valueOf(r1.insert(r2));
    }

    public final Integer a(TimerTaskBean r2) {
        o.e(r2, "task");
        com.obric.aiagent.executionengine.eventstaskmanager.timertask.data.b.a r1 = c();
        if (r1 != null) goto L7;
        return null;
    L7:
        return Integer.valueOf(r1.a(r2));
    }

    public final List<TimerTaskBean> a(androidx.sqlite.db.f r3) {
        androidx.sqlite.db.f r4 = (androidx.sqlite.db.f) ZeusTransformUtils.wrapperContextForParams(r3, androidx.sqlite.db.f.class, "com.obric.aiagent.plugin");
        o.e(r4, "sql");
        com.obric.aiagent.executionengine.eventstaskmanager.timertask.data.b.a r2 = c();
        if (r2 != null) goto L7;
        return null;
    L7:
        return r2.a(r4);
    }

    public final List<TimerTaskBean> a(String r2) {
        o.e(r2, "packageName");
        com.obric.aiagent.executionengine.eventstaskmanager.timertask.data.b.a r1 = c();
        if (r1 != null) goto L7;
        return null;
    L7:
        return r1.a(r2);
    }

    public final List<TimerTaskBean> a(String r2, int r3, int r4) {
        o.e(r2, "packageName");
        com.obric.aiagent.executionengine.eventstaskmanager.timertask.data.b.a r1 = c();
        if (r1 != null) goto L7;
        return null;
    L7:
        return r1.a(r2, r3, r4);
    }

    public final Integer b(TimerTaskBean r2) {
        o.e(r2, "task");
        com.obric.aiagent.executionengine.eventstaskmanager.timertask.data.b.a r1 = c();
        if (r1 != null) goto L7;
        return null;
    L7:
        return Integer.valueOf(r1.delete(r2));
    }

    public final List<TimerTaskBean> a() {
        com.obric.aiagent.executionengine.eventstaskmanager.timertask.data.b.a r0 = c();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.a();
    }

    public final List<TimerTaskBean> b(String r2) {
        o.e(r2, "uid");
        com.obric.aiagent.executionengine.eventstaskmanager.timertask.data.b.a r1 = c(r2);
        if (r1 != null) goto L7;
        return null;
    L7:
        return r1.a();
    }
}
