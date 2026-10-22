package androidx.compose.ui.unit;

import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.bouncycastle.asn1.cmc.BodyPartID;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087@\u0018\u0000 \"2\u00020\u0001:\u0001\"B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J!\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\u000e\u001a\u00020\t¢\u0006\u0004\b\u0012\u0010\u0013J\u0018\u0010\u0014\u001a\u00020\u00002\u0006\u0010\u0015\u001a\u00020\u0000H\u0087\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u0018\u0010\u0018\u001a\u00020\u00002\u0006\u0010\u0015\u001a\u00020\u0000H\u0087\u0002¢\u0006\u0004\b\u0019\u0010\u0017J\u000f\u0010\u001a\u001a\u00020\u001bH\u0017¢\u0006\u0004\b\u001c\u0010\u001dJ\u0013\u0010\u001e\u001a\u00020\u001f2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010 \u001a\u00020!HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u001a\u0010\b\u001a\u00020\t8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\t8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u000f\u0010\u000b\u001a\u0004\b\u0010\u0010\r\u0088\u0001\u0002¨\u0006#"}, d2 = {"Landroidx/compose/ui/unit/DpOffset;", "", "packedValue", "", "constructor-impl", "(J)J", "getPackedValue", "()J", "x", "Landroidx/compose/ui/unit/Dp;", "getX-D9Ej5fM$annotations", "()V", "getX-D9Ej5fM", "(J)F", "y", "getY-D9Ej5fM$annotations", "getY-D9Ej5fM", "copy", "copy-tPigGR8", "(JFF)J", "minus", "other", "minus-CB-Mgk4", "(JJ)J", "plus", "plus-CB-Mgk4", "toString", "", "toString-impl", "(J)Ljava/lang/String;", "equals", "", "hashCode", "", "Companion", "ui-unit"}, k = 1, mv = {2, 0, 0}, xi = 48)
@JvmInline
public final class DpOffset {
    public static final Companion Companion = null;
    private static final long Unspecified = 0;
    private static final long Zero = 0;
    private final long packedValue;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0013\u0010\u0004\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007R\u0013\u0010\t\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\n\u0010\u0007¨\u0006\u000b"}, d2 = {"Landroidx/compose/ui/unit/DpOffset$Companion;", "", "<init>", "()V", "Zero", "Landroidx/compose/ui/unit/DpOffset;", "getZero-RKDOV3M", "()J", "J", "Unspecified", "getUnspecified-RKDOV3M", "ui-unit"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        /* JADX INFO: renamed from: getUnspecified-RKDOV3M, reason: not valid java name */
        public final long m7614getUnspecifiedRKDOV3M() {
            return DpOffset.access$getUnspecified$cp();
        }

        /* JADX INFO: renamed from: getZero-RKDOV3M, reason: not valid java name */
        public final long m7615getZeroRKDOV3M() {
            return DpOffset.access$getZero$cp();
        }
    }

    /* JADX INFO: renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ DpOffset m7599boximpl(long r100) {
        return new DpOffset(r100);
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static long m7600constructorimpl(long r100) {
        return r100;
    }

    /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
    public static boolean m7603equalsimpl(long r100, Object r101) {
        if ((r101 instanceof DpOffset) == true) goto L6;
        return false;
    L6:
        if (r100 == ((DpOffset) r101).m7613unboximpl()) goto L8;
        return false;
    L8:
        return true;
    }

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m7604equalsimpl0(long r100, long r101) {
        if (r100 != r101) goto L5;
        return true;
    L5:
        return false;
    }

    /* JADX INFO: renamed from: getX-D9Ej5fM$annotations, reason: not valid java name */
    public static /* synthetic */ void m7606getXD9Ej5fM$annotations() {
    }

    /* JADX INFO: renamed from: getY-D9Ej5fM$annotations, reason: not valid java name */
    public static /* synthetic */ void m7608getYD9Ej5fM$annotations() {
    }

    /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
    public static int m7609hashCodeimpl(long r100) {
        return (int) (r100 ^ (r100 >>> 32));
    }

    public boolean equals(Object r100) {
        return m7603equalsimpl(this.packedValue, r100);
    }

    public int hashCode() {
        return m7609hashCodeimpl(this.packedValue);
    }

    /* JADX INFO: renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ long m7613unboximpl() {
        return this.packedValue;
    }

    static {
        Companion = new Companion(null);
        Zero = m7600constructorimpl(0);
        Unspecified = m7600constructorimpl(androidx.compose.ui.geometry.InlineClassHelperKt.UnspecifiedPackedFloats);
    }

    public String toString() {
        return m7612toStringimpl(this.packedValue);
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

    private /* synthetic */ DpOffset(long r100) {
        this.packedValue = r100;
    }

    /* JADX INFO: renamed from: getX-D9Ej5fM, reason: not valid java name */
    public static final float m7605getXD9Ej5fM(long r100) {
        return Dp.m7544constructorimpl(Float.intBitsToFloat((int) (r100 >> 32)));
    }

    /* JADX INFO: renamed from: getY-D9Ej5fM, reason: not valid java name */
    public static final float m7607getYD9Ej5fM(long r100) {
        return Dp.m7544constructorimpl(Float.intBitsToFloat((int) (r100 & BodyPartID.bodyIdMax)));
    }

    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m7612toStringimpl(long r100) {
        if (r100 == androidx.compose.ui.geometry.InlineClassHelperKt.UnspecifiedPackedFloats) goto L5;
        boolean r101 = true;
    L6:
        if (r101 == true) goto L10;
        return "DpOffset.Unspecified";
    L10:
        return "(" + Dp.m7555toStringimpl(m7605getXD9Ej5fM(r100)) + ", " + Dp.m7555toStringimpl(m7607getYD9Ej5fM(r100)) + ')';
    L5:
        r101 = false;
        goto L6
    }

    /* JADX INFO: renamed from: minus-CB-Mgk4, reason: not valid java name */
    public static final long m7610minusCBMgk4(long r100, long r101) {
        float r102 = Dp.m7544constructorimpl(m7605getXD9Ej5fM(r100) - m7605getXD9Ej5fM(r101));
        float r103 = Dp.m7544constructorimpl(m7607getYD9Ej5fM(r100) - m7607getYD9Ej5fM(r101));
        return m7600constructorimpl((Float.floatToRawIntBits(r102) << 32) | (BodyPartID.bodyIdMax & Float.floatToRawIntBits(r103)));
    }

    /* JADX INFO: renamed from: plus-CB-Mgk4, reason: not valid java name */
    public static final long m7611plusCBMgk4(long r100, long r101) {
        float r102 = Dp.m7544constructorimpl(m7605getXD9Ej5fM(r100) + m7605getXD9Ej5fM(r101));
        float r103 = Dp.m7544constructorimpl(m7607getYD9Ej5fM(r100) + m7607getYD9Ej5fM(r101));
        return m7600constructorimpl((Float.floatToRawIntBits(r102) << 32) | (BodyPartID.bodyIdMax & Float.floatToRawIntBits(r103)));
    }

    /* JADX INFO: renamed from: copy-tPigGR8, reason: not valid java name */
    public static final long m7601copytPigGR8(long r100, float r101, float r102) {
        return m7600constructorimpl((Float.floatToRawIntBits(r101) << 32) | (((long) Float.floatToRawIntBits(r102)) & BodyPartID.bodyIdMax));
    }

    /* JADX INFO: renamed from: copy-tPigGR8$default, reason: not valid java name */
    public static /* synthetic */ long m7602copytPigGR8$default(long r100, float r101, float r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = m7605getXD9Ej5fM(r100);
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = m7607getYD9Ej5fM(r100);
    L9:
        return m7601copytPigGR8(r100, r101, r102);
    }
}
