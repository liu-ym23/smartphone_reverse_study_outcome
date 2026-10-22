package androidx.compose.ui.input.indirect;

import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087@\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0006\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001a\u00020\u0003HÖ\u0001R\u000e\u0010\u0002\u001a\u00020\u0003X\u0080\u0004¢\u0006\u0002\n\u0000\u0088\u0001\u0002\u0092\u0001\u00020\u0003¨\u0006\u000f"}, d2 = {"Landroidx/compose/ui/input/indirect/IndirectTouchEventType;", "", "value", "", "constructor-impl", "(I)I", "toString", "", "toString-impl", "(I)Ljava/lang/String;", "equals", "", "other", "hashCode", "Companion", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
@JvmInline
public final class IndirectTouchEventType {
    public static final Companion Companion = null;
    private static final int Move = 0;
    private static final int Press = 0;
    private static final int Release = 0;
    private static final int Unknown = 0;
    private final int value;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\b\u0087\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0013\u0010\u0004\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007R\u0013\u0010\t\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\n\u0010\u0007R\u0013\u0010\u000b\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\f\u0010\u0007R\u0013\u0010\r\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u000e\u0010\u0007¨\u0006\u000f"}, d2 = {"Landroidx/compose/ui/input/indirect/IndirectTouchEventType$Companion;", "", "<init>", "()V", "Unknown", "Landroidx/compose/ui/input/indirect/IndirectTouchEventType;", "getUnknown-LxEHWp8", "()I", "I", "Press", "getPress-LxEHWp8", "Release", "getRelease-LxEHWp8", "Move", "getMove-LxEHWp8", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        /* JADX INFO: renamed from: getMove-LxEHWp8, reason: not valid java name */
        public final int m5660getMoveLxEHWp8() {
            return IndirectTouchEventType.access$getMove$cp();
        }

        /* JADX INFO: renamed from: getPress-LxEHWp8, reason: not valid java name */
        public final int m5661getPressLxEHWp8() {
            return IndirectTouchEventType.access$getPress$cp();
        }

        /* JADX INFO: renamed from: getRelease-LxEHWp8, reason: not valid java name */
        public final int m5662getReleaseLxEHWp8() {
            return IndirectTouchEventType.access$getRelease$cp();
        }

        /* JADX INFO: renamed from: getUnknown-LxEHWp8, reason: not valid java name */
        public final int m5663getUnknownLxEHWp8() {
            return IndirectTouchEventType.access$getUnknown$cp();
        }
    }

    /* JADX INFO: renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ IndirectTouchEventType m5653boximpl(int r100) {
        return new IndirectTouchEventType(r100);
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    private static int m5654constructorimpl(int r100) {
        return r100;
    }

    /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
    public static boolean m5655equalsimpl(int r100, Object r101) {
        if ((r101 instanceof IndirectTouchEventType) == true) goto L6;
        return false;
    L6:
        if (r100 == ((IndirectTouchEventType) r101).m5659unboximpl()) goto L8;
        return false;
    L8:
        return true;
    }

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m5656equalsimpl0(int r100, int r101) {
        if (r100 != r101) goto L4;
        return true;
    L4:
        return false;
    }

    /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
    public static int m5657hashCodeimpl(int r100) {
        return r100;
    }

    public boolean equals(Object r100) {
        return m5655equalsimpl(this.value, r100);
    }

    public int hashCode() {
        return m5657hashCodeimpl(this.value);
    }

    /* JADX INFO: renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ int m5659unboximpl() {
        return this.value;
    }

    static {
        Companion = new Companion(null);
        Unknown = m5654constructorimpl(0);
        Press = m5654constructorimpl(1);
        Release = m5654constructorimpl(2);
        Move = m5654constructorimpl(3);
    }

    public String toString() {
        return m5658toStringimpl(this.value);
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

    public static final /* synthetic */ int access$getUnknown$cp() {
        return Unknown;
    }

    private /* synthetic */ IndirectTouchEventType(int r100) {
        this.value = r100;
    }

    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m5658toStringimpl(int r100) {
        if (m5656equalsimpl0(r100, Press) == false) goto L6;
        return "Press";
    L6:
        if (m5656equalsimpl0(r100, Release) == false) goto L9;
        return "Release";
    L9:
        if (m5656equalsimpl0(r100, Move) == false) goto L11;
        return "Move";
    L11:
        return "Unknown";
    }
}
