package androidx.compose.ui.geometry;

import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.bouncycastle.asn1.cmc.BodyPartID;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0017\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087@\u0018\u0000 72\u00020\u0001:\u00017B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0011\u001a\u00020\tH\u0087\n¢\u0006\u0004\b\u0012\u0010\rJ\u0010\u0010\u0013\u001a\u00020\tH\u0087\n¢\u0006\u0004\b\u0014\u0010\rJ!\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\u000e\u001a\u00020\t¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0018\u001a\u00020\u0019H\u0087\b¢\u0006\u0004\b\u001a\u0010\u001bJ\u000f\u0010\u001c\u001a\u00020\tH\u0007¢\u0006\u0004\b\u001d\u0010\rJ\u000f\u0010\u001e\u001a\u00020\tH\u0007¢\u0006\u0004\b\u001f\u0010\rJ\u0010\u0010 \u001a\u00020\u0000H\u0087\n¢\u0006\u0004\b!\u0010\u0005J\u0018\u0010\"\u001a\u00020\u00002\u0006\u0010#\u001a\u00020\u0000H\u0087\u0002¢\u0006\u0004\b$\u0010%J\u0018\u0010&\u001a\u00020\u00002\u0006\u0010#\u001a\u00020\u0000H\u0087\u0002¢\u0006\u0004\b'\u0010%J\u0018\u0010(\u001a\u00020\u00002\u0006\u0010)\u001a\u00020\tH\u0087\u0002¢\u0006\u0004\b*\u0010+J\u0018\u0010,\u001a\u00020\u00002\u0006\u0010)\u001a\u00020\tH\u0087\u0002¢\u0006\u0004\b-\u0010+J\u0018\u0010.\u001a\u00020\u00002\u0006\u0010)\u001a\u00020\tH\u0087\u0002¢\u0006\u0004\b/\u0010+J\u000f\u00100\u001a\u000201H\u0016¢\u0006\u0004\b2\u00103J\u0013\u00104\u001a\u00020\u00192\b\u0010#\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00105\u001a\u000206HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u001b\u0010\b\u001a\u00020\t8Æ\u0002X\u0087\u0004¢\u0006\f\u0012\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001b\u0010\u000e\u001a\u00020\t8Æ\u0002X\u0087\u0004¢\u0006\f\u0012\u0004\b\u000f\u0010\u000b\u001a\u0004\b\u0010\u0010\r\u0088\u0001\u0002¨\u00068"}, d2 = {"Landroidx/compose/ui/geometry/Offset;", "", "packedValue", "", "constructor-impl", "(J)J", "getPackedValue", "()J", "x", "", "getX$annotations", "()V", "getX-impl", "(J)F", "y", "getY$annotations", "getY-impl", "component1", "component1-impl", "component2", "component2-impl", "copy", "copy-dBAh8RU", "(JFF)J", "isValid", "", "isValid-impl", "(J)Z", "getDistance", "getDistance-impl", "getDistanceSquared", "getDistanceSquared-impl", "unaryMinus", "unaryMinus-F1C5BW0", "minus", "other", "minus-MK-Hz9U", "(JJ)J", "plus", "plus-MK-Hz9U", "times", "operand", "times-tuRUvjQ", "(JF)J", "div", "div-tuRUvjQ", "rem", "rem-tuRUvjQ", "toString", "", "toString-impl", "(J)Ljava/lang/String;", "equals", "hashCode", "", "Companion", "ui-geometry"}, k = 1, mv = {2, 0, 0}, xi = 48)
@JvmInline
public final class Offset {
    public static final Companion Companion = null;
    private static final long Infinite = 0;
    private static final long Unspecified = 0;
    private static final long Zero = 0;
    private final long packedValue;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001e\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\t\u0012\u0004\b\u0006\u0010\u0003\u001a\u0004\b\u0007\u0010\bR\u001e\u0010\n\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\t\u0012\u0004\b\u000b\u0010\u0003\u001a\u0004\b\f\u0010\bR\u001e\u0010\r\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\t\u0012\u0004\b\u000e\u0010\u0003\u001a\u0004\b\u000f\u0010\b¨\u0006\u0010"}, d2 = {"Landroidx/compose/ui/geometry/Offset$Companion;", "", "<init>", "()V", "Zero", "Landroidx/compose/ui/geometry/Offset;", "getZero-F1C5BW0$annotations", "getZero-F1C5BW0", "()J", "J", "Infinite", "getInfinite-F1C5BW0$annotations", "getInfinite-F1C5BW0", "Unspecified", "getUnspecified-F1C5BW0$annotations", "getUnspecified-F1C5BW0", "ui-geometry"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        /* JADX INFO: renamed from: getInfinite-F1C5BW0$annotations, reason: not valid java name */
        public static /* synthetic */ void m4593getInfiniteF1C5BW0$annotations() {
        }

        /* JADX INFO: renamed from: getUnspecified-F1C5BW0$annotations, reason: not valid java name */
        public static /* synthetic */ void m4594getUnspecifiedF1C5BW0$annotations() {
        }

        /* JADX INFO: renamed from: getZero-F1C5BW0$annotations, reason: not valid java name */
        public static /* synthetic */ void m4595getZeroF1C5BW0$annotations() {
        }

        /* JADX INFO: renamed from: getInfinite-F1C5BW0, reason: not valid java name */
        public final long m4596getInfiniteF1C5BW0() {
            return Offset.access$getInfinite$cp();
        }

        /* JADX INFO: renamed from: getUnspecified-F1C5BW0, reason: not valid java name */
        public final long m4597getUnspecifiedF1C5BW0() {
            return Offset.access$getUnspecified$cp();
        }

        /* JADX INFO: renamed from: getZero-F1C5BW0, reason: not valid java name */
        public final long m4598getZeroF1C5BW0() {
            return Offset.access$getZero$cp();
        }
    }

    /* JADX INFO: renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ Offset m4571boximpl(long r100) {
        return new Offset(r100);
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static long m4574constructorimpl(long r100) {
        return r100;
    }

    /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
    public static boolean m4578equalsimpl(long r100, Object r101) {
        if ((r101 instanceof Offset) == true) goto L6;
        return false;
    L6:
        if (r100 == ((Offset) r101).m4592unboximpl()) goto L8;
        return false;
    L8:
        return true;
    }

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m4579equalsimpl0(long r100, long r101) {
        if (r100 != r101) goto L5;
        return true;
    L5:
        return false;
    }

    public static /* synthetic */ void getX$annotations() {
    }

    public static /* synthetic */ void getY$annotations() {
    }

    /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
    public static int m4584hashCodeimpl(long r100) {
        return (int) (r100 ^ (r100 >>> 32));
    }

    /* JADX INFO: renamed from: isValid-impl, reason: not valid java name */
    public static final boolean m4585isValidimpl(long r100) {
        if ((((r100 & 9223372034707292159L) + InlineClassHelperKt.DualLoadedSignificand) & (-9223372034707292160L)) != 0) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean equals(Object r100) {
        return m4578equalsimpl(this.packedValue, r100);
    }

    public int hashCode() {
        return m4584hashCodeimpl(this.packedValue);
    }

    /* JADX INFO: renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ long m4592unboximpl() {
        return this.packedValue;
    }

    static {
        Companion = new Companion(null);
        Zero = m4574constructorimpl(0);
        Infinite = m4574constructorimpl(InlineClassHelperKt.DualFloatInfinityBase);
        Unspecified = m4574constructorimpl(InlineClassHelperKt.UnspecifiedPackedFloats);
    }

    public String toString() {
        return m4590toStringimpl(this.packedValue);
    }

    public static final /* synthetic */ long access$getInfinite$cp() {
        return Infinite;
    }

    public static final /* synthetic */ long access$getUnspecified$cp() {
        return Unspecified;
    }

    public static final /* synthetic */ long access$getZero$cp() {
        return Zero;
    }

    public final long getPackedValue() {
        return this.packedValue;
    }

    private /* synthetic */ Offset(long r100) {
        this.packedValue = r100;
    }

    /* JADX INFO: renamed from: component1-impl, reason: not valid java name */
    public static final float m4572component1impl(long r100) {
        return Float.intBitsToFloat((int) (r100 >> 32));
    }

    /* JADX INFO: renamed from: component2-impl, reason: not valid java name */
    public static final float m4573component2impl(long r100) {
        return Float.intBitsToFloat((int) (r100 & BodyPartID.bodyIdMax));
    }

    /* JADX INFO: renamed from: getDistance-impl, reason: not valid java name */
    public static final float m4580getDistanceimpl(long r100) {
        float r101 = Float.intBitsToFloat((int) (r100 >> 32));
        float r102 = Float.intBitsToFloat((int) (r100 & BodyPartID.bodyIdMax));
        return (float) Math.sqrt((r101 * r101) + (r102 * r102));
    }

    /* JADX INFO: renamed from: getDistanceSquared-impl, reason: not valid java name */
    public static final float m4581getDistanceSquaredimpl(long r100) {
        float r101 = Float.intBitsToFloat((int) (r100 >> 32));
        float r102 = Float.intBitsToFloat((int) (r100 & BodyPartID.bodyIdMax));
        return (r101 * r101) + (r102 * r102);
    }

    /* JADX INFO: renamed from: getX-impl, reason: not valid java name */
    public static final float m4582getXimpl(long r100) {
        return Float.intBitsToFloat((int) (r100 >> 32));
    }

    /* JADX INFO: renamed from: getY-impl, reason: not valid java name */
    public static final float m4583getYimpl(long r100) {
        return Float.intBitsToFloat((int) (r100 & BodyPartID.bodyIdMax));
    }

    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m4590toStringimpl(long r100) {
        if ((9223372034707292159L & r100) == InlineClassHelperKt.UnspecifiedPackedFloats) goto L5;
        boolean r101 = true;
    L6:
        if (r101 == true) goto L10;
        return "Offset.Unspecified";
    L10:
        return "Offset(" + GeometryUtilsKt.toStringAsFixed(Float.intBitsToFloat((int) (r100 >> 32)), 1) + ", " + GeometryUtilsKt.toStringAsFixed(Float.intBitsToFloat((int) (r100 & BodyPartID.bodyIdMax)), 1) + ')';
    L5:
        r101 = false;
        goto L6
    }

    /* JADX INFO: renamed from: unaryMinus-F1C5BW0, reason: not valid java name */
    public static final long m4591unaryMinusF1C5BW0(long r100) {
        return m4574constructorimpl(r100 ^ (-9223372034707292160L));
    }

    /* JADX INFO: renamed from: div-tuRUvjQ, reason: not valid java name */
    public static final long m4577divtuRUvjQ(long r100, float r101) {
        float r102 = Float.intBitsToFloat((int) (r100 >> 32)) / r101;
        float r103 = Float.intBitsToFloat((int) (r100 & BodyPartID.bodyIdMax)) / r101;
        return m4574constructorimpl((Float.floatToRawIntBits(r102) << 32) | (Float.floatToRawIntBits(r103) & BodyPartID.bodyIdMax));
    }

    /* JADX INFO: renamed from: minus-MK-Hz9U, reason: not valid java name */
    public static final long m4586minusMKHz9U(long r100, long r101) {
        float r102 = Float.intBitsToFloat((int) (r100 >> 32)) - Float.intBitsToFloat((int) (r101 >> 32));
        float r103 = Float.intBitsToFloat((int) (r100 & BodyPartID.bodyIdMax)) - Float.intBitsToFloat((int) (r101 & BodyPartID.bodyIdMax));
        return m4574constructorimpl((Float.floatToRawIntBits(r102) << 32) | (Float.floatToRawIntBits(r103) & BodyPartID.bodyIdMax));
    }

    /* JADX INFO: renamed from: plus-MK-Hz9U, reason: not valid java name */
    public static final long m4587plusMKHz9U(long r100, long r101) {
        float r102 = Float.intBitsToFloat((int) (r100 >> 32)) + Float.intBitsToFloat((int) (r101 >> 32));
        float r103 = Float.intBitsToFloat((int) (r100 & BodyPartID.bodyIdMax)) + Float.intBitsToFloat((int) (r101 & BodyPartID.bodyIdMax));
        return m4574constructorimpl((Float.floatToRawIntBits(r102) << 32) | (Float.floatToRawIntBits(r103) & BodyPartID.bodyIdMax));
    }

    /* JADX INFO: renamed from: rem-tuRUvjQ, reason: not valid java name */
    public static final long m4588remtuRUvjQ(long r100, float r101) {
        float r102 = Float.intBitsToFloat((int) (r100 >> 32)) % r101;
        float r103 = Float.intBitsToFloat((int) (r100 & BodyPartID.bodyIdMax)) % r101;
        return m4574constructorimpl((Float.floatToRawIntBits(r102) << 32) | (Float.floatToRawIntBits(r103) & BodyPartID.bodyIdMax));
    }

    /* JADX INFO: renamed from: times-tuRUvjQ, reason: not valid java name */
    public static final long m4589timestuRUvjQ(long r100, float r101) {
        float r102 = Float.intBitsToFloat((int) (r100 >> 32)) * r101;
        float r103 = Float.intBitsToFloat((int) (r100 & BodyPartID.bodyIdMax)) * r101;
        return m4574constructorimpl((Float.floatToRawIntBits(r102) << 32) | (Float.floatToRawIntBits(r103) & BodyPartID.bodyIdMax));
    }

    /* JADX INFO: renamed from: copy-dBAh8RU, reason: not valid java name */
    public static final long m4575copydBAh8RU(long r100, float r101, float r102) {
        return m4574constructorimpl((Float.floatToRawIntBits(r101) << 32) | (((long) Float.floatToRawIntBits(r102)) & BodyPartID.bodyIdMax));
    }

    /* JADX INFO: renamed from: copy-dBAh8RU$default, reason: not valid java name */
    public static /* synthetic */ long m4576copydBAh8RU$default(long r100, float r101, float r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = Float.intBitsToFloat((int) (r100 >> 32));
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = Float.intBitsToFloat((int) (BodyPartID.bodyIdMax & r100));
    L9:
        return m4575copydBAh8RU(r100, r101, r102);
    }
}
