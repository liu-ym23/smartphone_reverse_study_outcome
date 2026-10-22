package org.apache.commons.math.dfp;

import com.android.server.job.controllers.JobStatus;
import java.util.Arrays;
import org.apache.commons.math.Field;
import org.apache.commons.math.FieldElement;

/* JADX INFO: loaded from: classes3.dex */
public class Dfp implements FieldElement<Dfp> {
    private static final String ADD_TRAP = "add";
    private static final String ALIGN_TRAP = "align";
    private static final String DIVIDE_TRAP = "divide";
    public static final int ERR_SCALE = 32760;
    public static final byte FINITE = 0;
    private static final String GREATER_THAN_TRAP = "greaterThan";
    public static final byte INFINITE = 1;
    private static final String LESS_THAN_TRAP = "lessThan";
    public static final int MAX_EXP = 32768;
    public static final int MIN_EXP = -32767;
    private static final String MULTIPLY_TRAP = "multiply";
    private static final String NAN_STRING = "NaN";
    private static final String NEG_INFINITY_STRING = "-Infinity";
    private static final String NEW_INSTANCE_TRAP = "newInstance";
    private static final String NEXT_AFTER_TRAP = "nextAfter";
    private static final String POS_INFINITY_STRING = "Infinity";
    public static final byte QNAN = 3;
    public static final int RADIX = 10000;
    public static final byte SNAN = 2;
    private static final String SQRT_TRAP = "sqrt";
    private static final String TRUNC_TRAP = "trunc";
    protected int exp;
    private final DfpField field;
    protected int[] mant;
    protected byte nans;
    protected byte sign;

    /* JADX INFO: renamed from: org.apache.commons.math.dfp.Dfp$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$apache$commons$math$dfp$DfpField$RoundingMode = null;

        static {
            $SwitchMap$org$apache$commons$math$dfp$DfpField$RoundingMode = new int[DfpField.RoundingMode.values().length];
            $SwitchMap$org$apache$commons$math$dfp$DfpField$RoundingMode[DfpField.RoundingMode.ROUND_FLOOR.ordinal()] = 1;     // Catch: NoSuchFieldError -> L5
        L40:
            $SwitchMap$org$apache$commons$math$dfp$DfpField$RoundingMode[DfpField.RoundingMode.ROUND_CEIL.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L30:
            $SwitchMap$org$apache$commons$math$dfp$DfpField$RoundingMode[DfpField.RoundingMode.ROUND_HALF_EVEN.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L28:
            $SwitchMap$org$apache$commons$math$dfp$DfpField$RoundingMode[DfpField.RoundingMode.ROUND_DOWN.ordinal()] = 4;     // Catch: NoSuchFieldError -> L14
        L32:
            $SwitchMap$org$apache$commons$math$dfp$DfpField$RoundingMode[DfpField.RoundingMode.ROUND_UP.ordinal()] = 5;     // Catch: NoSuchFieldError -> L17
        L36:
            $SwitchMap$org$apache$commons$math$dfp$DfpField$RoundingMode[DfpField.RoundingMode.ROUND_HALF_UP.ordinal()] = 6;     // Catch: NoSuchFieldError -> L20
        L42:
            $SwitchMap$org$apache$commons$math$dfp$DfpField$RoundingMode[DfpField.RoundingMode.ROUND_HALF_DOWN.ordinal()] = 7;     // Catch: NoSuchFieldError -> L23
        L38:
            $SwitchMap$org$apache$commons$math$dfp$DfpField$RoundingMode[DfpField.RoundingMode.ROUND_HALF_ODD.ordinal()] = 8;     // Catch: NoSuchFieldError -> L26
            return;
        }
    }

    @Override // org.apache.commons.math.FieldElement
    public /* bridge */ /* synthetic */ Dfp add(Dfp r1) {
        return add2(r1);
    }

    @Override // org.apache.commons.math.FieldElement
    public /* bridge */ /* synthetic */ Dfp divide(Dfp r1) throws ArithmeticException {
        return divide2(r1);
    }

    @Override // org.apache.commons.math.FieldElement
    public /* bridge */ /* synthetic */ Field<Dfp> getField() {
        return getField2();
    }

    @Override // org.apache.commons.math.FieldElement
    public /* bridge */ /* synthetic */ Dfp multiply(Dfp r1) {
        return multiply2(r1);
    }

    @Override // org.apache.commons.math.FieldElement
    public /* bridge */ /* synthetic */ Dfp subtract(Dfp r1) {
        return subtract2(r1);
    }

    protected Dfp(DfpField field) {
        this.mant = new int[field.getRadixDigits()];
        this.sign = 1;
        this.exp = 0;
        this.nans = 0;
        this.field = field;
    }

    protected Dfp(DfpField field, byte x) {
        this(field, x);
    }

    protected Dfp(DfpField field, int x) {
        this(field, x);
    }

    protected Dfp(DfpField field, long x) {
        this.mant = new int[field.getRadixDigits()];
        this.nans = 0;
        this.field = field;
        boolean isLongMin = false;
        if (x != Long.MIN_VALUE) goto L6;
        isLongMin = true;
        x = x + 1;
    L6:
        if (x >= 0) goto L8;
        this.sign = -1;
        x = -x;
    L9:
        this.exp = 0;
    L11:
        if (x == 0) goto L13;
        System.arraycopy(this.mant, this.mant.length - this.exp, this.mant, (this.mant.length - 1) - this.exp, this.exp);
        this.mant[this.mant.length - 1] = (int) (x % JobStatus.DEFAULT_TRIGGER_UPDATE_DELAY);
        x = x / JobStatus.DEFAULT_TRIGGER_UPDATE_DELAY;
        this.exp++;
        goto L11
    L13:
        if (isLongMin == false) goto L21;
        int i = 0;
    L16:
        if (i >= (this.mant.length - 1)) goto L26;
        if (this.mant[i] != 0) goto L19;
        i = i + 1;
        goto L16
    L19:
        int[] r2 = this.mant;
        r2[i] = r2[i] + 1;
        return;
    L26:
        return;
    L21:
        return;
    L8:
        this.sign = 1;
        goto L9
    }

    protected Dfp(DfpField field, double x) {
        this.mant = new int[field.getRadixDigits()];
        this.sign = 1;
        this.exp = 0;
        this.nans = 0;
        this.field = field;
        long bits = Double.doubleToLongBits(x);
        long mantissa = bits & 4503599627370495L;
        int exponent = ((int) ((9218868437227405312L & bits) >> 52)) - 1023;
        if (exponent != (-1023)) goto L13;
        if (x != 0.0d) goto L7;
        return;
    L7:
        exponent = exponent + 1;
    L9:
        if ((mantissa & 4503599627370496L) != 0) goto L11;
        exponent = exponent - 1;
        mantissa = mantissa << 1;
        goto L9
    L11:
        mantissa = mantissa & 4503599627370495L;
    L13:
        if (exponent == 1024) goto L15;
        Dfp xdfp = new Dfp(field, mantissa);
        Dfp xdfp2 = xdfp.divide2(new Dfp(field, 4503599627370496L)).add2(field.getOne2()).multiply2(DfpMath.pow(field.getTwo(), exponent));
        if ((Long.MIN_VALUE & bits) == 0) goto L25;
        xdfp2 = xdfp2.negate();
    L25:
        System.arraycopy(xdfp2.mant, 0, this.mant, 0, this.mant.length);
        this.sign = xdfp2.sign;
        this.exp = xdfp2.exp;
        this.nans = xdfp2.nans;
        return;
    L15:
        if (x == x) goto L18;
        this.sign = 1;
        this.nans = 3;
        return;
    L18:
        if (x >= 0.0d) goto L20;
        this.sign = -1;
        this.nans = 1;
        return;
    L20:
        this.sign = 1;
        this.nans = 1;
    }

    public Dfp(Dfp d) {
        this.mant = (int[]) d.mant.clone();
        this.sign = d.sign;
        this.exp = d.exp;
        this.nans = d.nans;
        this.field = d.field;
    }

    protected Dfp(DfpField field, String s) {
        this.mant = new int[field.getRadixDigits()];
        this.sign = 1;
        this.exp = 0;
        this.nans = 0;
        this.field = field;
        boolean decimalFound = false;
        int r9 = 4;
        char[] striped = new char[(getRadixDigits() * 4) + 8];
        if (s.equals(POS_INFINITY_STRING) == false) goto L6;
        this.sign = 1;
        this.nans = 1;
        return;
    L6:
        byte r11 = -1;
        if (s.equals(NEG_INFINITY_STRING) == false) goto L10;
        this.sign = -1;
        this.nans = 1;
        return;
    L10:
        char r12 = 3;
        if (s.equals(NAN_STRING) == false) goto L14;
        this.sign = 1;
        this.nans = 3;
        return;
    L14:
        int p = s.indexOf("e");
        if (p != (-1)) goto L17;
        p = s.indexOf("E");
    L17:
        int sciexp = 0;
        char r14 = '9';
        char r15 = '0';
        if (p == (-1)) goto L35;
        String fpdecimal = s.substring(0, p);
        String fpexp = s.substring(p + 1);
        boolean negative = false;
        int i = 0;
    L20:
        char r20 = r12;
        if (i >= fpexp.length()) goto L31;
        int r21 = r9;
        if (fpexp.charAt(i) != '-') goto L26;
        negative = true;
    L30:
        i = i + 1;
        r12 = r20;
        r9 = r21;
        goto L20
    L26:
        if (fpexp.charAt(i) < '0') goto L30;
        if (fpexp.charAt(i) > '9') goto L30;
        sciexp = ((sciexp * 10) + fpexp.charAt(i)) - 48;
        goto L30
    L31:
        int r22 = r9;
        if (negative == false) goto L34;
        sciexp = -sciexp;
    L34:
        String fpexp2 = fpdecimal;
    L37:
        if (fpexp2.indexOf("-") == (-1)) goto L39;
        this.sign = -1;
    L39:
        int p2 = 0;
        int decimalPos = 0;
    L40:
        byte r16 = r11;
        if (fpexp2.charAt(p2) >= '1') goto L43;
    L45:
        if (decimalFound == false) goto L50;
        if (fpexp2.charAt(p2) != r15) goto L50;
        decimalPos = decimalPos - 1;
    L50:
        if (fpexp2.charAt(p2) != '.') goto L52;
        decimalFound = true;
    L52:
        p2 = p2 + 1;
        if (p2 == fpexp2.length()) goto L54;
        r15 = r15;
        r14 = r14;
        r11 = r16;
    L54:
        int q = 4;
        striped[0] = r15;
        striped[1] = r15;
        striped[2] = r15;
        striped[r20] = r15;
        int significantDigits = 0;
    L56:
        if (p2 == fpexp2.length()) goto L60;
        if (q == (((this.mant.length * 4) + 4) + 1)) goto L60;
        char r23 = r15;
        if (fpexp2.charAt(p2) == '.') goto L97;
        if (fpexp2.charAt(p2) < r23) goto L104;
        char r17 = '9';
        if (fpexp2.charAt(p2) <= '9') goto L103;
    L105:
        p2 = p2 + 1;
        r15 = r23;
        goto L56
    L103:
        striped[q] = fpexp2.charAt(p2);
        q = q + 1;
        p2 = p2 + 1;
        significantDigits = significantDigits + 1;
        r15 = r23;
        goto L56
    L104:
        r17 = '9';
        goto L105
    L97:
        decimalFound = true;
        decimalPos = significantDigits;
        p2 = p2 + 1;
        r15 = r23;
    L60:
        if (decimalFound == false) goto L69;
        int r13 = r22;
        if (q == r13) goto L69;
    L63:
        q = q - 1;
        if (q == r13) goto L69;
        if (striped[q] != r15) goto L69;
        significantDigits = significantDigits - 1;
        r13 = 4;
    L69:
        if (decimalFound == false) goto L72;
        if (significantDigits != 0) goto L72;
        decimalPos = 0;
    L72:
        if (decimalFound == true) goto L74;
        decimalPos = q - 4;
    L74:
        int p3 = (significantDigits - 1) + 4;
        int trailingZeros = 0;
    L75:
        if (p3 <= 4) goto L80;
        if (striped[p3] != r15) goto L80;
        trailingZeros = trailingZeros + 1;
        p3 = p3 - 1;
    L80:
        char r24 = r15;
        int r18 = 4;
        int i2 = ((400 - decimalPos) - (sciexp % 4)) % 4;
        int q2 = 4 - i2;
        int decimalPos2 = decimalPos + i2;
    L81:
        int r25 = r18;
        if ((p3 - q2) >= (this.mant.length * 4)) goto L88;
        int i3 = 0;
    L85:
        if (i3 >= r25) goto L87;
        p3 = p3 + 1;
        striped[p3] = r24;
        i3 = i3 + 1;
        r25 = 4;
        goto L85
    L87:
        r18 = 4;
        goto L81
    L88:
        int i4 = this.mant.length - 1;
    L89:
        if (i4 < 0) goto L91;
        this.mant[i4] = ((((striped[q2] - '0') * 1000) + ((striped[q2 + 1] - '0') * 100)) + ((striped[q2 + 2] - '0') * 10)) + (striped[q2 + 3] - '0');
        q2 = q2 + 4;
        i4 = i4 - 1;
        goto L89
    L91:
        this.exp = (decimalPos2 + sciexp) / 4;
        if (q2 >= striped.length) goto L132;
        round((striped[q2] - '0') * 1000);
        return;
    L132:
        return;
    L43:
        if (fpexp2.charAt(p2) > r14) goto L45;
    L35:
        r22 = 4;
        r20 = 3;
        fpexp2 = s;
        goto L37
    }

    protected Dfp(DfpField field, byte sign, byte nans) {
        this.field = field;
        this.mant = new int[field.getRadixDigits()];
        this.sign = sign;
        this.exp = 0;
        this.nans = nans;
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [org.apache.commons.math.dfp.DfpField] */
    public Dfp newInstance() {
        return new Dfp(getField2());
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [org.apache.commons.math.dfp.DfpField] */
    public Dfp newInstance(byte x) {
        return new Dfp(getField2(), x);
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [org.apache.commons.math.dfp.DfpField] */
    public Dfp newInstance(int x) {
        return new Dfp(getField2(), x);
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [org.apache.commons.math.dfp.DfpField] */
    public Dfp newInstance(long x) {
        return new Dfp(getField2(), x);
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [org.apache.commons.math.dfp.DfpField] */
    public Dfp newInstance(double x) {
        return new Dfp(getField2(), x);
    }

    public Dfp newInstance(Dfp d) {
        if (this.field.getRadixDigits() == d.field.getRadixDigits()) goto L7;
        this.field.setIEEEFlagsBits(1);
        Dfp result = newInstance(getZero());
        result.nans = 3;
        return dotrap(1, NEW_INSTANCE_TRAP, d, result);
    L7:
        return new Dfp(d);
    }

    public Dfp newInstance(String s) {
        return new Dfp(this.field, s);
    }

    public Dfp newInstance(byte sig, byte code) {
        return this.field.newDfp(sig, code);
    }

    @Override // org.apache.commons.math.FieldElement
    /* JADX INFO: renamed from: getField, reason: avoid collision after fix types in other method */
    public Field<Dfp> getField2() {
        return this.field;
    }

    public int getRadixDigits() {
        return this.field.getRadixDigits();
    }

    public Dfp getZero() {
        return this.field.getZero2();
    }

    public Dfp getOne() {
        return this.field.getOne2();
    }

    public Dfp getTwo() {
        return this.field.getTwo();
    }

    protected void shiftLeft() {
        int i = this.mant.length - 1;
    L3:
        if (i <= 0) goto L5;
        this.mant[i] = this.mant[i - 1];
        i = i - 1;
        goto L3
    L5:
        this.mant[0] = 0;
        this.exp--;
    }

    protected void shiftRight() {
        int i = 0;
    L4:
        if (i >= (this.mant.length - 1)) goto L6;
        this.mant[i] = this.mant[i + 1];
        i = i + 1;
        goto L4
    L6:
        this.mant[this.mant.length - 1] = 0;
        this.exp++;
    }

    protected int align(int e) {
        int lostdigit = 0;
        boolean inexact = false;
        int diff = this.exp - e;
        int adiff = diff;
        if (adiff >= 0) goto L6;
        adiff = -adiff;
    L6:
        if (diff != 0) goto L9;
        return 0;
    L9:
        if (adiff <= (this.mant.length + 1)) goto L12;
        Arrays.fill(this.mant, 0);
        this.exp = e;
        this.field.setIEEEFlagsBits(16);
        dotrap(16, ALIGN_TRAP, this, this);
        return 0;
    L12:
        int i = 0;
    L13:
        if (i >= adiff) goto L21;
        if (diff >= 0) goto L18;
        if (lostdigit == 0) goto L17;
        inexact = true;
    L17:
        lostdigit = this.mant[0];
        shiftRight();
    L19:
        i = i + 1;
        goto L13
    L18:
        shiftLeft();
        goto L19
    L21:
        if (inexact == false) goto L23;
        this.field.setIEEEFlagsBits(16);
        dotrap(16, ALIGN_TRAP, this, this);
    L23:
        return lostdigit;
    }

    public boolean lessThan(Dfp x) {
        if (this.field.getRadixDigits() == x.field.getRadixDigits()) goto L7;
        this.field.setIEEEFlagsBits(1);
        Dfp result = newInstance(getZero());
        result.nans = 3;
        dotrap(1, LESS_THAN_TRAP, x, result);
        return false;
    L7:
        if (isNaN() == false) goto L9;
    L15:
        this.field.setIEEEFlagsBits(1);
        dotrap(1, LESS_THAN_TRAP, x, newInstance(getZero()));
        return false;
    L9:
        if (x.isNaN() == true) goto L15;
        if (compare(this, x) < 0) goto L14;
        return false;
    L14:
        return true;
    }

    public boolean greaterThan(Dfp x) {
        if (this.field.getRadixDigits() == x.field.getRadixDigits()) goto L7;
        this.field.setIEEEFlagsBits(1);
        Dfp result = newInstance(getZero());
        result.nans = 3;
        dotrap(1, GREATER_THAN_TRAP, x, result);
        return false;
    L7:
        if (isNaN() == false) goto L9;
    L15:
        this.field.setIEEEFlagsBits(1);
        dotrap(1, GREATER_THAN_TRAP, x, newInstance(getZero()));
        return false;
    L9:
        if (x.isNaN() == true) goto L15;
        if (compare(this, x) > 0) goto L14;
        return false;
    L14:
        return true;
    }

    public boolean isInfinite() {
        if (this.nans == 1) goto L7;
        return false;
    L7:
        return true;
    }

    public boolean isNaN() {
        if (this.nans != 3) goto L5;
    L8:
        return true;
    L5:
        if (this.nans == 2) goto L8;
        return false;
    }

    public boolean equals(Object other) {
        if ((other instanceof Dfp) == false) goto L16;
        Dfp x = (Dfp) other;
        if (isNaN() == false) goto L7;
    L15:
        return false;
    L7:
        if (x.isNaN() == true) goto L15;
        if (this.field.getRadixDigits() != x.field.getRadixDigits()) goto L15;
        if (compare(this, x) != 0) goto L17;
        return true;
    L17:
        return false;
    L16:
        return false;
    }

    public int hashCode() {
        return ((((this.sign << 8) + 17) + (this.nans << 16)) + this.exp) + Arrays.hashCode(this.mant);
    }

    public boolean unequal(Dfp x) {
        if (isNaN() == false) goto L5;
    L15:
        return false;
    L5:
        if (x.isNaN() == true) goto L15;
        if (this.field.getRadixDigits() != x.field.getRadixDigits()) goto L15;
        if (greaterThan(x) == false) goto L12;
    L13:
        return true;
    L12:
        if (lessThan(x) == true) goto L13;
        return false;
    }

    private static int compare(Dfp a, Dfp b) {
        if (a.mant[a.mant.length - 1] != 0) goto L12;
        if (b.mant[b.mant.length - 1] != 0) goto L12;
        if (a.nans != 0) goto L12;
        if (b.nans != 0) goto L12;
        return 0;
    L12:
        if (a.sign == b.sign) goto L18;
        if (a.sign != (-1)) goto L16;
        return -1;
    L16:
        return 1;
    L18:
        if (a.nans != 1) goto L24;
        if (b.nans != 0) goto L24;
        return a.sign;
    L24:
        if (a.nans != 0) goto L30;
        if (b.nans != 1) goto L30;
        return -b.sign;
    L30:
        if (a.nans != 1) goto L35;
        if (b.nans != 1) goto L35;
        return 0;
    L35:
        if (b.mant[b.mant.length - 1] != 0) goto L37;
    L46:
        int i = a.mant.length - 1;
    L47:
        if (i < 0) goto L58;
        if (a.mant[i] > b.mant[i]) goto L51;
        if (a.mant[i] < b.mant[i]) goto L55;
        i = i - 1;
        goto L47
    L55:
        return -a.sign;
    L51:
        return a.sign;
    L58:
        return 0;
    L37:
        if (a.mant[b.mant.length - 1] == 0) goto L46;
        if (a.exp >= b.exp) goto L43;
        return -a.sign;
    L43:
        if (a.exp <= b.exp) goto L46;
        return a.sign;
    }

    public Dfp rint() {
        return trunc(DfpField.RoundingMode.ROUND_HALF_EVEN);
    }

    public Dfp floor() {
        return trunc(DfpField.RoundingMode.ROUND_FLOOR);
    }

    public Dfp ceil() {
        return trunc(DfpField.RoundingMode.ROUND_CEIL);
    }

    public Dfp remainder(Dfp d) {
        Dfp result = subtract2(divide2(d).rint().multiply2(d));
        if (result.mant[this.mant.length - 1] != 0) goto L5;
        result.sign = this.sign;
    L5:
        return result;
    }

    protected Dfp trunc(DfpField.RoundingMode rmode) {
        boolean changed = false;
        if (isNaN() == false) goto L7;
        return newInstance(this);
    L7:
        if (this.nans != 1) goto L11;
        return newInstance(this);
    L11:
        if (this.mant[this.mant.length - 1] != 0) goto L15;
        return newInstance(this);
    L15:
        if (this.exp >= 0) goto L19;
        this.field.setIEEEFlagsBits(16);
        return dotrap(16, TRUNC_TRAP, this, newInstance(getZero()));
    L19:
        if (this.exp >= this.mant.length) goto L21;
        Dfp result = newInstance(this);
        int i = 0;
    L24:
        if (i >= (this.mant.length - result.exp)) goto L31;
        if (result.mant[i] == 0) goto L28;
        boolean r6 = true;
    L29:
        changed = changed | r6;
        result.mant[i] = 0;
        i = i + 1;
        goto L24
    L28:
        r6 = false;
        goto L29
    L31:
        if (changed == true) goto L33;
        return result;
    L33:
        switch(AnonymousClass1.$SwitchMap$org$apache$commons$math$dfp$DfpField$RoundingMode[rmode.ordinal()]) {
            case 1: goto L48;
            case 2: goto L45;
            default: goto L34;
        };
    L34:
        Dfp half = newInstance("0.5");
        Dfp a = subtract2(result);
        a.sign = 1;
        if (a.greaterThan(half) == false) goto L38;
        a = newInstance(getOne());
        a.sign = this.sign;
        result = result.add2(a);
    L38:
        if (a.equals(half) == true) goto L40;
    L50:
        this.field.setIEEEFlagsBits(16);
        return dotrap(16, TRUNC_TRAP, this, result);
    L40:
        if (result.exp <= 0) goto L50;
        if ((1 & result.mant[this.mant.length - result.exp]) == 0) goto L50;
        Dfp a2 = newInstance(getOne());
        a2.sign = this.sign;
        result = result.add2(a2);
        goto L50
    L45:
        if (result.sign != 1) goto L50;
        result = result.add2(getOne());
        goto L50
    L48:
        if (result.sign != (-1)) goto L50;
        result = result.add2(newInstance(-1));
        goto L50
    L21:
        return newInstance(this);
    }

    public int intValue() {
        int result = 0;
        Dfp rounded = rint();
        if (rounded.greaterThan(newInstance(Integer.MAX_VALUE)) == false) goto L6;
        return Integer.MAX_VALUE;
    L6:
        if (rounded.lessThan(newInstance(Integer.MIN_VALUE)) == false) goto L8;
        return Integer.MIN_VALUE;
    L8:
        int i = this.mant.length;
    L9:
        i = i - 1;
        if (i < (this.mant.length - rounded.exp)) goto L12;
        result = (result * 10000) + rounded.mant[i];
        goto L9
    L12:
        int i2 = rounded.sign;
        if (i2 == (-1)) goto L15;
        return result;
    L15:
        return -result;
    }

    public int log10K() {
        return this.exp - 1;
    }

    public Dfp power10K(int e) {
        Dfp d = newInstance(getOne());
        d.exp = e + 1;
        return d;
    }

    public int log10() {
        if (this.mant[this.mant.length - 1] <= 1000) goto L7;
        return (this.exp * 4) - 1;
    L7:
        if (this.mant[this.mant.length - 1] <= 100) goto L11;
        return (this.exp * 4) - 2;
    L11:
        if (this.mant[this.mant.length - 1] <= 10) goto L15;
        return (this.exp * 4) - 3;
    L15:
        return (this.exp * 4) - 4;
    }

    public Dfp power10(int e) {
        Dfp d = newInstance(getOne());
        if (e < 0) goto L5;
        d.exp = (e / 4) + 1;
    L7:
        switch((((e % 4) + 4) % 4)) {
            case 0: goto L15;
            case 1: goto L14;
            case 2: goto L13;
            default: goto L12;
        };
    L15:
        return d;
    L12:
        return d.multiply(1000);
    L13:
        return d.multiply(100);
    L14:
        return d.multiply(10);
    L5:
        d.exp = (e + 1) / 4;
        goto L7
    }

    protected int complement(int extra) {
        int extra2 = 10000 - extra;
        int i = 0;
    L4:
        if (i >= this.mant.length) goto L6;
        this.mant[i] = (10000 - this.mant[i]) - 1;
        i = i + 1;
        goto L4
    L6:
        int rh = extra2 / 10000;
        int extra3 = extra2 - (rh * 10000);
        int i2 = 0;
    L8:
        if (i2 >= this.mant.length) goto L11;
        int r = this.mant[i2] + rh;
        rh = r / 10000;
        this.mant[i2] = r - (rh * 10000);
        i2 = i2 + 1;
        goto L8
    L11:
        return extra3;
    }

    /* JADX INFO: renamed from: add, reason: avoid collision after fix types in other method */
    public Dfp add2(Dfp x) {
        byte r6 = 1;
        if (this.field.getRadixDigits() == x.field.getRadixDigits()) goto L7;
        this.field.setIEEEFlagsBits(1);
        Dfp result = newInstance(getZero());
        result.nans = 3;
        return dotrap(1, ADD_TRAP, x, result);
    L7:
        if (this.nans != 0) goto L11;
        if (x.nans != 0) goto L11;
    L41:
        Dfp a = newInstance(this);
        Dfp b = newInstance(x);
        Dfp result2 = newInstance(getZero());
        byte asign = a.sign;
        byte bsign = b.sign;
        a.sign = 1;
        b.sign = 1;
        byte rsign = bsign;
        if (compare(a, b) <= 0) goto L45;
        rsign = asign;
    L45:
        if (b.mant[this.mant.length - 1] != 0) goto L48;
        b.exp = a.exp;
    L48:
        if (a.mant[this.mant.length - 1] != 0) goto L50;
        a.exp = b.exp;
    L50:
        int aextradigit = 0;
        int bextradigit = 0;
        if (a.exp >= b.exp) goto L53;
        aextradigit = a.align(b.exp);
    L54:
        if (asign == bsign) goto L58;
        if (asign != rsign) goto L57;
        bextradigit = b.complement(bextradigit);
        goto L58
    L57:
        aextradigit = a.complement(aextradigit);
    L58:
        int rh = 0;
        int i = 0;
    L60:
        if (i >= this.mant.length) goto L62;
        int r = (a.mant[i] + b.mant[i]) + rh;
        rh = r / 10000;
        result2.mant[i] = r - (rh * 10000);
        i = i + 1;
        r6 = r6;
        goto L60
    L62:
        byte r16 = r6;
        result2.exp = a.exp;
        result2.sign = rsign;
        if (rh == 0) goto L68;
        if (asign != bsign) goto L68;
        int lostdigit = result2.mant[0];
        result2.shiftRight();
        result2.mant[this.mant.length - 1] = rh;
        int excp = result2.round(lostdigit);
        if (excp == 0) goto L68;
        result2 = dotrap(excp, ADD_TRAP, x, result2);
    L68:
        int i2 = 0;
    L70:
        if (i2 >= this.mant.length) goto L79;
        if (result2.mant[this.mant.length - 1] != 0) goto L79;
        result2.shiftLeft();
        if (i2 != 0) goto L77;
        result2.mant[0] = aextradigit + bextradigit;
        aextradigit = 0;
        bextradigit = 0;
    L77:
        i2 = i2 + 1;
    L79:
        if (result2.mant[this.mant.length - 1] != 0) goto L83;
        result2.exp = 0;
        if (asign == bsign) goto L83;
        result2.sign = r16;
    L83:
        int excp2 = result2.round(aextradigit + bextradigit);
        if (excp2 != 0) goto L86;
        return result2;
    L86:
        return dotrap(excp2, ADD_TRAP, x, result2);
    L53:
        bextradigit = b.align(a.exp);
    L11:
        if (isNaN() == false) goto L14;
        return this;
    L14:
        if (x.isNaN() == false) goto L17;
        return x;
    L17:
        if (this.nans != 1) goto L22;
        if (x.nans != 0) goto L22;
        return this;
    L22:
        if (x.nans != 1) goto L27;
        if (this.nans != 0) goto L27;
        return x;
    L27:
        if (x.nans != 1) goto L34;
        if (this.nans != 1) goto L34;
        if (this.sign != x.sign) goto L34;
        return x;
    L34:
        if (x.nans != 1) goto L41;
        if (this.nans != 1) goto L41;
        if (this.sign == x.sign) goto L41;
        this.field.setIEEEFlagsBits(1);
        Dfp result3 = newInstance(getZero());
        result3.nans = 3;
        return dotrap(1, ADD_TRAP, x, result3);
    }

    public Dfp negate() {
        Dfp result = newInstance(this);
        result.sign = (byte) (-result.sign);
        return result;
    }

    /* JADX INFO: renamed from: subtract, reason: avoid collision after fix types in other method */
    public Dfp subtract2(Dfp x) {
        return add2(x.negate());
    }

    protected int round(int n) {
        switch(AnonymousClass1.$SwitchMap$org$apache$commons$math$dfp$DfpField$RoundingMode[this.field.getRoundingMode().ordinal()]) {
            case 2: goto L40;
            case 3: goto L31;
            case 4: goto L30;
            case 5: goto L26;
            case 6: goto L22;
            case 7: goto L18;
            case 8: goto L10;
            default: goto L5;
        };
    L10:
        if (n > 5000) goto L16;
        if (n == 5000) goto L13;
    L15:
        boolean inc = false;
    L45:
        if (inc == false) goto L53;
        int rh = 1;
        int i = 0;
    L48:
        if (i >= this.mant.length) goto L51;
        int r = this.mant[i] + rh;
        rh = r / 10000;
        this.mant[i] = r - (rh * 10000);
        i = i + 1;
        goto L48
    L51:
        if (rh == 0) goto L53;
        shiftRight();
        this.mant[this.mant.length - 1] = rh;
    L53:
        int rh2 = this.exp;
        if (rh2 >= (-32767)) goto L58;
        this.field.setIEEEFlagsBits(8);
        return 8;
    L58:
        if (this.exp <= 32768) goto L61;
        this.field.setIEEEFlagsBits(4);
        return 4;
    L61:
        if (n == 0) goto L64;
        this.field.setIEEEFlagsBits(16);
        return 16;
    L64:
        return 0;
    L13:
        if ((this.mant[0] & 1) != 0) goto L15;
    L16:
        inc = true;
        goto L45
    L18:
        if (n <= 5000) goto L20;
        inc = true;
        goto L45
    L20:
        inc = false;
        goto L45
    L22:
        if (n < 5000) goto L24;
        inc = true;
        goto L45
    L24:
        inc = false;
        goto L45
    L26:
        if (n == 0) goto L28;
        inc = true;
        goto L45
    L28:
        inc = false;
        goto L45
    L30:
        inc = false;
        goto L45
    L31:
        if (n > 5000) goto L37;
        if (n == 5000) goto L34;
    L36:
        inc = false;
        goto L45
    L34:
        if ((this.mant[0] & 1) != 1) goto L36;
    L37:
        inc = true;
        goto L45
    L5:
        if (this.sign != (-1)) goto L8;
        if (n == 0) goto L8;
        inc = true;
    L8:
        inc = false;
        goto L45
    L40:
        if (this.sign != 1) goto L43;
        if (n == 0) goto L43;
        inc = true;
    L43:
        inc = false;
        goto L45
    }

    /* JADX INFO: renamed from: multiply, reason: avoid collision after fix types in other method */
    public Dfp multiply2(Dfp x) {
        if (this.field.getRadixDigits() == x.field.getRadixDigits()) goto L6;
        this.field.setIEEEFlagsBits(1);
        Dfp result = newInstance(getZero());
        result.nans = 3;
        return dotrap(1, MULTIPLY_TRAP, x, result);
    L6:
        Dfp result2 = newInstance(getZero());
        if (this.nans != 0) goto L11;
        if (x.nans != 0) goto L11;
    L52:
        int[] product = new int[this.mant.length * 2];
        int i = 0;
    L54:
        if (i >= this.mant.length) goto L60;
        int rh = 0;
        int j = 0;
    L57:
        if (j >= this.mant.length) goto L59;
        int r = (product[i + j] + (this.mant[i] * x.mant[j])) + rh;
        rh = r / 10000;
        product[i + j] = r - (rh * 10000);
        j = j + 1;
        goto L57
    L59:
        product[this.mant.length + i] = rh;
        i = i + 1;
        goto L54
    L60:
        int md = (this.mant.length * 2) - 1;
        int i2 = (this.mant.length * 2) - 1;
    L61:
        if (i2 < 0) goto L66;
        if (product[i2] != 0) goto L64;
        i2 = i2 - 1;
        goto L61
    L64:
        md = i2;
    L66:
        int i3 = 0;
    L68:
        if (i3 >= this.mant.length) goto L70;
        result2.mant[(this.mant.length - i3) - 1] = product[md - i3];
        i3 = i3 + 1;
        goto L68
    L70:
        int i4 = this.exp;
        result2.exp = (((i4 + x.exp) + md) - (this.mant.length * 2)) + 1;
        if (this.sign != x.sign) goto L73;
        int r5 = 1;
    L74:
        result2.sign = (byte) r5;
        if (result2.mant[this.mant.length - 1] != 0) goto L78;
        result2.exp = 0;
    L78:
        if (md <= (this.mant.length - 1)) goto L80;
        int excp = result2.round(product[md - this.mant.length]);
    L81:
        if (excp != 0) goto L83;
        return result2;
    L83:
        return dotrap(excp, MULTIPLY_TRAP, x, result2);
    L80:
        excp = result2.round(0);
        goto L81
    L73:
        r5 = -1;
    L11:
        if (isNaN() == false) goto L14;
        return this;
    L14:
        if (x.isNaN() == false) goto L17;
        return x;
    L17:
        if (this.nans != 1) goto L25;
        if (x.nans != 0) goto L25;
        if (x.mant[this.mant.length - 1] == 0) goto L25;
        Dfp result3 = newInstance(this);
        result3.sign = (byte) (this.sign * x.sign);
        return result3;
    L25:
        if (x.nans != 1) goto L33;
        if (this.nans != 0) goto L33;
        if (this.mant[this.mant.length - 1] == 0) goto L33;
        Dfp result4 = newInstance(x);
        result4.sign = (byte) (this.sign * x.sign);
        return result4;
    L33:
        if (x.nans != 1) goto L39;
        if (this.nans != 1) goto L39;
        Dfp result5 = newInstance(this);
        result5.sign = (byte) (this.sign * x.sign);
        return result5;
    L39:
        if (x.nans != 1) goto L45;
        if (this.nans != 0) goto L45;
        if (this.mant[this.mant.length - 1] != 0) goto L45;
    L50:
        this.field.setIEEEFlagsBits(1);
        Dfp result6 = newInstance(getZero());
        result6.nans = 3;
        return dotrap(1, MULTIPLY_TRAP, x, result6);
    L45:
        if (this.nans != 1) goto L52;
        if (x.nans != 0) goto L52;
        if (x.mant[this.mant.length - 1] != 0) goto L52;
        goto L50
    }

    public Dfp multiply(int x) {
        Dfp result = newInstance(this);
        if (this.nans != 0) goto L5;
    L17:
        if (x >= 0) goto L19;
    L35:
        this.field.setIEEEFlagsBits(1);
        Dfp result2 = newInstance(getZero());
        result2.nans = 3;
        return dotrap(1, MULTIPLY_TRAP, result2, result2);
    L19:
        if (x >= 10000) goto L35;
        int rh = 0;
        int i = 0;
    L23:
        if (i >= this.mant.length) goto L25;
        int r = (this.mant[i] * x) + rh;
        rh = r / 10000;
        result.mant[i] = r - (rh * 10000);
        i = i + 1;
        goto L23
    L25:
        int lostdigit = 0;
        if (rh == 0) goto L29;
        lostdigit = result.mant[0];
        result.shiftRight();
        result.mant[this.mant.length - 1] = rh;
    L29:
        if (result.mant[this.mant.length - 1] != 0) goto L31;
        result.exp = 0;
    L31:
        int excp = result.round(lostdigit);
        if (excp != 0) goto L34;
        return result;
    L34:
        return dotrap(excp, MULTIPLY_TRAP, result, result);
    L5:
        if (isNaN() == false) goto L8;
        return this;
    L8:
        if (this.nans != 1) goto L13;
        if (x == 0) goto L13;
        return newInstance(this);
    L13:
        if (this.nans != 1) goto L17;
        if (x != 0) goto L17;
        this.field.setIEEEFlagsBits(1);
        Dfp result3 = newInstance(getZero());
        result3.nans = 3;
        return dotrap(1, MULTIPLY_TRAP, newInstance(getZero()), result3);
    }

    /* JADX INFO: renamed from: divide, reason: avoid collision after fix types in other method */
    public Dfp divide2(Dfp divisor) {
        int trial = 0;
        int md = 0;
        int r8 = 1;
        if (this.field.getRadixDigits() == divisor.field.getRadixDigits()) goto L6;
        this.field.setIEEEFlagsBits(1);
        Dfp result = newInstance(getZero());
        result.nans = 3;
        return dotrap(1, DIVIDE_TRAP, divisor, result);
    L6:
        Dfp result2 = newInstance(getZero());
        if (this.nans != 0) goto L11;
        if (divisor.nans != 0) goto L11;
    L34:
        int r6 = 2;
        if (divisor.mant[this.mant.length - 1] != 0) goto L38;
        this.field.setIEEEFlagsBits(2);
        Dfp result3 = newInstance(getZero());
        result3.sign = (byte) (this.sign * divisor.sign);
        result3.nans = 1;
        return dotrap(2, DIVIDE_TRAP, divisor, result3);
    L38:
        int[] dividend = new int[this.mant.length + 1];
        int[] quotient = new int[this.mant.length + 2];
        int[] remainder = new int[this.mant.length + 1];
        int r12 = 0;
        dividend[this.mant.length] = 0;
        quotient[this.mant.length] = 0;
        quotient[this.mant.length + 1] = 0;
        remainder[this.mant.length] = 0;
        int i = 0;
    L40:
        if (i >= this.mant.length) goto L42;
        dividend[i] = this.mant[i];
        quotient[i] = 0;
        remainder[i] = 0;
        i = i + 1;
        goto L40
    L42:
        int nsqd = 0;
        int qd = this.mant.length + 1;
    L43:
        if (qd < 0) goto L99;
        int divMsb = (dividend[this.mant.length] * 10000) + dividend[this.mant.length - r8];
        int r16 = r8;
        int min = divMsb / (divisor.mant[this.mant.length - 1] + 1);
        int r17 = r12;
        int r18 = r6;
        int max = (divMsb + 1) / divisor.mant[this.mant.length - 1];
        boolean trialgood = false;
    L45:
        if (trialgood == true) goto L82;
        int trial2 = (min + max) / 2;
        int rh = 0;
        trial = trial2;
        int trial3 = 0;
    L47:
        md = md;
        if (trial3 >= (this.mant.length + 1)) goto L54;
        if (trial3 >= this.mant.length) goto L52;
        int dm = divisor.mant[trial3];
    L53:
        int i2 = trial3;
        int i3 = (dm * trial) + rh;
        rh = i3 / 10000;
        remainder[i2] = i3 - (rh * 10000);
        trial3 = i2 + 1;
        md = md;
        goto L47
    L52:
        dm = r17;
        goto L53
    L54:
        int rh2 = 1;
        int i4 = 0;
    L56:
        if (i4 >= (this.mant.length + 1)) goto L59;
        int r = ((9999 - remainder[i4]) + dividend[i4]) + rh2;
        rh2 = r / 10000;
        int i5 = i4;
        int i6 = rh2 * 10000;
        remainder[i5] = r - i6;
        i4 = i5 + 1;
        goto L56
    L59:
        if (rh2 == 0) goto L60;
        int minadj = ((remainder[this.mant.length] * 10000) + remainder[this.mant.length - 1]) / (divisor.mant[this.mant.length - 1] + 1);
        int r13 = r18;
        if (minadj >= r13) goto L63;
        boolean trialgood2 = false;
        int i7 = this.mant.length - 1;
    L65:
        if (i7 < 0) goto L76;
        boolean trialgood3 = trialgood2;
        if (divisor.mant[i7] <= remainder[i7]) goto L69;
        boolean trialgood4 = true;
    L70:
        boolean trialgood5 = trialgood4;
        if (divisor.mant[i7] < remainder[i7]) goto L72;
        i7 = i7 - 1;
        trialgood2 = trialgood5;
        goto L65
    L72:
        trialgood2 = trialgood5;
        goto L76
    L69:
        trialgood4 = trialgood3;
    L76:
        if (remainder[this.mant.length] == 0) goto L78;
        trialgood = false;
    L79:
        if (trialgood == true) goto L81;
        min = trial + 1;
    L81:
        r18 = 2;
        goto L45
    L78:
        trialgood = trialgood2;
        goto L79
    L63:
        min = trial + minadj;
        r18 = r13;
        goto L45
    L60:
        max = trial - 1;
        goto L45
    L82:
        int md2 = md;
        quotient[qd] = trial;
        if (trial != 0) goto L85;
        if (nsqd != 0) goto L85;
    L87:
        if (this.field.getRoundingMode() != DfpField.RoundingMode.ROUND_DOWN) goto L92;
        if (nsqd != this.mant.length) goto L92;
    L100:
        int md3 = this.mant.length;
        int i8 = this.mant.length + 1;
    L101:
        if (i8 < 0) goto L106;
        if (quotient[i8] != 0) goto L104;
        i8 = i8 - 1;
        goto L101
    L104:
        md3 = i8;
    L106:
        int i9 = 0;
    L108:
        if (i9 >= this.mant.length) goto L110;
        result2.mant[(this.mant.length - i9) - 1] = quotient[md3 - i9];
        i9 = i9 + 1;
        goto L108
    L110:
        int i10 = this.exp;
        result2.exp = ((i10 - divisor.exp) + md3) - this.mant.length;
        if (this.sign != divisor.sign) goto L113;
        int r7 = r16;
    L114:
        result2.sign = (byte) r7;
        if (result2.mant[this.mant.length - 1] != 0) goto L118;
        result2.exp = r17;
    L118:
        if (md3 <= (this.mant.length - 1)) goto L120;
        int excp = result2.round(quotient[md3 - this.mant.length]);
    L121:
        if (excp != 0) goto L123;
        return result2;
    L123:
        return dotrap(excp, DIVIDE_TRAP, divisor, result2);
    L120:
        excp = result2.round(0);
        goto L121
    L113:
        r7 = -1;
    L92:
        if (nsqd > this.mant.length) goto L100;
        dividend[r17] = r17;
        int i11 = 0;
    L96:
        if (i11 >= this.mant.length) goto L98;
        dividend[i11 + 1] = remainder[i11];
        i11 = i11 + 1;
        goto L96
    L98:
        qd = qd - 1;
        r8 = r16;
        r12 = r17;
        md = md2;
        r6 = 2;
    L85:
        nsqd = nsqd + 1;
        goto L87
    L99:
        r16 = r8;
        r17 = r12;
    L11:
        if (isNaN() == false) goto L14;
        return this;
    L14:
        if (divisor.isNaN() == false) goto L17;
        return divisor;
    L17:
        if (this.nans != 1) goto L23;
        if (divisor.nans != 0) goto L23;
        Dfp result4 = newInstance(this);
        result4.sign = (byte) (this.sign * divisor.sign);
        return result4;
    L23:
        if (divisor.nans != 1) goto L29;
        if (this.nans != 0) goto L29;
        Dfp result5 = newInstance(getZero());
        result5.sign = (byte) (this.sign * divisor.sign);
        return result5;
    L29:
        if (divisor.nans != 1) goto L34;
        if (this.nans != 1) goto L34;
        this.field.setIEEEFlagsBits(1);
        Dfp result6 = newInstance(getZero());
        result6.nans = 3;
        return dotrap(1, DIVIDE_TRAP, divisor, result6);
    }

    public Dfp divide(int divisor) {
        if (this.nans == 0) goto L12;
        if (isNaN() == false) goto L8;
        return this;
    L8:
        if (this.nans != 1) goto L12;
        return newInstance(this);
    L12:
        if (divisor != 0) goto L15;
        this.field.setIEEEFlagsBits(2);
        Dfp result = newInstance(getZero());
        result.sign = this.sign;
        result.nans = 1;
        return dotrap(2, DIVIDE_TRAP, getZero(), result);
    L15:
        if (divisor >= 0) goto L17;
    L29:
        this.field.setIEEEFlagsBits(1);
        Dfp result2 = newInstance(getZero());
        result2.nans = 3;
        return dotrap(1, DIVIDE_TRAP, result2, result2);
    L17:
        if (divisor >= 10000) goto L29;
        Dfp result3 = newInstance(this);
        int rl = 0;
        int i = this.mant.length - 1;
    L20:
        if (i < 0) goto L23;
        int r = (rl * 10000) + result3.mant[i];
        int rh = r / divisor;
        rl = r - (rh * divisor);
        result3.mant[i] = rh;
        i = i - 1;
        goto L20
    L23:
        if (result3.mant[this.mant.length - 1] != 0) goto L25;
        result3.shiftLeft();
        int r2 = rl * 10000;
        int rh2 = r2 / divisor;
        rl = r2 - (rh2 * divisor);
        result3.mant[0] = rh2;
    L25:
        int excp = result3.round((rl * 10000) / divisor);
        if (excp != 0) goto L28;
        return result3;
    L28:
        return dotrap(excp, DIVIDE_TRAP, result3, result3);
    }

    public Dfp sqrt() {
        if (this.nans != 0) goto L9;
        if (this.mant[this.mant.length - 1] != 0) goto L9;
        return newInstance(this);
    L9:
        if (this.nans == 0) goto L25;
        if (this.nans != 1) goto L17;
        if (this.sign != 1) goto L17;
        return newInstance(this);
    L17:
        if (this.nans != 3) goto L21;
        return newInstance(this);
    L21:
        if (this.nans != 2) goto L25;
        this.field.setIEEEFlagsBits(1);
        return dotrap(1, SQRT_TRAP, null, newInstance(this));
    L25:
        if (this.sign != (-1)) goto L28;
        this.field.setIEEEFlagsBits(1);
        Dfp result = newInstance(this);
        result.nans = 3;
        return dotrap(1, SQRT_TRAP, null, result);
    L28:
        Dfp x = newInstance(this);
        if (x.exp >= (-1)) goto L31;
    L32:
        x.exp = this.exp / 2;
    L34:
        switch((x.mant[this.mant.length - 1] / 2000)) {
            case 0: goto L38;
            case 1: goto L35;
            case 2: goto L37;
            case 3: goto L36;
            default: goto L35;
        };
    L35:
        x.mant[this.mant.length - 1] = 3000;
    L39:
        newInstance(x);
        Dfp px = getZero();
        getZero();
    L41:
        if (x.unequal(px) == false) goto L47;
        Dfp dx = newInstance(x);
        dx.sign = -1;
        Dfp dx2 = dx.add2(divide2(x)).divide(2);
        Object ppx = px;
        px = x;
        x = x.add2(dx2);
        if (x.equals(ppx) == true) goto L47;
        if (dx2.mant[this.mant.length - 1] != 0) goto L41;
    L47:
        return x;
    L36:
        x.mant[this.mant.length - 1] = 2200;
        goto L39
    L37:
        x.mant[this.mant.length - 1] = 1500;
        goto L39
    L38:
        x.mant[this.mant.length - 1] = (x.mant[this.mant.length - 1] / 2) + 1;
        goto L39
    L31:
        if (x.exp <= 1) goto L34;
        goto L32
    }

    public String toString() {
        if (this.nans == 0) goto L14;
        if (this.nans == 1) goto L7;
        return NAN_STRING;
    L7:
        if (this.sign >= 0) goto L9;
        return NEG_INFINITY_STRING;
    L9:
        return POS_INFINITY_STRING;
    L14:
        if (this.exp > this.mant.length) goto L21;
        if (this.exp < (-1)) goto L21;
        return dfp2string();
    L21:
        return dfp2sci();
    }

    protected String dfp2sci() {
        char[] rawdigits = new char[this.mant.length * 4];
        char[] outputbuffer = new char[(this.mant.length * 4) + 20];
        int p = 0;
        int i = this.mant.length;
    L3:
        i = i - 1;
        if (i < 0) goto L6;
        int p2 = p + 1;
        rawdigits[p] = (char) ((this.mant[i] / 1000) + 48);
        int p3 = p2 + 1;
        rawdigits[p2] = (char) (((this.mant[i] / 100) % 10) + 48);
        int p4 = p3 + 1;
        rawdigits[p3] = (char) (((this.mant[i] / 10) % 10) + 48);
        p = p4 + 1;
        rawdigits[p4] = (char) ((this.mant[i] % 10) + 48);
        goto L3
    L6:
        int p5 = 0;
    L8:
        if (p5 >= rawdigits.length) goto L13;
        if (rawdigits[p5] != '0') goto L13;
        p5 = p5 + 1;
    L13:
        int shf = p5;
        int q = 0;
        if (this.sign != (-1)) goto L16;
        int q2 = 0 + 1;
        outputbuffer[0] = '-';
        q = q2;
    L16:
        int q3 = rawdigits.length;
        if (p5 == q3) goto L34;
        int q4 = q + 1;
        int p6 = p5 + 1;
        outputbuffer[q] = rawdigits[p5];
        int q5 = q4 + 1;
        outputbuffer[q4] = '.';
    L20:
        if (p6 >= rawdigits.length) goto L22;
        outputbuffer[q5] = rawdigits[p6];
        q5 = q5 + 1;
        p6 = p6 + 1;
        goto L20
    L22:
        int q6 = q5 + 1;
        outputbuffer[q5] = 'e';
        int e = ((this.exp * 4) - shf) - 1;
        int ae = e;
        if (e >= 0) goto L25;
        ae = -e;
    L25:
        int p7 = 1000000000;
    L26:
        if (p7 <= ae) goto L28;
        p7 = p7 / 10;
        goto L26
    L28:
        if (e >= 0) goto L30;
        outputbuffer[q6] = '-';
        q6 = q6 + 1;
    L30:
        if (p7 <= 0) goto L33;
        outputbuffer[q6] = (char) ((ae / p7) + 48);
        ae = ae % p7;
        p7 = p7 / 10;
        q6 = q6 + 1;
        goto L30
    L33:
        return new String(outputbuffer, 0, q6);
    L34:
        int ae2 = q + 1;
        outputbuffer[q] = '0';
        int q7 = ae2 + 1;
        outputbuffer[ae2] = '.';
        int q8 = q7 + 1;
        outputbuffer[q7] = '0';
        int q9 = q8 + 1;
        outputbuffer[q8] = 'e';
        int r6 = q9 + 1;
        outputbuffer[q9] = '0';
        return new String(outputbuffer, 0, 5);
    }

    protected String dfp2string() {
        char[] buffer = new char[(this.mant.length * 4) + 20];
        int p = 1;
        int e = this.exp;
        boolean pointInserted = false;
        buffer[0] = ' ';
        if (e > 0) goto L5;
        int p2 = 1 + 1;
        buffer[1] = '0';
        p = p2 + 1;
        buffer[p2] = '.';
        pointInserted = true;
    L5:
        if (e >= 0) goto L7;
        int p3 = p + 1;
        buffer[p] = '0';
        int p4 = p3 + 1;
        buffer[p3] = '0';
        int p5 = p4 + 1;
        buffer[p4] = '0';
        p = p5 + 1;
        buffer[p5] = '0';
        e = e + 1;
        goto L5
    L7:
        int i = this.mant.length - 1;
    L8:
        if (i < 0) goto L13;
        int p6 = p + 1;
        buffer[p] = (char) ((this.mant[i] / 1000) + 48);
        int p7 = p6 + 1;
        buffer[p6] = (char) (((this.mant[i] / 100) % 10) + 48);
        int p8 = p7 + 1;
        buffer[p7] = (char) (((this.mant[i] / 10) % 10) + 48);
        p = p8 + 1;
        buffer[p8] = (char) ((this.mant[i] % 10) + 48);
        e = e - 1;
        if (e != 0) goto L12;
        buffer[p] = '.';
        pointInserted = true;
        p = p + 1;
    L12:
        i = i - 1;
    L13:
        if (e <= 0) goto L15;
        int p9 = p + 1;
        buffer[p] = '0';
        int p10 = p9 + 1;
        buffer[p9] = '0';
        int p11 = p10 + 1;
        buffer[p10] = '0';
        p = p11 + 1;
        buffer[p11] = '0';
        e = e - 1;
        goto L13
    L15:
        if (pointInserted == true) goto L17;
        buffer[p] = '.';
        p = p + 1;
    L17:
        int q = 1;
    L19:
        if (buffer[q] != '0') goto L22;
        q = q + 1;
        goto L19
    L22:
        if (buffer[q] != '.') goto L25;
        q = q - 1;
    L25:
        if (buffer[p - 1] != '0') goto L28;
        p = p - 1;
        goto L25
    L28:
        if (this.sign >= 0) goto L31;
        q = q - 1;
        buffer[q] = '-';
    L31:
        return new String(buffer, q, p - q);
    }

    public Dfp dotrap(int type, String what, Dfp oper, Dfp result) {
        Dfp def = result;
        switch(type) {
            case 1: goto L33;
            case 2: goto L12;
            case 4: goto L10;
            case 8: goto L6;
            default: goto L4;
        };
    L4:
        Dfp def2 = result;
    L35:
        return trap(type, what, oper, def2, result);
    L10:
        result.exp -= 32760;
        Dfp def3 = newInstance(getZero());
        def3.sign = result.sign;
        def3.nans = 1;
        def2 = def3;
        goto L35
    L33:
        Dfp def4 = newInstance(getZero());
        def4.sign = result.sign;
        def4.nans = 3;
        def2 = def4;
        goto L35
    L6:
        if ((result.exp + this.mant.length) >= (-32767)) goto L8;
        Dfp def5 = newInstance(getZero());
        def5.sign = result.sign;
    L9:
        result.exp += ERR_SCALE;
        def2 = def5;
        goto L35
    L8:
        def5 = newInstance(result);
        goto L9
    L12:
        if (this.nans != 0) goto L17;
        if (this.mant[this.mant.length - 1] == 0) goto L17;
        def = newInstance(getZero());
        def.sign = (byte) (this.sign * oper.sign);
        def.nans = 1;
    L17:
        if (this.nans != 0) goto L22;
        if (this.mant[this.mant.length - 1] != 0) goto L22;
        def = newInstance(getZero());
        def.nans = 3;
    L22:
        if (this.nans != 1) goto L24;
    L25:
        def = newInstance(getZero());
        def.nans = 3;
    L27:
        if (this.nans != 1) goto L29;
    L32:
        Dfp def6 = newInstance(getZero());
        def6.nans = 3;
        def2 = def6;
        goto L35
    L29:
        if (this.nans == 2) goto L32;
        def2 = def;
        goto L35
    L24:
        if (this.nans != 3) goto L27;
        goto L25
    }

    protected Dfp trap(int type, String what, Dfp oper, Dfp def, Dfp result) {
        return def;
    }

    public int classify() {
        return this.nans;
    }

    public static Dfp copysign(Dfp x, Dfp y) {
        Dfp result = x.newInstance(x);
        result.sign = y.sign;
        return result;
    }

    public Dfp nextAfter(Dfp x) {
        if (this.field.getRadixDigits() == x.field.getRadixDigits()) goto L6;
        this.field.setIEEEFlagsBits(1);
        Dfp result = newInstance(getZero());
        result.nans = 3;
        return dotrap(1, NEXT_AFTER_TRAP, x, result);
    L6:
        boolean up = false;
        if (lessThan(x) == false) goto L10;
        up = true;
    L10:
        if (compare(this, x) != 0) goto L14;
        return newInstance(x);
    L14:
        if (lessThan(getZero()) == false) goto L16;
        up = !up;
    L16:
        if (up == false) goto L21;
        Dfp inc = newInstance(getOne());
        inc.exp = (this.exp - this.mant.length) + 1;
        inc.sign = this.sign;
        if (equals(getZero()) == false) goto L20;
        inc.exp = (-32767) - this.mant.length;
    L20:
        Dfp result2 = add2(inc);
    L30:
        if (result2.classify() != 1) goto L35;
        if (classify() == 1) goto L35;
        this.field.setIEEEFlagsBits(16);
        result2 = dotrap(16, NEXT_AFTER_TRAP, x, result2);
    L35:
        if (result2.equals(getZero()) == true) goto L37;
        return result2;
    L37:
        if (equals(getZero()) == true) goto L41;
        this.field.setIEEEFlagsBits(16);
        return dotrap(16, NEXT_AFTER_TRAP, x, result2);
    L41:
        return result2;
    L21:
        Dfp inc2 = newInstance(getOne());
        inc2.exp = this.exp;
        inc2.sign = this.sign;
        if (equals(inc2) == false) goto L24;
        inc2.exp = this.exp - this.mant.length;
    L26:
        if (equals(getZero()) == false) goto L28;
        inc2.exp = (-32767) - this.mant.length;
    L28:
        result2 = subtract2(inc2);
        goto L30
    L24:
        inc2.exp = (this.exp - this.mant.length) + 1;
        goto L26
    }

    public double toDouble() {
        if (isInfinite() == false) goto L9;
        if (lessThan(getZero()) == false) goto L7;
        return Double.NEGATIVE_INFINITY;
    L7:
        return Double.POSITIVE_INFINITY;
    L9:
        if (isNaN() == false) goto L12;
        return Double.NaN;
    L12:
        Dfp y = this;
        boolean negate = false;
        if (lessThan(getZero()) == false) goto L15;
        y = negate();
        negate = true;
    L15:
        int exponent = (int) (((double) y.log10()) * 3.32d);
        if (exponent >= 0) goto L18;
        exponent = exponent - 1;
    L18:
        Dfp tempDfp = DfpMath.pow(getTwo(), exponent);
    L20:
        if (tempDfp.lessThan(y) == true) goto L47;
        if (tempDfp.equals(y) == true) goto L47;
        int exponent2 = exponent - 1;
        Dfp y2 = y.divide2(DfpMath.pow(getTwo(), exponent2));
        if (exponent2 <= (-1023)) goto L28;
        y2 = y2.subtract2(getOne());
    L28:
        if (exponent2 >= (-1074)) goto L32;
        return 0.0d;
    L32:
        if (exponent2 <= 1023) goto L36;
        if (negate == true) goto L35;
        return Double.POSITIVE_INFINITY;
    L35:
        return Double.NEGATIVE_INFINITY;
    L36:
        String str = y2.multiply2(newInstance(4503599627370496L)).rint().toString();
        long mantissa = Long.parseLong(str.substring(0, str.length() - 1));
        if (mantissa != 4503599627370496L) goto L39;
        mantissa = 0;
        exponent2 = exponent2 + 1;
    L39:
        if (exponent2 > (-1023)) goto L41;
        exponent2 = exponent2 - 1;
    L41:
        if (exponent2 >= (-1023)) goto L43;
        exponent2 = exponent2 + 1;
        mantissa = mantissa >>> 1;
        goto L41
    L43:
        long bits = ((((long) exponent2) + 1023) << 52) | mantissa;
        double x = Double.longBitsToDouble(bits);
        if (negate == true) goto L46;
        return x;
    L46:
        return -x;
    L47:
        tempDfp = tempDfp.multiply(2);
        exponent = exponent + 1;
        goto L20
    }

    public double[] toSplitDouble() {
        double[] split = new double[2];
        split[0] = Double.longBitsToDouble(Double.doubleToLongBits(toDouble()) & (-1073741824));
        split[1] = subtract2(newInstance(split[0])).toDouble();
        return split;
    }
}
