package ca2;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Matrix;
import android.graphics.RectF;
import ba2.e;
import com.bytedance.android.livesdk.interactivity.publicscreen.preview.ZoomableControllerImp;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Iterator;
import java.util.LinkedHashSet;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class c extends ZoomableControllerImp {
    public final Matrix A;
    public final float B;
    public final com.bytedance.android.livesdk.interactivity.publicscreen.preview.c C;
    public final b D;
    public long E;
    public boolean F;
    public boolean G;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final LinkedHashSet<ca2.a> f22924w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public int f22925x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final Matrix f22926y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public boolean f22927z;

    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ c f22928a;

        @Override // java.lang.Runnable
        public final void run() {
            Iterator<T> r100 = this.f22928a.f22924w.iterator();     // Catch: Throwable -> L7
        L4:
            if (r100.hasNext() == false) goto L16;
            ((ca2.a) r100.next()).onTransitionEnd(this.f22928a.f22925x);     // Catch: Throwable -> L7
            goto L4
        L16:
            return;
        L7:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L11;
            return;
        L11:
            throw th;
        }

        public a(c r100) {
            this.f22928a = r100;
        }
    }

    public static final class b implements ValueAnimator.AnimatorUpdateListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ c f22929a;

        public b(c r100) {
            this.f22929a = r100;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator r100) {
            Intrinsics.checkNotNullParameter(r100, "it");
            Object r101 = r100.getAnimatedValue();
            if (r101 == null) goto L10;
            float r102 = ((Float) r101).floatValue();
            Iterator<T> r103 = this.f22929a.f22924w.iterator();
        L6:
            if (r103.hasNext() == false) goto L8;
            ((ca2.a) r103.next()).onTransitionChanged(this.f22929a.f22925x, r102);
            goto L6
        L8:
            return;
        L10:
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");
        }
    }

    @Override // com.bytedance.android.livesdk.interactivity.publicscreen.preview.ZoomableControllerImp
    public final void f(e r100) {
        Intrinsics.checkNotNullParameter(r100, "detector");
        super.f(r100);
        if (this.f139327v == false) goto L5;
        return;
    L5:
        this.f22925x = -1;
        if ((this.f139332e.top - this.f139334g.top) <= 0.001f) goto L8;
        boolean r101 = true;
    L9:
        this.f22927z = !r101;
        return;
    L8:
        r101 = false;
        goto L9
    }

    @Override // com.bytedance.android.livesdk.interactivity.publicscreen.preview.ZoomableControllerImp
    public final void g(e r100) {
        Intrinsics.checkNotNullParameter(r100, "detector");
        if (this.f139327v == false) goto L5;
        return;
    L5:
        if (this.f139322q.isRunning() == false) goto L7;
    L10:
        boolean r101 = true;
    L11:
        if (r101 == false) goto L14;
        return;
    L14:
        if (this.F == false) goto L26;
        if (r100.f18409l != 4) goto L26;
        if (this.f22927z == false) goto L26;
        if (this.f22925x != (-1)) goto L26;
        this.f22925x = 3;
        this.A.set(this.f139335h);
        Iterator<T> r102 = this.f22924w.iterator();
    L23:
        if (r102.hasNext() == false) goto L26;
        ((ca2.a) r102.next()).onTransitionBegin(this.f22925x);
    L26:
        if (this.f22925x != 3) goto L38;
        Matrix r103 = this.f139335h;
        RectF r104 = this.f139333f;
        r103.set(this.A);
        float r105 = this.f139328a.f18403f;
        com.bytedance.android.livesdk.interactivity.publicscreen.preview.c r106 = this.C;
        float r107 = 1 - (r106.f139342d.f18403f / r106.f139339a);
        if (r107 <= 1.0f) goto L31;
        r107 = 1.0f;
    L33:
        r103.postScale(r107, r107, r104.centerX(), r104.centerY());
        Iterator<T> r108 = this.f22924w.iterator();
    L35:
        if (r108.hasNext() == false) goto L37;
        ca2.a r109 = (ca2.a) r108.next();
        int r110 = this.f22925x;
        com.bytedance.android.livesdk.interactivity.publicscreen.preview.c r111 = this.C;
        r109.onTransitionChanged(r110, r111.f139342d.f18403f / r111.f139339a);
        goto L35
    L37:
        r103.postTranslate(this.f139328a.f18402e, r105);
        a();
        return;
    L31:
        if (r107 >= 0.3f) goto L33;
        r107 = 0.3f;
        goto L33
    L38:
        super.g(r100);
        return;
    L7:
        if (this.f139325t.computeScrollOffset() == true) goto L10;
        r101 = false;
        goto L11
    }

    public final void k(boolean r100) {
        this.f22925x = 2;
        this.f139327v = true;
        this.f22926y.set(this.f139335h);
        if (r100 == false) goto L5;
        this.f22926y.postTranslate(this.f139333f.centerX() - this.f139334g.centerX(), this.f139333f.centerY() - this.f139334g.centerY());
        Matrix r101 = this.f22926y;
        float r102 = this.B;
        r101.postScale(r102, r102, this.f139333f.centerX(), this.f139333f.centerY());
    L6:
        Iterator<T> r103 = this.f22924w.iterator();
    L8:
        if (r103.hasNext() == false) goto L10;
        ((ca2.a) r103.next()).onTransitionBegin(this.f22925x);
        goto L8
    L10:
        i(this.f22926y, this.E, new a(this), this.D);
        return;
    L5:
        Matrix r104 = this.f22926y;
        float r105 = this.B;
        r104.postScale(r105, r105, this.f139334g.centerX(), this.f139334g.centerY());
        goto L6
    }

    public final void l(e r100) {
        Intrinsics.checkNotNullParameter(r100, "detector");
        if (this.f139327v == false) goto L6;
        return;
    L6:
        if (this.f22925x != 3) goto L25;
        Iterator<T> r101 = this.f22924w.iterator();
    L9:
        if (r101.hasNext() == false) goto L11;
        ((ca2.a) r101.next()).onTransitionEnd(this.f22925x);
        goto L9
    L11:
        com.bytedance.android.livesdk.interactivity.publicscreen.preview.c r102 = this.C;
        if ((r102.f139342d.f18403f / r102.f139339a) <= r102.f139340b) goto L14;
        boolean r103 = true;
    L15:
        if (r103 == false) goto L17;
        k(false);
        return;
    L17:
        this.f22925x = 1;
        this.f139327v = true;
        this.f22926y.set(this.A);
        Iterator<T> r104 = this.f22924w.iterator();
    L19:
        if (r104.hasNext() == false) goto L21;
        ((ca2.a) r104.next()).onTransitionBegin(this.f22925x);
        goto L19
    L21:
        i(this.f22926y, this.E, new d(this), this.D);
        return;
    L14:
        r103 = false;
        goto L15
    }

    @Override // ba2.b
    public final /* bridge */ /* synthetic */ void onGestureEnd(e r100) {
        l(r100);
    }

    public c(e r100, Context r101) {
        Intrinsics.checkNotNullParameter(r100, "transformGestureDetector");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
        this.f22924w = new LinkedHashSet();
        this.f22925x = -1;
        this.f22926y = new Matrix();
        this.f22927z = true;
        this.A = new Matrix();
        this.B = 1.0f;
        this.C = new com.bytedance.android.livesdk.interactivity.publicscreen.preview.c(r101, r100);
        this.D = new b(this);
        this.F = true;
        this.G = true;
    }
}
