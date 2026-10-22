package androidx.compose.foundation.text;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.ParentDataModifier;
import androidx.compose.ui.unit.Density;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\b\u0001\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0016\u0010\b\u001a\u00020\u0000*\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\f"}, d2 = {"Landroidx/compose/foundation/text/TextRangeLayoutModifier;", "Landroidx/compose/ui/layout/ParentDataModifier;", "measurePolicy", "Landroidx/compose/foundation/text/TextRangeScopeMeasurePolicy;", "<init>", "(Landroidx/compose/foundation/text/TextRangeScopeMeasurePolicy;)V", "getMeasurePolicy", "()Landroidx/compose/foundation/text/TextRangeScopeMeasurePolicy;", "modifyParentData", "Landroidx/compose/ui/unit/Density;", "parentData", "", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class TextRangeLayoutModifier implements ParentDataModifier {
    public static final int $stable = 0;
    private final TextRangeScopeMeasurePolicy measurePolicy;

    @Override // androidx.compose.ui.Modifier.Element, androidx.compose.ui.Modifier
    public final /* synthetic */ boolean all(Function1 r100) {
        return Modifier.Element.CC.$default$all(this, r100);
    }

    @Override // androidx.compose.ui.Modifier.Element, androidx.compose.ui.Modifier
    public final /* synthetic */ boolean any(Function1 r100) {
        return Modifier.Element.CC.$default$any(this, r100);
    }

    @Override // androidx.compose.ui.Modifier.Element, androidx.compose.ui.Modifier
    public final /* synthetic */ Object foldIn(Object r100, Function2 r101) {
        return Modifier.Element.CC.$default$foldIn(this, r100, r101);
    }

    @Override // androidx.compose.ui.Modifier.Element, androidx.compose.ui.Modifier
    public final /* synthetic */ Object foldOut(Object r100, Function2 r101) {
        return Modifier.Element.CC.$default$foldOut(this, r100, r101);
    }

    @Override // androidx.compose.ui.layout.ParentDataModifier
    public TextRangeLayoutModifier modifyParentData(Density r100, Object r101) {
        return this;
    }

    @Override // androidx.compose.ui.Modifier
    public final /* synthetic */ Modifier then(Modifier r100) {
        return Modifier.CC.$default$then(this, r100);
    }

    public final TextRangeScopeMeasurePolicy getMeasurePolicy() {
        return this.measurePolicy;
    }

    public TextRangeLayoutModifier(TextRangeScopeMeasurePolicy r100) {
        this.measurePolicy = r100;
    }

    @Override // androidx.compose.ui.layout.ParentDataModifier
    public /* bridge */ /* synthetic */ Object modifyParentData(Density r100, Object r101) {
        return modifyParentData(r100, r101);
    }
}
