package androidx.compose.ui.unit;

import androidx.compose.runtime.Immutable;
import androidx.compose.runtime.Stable;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import kotlin.Metadata;
import kotlin.jvm.internal.e;

@Immutable
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0018\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0087@\u0018\u0000 12\u00020\u0001:\u00011B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0011\u001a\u00020\tH\u0087\n¢\u0006\u0004\b\u0012\u0010\rJ\u0010\u0010\u0013\u001a\u00020\tH\u0087\n¢\u0006\u0004\b\u0014\u0010\rJ!\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\u000e\u001a\u00020\t¢\u0006\u0004\b\u0016\u0010\u0017J\u0018\u0010\u0018\u001a\u00020\u00002\u0006\u0010\u0019\u001a\u00020\u0000H\u0087\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ\u0018\u0010\u001c\u001a\u00020\u00002\u0006\u0010\u0019\u001a\u00020\u0000H\u0087\u0002¢\u0006\u0004\b\u001d\u0010\u001bJ\u0010\u0010\u001e\u001a\u00020\u0000H\u0087\u0002¢\u0006\u0004\b\u001f\u0010\u0005J\u0018\u0010 \u001a\u00020\u00002\u0006\u0010!\u001a\u00020\"H\u0087\u0002¢\u0006\u0004\b#\u0010$J\u0018\u0010%\u001a\u00020\u00002\u0006\u0010!\u001a\u00020\"H\u0087\u0002¢\u0006\u0004\b&\u0010$J\u0018\u0010'\u001a\u00020\u00002\u0006\u0010!\u001a\u00020\tH\u0087\u0002¢\u0006\u0004\b(\u0010)J\u000f\u0010*\u001a\u00020+H\u0017¢\u0006\u0004\b,\u0010-J\u0013\u0010.\u001a\u00020/2\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00100\u001a\u00020\tHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u001a\u0010\b\u001a\u00020\t8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\t8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u000f\u0010\u000b\u001a\u0004\b\u0010\u0010\r\u0088\u0001\u0002¨\u00062"}, d2 = {"Landroidx/compose/ui/unit/IntOffset;", "", "packedValue", "", "constructor-impl", "(J)J", "getPackedValue", "()J", "x", "", "getX$annotations", "()V", "getX-impl", "(J)I", "y", "getY$annotations", "getY-impl", "component1", "component1-impl", "component2", "component2-impl", "copy", "copy-iSbpLlY", "(JII)J", "minus", "other", "minus-qkQi6aY", "(JJ)J", "plus", "plus-qkQi6aY", "unaryMinus", "unaryMinus-nOcc-ac", "times", "operand", "", "times-Bjo55l4", "(JF)J", "div", "div-Bjo55l4", "rem", "rem-Bjo55l4", "(JI)J", "toString", "", "toString-impl", "(J)Ljava/lang/String;", "equals", "", "hashCode", "Companion", "ui-unit"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class IntOffset {
    private final long packedValue;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final long Zero = m6966constructorimpl(0);
    private static final long Max = m6966constructorimpl(9223372034707292159L);

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0013\u0010\u0004\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007R\u0013\u0010\t\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\n\u0010\u0007¨\u0006\u000b"}, d2 = {"Landroidx/compose/ui/unit/IntOffset$Companion;", "", AppAgent.CONSTRUCT, "()V", "Zero", "Landroidx/compose/ui/unit/IntOffset;", "getZero-nOcc-ac", "()J", "J", "Max", "getMax-nOcc-ac", "ui-unit"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(e eVar) {
            this();
        }

        /* renamed from: getMax-nOcc-ac, reason: not valid java name */
        public final long m6982getMaxnOccac() {
            return IntOffset.Max;
        }

        /* renamed from: getZero-nOcc-ac, reason: not valid java name */
        public final long m6983getZeronOccac() {
            return IntOffset.Zero;
        }

        private Companion() {
        }
    }

    private /* synthetic */ IntOffset(long j5) {
        this.packedValue = j5;
    }

    /* renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ IntOffset m6963boximpl(long j5) {
        return new IntOffset(j5);
    }

    @Stable
    /* renamed from: component1-impl, reason: not valid java name */
    public static final int m6964component1impl(long j5) {
        return m6972getXimpl(j5);
    }

    @Stable
    /* renamed from: component2-impl, reason: not valid java name */
    public static final int m6965component2impl(long j5) {
        return m6973getYimpl(j5);
    }

    /* renamed from: constructor-impl, reason: not valid java name */
    public static long m6966constructorimpl(long j5) {
        return j5;
    }

    /* renamed from: copy-iSbpLlY, reason: not valid java name */
    public static final long m6967copyiSbpLlY(long j5, int i, int i6) {
        return m6966constructorimpl((i << 32) | (i6 & 4294967295L));
    }

    /* renamed from: copy-iSbpLlY$default, reason: not valid java name */
    public static /* synthetic */ long m6968copyiSbpLlY$default(long j5, int i, int i6, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            i = (int) (j5 >> 32);
        }
        if ((i10 & 2) != 0) {
            i6 = (int) (4294967295L & j5);
        }
        return m6967copyiSbpLlY(j5, i, i6);
    }

    @Stable
    /* renamed from: div-Bjo55l4, reason: not valid java name */
    public static final long m6969divBjo55l4(long j5, float f) {
        return m6966constructorimpl((Math.round(((int) (j5 >> 32)) / f) << 32) | (Math.round(((int) (j5 & 4294967295L)) / f) & 4294967295L));
    }

    /* renamed from: equals-impl, reason: not valid java name */
    public static boolean m6970equalsimpl(long j5, Object obj) {
        return (obj instanceof IntOffset) && j5 == ((IntOffset) obj).m6981unboximpl();
    }

    /* renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m6971equalsimpl0(long j5, long j6) {
        return j5 == j6;
    }

    @Stable
    public static /* synthetic */ void getX$annotations() {
    }

    /* renamed from: getX-impl, reason: not valid java name */
    public static final int m6972getXimpl(long j5) {
        return (int) (j5 >> 32);
    }

    @Stable
    public static /* synthetic */ void getY$annotations() {
    }

    /* renamed from: getY-impl, reason: not valid java name */
    public static final int m6973getYimpl(long j5) {
        return (int) (j5 & 4294967295L);
    }

    /* renamed from: hashCode-impl, reason: not valid java name */
    public static int m6974hashCodeimpl(long j5) {
        return Long.hashCode(j5);
    }

    @Stable
    /* renamed from: minus-qkQi6aY, reason: not valid java name */
    public static final long m6975minusqkQi6aY(long j5, long j6) {
        return m6966constructorimpl(((((int) (j5 >> 32)) - ((int) (j6 >> 32))) << 32) | ((((int) (j5 & 4294967295L)) - ((int) (j6 & 4294967295L))) & 4294967295L));
    }

    @Stable
    /* renamed from: plus-qkQi6aY, reason: not valid java name */
    public static final long m6976plusqkQi6aY(long j5, long j6) {
        return m6966constructorimpl(((((int) (j5 >> 32)) + ((int) (j6 >> 32))) << 32) | ((((int) (j5 & 4294967295L)) + ((int) (j6 & 4294967295L))) & 4294967295L));
    }

    @Stable
    /* renamed from: rem-Bjo55l4, reason: not valid java name */
    public static final long m6977remBjo55l4(long j5, int i) {
        return m6966constructorimpl(((((int) (j5 >> 32)) % i) << 32) | ((((int) (j5 & 4294967295L)) % i) & 4294967295L));
    }

    @Stable
    /* renamed from: times-Bjo55l4, reason: not valid java name */
    public static final long m6978timesBjo55l4(long j5, float f) {
        return m6966constructorimpl((Math.round(((int) (j5 >> 32)) * f) << 32) | (Math.round(((int) (j5 & 4294967295L)) * f) & 4294967295L));
    }

    @Stable
    /* renamed from: toString-impl, reason: not valid java name */
    public static String m6979toStringimpl(long j5) {
        return "(" + m6972getXimpl(j5) + ", " + m6973getYimpl(j5) + ')';
    }

    @Stable
    /* renamed from: unaryMinus-nOcc-ac, reason: not valid java name */
    public static final long m6980unaryMinusnOccac(long j5) {
        return m6966constructorimpl(((-((int) (j5 & 4294967295L))) & 4294967295L) | ((-((int) (j5 >> 32))) << 32));
    }

    public boolean equals(Object other) {
        return m6970equalsimpl(this.packedValue, other);
    }

    public final long getPackedValue() {
        return this.packedValue;
    }

    public int hashCode() {
        return m6974hashCodeimpl(this.packedValue);
    }

    @Stable
    public String toString() {
        return m6979toStringimpl(this.packedValue);
    }

    /* renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ long m6981unboximpl() {
        return this.packedValue;
    }
}
