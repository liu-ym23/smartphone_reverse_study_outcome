package com.uxsense.core.pattern;

import com.uxsense.core.base.parse.KRect;
import com.uxsense.core.base.parse.KViewNode;
import com.uxsense.core.pattern.ViewPattern;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.EmptyList;
import kotlin.jvm.internal.e;

@Metadata(d1 = {"\u0000&\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\u001a.\u0010\u0000\u001a\u0004\u0018\u00010\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u00032\u0006\u0010\u0007\u001a\u00020\bH\u0002\u001a\u001e\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\fH\u0002¨\u0006\r"}, d2 = {"matchChildren", "Lcom/uxsense/core/pattern/ChildMatchResult;", "childNodes", "", "Lcom/uxsense/core/base/parse/KViewNode;", "patterns", "Lcom/uxsense/core/pattern/ViewPattern;", "context", "Lcom/uxsense/core/pattern/MatchContext;", "getAllDescendants", "node", "maxDepth", "", "uxsense_release"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ViewPatternKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final List<KViewNode> getAllDescendants(KViewNode kViewNode, int i) {
        ArrayList arrayList = new ArrayList();
        getAllDescendants$traverse(i, arrayList, kViewNode, 1);
        return arrayList;
    }

    private static final void getAllDescendants$traverse(int i, List<KViewNode> list, KViewNode kViewNode, int i6) {
        if (i == -1 || i6 <= i) {
            for (KViewNode kViewNode2 : kViewNode.getChildren()) {
                list.add(kViewNode2);
                getAllDescendants$traverse(i, list, kViewNode2, i6 + 1);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ChildMatchResult matchChildren(List<KViewNode> list, List<? extends ViewPattern> list2, MatchContext matchContext) {
        boolean z10;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        LinkedHashMap linkedHashMap3 = new LinkedHashMap();
        int size = 0;
        for (ViewPattern viewPattern : list2) {
            if ((viewPattern instanceof ViewPattern.AnyOf) || (viewPattern instanceof ViewPattern.NoneOf) || (viewPattern instanceof ViewPattern.ConditionalGroup) || (viewPattern instanceof ViewPattern.Branches)) {
                PatternMatchResult patternMatchResultMatch = viewPattern.match(new KViewNode(0, 0L, "__wrapper__", (String) null, (KRect) null, (String) null, (String) null, (String) null, (List) (size < list.size() ? list.subList(size, list.size()) : EmptyList.f4893a), false, false, false, false, false, false, false, 0, 0, 0, 524027, (e) null), matchContext);
                if (patternMatchResultMatch != null) {
                    linkedHashMap.putAll(patternMatchResultMatch.getNodes());
                    linkedHashMap2.putAll(patternMatchResultMatch.getValueSources());
                    linkedHashMap3.putAll(patternMatchResultMatch.getTriggers());
                    size += patternMatchResultMatch.getNodes().size();
                }
                if (patternMatchResultMatch == null && !viewPattern.isOptional()) {
                    return null;
                }
            } else {
                int size2 = list.size();
                int i = size;
                while (true) {
                    if (i >= size2) {
                        z10 = false;
                        break;
                    }
                    PatternMatchResult patternMatchResultMatch2 = viewPattern.match(list.get(i), matchContext);
                    if (patternMatchResultMatch2 != null) {
                        linkedHashMap.putAll(patternMatchResultMatch2.getNodes());
                        linkedHashMap2.putAll(patternMatchResultMatch2.getValueSources());
                        linkedHashMap3.putAll(patternMatchResultMatch2.getTriggers());
                        size = i + 1;
                        z10 = true;
                        break;
                    }
                    i++;
                }
                if (!z10 && !viewPattern.isOptional()) {
                    return null;
                }
            }
        }
        return new ChildMatchResult(linkedHashMap, linkedHashMap2, linkedHashMap3);
    }
}
