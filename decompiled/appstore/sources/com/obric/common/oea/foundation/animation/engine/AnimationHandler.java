package com.obric.common.oea.foundation.animation.engine;

import android.os.SystemClock;
import android.util.ArrayMap;
import android.view.Choreographer;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes3.dex */
public class AnimationHandler {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final ThreadLocal f11495g = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayMap f11496a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ArrayList f11497b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final a f11498c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public b f11499d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f11500e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f11501f;

    public interface AnimationFrameCallback {
        boolean doAnimationFrame(long r10);
    }

    public class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AnimationHandler f11502a;

        public a(AnimationHandler r10) {
            this.f11502a = r10;
        }

        public void a() {
            AnimationHandler r10 = this.f11502a;
            r10.f11500e = SystemClock.uptimeMillis();
            AnimationHandler r11 = this.f11502a;
            r11.c(r11.f11500e);
            if (this.f11502a.f11497b.size() <= 0) goto L6;
            this.f11502a.e().a();
            return;
        }
    }

    public static abstract class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final a f11503a;

        public b(a r10) {
            this.f11503a = r10;
        }

        public abstract void a();
    }

    public static class c extends b {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Choreographer f11504b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Choreographer.FrameCallback f11505c;

        public class a implements Choreographer.FrameCallback {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ c f11506a;

            public a(c r10) {
                this.f11506a = r10;
            }

            @Override // android.view.Choreographer.FrameCallback
            public void doFrame(long r10) {
                this.f11506a.f11503a.a();
            }
        }

        public c(a r10) {
            super(r10);
            this.f11504b = Choreographer.getInstance();
            this.f11505c = new a(this);
        }

        @Override // com.obric.common.oea.foundation.animation.engine.AnimationHandler.b
        public void a() {
            this.f11504b.postFrameCallback(this.f11505c);
        }
    }

    static {
        f11495g = new ThreadLocal();
    }

    public AnimationHandler() {
        this.f11496a = new ArrayMap();
        this.f11497b = new ArrayList();
        this.f11498c = new a(this);
        this.f11500e = 0;
        this.f11501f = false;
    }

    public static AnimationHandler d() {
        ThreadLocal r10 = f11495g;
        if (r10.get() != null) goto L6;
        r10.set(new AnimationHandler());
    L6:
        return (AnimationHandler) r10.get();
    }

    public void a(AnimationFrameCallback r10, long r11) {
        if (this.f11497b.size() != 0) goto L6;
        e().a();
    L6:
        if (this.f11497b.contains(r10) == true) goto L9;
        this.f11497b.add(r10);
    L9:
        if (r11 <= 0) goto L12;
        this.f11496a.put(r10, Long.valueOf(SystemClock.uptimeMillis() + r11));
        return;
    }

    public final void b() {
        if (this.f11501f == false) goto L15;
        int r10 = this.f11497b.size() - 1;
    L5:
        if (r10 < 0) goto L10;
        if (this.f11497b.get(r10) != null) goto L9;
        this.f11497b.remove(r10);
    L9:
        r10 = r10 - 1;
        goto L5
    L10:
        this.f11501f = false;
        return;
    }

    public void c(long r10) {
        long r11 = SystemClock.uptimeMillis();
        int r12 = 0;
    L4:
        if (r12 >= this.f11497b.size()) goto L12;
        AnimationFrameCallback r13 = (AnimationFrameCallback) this.f11497b.get(r12);
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
        if (this.f11499d != null) goto L6;
        this.f11499d = new c(this.f11498c);
    L6:
        return this.f11499d;
    }

    public final boolean f(AnimationFrameCallback r10, long r11) {
        Long r12 = (Long) this.f11496a.get(r10);
        if (r12 != null) goto L6;
        return true;
    L6:
        if (r12.longValue() >= r11) goto L9;
        this.f11496a.remove(r10);
        return true;
    L9:
        return false;
    }

    public void g(AnimationFrameCallback r10) {
        this.f11496a.remove(r10);
        int r11 = this.f11497b.indexOf(r10);
        if (r11 < 0) goto L6;
        this.f11497b.set(r11, null);
        this.f11501f = true;
        return;
    }
}
