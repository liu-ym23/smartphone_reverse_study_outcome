package androidx.compose.ui.text.style;

import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087@\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\u0011\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0006\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001a\u00020\u0003HÖ\u0001R\u000e\u0010\u0002\u001a\u00020\u0003X\u0080\u0004¢\u0006\u0002\n\u0000\u0088\u0001\u0002\u0092\u0001\u00020\u0003¨\u0006\u000f"}, d2 = {"Landroidx/compose/ui/text/style/TextAlign;", "", "value", "", "constructor-impl", "(I)I", "toString", "", "toString-impl", "(I)Ljava/lang/String;", "equals", "", "other", "hashCode", "Companion", "ui-text"}, k = 1, mv = {2, 0, 0}, xi = 48)
@JvmInline
public final class TextAlign {
    private static final int Center = 0;
    public static final Companion Companion = null;
    private static final int End = 0;
    private static final int Justify = 0;
    private static final int Left = 0;
    private static final int Right = 0;
    private static final int Start = 0;
    private static final int Unspecified = 0;
    private final int value;

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010 \n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00050\u0014R\u0013\u0010\u0004\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007R\u0013\u0010\t\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\n\u0010\u0007R\u0013\u0010\u000b\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\f\u0010\u0007R\u0013\u0010\r\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u000e\u0010\u0007R\u0013\u0010\u000f\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0010\u0010\u0007R\u0013\u0010\u0011\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0012\u0010\u0007R\u0013\u0010\u0015\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0016\u0010\u0007¨\u0006\u0017"}, d2 = {"Landroidx/compose/ui/text/style/TextAlign$Companion;", "", "<init>", "()V", "Left", "Landroidx/compose/ui/text/style/TextAlign;", "getLeft-e0LSkKk", "()I", "I", "Right", "getRight-e0LSkKk", "Center", "getCenter-e0LSkKk", "Justify", "getJustify-e0LSkKk", "Start", "getStart-e0LSkKk", "End", "getEnd-e0LSkKk", "values", "", "Unspecified", "getUnspecified-e0LSkKk", "ui-text"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        public final List<TextAlign> values() {
            return CollectionsKt.listOf(new TextAlign[]{TextAlign.m7411boximpl(m7421getLefte0LSkKk()), TextAlign.m7411boximpl(m7422getRighte0LSkKk()), TextAlign.m7411boximpl(m7418getCentere0LSkKk()), TextAlign.m7411boximpl(m7420getJustifye0LSkKk()), TextAlign.m7411boximpl(m7423getStarte0LSkKk()), TextAlign.m7411boximpl(m7419getEnde0LSkKk())});
        }

        /* JADX INFO: renamed from: getCenter-e0LSkKk, reason: not valid java name */
        public final int m7418getCentere0LSkKk() {
            return TextAlign.access$getCenter$cp();
        }

        /* JADX INFO: renamed from: getEnd-e0LSkKk, reason: not valid java name */
        public final int m7419getEnde0LSkKk() {
            return TextAlign.access$getEnd$cp();
        }

        /* JADX INFO: renamed from: getJustify-e0LSkKk, reason: not valid java name */
        public final int m7420getJustifye0LSkKk() {
            return TextAlign.access$getJustify$cp();
        }

        /* JADX INFO: renamed from: getLeft-e0LSkKk, reason: not valid java name */
        public final int m7421getLefte0LSkKk() {
            return TextAlign.access$getLeft$cp();
        }

        /* JADX INFO: renamed from: getRight-e0LSkKk, reason: not valid java name */
        public final int m7422getRighte0LSkKk() {
            return TextAlign.access$getRight$cp();
        }

        /* JADX INFO: renamed from: getStart-e0LSkKk, reason: not valid java name */
        public final int m7423getStarte0LSkKk() {
            return TextAlign.access$getStart$cp();
        }

        /* JADX INFO: renamed from: getUnspecified-e0LSkKk, reason: not valid java name */
        public final int m7424getUnspecifiede0LSkKk() {
            return TextAlign.access$getUnspecified$cp();
        }
    }

    /* JADX INFO: renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ TextAlign m7411boximpl(int r100) {
        return new TextAlign(r100);
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static int m7412constructorimpl(int r100) {
        return r100;
    }

    /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
    public static boolean m7413equalsimpl(int r100, Object r101) {
        if ((r101 instanceof TextAlign) == true) goto L6;
        return false;
    L6:
        if (r100 == ((TextAlign) r101).m7417unboximpl()) goto L8;
        return false;
    L8:
        return true;
    }

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m7414equalsimpl0(int r100, int r101) {
        if (r100 != r101) goto L4;
        return true;
    L4:
        return false;
    }

    /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
    public static int m7415hashCodeimpl(int r100) {
        return r100;
    }

    public boolean equals(Object r100) {
        return m7413equalsimpl(this.value, r100);
    }

    public int hashCode() {
        return m7415hashCodeimpl(this.value);
    }

    /* JADX INFO: renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ int m7417unboximpl() {
        return this.value;
    }

    static {
        Companion = new Companion(null);
        Left = m7412constructorimpl(1);
        Right = m7412constructorimpl(2);
        Center = m7412constructorimpl(3);
        Justify = m7412constructorimpl(4);
        Start = m7412constructorimpl(5);
        End = m7412constructorimpl(6);
        Unspecified = m7412constructorimpl(Integer.MIN_VALUE);
    }

    public String toString() {
        return m7416toStringimpl(this.value);
    }

    public static final /* synthetic */ int access$getCenter$cp() {
        return Center;
    }

    public static final /* synthetic */ int access$getEnd$cp() {
        return End;
    }

    public static final /* synthetic */ int access$getJustify$cp() {
        return Justify;
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

    public static final /* synthetic */ int access$getUnspecified$cp() {
        return Unspecified;
    }

    private /* synthetic */ TextAlign(int r100) {
        this.value = r100;
    }

    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m7416toStringimpl(int r100) {
        if (m7414equalsimpl0(r100, Left) == false) goto L6;
        return "Left";
    L6:
        if (m7414equalsimpl0(r100, Right) == false) goto L9;
        return "Right";
    L9:
        if (m7414equalsimpl0(r100, Center) == false) goto L12;
        return "Center";
    L12:
        if (m7414equalsimpl0(r100, Justify) == false) goto L15;
        return "Justify";
    L15:
        if (m7414equalsimpl0(r100, Start) == false) goto L18;
        return "Start";
    L18:
        if (m7414equalsimpl0(r100, End) == false) goto L21;
        return "End";
    L21:
        if (m7414equalsimpl0(r100, Unspecified) == false) goto L23;
        return "Unspecified";
    L23:
        return "Invalid";
    }
}
