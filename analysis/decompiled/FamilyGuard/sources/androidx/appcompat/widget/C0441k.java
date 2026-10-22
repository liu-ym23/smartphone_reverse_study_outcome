package androidx.appcompat.widget;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import androidx.appcompat.widget.P;
import g.C0728a;
import h.C0744a;

/* renamed from: androidx.appcompat.widget.k, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0441k {

    /* renamed from: b, reason: collision with root package name */
    private static final PorterDuff.Mode f8572b = PorterDuff.Mode.SRC_IN;

    /* renamed from: c, reason: collision with root package name */
    private static C0441k f8573c;

    /* renamed from: a, reason: collision with root package name */
    private P f8574a;

    /* renamed from: androidx.appcompat.widget.k$a */
    class a implements P.c {

        /* renamed from: a, reason: collision with root package name */
        private final int[] f8575a = {g.e.f16885R, g.e.f16883P, g.e.f16887a};

        /* renamed from: b, reason: collision with root package name */
        private final int[] f8576b = {g.e.f16901o, g.e.f16869B, g.e.f16906t, g.e.f16902p, g.e.f16903q, g.e.f16905s, g.e.f16904r};

        /* renamed from: c, reason: collision with root package name */
        private final int[] f8577c = {g.e.f16882O, g.e.f16884Q, g.e.f16897k, g.e.f16878K, g.e.f16879L, g.e.f16880M, g.e.f16881N};

        /* renamed from: d, reason: collision with root package name */
        private final int[] f8578d = {g.e.f16909w, g.e.f16895i, g.e.f16908v};

        /* renamed from: e, reason: collision with root package name */
        private final int[] f8579e = {g.e.f16877J, g.e.f16886S};

        /* renamed from: f, reason: collision with root package name */
        private final int[] f8580f = {g.e.f16889c, g.e.f16893g, g.e.f16890d, g.e.f16894h};

        a() {
        }

        private boolean f(int[] iArr, int i5) {
            for (int i6 : iArr) {
                if (i6 == i5) {
                    return true;
                }
            }
            return false;
        }

        private ColorStateList g(Context context) {
            return h(context, 0);
        }

        private ColorStateList h(Context context, int i5) {
            int iC = V.c(context, C0728a.f16848y);
            return new ColorStateList(new int[][]{V.f8445b, V.f8448e, V.f8446c, V.f8452i}, new int[]{V.b(context, C0728a.f16846w), androidx.core.graphics.a.g(iC, i5), androidx.core.graphics.a.g(iC, i5), i5});
        }

        private ColorStateList i(Context context) {
            return h(context, V.c(context, C0728a.f16845v));
        }

        private ColorStateList j(Context context) {
            return h(context, V.c(context, C0728a.f16846w));
        }

        private ColorStateList k(Context context) {
            int[][] iArr = new int[3][];
            int[] iArr2 = new int[3];
            int i5 = C0728a.f16806C;
            ColorStateList colorStateListE = V.e(context, i5);
            if (colorStateListE == null || !colorStateListE.isStateful()) {
                iArr[0] = V.f8445b;
                iArr2[0] = V.b(context, i5);
                iArr[1] = V.f8449f;
                iArr2[1] = V.c(context, C0728a.f16847x);
                iArr[2] = V.f8452i;
                iArr2[2] = V.c(context, i5);
            } else {
                int[] iArr3 = V.f8445b;
                iArr[0] = iArr3;
                iArr2[0] = colorStateListE.getColorForState(iArr3, 0);
                iArr[1] = V.f8449f;
                iArr2[1] = V.c(context, C0728a.f16847x);
                iArr[2] = V.f8452i;
                iArr2[2] = colorStateListE.getDefaultColor();
            }
            return new ColorStateList(iArr, iArr2);
        }

        private LayerDrawable l(P p5, Context context, int i5) throws Resources.NotFoundException {
            BitmapDrawable bitmapDrawable;
            BitmapDrawable bitmapDrawable2;
            BitmapDrawable bitmapDrawable3;
            int dimensionPixelSize = context.getResources().getDimensionPixelSize(i5);
            Drawable drawableI = p5.i(context, g.e.f16873F);
            Drawable drawableI2 = p5.i(context, g.e.f16874G);
            if ((drawableI instanceof BitmapDrawable) && drawableI.getIntrinsicWidth() == dimensionPixelSize && drawableI.getIntrinsicHeight() == dimensionPixelSize) {
                bitmapDrawable = (BitmapDrawable) drawableI;
                bitmapDrawable2 = new BitmapDrawable(bitmapDrawable.getBitmap());
            } else {
                Bitmap bitmapCreateBitmap = Bitmap.createBitmap(dimensionPixelSize, dimensionPixelSize, Bitmap.Config.ARGB_8888);
                Canvas canvas = new Canvas(bitmapCreateBitmap);
                drawableI.setBounds(0, 0, dimensionPixelSize, dimensionPixelSize);
                drawableI.draw(canvas);
                bitmapDrawable = new BitmapDrawable(bitmapCreateBitmap);
                bitmapDrawable2 = new BitmapDrawable(bitmapCreateBitmap);
            }
            bitmapDrawable2.setTileModeX(Shader.TileMode.REPEAT);
            if ((drawableI2 instanceof BitmapDrawable) && drawableI2.getIntrinsicWidth() == dimensionPixelSize && drawableI2.getIntrinsicHeight() == dimensionPixelSize) {
                bitmapDrawable3 = (BitmapDrawable) drawableI2;
            } else {
                Bitmap bitmapCreateBitmap2 = Bitmap.createBitmap(dimensionPixelSize, dimensionPixelSize, Bitmap.Config.ARGB_8888);
                Canvas canvas2 = new Canvas(bitmapCreateBitmap2);
                drawableI2.setBounds(0, 0, dimensionPixelSize, dimensionPixelSize);
                drawableI2.draw(canvas2);
                bitmapDrawable3 = new BitmapDrawable(bitmapCreateBitmap2);
            }
            LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{bitmapDrawable, bitmapDrawable3, bitmapDrawable2});
            layerDrawable.setId(0, R.id.background);
            layerDrawable.setId(1, R.id.secondaryProgress);
            layerDrawable.setId(2, R.id.progress);
            return layerDrawable;
        }

        private void m(Drawable drawable, int i5, PorterDuff.Mode mode) {
            Drawable drawableMutate = drawable.mutate();
            if (mode == null) {
                mode = C0441k.f8572b;
            }
            drawableMutate.setColorFilter(C0441k.e(i5, mode));
        }

        /* JADX WARN: Removed duplicated region for block: B:22:0x004b  */
        /* JADX WARN: Removed duplicated region for block: B:26:0x0060 A[RETURN] */
        @Override // androidx.appcompat.widget.P.c
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public boolean a(android.content.Context r6, int r7, android.graphics.drawable.Drawable r8) {
            /*
                r5 = this;
                android.graphics.PorterDuff$Mode r0 = androidx.appcompat.widget.C0441k.a()
                int[] r1 = r5.f8575a
                boolean r1 = r5.f(r1, r7)
                r2 = 1
                r3 = 0
                r4 = -1
                if (r1 == 0) goto L14
                int r5 = g.C0728a.f16849z
            L11:
                r1 = r2
            L12:
                r7 = r4
                goto L49
            L14:
                int[] r1 = r5.f8577c
                boolean r1 = r5.f(r1, r7)
                if (r1 == 0) goto L1f
                int r5 = g.C0728a.f16847x
                goto L11
            L1f:
                int[] r1 = r5.f8578d
                boolean r5 = r5.f(r1, r7)
                r1 = 16842801(0x1010031, float:2.3693695E-38)
                if (r5 == 0) goto L2e
                android.graphics.PorterDuff$Mode r0 = android.graphics.PorterDuff.Mode.MULTIPLY
            L2c:
                r5 = r1
                goto L11
            L2e:
                int r5 = g.e.f16907u
                if (r7 != r5) goto L41
                r5 = 1109603123(0x42233333, float:40.8)
                int r5 = java.lang.Math.round(r5)
                r7 = 16842800(0x1010030, float:2.3693693E-38)
                r1 = r7
                r7 = r5
                r5 = r1
                r1 = r2
                goto L49
            L41:
                int r5 = g.e.f16898l
                if (r7 != r5) goto L46
                goto L2c
            L46:
                r5 = r3
                r1 = r5
                goto L12
            L49:
                if (r1 == 0) goto L60
                android.graphics.drawable.Drawable r8 = r8.mutate()
                int r5 = androidx.appcompat.widget.V.c(r6, r5)
                android.graphics.PorterDuffColorFilter r5 = androidx.appcompat.widget.C0441k.e(r5, r0)
                r8.setColorFilter(r5)
                if (r7 == r4) goto L5f
                r8.setAlpha(r7)
            L5f:
                return r2
            L60:
                return r3
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.C0441k.a.a(android.content.Context, int, android.graphics.drawable.Drawable):boolean");
        }

        @Override // androidx.appcompat.widget.P.c
        public PorterDuff.Mode b(int i5) {
            if (i5 == g.e.f16875H) {
                return PorterDuff.Mode.MULTIPLY;
            }
            return null;
        }

        @Override // androidx.appcompat.widget.P.c
        public Drawable c(P p5, Context context, int i5) {
            if (i5 == g.e.f16896j) {
                return new LayerDrawable(new Drawable[]{p5.i(context, g.e.f16895i), p5.i(context, g.e.f16897k)});
            }
            if (i5 == g.e.f16911y) {
                return l(p5, context, g.d.f16865g);
            }
            if (i5 == g.e.f16910x) {
                return l(p5, context, g.d.f16866h);
            }
            if (i5 == g.e.f16912z) {
                return l(p5, context, g.d.f16867i);
            }
            return null;
        }

        @Override // androidx.appcompat.widget.P.c
        public ColorStateList d(Context context, int i5) {
            if (i5 == g.e.f16899m) {
                return C0744a.a(context, g.c.f16855e);
            }
            if (i5 == g.e.f16876I) {
                return C0744a.a(context, g.c.f16858h);
            }
            if (i5 == g.e.f16875H) {
                return k(context);
            }
            if (i5 == g.e.f16892f) {
                return j(context);
            }
            if (i5 == g.e.f16888b) {
                return g(context);
            }
            if (i5 == g.e.f16891e) {
                return i(context);
            }
            if (i5 == g.e.f16871D || i5 == g.e.f16872E) {
                return C0744a.a(context, g.c.f16857g);
            }
            if (f(this.f8576b, i5)) {
                return V.e(context, C0728a.f16849z);
            }
            if (f(this.f8579e, i5)) {
                return C0744a.a(context, g.c.f16854d);
            }
            if (f(this.f8580f, i5)) {
                return C0744a.a(context, g.c.f16853c);
            }
            if (i5 == g.e.f16868A) {
                return C0744a.a(context, g.c.f16856f);
            }
            return null;
        }

        @Override // androidx.appcompat.widget.P.c
        public boolean e(Context context, int i5, Drawable drawable) {
            if (i5 == g.e.f16870C) {
                LayerDrawable layerDrawable = (LayerDrawable) drawable;
                Drawable drawableFindDrawableByLayerId = layerDrawable.findDrawableByLayerId(R.id.background);
                int i6 = C0728a.f16849z;
                m(drawableFindDrawableByLayerId, V.c(context, i6), C0441k.f8572b);
                m(layerDrawable.findDrawableByLayerId(R.id.secondaryProgress), V.c(context, i6), C0441k.f8572b);
                m(layerDrawable.findDrawableByLayerId(R.id.progress), V.c(context, C0728a.f16847x), C0441k.f8572b);
                return true;
            }
            if (i5 != g.e.f16911y && i5 != g.e.f16910x && i5 != g.e.f16912z) {
                return false;
            }
            LayerDrawable layerDrawable2 = (LayerDrawable) drawable;
            m(layerDrawable2.findDrawableByLayerId(R.id.background), V.b(context, C0728a.f16849z), C0441k.f8572b);
            Drawable drawableFindDrawableByLayerId2 = layerDrawable2.findDrawableByLayerId(R.id.secondaryProgress);
            int i7 = C0728a.f16847x;
            m(drawableFindDrawableByLayerId2, V.c(context, i7), C0441k.f8572b);
            m(layerDrawable2.findDrawableByLayerId(R.id.progress), V.c(context, i7), C0441k.f8572b);
            return true;
        }
    }

    public static synchronized C0441k b() {
        try {
            if (f8573c == null) {
                h();
            }
        } catch (Throwable th) {
            throw th;
        }
        return f8573c;
    }

    public static synchronized PorterDuffColorFilter e(int i5, PorterDuff.Mode mode) {
        return P.k(i5, mode);
    }

    public static synchronized void h() {
        if (f8573c == null) {
            C0441k c0441k = new C0441k();
            f8573c = c0441k;
            c0441k.f8574a = P.g();
            f8573c.f8574a.t(new a());
        }
    }

    static void i(Drawable drawable, Y y5, int[] iArr) {
        P.v(drawable, y5, iArr);
    }

    public synchronized Drawable c(Context context, int i5) {
        return this.f8574a.i(context, i5);
    }

    synchronized Drawable d(Context context, int i5, boolean z5) {
        return this.f8574a.j(context, i5, z5);
    }

    synchronized ColorStateList f(Context context, int i5) {
        return this.f8574a.l(context, i5);
    }

    public synchronized void g(Context context) {
        this.f8574a.r(context);
    }
}
