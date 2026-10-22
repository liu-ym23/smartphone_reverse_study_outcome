package androidx.compose.foundation.text.input;

import androidx.compose.foundation.text.KeyboardOptions;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B?\u00126\u0010\u0002\u001a2\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\t\u0010\nJ\f\u0010\r\u001a\u00020\u000e*\u00020\u000fH\u0016J\b\u0010\u0010\u001a\u00020\u0011H\u0016J9\u0010\u0012\u001a2\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003JC\u0010\u0013\u001a\u00020\u000028\b\u0002\u0010\u0002\u001a2\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001RA\u0010\u0002\u001a2\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u001a"}, d2 = {"Landroidx/compose/foundation/text/input/InputTransformationByValue;", "Landroidx/compose/foundation/text/input/InputTransformation;", "transformation", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "current", "proposed", "<init>", "(Lkotlin/jvm/functions/Function2;)V", "getTransformation", "()Lkotlin/jvm/functions/Function2;", "transformInput", "", "Landroidx/compose/foundation/text/input/TextFieldBuffer;", "toString", "", "component1", "copy", "equals", "", "other", "", "hashCode", "", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
final class InputTransformationByValue implements InputTransformation {
    private final Function2<CharSequence, CharSequence, CharSequence> transformation;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ InputTransformationByValue copy$default(InputTransformationByValue r100, Function2 r101, int r102, Object r103) {
        if ((r102 & 1) == 0) goto L6;
        r101 = r100.transformation;
    L6:
        return r100.copy(r101);
    }

    @Override // androidx.compose.foundation.text.input.InputTransformation
    public final /* synthetic */ void applySemantics(SemanticsPropertyReceiver r100) {
        InputTransformation.CC.$default$applySemantics(this, r100);
    }

    public final Function2<CharSequence, CharSequence, CharSequence> component1() {
        return this.transformation;
    }

    public final InputTransformationByValue copy(Function2<? super CharSequence, ? super CharSequence, ? extends CharSequence> r100) {
        return new InputTransformationByValue(r100);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof InputTransformationByValue) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.transformation, ((InputTransformationByValue) r100).transformation) == true) goto L11;
        return false;
    L11:
        return true;
    }

    @Override // androidx.compose.foundation.text.input.InputTransformation
    public final /* synthetic */ KeyboardOptions getKeyboardOptions() {
        return InputTransformation.CC.$default$getKeyboardOptions(this);
    }

    public int hashCode() {
        return this.transformation.hashCode();
    }

    public String toString() {
        return "InputTransformation.byValue(transformation=" + this.transformation + ')';
    }

    public final Function2<CharSequence, CharSequence, CharSequence> getTransformation() {
        return this.transformation;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public InputTransformationByValue(Function2<? super CharSequence, ? super CharSequence, ? extends CharSequence> r100) {
        this.transformation = r100;
    }

    @Override // androidx.compose.foundation.text.input.InputTransformation
    public void transformInput(TextFieldBuffer r100) {
        TextFieldCharSequence r101 = TextFieldBuffer.m1186toTextFieldCharSequencewFTz33Y$foundation_release$default(r100, 0, null, null, null, 15, null);
        CharSequence r102 = this.transformation.invoke(r100.getOriginalValue$foundation_release(), r101);
        if (r102 != r101) goto L6;
        return;
    L6:
        if (r102 != r100.getOriginalValue$foundation_release()) goto L8;
        r100.revertAllChanges();
        return;
    L8:
        r100.setTextIfChanged$foundation_release(r102);
    }
}
