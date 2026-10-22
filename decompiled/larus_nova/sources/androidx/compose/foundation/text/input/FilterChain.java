package androidx.compose.foundation.text.input;

import androidx.compose.foundation.text.KeyboardOptions;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import com.bytedance.android.live.soloktv.SoloKtvContext;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0001¢\u0006\u0004\b\u0004\u0010\u0005J\f\u0010\n\u001a\u00020\u000b*\u00020\fH\u0016J\f\u0010\r\u001a\u00020\u000b*\u00020\u000eH\u0016J\b\u0010\u000f\u001a\u00020\u0010H\u0016J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0096\u0002J\b\u0010\u0015\u001a\u00020\u0016H\u0016R\u000e\u0010\u0002\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001a\u0004\u0018\u00010\u00078VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\t¨\u0006\u0017"}, d2 = {"Landroidx/compose/foundation/text/input/FilterChain;", "Landroidx/compose/foundation/text/input/InputTransformation;", SoloKtvContext.SOLO_PAGE_FIRST, "second", "<init>", "(Landroidx/compose/foundation/text/input/InputTransformation;Landroidx/compose/foundation/text/input/InputTransformation;)V", "keyboardOptions", "Landroidx/compose/foundation/text/KeyboardOptions;", "getKeyboardOptions", "()Landroidx/compose/foundation/text/KeyboardOptions;", "applySemantics", "", "Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;", "transformInput", "Landroidx/compose/foundation/text/input/TextFieldBuffer;", "toString", "", "equals", "", "other", "", "hashCode", "", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
final class FilterChain implements InputTransformation {
    private final InputTransformation first;
    private final InputTransformation second;

    @Override // androidx.compose.foundation.text.input.InputTransformation
    public KeyboardOptions getKeyboardOptions() {
        KeyboardOptions r100 = this.second.getKeyboardOptions();
        if (r100 == null) goto L7;
        KeyboardOptions r101 = r100.fillUnspecifiedValuesWith$foundation_release(this.first.getKeyboardOptions());
        if (r101 == null) goto L7;
        return r101;
    L7:
        return this.first.getKeyboardOptions();
    }

    public int hashCode() {
        int r100 = ((this.first.hashCode() * 31) + this.second.hashCode()) * 32;
        KeyboardOptions r101 = getKeyboardOptions();
        if (r101 == null) goto L5;
        int r102 = r101.hashCode();
    L7:
        return r100 + r102;
    L5:
        r102 = 0;
        goto L7
    }

    public String toString() {
        return this.first + ".then(" + this.second + ')';
    }

    @Override // androidx.compose.foundation.text.input.InputTransformation
    public void applySemantics(SemanticsPropertyReceiver r100) {
        this.first.applySemantics(r100);
        this.second.applySemantics(r100);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if (r100 != null) goto L9;
        return false;
    L9:
        if (FilterChain.class == r100.getClass()) goto L11;
        return false;
    L11:
        FilterChain r101 = (FilterChain) r100;
        if (Intrinsics.areEqual(this.first, r101.first) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.second, r101.second) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(getKeyboardOptions(), r101.getKeyboardOptions()) == true) goto L20;
        return false;
    L20:
        return true;
    }

    @Override // androidx.compose.foundation.text.input.InputTransformation
    public void transformInput(TextFieldBuffer r100) {
        this.first.transformInput(r100);
        this.second.transformInput(r100);
    }

    public FilterChain(InputTransformation r100, InputTransformation r101) {
        this.first = r100;
        this.second = r101;
    }
}
