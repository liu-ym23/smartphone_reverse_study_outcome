package androidx.compose.foundation.lazy.staggeredgrid;

import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import org.bouncycastle.asn1.cmc.BodyPartID;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0081@\u0018\u00002\u00020\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u0019\b\u0016\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\u0004\u0010\tJ\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0007HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0012\u0010\f\u001a\u00020\u00078Æ\u0002¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u0012\u0010\u000f\u001a\u00020\u00078Æ\u0002¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u000eR\u0012\u0010\u0011\u001a\u00020\u00078Æ\u0002¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u000e\u0088\u0001\u0002¨\u0006\u0019"}, d2 = {"Landroidx/compose/foundation/lazy/staggeredgrid/SpanRange;", "", "packedValue", "", "constructor-impl", "(J)J", "lane", "", "span", "(II)J", "getPackedValue", "()J", "start", "getStart-impl", "(J)I", "end", "getEnd-impl", "size", "getSize-impl", "equals", "", "other", "hashCode", "toString", "", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
@JvmInline
public final class SpanRange {
    private final long packedValue;

    /* JADX INFO: renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ SpanRange m955boximpl(long r100) {
        return new SpanRange(r100);
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    private static long m957constructorimpl(long r100) {
        return r100;
    }

    /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
    public static boolean m958equalsimpl(long r100, Object r101) {
        if ((r101 instanceof SpanRange) == true) goto L6;
        return false;
    L6:
        if (r100 == ((SpanRange) r101).m965unboximpl()) goto L8;
        return false;
    L8:
        return true;
    }

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m959equalsimpl0(long r100, long r101) {
        if (r100 != r101) goto L5;
        return true;
    L5:
        return false;
    }

    /* JADX INFO: renamed from: getEnd-impl, reason: not valid java name */
    public static final int m960getEndimpl(long r100) {
        return (int) (r100 & BodyPartID.bodyIdMax);
    }

    /* JADX INFO: renamed from: getSize-impl, reason: not valid java name */
    public static final int m961getSizeimpl(long r100) {
        return ((int) (BodyPartID.bodyIdMax & r100)) - ((int) (r100 >> 32));
    }

    /* JADX INFO: renamed from: getStart-impl, reason: not valid java name */
    public static final int m962getStartimpl(long r100) {
        return (int) (r100 >> 32);
    }

    /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
    public static int m963hashCodeimpl(long r100) {
        return (int) (r100 ^ (r100 >>> 32));
    }

    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m964toStringimpl(long r100) {
        return "SpanRange(packedValue=" + r100 + ')';
    }

    public boolean equals(Object r100) {
        return m958equalsimpl(this.packedValue, r100);
    }

    public int hashCode() {
        return m963hashCodeimpl(this.packedValue);
    }

    public String toString() {
        return m964toStringimpl(this.packedValue);
    }

    /* JADX INFO: renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ long m965unboximpl() {
        return this.packedValue;
    }

    public final long getPackedValue() {
        return this.packedValue;
    }

    private /* synthetic */ SpanRange(long r100) {
        this.packedValue = r100;
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static long m956constructorimpl(int r100, int r101) {
        long r102 = ((long) r100) << 32;
        return m957constructorimpl((((long) (r101 + r100)) & BodyPartID.bodyIdMax) | r102);
    }
}
