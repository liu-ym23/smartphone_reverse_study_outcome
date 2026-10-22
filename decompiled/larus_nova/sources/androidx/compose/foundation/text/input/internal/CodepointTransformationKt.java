package androidx.compose.foundation.text.input.internal;

import androidx.compose.foundation.text.StringHelpers_jvmKt;
import androidx.compose.foundation.text.input.TextFieldCharSequence;
import com.bytedance.android.shopping.buynow.data.model.BuyNowCloseMethod;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000$\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\f\n\u0000\n\u0002\u0010\r\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0001\u001a\u001c\u0010\u0005\u001a\u00020\u0006*\u00020\u00072\u0006\u0010\b\u001a\u00020\u00012\u0006\u0010\t\u001a\u00020\nH\u0000¨\u0006\u000b"}, d2 = {BuyNowCloseMethod.MASK, "Landroidx/compose/foundation/text/input/internal/CodepointTransformation;", "Landroidx/compose/foundation/text/input/internal/CodepointTransformation$Companion;", "character", "", "toVisualText", "", "Landroidx/compose/foundation/text/input/TextFieldCharSequence;", "codepointTransformation", "offsetMappingCalculator", "Landroidx/compose/foundation/text/input/internal/OffsetMappingCalculator;", "foundation_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class CodepointTransformationKt {
    public static final CodepointTransformation mask(CodepointTransformation.Companion r100, char r101) {
        return new MaskCodepointTransformation(r101);
    }

    public static final CharSequence toVisualText(TextFieldCharSequence r100, CodepointTransformation r101, OffsetMappingCalculator r110) {
        StringBuilder r102 = new StringBuilder();
        int r103 = 0;
        boolean r104 = false;
        int r105 = 0;
    L4:
        if (r103 >= r100.length()) goto L9;
        int r106 = CodepointHelpers_jvmKt.codePointAt(r100, r103);
        int r107 = r101.transform(r105, r106);
        int r108 = CodepointHelpers_jvmKt.charCount(r106);
        if (r107 == r106) goto L8;
        int r109 = CodepointHelpers_jvmKt.charCount(r107);
        r110.recordEditOperation(r102.length(), r102.length() + r108, r109);
        r104 = true;
    L8:
        StringHelpers_jvmKt.appendCodePointX(r102, r107);
        r103 = r103 + r108;
        r105 = r105 + 1;
        goto L4
    L9:
        String r111 = r102.toString();
        if (r104 == true) goto L12;
        return r100;
    L12:
        return r111;
    }
}
