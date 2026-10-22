package androidx.compose.ui.geometry;

import androidx.collection.SieveCacheKt;
import androidx.compose.runtime.Immutable;
import androidx.compose.runtime.Stable;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import kotlin.Metadata;
import kotlin.jvm.internal.e;

@Immutable
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087@\u0018\u0000 02\u00020\u0001:\u00010B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0011\u001a\u00020\tH\u0087\n¢\u0006\u0004\b\u0012\u0010\rJ\u0010\u0010\u0013\u001a\u00020\tH\u0087\n¢\u0006\u0004\b\u0014\u0010\rJ!\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\u000e\u001a\u00020\t¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0018\u001a\u00020\u0019H\u0007¢\u0006\u0004\b\u001a\u0010\u001bJ\u0018\u0010\u001c\u001a\u00020\u00002\u0006\u0010\u001d\u001a\u00020\tH\u0087\u0002¢\u0006\u0004\b\u001e\u0010\u001fJ\u0018\u0010 \u001a\u00020\u00002\u0006\u0010\u001d\u001a\u00020\tH\u0087\u0002¢\u0006\u0004\b!\u0010\u001fJ\u000f\u0010(\u001a\u00020)H\u0016¢\u0006\u0004\b*\u0010+J\u0013\u0010,\u001a\u00020\u00192\b\u0010-\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010.\u001a\u00020/HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u001b\u0010\b\u001a\u00020\t8Æ\u0002X\u0087\u0004¢\u0006\f\u0012\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001b\u0010\u000e\u001a\u00020\t8Æ\u0002X\u0087\u0004¢\u0006\f\u0012\u0004\b\u000f\u0010\u000b\u001a\u0004\b\u0010\u0010\rR\u001a\u0010\"\u001a\u00020\t8FX\u0087\u0004¢\u0006\f\u0012\u0004\b#\u0010\u000b\u001a\u0004\b$\u0010\rR\u001a\u0010%\u001a\u00020\t8FX\u0087\u0004¢\u0006\f\u0012\u0004\b&\u0010\u000b\u001a\u0004\b'\u0010\r\u0088\u0001\u0002¨\u00061"}, d2 = {"Landroidx/compose/ui/geometry/Size;", "", "packedValue", "", "constructor-impl", "(J)J", "getPackedValue", "()J", "width", "", "getWidth$annotations", "()V", "getWidth-impl", "(J)F", "height", "getHeight$annotations", "getHeight-impl", "component1", "component1-impl", "component2", "component2-impl", "copy", "copy-xjbvk4A", "(JFF)J", "isEmpty", "", "isEmpty-impl", "(J)Z", "times", "operand", "times-7Ah8Wj8", "(JF)J", "div", "div-7Ah8Wj8", "minDimension", "getMinDimension$annotations", "getMinDimension-impl", "maxDimension", "getMaxDimension$annotations", "getMaxDimension-impl", "toString", "", "toString-impl", "(J)Ljava/lang/String;", "equals", "other", "hashCode", "", "Companion", "ui-geometry"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class Size {
    private final long packedValue;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final long Zero = m3955constructorimpl(0);
    private static final long Unspecified = m3955constructorimpl(InlineClassHelperKt.UnspecifiedPackedFloats);

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001e\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\t\u0012\u0004\b\u0006\u0010\u0003\u001a\u0004\b\u0007\u0010\bR\u001e\u0010\n\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\t\u0012\u0004\b\u000b\u0010\u0003\u001a\u0004\b\f\u0010\b¨\u0006\r"}, d2 = {"Landroidx/compose/ui/geometry/Size$Companion;", "", AppAgent.CONSTRUCT, "()V", "Zero", "Landroidx/compose/ui/geometry/Size;", "getZero-NH-jbRc$annotations", "getZero-NH-jbRc", "()J", "J", "Unspecified", "getUnspecified-NH-jbRc$annotations", "getUnspecified-NH-jbRc", "ui-geometry"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(e eVar) {
            this();
        }

        @Stable
        /* renamed from: getUnspecified-NH-jbRc$annotations, reason: not valid java name */
        public static /* synthetic */ void m3970getUnspecifiedNHjbRc$annotations() {
        }

        @Stable
        /* renamed from: getZero-NH-jbRc$annotations, reason: not valid java name */
        public static /* synthetic */ void m3971getZeroNHjbRc$annotations() {
        }

        /* renamed from: getUnspecified-NH-jbRc, reason: not valid java name */
        public final long m3972getUnspecifiedNHjbRc() {
            return Size.Unspecified;
        }

        /* renamed from: getZero-NH-jbRc, reason: not valid java name */
        public final long m3973getZeroNHjbRc() {
            return Size.Zero;
        }

        private Companion() {
        }
    }

    private /* synthetic */ Size(long j5) {
        this.packedValue = j5;
    }

    /* renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ Size m3952boximpl(long j5) {
        return new Size(j5);
    }

    @Stable
    /* renamed from: component1-impl, reason: not valid java name */
    public static final float m3953component1impl(long j5) {
        return Float.intBitsToFloat((int) (j5 >> 32));
    }

    @Stable
    /* renamed from: component2-impl, reason: not valid java name */
    public static final float m3954component2impl(long j5) {
        return Float.intBitsToFloat((int) (j5 & 4294967295L));
    }

    /* renamed from: constructor-impl, reason: not valid java name */
    public static long m3955constructorimpl(long j5) {
        return j5;
    }

    /* renamed from: copy-xjbvk4A, reason: not valid java name */
    public static final long m3956copyxjbvk4A(long j5, float f, float f7) {
        return m3955constructorimpl((Float.floatToRawIntBits(f) << 32) | (Float.floatToRawIntBits(f7) & 4294967295L));
    }

    /* renamed from: copy-xjbvk4A$default, reason: not valid java name */
    public static /* synthetic */ long m3957copyxjbvk4A$default(long j5, float f, float f7, int i, Object obj) {
        if ((i & 1) != 0) {
            f = Float.intBitsToFloat((int) (j5 >> 32));
        }
        if ((i & 2) != 0) {
            f7 = Float.intBitsToFloat((int) (4294967295L & j5));
        }
        return m3956copyxjbvk4A(j5, f, f7);
    }

    @Stable
    /* renamed from: div-7Ah8Wj8, reason: not valid java name */
    public static final long m3958div7Ah8Wj8(long j5, float f) {
        float fIntBitsToFloat = Float.intBitsToFloat((int) (j5 >> 32)) / f;
        float fIntBitsToFloat2 = Float.intBitsToFloat((int) (j5 & 4294967295L)) / f;
        return m3955constructorimpl((Float.floatToRawIntBits(fIntBitsToFloat) << 32) | (Float.floatToRawIntBits(fIntBitsToFloat2) & 4294967295L));
    }

    /* renamed from: equals-impl, reason: not valid java name */
    public static boolean m3959equalsimpl(long j5, Object obj) {
        return (obj instanceof Size) && j5 == ((Size) obj).m3969unboximpl();
    }

    /* renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m3960equalsimpl0(long j5, long j6) {
        return j5 == j6;
    }

    @Stable
    public static /* synthetic */ void getHeight$annotations() {
    }

    /* renamed from: getHeight-impl, reason: not valid java name */
    public static final float m3961getHeightimpl(long j5) {
        return Float.intBitsToFloat((int) (j5 & 4294967295L));
    }

    @Stable
    public static /* synthetic */ void getMaxDimension$annotations() {
    }

    /* renamed from: getMaxDimension-impl, reason: not valid java name */
    public static final float m3962getMaxDimensionimpl(long j5) {
        return Math.max(Float.intBitsToFloat((int) ((j5 >> 32) & SieveCacheKt.NodeLinkMask)), Float.intBitsToFloat((int) (j5 & SieveCacheKt.NodeLinkMask)));
    }

    @Stable
    public static /* synthetic */ void getMinDimension$annotations() {
    }

    /* renamed from: getMinDimension-impl, reason: not valid java name */
    public static final float m3963getMinDimensionimpl(long j5) {
        return Math.min(Float.intBitsToFloat((int) ((j5 >> 32) & SieveCacheKt.NodeLinkMask)), Float.intBitsToFloat((int) (j5 & SieveCacheKt.NodeLinkMask)));
    }

    @Stable
    public static /* synthetic */ void getWidth$annotations() {
    }

    /* renamed from: getWidth-impl, reason: not valid java name */
    public static final float m3964getWidthimpl(long j5) {
        return Float.intBitsToFloat((int) (j5 >> 32));
    }

    /* renamed from: hashCode-impl, reason: not valid java name */
    public static int m3965hashCodeimpl(long j5) {
        return Long.hashCode(j5);
    }

    @Stable
    /* renamed from: isEmpty-impl, reason: not valid java name */
    public static final boolean m3966isEmptyimpl(long j5) {
        return (j5 == InlineClassHelperKt.UnspecifiedPackedFloats) | (Float.intBitsToFloat((int) (j5 >> 32)) <= 0.0f) | (Float.intBitsToFloat((int) (j5 & 4294967295L)) <= 0.0f);
    }

    @Stable
    /* renamed from: times-7Ah8Wj8, reason: not valid java name */
    public static final long m3967times7Ah8Wj8(long j5, float f) {
        float fIntBitsToFloat = Float.intBitsToFloat((int) (j5 >> 32)) * f;
        float fIntBitsToFloat2 = Float.intBitsToFloat((int) (j5 & 4294967295L)) * f;
        return m3955constructorimpl((Float.floatToRawIntBits(fIntBitsToFloat) << 32) | (Float.floatToRawIntBits(fIntBitsToFloat2) & 4294967295L));
    }

    /* renamed from: toString-impl, reason: not valid java name */
    public static String m3968toStringimpl(long j5) {
        if (j5 == InlineClassHelperKt.UnspecifiedPackedFloats) {
            return "Size.Unspecified";
        }
        return "Size(" + GeometryUtilsKt.toStringAsFixed(Float.intBitsToFloat((int) (j5 >> 32)), 1) + ", " + GeometryUtilsKt.toStringAsFixed(Float.intBitsToFloat((int) (j5 & 4294967295L)), 1) + ')';
    }

    public boolean equals(Object other) {
        return m3959equalsimpl(this.packedValue, other);
    }

    public final long getPackedValue() {
        return this.packedValue;
    }

    public int hashCode() {
        return m3965hashCodeimpl(this.packedValue);
    }

    public String toString() {
        return m3968toStringimpl(this.packedValue);
    }

    /* renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ long m3969unboximpl() {
        return this.packedValue;
    }
}
