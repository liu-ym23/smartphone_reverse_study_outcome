package androidx.compose.ui.text.style;

import androidx.compose.ui.unit.TextUnit;
import androidx.compose.ui.unit.TextUnitKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0007\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u001b\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J!\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\f\u0010\rJ\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\b\u0010\u0013\u001a\u00020\u0014H\u0016R\u0013\u0010\u0002\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0004\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\n\u0010\b¨\u0006\u0016"}, d2 = {"Landroidx/compose/ui/text/style/TextIndent;", "", "firstLine", "Landroidx/compose/ui/unit/TextUnit;", "restLine", "<init>", "(JJLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getFirstLine-XSAIIZE", "()J", "J", "getRestLine-XSAIIZE", "copy", "copy-NB67dxo", "(JJ)Landroidx/compose/ui/text/style/TextIndent;", "equals", "", "other", "hashCode", "", "toString", "", "Companion", "ui-text"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class TextIndent {
    public static final int $stable = 0;
    public static final Companion Companion = null;
    private static final TextIndent None = null;
    private final long firstLine;
    private final long restLine;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001c\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0006\u0010\u0003\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Landroidx/compose/ui/text/style/TextIndent$Companion;", "", "<init>", "()V", "None", "Landroidx/compose/ui/text/style/TextIndent;", "getNone$annotations", "getNone", "()Landroidx/compose/ui/text/style/TextIndent;", "ui-text"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        public static /* synthetic */ void getNone$annotations() {
        }

        public final TextIndent getNone() {
            return TextIndent.access$getNone$cp();
        }
    }

    public /* synthetic */ TextIndent(long r100, long r101, DefaultConstructorMarker r102) {
        this(r100, r101);
    }

    static {
        Companion = new Companion(null);
        None = new TextIndent(0, 0, 3, null);
    }

    public int hashCode() {
        return (TextUnit.m7743hashCodeimpl(this.firstLine) * 31) + TextUnit.m7743hashCodeimpl(this.restLine);
    }

    public String toString() {
        return "TextIndent(firstLine=" + TextUnit.m7749toStringimpl(this.firstLine) + ", restLine=" + TextUnit.m7749toStringimpl(this.restLine) + ')';
    }

    public static final /* synthetic */ TextIndent access$getNone$cp() {
        return None;
    }

    /* JADX INFO: renamed from: getFirstLine-XSAIIZE, reason: not valid java name */
    public final long m7442getFirstLineXSAIIZE() {
        return this.firstLine;
    }

    /* JADX INFO: renamed from: getRestLine-XSAIIZE, reason: not valid java name */
    public final long m7443getRestLineXSAIIZE() {
        return this.restLine;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof TextIndent) == true) goto L8;
        return false;
    L8:
        TextIndent r101 = (TextIndent) r100;
        if (TextUnit.m7739equalsimpl0(this.firstLine, r101.firstLine) == true) goto L12;
        return false;
    L12:
        if (TextUnit.m7739equalsimpl0(this.restLine, r101.restLine) == true) goto L14;
        return false;
    L14:
        return true;
    }

    private TextIndent(long r100, long r101) {
        this.firstLine = r100;
        this.restLine = r101;
    }

    /* JADX INFO: renamed from: copy-NB67dxo, reason: not valid java name */
    public final TextIndent m7441copyNB67dxo(long r100, long r110) {
        return new TextIndent(r100, r110, null);
    }

    public /* synthetic */ TextIndent(long r100, long r110, int r111, DefaultConstructorMarker r112) {
        if ((r111 & 1) == 0) goto L5;
        r100 = TextUnitKt.getSp(0);
    L5:
        long r101 = r100;
        if ((r111 & 2) == 0) goto L8;
        r110 = TextUnitKt.getSp(0);
    L8:
        this(r101, r110, null);
    }

    /* JADX INFO: renamed from: copy-NB67dxo$default, reason: not valid java name */
    public static /* synthetic */ TextIndent m7440copyNB67dxo$default(TextIndent r100, long r101, long r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.firstLine;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.restLine;
    L9:
        return r100.m7441copyNB67dxo(r101, r102);
    }
}
