package androidx.compose.ui.focus;

import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087@\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\u0011\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0006\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001a\u00020\u0003HÖ\u0001R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\u0088\u0001\u0002\u0092\u0001\u00020\u0003¨\u0006\u000f"}, d2 = {"Landroidx/compose/ui/focus/FocusDirection;", "", "value", "", "constructor-impl", "(I)I", "toString", "", "toString-impl", "(I)Ljava/lang/String;", "equals", "", "other", "hashCode", "Companion", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
@JvmInline
public final class FocusDirection {
    public static final Companion Companion = null;
    private static final int Down = 0;
    private static final int Enter = 0;
    private static final int Exit = 0;
    private static final int Left = 0;
    private static final int Next = 0;
    private static final int Previous = 0;
    private static final int Right = 0;
    private static final int Up = 0;
    private final int value;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0012\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0013\u0010\u0004\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007R\u0013\u0010\t\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\n\u0010\u0007R\u0013\u0010\u000b\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\f\u0010\u0007R\u0013\u0010\r\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u000e\u0010\u0007R\u0013\u0010\u000f\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0010\u0010\u0007R\u0013\u0010\u0011\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0012\u0010\u0007R\u0013\u0010\u0013\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0014\u0010\u0007R\u0013\u0010\u0015\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0016\u0010\u0007¨\u0006\u0017"}, d2 = {"Landroidx/compose/ui/focus/FocusDirection$Companion;", "", "<init>", "()V", "Next", "Landroidx/compose/ui/focus/FocusDirection;", "getNext-dhqQ-8s", "()I", "I", "Previous", "getPrevious-dhqQ-8s", "Left", "getLeft-dhqQ-8s", "Right", "getRight-dhqQ-8s", "Up", "getUp-dhqQ-8s", "Down", "getDown-dhqQ-8s", "Enter", "getEnter-dhqQ-8s", "Exit", "getExit-dhqQ-8s", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        /* JADX INFO: renamed from: getDown-dhqQ-8s, reason: not valid java name */
        public final int m4465getDowndhqQ8s() {
            return FocusDirection.access$getDown$cp();
        }

        /* JADX INFO: renamed from: getEnter-dhqQ-8s, reason: not valid java name */
        public final int m4466getEnterdhqQ8s() {
            return FocusDirection.access$getEnter$cp();
        }

        /* JADX INFO: renamed from: getExit-dhqQ-8s, reason: not valid java name */
        public final int m4467getExitdhqQ8s() {
            return FocusDirection.access$getExit$cp();
        }

        /* JADX INFO: renamed from: getLeft-dhqQ-8s, reason: not valid java name */
        public final int m4468getLeftdhqQ8s() {
            return FocusDirection.access$getLeft$cp();
        }

        /* JADX INFO: renamed from: getNext-dhqQ-8s, reason: not valid java name */
        public final int m4469getNextdhqQ8s() {
            return FocusDirection.access$getNext$cp();
        }

        /* JADX INFO: renamed from: getPrevious-dhqQ-8s, reason: not valid java name */
        public final int m4470getPreviousdhqQ8s() {
            return FocusDirection.access$getPrevious$cp();
        }

        /* JADX INFO: renamed from: getRight-dhqQ-8s, reason: not valid java name */
        public final int m4471getRightdhqQ8s() {
            return FocusDirection.access$getRight$cp();
        }

        /* JADX INFO: renamed from: getUp-dhqQ-8s, reason: not valid java name */
        public final int m4472getUpdhqQ8s() {
            return FocusDirection.access$getUp$cp();
        }
    }

    /* JADX INFO: renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ FocusDirection m4458boximpl(int r100) {
        return new FocusDirection(r100);
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static int m4459constructorimpl(int r100) {
        return r100;
    }

    /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
    public static boolean m4460equalsimpl(int r100, Object r101) {
        if ((r101 instanceof FocusDirection) == true) goto L6;
        return false;
    L6:
        if (r100 == ((FocusDirection) r101).m4464unboximpl()) goto L8;
        return false;
    L8:
        return true;
    }

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m4461equalsimpl0(int r100, int r101) {
        if (r100 != r101) goto L4;
        return true;
    L4:
        return false;
    }

    /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
    public static int m4462hashCodeimpl(int r100) {
        return r100;
    }

    public boolean equals(Object r100) {
        return m4460equalsimpl(this.value, r100);
    }

    public int hashCode() {
        return m4462hashCodeimpl(this.value);
    }

    /* JADX INFO: renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ int m4464unboximpl() {
        return this.value;
    }

    static {
        Companion = new Companion(null);
        Next = m4459constructorimpl(1);
        Previous = m4459constructorimpl(2);
        Left = m4459constructorimpl(3);
        Right = m4459constructorimpl(4);
        Up = m4459constructorimpl(5);
        Down = m4459constructorimpl(6);
        Enter = m4459constructorimpl(7);
        Exit = m4459constructorimpl(8);
    }

    public String toString() {
        return m4463toStringimpl(this.value);
    }

    public static final /* synthetic */ int access$getDown$cp() {
        return Down;
    }

    public static final /* synthetic */ int access$getEnter$cp() {
        return Enter;
    }

    public static final /* synthetic */ int access$getExit$cp() {
        return Exit;
    }

    public static final /* synthetic */ int access$getLeft$cp() {
        return Left;
    }

    public static final /* synthetic */ int access$getNext$cp() {
        return Next;
    }

    public static final /* synthetic */ int access$getPrevious$cp() {
        return Previous;
    }

    public static final /* synthetic */ int access$getRight$cp() {
        return Right;
    }

    public static final /* synthetic */ int access$getUp$cp() {
        return Up;
    }

    private /* synthetic */ FocusDirection(int r100) {
        this.value = r100;
    }

    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m4463toStringimpl(int r100) {
        if (m4461equalsimpl0(r100, Next) == false) goto L6;
        return "Next";
    L6:
        if (m4461equalsimpl0(r100, Previous) == false) goto L9;
        return "Previous";
    L9:
        if (m4461equalsimpl0(r100, Left) == false) goto L12;
        return "Left";
    L12:
        if (m4461equalsimpl0(r100, Right) == false) goto L15;
        return "Right";
    L15:
        if (m4461equalsimpl0(r100, Up) == false) goto L18;
        return "Up";
    L18:
        if (m4461equalsimpl0(r100, Down) == false) goto L21;
        return "Down";
    L21:
        if (m4461equalsimpl0(r100, Enter) == false) goto L24;
        return "Enter";
    L24:
        if (m4461equalsimpl0(r100, Exit) == false) goto L26;
        return "Exit";
    L26:
        return "Invalid FocusDirection";
    }
}
