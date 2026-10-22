package androidx.compose.ui.text;

import androidx.compose.runtime.Immutable;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import kotlin.Metadata;
import kotlin.jvm.internal.e;

@Immutable
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0010\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0087@\u0018\u0000 '2\u00020\u0001:\u0001'B\u0011\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0015\u0010\u0018\u001a\u00020\u00112\u0006\u0010\u0019\u001a\u00020\u0000¢\u0006\u0004\b\u001a\u0010\u001bJ\u0018\u0010\u001c\u001a\u00020\u00112\u0006\u0010\u0019\u001a\u00020\u0000H\u0086\u0002¢\u0006\u0004\b\u001d\u0010\u001bJ\u0018\u0010\u001c\u001a\u00020\u00112\u0006\u0010\u001e\u001a\u00020\u0007H\u0086\u0002¢\u0006\u0004\b\u001f\u0010 J\u000f\u0010!\u001a\u00020\"H\u0016¢\u0006\u0004\b#\u0010$J\u0013\u0010%\u001a\u00020\u00112\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010&\u001a\u00020\u0007HÖ\u0001R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0011\u0010\n\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b\u000b\u0010\tR\u0011\u0010\f\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b\r\u0010\tR\u0011\u0010\u000e\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b\u000f\u0010\tR\u0011\u0010\u0010\u001a\u00020\u00118F¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0014\u001a\u00020\u00118F¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0013R\u0011\u0010\u0016\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b\u0017\u0010\t\u0088\u0001\u0002\u0092\u0001\u00020\u0003¨\u0006("}, d2 = {"Landroidx/compose/ui/text/TextRange;", "", "packedValue", "", "constructor-impl", "(J)J", "start", "", "getStart-impl", "(J)I", "end", "getEnd-impl", "min", "getMin-impl", "max", "getMax-impl", "collapsed", "", "getCollapsed-impl", "(J)Z", "reversed", "getReversed-impl", "length", "getLength-impl", "intersects", "other", "intersects-5zc-tL8", "(JJ)Z", "contains", "contains-5zc-tL8", TypedValues.CycleType.S_WAVE_OFFSET, "contains-impl", "(JI)Z", "toString", "", "toString-impl", "(J)Ljava/lang/String;", "equals", "hashCode", "Companion", "ui-text"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class TextRange {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final long Zero = TextRangeKt.TextRange(0);
    private final long packedValue;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0013\u0010\u0004\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007¨\u0006\t"}, d2 = {"Landroidx/compose/ui/text/TextRange$Companion;", "", AppAgent.CONSTRUCT, "()V", "Zero", "Landroidx/compose/ui/text/TextRange;", "getZero-d9O1mEE", "()J", "J", "ui-text"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(e eVar) {
            this();
        }

        /* renamed from: getZero-d9O1mEE, reason: not valid java name */
        public final long m6316getZerod9O1mEE() {
            return TextRange.Zero;
        }

        private Companion() {
        }
    }

    private /* synthetic */ TextRange(long j5) {
        this.packedValue = j5;
    }

    /* renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ TextRange m6299boximpl(long j5) {
        return new TextRange(j5);
    }

    /* renamed from: constructor-impl, reason: not valid java name */
    public static long m6300constructorimpl(long j5) {
        return j5;
    }

    /* renamed from: contains-5zc-tL8, reason: not valid java name */
    public static final boolean m6301contains5zctL8(long j5, long j6) {
        return (m6309getMinimpl(j5) <= m6309getMinimpl(j6)) & (m6308getMaximpl(j6) <= m6308getMaximpl(j5));
    }

    /* renamed from: contains-impl, reason: not valid java name */
    public static final boolean m6302containsimpl(long j5, int i) {
        return i < m6308getMaximpl(j5) && m6309getMinimpl(j5) <= i;
    }

    /* renamed from: equals-impl, reason: not valid java name */
    public static boolean m6303equalsimpl(long j5, Object obj) {
        return (obj instanceof TextRange) && j5 == ((TextRange) obj).getPackedValue();
    }

    /* renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m6304equalsimpl0(long j5, long j6) {
        return j5 == j6;
    }

    /* renamed from: getCollapsed-impl, reason: not valid java name */
    public static final boolean m6305getCollapsedimpl(long j5) {
        return m6311getStartimpl(j5) == m6306getEndimpl(j5);
    }

    /* renamed from: getEnd-impl, reason: not valid java name */
    public static final int m6306getEndimpl(long j5) {
        return (int) (j5 & 4294967295L);
    }

    /* renamed from: getLength-impl, reason: not valid java name */
    public static final int m6307getLengthimpl(long j5) {
        return m6308getMaximpl(j5) - m6309getMinimpl(j5);
    }

    /* renamed from: getMax-impl, reason: not valid java name */
    public static final int m6308getMaximpl(long j5) {
        return Math.max(m6311getStartimpl(j5), m6306getEndimpl(j5));
    }

    /* renamed from: getMin-impl, reason: not valid java name */
    public static final int m6309getMinimpl(long j5) {
        return Math.min(m6311getStartimpl(j5), m6306getEndimpl(j5));
    }

    /* renamed from: getReversed-impl, reason: not valid java name */
    public static final boolean m6310getReversedimpl(long j5) {
        return m6311getStartimpl(j5) > m6306getEndimpl(j5);
    }

    /* renamed from: getStart-impl, reason: not valid java name */
    public static final int m6311getStartimpl(long j5) {
        return (int) (j5 >> 32);
    }

    /* renamed from: hashCode-impl, reason: not valid java name */
    public static int m6312hashCodeimpl(long j5) {
        return Long.hashCode(j5);
    }

    /* renamed from: intersects-5zc-tL8, reason: not valid java name */
    public static final boolean m6313intersects5zctL8(long j5, long j6) {
        return (m6309getMinimpl(j5) < m6308getMaximpl(j6)) & (m6309getMinimpl(j6) < m6308getMaximpl(j5));
    }

    /* renamed from: toString-impl, reason: not valid java name */
    public static String m6314toStringimpl(long j5) {
        return "TextRange(" + m6311getStartimpl(j5) + ", " + m6306getEndimpl(j5) + ')';
    }

    public boolean equals(Object other) {
        return m6303equalsimpl(this.packedValue, other);
    }

    public int hashCode() {
        return m6312hashCodeimpl(this.packedValue);
    }

    public String toString() {
        return m6314toStringimpl(this.packedValue);
    }

    /* renamed from: unbox-impl, reason: not valid java name and from getter */
    public final /* synthetic */ long getPackedValue() {
        return this.packedValue;
    }
}
