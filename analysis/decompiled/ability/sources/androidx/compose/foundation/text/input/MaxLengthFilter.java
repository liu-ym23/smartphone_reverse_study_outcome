package androidx.compose.foundation.text.input;

import B7.a;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0082\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u0002HÂ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0013\u0010\n\u001a\u00020\t*\u00020\bH\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u0013\u0010\r\u001a\u00020\t*\u00020\fH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0014\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0014\u0010\u0007J\u001a\u0010\u0018\u001a\u00020\u00172\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015HÖ\u0003¢\u0006\u0004\b\u0018\u0010\u0019R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u001a¨\u0006\u001b"}, d2 = {"Landroidx/compose/foundation/text/input/MaxLengthFilter;", "Landroidx/compose/foundation/text/input/InputTransformation;", "", "maxLength", AppAgent.CONSTRUCT, "(I)V", "component1", "()I", "Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;", "LC7/r;", "applySemantics", "(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)V", "Landroidx/compose/foundation/text/input/TextFieldBuffer;", "transformInput", "(Landroidx/compose/foundation/text/input/TextFieldBuffer;)V", "", "toString", "()Ljava/lang/String;", "copy", "(I)Landroidx/compose/foundation/text/input/MaxLengthFilter;", "hashCode", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "I", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
final /* data */ class MaxLengthFilter implements InputTransformation {
    private final int maxLength;

    public MaxLengthFilter(int i) {
        this.maxLength = i;
        if (i < 0) {
            throw new IllegalArgumentException(a.h(i, "maxLength must be at least zero, was ").toString());
        }
    }

    /* renamed from: component1, reason: from getter */
    private final int getMaxLength() {
        return this.maxLength;
    }

    public static /* synthetic */ MaxLengthFilter copy$default(MaxLengthFilter maxLengthFilter, int i, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            i = maxLengthFilter.maxLength;
        }
        return maxLengthFilter.copy(i);
    }

    @Override // androidx.compose.foundation.text.input.InputTransformation
    public void applySemantics(SemanticsPropertyReceiver semanticsPropertyReceiver) {
        SemanticsPropertiesKt.setMaxTextLength(semanticsPropertyReceiver, this.maxLength);
    }

    public final MaxLengthFilter copy(int maxLength) {
        return new MaxLengthFilter(maxLength);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof MaxLengthFilter) && this.maxLength == ((MaxLengthFilter) other).maxLength;
    }

    public int hashCode() {
        return Integer.hashCode(this.maxLength);
    }

    public String toString() {
        return a.o(new StringBuilder("InputTransformation.maxLength("), this.maxLength, ')');
    }

    @Override // androidx.compose.foundation.text.input.InputTransformation
    public void transformInput(TextFieldBuffer textFieldBuffer) {
        if (textFieldBuffer.getLength() > this.maxLength) {
            textFieldBuffer.revertAllChanges();
        }
    }
}
