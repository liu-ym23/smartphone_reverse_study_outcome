package androidx.compose.foundation.text;

import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.input.OffsetMapping;
import androidx.compose.ui.text.input.TransformedText;
import androidx.compose.ui.text.input.VisualTransformation;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\u001b\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0000¢\u0006\u0004\b\u0004\u0010\u0005\u001a%\u0010\n\u001a\u00020\t*\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u0006H\u0001¢\u0006\u0004\b\n\u0010\u000b\u001a'\u0010\u000e\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u000e\u0010\u000f\u001a'\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0012\u0010\u000f\"\u001a\u0010\u0014\u001a\u00020\u00138\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u0018"}, d2 = {"Landroidx/compose/ui/text/input/VisualTransformation;", "Landroidx/compose/ui/text/AnnotatedString;", "text", "Landroidx/compose/ui/text/input/TransformedText;", "filterWithValidation", "(Landroidx/compose/ui/text/input/VisualTransformation;Landroidx/compose/ui/text/AnnotatedString;)Landroidx/compose/ui/text/input/TransformedText;", "", "originalLength", "limit", "LC7/r;", "throwIfNotValidTransform", "(Landroidx/compose/ui/text/input/TransformedText;II)V", "originalOffset", TypedValues.CycleType.S_WAVE_OFFSET, "validateTransformedToOriginal", "(III)V", "transformedOffset", "transformedLength", "validateOriginalToTransformed", "Landroidx/compose/ui/text/input/OffsetMapping;", "ValidatingEmptyOffsetMappingIdentity", "Landroidx/compose/ui/text/input/OffsetMapping;", "getValidatingEmptyOffsetMappingIdentity", "()Landroidx/compose/ui/text/input/OffsetMapping;", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class ValidatingOffsetMappingKt {
    private static final OffsetMapping ValidatingEmptyOffsetMappingIdentity = new ValidatingOffsetMapping(OffsetMapping.INSTANCE.getIdentity(), 0, 0);

    public static final TransformedText filterWithValidation(VisualTransformation visualTransformation, AnnotatedString annotatedString) {
        TransformedText transformedTextFilter = visualTransformation.filter(annotatedString);
        throwIfNotValidTransform$default(transformedTextFilter, annotatedString.length(), 0, 2, null);
        return new TransformedText(transformedTextFilter.getText(), new ValidatingOffsetMapping(transformedTextFilter.getOffsetMapping(), annotatedString.length(), transformedTextFilter.getText().length()));
    }

    public static final OffsetMapping getValidatingEmptyOffsetMappingIdentity() {
        return ValidatingEmptyOffsetMappingIdentity;
    }

    public static final void throwIfNotValidTransform(TransformedText transformedText, int i, int i6) {
        int length = transformedText.getText().length();
        int iMin = Math.min(i, i6);
        for (int i10 = 0; i10 < iMin; i10++) {
            validateOriginalToTransformed(transformedText.getOffsetMapping().originalToTransformed(i10), length, i10);
        }
        validateOriginalToTransformed(transformedText.getOffsetMapping().originalToTransformed(i), length, i);
        int iMin2 = Math.min(length, i6);
        for (int i11 = 0; i11 < iMin2; i11++) {
            validateTransformedToOriginal(transformedText.getOffsetMapping().transformedToOriginal(i11), i, i11);
        }
        validateTransformedToOriginal(transformedText.getOffsetMapping().transformedToOriginal(length), i, length);
    }

    public static /* synthetic */ void throwIfNotValidTransform$default(TransformedText transformedText, int i, int i6, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            i6 = 100;
        }
        throwIfNotValidTransform(transformedText, i, i6);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void validateOriginalToTransformed(int i, int i6, int i10) {
        if (i < 0 || i > i6) {
            throw new IllegalStateException(B7.a.o(androidx.appfunctions.metadata.a.s(i10, "OffsetMapping.originalToTransformed returned invalid mapping: ", i, " -> ", " is not in range of transformed text [0, "), i6, ']').toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void validateTransformedToOriginal(int i, int i6, int i10) {
        if (i < 0 || i > i6) {
            throw new IllegalStateException(B7.a.o(androidx.appfunctions.metadata.a.s(i10, "OffsetMapping.transformedToOriginal returned invalid mapping: ", i, " -> ", " is not in range of original text [0, "), i6, ']').toString());
        }
    }
}
