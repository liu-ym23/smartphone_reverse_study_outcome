package com.obric.oui.animation.engine;

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
    public static final ThreadLocal<a> f33958a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final ArrayList<b> f33959b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    long f33960c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final ArrayMap<b, Long> f33961d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final C0922a f33962e;
    private c f;
    private boolean g;

    /* JADX INFO: renamed from: com.obric.oui.animation.engine.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: AnimationHandler.java */
    class C0922a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ a f33963a;

        C0922a(a r1) {
            this.f33963a = r1;
        }

        void a() {
            a r0 = this.f33963a;
            r0.f33960c = SystemClock.uptimeMillis();
            a r1 = this.f33963a;
            r1.a(r1.f33960c);
            if (this.f33963a.f33959b.size() <= 0) goto L6;
            this.f33963a.b().a();
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
        final C0922a f33964a;

        abstract void a();

        c(C0922a r1) {
            this.f33964a = r1;
        }
    }

    /* JADX INFO: compiled from: AnimationHandler.java */
    private static class d extends c {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        long f33965b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final Runnable f33966c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final Handler f33967d;

        d(C0922a r3) {
            super(r3);
            this.f33965b = -1;
            this.f33966c = new AnonymousClass1(this);
            this.f33967d = new Handler(Looper.myLooper());
        }

        @Override // com.obric.oui.animation.engine.a.c
        void a() {
            long r0 = Math.max(10 - (SystemClock.uptimeMillis() - this.f33965b), 0);
            this.f33967d.postDelayed(this.f33966c, r0);
        }
    }

    /* JADX INFO: compiled from: AnimationHandler.java */
    private static class e extends c {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Choreographer f33969b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final Choreographer.FrameCallback f33970c;

        e(C0922a r1) {
            super(r1);
            this.f33969b = Choreographer.getInstance();
            this.f33970c = new AnimationHandler$FrameCallbackProvider16$1(this);
        }

        @Override // com.obric.oui.animation.engine.a.c
        void a() {
            this.f33969b.postFrameCallback(this.f33970c);
        }
    }

    a() {
        this.f33961d = new ArrayMap();
        this.f33959b = new ArrayList();
        this.f33962e = new C0922a(this);
        this.f33960c = 0;
        this.g = false;
    }

    static {
        f33958a = new ThreadLocal();
    }

    public static a a() {
        ThreadLocal<a> r0 = f33958a;
        if (r0.get() != null) goto L6;
        r0.set(new a());
    L6:
        return (a) ZeusTransformUtils.preCheckCast(r0.get(), a.class, "com.obric.aiagent.plugin");
    }

    c b() {
        if (this.f != null) goto L9;
        if (Build.VERSION.SDK_INT < 16) goto L7;
        this.f = new e(this.f33962e);
        goto L9
    L7:
        this.f = new d(this.f33962e);
    L9:
        return this.f;
    }

    public void a(b r3, long r4) {
        b r5 = (b) ZeusTransformUtils.wrapperContextForParams(r3, b.class, "com.obric.aiagent.plugin");
        if (this.f33959b.size() != 0) goto L6;
        b().a();
    L6:
        if (this.f33959b.contains(r5) == true) goto L9;
        this.f33959b.add(r5);
    L9:
        if (r4 <= 0) goto L12;
        this.f33961d.put(r5, Long.valueOf(SystemClock.uptimeMillis() + r4));
        return;
    }

    public void a(b r3) {
        b r4 = (b) ZeusTransformUtils.wrapperContextForParams(r3, b.class, "com.obric.aiagent.plugin");
        this.f33961d.remove(r4);
        int r5 = this.f33959b.indexOf(r4);
        if (r5 < 0) goto L6;
        this.f33959b.set(r5, null);
        this.g = true;
        return;
    }

    void a(long r7) {
        long r0 = SystemClock.uptimeMillis();
        int r2 = 0;
    L4:
        if (r2 >= this.f33959b.size()) goto L12;
        b r3 = (b) ZeusTransformUtils.preCheckCast(this.f33959b.get(r2), b.class, "com.obric.aiagent.plugin");
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
        Long r0 = (Long) ZeusTransformUtils.preCheckCast(this.f33961d.get(r7), Long.class, "com.obric.aiagent.plugin");
        if (r0 != null) goto L6;
        return true;
    L6:
        if (r0.longValue() >= r6) goto L9;
        this.f33961d.remove(r7);
        return true;
    L9:
        return false;
    }

    private void c() {
        if (this.g == false) goto L15;
        int r0 = this.f33959b.size() - 1;
    L5:
        if (r0 < 0) goto L10;
        if (this.f33959b.get(r0) != null) goto L9;
        this.f33959b.remove(r0);
    L9:
        r0 = r0 - 1;
        goto L5
    L10:
        this.g = false;
        return;
    }
}
