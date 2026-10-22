package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.util.Xml;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnimationUtils;
import android.view.animation.AnticipateInterpolator;
import android.view.animation.BounceInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.OvershootInterpolator;
import androidx.constraintlayout.motion.widget.q;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.R$id;
import androidx.constraintlayout.widget.R$styleable;
import androidx.constraintlayout.widget.c;
import java.util.ArrayList;
import java.util.Iterator;
import m0.C4890c;
import m0.C4891d;
import org.xmlpull.v1.XmlPullParser;

/* loaded from: classes.dex */
public class t {

    /* renamed from: a, reason: collision with root package name */
    public int f12513a;

    /* renamed from: e, reason: collision with root package name */
    public int f12517e;

    /* renamed from: f, reason: collision with root package name */
    public g f12518f;

    /* renamed from: g, reason: collision with root package name */
    public c.a f12519g;

    /* renamed from: j, reason: collision with root package name */
    public int f12522j;

    /* renamed from: k, reason: collision with root package name */
    public String f12523k;

    /* renamed from: o, reason: collision with root package name */
    public Context f12527o;

    /* renamed from: b, reason: collision with root package name */
    public int f12514b = -1;

    /* renamed from: c, reason: collision with root package name */
    public boolean f12515c = false;

    /* renamed from: d, reason: collision with root package name */
    public int f12516d = 0;

    /* renamed from: h, reason: collision with root package name */
    public int f12520h = -1;

    /* renamed from: i, reason: collision with root package name */
    public int f12521i = -1;

    /* renamed from: l, reason: collision with root package name */
    public int f12524l = 0;

    /* renamed from: m, reason: collision with root package name */
    public String f12525m = null;

    /* renamed from: n, reason: collision with root package name */
    public int f12526n = -1;

    /* renamed from: p, reason: collision with root package name */
    public int f12528p = -1;

    /* renamed from: q, reason: collision with root package name */
    public int f12529q = -1;

    /* renamed from: r, reason: collision with root package name */
    public int f12530r = -1;

    /* renamed from: s, reason: collision with root package name */
    public int f12531s = -1;

    /* renamed from: t, reason: collision with root package name */
    public int f12532t = -1;

    /* renamed from: u, reason: collision with root package name */
    public int f12533u = -1;

    /* renamed from: v, reason: collision with root package name */
    public int f12534v = -1;

    public class a implements Interpolator {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ C4890c f12535a;

        public a(C4890c c4890c) {
            this.f12535a = c4890c;
        }

        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f10) {
            return (float) this.f12535a.a(f10);
        }
    }

    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public final int f12537a;

        /* renamed from: b, reason: collision with root package name */
        public final int f12538b;

        /* renamed from: c, reason: collision with root package name */
        public long f12539c;

        /* renamed from: d, reason: collision with root package name */
        public m f12540d;

        /* renamed from: e, reason: collision with root package name */
        public int f12541e;

        /* renamed from: f, reason: collision with root package name */
        public int f12542f;

        /* renamed from: h, reason: collision with root package name */
        public u f12544h;

        /* renamed from: i, reason: collision with root package name */
        public Interpolator f12545i;

        /* renamed from: k, reason: collision with root package name */
        public float f12547k;

        /* renamed from: l, reason: collision with root package name */
        public float f12548l;

        /* renamed from: m, reason: collision with root package name */
        public long f12549m;

        /* renamed from: o, reason: collision with root package name */
        public boolean f12551o;

        /* renamed from: g, reason: collision with root package name */
        public C4891d f12543g = new C4891d();

        /* renamed from: j, reason: collision with root package name */
        public boolean f12546j = false;

        /* renamed from: n, reason: collision with root package name */
        public Rect f12550n = new Rect();

        public b(u uVar, m mVar, int i10, int i11, int i12, Interpolator interpolator, int i13, int i14) {
            this.f12551o = false;
            this.f12544h = uVar;
            this.f12540d = mVar;
            this.f12541e = i10;
            this.f12542f = i11;
            long jNanoTime = System.nanoTime();
            this.f12539c = jNanoTime;
            this.f12549m = jNanoTime;
            this.f12544h.b(this);
            this.f12545i = interpolator;
            this.f12537a = i13;
            this.f12538b = i14;
            if (i12 == 3) {
                this.f12551o = true;
            }
            this.f12548l = i10 == 0 ? Float.MAX_VALUE : 1.0f / i10;
            a();
        }

        public void a() {
            if (this.f12546j) {
                c();
            } else {
                b();
            }
        }

        public void b() {
            long jNanoTime = System.nanoTime();
            long j10 = jNanoTime - this.f12549m;
            this.f12549m = jNanoTime;
            float f10 = this.f12547k + (((float) (j10 * 1.0E-6d)) * this.f12548l);
            this.f12547k = f10;
            if (f10 >= 1.0f) {
                this.f12547k = 1.0f;
            }
            Interpolator interpolator = this.f12545i;
            float interpolation = interpolator == null ? this.f12547k : interpolator.getInterpolation(this.f12547k);
            m mVar = this.f12540d;
            boolean zU = mVar.u(mVar.f12382b, interpolation, jNanoTime, this.f12543g);
            if (this.f12547k >= 1.0f) {
                if (this.f12537a != -1) {
                    this.f12540d.s().setTag(this.f12537a, Long.valueOf(System.nanoTime()));
                }
                if (this.f12538b != -1) {
                    this.f12540d.s().setTag(this.f12538b, null);
                }
                if (!this.f12551o) {
                    this.f12544h.f(this);
                }
            }
            if (this.f12547k < 1.0f || zU) {
                this.f12544h.d();
            }
        }

        public void c() {
            long jNanoTime = System.nanoTime();
            long j10 = jNanoTime - this.f12549m;
            this.f12549m = jNanoTime;
            float f10 = this.f12547k - (((float) (j10 * 1.0E-6d)) * this.f12548l);
            this.f12547k = f10;
            if (f10 < 0.0f) {
                this.f12547k = 0.0f;
            }
            Interpolator interpolator = this.f12545i;
            float interpolation = interpolator == null ? this.f12547k : interpolator.getInterpolation(this.f12547k);
            m mVar = this.f12540d;
            boolean zU = mVar.u(mVar.f12382b, interpolation, jNanoTime, this.f12543g);
            if (this.f12547k <= 0.0f) {
                if (this.f12537a != -1) {
                    this.f12540d.s().setTag(this.f12537a, Long.valueOf(System.nanoTime()));
                }
                if (this.f12538b != -1) {
                    this.f12540d.s().setTag(this.f12538b, null);
                }
                this.f12544h.f(this);
            }
            if (this.f12547k > 0.0f || zU) {
                this.f12544h.d();
            }
        }

        public void d(int i10, float f10, float f11) {
            if (i10 == 1) {
                if (this.f12546j) {
                    return;
                }
                e(true);
            } else {
                if (i10 != 2) {
                    return;
                }
                this.f12540d.s().getHitRect(this.f12550n);
                if (this.f12550n.contains((int) f10, (int) f11) || this.f12546j) {
                    return;
                }
                e(true);
            }
        }

        public void e(boolean z10) {
            int i10;
            this.f12546j = z10;
            if (z10 && (i10 = this.f12542f) != -1) {
                this.f12548l = i10 == 0 ? Float.MAX_VALUE : 1.0f / i10;
            }
            this.f12544h.d();
            this.f12549m = System.nanoTime();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x0088  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public t(android.content.Context r11, org.xmlpull.v1.XmlPullParser r12) throws org.xmlpull.v1.XmlPullParserException, java.io.IOException {
        /*
            Method dump skipped, instructions count: 262
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.motion.widget.t.<init>(android.content.Context, org.xmlpull.v1.XmlPullParser):void");
    }

    public static /* synthetic */ void a(t tVar, View[] viewArr) {
        if (tVar.f12528p != -1) {
            for (View view : viewArr) {
                view.setTag(tVar.f12528p, Long.valueOf(System.nanoTime()));
            }
        }
        if (tVar.f12529q != -1) {
            for (View view2 : viewArr) {
                view2.setTag(tVar.f12529q, null);
            }
        }
    }

    public void b(u uVar, MotionLayout motionLayout, View view) {
        m mVar = new m(view);
        mVar.y(view);
        this.f12518f.a(mVar);
        mVar.F(motionLayout.getWidth(), motionLayout.getHeight(), this.f12520h, System.nanoTime());
        new b(uVar, mVar, this.f12520h, this.f12521i, this.f12514b, f(motionLayout.getContext()), this.f12528p, this.f12529q);
    }

    public void c(u uVar, MotionLayout motionLayout, int i10, androidx.constraintlayout.widget.c cVar, final View... viewArr) {
        if (this.f12515c) {
            return;
        }
        int i11 = this.f12517e;
        if (i11 == 2) {
            b(uVar, motionLayout, viewArr[0]);
            return;
        }
        if (i11 == 1) {
            for (int i12 : motionLayout.getConstraintSetIds()) {
                if (i12 != i10) {
                    androidx.constraintlayout.widget.c cVarN = motionLayout.N(i12);
                    for (View view : viewArr) {
                        c.a aVarC = cVarN.C(view.getId());
                        c.a aVar = this.f12519g;
                        if (aVar != null) {
                            aVar.d(aVarC);
                            aVarC.f12727g.putAll(this.f12519g.f12727g);
                        }
                    }
                }
            }
        }
        androidx.constraintlayout.widget.c cVar2 = new androidx.constraintlayout.widget.c();
        cVar2.q(cVar);
        for (View view2 : viewArr) {
            c.a aVarC2 = cVar2.C(view2.getId());
            c.a aVar2 = this.f12519g;
            if (aVar2 != null) {
                aVar2.d(aVarC2);
                aVarC2.f12727g.putAll(this.f12519g.f12727g);
            }
        }
        motionLayout.j0(i10, cVar2);
        int i13 = R$id.view_transition;
        motionLayout.j0(i13, cVar);
        motionLayout.setState(i13, -1, -1);
        q.b bVar = new q.b(-1, motionLayout.mScene, i13, i10);
        for (View view3 : viewArr) {
            m(bVar, view3);
        }
        motionLayout.setTransition(bVar);
        motionLayout.d0(new Runnable() { // from class: androidx.constraintlayout.motion.widget.s
            @Override // java.lang.Runnable
            public final void run() {
                t.a(this.f12511a, viewArr);
            }
        });
    }

    public boolean d(View view) {
        int i10 = this.f12530r;
        boolean z10 = i10 == -1 || view.getTag(i10) != null;
        int i11 = this.f12531s;
        return z10 && (i11 == -1 || view.getTag(i11) == null);
    }

    public int e() {
        return this.f12513a;
    }

    public Interpolator f(Context context) {
        int i10 = this.f12524l;
        if (i10 == -2) {
            return AnimationUtils.loadInterpolator(context, this.f12526n);
        }
        if (i10 == -1) {
            return new a(C4890c.c(this.f12525m));
        }
        if (i10 == 0) {
            return new AccelerateDecelerateInterpolator();
        }
        if (i10 == 1) {
            return new AccelerateInterpolator();
        }
        if (i10 == 2) {
            return new DecelerateInterpolator();
        }
        if (i10 == 4) {
            return new BounceInterpolator();
        }
        if (i10 == 5) {
            return new OvershootInterpolator();
        }
        if (i10 != 6) {
            return null;
        }
        return new AnticipateInterpolator();
    }

    public int g() {
        return this.f12532t;
    }

    public int h() {
        return this.f12533u;
    }

    public int i() {
        return this.f12514b;
    }

    public boolean j(View view) {
        String str;
        if (view == null) {
            return false;
        }
        if ((this.f12522j == -1 && this.f12523k == null) || !d(view)) {
            return false;
        }
        if (view.getId() == this.f12522j) {
            return true;
        }
        return this.f12523k != null && (view.getLayoutParams() instanceof ConstraintLayout.b) && (str = ((ConstraintLayout.b) view.getLayoutParams()).f12631c0) != null && str.matches(this.f12523k);
    }

    public final void k(Context context, XmlPullParser xmlPullParser) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlPullParser), R$styleable.ViewTransition);
        int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
        for (int i10 = 0; i10 < indexCount; i10++) {
            int index = typedArrayObtainStyledAttributes.getIndex(i10);
            if (index == R$styleable.ViewTransition_android_id) {
                this.f12513a = typedArrayObtainStyledAttributes.getResourceId(index, this.f12513a);
            } else if (index == R$styleable.ViewTransition_motionTarget) {
                if (MotionLayout.IS_IN_EDIT_MODE) {
                    int resourceId = typedArrayObtainStyledAttributes.getResourceId(index, this.f12522j);
                    this.f12522j = resourceId;
                    if (resourceId == -1) {
                        this.f12523k = typedArrayObtainStyledAttributes.getString(index);
                    }
                } else if (typedArrayObtainStyledAttributes.peekValue(index).type == 3) {
                    this.f12523k = typedArrayObtainStyledAttributes.getString(index);
                } else {
                    this.f12522j = typedArrayObtainStyledAttributes.getResourceId(index, this.f12522j);
                }
            } else if (index == R$styleable.ViewTransition_onStateTransition) {
                this.f12514b = typedArrayObtainStyledAttributes.getInt(index, this.f12514b);
            } else if (index == R$styleable.ViewTransition_transitionDisable) {
                this.f12515c = typedArrayObtainStyledAttributes.getBoolean(index, this.f12515c);
            } else if (index == R$styleable.ViewTransition_pathMotionArc) {
                this.f12516d = typedArrayObtainStyledAttributes.getInt(index, this.f12516d);
            } else if (index == R$styleable.ViewTransition_duration) {
                this.f12520h = typedArrayObtainStyledAttributes.getInt(index, this.f12520h);
            } else if (index == R$styleable.ViewTransition_upDuration) {
                this.f12521i = typedArrayObtainStyledAttributes.getInt(index, this.f12521i);
            } else if (index == R$styleable.ViewTransition_viewTransitionMode) {
                this.f12517e = typedArrayObtainStyledAttributes.getInt(index, this.f12517e);
            } else if (index == R$styleable.ViewTransition_motionInterpolator) {
                int i11 = typedArrayObtainStyledAttributes.peekValue(index).type;
                if (i11 == 1) {
                    int resourceId2 = typedArrayObtainStyledAttributes.getResourceId(index, -1);
                    this.f12526n = resourceId2;
                    if (resourceId2 != -1) {
                        this.f12524l = -2;
                    }
                } else if (i11 == 3) {
                    String string = typedArrayObtainStyledAttributes.getString(index);
                    this.f12525m = string;
                    if (string == null || string.indexOf("/") <= 0) {
                        this.f12524l = -1;
                    } else {
                        this.f12526n = typedArrayObtainStyledAttributes.getResourceId(index, -1);
                        this.f12524l = -2;
                    }
                } else {
                    this.f12524l = typedArrayObtainStyledAttributes.getInteger(index, this.f12524l);
                }
            } else if (index == R$styleable.ViewTransition_setsTag) {
                this.f12528p = typedArrayObtainStyledAttributes.getResourceId(index, this.f12528p);
            } else if (index == R$styleable.ViewTransition_clearsTag) {
                this.f12529q = typedArrayObtainStyledAttributes.getResourceId(index, this.f12529q);
            } else if (index == R$styleable.ViewTransition_ifTagSet) {
                this.f12530r = typedArrayObtainStyledAttributes.getResourceId(index, this.f12530r);
            } else if (index == R$styleable.ViewTransition_ifTagNotSet) {
                this.f12531s = typedArrayObtainStyledAttributes.getResourceId(index, this.f12531s);
            } else if (index == R$styleable.ViewTransition_SharedValueId) {
                this.f12533u = typedArrayObtainStyledAttributes.getResourceId(index, this.f12533u);
            } else if (index == R$styleable.ViewTransition_SharedValue) {
                this.f12532t = typedArrayObtainStyledAttributes.getInteger(index, this.f12532t);
            }
        }
        typedArrayObtainStyledAttributes.recycle();
    }

    public boolean l(int i10) {
        int i11 = this.f12514b;
        return i11 == 1 ? i10 == 0 : i11 == 2 ? i10 == 1 : i11 == 3 && i10 == 0;
    }

    public final void m(q.b bVar, View view) {
        int i10 = this.f12520h;
        if (i10 != -1) {
            bVar.E(i10);
        }
        bVar.G(this.f12516d);
        bVar.F(this.f12524l, this.f12525m, this.f12526n);
        int id = view.getId();
        g gVar = this.f12518f;
        if (gVar != null) {
            ArrayList<d> arrayListD = gVar.d(-1);
            g gVar2 = new g();
            Iterator<d> it = arrayListD.iterator();
            while (it.hasNext()) {
                gVar2.c(it.next().clone().h(id));
            }
            bVar.t(gVar2);
        }
    }

    public String toString() {
        return "ViewTransition(" + androidx.constraintlayout.motion.widget.a.c(this.f12527o, this.f12513a) + ")";
    }
}
