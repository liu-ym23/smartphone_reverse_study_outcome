package com.obric.oui.animation.engine;

import android.os.SystemClock;
import android.util.ArrayMap;
import android.view.Choreographer;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes4.dex */
public class AnimationHandler {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final ThreadLocal f12300g = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayMap f12301a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ArrayList f12302b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final a f12303c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public b f12304d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f12305e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f12306f;

    public interface AnimationFrameCallback {
        boolean doAnimationFrame(long r10);
    }

    public class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AnimationHandler f12307a;

        public a(AnimationHandler r10) {
            this.f12307a = r10;
        }

        public void a() {
            AnimationHandler r10 = this.f12307a;
            r10.f12305e = SystemClock.uptimeMillis();
            AnimationHandler r11 = this.f12307a;
            r11.c(r11.f12305e);
            if (this.f12307a.f12302b.size() <= 0) goto L6;
            this.f12307a.e().a();
            return;
        }
    }

    public static abstract class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final a f12308a;

        public b(a r10) {
            this.f12308a = r10;
        }

        public abstract void a();
    }

    public static class c extends b {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Choreographer f12309b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Choreographer.FrameCallback f12310c;

        public class a implements Choreographer.FrameCallback {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ c f12311a;

            public a(c r10) {
                this.f12311a = r10;
            }

            @Override // android.view.Choreographer.FrameCallback
            public void doFrame(long r10) {
                this.f12311a.f12308a.a();
            }
        }

        public c(a r10) {
            super(r10);
            this.f12309b = Choreographer.getInstance();
            this.f12310c = new a(this);
        }

        @Override // com.obric.oui.animation.engine.AnimationHandler.b
        public void a() {
            this.f12309b.postFrameCallback(this.f12310c);
        }
    }

    static {
        f12300g = new ThreadLocal();
    }

    public AnimationHandler() {
        this.f12301a = new ArrayMap();
        this.f12302b = new ArrayList();
        this.f12303c = new a(this);
        this.f12305e = 0;
        this.f12306f = false;
    }

    public static AnimationHandler d() {
        ThreadLocal r10 = f12300g;
        if (r10.get() != null) goto L6;
        r10.set(new AnimationHandler());
    L6:
        return (AnimationHandler) r10.get();
    }

    public void a(AnimationFrameCallback r10, long r11) {
        if (this.f12302b.size() != 0) goto L6;
        e().a();
    L6:
        if (this.f12302b.contains(r10) == true) goto L9;
        this.f12302b.add(r10);
    L9:
        if (r11 <= 0) goto L12;
        this.f12301a.put(r10, Long.valueOf(SystemClock.uptimeMillis() + r11));
        return;
    }

    public final void b() {
        if (this.f12306f == false) goto L15;
        int r10 = this.f12302b.size() - 1;
    L5:
        if (r10 < 0) goto L10;
        if (this.f12302b.get(r10) != null) goto L9;
        this.f12302b.remove(r10);
    L9:
        r10 = r10 - 1;
        goto L5
    L10:
        this.f12306f = false;
        return;
    }

    public void c(long r10) {
        long r11 = SystemClock.uptimeMillis();
        int r12 = 0;
    L4:
        if (r12 >= this.f12302b.size()) goto L12;
        AnimationFrameCallback r13 = (AnimationFrameCallback) this.f12302b.get(r12);
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
        if (this.f12304d != null) goto L6;
        this.f12304d = new c(this.f12303c);
    L6:
        return this.f12304d;
    }

    public final boolean f(AnimationFrameCallback r10, long r11) {
        Long r12 = (Long) this.f12301a.get(r10);
        if (r12 != null) goto L6;
        return true;
    L6:
        if (r12.longValue() >= r11) goto L9;
        this.f12301a.remove(r10);
        return true;
    L9:
        return false;
    }

    public void g(AnimationFrameCallback r10) {
        this.f12301a.remove(r10);
        int r11 = this.f12302b.indexOf(r10);
        if (r11 < 0) goto L6;
        this.f12302b.set(r11, null);
        this.f12306f = true;
        return;
    }
}
