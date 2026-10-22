package androidx.compose.animation.core;

import com.ttnet.org.chromium.base.BaseSwitches;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\u0014\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\b\u0001\u0018\u00002\u00020\u0001:\u0001\u0015B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0007¢\u0006\u0004\b\b\u0010\tJ\u0016\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0005J\u0016\u0010\u0014\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0005R\u001c\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\u00070\u0007X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\fR\u000e\u0010\r\u001a\u00020\u000eX\u0082D¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Landroidx/compose/animation/core/ArcSpline;", "", "arcModes", "", "timePoints", "", "y", "", "<init>", "([I[F[[F)V", "arcs", "Landroidx/compose/animation/core/ArcSpline$Arc;", "[[Landroidx/compose/animation/core/ArcSpline$Arc;", "isExtrapolate", "", "getPos", "", "time", "", BaseSwitches.V, "getSlope", "Arc", "animation-core"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ArcSpline {
    public static final int $stable = 8;
    private final Arc[][] arcs;
    private final boolean isExtrapolate;

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u000e\n\u0002\u0010\u0014\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\r\b\u0007\u0018\u00002\u00020\u0001BA\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\u0006\u0010\t\u001a\u00020\u0005\u0012\u0006\u0010\n\u001a\u00020\u0005¢\u0006\u0004\b\u000b\u0010\fJ\u000e\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\u0005J\u0011\u0010%\u001a\u00020\u00052\u0006\u0010$\u001a\u00020\u0005H\u0082\bJ\t\u0010&\u001a\u00020\u0005H\u0086\bJ\t\u0010'\u001a\u00020\u0005H\u0086\bJ\u0006\u0010(\u001a\u00020\u0005J\u0006\u0010)\u001a\u00020\u0005J\u000e\u0010*\u001a\u00020\u00052\u0006\u0010$\u001a\u00020\u0005J\u000e\u0010+\u001a\u00020\u00052\u0006\u0010$\u001a\u00020\u0005J\u0010\u0010,\u001a\u00020\u00052\u0006\u0010-\u001a\u00020\u0005H\u0002J-\u0010.\u001a\u00020#2\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u0005H\u0000¢\u0006\u0002\b/R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u000e\u0010\u0007\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u00020\u00058\u0000X\u0081\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u00020\u00058\u0000X\u0081\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u00020\u001b8\u0000X\u0081\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001c\u001a\u00020\u00058\u0000X\u0081\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001d\u001a\u00020\u00058\u0000X\u0081\u0004¢\u0006\u0002\n\u0000R\u0015\u0010\u001e\u001a\u00020\u00058À\u0002X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u001f\u0010\u000eR\u0015\u0010 \u001a\u00020\u00058À\u0002X\u0080\u0004¢\u0006\u0006\u001a\u0004\b!\u0010\u000e¨\u00060"}, d2 = {"Landroidx/compose/animation/core/ArcSpline$Arc;", "", "mode", "", "time1", "", "time2", "x1", "y1", "x2", "y2", "<init>", "(IFFFFFF)V", "getTime1", "()F", "getTime2", "arcDistance", "tmpSinAngle", "tmpCosAngle", "lut", "", "oneOverDeltaTime", "arcVelocity", "vertical", "ellipseA", "ellipseB", "isLinear", "", "ellipseCenterX", "ellipseCenterY", "linearDX", "getLinearDX$animation_core", "linearDY", "getLinearDY$animation_core", "setPoint", "", "time", "calcAngle", "calcX", "calcY", "calcDX", "calcDY", "getLinearX", "getLinearY", "lookup", BaseSwitches.V, "buildTable", "buildTable$animation_core", "animation-core"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Arc {
        public static final int $stable = 8;
        private float arcDistance;
        private final float arcVelocity;
        public final float ellipseA;
        public final float ellipseB;
        public final float ellipseCenterX;
        public final float ellipseCenterY;
        public final boolean isLinear;
        private final float[] lut;
        private final float oneOverDeltaTime;
        private final float time1;
        private final float time2;
        private float tmpCosAngle;
        private float tmpSinAngle;
        private final float vertical;

        /* JADX INFO: renamed from: x1, reason: collision with root package name */
        private final float f5648x1;

        /* JADX INFO: renamed from: x2, reason: collision with root package name */
        private final float f5649x2;

        /* JADX INFO: renamed from: y1, reason: collision with root package name */
        private final float f5650y1;

        /* JADX INFO: renamed from: y2, reason: collision with root package name */
        private final float f5651y2;

        public final float calcDX() {
            float r100 = this.ellipseA * this.tmpCosAngle;
            return (r100 * this.vertical) * (this.arcVelocity / ((float) Math.hypot(r100, (-this.ellipseB) * this.tmpSinAngle)));
        }

        public final float calcDY() {
            float r100 = this.ellipseA * this.tmpCosAngle;
            float r101 = (-this.ellipseB) * this.tmpSinAngle;
            return (r101 * this.vertical) * (this.arcVelocity / ((float) Math.hypot(r100, r101)));
        }

        public final float calcX() {
            return this.ellipseCenterX + (this.ellipseA * access$getTmpSinAngle$p(this));
        }

        public final float calcY() {
            return this.ellipseCenterY + (this.ellipseB * access$getTmpCosAngle$p(this));
        }

        public final float getLinearDX$animation_core() {
            return this.ellipseCenterX;
        }

        public final float getLinearDY$animation_core() {
            return this.ellipseCenterY;
        }

        public final float getTime1() {
            return this.time1;
        }

        public final float getTime2() {
            return this.time2;
        }

        public static final /* synthetic */ float access$getTmpCosAngle$p(Arc r100) {
            return r100.tmpCosAngle;
        }

        public static final /* synthetic */ float access$getTmpSinAngle$p(Arc r100) {
            return r100.tmpSinAngle;
        }

        private final float calcAngle(float r100) {
            if (this.vertical != (-1.0f)) goto L5;
            boolean r101 = true;
        L6:
            if (r101 == false) goto L8;
            float r102 = this.time2 - r100;
        L10:
            return lookup(r102 * this.oneOverDeltaTime) * 1.5707964f;
        L8:
            r102 = r100 - this.time1;
            goto L10
        L5:
            r101 = false;
            goto L6
        }

        private final float lookup(float r100) {
            if (r100 > 0.0f) goto L6;
            return 0.0f;
        L6:
            if (r100 < 1.0f) goto L8;
            return 1.0f;
        L8:
            float r101 = r100 * 100;
            int r102 = (int) r101;
            float r103 = r101 - r102;
            float[] r104 = this.lut;
            float r105 = r104[r102];
            return r105 + (r103 * (r104[r102 + 1] - r105));
        }

        public final float getLinearX(float r100) {
            float r101 = (r100 - this.time1) * this.oneOverDeltaTime;
            float r102 = this.f5648x1;
            return r102 + (r101 * (this.f5649x2 - r102));
        }

        public final float getLinearY(float r100) {
            float r101 = (r100 - this.time1) * this.oneOverDeltaTime;
            float r102 = this.f5650y1;
            return r102 + (r101 * (this.f5651y2 - r102));
        }

        public final void setPoint(float r100) {
            if (this.vertical != (-1.0f)) goto L5;
            boolean r101 = true;
        L6:
            if (r101 == false) goto L8;
            float r102 = this.time2 - r100;
        L9:
            double r103 = lookup(r102 * this.oneOverDeltaTime) * 1.5707964f;
            this.tmpSinAngle = (float) Math.sin(r103);
            this.tmpCosAngle = (float) Math.cos(r103);
            return;
        L8:
            r102 = r100 - this.time1;
            goto L9
        L5:
            r101 = false;
            goto L6
        }

        public final void buildTable$animation_core(float r110, float r111, float r112, float r210) {
            float r100 = r112 - r110;
            float r101 = r111 - r210;
            float[] r102 = ArcSplineKt.access$getOurPercentCache$p();
            int r103 = r102.length - 1;
            float r113 = r103;
            float[] r114 = this.lut;
            if (1 > r103) goto L8;
            float r104 = r101;
            int r105 = 1;
            float r106 = 0.0f;
            float r107 = 0.0f;
        L5:
            float r115 = r113;
            double r116 = (float) Math.toRadians((((double) r105) * 90.0d) / ((double) r103));
            float r108 = ((float) Math.sin(r116)) * r100;
            float r117 = ((float) Math.cos(r116)) * r101;
            r106 = r106 + ((float) Math.hypot(r108 - r107, r117 - r104));
            r102[r105] = r106;
            if (r105 == r103) goto L9;
            r105 = r105 + 1;
            r113 = r115;
            r107 = r108;
            r104 = r117;
        L9:
            this.arcDistance = r106;
            if (1 > r103) goto L15;
            int r109 = 1;
        L12:
            r102[r109] = r102[r109] / r106;
            if (r109 == r103) goto L15;
            r109 = r109 + 1;
        L15:
            int r118 = r114.length;
            int r119 = 0;
        L16:
            if (r119 >= r118) goto L26;
            float r120 = r119 / 100.0f;
            int r121 = ArraysKt.binarySearch$default(r102, r120, 0, 0, 6, null);
            if (r121 < 0) goto L22;
            r114[r119] = r121 / r115;
        L25:
            r119 = r119 + 1;
            goto L16
        L22:
            if (r121 != (-1)) goto L24;
            r114[r119] = 0.0f;
            goto L25
        L24:
            int r122 = -r121;
            int r123 = r122 - 2;
            float r124 = r123;
            float r125 = r102[r123];
            r114[r119] = (r124 + ((r120 - r125) / (r102[r122 - 1] - r125))) / r115;
            goto L25
        L26:
            return;
        L8:
            r115 = r113;
            r106 = 0.0f;
            goto L9
        }

        public Arc(int r100, float r101, float r110, float r111, float r112, float r113, float r114) {
            this.time1 = r101;
            this.time2 = r110;
            this.f5648x1 = r111;
            this.f5650y1 = r112;
            this.f5649x2 = r113;
            this.f5651y2 = r114;
            float r102 = r113 - r111;
            float r103 = r114 - r112;
            boolean r104 = false;
            boolean r105 = true;
            if (r100 != 1) goto L5;
        L14:
            boolean r106 = true;
        L15:
            if (r106 == false) goto L17;
            float r107 = -1.0f;
        L18:
            this.vertical = r107;
            float r108 = 1 / (r110 - r101);
            this.oneOverDeltaTime = r108;
            this.lut = new float[101];
            if (r100 != 3) goto L21;
            r104 = true;
        L21:
            if (r104 == false) goto L23;
        L36:
            float r109 = (float) Math.hypot(r103, r102);
            this.arcDistance = r109;
            this.arcVelocity = r109 * r108;
            this.ellipseCenterX = r102 * r108;
            this.ellipseCenterY = r103 * r108;
            this.ellipseA = Float.NaN;
            this.ellipseB = Float.NaN;
        L37:
            this.isLinear = r105;
            return;
        L23:
            if (Math.abs(r102) < 0.001f) goto L36;
            if (Math.abs(r103) < 0.001f) goto L36;
            this.ellipseA = r102 * r107;
            this.ellipseB = r103 * (-r107);
            if (r106 == false) goto L30;
            float r115 = r113;
        L31:
            this.ellipseCenterX = r115;
            if (r106 == false) goto L34;
            float r116 = r112;
        L35:
            this.ellipseCenterY = r116;
            buildTable$animation_core(r111, r112, r113, r114);
            this.arcVelocity = this.arcDistance * r108;
            r105 = r104;
            goto L37
        L34:
            r116 = r114;
            goto L35
        L30:
            r115 = r111;
            goto L31
        L17:
            r107 = 1.0f;
            goto L18
        L5:
            if (r100 == 4) goto L13;
            if (r100 == 5) goto L10;
        L8:
            r106 = false;
            goto L15
        L10:
            if (r103 >= 0.0f) goto L8;
        L13:
            if (r103 <= 0.0f) goto L8;
            goto L8
        }
    }

    public final void getPos(float r110, float[] r111) {
        Arc[][] r100 = this.arcs;
        int r101 = r100.length - 1;
        int r102 = 0;
        float r103 = r100[0][0].getTime1();
        float r104 = r100[r101][0].getTime2();
        int r105 = r111.length;
        if (this.isExtrapolate == true) goto L5;
        r110 = Math.min(Math.max(r110, r103), r104);
    L22:
        int r106 = r100.length;
        int r107 = 0;
        boolean r108 = false;
    L23:
        if (r107 >= r106) goto L38;
        int r109 = 0;
        int r112 = 0;
    L26:
        if (r109 >= (r105 - 1)) goto L35;
        Arc r113 = r100[r107][r112];
        if (r110 > r113.getTime2()) goto L34;
        if (r113.isLinear == false) goto L32;
        r111[r109] = r113.getLinearX(r110);
        r111[r109 + 1] = r113.getLinearY(r110);
    L33:
        r108 = true;
        goto L34
    L32:
        r113.setPoint(r110);
        r111[r109] = r113.ellipseCenterX + (r113.ellipseA * Arc.access$getTmpSinAngle$p(r113));
        r111[r109 + 1] = r113.ellipseCenterY + (r113.ellipseB * Arc.access$getTmpCosAngle$p(r113));
    L34:
        r109 = r109 + 2;
        r112 = r112 + 1;
        goto L26
    L35:
        if (r108 == true) goto L36;
        r107 = r107 + 1;
        goto L23
    L36:
        return;
    L38:
        return;
    L5:
        if (r110 < r103) goto L9;
        if (r110 <= r104) goto L22;
    L9:
        if (r110 <= r104) goto L11;
        r103 = r104;
    L12:
        float r114 = r110 - r103;
        int r115 = 0;
    L14:
        if (r102 >= (r105 - 1)) goto L20;
        Arc r116 = r100[r101][r115];
        if (r116.isLinear == false) goto L18;
        r111[r102] = r116.getLinearX(r103) + (r116.ellipseCenterX * r114);
        r111[r102 + 1] = r116.getLinearY(r103) + (r116.ellipseCenterY * r114);
    L19:
        r102 = r102 + 2;
        r115 = r115 + 1;
        goto L14
    L18:
        r116.setPoint(r103);
        r111[r102] = (r116.ellipseCenterX + (r116.ellipseA * Arc.access$getTmpSinAngle$p(r116))) + (r116.calcDX() * r114);
        r111[r102 + 1] = (r116.ellipseCenterY + (r116.ellipseB * Arc.access$getTmpCosAngle$p(r116))) + (r116.calcDY() * r114);
        goto L19
    L20:
        return;
    L11:
        r101 = 0;
        goto L12
    }

    public final void getSlope(float r110, float[] r111) {
        Arc[][] r100 = this.arcs;
        float r101 = r100[0][0].getTime1();
        float r102 = r100[r100.length - 1][0].getTime2();
        if (r110 >= r101) goto L6;
        r110 = r101;
    L6:
        if (r110 > r102) goto L9;
        r102 = r110;
    L9:
        int r112 = r111.length;
        int r103 = r100.length;
        int r104 = 0;
        boolean r105 = false;
    L10:
        if (r104 >= r103) goto L25;
        int r106 = 0;
        int r107 = 0;
    L13:
        if (r106 >= (r112 - 1)) goto L22;
        Arc r108 = r100[r104][r107];
        if (r102 > r108.getTime2()) goto L21;
        if (r108.isLinear == false) goto L19;
        r111[r106] = r108.ellipseCenterX;
        r111[r106 + 1] = r108.ellipseCenterY;
    L20:
        r105 = true;
        goto L21
    L19:
        r108.setPoint(r102);
        r111[r106] = r108.calcDX();
        r111[r106 + 1] = r108.calcDY();
    L21:
        r106 = r106 + 2;
        r107 = r107 + 1;
        goto L13
    L22:
        if (r105 == true) goto L23;
        r104 = r104 + 1;
        goto L10
    L23:
        return;
    }

    public ArcSpline(int[] r210, float[] r211, float[][] r212) {
        this.isExtrapolate = true;
        int r100 = r211.length - 1;
        Arc[][] r101 = new Arc[r100][];
        int r102 = 0;
        int r103 = 1;
        int r104 = 1;
    L3:
        if (r102 >= r100) goto L27;
        int r105 = r210[r102];
        if (r105 == 0) goto L22;
        if (r105 == 1) goto L21;
        if (r105 == 2) goto L20;
        if (r105 != 3) goto L10;
        if (r103 != 1) goto L18;
        r103 = 2;
    L19:
        r104 = r103;
    L23:
        float[] r106 = r212[r102];
        int r110 = r102 + 1;
        float[] r213 = r212[r110];
        float r214 = r211[r102];
        float r215 = r211[r110];
        int r111 = (r106.length / 2) + (r106.length % 2);
        Arc[] r112 = new Arc[r111];
        int r113 = 0;
    L24:
        if (r113 >= r111) goto L26;
        int r114 = r113 * 2;
        float r115 = r106[r114];
        int r116 = r114 + 1;
        float r117 = r106[r116];
        float r118 = r213[r114];
        float r119 = r213[r116];
        int r216 = r113;
        Arc[] r217 = r112;
        r217[r216] = new Arc(r104, r214, r215, r115, r117, r118, r119);
        r113 = r216 + 1;
        r112 = r217;
        goto L24
    L26:
        r101[r102] = r112;
        r102 = r110;
        goto L3
    L18:
        r103 = 1;
        goto L19
    L10:
        if (r105 != 4) goto L12;
        r104 = 4;
        goto L23
    L12:
        if (r105 != 5) goto L23;
        r104 = 5;
        goto L23
    L20:
        r103 = 2;
        r104 = 2;
        goto L23
    L21:
        r103 = 1;
        r104 = 1;
        goto L23
    L22:
        r104 = 3;
        goto L23
    L27:
        this.arcs = r101;
    }
}
