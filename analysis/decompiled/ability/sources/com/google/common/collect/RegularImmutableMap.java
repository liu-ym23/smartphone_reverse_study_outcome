package com.google.common.collect;

import java.util.AbstractMap;
import java.util.Map;
import java.util.Objects;
import k3.AbstractC1622a;
import m3.AbstractC1677d;

/* loaded from: classes3.dex */
final class RegularImmutableMap<K, V> extends ImmutableMap<K, V> {
    public static final ImmutableMap g = new RegularImmutableMap(new Object[0], 0, null);
    public final transient Object d;
    public final transient Object[] e;
    public final transient int f;

    public static class EntrySet<K, V> extends ImmutableSet<Map.Entry<K, V>> {
        public final transient ImmutableMap d;
        public final transient Object[] e;
        public final transient int f;

        public EntrySet(ImmutableMap immutableMap, Object[] objArr, int i) {
            this.d = immutableMap;
            this.e = objArr;
            this.f = i;
        }

        @Override // com.google.common.collect.ImmutableCollection
        public final int b(Object[] objArr) {
            return h().b(objArr);
        }

        @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection
        public final boolean contains(Object obj) {
            if (obj instanceof Map.Entry) {
                Map.Entry entry = (Map.Entry) obj;
                Object key = entry.getKey();
                Object value = entry.getValue();
                if (value != null && value.equals(this.d.get(key))) {
                    return true;
                }
            }
            return false;
        }

        @Override // com.google.common.collect.ImmutableCollection
        /* renamed from: g */
        public final AbstractC1677d iterator() {
            return h().listIterator(0);
        }

        @Override // com.google.common.collect.ImmutableSet
        public final ImmutableList l() {
            return new ImmutableList<Map.Entry<Object, Object>>() { // from class: com.google.common.collect.RegularImmutableMap.EntrySet.1
                @Override // java.util.List
                public final Object get(int i) {
                    EntrySet entrySet = EntrySet.this;
                    AbstractC1622a.b(i, entrySet.f);
                    Object[] objArr = entrySet.e;
                    int i6 = i * 2;
                    Object obj = objArr[i6];
                    Objects.requireNonNull(obj);
                    Object obj2 = objArr[i6 + 1];
                    Objects.requireNonNull(obj2);
                    return new AbstractMap.SimpleImmutableEntry(obj, obj2);
                }

                @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
                public final int size() {
                    return EntrySet.this.f;
                }
            };
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public final int size() {
            return this.f;
        }
    }

    public static final class KeySet<K> extends ImmutableSet<K> {
        public final transient ImmutableMap d;
        public final transient ImmutableList e;

        public KeySet(ImmutableMap immutableMap, ImmutableList immutableList) {
            this.d = immutableMap;
            this.e = immutableList;
        }

        @Override // com.google.common.collect.ImmutableCollection
        public final int b(Object[] objArr) {
            return this.e.b(objArr);
        }

        @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection
        public final boolean contains(Object obj) {
            return this.d.get(obj) != null;
        }

        @Override // com.google.common.collect.ImmutableCollection
        /* renamed from: g */
        public final AbstractC1677d iterator() {
            return this.e.listIterator(0);
        }

        @Override // com.google.common.collect.ImmutableSet
        public final ImmutableList h() {
            throw null;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public final int size() {
            return this.d.size();
        }
    }

    public static final class KeysOrValuesAsList extends ImmutableList<Object> {
        public final transient Object[] c;
        public final transient int d;
        public final transient int e;

        public KeysOrValuesAsList(Object[] objArr, int i, int i6) {
            this.c = objArr;
            this.d = i;
            this.e = i6;
        }

        @Override // java.util.List
        public final Object get(int i) {
            AbstractC1622a.b(i, this.e);
            Object obj = this.c[(i * 2) + this.d];
            Objects.requireNonNull(obj);
            return obj;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public final int size() {
            return this.e;
        }
    }

    public RegularImmutableMap(Object[] objArr, int i, Object obj) {
        this.d = obj;
        this.e = objArr;
        this.f = i;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:74:0x019b  */
    /* JADX WARN: Type inference failed for: r16v11 */
    /* JADX WARN: Type inference failed for: r16v12 */
    /* JADX WARN: Type inference failed for: r16v13 */
    /* JADX WARN: Type inference failed for: r16v4 */
    /* JADX WARN: Type inference failed for: r4v6 */
    /* JADX WARN: Type inference failed for: r4v8, types: [java.lang.Object[]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static com.google.common.collect.RegularImmutableMap e(int r19, java.lang.Object[] r20, D9.l r21) {
        /*
            Method dump skipped, instructions count: 451
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.common.collect.RegularImmutableMap.e(int, java.lang.Object[], D9.l):com.google.common.collect.RegularImmutableMap");
    }

    /* JADX WARN: Removed duplicated region for block: B:4:0x0003  */
    /* JADX WARN: Removed duplicated region for block: B:4:0x0003 A[EDGE_INSN: B:44:0x0003->B:4:0x0003 BREAK  A[LOOP:0: B:16:0x0037->B:22:0x004d], EDGE_INSN: B:46:0x0003->B:4:0x0003 BREAK  A[LOOP:1: B:26:0x0062->B:32:0x0079], EDGE_INSN: B:48:0x0003->B:4:0x0003 BREAK  A[LOOP:2: B:34:0x0088->B:43:0x00a0]] */
    @Override // com.google.common.collect.ImmutableMap, java.util.Map
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object get(java.lang.Object r8) {
        /*
            r7 = this;
            r0 = 0
            if (r8 != 0) goto L6
        L3:
            r7 = r0
            goto L9c
        L6:
            java.lang.Object[] r1 = r7.e
            int r2 = r7.f
            r3 = 1
            if (r2 != r3) goto L20
            r7 = 0
            r7 = r1[r7]
            java.util.Objects.requireNonNull(r7)
            boolean r7 = r7.equals(r8)
            if (r7 == 0) goto L3
            r7 = r1[r3]
            java.util.Objects.requireNonNull(r7)
            goto L9c
        L20:
            java.lang.Object r7 = r7.d
            if (r7 != 0) goto L25
            goto L3
        L25:
            boolean r2 = r7 instanceof byte[]
            if (r2 == 0) goto L50
            r2 = r7
            byte[] r2 = (byte[]) r2
            int r7 = r2.length
            int r4 = r7 + (-1)
            int r7 = r8.hashCode()
            int r7 = N9.j.P(r7)
        L37:
            r7 = r7 & r4
            r5 = r2[r7]
            r6 = 255(0xff, float:3.57E-43)
            r5 = r5 & r6
            if (r5 != r6) goto L40
            goto L3
        L40:
            r6 = r1[r5]
            boolean r6 = r8.equals(r6)
            if (r6 == 0) goto L4d
            r7 = r5 ^ 1
            r7 = r1[r7]
            goto L9c
        L4d:
            int r7 = r7 + 1
            goto L37
        L50:
            boolean r2 = r7 instanceof short[]
            if (r2 == 0) goto L7c
            r2 = r7
            short[] r2 = (short[]) r2
            int r7 = r2.length
            int r4 = r7 + (-1)
            int r7 = r8.hashCode()
            int r7 = N9.j.P(r7)
        L62:
            r7 = r7 & r4
            short r5 = r2[r7]
            r6 = 65535(0xffff, float:9.1834E-41)
            r5 = r5 & r6
            if (r5 != r6) goto L6c
            goto L3
        L6c:
            r6 = r1[r5]
            boolean r6 = r8.equals(r6)
            if (r6 == 0) goto L79
            r7 = r5 ^ 1
            r7 = r1[r7]
            goto L9c
        L79:
            int r7 = r7 + 1
            goto L62
        L7c:
            int[] r7 = (int[]) r7
            int r2 = r7.length
            int r2 = r2 - r3
            int r4 = r8.hashCode()
            int r4 = N9.j.P(r4)
        L88:
            r4 = r4 & r2
            r5 = r7[r4]
            r6 = -1
            if (r5 != r6) goto L90
            goto L3
        L90:
            r6 = r1[r5]
            boolean r6 = r8.equals(r6)
            if (r6 == 0) goto La0
            r7 = r5 ^ 1
            r7 = r1[r7]
        L9c:
            if (r7 != 0) goto L9f
            return r0
        L9f:
            return r7
        La0:
            int r4 = r4 + 1
            goto L88
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.common.collect.RegularImmutableMap.get(java.lang.Object):java.lang.Object");
    }

    @Override // java.util.Map
    public final int size() {
        return this.f;
    }
}
