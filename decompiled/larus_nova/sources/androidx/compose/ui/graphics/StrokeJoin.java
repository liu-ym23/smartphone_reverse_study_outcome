package androidx.compose.ui.graphics;

import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087@\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\u0011\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0006\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001a\u00020\u0003HÖ\u0001R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\u0088\u0001\u0002\u0092\u0001\u00020\u0003¨\u0006\u000f"}, d2 = {"Landroidx/compose/ui/graphics/StrokeJoin;", "", "value", "", "constructor-impl", "(I)I", "toString", "", "toString-impl", "(I)Ljava/lang/String;", "equals", "", "other", "hashCode", "Companion", "ui-graphics_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
@JvmInline
public final class StrokeJoin {
    private static final int Bevel = 0;
    public static final Companion Companion = null;
    private static final int Miter = 0;
    private static final int Round = 0;
    private final int value;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0013\u0010\u0004\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007R\u0013\u0010\t\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\n\u0010\u0007R\u0013\u0010\u000b\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\f\u0010\u0007¨\u0006\r"}, d2 = {"Landroidx/compose/ui/graphics/StrokeJoin$Companion;", "", "<init>", "()V", "Miter", "Landroidx/compose/ui/graphics/StrokeJoin;", "getMiter-LxFBmk8", "()I", "I", "Round", "getRound-LxFBmk8", "Bevel", "getBevel-LxFBmk8", "ui-graphics_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        /* JADX INFO: renamed from: getBevel-LxFBmk8, reason: not valid java name */
        public final int m5216getBevelLxFBmk8() {
            return StrokeJoin.access$getBevel$cp();
        }

        /* JADX INFO: renamed from: getMiter-LxFBmk8, reason: not valid java name */
        public final int m5217getMiterLxFBmk8() {
            return StrokeJoin.access$getMiter$cp();
        }

        /* JADX INFO: renamed from: getRound-LxFBmk8, reason: not valid java name */
        public final int m5218getRoundLxFBmk8() {
            return StrokeJoin.access$getRound$cp();
        }
    }

    /* JADX INFO: renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ StrokeJoin m5209boximpl(int r100) {
        return new StrokeJoin(r100);
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static int m5210constructorimpl(int r100) {
        return r100;
    }

    /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
    public static boolean m5211equalsimpl(int r100, Object r101) {
        if ((r101 instanceof StrokeJoin) == true) goto L6;
        return false;
    L6:
        if (r100 == ((StrokeJoin) r101).m5215unboximpl()) goto L8;
        return false;
    L8:
        return true;
    }

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m5212equalsimpl0(int r100, int r101) {
        if (r100 != r101) goto L4;
        return true;
    L4:
        return false;
    }

    /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
    public static int m5213hashCodeimpl(int r100) {
        return r100;
    }

    public boolean equals(Object r100) {
        return m5211equalsimpl(this.value, r100);
    }

    public int hashCode() {
        return m5213hashCodeimpl(this.value);
    }

    /* JADX INFO: renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ int m5215unboximpl() {
        return this.value;
    }

    static {
        Companion = new Companion(null);
        Miter = m5210constructorimpl(0);
        Round = m5210constructorimpl(1);
        Bevel = m5210constructorimpl(2);
    }

    public String toString() {
        return m5214toStringimpl(this.value);
    }

    public static final /* synthetic */ int access$getBevel$cp() {
        return Bevel;
    }

    public static final /* synthetic */ int access$getMiter$cp() {
        return Miter;
    }

    public static final /* synthetic */ int access$getRound$cp() {
        return Round;
    }

    private /* synthetic */ StrokeJoin(int r100) {
        this.value = r100;
    }

    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m5214toStringimpl(int r100) {
        if (m5212equalsimpl0(r100, Miter) == false) goto L6;
        return "Miter";
    L6:
        if (m5212equalsimpl0(r100, Round) == false) goto L9;
        return "Round";
    L9:
        if (m5212equalsimpl0(r100, Bevel) == false) goto L11;
        return "Bevel";
    L11:
        return "Unknown";
    }
}
