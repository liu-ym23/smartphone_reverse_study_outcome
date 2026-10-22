package androidx.dynamicanimation.animation;

import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.view.Choreographer;
import androidx.b.g;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;

/* JADX INFO: compiled from: AnimationHandler.java */
/* JADX INFO: loaded from: classes.dex */
class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ThreadLocal<a> f1576a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final ArrayList<b> f1577b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    long f1578c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final g<b, Long> f1579d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final C0047a f1580e;
    private c f;
    private boolean g;

    /* JADX INFO: renamed from: androidx.dynamicanimation.animation.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: AnimationHandler.java */
    class C0047a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ a f1581a;

        C0047a(a r1) {
            this.f1581a = r1;
        }

        void a() {
            a r0 = this.f1581a;
            r0.f1578c = SystemClock.uptimeMillis();
            a r1 = this.f1581a;
            r1.a(r1.f1578c);
            if (this.f1581a.f1577b.size() <= 0) goto L6;
            this.f1581a.b().a();
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
        final C0047a f1582a;

        abstract void a();

        c(C0047a r1) {
            this.f1582a = r1;
        }
    }

    /* JADX INFO: compiled from: AnimationHandler.java */
    private static class d extends c {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        long f1583b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final Runnable f1584c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final Handler f1585d;

        d(C0047a r3) {
            super(r3);
            this.f1583b = -1;
            this.f1584c = new AnonymousClass1(this);
            this.f1585d = new Handler(Looper.myLooper());
        }

        @Override // androidx.dynamicanimation.animation.a.c
        void a() {
            long r0 = Math.max(10 - (SystemClock.uptimeMillis() - this.f1583b), 0);
            this.f1585d.postDelayed(this.f1584c, r0);
        }
    }

    /* JADX INFO: compiled from: AnimationHandler.java */
    private static class e extends c {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Choreographer f1587b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final Choreographer.FrameCallback f1588c;

        e(C0047a r1) {
            super(r1);
            this.f1587b = Choreographer.getInstance();
            this.f1588c = new AnimationHandler$FrameCallbackProvider16$1(this);
        }

        @Override // androidx.dynamicanimation.animation.a.c
        void a() {
            this.f1587b.postFrameCallback(this.f1588c);
        }
    }

    a() {
        this.f1579d = new g();
        this.f1577b = new ArrayList();
        this.f1580e = new C0047a(this);
        this.f1578c = 0;
        this.g = false;
    }

    static {
        f1576a = new ThreadLocal();
    }

    public static a a() {
        ThreadLocal<a> r0 = f1576a;
        if (r0.get() != null) goto L6;
        r0.set(new a());
    L6:
        return (a) ZeusTransformUtils.preCheckCast(r0.get(), a.class, "com.obric.aiagent.plugin");
    }

    c b() {
        if (this.f != null) goto L9;
        if (Build.VERSION.SDK_INT < 16) goto L7;
        this.f = new e(this.f1580e);
        goto L9
    L7:
        this.f = new d(this.f1580e);
    L9:
        return this.f;
    }

    public void a(b r3, long r4) {
        b r5 = (b) ZeusTransformUtils.wrapperContextForParams(r3, b.class, "com.obric.aiagent.plugin");
        if (this.f1577b.size() != 0) goto L6;
        b().a();
    L6:
        if (this.f1577b.contains(r5) == true) goto L9;
        this.f1577b.add(r5);
    L9:
        if (r4 <= 0) goto L12;
        this.f1579d.put(r5, Long.valueOf(SystemClock.uptimeMillis() + r4));
        return;
    }

    public void a(b r3) {
        b r4 = (b) ZeusTransformUtils.wrapperContextForParams(r3, b.class, "com.obric.aiagent.plugin");
        this.f1579d.remove(r4);
        int r5 = this.f1577b.indexOf(r4);
        if (r5 < 0) goto L6;
        this.f1577b.set(r5, null);
        this.g = true;
        return;
    }

    void a(long r7) {
        long r0 = SystemClock.uptimeMillis();
        int r2 = 0;
    L4:
        if (r2 >= this.f1577b.size()) goto L12;
        b r3 = (b) ZeusTransformUtils.preCheckCast(this.f1577b.get(r2), b.class, "com.obric.aiagent.plugin");
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
        Long r0 = (Long) ZeusTransformUtils.preCheckCast(this.f1579d.get(r7), Long.class, "com.obric.aiagent.plugin");
        if (r0 != null) goto L6;
        return true;
    L6:
        if (r0.longValue() >= r6) goto L9;
        this.f1579d.remove(r7);
        return true;
    L9:
        return false;
    }

    private void c() {
        if (this.g == false) goto L15;
        int r0 = this.f1577b.size() - 1;
    L5:
        if (r0 < 0) goto L10;
        if (this.f1577b.get(r0) != null) goto L9;
        this.f1577b.remove(r0);
    L9:
        r0 = r0 - 1;
        goto L5
    L10:
        this.g = false;
        return;
    }
}
