package androidx.compose.ui.semantics;

import androidx.compose.ui.geometry.Rect;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.Comparator;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\bÂ\u0002\u0018\u00002\u0012\u0012\u0004\u0012\u00020\u00020\u0001j\b\u0012\u0004\u0012\u00020\u0002`\u0003B\t\b\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u0002H\u0016¨\u0006\n"}, d2 = {"Landroidx/compose/ui/semantics/LtrBoundsComparator;", "Ljava/util/Comparator;", "Landroidx/compose/ui/semantics/SemanticsNode;", "Lkotlin/Comparator;", "<init>", "()V", "compare", "", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "b", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
final class LtrBoundsComparator implements Comparator<SemanticsNode> {
    public static final LtrBoundsComparator INSTANCE = null;

    static {
        INSTANCE = new LtrBoundsComparator();
    }

    private LtrBoundsComparator() {
    }

    /* JADX INFO: renamed from: compare, reason: avoid collision after fix types in other method */
    public int compare2(SemanticsNode r100, SemanticsNode r101) {
        Rect r102 = r100.getBoundsInWindow();
        Rect r103 = r101.getBoundsInWindow();
        int r104 = Float.compare(r102.getLeft(), r103.getLeft());
        if (r104 == 0) goto L5;
        return r104;
    L5:
        int r105 = Float.compare(r102.getTop(), r103.getTop());
        if (r105 == 0) goto L8;
        return r105;
    L8:
        int r106 = Float.compare(r102.getBottom(), r103.getBottom());
        if (r106 == 0) goto L12;
        return r106;
    L12:
        return Float.compare(r102.getRight(), r103.getRight());
    }

    @Override // java.util.Comparator
    public /* bridge */ /* synthetic */ int compare(SemanticsNode r100, SemanticsNode r101) {
        return compare2(r100, r101);
    }
}
