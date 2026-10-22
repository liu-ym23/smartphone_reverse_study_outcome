package androidx.compose.ui.graphics.colorspace;

import androidx.camera.video.AudioStats;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001BC\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\t\u0010 \u001a\u00020\u0003HÆ\u0003JO\u0010!\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\"\u001a\u00020\u00152\b\u0010#\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010$\u001a\u00020%HÖ\u0001J\t\u0010&\u001a\u00020'HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\rR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\rR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\rR\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\rR\u0014\u0010\u0014\u001a\u00020\u00158@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0018\u001a\u00020\u00158@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u0017¨\u0006("}, d2 = {"Landroidx/compose/ui/graphics/colorspace/TransferParameters;", "", "gamma", "", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "b", "c", "d", "e", "f", "<init>", "(DDDDDDD)V", "getGamma", "()D", "getA", "getB", "getC", "getD", "getE", "getF", "isHLGish", "", "isHLGish$ui_graphics_release", "()Z", "isPQish", "isPQish$ui_graphics_release", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "other", "hashCode", "", "toString", "", "ui-graphics_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class TransferParameters {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final double f15184a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final double f15185b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final double f15186c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final double f15187d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final double f15188e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final double f15189f;
    private final double gamma;

    public static /* synthetic */ TransferParameters copy$default(TransferParameters r110, double r111, double r112, double r210, double r211, double r212, double r213, double r214, int r310, Object r311) {
        if ((r310 & 1) == 0) goto L5;
        double r100 = r110.gamma;
    L7:
        if ((r310 & 2) == 0) goto L9;
        double r101 = r110.f15184a;
    L11:
        if ((r310 & 4) == 0) goto L13;
        double r102 = r110.f15185b;
    L15:
        if ((r310 & 8) == 0) goto L17;
        double r103 = r110.f15186c;
    L19:
        if ((r310 & 16) == 0) goto L21;
        double r104 = r110.f15187d;
    L23:
        if ((r310 & 32) == 0) goto L25;
        double r113 = r110.f15188e;
    L27:
        if ((r310 & 64) == 0) goto L29;
        double r114 = r110.f15189f;
    L31:
        return r110.copy(r100, r101, r102, r103, r104, r113, r114);
    L29:
        r114 = r214;
        goto L31
    L25:
        r113 = r213;
        goto L27
    L21:
        r104 = r212;
        goto L23
    L17:
        r103 = r211;
        goto L19
    L13:
        r102 = r210;
        goto L15
    L9:
        r101 = r112;
        goto L11
    L5:
        r100 = r111;
        goto L7
    }

    public final double component1() {
        return this.gamma;
    }

    public final double component2() {
        return this.f15184a;
    }

    public final double component3() {
        return this.f15185b;
    }

    public final double component4() {
        return this.f15186c;
    }

    public final double component5() {
        return this.f15187d;
    }

    public final double component6() {
        return this.f15188e;
    }

    public final double component7() {
        return this.f15189f;
    }

    public final TransferParameters copy(double r110, double r111, double r210, double r211, double r212, double r213, double r214) {
        return new TransferParameters(r110, r111, r210, r211, r212, r213, r214);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof TransferParameters) == true) goto L8;
        return false;
    L8:
        TransferParameters r101 = (TransferParameters) r100;
        if (Double.compare(this.gamma, r101.gamma) == 0) goto L12;
        return false;
    L12:
        if (Double.compare(this.f15184a, r101.f15184a) == 0) goto L15;
        return false;
    L15:
        if (Double.compare(this.f15185b, r101.f15185b) == 0) goto L18;
        return false;
    L18:
        if (Double.compare(this.f15186c, r101.f15186c) == 0) goto L21;
        return false;
    L21:
        if (Double.compare(this.f15187d, r101.f15187d) == 0) goto L24;
        return false;
    L24:
        if (Double.compare(this.f15188e, r101.f15188e) == 0) goto L27;
        return false;
    L27:
        if (Double.compare(this.f15189f, r101.f15189f) == 0) goto L29;
        return false;
    L29:
        return true;
    }

    public int hashCode() {
        long r100 = Double.doubleToLongBits(this.gamma);
        int r101 = ((int) (r100 ^ (r100 >>> 32))) * 31;
        long r102 = Double.doubleToLongBits(this.f15184a);
        int r103 = (r101 + ((int) (r102 ^ (r102 >>> 32)))) * 31;
        long r104 = Double.doubleToLongBits(this.f15185b);
        int r105 = (r103 + ((int) (r104 ^ (r104 >>> 32)))) * 31;
        long r106 = Double.doubleToLongBits(this.f15186c);
        int r107 = (r105 + ((int) (r106 ^ (r106 >>> 32)))) * 31;
        long r108 = Double.doubleToLongBits(this.f15187d);
        int r109 = (r107 + ((int) (r108 ^ (r108 >>> 32)))) * 31;
        long r110 = Double.doubleToLongBits(this.f15188e);
        int r111 = (r109 + ((int) (r110 ^ (r110 >>> 32)))) * 31;
        long r112 = Double.doubleToLongBits(this.f15189f);
        return r111 + ((int) (r112 ^ (r112 >>> 32)));
    }

    public String toString() {
        return "TransferParameters(gamma=" + this.gamma + ", a=" + this.f15184a + ", b=" + this.f15185b + ", c=" + this.f15186c + ", d=" + this.f15187d + ", e=" + this.f15188e + ", f=" + this.f15189f + ')';
    }

    public final boolean isHLGish$ui_graphics_release() {
        if (this.gamma != (-3.0d)) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean isPQish$ui_graphics_release() {
        if (this.gamma != (-2.0d)) goto L5;
        return true;
    L5:
        return false;
    }

    public final double getA() {
        return this.f15184a;
    }

    public final double getB() {
        return this.f15185b;
    }

    public final double getC() {
        return this.f15186c;
    }

    public final double getD() {
        return this.f15187d;
    }

    public final double getE() {
        return this.f15188e;
    }

    public final double getF() {
        return this.f15189f;
    }

    public final double getGamma() {
        return this.gamma;
    }

    public TransferParameters(double r100, double r101, double r102, double r103, double r110, double r111, double r112) {
        this.gamma = r100;
        this.f15184a = r101;
        this.f15185b = r102;
        this.f15186c = r103;
        this.f15187d = r110;
        this.f15188e = r111;
        this.f15189f = r112;
        if (Double.isNaN(r101) == true) goto L82;
        if (Double.isNaN(r102) == true) goto L82;
        if (Double.isNaN(r103) == true) goto L82;
        if (Double.isNaN(r110) == true) goto L82;
        if (Double.isNaN(r111) == true) goto L82;
        if (Double.isNaN(r112) == true) goto L82;
        if (Double.isNaN(r100) == true) goto L82;
        if (TransferParametersKt.access$isSpecialG(r100) == false) goto L19;
        return;
    L19:
        if (r110 < AudioStats.AUDIO_AMPLITUDE_NONE) goto L79;
        if (r110 > 1.0d) goto L79;
        boolean r113 = true;
        if (r110 != AudioStats.AUDIO_AMPLITUDE_NONE) goto L25;
        boolean r104 = true;
    L26:
        if (r104 == false) goto L41;
        if (r101 != AudioStats.AUDIO_AMPLITUDE_NONE) goto L30;
        boolean r105 = true;
    L31:
        if (r105 == true) goto L39;
        if (r100 != AudioStats.AUDIO_AMPLITUDE_NONE) goto L35;
        boolean r106 = true;
    L36:
        if (r106 == true) goto L39;
    L35:
        r106 = false;
    L39:
        throw new IllegalArgumentException("Parameter a or g is zero, the transfer function is constant");
    L30:
        r105 = false;
    L41:
        if (r110 < 1.0d) goto L51;
        if (r103 != AudioStats.AUDIO_AMPLITUDE_NONE) goto L45;
        boolean r114 = true;
    L46:
        if (r114 == false) goto L51;
        throw new IllegalArgumentException("Parameter c is zero, the transfer function is constant");
    L45:
        r114 = false;
    L51:
        if (r101 != AudioStats.AUDIO_AMPLITUDE_NONE) goto L53;
        boolean r115 = true;
    L54:
        if (r115 == true) goto L61;
        if (r100 != AudioStats.AUDIO_AMPLITUDE_NONE) goto L58;
        boolean r116 = true;
    L59:
        if (r116 == true) goto L61;
    L66:
        if (r103 < AudioStats.AUDIO_AMPLITUDE_NONE) goto L75;
        if (r101 < AudioStats.AUDIO_AMPLITUDE_NONE) goto L73;
        if (r100 < AudioStats.AUDIO_AMPLITUDE_NONE) goto L73;
        return;
    L73:
        throw new IllegalArgumentException("The transfer function must be positive or increasing");
    L75:
        throw new IllegalArgumentException("The transfer function must be increasing");
    L58:
        r116 = false;
    L61:
        if (r103 == AudioStats.AUDIO_AMPLITUDE_NONE) goto L64;
        r113 = false;
    L64:
        if (r113 == false) goto L66;
        throw new IllegalArgumentException("Parameter a or g is zero, and c is zero, the transfer function is constant");
    L53:
        r115 = false;
        goto L54
    L25:
        r104 = false;
    L79:
        throw new IllegalArgumentException("Parameter d must be in the range [0..1], was " + r110);
    L82:
        throw new IllegalArgumentException("Parameters cannot be NaN");
    }

    public /* synthetic */ TransferParameters(double r110, double r210, double r211, double r212, double r213, double r214, double r310, int r311, DefaultConstructorMarker r312) {
        if ((r311 & 32) == 0) goto L5;
        double r111 = 0.0d;
    L7:
        if ((r311 & 64) == 0) goto L9;
        double r112 = 0.0d;
    L10:
        this(r110, r210, r211, r212, r213, r111, r112);
        return;
    L9:
        r112 = r310;
        goto L10
    L5:
        r111 = r214;
        goto L7
    }
}
