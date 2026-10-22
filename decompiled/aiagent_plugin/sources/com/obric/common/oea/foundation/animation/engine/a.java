package com.obric.common.oea.foundation.animation.engine;

import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.util.ArrayMap;
import android.view.Choreographer;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;

/* JADX INFO: compiled from: AnimationHandler.java */
/* JADX INFO: loaded from: classes4.dex */
class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ThreadLocal<a> f32357a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final ArrayList<b> f32358b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    long f32359c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final ArrayMap<b, Long> f32360d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final C0882a f32361e;
    private c f;
    private boolean g;

    /* JADX INFO: renamed from: com.obric.common.oea.foundation.animation.engine.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: AnimationHandler.java */
    class C0882a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ a f32362a;

        C0882a(a r1) {
            this.f32362a = r1;
        }

        void a() {
            a r0 = this.f32362a;
            r0.f32359c = SystemClock.uptimeMillis();
            a r1 = this.f32362a;
            r1.a(r1.f32359c);
            if (this.f32362a.f32358b.size() <= 0) goto L6;
            this.f32362a.b().a();
            return;
        }
    }

    /* JADX INFO: compiled from: AnimationHandler.java */
    interface b {
        boolean a(long r1);
    }

    /* JADX INFO: compiled from: AnimationHandler.java */
    static abstract class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final C0882a f32363a;

        abstract void a();

        c(C0882a r1) {
            this.f32363a = r1;
        }
    }

    /* JADX INFO: compiled from: AnimationHandler.java */
    private static class d extends c {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        long f32364b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final Runnable f32365c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final Handler f32366d;

        d(C0882a r3) {
            super(r3);
            this.f32364b = -1;
            this.f32365c = new AnonymousClass1(this);
            this.f32366d = new Handler(Looper.myLooper());
        }

        @Override // com.obric.common.oea.foundation.animation.engine.a.c
        void a() {
            long r0 = Math.max(10 - (SystemClock.uptimeMillis() - this.f32364b), 0);
            this.f32366d.postDelayed(this.f32365c, r0);
        }
    }

    /* JADX INFO: compiled from: AnimationHandler.java */
    private static class e extends c {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Choreographer f32368b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final Choreographer.FrameCallback f32369c;

        e(C0882a r1) {
            super(r1);
            this.f32368b = Choreographer.getInstance();
            this.f32369c = new AnimationHandler$FrameCallbackProvider16$1(this);
        }

        @Override // com.obric.common.oea.foundation.animation.engine.a.c
        void a() {
            this.f32368b.postFrameCallback(this.f32369c);
        }
    }

    a() {
        this.f32360d = new ArrayMap();
        this.f32358b = new ArrayList();
        this.f32361e = new C0882a(this);
        this.f32359c = 0;
        this.g = false;
    }

    static {
        f32357a = new ThreadLocal();
    }

    public static a a() {
        ThreadLocal<a> r0 = f32357a;
        if (r0.get() != null) goto L6;
        r0.set(new a());
    L6:
        return (a) ZeusTransformUtils.preCheckCast(r0.get(), a.class, "com.obric.aiagent.plugin");
    }

    c b() {
        if (this.f != null) goto L9;
        if (Build.VERSION.SDK_INT < 16) goto L7;
        this.f = new e(this.f32361e);
        goto L9
    L7:
        this.f = new d(this.f32361e);
    L9:
        return this.f;
    }

    public void a(b r3, long r4) {
        b r5 = (b) ZeusTransformUtils.wrapperContextForParams(r3, b.class, "com.obric.aiagent.plugin");
        if (this.f32358b.size() != 0) goto L6;
        b().a();
    L6:
        if (this.f32358b.contains(r5) == true) goto L9;
        this.f32358b.add(r5);
    L9:
        if (r4 <= 0) goto L12;
        this.f32360d.put(r5, Long.valueOf(SystemClock.uptimeMillis() + r4));
        return;
    }

    public void a(b r3) {
        b r4 = (b) ZeusTransformUtils.wrapperContextForParams(r3, b.class, "com.obric.aiagent.plugin");
        this.f32360d.remove(r4);
        int r5 = this.f32358b.indexOf(r4);
        if (r5 < 0) goto L6;
        this.f32358b.set(r5, null);
        this.g = true;
        return;
    }

    void a(long r7) {
        long r0 = SystemClock.uptimeMillis();
        int r2 = 0;
    L4:
        if (r2 >= this.f32358b.size()) goto L12;
        b r3 = (b) ZeusTransformUtils.preCheckCast(this.f32358b.get(r2), b.class, "com.obric.aiagent.plugin");
        if (r3 == null) goto L11;
        if (b(r3, r0) == false) goto L11;
        r3.a(r7);
    L11:
        r2 = r2 + 1;
        goto L4
    L12:
        c();
    }

    private boolean b(b r5, long r6) {
        b r7 = (b) ZeusTransformUtils.wrapperContextForParams(r5, b.class, "com.obric.aiagent.plugin");
        Long r0 = (Long) ZeusTransformUtils.preCheckCast(this.f32360d.get(r7), Long.class, "com.obric.aiagent.plugin");
        if (r0 != null) goto L6;
        return true;
    L6:
        if (r0.longValue() >= r6) goto L9;
        this.f32360d.remove(r7);
        return true;
    L9:
        return false;
    }

    private void c() {
        if (this.g == false) goto L15;
        int r0 = this.f32358b.size() - 1;
    L5:
        if (r0 < 0) goto L10;
        if (this.f32358b.get(r0) != null) goto L9;
        this.f32358b.remove(r0);
    L9:
        r0 = r0 - 1;
        goto L5
    L10:
        this.g = false;
        return;
    }
}
