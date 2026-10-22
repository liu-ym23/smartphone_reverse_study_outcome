package l0;

import androidx.work.RunnableScheduler;
import androidx.work.i;
import androidx.work.impl.model.o;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String f21777d = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b f21778a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final RunnableScheduler f21779b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map f21780c;

    /* JADX INFO: renamed from: l0.a$a, reason: collision with other inner class name */
    public class RunnableC0298a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ o f21781a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ a f21782b;

        public RunnableC0298a(a r10, o r11) {
            this.f21782b = r10;
            this.f21781a = r11;
        }

        @Override // java.lang.Runnable
        public void run() {
            i.e().a(a.f21777d, "Scheduling work " + this.f21781a.f5670a);
            this.f21782b.f21778a.schedule(new o[]{this.f21781a});
        }
    }

    static {
        f21777d = i.i("DelayedWorkTracker");
    }

    public a(b r10, RunnableScheduler r11) {
        this.f21778a = r10;
        this.f21779b = r11;
        this.f21780c = new HashMap();
    }

    public void a(o r10) {
        Runnable r11 = (Runnable) this.f21780c.remove(r10.f5670a);
        if (r11 == null) goto L5;
        this.f21779b.cancel(r11);
    L5:
        RunnableC0298a r12 = new RunnableC0298a(this, r10);
        this.f21780c.put(r10.f5670a, r12);
        long r13 = System.currentTimeMillis();
        long r14 = r10.c() - r13;
        this.f21779b.scheduleWithDelay(r14, r12);
    }

    public void b(String r10) {
        Runnable r11 = (Runnable) this.f21780c.remove(r10);
        if (r11 == null) goto L6;
        this.f21779b.cancel(r11);
        return;
    }
}
