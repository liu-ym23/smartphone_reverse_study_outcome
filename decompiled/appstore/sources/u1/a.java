package u1;

import com.bytedance.apm.listener.IApmLogListener;
import com.bytedance.apm.thread.AsyncEventManager;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;
import org.json.JSONObject;
import w0.c;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile a f24813b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public CopyOnWriteArraySet f24814a;

    /* JADX INFO: renamed from: u1.a$a, reason: collision with other inner class name */
    public class RunnableC0385a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f24815a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f24816b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ JSONObject f24817c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ a f24818d;

        public RunnableC0385a(a r10, String r11, String r12, JSONObject r13) {
            this.f24818d = r10;
            this.f24815a = r11;
            this.f24816b = r12;
            this.f24817c = r13;
        }

        @Override // java.lang.Runnable
        public void run() {
            Iterator r10 = this.f24818d.f24814a.iterator();
        L4:
            if (r10.hasNext() == false) goto L6;
            ((IApmLogListener) r10.next()).onLog(this.f24815a, this.f24816b, this.f24817c);
            goto L4
        }
    }

    public a() {
        this.f24814a = new CopyOnWriteArraySet();
    }

    public static a b() {
        if (f24813b != null) goto L16;
        monitor-enter(a.class);
    L9:
        th = move-exception;
        throw th;
    L7:
        if (f24813b != null) goto L11;
        f24813b = new a();     // Catch: Throwable -> L9
    L11:
        monitor-exit(a.class);     // Catch: Throwable -> L9
    L16:
        return f24813b;
    }

    public void a(IApmLogListener r10) {
        if (r10 == null) goto L8;
        this.f24814a.add(r10);     // Catch: Throwable -> L5
        return;
    L9:
        return;
    }

    public void c(String r10, String r11, JSONObject r12) {
        if (c.B() == false) goto L6;
        s3.a.a("LogObserver", "logObserverList:" + this.f24814a.size());
    L6:
        if (this.f24814a.size() != 0) goto L8;
        return;
    L8:
        AsyncEventManager.e().n(new RunnableC0385a(this, r10, r11, r12));
    }
}
