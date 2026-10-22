package w0;

import android.content.Context;
import com.bytedance.apm.ApmAgent;
import com.bytedance.apm.internal.ApmDelegate;

/* JADX INFO: loaded from: classes.dex */
public class b {

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f25237a;

        public a(b r10) {
            this.f25237a = r10;
        }

        @Override // java.lang.Runnable
        public void run() {
            ApmAgent.r("Apm#init", "Apm init");
        }
    }

    /* JADX INFO: renamed from: w0.b$b, reason: collision with other inner class name */
    public class RunnableC0398b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f25238a;

        public RunnableC0398b(b r10) {
            this.f25238a = r10;
        }

        @Override // java.lang.Runnable
        public void run() {
            ApmAgent.r("Apm#start", "Apm start");
        }
    }

    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f25239a = null;

        static {
            f25239a = new b(null);
        }

        public static /* synthetic */ b a() {
            return f25239a;
        }
    }

    public /* synthetic */ b(w0.a r10) {
        this();
    }

    public static b a() {
        return c.a();
    }

    public void b(Context r10, h1.b r11) {
        ApmDelegate.j().n(r10, r11);
        if (w0.c.D() == false) goto L6;
        d2.b.a().b(new a(this));
        return;
    }

    public void c(h1.c r10) {
        ApmDelegate.j().z(r10);
        if (w0.c.D() == false) goto L6;
        d2.b.a().b(new RunnableC0398b(this));
        return;
    }

    public b() {
    }
}
