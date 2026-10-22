package org.apache.commons.math.dfp;

/* JADX INFO: loaded from: classes3.dex */
public class DfpMath {
    private static final String POW_TRAP = "pow";

    private DfpMath() {
    }

    protected static Dfp[] split(DfpField field, String a) {
        Dfp[] result = new Dfp[2];
        boolean leading = true;
        int sp = 0;
        int sig = 0;
        char[] buf = new char[a.length()];
        int i = 0;
    L4:
        if (i >= buf.length) goto L23;
        buf[i] = a.charAt(i);
        if (buf[i] < '1') goto L11;
        if (buf[i] > '9') goto L11;
        leading = false;
    L11:
        if (buf[i] != '.') goto L14;
        sig = sig + ((400 - sig) % 4);
        leading = false;
    L14:
        if (sig == ((field.getRadixDigits() / 2) * 4)) goto L15;
        if (buf[i] < '0') goto L22;
        if (buf[i] > '9') goto L22;
        if (leading == true) goto L22;
        sig = sig + 1;
    L22:
        i = i + 1;
        goto L4
    L15:
        sp = i;
    L23:
        result[0] = field.newDfp(new String(buf, 0, sp));
        int i2 = 0;
    L25:
        if (i2 >= buf.length) goto L33;
        buf[i2] = a.charAt(i2);
        if (buf[i2] < '0') goto L32;
        if (buf[i2] > '9') goto L32;
        if (i2 >= sp) goto L32;
        buf[i2] = '0';
    L32:
        i2 = i2 + 1;
        goto L25
    L33:
        result[1] = field.newDfp(new String(buf));
        return result;
    }

    protected static Dfp[] split(Dfp a) {
        Dfp[] result = new Dfp[2];
        Dfp shift = a.multiply2(a.power10K(a.getRadixDigits() / 2));
        result[0] = a.add2(shift).subtract2(shift);
        result[1] = a.subtract2(result[0]);
        return result;
    }

    protected static Dfp[] splitMult(Dfp[] a, Dfp[] b) {
        Dfp[] result = {a[0].multiply2(b[0]), a[0].getZero()};
        if (result[0].classify() != 1) goto L5;
    L9:
        return result;
    L5:
        if (result[0].equals(result[1]) == true) goto L9;
        result[1] = a[0].multiply2(b[1]).add2(a[1].multiply2(b[0])).add2(a[1].multiply2(b[1]));
        return result;
    }

    protected static Dfp[] splitDiv(Dfp[] a, Dfp[] b) {
        Dfp[] result = {a[0].divide2(b[0]), a[1].multiply2(b[0]).subtract2(a[0].multiply2(b[1]))};
        result[1] = result[1].divide2(b[0].multiply2(b[0]).add2(b[0].multiply2(b[1])));
        return result;
    }

    protected static Dfp splitPow(Dfp[] base, int a) {
        boolean invert = false;
        Dfp[] r = new Dfp[2];
        Dfp[] result = {base[0].getOne(), base[0].getZero()};
        if (a == 0) goto L5;
        if (a >= 0) goto L8;
        invert = true;
        a = -a;
    L8:
        r[0] = new Dfp(base[0]);
        r[1] = new Dfp(base[1]);
        int trial = 1;
    L9:
        int prevtrial = trial;
        trial = trial * 2;
        if (trial > a) goto L11;
        r = splitMult(r, r);
        goto L9
    L11:
        a = a - prevtrial;
        result = splitMult(result, r);
        if (a >= 1) goto L8;
        result[0] = result[0].add2(result[1]);
        if (invert == false) goto L17;
        result[0] = base[0].getOne().divide2(result[0]);
    L17:
        return result[0];
    L5:
        return result[0].add2(result[1]);
    }

    public static Dfp pow(Dfp base, int a) {
        boolean invert = false;
        Dfp result = base.getOne();
        if (a != 0) goto L5;
        return result;
    L5:
        if (a >= 0) goto L7;
        invert = true;
        a = -a;
    L7:
        Dfp r = new Dfp(base);
        int trial = 1;
    L8:
        Dfp prevr = new Dfp(r);
        int prevtrial = trial;
        r = r.multiply2(r);
        trial = trial * 2;
        if (a > trial) goto L8;
        a = a - prevtrial;
        result = result.multiply2(prevr);
        if (a >= 1) goto L7;
        if (invert == false) goto L15;
        result = base.getOne().divide2(result);
    L15:
        return base.newInstance(result);
    }

    /* JADX WARN: Type inference failed for: r3v2, types: [org.apache.commons.math.dfp.DfpField] */
    public static Dfp exp(Dfp a) {
        Dfp inta = a.rint();
        Dfp fraca = a.subtract2(inta);
        int ia = inta.intValue();
        if (ia <= 2147483646) goto L7;
        return a.newInstance((byte) 1, (byte) 1);
    L7:
        if (ia < (-2147483646)) goto L9;
        Dfp einta = splitPow(a.getField2().getESplit(), ia);
        Dfp efraca = expInternal(fraca);
        return einta.multiply2(efraca);
    L9:
        return a.newInstance();
    }

    protected static Dfp expInternal(Dfp a) {
        Dfp y = a.getOne();
        Dfp x = a.getOne();
        Dfp fact = a.getOne();
        Dfp py = new Dfp(y);
        int i = 1;
    L4:
        if (i >= 90) goto L9;
        x = x.multiply2(a);
        fact = fact.divide(i);
        y = y.add2(x.multiply2(fact));
        if (y.equals(py) == true) goto L9;
        py = new Dfp(y);
        i = i + 1;
    L9:
        return y;
    }

    /* JADX WARN: Type inference failed for: r1v2, types: [org.apache.commons.math.dfp.DfpField] */
    /* JADX WARN: Type inference failed for: r8v15, types: [org.apache.commons.math.dfp.DfpField] */
    /* JADX WARN: Type inference failed for: r8v25, types: [org.apache.commons.math.dfp.DfpField] */
    public static Dfp log(Dfp a) {
        int p2 = 0;
        if (a.equals(a.getZero()) == false) goto L5;
    L22:
        a.getField2().setIEEEFlagsBits(1);
        return a.dotrap(1, "ln", a, a.newInstance((byte) 1, (byte) 3));
    L5:
        if (a.lessThan(a.getZero()) == true) goto L22;
        if (a.isNaN() == true) goto L22;
        if (a.classify() != 1) goto L12;
        return a;
    L12:
        Dfp x = new Dfp(a);
        int lr = x.log10K();
        Dfp x2 = x.divide2(pow(a.newInstance(10000), lr));
        int ix = x2.floor().intValue();
    L14:
        if (ix <= 2) goto L16;
        ix = ix >> 1;
        p2 = p2 + 1;
        goto L14
    L16:
        Dfp[] spx = split(x2);
        Dfp[] spy = new Dfp[2];
        spy[0] = pow(a.getTwo(), p2);
        spx[0] = spx[0].divide2(spy[0]);
        spx[1] = spx[1].divide2(spy[0]);
        spy[0] = a.newInstance("1.33333");
    L18:
        if (spx[0].add2(spx[1]).greaterThan(spy[0]) == false) goto L20;
        spx[0] = spx[0].divide(2);
        spx[1] = spx[1].divide(2);
        p2 = p2 + 1;
        goto L18
    L20:
        Dfp[] spz = logInternal(spx);
        StringBuilder r8 = new StringBuilder();
        r8.append((lr * 4) + p2);
        spx[0] = a.newInstance(r8.toString());
        spx[1] = a.getZero();
        Dfp[] spy2 = splitMult(a.getField2().getLn2Split(), spx);
        spz[0] = spz[0].add2(spy2[0]);
        spz[1] = spz[1].add2(spy2[1]);
        StringBuilder r9 = new StringBuilder();
        r9.append(lr * 4);
        spx[0] = a.newInstance(r9.toString());
        spx[1] = a.getZero();
        Dfp[] spy3 = splitMult(a.getField2().getLn5Split(), spx);
        spz[0] = spz[0].add2(spy3[0]);
        spz[1] = spz[1].add2(spy3[1]);
        return a.newInstance(spz[0].add2(spz[1]));
    }

    protected static Dfp[] logInternal(Dfp[] a) {
        Dfp t = a[0].divide(4).add2(a[1].divide(4));
        Dfp x = t.add2(a[0].newInstance("-0.25")).divide2(t.add2(a[0].newInstance("0.25")));
        Dfp y = new Dfp(x);
        Dfp num = new Dfp(x);
        Dfp py = new Dfp(y);
        int den = 1;
        int i = 0;
    L4:
        if (i >= 10000) goto L10;
        num = num.multiply2(x).multiply2(x);
        den = den + 2;
        y = y.add2(num.divide(den));
        if (y.equals(py) == true) goto L10;
        py = new Dfp(y);
        i = i + 1;
    L10:
        return split(y.multiply2(a[0].getTwo()));
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [org.apache.commons.math.dfp.DfpField] */
    /* JADX WARN: Type inference failed for: r0v3, types: [org.apache.commons.math.dfp.DfpField] */
    /* JADX WARN: Type inference failed for: r1v0, types: [org.apache.commons.math.dfp.DfpField] */
    /* JADX WARN: Type inference failed for: r2v64, types: [org.apache.commons.math.dfp.DfpField] */
    /* JADX WARN: Type inference failed for: r7v23, types: [org.apache.commons.math.dfp.DfpField] */
    /* JADX WARN: Type inference failed for: r7v25, types: [org.apache.commons.math.dfp.DfpField] */
    /* JADX WARN: Type inference failed for: r7v3, types: [org.apache.commons.math.dfp.DfpField] */
    /* JADX WARN: Type inference failed for: r8v1, types: [org.apache.commons.math.dfp.DfpField] */
    /* JADX WARN: Type inference failed for: r9v0, types: [org.apache.commons.math.dfp.DfpField] */
    public static Dfp pow(Dfp x, Dfp y) {
        if (x.getField2().getRadixDigits() == y.getField2().getRadixDigits()) goto L6;
        x.getField2().setIEEEFlagsBits(1);
        Dfp result = x.newInstance(x.getZero());
        result.nans = 3;
        return x.dotrap(1, POW_TRAP, x, result);
    L6:
        Dfp zero = x.getZero();
        Dfp one = x.getOne();
        Dfp two = x.getTwo();
        boolean invert = false;
        if (y.equals(zero) == false) goto L11;
        return x.newInstance(one);
    L11:
        if (y.equals(one) == false) goto L18;
        if (x.isNaN() == false) goto L16;
        x.getField2().setIEEEFlagsBits(1);
        return x.dotrap(1, POW_TRAP, x, x);
    L16:
        return x;
    L18:
        if (x.isNaN() == false) goto L20;
    L127:
        x.getField2().setIEEEFlagsBits(1);
        return x.dotrap(1, POW_TRAP, x, x.newInstance((byte) 1, (byte) 3));
    L20:
        if (y.isNaN() == true) goto L127;
        if (x.equals(zero) == false) goto L51;
        if (Dfp.copysign(one, x).greaterThan(zero) == false) goto L33;
        if (y.greaterThan(zero) == false) goto L31;
        return x.newInstance(zero);
    L31:
        return x.newInstance(x.newInstance((byte) 1, (byte) 1));
    L33:
        if (y.classify() != 0) goto L45;
        if (y.rint().equals(y) == false) goto L45;
        if (y.remainder(two).equals(zero) == true) goto L45;
        if (y.greaterThan(zero) == false) goto L43;
        return x.newInstance(zero.negate());
    L43:
        return x.newInstance(x.newInstance((byte) -1, (byte) 1));
    L45:
        if (y.greaterThan(zero) == false) goto L49;
        return x.newInstance(zero);
    L49:
        return x.newInstance(x.newInstance((byte) 1, (byte) 1));
    L51:
        if (x.lessThan(zero) == false) goto L54;
        x = x.negate();
        invert = true;
    L54:
        if (x.greaterThan(one) == false) goto L63;
        if (y.classify() != 1) goto L63;
        if (y.greaterThan(zero) == false) goto L61;
        return y;
    L61:
        return x.newInstance(zero);
    L63:
        if (x.lessThan(one) == false) goto L73;
        if (y.classify() != 1) goto L73;
        if (y.greaterThan(zero) == false) goto L71;
        return x.newInstance(zero);
    L71:
        return x.newInstance(Dfp.copysign(y, one));
    L73:
        if (x.equals(one) == false) goto L79;
        if (y.classify() != 1) goto L79;
        x.getField2().setIEEEFlagsBits(1);
        return x.dotrap(1, POW_TRAP, x, x.newInstance((byte) 1, (byte) 3));
    L79:
        if (x.classify() != 1) goto L104;
        if (invert == false) goto L100;
        if (y.classify() != 0) goto L94;
        if (y.rint().equals(y) == false) goto L94;
        if (y.remainder(two).equals(zero) == true) goto L94;
        if (y.greaterThan(zero) == false) goto L92;
        return x.newInstance(x.newInstance((byte) -1, (byte) 1));
    L92:
        return x.newInstance(zero.negate());
    L94:
        if (y.greaterThan(zero) == false) goto L98;
        return x.newInstance(x.newInstance((byte) 1, (byte) 1));
    L98:
        return x.newInstance(zero);
    L100:
        if (y.greaterThan(zero) == false) goto L103;
        return x;
    L103:
        return x.newInstance(zero);
    L104:
        if (invert == false) goto L110;
        if (y.rint().equals(y) == true) goto L110;
        x.getField2().setIEEEFlagsBits(1);
        return x.dotrap(1, POW_TRAP, x, x.newInstance((byte) 1, (byte) 3));
    L110:
        if (y.lessThan(x.newInstance(100000000)) == true) goto L112;
    L118:
        Dfp a = exp(log(x).multiply2(y));
    L119:
        if (invert == false) goto L126;
        if (y.rint().equals(y) == false) goto L126;
        if (y.remainder(two).equals(zero) == true) goto L126;
        a = a.negate();
    L126:
        return x.newInstance(a);
    L112:
        if (y.greaterThan(x.newInstance(-100000000)) == false) goto L118;
        Dfp u = y.rint();
        int ui = u.intValue();
        Dfp v = y.subtract2(u);
        if (v.unequal(zero) == false) goto L116;
        Dfp a2 = v.multiply2(log(x));
        Dfp b = a2.divide2(x.getField2().getLn2()).rint();
        Dfp c = a2.subtract2(b.multiply2(x.getField2().getLn2()));
        Dfp r = splitPow(split(x), ui);
        a = r.multiply2(pow(two, b.intValue())).multiply2(exp(c));
        goto L119
    L116:
        a = splitPow(split(x), ui);
        goto L119
    }

    protected static Dfp sinInternal(Dfp[] a) {
        Dfp c = a[0].add2(a[1]);
        Dfp y = c;
        Dfp c2 = c.multiply2(c);
        Dfp x = y;
        Dfp fact = a[0].getOne();
        Dfp py = new Dfp(y);
        int i = 3;
    L4:
        if (i >= 90) goto L9;
        x = x.multiply2(c2).negate();
        fact = fact.divide((i - 1) * i);
        y = y.add2(x.multiply2(fact));
        if (y.equals(py) == true) goto L9;
        py = new Dfp(y);
        i = i + 2;
    L9:
        return y;
    }

    protected static Dfp cosInternal(Dfp[] a) {
        Dfp one = a[0].getOne();
        Dfp x = one;
        Dfp y = one;
        Dfp c = a[0].add2(a[1]);
        Dfp c2 = c.multiply2(c);
        Dfp fact = one;
        Dfp py = new Dfp(y);
        int i = 2;
    L4:
        if (i >= 90) goto L9;
        x = x.multiply2(c2).negate();
        fact = fact.divide((i - 1) * i);
        y = y.add2(x.multiply2(fact));
        if (y.equals(py) == true) goto L9;
        py = new Dfp(y);
        i = i + 2;
    L9:
        return y;
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [org.apache.commons.math.dfp.DfpField] */
    /* JADX WARN: Type inference failed for: r8v0, types: [org.apache.commons.math.dfp.DfpField] */
    public static Dfp sin(Dfp a) {
        Dfp pi = a.getField2().getPi();
        Dfp zero = a.getField2().getZero2();
        boolean neg = false;
        Dfp x = a.remainder(pi.multiply(2));
        if (x.lessThan(zero) == false) goto L6;
        x = x.negate();
        neg = true;
    L6:
        if (x.greaterThan(pi.divide(2)) == false) goto L9;
        x = pi.subtract2(x);
    L9:
        if (x.lessThan(pi.divide(4)) == false) goto L11;
        Dfp[] c = {x, zero};
        Dfp y = sinInternal(split(x));
    L12:
        if (neg == false) goto L15;
        y = y.negate();
    L15:
        return a.newInstance(y);
    L11:
        Dfp[] piSplit = a.getField2().getPiSplit();
        Dfp[] c2 = {piSplit[0].divide(2).subtract2(x), piSplit[1].divide(2)};
        y = cosInternal(c2);
        goto L12
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [org.apache.commons.math.dfp.DfpField] */
    /* JADX WARN: Type inference failed for: r8v0, types: [org.apache.commons.math.dfp.DfpField] */
    public static Dfp cos(Dfp a) {
        Dfp pi = a.getField2().getPi();
        Dfp zero = a.getField2().getZero2();
        boolean neg = false;
        Dfp x = a.remainder(pi.multiply(2));
        if (x.lessThan(zero) == false) goto L6;
        x = x.negate();
    L6:
        if (x.greaterThan(pi.divide(2)) == false) goto L9;
        x = pi.subtract2(x);
        neg = true;
    L9:
        if (x.lessThan(pi.divide(4)) == false) goto L11;
        Dfp[] c = {x, zero};
        Dfp y = cosInternal(c);
    L12:
        if (neg == false) goto L15;
        y = y.negate();
    L15:
        return a.newInstance(y);
    L11:
        Dfp[] piSplit = a.getField2().getPiSplit();
        Dfp[] c2 = {piSplit[0].divide(2).subtract2(x), piSplit[1].divide(2)};
        y = sinInternal(c2);
        goto L12
    }

    public static Dfp tan(Dfp a) {
        return sin(a).divide2(cos(a));
    }

    protected static Dfp atanInternal(Dfp a) {
        Dfp y = new Dfp(a);
        Dfp x = new Dfp(y);
        Dfp py = new Dfp(y);
        int i = 3;
    L4:
        if (i >= 90) goto L9;
        x = x.multiply2(a).multiply2(a).negate();
        y = y.add2(x.divide(i));
        if (y.equals(py) == true) goto L9;
        py = new Dfp(y);
        i = i + 2;
    L9:
        return y;
    }

    /* JADX WARN: Type inference failed for: r3v0, types: [org.apache.commons.math.dfp.DfpField] */
    /* JADX WARN: Type inference failed for: r4v0, types: [org.apache.commons.math.dfp.DfpField] */
    public static Dfp atan(Dfp a) {
        Dfp zero = a.getField2().getZero2();
        Dfp one = a.getField2().getOne2();
        Dfp[] sqr2Split = a.getField2().getSqr2Split();
        Dfp[] piSplit = a.getField2().getPiSplit();
        boolean recp = false;
        boolean neg = false;
        boolean sub = false;
        Dfp ty = sqr2Split[0].subtract2(one).add2(sqr2Split[1]);
        Dfp x = new Dfp(a);
        if (x.lessThan(zero) == false) goto L6;
        neg = true;
        x = x.negate();
    L6:
        if (x.greaterThan(one) == false) goto L9;
        recp = true;
        x = one.divide2(x);
    L9:
        if (x.greaterThan(ty) == false) goto L11;
        sub = true;
        Dfp[] sty = {sqr2Split[0].subtract2(one), sqr2Split[1]};
        Dfp[] xs = split(x);
        Dfp[] ds = splitMult(xs, sty);
        char r16 = 0;
        ds[0] = ds[0].add2(one);
        char r17 = 1;
        xs[0] = xs[0].subtract2(sty[0]);
        xs[1] = xs[1].subtract2(sty[1]);
        Dfp[] xs2 = splitDiv(xs, ds);
        x = xs2[0].add2(xs2[1]);
    L12:
        Dfp y = atanInternal(x);
        if (sub == false) goto L15;
        y = y.add2(piSplit[r16].divide(8)).add2(piSplit[r17].divide(8));
    L15:
        if (recp == false) goto L17;
        y = piSplit[r16].divide(2).subtract2(y).add2(piSplit[r17].divide(2));
    L17:
        if (neg == false) goto L20;
        y = y.negate();
    L20:
        return a.newInstance(y);
    L11:
        r16 = 0;
        r17 = 1;
        goto L12
    }

    public static Dfp asin(Dfp a) {
        return atan(a.divide2(a.getOne().subtract2(a.multiply2(a)).sqrt()));
    }

    /* JADX WARN: Type inference failed for: r2v2, types: [org.apache.commons.math.dfp.DfpField] */
    public static Dfp acos(Dfp a) {
        boolean negative = false;
        if (a.lessThan(a.getZero()) == false) goto L5;
        negative = true;
    L5:
        Dfp a2 = Dfp.copysign(a, a.getOne());
        Dfp result = atan(a2.getOne().subtract2(a2.multiply2(a2)).sqrt().divide2(a2));
        if (negative == false) goto L9;
        result = a2.getField2().getPi().subtract2(result);
    L9:
        return a2.newInstance(result);
    }
}
