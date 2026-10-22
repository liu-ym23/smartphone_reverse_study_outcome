package androidx.compose.foundation.text.input;

import androidx.compose.foundation.internal.InlineClassHelperKt;
import androidx.compose.foundation.text.KeyboardOptions;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0082\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\f\u0010\u0006\u001a\u00020\u0007*\u00020\bH\u0016J\f\u0010\t\u001a\u00020\u0007*\u00020\nH\u0016J\b\u0010\u000b\u001a\u00020\fH\u0016J\t\u0010\r\u001a\u00020\u0003HÂ\u0003J\u0013\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Landroidx/compose/foundation/text/input/MaxLengthFilter;", "Landroidx/compose/foundation/text/input/InputTransformation;", "maxLength", "", "<init>", "(I)V", "applySemantics", "", "Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;", "transformInput", "Landroidx/compose/foundation/text/input/TextFieldBuffer;", "toString", "", "component1", "copy", "equals", "", "other", "", "hashCode", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
final class MaxLengthFilter implements InputTransformation {
    private final int maxLength;

    private final int component1() {
        return this.maxLength;
    }

    public static /* synthetic */ MaxLengthFilter copy$default(MaxLengthFilter r100, int r101, int r102, Object r103) {
        if ((r102 & 1) == 0) goto L6;
        r101 = r100.maxLength;
    L6:
        return r100.copy(r101);
    }

    public final MaxLengthFilter copy(int r100) {
        return new MaxLengthFilter(r100);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof MaxLengthFilter) == true) goto L9;
        return false;
    L9:
        if (this.maxLength == ((MaxLengthFilter) r100).maxLength) goto L11;
        return false;
    L11:
        return true;
    }

    @Override // androidx.compose.foundation.text.input.InputTransformation
    public final /* synthetic */ KeyboardOptions getKeyboardOptions() {
        return InputTransformation.CC.$default$getKeyboardOptions(this);
    }

    public int hashCode() {
        return this.maxLength;
    }

    public String toString() {
        return "InputTransformation.maxLength(" + this.maxLength + ')';
    }

    public MaxLengthFilter(int r100) {
        this.maxLength = r100;
        if (r100 < 0) goto L5;
        boolean r101 = true;
    L6:
        if (r101 == true) goto L9;
        InlineClassHelperKt.throwIllegalArgumentException("maxLength must be at least zero");
        return;
    L9:
        return;
    L5:
        r101 = false;
        goto L6
    }

    @Override // androidx.compose.foundation.text.input.InputTransformation
    public void applySemantics(SemanticsPropertyReceiver r100) {
        SemanticsPropertiesKt.setMaxTextLength(r100, this.maxLength);
    }

    @Override // androidx.compose.foundation.text.input.InputTransformation
    public void transformInput(TextFieldBuffer r100) {
        if (r100.getLength() <= this.maxLength) goto L6;
        r100.revertAllChanges();
        return;
    }
}
