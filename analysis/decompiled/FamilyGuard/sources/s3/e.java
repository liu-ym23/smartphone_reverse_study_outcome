package s3;

import P.e;
import V3.v;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import i4.InterfaceC0772l;
import s3.e;

/* loaded from: classes.dex */
public final class e {

    /* renamed from: u, reason: collision with root package name */
    private static final a f20246u = new a(null);

    /* renamed from: a, reason: collision with root package name */
    private final View f20247a;

    /* renamed from: b, reason: collision with root package name */
    private int f20248b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f20249c;

    /* renamed from: d, reason: collision with root package name */
    private float f20250d;

    /* renamed from: e, reason: collision with root package name */
    private float f20251e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f20252f;

    /* renamed from: g, reason: collision with root package name */
    private float f20253g;

    /* renamed from: h, reason: collision with root package name */
    private float f20254h;

    /* renamed from: i, reason: collision with root package name */
    private long f20255i;

    /* renamed from: j, reason: collision with root package name */
    private float f20256j;

    /* renamed from: k, reason: collision with root package name */
    private float f20257k;

    /* renamed from: l, reason: collision with root package name */
    private float f20258l;

    /* renamed from: m, reason: collision with root package name */
    private float f20259m;

    /* renamed from: n, reason: collision with root package name */
    private float f20260n;

    /* renamed from: o, reason: collision with root package name */
    private final P.g f20261o;

    /* renamed from: p, reason: collision with root package name */
    private final P.g f20262p;

    /* renamed from: q, reason: collision with root package name */
    private final P.g f20263q;

    /* renamed from: r, reason: collision with root package name */
    private final P.i f20264r;

    /* renamed from: s, reason: collision with root package name */
    private final P.i f20265s;

    /* renamed from: t, reason: collision with root package name */
    private final P.i f20266t;

    /* JADX INFO: Access modifiers changed from: private */
    static final class a {
        public /* synthetic */ a(j4.g gVar) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final float d(float f5, float f6) {
            if (f6 <= 0.0f) {
                return 0.0f;
            }
            float fG = kotlin.ranges.l.g(f5 / f6, 0.0f, 1.0f);
            return fG * fG * (3.0f - (fG * 2.0f));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final P.i e(P.g gVar, float f5, float f6, float f7, final InterfaceC0772l<? super Float, v> interfaceC0772l) {
            P.i iVar = new P.i(gVar);
            iVar.x(new P.j(0.0f).h(f5).f(f6));
            iVar.k(f7);
            iVar.c(new e.r() { // from class: s3.d
                @Override // P.e.r
                public final void a(P.e eVar, float f8, float f9) {
                    e.a.f(interfaceC0772l, eVar, f8, f9);
                }
            });
            return iVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void f(InterfaceC0772l interfaceC0772l, P.e eVar, float f5, float f6) {
            interfaceC0772l.invoke(Float.valueOf(f5));
        }

        private a() {
        }
    }

    public e(View view) {
        j4.k.g(view, "view");
        this.f20247a = view;
        this.f20248b = -1;
        P.g gVar = new P.g(0.0f);
        this.f20261o = gVar;
        P.g gVar2 = new P.g(0.0f);
        this.f20262p = gVar2;
        P.g gVar3 = new P.g(0.0f);
        this.f20263q = gVar3;
        a aVar = f20246u;
        this.f20264r = aVar.e(gVar, 320.0f, 0.5f, 0.001f, new InterfaceC0772l() { // from class: s3.a
            @Override // i4.InterfaceC0772l
            public final Object invoke(Object obj) {
                return e.l(this.f20242a, ((Float) obj).floatValue());
            }
        });
        this.f20265s = aVar.e(gVar2, 300.0f, 0.5f, 0.5f, new InterfaceC0772l() { // from class: s3.b
            @Override // i4.InterfaceC0772l
            public final Object invoke(Object obj) {
                return e.g(this.f20243a, ((Float) obj).floatValue());
            }
        });
        this.f20266t = aVar.e(gVar3, 300.0f, 0.5f, 0.5f, new InterfaceC0772l() { // from class: s3.c
            @Override // i4.InterfaceC0772l
            public final Object invoke(Object obj) {
                return e.h(this.f20244a, ((Float) obj).floatValue());
            }
        });
    }

    private final void e() {
        if (this.f20247a.getWidth() <= 0 || this.f20247a.getHeight() <= 0) {
            return;
        }
        if (!this.f20249c && Math.abs(this.f20258l) < 5.0E-4f && Math.abs(this.f20259m) < 0.05f && Math.abs(this.f20260n) < 0.05f) {
            this.f20247a.setScaleX(1.0f);
            this.f20247a.setScaleY(1.0f);
            this.f20247a.setTranslationX(0.0f);
            this.f20247a.setTranslationY(0.0f);
            return;
        }
        float f5 = this.f20247a.getResources().getDisplayMetrics().density;
        float f6 = 60.0f * f5;
        float f7 = f5 * 40.0f;
        float f8 = (this.f20258l * 0.049999952f) + 1.0f;
        a aVar = f20246u;
        float fD = aVar.d(Math.abs(this.f20259m), f6) * 0.3f;
        float fD2 = aVar.d(Math.abs(this.f20260n), f6) * 0.3f;
        this.f20247a.setPivotX(r5.getWidth() / 2.0f);
        this.f20247a.setPivotY(r5.getHeight() / 2.0f);
        this.f20247a.setScaleX((fD + 1.0f) * f8 * (1.0f - (fD2 * 0.8f)));
        this.f20247a.setScaleY(f8 * (fD2 + 1.0f) * (1.0f - (fD * 0.8f)));
        float fHypot = (float) Math.hypot(this.f20259m, this.f20260n);
        if (fHypot < 1.0E-4f || f7 <= 0.0f) {
            this.f20247a.setTranslationX(0.0f);
            this.f20247a.setTranslationY(0.0f);
        } else {
            float fExp = f7 * (1.0f - ((float) Math.exp((-fHypot) / f7)));
            this.f20247a.setTranslationX((this.f20259m / fHypot) * fExp);
            this.f20247a.setTranslationY((this.f20260n / fHypot) * fExp);
        }
    }

    private final void f(MotionEvent motionEvent) {
        this.f20248b = motionEvent.getPointerId(0);
        this.f20249c = true;
        this.f20250d = motionEvent.getRawX();
        this.f20251e = motionEvent.getRawY();
        this.f20252f = false;
        this.f20255i = motionEvent.getEventTime();
        this.f20256j = 0.0f;
        this.f20257k = 0.0f;
        ViewParent parent = this.f20247a.getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(true);
        }
        this.f20265s.d();
        this.f20266t.d();
        this.f20261o.b(this.f20258l);
        this.f20264r.s(1.0f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final v g(e eVar, float f5) {
        eVar.f20259m = f5;
        eVar.e();
        return v.f5542a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final v h(e eVar, float f5) {
        eVar.f20260n = f5;
        eVar.e();
        return v.f5542a;
    }

    private final void i() {
        if (this.f20249c || this.f20248b != -1) {
            this.f20249c = false;
            this.f20252f = false;
            this.f20248b = -1;
            ViewParent parent = this.f20247a.getParent();
            if (parent != null) {
                parent.requestDisallowInterceptTouchEvent(false);
            }
            this.f20261o.b(this.f20258l);
            this.f20264r.s(0.0f);
            n(this.f20265s, this.f20262p, this.f20259m, this.f20256j);
            n(this.f20266t, this.f20263q, this.f20260n, this.f20257k);
            this.f20256j = 0.0f;
            this.f20257k = 0.0f;
        }
    }

    private final void j(MotionEvent motionEvent) {
        int iFindPointerIndex;
        if (this.f20249c && (iFindPointerIndex = motionEvent.findPointerIndex(this.f20248b)) >= 0) {
            float rawX = (motionEvent.getRawX(iFindPointerIndex) - this.f20250d) * 0.1f;
            float rawY = (motionEvent.getRawY(iFindPointerIndex) - this.f20251e) * 0.1f;
            if (this.f20252f) {
                float fC = kotlin.ranges.l.c(motionEvent.getEventTime() - this.f20255i, 1L) / 1000.0f;
                this.f20256j = (rawX - this.f20253g) / fC;
                this.f20257k = (rawY - this.f20254h) / fC;
            } else {
                this.f20252f = true;
                this.f20256j = 0.0f;
                this.f20257k = 0.0f;
            }
            this.f20253g = rawX;
            this.f20254h = rawY;
            this.f20255i = motionEvent.getEventTime();
            this.f20265s.d();
            this.f20266t.d();
            this.f20259m = rawX;
            this.f20260n = rawY;
            this.f20262p.b(rawX);
            this.f20263q.b(rawY);
            e();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final v l(e eVar, float f5) {
        eVar.f20258l = f5;
        eVar.e();
        return v.f5542a;
    }

    private final void n(P.i iVar, P.g gVar, float f5, float f6) {
        iVar.d();
        gVar.b(f5);
        iVar.n(f6 * 0.45f);
        iVar.s(0.0f);
    }

    public final void d() {
        ViewParent parent = this.f20247a.getParent();
        for (int i5 = 0; (parent instanceof ViewGroup) && i5 < 2; i5++) {
            ViewGroup viewGroup = (ViewGroup) parent;
            viewGroup.setClipChildren(false);
            viewGroup.setClipToPadding(false);
            parent = viewGroup.getParent();
        }
    }

    public final void k(MotionEvent motionEvent) {
        j4.k.g(motionEvent, "event");
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            f(motionEvent);
            return;
        }
        if (actionMasked != 1) {
            if (actionMasked == 2) {
                j(motionEvent);
                return;
            } else if (actionMasked != 3) {
                if (actionMasked == 6 && motionEvent.getPointerId(motionEvent.getActionIndex()) == this.f20248b) {
                    i();
                    return;
                }
                return;
            }
        }
        i();
    }

    public final void m() {
        if (this.f20258l == 0.0f && this.f20259m == 0.0f && this.f20260n == 0.0f && !this.f20249c) {
            return;
        }
        e();
    }

    public final void o() {
        this.f20249c = false;
        this.f20252f = false;
        this.f20248b = -1;
        this.f20264r.d();
        this.f20265s.d();
        this.f20266t.d();
        this.f20258l = 0.0f;
        this.f20259m = 0.0f;
        this.f20260n = 0.0f;
        this.f20256j = 0.0f;
        this.f20257k = 0.0f;
        this.f20261o.b(0.0f);
        this.f20262p.b(0.0f);
        this.f20263q.b(0.0f);
        this.f20247a.setScaleX(1.0f);
        this.f20247a.setScaleY(1.0f);
        this.f20247a.setTranslationX(0.0f);
        this.f20247a.setTranslationY(0.0f);
    }
}
