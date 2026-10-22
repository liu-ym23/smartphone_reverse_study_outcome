package Z0;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import org.ahocorasick.trie.Emit;
import org.ahocorasick.trie.Trie;

/* loaded from: classes.dex */
final class a {

    /* renamed from: a, reason: collision with root package name */
    static final C0096a f6618a = new C0096a();

    /* renamed from: Z0.a$a, reason: collision with other inner class name */
    static final class C0096a implements Comparator<Emit> {
        C0096a() {
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(Emit emit, Emit emit2) {
            if (emit.getStart() == emit2.getStart()) {
                if (emit.size() < emit2.size()) {
                    return 1;
                }
                return emit.size() == emit2.size() ? 0 : -1;
            }
            if (emit.getStart() < emit2.getStart()) {
                return -1;
            }
            return emit.getStart() == emit2.getStart() ? 0 : 1;
        }
    }

    static String[] a(String str, List<g> list) {
        if (list != null) {
            for (g gVar : list) {
                if (gVar != null && gVar.a() != null && gVar.a().contains(str)) {
                    return gVar.b(str);
                }
            }
        }
        throw new IllegalArgumentException("No pinyin dict contains word: " + str);
    }

    static String b(String str, Trie trie, List<g> list, String str2, h hVar) {
        if (str == null || str.length() == 0) {
            return str;
        }
        if (trie == null || hVar == null) {
            StringBuffer stringBuffer = new StringBuffer();
            for (int i5 = 0; i5 < str.length(); i5++) {
                stringBuffer.append(b.d(str.charAt(i5)));
                if (i5 != str.length() - 1) {
                    stringBuffer.append(str2);
                }
            }
            return stringBuffer.toString();
        }
        List<Emit> listA = hVar.a(trie.parseText(str));
        Collections.sort(listA, f6618a);
        StringBuffer stringBuffer2 = new StringBuffer();
        int size = 0;
        int i6 = 0;
        while (size < str.length()) {
            if (i6 >= listA.size() || size != listA.get(i6).getStart()) {
                stringBuffer2.append(b.d(str.charAt(size)));
                size++;
            } else {
                String[] strArrA = a(listA.get(i6).getKeyword(), list);
                for (int i7 = 0; i7 < strArrA.length; i7++) {
                    stringBuffer2.append(strArrA[i7].toUpperCase());
                    if (i7 != strArrA.length - 1) {
                        stringBuffer2.append(str2);
                    }
                }
                size += listA.get(i6).size();
                i6++;
            }
            if (size != str.length()) {
                stringBuffer2.append(str2);
            }
        }
        return stringBuffer2.toString();
    }
}
