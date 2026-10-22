package androidx.compose.ui.semantics;

import D7.z;
import H4.o;
import N9.j;
import S7.a;
import S7.k;
import S7.n;
import androidx.collection.IntObjectMap;
import androidx.collection.IntObjectMapKt;
import androidx.collection.MutableIntObjectMap;
import androidx.compose.foundation.text.selection.b;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.unit.LayoutDirection;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;

@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\u001aO\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00000\u0005*\u00020\u00002\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u00012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u00012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00000\u0005H\u0000¢\u0006\u0004\b\u0007\u0010\b\u001ag\u0010\u000f\u001a\u00020\u000e*\u00020\u00002\u0016\u0010\u000b\u001a\u0012\u0012\u0004\u0012\u00020\u00000\tj\b\u0012\u0004\u0012\u00020\u0000`\n2\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u00012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u00012\u0012\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00000\u00050\fH\u0002¢\u0006\u0004\b\u000f\u0010\u0010\u001aS\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00000\u0005*\u00020\u00002\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00000\u00052\u0014\b\u0002\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u00012\u0014\b\u0002\u0010\u0013\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00000\u00050\u0012H\u0000¢\u0006\u0004\b\u0014\u0010\u0015\u001aS\u0010\u001b\u001a\u00020\u00022:\u0010\u0019\u001a6\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0017\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00000\u00180\u00160\tj\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0017\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00000\u00180\u0016`\n2\u0006\u0010\u001a\u001a\u00020\u0000H\u0002¢\u0006\u0004\b\u001b\u0010\u001c\"*\u0010 \u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00000\u001ej\b\u0012\u0004\u0012\u00020\u0000`\u001f0\u001d8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b \u0010!\"&\u0010$\u001a\u0014\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020#0\"8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b$\u0010%¨\u0006&"}, d2 = {"Landroidx/compose/ui/semantics/SemanticsNode;", "Lkotlin/Function1;", "", "isVisible", "isFocusableContainer", "", "listToSort", "subtreeSortedByGeometryGrouping", "(Landroidx/compose/ui/semantics/SemanticsNode;LS7/k;LS7/k;Ljava/util/List;)Ljava/util/List;", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "geometryList", "Landroidx/collection/MutableIntObjectMap;", "containerMapToChildren", "LC7/r;", "geometryDepthFirstSearch", "(Landroidx/compose/ui/semantics/SemanticsNode;Ljava/util/ArrayList;LS7/k;LS7/k;Landroidx/collection/MutableIntObjectMap;)V", "parentListToSort", "Landroidx/collection/IntObjectMap;", "containerChildrenMapping", "sortByGeometryGroupings", "(Landroidx/compose/ui/semantics/SemanticsNode;Ljava/util/List;LS7/k;Landroidx/collection/IntObjectMap;)Ljava/util/List;", "Lkotlin/Pair;", "Landroidx/compose/ui/geometry/Rect;", "", "rowGroupings", "node", "placedEntryRowOverlaps", "(Ljava/util/ArrayList;Landroidx/compose/ui/semantics/SemanticsNode;)Z", "", "Ljava/util/Comparator;", "Lkotlin/Comparator;", "semanticComparators", "[Ljava/util/Comparator;", "Lkotlin/Function2;", "", "UnmergedConfigComparator", "LS7/n;", "ui_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class SemanticsSortKt {
    private static final n UnmergedConfigComparator;
    private static final Comparator<SemanticsNode>[] semanticComparators;

    static {
        Comparator<SemanticsNode>[] comparatorArr = new Comparator[2];
        int i = 0;
        while (i < 2) {
            final Comparator comparator = i == 0 ? RtlBoundsComparator.INSTANCE : LtrBoundsComparator.INSTANCE;
            final Comparator<LayoutNode> zComparator$ui_release = LayoutNode.INSTANCE.getZComparator$ui_release();
            final Comparator comparator2 = new Comparator() { // from class: androidx.compose.ui.semantics.SemanticsSortKt$special$$inlined$thenBy$1
                /* JADX WARN: Multi-variable type inference failed */
                @Override // java.util.Comparator
                public final int compare(T t9, T t10) {
                    int iCompare = comparator.compare(t9, t10);
                    return iCompare != 0 ? iCompare : zComparator$ui_release.compare(((SemanticsNode) t9).getLayoutNode(), ((SemanticsNode) t10).getLayoutNode());
                }
            };
            comparatorArr[i] = new Comparator() { // from class: androidx.compose.ui.semantics.SemanticsSortKt$special$$inlined$thenBy$2
                /* JADX WARN: Multi-variable type inference failed */
                @Override // java.util.Comparator
                public final int compare(T t9, T t10) {
                    int iCompare = comparator2.compare(t9, t10);
                    return iCompare != 0 ? iCompare : j.m(Integer.valueOf(((SemanticsNode) t9).getId()), Integer.valueOf(((SemanticsNode) t10).getId()));
                }
            };
            i++;
        }
        semanticComparators = comparatorArr;
        UnmergedConfigComparator = new n() { // from class: androidx.compose.ui.semantics.SemanticsSortKt$UnmergedConfigComparator$1
            @Override // S7.n
            public final Integer invoke(SemanticsNode semanticsNode, SemanticsNode semanticsNode2) {
                SemanticsConfiguration unmergedConfig = semanticsNode.getUnmergedConfig();
                SemanticsProperties semanticsProperties = SemanticsProperties.INSTANCE;
                return Integer.valueOf(Float.compare(((Number) unmergedConfig.getOrElse(semanticsProperties.getTraversalIndex(), new a() { // from class: androidx.compose.ui.semantics.SemanticsSortKt$UnmergedConfigComparator$1.1
                    @Override // S7.a
                    public final Float invoke() {
                        return Float.valueOf(0.0f);
                    }
                })).floatValue(), ((Number) semanticsNode2.getUnmergedConfig().getOrElse(semanticsProperties.getTraversalIndex(), new a() { // from class: androidx.compose.ui.semantics.SemanticsSortKt$UnmergedConfigComparator$1.2
                    @Override // S7.a
                    public final Float invoke() {
                        return Float.valueOf(0.0f);
                    }
                })).floatValue()));
            }
        };
    }

    private static final void geometryDepthFirstSearch(SemanticsNode semanticsNode, ArrayList<SemanticsNode> arrayList, k kVar, k kVar2, MutableIntObjectMap<List<SemanticsNode>> mutableIntObjectMap) {
        boolean zBooleanValue = ((Boolean) semanticsNode.getUnmergedConfig().getOrElse(SemanticsProperties.INSTANCE.getIsTraversalGroup(), new a() { // from class: androidx.compose.ui.semantics.SemanticsSortKt$geometryDepthFirstSearch$isTraversalGroup$1
            @Override // S7.a
            public final Boolean invoke() {
                return Boolean.FALSE;
            }
        })).booleanValue();
        if ((zBooleanValue || ((Boolean) kVar2.invoke(semanticsNode)).booleanValue()) && ((Boolean) kVar.invoke(semanticsNode)).booleanValue()) {
            arrayList.add(semanticsNode);
        }
        if (zBooleanValue) {
            mutableIntObjectMap.set(semanticsNode.getId(), subtreeSortedByGeometryGrouping(semanticsNode, kVar, kVar2, semanticsNode.getChildren()));
            return;
        }
        List<SemanticsNode> children = semanticsNode.getChildren();
        int size = children.size();
        for (int i = 0; i < size; i++) {
            geometryDepthFirstSearch(children.get(i), arrayList, kVar, kVar2, mutableIntObjectMap);
        }
    }

    private static final boolean placedEntryRowOverlaps(ArrayList<Pair<Rect, List<SemanticsNode>>> arrayList, SemanticsNode semanticsNode) {
        float top = semanticsNode.getBoundsInWindow().getTop();
        float bottom = semanticsNode.getBoundsInWindow().getBottom();
        boolean z10 = top >= bottom;
        int iH = o.H(arrayList);
        if (iH >= 0) {
            int i = 0;
            while (true) {
                Rect rect = (Rect) arrayList.get(i).f4886a;
                boolean z11 = rect.getTop() >= rect.getBottom();
                if (!z10 && !z11 && Math.max(top, rect.getTop()) < Math.min(bottom, rect.getBottom())) {
                    arrayList.set(i, new Pair<>(rect.intersect(0.0f, top, Float.POSITIVE_INFINITY, bottom), arrayList.get(i).b));
                    ((List) arrayList.get(i).b).add(semanticsNode);
                    return true;
                }
                if (i == iH) {
                    break;
                }
                i++;
            }
        }
        return false;
    }

    public static final List<SemanticsNode> sortByGeometryGroupings(SemanticsNode semanticsNode, List<SemanticsNode> list, k kVar, IntObjectMap<List<SemanticsNode>> intObjectMap) {
        int size = 0;
        char c = semanticsNode.getLayoutInfo().getLayoutDirection() == LayoutDirection.Rtl ? (char) 1 : (char) 0;
        ArrayList arrayList = new ArrayList(list.size() / 2);
        int iH = o.H(list);
        if (iH >= 0) {
            int i = 0;
            while (true) {
                SemanticsNode semanticsNode2 = list.get(i);
                if (i == 0 || !placedEntryRowOverlaps(arrayList, semanticsNode2)) {
                    arrayList.add(new Pair(semanticsNode2.getBoundsInWindow(), o.Q(semanticsNode2)));
                }
                if (i == iH) {
                    break;
                }
                i++;
            }
        }
        z.d0(TopBottomBoundsComparator.INSTANCE, arrayList);
        ArrayList arrayList2 = new ArrayList();
        Comparator<SemanticsNode> comparator = semanticComparators[c ^ 1];
        int size2 = arrayList.size();
        for (int i6 = 0; i6 < size2; i6++) {
            Pair pair = (Pair) arrayList.get(i6);
            z.d0(comparator, (List) pair.b);
            arrayList2.addAll((Collection) pair.b);
        }
        z.d0(new b(UnmergedConfigComparator, 1), arrayList2);
        while (size <= o.H(arrayList2)) {
            List<SemanticsNode> list2 = intObjectMap.get(((SemanticsNode) arrayList2.get(size)).getId());
            if (list2 != null) {
                if (((Boolean) kVar.invoke(arrayList2.get(size))).booleanValue()) {
                    size++;
                } else {
                    arrayList2.remove(size);
                }
                arrayList2.addAll(size, list2);
                size += list2.size();
            } else {
                size++;
            }
        }
        return arrayList2;
    }

    public static /* synthetic */ List sortByGeometryGroupings$default(SemanticsNode semanticsNode, List list, k kVar, IntObjectMap intObjectMap, int i, Object obj) {
        if ((i & 2) != 0) {
            kVar = new k() { // from class: androidx.compose.ui.semantics.SemanticsSortKt.sortByGeometryGroupings.1
                @Override // S7.k
                public final Boolean invoke(SemanticsNode semanticsNode2) {
                    return Boolean.FALSE;
                }
            };
        }
        if ((i & 4) != 0) {
            intObjectMap = IntObjectMapKt.intObjectMapOf();
        }
        return sortByGeometryGroupings(semanticsNode, list, kVar, intObjectMap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int sortByGeometryGroupings$lambda$3(n nVar, Object obj, Object obj2) {
        return ((Number) nVar.invoke(obj, obj2)).intValue();
    }

    public static final List<SemanticsNode> subtreeSortedByGeometryGrouping(SemanticsNode semanticsNode, k kVar, k kVar2, List<SemanticsNode> list) {
        MutableIntObjectMap mutableIntObjectMapMutableIntObjectMapOf = IntObjectMapKt.mutableIntObjectMapOf();
        ArrayList arrayList = new ArrayList();
        int size = list.size();
        for (int i = 0; i < size; i++) {
            geometryDepthFirstSearch(list.get(i), arrayList, kVar, kVar2, mutableIntObjectMapMutableIntObjectMapOf);
        }
        return sortByGeometryGroupings(semanticsNode, arrayList, kVar2, mutableIntObjectMapMutableIntObjectMapOf);
    }
}
