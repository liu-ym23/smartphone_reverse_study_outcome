package androidx.compose.ui.layout;

import B7.a;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0081@\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0012\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u001a\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u0010\u001b\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\u001c\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0012\u0010\b\u001a\u00020\t8Æ\u0002¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0012\u0010\f\u001a\u00020\t8Æ\u0002¢\u0006\u0006\u001a\u0004\b\r\u0010\u000bR\u0012\u0010\u000e\u001a\u00020\t8Æ\u0002¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u000bR\u0012\u0010\u0010\u001a\u00020\t8Æ\u0002¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u000b\u0088\u0001\u0002¨\u0006\u001d"}, d2 = {"Landroidx/compose/ui/layout/ValueInsets;", "", "packedValue", "", "constructor-impl", "(J)J", "getPackedValue", "()J", "left", "", "getLeft-impl", "(J)I", "top", "getTop-impl", "right", "getRight-impl", "bottom", "getBottom-impl", "toString", "", "toString-impl", "(J)Ljava/lang/String;", "equals", "", "other", "equals-impl", "(JLjava/lang/Object;)Z", "hashCode", "hashCode-impl", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class ValueInsets {
    private final long packedValue;

    private /* synthetic */ ValueInsets(long j5) {
        this.packedValue = j5;
    }

    /* renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ ValueInsets m5660boximpl(long j5) {
        return new ValueInsets(j5);
    }

    /* renamed from: constructor-impl, reason: not valid java name */
    public static long m5661constructorimpl(long j5) {
        return j5;
    }

    /* renamed from: equals-impl, reason: not valid java name */
    public static boolean m5662equalsimpl(long j5, Object obj) {
        return (obj instanceof ValueInsets) && j5 == ((ValueInsets) obj).m5670unboximpl();
    }

    /* renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m5663equalsimpl0(long j5, long j6) {
        return j5 == j6;
    }

    /* renamed from: getBottom-impl, reason: not valid java name */
    public static final int m5664getBottomimpl(long j5) {
        return (int) (j5 & 65535);
    }

    /* renamed from: getLeft-impl, reason: not valid java name */
    public static final int m5665getLeftimpl(long j5) {
        return (int) ((j5 >>> 48) & 65535);
    }

    /* renamed from: getRight-impl, reason: not valid java name */
    public static final int m5666getRightimpl(long j5) {
        return (int) ((j5 >>> 16) & 65535);
    }

    /* renamed from: getTop-impl, reason: not valid java name */
    public static final int m5667getTopimpl(long j5) {
        return (int) ((j5 >>> 32) & 65535);
    }

    /* renamed from: hashCode-impl, reason: not valid java name */
    public static int m5668hashCodeimpl(long j5) {
        return Long.hashCode(j5);
    }

    /* renamed from: toString-impl, reason: not valid java name */
    public static String m5669toStringimpl(long j5) {
        StringBuilder sb = new StringBuilder("ValueInsets(");
        sb.append((int) ((j5 >>> 48) & 65535));
        sb.append(", ");
        sb.append((int) ((j5 >>> 32) & 65535));
        sb.append(", ");
        sb.append((int) ((j5 >>> 16) & 65535));
        sb.append(", ");
        return a.o(sb, (int) (j5 & 65535), ')');
    }

    public boolean equals(Object obj) {
        return m5662equalsimpl(this.packedValue, obj);
    }

    public final long getPackedValue() {
        return this.packedValue;
    }

    public int hashCode() {
        return m5668hashCodeimpl(this.packedValue);
    }

    public String toString() {
        return m5669toStringimpl(this.packedValue);
    }

    /* renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ long m5670unboximpl() {
        return this.packedValue;
    }
}
