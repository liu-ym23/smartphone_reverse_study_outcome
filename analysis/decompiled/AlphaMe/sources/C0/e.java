package C0;

import androidx.work.impl.WorkDatabase;
import androidx.work.impl.background.systemalarm.RescheduleReceiver;
import f1.AbstractC0557a;
import java.util.HashSet;
import s0.B;
import t0.C0913H;
import t0.C0929o;

/* loaded from: classes.dex */
public final class e implements Runnable {

    /* renamed from: c, reason: collision with root package name */
    public static final String f293c = s0.t.f("EnqueueRunnable");

    /* renamed from: a, reason: collision with root package name */
    public final t0.y f294a;

    /* renamed from: b, reason: collision with root package name */
    public final C0929o f295b;

    public e(t0.y yVar, C0929o c0929o) {
        this.f294a = yVar;
        this.f295b = c0929o;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:102:0x01e9  */
    /* JADX WARN: Removed duplicated region for block: B:165:0x0173 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:70:0x015a  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x01c9  */
    /* JADX WARN: Type inference failed for: r14v8, types: [java.util.List] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static boolean a(t0.y r26) {
        /*
            Method dump skipped, instructions count: 767
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: C0.e.a(t0.y):boolean");
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0929o c0929o = this.f295b;
        t0.y yVar = this.f294a;
        try {
            yVar.getClass();
            C0913H c0913h = yVar.f15427b;
            if (t0.y.J0(yVar, new HashSet())) {
                throw new IllegalStateException("WorkContinuation has cycles (" + yVar + ")");
            }
            WorkDatabase workDatabase = c0913h.f15327d;
            workDatabase.beginTransaction();
            try {
                AbstractC0557a.j(workDatabase, c0913h.f15326c, yVar);
                boolean zA = a(yVar);
                workDatabase.setTransactionSuccessful();
                if (zA) {
                    m.a(c0913h.f15325b, RescheduleReceiver.class, true);
                    t0.w.b(c0913h.f15326c, c0913h.f15327d, c0913h.f15329f);
                }
                c0929o.a(B.f14148a);
            } finally {
                workDatabase.endTransaction();
            }
        } catch (Throwable th) {
            c0929o.a(new s0.y(th));
        }
    }
}
