package androidx.compose.ui.node;

import androidx.compose.ui.internal.InlineClassHelperKt;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0087@\u0018\u0000  2\u00020\u0001:\u0001 B\u0011\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u0016H\u0000¢\u0006\u0004\b\u0017\u0010\u0018J\u0017\u0010\u0019\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u0016H\u0000¢\u0006\u0004\b\u001a\u0010\u0018J\u0013\u0010\u001b\u001a\u00020\u00112\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001d\u001a\u00020\u0007HÖ\u0001J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0011\u0010\n\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b\u000b\u0010\tR\u0011\u0010\f\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b\r\u0010\tR\u0011\u0010\u000e\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b\u000f\u0010\tR\u0011\u0010\u0010\u001a\u00020\u00118F¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013\u0088\u0001\u0002\u0092\u0001\u00020\u0003¨\u0006!"}, d2 = {"Landroidx/compose/ui/node/TouchBoundsExpansion;", "", "packedValue", "", "constructor-impl", "(J)J", "start", "", "getStart-impl", "(J)I", "top", "getTop-impl", "end", "getEnd-impl", "bottom", "getBottom-impl", "isLayoutDirectionAware", "", "isLayoutDirectionAware-impl", "(J)Z", "computeLeft", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "computeLeft-impl$ui_release", "(JLandroidx/compose/ui/unit/LayoutDirection;)I", "computeRight", "computeRight-impl$ui_release", "equals", "other", "hashCode", "toString", "", "Companion", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
@JvmInline
public final class TouchBoundsExpansion {
    public static final Companion Companion = null;
    private static final long IS_LAYOUT_DIRECTION_AWARE = Long.MIN_VALUE;
    private static final int MASK = 32767;
    public static final int MAX_VALUE = 32767;
    private static final long None = 0;
    private static final int SHIFT = 15;
    private final long packedValue;

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J5\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u00072\b\b\u0002\u0010\n\u001a\u00020\u0007¢\u0006\u0004\b\u000b\u0010\fJ5\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u0016H\u0000¢\u0006\u0002\b\u0017J\u0018\u0010\u001c\u001a\u00020\u00072\u0006\u0010\u001d\u001a\u00020\u00122\u0006\u0010\u001e\u001a\u00020\u0007H\u0002J\u0018\u0010\u001f\u001a\u00020\u00122\u0006\u0010 \u001a\u00020\u00072\u0006\u0010\u001e\u001a\u00020\u0007H\u0002R\u0013\u0010\r\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0018\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0007X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0012X\u0082T¢\u0006\u0002\n\u0000¨\u0006!"}, d2 = {"Landroidx/compose/ui/node/TouchBoundsExpansion$Companion;", "", "<init>", "()V", "Absolute", "Landroidx/compose/ui/node/TouchBoundsExpansion;", "left", "", "top", "right", "bottom", "Absolute-vsh68fg", "(IIII)J", "None", "getNone-RZrCHBk", "()J", "J", "pack", "", "start", "end", "isLayoutDirectionAware", "", "pack$ui_release", "MASK", "SHIFT", "MAX_VALUE", "IS_LAYOUT_DIRECTION_AWARE", "unpack", "packedValue", "position", "trimAndShift", "int", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        private final long trimAndShift(int r100, int r101) {
            return ((long) (r100 & 32767)) << (r101 * 15);
        }

        private final int unpack(long r100, int r101) {
            return ((int) (r100 >> (r101 * 15))) & 32767;
        }

        /* JADX INFO: renamed from: getNone-RZrCHBk, reason: not valid java name */
        public final long m6655getNoneRZrCHBk() {
            return TouchBoundsExpansion.access$getNone$cp();
        }

        public static final /* synthetic */ int access$unpack(Companion r100, long r101, int r102) {
            return r100.unpack(r101, r102);
        }

        /* JADX INFO: renamed from: Absolute-vsh68fg, reason: not valid java name */
        public final long m6654Absolutevsh68fg(int r100, int r101, int r110, int r111) {
            boolean r102 = true;
            if (r100 < 0) goto L6;
            if (r100 >= 32768) goto L6;
            boolean r103 = true;
        L7:
            if (r103 == true) goto L9;
            InlineClassHelperKt.throwIllegalArgumentException("Start must be in the range of 0 .. 32767");
        L9:
            if (r101 < 0) goto L12;
            if (r101 >= 32768) goto L12;
            boolean r104 = true;
        L13:
            if (r104 == true) goto L15;
            InlineClassHelperKt.throwIllegalArgumentException("Top must be in the range of 0 .. 32767");
        L15:
            if (r110 < 0) goto L18;
            if (r110 >= 32768) goto L18;
            boolean r105 = true;
        L19:
            if (r105 == true) goto L21;
            InlineClassHelperKt.throwIllegalArgumentException("End must be in the range of 0 .. 32767");
        L21:
            if (r111 < 0) goto L24;
            if (r111 >= 32768) goto L24;
        L25:
            if (r102 == true) goto L28;
            InlineClassHelperKt.throwIllegalArgumentException("Bottom must be in the range of 0 .. 32767");
        L28:
            return TouchBoundsExpansion.m6642constructorimpl(pack$ui_release(r100, r101, r110, r111, false));
        L24:
            r102 = false;
        L18:
            r105 = false;
        L12:
            r104 = false;
        L6:
            r103 = false;
            goto L7
        }

        public final long pack$ui_release(int r100, int r101, int r102, int r103, boolean r104) {
            long r105 = trimAndShift(r100, 0);
            long r106 = ((trimAndShift(r101, 1) | r105) | trimAndShift(r102, 2)) | trimAndShift(r103, 3);
            if (r104 == false) goto L5;
            long r107 = Long.MIN_VALUE;
        L7:
            return r106 | r107;
        L5:
            r107 = 0;
            goto L7
        }

        /* JADX INFO: renamed from: Absolute-vsh68fg$default, reason: not valid java name */
        public static /* synthetic */ long m6653Absolutevsh68fg$default(Companion r100, int r101, int r102, int r103, int r104, int r105, Object r106) {
            if ((r105 & 1) == 0) goto L6;
            r101 = 0;
        L6:
            if ((r105 & 2) == 0) goto L9;
            r102 = 0;
        L9:
            if ((r105 & 4) == 0) goto L12;
            r103 = 0;
        L12:
            if ((r105 & 8) == 0) goto L15;
            r104 = 0;
        L15:
            return r100.m6654Absolutevsh68fg(r101, r102, r103, r104);
        }
    }

    /* JADX INFO: renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ TouchBoundsExpansion m6639boximpl(long r100) {
        return new TouchBoundsExpansion(r100);
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static long m6642constructorimpl(long r100) {
        return r100;
    }

    /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
    public static boolean m6643equalsimpl(long r100, Object r101) {
        if ((r101 instanceof TouchBoundsExpansion) == true) goto L6;
        return false;
    L6:
        if (r100 == ((TouchBoundsExpansion) r101).m6652unboximpl()) goto L8;
        return false;
    L8:
        return true;
    }

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m6644equalsimpl0(long r100, long r101) {
        if (r100 != r101) goto L5;
        return true;
    L5:
        return false;
    }

    /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
    public static int m6649hashCodeimpl(long r100) {
        return (int) (r100 ^ (r100 >>> 32));
    }

    /* JADX INFO: renamed from: isLayoutDirectionAware-impl, reason: not valid java name */
    public static final boolean m6650isLayoutDirectionAwareimpl(long r100) {
        if ((r100 & Long.MIN_VALUE) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m6651toStringimpl(long r100) {
        return "TouchBoundsExpansion(packedValue=" + r100 + ')';
    }

    public boolean equals(Object r100) {
        return m6643equalsimpl(this.packedValue, r100);
    }

    public int hashCode() {
        return m6649hashCodeimpl(this.packedValue);
    }

    public String toString() {
        return m6651toStringimpl(this.packedValue);
    }

    /* JADX INFO: renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ long m6652unboximpl() {
        return this.packedValue;
    }

    static {
        Companion = new Companion(null);
        None = TouchBoundsExpansionKt.TouchBoundsExpansion$default(0, 0, 0, 0, 14, null);
    }

    public static final /* synthetic */ long access$getNone$cp() {
        return None;
    }

    private /* synthetic */ TouchBoundsExpansion(long r100) {
        this.packedValue = r100;
    }

    /* JADX INFO: renamed from: getBottom-impl, reason: not valid java name */
    public static final int m6645getBottomimpl(long r100) {
        return Companion.access$unpack(Companion, r100, 3);
    }

    /* JADX INFO: renamed from: getEnd-impl, reason: not valid java name */
    public static final int m6646getEndimpl(long r100) {
        return Companion.access$unpack(Companion, r100, 2);
    }

    /* JADX INFO: renamed from: getStart-impl, reason: not valid java name */
    public static final int m6647getStartimpl(long r100) {
        return Companion.access$unpack(Companion, r100, 0);
    }

    /* JADX INFO: renamed from: getTop-impl, reason: not valid java name */
    public static final int m6648getTopimpl(long r100) {
        return Companion.access$unpack(Companion, r100, 1);
    }

    /* JADX INFO: renamed from: computeLeft-impl$ui_release, reason: not valid java name */
    public static final int m6640computeLeftimpl$ui_release(long r100, LayoutDirection r101) {
        if (m6650isLayoutDirectionAwareimpl(r100) == false) goto L9;
        if (r101 == LayoutDirection.Ltr) goto L9;
        return m6646getEndimpl(r100);
    L9:
        return m6647getStartimpl(r100);
    }

    /* JADX INFO: renamed from: computeRight-impl$ui_release, reason: not valid java name */
    public static final int m6641computeRightimpl$ui_release(long r100, LayoutDirection r101) {
        if (m6650isLayoutDirectionAwareimpl(r100) == false) goto L9;
        if (r101 == LayoutDirection.Ltr) goto L9;
        return m6647getStartimpl(r100);
    L9:
        return m6646getEndimpl(r100);
    }
}
