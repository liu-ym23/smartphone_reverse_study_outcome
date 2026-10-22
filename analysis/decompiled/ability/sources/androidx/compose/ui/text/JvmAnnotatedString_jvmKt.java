package androidx.compose.ui.text;

import D7.AbstractC0214f;
import D7.C0211c;
import D7.C0213e;
import D7.q;
import S7.o;
import androidx.compose.ui.text.AnnotatedString;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.RandomAccess;
import java.util.SortedSet;
import java.util.TreeSet;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a3\u0010\u0004\u001a\u00020\u0000*\u00020\u00002\u001e\u0010\u0004\u001a\u001a\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00020\u0001H\u0000¢\u0006\u0004\b\u0004\u0010\u0005\u001a1\u0010\f\u001a\u00020\u000b2\u0012\u0010\b\u001a\u000e\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0007\u0018\u00010\u00062\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00030\tH\u0002¢\u0006\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Landroidx/compose/ui/text/AnnotatedString;", "Lkotlin/Function3;", "", "", "transform", "(Landroidx/compose/ui/text/AnnotatedString;LS7/o;)Landroidx/compose/ui/text/AnnotatedString;", "", "Landroidx/compose/ui/text/AnnotatedString$Range;", "ranges", "Ljava/util/SortedSet;", TypedValues.AttributesType.S_TARGET, "LC7/r;", "collectRangeTransitions", "(Ljava/util/List;Ljava/util/SortedSet;)V", "ui-text"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class JvmAnnotatedString_jvmKt {
    private static final void collectRangeTransitions(List<? extends AnnotatedString.Range<?>> list, SortedSet<Integer> sortedSet) {
        if (list != null) {
            int size = list.size();
            for (int i = 0; i < size; i++) {
                AnnotatedString.Range<?> range = list.get(i);
                sortedSet.add(Integer.valueOf(range.getStart()));
                sortedSet.add(Integer.valueOf(range.getEnd()));
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final AnnotatedString transform(AnnotatedString annotatedString, o oVar) {
        ArrayList arrayList;
        Integer[] numArr = {0, Integer.valueOf(annotatedString.getText().length())};
        TreeSet treeSet = new TreeSet();
        q.F0(numArr, treeSet);
        collectRangeTransitions(annotatedString.getAnnotations$ui_text(), treeSet);
        Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
        ref$ObjectRef.f4920a = "";
        LinkedHashMap linkedHashMapS = kotlin.collections.a.S(new Pair(0, 0));
        kotlin.collections.b.a(2, 1);
        if ((treeSet instanceof RandomAccess) && (treeSet instanceof List)) {
            List list = (List) treeSet;
            int size = list.size();
            ArrayList arrayList2 = new ArrayList((size % 1 == 0 ? 0 : 1) + size);
            C0213e c0213e = new C0213e(list);
            for (int i = 0; i >= 0 && i < size; i++) {
                int i6 = size - i;
                if (2 <= i6) {
                    i6 = 2;
                }
                if (i6 < 2) {
                    break;
                }
                int i10 = i6 + i;
                C0211c c0211c = AbstractC0214f.Companion;
                int size2 = c0213e.d.size();
                c0211c.getClass();
                C0211c.d(i, i10, size2);
                c0213e.b = i;
                c0213e.c = i10 - i;
                arrayList2.add(transform$lambda$0(ref$ObjectRef, oVar, annotatedString, linkedHashMapS, c0213e));
            }
        } else {
            ArrayList arrayList3 = new ArrayList();
            Iterator itB = kotlin.collections.b.b(treeSet.iterator(), 2, 1, false, true);
            while (itB.hasNext()) {
                arrayList3.add(transform$lambda$0(ref$ObjectRef, oVar, annotatedString, linkedHashMapS, (List) itB.next()));
            }
        }
        List<AnnotatedString.Range<? extends AnnotatedString.Annotation>> annotations$ui_text = annotatedString.getAnnotations$ui_text();
        if (annotations$ui_text != null) {
            arrayList = new ArrayList(annotations$ui_text.size());
            int size3 = annotations$ui_text.size();
            for (int i11 = 0; i11 < size3; i11++) {
                AnnotatedString.Range<? extends AnnotatedString.Annotation> range = annotations$ui_text.get(i11);
                AnnotatedString.Annotation item = range.getItem();
                Object obj = linkedHashMapS.get(Integer.valueOf(range.getStart()));
                k.c(obj);
                int iIntValue = ((Number) obj).intValue();
                Object obj2 = linkedHashMapS.get(Integer.valueOf(range.getEnd()));
                k.c(obj2);
                arrayList.add(new AnnotatedString.Range(item, iIntValue, ((Number) obj2).intValue()));
            }
        } else {
            arrayList = null;
        }
        return new AnnotatedString(arrayList, (String) ref$ObjectRef.f4920a);
    }

    private static final Integer transform$lambda$0(Ref$ObjectRef ref$ObjectRef, o oVar, AnnotatedString annotatedString, Map map, List list) {
        int iIntValue = ((Number) list.get(0)).intValue();
        int iIntValue2 = ((Number) list.get(1)).intValue();
        ref$ObjectRef.f4920a = ((String) ref$ObjectRef.f4920a) + ((String) oVar.invoke(annotatedString.getText(), Integer.valueOf(iIntValue), Integer.valueOf(iIntValue2)));
        return (Integer) map.put(Integer.valueOf(iIntValue2), Integer.valueOf(((String) ref$ObjectRef.f4920a).length()));
    }
}
