package androidx.compose.ui.unit;

import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.bouncycastle.asn1.cmc.BodyPartID;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0018\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0087@\u0018\u0000 12\u00020\u0001:\u00011B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0011\u001a\u00020\tH\u0087\n¢\u0006\u0004\b\u0012\u0010\rJ\u0010\u0010\u0013\u001a\u00020\tH\u0087\n¢\u0006\u0004\b\u0014\u0010\rJ!\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\u000e\u001a\u00020\t¢\u0006\u0004\b\u0016\u0010\u0017J\u0018\u0010\u0018\u001a\u00020\u00002\u0006\u0010\u0019\u001a\u00020\u0000H\u0087\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ\u0018\u0010\u001c\u001a\u00020\u00002\u0006\u0010\u0019\u001a\u00020\u0000H\u0087\u0002¢\u0006\u0004\b\u001d\u0010\u001bJ\u0010\u0010\u001e\u001a\u00020\u0000H\u0087\u0002¢\u0006\u0004\b\u001f\u0010\u0005J\u0018\u0010 \u001a\u00020\u00002\u0006\u0010!\u001a\u00020\"H\u0087\u0002¢\u0006\u0004\b#\u0010$J\u0018\u0010%\u001a\u00020\u00002\u0006\u0010!\u001a\u00020\"H\u0087\u0002¢\u0006\u0004\b&\u0010$J\u0018\u0010'\u001a\u00020\u00002\u0006\u0010!\u001a\u00020\tH\u0087\u0002¢\u0006\u0004\b(\u0010)J\u000f\u0010*\u001a\u00020+H\u0017¢\u0006\u0004\b,\u0010-J\u0013\u0010.\u001a\u00020/2\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00100\u001a\u00020\tHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u001a\u0010\b\u001a\u00020\t8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\t8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u000f\u0010\u000b\u001a\u0004\b\u0010\u0010\r\u0088\u0001\u0002¨\u00062"}, d2 = {"Landroidx/compose/ui/unit/IntOffset;", "", "packedValue", "", "constructor-impl", "(J)J", "getPackedValue", "()J", "x", "", "getX$annotations", "()V", "getX-impl", "(J)I", "y", "getY$annotations", "getY-impl", "component1", "component1-impl", "component2", "component2-impl", "copy", "copy-iSbpLlY", "(JII)J", "minus", "other", "minus-qkQi6aY", "(JJ)J", "plus", "plus-qkQi6aY", "unaryMinus", "unaryMinus-nOcc-ac", "times", "operand", "", "times-Bjo55l4", "(JF)J", "div", "div-Bjo55l4", "rem", "rem-Bjo55l4", "(JI)J", "toString", "", "toString-impl", "(J)Ljava/lang/String;", "equals", "", "hashCode", "Companion", "ui-unit"}, k = 1, mv = {2, 0, 0}, xi = 48)
@JvmInline
public final class IntOffset {
    public static final Companion Companion = null;
    private static final long Max = 0;
    private static final long Zero = 0;
    private final long packedValue;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0013\u0010\u0004\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007R\u0013\u0010\t\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\n\u0010\u0007¨\u0006\u000b"}, d2 = {"Landroidx/compose/ui/unit/IntOffset$Companion;", "", "<init>", "()V", "Zero", "Landroidx/compose/ui/unit/IntOffset;", "getZero-nOcc-ac", "()J", "J", "Max", "getMax-nOcc-ac", "ui-unit"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        /* JADX INFO: renamed from: getMax-nOcc-ac, reason: not valid java name */
        public final long m7686getMaxnOccac() {
            return IntOffset.access$getMax$cp();
        }

        /* JADX INFO: renamed from: getZero-nOcc-ac, reason: not valid java name */
        public final long m7687getZeronOccac() {
            return IntOffset.access$getZero$cp();
        }
    }

    /* JADX INFO: renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ IntOffset m7667boximpl(long r100) {
        return new IntOffset(r100);
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static long m7670constructorimpl(long r100) {
        return r100;
    }

    /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
    public static boolean m7674equalsimpl(long r100, Object r101) {
        if ((r101 instanceof IntOffset) == true) goto L6;
        return false;
    L6:
        if (r100 == ((IntOffset) r101).m7685unboximpl()) goto L8;
        return false;
    L8:
        return true;
    }

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m7675equalsimpl0(long r100, long r101) {
        if (r100 != r101) goto L5;
        return true;
    L5:
        return false;
    }

    public static /* synthetic */ void getX$annotations() {
    }

    /* JADX INFO: renamed from: getX-impl, reason: not valid java name */
    public static final int m7676getXimpl(long r100) {
        return (int) (r100 >> 32);
    }

    public static /* synthetic */ void getY$annotations() {
    }

    /* JADX INFO: renamed from: getY-impl, reason: not valid java name */
    public static final int m7677getYimpl(long r100) {
        return (int) (r100 & BodyPartID.bodyIdMax);
    }

    /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
    public static int m7678hashCodeimpl(long r100) {
        return (int) (r100 ^ (r100 >>> 32));
    }

    public boolean equals(Object r100) {
        return m7674equalsimpl(this.packedValue, r100);
    }

    public int hashCode() {
        return m7678hashCodeimpl(this.packedValue);
    }

    /* JADX INFO: renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ long m7685unboximpl() {
        return this.packedValue;
    }

    static {
        Companion = new Companion(null);
        Zero = m7670constructorimpl(0);
        Max = m7670constructorimpl(9223372034707292159L);
    }

    public String toString() {
        return m7683toStringimpl(this.packedValue);
    }

    public static final /* synthetic */ long access$getMax$cp() {
        return Max;
    }

    public static final /* synthetic */ long access$getZero$cp() {
        return Zero;
    }

    public final long getPackedValue() {
        return this.packedValue;
    }

    private /* synthetic */ IntOffset(long r100) {
        this.packedValue = r100;
    }

    /* JADX INFO: renamed from: component1-impl, reason: not valid java name */
    public static final int m7668component1impl(long r100) {
        return m7676getXimpl(r100);
    }

    /* JADX INFO: renamed from: component2-impl, reason: not valid java name */
    public static final int m7669component2impl(long r100) {
        return m7677getYimpl(r100);
    }

    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m7683toStringimpl(long r100) {
        return "(" + m7676getXimpl(r100) + ", " + m7677getYimpl(r100) + ')';
    }

    /* JADX INFO: renamed from: unaryMinus-nOcc-ac, reason: not valid java name */
    public static final long m7684unaryMinusnOccac(long r100) {
        int r101 = -((int) (r100 >> 32));
        long r102 = ((long) (-((int) (r100 & BodyPartID.bodyIdMax)))) & BodyPartID.bodyIdMax;
        return m7670constructorimpl(r102 | (((long) r101) << 32));
    }

    /* JADX INFO: renamed from: div-Bjo55l4, reason: not valid java name */
    public static final long m7673divBjo55l4(long r100, float r101) {
        return m7670constructorimpl((((long) Math.round(((int) (r100 >> 32)) / r101)) << 32) | (((long) Math.round(((int) (r100 & BodyPartID.bodyIdMax)) / r101)) & BodyPartID.bodyIdMax));
    }

    /* JADX INFO: renamed from: minus-qkQi6aY, reason: not valid java name */
    public static final long m7679minusqkQi6aY(long r100, long r101) {
        int r102 = ((int) (r100 >> 32)) - ((int) (r101 >> 32));
        int r103 = ((int) (r100 & BodyPartID.bodyIdMax)) - ((int) (r101 & BodyPartID.bodyIdMax));
        long r104 = ((long) r103) & BodyPartID.bodyIdMax;
        return m7670constructorimpl(r104 | (((long) r102) << 32));
    }

    /* JADX INFO: renamed from: plus-qkQi6aY, reason: not valid java name */
    public static final long m7680plusqkQi6aY(long r100, long r101) {
        int r102 = ((int) (r100 >> 32)) + ((int) (r101 >> 32));
        int r103 = ((int) (r100 & BodyPartID.bodyIdMax)) + ((int) (r101 & BodyPartID.bodyIdMax));
        long r104 = ((long) r103) & BodyPartID.bodyIdMax;
        return m7670constructorimpl(r104 | (((long) r102) << 32));
    }

    /* JADX INFO: renamed from: rem-Bjo55l4, reason: not valid java name */
    public static final long m7681remBjo55l4(long r100, int r101) {
        int r102 = ((int) (r100 >> 32)) % r101;
        long r103 = ((long) (((int) (r100 & BodyPartID.bodyIdMax)) % r101)) & BodyPartID.bodyIdMax;
        return m7670constructorimpl(r103 | (((long) r102) << 32));
    }

    /* JADX INFO: renamed from: times-Bjo55l4, reason: not valid java name */
    public static final long m7682timesBjo55l4(long r100, float r101) {
        return m7670constructorimpl((((long) Math.round(((int) (r100 >> 32)) * r101)) << 32) | (((long) Math.round(((int) (r100 & BodyPartID.bodyIdMax)) * r101)) & BodyPartID.bodyIdMax));
    }

    /* JADX INFO: renamed from: copy-iSbpLlY, reason: not valid java name */
    public static final long m7671copyiSbpLlY(long r100, int r101, int r102) {
        return m7670constructorimpl((((long) r101) << 32) | (((long) r102) & BodyPartID.bodyIdMax));
    }

    /* JADX INFO: renamed from: copy-iSbpLlY$default, reason: not valid java name */
    public static /* synthetic */ long m7672copyiSbpLlY$default(long r100, int r101, int r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = (int) (r100 >> 32);
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = (int) (BodyPartID.bodyIdMax & r100);
    L9:
        return m7671copyiSbpLlY(r100, r101, r102);
    }
}
