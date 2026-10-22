package androidx.compose.ui.node;

import androidx.compose.ui.internal.InlineClassHelperKt;
import androidx.compose.ui.unit.LayoutDirection;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import kotlin.Metadata;
import kotlin.jvm.internal.e;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0087@\u0018\u0000  2\u00020\u0001:\u0001 B\u0011\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u0016H\u0000¢\u0006\u0004\b\u0017\u0010\u0018J\u0017\u0010\u0019\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u0016H\u0000¢\u0006\u0004\b\u001a\u0010\u0018J\u0013\u0010\u001b\u001a\u00020\u00112\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001d\u001a\u00020\u0007HÖ\u0001J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0011\u0010\n\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b\u000b\u0010\tR\u0011\u0010\f\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b\r\u0010\tR\u0011\u0010\u000e\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b\u000f\u0010\tR\u0011\u0010\u0010\u001a\u00020\u00118F¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013\u0088\u0001\u0002\u0092\u0001\u00020\u0003¨\u0006!"}, d2 = {"Landroidx/compose/ui/node/TouchBoundsExpansion;", "", "packedValue", "", "constructor-impl", "(J)J", "start", "", "getStart-impl", "(J)I", "top", "getTop-impl", "end", "getEnd-impl", "bottom", "getBottom-impl", "isLayoutDirectionAware", "", "isLayoutDirectionAware-impl", "(J)Z", "computeLeft", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "computeLeft-impl$ui_release", "(JLandroidx/compose/ui/unit/LayoutDirection;)I", "computeRight", "computeRight-impl$ui_release", "equals", "other", "hashCode", "toString", "", "Companion", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class TouchBoundsExpansion {
    private static final long IS_LAYOUT_DIRECTION_AWARE = Long.MIN_VALUE;
    private static final int MASK = 32767;
    public static final int MAX_VALUE = 32767;
    private static final int SHIFT = 15;
    private final long packedValue;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final long None = TouchBoundsExpansionKt.TouchBoundsExpansion$default(0, 0, 0, 0, 14, null);

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J5\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u00072\b\b\u0002\u0010\n\u001a\u00020\u0007¢\u0006\u0004\b\u000b\u0010\fJ5\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u0016H\u0000¢\u0006\u0002\b\u0017J\u0018\u0010\u001c\u001a\u00020\u00072\u0006\u0010\u001d\u001a\u00020\u00122\u0006\u0010\u001e\u001a\u00020\u0007H\u0002J\u0018\u0010\u001f\u001a\u00020\u00122\u0006\u0010 \u001a\u00020\u00072\u0006\u0010\u001e\u001a\u00020\u0007H\u0002R\u0013\u0010\r\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0018\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0007X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0012X\u0082T¢\u0006\u0002\n\u0000¨\u0006!"}, d2 = {"Landroidx/compose/ui/node/TouchBoundsExpansion$Companion;", "", AppAgent.CONSTRUCT, "()V", "Absolute", "Landroidx/compose/ui/node/TouchBoundsExpansion;", "left", "", "top", "right", "bottom", "Absolute-vsh68fg", "(IIII)J", "None", "getNone-RZrCHBk", "()J", "J", "pack", "", "start", "end", "isLayoutDirectionAware", "", "pack$ui_release", "MASK", "SHIFT", "MAX_VALUE", "IS_LAYOUT_DIRECTION_AWARE", "unpack", "packedValue", "position", "trimAndShift", "int", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(e eVar) {
            this();
        }

        /* renamed from: Absolute-vsh68fg$default, reason: not valid java name */
        public static /* synthetic */ long m5957Absolutevsh68fg$default(Companion companion, int i, int i6, int i10, int i11, int i12, Object obj) {
            if ((i12 & 1) != 0) {
                i = 0;
            }
            if ((i12 & 2) != 0) {
                i6 = 0;
            }
            if ((i12 & 4) != 0) {
                i10 = 0;
            }
            if ((i12 & 8) != 0) {
                i11 = 0;
            }
            return companion.m5958Absolutevsh68fg(i, i6, i10, i11);
        }

        private final long trimAndShift(int i, int position) {
            return (i & 32767) << (position * 15);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final int unpack(long packedValue, int position) {
            return ((int) (packedValue >> (position * 15))) & 32767;
        }

        /* renamed from: Absolute-vsh68fg, reason: not valid java name */
        public final long m5958Absolutevsh68fg(int left, int top, int right, int bottom) {
            if (!(left >= 0 && left < 32768)) {
                InlineClassHelperKt.throwIllegalArgumentException("Start must be in the range of 0 .. 32767");
            }
            if (!(top >= 0 && top < 32768)) {
                InlineClassHelperKt.throwIllegalArgumentException("Top must be in the range of 0 .. 32767");
            }
            if (!(right >= 0 && right < 32768)) {
                InlineClassHelperKt.throwIllegalArgumentException("End must be in the range of 0 .. 32767");
            }
            if (!(bottom >= 0 && bottom < 32768)) {
                InlineClassHelperKt.throwIllegalArgumentException("Bottom must be in the range of 0 .. 32767");
            }
            return TouchBoundsExpansion.m5946constructorimpl(pack$ui_release(left, top, right, bottom, false));
        }

        /* renamed from: getNone-RZrCHBk, reason: not valid java name */
        public final long m5959getNoneRZrCHBk() {
            return TouchBoundsExpansion.None;
        }

        public final long pack$ui_release(int start, int top, int end, int bottom, boolean isLayoutDirectionAware) {
            return trimAndShift(top, 1) | trimAndShift(start, 0) | trimAndShift(end, 2) | trimAndShift(bottom, 3) | (isLayoutDirectionAware ? Long.MIN_VALUE : 0L);
        }

        private Companion() {
        }
    }

    private /* synthetic */ TouchBoundsExpansion(long j5) {
        this.packedValue = j5;
    }

    /* renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ TouchBoundsExpansion m5943boximpl(long j5) {
        return new TouchBoundsExpansion(j5);
    }

    /* renamed from: computeLeft-impl$ui_release, reason: not valid java name */
    public static final int m5944computeLeftimpl$ui_release(long j5, LayoutDirection layoutDirection) {
        return (!m5954isLayoutDirectionAwareimpl(j5) || layoutDirection == LayoutDirection.Ltr) ? m5951getStartimpl(j5) : m5950getEndimpl(j5);
    }

    /* renamed from: computeRight-impl$ui_release, reason: not valid java name */
    public static final int m5945computeRightimpl$ui_release(long j5, LayoutDirection layoutDirection) {
        return (!m5954isLayoutDirectionAwareimpl(j5) || layoutDirection == LayoutDirection.Ltr) ? m5950getEndimpl(j5) : m5951getStartimpl(j5);
    }

    /* renamed from: constructor-impl, reason: not valid java name */
    public static long m5946constructorimpl(long j5) {
        return j5;
    }

    /* renamed from: equals-impl, reason: not valid java name */
    public static boolean m5947equalsimpl(long j5, Object obj) {
        return (obj instanceof TouchBoundsExpansion) && j5 == ((TouchBoundsExpansion) obj).getPackedValue();
    }

    /* renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m5948equalsimpl0(long j5, long j6) {
        return j5 == j6;
    }

    /* renamed from: getBottom-impl, reason: not valid java name */
    public static final int m5949getBottomimpl(long j5) {
        return INSTANCE.unpack(j5, 3);
    }

    /* renamed from: getEnd-impl, reason: not valid java name */
    public static final int m5950getEndimpl(long j5) {
        return INSTANCE.unpack(j5, 2);
    }

    /* renamed from: getStart-impl, reason: not valid java name */
    public static final int m5951getStartimpl(long j5) {
        return INSTANCE.unpack(j5, 0);
    }

    /* renamed from: getTop-impl, reason: not valid java name */
    public static final int m5952getTopimpl(long j5) {
        return INSTANCE.unpack(j5, 1);
    }

    /* renamed from: hashCode-impl, reason: not valid java name */
    public static int m5953hashCodeimpl(long j5) {
        return Long.hashCode(j5);
    }

    /* renamed from: isLayoutDirectionAware-impl, reason: not valid java name */
    public static final boolean m5954isLayoutDirectionAwareimpl(long j5) {
        return (j5 & Long.MIN_VALUE) != 0;
    }

    /* renamed from: toString-impl, reason: not valid java name */
    public static String m5955toStringimpl(long j5) {
        return "TouchBoundsExpansion(packedValue=" + j5 + ')';
    }

    public boolean equals(Object other) {
        return m5947equalsimpl(this.packedValue, other);
    }

    public int hashCode() {
        return m5953hashCodeimpl(this.packedValue);
    }

    public String toString() {
        return m5955toStringimpl(this.packedValue);
    }

    /* renamed from: unbox-impl, reason: not valid java name and from getter */
    public final /* synthetic */ long getPackedValue() {
        return this.packedValue;
    }
}
