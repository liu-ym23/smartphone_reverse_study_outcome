package androidx.compose.animation.core;

import androidx.compose.runtime.internal.StabilityInferred;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.k;

@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\u0014\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0001\u0018\u0000 \u00172\u00020\u0001:\u0002\u0018\u0017B%\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\u0006¢\u0006\u0004\b\b\u0010\tJ\u001d\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u0004¢\u0006\u0004\b\u000e\u0010\u000fJ\u001d\u0010\u0010\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u0004¢\u0006\u0004\b\u0010\u0010\u000fR \u0010\u0012\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u00060\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0015\u001a\u00020\u00148\u0002X\u0082D¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016¨\u0006\u0019"}, d2 = {"Landroidx/compose/animation/core/ArcSpline;", "", "", "arcModes", "", "timePoints", "", "y", AppAgent.CONSTRUCT, "([I[F[[F)V", "", "time", "v", "LC7/r;", "getPos", "(F[F)V", "getSlope", "Landroidx/compose/animation/core/ArcSpline$Arc;", "arcs", "[[Landroidx/compose/animation/core/ArcSpline$Arc;", "", "isExtrapolate", "Z", "Companion", "Arc", "animation-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
@ExperimentalAnimationSpecApi
/* loaded from: classes.dex */
public final class ArcSpline {
    public static final int ArcAbove = 5;
    public static final int ArcBelow = 4;
    public static final int ArcStartFlip = 3;
    public static final int ArcStartHorizontal = 2;
    public static final int ArcStartLinear = 0;
    public static final int ArcStartVertical = 1;
    private static final int DownArc = 4;
    private static final int StartHorizontal = 2;
    private static final int StartLinear = 3;
    private static final int StartVertical = 1;
    private static final int UpArc = 5;
    private final Arc[][] arcs;
    private final boolean isExtrapolate = true;
    public static final int $stable = 8;

    @StabilityInferred(parameters = 0)
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\u0014\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0007\u0018\u0000 32\u00020\u0001:\u00013BA\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0004\u0012\u0006\u0010\b\u001a\u00020\u0004\u0012\u0006\u0010\t\u001a\u00020\u0004\u0012\u0006\u0010\n\u001a\u00020\u0004¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000e\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ/\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u0015\u0010\u0014\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0004¢\u0006\u0004\b\u0014\u0010\u0015J\r\u0010\u0016\u001a\u00020\u0004¢\u0006\u0004\b\u0016\u0010\u0017J\r\u0010\u0018\u001a\u00020\u0004¢\u0006\u0004\b\u0018\u0010\u0017J\r\u0010\u0019\u001a\u00020\u0004¢\u0006\u0004\b\u0019\u0010\u0017J\r\u0010\u001a\u001a\u00020\u0004¢\u0006\u0004\b\u001a\u0010\u0017J\u0015\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0004¢\u0006\u0004\b\u001b\u0010\u000fJ\u0015\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0004¢\u0006\u0004\b\u001c\u0010\u000fJ\r\u0010\u001d\u001a\u00020\u0004¢\u0006\u0004\b\u001d\u0010\u0017J\r\u0010\u001e\u001a\u00020\u0004¢\u0006\u0004\b\u001e\u0010\u0017R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u001f\u001a\u0004\b \u0010\u0017R\u0017\u0010\u0006\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u001f\u001a\u0004\b!\u0010\u0017R\u0014\u0010\u0007\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\u001fR\u0014\u0010\b\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\u001fR\u0014\u0010\t\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\u001fR\u0014\u0010\n\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u001fR\u0016\u0010\"\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\"\u0010\u001fR\u0016\u0010#\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b#\u0010\u001fR\u0016\u0010$\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b$\u0010\u001fR\u0014\u0010&\u001a\u00020%8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b&\u0010'R\u0014\u0010(\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b(\u0010\u001fR\u0014\u0010)\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b)\u0010\u001fR\u0014\u0010*\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b*\u0010\u001fR\u0014\u0010+\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b+\u0010\u001fR\u0014\u0010,\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b,\u0010\u001fR\u0014\u0010-\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b-\u0010\u001fR\u0014\u0010/\u001a\u00020.8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b/\u00100R\u0017\u00101\u001a\u00020.8\u0006¢\u0006\f\n\u0004\b1\u00100\u001a\u0004\b1\u00102¨\u00064"}, d2 = {"Landroidx/compose/animation/core/ArcSpline$Arc;", "", "", "mode", "", "time1", "time2", "x1", "y1", "x2", "y2", AppAgent.CONSTRUCT, "(IFFFFFF)V", "v", "lookup", "(F)F", "LC7/r;", "buildTable", "(FFFF)V", "time", "setPoint", "(F)V", "calcX", "()F", "calcY", "calcDX", "calcDY", "getLinearX", "getLinearY", "getLinearDX", "getLinearDY", "F", "getTime1", "getTime2", "arcDistance", "tmpSinAngle", "tmpCosAngle", "", "lut", "[F", "oneOverDeltaTime", "ellipseA", "ellipseB", "ellipseCenterX", "ellipseCenterY", "arcVelocity", "", "isVertical", "Z", "isLinear", "()Z", "Companion", "animation-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Arc {
        private static final float Epsilon = 0.001f;
        private static float[] _ourPercent;
        private float arcDistance;
        private final float arcVelocity;
        private final float ellipseA;
        private final float ellipseB;
        private final float ellipseCenterX;
        private final float ellipseCenterY;
        private final boolean isLinear;
        private final boolean isVertical;
        private final float[] lut;
        private final float oneOverDeltaTime;
        private final float time1;
        private final float time2;
        private float tmpCosAngle;
        private float tmpSinAngle;
        private final float x1;
        private final float x2;
        private final float y1;
        private final float y2;

        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        public static final int $stable = 8;

        @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0014\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\u00020\u00068BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Landroidx/compose/animation/core/ArcSpline$Arc$Companion;", "", "()V", "Epsilon", "", "_ourPercent", "", "ourPercent", "getOurPercent", "()[F", "animation-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(e eVar) {
                this();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public final float[] getOurPercent() {
                if (Arc._ourPercent != null) {
                    float[] fArr = Arc._ourPercent;
                    k.c(fArr);
                    return fArr;
                }
                Arc._ourPercent = new float[91];
                float[] fArr2 = Arc._ourPercent;
                k.c(fArr2);
                return fArr2;
            }

            private Companion() {
            }
        }

        public Arc(int i, float f, float f7, float f9, float f10, float f11, float f12) {
            this.time1 = f;
            this.time2 = f7;
            this.x1 = f9;
            this.y1 = f10;
            this.x2 = f11;
            this.y2 = f12;
            float f13 = f11 - f9;
            float f14 = f12 - f10;
            boolean z10 = true;
            boolean z11 = i == 1 || (i == 4 ? f14 > 0.0f : !(i != 5 || f14 >= 0.0f));
            this.isVertical = z11;
            float f15 = 1 / (f7 - f);
            this.oneOverDeltaTime = f15;
            boolean z12 = 3 == i;
            if (z12 || Math.abs(f13) < Epsilon || Math.abs(f14) < Epsilon) {
                float fHypot = (float) Math.hypot(f14, f13);
                this.arcDistance = fHypot;
                this.arcVelocity = fHypot * f15;
                this.ellipseCenterX = f13 / (f7 - f);
                this.ellipseCenterY = f14 / (f7 - f);
                this.lut = new float[101];
                this.ellipseA = Float.NaN;
                this.ellipseB = Float.NaN;
            } else {
                this.lut = new float[101];
                this.ellipseA = f13 * (z11 ? -1 : 1);
                this.ellipseB = f14 * (z11 ? 1 : -1);
                this.ellipseCenterX = z11 ? f11 : f9;
                this.ellipseCenterY = z11 ? f10 : f12;
                buildTable(f9, f10, f11, f12);
                this.arcVelocity = this.arcDistance * f15;
                z10 = z12;
            }
            this.isLinear = z10;
        }

        private final void buildTable(float x12, float y12, float x22, float y22) {
            float f = x22 - x12;
            float f7 = y12 - y22;
            int length = INSTANCE.getOurPercent().length;
            float fHypot = 0.0f;
            float f9 = 0.0f;
            float f10 = 0.0f;
            int i = 0;
            while (i < length) {
                Companion companion = INSTANCE;
                double radians = (float) Math.toRadians((i * 90.0d) / (companion.getOurPercent().length - 1));
                float fSin = ((float) Math.sin(radians)) * f;
                float fCos = ((float) Math.cos(radians)) * f7;
                if (i > 0) {
                    fHypot += (float) Math.hypot(fSin - f9, fCos - f10);
                    companion.getOurPercent()[i] = fHypot;
                }
                i++;
                f10 = fCos;
                f9 = fSin;
            }
            this.arcDistance = fHypot;
            int length2 = INSTANCE.getOurPercent().length;
            for (int i6 = 0; i6 < length2; i6++) {
                float[] ourPercent = INSTANCE.getOurPercent();
                ourPercent[i6] = ourPercent[i6] / fHypot;
            }
            int length3 = this.lut.length;
            for (int i10 = 0; i10 < length3; i10++) {
                float length4 = i10 / (this.lut.length - 1);
                Companion companion2 = INSTANCE;
                float[] ourPercent2 = companion2.getOurPercent();
                int length5 = ourPercent2.length;
                k.f(ourPercent2, "<this>");
                int iBinarySearch = Arrays.binarySearch(ourPercent2, 0, length5, length4);
                if (iBinarySearch >= 0) {
                    this.lut[i10] = iBinarySearch / (companion2.getOurPercent().length - 1);
                } else if (iBinarySearch == -1) {
                    this.lut[i10] = 0.0f;
                } else {
                    int i11 = -iBinarySearch;
                    int i12 = i11 - 2;
                    this.lut[i10] = (((length4 - companion2.getOurPercent()[i12]) / (companion2.getOurPercent()[i11 - 1] - companion2.getOurPercent()[i12])) + i12) / (companion2.getOurPercent().length - 1);
                }
            }
        }

        private final float lookup(float v10) {
            if (v10 <= 0.0f) {
                return 0.0f;
            }
            if (v10 >= 1.0f) {
                return 1.0f;
            }
            float[] fArr = this.lut;
            float length = v10 * (fArr.length - 1);
            int i = (int) length;
            float f = length - i;
            float f7 = fArr[i];
            return B7.a.b(fArr[i + 1], f7, f, f7);
        }

        public final float calcDX() {
            float f = this.ellipseA * this.tmpCosAngle;
            float fHypot = this.arcVelocity / ((float) Math.hypot(f, (-this.ellipseB) * this.tmpSinAngle));
            return this.isVertical ? (-f) * fHypot : f * fHypot;
        }

        public final float calcDY() {
            float f = this.ellipseA * this.tmpCosAngle;
            float f7 = (-this.ellipseB) * this.tmpSinAngle;
            float fHypot = this.arcVelocity / ((float) Math.hypot(f, f7));
            return this.isVertical ? (-f7) * fHypot : f7 * fHypot;
        }

        public final float calcX() {
            return (this.ellipseA * this.tmpSinAngle) + this.ellipseCenterX;
        }

        public final float calcY() {
            return (this.ellipseB * this.tmpCosAngle) + this.ellipseCenterY;
        }

        /* renamed from: getLinearDX, reason: from getter */
        public final float getEllipseCenterX() {
            return this.ellipseCenterX;
        }

        /* renamed from: getLinearDY, reason: from getter */
        public final float getEllipseCenterY() {
            return this.ellipseCenterY;
        }

        public final float getLinearX(float time) {
            float f = (time - this.time1) * this.oneOverDeltaTime;
            float f7 = this.x1;
            return B7.a.b(this.x2, f7, f, f7);
        }

        public final float getLinearY(float time) {
            float f = (time - this.time1) * this.oneOverDeltaTime;
            float f7 = this.y1;
            return B7.a.b(this.y2, f7, f, f7);
        }

        public final float getTime1() {
            return this.time1;
        }

        public final float getTime2() {
            return this.time2;
        }

        /* renamed from: isLinear, reason: from getter */
        public final boolean getIsLinear() {
            return this.isLinear;
        }

        public final void setPoint(float time) {
            double dLookup = lookup((this.isVertical ? this.time2 - time : time - this.time1) * this.oneOverDeltaTime) * 1.5707964f;
            this.tmpSinAngle = (float) Math.sin(dLookup);
            this.tmpCosAngle = (float) Math.cos(dLookup);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0028 A[PHI: r10
      0x0028: PHI (r10v1 int) = (r10v0 int), (r10v5 int), (r10v6 int) binds: [B:5:0x0018, B:10:0x0021, B:12:0x0024] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0031  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public ArcSpline(int[] r21, float[] r22, float[][] r23) {
        /*
            r20 = this;
            r0 = r20
            r1 = r22
            r0.<init>()
            r2 = 1
            r0.isExtrapolate = r2
            int r3 = r1.length
            int r3 = r3 - r2
            androidx.compose.animation.core.ArcSpline$Arc[][] r4 = new androidx.compose.animation.core.ArcSpline.Arc[r3][]
            r5 = 0
            r7 = r2
            r8 = r7
            r6 = r5
        L12:
            if (r6 >= r3) goto L6b
            r9 = r21[r6]
            r10 = 3
            r11 = 2
            if (r9 == 0) goto L28
            if (r9 == r2) goto L31
            if (r9 == r11) goto L2f
            if (r9 == r10) goto L2a
            r10 = 4
            if (r9 == r10) goto L28
            r10 = 5
            if (r9 == r10) goto L28
            r13 = r8
            goto L33
        L28:
            r13 = r10
            goto L33
        L2a:
            if (r7 != r2) goto L31
            goto L2f
        L2d:
            r13 = r7
            goto L33
        L2f:
            r7 = r11
            goto L2d
        L31:
            r7 = r2
            goto L2d
        L33:
            r8 = r23[r6]
            int r9 = r8.length
            int r9 = r9 / r11
            int r8 = r8.length
            int r8 = r8 % r11
            int r8 = r8 + r9
            androidx.compose.animation.core.ArcSpline$Arc[] r9 = new androidx.compose.animation.core.ArcSpline.Arc[r8]
            r10 = r5
        L3d:
            if (r10 >= r8) goto L65
            int r11 = r10 * 2
            androidx.compose.animation.core.ArcSpline$Arc r12 = new androidx.compose.animation.core.ArcSpline$Arc
            r14 = r1[r6]
            int r15 = r6 + 1
            r16 = r15
            r15 = r1[r16]
            r17 = r23[r6]
            r18 = r16
            r16 = r17[r11]
            int r19 = r11 + 1
            r17 = r17[r19]
            r18 = r23[r18]
            r11 = r18[r11]
            r19 = r18[r19]
            r18 = r11
            r12.<init>(r13, r14, r15, r16, r17, r18, r19)
            r9[r10] = r12
            int r10 = r10 + 1
            goto L3d
        L65:
            r4[r6] = r9
            int r6 = r6 + 1
            r8 = r13
            goto L12
        L6b:
            r0.arcs = r4
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.animation.core.ArcSpline.<init>(int[], float[], float[][]):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x0022, code lost:
    
        if (r9 > r0[r0.length - 1][0].getTime2()) goto L8;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void getPos(float r9, float[] r10) {
        /*
            Method dump skipped, instructions count: 377
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.animation.core.ArcSpline.getPos(float, float[]):void");
    }

    public final void getSlope(float time, float[] v10) {
        if (time < this.arcs[0][0].getTime1()) {
            time = this.arcs[0][0].getTime1();
        } else {
            Arc[][] arcArr = this.arcs;
            if (time > arcArr[arcArr.length - 1][0].getTime2()) {
                Arc[][] arcArr2 = this.arcs;
                time = arcArr2[arcArr2.length - 1][0].getTime2();
            }
        }
        int length = this.arcs.length;
        boolean z10 = false;
        for (int i = 0; i < length; i++) {
            int i6 = 0;
            int i10 = 0;
            while (i6 < v10.length) {
                if (time <= this.arcs[i][i10].getTime2()) {
                    if (this.arcs[i][i10].getIsLinear()) {
                        v10[i6] = this.arcs[i][i10].getEllipseCenterX();
                        v10[i6 + 1] = this.arcs[i][i10].getEllipseCenterY();
                    } else {
                        this.arcs[i][i10].setPoint(time);
                        v10[i6] = this.arcs[i][i10].calcDX();
                        v10[i6 + 1] = this.arcs[i][i10].calcDY();
                    }
                    z10 = true;
                }
                i6 += 2;
                i10++;
            }
            if (z10) {
                return;
            }
        }
    }
}
