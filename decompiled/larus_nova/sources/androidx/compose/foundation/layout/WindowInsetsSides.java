package androidx.compose.foundation.layout;

import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\t\b\u0087@\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0018\u0010\u0006\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u0000H\u0086\u0002¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\u0000H\u0000¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\u0013\u0010\u0011J\u0013\u0010\u0014\u001a\u00020\u000b2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\u0088\u0001\u0002\u0092\u0001\u00020\u0003¨\u0006\u0018"}, d2 = {"Landroidx/compose/foundation/layout/WindowInsetsSides;", "", "value", "", "constructor-impl", "(I)I", "plus", "sides", "plus-gK_yJZ4", "(II)I", "hasAny", "", "hasAny-bkgdKaI$foundation_layout", "(II)Z", "toString", "", "toString-impl", "(I)Ljava/lang/String;", "valueToString", "valueToString-impl", "equals", "other", "hashCode", "Companion", "foundation-layout"}, k = 1, mv = {2, 0, 0}, xi = 48)
@JvmInline
public final class WindowInsetsSides {
    private static final int AllowLeftInLtr = 0;
    private static final int AllowLeftInRtl = 0;
    private static final int AllowRightInLtr = 0;
    private static final int AllowRightInRtl = 0;
    private static final int Bottom = 0;
    public static final Companion Companion = null;
    private static final int End = 0;
    private static final int Horizontal = 0;
    private static final int Left = 0;
    private static final int Right = 0;
    private static final int Start = 0;
    private static final int Top = 0;
    private static final int Vertical = 0;
    private final int value;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u001a\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0016\u0010\u0004\u001a\u00020\u0005X\u0080\u0004¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007R\u0016\u0010\t\u001a\u00020\u0005X\u0080\u0004¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\n\u0010\u0007R\u0016\u0010\u000b\u001a\u00020\u0005X\u0080\u0004¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\f\u0010\u0007R\u0016\u0010\r\u001a\u00020\u0005X\u0080\u0004¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u000e\u0010\u0007R\u0013\u0010\u000f\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0010\u0010\u0007R\u0013\u0010\u0011\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0012\u0010\u0007R\u0013\u0010\u0013\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0014\u0010\u0007R\u0013\u0010\u0015\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0016\u0010\u0007R\u0013\u0010\u0017\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0018\u0010\u0007R\u0013\u0010\u0019\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u001a\u0010\u0007R\u0013\u0010\u001b\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u001c\u0010\u0007R\u0013\u0010\u001d\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u001e\u0010\u0007¨\u0006\u001f"}, d2 = {"Landroidx/compose/foundation/layout/WindowInsetsSides$Companion;", "", "<init>", "()V", "AllowLeftInLtr", "Landroidx/compose/foundation/layout/WindowInsetsSides;", "getAllowLeftInLtr-JoeWqyM$foundation_layout", "()I", "I", "AllowRightInLtr", "getAllowRightInLtr-JoeWqyM$foundation_layout", "AllowLeftInRtl", "getAllowLeftInRtl-JoeWqyM$foundation_layout", "AllowRightInRtl", "getAllowRightInRtl-JoeWqyM$foundation_layout", "Start", "getStart-JoeWqyM", "End", "getEnd-JoeWqyM", "Top", "getTop-JoeWqyM", "Bottom", "getBottom-JoeWqyM", "Left", "getLeft-JoeWqyM", "Right", "getRight-JoeWqyM", "Horizontal", "getHorizontal-JoeWqyM", "Vertical", "getVertical-JoeWqyM", "foundation-layout"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        /* JADX INFO: renamed from: getAllowLeftInLtr-JoeWqyM$foundation_layout, reason: not valid java name */
        public final int m818getAllowLeftInLtrJoeWqyM$foundation_layout() {
            return WindowInsetsSides.access$getAllowLeftInLtr$cp();
        }

        /* JADX INFO: renamed from: getAllowLeftInRtl-JoeWqyM$foundation_layout, reason: not valid java name */
        public final int m819getAllowLeftInRtlJoeWqyM$foundation_layout() {
            return WindowInsetsSides.access$getAllowLeftInRtl$cp();
        }

        /* JADX INFO: renamed from: getAllowRightInLtr-JoeWqyM$foundation_layout, reason: not valid java name */
        public final int m820getAllowRightInLtrJoeWqyM$foundation_layout() {
            return WindowInsetsSides.access$getAllowRightInLtr$cp();
        }

        /* JADX INFO: renamed from: getAllowRightInRtl-JoeWqyM$foundation_layout, reason: not valid java name */
        public final int m821getAllowRightInRtlJoeWqyM$foundation_layout() {
            return WindowInsetsSides.access$getAllowRightInRtl$cp();
        }

        /* JADX INFO: renamed from: getBottom-JoeWqyM, reason: not valid java name */
        public final int m822getBottomJoeWqyM() {
            return WindowInsetsSides.access$getBottom$cp();
        }

        /* JADX INFO: renamed from: getEnd-JoeWqyM, reason: not valid java name */
        public final int m823getEndJoeWqyM() {
            return WindowInsetsSides.access$getEnd$cp();
        }

        /* JADX INFO: renamed from: getHorizontal-JoeWqyM, reason: not valid java name */
        public final int m824getHorizontalJoeWqyM() {
            return WindowInsetsSides.access$getHorizontal$cp();
        }

        /* JADX INFO: renamed from: getLeft-JoeWqyM, reason: not valid java name */
        public final int m825getLeftJoeWqyM() {
            return WindowInsetsSides.access$getLeft$cp();
        }

        /* JADX INFO: renamed from: getRight-JoeWqyM, reason: not valid java name */
        public final int m826getRightJoeWqyM() {
            return WindowInsetsSides.access$getRight$cp();
        }

        /* JADX INFO: renamed from: getStart-JoeWqyM, reason: not valid java name */
        public final int m827getStartJoeWqyM() {
            return WindowInsetsSides.access$getStart$cp();
        }

        /* JADX INFO: renamed from: getTop-JoeWqyM, reason: not valid java name */
        public final int m828getTopJoeWqyM() {
            return WindowInsetsSides.access$getTop$cp();
        }

        /* JADX INFO: renamed from: getVertical-JoeWqyM, reason: not valid java name */
        public final int m829getVerticalJoeWqyM() {
            return WindowInsetsSides.access$getVertical$cp();
        }
    }

    /* JADX INFO: renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ WindowInsetsSides m808boximpl(int r100) {
        return new WindowInsetsSides(r100);
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    private static int m809constructorimpl(int r100) {
        return r100;
    }

    /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
    public static boolean m810equalsimpl(int r100, Object r101) {
        if ((r101 instanceof WindowInsetsSides) == true) goto L6;
        return false;
    L6:
        if (r100 == ((WindowInsetsSides) r101).m817unboximpl()) goto L8;
        return false;
    L8:
        return true;
    }

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m811equalsimpl0(int r100, int r101) {
        if (r100 != r101) goto L4;
        return true;
    L4:
        return false;
    }

    /* JADX INFO: renamed from: hasAny-bkgdKaI$foundation_layout, reason: not valid java name */
    public static final boolean m812hasAnybkgdKaI$foundation_layout(int r100, int r101) {
        if ((r100 & r101) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
    public static int m813hashCodeimpl(int r100) {
        return r100;
    }

    public boolean equals(Object r100) {
        return m810equalsimpl(this.value, r100);
    }

    public int hashCode() {
        return m813hashCodeimpl(this.value);
    }

    /* JADX INFO: renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ int m817unboximpl() {
        return this.value;
    }

    static {
        Companion = new Companion(null);
        int r100 = m809constructorimpl(8);
        AllowLeftInLtr = r100;
        int r101 = m809constructorimpl(4);
        AllowRightInLtr = r101;
        int r102 = m809constructorimpl(2);
        AllowLeftInRtl = r102;
        int r103 = m809constructorimpl(1);
        AllowRightInRtl = r103;
        Start = m814plusgK_yJZ4(r100, r103);
        End = m814plusgK_yJZ4(r101, r102);
        int r104 = m809constructorimpl(16);
        Top = r104;
        int r105 = m809constructorimpl(32);
        Bottom = r105;
        int r106 = m814plusgK_yJZ4(r100, r102);
        Left = r106;
        int r107 = m814plusgK_yJZ4(r101, r103);
        Right = r107;
        Horizontal = m814plusgK_yJZ4(r106, r107);
        Vertical = m814plusgK_yJZ4(r104, r105);
    }

    public String toString() {
        return m815toStringimpl(this.value);
    }

    public static final /* synthetic */ int access$getAllowLeftInLtr$cp() {
        return AllowLeftInLtr;
    }

    public static final /* synthetic */ int access$getAllowLeftInRtl$cp() {
        return AllowLeftInRtl;
    }

    public static final /* synthetic */ int access$getAllowRightInLtr$cp() {
        return AllowRightInLtr;
    }

    public static final /* synthetic */ int access$getAllowRightInRtl$cp() {
        return AllowRightInRtl;
    }

    public static final /* synthetic */ int access$getBottom$cp() {
        return Bottom;
    }

    public static final /* synthetic */ int access$getEnd$cp() {
        return End;
    }

    public static final /* synthetic */ int access$getHorizontal$cp() {
        return Horizontal;
    }

    public static final /* synthetic */ int access$getLeft$cp() {
        return Left;
    }

    public static final /* synthetic */ int access$getRight$cp() {
        return Right;
    }

    public static final /* synthetic */ int access$getStart$cp() {
        return Start;
    }

    public static final /* synthetic */ int access$getTop$cp() {
        return Top;
    }

    public static final /* synthetic */ int access$getVertical$cp() {
        return Vertical;
    }

    private /* synthetic */ WindowInsetsSides(int r100) {
        this.value = r100;
    }

    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m815toStringimpl(int r100) {
        return "WindowInsetsSides(" + m816valueToStringimpl(r100) + ')';
    }

    /* JADX INFO: renamed from: valueToString-impl, reason: not valid java name */
    private static final String m816valueToStringimpl(int r100) {
        StringBuilder r101 = new StringBuilder();
        int r102 = Start;
        if ((r100 & r102) != r102) goto L5;
        valueToString_impl$lambda$0$appendPlus(r101, "Start");
    L5:
        int r103 = Left;
        if ((r100 & r103) != r103) goto L8;
        valueToString_impl$lambda$0$appendPlus(r101, "Left");
    L8:
        int r104 = Top;
        if ((r100 & r104) != r104) goto L11;
        valueToString_impl$lambda$0$appendPlus(r101, "Top");
    L11:
        int r105 = End;
        if ((r100 & r105) != r105) goto L14;
        valueToString_impl$lambda$0$appendPlus(r101, "End");
    L14:
        int r106 = Right;
        if ((r100 & r106) != r106) goto L17;
        valueToString_impl$lambda$0$appendPlus(r101, "Right");
    L17:
        int r107 = Bottom;
        if ((r100 & r107) != r107) goto L21;
        valueToString_impl$lambda$0$appendPlus(r101, "Bottom");
    L21:
        return r101.toString();
    }

    /* JADX INFO: renamed from: plus-gK_yJZ4, reason: not valid java name */
    public static final int m814plusgK_yJZ4(int r100, int r101) {
        return m809constructorimpl(r100 | r101);
    }

    private static final void valueToString_impl$lambda$0$appendPlus(StringBuilder r100, String r101) {
        if (r100.length() <= 0) goto L5;
        boolean r102 = true;
    L6:
        if (r102 == false) goto L8;
        r100.append('+');
    L8:
        r100.append(r101);
        return;
    L5:
        r102 = false;
        goto L6
    }
}
