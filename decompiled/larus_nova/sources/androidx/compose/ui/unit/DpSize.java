package androidx.compose.ui.unit;

import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.bouncycastle.asn1.cmc.BodyPartID;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0087@\u0018\u0000 ,2\u00020\u0001:\u0001,B\u0011\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J!\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\r\u001a\u00020\t¢\u0006\u0004\b\u0011\u0010\u0012J\u0018\u0010\u0013\u001a\u00020\u00002\u0006\u0010\u0014\u001a\u00020\u0000H\u0087\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u0018\u0010\u0017\u001a\u00020\u00002\u0006\u0010\u0014\u001a\u00020\u0000H\u0087\u0002¢\u0006\u0004\b\u0018\u0010\u0016J\u0010\u0010\u0019\u001a\u00020\tH\u0087\n¢\u0006\u0004\b\u001a\u0010\fJ\u0010\u0010\u001b\u001a\u00020\tH\u0087\n¢\u0006\u0004\b\u001c\u0010\fJ\u0018\u0010\u001d\u001a\u00020\u00002\u0006\u0010\u0014\u001a\u00020\u001eH\u0087\u0002¢\u0006\u0004\b\u001f\u0010 J\u0018\u0010\u001d\u001a\u00020\u00002\u0006\u0010\u0014\u001a\u00020!H\u0087\u0002¢\u0006\u0004\b\u001f\u0010\"J\u0018\u0010#\u001a\u00020\u00002\u0006\u0010\u0014\u001a\u00020\u001eH\u0087\u0002¢\u0006\u0004\b$\u0010 J\u0018\u0010#\u001a\u00020\u00002\u0006\u0010\u0014\u001a\u00020!H\u0087\u0002¢\u0006\u0004\b$\u0010\"J\u000f\u0010%\u001a\u00020&H\u0017¢\u0006\u0004\b'\u0010(J\u0013\u0010)\u001a\u00020*2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010+\u001a\u00020\u001eHÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0000X\u0081\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0006\u0010\u0007R\u001a\u0010\b\u001a\u00020\t8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\n\u0010\u0007\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u00020\t8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u000e\u0010\u0007\u001a\u0004\b\u000f\u0010\f\u0088\u0001\u0002\u0092\u0001\u00020\u0003¨\u0006-"}, d2 = {"Landroidx/compose/ui/unit/DpSize;", "", "packedValue", "", "constructor-impl", "(J)J", "getPackedValue$annotations", "()V", "width", "Landroidx/compose/ui/unit/Dp;", "getWidth-D9Ej5fM$annotations", "getWidth-D9Ej5fM", "(J)F", "height", "getHeight-D9Ej5fM$annotations", "getHeight-D9Ej5fM", "copy", "copy-DwJknco", "(JFF)J", "minus", "other", "minus-e_xh8Ic", "(JJ)J", "plus", "plus-e_xh8Ic", "component1", "component1-D9Ej5fM", "component2", "component2-D9Ej5fM", "times", "", "times-Gh9hcWk", "(JI)J", "", "(JF)J", "div", "div-Gh9hcWk", "toString", "", "toString-impl", "(J)Ljava/lang/String;", "equals", "", "hashCode", "Companion", "ui-unit"}, k = 1, mv = {2, 0, 0}, xi = 48)
@JvmInline
public final class DpSize {
    public static final Companion Companion = null;
    private static final long Unspecified = 0;
    private static final long Zero = 0;
    private final long packedValue;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0013\u0010\u0004\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007R\u0013\u0010\t\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\n\u0010\u0007¨\u0006\u000b"}, d2 = {"Landroidx/compose/ui/unit/DpSize$Companion;", "", "<init>", "()V", "Zero", "Landroidx/compose/ui/unit/DpSize;", "getZero-MYxV2XQ", "()J", "J", "Unspecified", "getUnspecified-MYxV2XQ", "ui-unit"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        /* JADX INFO: renamed from: getUnspecified-MYxV2XQ, reason: not valid java name */
        public final long m7651getUnspecifiedMYxV2XQ() {
            return DpSize.access$getUnspecified$cp();
        }

        /* JADX INFO: renamed from: getZero-MYxV2XQ, reason: not valid java name */
        public final long m7652getZeroMYxV2XQ() {
            return DpSize.access$getZero$cp();
        }
    }

    /* JADX INFO: renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ DpSize m7630boximpl(long r100) {
        return new DpSize(r100);
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static long m7633constructorimpl(long r100) {
        return r100;
    }

    /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
    public static boolean m7638equalsimpl(long r100, Object r101) {
        if ((r101 instanceof DpSize) == true) goto L6;
        return false;
    L6:
        if (r100 == ((DpSize) r101).m7650unboximpl()) goto L8;
        return false;
    L8:
        return true;
    }

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m7639equalsimpl0(long r100, long r101) {
        if (r100 != r101) goto L5;
        return true;
    L5:
        return false;
    }

    /* JADX INFO: renamed from: getHeight-D9Ej5fM$annotations, reason: not valid java name */
    public static /* synthetic */ void m7641getHeightD9Ej5fM$annotations() {
    }

    public static /* synthetic */ void getPackedValue$annotations() {
    }

    /* JADX INFO: renamed from: getWidth-D9Ej5fM$annotations, reason: not valid java name */
    public static /* synthetic */ void m7643getWidthD9Ej5fM$annotations() {
    }

    /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
    public static int m7644hashCodeimpl(long r100) {
        return (int) (r100 ^ (r100 >>> 32));
    }

    public boolean equals(Object r100) {
        return m7638equalsimpl(this.packedValue, r100);
    }

    public int hashCode() {
        return m7644hashCodeimpl(this.packedValue);
    }

    /* JADX INFO: renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ long m7650unboximpl() {
        return this.packedValue;
    }

    static {
        Companion = new Companion(null);
        Zero = m7633constructorimpl(0);
        Unspecified = m7633constructorimpl(androidx.compose.ui.geometry.InlineClassHelperKt.UnspecifiedPackedFloats);
    }

    public String toString() {
        return m7649toStringimpl(this.packedValue);
    }

    public static final /* synthetic */ long access$getUnspecified$cp() {
        return Unspecified;
    }

    public static final /* synthetic */ long access$getZero$cp() {
        return Zero;
    }

    private /* synthetic */ DpSize(long r100) {
        this.packedValue = r100;
    }

    /* JADX INFO: renamed from: component1-D9Ej5fM, reason: not valid java name */
    public static final float m7631component1D9Ej5fM(long r100) {
        return m7642getWidthD9Ej5fM(r100);
    }

    /* JADX INFO: renamed from: component2-D9Ej5fM, reason: not valid java name */
    public static final float m7632component2D9Ej5fM(long r100) {
        return m7640getHeightD9Ej5fM(r100);
    }

    /* JADX INFO: renamed from: getHeight-D9Ej5fM, reason: not valid java name */
    public static final float m7640getHeightD9Ej5fM(long r100) {
        return Dp.m7544constructorimpl(Float.intBitsToFloat((int) (r100 & BodyPartID.bodyIdMax)));
    }

    /* JADX INFO: renamed from: getWidth-D9Ej5fM, reason: not valid java name */
    public static final float m7642getWidthD9Ej5fM(long r100) {
        return Dp.m7544constructorimpl(Float.intBitsToFloat((int) (r100 >> 32)));
    }

    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m7649toStringimpl(long r100) {
        if (r100 == androidx.compose.ui.geometry.InlineClassHelperKt.UnspecifiedPackedFloats) goto L5;
        boolean r101 = true;
    L6:
        if (r101 == true) goto L10;
        return "DpSize.Unspecified";
    L10:
        return Dp.m7555toStringimpl(m7642getWidthD9Ej5fM(r100)) + " x " + Dp.m7555toStringimpl(m7640getHeightD9Ej5fM(r100));
    L5:
        r101 = false;
        goto L6
    }

    /* JADX INFO: renamed from: div-Gh9hcWk, reason: not valid java name */
    public static final long m7637divGh9hcWk(long r100, int r101) {
        float r102 = r101;
        float r103 = Dp.m7544constructorimpl(m7642getWidthD9Ej5fM(r100) / r102);
        float r104 = Dp.m7544constructorimpl(m7640getHeightD9Ej5fM(r100) / r102);
        return m7633constructorimpl((Float.floatToRawIntBits(r103) << 32) | (Float.floatToRawIntBits(r104) & BodyPartID.bodyIdMax));
    }

    /* JADX INFO: renamed from: minus-e_xh8Ic, reason: not valid java name */
    public static final long m7645minuse_xh8Ic(long r100, long r101) {
        float r102 = Dp.m7544constructorimpl(m7642getWidthD9Ej5fM(r100) - m7642getWidthD9Ej5fM(r101));
        float r103 = Dp.m7544constructorimpl(m7640getHeightD9Ej5fM(r100) - m7640getHeightD9Ej5fM(r101));
        return m7633constructorimpl((Float.floatToRawIntBits(r102) << 32) | (BodyPartID.bodyIdMax & Float.floatToRawIntBits(r103)));
    }

    /* JADX INFO: renamed from: plus-e_xh8Ic, reason: not valid java name */
    public static final long m7646pluse_xh8Ic(long r100, long r101) {
        float r102 = Dp.m7544constructorimpl(m7642getWidthD9Ej5fM(r100) + m7642getWidthD9Ej5fM(r101));
        float r103 = Dp.m7544constructorimpl(m7640getHeightD9Ej5fM(r100) + m7640getHeightD9Ej5fM(r101));
        return m7633constructorimpl((Float.floatToRawIntBits(r102) << 32) | (BodyPartID.bodyIdMax & Float.floatToRawIntBits(r103)));
    }

    /* JADX INFO: renamed from: times-Gh9hcWk, reason: not valid java name */
    public static final long m7648timesGh9hcWk(long r100, int r101) {
        float r102 = r101;
        float r103 = Dp.m7544constructorimpl(m7642getWidthD9Ej5fM(r100) * r102);
        float r104 = Dp.m7544constructorimpl(m7640getHeightD9Ej5fM(r100) * r102);
        return m7633constructorimpl((Float.floatToRawIntBits(r103) << 32) | (Float.floatToRawIntBits(r104) & BodyPartID.bodyIdMax));
    }

    /* JADX INFO: renamed from: div-Gh9hcWk, reason: not valid java name */
    public static final long m7636divGh9hcWk(long r100, float r101) {
        float r102 = Dp.m7544constructorimpl(m7642getWidthD9Ej5fM(r100) / r101);
        float r103 = Dp.m7544constructorimpl(m7640getHeightD9Ej5fM(r100) / r101);
        return m7633constructorimpl((Float.floatToRawIntBits(r102) << 32) | (Float.floatToRawIntBits(r103) & BodyPartID.bodyIdMax));
    }

    /* JADX INFO: renamed from: times-Gh9hcWk, reason: not valid java name */
    public static final long m7647timesGh9hcWk(long r100, float r101) {
        float r102 = Dp.m7544constructorimpl(m7642getWidthD9Ej5fM(r100) * r101);
        float r103 = Dp.m7544constructorimpl(m7640getHeightD9Ej5fM(r100) * r101);
        return m7633constructorimpl((Float.floatToRawIntBits(r102) << 32) | (Float.floatToRawIntBits(r103) & BodyPartID.bodyIdMax));
    }

    /* JADX INFO: renamed from: copy-DwJknco, reason: not valid java name */
    public static final long m7634copyDwJknco(long r100, float r101, float r102) {
        return m7633constructorimpl((Float.floatToRawIntBits(r101) << 32) | (((long) Float.floatToRawIntBits(r102)) & BodyPartID.bodyIdMax));
    }

    /* JADX INFO: renamed from: copy-DwJknco$default, reason: not valid java name */
    public static /* synthetic */ long m7635copyDwJknco$default(long r100, float r101, float r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = m7642getWidthD9Ej5fM(r100);
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = m7640getHeightD9Ej5fM(r100);
    L9:
        return m7634copyDwJknco(r100, r101, r102);
    }
}
