package androidx.dynamicanimation.animation;

import android.animation.ValueAnimator;
import android.os.Looper;
import android.os.SystemClock;
import android.view.Choreographer;
import androidx.collection.t;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class b {

    /* renamed from: j, reason: collision with root package name */
    public static final ThreadLocal<b> f13672j = new ThreadLocal<>();

    /* renamed from: e, reason: collision with root package name */
    public h f13677e;

    /* renamed from: i, reason: collision with root package name */
    public e f13681i;

    /* renamed from: a, reason: collision with root package name */
    public final t<c, Long> f13673a = new t<>();

    /* renamed from: b, reason: collision with root package name */
    public final ArrayList<c> f13674b = new ArrayList<>();

    /* renamed from: c, reason: collision with root package name */
    public final C0165b f13675c = new C0165b();

    /* renamed from: d, reason: collision with root package name */
    public final Runnable f13676d = new Runnable() { // from class: androidx.dynamicanimation.animation.a
        @Override // java.lang.Runnable
        public final void run() {
            this.f13671a.f13675c.a();
        }
    };

    /* renamed from: f, reason: collision with root package name */
    public long f13678f = 0;

    /* renamed from: g, reason: collision with root package name */
    public boolean f13679g = false;

    /* renamed from: h, reason: collision with root package name */
    public float f13680h = 1.0f;

    /* renamed from: androidx.dynamicanimation.animation.b$b, reason: collision with other inner class name */
    public class C0165b {
        public C0165b() {
        }

        public void a() {
            b.this.f13678f = SystemClock.uptimeMillis();
            b bVar = b.this;
            bVar.f(bVar.f13678f);
            if (b.this.f13674b.size() > 0) {
                b.this.f13677e.a(b.this.f13676d);
            }
        }
    }

    public interface c {
        boolean a(long j10);
    }

    public class d implements e {

        /* renamed from: a, reason: collision with root package name */
        public ValueAnimator.DurationScaleChangeListener f13683a;

        public d() {
        }

        @Override // androidx.dynamicanimation.animation.b.e
        public boolean register() {
            if (this.f13683a != null) {
                return true;
            }
            ValueAnimator.DurationScaleChangeListener durationScaleChangeListener = new ValueAnimator.DurationScaleChangeListener() { // from class: androidx.dynamicanimation.animation.c
                @Override // android.animation.ValueAnimator.DurationScaleChangeListener
                public final void onChanged(float f10) {
                    b.this.f13680h = f10;
                }
            };
            this.f13683a = durationScaleChangeListener;
            return ValueAnimator.registerDurationScaleChangeListener(durationScaleChangeListener);
        }

        @Override // androidx.dynamicanimation.animation.b.e
        public boolean unregister() {
            boolean zUnregisterDurationScaleChangeListener = ValueAnimator.unregisterDurationScaleChangeListener(this.f13683a);
            this.f13683a = null;
            return zUnregisterDurationScaleChangeListener;
        }
    }

    public interface e {
        boolean register();

        boolean unregister();
    }

    public static final class f implements h {

        /* renamed from: a, reason: collision with root package name */
        public final Choreographer f13685a = Choreographer.getInstance();

        /* renamed from: b, reason: collision with root package name */
        public final Looper f13686b = Looper.myLooper();

        @Override // androidx.dynamicanimation.animation.h
        public void a(final Runnable runnable) {
            this.f13685a.postFrameCallback(new Choreographer.FrameCallback() { // from class: androidx.dynamicanimation.animation.d
                @Override // android.view.Choreographer.FrameCallback
                public final void doFrame(long j10) {
                    runnable.run();
                }
            });
        }

        @Override // androidx.dynamicanimation.animation.h
        public boolean b() {
            return Thread.currentThread() == this.f13686b.getThread();
        }
    }

    public b(h hVar) {
        this.f13677e = hVar;
    }

    public static b h() {
        ThreadLocal<b> threadLocal = f13672j;
        if (threadLocal.get() == null) {
            threadLocal.set(new b(new f()));
        }
        return threadLocal.get();
    }

    public void d(c cVar, long j10) {
        if (this.f13674b.size() == 0) {
            this.f13677e.a(this.f13676d);
            this.f13680h = ValueAnimator.getDurationScale();
            if (this.f13681i == null) {
                this.f13681i = new d();
            }
            this.f13681i.register();
        }
        if (!this.f13674b.contains(cVar)) {
            this.f13674b.add(cVar);
        }
        if (j10 > 0) {
            this.f13673a.put(cVar, Long.valueOf(SystemClock.uptimeMillis() + j10));
        }
    }

    public final void e() {
        if (this.f13679g) {
            for (int size = this.f13674b.size() - 1; size >= 0; size--) {
                if (this.f13674b.get(size) == null) {
                    this.f13674b.remove(size);
                }
            }
            if (this.f13674b.size() == 0) {
                this.f13681i.unregister();
            }
            this.f13679g = false;
        }
    }

    public void f(long j10) {
        long jUptimeMillis = SystemClock.uptimeMillis();
        for (int i10 = 0; i10 < this.f13674b.size(); i10++) {
            c cVar = this.f13674b.get(i10);
            if (cVar != null && i(cVar, jUptimeMillis)) {
                cVar.a(j10);
            }
        }
        e();
    }

    public float g() {
        return this.f13680h;
    }

    public final boolean i(c cVar, long j10) {
        Long l10 = this.f13673a.get(cVar);
        if (l10 == null) {
            return true;
        }
        if (l10.longValue() >= j10) {
            return false;
        }
        this.f13673a.remove(cVar);
        return true;
    }

    public boolean j() {
        return this.f13677e.b();
    }

    public void k(c cVar) {
        this.f13673a.remove(cVar);
        int iIndexOf = this.f13674b.indexOf(cVar);
        if (iIndexOf >= 0) {
            this.f13674b.set(iIndexOf, null);
            this.f13679g = true;
        }
    }
}
