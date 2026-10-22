package androidx.compose.ui.semantics;

import androidx.collection.MutableObjectList;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u000e\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0001H\u0000\u001a\u000e\u0010\u0002\u001a\u0004\u0018\u00010\u0001*\u00020\u0001H\u0000\u001a\u000e\u0010\u0003\u001a\u0004\u0018\u00010\u0004*\u00020\u0001H\u0000¨\u0006\u0005"}, d2 = {"nearestParentThatHasSemantics", "Landroidx/compose/ui/semantics/SemanticsInfo;", "findMergingSemanticsParent", "mergedSemanticsConfiguration", "Landroidx/compose/ui/semantics/SemanticsConfiguration;", "ui_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class SemanticsInfoKt {
    public static final SemanticsInfo findMergingSemanticsParent(SemanticsInfo r100) {
        SemanticsInfo r101 = r100.getParentInfo();
    L3:
        if (r101 == null) goto L12;
        SemanticsConfiguration r102 = r101.getSemanticsConfiguration();
        boolean r103 = false;
        if (r102 != null) goto L7;
    L9:
        if (r103 == true) goto L10;
        r101 = r101.getParentInfo();
        goto L3
    L10:
        return r101;
    L7:
        if (r102.isMergingSemanticsOfDescendants() != true) goto L9;
        r103 = true;
        goto L9
    L12:
        return null;
    }

    public static final SemanticsConfiguration mergedSemanticsConfiguration(SemanticsInfo r100) {
        SemanticsConfiguration r101 = r100.getSemanticsConfiguration();
        if (r101 != null) goto L5;
    L20:
        return r101;
    L5:
        if (r101.isMergingSemanticsOfDescendants() == false) goto L20;
        if (r101.isClearingSemantics() == true) goto L20;
        r101 = r101.copy();
        MutableObjectList r102 = new MutableObjectList(r100.getChildrenInfo().size());
        r102.addAll(r100.getChildrenInfo());
    L11:
        if (r102.isNotEmpty() == false) goto L20;
        SemanticsInfo r103 = (SemanticsInfo) r102.removeAt(r102._size - 1);
        SemanticsConfiguration r104 = r103.getSemanticsConfiguration();
        if (r104 == null) goto L11;
        if (r104.isMergingSemanticsOfDescendants() == true) goto L11;
        r101.mergeChild$ui_release(r104);
        if (r104.isClearingSemantics() == true) goto L11;
        r102.addAll(r103.getChildrenInfo());
        goto L11
    }

    public static final SemanticsInfo nearestParentThatHasSemantics(SemanticsInfo r100) {
        SemanticsInfo r101 = r100.getParentInfo();
    L3:
        if (r101 == null) goto L8;
        if (r101.getSemanticsConfiguration() != null) goto L6;
        r101 = r101.getParentInfo();
        goto L3
    L6:
        return r101;
    L8:
        return null;
    }
}
