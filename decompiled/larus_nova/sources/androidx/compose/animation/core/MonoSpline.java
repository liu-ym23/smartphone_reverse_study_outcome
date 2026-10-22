package androidx.compose.animation.core;

import com.amap.api.col.s.ce;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ttnet.org.chromium.base.BaseSwitches;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0014\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u0007\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0001\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ#\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00030\u00052\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0011H\u0002¢\u0006\u0002\u0010\u0013J\u0016\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u0011J \u0010\u0014\u001a\u00020\u00172\u0006\u0010\u0002\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u0011J\u0018\u0010\u001b\u001a\u00020\u00172\u0006\u0010\u0002\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\u0003H\u0002J \u0010\u001b\u001a\u00020\u00172\u0006\u0010\u0002\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u0011J\u0018\u0010\u001b\u001a\u00020\u00072\u0006\u0010\u0002\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u0011H\u0002R\u000e\u0010\n\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\fR\u0016\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\fR\u000e\u0010\u000e\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Landroidx/compose/animation/core/MonoSpline;", "", "time", "", "y", "", "periodicBias", "", "<init>", "([F[[FF)V", "timePoints", "values", "[[F", "tangents", "slopeTemp", "makeFloatArray", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "", "b", "(II)[[F", "getPos", "t", ce.f26395j, "", BaseSwitches.V, "Landroidx/compose/animation/core/AnimationVector;", "index", "getSlope", "animation-core"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class MonoSpline {
    public static final int $stable = 8;
    private final float[] slopeTemp;
    private final float[][] tangents;
    private final float[] timePoints;
    private final float[][] values;

    private final void getSlope(float r110, float[] r111) {
        int r100 = 0;
        int r101 = this.values[0].length;
        float[] r102 = this.timePoints;
        int r103 = r102.length;
        float r104 = r102[0];
        int r105 = r103 - 1;
        float r106 = r102[r105];
        if (r110 >= r104) goto L6;
        r110 = r104;
    L6:
        if (r110 > r106) goto L10;
        r106 = r110;
    L10:
        if (r111.length >= r101) goto L12;
        return;
    L12:
        int r112 = 0;
    L13:
        if (r112 >= r105) goto L20;
        float[] r107 = this.timePoints;
        int r108 = r112 + 1;
        float r109 = r107[r108];
        if (r106 <= r109) goto L16;
        r112 = r108;
        goto L13
    L16:
        float r113 = r107[r112];
        float r114 = r109 - r113;
        float r115 = (r106 - r113) / r114;
    L17:
        if (r100 >= r101) goto L24;
        float[][] r116 = this.values;
        float r117 = r116[r112][r100];
        float r118 = r116[r108][r100];
        float[][] r119 = this.tangents;
        r111[r100] = MonoSplineKt.hermiteDifferential(r114, r115, r117, r118, r119[r112][r100], r119[r108][r100]) / r114;
        r100 = r100 + 1;
        goto L17
    L24:
        return;
    }

    private final float[][] makeFloatArray(int r100, int r101) {
        float[][] r102 = new float[r100][];
        int r103 = 0;
    L3:
        if (r103 >= r100) goto L5;
        r102[r103] = new float[r101];
        r103 = r103 + 1;
        goto L3
    L5:
        return r102;
    }

    public final float getPos(float r110, int r210) {
        float[][] r100 = this.values;
        float[][] r101 = this.tangents;
        float[] r102 = this.timePoints;
        int r103 = r102.length;
        if (r110 > r102[0]) goto L5;
        int r104 = 0;
    L9:
        if (r104 == (-1)) goto L12;
        float r105 = r100[r104][r210];
        float r106 = r102[r104];
        return r105 + ((r110 - r106) * getSlope(r106, r210));
    L12:
        int r107 = r103 - 1;
        int r108 = 0;
    L13:
        if (r108 >= r107) goto L26;
        float[] r109 = this.timePoints;
        float r111 = r109[r108];
        if (r110 != r111) goto L17;
        boolean r112 = true;
    L18:
        if (r112 == true) goto L20;
        int r113 = r108 + 1;
        float r114 = r109[r113];
        if (r110 < r114) goto L23;
        r108 = r113;
        goto L13
    L23:
        float r115 = r114 - r111;
        return MonoSplineKt.hermiteInterpolate(r115, (r110 - r111) / r115, r100[r108][r210], r100[r113][r210], r101[r108][r210], r101[r113][r210]);
    L20:
        return r100[r108][r210];
    L17:
        r112 = false;
        goto L18
    L26:
        return 0.0f;
    L5:
        r104 = r103 - 1;
        if (r110 >= r102[r104]) goto L9;
        r104 = -1;
        goto L9
    }

    private final float getSlope(float r110, int r111) {
        float[] r100 = this.timePoints;
        float[][] r101 = this.values;
        float[][] r102 = this.tangents;
        int r103 = r100.length;
        int r104 = 0;
        float r105 = r100[0];
        int r106 = r103 - 1;
        float r107 = r100[r106];
        if (r110 >= r105) goto L6;
        r110 = r105;
    L6:
        if (r110 > r107) goto L9;
        r107 = r110;
    L9:
        if (r104 >= r106) goto L15;
        int r112 = r104 + 1;
        float r108 = r100[r112];
        if (r107 <= r108) goto L12;
        r104 = r112;
        goto L9
    L12:
        float r109 = r101[r104][r111];
        float r113 = r101[r112][r111];
        float r114 = r102[r104][r111];
        float r115 = r102[r112][r111];
        float r116 = r100[r104];
        float r117 = r108 - r116;
        return MonoSplineKt.hermiteDifferential(r117, (r107 - r116) / r117, r109, r113, r114, r115) / r117;
    L15:
        return 0.0f;
    }

    public MonoSpline(float[] r110, float[][] r210, float r211) {
        int r100 = r110.length;
        int r101 = r210[0].length;
        this.slopeTemp = new float[r101];
        int r102 = r100 - 1;
        float[][] r103 = makeFloatArray(r102, r101);
        float[][] r104 = makeFloatArray(r100, r101);
        int r105 = 0;
    L3:
        if (r105 >= r101) goto L13;
        int r111 = 0;
    L5:
        if (r111 >= r102) goto L11;
        int r112 = r111 + 1;
        float r113 = r110[r112] - r110[r111];
        float[] r114 = r103[r111];
        float r115 = (r210[r112][r105] - r210[r111][r105]) / r113;
        r114[r105] = r115;
        if (r111 != 0) goto L9;
        r104[r111][r105] = r115;
    L10:
        r111 = r112;
        goto L5
    L9:
        r104[r111][r105] = (r103[r111 - 1][r105] + r115) * 0.5f;
        goto L10
    L11:
        r104[r102][r105] = r103[r100 - 2][r105];
        r105 = r105 + 1;
        goto L3
    L13:
        if (Float.isNaN(r211) == true) goto L17;
        int r106 = 0;
    L15:
        if (r106 >= r101) goto L17;
        float[] r116 = r103[r100 - 2];
        float r117 = r116[r106] * (1 - r211);
        float[] r118 = r103[0];
        float r119 = r117 + (r118[r106] * r211);
        r118[r106] = r119;
        r116[r106] = r119;
        r104[r102][r106] = r119;
        r104[0][r106] = r119;
        r106 = r106 + 1;
    L17:
        int r107 = 0;
    L18:
        if (r107 >= r102) goto L32;
        int r108 = 0;
    L20:
        if (r108 >= r101) goto L31;
        float r120 = r103[r107][r108];
        if (r120 != 0.0f) goto L24;
        boolean r121 = true;
    L25:
        if (r121 == false) goto L27;
        r104[r107][r108] = 0.0f;
        r104[r107 + 1][r108] = 0.0f;
        int r122 = r101;
    L30:
        r108 = r108 + 1;
        r101 = r122;
        goto L20
    L27:
        float r123 = r104[r107][r108] / r120;
        int r124 = r107 + 1;
        float r125 = r104[r124][r108] / r120;
        r122 = r101;
        float r109 = (float) Math.hypot(r123, r125);
        if (r109 <= 9.0d) goto L30;
        float r126 = 3.0f / r109;
        float[] r127 = r104[r107];
        float[] r128 = r103[r107];
        r127[r108] = (r123 * r126) * r128[r108];
        r104[r124][r108] = (r126 * r125) * r128[r108];
        goto L30
    L24:
        r121 = false;
        goto L25
    L31:
        r107 = r107 + 1;
        goto L18
    L32:
        this.timePoints = r110;
        this.values = r210;
        this.tangents = r104;
    }

    public final void getPos(float r110, AnimationVector r111, int r210) {
        float[] r100 = this.timePoints;
        int r101 = r100.length;
        int r102 = 0;
        int r103 = this.values[0].length;
        if (r110 > r100[0]) goto L5;
        int r104 = 0;
    L9:
        if (r104 == (-1)) goto L14;
        getSlope(r100[r104], this.slopeTemp);
    L11:
        if (r102 >= r103) goto L13;
        r111.set$animation_core(r102, this.values[r104][r102] + ((r110 - this.timePoints[r104]) * this.slopeTemp[r102]));
        r102 = r102 + 1;
        goto L11
    L13:
        return;
    L14:
        int r105 = r101 - 1;
        int r106 = r210;
    L15:
        if (r106 >= r105) goto L31;
        float[] r107 = this.timePoints;
        float r108 = r107[r106];
        if (r110 != r108) goto L19;
        boolean r109 = true;
    L20:
        if (r109 == true) goto L21;
        int r112 = r106 + 1;
        float r113 = r107[r112];
        if (r110 < r113) goto L26;
        r106 = r112;
        goto L15
    L26:
        float r114 = r113 - r108;
        float r115 = (r110 - r108) / r114;
    L27:
        if (r102 >= r103) goto L29;
        float[][] r116 = this.values;
        float r117 = r116[r106][r102];
        float r118 = r116[r112][r102];
        float[][] r119 = this.tangents;
        r111.set$animation_core(r102, MonoSplineKt.hermiteInterpolate(r114, r115, r117, r118, r119[r106][r102], r119[r112][r102]));
        r102 = r102 + 1;
        goto L27
    L29:
        return;
    L21:
        if (r102 >= r103) goto L23;
        r111.set$animation_core(r102, this.values[r106][r102]);
        r102 = r102 + 1;
        goto L21
    L23:
        return;
    L19:
        r109 = false;
        goto L20
    L31:
        return;
    L5:
        r104 = r101 - 1;
        if (r110 >= r100[r104]) goto L9;
        r104 = -1;
        goto L9
    }

    public final void getSlope(float r110, AnimationVector r111, int r210) {
        float[] r100 = this.timePoints;
        float[][] r101 = this.values;
        float[][] r102 = this.tangents;
        int r103 = r100.length;
        int r104 = 0;
        int r105 = r101[0].length;
        if (r110 > r100[0]) goto L5;
        int r106 = 0;
    L9:
        if (r106 == (-1)) goto L16;
        float[] r107 = r102[r106];
        if (r107.length >= r105) goto L13;
        return;
    L13:
        if (r104 >= r105) goto L15;
        r111.set$animation_core(r104, r107[r104]);
        r104 = r104 + 1;
        goto L13
    L15:
        return;
    L16:
        int r108 = r103 - 1;
        int r109 = r210;
    L17:
        if (r109 >= r108) goto L24;
        int r112 = r109 + 1;
        float r113 = r100[r112];
        if (r110 <= r113) goto L20;
        r109 = r112;
        goto L17
    L20:
        float r114 = r100[r109];
        float r115 = r113 - r114;
        float r116 = (r110 - r114) / r115;
    L21:
        if (r104 >= r105) goto L29;
        r111.set$animation_core(r104, MonoSplineKt.hermiteDifferential(r115, r116, r101[r109][r104], r101[r112][r104], r102[r109][r104], r102[r112][r104]) / r115);
        r104 = r104 + 1;
        goto L21
    L29:
        return;
    L24:
        return;
    L5:
        r106 = r103 - 1;
        if (r110 >= r100[r106]) goto L9;
        r106 = -1;
        goto L9
    }

    public static /* synthetic */ void getPos$default(MonoSpline r100, float r101, AnimationVector r102, int r103, int r104, Object r105) {
        if ((r104 & 4) == 0) goto L5;
        r103 = 0;
    L5:
        r100.getPos(r101, r102, r103);
    }

    public static /* synthetic */ void getSlope$default(MonoSpline r100, float r101, AnimationVector r102, int r103, int r104, Object r105) {
        if ((r104 & 4) == 0) goto L5;
        r103 = 0;
    L5:
        r100.getSlope(r101, r102, r103);
    }
}
