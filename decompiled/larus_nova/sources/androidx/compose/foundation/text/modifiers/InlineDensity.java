package androidx.compose.foundation.text.modifiers;

import androidx.compose.ui.unit.Density;
import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.bouncycastle.asn1.cmc.BodyPartID;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0081@\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u0019\b\u0016\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\u0004\u0010\tB\u0011\b\u0016\u0012\u0006\u0010\u0006\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\u000bJ\u000f\u0010\u000f\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0011\u0010\b\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b\u000e\u0010\r\u0088\u0001\u0002\u0092\u0001\u00020\u0003¨\u0006\u0019"}, d2 = {"Landroidx/compose/foundation/text/modifiers/InlineDensity;", "", "packedValue", "", "constructor-impl", "(J)J", "density", "", "fontScale", "(FF)J", "Landroidx/compose/ui/unit/Density;", "(Landroidx/compose/ui/unit/Density;)J", "getDensity-impl", "(J)F", "getFontScale-impl", "toString", "", "toString-impl", "(J)Ljava/lang/String;", "equals", "", "other", "hashCode", "", "Companion", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
@JvmInline
public final class InlineDensity {
    public static final Companion Companion = null;
    private static final long Unspecified = 0;
    private final long packedValue;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0013\u0010\u0004\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007¨\u0006\t"}, d2 = {"Landroidx/compose/foundation/text/modifiers/InlineDensity$Companion;", "", "<init>", "()V", "Unspecified", "Landroidx/compose/foundation/text/modifiers/InlineDensity;", "getUnspecified-L26CHvs", "()J", "J", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        /* JADX INFO: renamed from: getUnspecified-L26CHvs, reason: not valid java name */
        public final long m1391getUnspecifiedL26CHvs() {
            return InlineDensity.access$getUnspecified$cp();
        }
    }

    /* JADX INFO: renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ InlineDensity m1380boximpl(long r100) {
        return new InlineDensity(r100);
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    private static long m1382constructorimpl(long r100) {
        return r100;
    }

    /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
    public static boolean m1384equalsimpl(long r100, Object r101) {
        if ((r101 instanceof InlineDensity) == true) goto L6;
        return false;
    L6:
        if (r100 == ((InlineDensity) r101).m1390unboximpl()) goto L8;
        return false;
    L8:
        return true;
    }

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m1385equalsimpl0(long r100, long r101) {
        if (r100 != r101) goto L5;
        return true;
    L5:
        return false;
    }

    /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
    public static int m1388hashCodeimpl(long r100) {
        return (int) (r100 ^ (r100 >>> 32));
    }

    public boolean equals(Object r100) {
        return m1384equalsimpl(this.packedValue, r100);
    }

    public int hashCode() {
        return m1388hashCodeimpl(this.packedValue);
    }

    /* JADX INFO: renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ long m1390unboximpl() {
        return this.packedValue;
    }

    static {
        Companion = new Companion(null);
        Unspecified = m1381constructorimpl(Float.NaN, Float.NaN);
    }

    public String toString() {
        return m1389toStringimpl(this.packedValue);
    }

    public static final /* synthetic */ long access$getUnspecified$cp() {
        return Unspecified;
    }

    private /* synthetic */ InlineDensity(long r100) {
        this.packedValue = r100;
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static long m1383constructorimpl(Density r100) {
        return m1381constructorimpl(r100.getDensity(), r100.getFontScale());
    }

    /* JADX INFO: renamed from: getDensity-impl, reason: not valid java name */
    public static final float m1386getDensityimpl(long r100) {
        return Float.intBitsToFloat((int) (r100 >> 32));
    }

    /* JADX INFO: renamed from: getFontScale-impl, reason: not valid java name */
    public static final float m1387getFontScaleimpl(long r100) {
        return Float.intBitsToFloat((int) (r100 & BodyPartID.bodyIdMax));
    }

    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m1389toStringimpl(long r100) {
        return "InlineDensity(density=" + m1386getDensityimpl(r100) + ", fontScale=" + m1387getFontScaleimpl(r100) + ')';
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static long m1381constructorimpl(float r100, float r101) {
        long r102 = Float.floatToRawIntBits(r100);
        return m1382constructorimpl((((long) Float.floatToRawIntBits(r101)) & BodyPartID.bodyIdMax) | (r102 << 32));
    }
}
