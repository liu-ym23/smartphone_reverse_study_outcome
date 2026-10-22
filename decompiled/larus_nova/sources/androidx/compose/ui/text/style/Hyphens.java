package androidx.compose.ui.text.style;

import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087@\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0006\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001a\u00020\u0003HÖ\u0001R\u000e\u0010\u0002\u001a\u00020\u0003X\u0080\u0004¢\u0006\u0002\n\u0000\u0088\u0001\u0002\u0092\u0001\u00020\u0003¨\u0006\u000f"}, d2 = {"Landroidx/compose/ui/text/style/Hyphens;", "", "value", "", "constructor-impl", "(I)I", "toString", "", "toString-impl", "(I)Ljava/lang/String;", "equals", "", "other", "hashCode", "Companion", "ui-text"}, k = 1, mv = {2, 0, 0}, xi = 48)
@JvmInline
public final class Hyphens {
    private static final int Auto = 0;
    public static final Companion Companion = null;
    private static final int None = 0;
    private static final int Unspecified = 0;
    private final int value;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0013\u0010\u0004\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007R\u0013\u0010\t\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\n\u0010\u0007R\u0013\u0010\u000b\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\f\u0010\u0007¨\u0006\r"}, d2 = {"Landroidx/compose/ui/text/style/Hyphens$Companion;", "", "<init>", "()V", "None", "Landroidx/compose/ui/text/style/Hyphens;", "getNone-vmbZdU8", "()I", "I", "Auto", "getAuto-vmbZdU8", "Unspecified", "getUnspecified-vmbZdU8", "ui-text"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        /* JADX INFO: renamed from: getAuto-vmbZdU8, reason: not valid java name */
        public final int m7316getAutovmbZdU8() {
            return Hyphens.access$getAuto$cp();
        }

        /* JADX INFO: renamed from: getNone-vmbZdU8, reason: not valid java name */
        public final int m7317getNonevmbZdU8() {
            return Hyphens.access$getNone$cp();
        }

        /* JADX INFO: renamed from: getUnspecified-vmbZdU8, reason: not valid java name */
        public final int m7318getUnspecifiedvmbZdU8() {
            return Hyphens.access$getUnspecified$cp();
        }
    }

    /* JADX INFO: renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ Hyphens m7309boximpl(int r100) {
        return new Hyphens(r100);
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    private static int m7310constructorimpl(int r100) {
        return r100;
    }

    /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
    public static boolean m7311equalsimpl(int r100, Object r101) {
        if ((r101 instanceof Hyphens) == true) goto L6;
        return false;
    L6:
        if (r100 == ((Hyphens) r101).m7315unboximpl()) goto L8;
        return false;
    L8:
        return true;
    }

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m7312equalsimpl0(int r100, int r101) {
        if (r100 != r101) goto L4;
        return true;
    L4:
        return false;
    }

    /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
    public static int m7313hashCodeimpl(int r100) {
        return r100;
    }

    public boolean equals(Object r100) {
        return m7311equalsimpl(this.value, r100);
    }

    public int hashCode() {
        return m7313hashCodeimpl(this.value);
    }

    /* JADX INFO: renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ int m7315unboximpl() {
        return this.value;
    }

    static {
        Companion = new Companion(null);
        None = m7310constructorimpl(1);
        Auto = m7310constructorimpl(2);
        Unspecified = m7310constructorimpl(Integer.MIN_VALUE);
    }

    public String toString() {
        return m7314toStringimpl(this.value);
    }

    public static final /* synthetic */ int access$getAuto$cp() {
        return Auto;
    }

    public static final /* synthetic */ int access$getNone$cp() {
        return None;
    }

    public static final /* synthetic */ int access$getUnspecified$cp() {
        return Unspecified;
    }

    private /* synthetic */ Hyphens(int r100) {
        this.value = r100;
    }

    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m7314toStringimpl(int r100) {
        if (m7312equalsimpl0(r100, None) == false) goto L6;
        return "Hyphens.None";
    L6:
        if (m7312equalsimpl0(r100, Auto) == false) goto L9;
        return "Hyphens.Auto";
    L9:
        if (m7312equalsimpl0(r100, Unspecified) == false) goto L11;
        return "Hyphens.Unspecified";
    L11:
        return "Invalid";
    }
}
