package r3;

import M2.C0374k;
import M2.C0378o;
import V3.n;
import W3.C0403n;
import W3.K;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Trace;
import android.util.Log;
import android.view.View;
import i4.InterfaceC0772l;
import java.util.List;
import java.util.Set;

/* renamed from: r3.e, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C1009e {

    /* renamed from: i, reason: collision with root package name */
    public static final a f20010i = new a(null);

    /* renamed from: j, reason: collision with root package name */
    private static int f20011j;

    /* renamed from: k, reason: collision with root package name */
    private static long f20012k;

    /* renamed from: a, reason: collision with root package name */
    private final View f20013a;

    /* renamed from: b, reason: collision with root package name */
    private K2.D f20014b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f20015c;

    /* renamed from: d, reason: collision with root package name */
    private final Paint f20016d;

    /* renamed from: e, reason: collision with root package name */
    private final Runnable f20017e;

    /* renamed from: f, reason: collision with root package name */
    private final b f20018f;

    /* renamed from: g, reason: collision with root package name */
    private boolean f20019g;

    /* renamed from: h, reason: collision with root package name */
    private Set<String> f20020h;

    /* renamed from: r3.e$a */
    public static final class a {
        public /* synthetic */ a(j4.g gVar) {
            this();
        }

        private a() {
        }
    }

    /* renamed from: r3.e$b */
    public static final class b implements View.OnAttachStateChangeListener {
        b() {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
            j4.k.g(view, "v");
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
            j4.k.g(view, "v");
            C1009e.this.m();
        }
    }

    public C1009e(View view) {
        j4.k.g(view, "view");
        this.f20013a = view;
        Paint paint = new Paint(1);
        paint.setStyle(Paint.Style.FILL);
        this.f20016d = paint;
        this.f20017e = new Runnable() { // from class: r3.b
            @Override // java.lang.Runnable
            public final void run() {
                C1009e.n(this.f20005a);
            }
        };
        b bVar = new b();
        this.f20018f = bVar;
        view.addOnAttachStateChangeListener(bVar);
        this.f20020h = K.b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final V3.v f(float f5, int i5, int i6, C0378o c0378o) {
        j4.k.g(c0378o, "$this$apply");
        c0378o.n(f5);
        if (1 <= i5 && i5 < 255) {
            c0378o.o(i6);
        }
        return V3.v.f5542a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final V3.v g(int i5, C0374k c0374k) {
        j4.k.g(c0374k, "$this$apply");
        c0374k.f(C0403n.b(V3.r.a(1, Integer.valueOf(i5))));
        return V3.v.f5542a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n(C1009e c1009e) {
        if (c1009e.f20015c) {
            c1009e.f20015c = false;
            c1009e.f20013a.invalidate();
        }
    }

    public final boolean d(int i5, float f5, K2.o oVar) {
        Object objA;
        Set<String> setB;
        List<String> listC;
        j4.k.g(oVar, "effect");
        s3.k kVar = s3.k.f20291a;
        Trace.beginSection("StepOS:GlassDelegate.apply");
        try {
            m();
            try {
                n.a aVar = V3.n.f5531a;
                K2.A aS = K2.G.a(J2.e.f3219a, this.f20013a).t(i5 == 1).s(f5);
                InterfaceC1005a interfaceC1005aQ = C1003H.f20004a.Q(oVar, this.f20013a.getResources().getDisplayMetrics().density);
                objA = V3.n.a((interfaceC1005aQ != null ? interfaceC1005aQ.a(aS) : aS.h(oVar)).q());
            } catch (Throwable th) {
                n.a aVar2 = V3.n.f5531a;
                objA = V3.n.a(V3.o.a(th));
            }
            Throwable thB = V3.n.b(objA);
            if (thB != null) {
                Log.w("StepOSGlass", "glass commit failed on " + this.f20013a.getClass().getSimpleName(), thB);
                objA = null;
            }
            K2.D d6 = (K2.D) objA;
            this.f20014b = d6;
            this.f20019g = (d6 != null ? d6.b() : 0) > 0;
            if (d6 == null || (listC = d6.c()) == null || (setB = C0403n.X(listC)) == null) {
                setB = K.b();
            }
            this.f20020h = setB;
            String simpleName = this.f20013a.getClass().getSimpleName();
            int iIdentityHashCode = System.identityHashCode(this.f20013a);
            boolean z5 = this.f20019g;
            int iB = d6 != null ? d6.b() : 0;
            Log.i("StepOSGlass", "commit " + simpleName + "#" + iIdentityHashCode + " active=" + z5 + " count=" + iB + " ids=" + this.f20020h + " live=" + f20011j + " size=" + this.f20013a.getWidth() + "x" + this.f20013a.getHeight());
            if (d6 != null) {
                f20011j++;
                s3.k kVar2 = s3.k.f20291a;
                kVar2.a("glass.liveHandles", f20011j);
                long j5 = f20012k + 1;
                f20012k = j5;
                kVar2.a("glass.applyCount", j5);
            }
            if (!this.f20019g) {
                Log.i("StepOSGlass", "glass inactive on " + this.f20013a.getClass().getSimpleName() + "（scope=" + i5 + "）—— 已降级，改用兜底背景。排障见 MotionKit 文档第 5、6 章");
            }
            return this.f20019g;
        } finally {
            Trace.endSection();
        }
    }

    public final boolean e(int i5, float f5, final float f6, final int i6) {
        Object objA;
        Set<String> setB;
        List<String> listC;
        s3.k kVar = s3.k.f20291a;
        Trace.beginSection("StepOS:GlassDelegate.apply");
        try {
            m();
            try {
                n.a aVar = V3.n.f5531a;
                K2.A aS = K2.G.a(J2.e.f3219a, this.f20013a).t(i5 == 1).s(f5);
                final int iAlpha = Color.alpha(i6);
                K2.F f7 = K2.F.f3603a;
                K2.A aI = aS.i(f7.b(), new InterfaceC0772l() { // from class: r3.c
                    @Override // i4.InterfaceC0772l
                    public final Object invoke(Object obj) {
                        return C1009e.f(f6, iAlpha, i6, (C0378o) obj);
                    }
                });
                if (iAlpha == 255) {
                    aI = aI.i(f7.a(), new InterfaceC0772l() { // from class: r3.d
                        @Override // i4.InterfaceC0772l
                        public final Object invoke(Object obj) {
                            return C1009e.g(i6, (C0374k) obj);
                        }
                    });
                }
                objA = V3.n.a(aI.q());
            } catch (Throwable th) {
                n.a aVar2 = V3.n.f5531a;
                objA = V3.n.a(V3.o.a(th));
            }
            Throwable thB = V3.n.b(objA);
            if (thB != null) {
                Log.w("StepOSGlass", "glass commit failed on " + this.f20013a.getClass().getSimpleName(), thB);
                objA = null;
            }
            K2.D d6 = (K2.D) objA;
            this.f20014b = d6;
            this.f20019g = (d6 != null ? d6.b() : 0) > 0;
            if (d6 == null || (listC = d6.c()) == null || (setB = C0403n.X(listC)) == null) {
                setB = K.b();
            }
            this.f20020h = setB;
            String simpleName = this.f20013a.getClass().getSimpleName();
            int iIdentityHashCode = System.identityHashCode(this.f20013a);
            boolean z5 = this.f20019g;
            int iB = d6 != null ? d6.b() : 0;
            Log.i("StepOSGlass", "commit " + simpleName + "#" + iIdentityHashCode + " active=" + z5 + " count=" + iB + " ids=" + this.f20020h + " live=" + f20011j + " size=" + this.f20013a.getWidth() + "x" + this.f20013a.getHeight());
            if (d6 != null) {
                f20011j++;
                s3.k kVar2 = s3.k.f20291a;
                kVar2.a("glass.liveHandles", f20011j);
                long j5 = f20012k + 1;
                f20012k = j5;
                kVar2.a("glass.applyCount", j5);
            }
            if (!this.f20019g) {
                Log.i("StepOSGlass", "glass inactive on " + this.f20013a.getClass().getSimpleName() + "（scope=" + i5 + "）—— 已降级，改用兜底背景。排障见 MotionKit 文档第 5、6 章");
            }
            return this.f20019g;
        } finally {
            Trace.endSection();
        }
    }

    public final boolean h(int i5, float f5, InterfaceC0772l<? super K2.A, K2.A> interfaceC0772l) {
        Object objA;
        Set<String> setB;
        List<String> listC;
        j4.k.g(interfaceC0772l, "applyEffect");
        s3.k kVar = s3.k.f20291a;
        Trace.beginSection("StepOS:GlassDelegate.apply");
        try {
            m();
            try {
                n.a aVar = V3.n.f5531a;
                objA = V3.n.a(interfaceC0772l.invoke(K2.G.a(J2.e.f3219a, this.f20013a).t(i5 == 1).s(f5)).q());
            } catch (Throwable th) {
                n.a aVar2 = V3.n.f5531a;
                objA = V3.n.a(V3.o.a(th));
            }
            Throwable thB = V3.n.b(objA);
            if (thB != null) {
                Log.w("StepOSGlass", "glass commit failed on " + this.f20013a.getClass().getSimpleName(), thB);
                objA = null;
            }
            K2.D d6 = (K2.D) objA;
            this.f20014b = d6;
            this.f20019g = (d6 != null ? d6.b() : 0) > 0;
            if (d6 == null || (listC = d6.c()) == null || (setB = C0403n.X(listC)) == null) {
                setB = K.b();
            }
            this.f20020h = setB;
            String simpleName = this.f20013a.getClass().getSimpleName();
            int iIdentityHashCode = System.identityHashCode(this.f20013a);
            boolean z5 = this.f20019g;
            int iB = d6 != null ? d6.b() : 0;
            Log.i("StepOSGlass", "commit " + simpleName + "#" + iIdentityHashCode + " active=" + z5 + " count=" + iB + " ids=" + this.f20020h + " live=" + f20011j + " size=" + this.f20013a.getWidth() + "x" + this.f20013a.getHeight());
            if (d6 != null) {
                f20011j++;
                s3.k kVar2 = s3.k.f20291a;
                kVar2.a("glass.liveHandles", f20011j);
                long j5 = f20012k + 1;
                f20012k = j5;
                kVar2.a("glass.applyCount", j5);
            }
            if (!this.f20019g) {
                Log.i("StepOSGlass", "glass inactive on " + this.f20013a.getClass().getSimpleName() + "（scope=" + i5 + "）—— 已降级，改用兜底背景。排障见 MotionKit 文档第 5、6 章");
            }
            return this.f20019g;
        } finally {
            Trace.endSection();
        }
    }

    public final void i() {
        this.f20015c = false;
        this.f20013a.removeCallbacks(this.f20017e);
    }

    public final Set<String> j() {
        return this.f20020h;
    }

    public final boolean k() {
        return this.f20014b != null;
    }

    public final boolean l() {
        return this.f20019g;
    }

    public final void m() {
        K2.D d6 = this.f20014b;
        if (d6 == null) {
            this.f20019g = false;
            this.f20020h = K.b();
            return;
        }
        s3.k kVar = s3.k.f20291a;
        Trace.beginSection("StepOS:GlassDelegate.release");
        try {
            Log.i("StepOSGlass", "release " + this.f20013a.getClass().getSimpleName() + "#" + System.identityHashCode(this.f20013a) + " live=" + f20011j + " size=" + this.f20013a.getWidth() + "x" + this.f20013a.getHeight());
            try {
                n.a aVar = V3.n.f5531a;
                d6.d();
                V3.n.a(V3.v.f5542a);
            } catch (Throwable th) {
                n.a aVar2 = V3.n.f5531a;
                V3.n.a(V3.o.a(th));
            }
            this.f20014b = null;
            this.f20019g = false;
            this.f20020h = K.b();
            f20011j--;
            s3.k.f20291a.a("glass.liveHandles", f20011j);
            V3.v vVar = V3.v.f5542a;
        } finally {
            Trace.endSection();
        }
    }
}
