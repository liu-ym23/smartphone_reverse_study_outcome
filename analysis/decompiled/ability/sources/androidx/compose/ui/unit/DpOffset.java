package androidx.compose.ui.unit;

import androidx.compose.runtime.Immutable;
import androidx.compose.runtime.Stable;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import kotlin.Metadata;
import kotlin.jvm.internal.e;

@Immutable
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087@\u0018\u0000 \"2\u00020\u0001:\u0001\"B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J!\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\u000e\u001a\u00020\t¢\u0006\u0004\b\u0012\u0010\u0013J\u0018\u0010\u0014\u001a\u00020\u00002\u0006\u0010\u0015\u001a\u00020\u0000H\u0087\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u0018\u0010\u0018\u001a\u00020\u00002\u0006\u0010\u0015\u001a\u00020\u0000H\u0087\u0002¢\u0006\u0004\b\u0019\u0010\u0017J\u000f\u0010\u001a\u001a\u00020\u001bH\u0017¢\u0006\u0004\b\u001c\u0010\u001dJ\u0013\u0010\u001e\u001a\u00020\u001f2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010 \u001a\u00020!HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u001a\u0010\b\u001a\u00020\t8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\t8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u000f\u0010\u000b\u001a\u0004\b\u0010\u0010\r\u0088\u0001\u0002¨\u0006#"}, d2 = {"Landroidx/compose/ui/unit/DpOffset;", "", "packedValue", "", "constructor-impl", "(J)J", "getPackedValue", "()J", "x", "Landroidx/compose/ui/unit/Dp;", "getX-D9Ej5fM$annotations", "()V", "getX-D9Ej5fM", "(J)F", "y", "getY-D9Ej5fM$annotations", "getY-D9Ej5fM", "copy", "copy-tPigGR8", "(JFF)J", "minus", "other", "minus-CB-Mgk4", "(JJ)J", "plus", "plus-CB-Mgk4", "toString", "", "toString-impl", "(J)Ljava/lang/String;", "equals", "", "hashCode", "", "Companion", "ui-unit"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class DpOffset {
    private final long packedValue;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final long Zero = m6900constructorimpl(0);
    private static final long Unspecified = m6900constructorimpl(androidx.compose.ui.geometry.InlineClassHelperKt.UnspecifiedPackedFloats);

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0013\u0010\u0004\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007R\u0013\u0010\t\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\n\u0010\u0007¨\u0006\u000b"}, d2 = {"Landroidx/compose/ui/unit/DpOffset$Companion;", "", AppAgent.CONSTRUCT, "()V", "Zero", "Landroidx/compose/ui/unit/DpOffset;", "getZero-RKDOV3M", "()J", "J", "Unspecified", "getUnspecified-RKDOV3M", "ui-unit"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(e eVar) {
            this();
        }

        /* renamed from: getUnspecified-RKDOV3M, reason: not valid java name */
        public final long m6914getUnspecifiedRKDOV3M() {
            return DpOffset.Unspecified;
        }

        /* renamed from: getZero-RKDOV3M, reason: not valid java name */
        public final long m6915getZeroRKDOV3M() {
            return DpOffset.Zero;
        }

        private Companion() {
        }
    }

    private /* synthetic */ DpOffset(long j5) {
        this.packedValue = j5;
    }

    /* renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ DpOffset m6899boximpl(long j5) {
        return new DpOffset(j5);
    }

    /* renamed from: constructor-impl, reason: not valid java name */
    public static long m6900constructorimpl(long j5) {
        return j5;
    }

    /* renamed from: copy-tPigGR8, reason: not valid java name */
    public static final long m6901copytPigGR8(long j5, float f, float f7) {
        return m6900constructorimpl((Float.floatToRawIntBits(f) << 32) | (Float.floatToRawIntBits(f7) & 4294967295L));
    }

    /* renamed from: copy-tPigGR8$default, reason: not valid java name */
    public static /* synthetic */ long m6902copytPigGR8$default(long j5, float f, float f7, int i, Object obj) {
        if ((i & 1) != 0) {
            f = m6905getXD9Ej5fM(j5);
        }
        if ((i & 2) != 0) {
            f7 = m6907getYD9Ej5fM(j5);
        }
        return m6901copytPigGR8(j5, f, f7);
    }

    /* renamed from: equals-impl, reason: not valid java name */
    public static boolean m6903equalsimpl(long j5, Object obj) {
        return (obj instanceof DpOffset) && j5 == ((DpOffset) obj).m6913unboximpl();
    }

    /* renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m6904equalsimpl0(long j5, long j6) {
        return j5 == j6;
    }

    /* renamed from: getX-D9Ej5fM, reason: not valid java name */
    public static final float m6905getXD9Ej5fM(long j5) {
        return Dp.m6844constructorimpl(Float.intBitsToFloat((int) (j5 >> 32)));
    }

    @Stable
    /* renamed from: getX-D9Ej5fM$annotations, reason: not valid java name */
    public static /* synthetic */ void m6906getXD9Ej5fM$annotations() {
    }

    /* renamed from: getY-D9Ej5fM, reason: not valid java name */
    public static final float m6907getYD9Ej5fM(long j5) {
        return Dp.m6844constructorimpl(Float.intBitsToFloat((int) (j5 & 4294967295L)));
    }

    @Stable
    /* renamed from: getY-D9Ej5fM$annotations, reason: not valid java name */
    public static /* synthetic */ void m6908getYD9Ej5fM$annotations() {
    }

    /* renamed from: hashCode-impl, reason: not valid java name */
    public static int m6909hashCodeimpl(long j5) {
        return Long.hashCode(j5);
    }

    @Stable
    /* renamed from: minus-CB-Mgk4, reason: not valid java name */
    public static final long m6910minusCBMgk4(long j5, long j6) {
        float fM6844constructorimpl = Dp.m6844constructorimpl(m6905getXD9Ej5fM(j5) - m6905getXD9Ej5fM(j6));
        float fM6844constructorimpl2 = Dp.m6844constructorimpl(m6907getYD9Ej5fM(j5) - m6907getYD9Ej5fM(j6));
        return m6900constructorimpl((Float.floatToRawIntBits(fM6844constructorimpl) << 32) | (4294967295L & Float.floatToRawIntBits(fM6844constructorimpl2)));
    }

    @Stable
    /* renamed from: plus-CB-Mgk4, reason: not valid java name */
    public static final long m6911plusCBMgk4(long j5, long j6) {
        float fM6844constructorimpl = Dp.m6844constructorimpl(m6905getXD9Ej5fM(j6) + m6905getXD9Ej5fM(j5));
        float fM6844constructorimpl2 = Dp.m6844constructorimpl(m6907getYD9Ej5fM(j6) + m6907getYD9Ej5fM(j5));
        return m6900constructorimpl((Float.floatToRawIntBits(fM6844constructorimpl) << 32) | (4294967295L & Float.floatToRawIntBits(fM6844constructorimpl2)));
    }

    @Stable
    /* renamed from: toString-impl, reason: not valid java name */
    public static String m6912toStringimpl(long j5) {
        if (j5 == androidx.compose.ui.geometry.InlineClassHelperKt.UnspecifiedPackedFloats) {
            return "DpOffset.Unspecified";
        }
        return "(" + ((Object) Dp.m6855toStringimpl(m6905getXD9Ej5fM(j5))) + ", " + ((Object) Dp.m6855toStringimpl(m6907getYD9Ej5fM(j5))) + ')';
    }

    public boolean equals(Object other) {
        return m6903equalsimpl(this.packedValue, other);
    }

    public final long getPackedValue() {
        return this.packedValue;
    }

    public int hashCode() {
        return m6909hashCodeimpl(this.packedValue);
    }

    @Stable
    public String toString() {
        return m6912toStringimpl(this.packedValue);
    }

    /* renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ long m6913unboximpl() {
        return this.packedValue;
    }
}
