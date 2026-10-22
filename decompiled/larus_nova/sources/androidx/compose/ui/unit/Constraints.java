package androidx.compose.ui.unit;

import kotlin.Deprecated;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0013\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0087@\u0018\u0000 /2\u00020\u0001:\u0001/B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J5\u0010#\u001a\u00020\u00002\b\b\u0002\u0010\f\u001a\u00020\t2\b\b\u0002\u0010\u000e\u001a\u00020\t2\b\b\u0002\u0010\u0010\u001a\u00020\t2\b\b\u0002\u0010\u0012\u001a\u00020\t¢\u0006\u0004\b$\u0010%J\u0010\u0010&\u001a\u00020\u0000H\u0086\b¢\u0006\u0004\b'\u0010\u0005J\u000f\u0010(\u001a\u00020)H\u0016¢\u0006\u0004\b*\u0010+J\u0013\u0010,\u001a\u00020\u00152\b\u0010-\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010.\u001a\u00020\tHÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0000X\u0081\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0006\u0010\u0007R\u0015\u0010\b\u001a\u00020\t8Â\u0002X\u0082\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\f\u001a\u00020\t8F¢\u0006\u0006\u001a\u0004\b\r\u0010\u000bR\u0011\u0010\u000e\u001a\u00020\t8F¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u000bR\u0011\u0010\u0010\u001a\u00020\t8F¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u000bR\u0011\u0010\u0012\u001a\u00020\t8F¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u000bR\u0011\u0010\u0014\u001a\u00020\u00158F¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u0018\u001a\u00020\u00158F¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u0017R\u001a\u0010\u001a\u001a\u00020\u00158FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u001b\u0010\u0007\u001a\u0004\b\u001c\u0010\u0017R\u001a\u0010\u001d\u001a\u00020\u00158FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u001e\u0010\u0007\u001a\u0004\b\u001f\u0010\u0017R\u001a\u0010 \u001a\u00020\u00158FX\u0087\u0004¢\u0006\f\u0012\u0004\b!\u0010\u0007\u001a\u0004\b\"\u0010\u0017\u0088\u0001\u0002\u0092\u0001\u00020\u0003¨\u00060"}, d2 = {"Landroidx/compose/ui/unit/Constraints;", "", "value", "", "constructor-impl", "(J)J", "getValue$annotations", "()V", "focusIndex", "", "getFocusIndex-impl", "(J)I", "minWidth", "getMinWidth-impl", "maxWidth", "getMaxWidth-impl", "minHeight", "getMinHeight-impl", "maxHeight", "getMaxHeight-impl", "hasBoundedWidth", "", "getHasBoundedWidth-impl", "(J)Z", "hasBoundedHeight", "getHasBoundedHeight-impl", "hasFixedWidth", "getHasFixedWidth$annotations", "getHasFixedWidth-impl", "hasFixedHeight", "getHasFixedHeight$annotations", "getHasFixedHeight-impl", "isZero", "isZero$annotations", "isZero-impl", "copy", "copy-Zbe2FdA", "(JIIII)J", "copyMaxDimensions", "copyMaxDimensions-msEJaDk", "toString", "", "toString-impl", "(J)Ljava/lang/String;", "equals", "other", "hashCode", "Companion", "ui-unit"}, k = 1, mv = {2, 0, 0}, xi = 48)
@JvmInline
public final class Constraints {
    public static final Companion Companion = null;
    public static final int Infinity = Integer.MAX_VALUE;
    private final long value;

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001f\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u0005H\u0007¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\f\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0005H\u0007¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u000f\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0005H\u0007¢\u0006\u0004\b\u0010\u0010\u000eJ9\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u00052\b\b\u0002\u0010\u0016\u001a\u00020\u0017H\u0007¢\u0006\u0004\b\u0018\u0010\u0019J/\u0010\u001a\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u0005H\u0007¢\u0006\u0004\b\u001b\u0010\u001cJ/\u0010\u001d\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u0005H\u0007¢\u0006\u0004\b\u001e\u0010\u001cR\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Landroidx/compose/ui/unit/Constraints$Companion;", "", "<init>", "()V", "Infinity", "", "fixed", "Landroidx/compose/ui/unit/Constraints;", "width", "height", "fixed-JhjzzOo", "(II)J", "fixedWidth", "fixedWidth-OenEA2s", "(I)J", "fixedHeight", "fixedHeight-OenEA2s", "restrictConstraints", "minWidth", "maxWidth", "minHeight", "maxHeight", "prioritizeWidth", "", "restrictConstraints-xF2OJ5Q", "(IIIIZ)J", "fitPrioritizingWidth", "fitPrioritizingWidth-Zbe2FdA", "(IIII)J", "fitPrioritizingHeight", "fitPrioritizingHeight-Zbe2FdA", "ui-unit"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        /* JADX INFO: renamed from: fixedHeight-OenEA2s, reason: not valid java name */
        public final long m7498fixedHeightOenEA2s(int r100) {
            if (r100 < 0) goto L5;
            boolean r101 = true;
        L6:
            if (r101 == true) goto L9;
            InlineClassHelperKt.throwIllegalArgumentException("height must be >= 0");
        L9:
            return ConstraintsKt.createConstraints(0, Integer.MAX_VALUE, r100, r100);
        L5:
            r101 = false;
            goto L6
        }

        /* JADX INFO: renamed from: fixedWidth-OenEA2s, reason: not valid java name */
        public final long m7499fixedWidthOenEA2s(int r100) {
            if (r100 < 0) goto L5;
            boolean r101 = true;
        L6:
            if (r101 == true) goto L9;
            InlineClassHelperKt.throwIllegalArgumentException("width must be >= 0");
        L9:
            return ConstraintsKt.createConstraints(r100, r100, 0, Integer.MAX_VALUE);
        L5:
            r101 = false;
            goto L6
        }

        /* JADX INFO: renamed from: fixed-JhjzzOo, reason: not valid java name */
        public final long m7497fixedJhjzzOo(int r100, int r101) {
            boolean r102 = true;
            if (r100 < 0) goto L5;
            boolean r103 = true;
        L6:
            if (r101 >= 0) goto L10;
            r102 = false;
        L10:
            if ((r102 & r103) == true) goto L13;
            InlineClassHelperKt.throwIllegalArgumentException("width and height must be >= 0");
        L13:
            return ConstraintsKt.createConstraints(r100, r100, r101, r101);
        L5:
            r103 = false;
            goto L6
        }

        /* JADX INFO: renamed from: fitPrioritizingHeight-Zbe2FdA, reason: not valid java name */
        public final long m7495fitPrioritizingHeightZbe2FdA(int r100, int r101, int r102, int r103) {
            int r104 = 262142;
            int r105 = Math.min(r102, 262142);
            int r106 = Integer.MAX_VALUE;
            if (r103 != Integer.MAX_VALUE) goto L5;
            int r107 = Integer.MAX_VALUE;
        L6:
            if (r107 != Integer.MAX_VALUE) goto L8;
            int r108 = r105;
        L10:
            if (r108 >= 8191) goto L13;
        L21:
            if (r101 == Integer.MAX_VALUE) goto L25;
            r106 = Math.min(r104, r101);
        L25:
            return ConstraintsKt.Constraints(Math.min(r104, r100), r106, r105, r107);
        L13:
            if (r108 >= 32767) goto L16;
            r104 = 65534;
            goto L21
        L16:
            if (r108 >= 65535) goto L19;
            r104 = 32766;
            goto L21
        L19:
            if (r108 >= 262143) goto L26;
            r104 = 8190;
            goto L21
        L26:
            ConstraintsKt.throwInvalidConstraintsSizeException(r108);
            throw new KotlinNothingValueException();
        L8:
            r108 = r107;
            goto L10
        L5:
            r107 = Math.min(r103, 262142);
            goto L6
        }

        /* JADX INFO: renamed from: fitPrioritizingWidth-Zbe2FdA, reason: not valid java name */
        public final long m7496fitPrioritizingWidthZbe2FdA(int r100, int r101, int r102, int r103) {
            int r104 = 262142;
            int r105 = Math.min(r100, 262142);
            int r106 = Integer.MAX_VALUE;
            if (r101 != Integer.MAX_VALUE) goto L5;
            int r107 = Integer.MAX_VALUE;
        L6:
            if (r107 != Integer.MAX_VALUE) goto L8;
            int r108 = r105;
        L10:
            if (r108 >= 8191) goto L13;
        L21:
            if (r103 == Integer.MAX_VALUE) goto L25;
            r106 = Math.min(r104, r103);
        L25:
            return ConstraintsKt.Constraints(r105, r107, Math.min(r104, r102), r106);
        L13:
            if (r108 >= 32767) goto L16;
            r104 = 65534;
            goto L21
        L16:
            if (r108 >= 65535) goto L19;
            r104 = 32766;
            goto L21
        L19:
            if (r108 >= 262143) goto L26;
            r104 = 8190;
            goto L21
        L26:
            ConstraintsKt.throwInvalidConstraintsSizeException(r108);
            throw new KotlinNothingValueException();
        L8:
            r108 = r107;
            goto L10
        L5:
            r107 = Math.min(r101, 262142);
            goto L6
        }

        @Deprecated(message = "Replace with fitPrioritizingWidth", replaceWith = @ReplaceWith(expression = "Constraints.fitPrioritizingWidth(minWidth, maxWidth, minHeight, maxHeight)", imports = {}))
        /* JADX INFO: renamed from: restrictConstraints-xF2OJ5Q, reason: not valid java name */
        public final long m7500restrictConstraintsxF2OJ5Q(int r100, int r101, int r102, int r103, boolean r104) {
            if (r104 == false) goto L5;
            return m7496fitPrioritizingWidthZbe2FdA(r100, r101, r102, r103);
        L5:
            return m7495fitPrioritizingHeightZbe2FdA(r100, r101, r102, r103);
        }

        /* JADX INFO: renamed from: restrictConstraints-xF2OJ5Q$default, reason: not valid java name */
        public static /* synthetic */ long m7494restrictConstraintsxF2OJ5Q$default(Companion r100, int r101, int r102, int r103, int r110, boolean r111, int r112, Object r113) {
            if ((r112 & 16) == 0) goto L5;
            boolean r104 = true;
        L7:
            return r100.m7500restrictConstraintsxF2OJ5Q(r101, r102, r103, r110, r104);
        L5:
            r104 = r111;
            goto L7
        }
    }

    static {
        Companion = new Companion(null);
    }

    /* JADX INFO: renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ Constraints m7474boximpl(long r100) {
        return new Constraints(r100);
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static long m7475constructorimpl(long r100) {
        return r100;
    }

    /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
    public static boolean m7479equalsimpl(long r100, Object r101) {
        if ((r101 instanceof Constraints) == true) goto L6;
        return false;
    L6:
        if (r100 == ((Constraints) r101).m7493unboximpl()) goto L8;
        return false;
    L8:
        return true;
    }

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m7480equalsimpl0(long r100, long r101) {
        if (r100 != r101) goto L5;
        return true;
    L5:
        return false;
    }

    /* JADX INFO: renamed from: getFocusIndex-impl, reason: not valid java name */
    private static final int m7481getFocusIndeximpl(long r100) {
        return (int) (r100 & 3);
    }

    /* JADX INFO: renamed from: getHasBoundedHeight-impl, reason: not valid java name */
    public static final boolean m7482getHasBoundedHeightimpl(long r100) {
        int r101 = (int) (3 & r100);
        int r102 = ((r101 & 1) << 1) + (((r101 & 2) >> 1) * 3);
        int r103 = (1 << (18 - r102)) - 1;
        if ((((int) (r100 >> ((r102 + 15) + 31))) & r103) != 0) goto L7;
        return false;
    L7:
        return true;
    }

    /* JADX INFO: renamed from: getHasBoundedWidth-impl, reason: not valid java name */
    public static final boolean m7483getHasBoundedWidthimpl(long r100) {
        int r101 = (int) (3 & r100);
        int r102 = (int) (r100 >> 33);
        if ((r102 & ((1 << ((((r101 & 1) << 1) + (((r101 & 2) >> 1) * 3)) + 13)) - 1)) != 0) goto L7;
        return false;
    L7:
        return true;
    }

    public static /* synthetic */ void getHasFixedHeight$annotations() {
    }

    /* JADX INFO: renamed from: getHasFixedHeight-impl, reason: not valid java name */
    public static final boolean m7484getHasFixedHeightimpl(long r100) {
        int r101 = (int) (3 & r100);
        int r102 = ((r101 & 1) << 1) + (((r101 & 2) >> 1) * 3);
        int r103 = (1 << (18 - r102)) - 1;
        int r104 = r102 + 15;
        int r105 = ((int) (r100 >> r104)) & r103;
        int r106 = ((int) (r100 >> (r104 + 31))) & r103;
        if (r106 != 0) goto L5;
        int r107 = Integer.MAX_VALUE;
    L6:
        if (r105 == r107) goto L10;
        return false;
    L10:
        return true;
    L5:
        r107 = r106 - 1;
        goto L6
    }

    public static /* synthetic */ void getHasFixedWidth$annotations() {
    }

    /* JADX INFO: renamed from: getHasFixedWidth-impl, reason: not valid java name */
    public static final boolean m7485getHasFixedWidthimpl(long r100) {
        int r101 = (int) (3 & r100);
        int r102 = (1 << ((((r101 & 1) << 1) + (((r101 & 2) >> 1) * 3)) + 13)) - 1;
        int r103 = ((int) (r100 >> 2)) & r102;
        int r104 = ((int) (r100 >> 33)) & r102;
        if (r104 != 0) goto L5;
        int r105 = Integer.MAX_VALUE;
    L6:
        if (r103 == r105) goto L10;
        return false;
    L10:
        return true;
    L5:
        r105 = r104 - 1;
        goto L6
    }

    /* JADX INFO: renamed from: getMaxHeight-impl, reason: not valid java name */
    public static final int m7486getMaxHeightimpl(long r100) {
        int r101 = (int) (3 & r100);
        int r102 = ((r101 & 1) << 1) + (((r101 & 2) >> 1) * 3);
        int r103 = (1 << (18 - r102)) - 1;
        int r104 = ((int) (r100 >> ((r102 + 15) + 31))) & r103;
        if (r104 != 0) goto L6;
        return Integer.MAX_VALUE;
    L6:
        return r104 - 1;
    }

    /* JADX INFO: renamed from: getMaxWidth-impl, reason: not valid java name */
    public static final int m7487getMaxWidthimpl(long r100) {
        int r101 = (int) (3 & r100);
        int r102 = (int) (r100 >> 33);
        int r103 = r102 & ((1 << ((((r101 & 1) << 1) + (((r101 & 2) >> 1) * 3)) + 13)) - 1);
        if (r103 != 0) goto L6;
        return Integer.MAX_VALUE;
    L6:
        return r103 - 1;
    }

    /* JADX INFO: renamed from: getMinHeight-impl, reason: not valid java name */
    public static final int m7488getMinHeightimpl(long r100) {
        int r101 = (int) (3 & r100);
        int r102 = ((r101 & 1) << 1) + (((r101 & 2) >> 1) * 3);
        int r103 = (1 << (18 - r102)) - 1;
        return ((int) (r100 >> (r102 + 15))) & r103;
    }

    /* JADX INFO: renamed from: getMinWidth-impl, reason: not valid java name */
    public static final int m7489getMinWidthimpl(long r100) {
        int r101 = (int) (3 & r100);
        int r102 = (int) (r100 >> 2);
        return r102 & ((1 << ((((r101 & 1) << 1) + (((r101 & 2) >> 1) * 3)) + 13)) - 1);
    }

    public static /* synthetic */ void getValue$annotations() {
    }

    /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
    public static int m7490hashCodeimpl(long r100) {
        return (int) (r100 ^ (r100 >>> 32));
    }

    public static /* synthetic */ void isZero$annotations() {
    }

    /* JADX INFO: renamed from: isZero-impl, reason: not valid java name */
    public static final boolean m7491isZeroimpl(long r100) {
        int r101 = (int) (3 & r100);
        boolean r102 = true;
        int r103 = ((r101 & 1) << 1) + (((r101 & 2) >> 1) * 3);
        int r104 = (((int) (r100 >> 33)) & ((1 << (r103 + 13)) - 1)) - 1;
        int r105 = (int) (r100 >> ((r103 + 15) + 31));
        int r106 = (((1 << (18 - r103)) - 1) & r105) - 1;
        if (r104 != 0) goto L5;
        boolean r107 = true;
    L6:
        if (r106 == 0) goto L10;
        r102 = false;
    L10:
        return r107 | r102;
    L5:
        r107 = false;
        goto L6
    }

    public boolean equals(Object r100) {
        return m7479equalsimpl(this.value, r100);
    }

    public int hashCode() {
        return m7490hashCodeimpl(this.value);
    }

    /* JADX INFO: renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ long m7493unboximpl() {
        return this.value;
    }

    public String toString() {
        return m7492toStringimpl(this.value);
    }

    private /* synthetic */ Constraints(long r100) {
        this.value = r100;
    }

    /* JADX INFO: renamed from: copyMaxDimensions-msEJaDk, reason: not valid java name */
    public static final long m7478copyMaxDimensionsmsEJaDk(long r100) {
        return m7475constructorimpl(r100 & ConstraintsKt.MaxDimensionsAndFocusMask);
    }

    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m7492toStringimpl(long r100) {
        int r101 = m7487getMaxWidthimpl(r100);
        String r102 = "Infinity";
        if (r101 != Integer.MAX_VALUE) goto L5;
        String r103 = "Infinity";
    L6:
        int r104 = m7486getMaxHeightimpl(r100);
        if (r104 == Integer.MAX_VALUE) goto L11;
        r102 = String.valueOf(r104);
    L11:
        return "Constraints(minWidth = " + m7489getMinWidthimpl(r100) + ", maxWidth = " + r103 + ", minHeight = " + m7488getMinHeightimpl(r100) + ", maxHeight = " + r102 + ')';
    L5:
        r103 = String.valueOf(r101);
        goto L6
    }

    /* JADX INFO: renamed from: copy-Zbe2FdA, reason: not valid java name */
    public static final long m7476copyZbe2FdA(long r100, int r101, int r102, int r103, int r104) {
        if (r102 < r101) goto L7;
        if (r104 < r103) goto L7;
        if (r101 < 0) goto L7;
        if (r103 < 0) goto L7;
        boolean r105 = true;
    L8:
        if (r105 == true) goto L11;
        InlineClassHelperKt.throwIllegalArgumentException("maxWidth must be >= than minWidth,\nmaxHeight must be >= than minHeight,\nminWidth and minHeight must be >= 0");
    L11:
        return ConstraintsKt.createConstraints(r101, r102, r103, r104);
    L7:
        r105 = false;
        goto L8
    }

    /* JADX INFO: renamed from: copy-Zbe2FdA$default, reason: not valid java name */
    public static /* synthetic */ long m7477copyZbe2FdA$default(long r100, int r101, int r102, int r110, int r111, int r112, Object r113) {
        if ((r112 & 1) == 0) goto L5;
        r101 = m7489getMinWidthimpl(r100);
    L5:
        int r103 = r101;
        if ((r112 & 2) == 0) goto L8;
        r102 = m7487getMaxWidthimpl(r100);
    L8:
        int r104 = r102;
        if ((r112 & 4) == 0) goto L11;
        r110 = m7488getMinHeightimpl(r100);
    L11:
        int r105 = r110;
        if ((r112 & 8) == 0) goto L15;
        r111 = m7486getMaxHeightimpl(r100);
    L15:
        return m7476copyZbe2FdA(r100, r103, r104, r105, r111);
    }
}
