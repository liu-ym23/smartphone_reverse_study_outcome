package androidx.compose.foundation.text.input;

import S7.n;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import kotlin.Metadata;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0082\b\u0018\u00002\u00020\u0001B!\u0012\u0018\u0010\u0004\u001a\u0014\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0013\u0010\t\u001a\u00020\b*\u00020\u0007H\u0016¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\f\u0010\rJ\"\u0010\u000e\u001a\u0014\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0002HÆ\u0003¢\u0006\u0004\b\u000e\u0010\u000fJ,\u0010\u0010\u001a\u00020\u00002\u001a\b\u0002\u0010\u0004\u001a\u0014\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0002HÆ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0013\u001a\u00020\u0012HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u001a\u0010\u0018\u001a\u00020\u00172\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015HÖ\u0003¢\u0006\u0004\b\u0018\u0010\u0019R)\u0010\u0004\u001a\u0014\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u001a\u001a\u0004\b\u001b\u0010\u000f¨\u0006\u001c"}, d2 = {"Landroidx/compose/foundation/text/input/InputTransformationByValue;", "Landroidx/compose/foundation/text/input/InputTransformation;", "Lkotlin/Function2;", "", "transformation", AppAgent.CONSTRUCT, "(LS7/n;)V", "Landroidx/compose/foundation/text/input/TextFieldBuffer;", "LC7/r;", "transformInput", "(Landroidx/compose/foundation/text/input/TextFieldBuffer;)V", "", "toString", "()Ljava/lang/String;", "component1", "()LS7/n;", "copy", "(LS7/n;)Landroidx/compose/foundation/text/input/InputTransformationByValue;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "LS7/n;", "getTransformation", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
final /* data */ class InputTransformationByValue implements InputTransformation {
    private final n transformation;

    public InputTransformationByValue(n nVar) {
        this.transformation = nVar;
    }

    public static /* synthetic */ InputTransformationByValue copy$default(InputTransformationByValue inputTransformationByValue, n nVar, int i, Object obj) {
        if ((i & 1) != 0) {
            nVar = inputTransformationByValue.transformation;
        }
        return inputTransformationByValue.copy(nVar);
    }

    /* renamed from: component1, reason: from getter */
    public final n getTransformation() {
        return this.transformation;
    }

    public final InputTransformationByValue copy(n transformation) {
        return new InputTransformationByValue(transformation);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof InputTransformationByValue) && k.b(this.transformation, ((InputTransformationByValue) other).transformation);
    }

    public final n getTransformation() {
        return this.transformation;
    }

    public int hashCode() {
        return this.transformation.hashCode();
    }

    public String toString() {
        return "InputTransformation.byValue(transformation=" + this.transformation + ')';
    }

    @Override // androidx.compose.foundation.text.input.InputTransformation
    public void transformInput(TextFieldBuffer textFieldBuffer) {
        TextFieldCharSequence textFieldCharSequenceM1134toTextFieldCharSequenceudt6zUU$foundation_release$default = TextFieldBuffer.m1134toTextFieldCharSequenceudt6zUU$foundation_release$default(textFieldBuffer, 0L, null, 3, null);
        CharSequence charSequence = (CharSequence) this.transformation.invoke(textFieldBuffer.getOriginalValue(), textFieldCharSequenceM1134toTextFieldCharSequenceudt6zUU$foundation_release$default);
        if (charSequence == textFieldCharSequenceM1134toTextFieldCharSequenceudt6zUU$foundation_release$default) {
            return;
        }
        if (charSequence == textFieldBuffer.getOriginalValue()) {
            textFieldBuffer.revertAllChanges();
        } else {
            textFieldBuffer.setTextIfChanged$foundation_release(charSequence);
        }
    }
}
