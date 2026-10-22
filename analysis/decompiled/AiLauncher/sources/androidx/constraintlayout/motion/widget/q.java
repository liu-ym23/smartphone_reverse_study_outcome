package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.util.Xml;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnimationUtils;
import android.view.animation.AnticipateInterpolator;
import android.view.animation.BounceInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.OvershootInterpolator;
import androidx.constraintlayout.motion.widget.MotionLayout;
import androidx.constraintlayout.widget.R$id;
import androidx.constraintlayout.widget.R$styleable;
import com.autonavi.aps.amapapi.config.Const;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import m0.C4890c;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: classes.dex */
public class q {

    /* renamed from: a, reason: collision with root package name */
    public final MotionLayout f12432a;

    /* renamed from: m, reason: collision with root package name */
    public MotionEvent f12444m;

    /* renamed from: p, reason: collision with root package name */
    public MotionLayout.g f12447p;

    /* renamed from: q, reason: collision with root package name */
    public boolean f12448q;

    /* renamed from: r, reason: collision with root package name */
    public final u f12449r;

    /* renamed from: s, reason: collision with root package name */
    public float f12450s;

    /* renamed from: t, reason: collision with root package name */
    public float f12451t;

    /* renamed from: b, reason: collision with root package name */
    public androidx.constraintlayout.widget.h f12433b = null;

    /* renamed from: c, reason: collision with root package name */
    public b f12434c = null;

    /* renamed from: d, reason: collision with root package name */
    public boolean f12435d = false;

    /* renamed from: e, reason: collision with root package name */
    public ArrayList<b> f12436e = new ArrayList<>();

    /* renamed from: f, reason: collision with root package name */
    public b f12437f = null;

    /* renamed from: g, reason: collision with root package name */
    public ArrayList<b> f12438g = new ArrayList<>();

    /* renamed from: h, reason: collision with root package name */
    public SparseArray<androidx.constraintlayout.widget.c> f12439h = new SparseArray<>();

    /* renamed from: i, reason: collision with root package name */
    public HashMap<String, Integer> f12440i = new HashMap<>();

    /* renamed from: j, reason: collision with root package name */
    public SparseIntArray f12441j = new SparseIntArray();

    /* renamed from: k, reason: collision with root package name */
    public int f12442k = Const.I_TILE_TINY;

    /* renamed from: l, reason: collision with root package name */
    public int f12443l = 0;

    /* renamed from: n, reason: collision with root package name */
    public boolean f12445n = false;

    /* renamed from: o, reason: collision with root package name */
    public boolean f12446o = false;

    public class a implements Interpolator {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ C4890c f12452a;

        public a(C4890c c4890c) {
            this.f12452a = c4890c;
        }

        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f10) {
            return (float) this.f12452a.a(f10);
        }
    }

    public q(Context context, MotionLayout motionLayout, int i10) throws XmlPullParserException, Resources.NotFoundException, IOException {
        this.f12432a = motionLayout;
        this.f12449r = new u(motionLayout);
        J(context, i10);
        SparseArray<androidx.constraintlayout.widget.c> sparseArray = this.f12439h;
        int i11 = R$id.motion_base;
        sparseArray.put(i11, new androidx.constraintlayout.widget.c());
        this.f12440i.put("motion_base", Integer.valueOf(i11));
    }

    public static String Z(String str) {
        if (str == null) {
            return "";
        }
        int iIndexOf = str.indexOf(47);
        return iIndexOf < 0 ? str : str.substring(iIndexOf + 1);
    }

    public float A() {
        b bVar = this.f12434c;
        if (bVar == null || bVar.f12465l == null) {
            return 0.0f;
        }
        return this.f12434c.f12465l.m();
    }

    public float B() {
        b bVar = this.f12434c;
        if (bVar == null || bVar.f12465l == null) {
            return 0.0f;
        }
        return this.f12434c.f12465l.n();
    }

    public float C() {
        b bVar = this.f12434c;
        if (bVar == null || bVar.f12465l == null) {
            return 0.0f;
        }
        return this.f12434c.f12465l.o();
    }

    public float D() {
        b bVar = this.f12434c;
        if (bVar != null) {
            return bVar.f12462i;
        }
        return 0.0f;
    }

    public int E() {
        b bVar = this.f12434c;
        if (bVar == null) {
            return -1;
        }
        return bVar.f12457d;
    }

    public b F(int i10) {
        Iterator<b> it = this.f12436e.iterator();
        while (it.hasNext()) {
            b next = it.next();
            if (next.f12454a == i10) {
                return next;
            }
        }
        return null;
    }

    public List<b> G(int i10) {
        int iX = x(i10);
        ArrayList arrayList = new ArrayList();
        Iterator<b> it = this.f12436e.iterator();
        while (it.hasNext()) {
            b next = it.next();
            if (next.f12457d == iX || next.f12456c == iX) {
                arrayList.add(next);
            }
        }
        return arrayList;
    }

    public final boolean H(int i10) {
        int i11 = this.f12441j.get(i10);
        int size = this.f12441j.size();
        while (i11 > 0) {
            if (i11 == i10) {
                return true;
            }
            int i12 = size - 1;
            if (size < 0) {
                return true;
            }
            i11 = this.f12441j.get(i11);
            size = i12;
        }
        return false;
    }

    public final boolean I() {
        return this.f12447p != null;
    }

    /* JADX WARN: Removed duplicated region for block: B:46:0x0091  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void J(android.content.Context r10, int r11) throws org.xmlpull.v1.XmlPullParserException, android.content.res.Resources.NotFoundException, java.io.IOException {
        /*
            Method dump skipped, instructions count: 452
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.motion.widget.q.J(android.content.Context, int):void");
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:32:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0028  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int K(android.content.Context r14, org.xmlpull.v1.XmlPullParser r15) throws org.xmlpull.v1.XmlPullParserException, java.io.IOException {
        /*
            Method dump skipped, instructions count: 316
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.motion.widget.q.K(android.content.Context, org.xmlpull.v1.XmlPullParser):int");
    }

    public final int L(Context context, int i10) throws XmlPullParserException, Resources.NotFoundException, IOException {
        XmlResourceParser xml = context.getResources().getXml(i10);
        try {
            for (int eventType = xml.getEventType(); eventType != 1; eventType = xml.next()) {
                String name = xml.getName();
                if (2 == eventType && "ConstraintSet".equals(name)) {
                    return K(context, xml);
                }
            }
            return -1;
        } catch (IOException e10) {
            Log.e("MotionScene", "Error parsing resource: " + i10, e10);
            return -1;
        } catch (XmlPullParserException e11) {
            Log.e("MotionScene", "Error parsing resource: " + i10, e11);
            return -1;
        }
    }

    public final void M(Context context, XmlPullParser xmlPullParser) throws XmlPullParserException, Resources.NotFoundException, IOException {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlPullParser), R$styleable.include);
        int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
        for (int i10 = 0; i10 < indexCount; i10++) {
            int index = typedArrayObtainStyledAttributes.getIndex(i10);
            if (index == R$styleable.include_constraintSet) {
                L(context, typedArrayObtainStyledAttributes.getResourceId(index, -1));
            }
        }
        typedArrayObtainStyledAttributes.recycle();
    }

    public final void N(Context context, XmlPullParser xmlPullParser) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlPullParser), R$styleable.MotionScene);
        int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
        for (int i10 = 0; i10 < indexCount; i10++) {
            int index = typedArrayObtainStyledAttributes.getIndex(i10);
            if (index == R$styleable.MotionScene_defaultDuration) {
                int i11 = typedArrayObtainStyledAttributes.getInt(index, this.f12442k);
                this.f12442k = i11;
                if (i11 < 8) {
                    this.f12442k = 8;
                }
            } else if (index == R$styleable.MotionScene_layoutDuringTransition) {
                this.f12443l = typedArrayObtainStyledAttributes.getInteger(index, 0);
            }
        }
        typedArrayObtainStyledAttributes.recycle();
    }

    public void O(float f10, float f11) {
        b bVar = this.f12434c;
        if (bVar == null || bVar.f12465l == null) {
            return;
        }
        this.f12434c.f12465l.u(f10, f11);
    }

    public void P(float f10, float f11) {
        b bVar = this.f12434c;
        if (bVar == null || bVar.f12465l == null) {
            return;
        }
        this.f12434c.f12465l.v(f10, f11);
    }

    public void Q(MotionEvent motionEvent, int i10, MotionLayout motionLayout) {
        MotionLayout.g gVar;
        MotionEvent motionEvent2;
        RectF rectF = new RectF();
        if (this.f12447p == null) {
            this.f12447p = this.f12432a.T();
        }
        this.f12447p.a(motionEvent);
        if (i10 != -1) {
            int action = motionEvent.getAction();
            boolean z10 = false;
            if (action == 0) {
                this.f12450s = motionEvent.getRawX();
                this.f12451t = motionEvent.getRawY();
                this.f12444m = motionEvent;
                this.f12445n = false;
                if (this.f12434c.f12465l != null) {
                    RectF rectFF = this.f12434c.f12465l.f(this.f12432a, rectF);
                    if (rectFF != null && !rectFF.contains(this.f12444m.getX(), this.f12444m.getY())) {
                        this.f12444m = null;
                        this.f12445n = true;
                        return;
                    }
                    RectF rectFP = this.f12434c.f12465l.p(this.f12432a, rectF);
                    if (rectFP == null || rectFP.contains(this.f12444m.getX(), this.f12444m.getY())) {
                        this.f12446o = false;
                    } else {
                        this.f12446o = true;
                    }
                    this.f12434c.f12465l.w(this.f12450s, this.f12451t);
                    return;
                }
                return;
            }
            if (action == 2 && !this.f12445n) {
                float rawY = motionEvent.getRawY() - this.f12451t;
                float rawX = motionEvent.getRawX() - this.f12450s;
                if ((rawX == 0.0d && rawY == 0.0d) || (motionEvent2 = this.f12444m) == null) {
                    return;
                }
                b bVarH = h(i10, rawX, rawY, motionEvent2);
                if (bVarH != null) {
                    motionLayout.setTransition(bVarH);
                    RectF rectFP2 = this.f12434c.f12465l.p(this.f12432a, rectF);
                    if (rectFP2 != null && !rectFP2.contains(this.f12444m.getX(), this.f12444m.getY())) {
                        z10 = true;
                    }
                    this.f12446o = z10;
                    this.f12434c.f12465l.y(this.f12450s, this.f12451t);
                }
            }
        }
        if (this.f12445n) {
            return;
        }
        b bVar = this.f12434c;
        if (bVar != null && bVar.f12465l != null && !this.f12446o) {
            this.f12434c.f12465l.s(motionEvent, this.f12447p, i10, this);
        }
        this.f12450s = motionEvent.getRawX();
        this.f12451t = motionEvent.getRawY();
        if (motionEvent.getAction() != 1 || (gVar = this.f12447p) == null) {
            return;
        }
        gVar.recycle();
        this.f12447p = null;
        int i11 = motionLayout.mCurrentState;
        if (i11 != -1) {
            g(motionLayout, i11);
        }
    }

    public final void R(int i10, MotionLayout motionLayout) {
        androidx.constraintlayout.widget.c cVar = this.f12439h.get(i10);
        cVar.f12715c = cVar.f12714b;
        int i11 = this.f12441j.get(i10);
        if (i11 > 0) {
            R(i11, motionLayout);
            androidx.constraintlayout.widget.c cVar2 = this.f12439h.get(i11);
            if (cVar2 == null) {
                Log.e("MotionScene", "ERROR! invalid deriveConstraintsFrom: @id/" + androidx.constraintlayout.motion.widget.a.c(this.f12432a.getContext(), i11));
                return;
            }
            cVar.f12715c += "/" + cVar2.f12715c;
            cVar.S(cVar2);
        } else {
            cVar.f12715c += "  layout";
            cVar.R(motionLayout);
        }
        cVar.h(cVar);
    }

    public void S(MotionLayout motionLayout) {
        for (int i10 = 0; i10 < this.f12439h.size(); i10++) {
            int iKeyAt = this.f12439h.keyAt(i10);
            if (H(iKeyAt)) {
                Log.e("MotionScene", "Cannot be derived from yourself");
                return;
            }
            R(iKeyAt, motionLayout);
        }
    }

    public void T(int i10, androidx.constraintlayout.widget.c cVar) {
        this.f12439h.put(i10, cVar);
    }

    public void U(int i10) {
        b bVar = this.f12434c;
        if (bVar != null) {
            bVar.E(i10);
        } else {
            this.f12442k = i10;
        }
    }

    public void V(boolean z10) {
        this.f12448q = z10;
        b bVar = this.f12434c;
        if (bVar == null || bVar.f12465l == null) {
            return;
        }
        this.f12434c.f12465l.x(this.f12448q);
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0039  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0096  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void W(int r7, int r8) {
        /*
            r6 = this;
            androidx.constraintlayout.widget.h r0 = r6.f12433b
            r1 = -1
            if (r0 == 0) goto L18
            int r0 = r0.c(r7, r1, r1)
            if (r0 == r1) goto Lc
            goto Ld
        Lc:
            r0 = r7
        Ld:
            androidx.constraintlayout.widget.h r2 = r6.f12433b
            int r2 = r2.c(r8, r1, r1)
            if (r2 == r1) goto L16
            goto L1a
        L16:
            r2 = r8
            goto L1a
        L18:
            r0 = r7
            goto L16
        L1a:
            androidx.constraintlayout.motion.widget.q$b r3 = r6.f12434c
            if (r3 == 0) goto L2d
            int r3 = androidx.constraintlayout.motion.widget.q.b.a(r3)
            if (r3 != r8) goto L2d
            androidx.constraintlayout.motion.widget.q$b r3 = r6.f12434c
            int r3 = androidx.constraintlayout.motion.widget.q.b.c(r3)
            if (r3 != r7) goto L2d
            goto L6c
        L2d:
            java.util.ArrayList<androidx.constraintlayout.motion.widget.q$b> r3 = r6.f12436e
            java.util.Iterator r3 = r3.iterator()
        L33:
            boolean r4 = r3.hasNext()
            if (r4 == 0) goto L6d
            java.lang.Object r4 = r3.next()
            androidx.constraintlayout.motion.widget.q$b r4 = (androidx.constraintlayout.motion.widget.q.b) r4
            int r5 = androidx.constraintlayout.motion.widget.q.b.a(r4)
            if (r5 != r2) goto L4b
            int r5 = androidx.constraintlayout.motion.widget.q.b.c(r4)
            if (r5 == r0) goto L57
        L4b:
            int r5 = androidx.constraintlayout.motion.widget.q.b.a(r4)
            if (r5 != r8) goto L33
            int r5 = androidx.constraintlayout.motion.widget.q.b.c(r4)
            if (r5 != r7) goto L33
        L57:
            r6.f12434c = r4
            if (r4 == 0) goto L6c
            androidx.constraintlayout.motion.widget.r r7 = androidx.constraintlayout.motion.widget.q.b.l(r4)
            if (r7 == 0) goto L6c
            androidx.constraintlayout.motion.widget.q$b r7 = r6.f12434c
            androidx.constraintlayout.motion.widget.r r7 = androidx.constraintlayout.motion.widget.q.b.l(r7)
            boolean r6 = r6.f12448q
            r7.x(r6)
        L6c:
            return
        L6d:
            androidx.constraintlayout.motion.widget.q$b r7 = r6.f12437f
            java.util.ArrayList<androidx.constraintlayout.motion.widget.q$b> r3 = r6.f12438g
            java.util.Iterator r3 = r3.iterator()
        L75:
            boolean r4 = r3.hasNext()
            if (r4 == 0) goto L89
            java.lang.Object r4 = r3.next()
            androidx.constraintlayout.motion.widget.q$b r4 = (androidx.constraintlayout.motion.widget.q.b) r4
            int r5 = androidx.constraintlayout.motion.widget.q.b.a(r4)
            if (r5 != r8) goto L75
            r7 = r4
            goto L75
        L89:
            androidx.constraintlayout.motion.widget.q$b r8 = new androidx.constraintlayout.motion.widget.q$b
            r8.<init>(r6, r7)
            androidx.constraintlayout.motion.widget.q.b.d(r8, r0)
            androidx.constraintlayout.motion.widget.q.b.b(r8, r2)
            if (r0 == r1) goto L9b
            java.util.ArrayList<androidx.constraintlayout.motion.widget.q$b> r7 = r6.f12436e
            r7.add(r8)
        L9b:
            r6.f12434c = r8
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.motion.widget.q.W(int, int):void");
    }

    public void X(b bVar) {
        this.f12434c = bVar;
        if (bVar == null || bVar.f12465l == null) {
            return;
        }
        this.f12434c.f12465l.x(this.f12448q);
    }

    public void Y() {
        b bVar = this.f12434c;
        if (bVar == null || bVar.f12465l == null) {
            return;
        }
        this.f12434c.f12465l.z();
    }

    public boolean a0() {
        Iterator<b> it = this.f12436e.iterator();
        while (it.hasNext()) {
            if (it.next().f12465l != null) {
                return true;
            }
        }
        b bVar = this.f12434c;
        return (bVar == null || bVar.f12465l == null) ? false : true;
    }

    public void b0(int i10, View... viewArr) {
        this.f12449r.h(i10, viewArr);
    }

    public void f(MotionLayout motionLayout, int i10) {
        Iterator<b> it = this.f12436e.iterator();
        while (it.hasNext()) {
            b next = it.next();
            if (next.f12466m.size() > 0) {
                Iterator it2 = next.f12466m.iterator();
                while (it2.hasNext()) {
                    ((b.a) it2.next()).c(motionLayout);
                }
            }
        }
        Iterator<b> it3 = this.f12438g.iterator();
        while (it3.hasNext()) {
            b next2 = it3.next();
            if (next2.f12466m.size() > 0) {
                Iterator it4 = next2.f12466m.iterator();
                while (it4.hasNext()) {
                    ((b.a) it4.next()).c(motionLayout);
                }
            }
        }
        Iterator<b> it5 = this.f12436e.iterator();
        while (it5.hasNext()) {
            b next3 = it5.next();
            if (next3.f12466m.size() > 0) {
                Iterator it6 = next3.f12466m.iterator();
                while (it6.hasNext()) {
                    ((b.a) it6.next()).a(motionLayout, i10, next3);
                }
            }
        }
        Iterator<b> it7 = this.f12438g.iterator();
        while (it7.hasNext()) {
            b next4 = it7.next();
            if (next4.f12466m.size() > 0) {
                Iterator it8 = next4.f12466m.iterator();
                while (it8.hasNext()) {
                    ((b.a) it8.next()).a(motionLayout, i10, next4);
                }
            }
        }
    }

    public boolean g(MotionLayout motionLayout, int i10) {
        b bVar;
        if (I() || this.f12435d) {
            return false;
        }
        Iterator<b> it = this.f12436e.iterator();
        while (it.hasNext()) {
            b next = it.next();
            if (next.f12467n != 0 && ((bVar = this.f12434c) != next || !bVar.D(2))) {
                if (i10 == next.f12457d && (next.f12467n == 4 || next.f12467n == 2)) {
                    MotionLayout.TransitionState transitionState = MotionLayout.TransitionState.FINISHED;
                    motionLayout.setState(transitionState);
                    motionLayout.setTransition(next);
                    if (next.f12467n == 4) {
                        motionLayout.c0();
                        motionLayout.setState(MotionLayout.TransitionState.SETUP);
                        motionLayout.setState(MotionLayout.TransitionState.MOVING);
                    } else {
                        motionLayout.setProgress(1.0f);
                        motionLayout.G(true);
                        motionLayout.setState(MotionLayout.TransitionState.SETUP);
                        motionLayout.setState(MotionLayout.TransitionState.MOVING);
                        motionLayout.setState(transitionState);
                        motionLayout.U();
                    }
                    return true;
                }
                if (i10 == next.f12456c && (next.f12467n == 3 || next.f12467n == 1)) {
                    MotionLayout.TransitionState transitionState2 = MotionLayout.TransitionState.FINISHED;
                    motionLayout.setState(transitionState2);
                    motionLayout.setTransition(next);
                    if (next.f12467n == 3) {
                        motionLayout.e0();
                        motionLayout.setState(MotionLayout.TransitionState.SETUP);
                        motionLayout.setState(MotionLayout.TransitionState.MOVING);
                    } else {
                        motionLayout.setProgress(0.0f);
                        motionLayout.G(true);
                        motionLayout.setState(MotionLayout.TransitionState.SETUP);
                        motionLayout.setState(MotionLayout.TransitionState.MOVING);
                        motionLayout.setState(transitionState2);
                        motionLayout.U();
                    }
                    return true;
                }
            }
        }
        return false;
    }

    public b h(int i10, float f10, float f11, MotionEvent motionEvent) {
        if (i10 == -1) {
            return this.f12434c;
        }
        List<b> listG = G(i10);
        RectF rectF = new RectF();
        float f12 = 0.0f;
        b bVar = null;
        for (b bVar2 : listG) {
            if (!bVar2.f12468o && bVar2.f12465l != null) {
                bVar2.f12465l.x(this.f12448q);
                RectF rectFP = bVar2.f12465l.p(this.f12432a, rectF);
                if (rectFP == null || motionEvent == null || rectFP.contains(motionEvent.getX(), motionEvent.getY())) {
                    RectF rectFF = bVar2.f12465l.f(this.f12432a, rectF);
                    if (rectFF == null || motionEvent == null || rectFF.contains(motionEvent.getX(), motionEvent.getY())) {
                        float fA = bVar2.f12465l.a(f10, f11);
                        if (bVar2.f12465l.f12494l && motionEvent != null) {
                            fA = ((float) (Math.atan2(f11 + r10, f10 + r9) - Math.atan2(motionEvent.getX() - bVar2.f12465l.f12491i, motionEvent.getY() - bVar2.f12465l.f12492j))) * 10.0f;
                        }
                        float f13 = fA * (bVar2.f12456c == i10 ? -1.0f : 1.1f);
                        if (f13 > f12) {
                            bVar = bVar2;
                            f12 = f13;
                        }
                    }
                }
            }
        }
        return bVar;
    }

    public int i() {
        b bVar = this.f12434c;
        if (bVar != null) {
            return bVar.f12469p;
        }
        return -1;
    }

    public int j() {
        b bVar = this.f12434c;
        if (bVar == null || bVar.f12465l == null) {
            return 0;
        }
        return this.f12434c.f12465l.d();
    }

    public androidx.constraintlayout.widget.c k(int i10) {
        return l(i10, -1, -1);
    }

    public androidx.constraintlayout.widget.c l(int i10, int i11, int i12) {
        int iC;
        androidx.constraintlayout.widget.h hVar = this.f12433b;
        if (hVar != null && (iC = hVar.c(i10, i11, i12)) != -1) {
            i10 = iC;
        }
        if (this.f12439h.get(i10) != null) {
            return this.f12439h.get(i10);
        }
        Log.e("MotionScene", "Warning could not find ConstraintSet id/" + androidx.constraintlayout.motion.widget.a.c(this.f12432a.getContext(), i10) + " In MotionScene");
        SparseArray<androidx.constraintlayout.widget.c> sparseArray = this.f12439h;
        return sparseArray.get(sparseArray.keyAt(0));
    }

    public int[] m() {
        int size = this.f12439h.size();
        int[] iArr = new int[size];
        for (int i10 = 0; i10 < size; i10++) {
            iArr[i10] = this.f12439h.keyAt(i10);
        }
        return iArr;
    }

    public ArrayList<b> n() {
        return this.f12436e;
    }

    public int o() {
        b bVar = this.f12434c;
        return bVar != null ? bVar.f12461h : this.f12442k;
    }

    public int p() {
        b bVar = this.f12434c;
        if (bVar == null) {
            return -1;
        }
        return bVar.f12456c;
    }

    public final int q(Context context, String str) {
        int identifier;
        if (str.contains("/")) {
            identifier = context.getResources().getIdentifier(str.substring(str.indexOf(47) + 1), "id", context.getPackageName());
        } else {
            identifier = -1;
        }
        if (identifier == -1) {
            if (str.length() > 1) {
                return Integer.parseInt(str.substring(1));
            }
            Log.e("MotionScene", "error in parsing id");
        }
        return identifier;
    }

    public Interpolator r() {
        int i10 = this.f12434c.f12458e;
        if (i10 == -2) {
            return AnimationUtils.loadInterpolator(this.f12432a.getContext(), this.f12434c.f12460g);
        }
        if (i10 == -1) {
            return new a(C4890c.c(this.f12434c.f12459f));
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

    public void s(m mVar) {
        b bVar = this.f12434c;
        if (bVar != null) {
            Iterator it = bVar.f12464k.iterator();
            while (it.hasNext()) {
                ((g) it.next()).b(mVar);
            }
        } else {
            b bVar2 = this.f12437f;
            if (bVar2 != null) {
                Iterator it2 = bVar2.f12464k.iterator();
                while (it2.hasNext()) {
                    ((g) it2.next()).b(mVar);
                }
            }
        }
    }

    public float t() {
        b bVar = this.f12434c;
        if (bVar == null || bVar.f12465l == null) {
            return 0.0f;
        }
        return this.f12434c.f12465l.g();
    }

    public float u() {
        b bVar = this.f12434c;
        if (bVar == null || bVar.f12465l == null) {
            return 0.0f;
        }
        return this.f12434c.f12465l.h();
    }

    public boolean v() {
        b bVar = this.f12434c;
        if (bVar == null || bVar.f12465l == null) {
            return false;
        }
        return this.f12434c.f12465l.i();
    }

    public float w(float f10, float f11) {
        b bVar = this.f12434c;
        if (bVar == null || bVar.f12465l == null) {
            return 0.0f;
        }
        return this.f12434c.f12465l.j(f10, f11);
    }

    public final int x(int i10) {
        int iC;
        androidx.constraintlayout.widget.h hVar = this.f12433b;
        return (hVar == null || (iC = hVar.c(i10, -1, -1)) == -1) ? i10 : iC;
    }

    public int y() {
        b bVar = this.f12434c;
        if (bVar == null || bVar.f12465l == null) {
            return 0;
        }
        return this.f12434c.f12465l.k();
    }

    public float z() {
        b bVar = this.f12434c;
        if (bVar == null || bVar.f12465l == null) {
            return 0.0f;
        }
        return this.f12434c.f12465l.l();
    }

    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public int f12454a;

        /* renamed from: b, reason: collision with root package name */
        public boolean f12455b;

        /* renamed from: c, reason: collision with root package name */
        public int f12456c;

        /* renamed from: d, reason: collision with root package name */
        public int f12457d;

        /* renamed from: e, reason: collision with root package name */
        public int f12458e;

        /* renamed from: f, reason: collision with root package name */
        public String f12459f;

        /* renamed from: g, reason: collision with root package name */
        public int f12460g;

        /* renamed from: h, reason: collision with root package name */
        public int f12461h;

        /* renamed from: i, reason: collision with root package name */
        public float f12462i;

        /* renamed from: j, reason: collision with root package name */
        public final q f12463j;

        /* renamed from: k, reason: collision with root package name */
        public ArrayList<g> f12464k;

        /* renamed from: l, reason: collision with root package name */
        public r f12465l;

        /* renamed from: m, reason: collision with root package name */
        public ArrayList<a> f12466m;

        /* renamed from: n, reason: collision with root package name */
        public int f12467n;

        /* renamed from: o, reason: collision with root package name */
        public boolean f12468o;

        /* renamed from: p, reason: collision with root package name */
        public int f12469p;

        /* renamed from: q, reason: collision with root package name */
        public int f12470q;

        /* renamed from: r, reason: collision with root package name */
        public int f12471r;

        public static class a implements View.OnClickListener {

            /* renamed from: a, reason: collision with root package name */
            public final b f12472a;

            /* renamed from: b, reason: collision with root package name */
            public int f12473b;

            /* renamed from: c, reason: collision with root package name */
            public int f12474c;

            public a(Context context, b bVar, XmlPullParser xmlPullParser) {
                this.f12473b = -1;
                this.f12474c = 17;
                this.f12472a = bVar;
                TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlPullParser), R$styleable.OnClick);
                int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
                for (int i10 = 0; i10 < indexCount; i10++) {
                    int index = typedArrayObtainStyledAttributes.getIndex(i10);
                    if (index == R$styleable.OnClick_targetId) {
                        this.f12473b = typedArrayObtainStyledAttributes.getResourceId(index, this.f12473b);
                    } else if (index == R$styleable.OnClick_clickAction) {
                        this.f12474c = typedArrayObtainStyledAttributes.getInt(index, this.f12474c);
                    }
                }
                typedArrayObtainStyledAttributes.recycle();
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r7v4, types: [android.view.View] */
            public void a(MotionLayout motionLayout, int i10, b bVar) {
                int i11 = this.f12473b;
                MotionLayout motionLayoutFindViewById = motionLayout;
                if (i11 != -1) {
                    motionLayoutFindViewById = motionLayout.findViewById(i11);
                }
                if (motionLayoutFindViewById == null) {
                    Log.e("MotionScene", "OnClick could not find id " + this.f12473b);
                    return;
                }
                int i12 = bVar.f12457d;
                int i13 = bVar.f12456c;
                if (i12 == -1) {
                    motionLayoutFindViewById.setOnClickListener(this);
                    return;
                }
                int i14 = this.f12474c;
                boolean z10 = false;
                boolean z11 = ((i14 & 1) != 0 && i10 == i12) | ((i14 & 1) != 0 && i10 == i12) | ((i14 & 256) != 0 && i10 == i12) | ((i14 & 16) != 0 && i10 == i13);
                if ((i14 & 4096) != 0 && i10 == i13) {
                    z10 = true;
                }
                if (z11 || z10) {
                    motionLayoutFindViewById.setOnClickListener(this);
                }
            }

            public boolean b(b bVar, MotionLayout motionLayout) {
                b bVar2 = this.f12472a;
                if (bVar2 == bVar) {
                    return true;
                }
                int i10 = bVar2.f12456c;
                int i11 = this.f12472a.f12457d;
                if (i11 == -1) {
                    return motionLayout.mCurrentState != i10;
                }
                int i12 = motionLayout.mCurrentState;
                return i12 == i11 || i12 == i10;
            }

            public void c(MotionLayout motionLayout) {
                int i10 = this.f12473b;
                if (i10 == -1) {
                    return;
                }
                View viewFindViewById = motionLayout.findViewById(i10);
                if (viewFindViewById != null) {
                    viewFindViewById.setOnClickListener(null);
                    return;
                }
                Log.e("MotionScene", " (*)  could not find id " + this.f12473b);
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MotionLayout motionLayout = this.f12472a.f12463j.f12432a;
                if (motionLayout.S()) {
                    if (this.f12472a.f12457d == -1) {
                        int currentState = motionLayout.getCurrentState();
                        if (currentState == -1) {
                            motionLayout.f0(this.f12472a.f12456c);
                            return;
                        }
                        b bVar = new b(this.f12472a.f12463j, this.f12472a);
                        bVar.f12457d = currentState;
                        bVar.f12456c = this.f12472a.f12456c;
                        motionLayout.setTransition(bVar);
                        motionLayout.c0();
                        return;
                    }
                    b bVar2 = this.f12472a.f12463j.f12434c;
                    int i10 = this.f12474c;
                    boolean z10 = false;
                    boolean z11 = ((i10 & 1) == 0 && (i10 & 256) == 0) ? false : true;
                    boolean z12 = ((i10 & 16) == 0 && (i10 & 4096) == 0) ? false : true;
                    if (z11 && z12) {
                        b bVar3 = this.f12472a.f12463j.f12434c;
                        b bVar4 = this.f12472a;
                        if (bVar3 != bVar4) {
                            motionLayout.setTransition(bVar4);
                        }
                        if (motionLayout.getCurrentState() != motionLayout.getEndState() && motionLayout.getProgress() <= 0.5f) {
                            z12 = false;
                            z10 = z11;
                        }
                    } else {
                        z10 = z11;
                    }
                    if (b(bVar2, motionLayout)) {
                        if (z10 && (this.f12474c & 1) != 0) {
                            motionLayout.setTransition(this.f12472a);
                            motionLayout.c0();
                            return;
                        }
                        if (z12 && (this.f12474c & 16) != 0) {
                            motionLayout.setTransition(this.f12472a);
                            motionLayout.e0();
                        } else if (z10 && (this.f12474c & 256) != 0) {
                            motionLayout.setTransition(this.f12472a);
                            motionLayout.setProgress(1.0f);
                        } else {
                            if (!z12 || (this.f12474c & 4096) == 0) {
                                return;
                            }
                            motionLayout.setTransition(this.f12472a);
                            motionLayout.setProgress(0.0f);
                        }
                    }
                }
            }
        }

        public b(q qVar, b bVar) {
            this.f12454a = -1;
            this.f12455b = false;
            this.f12456c = -1;
            this.f12457d = -1;
            this.f12458e = 0;
            this.f12459f = null;
            this.f12460g = -1;
            this.f12461h = Const.I_TILE_TINY;
            this.f12462i = 0.0f;
            this.f12464k = new ArrayList<>();
            this.f12465l = null;
            this.f12466m = new ArrayList<>();
            this.f12467n = 0;
            this.f12468o = false;
            this.f12469p = -1;
            this.f12470q = 0;
            this.f12471r = 0;
            this.f12463j = qVar;
            this.f12461h = qVar.f12442k;
            if (bVar != null) {
                this.f12469p = bVar.f12469p;
                this.f12458e = bVar.f12458e;
                this.f12459f = bVar.f12459f;
                this.f12460g = bVar.f12460g;
                this.f12461h = bVar.f12461h;
                this.f12464k = bVar.f12464k;
                this.f12462i = bVar.f12462i;
                this.f12470q = bVar.f12470q;
            }
        }

        public int A() {
            return this.f12457d;
        }

        public r B() {
            return this.f12465l;
        }

        public boolean C() {
            return !this.f12468o;
        }

        public boolean D(int i10) {
            return (this.f12471r & i10) != 0;
        }

        public void E(int i10) {
            this.f12461h = Math.max(i10, 8);
        }

        public void F(int i10, String str, int i11) {
            this.f12458e = i10;
            this.f12459f = str;
            this.f12460g = i11;
        }

        public void G(int i10) {
            this.f12469p = i10;
        }

        public void t(g gVar) {
            this.f12464k.add(gVar);
        }

        public void u(Context context, XmlPullParser xmlPullParser) {
            this.f12466m.add(new a(context, this, xmlPullParser));
        }

        public final void v(q qVar, Context context, TypedArray typedArray) throws Resources.NotFoundException {
            int indexCount = typedArray.getIndexCount();
            for (int i10 = 0; i10 < indexCount; i10++) {
                int index = typedArray.getIndex(i10);
                if (index == R$styleable.Transition_constraintSetEnd) {
                    this.f12456c = typedArray.getResourceId(index, -1);
                    String resourceTypeName = context.getResources().getResourceTypeName(this.f12456c);
                    if ("layout".equals(resourceTypeName)) {
                        androidx.constraintlayout.widget.c cVar = new androidx.constraintlayout.widget.c();
                        cVar.J(context, this.f12456c);
                        qVar.f12439h.append(this.f12456c, cVar);
                    } else if ("xml".equals(resourceTypeName)) {
                        this.f12456c = qVar.L(context, this.f12456c);
                    }
                } else if (index == R$styleable.Transition_constraintSetStart) {
                    this.f12457d = typedArray.getResourceId(index, this.f12457d);
                    String resourceTypeName2 = context.getResources().getResourceTypeName(this.f12457d);
                    if ("layout".equals(resourceTypeName2)) {
                        androidx.constraintlayout.widget.c cVar2 = new androidx.constraintlayout.widget.c();
                        cVar2.J(context, this.f12457d);
                        qVar.f12439h.append(this.f12457d, cVar2);
                    } else if ("xml".equals(resourceTypeName2)) {
                        this.f12457d = qVar.L(context, this.f12457d);
                    }
                } else if (index == R$styleable.Transition_motionInterpolator) {
                    int i11 = typedArray.peekValue(index).type;
                    if (i11 == 1) {
                        int resourceId = typedArray.getResourceId(index, -1);
                        this.f12460g = resourceId;
                        if (resourceId != -1) {
                            this.f12458e = -2;
                        }
                    } else if (i11 == 3) {
                        String string = typedArray.getString(index);
                        this.f12459f = string;
                        if (string != null) {
                            if (string.indexOf("/") > 0) {
                                this.f12460g = typedArray.getResourceId(index, -1);
                                this.f12458e = -2;
                            } else {
                                this.f12458e = -1;
                            }
                        }
                    } else {
                        this.f12458e = typedArray.getInteger(index, this.f12458e);
                    }
                } else if (index == R$styleable.Transition_duration) {
                    int i12 = typedArray.getInt(index, this.f12461h);
                    this.f12461h = i12;
                    if (i12 < 8) {
                        this.f12461h = 8;
                    }
                } else if (index == R$styleable.Transition_staggered) {
                    this.f12462i = typedArray.getFloat(index, this.f12462i);
                } else if (index == R$styleable.Transition_autoTransition) {
                    this.f12467n = typedArray.getInteger(index, this.f12467n);
                } else if (index == R$styleable.Transition_android_id) {
                    this.f12454a = typedArray.getResourceId(index, this.f12454a);
                } else if (index == R$styleable.Transition_transitionDisable) {
                    this.f12468o = typedArray.getBoolean(index, this.f12468o);
                } else if (index == R$styleable.Transition_pathMotionArc) {
                    this.f12469p = typedArray.getInteger(index, -1);
                } else if (index == R$styleable.Transition_layoutDuringTransition) {
                    this.f12470q = typedArray.getInteger(index, 0);
                } else if (index == R$styleable.Transition_transitionFlags) {
                    this.f12471r = typedArray.getInteger(index, 0);
                }
            }
            if (this.f12457d == -1) {
                this.f12455b = true;
            }
        }

        public final void w(q qVar, Context context, AttributeSet attributeSet) throws Resources.NotFoundException {
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.Transition);
            v(qVar, context, typedArrayObtainStyledAttributes);
            typedArrayObtainStyledAttributes.recycle();
        }

        public int x() {
            return this.f12467n;
        }

        public int y() {
            return this.f12456c;
        }

        public int z() {
            return this.f12470q;
        }

        public b(int i10, q qVar, int i11, int i12) {
            this.f12454a = -1;
            this.f12455b = false;
            this.f12456c = -1;
            this.f12457d = -1;
            this.f12458e = 0;
            this.f12459f = null;
            this.f12460g = -1;
            this.f12461h = Const.I_TILE_TINY;
            this.f12462i = 0.0f;
            this.f12464k = new ArrayList<>();
            this.f12465l = null;
            this.f12466m = new ArrayList<>();
            this.f12467n = 0;
            this.f12468o = false;
            this.f12469p = -1;
            this.f12470q = 0;
            this.f12471r = 0;
            this.f12454a = i10;
            this.f12463j = qVar;
            this.f12457d = i11;
            this.f12456c = i12;
            this.f12461h = qVar.f12442k;
            this.f12470q = qVar.f12443l;
        }

        public b(q qVar, Context context, XmlPullParser xmlPullParser) throws Resources.NotFoundException {
            this.f12454a = -1;
            this.f12455b = false;
            this.f12456c = -1;
            this.f12457d = -1;
            this.f12458e = 0;
            this.f12459f = null;
            this.f12460g = -1;
            this.f12461h = Const.I_TILE_TINY;
            this.f12462i = 0.0f;
            this.f12464k = new ArrayList<>();
            this.f12465l = null;
            this.f12466m = new ArrayList<>();
            this.f12467n = 0;
            this.f12468o = false;
            this.f12469p = -1;
            this.f12470q = 0;
            this.f12471r = 0;
            this.f12461h = qVar.f12442k;
            this.f12470q = qVar.f12443l;
            this.f12463j = qVar;
            w(qVar, context, Xml.asAttributeSet(xmlPullParser));
        }
    }
}
