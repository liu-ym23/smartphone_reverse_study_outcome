package org.apache.commons.math.dfp;

import org.apache.commons.math.Field;

/* JADX INFO: loaded from: classes3.dex */
public class DfpField implements Field<Dfp> {
    public static final int FLAG_DIV_ZERO = 2;
    public static final int FLAG_INEXACT = 16;
    public static final int FLAG_INVALID = 1;
    public static final int FLAG_OVERFLOW = 4;
    public static final int FLAG_UNDERFLOW = 8;
    private static String eString;
    private static String ln10String;
    private static String ln2String;
    private static String ln5String;
    private static String piString;
    private static String sqr2ReciprocalString;
    private static String sqr2String;
    private static String sqr3ReciprocalString;
    private static String sqr3String;
    private final Dfp e;
    private final Dfp[] eSplit;
    private int ieeeFlags;
    private final Dfp ln10;
    private final Dfp ln2;
    private final Dfp[] ln2Split;
    private final Dfp ln5;
    private final Dfp[] ln5Split;
    private final Dfp one;
    private final Dfp pi;
    private final Dfp[] piSplit;
    private RoundingMode rMode;
    private final int radixDigits;
    private final Dfp sqr2;
    private final Dfp sqr2Reciprocal;
    private final Dfp[] sqr2Split;
    private final Dfp sqr3;
    private final Dfp sqr3Reciprocal;
    private final Dfp two;
    private final Dfp zero;

    public static final enum RoundingMode extends Enum<RoundingMode> {
        private static final /* synthetic */ RoundingMode[] $VALUES = null;
        public static final RoundingMode ROUND_CEIL = null;
        public static final RoundingMode ROUND_DOWN = null;
        public static final RoundingMode ROUND_FLOOR = null;
        public static final RoundingMode ROUND_HALF_DOWN = null;
        public static final RoundingMode ROUND_HALF_EVEN = null;
        public static final RoundingMode ROUND_HALF_ODD = null;
        public static final RoundingMode ROUND_HALF_UP = null;
        public static final RoundingMode ROUND_UP = null;

        private static /* synthetic */ RoundingMode[] $values() {
            return new RoundingMode[]{ROUND_DOWN, ROUND_UP, ROUND_HALF_UP, ROUND_HALF_DOWN, ROUND_HALF_EVEN, ROUND_HALF_ODD, ROUND_CEIL, ROUND_FLOOR};
        }

        private RoundingMode(String r1, int r2) {
            super(r1, r2);
        }

        public static RoundingMode valueOf(String name) {
            return (RoundingMode) Enum.valueOf(RoundingMode.class, name);
        }

        public static RoundingMode[] values() {
            return (RoundingMode[]) $VALUES.clone();
        }

        static {
            ROUND_DOWN = new RoundingMode("ROUND_DOWN", 0);
            ROUND_UP = new RoundingMode("ROUND_UP", 1);
            ROUND_HALF_UP = new RoundingMode("ROUND_HALF_UP", 2);
            ROUND_HALF_DOWN = new RoundingMode("ROUND_HALF_DOWN", 3);
            ROUND_HALF_EVEN = new RoundingMode("ROUND_HALF_EVEN", 4);
            ROUND_HALF_ODD = new RoundingMode("ROUND_HALF_ODD", 5);
            ROUND_CEIL = new RoundingMode("ROUND_CEIL", 6);
            ROUND_FLOOR = new RoundingMode("ROUND_FLOOR", 7);
            $VALUES = $values();
        }
    }

    @Override // org.apache.commons.math.Field
    public /* bridge */ /* synthetic */ Dfp getOne() {
        return getOne2();
    }

    @Override // org.apache.commons.math.Field
    public /* bridge */ /* synthetic */ Dfp getZero() {
        return getZero2();
    }

    public DfpField(int decimalDigits) {
        this(decimalDigits, true);
    }

    private DfpField(int decimalDigits, boolean computeConstants) {
        int r1 = 4;
        if (decimalDigits < 13) goto L6;
        r1 = (decimalDigits + 3) / 4;
    L6:
        this.radixDigits = r1;
        this.rMode = RoundingMode.ROUND_HALF_EVEN;
        this.ieeeFlags = 0;
        this.zero = new Dfp(this, 0);
        this.one = new Dfp(this, 1);
        this.two = new Dfp(this, 2);
        if (computeConstants == true) goto L9;
        this.sqr2 = null;
        this.sqr2Split = null;
        this.sqr2Reciprocal = null;
        this.sqr3 = null;
        this.sqr3Reciprocal = null;
        this.pi = null;
        this.piSplit = null;
        this.e = null;
        this.eSplit = null;
        this.ln2 = null;
        this.ln2Split = null;
        this.ln5 = null;
        this.ln5Split = null;
        this.ln10 = null;
        return;
    L9:
        monitor-enter(DfpField.class);
        if (decimalDigits >= 67) goto L13;
        int r2 = 200;
    L22:
        computeStringConstants(r2);     // Catch: Throwable -> L17
        this.sqr2 = new Dfp(this, sqr2String);     // Catch: Throwable -> L17
        this.sqr2Split = split(sqr2String);     // Catch: Throwable -> L17
        this.sqr2Reciprocal = new Dfp(this, sqr2ReciprocalString);     // Catch: Throwable -> L17
        this.sqr3 = new Dfp(this, sqr3String);     // Catch: Throwable -> L17
        this.sqr3Reciprocal = new Dfp(this, sqr3ReciprocalString);     // Catch: Throwable -> L17
        this.pi = new Dfp(this, piString);     // Catch: Throwable -> L17
        this.piSplit = split(piString);     // Catch: Throwable -> L17
        this.e = new Dfp(this, eString);     // Catch: Throwable -> L17
        this.eSplit = split(eString);     // Catch: Throwable -> L17
        this.ln2 = new Dfp(this, ln2String);     // Catch: Throwable -> L17
        this.ln2Split = split(ln2String);     // Catch: Throwable -> L17
        this.ln5 = new Dfp(this, ln5String);     // Catch: Throwable -> L17
        this.ln5Split = split(ln5String);     // Catch: Throwable -> L17
        this.ln10 = new Dfp(this, ln10String);     // Catch: Throwable -> L17
        monitor-exit(DfpField.class);     // Catch: Throwable -> L17
        return;
    L17:
        th = move-exception;
        throw th;
    L13:
        r2 = decimalDigits * 3;
        goto L22
    }

    public int getRadixDigits() {
        return this.radixDigits;
    }

    public void setRoundingMode(RoundingMode mode) {
        this.rMode = mode;
    }

    public RoundingMode getRoundingMode() {
        return this.rMode;
    }

    public int getIEEEFlags() {
        return this.ieeeFlags;
    }

    public void clearIEEEFlags() {
        this.ieeeFlags = 0;
    }

    public void setIEEEFlags(int flags) {
        this.ieeeFlags = flags & 31;
    }

    public void setIEEEFlagsBits(int bits) {
        this.ieeeFlags |= bits & 31;
    }

    public Dfp newDfp() {
        return new Dfp(this);
    }

    public Dfp newDfp(byte x) {
        return new Dfp(this, x);
    }

    public Dfp newDfp(int x) {
        return new Dfp(this, x);
    }

    public Dfp newDfp(long x) {
        return new Dfp(this, x);
    }

    public Dfp newDfp(double x) {
        return new Dfp(this, x);
    }

    public Dfp newDfp(Dfp d) {
        return new Dfp(d);
    }

    public Dfp newDfp(String s) {
        return new Dfp(this, s);
    }

    public Dfp newDfp(byte sign, byte nans) {
        return new Dfp(this, sign, nans);
    }

    @Override // org.apache.commons.math.Field
    /* JADX INFO: renamed from: getZero, reason: avoid collision after fix types in other method */
    public Dfp getZero2() {
        return this.zero;
    }

    @Override // org.apache.commons.math.Field
    /* JADX INFO: renamed from: getOne, reason: avoid collision after fix types in other method */
    public Dfp getOne2() {
        return this.one;
    }

    public Dfp getTwo() {
        return this.two;
    }

    public Dfp getSqr2() {
        return this.sqr2;
    }

    public Dfp[] getSqr2Split() {
        return (Dfp[]) this.sqr2Split.clone();
    }

    public Dfp getSqr2Reciprocal() {
        return this.sqr2Reciprocal;
    }

    public Dfp getSqr3() {
        return this.sqr3;
    }

    public Dfp getSqr3Reciprocal() {
        return this.sqr3Reciprocal;
    }

    public Dfp getPi() {
        return this.pi;
    }

    public Dfp[] getPiSplit() {
        return (Dfp[]) this.piSplit.clone();
    }

    public Dfp getE() {
        return this.e;
    }

    public Dfp[] getESplit() {
        return (Dfp[]) this.eSplit.clone();
    }

    public Dfp getLn2() {
        return this.ln2;
    }

    public Dfp[] getLn2Split() {
        return (Dfp[]) this.ln2Split.clone();
    }

    public Dfp getLn5() {
        return this.ln5;
    }

    public Dfp[] getLn5Split() {
        return (Dfp[]) this.ln5Split.clone();
    }

    public Dfp getLn10() {
        return this.ln10;
    }

    private Dfp[] split(String a) {
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
        if (sig == ((this.radixDigits / 2) * 4)) goto L15;
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
        result[0] = new Dfp(this, new String(buf, 0, sp));
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
        result[1] = new Dfp(this, new String(buf));
        return result;
    }

    private static void computeStringConstants(int highPrecisionDecimalDigits) {
        if (sqr2String != null) goto L5;
    L6:
        DfpField highPrecisionField = new DfpField(highPrecisionDecimalDigits, false);
        Dfp highPrecisionOne = new Dfp(highPrecisionField, 1);
        Dfp highPrecisionTwo = new Dfp(highPrecisionField, 2);
        Dfp highPrecisionThree = new Dfp(highPrecisionField, 3);
        Dfp highPrecisionSqr2 = highPrecisionTwo.sqrt();
        sqr2String = highPrecisionSqr2.toString();
        sqr2ReciprocalString = highPrecisionOne.divide2(highPrecisionSqr2).toString();
        Dfp highPrecisionSqr3 = highPrecisionThree.sqrt();
        sqr3String = highPrecisionSqr3.toString();
        sqr3ReciprocalString = highPrecisionOne.divide2(highPrecisionSqr3).toString();
        piString = computePi(highPrecisionOne, highPrecisionTwo, highPrecisionThree).toString();
        eString = computeExp(highPrecisionOne, highPrecisionOne).toString();
        ln2String = computeLn(highPrecisionTwo, highPrecisionOne, highPrecisionTwo).toString();
        ln5String = computeLn(new Dfp(highPrecisionField, 5), highPrecisionOne, highPrecisionTwo).toString();
        ln10String = computeLn(new Dfp(highPrecisionField, 10), highPrecisionOne, highPrecisionTwo).toString();
        return;
    L5:
        if (sqr2String.length() < (highPrecisionDecimalDigits - 3)) goto L6;
    }

    private static Dfp computePi(Dfp r18, Dfp two, Dfp three) {
        Dfp sqrt2 = two.sqrt();
        Dfp yk = sqrt2.subtract2(r18);
        Dfp four = two.add2(two);
        Dfp two2kp3 = two;
        Dfp ak = two.multiply2(three.subtract2(two.multiply2(sqrt2)));
        int i = 1;
    L4:
        if (i >= 20) goto L11;
        Object ykM1 = yk;
        Dfp y2 = yk.multiply2(yk);
        Dfp oneMinusY4 = r18.subtract2(y2.multiply2(y2));
        Dfp s = oneMinusY4.sqrt().sqrt();
        yk = r18.subtract2(s).divide2(r18.add2(s));
        two2kp3 = two2kp3.multiply2(four);
        Dfp p = r18.add2(yk);
        Dfp p2 = p.multiply2(p);
        Dfp r15 = ak.multiply2(p2.multiply2(p2));
        Dfp r1 = two2kp3.multiply2(yk);
        Dfp sqrt3 = sqrt2;
        Dfp sqrt4 = r18.add2(yk);
        Dfp four2 = four;
        Dfp four3 = yk.multiply2(yk);
        ak = r15.subtract2(r1.multiply2(sqrt4.add2(four3)));
        if (yk.equals(ykM1) == true) goto L11;
        i = i + 1;
        sqrt2 = sqrt3;
        four = four2;
    L11:
        return r18.divide2(ak);
    }

    public static Dfp computeExp(Dfp a, Dfp one) {
        Dfp y = new Dfp(one);
        Dfp py = new Dfp(one);
        Dfp f = new Dfp(one);
        Dfp fi = new Dfp(one);
        Dfp x = new Dfp(one);
        int i = 0;
    L4:
        if (i >= 10000) goto L9;
        x = x.multiply2(a);
        y = y.add2(x.divide2(f));
        fi = fi.add2(one);
        f = f.multiply2(fi);
        if (y.equals(py) == true) goto L9;
        py = new Dfp(y);
        i = i + 1;
    L9:
        return y;
    }

    /* JADX WARN: Type inference failed for: r2v0, types: [org.apache.commons.math.dfp.DfpField] */
    public static Dfp computeLn(Dfp a, Dfp one, Dfp two) {
        int den = 1;
        Dfp x = a.add2(new Dfp(a.getField2(), -1)).divide2(a.add2(one));
        Dfp y = new Dfp(x);
        Dfp num = new Dfp(x);
        Dfp py = new Dfp(y);
        int i = 0;
    L4:
        if (i >= 10000) goto L10;
        num = num.multiply2(x).multiply2(x);
        den = den + 2;
        Dfp t = num.divide(den);
        y = y.add2(t);
        if (y.equals(py) == true) goto L10;
        py = new Dfp(y);
        i = i + 1;
    L10:
        return y.multiply2(two);
    }
}
