package androidx.dynamicanimation.animation;

import android.os.SystemClock;
import android.view.Choreographer;
import androidx.collection.SimpleArrayMap;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class AnimationHandler {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final ThreadLocal f2959g = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SimpleArrayMap f2960a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ArrayList f2961b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final a f2962c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public b f2963d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f2964e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f2965f;

    public interface AnimationFrameCallback {
        boolean doAnimationFrame(long r10);
    }

    public class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AnimationHandler f2966a;

        public a(AnimationHandler r10) {
            this.f2966a = r10;
        }

        public void a() {
            AnimationHandler r10 = this.f2966a;
            r10.f2964e = SystemClock.uptimeMillis();
            AnimationHandler r11 = this.f2966a;
            r11.c(r11.f2964e);
            if (this.f2966a.f2961b.size() <= 0) goto L6;
            this.f2966a.e().a();
            return;
        }
    }

    public static abstract class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final a f2967a;

        public b(a r10) {
            this.f2967a = r10;
        }

        public abstract void a();
    }

    public static class c extends b {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Choreographer f2968b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Choreographer.FrameCallback f2969c;

        public class a implements Choreographer.FrameCallback {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ c f2970a;

            public a(c r10) {
                this.f2970a = r10;
            }

            @Override // android.view.Choreographer.FrameCallback
            public void doFrame(long r10) {
                this.f2970a.f2967a.a();
            }
        }

        public c(a r10) {
            super(r10);
            this.f2968b = Choreographer.getInstance();
            this.f2969c = new a(this);
        }

        @Override // androidx.dynamicanimation.animation.AnimationHandler.b
        public void a() {
            this.f2968b.postFrameCallback(this.f2969c);
        }
    }

    static {
        f2959g = new ThreadLocal();
    }

    public AnimationHandler() {
        this.f2960a = new SimpleArrayMap();
        this.f2961b = new ArrayList();
        this.f2962c = new a(this);
        this.f2964e = 0;
        this.f2965f = false;
    }

    public static AnimationHandler d() {
        ThreadLocal r10 = f2959g;
        if (r10.get() != null) goto L6;
        r10.set(new AnimationHandler());
    L6:
        return (AnimationHandler) r10.get();
    }

    public void a(AnimationFrameCallback r10, long r11) {
        if (this.f2961b.size() != 0) goto L6;
        e().a();
    L6:
        if (this.f2961b.contains(r10) == true) goto L9;
        this.f2961b.add(r10);
    L9:
        if (r11 <= 0) goto L12;
        this.f2960a.put(r10, Long.valueOf(SystemClock.uptimeMillis() + r11));
        return;
    }

    public final void b() {
        if (this.f2965f == false) goto L15;
        int r10 = this.f2961b.size() - 1;
    L5:
        if (r10 < 0) goto L10;
        if (this.f2961b.get(r10) != null) goto L9;
        this.f2961b.remove(r10);
    L9:
        r10 = r10 - 1;
        goto L5
    L10:
        this.f2965f = false;
        return;
    }

    public void c(long r10) {
        long r11 = SystemClock.uptimeMillis();
        int r12 = 0;
    L4:
        if (r12 >= this.f2961b.size()) goto L12;
        AnimationFrameCallback r13 = (AnimationFrameCallback) this.f2961b.get(r12);
        if (r13 == null) goto L11;
        if (f(r13, r11) == false) goto L11;
        r13.doAnimationFrame(r10);
    L11:
        r12 = r12 + 1;
        goto L4
    L12:
        b();
    }

    public b e() {
        if (this.f2963d != null) goto L6;
        this.f2963d = new c(this.f2962c);
    L6:
        return this.f2963d;
    }

    public final boolean f(AnimationFrameCallback r10, long r11) {
        Long r12 = (Long) this.f2960a.get(r10);
        if (r12 != null) goto L6;
        return true;
    L6:
        if (r12.longValue() >= r11) goto L9;
        this.f2960a.remove(r10);
        return true;
    L9:
        return false;
    }

    public void g(AnimationFrameCallback r10) {
        this.f2960a.remove(r10);
        int r11 = this.f2961b.indexOf(r10);
        if (r11 < 0) goto L6;
        this.f2961b.set(r11, null);
        this.f2965f = true;
        return;
    }
}
