package androidx.compose.ui.unit;

import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.bouncycastle.asn1.cmc.BodyPartID;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u001f\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087@\u0018\u0000 .2\u00020\u0001:\u0001.B\u0011\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u000f\u001a\u00020\u0007H\u0087\n¢\u0006\u0004\b\u0010\u0010\u000bJ\u0010\u0010\u0011\u001a\u00020\u0007H\u0087\n¢\u0006\u0004\b\u0012\u0010\u000bJ!\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\f\u001a\u00020\u0007¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0016\u001a\u00020\u0000H\u0087\u0002¢\u0006\u0004\b\u0017\u0010\u0005J\u0018\u0010\u0018\u001a\u00020\u00002\u0006\u0010\u0019\u001a\u00020\u0000H\u0087\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ\u0018\u0010\u001c\u001a\u00020\u00002\u0006\u0010\u0019\u001a\u00020\u0000H\u0087\u0002¢\u0006\u0004\b\u001d\u0010\u001bJ\u0018\u0010\u001e\u001a\u00020\u00002\u0006\u0010\u001f\u001a\u00020\u0007H\u0087\u0002¢\u0006\u0004\b \u0010!J\u0018\u0010\"\u001a\u00020\u00002\u0006\u0010\u001f\u001a\u00020\u0007H\u0087\u0002¢\u0006\u0004\b#\u0010!J\u0018\u0010$\u001a\u00020\u00002\u0006\u0010\u001f\u001a\u00020\u0007H\u0087\u0002¢\u0006\u0004\b%\u0010!J\u000f\u0010&\u001a\u00020'H\u0016¢\u0006\u0004\b(\u0010)J\u0013\u0010*\u001a\u00020+2\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010,\u001a\u00020-HÖ\u0001R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u00020\u00078FX\u0087\u0004¢\u0006\f\u0012\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\u00078FX\u0087\u0004¢\u0006\f\u0012\u0004\b\r\u0010\t\u001a\u0004\b\u000e\u0010\u000b\u0088\u0001\u0002\u0092\u0001\u00020\u0003¨\u0006/"}, d2 = {"Landroidx/compose/ui/unit/Velocity;", "", "packedValue", "", "constructor-impl", "(J)J", "x", "", "getX$annotations", "()V", "getX-impl", "(J)F", "y", "getY$annotations", "getY-impl", "component1", "component1-impl", "component2", "component2-impl", "copy", "copy-OhffZ5M", "(JFF)J", "unaryMinus", "unaryMinus-9UxMQ8M", "minus", "other", "minus-AH228Gc", "(JJ)J", "plus", "plus-AH228Gc", "times", "operand", "times-adjELrA", "(JF)J", "div", "div-adjELrA", "rem", "rem-adjELrA", "toString", "", "toString-impl", "(J)Ljava/lang/String;", "equals", "", "hashCode", "", "Companion", "ui-unit"}, k = 1, mv = {2, 0, 0}, xi = 48)
@JvmInline
public final class Velocity {
    public static final Companion Companion = null;
    private static final long Zero = 0;
    private final long packedValue;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001e\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\t\u0012\u0004\b\u0006\u0010\u0003\u001a\u0004\b\u0007\u0010\b¨\u0006\n"}, d2 = {"Landroidx/compose/ui/unit/Velocity$Companion;", "", "<init>", "()V", "Zero", "Landroidx/compose/ui/unit/Velocity;", "getZero-9UxMQ8M$annotations", "getZero-9UxMQ8M", "()J", "J", "ui-unit"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        /* JADX INFO: renamed from: getZero-9UxMQ8M$annotations, reason: not valid java name */
        public static /* synthetic */ void m7796getZero9UxMQ8M$annotations() {
        }

        /* JADX INFO: renamed from: getZero-9UxMQ8M, reason: not valid java name */
        public final long m7797getZero9UxMQ8M() {
            return Velocity.access$getZero$cp();
        }
    }

    /* JADX INFO: renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ Velocity m7777boximpl(long r100) {
        return new Velocity(r100);
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static long m7780constructorimpl(long r100) {
        return r100;
    }

    /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
    public static boolean m7784equalsimpl(long r100, Object r101) {
        if ((r101 instanceof Velocity) == true) goto L6;
        return false;
    L6:
        if (r100 == ((Velocity) r101).m7795unboximpl()) goto L8;
        return false;
    L8:
        return true;
    }

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m7785equalsimpl0(long r100, long r101) {
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
    public static int m7788hashCodeimpl(long r100) {
        return (int) (r100 ^ (r100 >>> 32));
    }

    public boolean equals(Object r100) {
        return m7784equalsimpl(this.packedValue, r100);
    }

    public int hashCode() {
        return m7788hashCodeimpl(this.packedValue);
    }

    /* JADX INFO: renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ long m7795unboximpl() {
        return this.packedValue;
    }

    static {
        Companion = new Companion(null);
        Zero = m7780constructorimpl(0);
    }

    public String toString() {
        return m7793toStringimpl(this.packedValue);
    }

    public static final /* synthetic */ long access$getZero$cp() {
        return Zero;
    }

    private /* synthetic */ Velocity(long r100) {
        this.packedValue = r100;
    }

    /* JADX INFO: renamed from: component1-impl, reason: not valid java name */
    public static final float m7778component1impl(long r100) {
        return m7786getXimpl(r100);
    }

    /* JADX INFO: renamed from: component2-impl, reason: not valid java name */
    public static final float m7779component2impl(long r100) {
        return m7787getYimpl(r100);
    }

    /* JADX INFO: renamed from: getX-impl, reason: not valid java name */
    public static final float m7786getXimpl(long r100) {
        return Float.intBitsToFloat((int) (r100 >> 32));
    }

    /* JADX INFO: renamed from: getY-impl, reason: not valid java name */
    public static final float m7787getYimpl(long r100) {
        return Float.intBitsToFloat((int) (r100 & BodyPartID.bodyIdMax));
    }

    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m7793toStringimpl(long r100) {
        return "(" + m7786getXimpl(r100) + ", " + m7787getYimpl(r100) + ") px/sec";
    }

    /* JADX INFO: renamed from: unaryMinus-9UxMQ8M, reason: not valid java name */
    public static final long m7794unaryMinus9UxMQ8M(long r100) {
        return m7780constructorimpl(r100 ^ (-9223372034707292160L));
    }

    /* JADX INFO: renamed from: div-adjELrA, reason: not valid java name */
    public static final long m7783divadjELrA(long r100, float r101) {
        float r102 = Float.intBitsToFloat((int) (r100 >> 32)) / r101;
        float r103 = Float.intBitsToFloat((int) (r100 & BodyPartID.bodyIdMax)) / r101;
        return m7780constructorimpl((Float.floatToRawIntBits(r102) << 32) | (Float.floatToRawIntBits(r103) & BodyPartID.bodyIdMax));
    }

    /* JADX INFO: renamed from: minus-AH228Gc, reason: not valid java name */
    public static final long m7789minusAH228Gc(long r100, long r101) {
        float r102 = Float.intBitsToFloat((int) (r100 >> 32)) - Float.intBitsToFloat((int) (r101 >> 32));
        float r103 = Float.intBitsToFloat((int) (r100 & BodyPartID.bodyIdMax)) - Float.intBitsToFloat((int) (r101 & BodyPartID.bodyIdMax));
        return m7780constructorimpl((Float.floatToRawIntBits(r102) << 32) | (Float.floatToRawIntBits(r103) & BodyPartID.bodyIdMax));
    }

    /* JADX INFO: renamed from: plus-AH228Gc, reason: not valid java name */
    public static final long m7790plusAH228Gc(long r100, long r101) {
        float r102 = Float.intBitsToFloat((int) (r100 >> 32)) + Float.intBitsToFloat((int) (r101 >> 32));
        float r103 = Float.intBitsToFloat((int) (r100 & BodyPartID.bodyIdMax)) + Float.intBitsToFloat((int) (r101 & BodyPartID.bodyIdMax));
        return m7780constructorimpl((Float.floatToRawIntBits(r102) << 32) | (Float.floatToRawIntBits(r103) & BodyPartID.bodyIdMax));
    }

    /* JADX INFO: renamed from: rem-adjELrA, reason: not valid java name */
    public static final long m7791remadjELrA(long r100, float r101) {
        float r102 = Float.intBitsToFloat((int) (r100 >> 32)) % r101;
        float r103 = Float.intBitsToFloat((int) (r100 & BodyPartID.bodyIdMax)) % r101;
        return m7780constructorimpl((Float.floatToRawIntBits(r102) << 32) | (Float.floatToRawIntBits(r103) & BodyPartID.bodyIdMax));
    }

    /* JADX INFO: renamed from: times-adjELrA, reason: not valid java name */
    public static final long m7792timesadjELrA(long r100, float r101) {
        float r102 = Float.intBitsToFloat((int) (r100 >> 32)) * r101;
        float r103 = Float.intBitsToFloat((int) (r100 & BodyPartID.bodyIdMax)) * r101;
        return m7780constructorimpl((Float.floatToRawIntBits(r102) << 32) | (Float.floatToRawIntBits(r103) & BodyPartID.bodyIdMax));
    }

    /* JADX INFO: renamed from: copy-OhffZ5M, reason: not valid java name */
    public static final long m7781copyOhffZ5M(long r100, float r101, float r102) {
        return m7780constructorimpl((Float.floatToRawIntBits(r101) << 32) | (((long) Float.floatToRawIntBits(r102)) & BodyPartID.bodyIdMax));
    }

    /* JADX INFO: renamed from: copy-OhffZ5M$default, reason: not valid java name */
    public static /* synthetic */ long m7782copyOhffZ5M$default(long r100, float r101, float r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = Float.intBitsToFloat((int) (r100 >> 32));
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = Float.intBitsToFloat((int) (BodyPartID.bodyIdMax & r100));
    L9:
        return m7781copyOhffZ5M(r100, r101, r102);
    }
}
