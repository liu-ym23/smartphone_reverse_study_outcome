package androidx.compose.foundation.text;

import androidx.compose.foundation.internal.InlineClassHelperKt;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.input.OffsetMapping;
import androidx.compose.ui.text.input.TransformedText;
import androidx.compose.ui.text.input.VisualTransformation;
import com.android.ttcjpaysdk.thirdparty.verify.view.VerifyPasswordFragment;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000(\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\u001a\u0014\u0010\u0004\u001a\u00020\u0005*\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0000\u001a\u001e\u0010\t\u001a\u00020\n*\u00020\u00052\u0006\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\fH\u0001\u001a \u0010\u000e\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\fH\u0002\u001a \u0010\u0011\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\fH\u0002\"\u0014\u0010\u0000\u001a\u00020\u0001X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0003¨\u0006\u0014"}, d2 = {"ValidatingEmptyOffsetMappingIdentity", "Landroidx/compose/ui/text/input/OffsetMapping;", "getValidatingEmptyOffsetMappingIdentity", "()Landroidx/compose/ui/text/input/OffsetMapping;", "filterWithValidation", "Landroidx/compose/ui/text/input/TransformedText;", "Landroidx/compose/ui/text/input/VisualTransformation;", "text", "Landroidx/compose/ui/text/AnnotatedString;", "throwIfNotValidTransform", "", "originalLength", "", VerifyPasswordFragment.LYNX_OPEN_CREDIT_LIMIT, "validateTransformedToOriginal", "originalOffset", "offset", "validateOriginalToTransformed", "transformedOffset", "transformedLength", "foundation_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class ValidatingOffsetMappingKt {
    private static final OffsetMapping ValidatingEmptyOffsetMappingIdentity = null;

    static {
        ValidatingEmptyOffsetMappingIdentity = new ValidatingOffsetMapping(OffsetMapping.Companion.getIdentity(), 0, 0);
    }

    public static final OffsetMapping getValidatingEmptyOffsetMappingIdentity() {
        return ValidatingEmptyOffsetMappingIdentity;
    }

    public static final TransformedText filterWithValidation(VisualTransformation r100, AnnotatedString r101) {
        TransformedText r102 = r100.filter(r101);
        throwIfNotValidTransform$default(r102, r101.length(), 0, 2, null);
        return new TransformedText(r102.getText(), new ValidatingOffsetMapping(r102.getOffsetMapping(), r101.length(), r102.getText().length()));
    }

    public static final /* synthetic */ void access$validateOriginalToTransformed(int r100, int r101, int r102) {
        validateOriginalToTransformed(r100, r101, r102);
    }

    public static final /* synthetic */ void access$validateTransformedToOriginal(int r100, int r101, int r102) {
        validateTransformedToOriginal(r100, r101, r102);
    }

    public static final void throwIfNotValidTransform(TransformedText r100, int r101, int r102) {
        int r103 = r100.getText().length();
        int r104 = Math.min(r101, r102);
        int r105 = 0;
        int r106 = 0;
    L3:
        if (r106 >= r104) goto L5;
        validateOriginalToTransformed(r100.getOffsetMapping().originalToTransformed(r106), r103, r106);
        r106 = r106 + 1;
        goto L3
    L5:
        validateOriginalToTransformed(r100.getOffsetMapping().originalToTransformed(r101), r103, r101);
        int r107 = Math.min(r103, r102);
    L6:
        if (r105 >= r107) goto L8;
        validateTransformedToOriginal(r100.getOffsetMapping().transformedToOriginal(r105), r101, r105);
        r105 = r105 + 1;
        goto L6
    L8:
        validateTransformedToOriginal(r100.getOffsetMapping().transformedToOriginal(r103), r101, r103);
    }

    private static final void validateOriginalToTransformed(int r100, int r101, int r102) {
        boolean r103 = false;
        if (r100 < 0) goto L6;
        if (r100 > r101) goto L6;
        r103 = true;
    L6:
        if (r103 == true) goto L9;
        InlineClassHelperKt.throwIllegalStateException("OffsetMapping.originalToTransformed returned invalid mapping: " + r102 + " -> " + r100 + " is not in range of transformed text [0, " + r101 + ']');
        return;
    }

    private static final void validateTransformedToOriginal(int r100, int r101, int r102) {
        boolean r103 = false;
        if (r100 < 0) goto L6;
        if (r100 > r101) goto L6;
        r103 = true;
    L6:
        if (r103 == true) goto L9;
        InlineClassHelperKt.throwIllegalStateException("OffsetMapping.transformedToOriginal returned invalid mapping: " + r102 + " -> " + r100 + " is not in range of original text [0, " + r101 + ']');
        return;
    }

    public static /* synthetic */ void throwIfNotValidTransform$default(TransformedText r100, int r101, int r102, int r103, Object r104) {
        if ((r103 & 2) == 0) goto L5;
        r102 = 100;
    L5:
        throwIfNotValidTransform(r100, r101, r102);
    }
}
