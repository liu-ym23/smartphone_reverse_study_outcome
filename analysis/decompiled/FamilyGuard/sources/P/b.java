package P;

import android.animation.ValueAnimator;
import android.os.Looper;
import android.os.SystemClock;
import android.view.Choreographer;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class b {

    /* renamed from: j, reason: collision with root package name */
    private static final ThreadLocal<b> f4470j = new ThreadLocal<>();

    /* renamed from: e, reason: collision with root package name */
    private h f4475e;

    /* renamed from: i, reason: collision with root package name */
    public e f4479i;

    /* renamed from: a, reason: collision with root package name */
    private final q.i<c, Long> f4471a = new q.i<>();

    /* renamed from: b, reason: collision with root package name */
    final ArrayList<c> f4472b = new ArrayList<>();

    /* renamed from: c, reason: collision with root package name */
    private final C0071b f4473c = new C0071b();

    /* renamed from: d, reason: collision with root package name */
    private final Runnable f4474d = new Runnable() { // from class: P.a
        @Override // java.lang.Runnable
        public final void run() {
            this.f4469a.f4473c.a();
        }
    };

    /* renamed from: f, reason: collision with root package name */
    long f4476f = 0;

    /* renamed from: g, reason: collision with root package name */
    private boolean f4477g = false;

    /* renamed from: h, reason: collision with root package name */
    public float f4478h = 1.0f;

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: P.b$b, reason: collision with other inner class name */
    class C0071b {
        private C0071b() {
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void a() {
            b.this.f4476f = SystemClock.uptimeMillis();
            b bVar = b.this;
            bVar.f(bVar.f4476f);
            if (b.this.f4472b.size() > 0) {
                b.this.f4475e.a(b.this.f4474d);
            }
        }
    }

    interface c {
        boolean a(long j5);
    }

    public class d implements e {

        /* renamed from: a, reason: collision with root package name */
        ValueAnimator.DurationScaleChangeListener f4481a;

        public d() {
        }

        @Override // P.b.e
        public boolean a() {
            if (this.f4481a != null) {
                return true;
            }
            ValueAnimator.DurationScaleChangeListener durationScaleChangeListener = new ValueAnimator.DurationScaleChangeListener() { // from class: P.c
                @Override // android.animation.ValueAnimator.DurationScaleChangeListener
                public final void onChanged(float f5) {
                    b.this.f4478h = f5;
                }
            };
            this.f4481a = durationScaleChangeListener;
            return ValueAnimator.registerDurationScaleChangeListener(durationScaleChangeListener);
        }

        @Override // P.b.e
        public boolean b() {
            boolean zUnregisterDurationScaleChangeListener = ValueAnimator.unregisterDurationScaleChangeListener(this.f4481a);
            this.f4481a = null;
            return zUnregisterDurationScaleChangeListener;
        }
    }

    public interface e {
        boolean a();

        boolean b();
    }

    static final class f implements h {

        /* renamed from: a, reason: collision with root package name */
        private final Choreographer f4483a = Choreographer.getInstance();

        /* renamed from: b, reason: collision with root package name */
        private final Looper f4484b = Looper.myLooper();

        f() {
        }

        @Override // P.h
        public void a(final Runnable runnable) {
            this.f4483a.postFrameCallback(new Choreographer.FrameCallback() { // from class: P.d
                @Override // android.view.Choreographer.FrameCallback
                public final void doFrame(long j5) {
                    runnable.run();
                }
            });
        }

        @Override // P.h
        public boolean b() {
            return Thread.currentThread() == this.f4484b.getThread();
        }
    }

    public b(h hVar) {
        this.f4475e = hVar;
    }

    private void e() {
        if (this.f4477g) {
            for (int size = this.f4472b.size() - 1; size >= 0; size--) {
                if (this.f4472b.get(size) == null) {
                    this.f4472b.remove(size);
                }
            }
            if (this.f4472b.size() == 0) {
                this.f4479i.b();
            }
            this.f4477g = false;
        }
    }

    static b h() {
        ThreadLocal<b> threadLocal = f4470j;
        if (threadLocal.get() == null) {
            threadLocal.set(new b(new f()));
        }
        return threadLocal.get();
    }

    private boolean i(c cVar, long j5) {
        Long l5 = this.f4471a.get(cVar);
        if (l5 == null) {
            return true;
        }
        if (l5.longValue() >= j5) {
            return false;
        }
        this.f4471a.remove(cVar);
        return true;
    }

    void d(c cVar, long j5) {
        if (this.f4472b.size() == 0) {
            this.f4475e.a(this.f4474d);
            this.f4478h = ValueAnimator.getDurationScale();
            if (this.f4479i == null) {
                this.f4479i = new d();
            }
            this.f4479i.a();
        }
        if (!this.f4472b.contains(cVar)) {
            this.f4472b.add(cVar);
        }
        if (j5 > 0) {
            this.f4471a.put(cVar, Long.valueOf(SystemClock.uptimeMillis() + j5));
        }
    }

    void f(long j5) {
        long jUptimeMillis = SystemClock.uptimeMillis();
        for (int i5 = 0; i5 < this.f4472b.size(); i5++) {
            c cVar = this.f4472b.get(i5);
            if (cVar != null && i(cVar, jUptimeMillis)) {
                cVar.a(j5);
            }
        }
        e();
    }

    public float g() {
        return this.f4478h;
    }

    boolean j() {
        return this.f4475e.b();
    }

    void k(c cVar) {
        this.f4471a.remove(cVar);
        int iIndexOf = this.f4472b.indexOf(cVar);
        if (iIndexOf >= 0) {
            this.f4472b.set(iIndexOf, null);
            this.f4477g = true;
        }
    }
}
