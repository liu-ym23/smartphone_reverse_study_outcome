package com.android.ttcjpaysdk.base.ui.anim;

import android.graphics.PointF;
import com.ss.android.downloadlib.addownload.AdQuickAppManager;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u001f\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001Bi\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\b\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\u000b\u0012\b\b\u0002\u0010\r\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u000b\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0006¢\u0006\u0002\u0010\u0010J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\t\u0010 \u001a\u00020\u0006HÆ\u0003J\t\u0010!\u001a\u00020\u0003HÆ\u0003J\t\u0010\"\u001a\u00020\u0006HÆ\u0003J\t\u0010#\u001a\u00020\bHÆ\u0003J\t\u0010$\u001a\u00020\bHÆ\u0003J\t\u0010%\u001a\u00020\u000bHÆ\u0003J\t\u0010&\u001a\u00020\u000bHÆ\u0003J\t\u0010'\u001a\u00020\u0003HÆ\u0003J\t\u0010(\u001a\u00020\u000bHÆ\u0003Jm\u0010)\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010\r\u001a\u00020\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u000b2\b\b\u0002\u0010\u000f\u001a\u00020\u0006HÆ\u0001J\u0013\u0010*\u001a\u00020+2\b\u0010,\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010-\u001a\u00020\u0006HÖ\u0001J\t\u0010.\u001a\u00020/HÖ\u0001R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\r\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0014R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\t\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0019R\u0011\u0010\u000e\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0017R\u0011\u0010\u000f\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0012R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0014R\u0011\u0010\f\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0017¨\u00060"}, d2 = {"Lcom/android/ttcjpaysdk/base/ui/anim/CJPaySweepLightConfig;", "", "sideAlpha", "", "centerAlpha", "baseColor", "", "gradientStartPoint", "Landroid/graphics/PointF;", "gradientEndPoint", "duration", "", "startDelay", "cornerRadius", "repeatInterval", "runningTimes", "(FFILandroid/graphics/PointF;Landroid/graphics/PointF;JJFJI)V", "getBaseColor", "()I", "getCenterAlpha", "()F", "getCornerRadius", "getDuration", "()J", "getGradientEndPoint", "()Landroid/graphics/PointF;", "getGradientStartPoint", "getRepeatInterval", "getRunningTimes", "getSideAlpha", "getStartDelay", "component1", "component10", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "hashCode", "toString", "", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CJPaySweepLightConfig {
    private final int baseColor;
    private final float centerAlpha;
    private final float cornerRadius;
    private final long duration;
    private final PointF gradientEndPoint;
    private final PointF gradientStartPoint;
    private final long repeatInterval;
    private final int runningTimes;
    private final float sideAlpha;
    private final long startDelay;

    public CJPaySweepLightConfig() {
        this(0.0f, 0.0f, 0, null, null, 0, 0, 0.0f, 0, 0, 1023, null);
    }

    public static /* synthetic */ CJPaySweepLightConfig copy$default(CJPaySweepLightConfig r110, float r111, float r112, int r113, PointF r114, PointF r115, long r210, long r211, float r212, long r213, int r214, int r215, Object r216) {
        if ((r215 & 1) == 0) goto L5;
        float r100 = r110.sideAlpha;
    L7:
        if ((r215 & 2) == 0) goto L9;
        float r101 = r110.centerAlpha;
    L11:
        if ((r215 & 4) == 0) goto L13;
        int r102 = r110.baseColor;
    L15:
        if ((r215 & 8) == 0) goto L17;
        PointF r103 = r110.gradientStartPoint;
    L19:
        if ((r215 & 16) == 0) goto L21;
        PointF r104 = r110.gradientEndPoint;
    L23:
        if ((r215 & 32) == 0) goto L25;
        long r105 = r110.duration;
    L27:
        if ((r215 & 64) == 0) goto L29;
        long r106 = r110.startDelay;
    L31:
        if ((r215 & 128) == 0) goto L33;
        float r116 = r110.cornerRadius;
    L35:
        if ((r215 & 256) == 0) goto L37;
        long r117 = r110.repeatInterval;
    L39:
        if ((r215 & 512) == 0) goto L41;
        int r107 = r110.runningTimes;
    L43:
        return r110.copy(r100, r101, r102, r103, r104, r105, r106, r116, r117, r107);
    L41:
        r107 = r214;
        goto L43
    L37:
        r117 = r213;
        goto L39
    L33:
        r116 = r212;
        goto L35
    L29:
        r106 = r211;
        goto L31
    L25:
        r105 = r210;
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

    public final float component1() {
        return this.sideAlpha;
    }

    public final int component10() {
        return this.runningTimes;
    }

    public final float component2() {
        return this.centerAlpha;
    }

    public final int component3() {
        return this.baseColor;
    }

    public final PointF component4() {
        return this.gradientStartPoint;
    }

    public final PointF component5() {
        return this.gradientEndPoint;
    }

    public final long component6() {
        return this.duration;
    }

    public final long component7() {
        return this.startDelay;
    }

    public final float component8() {
        return this.cornerRadius;
    }

    public final long component9() {
        return this.repeatInterval;
    }

    public final CJPaySweepLightConfig copy(float r110, float r111, int r112, PointF r113, PointF r210, long r211, long r212, float r213, long r214, int r215) {
        Intrinsics.checkNotNullParameter(r113, "gradientStartPoint");
        Intrinsics.checkNotNullParameter(r210, "gradientEndPoint");
        return new CJPaySweepLightConfig(r110, r111, r112, r113, r210, r211, r212, r213, r214, r215);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof CJPaySweepLightConfig) == true) goto L8;
        return false;
    L8:
        CJPaySweepLightConfig r101 = (CJPaySweepLightConfig) r100;
        if (Float.compare(this.sideAlpha, r101.sideAlpha) == 0) goto L12;
        return false;
    L12:
        if (Float.compare(this.centerAlpha, r101.centerAlpha) == 0) goto L15;
        return false;
    L15:
        if (this.baseColor == r101.baseColor) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.gradientStartPoint, r101.gradientStartPoint) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.gradientEndPoint, r101.gradientEndPoint) == true) goto L24;
        return false;
    L24:
        if (this.duration == r101.duration) goto L27;
        return false;
    L27:
        if (this.startDelay == r101.startDelay) goto L30;
        return false;
    L30:
        if (Float.compare(this.cornerRadius, r101.cornerRadius) == 0) goto L33;
        return false;
    L33:
        if (this.repeatInterval == r101.repeatInterval) goto L36;
        return false;
    L36:
        if (this.runningTimes == r101.runningTimes) goto L38;
        return false;
    L38:
        return true;
    }

    public int hashCode() {
        int r100 = ((((((((Float.floatToIntBits(this.sideAlpha) * 31) + Float.floatToIntBits(this.centerAlpha)) * 31) + this.baseColor) * 31) + this.gradientStartPoint.hashCode()) * 31) + this.gradientEndPoint.hashCode()) * 31;
        long r101 = this.duration;
        int r102 = (r100 + ((int) (r101 ^ (r101 >>> 32)))) * 31;
        long r103 = this.startDelay;
        int r104 = (((r102 + ((int) (r103 ^ (r103 >>> 32)))) * 31) + Float.floatToIntBits(this.cornerRadius)) * 31;
        long r105 = this.repeatInterval;
        return ((r104 + ((int) (r105 ^ (r105 >>> 32)))) * 31) + this.runningTimes;
    }

    public String toString() {
        return "CJPaySweepLightConfig(sideAlpha=" + this.sideAlpha + ", centerAlpha=" + this.centerAlpha + ", baseColor=" + this.baseColor + ", gradientStartPoint=" + this.gradientStartPoint + ", gradientEndPoint=" + this.gradientEndPoint + ", duration=" + this.duration + ", startDelay=" + this.startDelay + ", cornerRadius=" + this.cornerRadius + ", repeatInterval=" + this.repeatInterval + ", runningTimes=" + this.runningTimes + ')';
    }

    public final int getBaseColor() {
        return this.baseColor;
    }

    public final float getCenterAlpha() {
        return this.centerAlpha;
    }

    public final float getCornerRadius() {
        return this.cornerRadius;
    }

    public final long getDuration() {
        return this.duration;
    }

    public final PointF getGradientEndPoint() {
        return this.gradientEndPoint;
    }

    public final PointF getGradientStartPoint() {
        return this.gradientStartPoint;
    }

    public final long getRepeatInterval() {
        return this.repeatInterval;
    }

    public final int getRunningTimes() {
        return this.runningTimes;
    }

    public final float getSideAlpha() {
        return this.sideAlpha;
    }

    public final long getStartDelay() {
        return this.startDelay;
    }

    public CJPaySweepLightConfig(float r100, float r101, int r102, PointF r103, PointF r104, long r105, long r106, float r110, long r111, int r112) {
        Intrinsics.checkNotNullParameter(r103, "gradientStartPoint");
        Intrinsics.checkNotNullParameter(r104, "gradientEndPoint");
        this.sideAlpha = r100;
        this.centerAlpha = r101;
        this.baseColor = r102;
        this.gradientStartPoint = r103;
        this.gradientEndPoint = r104;
        this.duration = r105;
        this.startDelay = r106;
        this.cornerRadius = r110;
        this.repeatInterval = r111;
        this.runningTimes = r112;
    }

    public /* synthetic */ CJPaySweepLightConfig(float r110, float r111, int r112, PointF r113, PointF r114, long r210, long r211, float r212, long r213, int r214, int r215, DefaultConstructorMarker r216) {
        if ((r215 & 1) == 0) goto L5;
        float r100 = 0.08f;
    L7:
        if ((r215 & 2) == 0) goto L9;
        float r101 = 0.35f;
    L11:
        if ((r215 & 4) == 0) goto L13;
        int r102 = -1;
    L14:
        float r103 = 0.0f;
        if ((r215 & 8) == 0) goto L17;
        PointF r104 = new PointF(0.0f, 0.2f);
    L19:
        if ((r215 & 16) == 0) goto L21;
        PointF r105 = new PointF(1.0f, 0.2f);
    L23:
        if ((r215 & 32) == 0) goto L25;
        long r106 = AdQuickAppManager.DEFAULT_QUICK_APP_CHECK_TIME;
    L26:
        long r115 = 0;
        if ((r215 & 64) == 0) goto L29;
        long r116 = 0;
    L31:
        if ((r215 & 128) != 0) goto L35;
        r103 = r212;
    L35:
        if ((r215 & 256) != 0) goto L39;
        r115 = r213;
    L39:
        if ((r215 & 512) == 0) goto L41;
        int r107 = 1;
    L42:
        this(r100, r101, r102, r104, r105, r106, r116, r103, r115, r107);
        return;
    L41:
        r107 = r214;
        goto L42
    L29:
        r116 = r211;
        goto L31
    L25:
        r106 = r210;
        goto L26
    L21:
        r105 = r114;
        goto L23
    L17:
        r104 = r113;
        goto L19
    L13:
        r102 = r112;
        goto L14
    L9:
        r101 = r111;
        goto L11
    L5:
        r100 = r110;
        goto L7
    }
}
