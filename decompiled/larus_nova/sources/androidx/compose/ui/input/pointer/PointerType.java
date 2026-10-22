package androidx.compose.ui.input.pointer;

import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087@\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0006\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001a\u00020\u0003HÖ\u0001R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\u0088\u0001\u0002\u0092\u0001\u00020\u0003¨\u0006\u000f"}, d2 = {"Landroidx/compose/ui/input/pointer/PointerType;", "", "value", "", "constructor-impl", "(I)I", "toString", "", "toString-impl", "(I)Ljava/lang/String;", "equals", "", "other", "hashCode", "Companion", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
@JvmInline
public final class PointerType {
    public static final Companion Companion = null;
    private static final int Eraser = 0;
    private static final int Mouse = 0;
    private static final int Stylus = 0;
    private static final int Touch = 0;
    private static final int Unknown = 0;
    private final int value;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0013\u0010\u0004\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007R\u0013\u0010\t\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\n\u0010\u0007R\u0013\u0010\u000b\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\f\u0010\u0007R\u0013\u0010\r\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u000e\u0010\u0007R\u0013\u0010\u000f\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0010\u0010\u0007¨\u0006\u0011"}, d2 = {"Landroidx/compose/ui/input/pointer/PointerType$Companion;", "", "<init>", "()V", "Unknown", "Landroidx/compose/ui/input/pointer/PointerType;", "getUnknown-T8wyACA", "()I", "I", "Touch", "getTouch-T8wyACA", "Mouse", "getMouse-T8wyACA", "Stylus", "getStylus-T8wyACA", "Eraser", "getEraser-T8wyACA", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        /* JADX INFO: renamed from: getEraser-T8wyACA, reason: not valid java name */
        public final int m6202getEraserT8wyACA() {
            return PointerType.access$getEraser$cp();
        }

        /* JADX INFO: renamed from: getMouse-T8wyACA, reason: not valid java name */
        public final int m6203getMouseT8wyACA() {
            return PointerType.access$getMouse$cp();
        }

        /* JADX INFO: renamed from: getStylus-T8wyACA, reason: not valid java name */
        public final int m6204getStylusT8wyACA() {
            return PointerType.access$getStylus$cp();
        }

        /* JADX INFO: renamed from: getTouch-T8wyACA, reason: not valid java name */
        public final int m6205getTouchT8wyACA() {
            return PointerType.access$getTouch$cp();
        }

        /* JADX INFO: renamed from: getUnknown-T8wyACA, reason: not valid java name */
        public final int m6206getUnknownT8wyACA() {
            return PointerType.access$getUnknown$cp();
        }
    }

    /* JADX INFO: renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ PointerType m6195boximpl(int r100) {
        return new PointerType(r100);
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    private static int m6196constructorimpl(int r100) {
        return r100;
    }

    /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
    public static boolean m6197equalsimpl(int r100, Object r101) {
        if ((r101 instanceof PointerType) == true) goto L6;
        return false;
    L6:
        if (r100 == ((PointerType) r101).m6201unboximpl()) goto L8;
        return false;
    L8:
        return true;
    }

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m6198equalsimpl0(int r100, int r101) {
        if (r100 != r101) goto L4;
        return true;
    L4:
        return false;
    }

    /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
    public static int m6199hashCodeimpl(int r100) {
        return r100;
    }

    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m6200toStringimpl(int r100) {
        if (r100 != 1) goto L5;
        return "Touch";
    L5:
        if (r100 != 2) goto L7;
        return "Mouse";
    L7:
        if (r100 != 3) goto L9;
        return "Stylus";
    L9:
        if (r100 == 4) goto L11;
        return "Unknown";
    L11:
        return "Eraser";
    }

    public boolean equals(Object r100) {
        return m6197equalsimpl(this.value, r100);
    }

    public int hashCode() {
        return m6199hashCodeimpl(this.value);
    }

    /* JADX INFO: renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ int m6201unboximpl() {
        return this.value;
    }

    static {
        Companion = new Companion(null);
        Unknown = m6196constructorimpl(0);
        Touch = m6196constructorimpl(1);
        Mouse = m6196constructorimpl(2);
        Stylus = m6196constructorimpl(3);
        Eraser = m6196constructorimpl(4);
    }

    public String toString() {
        return m6200toStringimpl(this.value);
    }

    public static final /* synthetic */ int access$getEraser$cp() {
        return Eraser;
    }

    public static final /* synthetic */ int access$getMouse$cp() {
        return Mouse;
    }

    public static final /* synthetic */ int access$getStylus$cp() {
        return Stylus;
    }

    public static final /* synthetic */ int access$getTouch$cp() {
        return Touch;
    }

    public static final /* synthetic */ int access$getUnknown$cp() {
        return Unknown;
    }

    private /* synthetic */ PointerType(int r100) {
        this.value = r100;
    }
}
