package androidx.work.impl.utils;

import androidx.work.Operation;
import androidx.work.WorkInfo;
import androidx.work.impl.Scheduler;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.c0;
import androidx.work.impl.model.DependencyDao;
import androidx.work.impl.model.WorkSpecDao;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.UUID;

/* JADX INFO: loaded from: classes.dex */
public abstract class b implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final androidx.work.impl.n f5792a;

    public class a extends b {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ c0 f5793b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ UUID f5794c;

        public a(c0 r10, UUID r11) {
            this.f5793b = r10;
            this.f5794c = r11;
        }

        @Override // androidx.work.impl.utils.b
        public void g() {
            WorkDatabase r10 = this.f5793b.q();
            r10.e();
            a(this.f5793b, this.f5794c.toString());     // Catch: Throwable -> L6
            r10.D();     // Catch: Throwable -> L6
            r10.i();
            f(this.f5793b);
            return;
        L6:
            th = move-exception;
            r10.i();
            throw th;
        }
    }

    /* JADX INFO: renamed from: androidx.work.impl.utils.b$b, reason: collision with other inner class name */
    public class C0061b extends b {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ c0 f5795b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f5796c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ boolean f5797d;

        public C0061b(c0 r10, String r11, boolean r12) {
            this.f5795b = r10;
            this.f5796c = r11;
            this.f5797d = r12;
        }

        @Override // androidx.work.impl.utils.b
        public void g() {
            WorkDatabase r10 = this.f5795b.q();
            r10.e();
            Iterator<String> r11 = r10.L().getUnfinishedWorkWithName(this.f5796c).iterator();     // Catch: Throwable -> L7
        L5:
            if (r11.hasNext() == false) goto L9;
            String r12 = r11.next();     // Catch: Throwable -> L7
            a(this.f5795b, r12);     // Catch: Throwable -> L7
            goto L5
        L9:
            r10.D();     // Catch: Throwable -> L7
            r10.i();
            if (this.f5797d == false) goto L19;
            f(this.f5795b);
            return;
        L19:
            return;
        L7:
            th = move-exception;
            r10.i();
            throw th;
        }
    }

    public b() {
        this.f5792a = new androidx.work.impl.n();
    }

    public static b b(UUID r10, c0 r11) {
        return new a(r11, r10);
    }

    public static b c(String r10, c0 r11, boolean r12) {
        return new C0061b(r11, r10, r12);
    }

    public void a(c0 r10, String r11) {
        e(r10.q(), r11);
        r10.n().n(r11);
        Iterator r12 = r10.o().iterator();
    L4:
        if (r12.hasNext() == false) goto L6;
        ((Scheduler) r12.next()).cancel(r11);
        goto L4
    }

    public Operation d() {
        return this.f5792a;
    }

    public final void e(WorkDatabase r10, String r11) {
        WorkSpecDao r12 = r10.L();
        DependencyDao r13 = r10.G();
        LinkedList r14 = new LinkedList();
        r14.add(r11);
    L4:
        if (r14.isEmpty() == true) goto L11;
        String r15 = (String) r14.remove();
        WorkInfo.State r16 = r12.getState(r15);
        if (r16 == WorkInfo.State.SUCCEEDED) goto L10;
        if (r16 == WorkInfo.State.FAILED) goto L10;
        r12.setState(WorkInfo.State.CANCELLED, r15);
    L10:
        r14.addAll(r13.getDependentWorkIds(r15));
        goto L4
    }

    public void f(c0 r10) {
        androidx.work.impl.s.b(r10.j(), r10.q(), r10.o());
    }

    public abstract void g();

    @Override // java.lang.Runnable
    public void run() {
        g();     // Catch: Throwable -> L4
        this.f5792a.a(Operation.SUCCESS);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        this.f5792a.a(new Operation.b.a(th));
    }
}
