package androidx.work.impl;

import android.content.Context;
import androidx.work.Configuration;
import androidx.work.impl.background.systemjob.SystemJobService;
import androidx.work.impl.model.WorkSpecDao;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public abstract class s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f5773a = null;

    static {
        f5773a = androidx.work.i.i("Schedulers");
    }

    public static Scheduler a(Context r10, c0 r11) {
        androidx.work.impl.background.systemjob.b r12 = new androidx.work.impl.background.systemjob.b(r10, r11);
        androidx.work.impl.utils.l.a(r10, SystemJobService.class, true);
        androidx.work.i.e().a(f5773a, "Created SystemJobScheduler and enabled SystemJobService");
        return r12;
    }

    public static void b(Configuration r10, WorkDatabase r11, List r12) {
        if (r12 != null) goto L4;
        return;
    L4:
        if (r12.size() == 0) goto L56;
        WorkSpecDao r13 = r11.L();
        r11.e();
        List<androidx.work.impl.model.o> r14 = r13.getEligibleWorkForScheduling(r10.h());     // Catch: Throwable -> L15
        List<androidx.work.impl.model.o> r15 = r13.getAllEligibleWorkSpecsForScheduling(200);     // Catch: Throwable -> L15
        if (r14 != null) goto L10;
    L17:
        r11.D();     // Catch: Throwable -> L15
        r11.i();
        if (r14 != null) goto L21;
    L28:
        if (r15 != null) goto L30;
        return;
    L30:
        if (r15.size() <= 0) goto L54;
        androidx.work.impl.model.o[] r16 = (androidx.work.impl.model.o[]) r15.toArray(new androidx.work.impl.model.o[r15.size()]);
        Iterator r17 = r12.iterator();
    L33:
        if (r17.hasNext() == false) goto L55;
        Scheduler r18 = (Scheduler) r17.next();
        if (r18.hasLimitedSchedulingSlots() == true) goto L33;
        r18.schedule(r16);
        goto L33
    L55:
        return;
    L54:
        return;
    L21:
        if (r14.size() <= 0) goto L28;
        androidx.work.impl.model.o[] r19 = (androidx.work.impl.model.o[]) r14.toArray(new androidx.work.impl.model.o[r14.size()]);
        Iterator r20 = r12.iterator();
    L24:
        if (r20.hasNext() == false) goto L28;
        Scheduler r21 = (Scheduler) r20.next();
        if (r21.hasLimitedSchedulingSlots() == false) goto L24;
        r21.schedule(r19);
        goto L24
    L10:
        if (r14.size() <= 0) goto L17;
        long r22 = System.currentTimeMillis();     // Catch: Throwable -> L15
        Iterator<androidx.work.impl.model.o> r23 = r14.iterator();     // Catch: Throwable -> L15
    L13:
        if (r23.hasNext() == false) goto L17;
        r13.markWorkSpecScheduled(r23.next().f5670a, r22);     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        r11.i();
        throw th;
    }
}
