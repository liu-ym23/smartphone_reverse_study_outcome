package M;

import android.graphics.RectF;
import android.util.Rational;
import android.util.Size;
import java.util.Comparator;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final Rational f4454a = new Rational(4, 3);

    /* renamed from: b, reason: collision with root package name */
    public static final Rational f4455b = new Rational(3, 4);

    /* renamed from: c, reason: collision with root package name */
    public static final Rational f4456c = new Rational(16, 9);

    /* renamed from: d, reason: collision with root package name */
    public static final Rational f4457d = new Rational(9, 16);

    /* renamed from: M.a$a, reason: collision with other inner class name */
    public static final class C0078a implements Comparator<Rational> {

        /* renamed from: a, reason: collision with root package name */
        public final Rational f4458a;

        /* renamed from: b, reason: collision with root package name */
        public final RectF f4459b;

        /* renamed from: c, reason: collision with root package name */
        public final Rational f4460c;

        public C0078a(Rational rational, Rational rational2) {
            this.f4458a = rational;
            this.f4460c = rational2 == null ? new Rational(4, 3) : rational2;
            this.f4459b = d(rational);
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(Rational rational, Rational rational2) {
            if (rational.equals(rational2)) {
                return 0;
            }
            RectF rectFD = d(rational);
            RectF rectFD2 = d(rational2);
            boolean zE = e(rectFD, this.f4459b);
            boolean zE2 = e(rectFD2, this.f4459b);
            if (zE && zE2) {
                return (int) Math.signum(b(rectFD) - b(rectFD2));
            }
            if (zE) {
                return -1;
            }
            if (zE2) {
                return 1;
            }
            return -((int) Math.signum(c(rectFD, this.f4459b) - c(rectFD2, this.f4459b)));
        }

        public final float b(RectF rectF) {
            return rectF.width() * rectF.height();
        }

        public final float c(RectF rectF, RectF rectF2) {
            return (rectF.width() < rectF2.width() ? rectF.width() : rectF2.width()) * (rectF.height() < rectF2.height() ? rectF.height() : rectF2.height());
        }

        public final RectF d(Rational rational) {
            return rational.floatValue() == this.f4460c.floatValue() ? new RectF(0.0f, 0.0f, this.f4460c.getNumerator(), this.f4460c.getDenominator()) : rational.floatValue() > this.f4460c.floatValue() ? new RectF(0.0f, 0.0f, this.f4460c.getNumerator(), (rational.getDenominator() * this.f4460c.getNumerator()) / rational.getNumerator()) : new RectF(0.0f, 0.0f, (rational.getNumerator() * this.f4460c.getDenominator()) / rational.getDenominator(), this.f4460c.getDenominator());
        }

        public final boolean e(RectF rectF, RectF rectF2) {
            return rectF.width() >= rectF2.width() && rectF.height() >= rectF2.height();
        }
    }

    public static boolean a(Size size, Rational rational) {
        return b(size, rational, T.c.f5825c);
    }

    public static boolean b(Size size, Rational rational, Size size2) {
        if (rational == null) {
            return false;
        }
        if (rational.equals(new Rational(size.getWidth(), size.getHeight()))) {
            return true;
        }
        if (T.c.b(size) >= T.c.b(size2)) {
            return c(size, rational);
        }
        return false;
    }

    public static boolean c(Size size, Rational rational) {
        int width = size.getWidth();
        int height = size.getHeight();
        Rational rational2 = new Rational(rational.getDenominator(), rational.getNumerator());
        int i10 = width % 16;
        if (i10 == 0 && height % 16 == 0) {
            return d(Math.max(0, height + (-16)), width, rational) || d(Math.max(0, width + (-16)), height, rational2);
        }
        if (i10 == 0) {
            return d(height, width, rational);
        }
        if (height % 16 == 0) {
            return d(width, height, rational2);
        }
        return false;
    }

    public static boolean d(int i10, int i11, Rational rational) {
        B0.h.a(i11 % 16 == 0);
        double numerator = (i10 * rational.getNumerator()) / rational.getDenominator();
        return numerator > ((double) Math.max(0, i11 + (-16))) && numerator < ((double) (i11 + 16));
    }
}
