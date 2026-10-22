package androidx.compose.animation.core;

import androidx.camera.video.AudioStats;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000(\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\u0006\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\u001a0\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0004H\u0007\u001a0\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\t2\u0006\u0010\u0007\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\tH\u0007\u001a8\u0010\u0002\u001a\u00020\u00012\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\t2\u0006\u0010\u0007\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\tH\u0007\u001a0\u0010\r\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\tH\u0002\u001a(\u0010\u0012\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\tH\u0002\u001a0\u0010\u0013\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\tH\u0002\u001a@\u0010\u0015\u001a\u00020\u00012\u0006\u0010\u000e\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\t2\u0006\u0010\u0016\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\tH\u0002\u001a9\u0010\u0017\u001a\u00020\t2\u0006\u0010\u0018\u001a\u00020\t2\u0012\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\u001a2\u0012\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\u001aH\u0082\b\u001a\r\u0010\u001c\u001a\u00020\u001d*\u00020\tH\u0082\b\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"MAX_LONG_MILLIS", "", "estimateAnimationDurationMillis", "stiffness", "", "dampingRatio", "initialVelocity", "initialDisplacement", "delta", "", "springConstant", "dampingCoefficient", "mass", "estimateUnderDamped", "firstRootReal", "firstRootImaginary", "p0", "v0", "estimateCriticallyDamped", "estimateOverDamped", "secondRootReal", "estimateDurationInternal", "initialPosition", "iterateNewtonsMethod", "x", BytedCertConstant.LivenessInfoConfigKey.FRAME_NUM, "Lkotlin/Function1;", "fnPrime", "isNotFinite", "", "animation-core"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class SpringEstimationKt {
    private static final long MAX_LONG_MILLIS = 9223372036854L;

    private static final boolean isNotFinite(double r100) {
        if ((Double.doubleToRawLongBits(r100) & Long.MAX_VALUE) >= 9218868437227405312L) goto L5;
        boolean r101 = true;
    L7:
        return !r101;
    L5:
        r101 = false;
        goto L7
    }

    private static final double iterateNewtonsMethod(double r100, Function1<? super Double, Double> r101, Function1<? super Double, Double> r102) {
        return r100 - (r101.invoke(Double.valueOf(r100)).doubleValue() / r102.invoke(Double.valueOf(r100)).doubleValue());
    }

    private static final double estimateCriticallyDamped(double r210, double r211, double r212, double r213) {
        double r100 = r213;
        double r101 = r210 * r211;
        double r102 = r212 - r101;
        double r103 = Math.log(Math.abs(r100 / r211)) / r210;
        double r104 = Math.log(Math.abs(r100 / r102));
        int r110 = 0;
        double r111 = r104;
        int r112 = 0;
    L4:
        if (r112 >= 6) goto L6;
        r111 = r104 - Math.log(Math.abs(r111 / r210));
        r112 = r112 + 1;
        goto L4
    L6:
        double r113 = r111 / r210;
        if ((Double.doubleToRawLongBits(r103) & Long.MAX_VALUE) >= 9218868437227405312L) goto L9;
        boolean r105 = true;
    L11:
        if ((!r105) == false) goto L14;
        r103 = r113;
    L21:
        double r106 = (-(r101 + r102)) / (r210 * r102);
        double r114 = r210 * r106;
        double r115 = (Math.exp(r114) * r211) + ((r102 * r106) * Math.exp(r114));
        if (Double.isNaN(r106) == false) goto L24;
    L36:
        r100 = -r100;
    L37:
        double r107 = Double.MAX_VALUE;
    L39:
        if (r107 <= 0.001d) goto L43;
        if (r110 >= 100) goto L43;
        r110 = r110 + 1;
        double r116 = r210 * r103;
        double r108 = r103 - ((((r211 + (r102 * r103)) * Math.exp(r116)) + r100) / ((((((double) 1) + r116) * r102) + r101) * Math.exp(r116)));
        double r109 = Math.abs(r103 - r108);
        r103 = r108;
        r107 = r109;
    L43:
        return r103;
    L24:
        if (r106 <= AudioStats.AUDIO_AMPLITUDE_NONE) goto L36;
        if (r106 > AudioStats.AUDIO_AMPLITUDE_NONE) goto L29;
    L35:
        r103 = (-(2.0d / r210)) - (r211 / r102);
        goto L37
    L29:
        if ((-r115) >= r100) goto L35;
        if (r102 >= AudioStats.AUDIO_AMPLITUDE_NONE) goto L36;
        if (r211 <= AudioStats.AUDIO_AMPLITUDE_NONE) goto L36;
        r103 = 0.0d;
        goto L36
    L14:
        if ((Double.doubleToRawLongBits(r113) & Long.MAX_VALUE) >= 9218868437227405312L) goto L16;
        boolean r117 = true;
    L18:
        if ((!r117) == true) goto L21;
        r103 = Math.max(r103, r113);
        goto L21
    L16:
        r117 = false;
        goto L18
    L9:
        r105 = false;
        goto L11
    }

    public static final long estimateAnimationDurationMillis(double r110, double r111, double r210, double r211, double r212) {
        double r100 = (2.0d * r111) * Math.sqrt(r110);
        double r101 = (r100 * r100) - (4.0d * r110);
        double r102 = AudioStats.AUDIO_AMPLITUDE_NONE;
        if (r101 >= AudioStats.AUDIO_AMPLITUDE_NONE) goto L5;
        double r103 = 0.0d;
    L6:
        if (r101 >= AudioStats.AUDIO_AMPLITUDE_NONE) goto L8;
        r102 = Math.sqrt(Math.abs(r101));
    L8:
        double r104 = -r100;
        return estimateDurationInternal((r104 + r103) * 0.5d, r102 * 0.5d, (r104 - r103) * 0.5d, r111, r210, r211, r212);
    L5:
        r103 = Math.sqrt(r101);
        goto L6
    }

    private static final double estimateOverDamped(double r210, double r211, double r212, double r310, double r311) {
        double r110 = r210 - r211;
        double r111 = ((r210 * r212) - r310) / r110;
        double r112 = r212 - r111;
        double r100 = Math.log(Math.abs(r311 / r112)) / r210;
        double r101 = Math.log(Math.abs(r311 / r111)) / r211;
        if ((Double.doubleToRawLongBits(r100) & Long.MAX_VALUE) >= 9218868437227405312L) goto L5;
        boolean r102 = true;
    L7:
        if ((!r102) == false) goto L10;
        double r113 = r101;
    L18:
        double r213 = r112 * r210;
        double r103 = Math.log(r213 / ((-r111) * r211)) / (r211 - r210);
        if (Double.isNaN(r103) == false) goto L21;
    L33:
        double r104 = -r311;
    L34:
        double r105 = r111 * r211;
        if (Math.abs((Math.exp(r210 * r113) * r213) + (Math.exp(r211 * r113) * r105)) >= 1.0E-4d) goto L37;
        return r113;
    L37:
        double r106 = Double.MAX_VALUE;
        int r107 = 0;
    L39:
        if (r106 <= 0.001d) goto L43;
        if (r107 >= 100) goto L43;
        r107 = r107 + 1;
        double r108 = r210 * r113;
        double r109 = r211 * r113;
        double r114 = r113 - ((((Math.exp(r108) * r112) + (Math.exp(r109) * r111)) + r104) / ((Math.exp(r108) * r213) + (Math.exp(r109) * r105)));
        double r115 = Math.abs(r113 - r114);
        r113 = r114;
        r106 = r115;
    L43:
        return r113;
    L21:
        if (r103 <= AudioStats.AUDIO_AMPLITUDE_NONE) goto L33;
        if (r103 > AudioStats.AUDIO_AMPLITUDE_NONE) goto L26;
    L32:
        r113 = Math.log((-((r111 * r211) * r211)) / (r213 * r210)) / r110;
        r104 = r311;
        goto L34
    L26:
        if ((-estimateOverDamped$xInflection(r112, r210, r103, r111, r211)) >= r311) goto L32;
        if (r111 <= AudioStats.AUDIO_AMPLITUDE_NONE) goto L33;
        if (r112 >= AudioStats.AUDIO_AMPLITUDE_NONE) goto L33;
        r113 = 0.0d;
        goto L33
    L10:
        if ((Double.doubleToRawLongBits(r101) & Long.MAX_VALUE) >= 9218868437227405312L) goto L12;
        boolean r116 = true;
    L14:
        if ((!r116) == true) goto L17;
        r100 = Math.max(r100, r101);
    L17:
        r113 = r100;
        goto L18
    L12:
        r116 = false;
        goto L14
    L5:
        r102 = false;
        goto L7
    }

    private static final double estimateOverDamped$xInflection(double r100, double r101, double r102, double r103, double r104) {
        return (r100 * Math.exp(r101 * r102)) + (r103 * Math.exp(r104 * r102));
    }

    private static final double estimateUnderDamped(double r100, double r101, double r102, double r103, double r110) {
        double r104 = (r103 - (r100 * r102)) / r101;
        return Math.log(r110 / Math.sqrt((r102 * r102) + (r104 * r104))) / r100;
    }

    public static final long estimateAnimationDurationMillis(float r110, float r111, float r112, float r113, float r114) {
        if (r111 != 0.0f) goto L5;
        boolean r100 = true;
    L6:
        if (r100 == false) goto L10;
        return MAX_LONG_MILLIS;
    L10:
        return estimateAnimationDurationMillis(r110, r111, r112, r113, r114);
    L5:
        r100 = false;
        goto L6
    }

    public static final long estimateAnimationDurationMillis(double r210, double r211, double r212, double r213, double r214, double r310) {
        double r110 = r211 / (Math.sqrt(r210 * r212) * 2.0d);
        double r100 = (r211 * r211) - ((4.0d * r212) * r210);
        double r101 = 1.0d / (2.0d * r212);
        double r102 = AudioStats.AUDIO_AMPLITUDE_NONE;
        if (r100 >= AudioStats.AUDIO_AMPLITUDE_NONE) goto L5;
        double r103 = 0.0d;
    L6:
        if (r100 >= AudioStats.AUDIO_AMPLITUDE_NONE) goto L8;
        r102 = Math.sqrt(Math.abs(r100));
    L8:
        double r104 = -r211;
        return estimateDurationInternal((r104 + r103) * r101, r102 * r101, (r104 - r103) * r101, r110, r213, r214, r310);
    L5:
        r103 = Math.sqrt(r100);
        goto L6
    }

    private static final long estimateDurationInternal(double r110, double r111, double r112, double r113, double r210, double r211, double r212) {
        double r100 = r210;
        boolean r101 = true;
        if (r211 != AudioStats.AUDIO_AMPLITUDE_NONE) goto L5;
        boolean r102 = true;
    L6:
        if (r102 == true) goto L8;
    L14:
        if (r211 >= AudioStats.AUDIO_AMPLITUDE_NONE) goto L16;
        r100 = -r100;
    L16:
        double r103 = Math.abs(r211);
        if (r113 <= 1.0d) goto L20;
        double r104 = estimateOverDamped(r110, r112, r103, r100, r212);
    L24:
        return (long) (r104 * 1000.0d);
    L20:
        if (r113 >= 1.0d) goto L22;
        r104 = estimateUnderDamped(r110, r111, r103, r100, r212);
        goto L24
    L22:
        r104 = estimateCriticallyDamped(r110, r103, r100, r212);
        goto L24
    L8:
        if (r100 == AudioStats.AUDIO_AMPLITUDE_NONE) goto L11;
        r101 = false;
    L11:
        if (r101 == false) goto L14;
        return 0;
    L5:
        r102 = false;
        goto L6
    }
}
