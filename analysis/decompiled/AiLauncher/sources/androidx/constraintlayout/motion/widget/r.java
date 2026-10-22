package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Xml;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.motion.widget.MotionLayout;
import androidx.constraintlayout.widget.R$styleable;
import androidx.core.widget.NestedScrollView;
import org.xmlpull.v1.XmlPullParser;

/* loaded from: classes.dex */
public class r {

    /* renamed from: G, reason: collision with root package name */
    public static final float[][] f12475G = {new float[]{0.5f, 0.0f}, new float[]{0.0f, 0.5f}, new float[]{1.0f, 0.5f}, new float[]{0.5f, 1.0f}, new float[]{0.5f, 0.5f}, new float[]{0.0f, 0.5f}, new float[]{1.0f, 0.5f}};

    /* renamed from: H, reason: collision with root package name */
    public static final float[][] f12476H = {new float[]{0.0f, -1.0f}, new float[]{0.0f, 1.0f}, new float[]{-1.0f, 0.0f}, new float[]{1.0f, 0.0f}, new float[]{-1.0f, 0.0f}, new float[]{1.0f, 0.0f}};

    /* renamed from: r, reason: collision with root package name */
    public float f12500r;

    /* renamed from: s, reason: collision with root package name */
    public float f12501s;

    /* renamed from: t, reason: collision with root package name */
    public final MotionLayout f12502t;

    /* renamed from: a, reason: collision with root package name */
    public int f12483a = 0;

    /* renamed from: b, reason: collision with root package name */
    public int f12484b = 0;

    /* renamed from: c, reason: collision with root package name */
    public int f12485c = 0;

    /* renamed from: d, reason: collision with root package name */
    public int f12486d = -1;

    /* renamed from: e, reason: collision with root package name */
    public int f12487e = -1;

    /* renamed from: f, reason: collision with root package name */
    public int f12488f = -1;

    /* renamed from: g, reason: collision with root package name */
    public float f12489g = 0.5f;

    /* renamed from: h, reason: collision with root package name */
    public float f12490h = 0.5f;

    /* renamed from: i, reason: collision with root package name */
    public float f12491i = 0.5f;

    /* renamed from: j, reason: collision with root package name */
    public float f12492j = 0.5f;

    /* renamed from: k, reason: collision with root package name */
    public int f12493k = -1;

    /* renamed from: l, reason: collision with root package name */
    public boolean f12494l = false;

    /* renamed from: m, reason: collision with root package name */
    public float f12495m = 0.0f;

    /* renamed from: n, reason: collision with root package name */
    public float f12496n = 1.0f;

    /* renamed from: o, reason: collision with root package name */
    public boolean f12497o = false;

    /* renamed from: p, reason: collision with root package name */
    public float[] f12498p = new float[2];

    /* renamed from: q, reason: collision with root package name */
    public int[] f12499q = new int[2];

    /* renamed from: u, reason: collision with root package name */
    public float f12503u = 4.0f;

    /* renamed from: v, reason: collision with root package name */
    public float f12504v = 1.2f;

    /* renamed from: w, reason: collision with root package name */
    public boolean f12505w = true;

    /* renamed from: x, reason: collision with root package name */
    public float f12506x = 1.0f;

    /* renamed from: y, reason: collision with root package name */
    public int f12507y = 0;

    /* renamed from: z, reason: collision with root package name */
    public float f12508z = 10.0f;

    /* renamed from: A, reason: collision with root package name */
    public float f12477A = 10.0f;

    /* renamed from: B, reason: collision with root package name */
    public float f12478B = 1.0f;

    /* renamed from: C, reason: collision with root package name */
    public float f12479C = Float.NaN;

    /* renamed from: D, reason: collision with root package name */
    public float f12480D = Float.NaN;

    /* renamed from: E, reason: collision with root package name */
    public int f12481E = 0;

    /* renamed from: F, reason: collision with root package name */
    public int f12482F = 0;

    public class a implements View.OnTouchListener {
        public a() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            return false;
        }
    }

    public class b implements NestedScrollView.e {
        public b() {
        }

        @Override // androidx.core.widget.NestedScrollView.e
        public void a(NestedScrollView nestedScrollView, int i10, int i11, int i12, int i13) {
        }
    }

    public r(Context context, MotionLayout motionLayout, XmlPullParser xmlPullParser) {
        this.f12502t = motionLayout;
        c(context, Xml.asAttributeSet(xmlPullParser));
    }

    public float a(float f10, float f11) {
        return (f10 * this.f12495m) + (f11 * this.f12496n);
    }

    public final void b(TypedArray typedArray) {
        int indexCount = typedArray.getIndexCount();
        for (int i10 = 0; i10 < indexCount; i10++) {
            int index = typedArray.getIndex(i10);
            if (index == R$styleable.OnSwipe_touchAnchorId) {
                this.f12486d = typedArray.getResourceId(index, this.f12486d);
            } else if (index == R$styleable.OnSwipe_touchAnchorSide) {
                int i11 = typedArray.getInt(index, this.f12483a);
                this.f12483a = i11;
                float[] fArr = f12475G[i11];
                this.f12490h = fArr[0];
                this.f12489g = fArr[1];
            } else if (index == R$styleable.OnSwipe_dragDirection) {
                int i12 = typedArray.getInt(index, this.f12484b);
                this.f12484b = i12;
                float[][] fArr2 = f12476H;
                if (i12 < fArr2.length) {
                    float[] fArr3 = fArr2[i12];
                    this.f12495m = fArr3[0];
                    this.f12496n = fArr3[1];
                } else {
                    this.f12496n = Float.NaN;
                    this.f12495m = Float.NaN;
                    this.f12494l = true;
                }
            } else if (index == R$styleable.OnSwipe_maxVelocity) {
                this.f12503u = typedArray.getFloat(index, this.f12503u);
            } else if (index == R$styleable.OnSwipe_maxAcceleration) {
                this.f12504v = typedArray.getFloat(index, this.f12504v);
            } else if (index == R$styleable.OnSwipe_moveWhenScrollAtTop) {
                this.f12505w = typedArray.getBoolean(index, this.f12505w);
            } else if (index == R$styleable.OnSwipe_dragScale) {
                this.f12506x = typedArray.getFloat(index, this.f12506x);
            } else if (index == R$styleable.OnSwipe_dragThreshold) {
                this.f12508z = typedArray.getFloat(index, this.f12508z);
            } else if (index == R$styleable.OnSwipe_touchRegionId) {
                this.f12487e = typedArray.getResourceId(index, this.f12487e);
            } else if (index == R$styleable.OnSwipe_onTouchUp) {
                this.f12485c = typedArray.getInt(index, this.f12485c);
            } else if (index == R$styleable.OnSwipe_nestedScrollFlags) {
                this.f12507y = typedArray.getInteger(index, 0);
            } else if (index == R$styleable.OnSwipe_limitBoundsTo) {
                this.f12488f = typedArray.getResourceId(index, 0);
            } else if (index == R$styleable.OnSwipe_rotationCenterId) {
                this.f12493k = typedArray.getResourceId(index, this.f12493k);
            } else if (index == R$styleable.OnSwipe_springDamping) {
                this.f12477A = typedArray.getFloat(index, this.f12477A);
            } else if (index == R$styleable.OnSwipe_springMass) {
                this.f12478B = typedArray.getFloat(index, this.f12478B);
            } else if (index == R$styleable.OnSwipe_springStiffness) {
                this.f12479C = typedArray.getFloat(index, this.f12479C);
            } else if (index == R$styleable.OnSwipe_springStopThreshold) {
                this.f12480D = typedArray.getFloat(index, this.f12480D);
            } else if (index == R$styleable.OnSwipe_springBoundary) {
                this.f12481E = typedArray.getInt(index, this.f12481E);
            } else if (index == R$styleable.OnSwipe_autoCompleteMode) {
                this.f12482F = typedArray.getInt(index, this.f12482F);
            }
        }
    }

    public final void c(Context context, AttributeSet attributeSet) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.OnSwipe);
        b(typedArrayObtainStyledAttributes);
        typedArrayObtainStyledAttributes.recycle();
    }

    public int d() {
        return this.f12482F;
    }

    public int e() {
        return this.f12507y;
    }

    public RectF f(ViewGroup viewGroup, RectF rectF) {
        View viewFindViewById;
        int i10 = this.f12488f;
        if (i10 == -1 || (viewFindViewById = viewGroup.findViewById(i10)) == null) {
            return null;
        }
        rectF.set(viewFindViewById.getLeft(), viewFindViewById.getTop(), viewFindViewById.getRight(), viewFindViewById.getBottom());
        return rectF;
    }

    public float g() {
        return this.f12504v;
    }

    public float h() {
        return this.f12503u;
    }

    public boolean i() {
        return this.f12505w;
    }

    public float j(float f10, float f11) throws Resources.NotFoundException {
        this.f12502t.M(this.f12486d, this.f12502t.getProgress(), this.f12490h, this.f12489g, this.f12498p);
        float f12 = this.f12495m;
        if (f12 != 0.0f) {
            float[] fArr = this.f12498p;
            if (fArr[0] == 0.0f) {
                fArr[0] = 1.0E-7f;
            }
            return (f10 * f12) / fArr[0];
        }
        float[] fArr2 = this.f12498p;
        if (fArr2[1] == 0.0f) {
            fArr2[1] = 1.0E-7f;
        }
        return (f11 * this.f12496n) / fArr2[1];
    }

    public int k() {
        return this.f12481E;
    }

    public float l() {
        return this.f12477A;
    }

    public float m() {
        return this.f12478B;
    }

    public float n() {
        return this.f12479C;
    }

    public float o() {
        return this.f12480D;
    }

    public RectF p(ViewGroup viewGroup, RectF rectF) {
        View viewFindViewById;
        int i10 = this.f12487e;
        if (i10 == -1 || (viewFindViewById = viewGroup.findViewById(i10)) == null) {
            return null;
        }
        rectF.set(viewFindViewById.getLeft(), viewFindViewById.getTop(), viewFindViewById.getRight(), viewFindViewById.getBottom());
        return rectF;
    }

    public int q() {
        return this.f12487e;
    }

    public boolean r() {
        return this.f12497o;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r23v2 */
    /* JADX WARN: Type inference failed for: r23v3 */
    /* JADX WARN: Type inference failed for: r23v4 */
    /* JADX WARN: Type inference failed for: r24v1 */
    /* JADX WARN: Type inference failed for: r24v2 */
    /* JADX WARN: Type inference failed for: r24v3 */
    public void s(MotionEvent motionEvent, MotionLayout.g gVar, int i10, q qVar) throws Resources.NotFoundException {
        char c10;
        int i11;
        ?? r23;
        float f10;
        ?? r24;
        if (this.f12494l) {
            t(motionEvent, gVar, i10, qVar);
            return;
        }
        gVar.a(motionEvent);
        int action = motionEvent.getAction();
        if (action == 0) {
            this.f12500r = motionEvent.getRawX();
            this.f12501s = motionEvent.getRawY();
            this.f12497o = false;
            return;
        }
        if (action == 1) {
            this.f12497o = false;
            gVar.d(1000);
            float fC = gVar.c();
            float fB = gVar.b();
            float progress = this.f12502t.getProgress();
            int i12 = this.f12486d;
            if (i12 != -1) {
                this.f12502t.M(i12, progress, this.f12490h, this.f12489g, this.f12498p);
                c10 = 0;
            } else {
                float fMin = Math.min(this.f12502t.getWidth(), this.f12502t.getHeight());
                float[] fArr = this.f12498p;
                fArr[1] = this.f12496n * fMin;
                c10 = 0;
                fArr[0] = fMin * this.f12495m;
            }
            float f11 = this.f12495m;
            float[] fArr2 = this.f12498p;
            float fAbs = f11 != 0.0f ? fC / fArr2[c10] : fB / fArr2[1];
            float f12 = !Float.isNaN(fAbs) ? (fAbs / 3.0f) + progress : progress;
            if (f12 == 0.0f || f12 == 1.0f || (i11 = this.f12485c) == 3) {
                if (0.0f >= f12 || 1.0f <= f12) {
                    this.f12502t.setState(MotionLayout.TransitionState.FINISHED);
                    return;
                }
                return;
            }
            float f13 = ((double) f12) < 0.5d ? 0.0f : 1.0f;
            if (i11 == 6) {
                if (progress + fAbs < 0.0f) {
                    fAbs = Math.abs(fAbs);
                }
                f13 = 1.0f;
            }
            if (this.f12485c == 7) {
                if (progress + fAbs > 1.0f) {
                    fAbs = -Math.abs(fAbs);
                }
                f13 = 0.0f;
            }
            this.f12502t.b0(this.f12485c, f13, fAbs);
            if (0.0f >= progress || 1.0f <= progress) {
                this.f12502t.setState(MotionLayout.TransitionState.FINISHED);
                return;
            }
            return;
        }
        if (action != 2) {
            return;
        }
        float rawY = motionEvent.getRawY() - this.f12501s;
        float rawX = motionEvent.getRawX() - this.f12500r;
        if (Math.abs((this.f12495m * rawX) + (this.f12496n * rawY)) > this.f12508z || this.f12497o) {
            float progress2 = this.f12502t.getProgress();
            if (!this.f12497o) {
                this.f12497o = true;
                this.f12502t.setProgress(progress2);
            }
            int i13 = this.f12486d;
            if (i13 != -1) {
                r23 = 1;
                r24 = 0;
                f10 = progress2;
                this.f12502t.M(i13, f10, this.f12490h, this.f12489g, this.f12498p);
            } else {
                r23 = 1;
                f10 = progress2;
                r24 = 0;
                float fMin2 = Math.min(this.f12502t.getWidth(), this.f12502t.getHeight());
                float[] fArr3 = this.f12498p;
                fArr3[1] = this.f12496n * fMin2;
                fArr3[0] = fMin2 * this.f12495m;
            }
            float f14 = this.f12495m;
            float[] fArr4 = this.f12498p;
            if (Math.abs(((f14 * fArr4[r24]) + (this.f12496n * fArr4[r23])) * this.f12506x) < 0.01d) {
                float[] fArr5 = this.f12498p;
                fArr5[r24] = 0.01f;
                fArr5[r23] = 0.01f;
            }
            float fMax = Math.max(Math.min(f10 + (this.f12495m != 0.0f ? rawX / this.f12498p[r24] : rawY / this.f12498p[r23]), 1.0f), 0.0f);
            if (this.f12485c == 6) {
                fMax = Math.max(fMax, 0.01f);
            }
            if (this.f12485c == 7) {
                fMax = Math.min(fMax, 0.99f);
            }
            float progress3 = this.f12502t.getProgress();
            if (fMax != progress3) {
                if (progress3 == 0.0f || progress3 == 1.0f) {
                    this.f12502t.F(progress3 == 0.0f ? r23 : r24);
                }
                this.f12502t.setProgress(fMax);
                gVar.d(1000);
                this.f12502t.mLastVelocity = this.f12495m != 0.0f ? gVar.c() / this.f12498p[r24] : gVar.b() / this.f12498p[r23];
            } else {
                this.f12502t.mLastVelocity = 0.0f;
            }
            this.f12500r = motionEvent.getRawX();
            this.f12501s = motionEvent.getRawY();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:59:0x0276  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0290  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x02ae  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x02bb  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void t(android.view.MotionEvent r24, androidx.constraintlayout.motion.widget.MotionLayout.g r25, int r26, androidx.constraintlayout.motion.widget.q r27) throws android.content.res.Resources.NotFoundException {
        /*
            Method dump skipped, instructions count: 824
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.motion.widget.r.t(android.view.MotionEvent, androidx.constraintlayout.motion.widget.MotionLayout$g, int, androidx.constraintlayout.motion.widget.q):void");
    }

    public String toString() {
        if (Float.isNaN(this.f12495m)) {
            return "rotation";
        }
        return this.f12495m + " , " + this.f12496n;
    }

    public void u(float f10, float f11) throws Resources.NotFoundException {
        float progress = this.f12502t.getProgress();
        if (!this.f12497o) {
            this.f12497o = true;
            this.f12502t.setProgress(progress);
        }
        this.f12502t.M(this.f12486d, progress, this.f12490h, this.f12489g, this.f12498p);
        float f12 = this.f12495m;
        float[] fArr = this.f12498p;
        if (Math.abs((f12 * fArr[0]) + (this.f12496n * fArr[1])) < 0.01d) {
            float[] fArr2 = this.f12498p;
            fArr2[0] = 0.01f;
            fArr2[1] = 0.01f;
        }
        float f13 = this.f12495m;
        float fMax = Math.max(Math.min(progress + (f13 != 0.0f ? (f10 * f13) / this.f12498p[0] : (f11 * this.f12496n) / this.f12498p[1]), 1.0f), 0.0f);
        if (fMax != this.f12502t.getProgress()) {
            this.f12502t.setProgress(fMax);
        }
    }

    public void v(float f10, float f11) throws Resources.NotFoundException {
        int i10;
        this.f12497o = false;
        float progress = this.f12502t.getProgress();
        this.f12502t.M(this.f12486d, progress, this.f12490h, this.f12489g, this.f12498p);
        float f12 = this.f12495m;
        float[] fArr = this.f12498p;
        float f13 = f12 != 0.0f ? (f10 * f12) / fArr[0] : (f11 * this.f12496n) / fArr[1];
        if (!Float.isNaN(f13)) {
            progress += f13 / 3.0f;
        }
        if (progress == 0.0f || progress == 1.0f || (i10 = this.f12485c) == 3) {
            return;
        }
        this.f12502t.b0(i10, ((double) progress) >= 0.5d ? 1.0f : 0.0f, f13);
    }

    public void w(float f10, float f11) {
        this.f12500r = f10;
        this.f12501s = f11;
    }

    public void x(boolean z10) {
        if (z10) {
            float[][] fArr = f12476H;
            fArr[4] = fArr[3];
            fArr[5] = fArr[2];
            float[][] fArr2 = f12475G;
            fArr2[5] = fArr2[2];
            fArr2[6] = fArr2[1];
        } else {
            float[][] fArr3 = f12476H;
            fArr3[4] = fArr3[2];
            fArr3[5] = fArr3[3];
            float[][] fArr4 = f12475G;
            fArr4[5] = fArr4[1];
            fArr4[6] = fArr4[2];
        }
        float[] fArr5 = f12475G[this.f12483a];
        this.f12490h = fArr5[0];
        this.f12489g = fArr5[1];
        int i10 = this.f12484b;
        float[][] fArr6 = f12476H;
        if (i10 >= fArr6.length) {
            return;
        }
        float[] fArr7 = fArr6[i10];
        this.f12495m = fArr7[0];
        this.f12496n = fArr7[1];
    }

    public void y(float f10, float f11) {
        this.f12500r = f10;
        this.f12501s = f11;
        this.f12497o = false;
    }

    public void z() {
        View viewFindViewById;
        int i10 = this.f12486d;
        if (i10 != -1) {
            viewFindViewById = this.f12502t.findViewById(i10);
            if (viewFindViewById == null) {
                Log.e("TouchResponse", "cannot find TouchAnchorId @id/" + androidx.constraintlayout.motion.widget.a.c(this.f12502t.getContext(), this.f12486d));
            }
        } else {
            viewFindViewById = null;
        }
        if (viewFindViewById instanceof NestedScrollView) {
            NestedScrollView nestedScrollView = (NestedScrollView) viewFindViewById;
            nestedScrollView.setOnTouchListener(new a());
            nestedScrollView.setOnScrollChangeListener(new b());
        }
    }
}
