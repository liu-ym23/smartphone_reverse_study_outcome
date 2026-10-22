package androidx.compose.material3;

import com.ss.android.socialbase.downloader.constants.DownloadConstants;
import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.bouncycastle.asn1.cmc.BodyPartID;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0081@\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0011\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u001a\u0010\b\u001a\u00020\t8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\t8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u000f\u0010\u000b\u001a\u0004\b\u0010\u0010\r\u0088\u0001\u0002¨\u0006\u001b"}, d2 = {"Landroidx/compose/material3/SliderRange;", "", "packedValue", "", "constructor-impl", "(J)J", "getPackedValue", "()J", "start", "", "getStart$annotations", "()V", "getStart-impl", "(J)F", "endInclusive", "getEndInclusive$annotations", "getEndInclusive-impl", "toString", "", "toString-impl", "(J)Ljava/lang/String;", "equals", "", "other", "hashCode", "", "Companion", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
@JvmInline
public final class SliderRange {
    public static final Companion Companion = null;
    private static final long Unspecified = 0;
    private final long packedValue;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001e\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\t\u0012\u0004\b\u0006\u0010\u0003\u001a\u0004\b\u0007\u0010\b¨\u0006\n"}, d2 = {"Landroidx/compose/material3/SliderRange$Companion;", "", "<init>", "()V", "Unspecified", "Landroidx/compose/material3/SliderRange;", "getUnspecified-FYbKRX4$annotations", "getUnspecified-FYbKRX4", "()J", "J", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        /* JADX INFO: renamed from: getUnspecified-FYbKRX4$annotations, reason: not valid java name */
        public static /* synthetic */ void m2688getUnspecifiedFYbKRX4$annotations() {
        }

        /* JADX INFO: renamed from: getUnspecified-FYbKRX4, reason: not valid java name */
        public final long m2689getUnspecifiedFYbKRX4() {
            return SliderRange.access$getUnspecified$cp();
        }
    }

    /* JADX INFO: renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ SliderRange m2679boximpl(long r100) {
        return new SliderRange(r100);
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static long m2680constructorimpl(long r100) {
        return r100;
    }

    /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
    public static boolean m2681equalsimpl(long r100, Object r101) {
        if ((r101 instanceof SliderRange) == true) goto L6;
        return false;
    L6:
        if (r100 == ((SliderRange) r101).m2687unboximpl()) goto L8;
        return false;
    L8:
        return true;
    }

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m2682equalsimpl0(long r100, long r101) {
        if (r100 != r101) goto L5;
        return true;
    L5:
        return false;
    }

    public static /* synthetic */ void getEndInclusive$annotations() {
    }

    public static /* synthetic */ void getStart$annotations() {
    }

    /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
    public static int m2685hashCodeimpl(long r100) {
        return (int) (r100 ^ (r100 >>> 32));
    }

    public boolean equals(Object r100) {
        return m2681equalsimpl(this.packedValue, r100);
    }

    public int hashCode() {
        return m2685hashCodeimpl(this.packedValue);
    }

    /* JADX INFO: renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ long m2687unboximpl() {
        return this.packedValue;
    }

    static {
        Companion = new Companion(null);
        Unspecified = SliderKt.SliderRange(Float.NaN, Float.NaN);
    }

    public String toString() {
        return m2686toStringimpl(this.packedValue);
    }

    public static final /* synthetic */ long access$getUnspecified$cp() {
        return Unspecified;
    }

    public final long getPackedValue() {
        return this.packedValue;
    }

    private /* synthetic */ SliderRange(long r100) {
        this.packedValue = r100;
    }

    /* JADX INFO: renamed from: getEndInclusive-impl, reason: not valid java name */
    public static final float m2683getEndInclusiveimpl(long r100) {
        if (r100 == Unspecified) goto L5;
        boolean r101 = true;
    L6:
        if (r101 == false) goto L10;
        return Float.intBitsToFloat((int) (r100 & BodyPartID.bodyIdMax));
    L10:
        throw new IllegalStateException("SliderRange is unspecified".toString());
    L5:
        r101 = false;
        goto L6
    }

    /* JADX INFO: renamed from: getStart-impl, reason: not valid java name */
    public static final float m2684getStartimpl(long r100) {
        if (r100 == Unspecified) goto L5;
        boolean r101 = true;
    L6:
        if (r101 == false) goto L10;
        return Float.intBitsToFloat((int) (r100 >> 32));
    L10:
        throw new IllegalStateException("SliderRange is unspecified".toString());
    L5:
        r101 = false;
        goto L6
    }

    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m2686toStringimpl(long r100) {
        if (SliderKt.m2674isSpecifiedIf1S1O4(r100) == true) goto L7;
        return "FloatRange.Unspecified";
    L7:
        return m2684getStartimpl(r100) + DownloadConstants.VULNERABILITY_PATH + m2683getEndInclusiveimpl(r100);
    }
}
