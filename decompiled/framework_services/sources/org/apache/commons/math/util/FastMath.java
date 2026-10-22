package org.apache.commons.math.util;

import android.net.util.NetworkConstants;
import com.android.server.usb.descriptors.UsbTerminalTypes;

/* JADX INFO: loaded from: classes3.dex */
public class FastMath {
    private static final double[] CBRTTWO = null;
    private static final double[] COSINE_TABLE_A = null;
    private static final double[] COSINE_TABLE_B = null;
    public static final double E = 2.718281828459045d;
    private static final double[] EIGHTHS = null;
    private static final double[] EXP_FRAC_TABLE_A = null;
    private static final double[] EXP_FRAC_TABLE_B = null;
    private static final double[] EXP_INT_TABLE_A = null;
    private static final double[] EXP_INT_TABLE_B = null;
    private static final double[] FACT = null;
    private static final long HEX_40000000 = 1073741824;
    private static final double LN_2_A = 0.6931470632553101d;
    private static final double LN_2_B = 1.1730463525082348E-7d;
    private static final double[][] LN_HI_PREC_COEF = null;
    private static final double[][] LN_MANT = null;
    private static final double[][] LN_QUICK_COEF = null;
    private static final double[][] LN_SPLIT_COEF = null;
    private static final long MASK_30BITS = -1073741824;
    public static final double PI = 3.141592653589793d;
    private static final long[] PI_O_4_BITS = null;
    private static final long[] RECIP_2PI = null;
    private static final double[] SINE_TABLE_A = null;
    private static final double[] SINE_TABLE_B = null;
    private static final double[] TANGENT_TABLE_A = null;
    private static final double[] TANGENT_TABLE_B = null;
    private static final double TWO_POWER_52 = 4.503599627370496E15d;

    static {
        EXP_INT_TABLE_A = new double[NetworkConstants.ETHER_MTU];
        EXP_INT_TABLE_B = new double[NetworkConstants.ETHER_MTU];
        EXP_FRAC_TABLE_A = new double[UsbTerminalTypes.TERMINAL_BIDIR_HANDSET];
        EXP_FRAC_TABLE_B = new double[UsbTerminalTypes.TERMINAL_BIDIR_HANDSET];
        FACT = new double[20];
        LN_MANT = new double[1024][];
        LN_SPLIT_COEF = new double[][]{new double[]{2.0d, 0.0d}, new double[]{0.6666666269302368d, 3.9736429850260626E-8d}, new double[]{0.3999999761581421d, 2.3841857910019882E-8d}, new double[]{0.2857142686843872d, 1.7029898543501842E-8d}, new double[]{0.2222222089767456d, 1.3245471311735498E-8d}, new double[]{0.1818181574344635d, 2.4384203044354907E-8d}, new double[]{0.1538461446762085d, 9.140260083262505E-9d}, new double[]{0.13333332538604736d, 9.220590270857665E-9d}, new double[]{0.11764700710773468d, 1.2393345855018391E-8d}, new double[]{0.10526403784751892d, 8.251545029714408E-9d}, new double[]{0.0952233225107193d, 1.2675934823758863E-8d}, new double[]{0.08713622391223907d, 1.1430250008909141E-8d}, new double[]{0.07842259109020233d, 2.404307984052299E-9d}, new double[]{0.08371849358081818d, 1.176342548272881E-8d}, new double[]{0.030589580535888672d, 1.2958646899018938E-9d}, new double[]{0.14982303977012634d, 1.225743062930824E-8d}};
        LN_QUICK_COEF = new double[][]{new double[]{1.0d, 5.669184079525E-24d}, new double[]{-0.25d, -0.25d}, new double[]{0.3333333134651184d, 1.986821492305628E-8d}, new double[]{-0.25d, -6.663542893624021E-14d}, new double[]{0.19999998807907104d, 1.1921056801463227E-8d}, new double[]{-0.1666666567325592d, -7.800414592973399E-9d}, new double[]{0.1428571343421936d, 5.650007086920087E-9d}, new double[]{-0.12502530217170715d, -7.44321345601866E-11d}, new double[]{0.11113807559013367d, 9.219544613762692E-9d}};
        LN_HI_PREC_COEF = new double[][]{new double[]{1.0d, -6.032174644509064E-23d}, new double[]{-0.25d, -0.25d}, new double[]{0.3333333134651184d, 1.9868161777724352E-8d}, new double[]{-0.2499999701976776d, -2.957007209750105E-8d}, new double[]{0.19999954104423523d, 1.5830993332061267E-10d}, new double[]{-0.16624879837036133d, -2.6033824355191673E-8d}};
        SINE_TABLE_A = new double[14];
        SINE_TABLE_B = new double[14];
        COSINE_TABLE_A = new double[14];
        COSINE_TABLE_B = new double[14];
        TANGENT_TABLE_A = new double[14];
        TANGENT_TABLE_B = new double[14];
        RECIP_2PI = new long[]{2935890503282001226L, 9154082963658192752L, 3952090531849364496L, 9193070505571053912L, 7910884519577875640L, 113236205062349959L, 4577762542105553359L, -5034868814120038111L, 4208363204685324176L, 5648769086999809661L, 2819561105158720014L, -4035746434778044925L, -302932621132653753L, -2644281811660520851L, -3183605296591799669L, 6722166367014452318L, -3512299194304650054L, -7278142539171889152L};
        PI_O_4_BITS = new long[]{-3958705157555305932L, -4267615245585081135L};
        EIGHTHS = new double[]{0.0d, 0.125d, 0.25d, 0.375d, 0.5d, 0.625d, 0.75d, 0.875d, 1.0d, 1.125d, 1.25d, 1.375d, 1.5d, 1.625d};
        CBRTTWO = new double[]{0.6299605249474366d, 0.7937005259840998d, 1.0d, 1.2599210498948732d, 1.5874010519681994d};
        FACT[0] = 1.0d;
        int i = 1;
    L4:
        if (i >= FACT.length) goto L6;
        FACT[i] = FACT[i - 1] * ((double) i);
        i = i + 1;
        goto L4
    L6:
        double[] tmp = new double[2];
        double[] recip = new double[2];
        int i2 = 0;
    L8:
        if (i2 >= 750) goto L13;
        expint(i2, tmp);
        EXP_INT_TABLE_A[i2 + 750] = tmp[0];
        EXP_INT_TABLE_B[i2 + 750] = tmp[1];
        if (i2 == 0) goto L12;
        splitReciprocal(tmp, recip);
        EXP_INT_TABLE_A[750 - i2] = recip[0];
        EXP_INT_TABLE_B[750 - i2] = recip[1];
    L12:
        i2 = i2 + 1;
        goto L8
    L13:
        int i3 = 0;
    L15:
        if (i3 >= EXP_FRAC_TABLE_A.length) goto L17;
        slowexp(((double) i3) / 1024.0d, tmp);
        EXP_FRAC_TABLE_A[i3] = tmp[0];
        EXP_FRAC_TABLE_B[i3] = tmp[1];
        i3 = i3 + 1;
        goto L15
    L17:
        int i4 = 0;
    L19:
        if (i4 >= LN_MANT.length) goto L21;
        double d = Double.longBitsToDouble((((long) i4) << 42) | 4607182418800017408L);
        LN_MANT[i4] = slowLog(d);
        i4 = i4 + 1;
        goto L19
    L21:
        buildSinCosTables();
    }

    private FastMath() {
    }

    private static double doubleHighPart(double d) {
        if (d > (-2.2250738585072014E-308d)) goto L5;
    L7:
        long xl = Double.doubleToLongBits(d);
        return Double.longBitsToDouble(xl & MASK_30BITS);
    L5:
        if (d >= Double.MIN_NORMAL) goto L7;
        return d;
    }

    public static double sqrt(double a) {
        return Math.sqrt(a);
    }

    public static double cosh(double x) {
        double x2 = x;
        if (x2 == x2) goto L6;
        return x2;
    L6:
        if (x2 <= 20.0d) goto L10;
        return exp(x2) / 2.0d;
    L10:
        if (x2 < (-20.0d)) goto L12;
        double[] hiPrec = new double[2];
        if (x2 >= 0.0d) goto L16;
        x2 = -x2;
    L16:
        exp(x2, 0.0d, hiPrec);
        double ya = hiPrec[0] + hiPrec[1];
        double yb = -((ya - hiPrec[0]) - hiPrec[1]);
        double temp = ya * 1.073741824E9d;
        double yaa = (ya + temp) - temp;
        double yab = ya - yaa;
        double recip = 1.0d / ya;
        double temp2 = 1.073741824E9d * recip;
        double recipa = (recip + temp2) - temp2;
        double recipb = recip - recipa;
        double x3 = -yb;
        double recipb2 = (recipb + (((((1.0d - (yaa * recipa)) - (yaa * recipb)) - (yab * recipa)) - (yab * recipb)) * recip)) + ((x3 * recip) * recip);
        double temp3 = ya + recipa;
        double yb2 = yb + (-((temp3 - ya) - recipa));
        double temp4 = temp3 + recipb2;
        double result = temp4 + (yb2 + (-((temp4 - temp3) - recipb2)));
        return result * 0.5d;
    L12:
        return exp(-x2) / 2.0d;
    }

    public static double sinh(double x) {
        double x2 = x;
        boolean negate = false;
        if (x2 == x2) goto L6;
        return x2;
    L6:
        if (x2 <= 20.0d) goto L10;
        return exp(x2) / 2.0d;
    L10:
        if (x2 >= (-20.0d)) goto L14;
        return (-exp(-x2)) / 2.0d;
    L14:
        if (x2 != 0.0d) goto L17;
        return x2;
    L17:
        if (x2 >= 0.0d) goto L20;
        x2 = -x2;
        negate = true;
    L20:
        if (x2 <= 0.25d) goto L22;
        double[] hiPrec = new double[2];
        exp(x2, 0.0d, hiPrec);
        double ya = hiPrec[0] + hiPrec[1];
        double yb = -((ya - hiPrec[0]) - hiPrec[1]);
        double temp = ya * 1.073741824E9d;
        double yaa = (ya + temp) - temp;
        double yab = ya - yaa;
        double recip = 1.0d / ya;
        double temp2 = 1.073741824E9d * recip;
        double recipa = (recip + temp2) - temp2;
        double recipb = recip - recipa;
        double recipb2 = recipb + (((((1.0d - (yaa * recipa)) - (yaa * recipb)) - (yab * recipa)) - (yab * recipb)) * recip);
        double recipa2 = -recipa;
        double recipb3 = -((((-yb) * recip) * recip) + recipb2);
        double temp3 = ya + recipa2;
        double yb2 = yb + (-((temp3 - ya) - recipa2));
        double temp4 = temp3 + recipb3;
        double result = temp4 + (yb2 + (-((temp4 - temp3) - recipb3)));
        double result2 = result * 0.5d;
    L23:
        if (negate == true) goto L25;
        return result2;
    L25:
        return -result2;
    L22:
        double[] hiPrec2 = new double[2];
        expm1(x2, hiPrec2);
        double ya2 = hiPrec2[0] + hiPrec2[1];
        double yb3 = -((ya2 - hiPrec2[0]) - hiPrec2[1]);
        double denom = ya2 + 1.0d;
        double denomr = 1.0d / denom;
        double denomb = (-((denom - 1.0d) - ya2)) + yb3;
        double ratio = ya2 * denomr;
        double temp5 = ratio * 1.073741824E9d;
        double ra = (ratio + temp5) - temp5;
        double rb = ratio - ra;
        double temp6 = 1.073741824E9d * denom;
        double za = (denom + temp6) - temp6;
        double zb = denom - za;
        double x3 = -ya2;
        double rb2 = ((rb + (((((ya2 - (za * ra)) - (za * rb)) - (zb * ra)) - (zb * rb)) * denomr)) + (yb3 * denomr)) + (((x3 * denomb) * denomr) * denomr);
        double temp7 = ya2 + ra;
        double yb4 = yb3 + (-((temp7 - ya2) - ra));
        double temp8 = temp7 + rb2;
        double result3 = temp8 + (yb4 + (-((temp8 - temp7) - rb2)));
        result2 = result3 * 0.5d;
        goto L23
    }

    public static double tanh(double x) {
        double x2 = x;
        boolean negate = false;
        if (x2 == x2) goto L6;
        return x2;
    L6:
        if (x2 <= 20.0d) goto L9;
        return 1.0d;
    L9:
        if (x2 >= (-20.0d)) goto L12;
        return -1.0d;
    L12:
        if (x2 != 0.0d) goto L15;
        return x2;
    L15:
        if (x2 >= 0.0d) goto L18;
        x2 = -x2;
        negate = true;
    L18:
        if (x2 < 0.5d) goto L20;
        double[] hiPrec = new double[2];
        exp(x2 * 2.0d, 0.0d, hiPrec);
        double ya = hiPrec[0] + hiPrec[1];
        double yb = -((ya - hiPrec[0]) - hiPrec[1]);
        double na = (-1.0d) + ya;
        double nb = -((na + 1.0d) - ya);
        double temp = na + yb;
        double nb2 = nb + (-((temp - na) - yb));
        double da = ya + 1.0d;
        double x3 = (da - 1.0d) - ya;
        double db = -x3;
        double temp2 = da + yb;
        double db2 = (temp2 - da) - yb;
        double temp3 = temp2 * 1.073741824E9d;
        double daa = (temp2 + temp3) - temp3;
        double dab = temp2 - daa;
        double ratio = temp / temp2;
        double temp4 = ratio * 1.073741824E9d;
        double ratioa = (ratio + temp4) - temp4;
        double ratiob = ratio - ratioa;
        double result = ratioa + (((ratiob + (((((temp - (daa * ratioa)) - (daa * ratiob)) - (dab * ratioa)) - (dab * ratiob)) / temp2)) + (nb2 / temp2)) + ((((-(db + (-db2))) * temp) / temp2) / temp2));
        double db3 = result;
    L21:
        if (negate == false) goto L24;
        double result2 = -db3;
        return result2;
    L24:
        return db3;
    L20:
        double x4 = x2;
        double[] hiPrec2 = new double[2];
        expm1(x4 * 2.0d, hiPrec2);
        double ya2 = hiPrec2[0] + hiPrec2[1];
        double yb2 = -((ya2 - hiPrec2[0]) - hiPrec2[1]);
        double da2 = ya2 + 2.0d;
        double db4 = -((da2 - 2.0d) - ya2);
        double temp5 = da2 + yb2;
        double db5 = db4 + (-((temp5 - da2) - yb2));
        double da3 = temp5 * 1.073741824E9d;
        double daa2 = (temp5 + da3) - da3;
        double dab2 = temp5 - daa2;
        double ratio2 = ya2 / temp5;
        double temp6 = ratio2 * 1.073741824E9d;
        double ratioa2 = (ratio2 + temp6) - temp6;
        double ratiob2 = ratio2 - ratioa2;
        db3 = ratioa2 + (((ratiob2 + (((((ya2 - (daa2 * ratioa2)) - (daa2 * ratiob2)) - (dab2 * ratioa2)) - (dab2 * ratiob2)) / temp5)) + (yb2 / temp5)) + ((((-db5) * ya2) / temp5) / temp5));
        goto L21
    }

    public static double acosh(double a) {
        return log(sqrt((a * a) - 1.0d) + a);
    }

    public static double asinh(double a) {
        double a2 = a;
        boolean negative = false;
        if (a2 >= 0.0d) goto L6;
        negative = true;
        a2 = -a2;
    L6:
        if (a2 <= 0.167d) goto L8;
        double absAsinh = log(sqrt((a2 * a2) + 1.0d) + a2);
    L18:
        if (negative == false) goto L21;
        return -absAsinh;
    L21:
        return absAsinh;
    L8:
        double a3 = a2 * a2;
        if (a2 <= 0.097d) goto L12;
        absAsinh = a2 * (1.0d - (((0.3333333333333333d - ((((0.2d - ((((0.14285714285714285d - ((((0.1111111111111111d - ((((0.09090909090909091d - ((((0.07692307692307693d - ((((0.06666666666666667d - (((0.058823529411764705d * a3) * 15.0d) / 16.0d)) * a3) * 13.0d) / 14.0d)) * a3) * 11.0d) / 12.0d)) * a3) * 9.0d) / 10.0d)) * a3) * 7.0d) / 8.0d)) * a3) * 5.0d) / 6.0d)) * a3) * 3.0d) / 4.0d)) * a3) / 2.0d));
        goto L18
    L12:
        if (a2 <= 0.036d) goto L15;
        absAsinh = a2 * (1.0d - (((0.3333333333333333d - ((((0.2d - ((((0.14285714285714285d - ((((0.1111111111111111d - ((((0.09090909090909091d - (((0.07692307692307693d * a3) * 11.0d) / 12.0d)) * a3) * 9.0d) / 10.0d)) * a3) * 7.0d) / 8.0d)) * a3) * 5.0d) / 6.0d)) * a3) * 3.0d) / 4.0d)) * a3) / 2.0d));
        goto L18
    L15:
        if (a2 <= 0.0036d) goto L17;
        absAsinh = a2 * (1.0d - (((0.3333333333333333d - ((((0.2d - ((((0.14285714285714285d - (((0.1111111111111111d * a3) * 7.0d) / 8.0d)) * a3) * 5.0d) / 6.0d)) * a3) * 3.0d) / 4.0d)) * a3) / 2.0d));
        goto L18
    L17:
        absAsinh = a2 * (1.0d - (((0.3333333333333333d - (((0.2d * a3) * 3.0d) / 4.0d)) * a3) / 2.0d));
        goto L18
    }

    public static double atanh(double a) {
        double a2 = a;
        boolean negative = false;
        if (a2 >= 0.0d) goto L6;
        negative = true;
        a2 = -a2;
    L6:
        if (a2 <= 0.15d) goto L8;
        double absAtanh = log((a2 + 1.0d) / (1.0d - a2)) * 0.5d;
    L18:
        if (negative == false) goto L21;
        return -absAtanh;
    L21:
        return absAtanh;
    L8:
        double a3 = a2 * a2;
        if (a2 <= 0.087d) goto L12;
        absAtanh = a2 * ((((((((((((((((0.058823529411764705d * a3) + 0.06666666666666667d) * a3) + 0.07692307692307693d) * a3) + 0.09090909090909091d) * a3) + 0.1111111111111111d) * a3) + 0.14285714285714285d) * a3) + 0.2d) * a3) + 0.3333333333333333d) * a3) + 1.0d);
        goto L18
    L12:
        if (a2 <= 0.031d) goto L15;
        absAtanh = a2 * ((((((((((((0.07692307692307693d * a3) + 0.09090909090909091d) * a3) + 0.1111111111111111d) * a3) + 0.14285714285714285d) * a3) + 0.2d) * a3) + 0.3333333333333333d) * a3) + 1.0d);
        goto L18
    L15:
        if (a2 <= 0.003d) goto L17;
        absAtanh = a2 * ((((((((0.1111111111111111d * a3) + 0.14285714285714285d) * a3) + 0.2d) * a3) + 0.3333333333333333d) * a3) + 1.0d);
        goto L18
    L17:
        absAtanh = a2 * ((((0.2d * a3) + 0.3333333333333333d) * a3) + 1.0d);
        goto L18
    }

    public static double signum(double a) {
        if (a >= 0.0d) goto L6;
        return -1.0d;
    L6:
        if (a <= 0.0d) goto L9;
        return 1.0d;
    L9:
        return a;
    }

    public static float signum(float a) {
        if (a >= 0.0f) goto L6;
        return -1.0f;
    L6:
        if (a <= 0.0f) goto L9;
        return 1.0f;
    L9:
        return a;
    }

    public static double nextUp(double a) {
        return nextAfter(a, Double.POSITIVE_INFINITY);
    }

    public static float nextUp(float a) {
        return nextAfter(a, Double.POSITIVE_INFINITY);
    }

    public static double random() {
        return Math.random();
    }

    public static double exp(double x) {
        return exp(x, 0.0d, null);
    }

    private static double exp(double x, double extra, double[] hiPrec) {
        if (x >= 0.0d) goto L20;
        int intVal = (int) (-x);
        if (intVal <= 746) goto L9;
        if (hiPrec == null) goto L8;
        hiPrec[0] = 0.0d;
        hiPrec[1] = 0.0d;
    L8:
        return 0.0d;
    L9:
        if (intVal <= 709) goto L14;
        double result = exp(40.19140625d + x, extra, hiPrec) / 2.8504009514401178E17d;
        if (hiPrec == null) goto L13;
        hiPrec[0] = hiPrec[0] / 2.8504009514401178E17d;
        hiPrec[1] = hiPrec[1] / 2.8504009514401178E17d;
    L13:
        return result;
    L14:
        if (intVal != 709) goto L19;
        double result2 = exp(1.494140625d + x, extra, hiPrec) / 4.455505956692757d;
        if (hiPrec == null) goto L18;
        hiPrec[0] = hiPrec[0] / 4.455505956692757d;
        hiPrec[1] = hiPrec[1] / 4.455505956692757d;
    L18:
        return result2;
    L19:
        int intVal2 = intVal + 1;
        double intPartA = EXP_INT_TABLE_A[750 - intVal2];
        double intPartB = EXP_INT_TABLE_B[750 - intVal2];
        int intVal3 = -intVal2;
    L27:
        int intFrac = (int) ((x - ((double) intVal3)) * 1024.0d);
        double fracPartA = EXP_FRAC_TABLE_A[intFrac];
        double fracPartB = EXP_FRAC_TABLE_B[intFrac];
        double epsilon = x - (((double) intVal3) + (((double) intFrac) / 1024.0d));
        double z = (((((((0.04168701738764507d * epsilon) + 0.1666666505023083d) * epsilon) + 0.5000000000042687d) * epsilon) + 1.0d) * epsilon) - 3.940510424527919E-20d;
        double z2 = intPartA * fracPartA;
        double tempB = ((intPartA * fracPartB) + (intPartB * fracPartA)) + (intPartB * fracPartB);
        double tempC = tempB + z2;
        if (extra == 0.0d) goto L30;
        double result3 = (((((tempC * extra) * z) + (tempC * extra)) + (tempC * z)) + tempB) + z2;
    L31:
        if (hiPrec == null) goto L33;
        hiPrec[0] = z2;
        hiPrec[1] = ((((tempC * extra) * z) + (tempC * extra)) + (tempC * z)) + tempB;
    L33:
        return result3;
    L30:
        double result4 = tempC * z;
        result3 = (result4 + tempB) + z2;
        goto L31
    L20:
        intVal3 = (int) x;
        if (intVal3 > 709) goto L23;
        intPartA = EXP_INT_TABLE_A[intVal3 + 750];
        intPartB = EXP_INT_TABLE_B[intVal3 + 750];
        goto L27
    L23:
        if (hiPrec == null) goto L25;
        hiPrec[0] = Double.POSITIVE_INFINITY;
        hiPrec[1] = 0.0d;
    L25:
        return Double.POSITIVE_INFINITY;
    }

    public static double expm1(double x) {
        return expm1(x, null);
    }

    private static double expm1(double x, double[] hiPrecOut) {
        double x2 = x;
        if (x2 == x2) goto L5;
    L30:
        return x2;
    L5:
        if (x2 == 0.0d) goto L30;
        if (x2 > (-1.0d)) goto L10;
        char r21 = 0;
        char r24 = 1;
    L24:
        double[] hiPrec = new double[2];
        exp(x2, 0.0d, hiPrec);
        if (x2 > 0.0d) goto L27;
        double ra = hiPrec[r21] - 1.0d;
        return ra + ((-((ra + 1.0d) - hiPrec[r21])) + hiPrec[r24]);
    L27:
        return (hiPrec[r21] - 1.0d) + hiPrec[r24];
    L10:
        if (x2 < 1.0d) goto L12;
        r21 = 0;
        r24 = 1;
        goto L24
    L12:
        boolean negative = false;
        if (x2 >= 0.0d) goto L15;
        x2 = -x2;
        negative = true;
    L15:
        int intFrac = (int) (x2 * 1024.0d);
        double tempA = EXP_FRAC_TABLE_A[intFrac] - 1.0d;
        double tempB = EXP_FRAC_TABLE_B[intFrac];
        double temp = tempA + tempB;
        double tempB2 = -((temp - tempA) - tempB);
        double temp2 = temp * 1.073741824E9d;
        double baseA = (temp + temp2) - temp2;
        double baseB = tempB2 + (temp - baseA);
        double tempB3 = x2 - (((double) intFrac) / 1024.0d);
        double zb = (((((((0.008336750013465571d * tempB3) + 0.041666663879186654d) * tempB3) + 0.16666666666745392d) * tempB3) + 0.49999999999999994d) * tempB3) * tempB3;
        double temp3 = tempB3 + zb;
        double zb2 = -((temp3 - tempB3) - zb);
        double temp4 = temp3 * 1.073741824E9d;
        double temp5 = (temp3 + temp4) - temp4;
        double zb3 = zb2 + (temp3 - temp5);
        double ya = temp5 * baseA;
        double temp6 = ya + (temp5 * baseB);
        double yb = -((temp6 - ya) - (temp5 * baseB));
        double temp7 = (zb3 * baseA) + temp6;
        double temp8 = (zb3 * baseB) + temp7;
        double x3 = (temp8 - temp7) - (zb3 * baseB);
        double ya2 = temp8 + baseA;
        double yb2 = ((yb + (-((temp7 - temp6) - (zb3 * baseA)))) + (-x3)) + (-((ya2 - baseA) - temp8));
        double temp9 = ya2 + temp5;
        double yb3 = yb2 + (-((temp9 - ya2) - temp5));
        double temp10 = temp9 + baseB;
        double yb4 = yb3 + (-((temp10 - temp9) - baseB));
        double temp11 = temp10 + zb3;
        double yb5 = yb4 + (-((temp11 - temp10) - zb3));
        double ya3 = temp11;
        if (negative == false) goto L19;
        double denom = ya3 + 1.0d;
        double denomr = 1.0d / denom;
        double epsilon = (denom - 1.0d) - ya3;
        double denomb = (-epsilon) + yb5;
        double ratio = ya3 * denomr;
        double temp12 = ratio * 1.073741824E9d;
        double denomb2 = (ratio + temp12) - temp12;
        double rb = ratio - denomb2;
        double temp13 = denom * 1.073741824E9d;
        double za = (denom + temp13) - temp13;
        double zb4 = denom - za;
        double rb2 = ((rb + (((((ya3 - (za * denomb2)) - (za * rb)) - (zb4 * denomb2)) - (zb4 * rb)) * denomr)) + (yb5 * denomr)) + ((((-ya3) * denomb) * denomr) * denomr);
        ya3 = -denomb2;
        yb5 = -rb2;
    L19:
        if (hiPrecOut == null) goto L22;
        hiPrecOut[0] = ya3;
        hiPrecOut[1] = yb5;
    L22:
        return ya3 + yb5;
    }

    private static double slowexp(double x, double[] result) {
        double[] xs = new double[2];
        double[] facts = new double[2];
        double[] as = new double[2];
        split(x, xs);
        double[] ys = {0.0d, 0.0d};
        int i = 19;
    L3:
        if (i < 0) goto L6;
        splitMult(xs, ys, as);
        ys[0] = as[0];
        ys[1] = as[1];
        split(FACT[i], as);
        splitReciprocal(as, facts);
        splitAdd(ys, facts, as);
        ys[0] = as[0];
        ys[1] = as[1];
        i = i - 1;
        goto L3
    L6:
        if (result == null) goto L9;
        result[0] = ys[0];
        result[1] = ys[1];
    L9:
        return ys[0] + ys[1];
    }

    private static void split(double d, double[] split) {
        if (d < 8.0E298d) goto L5;
    L7:
        split[0] = ((d + (9.313225746154785E-10d * d)) - d) * 1.073741824E9d;
        split[1] = d - split[0];
        return;
    L5:
        if (d <= (-8.0E298d)) goto L7;
        double a = 1.073741824E9d * d;
        split[0] = (d + a) - a;
        split[1] = d - split[0];
    }

    private static void resplit(double[] a) {
        double c = a[0] + a[1];
        double d = -((c - a[0]) - a[1]);
        if (c < 8.0E298d) goto L5;
    L7:
        a[0] = ((c + (9.313225746154785E-10d * c)) - c) * 1.073741824E9d;
        a[1] = (c - a[0]) + d;
        return;
    L5:
        if (c <= (-8.0E298d)) goto L7;
        double z = 1.073741824E9d * c;
        a[0] = (c + z) - z;
        a[1] = (c - a[0]) + d;
    }

    private static void splitMult(double[] a, double[] b, double[] ans) {
        ans[0] = a[0] * b[0];
        ans[1] = ((a[0] * b[1]) + (a[1] * b[0])) + (a[1] * b[1]);
        resplit(ans);
    }

    private static void splitAdd(double[] a, double[] b, double[] ans) {
        ans[0] = a[0] + b[0];
        ans[1] = a[1] + b[1];
        resplit(ans);
    }

    private static void splitReciprocal(double[] in, double[] result) {
        if (in[0] != 0.0d) goto L5;
        in[0] = in[1];
        in[1] = 0.0d;
    L5:
        result[0] = 0.9999997615814209d / in[0];
        result[1] = ((in[0] * 2.384185791015625E-7d) - (in[1] * 0.9999997615814209d)) / ((in[0] * in[0]) + (in[0] * in[1]));
        if (result[1] == result[1]) goto L8;
        result[1] = 0.0d;
    L8:
        resplit(result);
        int i = 0;
    L10:
        if (i >= 2) goto L13;
        double err = (((1.0d - (result[0] * in[0])) - (result[0] * in[1])) - (result[1] * in[0])) - (result[1] * in[1]);
        double err2 = err * (result[0] + result[1]);
        result[1] = result[1] + err2;
        i = i + 1;
        goto L10
    }

    private static void quadMult(double[] a, double[] b, double[] result) {
        double[] xs = new double[2];
        double[] ys = new double[2];
        double[] zs = new double[2];
        split(a[0], xs);
        split(b[0], ys);
        splitMult(xs, ys, zs);
        result[0] = zs[0];
        result[1] = zs[1];
        split(b[1], ys);
        splitMult(xs, ys, zs);
        double tmp = result[0] + zs[0];
        result[1] = result[1] - ((tmp - result[0]) - zs[0]);
        result[0] = tmp;
        double tmp2 = result[0] + zs[1];
        result[1] = result[1] - ((tmp2 - result[0]) - zs[1]);
        result[0] = tmp2;
        split(a[1], xs);
        split(b[0], ys);
        splitMult(xs, ys, zs);
        double tmp3 = result[0] + zs[0];
        result[1] = result[1] - ((tmp3 - result[0]) - zs[0]);
        result[0] = tmp3;
        double tmp4 = result[0] + zs[1];
        result[1] = result[1] - ((tmp4 - result[0]) - zs[1]);
        result[0] = tmp4;
        split(a[1], xs);
        split(b[1], ys);
        splitMult(xs, ys, zs);
        double tmp5 = result[0] + zs[0];
        result[1] = result[1] - ((tmp5 - result[0]) - zs[0]);
        result[0] = tmp5;
        double tmp6 = result[0] + zs[1];
        result[1] = result[1] - ((tmp6 - result[0]) - zs[1]);
        result[0] = tmp6;
    }

    private static double expint(int p, double[] result) {
        double[] as = new double[2];
        double[] ys = new double[2];
        double[] xs = {2.718281828459045d, 1.4456468917292502E-16d};
        split(1.0d, ys);
    L3:
        if (p <= 0) goto L8;
        if ((p & 1) == 0) goto L7;
        quadMult(ys, xs, as);
        ys[0] = as[0];
        ys[1] = as[1];
    L7:
        quadMult(xs, xs, as);
        xs[0] = as[0];
        xs[1] = as[1];
        p = p >> 1;
        goto L3
    L8:
        if (result == null) goto L11;
        result[0] = ys[0];
        result[1] = ys[1];
        resplit(result);
    L11:
        return ys[0] + ys[1];
    }

    public static double log(double x) {
        return log(x, null);
    }

    private static double log(double x, double[] hiPrec) {
        if (x != 0.0d) goto L5;
        return Double.NEGATIVE_INFINITY;
    L5:
        long bits = Double.doubleToLongBits(x);
        if ((Long.MIN_VALUE & bits) != 0) goto L10;
        if (x != x) goto L10;
    L16:
        if (x != Double.POSITIVE_INFINITY) goto L20;
        if (hiPrec == null) goto L19;
        hiPrec[0] = Double.POSITIVE_INFINITY;
    L19:
        return Double.POSITIVE_INFINITY;
    L20:
        int exp = ((int) (bits >> 52)) - 1023;
        if ((9218868437227405312L & bits) != 0) goto L32;
        if (x != 0.0d) goto L27;
        if (hiPrec == null) goto L26;
        hiPrec[0] = Double.NEGATIVE_INFINITY;
    L26:
        return Double.NEGATIVE_INFINITY;
    L27:
        bits = bits << 1;
    L29:
        if ((4503599627370496L & bits) != 0) goto L32;
        exp = exp - 1;
        bits = bits << 1;
    L32:
        if (exp == (-1)) goto L37;
        if (exp == 0) goto L37;
    L47:
        double[] lnm = LN_MANT[(int) ((bits & 4499201580859392L) >> 42)];
        double epsilon = (bits & 4398046511103L) / ((bits & 4499201580859392L) + TWO_POWER_52);
        double lnzb = 0.0d;
        if (hiPrec == null) goto L53;
        double tmp = epsilon * 1.073741824E9d;
        double aa = (epsilon + tmp) - tmp;
        double ab = epsilon - aa;
        double numer = 4398046511103L & bits;
        double denom = (4499201580859392L & bits) + TWO_POWER_52;
        double xb = ab + (((numer - (aa * denom)) - (ab * denom)) / denom);
        char r23 = 1;
        double yb = LN_HI_PREC_COEF[LN_HI_PREC_COEF.length - 1][r7];
        double ab2 = LN_HI_PREC_COEF[LN_HI_PREC_COEF.length - 1][1];
        int i = LN_HI_PREC_COEF.length - 2;
    L50:
        if (i < 0) goto L52;
        double aa2 = yb * aa;
        double tmp2 = aa2 * 1.073741824E9d;
        double ya = (aa2 + tmp2) - tmp2;
        double yb2 = (aa2 - ya) + (((yb * xb) + (ab2 * aa)) + (ab2 * xb));
        double aa3 = ya + LN_HI_PREC_COEF[i][0];
        double tmp3 = aa3 * 1.073741824E9d;
        double ya2 = (aa3 + tmp3) - tmp3;
        double yb3 = (aa3 - ya2) + (yb2 + LN_HI_PREC_COEF[i][1]);
        i = i - 1;
        yb = ya2;
        ab2 = yb3;
        goto L50
    L52:
        double aa4 = yb * aa;
        double ab3 = ((yb * xb) + (ab2 * aa)) + (ab2 * xb);
        double lnza = aa4 + ab3;
        double lnzb2 = -((lnza - aa4) - ab3);
        lnzb = lnzb2;
    L54:
        double a = ((double) exp) * LN_2_A;
        double c = lnm[r7] + a;
        double d = -((c - a) - lnm[r7]);
        double b = 0.0d + d;
        double c2 = c + lnza;
        double b2 = (c2 - c) - lnza;
        double d2 = -b2;
        double b3 = b + d2;
        double d3 = exp;
        double c3 = (d3 * LN_2_B) + c2;
        double d4 = -((c3 - c2) - (((double) exp) * LN_2_B));
        double b4 = b3 + d4;
        double c4 = lnm[r23] + c3;
        double d5 = (c4 - c3) - lnm[r23];
        double b5 = b4 + (-d5);
        double c5 = c4 + lnzb;
        double d6 = (c5 - c4) - lnzb;
        double b6 = b5 + (-d6);
        if (hiPrec == null) goto L58;
        hiPrec[r7] = c5;
        hiPrec[r23] = b6;
    L58:
        return c5 + b6;
    L53:
        r23 = 1;
        double lnza2 = (-0.16624882440418567d) * epsilon;
        lnza = (((((((((lnza2 + 0.19999954120254515d) * epsilon) - 0.2499999997677497d) * epsilon) + 0.3333333333332802d) * epsilon) - 0.5d) * epsilon) + 1.0d) * epsilon;
    L37:
        if (x >= 1.01d) goto L47;
        if (x <= 0.99d) goto L47;
        if (hiPrec != null) goto L47;
        double xa = x - 1.0d;
        double r12 = (xa - x) + 1.0d;
        double tmp4 = xa * 1.073741824E9d;
        double aa5 = (xa + tmp4) - tmp4;
        double ab4 = xa - aa5;
        double yb4 = LN_QUICK_COEF[LN_QUICK_COEF.length - 1][0];
        double ab5 = LN_QUICK_COEF[LN_QUICK_COEF.length - 1][1];
        int i2 = LN_QUICK_COEF.length - 2;
    L42:
        if (i2 < 0) goto L44;
        double aa6 = yb4 * aa5;
        double ab6 = ((yb4 * ab4) + (ab5 * aa5)) + (ab5 * ab4);
        double tmp5 = aa6 * 1.073741824E9d;
        double ya3 = (aa6 + tmp5) - tmp5;
        double yb5 = (aa6 - ya3) + ab6;
        double aa7 = ya3 + LN_QUICK_COEF[i2][0];
        double tmp6 = aa7 * 1.073741824E9d;
        double ya4 = (aa7 + tmp6) - tmp6;
        double yb6 = (aa7 - ya4) + (yb5 + LN_QUICK_COEF[i2][1]);
        i2 = i2 - 1;
        yb4 = ya4;
        ab5 = yb6;
        goto L42
    L44:
        double aa8 = yb4 * aa5;
        double tmp7 = 1.073741824E9d * aa8;
        double ya5 = (aa8 + tmp7) - tmp7;
        return ya5 + ((aa8 - ya5) + (((yb4 * ab4) + (ab5 * aa5)) + (ab5 * ab4)));
    L10:
        if (x == 0.0d) goto L16;
        if (hiPrec == null) goto L14;
        hiPrec[0] = Double.NaN;
    L14:
        return Double.NaN;
    }

    public static double log1p(double x) {
        double xpa = x + 1.0d;
        double xpb = -((xpa - 1.0d) - x);
        if (x != (-1.0d)) goto L7;
        return x / 0.0d;
    L7:
        if (x <= 0.0d) goto L12;
        if ((1.0d / x) != 0.0d) goto L12;
        return x;
    L12:
        if (x <= 1.0E-6d) goto L14;
    L18:
        double[] hiPrec = new double[2];
        double lores = log(xpa, hiPrec);
        if (Double.isInfinite(lores) == false) goto L21;
        return lores;
    L21:
        double fx1 = xpb / xpa;
        double epsilon = (0.5d * fx1) + 1.0d;
        double r0 = hiPrec[1];
        return (r0 + (epsilon * fx1)) + hiPrec[0];
    L14:
        if (x < (-1.0E-6d)) goto L18;
        double y = (0.333333333333333d * x) - 0.5d;
        double y2 = (y * x) + 1.0d;
        return y2 * x;
    }

    public static double log10(double x) {
        double[] hiPrec = new double[2];
        double lores = log(x, hiPrec);
        if (Double.isInfinite(lores) == false) goto L5;
        return lores;
    L5:
        double tmp = hiPrec[0] * 1.073741824E9d;
        double lna = (hiPrec[0] + tmp) - tmp;
        double lnb = (hiPrec[0] - lna) + hiPrec[1];
        return (((lnb * 1.9699272335463627E-8d) + (1.9699272335463627E-8d * lna)) + (lnb * 0.4342944622039795d)) + (0.4342944622039795d * lna);
    }

    public static double pow(double x, double y) {
        double[] lns = new double[2];
        if (y != 0.0d) goto L6;
        return 1.0d;
    L6:
        if (x == x) goto L9;
        return x;
    L9:
        if (x != 0.0d) goto L43;
        long bits = Double.doubleToLongBits(x);
        if ((bits & Long.MIN_VALUE) == 0) goto L34;
        long yi = (long) y;
        if (y >= 0.0d) goto L19;
        double r22 = 0.0d;
        if (y != yi) goto L21;
        if ((yi & 1) != 1) goto L21;
        return Double.NEGATIVE_INFINITY;
    L21:
        if (y >= r22) goto L28;
        if (y != yi) goto L28;
        if ((yi & 1) != 1) goto L28;
        return -0.0d;
    L28:
        if (y <= r22) goto L36;
        if (y != yi) goto L36;
        if ((yi & 1) != 1) goto L36;
        return -0.0d;
    L36:
        if (y >= r22) goto L39;
        return Double.POSITIVE_INFINITY;
    L39:
        if (y <= r22) goto L41;
        return r22;
    L41:
        return Double.NaN;
    L19:
        r22 = 0.0d;
        goto L21
    L34:
        r22 = 0.0d;
        goto L36
    L43:
        if (x != Double.POSITIVE_INFINITY) goto L52;
        if (y == y) goto L48;
        return y;
    L48:
        if (y >= 0.0d) goto L50;
        return 0.0d;
    L50:
        return Double.POSITIVE_INFINITY;
    L52:
        if (y != Double.POSITIVE_INFINITY) goto L61;
        if ((x * x) != 1.0d) goto L57;
        return Double.NaN;
    L57:
        if ((x * x) <= 1.0d) goto L59;
        return Double.POSITIVE_INFINITY;
    L59:
        return 0.0d;
    L61:
        if (x != Double.NEGATIVE_INFINITY) goto L82;
        if (y == y) goto L66;
        return y;
    L66:
        if (y >= 0.0d) goto L74;
        long yi2 = (long) y;
        if (y == yi2) goto L70;
    L72:
        return 0.0d;
    L70:
        if ((yi2 & 1) != 1) goto L72;
        return -0.0d;
    L74:
        if (y <= 0.0d) goto L82;
        long yi3 = (long) y;
        if (y == yi3) goto L78;
    L80:
        return Double.POSITIVE_INFINITY;
    L78:
        if ((yi3 & 1) != 1) goto L80;
        return Double.NEGATIVE_INFINITY;
    L82:
        if (y != Double.NEGATIVE_INFINITY) goto L91;
        if ((x * x) != 1.0d) goto L87;
        return Double.NaN;
    L87:
        if ((x * x) >= 1.0d) goto L89;
        return Double.POSITIVE_INFINITY;
    L89:
        return 0.0d;
    L91:
        if (x >= 0.0d) goto L108;
        if (y >= TWO_POWER_52) goto L106;
        if (y <= (-4.503599627370496E15d)) goto L106;
        if (y == ((long) y)) goto L100;
        return Double.NaN;
    L100:
        if ((((long) y) & 1) != 0) goto L103;
        return pow(-x, y);
    L103:
        return -pow(-x, y);
    L106:
        return pow(-x, y);
    L108:
        if (y < 8.0E298d) goto L110;
    L112:
        double tmp1 = y * 9.313225746154785E-10d;
        double ya = (((tmp1 + (9.313225746154785E-10d * tmp1)) - tmp1) * 1.073741824E9d) * 1.073741824E9d;
        double ya2 = ya;
        double tmp2 = y - ya;
    L113:
        double lores = log(x, lns);
        if (Double.isInfinite(lores) == false) goto L116;
        return lores;
    L116:
        double lna = lns[0];
        double tmp3 = 1.073741824E9d * lna;
        double tmp4 = (lna + tmp3) - tmp3;
        double lnb = lns[1] + (lna - tmp4);
        double aa = tmp4 * ya2;
        double ab = ((tmp4 * tmp2) + (lnb * ya2)) + (lnb * tmp2);
        double lna2 = aa + ab;
        double lnb2 = -((lna2 - aa) - ab);
        double z = (0.008333333333333333d * lnb2) + 0.041666666666666664d;
        double result = exp(lna2, ((((((z * lnb2) + 0.16666666666666666d) * lnb2) + 0.5d) * lnb2) + 1.0d) * lnb2, null);
        return result;
    L110:
        if (y <= (-8.0E298d)) goto L112;
        double tmp5 = y * 1.073741824E9d;
        ya2 = (y + tmp5) - tmp5;
        tmp2 = y - ya2;
        goto L113
    }

    private static double[] slowLog(double xi) {
        double[] x = new double[2];
        double[] x2 = new double[2];
        double[] a = new double[2];
        split(xi, x);
        x[0] = x[0] + 1.0d;
        resplit(x);
        splitReciprocal(x, a);
        x[0] = x[0] - 2.0d;
        resplit(x);
        double[] y = {LN_SPLIT_COEF[LN_SPLIT_COEF.length - 1][0], LN_SPLIT_COEF[LN_SPLIT_COEF.length - 1][1]};
        splitMult(x, a, y);
        x[0] = y[0];
        x[1] = y[1];
        splitMult(x, x, x2);
        int i = LN_SPLIT_COEF.length - 2;
    L3:
        if (i < 0) goto L5;
        splitMult(y, x2, a);
        y[0] = a[0];
        y[1] = a[1];
        splitAdd(y, LN_SPLIT_COEF[i], a);
        y[0] = a[0];
        y[1] = a[1];
        i = i - 1;
        goto L3
    L5:
        splitMult(y, x, a);
        y[0] = a[0];
        y[1] = a[1];
        return y;
    }

    private static double slowSin(double x, double[] result) {
        double[] xs = new double[2];
        double[] facts = new double[2];
        double[] as = new double[2];
        split(x, xs);
        double[] ys = {0.0d, 0.0d};
        int i = 19;
    L3:
        if (i < 0) goto L13;
        splitMult(xs, ys, as);
        ys[0] = as[0];
        ys[1] = as[1];
        if ((i & 1) == 0) goto L11;
        split(FACT[i], as);
        splitReciprocal(as, facts);
        if ((i & 2) == 0) goto L10;
        facts[0] = -facts[0];
        facts[1] = -facts[1];
    L10:
        splitAdd(ys, facts, as);
        ys[0] = as[0];
        ys[1] = as[1];
    L11:
        i = i - 1;
        goto L3
    L13:
        if (result == null) goto L16;
        result[0] = ys[0];
        result[1] = ys[1];
    L16:
        return ys[0] + ys[1];
    }

    private static double slowCos(double x, double[] result) {
        double[] xs = new double[2];
        double[] facts = new double[2];
        double[] as = new double[2];
        split(x, xs);
        double[] ys = {0.0d, 0.0d};
        int i = 19;
    L3:
        if (i < 0) goto L13;
        splitMult(xs, ys, as);
        ys[0] = as[0];
        ys[1] = as[1];
        if ((i & 1) != 0) goto L11;
        split(FACT[i], as);
        splitReciprocal(as, facts);
        if ((i & 2) == 0) goto L10;
        facts[0] = -facts[0];
        facts[1] = -facts[1];
    L10:
        splitAdd(ys, facts, as);
        ys[0] = as[0];
        ys[1] = as[1];
    L11:
        i = i - 1;
        goto L3
    L13:
        if (result == null) goto L16;
        result[0] = ys[0];
        result[1] = ys[1];
    L16:
        return ys[0] + ys[1];
    }

    private static void buildSinCosTables() {
        double[] result = new double[2];
        int i = 0;
    L4:
        if (i >= 7) goto L6;
        double x = ((double) i) / 8.0d;
        slowSin(x, result);
        SINE_TABLE_A[i] = result[0];
        SINE_TABLE_B[i] = result[1];
        slowCos(x, result);
        COSINE_TABLE_A[i] = result[0];
        COSINE_TABLE_B[i] = result[1];
        i = i + 1;
        goto L4
    L6:
        int i2 = 7;
    L8:
        if (i2 >= 14) goto L14;
        double[] xs = new double[2];
        double[] ys = new double[2];
        double[] as = new double[2];
        double[] bs = new double[2];
        double[] temps = new double[2];
        if ((i2 & 1) != 0) goto L12;
        xs[0] = SINE_TABLE_A[i2 / 2];
        xs[1] = SINE_TABLE_B[i2 / 2];
        ys[0] = COSINE_TABLE_A[i2 / 2];
        ys[1] = COSINE_TABLE_B[i2 / 2];
        splitMult(xs, ys, result);
        SINE_TABLE_A[i2] = result[0] * 2.0d;
        SINE_TABLE_B[i2] = result[1] * 2.0d;
        splitMult(ys, ys, as);
        splitMult(xs, xs, temps);
        temps[0] = -temps[0];
        temps[1] = -temps[1];
        splitAdd(as, temps, result);
        COSINE_TABLE_A[i2] = result[0];
        COSINE_TABLE_B[i2] = result[1];
    L13:
        i2 = i2 + 1;
        goto L8
    L12:
        xs[0] = SINE_TABLE_A[i2 / 2];
        xs[1] = SINE_TABLE_B[i2 / 2];
        ys[0] = COSINE_TABLE_A[i2 / 2];
        ys[1] = COSINE_TABLE_B[i2 / 2];
        as[0] = SINE_TABLE_A[(i2 / 2) + 1];
        as[1] = SINE_TABLE_B[(i2 / 2) + 1];
        bs[0] = COSINE_TABLE_A[(i2 / 2) + 1];
        bs[1] = COSINE_TABLE_B[(i2 / 2) + 1];
        splitMult(xs, bs, temps);
        splitMult(ys, as, result);
        splitAdd(result, temps, result);
        SINE_TABLE_A[i2] = result[0];
        SINE_TABLE_B[i2] = result[1];
        splitMult(ys, bs, result);
        splitMult(xs, as, temps);
        temps[0] = -temps[0];
        temps[1] = -temps[1];
        splitAdd(result, temps, result);
        COSINE_TABLE_A[i2] = result[0];
        COSINE_TABLE_B[i2] = result[1];
        goto L13
    L14:
        int i3 = 0;
    L15:
        if (i3 >= 14) goto L18;
        double[] ys2 = new double[2];
        double[] as2 = {COSINE_TABLE_A[i3], COSINE_TABLE_B[i3]};
        splitReciprocal(as2, ys2);
        splitMult(new double[]{SINE_TABLE_A[i3], SINE_TABLE_B[i3]}, ys2, as2);
        TANGENT_TABLE_A[i3] = as2[0];
        TANGENT_TABLE_B[i3] = as2[1];
        i3 = i3 + 1;
        goto L15
    }

    private static double polySine(double x) {
        double x2 = x * x;
        double p = (2.7553817452272217E-6d * x2) - 1.9841269659586505E-4d;
        return (((((p * x2) + 0.008333333333329196d) * x2) - 0.16666666666666666d) * x2) * x;
    }

    private static double polyCosine(double x) {
        double x2 = x * x;
        double p = (2.479773539153719E-5d * x2) - 0.0013888888689039883d;
        return ((((p * x2) + 0.041666666666621166d) * x2) - 0.49999999999999994d) * x2;
    }

    private static double sinQ(double xa, double xb) {
        int idx = (int) ((8.0d * xa) + 0.5d);
        double epsilon = xa - EIGHTHS[idx];
        double sintA = SINE_TABLE_A[idx];
        double sintB = SINE_TABLE_B[idx];
        double costA = COSINE_TABLE_A[idx];
        double costB = COSINE_TABLE_B[idx];
        double sinEpsB = polySine(epsilon);
        double cosEpsB = polyCosine(epsilon);
        double temp = 1.073741824E9d * epsilon;
        double temp2 = (epsilon + temp) - temp;
        double sinEpsB2 = sinEpsB + (epsilon - temp2);
        double c = 0.0d + sintA;
        double d = -((c - 0.0d) - sintA);
        double b = 0.0d + d;
        double t = costA * temp2;
        double c2 = c + t;
        double d2 = (c2 - c) - t;
        double a = c2;
        double b2 = ((b + (-d2)) + (sintA * cosEpsB)) + (costA * sinEpsB2);
        double b3 = (((b2 + sintB) + (costB * temp2)) + (sintB * cosEpsB)) + (costB * sinEpsB2);
        if (xb == 0.0d) goto L6;
        double t2 = (((costA + costB) * (cosEpsB + 1.0d)) - ((sintA + sintB) * (temp2 + sinEpsB2))) * xb;
        double c3 = a + t2;
        double d3 = (c3 - a) - t2;
        a = c3;
        b3 = b3 + (-d3);
    L6:
        double result = a + b3;
        return result;
    }

    private static double cosQ(double xa, double xb) {
        double a = 1.5707963267948966d - xa;
        double b = -((a - 1.5707963267948966d) + xa);
        return sinQ(a, b + (6.123233995736766E-17d - xb));
    }

    private static double tanQ(double xa, double xb, boolean cotanFlag) {
        int idx = (int) ((8.0d * xa) + 0.5d);
        double epsilon = xa - EIGHTHS[idx];
        double sintA = SINE_TABLE_A[idx];
        double sintB = SINE_TABLE_B[idx];
        double costA = COSINE_TABLE_A[idx];
        double costB = COSINE_TABLE_B[idx];
        double sinEpsB = polySine(epsilon);
        double cosEpsB = polyCosine(epsilon);
        double temp = epsilon * 1.073741824E9d;
        double temp2 = (epsilon + temp) - temp;
        double sinEpsB2 = sinEpsB + (epsilon - temp2);
        double c = 0.0d + sintA;
        double d = -((c - 0.0d) - sintA);
        double b = 0.0d + d;
        double t = costA * temp2;
        double c2 = c + t;
        double d2 = (c2 - c) - t;
        double b2 = ((b + (-d2)) + (sintA * cosEpsB)) + (costA * sinEpsB2);
        double b3 = (((b2 + sintB) + (costB * temp2)) + (sintB * cosEpsB)) + (costB * sinEpsB2);
        double b4 = c2 + b3;
        double d3 = (b4 - c2) - b3;
        double sinb = -d3;
        double t2 = costA * 1.0d;
        double c3 = 0.0d + t2;
        double d4 = -((c3 - 0.0d) - t2);
        double b5 = 0.0d + d4;
        double d5 = -sintA;
        double t3 = d5 * temp2;
        double t4 = c3 + t3;
        double d6 = -((t4 - c3) - t3);
        double b6 = (((b5 + d6) + (1.0d * costB)) + (costA * cosEpsB)) + (costB * cosEpsB);
        double b7 = sintB * temp2;
        double b8 = b6 - ((b7 + (sintA * sinEpsB2)) + (sintB * sinEpsB2));
        double cosa = t4 + b8;
        double d7 = (cosa - t4) - b8;
        double cosb = -d7;
        if (cotanFlag == false) goto L5;
        double tmp = b4;
        double cosa2 = sinb;
        double cosb2 = cosa;
        double sina = cosb;
    L6:
        double sinb2 = cosb2 / tmp;
        double temp3 = sinb2 * 1.073741824E9d;
        double esta = (sinb2 + temp3) - temp3;
        double estb = sinb2 - esta;
        double temp4 = 1.073741824E9d * tmp;
        double cosaa = (tmp + temp4) - temp4;
        double cosab = tmp - cosaa;
        double err = ((((cosb2 - (esta * cosaa)) - (esta * cosab)) - (estb * cosaa)) - (estb * cosab)) / tmp;
        double err2 = (err + (sina / tmp)) + ((((-cosb2) * cosa2) / tmp) / tmp);
        if (xb == 0.0d) goto L13;
        double xbadj = xb + ((sinb2 * sinb2) * xb);
        if (cotanFlag == false) goto L11;
        xbadj = -xbadj;
    L11:
        err2 = err2 + xbadj;
    L13:
        return sinb2 + err2;
    L5:
        tmp = cosa;
        cosa2 = cosb;
        cosb2 = b4;
        sina = sinb;
        goto L6
    }

    private static void reducePayneHanek(double x, double[] result) {
        long inbits = Double.doubleToLongBits(x);
        int exponent = (((int) ((inbits >> 52) & 2047)) - 1023) + 1;
        long inbits2 = ((inbits & 4503599627370495L) | 4503599627370496L) << 11;
        int idx = exponent >> 6;
        int shift = exponent - (idx << 6);
        if (shift == 0) goto L8;
        if (idx != 0) goto L6;
        long shpi0 = 0;
    L7:
        long shpi1 = shpi0 | (RECIP_2PI[idx] >>> (64 - shift));
        long shpiA = (RECIP_2PI[idx] << shift) | (RECIP_2PI[idx + 1] >>> (64 - shift));
        long shpiB = (RECIP_2PI[idx + 1] << shift) | (RECIP_2PI[idx + 2] >>> (64 - shift));
    L12:
        long a = inbits2 >>> 32;
        long b = inbits2 & 4294967295L;
        long c = shpiA >>> 32;
        long d = shpiA & 4294967295L;
        long ac = a * c;
        long bd = b * d;
        long bc = b * c;
        long ad = a * d;
        long prodB = bd + (ad << 32);
        long prodA = ac + (ad >>> 32);
        if ((bd & Long.MIN_VALUE) == 0) goto L15;
        boolean bita = true;
    L17:
        if ((ad & 2147483648L) == 0) goto L19;
        boolean bitb = true;
    L21:
        if ((prodB & Long.MIN_VALUE) == 0) goto L23;
        boolean bitsum = true;
    L25:
        if (bita == false) goto L27;
        if (bitb == false) goto L27;
    L30:
        prodA = prodA + 1;
    L32:
        if ((prodB & Long.MIN_VALUE) == 0) goto L34;
        boolean bita2 = true;
    L36:
        if ((bc & 2147483648L) == 0) goto L38;
        boolean bitb2 = true;
    L39:
        long prodB2 = prodB + (bc << 32);
        long prodA2 = prodA + (bc >>> 32);
        if ((prodB2 & Long.MIN_VALUE) == 0) goto L42;
        boolean bitsum2 = true;
    L43:
        if (bita2 == false) goto L45;
        if (bitb2 == false) goto L45;
    L48:
        prodA2 = prodA2 + 1;
    L49:
        long c2 = shpiB >>> 32;
        long ac2 = a * c2;
        long ac3 = ac2 + (((b * c2) + (a * (shpiB & 4294967295L))) >>> 32);
        if ((prodB2 & Long.MIN_VALUE) == 0) goto L52;
        boolean bita3 = true;
    L54:
        if ((ac3 & Long.MIN_VALUE) == 0) goto L56;
        boolean bitb3 = true;
    L57:
        long prodB3 = prodB2 + ac3;
        if ((prodB3 & Long.MIN_VALUE) == 0) goto L60;
        boolean bitsum3 = true;
    L61:
        if (bita3 == false) goto L63;
        if (bitb3 == false) goto L63;
    L66:
        prodA2 = prodA2 + 1;
    L67:
        long d2 = shpi1 & 4294967295L;
        long prodA3 = prodA2 + ((b * d2) + (((b * (shpi1 >>> 32)) + (a * d2)) << 32));
        int intPart = (int) (prodA3 >>> 62);
        long prodA4 = (prodA3 << 2) | (prodB3 >>> 62);
        long prodB4 = prodB3 << 2;
        long a2 = prodA4 >>> 32;
        long b2 = prodA4 & 4294967295L;
        long c3 = PI_O_4_BITS[0] >>> 32;
        long d3 = PI_O_4_BITS[0] & 4294967295L;
        long ac4 = a2 * c3;
        long bd2 = b2 * d3;
        long bc2 = b2 * c3;
        long ad2 = a2 * d3;
        long prod2B = bd2 + (ad2 << 32);
        long prod2A = ac4 + (ad2 >>> 32);
        if ((bd2 & Long.MIN_VALUE) == 0) goto L70;
        boolean bita4 = true;
    L72:
        if ((ad2 & 2147483648L) == 0) goto L74;
        boolean bitb4 = true;
    L76:
        if ((prod2B & Long.MIN_VALUE) == 0) goto L78;
        boolean bitsum4 = true;
    L79:
        if (bita4 == false) goto L81;
        if (bitb4 == false) goto L81;
    L84:
        prod2A = prod2A + 1;
    L86:
        if ((prod2B & Long.MIN_VALUE) == 0) goto L88;
        boolean bita5 = true;
    L90:
        if ((bc2 & 2147483648L) == 0) goto L92;
        boolean bitb5 = true;
    L93:
        long prod2B2 = prod2B + (bc2 << 32);
        long prod2A2 = prod2A + (bc2 >>> 32);
        if ((prod2B2 & Long.MIN_VALUE) == 0) goto L96;
        boolean bitsum5 = true;
    L97:
        if (bita5 == false) goto L99;
        if (bitb5 == false) goto L99;
    L102:
        prod2A2 = prod2A2 + 1;
    L103:
        long c4 = PI_O_4_BITS[1] >>> 32;
        long ac5 = a2 * c4;
        long ac6 = ac5 + (((b2 * c4) + (a2 * (PI_O_4_BITS[1] & 4294967295L))) >>> 32);
        if ((prod2B2 & Long.MIN_VALUE) == 0) goto L106;
        boolean bita6 = true;
    L108:
        if ((ac6 & Long.MIN_VALUE) == 0) goto L110;
        boolean bitb6 = true;
    L111:
        long prod2B3 = prod2B2 + ac6;
        if ((prod2B3 & Long.MIN_VALUE) == 0) goto L114;
        boolean bitsum6 = true;
    L115:
        if (bita6 == false) goto L117;
        if (bitb6 == false) goto L117;
    L120:
        prod2A2 = prod2A2 + 1;
    L121:
        long a3 = prodB4 >>> 32;
        long c5 = PI_O_4_BITS[0] >>> 32;
        long ac7 = (prodB4 & 4294967295L) * c5;
        long ac8 = (a3 * c5) + ((ac7 + (a3 * (PI_O_4_BITS[0] & 4294967295L))) >>> 32);
        if ((prod2B3 & Long.MIN_VALUE) == 0) goto L124;
        boolean bita7 = true;
    L126:
        if ((ac8 & Long.MIN_VALUE) == 0) goto L128;
        boolean bitb7 = true;
    L129:
        long prod2B4 = prod2B3 + ac8;
        if ((prod2B4 & Long.MIN_VALUE) == 0) goto L132;
        boolean bitsum7 = true;
    L133:
        if (bita7 == false) goto L135;
        if (bitb7 == false) goto L135;
    L138:
        prod2A2 = prod2A2 + 1;
    L139:
        double tmpA = (prod2A2 >>> 12) / TWO_POWER_52;
        double tmpB = ((((prod2A2 & 4095) << 40) + (prod2B4 >>> 24)) / TWO_POWER_52) / TWO_POWER_52;
        double sumA = tmpA + tmpB;
        double sumB = -((sumA - tmpA) - tmpB);
        double sumB2 = intPart;
        result[0] = sumB2;
        result[1] = sumA * 2.0d;
        result[2] = 2.0d * sumB;
        return;
    L135:
        if (bita7 == true) goto L137;
        if (bitb7 == false) goto L139;
    L137:
        if (bitsum7 == true) goto L139;
    L132:
        bitsum7 = false;
        goto L133
    L128:
        bitb7 = false;
        goto L129
    L124:
        bita7 = false;
    L117:
        if (bita6 == true) goto L119;
        if (bitb6 == false) goto L121;
    L119:
        if (bitsum6 == true) goto L121;
    L114:
        bitsum6 = false;
        goto L115
    L110:
        bitb6 = false;
        goto L111
    L106:
        bita6 = false;
    L99:
        if (bita5 == true) goto L101;
        if (bitb5 == false) goto L103;
    L101:
        if (bitsum5 == true) goto L103;
    L96:
        bitsum5 = false;
        goto L97
    L92:
        bitb5 = false;
        goto L93
    L88:
        bita5 = false;
    L81:
        if (bita4 == true) goto L83;
        if (bitb4 == false) goto L86;
    L83:
        if (bitsum4 == true) goto L86;
    L78:
        bitsum4 = false;
        goto L79
    L74:
        bitb4 = false;
        goto L76
    L70:
        bita4 = false;
    L63:
        if (bita3 == true) goto L65;
        if (bitb3 == false) goto L67;
    L65:
        if (bitsum3 == true) goto L67;
    L60:
        bitsum3 = false;
        goto L61
    L56:
        bitb3 = false;
        goto L57
    L52:
        bita3 = false;
    L45:
        if (bita2 == true) goto L47;
        if (bitb2 == false) goto L49;
    L47:
        if (bitsum2 == true) goto L49;
    L42:
        bitsum2 = false;
        goto L43
    L38:
        bitb2 = false;
        goto L39
    L34:
        bita2 = false;
    L27:
        if (bita == true) goto L29;
        if (bitb == false) goto L32;
    L29:
        if (bitsum == true) goto L32;
    L23:
        bitsum = false;
        goto L25
    L19:
        bitb = false;
        goto L21
    L15:
        bita = false;
        goto L17
    L6:
        shpi0 = RECIP_2PI[idx - 1] << shift;
        goto L7
    L8:
        if (idx != 0) goto L10;
        shpi1 = 0;
    L11:
        shpiA = RECIP_2PI[idx];
        shpiB = RECIP_2PI[idx + 1];
        goto L12
    L10:
        shpi1 = RECIP_2PI[idx - 1];
        goto L11
    }

    public static double sin(double x) {
        boolean negative = false;
        int quadrant = 0;
        double xb = 0.0d;
        double xa = x;
        double remB = 0.0d;
        if (x >= 0.0d) goto L6;
        negative = true;
        xa = -xa;
    L6:
        if (xa != 0.0d) goto L13;
        long bits = Double.doubleToLongBits(x);
        if (bits >= 0) goto L11;
        return -0.0d;
    L11:
        return 0.0d;
    L13:
        if (xa != xa) goto L41;
        if (xa != Double.POSITIVE_INFINITY) goto L18;
        return Double.NaN;
    L18:
        if (xa <= 3294198.0d) goto L21;
        double[] reduceResults = new double[3];
        reducePayneHanek(xa, reduceResults);
        quadrant = ((int) reduceResults[0]) & 3;
        xa = reduceResults[1];
        xb = reduceResults[2];
        boolean negative2 = negative;
        double r19 = Double.NaN;
    L28:
        if (negative2 == false) goto L30;
        quadrant = quadrant ^ 2;
    L30:
        switch(quadrant) {
            case 0: goto L39;
            case 1: goto L37;
            case 2: goto L35;
            case 3: goto L33;
            default: goto L31;
        };
    L31:
        return r19;
    L33:
        return -cosQ(xa, xb);
    L35:
        return -sinQ(xa, xb);
    L37:
        return cosQ(xa, xb);
    L39:
        return sinQ(xa, xb);
    L21:
        if (xa <= 1.5707963267948966d) goto L27;
        int k = (int) (0.6366197723675814d * xa);
    L23:
        double a = ((double) (-k)) * 1.570796251296997d;
        double remA = xa + a;
        double r17 = remB;
        double remB2 = -((remA - xa) - a);
        r19 = Double.NaN;
        double a2 = ((double) (-k)) * 7.549789948768648E-8d;
        double remA2 = a2 + remA;
        negative2 = negative;
        int quadrant2 = quadrant;
        double a3 = ((double) (-k)) * 6.123233995736766E-17d;
        double b = a3 + remA2;
        double remB3 = (remB2 + (-((remA2 - remA) - a2))) + (-((b - remA2) - a3));
        if (b > r17) goto L25;
        k = k - 1;
        remB = r17;
        negative = negative2;
        quadrant = quadrant2;
        goto L23
    L25:
        quadrant = k & 3;
        xa = b;
        xb = remB3;
        goto L28
    L27:
        negative2 = negative;
        r19 = Double.NaN;
        goto L28
    L41:
        return Double.NaN;
    }

    public static double cos(double x) {
        int quadrant = 0;
        double xa = x;
        double r3 = 0.0d;
        if (x >= 0.0d) goto L6;
        xa = -xa;
    L6:
        if (xa == xa) goto L8;
        return Double.NaN;
    L8:
        if (xa != Double.POSITIVE_INFINITY) goto L10;
        return Double.NaN;
    L10:
        double xb = 0.0d;
        if (xa <= 3294198.0d) goto L14;
        double[] reduceResults = new double[3];
        reducePayneHanek(xa, reduceResults);
        quadrant = ((int) reduceResults[0]) & 3;
        xa = reduceResults[1];
        xb = reduceResults[2];
        double r20 = Double.NaN;
    L21:
        switch(quadrant) {
            case 0: goto L30;
            case 1: goto L28;
            case 2: goto L26;
            case 3: goto L24;
            default: goto L22;
        };
    L22:
        return r20;
    L24:
        return sinQ(xa, xb);
    L26:
        return -cosQ(xa, xb);
    L28:
        return -sinQ(xa, xb);
    L30:
        return cosQ(xa, xb);
    L14:
        if (xa <= 1.5707963267948966d) goto L20;
        int k = (int) (0.6366197723675814d * xa);
    L16:
        double a = ((double) (-k)) * 1.570796251296997d;
        double remA = xa + a;
        double remB = -((remA - xa) - a);
        double r16 = r3;
        double a2 = ((double) (-k)) * 7.549789948768648E-8d;
        double remA2 = a2 + remA;
        r20 = Double.NaN;
        double a3 = ((double) (-k)) * 6.123233995736766E-17d;
        double b = a3 + remA2;
        double remB2 = (remB + (-((remA2 - remA) - a2))) + (-((b - remA2) - a3));
        if (b > r16) goto L18;
        k = k - 1;
        r3 = r16;
        goto L16
    L18:
        quadrant = k & 3;
        xa = b;
        xb = remB2;
        goto L21
    L20:
        r20 = Double.NaN;
        goto L21
    }

    public static double tan(double x) {
        boolean negative = false;
        int quadrant = 0;
        double xa = x;
        if (x >= 0.0d) goto L6;
        negative = true;
        xa = -xa;
    L6:
        if (xa != 0.0d) goto L13;
        long bits = Double.doubleToLongBits(x);
        if (bits >= 0) goto L11;
        return -0.0d;
    L11:
        return 0.0d;
    L13:
        if (xa == xa) goto L15;
        return Double.NaN;
    L15:
        if (xa == Double.POSITIVE_INFINITY) goto L42;
        double xb = 0.0d;
        double remB = 1.5707963267948966d;
        if (xa <= 3294198.0d) goto L21;
        double[] reduceResults = new double[3];
        reducePayneHanek(xa, reduceResults);
        quadrant = ((int) reduceResults[0]) & 3;
        xa = reduceResults[1];
        double xb2 = reduceResults[2];
        double xb3 = xb2;
        double r23 = 1.5707963267948966d;
        double r21 = 6.123233995736766E-17d;
    L29:
        if (xa <= 1.5d) goto L32;
        double a = r23 - xa;
        double b = (-((a - r23) + xa)) + (r21 - xb3);
        xa = a + b;
        xb3 = -((xa - a) - b);
        quadrant = quadrant ^ 1;
        negative = !negative;
    L32:
        if ((quadrant & 1) != 0) goto L34;
        double result = tanQ(xa, xb3, false);
    L35:
        if (negative == true) goto L37;
        return result;
    L37:
        return -result;
    L34:
        result = -tanQ(xa, xb3, true);
        goto L35
    L21:
        if (xa <= 1.5707963267948966d) goto L27;
        int k = (int) (xa * 0.6366197723675814d);
    L23:
        double a2 = ((double) (-k)) * 1.570796251296997d;
        double remA = xa + a2;
        r23 = remB;
        double remB2 = -((remA - xa) - a2);
        r21 = 6.123233995736766E-17d;
        double a3 = ((double) (-k)) * 7.549789948768648E-8d;
        double remA2 = a3 + remA;
        double remB3 = remB2 + (-((remA2 - remA) - a3));
        double a4 = ((double) (-k)) * 6.123233995736766E-17d;
        double remA3 = a4 + remA2;
        double xb4 = xb;
        double remB4 = remB3 + (-((remA3 - remA2) - a4));
        if (remA3 > 0.0d) goto L25;
        k = k - 1;
        remB = r23;
        xb = xb4;
        goto L23
    L25:
        quadrant = k & 3;
        xa = remA3;
        xb3 = remB4;
        goto L29
    L27:
        r23 = 1.5707963267948966d;
        r21 = 6.123233995736766E-17d;
        xb3 = 0.0d;
        goto L29
    L42:
        return Double.NaN;
    }

    public static double atan(double x) {
        return atan(x, 0.0d, false);
    }

    private static double atan(double xa, double xb, boolean leftPlane) {
        double xa2 = xa;
        boolean negate = false;
        if (xa2 != 0.0d) goto L9;
        if (leftPlane == false) goto L7;
        return copySign(3.141592653589793d, xa2);
    L7:
        return xa2;
    L9:
        if (xa2 >= 0.0d) goto L11;
        xa2 = -xa2;
        double xb2 = -xb;
        negate = true;
    L13:
        if (xa2 <= 1.633123935319537E16d) goto L20;
        if ((negate ^ leftPlane) == false) goto L17;
        return -1.5707963267948966d;
    L17:
        return 1.5707963267948966d;
    L20:
        if (xa2 >= 1.0d) goto L22;
        int idx = (int) ((((((-1.7168146928204135d) * xa2) * xa2) + 8.0d) * xa2) + 0.5d);
    L23:
        double epsA = xa2 - TANGENT_TABLE_A[idx];
        double epsB = (-((epsA - xa2) + TANGENT_TABLE_A[idx])) + (xb2 - TANGENT_TABLE_B[idx]);
        double temp = epsA + epsB;
        double epsB2 = -((temp - epsA) - epsB);
        double temp2 = xa2 * 1.073741824E9d;
        double ya = (xa2 + temp2) - temp2;
        double yb = (xb2 + xa2) - ya;
        double xb3 = xb2 + yb;
        if (idx != 0) goto L26;
        double denom = 1.0d / (((ya + xb3) * (TANGENT_TABLE_A[idx] + TANGENT_TABLE_B[idx])) + 1.0d);
        double ya2 = temp * denom;
        double denom2 = denom * epsB2;
    L27:
        double epsA2 = ya2;
        double epsB3 = denom2;
        double epsA3 = epsA2 * epsA2;
        double yb2 = 0.07490822288864472d * epsA3;
        double yb3 = ((((((((((yb2 - 0.09088450866185192d) * epsA3) + 0.11111095942313305d) * epsA3) - 0.1428571423679182d) * epsA3) + 0.19999999999923582d) * epsA3) - 0.33333333333333287d) * epsA3) * epsA2;
        double temp3 = epsA2 + yb3;
        double yb4 = (-((temp3 - epsA2) - yb3)) + (epsB3 / ((epsA2 * epsA2) + 1.0d));
        double za = EIGHTHS[idx] + temp3;
        double yb5 = (za - EIGHTHS[idx]) - temp3;
        double zb = -yb5;
        double temp4 = za + yb4;
        double zb2 = (temp4 - za) - yb4;
        double zb3 = zb + (-zb2);
        double result = temp4 + zb3;
        double resultb = -((result - temp4) - zb3);
        if (leftPlane == false) goto L30;
        double za2 = 3.141592653589793d - result;
        double resultb2 = (za2 - 3.141592653589793d) + result;
        double zb4 = -resultb2;
        double zb5 = zb4 + (1.2246467991473532E-16d - resultb);
        double result2 = za2 + zb5;
        double r0 = -((result2 - za2) - zb5);
        double result3 = result2;
    L32:
        if ((negate ^ leftPlane) == true) goto L34;
        return result3;
    L34:
        return -result3;
    L30:
        result3 = result;
        goto L32
    L26:
        double temp5 = TANGENT_TABLE_A[idx] * ya;
        double za3 = temp5 + 1.0d;
        double zb6 = -((za3 - 1.0d) - temp5);
        double temp6 = (TANGENT_TABLE_A[idx] * xb3) + (TANGENT_TABLE_B[idx] * ya);
        double temp7 = za3 + temp6;
        double zb7 = (zb6 + (-((temp7 - za3) - temp6))) + (TANGENT_TABLE_B[idx] * xb3);
        ya2 = temp / temp7;
        double temp8 = ya2 * 1.073741824E9d;
        double yaa = (ya2 + temp8) - temp8;
        double yab = ya2 - yaa;
        double temp9 = temp7 * 1.073741824E9d;
        double zaa = (temp7 + temp9) - temp9;
        double zab = temp7 - zaa;
        double yb6 = ((((temp - (yaa * zaa)) - (yaa * zab)) - (yab * zaa)) - (yab * zab)) / temp7;
        double xa3 = -temp;
        denom2 = (yb6 + (((xa3 * zb7) / temp7) / temp7)) + (epsB2 / temp7);
        goto L27
    L22:
        double temp10 = 1.0d / xa2;
        idx = (int) ((-(((((-1.7168146928204135d) * temp10) * temp10) + 8.0d) * temp10)) + 13.07d);
        goto L23
    L11:
        xb2 = xb;
        goto L13
    }

    public static double atan2(double y, double x) {
        if (x == x) goto L5;
        return Double.NaN;
    L5:
        if (y == y) goto L8;
        return Double.NaN;
    L8:
        if (y != 0.0d) goto L30;
        double result = x * y;
        double invx = 1.0d / x;
        double invy = 1.0d / y;
        if (invx != 0.0d) goto L17;
        if (x <= 0.0d) goto L15;
        return y;
    L15:
        return copySign(3.141592653589793d, y);
    L17:
        if (x < 0.0d) goto L23;
        if (invx < 0.0d) goto L23;
        return result;
    L23:
        if (y >= 0.0d) goto L25;
    L28:
        return -3.141592653589793d;
    L25:
        if (invy < 0.0d) goto L28;
        return 3.141592653589793d;
    L30:
        if (y != Double.POSITIVE_INFINITY) goto L41;
        if (x != Double.POSITIVE_INFINITY) goto L36;
        return 0.7853981633974483d;
    L36:
        if (x != Double.NEGATIVE_INFINITY) goto L39;
        return 2.356194490192345d;
    L39:
        return 1.5707963267948966d;
    L41:
        if (y != Double.NEGATIVE_INFINITY) goto L52;
        if (x != Double.POSITIVE_INFINITY) goto L47;
        return -0.7853981633974483d;
    L47:
        if (x != Double.NEGATIVE_INFINITY) goto L50;
        return -2.356194490192345d;
    L50:
        return -1.5707963267948966d;
    L52:
        if (x != Double.POSITIVE_INFINITY) goto L66;
        if (y <= 0.0d) goto L56;
    L64:
        return 0.0d;
    L56:
        if ((1.0d / y) > 0.0d) goto L64;
        if (y >= 0.0d) goto L61;
        return -0.0d;
    L61:
        if ((1.0d / y) >= 0.0d) goto L66;
        return -0.0d;
    L66:
        if (x != Double.NEGATIVE_INFINITY) goto L79;
        if (y <= 0.0d) goto L70;
    L77:
        return 3.141592653589793d;
    L70:
        if ((1.0d / y) > 0.0d) goto L77;
        if (y >= 0.0d) goto L75;
    L76:
        return -3.141592653589793d;
    L75:
        if ((1.0d / y) < 0.0d) goto L76;
    L79:
        if (x == 0.0d) goto L81;
    L91:
        double r = y / x;
        if (Double.isInfinite(r) == true) goto L94;
        double ra = doubleHighPart(r);
        double rb = r - ra;
        double xa = doubleHighPart(x);
        double xb = x - xa;
        double rb2 = rb + (((((y - (ra * xa)) - (ra * xb)) - (rb * xa)) - (rb * xb)) / x);
        double temp = ra + rb2;
        double rb3 = -((temp - ra) - rb2);
        double ra2 = temp;
        if (ra2 != 0.0d) goto L103;
        ra2 = copySign(0.0d, y);
    L103:
        if (x >= 0.0d) goto L105;
        boolean r6 = true;
    L106:
        double result2 = atan(ra2, rb3, r6);
        return result2;
    L105:
        r6 = false;
        goto L106
    L94:
        if (x >= 0.0d) goto L96;
        boolean r7 = true;
    L98:
        return atan(r, 0.0d, r7);
    L96:
        r7 = false;
        goto L98
    L81:
        if (y <= 0.0d) goto L83;
    L90:
        return 1.5707963267948966d;
    L83:
        if ((1.0d / y) > 0.0d) goto L90;
        if (y >= 0.0d) goto L88;
    L89:
        return -1.5707963267948966d;
    L88:
        if ((1.0d / y) >= 0.0d) goto L91;
        goto L89
    }

    public static double asin(double x) {
        if (x == x) goto L6;
        return Double.NaN;
    L6:
        if (x <= 1.0d) goto L8;
    L23:
        return Double.NaN;
    L8:
        if (x < (-1.0d)) goto L23;
        if (x != 1.0d) goto L15;
        return 1.5707963267948966d;
    L15:
        if (x != (-1.0d)) goto L19;
        return -1.5707963267948966d;
    L19:
        if (x != 0.0d) goto L21;
        return x;
    L21:
        double temp = x * 1.073741824E9d;
        double xa = (x + temp) - temp;
        double xb = x - xa;
        double ya = -(xa * xa);
        double yb = -(((xa * xb) * 2.0d) + (xb * xb));
        double za = ya + 1.0d;
        double zb = -((za - 1.0d) - ya);
        double temp2 = za + yb;
        double zb2 = zb + (-((temp2 - za) - yb));
        double y = sqrt(temp2);
        double temp3 = y * 1.073741824E9d;
        double ya2 = (y + temp3) - temp3;
        double ya3 = y - ya2;
        double yb2 = ya2 * ya2;
        double yb3 = ya3 + ((((temp2 - yb2) - ((ya2 * 2.0d) * ya3)) - (ya3 * ya3)) / (y * 2.0d));
        double dx = zb2 / (2.0d * y);
        double r = x / y;
        double temp4 = r * 1.073741824E9d;
        double ra = (r + temp4) - temp4;
        double rb = r - ra;
        double rb2 = (rb + (((((x - (ra * ya2)) - (ra * yb3)) - (rb * ya2)) - (rb * yb3)) / y)) + ((((-x) * dx) / y) / y);
        double temp5 = ra + rb2;
        return atan(temp5, -((temp5 - ra) - rb2), false);
    }

    public static double acos(double x) {
        if (x == x) goto L6;
        return Double.NaN;
    L6:
        if (x <= 1.0d) goto L8;
    L29:
        return Double.NaN;
    L8:
        if (x < (-1.0d)) goto L29;
        if (x != (-1.0d)) goto L15;
        return 3.141592653589793d;
    L15:
        if (x != 1.0d) goto L18;
        return 0.0d;
    L18:
        if (x != 0.0d) goto L20;
        return 1.5707963267948966d;
    L20:
        double temp = x * 1.073741824E9d;
        double xa = (x + temp) - temp;
        double xb = x - xa;
        double ya = -(xa * xa);
        double yb = -(((xa * xb) * 2.0d) + (xb * xb));
        double za = ya + 1.0d;
        double zb = -((za - 1.0d) - ya);
        double temp2 = za + yb;
        double zb2 = zb + (-((temp2 - za) - yb));
        double y = sqrt(temp2);
        double temp3 = y * 1.073741824E9d;
        double ya2 = (y + temp3) - temp3;
        double ya3 = y - ya2;
        double yb2 = ya2 * ya2;
        double yb3 = ya3 + ((((temp2 - yb2) - ((ya2 * 2.0d) * ya3)) - (ya3 * ya3)) / (y * 2.0d));
        double yb4 = yb3 + (zb2 / (2.0d * y));
        double y2 = ya2 + yb4;
        double yb5 = -((y2 - ya2) - yb4);
        double r = y2 / x;
        if (Double.isInfinite(r) == false) goto L23;
        return 1.5707963267948966d;
    L23:
        double ra = doubleHighPart(r);
        double rb = r - ra;
        double rb2 = (rb + (((((y2 - (ra * xa)) - (ra * xb)) - (rb * xa)) - (rb * xb)) / x)) + (yb5 / x);
        double temp4 = ra + rb2;
        double rb3 = -((temp4 - ra) - rb2);
        if (x >= 0.0d) goto L26;
        boolean r10 = true;
    L28:
        return atan(temp4, rb3, r10);
    L26:
        r10 = false;
        goto L28
    }

    public static double cbrt(double x) {
        long inbits = Double.doubleToLongBits(x);
        int exponent = ((int) ((inbits >> 52) & 2047)) - 1023;
        boolean subnormal = false;
        if (exponent == (-1023)) goto L5;
        double x2 = x;
    L10:
        if (exponent != 1024) goto L12;
        return x2;
    L12:
        int exp3 = exponent / 3;
        double p2 = Double.longBitsToDouble((Long.MIN_VALUE & inbits) | (((long) ((exp3 + 1023) & 2047)) << 52));
        double mant = Double.longBitsToDouble((4503599627370495L & inbits) | 4607182418800017408L);
        double est = (((((((((-0.010714690733195933d) * mant) + 0.0875862700108075d) * mant) - 0.3058015757857271d) * mant) + 0.7249995199969751d) * mant) + 0.5039018405998233d) * CBRTTWO[(exponent % 3) + 2];
        double xs = x2 / ((p2 * p2) * p2);
        double est2 = est + ((xs - ((est * est) * est)) / ((est * 3.0d) * est));
        double est3 = est2 + ((xs - ((est2 * est2) * est2)) / ((est2 * 3.0d) * est2));
        double temp = est3 * 1.073741824E9d;
        double ya = (est3 + temp) - temp;
        double yb = est3 - ya;
        double za = ya * ya;
        double temp2 = 1.073741824E9d * za;
        double temp3 = (za + temp2) - temp2;
        double zb = (((ya * yb) * 2.0d) + (yb * yb)) + (za - temp3);
        double zb2 = ((temp3 * yb) + (ya * zb)) + (zb * yb);
        double za2 = temp3 * ya;
        double na = xs - za2;
        double nb = -((na - xs) + za2);
        double est4 = (est3 + ((na + (nb - zb2)) / ((3.0d * est3) * est3))) * p2;
        if (subnormal == true) goto L15;
        return est4;
    L15:
        return est4 * 3.814697265625E-6d;
    L5:
        if (x != 0.0d) goto L7;
        return x;
    L7:
        subnormal = true;
        x2 = 1.8014398509481984E16d * x;
        inbits = Double.doubleToLongBits(x2);
        exponent = ((int) (2047 & (inbits >> 52))) - 1023;
        goto L10
    }

    public static double toRadians(double x) {
        if (Double.isInfinite(x) == false) goto L5;
    L11:
        return x;
    L5:
        if (x == 0.0d) goto L11;
        double xa = doubleHighPart(x);
        double xb = x - xa;
        double result = (((xb * 1.997844754509471E-9d) + (xb * 0.01745329052209854d)) + (1.997844754509471E-9d * xa)) + (0.01745329052209854d * xa);
        if (result == 0.0d) goto L10;
        return result;
    L10:
        return result * x;
    }

    public static double toDegrees(double x) {
        if (Double.isInfinite(x) == false) goto L5;
    L9:
        return x;
    L5:
        if (x == 0.0d) goto L9;
        double xa = doubleHighPart(x);
        double xb = x - xa;
        return (((xb * 3.145894820876798E-6d) + (xb * 57.2957763671875d)) + (3.145894820876798E-6d * xa)) + (57.2957763671875d * xa);
    }

    public static int abs(int x) {
        if (x >= 0) goto L5;
        return -x;
    L5:
        return x;
    }

    public static long abs(long x) {
        if (x >= 0) goto L6;
        return -x;
    L6:
        return x;
    }

    public static float abs(float x) {
        if (x >= 0.0f) goto L6;
        return -x;
    L6:
        if (x != 0.0f) goto L9;
        return 0.0f;
    L9:
        return x;
    }

    public static double abs(double x) {
        if (x >= 0.0d) goto L6;
        return -x;
    L6:
        if (x != 0.0d) goto L9;
        return 0.0d;
    L9:
        return x;
    }

    public static double ulp(double x) {
        if (Double.isInfinite(x) == false) goto L7;
        return Double.POSITIVE_INFINITY;
    L7:
        return abs(x - Double.longBitsToDouble(Double.doubleToLongBits(x) ^ 1));
    }

    public static float ulp(float x) {
        if (Float.isInfinite(x) == false) goto L7;
        return Float.POSITIVE_INFINITY;
    L7:
        return abs(x - Float.intBitsToFloat(Float.floatToIntBits(x) ^ 1));
    }

    public static double scalb(double d, int n) {
        if (n <= (-1023)) goto L9;
        if (n >= 1024) goto L9;
        return Double.longBitsToDouble(((long) (n + 1023)) << 52) * d;
    L9:
        if (Double.isNaN(d) == false) goto L11;
    L64:
        return d;
    L11:
        if (Double.isInfinite(d) == true) goto L64;
        if (d == 0.0d) goto L64;
        if (n >= (-2098)) goto L23;
        if (d <= 0.0d) goto L21;
        return 0.0d;
    L21:
        return -0.0d;
    L23:
        if (n > 2097) goto L25;
        long bits = Double.doubleToLongBits(d);
        long sign = Long.MIN_VALUE & bits;
        int exponent = ((int) (bits >>> 52)) & 2047;
        long mantissa = bits & 4503599627370495L;
        int scaledExponent = exponent + n;
        if (n >= 0) goto L45;
        if (scaledExponent <= 0) goto L34;
        return Double.longBitsToDouble(((((long) scaledExponent) << 52) | sign) | mantissa);
    L34:
        if (scaledExponent <= (-53)) goto L41;
        long mantissa2 = mantissa | 4503599627370496L;
        long mostSignificantLostBit = (1 << (-scaledExponent)) & mantissa2;
        long mantissa3 = mantissa2 >>> (1 - scaledExponent);
        if (mostSignificantLostBit == 0) goto L39;
        mantissa3 = mantissa3 + 1;
    L39:
        return Double.longBitsToDouble(sign | mantissa3);
    L41:
        if (sign != 0) goto L44;
        return 0.0d;
    L44:
        return -0.0d;
    L45:
        if (exponent == 0) goto L47;
        if (scaledExponent >= 2047) goto L61;
        return Double.longBitsToDouble(((((long) scaledExponent) << 52) | sign) | mantissa);
    L61:
        if (sign == 0) goto L63;
        return Double.NEGATIVE_INFINITY;
    L63:
        return Double.POSITIVE_INFINITY;
    L47:
        if ((mantissa >>> 52) == 1) goto L49;
        mantissa = mantissa << 1;
        scaledExponent = scaledExponent - 1;
        goto L47
    L49:
        int scaledExponent2 = scaledExponent + 1;
        long mantissa4 = mantissa & 4503599627370495L;
        if (scaledExponent2 >= 2047) goto L54;
        return Double.longBitsToDouble(((((long) scaledExponent2) << 52) | sign) | mantissa4);
    L54:
        if (sign == 0) goto L56;
        return Double.NEGATIVE_INFINITY;
    L56:
        return Double.POSITIVE_INFINITY;
    L25:
        if (d > 0.0d) goto L27;
        return Double.NEGATIVE_INFINITY;
    L27:
        return Double.POSITIVE_INFINITY;
    }

    public static float scalb(float f, int n) {
        if (n <= (-127)) goto L9;
        if (n >= 128) goto L9;
        return Float.intBitsToFloat((n + 127) << 23) * f;
    L9:
        if (Float.isNaN(f) == false) goto L11;
    L61:
        return f;
    L11:
        if (Float.isInfinite(f) == true) goto L61;
        if (f == 0.0f) goto L61;
        if (n >= (-277)) goto L23;
        if (f <= 0.0f) goto L21;
        return 0.0f;
    L21:
        return -0.0f;
    L23:
        if (n > 276) goto L25;
        int bits = Float.floatToIntBits(f);
        int sign = Integer.MIN_VALUE & bits;
        int exponent = (bits >>> 23) & 255;
        int mantissa = bits & 8388607;
        int scaledExponent = exponent + n;
        if (n >= 0) goto L44;
        if (scaledExponent <= 0) goto L34;
        return Float.intBitsToFloat(((scaledExponent << 23) | sign) | mantissa);
    L34:
        if (scaledExponent <= (-24)) goto L40;
        int mantissa2 = 8388608 | mantissa;
        int mostSignificantLostBit = (1 << (-scaledExponent)) & mantissa2;
        int mantissa3 = mantissa2 >>> (1 - scaledExponent);
        if (mostSignificantLostBit == 0) goto L39;
        mantissa3 = mantissa3 + 1;
    L39:
        return Float.intBitsToFloat(sign | mantissa3);
    L40:
        if (sign != 0) goto L43;
        return 0.0f;
    L43:
        return -0.0f;
    L44:
        if (exponent == 0) goto L46;
        if (scaledExponent < 255) goto L57;
        if (sign == 0) goto L60;
        return Float.NEGATIVE_INFINITY;
    L60:
        return Float.POSITIVE_INFINITY;
    L57:
        return Float.intBitsToFloat(((scaledExponent << 23) | sign) | mantissa);
    L46:
        if ((mantissa >>> 23) == 1) goto L48;
        mantissa = mantissa << 1;
        scaledExponent = scaledExponent - 1;
        goto L46
    L48:
        int scaledExponent2 = scaledExponent + 1;
        int mantissa4 = mantissa & 8388607;
        if (scaledExponent2 < 255) goto L51;
        if (sign == 0) goto L54;
        return Float.NEGATIVE_INFINITY;
    L54:
        return Float.POSITIVE_INFINITY;
    L51:
        return Float.intBitsToFloat(((scaledExponent2 << 23) | sign) | mantissa4);
    L25:
        if (f > 0.0f) goto L27;
        return Float.NEGATIVE_INFINITY;
    L27:
        return Float.POSITIVE_INFINITY;
    }

    public static double nextAfter(double d, double direction) {
        if (Double.isNaN(d) == false) goto L5;
        return Double.NaN;
    L5:
        if (Double.isNaN(direction) == false) goto L8;
        return Double.NaN;
    L8:
        if (d != direction) goto L11;
        return direction;
    L11:
        if (Double.isInfinite(d) == false) goto L18;
        if (d >= 0.0d) goto L15;
        return -1.7976931348623157E308d;
    L15:
        return Double.MAX_VALUE;
    L18:
        if (d == 0.0d) goto L20;
        long bits = Double.doubleToLongBits(d);
        long sign = Long.MIN_VALUE & bits;
        boolean r5 = false;
        if (direction >= d) goto L27;
        boolean r4 = true;
    L29:
        if (sign != 0) goto L32;
        r5 = true;
    L32:
        if ((r4 ^ r5) == false) goto L36;
        return Double.longBitsToDouble(sign | ((Long.MAX_VALUE & bits) + 1));
    L36:
        return Double.longBitsToDouble(sign | ((Long.MAX_VALUE & bits) - 1));
    L27:
        r4 = false;
        goto L29
    L20:
        if (direction >= 0.0d) goto L22;
        return -4.9E-324d;
    L22:
        return Double.MIN_VALUE;
    }

    public static float nextAfter(float f, double direction) {
        if (Double.isNaN(f) == false) goto L5;
        return Float.NaN;
    L5:
        if (Double.isNaN(direction) == false) goto L8;
        return Float.NaN;
    L8:
        if (f != direction) goto L12;
        return (float) direction;
    L12:
        if (Float.isInfinite(f) == false) goto L19;
        if (f >= 0.0f) goto L16;
        return -3.4028235E38f;
    L16:
        return Float.MAX_VALUE;
    L19:
        if (f == 0.0f) goto L21;
        int bits = Float.floatToIntBits(f);
        int sign = Integer.MIN_VALUE & bits;
        boolean r3 = false;
        if (direction >= f) goto L28;
        boolean r2 = true;
    L29:
        if (sign != 0) goto L32;
        r3 = true;
    L32:
        if ((r2 ^ r3) == false) goto L36;
        return Float.intBitsToFloat(((bits & Integer.MAX_VALUE) + 1) | sign);
    L36:
        return Float.intBitsToFloat(((bits & Integer.MAX_VALUE) - 1) | sign);
    L28:
        r2 = false;
        goto L29
    L21:
        if (direction >= 0.0d) goto L23;
        return -1.4E-45f;
    L23:
        return Float.MIN_VALUE;
    }

    public static double floor(double x) {
        if (x == x) goto L6;
        return x;
    L6:
        if (x < TWO_POWER_52) goto L8;
    L21:
        return x;
    L8:
        if (x <= (-4.503599627370496E15d)) goto L21;
        long y = (long) x;
        if (x >= 0.0d) goto L16;
        if (y == x) goto L16;
        y = y - 1;
    L16:
        if (y != 0) goto L20;
        return y * x;
    L20:
        return y;
    }

    public static double ceil(double x) {
        if (x == x) goto L5;
        return x;
    L5:
        double y = floor(x);
        if (y != x) goto L8;
        return y;
    L8:
        double y2 = y + 1.0d;
        if (y2 == 0.0d) goto L11;
        return y2;
    L11:
        return x * y2;
    }

    public static double rint(double x) {
        double y = floor(x);
        double d = x - y;
        if (d <= 0.5d) goto L11;
        if (y != (-1.0d)) goto L9;
        return -0.0d;
    L9:
        return 1.0d + y;
    L11:
        if (d >= 0.5d) goto L13;
        return y;
    L13:
        long z = (long) y;
        if ((1 & z) != 0) goto L17;
        return y;
    L17:
        return 1.0d + y;
    }

    public static long round(double x) {
        return (long) floor(0.5d + x);
    }

    public static int round(float x) {
        return (int) floor(0.5f + x);
    }

    public static int min(int a, int b) {
        if (a > b) goto L5;
        return a;
    L5:
        return b;
    }

    public static long min(long a, long b) {
        if (a > b) goto L6;
        return a;
    L6:
        return b;
    }

    public static float min(float a, float b) {
        if (a <= b) goto L6;
        return b;
    L6:
        if (a >= b) goto L9;
        return a;
    L9:
        if (a == b) goto L12;
        return Float.NaN;
    L12:
        int bits = Float.floatToRawIntBits(a);
        if (bits != Integer.MIN_VALUE) goto L15;
        return a;
    L15:
        return b;
    }

    public static double min(double a, double b) {
        if (a <= b) goto L6;
        return b;
    L6:
        if (a >= b) goto L9;
        return a;
    L9:
        if (a == b) goto L12;
        return Double.NaN;
    L12:
        long bits = Double.doubleToRawLongBits(a);
        if (bits != Long.MIN_VALUE) goto L15;
        return a;
    L15:
        return b;
    }

    public static int max(int a, int b) {
        if (a > b) goto L5;
        return b;
    L5:
        return a;
    }

    public static long max(long a, long b) {
        if (a > b) goto L6;
        return b;
    L6:
        return a;
    }

    public static float max(float a, float b) {
        if (a <= b) goto L6;
        return a;
    L6:
        if (a >= b) goto L9;
        return b;
    L9:
        if (a == b) goto L12;
        return Float.NaN;
    L12:
        int bits = Float.floatToRawIntBits(a);
        if (bits != Integer.MIN_VALUE) goto L15;
        return b;
    L15:
        return a;
    }

    public static double max(double a, double b) {
        if (a <= b) goto L6;
        return a;
    L6:
        if (a >= b) goto L9;
        return b;
    L9:
        if (a == b) goto L12;
        return Double.NaN;
    L12:
        long bits = Double.doubleToRawLongBits(a);
        if (bits != Long.MIN_VALUE) goto L15;
        return b;
    L15:
        return a;
    }

    public static double hypot(double x, double y) {
        if (Double.isInfinite(x) == false) goto L5;
        return Double.POSITIVE_INFINITY;
    L5:
        if (Double.isInfinite(y) == false) goto L8;
        return Double.POSITIVE_INFINITY;
    L8:
        if (Double.isNaN(x) == false) goto L10;
        return Double.NaN;
    L10:
        if (Double.isNaN(y) == true) goto L26;
        int expX = getExponent(x);
        int expY = getExponent(y);
        if (expX <= (expY + 27)) goto L17;
        return abs(x);
    L17:
        if (expY > (expX + 27)) goto L19;
        int middleExp = (expX + expY) / 2;
        double scaledX = scalb(x, -middleExp);
        double scaledY = scalb(y, -middleExp);
        double scaledH = sqrt((scaledX * scaledX) + (scaledY * scaledY));
        return scalb(scaledH, middleExp);
    L19:
        return abs(y);
    L26:
        return Double.NaN;
    }

    public static double IEEEremainder(double dividend, double divisor) {
        return StrictMath.IEEEremainder(dividend, divisor);
    }

    public static double copySign(double magnitude, double sign) {
        long m = Double.doubleToLongBits(magnitude);
        long s = Double.doubleToLongBits(sign);
        if (m < 0) goto L7;
        if (s < 0) goto L7;
    L10:
        return magnitude;
    L7:
        if (m >= 0) goto L12;
        if (s < 0) goto L10;
    L12:
        return -magnitude;
    }

    public static float copySign(float magnitude, float sign) {
        int m = Float.floatToIntBits(magnitude);
        int s = Float.floatToIntBits(sign);
        if (m < 0) goto L5;
        if (s < 0) goto L5;
    L7:
        return magnitude;
    L5:
        if (m >= 0) goto L9;
        if (s < 0) goto L7;
    L9:
        return -magnitude;
    }

    public static int getExponent(double d) {
        return ((int) ((Double.doubleToLongBits(d) >>> 52) & 2047)) - 1023;
    }

    public static int getExponent(float f) {
        return ((Float.floatToIntBits(f) >>> 23) & 255) - 127;
    }
}
