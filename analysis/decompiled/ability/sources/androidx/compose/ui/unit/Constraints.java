package androidx.compose.ui.unit;

import B7.a;
import C7.c;
import androidx.compose.runtime.Immutable;
import androidx.compose.runtime.Stable;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.jvm.internal.e;

@Immutable
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0013\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0087@\u0018\u0000 /2\u00020\u0001:\u0001/B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J5\u0010#\u001a\u00020\u00002\b\b\u0002\u0010\f\u001a\u00020\t2\b\b\u0002\u0010\u000e\u001a\u00020\t2\b\b\u0002\u0010\u0010\u001a\u00020\t2\b\b\u0002\u0010\u0012\u001a\u00020\t¢\u0006\u0004\b$\u0010%J\u0010\u0010&\u001a\u00020\u0000H\u0086\b¢\u0006\u0004\b'\u0010\u0005J\u000f\u0010(\u001a\u00020)H\u0016¢\u0006\u0004\b*\u0010+J\u0013\u0010,\u001a\u00020\u00152\b\u0010-\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010.\u001a\u00020\tHÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0000X\u0081\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0006\u0010\u0007R\u0015\u0010\b\u001a\u00020\t8Â\u0002X\u0082\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\f\u001a\u00020\t8F¢\u0006\u0006\u001a\u0004\b\r\u0010\u000bR\u0011\u0010\u000e\u001a\u00020\t8F¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u000bR\u0011\u0010\u0010\u001a\u00020\t8F¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u000bR\u0011\u0010\u0012\u001a\u00020\t8F¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u000bR\u0011\u0010\u0014\u001a\u00020\u00158F¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u0018\u001a\u00020\u00158F¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u0017R\u001a\u0010\u001a\u001a\u00020\u00158FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u001b\u0010\u0007\u001a\u0004\b\u001c\u0010\u0017R\u001a\u0010\u001d\u001a\u00020\u00158FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u001e\u0010\u0007\u001a\u0004\b\u001f\u0010\u0017R\u001a\u0010 \u001a\u00020\u00158FX\u0087\u0004¢\u0006\f\u0012\u0004\b!\u0010\u0007\u001a\u0004\b\"\u0010\u0017\u0088\u0001\u0002\u0092\u0001\u00020\u0003¨\u00060"}, d2 = {"Landroidx/compose/ui/unit/Constraints;", "", "value", "", "constructor-impl", "(J)J", "getValue$annotations", "()V", "focusIndex", "", "getFocusIndex-impl", "(J)I", "minWidth", "getMinWidth-impl", "maxWidth", "getMaxWidth-impl", "minHeight", "getMinHeight-impl", "maxHeight", "getMaxHeight-impl", "hasBoundedWidth", "", "getHasBoundedWidth-impl", "(J)Z", "hasBoundedHeight", "getHasBoundedHeight-impl", "hasFixedWidth", "getHasFixedWidth$annotations", "getHasFixedWidth-impl", "hasFixedHeight", "getHasFixedHeight$annotations", "getHasFixedHeight-impl", "isZero", "isZero$annotations", "isZero-impl", "copy", "copy-Zbe2FdA", "(JIIII)J", "copyMaxDimensions", "copyMaxDimensions-msEJaDk", "toString", "", "toString-impl", "(J)Ljava/lang/String;", "equals", "other", "hashCode", "Companion", "ui-unit"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class Constraints {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int Infinity = Integer.MAX_VALUE;
    private final long value;

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001f\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u0005H\u0007¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\f\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0005H\u0007¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u000f\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0005H\u0007¢\u0006\u0004\b\u0010\u0010\u000eJ9\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u00052\b\b\u0002\u0010\u0016\u001a\u00020\u0017H\u0007¢\u0006\u0004\b\u0018\u0010\u0019J/\u0010\u001a\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u0005H\u0007¢\u0006\u0004\b\u001b\u0010\u001cJ/\u0010\u001d\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u0005H\u0007¢\u0006\u0004\b\u001e\u0010\u001cR\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Landroidx/compose/ui/unit/Constraints$Companion;", "", AppAgent.CONSTRUCT, "()V", "Infinity", "", "fixed", "Landroidx/compose/ui/unit/Constraints;", "width", "height", "fixed-JhjzzOo", "(II)J", "fixedWidth", "fixedWidth-OenEA2s", "(I)J", "fixedHeight", "fixedHeight-OenEA2s", "restrictConstraints", "minWidth", "maxWidth", "minHeight", "maxHeight", "prioritizeWidth", "", "restrictConstraints-xF2OJ5Q", "(IIIIZ)J", "fitPrioritizingWidth", "fitPrioritizingWidth-Zbe2FdA", "(IIII)J", "fitPrioritizingHeight", "fitPrioritizingHeight-Zbe2FdA", "ui-unit"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(e eVar) {
            this();
        }

        /* renamed from: restrictConstraints-xF2OJ5Q$default, reason: not valid java name */
        public static /* synthetic */ long m6804restrictConstraintsxF2OJ5Q$default(Companion companion, int i, int i6, int i10, int i11, boolean z10, int i12, Object obj) {
            if ((i12 & 16) != 0) {
                z10 = true;
            }
            return companion.m6810restrictConstraintsxF2OJ5Q(i, i6, i10, i11, z10);
        }

        @Stable
        /* renamed from: fitPrioritizingHeight-Zbe2FdA, reason: not valid java name */
        public final long m6805fitPrioritizingHeightZbe2FdA(int minWidth, int maxWidth, int minHeight, int maxHeight) {
            int i = 262142;
            int iMin = Math.min(minHeight, 262142);
            int iMin2 = maxHeight == Integer.MAX_VALUE ? Integer.MAX_VALUE : Math.min(maxHeight, 262142);
            int i6 = iMin2 == Integer.MAX_VALUE ? iMin : iMin2;
            if (i6 >= 8191) {
                if (i6 < 32767) {
                    i = 65534;
                } else if (i6 < 65535) {
                    i = 32766;
                } else {
                    if (i6 >= 262143) {
                        ConstraintsKt.throwInvalidConstraintsSizeException(i6);
                        throw new KotlinNothingValueException();
                    }
                    i = 8190;
                }
            }
            return ConstraintsKt.Constraints(Math.min(i, minWidth), maxWidth != Integer.MAX_VALUE ? Math.min(i, maxWidth) : Integer.MAX_VALUE, iMin, iMin2);
        }

        @Stable
        /* renamed from: fitPrioritizingWidth-Zbe2FdA, reason: not valid java name */
        public final long m6806fitPrioritizingWidthZbe2FdA(int minWidth, int maxWidth, int minHeight, int maxHeight) {
            int i = 262142;
            int iMin = Math.min(minWidth, 262142);
            int iMin2 = maxWidth == Integer.MAX_VALUE ? Integer.MAX_VALUE : Math.min(maxWidth, 262142);
            int i6 = iMin2 == Integer.MAX_VALUE ? iMin : iMin2;
            if (i6 >= 8191) {
                if (i6 < 32767) {
                    i = 65534;
                } else if (i6 < 65535) {
                    i = 32766;
                } else {
                    if (i6 >= 262143) {
                        ConstraintsKt.throwInvalidConstraintsSizeException(i6);
                        throw new KotlinNothingValueException();
                    }
                    i = 8190;
                }
            }
            return ConstraintsKt.Constraints(iMin, iMin2, Math.min(i, minHeight), maxHeight != Integer.MAX_VALUE ? Math.min(i, maxHeight) : Integer.MAX_VALUE);
        }

        @Stable
        /* renamed from: fixed-JhjzzOo, reason: not valid java name */
        public final long m6807fixedJhjzzOo(int width, int height) {
            if (!((height >= 0) & (width >= 0))) {
                InlineClassHelperKt.throwIllegalArgumentException("width and height must be >= 0");
            }
            return ConstraintsKt.createConstraints(width, width, height, height);
        }

        @Stable
        /* renamed from: fixedHeight-OenEA2s, reason: not valid java name */
        public final long m6808fixedHeightOenEA2s(int height) {
            if (!(height >= 0)) {
                InlineClassHelperKt.throwIllegalArgumentException("height must be >= 0");
            }
            return ConstraintsKt.createConstraints(0, Integer.MAX_VALUE, height, height);
        }

        @Stable
        /* renamed from: fixedWidth-OenEA2s, reason: not valid java name */
        public final long m6809fixedWidthOenEA2s(int width) {
            if (!(width >= 0)) {
                InlineClassHelperKt.throwIllegalArgumentException("width must be >= 0");
            }
            return ConstraintsKt.createConstraints(width, width, 0, Integer.MAX_VALUE);
        }

        @Stable
        @c
        /* renamed from: restrictConstraints-xF2OJ5Q, reason: not valid java name */
        public final long m6810restrictConstraintsxF2OJ5Q(int minWidth, int maxWidth, int minHeight, int maxHeight, boolean prioritizeWidth) {
            return prioritizeWidth ? m6806fitPrioritizingWidthZbe2FdA(minWidth, maxWidth, minHeight, maxHeight) : m6805fitPrioritizingHeightZbe2FdA(minWidth, maxWidth, minHeight, maxHeight);
        }

        private Companion() {
        }
    }

    private /* synthetic */ Constraints(long j5) {
        this.value = j5;
    }

    /* renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ Constraints m6784boximpl(long j5) {
        return new Constraints(j5);
    }

    /* renamed from: constructor-impl, reason: not valid java name */
    public static long m6785constructorimpl(long j5) {
        return j5;
    }

    /* renamed from: copy-Zbe2FdA, reason: not valid java name */
    public static final long m6786copyZbe2FdA(long j5, int i, int i6, int i10, int i11) {
        if (!(i6 >= i && i11 >= i10 && i >= 0 && i10 >= 0)) {
            InlineClassHelperKt.throwIllegalArgumentException("maxWidth must be >= than minWidth,\nmaxHeight must be >= than minHeight,\nminWidth and minHeight must be >= 0");
        }
        return ConstraintsKt.createConstraints(i, i6, i10, i11);
    }

    /* renamed from: copy-Zbe2FdA$default, reason: not valid java name */
    public static /* synthetic */ long m6787copyZbe2FdA$default(long j5, int i, int i6, int i10, int i11, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            i = m6799getMinWidthimpl(j5);
        }
        int i13 = i;
        if ((i12 & 2) != 0) {
            i6 = m6797getMaxWidthimpl(j5);
        }
        int i14 = i6;
        if ((i12 & 4) != 0) {
            i10 = m6798getMinHeightimpl(j5);
        }
        int i15 = i10;
        if ((i12 & 8) != 0) {
            i11 = m6796getMaxHeightimpl(j5);
        }
        return m6786copyZbe2FdA(j5, i13, i14, i15, i11);
    }

    /* renamed from: copyMaxDimensions-msEJaDk, reason: not valid java name */
    public static final long m6788copyMaxDimensionsmsEJaDk(long j5) {
        return m6785constructorimpl(j5 & ConstraintsKt.MaxDimensionsAndFocusMask);
    }

    /* renamed from: equals-impl, reason: not valid java name */
    public static boolean m6789equalsimpl(long j5, Object obj) {
        return (obj instanceof Constraints) && j5 == ((Constraints) obj).getValue();
    }

    /* renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m6790equalsimpl0(long j5, long j6) {
        return j5 == j6;
    }

    /* renamed from: getFocusIndex-impl, reason: not valid java name */
    private static final int m6791getFocusIndeximpl(long j5) {
        return (int) (j5 & 3);
    }

    /* renamed from: getHasBoundedHeight-impl, reason: not valid java name */
    public static final boolean m6792getHasBoundedHeightimpl(long j5) {
        int i = (int) (3 & j5);
        int i6 = (((i & 2) >> 1) * 3) + ((i & 1) << 1);
        return (((int) (j5 >> (i6 + 46))) & ((1 << (18 - i6)) - 1)) != 0;
    }

    /* renamed from: getHasBoundedWidth-impl, reason: not valid java name */
    public static final boolean m6793getHasBoundedWidthimpl(long j5) {
        int i = (int) (3 & j5);
        return (((int) (j5 >> 33)) & ((1 << (((((i & 2) >> 1) * 3) + ((i & 1) << 1)) + 13)) - 1)) != 0;
    }

    @Stable
    public static /* synthetic */ void getHasFixedHeight$annotations() {
    }

    /* renamed from: getHasFixedHeight-impl, reason: not valid java name */
    public static final boolean m6794getHasFixedHeightimpl(long j5) {
        int i = (int) (3 & j5);
        int i6 = (((i & 2) >> 1) * 3) + ((i & 1) << 1);
        int i10 = (1 << (18 - i6)) - 1;
        int i11 = ((int) (j5 >> (i6 + 15))) & i10;
        int i12 = ((int) (j5 >> (i6 + 46))) & i10;
        return i11 == (i12 == 0 ? Integer.MAX_VALUE : i12 - 1);
    }

    @Stable
    public static /* synthetic */ void getHasFixedWidth$annotations() {
    }

    /* renamed from: getHasFixedWidth-impl, reason: not valid java name */
    public static final boolean m6795getHasFixedWidthimpl(long j5) {
        int i = (int) (3 & j5);
        int i6 = (1 << (((((i & 2) >> 1) * 3) + ((i & 1) << 1)) + 13)) - 1;
        int i10 = ((int) (j5 >> 2)) & i6;
        int i11 = ((int) (j5 >> 33)) & i6;
        return i10 == (i11 == 0 ? Integer.MAX_VALUE : i11 - 1);
    }

    /* renamed from: getMaxHeight-impl, reason: not valid java name */
    public static final int m6796getMaxHeightimpl(long j5) {
        int i = (int) (3 & j5);
        int i6 = (((i & 2) >> 1) * 3) + ((i & 1) << 1);
        int i10 = ((int) (j5 >> (i6 + 46))) & ((1 << (18 - i6)) - 1);
        if (i10 == 0) {
            return Integer.MAX_VALUE;
        }
        return i10 - 1;
    }

    /* renamed from: getMaxWidth-impl, reason: not valid java name */
    public static final int m6797getMaxWidthimpl(long j5) {
        int i = (int) (3 & j5);
        int i6 = (int) (j5 >> 33);
        int i10 = i6 & ((1 << (((((i & 2) >> 1) * 3) + ((i & 1) << 1)) + 13)) - 1);
        if (i10 == 0) {
            return Integer.MAX_VALUE;
        }
        return i10 - 1;
    }

    /* renamed from: getMinHeight-impl, reason: not valid java name */
    public static final int m6798getMinHeightimpl(long j5) {
        int i = (int) (3 & j5);
        int i6 = (((i & 2) >> 1) * 3) + ((i & 1) << 1);
        return ((int) (j5 >> (i6 + 15))) & ((1 << (18 - i6)) - 1);
    }

    /* renamed from: getMinWidth-impl, reason: not valid java name */
    public static final int m6799getMinWidthimpl(long j5) {
        int i = (int) (3 & j5);
        return ((int) (j5 >> 2)) & ((1 << (((((i & 2) >> 1) * 3) + ((i & 1) << 1)) + 13)) - 1);
    }

    public static /* synthetic */ void getValue$annotations() {
    }

    /* renamed from: hashCode-impl, reason: not valid java name */
    public static int m6800hashCodeimpl(long j5) {
        return Long.hashCode(j5);
    }

    @Stable
    public static /* synthetic */ void isZero$annotations() {
    }

    /* renamed from: isZero-impl, reason: not valid java name */
    public static final boolean m6801isZeroimpl(long j5) {
        int i = (int) (3 & j5);
        int i6 = (((i & 2) >> 1) * 3) + ((i & 1) << 1);
        return ((((int) (j5 >> 33)) & ((1 << (i6 + 13)) - 1)) - 1 == 0) | ((((int) (j5 >> (i6 + 46))) & ((1 << (18 - i6)) - 1)) - 1 == 0);
    }

    /* renamed from: toString-impl, reason: not valid java name */
    public static String m6802toStringimpl(long j5) {
        int iM6797getMaxWidthimpl = m6797getMaxWidthimpl(j5);
        String strValueOf = iM6797getMaxWidthimpl == Integer.MAX_VALUE ? "Infinity" : String.valueOf(iM6797getMaxWidthimpl);
        int iM6796getMaxHeightimpl = m6796getMaxHeightimpl(j5);
        String strValueOf2 = iM6796getMaxHeightimpl != Integer.MAX_VALUE ? String.valueOf(iM6796getMaxHeightimpl) : "Infinity";
        StringBuilder sb = new StringBuilder("Constraints(minWidth = ");
        sb.append(m6799getMinWidthimpl(j5));
        sb.append(", maxWidth = ");
        sb.append(strValueOf);
        sb.append(", minHeight = ");
        sb.append(m6798getMinHeightimpl(j5));
        sb.append(", maxHeight = ");
        return a.g(')', strValueOf2, sb);
    }

    public boolean equals(Object other) {
        return m6789equalsimpl(this.value, other);
    }

    public int hashCode() {
        return m6800hashCodeimpl(this.value);
    }

    public String toString() {
        return m6802toStringimpl(this.value);
    }

    /* renamed from: unbox-impl, reason: not valid java name and from getter */
    public final /* synthetic */ long getValue() {
        return this.value;
    }
}
