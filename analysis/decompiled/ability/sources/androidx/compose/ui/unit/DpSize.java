package androidx.compose.ui.unit;

import androidx.compose.runtime.Immutable;
import androidx.compose.runtime.Stable;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import kotlin.Metadata;
import kotlin.jvm.internal.e;

@Immutable
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0087@\u0018\u0000 ,2\u00020\u0001:\u0001,B\u0011\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J!\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\r\u001a\u00020\t¢\u0006\u0004\b\u0011\u0010\u0012J\u0018\u0010\u0013\u001a\u00020\u00002\u0006\u0010\u0014\u001a\u00020\u0000H\u0087\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u0018\u0010\u0017\u001a\u00020\u00002\u0006\u0010\u0014\u001a\u00020\u0000H\u0087\u0002¢\u0006\u0004\b\u0018\u0010\u0016J\u0010\u0010\u0019\u001a\u00020\tH\u0087\n¢\u0006\u0004\b\u001a\u0010\fJ\u0010\u0010\u001b\u001a\u00020\tH\u0087\n¢\u0006\u0004\b\u001c\u0010\fJ\u0018\u0010\u001d\u001a\u00020\u00002\u0006\u0010\u0014\u001a\u00020\u001eH\u0087\u0002¢\u0006\u0004\b\u001f\u0010 J\u0018\u0010\u001d\u001a\u00020\u00002\u0006\u0010\u0014\u001a\u00020!H\u0087\u0002¢\u0006\u0004\b\u001f\u0010\"J\u0018\u0010#\u001a\u00020\u00002\u0006\u0010\u0014\u001a\u00020\u001eH\u0087\u0002¢\u0006\u0004\b$\u0010 J\u0018\u0010#\u001a\u00020\u00002\u0006\u0010\u0014\u001a\u00020!H\u0087\u0002¢\u0006\u0004\b$\u0010\"J\u000f\u0010%\u001a\u00020&H\u0017¢\u0006\u0004\b'\u0010(J\u0013\u0010)\u001a\u00020*2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010+\u001a\u00020\u001eHÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0000X\u0081\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0006\u0010\u0007R\u001a\u0010\b\u001a\u00020\t8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\n\u0010\u0007\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u00020\t8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u000e\u0010\u0007\u001a\u0004\b\u000f\u0010\f\u0088\u0001\u0002\u0092\u0001\u00020\u0003¨\u0006-"}, d2 = {"Landroidx/compose/ui/unit/DpSize;", "", "packedValue", "", "constructor-impl", "(J)J", "getPackedValue$annotations", "()V", "width", "Landroidx/compose/ui/unit/Dp;", "getWidth-D9Ej5fM$annotations", "getWidth-D9Ej5fM", "(J)F", "height", "getHeight-D9Ej5fM$annotations", "getHeight-D9Ej5fM", "copy", "copy-DwJknco", "(JFF)J", "minus", "other", "minus-e_xh8Ic", "(JJ)J", "plus", "plus-e_xh8Ic", "component1", "component1-D9Ej5fM", "component2", "component2-D9Ej5fM", "times", "", "times-Gh9hcWk", "(JI)J", "", "(JF)J", "div", "div-Gh9hcWk", "toString", "", "toString-impl", "(J)Ljava/lang/String;", "equals", "", "hashCode", "Companion", "ui-unit"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class DpSize {
    private final long packedValue;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final long Zero = m6933constructorimpl(0);
    private static final long Unspecified = m6933constructorimpl(androidx.compose.ui.geometry.InlineClassHelperKt.UnspecifiedPackedFloats);

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0013\u0010\u0004\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007R\u0013\u0010\t\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\n\u0010\u0007¨\u0006\u000b"}, d2 = {"Landroidx/compose/ui/unit/DpSize$Companion;", "", AppAgent.CONSTRUCT, "()V", "Zero", "Landroidx/compose/ui/unit/DpSize;", "getZero-MYxV2XQ", "()J", "J", "Unspecified", "getUnspecified-MYxV2XQ", "ui-unit"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(e eVar) {
            this();
        }

        /* renamed from: getUnspecified-MYxV2XQ, reason: not valid java name */
        public final long m6951getUnspecifiedMYxV2XQ() {
            return DpSize.Unspecified;
        }

        /* renamed from: getZero-MYxV2XQ, reason: not valid java name */
        public final long m6952getZeroMYxV2XQ() {
            return DpSize.Zero;
        }

        private Companion() {
        }
    }

    private /* synthetic */ DpSize(long j5) {
        this.packedValue = j5;
    }

    /* renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ DpSize m6930boximpl(long j5) {
        return new DpSize(j5);
    }

    @Stable
    /* renamed from: component1-D9Ej5fM, reason: not valid java name */
    public static final float m6931component1D9Ej5fM(long j5) {
        return m6942getWidthD9Ej5fM(j5);
    }

    @Stable
    /* renamed from: component2-D9Ej5fM, reason: not valid java name */
    public static final float m6932component2D9Ej5fM(long j5) {
        return m6940getHeightD9Ej5fM(j5);
    }

    /* renamed from: constructor-impl, reason: not valid java name */
    public static long m6933constructorimpl(long j5) {
        return j5;
    }

    /* renamed from: copy-DwJknco, reason: not valid java name */
    public static final long m6934copyDwJknco(long j5, float f, float f7) {
        return m6933constructorimpl((Float.floatToRawIntBits(f) << 32) | (Float.floatToRawIntBits(f7) & 4294967295L));
    }

    /* renamed from: copy-DwJknco$default, reason: not valid java name */
    public static /* synthetic */ long m6935copyDwJknco$default(long j5, float f, float f7, int i, Object obj) {
        if ((i & 1) != 0) {
            f = m6942getWidthD9Ej5fM(j5);
        }
        if ((i & 2) != 0) {
            f7 = m6940getHeightD9Ej5fM(j5);
        }
        return m6934copyDwJknco(j5, f, f7);
    }

    @Stable
    /* renamed from: div-Gh9hcWk, reason: not valid java name */
    public static final long m6937divGh9hcWk(long j5, int i) {
        float f = i;
        float fM6844constructorimpl = Dp.m6844constructorimpl(m6942getWidthD9Ej5fM(j5) / f);
        float fM6844constructorimpl2 = Dp.m6844constructorimpl(m6940getHeightD9Ej5fM(j5) / f);
        return m6933constructorimpl((Float.floatToRawIntBits(fM6844constructorimpl) << 32) | (Float.floatToRawIntBits(fM6844constructorimpl2) & 4294967295L));
    }

    /* renamed from: equals-impl, reason: not valid java name */
    public static boolean m6938equalsimpl(long j5, Object obj) {
        return (obj instanceof DpSize) && j5 == ((DpSize) obj).getPackedValue();
    }

    /* renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m6939equalsimpl0(long j5, long j6) {
        return j5 == j6;
    }

    /* renamed from: getHeight-D9Ej5fM, reason: not valid java name */
    public static final float m6940getHeightD9Ej5fM(long j5) {
        return Dp.m6844constructorimpl(Float.intBitsToFloat((int) (j5 & 4294967295L)));
    }

    @Stable
    /* renamed from: getHeight-D9Ej5fM$annotations, reason: not valid java name */
    public static /* synthetic */ void m6941getHeightD9Ej5fM$annotations() {
    }

    public static /* synthetic */ void getPackedValue$annotations() {
    }

    /* renamed from: getWidth-D9Ej5fM, reason: not valid java name */
    public static final float m6942getWidthD9Ej5fM(long j5) {
        return Dp.m6844constructorimpl(Float.intBitsToFloat((int) (j5 >> 32)));
    }

    @Stable
    /* renamed from: getWidth-D9Ej5fM$annotations, reason: not valid java name */
    public static /* synthetic */ void m6943getWidthD9Ej5fM$annotations() {
    }

    /* renamed from: hashCode-impl, reason: not valid java name */
    public static int m6944hashCodeimpl(long j5) {
        return Long.hashCode(j5);
    }

    @Stable
    /* renamed from: minus-e_xh8Ic, reason: not valid java name */
    public static final long m6945minuse_xh8Ic(long j5, long j6) {
        float fM6844constructorimpl = Dp.m6844constructorimpl(m6942getWidthD9Ej5fM(j5) - m6942getWidthD9Ej5fM(j6));
        float fM6844constructorimpl2 = Dp.m6844constructorimpl(m6940getHeightD9Ej5fM(j5) - m6940getHeightD9Ej5fM(j6));
        return m6933constructorimpl((Float.floatToRawIntBits(fM6844constructorimpl) << 32) | (4294967295L & Float.floatToRawIntBits(fM6844constructorimpl2)));
    }

    @Stable
    /* renamed from: plus-e_xh8Ic, reason: not valid java name */
    public static final long m6946pluse_xh8Ic(long j5, long j6) {
        float fM6844constructorimpl = Dp.m6844constructorimpl(m6942getWidthD9Ej5fM(j6) + m6942getWidthD9Ej5fM(j5));
        float fM6844constructorimpl2 = Dp.m6844constructorimpl(m6940getHeightD9Ej5fM(j6) + m6940getHeightD9Ej5fM(j5));
        return m6933constructorimpl((Float.floatToRawIntBits(fM6844constructorimpl) << 32) | (4294967295L & Float.floatToRawIntBits(fM6844constructorimpl2)));
    }

    @Stable
    /* renamed from: times-Gh9hcWk, reason: not valid java name */
    public static final long m6948timesGh9hcWk(long j5, int i) {
        float f = i;
        float fM6844constructorimpl = Dp.m6844constructorimpl(m6942getWidthD9Ej5fM(j5) * f);
        float fM6844constructorimpl2 = Dp.m6844constructorimpl(m6940getHeightD9Ej5fM(j5) * f);
        return m6933constructorimpl((Float.floatToRawIntBits(fM6844constructorimpl) << 32) | (Float.floatToRawIntBits(fM6844constructorimpl2) & 4294967295L));
    }

    @Stable
    /* renamed from: toString-impl, reason: not valid java name */
    public static String m6949toStringimpl(long j5) {
        if (j5 == androidx.compose.ui.geometry.InlineClassHelperKt.UnspecifiedPackedFloats) {
            return "DpSize.Unspecified";
        }
        return ((Object) Dp.m6855toStringimpl(m6942getWidthD9Ej5fM(j5))) + " x " + ((Object) Dp.m6855toStringimpl(m6940getHeightD9Ej5fM(j5)));
    }

    public boolean equals(Object other) {
        return m6938equalsimpl(this.packedValue, other);
    }

    public int hashCode() {
        return m6944hashCodeimpl(this.packedValue);
    }

    @Stable
    public String toString() {
        return m6949toStringimpl(this.packedValue);
    }

    /* renamed from: unbox-impl, reason: not valid java name and from getter */
    public final /* synthetic */ long getPackedValue() {
        return this.packedValue;
    }

    @Stable
    /* renamed from: div-Gh9hcWk, reason: not valid java name */
    public static final long m6936divGh9hcWk(long j5, float f) {
        float fM6844constructorimpl = Dp.m6844constructorimpl(m6942getWidthD9Ej5fM(j5) / f);
        float fM6844constructorimpl2 = Dp.m6844constructorimpl(m6940getHeightD9Ej5fM(j5) / f);
        return m6933constructorimpl((Float.floatToRawIntBits(fM6844constructorimpl) << 32) | (Float.floatToRawIntBits(fM6844constructorimpl2) & 4294967295L));
    }

    @Stable
    /* renamed from: times-Gh9hcWk, reason: not valid java name */
    public static final long m6947timesGh9hcWk(long j5, float f) {
        float fM6844constructorimpl = Dp.m6844constructorimpl(m6942getWidthD9Ej5fM(j5) * f);
        float fM6844constructorimpl2 = Dp.m6844constructorimpl(m6940getHeightD9Ej5fM(j5) * f);
        return m6933constructorimpl((Float.floatToRawIntBits(fM6844constructorimpl) << 32) | (Float.floatToRawIntBits(fM6844constructorimpl2) & 4294967295L));
    }
}
