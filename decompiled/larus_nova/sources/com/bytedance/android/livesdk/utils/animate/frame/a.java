package com.bytedance.android.livesdk.utils.animate.frame;

import android.view.Choreographer;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ChoreographerFrameCallbackC2429a f158866a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f158867b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f158868c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f158869d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f158870e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f158871f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public volatile boolean f158872g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f158873h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final int f158874i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final long f158875j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final long f158876k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final boolean f158877l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final int f158878m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final boolean f158879n;

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.utils.animate.frame.a$a, reason: collision with other inner class name */
    public static final class ChoreographerFrameCallbackC2429a implements Choreographer.FrameCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f158880a;

        public final String toString() {
            return "Scheduled " + this.f158880a;
        }

        public ChoreographerFrameCallbackC2429a(a r100) {
            this.f158880a = r100;
        }

        @Override // android.view.Choreographer.FrameCallback
        public final void doFrame(long r100) {
            a r101 = this.f158880a;
            boolean r102 = false;
            if (r101.f158870e == false) goto L5;
            r101.f158870e = false;
            r101.f158868c = System.currentTimeMillis() - r101.f158869d;
            ((ValueFrameAnimator.b) r101).f158862q.invoke();
            r101.c();
        L35:
            ChoreographerFrameCallbackC2429a r103 = this.f158880a.f158866a;
            if (r103 == null) goto L39;
            Choreographer.getInstance().postFrameCallback(r103);
            return;
        L39:
            return;
        L5:
            double r104 = System.currentTimeMillis() - r101.f158868c;
            if (r104 < 0) goto L35;
            int r105 = r101.f158874i;
            long r106 = (long) ((r104 * ((double) r105)) / r101.f158875j);
            if (r101.f158877l == false) goto L27;
            if (r106 != r101.f158867b) goto L13;
        L25:
            r106 = r106 % ((long) r101.f158874i);
            goto L27
        L13:
            if (r106 < (r105 + (r101.f158871f * r105))) goto L25;
            Function0<Unit> r107 = ((ValueFrameAnimator.b) r101).f158864s;
            if (r107 == null) goto L17;
            Unit r108 = r107.invoke();
        L17:
            int r109 = r101.f158871f;
            int r110 = r101.f158878m;
            if (r109 >= r110) goto L20;
        L24:
            r101.f158871f = r109 + 1;
            goto L25
        L20:
            if (r110 != (-1)) goto L22;
            r102 = true;
        L22:
            if (r102 == true) goto L24;
            r101.a();
        L27:
            if (r106 == r101.f158867b) goto L35;
            if (r101.f158877l == false) goto L32;
        L34:
            r101.f158867b = (int) r106;
            r101.c();
            goto L35
        L32:
            if (r106 < r101.f158874i) goto L34;
            r101.a();
            goto L35
        }
    }

    public final void a() {
        if (this.f158879n == false) goto L5;
        int r100 = this.f158874i;
    L6:
        ValueFrameAnimator.b r101 = (ValueFrameAnimator.b) this;
        float r102 = r100 / this.f158874i;
        r101.f158860o = r102;
        r101.f158861p.invoke(Float.valueOf(r102));
        ChoreographerFrameCallbackC2429a r103 = this.f158866a;
        if (r103 == null) goto L9;
        Choreographer.getInstance().removeFrameCallback(r103);
        this.f158866a = null;
    L9:
        r101.f158863r.invoke();
        return;
    L5:
        r100 = 0;
        goto L6
    }

    public final void b() {
        ChoreographerFrameCallbackC2429a r100 = this.f158866a;
        if (r100 == null) goto L5;
        boolean r101 = true;
    L6:
        if (r100 == null) goto L8;
        boolean r102 = true;
    L9:
        if (r102 == false) goto L14;
        this.f158869d = System.currentTimeMillis() - this.f158868c;
        this.f158870e = true;
        this.f158872g = true;
        ChoreographerFrameCallbackC2429a r103 = this.f158866a;
        if (r103 == null) goto L14;
        Choreographer.getInstance().removeFrameCallback(r103);
        this.f158866a = null;
    L14:
        this.f158867b = 0;
        this.f158869d = 0;
        this.f158870e = true;
        this.f158872g = false;
        this.f158871f = 0;
        if (r101 == false) goto L21;
        ValueFrameAnimator.b r104 = (ValueFrameAnimator.b) this;
        Function0<Unit> r105 = r104.f158865t;
        if (r105 == null) goto L19;
        Unit r106 = r105.invoke();
    L19:
        r104.f158863r.invoke();
        return;
    L21:
        return;
    L8:
        r102 = false;
        goto L9
    L5:
        r101 = false;
        goto L6
    }

    public final void c() {
        if (this.f158879n == false) goto L5;
        int r100 = this.f158867b;
    L6:
        ValueFrameAnimator.b r101 = (ValueFrameAnimator.b) this;
        float r102 = r100 / this.f158874i;
        r101.f158860o = r102;
        r101.f158861p.invoke(Float.valueOf(r102));
        return;
    L5:
        r100 = (this.f158874i - this.f158867b) - 1;
        goto L6
    }

    public final void d() {
        long r100 = 0;
        if (this.f158875j != 0) goto L6;
        this.f158867b = this.f158874i - 1;
        c();
        a();
        return;
    L6:
        if (this.f158866a != null) goto L13;
        this.f158866a = new ChoreographerFrameCallbackC2429a(this);
        if (this.f158870e == false) goto L10;
        r100 = this.f158876k;
    L10:
        Choreographer.getInstance().postFrameCallbackDelayed(this.f158866a, r100);
        return;
    }

    public final String toString() {
        ChoreographerFrameCallbackC2429a r100 = this.f158866a;
        StringBuilder r101 = new StringBuilder("FrameAnimator '");
        r101.append(this.f158873h);
        r101.append("' @");
        r101.append(System.identityHashCode(this));
        if (r100 != null) goto L5;
        String r102 = " (stopped)";
    L6:
        r101.append(r102);
        return r101.toString();
    L5:
        r102 = " (running " + this.f158867b + '/' + this.f158874i + " frame)";
        goto L6
    }

    public a(String r100, int r101, long r102, long r103, boolean r104, int r105) {
        Intrinsics.checkNotNullParameter(r100, "name");
        this.f158873h = r100;
        this.f158874i = r101;
        this.f158875j = r102;
        this.f158876k = r103;
        this.f158877l = r104;
        this.f158878m = r105;
        this.f158879n = true;
        this.f158867b = 0;
        this.f158869d = 0;
        this.f158870e = true;
        this.f158872g = false;
        this.f158871f = 0;
    }
}
