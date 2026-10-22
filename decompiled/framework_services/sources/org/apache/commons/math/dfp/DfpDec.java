package org.apache.commons.math.dfp;

/* JADX INFO: loaded from: classes3.dex */
public class DfpDec extends Dfp {

    /* JADX INFO: renamed from: org.apache.commons.math.dfp.DfpDec$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$apache$commons$math$dfp$DfpField$RoundingMode = null;

        static {
            $SwitchMap$org$apache$commons$math$dfp$DfpField$RoundingMode = new int[DfpField.RoundingMode.values().length];
            $SwitchMap$org$apache$commons$math$dfp$DfpField$RoundingMode[DfpField.RoundingMode.ROUND_DOWN.ordinal()] = 1;     // Catch: NoSuchFieldError -> L5
        L40:
            $SwitchMap$org$apache$commons$math$dfp$DfpField$RoundingMode[DfpField.RoundingMode.ROUND_UP.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L30:
            $SwitchMap$org$apache$commons$math$dfp$DfpField$RoundingMode[DfpField.RoundingMode.ROUND_HALF_UP.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L28:
            $SwitchMap$org$apache$commons$math$dfp$DfpField$RoundingMode[DfpField.RoundingMode.ROUND_HALF_DOWN.ordinal()] = 4;     // Catch: NoSuchFieldError -> L14
        L32:
            $SwitchMap$org$apache$commons$math$dfp$DfpField$RoundingMode[DfpField.RoundingMode.ROUND_HALF_EVEN.ordinal()] = 5;     // Catch: NoSuchFieldError -> L17
        L36:
            $SwitchMap$org$apache$commons$math$dfp$DfpField$RoundingMode[DfpField.RoundingMode.ROUND_HALF_ODD.ordinal()] = 6;     // Catch: NoSuchFieldError -> L20
        L42:
            $SwitchMap$org$apache$commons$math$dfp$DfpField$RoundingMode[DfpField.RoundingMode.ROUND_CEIL.ordinal()] = 7;     // Catch: NoSuchFieldError -> L23
        L38:
            $SwitchMap$org$apache$commons$math$dfp$DfpField$RoundingMode[DfpField.RoundingMode.ROUND_FLOOR.ordinal()] = 8;     // Catch: NoSuchFieldError -> L26
            return;
        }
    }

    protected DfpDec(DfpField factory) {
        super(factory);
    }

    protected DfpDec(DfpField factory, byte x) {
        super(factory, x);
    }

    protected DfpDec(DfpField factory, int x) {
        super(factory, x);
    }

    protected DfpDec(DfpField factory, long x) {
        super(factory, x);
    }

    protected DfpDec(DfpField factory, double x) {
        super(factory, x);
        round(0);
    }

    public DfpDec(Dfp d) {
        super(d);
        round(0);
    }

    protected DfpDec(DfpField factory, String s) {
        super(factory, s);
        round(0);
    }

    protected DfpDec(DfpField factory, byte sign, byte nans) {
        super(factory, sign, nans);
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [org.apache.commons.math.dfp.DfpField] */
    @Override // org.apache.commons.math.dfp.Dfp
    public Dfp newInstance() {
        return new DfpDec(getField2());
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [org.apache.commons.math.dfp.DfpField] */
    @Override // org.apache.commons.math.dfp.Dfp
    public Dfp newInstance(byte x) {
        return new DfpDec(getField2(), x);
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [org.apache.commons.math.dfp.DfpField] */
    @Override // org.apache.commons.math.dfp.Dfp
    public Dfp newInstance(int x) {
        return new DfpDec(getField2(), x);
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [org.apache.commons.math.dfp.DfpField] */
    @Override // org.apache.commons.math.dfp.Dfp
    public Dfp newInstance(long x) {
        return new DfpDec(getField2(), x);
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [org.apache.commons.math.dfp.DfpField] */
    @Override // org.apache.commons.math.dfp.Dfp
    public Dfp newInstance(double x) {
        return new DfpDec(getField2(), x);
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [org.apache.commons.math.dfp.DfpField] */
    /* JADX WARN: Type inference failed for: r0v3, types: [org.apache.commons.math.dfp.DfpField] */
    /* JADX WARN: Type inference failed for: r1v0, types: [org.apache.commons.math.dfp.DfpField] */
    @Override // org.apache.commons.math.dfp.Dfp
    public Dfp newInstance(Dfp d) {
        if (getField2().getRadixDigits() == d.getField2().getRadixDigits()) goto L7;
        getField2().setIEEEFlagsBits(1);
        Dfp result = newInstance(getZero());
        result.nans = 3;
        return dotrap(1, "newInstance", d, result);
    L7:
        return new DfpDec(d);
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [org.apache.commons.math.dfp.DfpField] */
    @Override // org.apache.commons.math.dfp.Dfp
    public Dfp newInstance(String s) {
        return new DfpDec(getField2(), s);
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [org.apache.commons.math.dfp.DfpField] */
    @Override // org.apache.commons.math.dfp.Dfp
    public Dfp newInstance(byte sign, byte nans) {
        return new DfpDec(getField2(), sign, nans);
    }

    protected int getDecimalDigits() {
        return (getRadixDigits() * 4) - 3;
    }

    /* JADX WARN: Type inference failed for: r14v2, types: [org.apache.commons.math.dfp.DfpField] */
    /* JADX WARN: Type inference failed for: r2v6, types: [org.apache.commons.math.dfp.DfpField] */
    /* JADX WARN: Type inference failed for: r2v7, types: [org.apache.commons.math.dfp.DfpField] */
    /* JADX WARN: Type inference failed for: r2v8, types: [org.apache.commons.math.dfp.DfpField] */
    @Override // org.apache.commons.math.dfp.Dfp
    protected int round(int in) {
        boolean r3 = true;
        int msb = this.mant[this.mant.length - 1];
        int r2 = 0;
        if (msb != 0) goto L5;
        return 0;
    L5:
        int cmaxdigits = this.mant.length * 4;
        int lsbthreshold = 1000;
    L6:
        if (lsbthreshold <= msb) goto L8;
        lsbthreshold = lsbthreshold / 10;
        cmaxdigits = cmaxdigits - 1;
        goto L6
    L8:
        int digits = getDecimalDigits();
        int lsbshift = cmaxdigits - digits;
        int lsd = lsbshift / 4;
        int lsbthreshold2 = 1;
        int i = 0;
    L10:
        if (i >= (lsbshift % 4)) goto L12;
        lsbthreshold2 = lsbthreshold2 * 10;
        i = i + 1;
        goto L10
    L12:
        int lsb = this.mant[lsd];
        if (lsbthreshold2 > 1) goto L19;
        if (digits != ((this.mant.length * 4) - 3)) goto L19;
        return super.round(in);
    L19:
        if (lsbthreshold2 != 1) goto L21;
        int n = (this.mant[lsd - 1] / 1000) % 10;
        int[] r13 = this.mant;
        int r14 = lsd - 1;
        r13[r14] = r13[r14] % 1000;
        int discarded = in | this.mant[lsd - 1];
    L22:
        int i2 = 0;
    L23:
        if (i2 >= lsd) goto L25;
        discarded = discarded | this.mant[i2];
        this.mant[i2] = 0;
        i2 = i2 + 1;
        goto L23
    L25:
        this.mant[lsd] = (lsb / lsbthreshold2) * lsbthreshold2;
        switch(AnonymousClass1.$SwitchMap$org$apache$commons$math$dfp$DfpField$RoundingMode[getField2().getRoundingMode().ordinal()]) {
            case 1: goto L77;
            case 2: goto L71;
            case 3: goto L67;
            case 4: goto L63;
            case 5: goto L52;
            case 6: goto L41;
            case 7: goto L35;
            default: goto L28;
        };
    L41:
        if (n > 5) goto L50;
        if (n != 5) goto L44;
        if (discarded != 0) goto L50;
    L44:
        if (n != 5) goto L49;
        if (discarded != 0) goto L49;
        if (((lsb / lsbthreshold2) & 1) == 0) goto L50;
    L49:
        boolean inc = false;
    L78:
        if (inc == false) goto L86;
        int rh = lsbthreshold2;
        int i3 = lsd;
    L80:
        int r16 = r2;
        if (i3 >= this.mant.length) goto L84;
        int r = this.mant[i3] + rh;
        rh = r / 10000;
        this.mant[i3] = r % 10000;
        i3 = i3 + 1;
        r2 = r16;
        r3 = r3;
        goto L80
    L84:
        if (rh == 0) goto L88;
        shiftRight();
        this.mant[this.mant.length - 1] = rh;
    L88:
        if (this.exp >= (-32767)) goto L92;
        getField2().setIEEEFlagsBits(8);
        return 8;
    L92:
        if (this.exp <= 32768) goto L95;
        getField2().setIEEEFlagsBits(4);
        return 4;
    L95:
        if (n != 0) goto L99;
        if (discarded != 0) goto L99;
        return r16;
    L99:
        getField2().setIEEEFlagsBits(16);
        return 16;
    L86:
        r16 = 0;
    L50:
        inc = true;
        goto L78
    L52:
        if (n > 5) goto L61;
        if (n != 5) goto L55;
        if (discarded != 0) goto L61;
    L55:
        if (n != 5) goto L60;
        if (discarded != 0) goto L60;
        if (((lsb / lsbthreshold2) & 1) == 1) goto L61;
    L60:
        inc = false;
    L61:
        inc = true;
        goto L78
    L63:
        if (n <= 5) goto L65;
        inc = true;
        goto L78
    L65:
        inc = false;
        goto L78
    L67:
        if (n < 5) goto L69;
        inc = true;
        goto L78
    L69:
        inc = false;
        goto L78
    L71:
        if (n != 0) goto L75;
        if (discarded != 0) goto L75;
        inc = false;
    L75:
        inc = true;
        goto L78
    L77:
        inc = false;
        goto L78
    L28:
        if (this.sign != (-1)) goto L32;
        if (n != 0) goto L31;
        if (discarded == 0) goto L32;
    L31:
        inc = true;
    L32:
        inc = false;
        goto L78
    L35:
        if (this.sign != 1) goto L39;
        if (n != 0) goto L38;
        if (discarded == 0) goto L39;
    L38:
        inc = true;
    L39:
        inc = false;
        goto L78
    L21:
        int n2 = lsb * 10;
        n = (n2 / lsbthreshold2) % 10;
        discarded = in | (lsb % (lsbthreshold2 / 10));
        goto L22
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [org.apache.commons.math.dfp.DfpField] */
    /* JADX WARN: Type inference failed for: r1v7, types: [org.apache.commons.math.dfp.DfpField] */
    /* JADX WARN: Type inference failed for: r2v0, types: [org.apache.commons.math.dfp.DfpField] */
    /* JADX WARN: Type inference failed for: r4v5, types: [org.apache.commons.math.dfp.DfpField] */
    /* JADX WARN: Type inference failed for: r4v6, types: [org.apache.commons.math.dfp.DfpField] */
    @Override // org.apache.commons.math.dfp.Dfp
    public Dfp nextAfter(Dfp x) {
        if (getField2().getRadixDigits() == x.getField2().getRadixDigits()) goto L6;
        getField2().setIEEEFlagsBits(1);
        Dfp result = newInstance(getZero());
        result.nans = 3;
        return dotrap(1, "nextAfter", x, result);
    L6:
        boolean up = false;
        if (lessThan(x) == false) goto L10;
        up = true;
    L10:
        if (equals(x) == false) goto L14;
        return newInstance(x);
    L14:
        if (lessThan(getZero()) == false) goto L16;
        up = !up;
    L16:
        if (up == false) goto L24;
        Dfp inc = Dfp.copysign(power10((log10() - getDecimalDigits()) + 1), this);
        if (equals(getZero()) == false) goto L21;
        inc = power10K(((-32767) - this.mant.length) - 1);
    L21:
        if (inc.equals(getZero()) == false) goto L23;
        Dfp result2 = Dfp.copysign(newInstance(getZero()), this);
    L36:
        if (result2.classify() != 1) goto L41;
        if (classify() == 1) goto L41;
        getField2().setIEEEFlagsBits(16);
        result2 = dotrap(16, "nextAfter", x, result2);
    L41:
        if (result2.equals(getZero()) == true) goto L43;
        return result2;
    L43:
        if (equals(getZero()) == true) goto L47;
        getField2().setIEEEFlagsBits(16);
        return dotrap(16, "nextAfter", x, result2);
    L47:
        return result2;
    L23:
        result2 = add2(inc);
        goto L36
    L24:
        Dfp inc2 = Dfp.copysign(power10(log10()), this);
        if (equals(inc2) == false) goto L27;
        Dfp inc3 = inc2.divide2(power10(getDecimalDigits()));
    L29:
        if (equals(getZero()) == false) goto L32;
        inc3 = power10K(((-32767) - this.mant.length) - 1);
    L32:
        if (inc3.equals(getZero()) == false) goto L34;
        result2 = Dfp.copysign(newInstance(getZero()), this);
        goto L36
    L34:
        result2 = subtract2(inc3);
        goto L36
    L27:
        inc3 = inc2.divide2(power10(getDecimalDigits() - 1));
        goto L29
    }
}
