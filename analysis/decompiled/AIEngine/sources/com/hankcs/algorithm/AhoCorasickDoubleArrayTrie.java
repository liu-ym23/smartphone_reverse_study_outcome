package com.hankcs.algorithm;

import java.io.Serializable;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeSet;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public class AhoCorasickDoubleArrayTrie<V> implements Serializable {

    /* renamed from: a, reason: collision with root package name */
    public int[] f5529a;

    /* renamed from: b, reason: collision with root package name */
    public int[] f5530b;

    /* renamed from: c, reason: collision with root package name */
    public int[] f5531c;

    /* renamed from: d, reason: collision with root package name */
    public int[][] f5532d;

    /* renamed from: e, reason: collision with root package name */
    public V[] f5533e;
    public int[] h;

    /* renamed from: j, reason: collision with root package name */
    public int f5534j;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public class a {

        /* renamed from: a, reason: collision with root package name */
        public m5.a f5535a = new m5.a();

        /* renamed from: b, reason: collision with root package name */
        public boolean[] f5536b;

        /* renamed from: c, reason: collision with root package name */
        public int f5537c;

        /* renamed from: d, reason: collision with root package name */
        public int f5538d;

        /* renamed from: e, reason: collision with root package name */
        public int f5539e;

        /* renamed from: f, reason: collision with root package name */
        public int f5540f;

        public a() {
        }

        public static int b(m5.a aVar, ArrayList arrayList) {
            int i10 = aVar.f10493a;
            if (i10 > 0 && aVar.f10495c != null) {
                m5.a aVar2 = new m5.a(-(i10 + 1));
                TreeSet treeSet = aVar.f10495c;
                aVar2.a(((treeSet == null || treeSet.size() == 0) ? null : (Integer) aVar.f10495c.iterator().next()).intValue());
                arrayList.add(new AbstractMap.SimpleEntry(0, aVar2));
            }
            for (Map.Entry entry : aVar.f10496d.entrySet()) {
                arrayList.add(new AbstractMap.SimpleEntry(Integer.valueOf(((Character) entry.getKey()).charValue() + 1), entry.getValue()));
            }
            return arrayList.size();
        }

        public final void a(m5.a aVar) {
            Collection collection = aVar.f10495c;
            if (collection == null) {
                collection = Collections.EMPTY_LIST;
            }
            if (collection == null || collection.size() == 0) {
                return;
            }
            int size = collection.size();
            int[] iArr = new int[size];
            Iterator it = collection.iterator();
            for (int i10 = 0; i10 < size; i10++) {
                iArr[i10] = ((Integer) it.next()).intValue();
            }
            AhoCorasickDoubleArrayTrie.this.f5532d[aVar.f10497e] = iArr;
        }

        public final void c(int i10) {
            int[] iArr = new int[i10];
            int[] iArr2 = new int[i10];
            boolean[] zArr = new boolean[i10];
            int i11 = this.f5537c;
            AhoCorasickDoubleArrayTrie ahoCorasickDoubleArrayTrie = AhoCorasickDoubleArrayTrie.this;
            if (i11 > 0) {
                System.arraycopy(ahoCorasickDoubleArrayTrie.f5530b, 0, iArr, 0, i11);
                System.arraycopy(ahoCorasickDoubleArrayTrie.f5529a, 0, iArr2, 0, this.f5537c);
                System.arraycopy(this.f5536b, 0, zArr, 0, this.f5537c);
            }
            ahoCorasickDoubleArrayTrie.f5530b = iArr;
            ahoCorasickDoubleArrayTrie.f5529a = iArr2;
            this.f5536b = zArr;
            this.f5537c = i10;
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static class b<V> {

        /* renamed from: a, reason: collision with root package name */
        public final int f5542a;

        /* renamed from: b, reason: collision with root package name */
        public final int f5543b;

        /* renamed from: c, reason: collision with root package name */
        public final V f5544c;

        public b(int i10, int i11, V v3) {
            this.f5542a = i10;
            this.f5543b = i11;
            this.f5544c = v3;
        }

        public final String toString() {
            return String.format("[%d:%d]=%s", Integer.valueOf(this.f5542a), Integer.valueOf(this.f5543b), this.f5544c);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:51:0x0199, code lost:
    
        if (((r10 * r16) / ((r11 - r1.f5539e) + 1)) < 0.95d) goto L53;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x019b, code lost:
    
        r1.f5539e = r11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x019d, code lost:
    
        r1.f5536b[r9] = r19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x01bc, code lost:
    
        if (r18.f5534j <= ((((java.lang.Integer) ((java.util.Map.Entry) r6.get(r6.size() - 1)).getKey()).intValue() + r9) + 1)) goto L56;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x01be, code lost:
    
        r7 = r18.f5534j;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x01c1, code lost:
    
        r7 = (((java.lang.Integer) ((java.util.Map.Entry) r6.get(r6.size() - 1)).getKey()).intValue() + r9) + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x01da, code lost:
    
        r18.f5534j = r7;
        r7 = r6.iterator();
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x01e4, code lost:
    
        if (r7.hasNext() == false) goto L120;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x01e6, code lost:
    
        r18.f5529a[((java.lang.Integer) ((java.util.Map.Entry) r7.next()).getKey()).intValue() + r9] = r9;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x01fc, code lost:
    
        r6 = r6.iterator();
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x0204, code lost:
    
        if (r6.hasNext() == false) goto L121;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x0206, code lost:
    
        r7 = (java.util.Map.Entry) r6.next();
        r8 = new java.util.ArrayList(((m5.a) r7.getValue()).f10496d.entrySet().size() + 1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x022d, code lost:
    
        if (com.hankcs.algorithm.AhoCorasickDoubleArrayTrie.a.b((m5.a) r7.getValue(), r8) != 0) goto L74;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x022f, code lost:
    
        r8 = r18.f5530b;
        r10 = ((java.lang.Integer) r7.getKey()).intValue() + r9;
        r11 = (m5.a) r7.getValue();
        r12 = r11.f10495c;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x0244, code lost:
    
        if (r12 == null) goto L72;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x024a, code lost:
    
        if (r12.size() != 0) goto L71;
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x024d, code lost:
    
        r11 = (java.lang.Integer) r11.f10495c.iterator().next();
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x025a, code lost:
    
        r11 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x025b, code lost:
    
        r8[r10] = (-r11.intValue()) - 1;
        r1.f5538d++;
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x026b, code lost:
    
        r2.add(new java.util.AbstractMap.SimpleEntry(java.lang.Integer.valueOf(((java.lang.Integer) r7.getKey()).intValue() + r9), r8));
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x0282, code lost:
    
        ((m5.a) r7.getValue()).f10497e = ((java.lang.Integer) r7.getKey()).intValue() + r9;
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x0297, code lost:
    
        r3 = (java.lang.Integer) r3.getKey();
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x029d, code lost:
    
        if (r3 == null) goto L115;
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x029f, code lost:
    
        r18.f5530b[r3.intValue()] = r9;
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x02a7, code lost:
    
        r7 = r19;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v3, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r7v58 */
    /* JADX WARN: Type inference failed for: r7v6 */
    /* JADX WARN: Type inference failed for: r7v7, types: [int] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void a(java.util.TreeMap r19) {
        /*
            Method dump skipped, instructions count: 881
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hankcs.algorithm.AhoCorasickDoubleArrayTrie.a(java.util.TreeMap):void");
    }

    public final ArrayList b(String str) {
        ArrayList arrayList = new ArrayList();
        int i10 = 1;
        int i11 = 0;
        for (int i12 = 0; i12 < str.length(); i12++) {
            char cCharAt = str.charAt(i12);
            int i13 = this.f5530b[i11];
            int i14 = i13 + cCharAt + 1;
            if (i13 != this.f5529a[i14]) {
                i14 = i11 == 0 ? 0 : -1;
            }
            int i15 = i11;
            while (true) {
                i11 = i14;
                while (i11 == -1) {
                    i15 = this.f5531c[i15];
                    int i16 = this.f5530b[i15];
                    i14 = i16 + cCharAt + 1;
                    if (i16 != this.f5529a[i14]) {
                        i11 = i15 == 0 ? 0 : -1;
                    }
                }
            }
            int[] iArr = this.f5532d[i11];
            if (iArr != null) {
                for (int i17 : iArr) {
                    arrayList.add(new b(i10 - this.h[i17], i10, this.f5533e[i17]));
                }
            }
            i10++;
        }
        return arrayList;
    }
}
