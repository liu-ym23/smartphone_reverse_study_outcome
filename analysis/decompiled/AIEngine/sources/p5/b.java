package p5;

import com.hankcs.algorithm.AhoCorasickDoubleArrayTrie;
import com.scp.moderation.keyword.model.MatchType;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.TreeMap;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class b implements e {

    /* renamed from: a, reason: collision with root package name */
    public final ArrayList f11403a;

    /* renamed from: b, reason: collision with root package name */
    public final AhoCorasickDoubleArrayTrie<String> f11404b;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public final String f11405a;

        /* renamed from: b, reason: collision with root package name */
        public final int f11406b;

        /* renamed from: c, reason: collision with root package name */
        public final int f11407c;

        public a(String str, int i10, int i11) {
            this.f11405a = str;
            this.f11406b = i10;
            this.f11407c = i11;
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    /* renamed from: p5.b$b, reason: collision with other inner class name */
    public static final class C0125b {

        /* renamed from: a, reason: collision with root package name */
        public final q5.b f11408a;

        /* renamed from: b, reason: collision with root package name */
        public final LinkedHashSet f11409b;

        /* renamed from: c, reason: collision with root package name */
        public final Integer f11410c;

        public C0125b(q5.b bVar, LinkedHashSet linkedHashSet, Integer num) {
            this.f11408a = bVar;
            this.f11409b = linkedHashSet;
            this.f11410c = num;
        }
    }

    public b(List<q5.b> list, o5.e eVar) {
        int i10;
        ArrayList arrayList;
        Integer numValueOf;
        ArrayList arrayList2 = new ArrayList();
        Iterator<q5.b> it = list.iterator();
        while (true) {
            Integer num = null;
            i10 = 0;
            if (!it.hasNext()) {
                break;
            }
            q5.b next = it.next();
            String strSubstring = next.f11622a;
            int iLastIndexOf = strSubstring.lastIndexOf(123);
            if (iLastIndexOf >= 0 && strSubstring.endsWith("}")) {
                try {
                    numValueOf = Integer.valueOf(Integer.parseInt(strSubstring.substring(iLastIndexOf + 1, strSubstring.length() - 1)));
                } catch (NumberFormatException unused) {
                    numValueOf = null;
                }
                if (numValueOf != null && numValueOf.intValue() >= 0) {
                    strSubstring = strSubstring.substring(0, iLastIndexOf);
                    num = numValueOf;
                }
            }
            String[] strArrSplit = strSubstring.split("&", -1);
            ArrayList arrayList3 = new ArrayList(strArrSplit.length);
            for (String str : strArrSplit) {
                arrayList3.add(str.trim());
            }
            if (arrayList3.size() < 2) {
                arrayList = new ArrayList();
            } else {
                int size = arrayList3.size();
                int i11 = 0;
                while (i11 < size) {
                    Object obj = arrayList3.get(i11);
                    i11++;
                    if (((String) obj).isEmpty()) {
                        arrayList = new ArrayList();
                    }
                }
                ArrayList arrayList4 = new ArrayList();
                LinkedHashMap linkedHashMap = new LinkedHashMap(3);
                for (MatchType matchType : next.f11627f) {
                    ArrayList arrayList5 = new ArrayList(arrayList3.size());
                    int size2 = arrayList3.size();
                    int i12 = 0;
                    while (true) {
                        if (i12 < size2) {
                            Object obj2 = arrayList3.get(i12);
                            i12++;
                            String strA = o5.d.a(eVar.a(matchType, (String) obj2));
                            if (strA.isEmpty()) {
                                break;
                            } else {
                                arrayList5.add(strA);
                            }
                        } else {
                            StringBuilder sb2 = new StringBuilder();
                            int size3 = arrayList5.size();
                            int i13 = 0;
                            while (i13 < size3) {
                                Object obj3 = arrayList5.get(i13);
                                i13++;
                                sb2.append((String) obj3);
                                sb2.append((char) 0);
                            }
                            linkedHashMap.putIfAbsent(sb2.toString(), arrayList5);
                        }
                    }
                }
                ArrayList arrayList6 = new ArrayList(linkedHashMap.values());
                int size4 = arrayList6.size();
                while (i10 < size4) {
                    Object obj4 = arrayList6.get(i10);
                    i10++;
                    LinkedHashSet linkedHashSet = new LinkedHashSet((List) obj4);
                    if (linkedHashSet.size() >= 2) {
                        arrayList4.add(new C0125b(next, linkedHashSet, num));
                    }
                }
                arrayList = arrayList4;
                arrayList2.addAll(arrayList);
            }
            arrayList2.addAll(arrayList);
        }
        this.f11403a = arrayList2;
        TreeMap treeMap = new TreeMap();
        int size5 = arrayList2.size();
        while (i10 < size5) {
            Object obj5 = arrayList2.get(i10);
            i10++;
            for (String str2 : ((C0125b) obj5).f11409b) {
                treeMap.putIfAbsent(str2, str2);
            }
        }
        if (treeMap.isEmpty()) {
            this.f11404b = null;
            return;
        }
        AhoCorasickDoubleArrayTrie<String> ahoCorasickDoubleArrayTrie = new AhoCorasickDoubleArrayTrie<>();
        this.f11404b = ahoCorasickDoubleArrayTrie;
        ahoCorasickDoubleArrayTrie.a(treeMap);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0114  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x011e  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x014f A[LOOP:4: B:29:0x00d4->B:49:0x014f, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:64:0x012f A[SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r19v1 */
    /* JADX WARN: Type inference failed for: r19v6 */
    /* JADX WARN: Type inference failed for: r19v7 */
    /* JADX WARN: Type inference failed for: r19v9 */
    @Override // p5.e
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.util.List<q5.a> a(java.lang.String r19, java.lang.String r20) {
        /*
            Method dump skipped, instructions count: 371
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: p5.b.a(java.lang.String, java.lang.String):java.util.List");
    }
}
