package androidx.compose.ui.layout;

import com.bytedance.android.live.core.anim.LiveDegradeFpsAnimator;
import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.bouncycastle.asn1.cmc.BodyPartID;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0015\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087@\u0018\u0000 '2\u00020\u0001:\u0001'B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0011\u001a\u00020\tH\u0087\n¢\u0006\u0004\b\u0012\u0010\rJ\u0010\u0010\u0013\u001a\u00020\tH\u0087\n¢\u0006\u0004\b\u0014\u0010\rJ!\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\u000e\u001a\u00020\t¢\u0006\u0004\b\u0016\u0010\u0017J\u0018\u0010\u0018\u001a\u00020\u00002\u0006\u0010\u0019\u001a\u00020\tH\u0087\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ\u0018\u0010\u001c\u001a\u00020\u00002\u0006\u0010\u0019\u001a\u00020\tH\u0087\u0002¢\u0006\u0004\b\u001d\u0010\u001bJ\u000f\u0010\u001e\u001a\u00020\u001fH\u0016¢\u0006\u0004\b \u0010!J\u0013\u0010\"\u001a\u00020#2\b\u0010$\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010%\u001a\u00020&HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u001b\u0010\b\u001a\u00020\t8Æ\u0002X\u0087\u0004¢\u0006\f\u0012\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001b\u0010\u000e\u001a\u00020\t8Æ\u0002X\u0087\u0004¢\u0006\f\u0012\u0004\b\u000f\u0010\u000b\u001a\u0004\b\u0010\u0010\r\u0088\u0001\u0002¨\u0006("}, d2 = {"Landroidx/compose/ui/layout/ScaleFactor;", "", "packedValue", "", "constructor-impl", "(J)J", "getPackedValue", "()J", LiveDegradeFpsAnimator.SCALE_X, "", "getScaleX$annotations", "()V", "getScaleX-impl", "(J)F", LiveDegradeFpsAnimator.SCALE_Y, "getScaleY$annotations", "getScaleY-impl", "component1", "component1-impl", "component2", "component2-impl", "copy", "copy-8GGzs04", "(JFF)J", "times", "operand", "times-44nBxM0", "(JF)J", "div", "div-44nBxM0", "toString", "", "toString-impl", "(J)Ljava/lang/String;", "equals", "", "other", "hashCode", "", "Companion", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
@JvmInline
public final class ScaleFactor {
    public static final Companion Companion = null;
    private static final long Unspecified = 0;
    private final long packedValue;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001e\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\t\u0012\u0004\b\u0006\u0010\u0003\u001a\u0004\b\u0007\u0010\b¨\u0006\n"}, d2 = {"Landroidx/compose/ui/layout/ScaleFactor$Companion;", "", "<init>", "()V", "Unspecified", "Landroidx/compose/ui/layout/ScaleFactor;", "getUnspecified-_hLwfpc$annotations", "getUnspecified-_hLwfpc", "()J", "J", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        /* JADX INFO: renamed from: getUnspecified-_hLwfpc$annotations, reason: not valid java name */
        public static /* synthetic */ void m6358getUnspecified_hLwfpc$annotations() {
        }

        /* JADX INFO: renamed from: getUnspecified-_hLwfpc, reason: not valid java name */
        public final long m6359getUnspecified_hLwfpc() {
            return ScaleFactor.access$getUnspecified$cp();
        }
    }

    /* JADX INFO: renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ ScaleFactor m6343boximpl(long r100) {
        return new ScaleFactor(r100);
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static long m6346constructorimpl(long r100) {
        return r100;
    }

    /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
    public static boolean m6350equalsimpl(long r100, Object r101) {
        if ((r101 instanceof ScaleFactor) == true) goto L6;
        return false;
    L6:
        if (r100 == ((ScaleFactor) r101).m6357unboximpl()) goto L8;
        return false;
    L8:
        return true;
    }

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m6351equalsimpl0(long r100, long r101) {
        if (r100 != r101) goto L5;
        return true;
    L5:
        return false;
    }

    public static /* synthetic */ void getScaleX$annotations() {
    }

    public static /* synthetic */ void getScaleY$annotations() {
    }

    /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
    public static int m6354hashCodeimpl(long r100) {
        return (int) (r100 ^ (r100 >>> 32));
    }

    public boolean equals(Object r100) {
        return m6350equalsimpl(this.packedValue, r100);
    }

    public int hashCode() {
        return m6354hashCodeimpl(this.packedValue);
    }

    /* JADX INFO: renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ long m6357unboximpl() {
        return this.packedValue;
    }

    static {
        Companion = new Companion(null);
        Unspecified = m6346constructorimpl((Float.floatToRawIntBits(Float.NaN) << 32) | (Float.floatToRawIntBits(Float.NaN) & BodyPartID.bodyIdMax));
    }

    public String toString() {
        return m6356toStringimpl(this.packedValue);
    }

    public static final /* synthetic */ long access$getUnspecified$cp() {
        return Unspecified;
    }

    public final long getPackedValue() {
        return this.packedValue;
    }

    private /* synthetic */ ScaleFactor(long r100) {
        this.packedValue = r100;
    }

    /* JADX INFO: renamed from: component1-impl, reason: not valid java name */
    public static final float m6344component1impl(long r100) {
        return Float.intBitsToFloat((int) (r100 >> 32));
    }

    /* JADX INFO: renamed from: component2-impl, reason: not valid java name */
    public static final float m6345component2impl(long r100) {
        return Float.intBitsToFloat((int) (r100 & BodyPartID.bodyIdMax));
    }

    /* JADX INFO: renamed from: getScaleX-impl, reason: not valid java name */
    public static final float m6352getScaleXimpl(long r100) {
        return Float.intBitsToFloat((int) (r100 >> 32));
    }

    /* JADX INFO: renamed from: getScaleY-impl, reason: not valid java name */
    public static final float m6353getScaleYimpl(long r100) {
        return Float.intBitsToFloat((int) (r100 & BodyPartID.bodyIdMax));
    }

    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m6356toStringimpl(long r100) {
        return "ScaleFactor(" + Float.intBitsToFloat((int) (r100 >> 32)) + ", " + Float.intBitsToFloat((int) (r100 & BodyPartID.bodyIdMax)) + ')';
    }

    /* JADX INFO: renamed from: div-44nBxM0, reason: not valid java name */
    public static final long m6349div44nBxM0(long r100, float r101) {
        float r102 = Float.intBitsToFloat((int) (r100 >> 32)) / r101;
        float r103 = Float.intBitsToFloat((int) (r100 & BodyPartID.bodyIdMax)) / r101;
        return m6346constructorimpl((Float.floatToRawIntBits(r102) << 32) | (Float.floatToRawIntBits(r103) & BodyPartID.bodyIdMax));
    }

    /* JADX INFO: renamed from: times-44nBxM0, reason: not valid java name */
    public static final long m6355times44nBxM0(long r100, float r101) {
        float r102 = Float.intBitsToFloat((int) (r100 >> 32)) * r101;
        float r103 = Float.intBitsToFloat((int) (r100 & BodyPartID.bodyIdMax)) * r101;
        return m6346constructorimpl((Float.floatToRawIntBits(r102) << 32) | (Float.floatToRawIntBits(r103) & BodyPartID.bodyIdMax));
    }

    /* JADX INFO: renamed from: copy-8GGzs04, reason: not valid java name */
    public static final long m6347copy8GGzs04(long r100, float r101, float r102) {
        return m6346constructorimpl((Float.floatToRawIntBits(r101) << 32) | (((long) Float.floatToRawIntBits(r102)) & BodyPartID.bodyIdMax));
    }

    /* JADX INFO: renamed from: copy-8GGzs04$default, reason: not valid java name */
    public static /* synthetic */ long m6348copy8GGzs04$default(long r100, float r101, float r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = Float.intBitsToFloat((int) (r100 >> 32));
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = Float.intBitsToFloat((int) (BodyPartID.bodyIdMax & r100));
    L9:
        return m6347copy8GGzs04(r100, r101, r102);
    }
}
