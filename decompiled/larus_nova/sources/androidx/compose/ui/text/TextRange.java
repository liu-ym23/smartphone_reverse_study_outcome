package androidx.compose.ui.text;

import com.bytedance.ee.bear.bitable.fieldedit.BitableFieldEditAnalytic;
import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.bouncycastle.asn1.cmc.BodyPartID;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0010\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0087@\u0018\u0000 '2\u00020\u0001:\u0001'B\u0011\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0015\u0010\u0018\u001a\u00020\u00112\u0006\u0010\u0019\u001a\u00020\u0000¢\u0006\u0004\b\u001a\u0010\u001bJ\u0018\u0010\u001c\u001a\u00020\u00112\u0006\u0010\u0019\u001a\u00020\u0000H\u0086\u0002¢\u0006\u0004\b\u001d\u0010\u001bJ\u0018\u0010\u001c\u001a\u00020\u00112\u0006\u0010\u001e\u001a\u00020\u0007H\u0086\u0002¢\u0006\u0004\b\u001f\u0010 J\u000f\u0010!\u001a\u00020\"H\u0016¢\u0006\u0004\b#\u0010$J\u0013\u0010%\u001a\u00020\u00112\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010&\u001a\u00020\u0007HÖ\u0001R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0011\u0010\n\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b\u000b\u0010\tR\u0011\u0010\f\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b\r\u0010\tR\u0011\u0010\u000e\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b\u000f\u0010\tR\u0011\u0010\u0010\u001a\u00020\u00118F¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0014\u001a\u00020\u00118F¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0013R\u0011\u0010\u0016\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b\u0017\u0010\t\u0088\u0001\u0002\u0092\u0001\u00020\u0003¨\u0006("}, d2 = {"Landroidx/compose/ui/text/TextRange;", "", "packedValue", "", "constructor-impl", "(J)J", "start", "", "getStart-impl", "(J)I", "end", "getEnd-impl", BitableFieldEditAnalytic.ProgressFieldEditScene.MIN, "getMin-impl", BitableFieldEditAnalytic.ProgressFieldEditScene.MAX, "getMax-impl", "collapsed", "", "getCollapsed-impl", "(J)Z", "reversed", "getReversed-impl", "length", "getLength-impl", "intersects", "other", "intersects-5zc-tL8", "(JJ)Z", "contains", "contains-5zc-tL8", "offset", "contains-impl", "(JI)Z", "toString", "", "toString-impl", "(J)Ljava/lang/String;", "equals", "hashCode", "Companion", "ui-text"}, k = 1, mv = {2, 0, 0}, xi = 48)
@JvmInline
public final class TextRange {
    public static final Companion Companion = null;
    private static final long Zero = 0;
    private final long packedValue;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0013\u0010\u0004\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007¨\u0006\t"}, d2 = {"Landroidx/compose/ui/text/TextRange$Companion;", "", "<init>", "()V", "Zero", "Landroidx/compose/ui/text/TextRange;", "getZero-d9O1mEE", "()J", "J", "ui-text"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        /* JADX INFO: renamed from: getZero-d9O1mEE, reason: not valid java name */
        public final long m7003getZerod9O1mEE() {
            return TextRange.access$getZero$cp();
        }
    }

    /* JADX INFO: renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ TextRange m6986boximpl(long r100) {
        return new TextRange(r100);
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static long m6987constructorimpl(long r100) {
        return r100;
    }

    /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
    public static boolean m6990equalsimpl(long r100, Object r101) {
        if ((r101 instanceof TextRange) == true) goto L6;
        return false;
    L6:
        if (r100 == ((TextRange) r101).m7002unboximpl()) goto L8;
        return false;
    L8:
        return true;
    }

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m6991equalsimpl0(long r100, long r101) {
        if (r100 != r101) goto L5;
        return true;
    L5:
        return false;
    }

    /* JADX INFO: renamed from: getEnd-impl, reason: not valid java name */
    public static final int m6993getEndimpl(long r100) {
        return (int) (r100 & BodyPartID.bodyIdMax);
    }

    /* JADX INFO: renamed from: getStart-impl, reason: not valid java name */
    public static final int m6998getStartimpl(long r100) {
        return (int) (r100 >> 32);
    }

    /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
    public static int m6999hashCodeimpl(long r100) {
        return (int) (r100 ^ (r100 >>> 32));
    }

    public boolean equals(Object r100) {
        return m6990equalsimpl(this.packedValue, r100);
    }

    public int hashCode() {
        return m6999hashCodeimpl(this.packedValue);
    }

    /* JADX INFO: renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ long m7002unboximpl() {
        return this.packedValue;
    }

    static {
        Companion = new Companion(null);
        Zero = TextRangeKt.TextRange(0);
    }

    public String toString() {
        return m7001toStringimpl(this.packedValue);
    }

    public static final /* synthetic */ long access$getZero$cp() {
        return Zero;
    }

    private /* synthetic */ TextRange(long r100) {
        this.packedValue = r100;
    }

    /* JADX INFO: renamed from: getCollapsed-impl, reason: not valid java name */
    public static final boolean m6992getCollapsedimpl(long r100) {
        if (m6998getStartimpl(r100) != m6993getEndimpl(r100)) goto L5;
        return true;
    L5:
        return false;
    }

    /* JADX INFO: renamed from: getLength-impl, reason: not valid java name */
    public static final int m6994getLengthimpl(long r100) {
        return m6995getMaximpl(r100) - m6996getMinimpl(r100);
    }

    /* JADX INFO: renamed from: getMax-impl, reason: not valid java name */
    public static final int m6995getMaximpl(long r100) {
        return Math.max(m6998getStartimpl(r100), m6993getEndimpl(r100));
    }

    /* JADX INFO: renamed from: getMin-impl, reason: not valid java name */
    public static final int m6996getMinimpl(long r100) {
        return Math.min(m6998getStartimpl(r100), m6993getEndimpl(r100));
    }

    /* JADX INFO: renamed from: getReversed-impl, reason: not valid java name */
    public static final boolean m6997getReversedimpl(long r100) {
        if (m6998getStartimpl(r100) <= m6993getEndimpl(r100)) goto L5;
        return true;
    L5:
        return false;
    }

    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m7001toStringimpl(long r100) {
        return "TextRange(" + m6998getStartimpl(r100) + ", " + m6993getEndimpl(r100) + ')';
    }

    /* JADX INFO: renamed from: contains-5zc-tL8, reason: not valid java name */
    public static final boolean m6988contains5zctL8(long r100, long r101) {
        boolean r102 = true;
        if (m6996getMinimpl(r100) > m6996getMinimpl(r101)) goto L5;
        boolean r103 = true;
    L7:
        if (m6995getMaximpl(r101) <= m6995getMaximpl(r100)) goto L11;
        r102 = false;
    L11:
        return r103 & r102;
    L5:
        r103 = false;
        goto L7
    }

    /* JADX INFO: renamed from: contains-impl, reason: not valid java name */
    public static final boolean m6989containsimpl(long r100, int r101) {
        int r102 = m6996getMinimpl(r100);
        if (r101 >= m6995getMaximpl(r100)) goto L7;
        if (r102 > r101) goto L8;
        return true;
    L8:
        return false;
    L7:
        return false;
    }

    /* JADX INFO: renamed from: intersects-5zc-tL8, reason: not valid java name */
    public static final boolean m7000intersects5zctL8(long r100, long r101) {
        boolean r102 = true;
        if (m6996getMinimpl(r100) >= m6995getMaximpl(r101)) goto L5;
        boolean r103 = true;
    L7:
        if (m6996getMinimpl(r101) < m6995getMaximpl(r100)) goto L11;
        r102 = false;
    L11:
        return r103 & r102;
    L5:
        r103 = false;
        goto L7
    }
}
