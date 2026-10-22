package com.android.ttcjpaysdk.bdpay.security.loading.view;

import android.view.animation.PathInterpolator;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\u0014\n\u0000\n\u0002\u0010\b\n\u0002\b\u0018\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001BK\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\u000b\u0012\b\b\u0002\u0010\r\u001a\u00020\u0003¢\u0006\u0002\u0010\u000eJ\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0007HÆ\u0003J\t\u0010\u001e\u001a\u00020\tHÆ\u0003J\t\u0010\u001f\u001a\u00020\u000bHÆ\u0003J\t\u0010 \u001a\u00020\u000bHÆ\u0003J\t\u0010!\u001a\u00020\u0003HÆ\u0003JO\u0010\"\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010\r\u001a\u00020\u0003HÆ\u0001J\u0013\u0010#\u001a\u00020$2\b\u0010%\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010&\u001a\u00020\u000bHÖ\u0001J\t\u0010'\u001a\u00020(HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\r\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\f\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0019¨\u0006)"}, d2 = {"Lcom/android/ttcjpaysdk/bdpay/security/loading/view/ScanningTextConfig;", "", "animationDuration", "", "interpolator", "Landroid/view/animation/PathInterpolator;", "gradientColors", "", "gradientPositions", "", "repeatCount", "", "repeatMode", "delayTime", "(JLandroid/view/animation/PathInterpolator;[I[FIIJ)V", "getAnimationDuration", "()J", "getDelayTime", "getGradientColors", "()[I", "getGradientPositions", "()[F", "getInterpolator", "()Landroid/view/animation/PathInterpolator;", "getRepeatCount", "()I", "getRepeatMode", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "", "other", "hashCode", "toString", "", "bdpay-security-loading_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ScanningTextConfig {
    private final long animationDuration;
    private final long delayTime;
    private final int[] gradientColors;
    private final float[] gradientPositions;
    private final PathInterpolator interpolator;
    private final int repeatCount;
    private final int repeatMode;

    public ScanningTextConfig() {
        this(0, null, null, null, 0, 0, 0, 127, null);
    }

    public static /* synthetic */ ScanningTextConfig copy$default(ScanningTextConfig r110, long r111, PathInterpolator r112, int[] r113, float[] r114, int r115, int r116, long r117, int r210, Object r211) {
        if ((r210 & 1) == 0) goto L5;
        long r100 = r110.animationDuration;
    L7:
        if ((r210 & 2) == 0) goto L9;
        PathInterpolator r101 = r110.interpolator;
    L11:
        if ((r210 & 4) == 0) goto L13;
        int[] r102 = r110.gradientColors;
    L15:
        if ((r210 & 8) == 0) goto L17;
        float[] r103 = r110.gradientPositions;
    L19:
        if ((r210 & 16) == 0) goto L21;
        int r104 = r110.repeatCount;
    L23:
        if ((r210 & 32) == 0) goto L25;
        int r105 = r110.repeatMode;
    L27:
        if ((r210 & 64) == 0) goto L29;
        long r106 = r110.delayTime;
    L31:
        return r110.copy(r100, r101, r102, r103, r104, r105, r106);
    L29:
        r106 = r117;
        goto L31
    L25:
        r105 = r116;
        goto L27
    L21:
        r104 = r115;
        goto L23
    L17:
        r103 = r114;
        goto L19
    L13:
        r102 = r113;
        goto L15
    L9:
        r101 = r112;
        goto L11
    L5:
        r100 = r111;
        goto L7
    }

    public final long component1() {
        return this.animationDuration;
    }

    public final PathInterpolator component2() {
        return this.interpolator;
    }

    public final int[] component3() {
        return this.gradientColors;
    }

    public final float[] component4() {
        return this.gradientPositions;
    }

    public final int component5() {
        return this.repeatCount;
    }

    public final int component6() {
        return this.repeatMode;
    }

    public final long component7() {
        return this.delayTime;
    }

    public final ScanningTextConfig copy(long r110, PathInterpolator r111, int[] r112, float[] r113, int r114, int r115, long r116) {
        Intrinsics.checkNotNullParameter(r111, "interpolator");
        Intrinsics.checkNotNullParameter(r112, "gradientColors");
        Intrinsics.checkNotNullParameter(r113, "gradientPositions");
        return new ScanningTextConfig(r110, r111, r112, r113, r114, r115, r116);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof ScanningTextConfig) == true) goto L8;
        return false;
    L8:
        ScanningTextConfig r101 = (ScanningTextConfig) r100;
        if (this.animationDuration == r101.animationDuration) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.interpolator, r101.interpolator) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.gradientColors, r101.gradientColors) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.gradientPositions, r101.gradientPositions) == true) goto L21;
        return false;
    L21:
        if (this.repeatCount == r101.repeatCount) goto L24;
        return false;
    L24:
        if (this.repeatMode == r101.repeatMode) goto L27;
        return false;
    L27:
        if (this.delayTime == r101.delayTime) goto L29;
        return false;
    L29:
        return true;
    }

    public int hashCode() {
        long r100 = this.animationDuration;
        int r101 = ((((((((((((int) (r100 ^ (r100 >>> 32))) * 31) + this.interpolator.hashCode()) * 31) + Arrays.hashCode(this.gradientColors)) * 31) + Arrays.hashCode(this.gradientPositions)) * 31) + this.repeatCount) * 31) + this.repeatMode) * 31;
        long r102 = this.delayTime;
        return r101 + ((int) (r102 ^ (r102 >>> 32)));
    }

    public String toString() {
        return "ScanningTextConfig(animationDuration=" + this.animationDuration + ", interpolator=" + this.interpolator + ", gradientColors=" + Arrays.toString(this.gradientColors) + ", gradientPositions=" + Arrays.toString(this.gradientPositions) + ", repeatCount=" + this.repeatCount + ", repeatMode=" + this.repeatMode + ", delayTime=" + this.delayTime + ')';
    }

    public final long getAnimationDuration() {
        return this.animationDuration;
    }

    public final long getDelayTime() {
        return this.delayTime;
    }

    public final int[] getGradientColors() {
        return this.gradientColors;
    }

    public final float[] getGradientPositions() {
        return this.gradientPositions;
    }

    public final PathInterpolator getInterpolator() {
        return this.interpolator;
    }

    public final int getRepeatCount() {
        return this.repeatCount;
    }

    public final int getRepeatMode() {
        return this.repeatMode;
    }

    public ScanningTextConfig(long r100, PathInterpolator r101, int[] r102, float[] r103, int r104, int r105, long r106) {
        Intrinsics.checkNotNullParameter(r101, "interpolator");
        Intrinsics.checkNotNullParameter(r102, "gradientColors");
        Intrinsics.checkNotNullParameter(r103, "gradientPositions");
        this.animationDuration = r100;
        this.interpolator = r101;
        this.gradientColors = r102;
        this.gradientPositions = r103;
        this.repeatCount = r104;
        this.repeatMode = r105;
        this.delayTime = r106;
    }

    public /* synthetic */ ScanningTextConfig(long r110, PathInterpolator r111, int[] r112, float[] r113, int r114, int r115, long r116, int r117, DefaultConstructorMarker r210) {
        if ((r117 & 1) == 0) goto L5;
        long r100 = 1100;
    L7:
        if ((r117 & 2) == 0) goto L9;
        PathInterpolator r101 = new PathInterpolator(0.53f, 0.0f, 0.73f, 1.0f);
    L11:
        if ((r117 & 4) == 0) goto L13;
        int[] r102 = {0, -1, 0};
    L15:
        if ((r117 & 8) == 0) goto L17;
        float[] r103 = {0.0f, 0.5f, 1.0f};
    L19:
        if ((r117 & 16) == 0) goto L21;
        int r104 = -1;
    L23:
        if ((r117 & 32) == 0) goto L25;
        int r105 = 1;
    L27:
        if ((r117 & 64) == 0) goto L29;
        long r106 = 800;
    L30:
        this(r100, r101, r102, r103, r104, r105, r106);
        return;
    L29:
        r106 = r116;
        goto L30
    L25:
        r105 = r115;
        goto L27
    L21:
        r104 = r114;
        goto L23
    L17:
        r103 = r113;
        goto L19
    L13:
        r102 = r112;
        goto L15
    L9:
        r101 = r111;
        goto L11
    L5:
        r100 = r110;
        goto L7
    }
}
