package androidx.compose.ui.input.pointer;

import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087@\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0006\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001a\u00020\u0003HÖ\u0001R\u000e\u0010\u0002\u001a\u00020\u0003X\u0080\u0004¢\u0006\u0002\n\u0000\u0088\u0001\u0002\u0092\u0001\u00020\u0003¨\u0006\u000f"}, d2 = {"Landroidx/compose/ui/input/pointer/PointerEventType;", "", "value", "", "constructor-impl", "(I)I", "toString", "", "toString-impl", "(I)Ljava/lang/String;", "equals", "", "other", "hashCode", "Companion", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
@JvmInline
public final class PointerEventType {
    public static final Companion Companion = null;
    private static final int Enter = 0;
    private static final int Exit = 0;
    private static final int Move = 0;
    private static final int Press = 0;
    private static final int Release = 0;
    private static final int Scroll = 0;
    private static final int Unknown = 0;
    private final int value;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0010\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0013\u0010\u0004\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007R\u0013\u0010\t\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\n\u0010\u0007R\u0013\u0010\u000b\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\f\u0010\u0007R\u0013\u0010\r\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u000e\u0010\u0007R\u0013\u0010\u000f\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0010\u0010\u0007R\u0013\u0010\u0011\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0012\u0010\u0007R\u0013\u0010\u0013\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0014\u0010\u0007¨\u0006\u0015"}, d2 = {"Landroidx/compose/ui/input/pointer/PointerEventType$Companion;", "", "<init>", "()V", "Unknown", "Landroidx/compose/ui/input/pointer/PointerEventType;", "getUnknown-7fucELk", "()I", "I", "Press", "getPress-7fucELk", "Release", "getRelease-7fucELk", "Move", "getMove-7fucELk", "Enter", "getEnter-7fucELk", "Exit", "getExit-7fucELk", "Scroll", "getScroll-7fucELk", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        /* JADX INFO: renamed from: getEnter-7fucELk, reason: not valid java name */
        public final int m6079getEnter7fucELk() {
            return PointerEventType.access$getEnter$cp();
        }

        /* JADX INFO: renamed from: getExit-7fucELk, reason: not valid java name */
        public final int m6080getExit7fucELk() {
            return PointerEventType.access$getExit$cp();
        }

        /* JADX INFO: renamed from: getMove-7fucELk, reason: not valid java name */
        public final int m6081getMove7fucELk() {
            return PointerEventType.access$getMove$cp();
        }

        /* JADX INFO: renamed from: getPress-7fucELk, reason: not valid java name */
        public final int m6082getPress7fucELk() {
            return PointerEventType.access$getPress$cp();
        }

        /* JADX INFO: renamed from: getRelease-7fucELk, reason: not valid java name */
        public final int m6083getRelease7fucELk() {
            return PointerEventType.access$getRelease$cp();
        }

        /* JADX INFO: renamed from: getScroll-7fucELk, reason: not valid java name */
        public final int m6084getScroll7fucELk() {
            return PointerEventType.access$getScroll$cp();
        }

        /* JADX INFO: renamed from: getUnknown-7fucELk, reason: not valid java name */
        public final int m6085getUnknown7fucELk() {
            return PointerEventType.access$getUnknown$cp();
        }
    }

    /* JADX INFO: renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ PointerEventType m6072boximpl(int r100) {
        return new PointerEventType(r100);
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    private static int m6073constructorimpl(int r100) {
        return r100;
    }

    /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
    public static boolean m6074equalsimpl(int r100, Object r101) {
        if ((r101 instanceof PointerEventType) == true) goto L6;
        return false;
    L6:
        if (r100 == ((PointerEventType) r101).m6078unboximpl()) goto L8;
        return false;
    L8:
        return true;
    }

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m6075equalsimpl0(int r100, int r101) {
        if (r100 != r101) goto L4;
        return true;
    L4:
        return false;
    }

    /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
    public static int m6076hashCodeimpl(int r100) {
        return r100;
    }

    public boolean equals(Object r100) {
        return m6074equalsimpl(this.value, r100);
    }

    public int hashCode() {
        return m6076hashCodeimpl(this.value);
    }

    /* JADX INFO: renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ int m6078unboximpl() {
        return this.value;
    }

    static {
        Companion = new Companion(null);
        Unknown = m6073constructorimpl(0);
        Press = m6073constructorimpl(1);
        Release = m6073constructorimpl(2);
        Move = m6073constructorimpl(3);
        Enter = m6073constructorimpl(4);
        Exit = m6073constructorimpl(5);
        Scroll = m6073constructorimpl(6);
    }

    public String toString() {
        return m6077toStringimpl(this.value);
    }

    public static final /* synthetic */ int access$getEnter$cp() {
        return Enter;
    }

    public static final /* synthetic */ int access$getExit$cp() {
        return Exit;
    }

    public static final /* synthetic */ int access$getMove$cp() {
        return Move;
    }

    public static final /* synthetic */ int access$getPress$cp() {
        return Press;
    }

    public static final /* synthetic */ int access$getRelease$cp() {
        return Release;
    }

    public static final /* synthetic */ int access$getScroll$cp() {
        return Scroll;
    }

    public static final /* synthetic */ int access$getUnknown$cp() {
        return Unknown;
    }

    private /* synthetic */ PointerEventType(int r100) {
        this.value = r100;
    }

    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m6077toStringimpl(int r100) {
        if (m6075equalsimpl0(r100, Press) == false) goto L6;
        return "Press";
    L6:
        if (m6075equalsimpl0(r100, Release) == false) goto L9;
        return "Release";
    L9:
        if (m6075equalsimpl0(r100, Move) == false) goto L12;
        return "Move";
    L12:
        if (m6075equalsimpl0(r100, Enter) == false) goto L15;
        return "Enter";
    L15:
        if (m6075equalsimpl0(r100, Exit) == false) goto L18;
        return "Exit";
    L18:
        if (m6075equalsimpl0(r100, Scroll) == false) goto L20;
        return "Scroll";
    L20:
        return "Unknown";
    }
}
