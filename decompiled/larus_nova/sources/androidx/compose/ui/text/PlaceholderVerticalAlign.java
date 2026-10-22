package androidx.compose.ui.text;

import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087@\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\u0011\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0006\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001a\u00020\u0003HÖ\u0001R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\u0088\u0001\u0002\u0092\u0001\u00020\u0003¨\u0006\u000f"}, d2 = {"Landroidx/compose/ui/text/PlaceholderVerticalAlign;", "", "value", "", "constructor-impl", "(I)I", "toString", "", "toString-impl", "(I)Ljava/lang/String;", "equals", "", "other", "hashCode", "Companion", "ui-text"}, k = 1, mv = {2, 0, 0}, xi = 48)
@JvmInline
public final class PlaceholderVerticalAlign {
    private static final int AboveBaseline = 0;
    private static final int Bottom = 0;
    private static final int Center = 0;
    public static final Companion Companion = null;
    private static final int TextBottom = 0;
    private static final int TextCenter = 0;
    private static final int TextTop = 0;
    private static final int Top = 0;
    private final int value;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0010\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0013\u0010\u0004\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007R\u0013\u0010\t\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\n\u0010\u0007R\u0013\u0010\u000b\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\f\u0010\u0007R\u0013\u0010\r\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u000e\u0010\u0007R\u0013\u0010\u000f\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0010\u0010\u0007R\u0013\u0010\u0011\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0012\u0010\u0007R\u0013\u0010\u0013\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0014\u0010\u0007¨\u0006\u0015"}, d2 = {"Landroidx/compose/ui/text/PlaceholderVerticalAlign$Companion;", "", "<init>", "()V", "AboveBaseline", "Landroidx/compose/ui/text/PlaceholderVerticalAlign;", "getAboveBaseline-J6kI3mc", "()I", "I", "Top", "getTop-J6kI3mc", "Bottom", "getBottom-J6kI3mc", "Center", "getCenter-J6kI3mc", "TextTop", "getTextTop-J6kI3mc", "TextBottom", "getTextBottom-J6kI3mc", "TextCenter", "getTextCenter-J6kI3mc", "ui-text"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        /* JADX INFO: renamed from: getAboveBaseline-J6kI3mc, reason: not valid java name */
        public final int m6919getAboveBaselineJ6kI3mc() {
            return PlaceholderVerticalAlign.access$getAboveBaseline$cp();
        }

        /* JADX INFO: renamed from: getBottom-J6kI3mc, reason: not valid java name */
        public final int m6920getBottomJ6kI3mc() {
            return PlaceholderVerticalAlign.access$getBottom$cp();
        }

        /* JADX INFO: renamed from: getCenter-J6kI3mc, reason: not valid java name */
        public final int m6921getCenterJ6kI3mc() {
            return PlaceholderVerticalAlign.access$getCenter$cp();
        }

        /* JADX INFO: renamed from: getTextBottom-J6kI3mc, reason: not valid java name */
        public final int m6922getTextBottomJ6kI3mc() {
            return PlaceholderVerticalAlign.access$getTextBottom$cp();
        }

        /* JADX INFO: renamed from: getTextCenter-J6kI3mc, reason: not valid java name */
        public final int m6923getTextCenterJ6kI3mc() {
            return PlaceholderVerticalAlign.access$getTextCenter$cp();
        }

        /* JADX INFO: renamed from: getTextTop-J6kI3mc, reason: not valid java name */
        public final int m6924getTextTopJ6kI3mc() {
            return PlaceholderVerticalAlign.access$getTextTop$cp();
        }

        /* JADX INFO: renamed from: getTop-J6kI3mc, reason: not valid java name */
        public final int m6925getTopJ6kI3mc() {
            return PlaceholderVerticalAlign.access$getTop$cp();
        }
    }

    /* JADX INFO: renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ PlaceholderVerticalAlign m6912boximpl(int r100) {
        return new PlaceholderVerticalAlign(r100);
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static int m6913constructorimpl(int r100) {
        return r100;
    }

    /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
    public static boolean m6914equalsimpl(int r100, Object r101) {
        if ((r101 instanceof PlaceholderVerticalAlign) == true) goto L6;
        return false;
    L6:
        if (r100 == ((PlaceholderVerticalAlign) r101).m6918unboximpl()) goto L8;
        return false;
    L8:
        return true;
    }

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m6915equalsimpl0(int r100, int r101) {
        if (r100 != r101) goto L4;
        return true;
    L4:
        return false;
    }

    /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
    public static int m6916hashCodeimpl(int r100) {
        return r100;
    }

    public boolean equals(Object r100) {
        return m6914equalsimpl(this.value, r100);
    }

    public int hashCode() {
        return m6916hashCodeimpl(this.value);
    }

    /* JADX INFO: renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ int m6918unboximpl() {
        return this.value;
    }

    static {
        Companion = new Companion(null);
        AboveBaseline = m6913constructorimpl(1);
        Top = m6913constructorimpl(2);
        Bottom = m6913constructorimpl(3);
        Center = m6913constructorimpl(4);
        TextTop = m6913constructorimpl(5);
        TextBottom = m6913constructorimpl(6);
        TextCenter = m6913constructorimpl(7);
    }

    public String toString() {
        return m6917toStringimpl(this.value);
    }

    public static final /* synthetic */ int access$getAboveBaseline$cp() {
        return AboveBaseline;
    }

    public static final /* synthetic */ int access$getBottom$cp() {
        return Bottom;
    }

    public static final /* synthetic */ int access$getCenter$cp() {
        return Center;
    }

    public static final /* synthetic */ int access$getTextBottom$cp() {
        return TextBottom;
    }

    public static final /* synthetic */ int access$getTextCenter$cp() {
        return TextCenter;
    }

    public static final /* synthetic */ int access$getTextTop$cp() {
        return TextTop;
    }

    public static final /* synthetic */ int access$getTop$cp() {
        return Top;
    }

    private /* synthetic */ PlaceholderVerticalAlign(int r100) {
        this.value = r100;
    }

    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m6917toStringimpl(int r100) {
        if (m6915equalsimpl0(r100, AboveBaseline) == false) goto L6;
        return "AboveBaseline";
    L6:
        if (m6915equalsimpl0(r100, Top) == false) goto L9;
        return "Top";
    L9:
        if (m6915equalsimpl0(r100, Bottom) == false) goto L12;
        return "Bottom";
    L12:
        if (m6915equalsimpl0(r100, Center) == false) goto L15;
        return "Center";
    L15:
        if (m6915equalsimpl0(r100, TextTop) == false) goto L18;
        return "TextTop";
    L18:
        if (m6915equalsimpl0(r100, TextBottom) == false) goto L21;
        return "TextBottom";
    L21:
        if (m6915equalsimpl0(r100, TextCenter) == false) goto L23;
        return "TextCenter";
    L23:
        return "Invalid";
    }
}
