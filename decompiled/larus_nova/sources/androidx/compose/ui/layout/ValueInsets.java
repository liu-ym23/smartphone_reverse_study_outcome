package androidx.compose.ui.layout;

import kotlin.Metadata;
import kotlin.jvm.JvmInline;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0081@\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0012\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u001a\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u0010\u001b\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\u001c\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0012\u0010\b\u001a\u00020\t8Æ\u0002¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0012\u0010\f\u001a\u00020\t8Æ\u0002¢\u0006\u0006\u001a\u0004\b\r\u0010\u000bR\u0012\u0010\u000e\u001a\u00020\t8Æ\u0002¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u000bR\u0012\u0010\u0010\u001a\u00020\t8Æ\u0002¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u000b\u0088\u0001\u0002¨\u0006\u001d"}, d2 = {"Landroidx/compose/ui/layout/ValueInsets;", "", "packedValue", "", "constructor-impl", "(J)J", "getPackedValue", "()J", "left", "", "getLeft-impl", "(J)I", "top", "getTop-impl", "right", "getRight-impl", "bottom", "getBottom-impl", "toString", "", "toString-impl", "(J)Ljava/lang/String;", "equals", "", "other", "equals-impl", "(JLjava/lang/Object;)Z", "hashCode", "hashCode-impl", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
@JvmInline
public final class ValueInsets {
    private final long packedValue;

    /* JADX INFO: renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ ValueInsets m6371boximpl(long r100) {
        return new ValueInsets(r100);
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static long m6372constructorimpl(long r100) {
        return r100;
    }

    /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
    public static boolean m6373equalsimpl(long r100, Object r101) {
        if ((r101 instanceof ValueInsets) == true) goto L6;
        return false;
    L6:
        if (r100 == ((ValueInsets) r101).m6381unboximpl()) goto L8;
        return false;
    L8:
        return true;
    }

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m6374equalsimpl0(long r100, long r101) {
        if (r100 != r101) goto L5;
        return true;
    L5:
        return false;
    }

    /* JADX INFO: renamed from: getBottom-impl, reason: not valid java name */
    public static final int m6375getBottomimpl(long r100) {
        return (int) (r100 & 65535);
    }

    /* JADX INFO: renamed from: getLeft-impl, reason: not valid java name */
    public static final int m6376getLeftimpl(long r100) {
        return (int) ((r100 >>> 48) & 65535);
    }

    /* JADX INFO: renamed from: getRight-impl, reason: not valid java name */
    public static final int m6377getRightimpl(long r100) {
        return (int) ((r100 >>> 16) & 65535);
    }

    /* JADX INFO: renamed from: getTop-impl, reason: not valid java name */
    public static final int m6378getTopimpl(long r100) {
        return (int) ((r100 >>> 32) & 65535);
    }

    /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
    public static int m6379hashCodeimpl(long r100) {
        return (int) (r100 ^ (r100 >>> 32));
    }

    public boolean equals(Object r100) {
        return m6373equalsimpl(this.packedValue, r100);
    }

    public int hashCode() {
        return m6379hashCodeimpl(this.packedValue);
    }

    /* JADX INFO: renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ long m6381unboximpl() {
        return this.packedValue;
    }

    public String toString() {
        return m6380toStringimpl(this.packedValue);
    }

    public final long getPackedValue() {
        return this.packedValue;
    }

    private /* synthetic */ ValueInsets(long r100) {
        this.packedValue = r100;
    }

    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m6380toStringimpl(long r100) {
        return "ValueInsets(" + ((int) ((r100 >>> 48) & 65535)) + ", " + ((int) ((r100 >>> 32) & 65535)) + ", " + ((int) ((r100 >>> 16) & 65535)) + ", " + ((int) (r100 & 65535)) + ')';
    }
}
