package androidx.compose.ui.input.nestedscroll;

import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087@\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\u0011\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0006\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001a\u00020\u0003HÖ\u0001R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\u0088\u0001\u0002\u0092\u0001\u00020\u0003¨\u0006\u000f"}, d2 = {"Landroidx/compose/ui/input/nestedscroll/NestedScrollSource;", "", "value", "", "constructor-impl", "(I)I", "toString", "", "toString-impl", "(I)Ljava/lang/String;", "equals", "", "other", "hashCode", "Companion", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
@JvmInline
public final class NestedScrollSource {
    public static final Companion Companion = null;
    private static final int Drag = 0;
    private static final int Fling = 0;
    private static final int Relocate = 0;
    private static final int SideEffect = 0;
    private static final int UserInput = 0;
    private static final int Wheel = 0;
    private final int value;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0012\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0013\u0010\u0004\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007R\u0013\u0010\t\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\n\u0010\u0007R\u001e\u0010\u000b\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\b\u0012\u0004\b\f\u0010\u0003\u001a\u0004\b\r\u0010\u0007R\u001e\u0010\u000e\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\b\u0012\u0004\b\u000f\u0010\u0003\u001a\u0004\b\u0010\u0010\u0007R\u001e\u0010\u0011\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\b\u0012\u0004\b\u0012\u0010\u0003\u001a\u0004\b\u0013\u0010\u0007R\u001e\u0010\u0014\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\b\u0012\u0004\b\u0015\u0010\u0003\u001a\u0004\b\u0016\u0010\u0007¨\u0006\u0017"}, d2 = {"Landroidx/compose/ui/input/nestedscroll/NestedScrollSource$Companion;", "", "<init>", "()V", "UserInput", "Landroidx/compose/ui/input/nestedscroll/NestedScrollSource;", "getUserInput-WNlRxjI", "()I", "I", "SideEffect", "getSideEffect-WNlRxjI", "Drag", "getDrag-WNlRxjI$annotations", "getDrag-WNlRxjI", "Fling", "getFling-WNlRxjI$annotations", "getFling-WNlRxjI", "Relocate", "getRelocate-WNlRxjI$annotations", "getRelocate-WNlRxjI", "Wheel", "getWheel-WNlRxjI$annotations", "getWheel-WNlRxjI", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        @Deprecated(message = "This has been replaced by UserInput.", replaceWith = @ReplaceWith(expression = "NestedScrollSource.UserInput", imports = {"import androidx.compose.ui.input.nestedscroll.NestedScrollSource.Companion.UserInput"}))
        /* JADX INFO: renamed from: getDrag-WNlRxjI$annotations, reason: not valid java name */
        public static /* synthetic */ void m6010getDragWNlRxjI$annotations() {
        }

        @Deprecated(message = "This has been replaced by SideEffect.", replaceWith = @ReplaceWith(expression = "NestedScrollSource.SideEffect", imports = {"import androidx.compose.ui.input.nestedscroll.NestedScrollSource.Companion.SideEffect"}))
        /* JADX INFO: renamed from: getFling-WNlRxjI$annotations, reason: not valid java name */
        public static /* synthetic */ void m6011getFlingWNlRxjI$annotations() {
        }

        @Deprecated(message = "Do not use. Will be removed in the future.")
        /* JADX INFO: renamed from: getRelocate-WNlRxjI$annotations, reason: not valid java name */
        public static /* synthetic */ void m6012getRelocateWNlRxjI$annotations() {
        }

        @Deprecated(message = "This has been replaced by UserInput.", replaceWith = @ReplaceWith(expression = "NestedScrollSource.UserInput", imports = {"import androidx.compose.ui.input.nestedscroll.NestedScrollSource.Companion.UserInput"}))
        /* JADX INFO: renamed from: getWheel-WNlRxjI$annotations, reason: not valid java name */
        public static /* synthetic */ void m6013getWheelWNlRxjI$annotations() {
        }

        /* JADX INFO: renamed from: getDrag-WNlRxjI, reason: not valid java name */
        public final int m6014getDragWNlRxjI() {
            return NestedScrollSource.access$getDrag$cp();
        }

        /* JADX INFO: renamed from: getFling-WNlRxjI, reason: not valid java name */
        public final int m6015getFlingWNlRxjI() {
            return NestedScrollSource.access$getFling$cp();
        }

        /* JADX INFO: renamed from: getRelocate-WNlRxjI, reason: not valid java name */
        public final int m6016getRelocateWNlRxjI() {
            return NestedScrollSource.access$getRelocate$cp();
        }

        /* JADX INFO: renamed from: getSideEffect-WNlRxjI, reason: not valid java name */
        public final int m6017getSideEffectWNlRxjI() {
            return NestedScrollSource.access$getSideEffect$cp();
        }

        /* JADX INFO: renamed from: getUserInput-WNlRxjI, reason: not valid java name */
        public final int m6018getUserInputWNlRxjI() {
            return NestedScrollSource.access$getUserInput$cp();
        }

        /* JADX INFO: renamed from: getWheel-WNlRxjI, reason: not valid java name */
        public final int m6019getWheelWNlRxjI() {
            return NestedScrollSource.access$getWheel$cp();
        }
    }

    /* JADX INFO: renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ NestedScrollSource m6003boximpl(int r100) {
        return new NestedScrollSource(r100);
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static int m6004constructorimpl(int r100) {
        return r100;
    }

    /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
    public static boolean m6005equalsimpl(int r100, Object r101) {
        if ((r101 instanceof NestedScrollSource) == true) goto L6;
        return false;
    L6:
        if (r100 == ((NestedScrollSource) r101).m6009unboximpl()) goto L8;
        return false;
    L8:
        return true;
    }

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m6006equalsimpl0(int r100, int r101) {
        if (r100 != r101) goto L4;
        return true;
    L4:
        return false;
    }

    /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
    public static int m6007hashCodeimpl(int r100) {
        return r100;
    }

    public boolean equals(Object r100) {
        return m6005equalsimpl(this.value, r100);
    }

    public int hashCode() {
        return m6007hashCodeimpl(this.value);
    }

    /* JADX INFO: renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ int m6009unboximpl() {
        return this.value;
    }

    static {
        Companion = new Companion(null);
        int r100 = m6004constructorimpl(1);
        UserInput = r100;
        int r101 = m6004constructorimpl(2);
        SideEffect = r101;
        Drag = r100;
        Fling = r101;
        Relocate = m6004constructorimpl(3);
        Wheel = r100;
    }

    public String toString() {
        return m6008toStringimpl(this.value);
    }

    public static final /* synthetic */ int access$getDrag$cp() {
        return Drag;
    }

    public static final /* synthetic */ int access$getFling$cp() {
        return Fling;
    }

    public static final /* synthetic */ int access$getRelocate$cp() {
        return Relocate;
    }

    public static final /* synthetic */ int access$getSideEffect$cp() {
        return SideEffect;
    }

    public static final /* synthetic */ int access$getUserInput$cp() {
        return UserInput;
    }

    public static final /* synthetic */ int access$getWheel$cp() {
        return Wheel;
    }

    private /* synthetic */ NestedScrollSource(int r100) {
        this.value = r100;
    }

    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m6008toStringimpl(int r100) {
        if (m6006equalsimpl0(r100, UserInput) == false) goto L6;
        return "UserInput";
    L6:
        if (m6006equalsimpl0(r100, SideEffect) == false) goto L9;
        return "SideEffect";
    L9:
        if (m6006equalsimpl0(r100, Relocate) == false) goto L11;
        return "Relocate";
    L11:
        return "Invalid";
    }
}
