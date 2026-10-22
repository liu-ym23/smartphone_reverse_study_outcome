package androidx.compose.animation.core;

import androidx.compose.ui.graphics.BezierKt;
import com.bytedance.ee.bear.bitable.fieldedit.BitableFieldEditAnalytic;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import org.bouncycastle.asn1.cmc.BodyPartID;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\n\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0007\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u0003H\u0016J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\f\u001a\u00020\u0003H\u0002J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0096\u0002J\b\u0010\u0013\u001a\u00020\u0014H\u0016J\b\u0010\u0015\u001a\u00020\u0016H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Landroidx/compose/animation/core/CubicBezierEasing;", "Landroidx/compose/animation/core/Easing;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "", "b", "c", "d", "<init>", "(FFFF)V", BitableFieldEditAnalytic.ProgressFieldEditScene.MIN, BitableFieldEditAnalytic.ProgressFieldEditScene.MAX, "transform", "fraction", "throwNoSolution", "", "equals", "", "other", "", "hashCode", "", "toString", "", "animation-core"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class CubicBezierEasing implements Easing {
    public static final int $stable = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final float f5652a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final float f5653b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final float f5654c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final float f5655d;
    private final float max;
    private final float min;

    public int hashCode() {
        return (((((Float.floatToIntBits(this.f5652a) * 31) + Float.floatToIntBits(this.f5653b)) * 31) + Float.floatToIntBits(this.f5654c)) * 31) + Float.floatToIntBits(this.f5655d);
    }

    public String toString() {
        return "CubicBezierEasing(a=" + this.f5652a + ", b=" + this.f5653b + ", c=" + this.f5654c + ", d=" + this.f5655d + ')';
    }

    private final void throwNoSolution(float r100) {
        throw new IllegalArgumentException("The cubic curve with parameters (" + this.f5652a + ", " + this.f5653b + ", " + this.f5654c + ", " + this.f5655d + ") has no solution at " + r100);
    }

    public boolean equals(Object r100) {
        if ((r100 instanceof CubicBezierEasing) == false) goto L26;
        CubicBezierEasing r101 = (CubicBezierEasing) r100;
        if (this.f5652a != r101.f5652a) goto L7;
        boolean r102 = true;
    L8:
        if (r102 == true) goto L10;
        return false;
    L10:
        if (this.f5653b != r101.f5653b) goto L12;
        boolean r103 = true;
    L13:
        if (r103 == true) goto L15;
        return false;
    L15:
        if (this.f5654c != r101.f5654c) goto L17;
        boolean r104 = true;
    L18:
        if (r104 == true) goto L20;
        return false;
    L20:
        if (this.f5655d != r101.f5655d) goto L22;
        boolean r105 = true;
    L23:
        if (r105 == false) goto L30;
        return true;
    L30:
        return false;
    L22:
        r105 = false;
        goto L23
    L17:
        r104 = false;
        goto L18
    L12:
        r103 = false;
        goto L13
    L7:
        r102 = false;
        goto L8
    L26:
        return false;
    }

    @Override // androidx.compose.animation.core.Easing
    public float transform(float r100) {
        if (r100 > 0.0f) goto L5;
        return r100;
    L5:
        if (r100 >= 1.0f) goto L17;
        float r101 = Math.max(r100, 1.1920929E-7f);
        float r102 = BezierKt.findFirstCubicRoot(0.0f - r101, this.f5652a - r101, this.f5654c - r101, 1.0f - r101);
        if (Float.isNaN(r102) == false) goto L9;
        throwNoSolution(r100);
    L9:
        float r103 = BezierKt.evaluateCubic(this.f5653b, this.f5655d, r102);
        float r104 = this.min;
        float r105 = this.max;
        if (r103 >= r104) goto L13;
        r103 = r104;
    L13:
        if (r103 > r105) goto L15;
        return r103;
    L15:
        return r105;
    L17:
        return r100;
    }

    public CubicBezierEasing(float r100, float r101, float r102, float r110) {
        this.f5652a = r100;
        this.f5653b = r101;
        this.f5654c = r102;
        this.f5655d = r110;
        if (Float.isNaN(r100) == false) goto L5;
    L11:
        boolean r103 = false;
    L12:
        if (r103 == true) goto L14;
        PreconditionsKt.throwIllegalArgumentException("Parameters to CubicBezierEasing cannot be NaN. Actual parameters are: " + r100 + ", " + r101 + ", " + r102 + ", " + r110 + '.');
    L14:
        long r104 = BezierKt.computeCubicVerticalBounds(0.0f, r101, r110, 1.0f, new float[5], 0);
        this.min = Float.intBitsToFloat((int) (r104 >> 32));
        this.max = Float.intBitsToFloat((int) (r104 & BodyPartID.bodyIdMax));
        return;
    L5:
        if (Float.isNaN(r101) == true) goto L11;
        if (Float.isNaN(r102) == true) goto L11;
        if (Float.isNaN(r110) == true) goto L11;
        r103 = true;
        goto L12
    }
}
