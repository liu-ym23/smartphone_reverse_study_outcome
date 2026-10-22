package androidx.compose.ui.text.style;

import androidx.compose.runtime.Immutable;
import androidx.compose.runtime.Stable;
import androidx.compose.ui.unit.TextUnit;
import androidx.compose.ui.unit.TextUnitKt;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import kotlin.Metadata;
import kotlin.jvm.internal.e;

@Immutable
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\b\u0007\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B\u001b\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J!\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u001a\u0010\f\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\u0001H\u0096\u0002¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0012\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0014\u001a\u0004\b\u0017\u0010\u0016¨\u0006\u0019"}, d2 = {"Landroidx/compose/ui/text/style/TextIndent;", "", "Landroidx/compose/ui/unit/TextUnit;", "firstLine", "restLine", AppAgent.CONSTRUCT, "(JJLkotlin/jvm/internal/e;)V", "copy-NB67dxo", "(JJ)Landroidx/compose/ui/text/style/TextIndent;", "copy", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "J", "getFirstLine-XSAIIZE", "()J", "getRestLine-XSAIIZE", "Companion", "ui-text"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class TextIndent {
    public static final int $stable = 0;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final TextIndent None = new TextIndent(0, 0, 3, null);
    private final long firstLine;
    private final long restLine;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001c\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0006\u0010\u0003\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Landroidx/compose/ui/text/style/TextIndent$Companion;", "", AppAgent.CONSTRUCT, "()V", "None", "Landroidx/compose/ui/text/style/TextIndent;", "getNone$annotations", "getNone", "()Landroidx/compose/ui/text/style/TextIndent;", "ui-text"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(e eVar) {
            this();
        }

        @Stable
        public static /* synthetic */ void getNone$annotations() {
        }

        public final TextIndent getNone() {
            return TextIndent.None;
        }

        private Companion() {
        }
    }

    public /* synthetic */ TextIndent(long j5, long j6, e eVar) {
        this(j5, j6);
    }

    /* renamed from: copy-NB67dxo$default, reason: not valid java name */
    public static /* synthetic */ TextIndent m6750copyNB67dxo$default(TextIndent textIndent, long j5, long j6, int i, Object obj) {
        if ((i & 1) != 0) {
            j5 = textIndent.firstLine;
        }
        if ((i & 2) != 0) {
            j6 = textIndent.restLine;
        }
        return textIndent.m6751copyNB67dxo(j5, j6);
    }

    /* renamed from: copy-NB67dxo, reason: not valid java name */
    public final TextIndent m6751copyNB67dxo(long firstLine, long restLine) {
        return new TextIndent(firstLine, restLine, null);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TextIndent)) {
            return false;
        }
        TextIndent textIndent = (TextIndent) other;
        return TextUnit.m7035equalsimpl0(this.firstLine, textIndent.firstLine) && TextUnit.m7035equalsimpl0(this.restLine, textIndent.restLine);
    }

    /* renamed from: getFirstLine-XSAIIZE, reason: not valid java name and from getter */
    public final long getFirstLine() {
        return this.firstLine;
    }

    /* renamed from: getRestLine-XSAIIZE, reason: not valid java name and from getter */
    public final long getRestLine() {
        return this.restLine;
    }

    public int hashCode() {
        return TextUnit.m7039hashCodeimpl(this.restLine) + (TextUnit.m7039hashCodeimpl(this.firstLine) * 31);
    }

    public String toString() {
        return "TextIndent(firstLine=" + ((Object) TextUnit.m7045toStringimpl(this.firstLine)) + ", restLine=" + ((Object) TextUnit.m7045toStringimpl(this.restLine)) + ')';
    }

    private TextIndent(long j5, long j6) {
        this.firstLine = j5;
        this.restLine = j6;
    }

    public /* synthetic */ TextIndent(long j5, long j6, int i, e eVar) {
        this((i & 1) != 0 ? TextUnitKt.getSp(0) : j5, (i & 2) != 0 ? TextUnitKt.getSp(0) : j6, null);
    }
}
