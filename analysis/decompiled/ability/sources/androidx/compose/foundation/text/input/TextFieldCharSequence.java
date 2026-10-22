package androidx.compose.foundation.text.input;

import androidx.compose.foundation.text.input.internal.ToCharArray_androidKt;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.TextRangeKt;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import j9.t;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.k;

@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\f\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0019\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0013\b\u0000\u0018\u00002\u00020\u0001B?\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0001\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\u0016\b\u0002\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0006¢\u0006\u0004\b\t\u0010\nJ\u0018\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u000bH\u0096\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u001f\u0010\u0012\u001a\u00020\u00012\u0006\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0015\u001a\u00020\u0014H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u0015\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0017\u001a\u00020\u0001¢\u0006\u0004\b\u0019\u0010\u001aJ-\u0010!\u001a\u00020 2\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001d\u001a\u00020\u000b2\u0006\u0010\u001e\u001a\u00020\u000b2\u0006\u0010\u001f\u001a\u00020\u000b¢\u0006\u0004\b!\u0010\"J\r\u0010#\u001a\u00020\u0018¢\u0006\u0004\b#\u0010$J\u001a\u0010&\u001a\u00020\u00182\b\u0010\u0017\u001a\u0004\u0018\u00010%H\u0096\u0002¢\u0006\u0004\b&\u0010'J\u000f\u0010(\u001a\u00020\u000bH\u0016¢\u0006\u0004\b(\u0010)R\u0017\u0010\u0002\u001a\u00020\u00018\u0006¢\u0006\f\n\u0004\b\u0002\u0010*\u001a\u0004\b+\u0010,R\u001d\u0010\u0004\u001a\u00020\u00038\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b\u0004\u0010-\u001a\u0004\b.\u0010/R\u001f\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b\u0005\u00100\u001a\u0004\b1\u00102R%\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00068\u0006¢\u0006\f\n\u0004\b\b\u00103\u001a\u0004\b4\u00105R\u0014\u00107\u001a\u00020\u000b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b6\u0010)\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u00068"}, d2 = {"Landroidx/compose/foundation/text/input/TextFieldCharSequence;", "", "text", "Landroidx/compose/ui/text/TextRange;", "selection", "composition", "Lkotlin/Pair;", "Landroidx/compose/foundation/text/input/TextHighlightType;", "highlight", AppAgent.CONSTRUCT, "(Ljava/lang/CharSequence;JLandroidx/compose/ui/text/TextRange;Lkotlin/Pair;Lkotlin/jvm/internal/e;)V", "", "index", "", "get", "(I)C", "startIndex", "endIndex", "subSequence", "(II)Ljava/lang/CharSequence;", "", "toString", "()Ljava/lang/String;", "other", "", "contentEquals", "(Ljava/lang/CharSequence;)Z", "", "destination", "destinationOffset", "sourceStartIndex", "sourceEndIndex", "LC7/r;", "toCharArray", "([CIII)V", "shouldShowSelection", "()Z", "", "equals", "(Ljava/lang/Object;)Z", "hashCode", "()I", "Ljava/lang/CharSequence;", "getText", "()Ljava/lang/CharSequence;", "J", "getSelection-d9O1mEE", "()J", "Landroidx/compose/ui/text/TextRange;", "getComposition-MzsxiRA", "()Landroidx/compose/ui/text/TextRange;", "Lkotlin/Pair;", "getHighlight", "()Lkotlin/Pair;", "getLength", "length", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class TextFieldCharSequence implements CharSequence {
    public static final int $stable = 8;
    private final TextRange composition;
    private final Pair<TextHighlightType, TextRange> highlight;
    private final long selection;
    private final CharSequence text;

    public /* synthetic */ TextFieldCharSequence(CharSequence charSequence, long j5, TextRange textRange, Pair pair, e eVar) {
        this(charSequence, j5, textRange, pair);
    }

    @Override // java.lang.CharSequence
    public final /* bridge */ char charAt(int i) {
        return get(i);
    }

    public final boolean contentEquals(CharSequence other) {
        return t.V(this.text, other);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other == null || TextFieldCharSequence.class != other.getClass()) {
            return false;
        }
        TextFieldCharSequence textFieldCharSequence = (TextFieldCharSequence) other;
        return TextRange.m6304equalsimpl0(this.selection, textFieldCharSequence.selection) && k.b(this.composition, textFieldCharSequence.composition) && k.b(this.highlight, textFieldCharSequence.highlight) && contentEquals(textFieldCharSequence.text);
    }

    public char get(int index) {
        return this.text.charAt(index);
    }

    /* renamed from: getComposition-MzsxiRA, reason: not valid java name and from getter */
    public final TextRange getComposition() {
        return this.composition;
    }

    public final Pair<TextHighlightType, TextRange> getHighlight() {
        return this.highlight;
    }

    public int getLength() {
        return this.text.length();
    }

    /* renamed from: getSelection-d9O1mEE, reason: not valid java name and from getter */
    public final long getSelection() {
        return this.selection;
    }

    public final CharSequence getText() {
        return this.text;
    }

    public int hashCode() {
        int iM6312hashCodeimpl = (TextRange.m6312hashCodeimpl(this.selection) + (this.text.hashCode() * 31)) * 31;
        TextRange textRange = this.composition;
        int iM6312hashCodeimpl2 = (iM6312hashCodeimpl + (textRange != null ? TextRange.m6312hashCodeimpl(textRange.getPackedValue()) : 0)) * 31;
        Pair<TextHighlightType, TextRange> pair = this.highlight;
        return iM6312hashCodeimpl2 + (pair != null ? pair.hashCode() : 0);
    }

    @Override // java.lang.CharSequence
    public final /* bridge */ int length() {
        return getLength();
    }

    public final boolean shouldShowSelection() {
        return this.highlight == null;
    }

    @Override // java.lang.CharSequence
    public CharSequence subSequence(int startIndex, int endIndex) {
        return this.text.subSequence(startIndex, endIndex);
    }

    public final void toCharArray(char[] destination, int destinationOffset, int sourceStartIndex, int sourceEndIndex) {
        ToCharArray_androidKt.toCharArray(this.text, destination, destinationOffset, sourceStartIndex, sourceEndIndex);
    }

    @Override // java.lang.CharSequence
    public String toString() {
        return this.text.toString();
    }

    private TextFieldCharSequence(CharSequence charSequence, long j5, TextRange textRange, Pair<TextHighlightType, TextRange> pair) {
        this.text = charSequence instanceof TextFieldCharSequence ? ((TextFieldCharSequence) charSequence).text : charSequence;
        this.selection = TextRangeKt.m6317coerceIn8ffj60Q(j5, 0, charSequence.length());
        this.composition = textRange != null ? TextRange.m6299boximpl(TextRangeKt.m6317coerceIn8ffj60Q(textRange.getPackedValue(), 0, charSequence.length())) : null;
        this.highlight = pair != null ? new Pair<>(pair.f4886a, TextRange.m6299boximpl(TextRangeKt.m6317coerceIn8ffj60Q(((TextRange) pair.b).getPackedValue(), 0, charSequence.length()))) : null;
    }

    public /* synthetic */ TextFieldCharSequence(String str, long j5, TextRange textRange, Pair pair, int i, e eVar) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? TextRange.INSTANCE.m6316getZerod9O1mEE() : j5, (i & 4) != 0 ? null : textRange, (i & 8) != 0 ? null : pair, null);
    }
}
