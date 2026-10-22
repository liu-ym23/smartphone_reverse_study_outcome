package androidx.work.impl.utils;

import androidx.work.impl.WorkDatabase;

/* JADX INFO: loaded from: classes.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final WorkDatabase f5832a;

    public g(WorkDatabase r10) {
        kotlin.jvm.internal.q.g(r10, "workDatabase");
        this.f5832a = r10;
    }

    public static /* synthetic */ Integer a(g r10, int r11, int r12) {
        return f(r10, r11, r12);
    }

    public static /* synthetic */ Integer b(g r10) {
        return d(r10);
    }

    public static final Integer d(g r10) {
        kotlin.jvm.internal.q.g(r10, "this$0");
        return Integer.valueOf(h.a(r10.f5832a, "next_alarm_manager_id"));
    }

    public static final Integer f(g r10, int r11, int r12) {
        kotlin.jvm.internal.q.g(r10, "this$0");
        int r13 = h.a(r10.f5832a, "next_job_scheduler_id");
        if (r11 > r13) goto L6;
        if (r13 > r12) goto L6;
        r11 = r13;
    L8:
        return Integer.valueOf(r11);
    L6:
        h.b(r10.f5832a, "next_job_scheduler_id", r11 + 1);
        goto L8
    }

    public final int c() {
        Object r10 = this.f5832a.C(new e(this));
        kotlin.jvm.internal.q.f(r10, "workDatabase.runInTransa…ANAGER_ID_KEY)\n        })");
        return ((Number) r10).intValue();
    }

    public final int e(final int r10, final int r11) {
        Object r12 = this.f5832a.C(new f(this, r10, r11));
        kotlin.jvm.internal.q.f(r12, "workDatabase.runInTransa…            id\n        })");
        return ((Number) r12).intValue();
    }
}
