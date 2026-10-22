package androidx.compose.ui.unit;

import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.bouncycastle.asn1.cmc.BodyPartID;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0012\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0087@\u0018\u0000 \"2\u00020\u0001:\u0001\"B\u0011\b\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0011\u001a\u00020\tH\u0087\n¢\u0006\u0004\b\u0012\u0010\rJ\u0010\u0010\u0013\u001a\u00020\tH\u0087\n¢\u0006\u0004\b\u0014\u0010\rJ\u0018\u0010\u0015\u001a\u00020\u00002\u0006\u0010\u0016\u001a\u00020\tH\u0087\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\u0018\u0010\u0019\u001a\u00020\u00002\u0006\u0010\u0016\u001a\u00020\tH\u0087\u0002¢\u0006\u0004\b\u001a\u0010\u0018J\u000f\u0010\u001b\u001a\u00020\u001cH\u0017¢\u0006\u0004\b\u001d\u0010\u001eJ\u0013\u0010\u001f\u001a\u00020 2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010!\u001a\u00020\tHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u001b\u0010\b\u001a\u00020\t8Æ\u0002X\u0087\u0004¢\u0006\f\u0012\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001b\u0010\u000e\u001a\u00020\t8Æ\u0002X\u0087\u0004¢\u0006\f\u0012\u0004\b\u000f\u0010\u000b\u001a\u0004\b\u0010\u0010\r\u0088\u0001\u0002¨\u0006#"}, d2 = {"Landroidx/compose/ui/unit/IntSize;", "", "packedValue", "", "constructor-impl", "(J)J", "getPackedValue", "()J", "width", "", "getWidth$annotations", "()V", "getWidth-impl", "(J)I", "height", "getHeight$annotations", "getHeight-impl", "component1", "component1-impl", "component2", "component2-impl", "times", "other", "times-YEO4UFw", "(JI)J", "div", "div-YEO4UFw", "toString", "", "toString-impl", "(J)Ljava/lang/String;", "equals", "", "hashCode", "Companion", "ui-unit"}, k = 1, mv = {2, 0, 0}, xi = 48)
@JvmInline
public final class IntSize {
    public static final Companion Companion = null;
    private static final long Zero = 0;
    private final long packedValue;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0013\u0010\u0004\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007¨\u0006\t"}, d2 = {"Landroidx/compose/ui/unit/IntSize$Companion;", "", "<init>", "()V", "Zero", "Landroidx/compose/ui/unit/IntSize;", "getZero-YbymL2g", "()J", "J", "ui-unit"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        /* JADX INFO: renamed from: getZero-YbymL2g, reason: not valid java name */
        public final long m7724getZeroYbymL2g() {
            return IntSize.access$getZero$cp();
        }
    }

    /* JADX INFO: renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ IntSize m7711boximpl(long r100) {
        return new IntSize(r100);
    }

    /* JADX INFO: renamed from: component1-impl, reason: not valid java name */
    public static final int m7712component1impl(long r100) {
        return (int) (r100 >> 32);
    }

    /* JADX INFO: renamed from: component2-impl, reason: not valid java name */
    public static final int m7713component2impl(long r100) {
        return (int) (r100 & BodyPartID.bodyIdMax);
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static long m7714constructorimpl(long r100) {
        return r100;
    }

    /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
    public static boolean m7716equalsimpl(long r100, Object r101) {
        if ((r101 instanceof IntSize) == true) goto L6;
        return false;
    L6:
        if (r100 == ((IntSize) r101).m7723unboximpl()) goto L8;
        return false;
    L8:
        return true;
    }

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m7717equalsimpl0(long r100, long r101) {
        if (r100 != r101) goto L5;
        return true;
    L5:
        return false;
    }

    public static /* synthetic */ void getHeight$annotations() {
    }

    /* JADX INFO: renamed from: getHeight-impl, reason: not valid java name */
    public static final int m7718getHeightimpl(long r100) {
        return (int) (r100 & BodyPartID.bodyIdMax);
    }

    public static /* synthetic */ void getWidth$annotations() {
    }

    /* JADX INFO: renamed from: getWidth-impl, reason: not valid java name */
    public static final int m7719getWidthimpl(long r100) {
        return (int) (r100 >> 32);
    }

    /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
    public static int m7720hashCodeimpl(long r100) {
        return (int) (r100 ^ (r100 >>> 32));
    }

    public boolean equals(Object r100) {
        return m7716equalsimpl(this.packedValue, r100);
    }

    public int hashCode() {
        return m7720hashCodeimpl(this.packedValue);
    }

    /* JADX INFO: renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ long m7723unboximpl() {
        return this.packedValue;
    }

    static {
        Companion = new Companion(null);
        Zero = m7714constructorimpl(0);
    }

    public String toString() {
        return m7722toStringimpl(this.packedValue);
    }

    public static final /* synthetic */ long access$getZero$cp() {
        return Zero;
    }

    public final long getPackedValue() {
        return this.packedValue;
    }

    private /* synthetic */ IntSize(long r100) {
        this.packedValue = r100;
    }

    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m7722toStringimpl(long r100) {
        return ((int) (r100 >> 32)) + " x " + ((int) (r100 & BodyPartID.bodyIdMax));
    }

    /* JADX INFO: renamed from: div-YEO4UFw, reason: not valid java name */
    public static final long m7715divYEO4UFw(long r100, int r101) {
        int r102 = ((int) (r100 >> 32)) / r101;
        long r103 = ((long) (((int) (r100 & BodyPartID.bodyIdMax)) / r101)) & BodyPartID.bodyIdMax;
        return m7714constructorimpl(r103 | (((long) r102) << 32));
    }

    /* JADX INFO: renamed from: times-YEO4UFw, reason: not valid java name */
    public static final long m7721timesYEO4UFw(long r100, int r101) {
        int r102 = ((int) (r100 >> 32)) * r101;
        long r103 = ((long) (((int) (r100 & BodyPartID.bodyIdMax)) * r101)) & BodyPartID.bodyIdMax;
        return m7714constructorimpl(r103 | (((long) r102) << 32));
    }
}
