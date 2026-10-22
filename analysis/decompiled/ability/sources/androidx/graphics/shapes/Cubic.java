package androidx.graphics.shapes;

import D7.q;
import androidx.collection.FloatFloatPair;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0014\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u001e\b\u0016\u0018\u0000 M2\u00020\u0001:\u0001MB\u0013\b\u0000\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005B9\b\u0010\u0012\n\u0010\b\u001a\u00060\u0006j\u0002`\u0007\u0012\n\u0010\t\u001a\u00060\u0006j\u0002`\u0007\u0012\n\u0010\n\u001a\u00060\u0006j\u0002`\u0007\u0012\n\u0010\u000b\u001a\u00060\u0006j\u0002`\u0007¢\u0006\u0004\b\u0004\u0010\fJ!\u0010\u0011\u001a\u00060\u0006j\u0002`\u00072\u0006\u0010\u000e\u001a\u00020\rH\u0000ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0015\u001a\u00020\u0012H\u0000¢\u0006\u0004\b\u0013\u0010\u0014J#\u0010\u001b\u001a\u00020\u00182\b\b\u0002\u0010\u0016\u001a\u00020\u00022\b\b\u0002\u0010\u0017\u001a\u00020\u0012H\u0000¢\u0006\u0004\b\u0019\u0010\u001aJ!\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00000\u001c2\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u001d\u0010\u001eJ\r\u0010\u001f\u001a\u00020\u0000¢\u0006\u0004\b\u001f\u0010 J\u0018\u0010\"\u001a\u00020\u00002\u0006\u0010!\u001a\u00020\u0000H\u0086\u0002¢\u0006\u0004\b\"\u0010#J\u0018\u0010%\u001a\u00020\u00002\u0006\u0010$\u001a\u00020\rH\u0086\u0002¢\u0006\u0004\b%\u0010&J\u0018\u0010%\u001a\u00020\u00002\u0006\u0010$\u001a\u00020'H\u0086\u0002¢\u0006\u0004\b%\u0010(J\u0018\u0010)\u001a\u00020\u00002\u0006\u0010$\u001a\u00020\rH\u0086\u0002¢\u0006\u0004\b)\u0010&J\u0018\u0010)\u001a\u00020\u00002\u0006\u0010$\u001a\u00020'H\u0086\u0002¢\u0006\u0004\b)\u0010(J\u000f\u0010+\u001a\u00020*H\u0016¢\u0006\u0004\b+\u0010,J\u001a\u0010.\u001a\u00020\u00122\b\u0010-\u001a\u0004\u0018\u00010\u0001H\u0096\u0002¢\u0006\u0004\b.\u0010/J\u0015\u00102\u001a\u00020\u00002\u0006\u00101\u001a\u000200¢\u0006\u0004\b2\u00103J\u000f\u00104\u001a\u00020'H\u0016¢\u0006\u0004\b4\u00105J\u0017\u00107\u001a\u00020\u00122\u0006\u00106\u001a\u00020\rH\u0002¢\u0006\u0004\b7\u00108R\u001a\u0010\u0003\u001a\u00020\u00028\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0003\u00109\u001a\u0004\b:\u0010;R\u0011\u0010>\u001a\u00020\r8F¢\u0006\u0006\u001a\u0004\b<\u0010=R\u0011\u0010@\u001a\u00020\r8F¢\u0006\u0006\u001a\u0004\b?\u0010=R\u0011\u0010B\u001a\u00020\r8F¢\u0006\u0006\u001a\u0004\bA\u0010=R\u0011\u0010D\u001a\u00020\r8F¢\u0006\u0006\u001a\u0004\bC\u0010=R\u0011\u0010F\u001a\u00020\r8F¢\u0006\u0006\u001a\u0004\bE\u0010=R\u0011\u0010H\u001a\u00020\r8F¢\u0006\u0006\u001a\u0004\bG\u0010=R\u0011\u0010J\u001a\u00020\r8F¢\u0006\u0006\u001a\u0004\bI\u0010=R\u0011\u0010L\u001a\u00020\r8F¢\u0006\u0006\u001a\u0004\bK\u0010=\u0082\u0002\u000b\n\u0002\b!\n\u0005\b¡\u001e0\u0001¨\u0006N"}, d2 = {"Landroidx/graphics/shapes/Cubic;", "", "", "points", AppAgent.CONSTRUCT, "([F)V", "Landroidx/collection/FloatFloatPair;", "Landroidx/graphics/shapes/Point;", "anchor0", "control0", "control1", "anchor1", "(JJJJLkotlin/jvm/internal/e;)V", "", "t", "pointOnCurve-OOQOV4g$graphics_shapes_release", "(F)J", "pointOnCurve", "", "zeroLength$graphics_shapes_release", "()Z", "zeroLength", "bounds", "approximate", "LC7/r;", "calculateBounds$graphics_shapes_release", "([FZ)V", "calculateBounds", "Lkotlin/Pair;", "split", "(F)Lkotlin/Pair;", "reverse", "()Landroidx/graphics/shapes/Cubic;", "o", "plus", "(Landroidx/graphics/shapes/Cubic;)Landroidx/graphics/shapes/Cubic;", "x", "times", "(F)Landroidx/graphics/shapes/Cubic;", "", "(I)Landroidx/graphics/shapes/Cubic;", "div", "", "toString", "()Ljava/lang/String;", "other", "equals", "(Ljava/lang/Object;)Z", "Landroidx/graphics/shapes/PointTransformer;", "f", "transformed", "(Landroidx/graphics/shapes/PointTransformer;)Landroidx/graphics/shapes/Cubic;", "hashCode", "()I", "value", "zeroIsh", "(F)Z", "[F", "getPoints$graphics_shapes_release", "()[F", "getAnchor0X", "()F", "anchor0X", "getAnchor0Y", "anchor0Y", "getControl0X", "control0X", "getControl0Y", "control0Y", "getControl1X", "control1X", "getControl1Y", "control1Y", "getAnchor1X", "anchor1X", "getAnchor1Y", "anchor1Y", "Companion", "graphics-shapes_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes2.dex */
public class Cubic {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final float[] points;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J8\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u0006H\u0007J(\u0010\f\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u0006H\u0007¨\u0006\r"}, d2 = {"Landroidx/graphics/shapes/Cubic$Companion;", "", "()V", "circularArc", "Landroidx/graphics/shapes/Cubic;", "centerX", "", "centerY", "x0", "y0", "x1", "y1", "straightLine", "graphics-shapes_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(e eVar) {
            this();
        }

        public final Cubic circularArc(float centerX, float centerY, float x02, float y02, float x12, float y12) {
            float f = x02 - centerX;
            float f7 = y02 - centerY;
            long jDirectionVector = Utils.directionVector(f, f7);
            float f9 = x12 - centerX;
            float f10 = y12 - centerY;
            long jDirectionVector2 = Utils.directionVector(f9, f10);
            long jM7158rotate90DnnuFBc = Utils.m7158rotate90DnnuFBc(jDirectionVector);
            long jM7158rotate90DnnuFBc2 = Utils.m7158rotate90DnnuFBc(jDirectionVector2);
            boolean z10 = PointKt.m7132dotProduct5P9i7ZU(jM7158rotate90DnnuFBc, f9, f10) >= 0.0f;
            float fM7133dotProductybeJwSQ = PointKt.m7133dotProductybeJwSQ(jDirectionVector, jDirectionVector2);
            if (fM7133dotProductybeJwSQ > 0.999f) {
                return straightLine(x02, y02, x12, y12);
            }
            float fSqrt = (((((float) Math.sqrt(2 * r9)) - ((float) Math.sqrt(r5 - (fM7133dotProductybeJwSQ * fM7133dotProductybeJwSQ)))) * ((Utils.distance(f, f7) * 4.0f) / 3.0f)) / (1 - fM7133dotProductybeJwSQ)) * (z10 ? 1.0f : -1.0f);
            return CubicKt.Cubic(x02, y02, (PointKt.m7137getXDnnuFBc(jM7158rotate90DnnuFBc) * fSqrt) + x02, (PointKt.m7138getYDnnuFBc(jM7158rotate90DnnuFBc) * fSqrt) + y02, x12 - (PointKt.m7137getXDnnuFBc(jM7158rotate90DnnuFBc2) * fSqrt), y12 - (PointKt.m7138getYDnnuFBc(jM7158rotate90DnnuFBc2) * fSqrt), x12, y12);
        }

        public final Cubic straightLine(float x02, float y02, float x12, float y12) {
            return CubicKt.Cubic(x02, y02, Utils.interpolate(x02, x12, 0.33333334f), Utils.interpolate(y02, y12, 0.33333334f), Utils.interpolate(x02, x12, 0.6666667f), Utils.interpolate(y02, y12, 0.6666667f), x12, y12);
        }

        private Companion() {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Cubic() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ void calculateBounds$graphics_shapes_release$default(Cubic cubic, float[] fArr, boolean z10, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: calculateBounds");
        }
        if ((i & 1) != 0) {
            fArr = new float[4];
        }
        if ((i & 2) != 0) {
            z10 = false;
        }
        cubic.calculateBounds$graphics_shapes_release(fArr, z10);
    }

    public static final Cubic circularArc(float f, float f7, float f9, float f10, float f11, float f12) {
        return INSTANCE.circularArc(f, f7, f9, f10, f11, f12);
    }

    public static final Cubic straightLine(float f, float f7, float f9, float f10) {
        return INSTANCE.straightLine(f, f7, f9, f10);
    }

    private final boolean zeroIsh(float value) {
        return Math.abs(value) < 1.0E-4f;
    }

    /* JADX WARN: Removed duplicated region for block: B:50:0x01a6  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x01cb A[PHI: r0 r7
      0x01cb: PHI (r0v2 float) = (r0v1 float), (r0v3 float) binds: [B:85:0x021a, B:62:0x01c9] A[DONT_GENERATE, DONT_INLINE]
      0x01cb: PHI (r7v14 float) = (r7v10 float), (r7v16 float) binds: [B:85:0x021a, B:62:0x01c9] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:64:0x01cd  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x021d A[PHI: r9 r13
      0x021d: PHI (r9v5 float) = (r9v2 float), (r9v3 float), (r9v3 float), (r9v2 float), (r9v2 float), (r9v2 float) binds: [B:65:0x01d4, B:77:0x0203, B:79:0x0207, B:51:0x01a8, B:54:0x01b2, B:56:0x01b6] A[DONT_GENERATE, DONT_INLINE]
      0x021d: PHI (r13v13 float) = (r13v9 float), (r13v10 float), (r13v10 float), (r13v9 float), (r13v9 float), (r13v9 float) binds: [B:65:0x01d4, B:77:0x0203, B:79:0x0207, B:51:0x01a8, B:54:0x01b2, B:56:0x01b6] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void calculateBounds$graphics_shapes_release(float[] r23, boolean r24) {
        /*
            Method dump skipped, instructions count: 551
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.graphics.shapes.Cubic.calculateBounds$graphics_shapes_release(float[], boolean):void");
    }

    public final Cubic div(float x10) {
        return times(1.0f / x10);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof Cubic) {
            return Arrays.equals(this.points, ((Cubic) other).points);
        }
        return false;
    }

    public final float getAnchor0X() {
        return this.points[0];
    }

    public final float getAnchor0Y() {
        return this.points[1];
    }

    public final float getAnchor1X() {
        return this.points[6];
    }

    public final float getAnchor1Y() {
        return this.points[7];
    }

    public final float getControl0X() {
        return this.points[2];
    }

    public final float getControl0Y() {
        return this.points[3];
    }

    public final float getControl1X() {
        return this.points[4];
    }

    public final float getControl1Y() {
        return this.points[5];
    }

    /* renamed from: getPoints$graphics_shapes_release, reason: from getter */
    public final float[] getPoints() {
        return this.points;
    }

    public int hashCode() {
        return Arrays.hashCode(this.points);
    }

    public final Cubic plus(Cubic o) {
        k.f(o, "o");
        float[] fArr = new float[8];
        for (int i = 0; i < 8; i++) {
            fArr[i] = this.points[i] + o.points[i];
        }
        return new Cubic(fArr);
    }

    /* renamed from: pointOnCurve-OOQOV4g$graphics_shapes_release, reason: not valid java name */
    public final long m7125pointOnCurveOOQOV4g$graphics_shapes_release(float t9) {
        float f = 1 - t9;
        float f7 = f * f * f;
        float f9 = 3 * t9;
        float f10 = f9 * f * f;
        float f11 = f9 * t9 * f;
        float f12 = t9 * t9 * t9;
        return FloatFloatPair.m11constructorimpl((getAnchor1X() * f12) + (getControl1X() * f11) + (getControl0X() * f10) + (getAnchor0X() * f7), (getAnchor1Y() * f12) + (getControl1Y() * f11) + (getControl0Y() * f10) + (getAnchor0Y() * f7));
    }

    public final Cubic reverse() {
        return CubicKt.Cubic(getAnchor1X(), getAnchor1Y(), getControl1X(), getControl1Y(), getControl0X(), getControl0Y(), getAnchor0X(), getAnchor0Y());
    }

    public final Pair<Cubic, Cubic> split(float t9) {
        float f = 1 - t9;
        long jM7125pointOnCurveOOQOV4g$graphics_shapes_release = m7125pointOnCurveOOQOV4g$graphics_shapes_release(t9);
        float f7 = f * f;
        float f9 = 2 * f * t9;
        float f10 = t9 * t9;
        return new Pair<>(CubicKt.Cubic(getAnchor0X(), getAnchor0Y(), (getAnchor0X() * f) + (getControl0X() * t9), (getAnchor0Y() * f) + (getControl0Y() * t9), (getControl1X() * f10) + (getControl0X() * f9) + (getAnchor0X() * f7), (getControl1Y() * f10) + (getControl0Y() * f9) + (getAnchor0Y() * f7), PointKt.m7137getXDnnuFBc(jM7125pointOnCurveOOQOV4g$graphics_shapes_release), PointKt.m7138getYDnnuFBc(jM7125pointOnCurveOOQOV4g$graphics_shapes_release)), CubicKt.Cubic(PointKt.m7137getXDnnuFBc(jM7125pointOnCurveOOQOV4g$graphics_shapes_release), PointKt.m7138getYDnnuFBc(jM7125pointOnCurveOOQOV4g$graphics_shapes_release), (getAnchor1X() * f10) + (getControl1X() * f9) + (getControl0X() * f7), (getAnchor1Y() * f10) + (getControl1Y() * f9) + (getControl0Y() * f7), (getAnchor1X() * t9) + (getControl1X() * f), (getAnchor1Y() * t9) + (getControl1Y() * f), getAnchor1X(), getAnchor1Y()));
    }

    public final Cubic times(float x10) {
        float[] fArr = new float[8];
        for (int i = 0; i < 8; i++) {
            fArr[i] = this.points[i] * x10;
        }
        return new Cubic(fArr);
    }

    public String toString() {
        return "anchor0: (" + getAnchor0X() + ", " + getAnchor0Y() + ") control0: (" + getControl0X() + ", " + getControl0Y() + "), control1: (" + getControl1X() + ", " + getControl1Y() + "), anchor1: (" + getAnchor1X() + ", " + getAnchor1Y() + ')';
    }

    public final Cubic transformed(PointTransformer f) {
        k.f(f, "f");
        MutableCubic mutableCubic = new MutableCubic();
        q.Z(this.points, 0, mutableCubic.getPoints(), 14);
        mutableCubic.transform(f);
        return mutableCubic;
    }

    public final boolean zeroLength$graphics_shapes_release() {
        return Math.abs(getAnchor0X() - getAnchor1X()) < 1.0E-4f && Math.abs(getAnchor0Y() - getAnchor1Y()) < 1.0E-4f;
    }

    public /* synthetic */ Cubic(long j5, long j6, long j10, long j11, e eVar) {
        this(j5, j6, j10, j11);
    }

    public final Cubic div(int x10) {
        return div(x10);
    }

    public final Cubic times(int x10) {
        return times(x10);
    }

    public Cubic(float[] points) {
        k.f(points, "points");
        this.points = points;
        if (points.length != 8) {
            throw new IllegalArgumentException("Points array size should be 8");
        }
    }

    public /* synthetic */ Cubic(float[] fArr, int i, e eVar) {
        this((i & 1) != 0 ? new float[8] : fArr);
    }

    private Cubic(long j5, long j6, long j10, long j11) {
        this(new float[]{PointKt.m7137getXDnnuFBc(j5), PointKt.m7138getYDnnuFBc(j5), PointKt.m7137getXDnnuFBc(j6), PointKt.m7138getYDnnuFBc(j6), PointKt.m7137getXDnnuFBc(j10), PointKt.m7138getYDnnuFBc(j10), PointKt.m7137getXDnnuFBc(j11), PointKt.m7138getYDnnuFBc(j11)});
    }
}
