package androidx.compose.foundation.text;

import androidx.compose.ui.text.input.OffsetMapping;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\b\u0002\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0004H\u0016J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0004H\u0016R\u000e\u0010\u0002\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Landroidx/compose/foundation/text/ValidatingOffsetMapping;", "Landroidx/compose/ui/text/input/OffsetMapping;", "delegate", "originalLength", "", "transformedLength", "<init>", "(Landroidx/compose/ui/text/input/OffsetMapping;II)V", "originalToTransformed", "offset", "transformedToOriginal", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
final class ValidatingOffsetMapping implements OffsetMapping {
    private final OffsetMapping delegate;
    private final int originalLength;
    private final int transformedLength;

    @Override // androidx.compose.ui.text.input.OffsetMapping
    public int originalToTransformed(int r100) {
        int r101 = this.delegate.originalToTransformed(r100);
        boolean r102 = false;
        if (r100 >= 0) goto L5;
    L7:
        if (r102 == false) goto L9;
        ValidatingOffsetMappingKt.access$validateOriginalToTransformed(r101, this.transformedLength, r100);
    L9:
        return r101;
    L5:
        if (r100 > this.originalLength) goto L7;
        r102 = true;
        goto L7
    }

    @Override // androidx.compose.ui.text.input.OffsetMapping
    public int transformedToOriginal(int r100) {
        int r101 = this.delegate.transformedToOriginal(r100);
        boolean r102 = false;
        if (r100 >= 0) goto L5;
    L7:
        if (r102 == false) goto L9;
        ValidatingOffsetMappingKt.access$validateTransformedToOriginal(r101, this.originalLength, r100);
    L9:
        return r101;
    L5:
        if (r100 > this.transformedLength) goto L7;
        r102 = true;
        goto L7
    }

    public ValidatingOffsetMapping(OffsetMapping r100, int r101, int r102) {
        this.delegate = r100;
        this.originalLength = r101;
        this.transformedLength = r102;
    }
}
