package androidx.lifecycle;

import android.os.Handler;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: ServiceLifecycleDispatcher.kt */
/* JADX INFO: loaded from: classes.dex */
public class ai {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final r f2010a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Handler f2011b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private a f2012c;

    /* JADX INFO: compiled from: ServiceLifecycleDispatcher.kt */
    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final r f2013a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final i.a f2014b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private boolean f2015c;

        public a(r r2, i.a r3) {
            d.h.b.o.e(r2, "registry");
            d.h.b.o.e(r3, "event");
            this.f2013a = r2;
            this.f2014b = r3;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f2015c == true) goto L6;
            this.f2013a.a(this.f2014b);
            this.f2015c = true;
            return;
        }
    }

    public ai(p r3) {
        p r4 = (p) ZeusTransformUtils.wrapperContextForParams(r3, p.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r4, "provider");
        this.f2010a = new r(r4);
        this.f2011b = new Handler();
    }

    private final void a(i.a r3) {
        a r0 = this.f2012c;
        if (r0 == null) goto L5;
        r0.run();
    L5:
        a r1 = new a(this.f2010a, r3);
        this.f2012c = r1;
        Handler r2 = this.f2011b;
        d.h.b.o.a(r1);
        r2.postAtFrontOfQueue((Runnable) ZeusTransformUtils.preCheckCast(r1, Runnable.class, "com.obric.aiagent.plugin"));
    }

    public void a() {
        a(i.a.ON_CREATE);
    }

    public void b() {
        a(i.a.ON_START);
    }

    public void c() {
        a(i.a.ON_START);
    }

    public void d() {
        a(i.a.ON_STOP);
        a(i.a.ON_DESTROY);
    }

    public i e() {
        return (i) ZeusTransformUtils.preCheckCast(this.f2010a, i.class, "com.obric.aiagent.plugin");
    }
}
