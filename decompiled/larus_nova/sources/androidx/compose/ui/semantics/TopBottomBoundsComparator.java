package androidx.compose.ui.semantics;

import androidx.compose.ui.geometry.Rect;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.Comparator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\bÂ\u0002\u0018\u000026\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00020\u0001j\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u0002`\u0006B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bJ<\u0010\t\u001a\u00020\n2\u0018\u0010\u000b\u001a\u0014\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00022\u0018\u0010\f\u001a\u0014\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u0002H\u0016¨\u0006\r"}, d2 = {"Landroidx/compose/ui/semantics/TopBottomBoundsComparator;", "Ljava/util/Comparator;", "Lkotlin/Pair;", "Landroidx/compose/ui/geometry/Rect;", "", "Landroidx/compose/ui/semantics/SemanticsNode;", "Lkotlin/Comparator;", "<init>", "()V", "compare", "", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "b", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
final class TopBottomBoundsComparator implements Comparator<Pair<? extends Rect, ? extends List<SemanticsNode>>> {
    public static final TopBottomBoundsComparator INSTANCE = null;

    static {
        INSTANCE = new TopBottomBoundsComparator();
    }

    private TopBottomBoundsComparator() {
    }

    /* JADX INFO: renamed from: compare, reason: avoid collision after fix types in other method */
    public int compare2(Pair<Rect, ? extends List<SemanticsNode>> r100, Pair<Rect, ? extends List<SemanticsNode>> r101) {
        int r102 = Float.compare(r100.getFirst().getTop(), r101.getFirst().getTop());
        if (r102 == 0) goto L6;
        return r102;
    L6:
        return Float.compare(r100.getFirst().getBottom(), r101.getFirst().getBottom());
    }

    @Override // java.util.Comparator
    public /* bridge */ /* synthetic */ int compare(Pair<? extends Rect, ? extends List<SemanticsNode>> r100, Pair<? extends Rect, ? extends List<SemanticsNode>> r101) {
        return compare2(r100, r101);
    }
}
