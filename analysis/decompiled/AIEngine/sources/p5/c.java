package p5;

import com.hankcs.algorithm.AhoCorasickDoubleArrayTrie;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.TreeMap;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class c implements e {

    /* renamed from: a, reason: collision with root package name */
    public final AhoCorasickDoubleArrayTrie<List<q5.b>> f11411a;

    public c(List<q5.b> list, o5.e eVar) {
        LinkedHashMap linkedHashMap = new LinkedHashMap(list.size());
        for (q5.b bVar : list) {
            LinkedHashSet linkedHashSet = new LinkedHashSet(3);
            ArrayList arrayListB = eVar.b(bVar);
            int size = arrayListB.size();
            int i10 = 0;
            int i11 = 0;
            while (i11 < size) {
                Object obj = arrayListB.get(i11);
                i11++;
                String strA = o5.d.a((String) obj);
                if (!strA.isEmpty()) {
                    linkedHashSet.add(strA);
                }
            }
            ArrayList arrayList = new ArrayList(linkedHashSet);
            int size2 = arrayList.size();
            while (i10 < size2) {
                Object obj2 = arrayList.get(i10);
                i10++;
                ((List) linkedHashMap.computeIfAbsent((String) obj2, new ai.onnxruntime.b(2))).add(bVar);
            }
        }
        if (linkedHashMap.isEmpty()) {
            this.f11411a = null;
            return;
        }
        AhoCorasickDoubleArrayTrie<List<q5.b>> ahoCorasickDoubleArrayTrie = new AhoCorasickDoubleArrayTrie<>();
        this.f11411a = ahoCorasickDoubleArrayTrie;
        ahoCorasickDoubleArrayTrie.a(new TreeMap(linkedHashMap));
    }

    @Override // p5.e
    public final List<q5.a> a(String str, String str2) {
        AhoCorasickDoubleArrayTrie<List<q5.b>> ahoCorasickDoubleArrayTrie = this.f11411a;
        if (ahoCorasickDoubleArrayTrie == null || str2.isEmpty()) {
            return Collections.EMPTY_LIST;
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayListB = ahoCorasickDoubleArrayTrie.b(str2);
        int size = arrayListB.size();
        int i10 = 0;
        while (i10 < size) {
            Object obj = arrayListB.get(i10);
            i10++;
            AhoCorasickDoubleArrayTrie.b bVar = (AhoCorasickDoubleArrayTrie.b) obj;
            int i11 = bVar.f5543b;
            int i12 = bVar.f5542a;
            if (i11 > i12) {
                Iterator it = ((List) bVar.f5544c).iterator();
                while (it.hasNext()) {
                    arrayList.addAll(q5.a.a((q5.b) it.next(), i12, bVar.f5543b));
                }
            }
        }
        return arrayList;
    }
}
