package androidx.compose.runtime.collection;

import S7.n;
import androidx.collection.MutableScatterMap;
import androidx.collection.MutableScatterSet;
import androidx.collection.ScatterMapKt;
import kotlin.Metadata;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\u0010\"\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\f\b\u0081@\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u0001*\b\b\u0001\u0010\u0003*\u00020\u00012\u00020\u0001B\u001d\u0012\u0014\b\u0002\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u001d\u0010\r\u001a\u00020\n2\u0006\u0010\b\u001a\u00028\u00002\u0006\u0010\t\u001a\u00028\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u001d\u0010\u0010\u001a\u00020\n2\u0006\u0010\b\u001a\u00028\u00002\u0006\u0010\u000e\u001a\u00028\u0001¢\u0006\u0004\b\u000f\u0010\fJ\u0018\u0010\u0015\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00028\u0000H\u0086\u0002¢\u0006\u0004\b\u0013\u0010\u0014J,\u0010\u001a\u001a\u00020\n2\u0006\u0010\b\u001a\u00028\u00002\u0012\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00020\n0\u0016H\u0086\b¢\u0006\u0004\b\u0018\u0010\u0019J,\u0010\u001d\u001a\u00020\u00122\u0006\u0010\b\u001a\u00028\u00002\u0012\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00020\u00120\u0016H\u0086\b¢\u0006\u0004\b\u001b\u0010\u001cJ\r\u0010 \u001a\u00020\n¢\u0006\u0004\b\u001e\u0010\u001fJ\u001d\u0010#\u001a\u00020\u00122\u0006\u0010\b\u001a\u00028\u00002\u0006\u0010\t\u001a\u00028\u0001¢\u0006\u0004\b!\u0010\"J&\u0010'\u001a\u00020\n2\u0014\b\u0004\u0010$\u001a\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00020\u00120\u0016H\u0086\b¢\u0006\u0004\b%\u0010&J,\u0010+\u001a\u00020\n2\u001a\b\u0004\u0010$\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00020\u00120(H\u0086\b¢\u0006\u0004\b)\u0010*J\u0015\u0010.\u001a\u00020\n2\u0006\u0010\t\u001a\u00028\u0001¢\u0006\u0004\b,\u0010-J\u001f\u00103\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u0001000/¢\u0006\u0004\b1\u00102J\u0010\u00105\u001a\u000204HÖ\u0001¢\u0006\u0004\b5\u00106J\u0010\u00108\u001a\u000207HÖ\u0001¢\u0006\u0004\b8\u00109J\u001a\u0010;\u001a\u00020\u00122\b\u0010:\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b;\u0010<R#\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010=\u001a\u0004\b>\u0010?R\u0011\u0010B\u001a\u0002078F¢\u0006\u0006\u001a\u0004\b@\u0010A\u0088\u0001\u0005\u0092\u0001\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00010\u0004¨\u0006C"}, d2 = {"Landroidx/compose/runtime/collection/ScopeMap;", "", "Key", "Scope", "Landroidx/collection/MutableScatterMap;", "map", "constructor-impl", "(Landroidx/collection/MutableScatterMap;)Landroidx/collection/MutableScatterMap;", "key", "scope", "LC7/r;", "add-impl", "(Landroidx/collection/MutableScatterMap;Ljava/lang/Object;Ljava/lang/Object;)V", "add", "value", "set-impl", "set", "element", "", "contains-impl", "(Landroidx/collection/MutableScatterMap;Ljava/lang/Object;)Z", "contains", "Lkotlin/Function1;", "block", "forEachScopeOf-impl", "(Landroidx/collection/MutableScatterMap;Ljava/lang/Object;LS7/k;)V", "forEachScopeOf", "anyScopeOf-impl", "(Landroidx/collection/MutableScatterMap;Ljava/lang/Object;LS7/k;)Z", "anyScopeOf", "clear-impl", "(Landroidx/collection/MutableScatterMap;)V", "clear", "remove-impl", "(Landroidx/collection/MutableScatterMap;Ljava/lang/Object;Ljava/lang/Object;)Z", "remove", "predicate", "removeScopeIf-impl", "(Landroidx/collection/MutableScatterMap;LS7/k;)V", "removeScopeIf", "Lkotlin/Function2;", "removeIf-impl", "(Landroidx/collection/MutableScatterMap;LS7/n;)V", "removeIf", "removeScope-impl", "(Landroidx/collection/MutableScatterMap;Ljava/lang/Object;)V", "removeScope", "", "", "asMap-impl", "(Landroidx/collection/MutableScatterMap;)Ljava/util/Map;", "asMap", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Landroidx/collection/MutableScatterMap;", "getMap", "()Landroidx/collection/MutableScatterMap;", "getSize-impl", "(Landroidx/collection/MutableScatterMap;)I", "size", "runtime"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class ScopeMap<Key, Scope> {
    private final MutableScatterMap<Object, Object> map;

    private /* synthetic */ ScopeMap(MutableScatterMap mutableScatterMap) {
        this.map = mutableScatterMap;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v0, types: [java.lang.Object[]] */
    /* JADX WARN: Type inference failed for: r5v1 */
    /* JADX WARN: Type inference failed for: r6v1, types: [androidx.collection.MutableScatterSet] */
    /* renamed from: add-impl, reason: not valid java name */
    public static final void m3568addimpl(MutableScatterMap<Object, Object> mutableScatterMap, Key key, Scope scope) {
        int iFindInsertIndex = mutableScatterMap.findInsertIndex(key);
        int i = 0;
        int i6 = 1;
        boolean z10 = iFindInsertIndex < 0;
        e eVar = null;
        Scope scope2 = z10 ? null : mutableScatterMap.values[iFindInsertIndex];
        if (scope2 != null) {
            if (scope2 instanceof MutableScatterSet) {
                ((MutableScatterSet) scope2).add(scope);
            } else if (scope2 != scope) {
                ?? mutableScatterSet = new MutableScatterSet(i, i6, eVar);
                mutableScatterSet.add(scope2);
                mutableScatterSet.add(scope);
                scope = mutableScatterSet;
            }
            scope = scope2;
        }
        if (!z10) {
            mutableScatterMap.values[iFindInsertIndex] = scope;
            return;
        }
        int i10 = ~iFindInsertIndex;
        mutableScatterMap.keys[i10] = key;
        mutableScatterMap.values[i10] = scope;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0055  */
    /* renamed from: anyScopeOf-impl, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final boolean m3569anyScopeOfimpl(androidx.collection.MutableScatterMap<java.lang.Object, java.lang.Object> r13, Key r14, S7.k r15) {
        /*
            java.lang.Object r13 = r13.get(r14)
            r14 = 0
            if (r13 == 0) goto L67
            boolean r0 = r13 instanceof androidx.collection.MutableScatterSet
            r1 = 1
            if (r0 == 0) goto L5a
            androidx.collection.MutableScatterSet r13 = (androidx.collection.MutableScatterSet) r13
            java.lang.Object[] r0 = r13.elements
            long[] r13 = r13.metadata
            int r2 = r13.length
            int r2 = r2 + (-2)
            if (r2 < 0) goto L67
            r3 = r14
        L18:
            r4 = r13[r3]
            long r6 = ~r4
            r8 = 7
            long r6 = r6 << r8
            long r6 = r6 & r4
            r8 = -9187201950435737472(0x8080808080808080, double:-2.937446524422997E-306)
            long r6 = r6 & r8
            int r6 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r6 == 0) goto L55
            int r6 = r3 - r2
            int r6 = ~r6
            int r6 = r6 >>> 31
            r7 = 8
            int r6 = 8 - r6
            r8 = r14
        L32:
            if (r8 >= r6) goto L53
            r9 = 255(0xff, double:1.26E-321)
            long r9 = r9 & r4
            r11 = 128(0x80, double:6.3E-322)
            int r9 = (r9 > r11 ? 1 : (r9 == r11 ? 0 : -1))
            if (r9 >= 0) goto L4f
            int r9 = r3 << 3
            int r9 = r9 + r8
            r9 = r0[r9]
            java.lang.Object r9 = r15.invoke(r9)
            java.lang.Boolean r9 = (java.lang.Boolean) r9
            boolean r9 = r9.booleanValue()
            if (r9 == 0) goto L4f
            return r1
        L4f:
            long r4 = r4 >> r7
            int r8 = r8 + 1
            goto L32
        L53:
            if (r6 != r7) goto L67
        L55:
            if (r3 == r2) goto L67
            int r3 = r3 + 1
            goto L18
        L5a:
            java.lang.Object r13 = r15.invoke(r13)
            java.lang.Boolean r13 = (java.lang.Boolean) r13
            boolean r13 = r13.booleanValue()
            if (r13 == 0) goto L67
            return r1
        L67:
            return r14
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.collection.ScopeMap.m3569anyScopeOfimpl(androidx.collection.MutableScatterMap, java.lang.Object, S7.k):boolean");
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0073  */
    /* renamed from: asMap-impl, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.util.Map<Key, java.util.Set<Scope>> m3570asMapimpl(androidx.collection.MutableScatterMap<java.lang.Object, java.lang.Object> r15) {
        /*
            java.util.HashMap r0 = new java.util.HashMap
            r0.<init>()
            java.lang.Object[] r1 = r15.keys
            java.lang.Object[] r2 = r15.values
            long[] r15 = r15.metadata
            int r3 = r15.length
            int r3 = r3 + (-2)
            if (r3 < 0) goto L78
            r4 = 0
            r5 = r4
        L12:
            r6 = r15[r5]
            long r8 = ~r6
            r10 = 7
            long r8 = r8 << r10
            long r8 = r8 & r6
            r10 = -9187201950435737472(0x8080808080808080, double:-2.937446524422997E-306)
            long r8 = r8 & r10
            int r8 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1))
            if (r8 == 0) goto L73
            int r8 = r5 - r3
            int r8 = ~r8
            int r8 = r8 >>> 31
            r9 = 8
            int r8 = 8 - r8
            r10 = r4
        L2c:
            if (r10 >= r8) goto L71
            r11 = 255(0xff, double:1.26E-321)
            long r11 = r11 & r6
            r13 = 128(0x80, double:6.3E-322)
            int r11 = (r11 > r13 ? 1 : (r11 == r13 ? 0 : -1))
            if (r11 >= 0) goto L6d
            int r11 = r5 << 3
            int r11 = r11 + r10
            r12 = r1[r11]
            r11 = r2[r11]
            java.lang.String r13 = "null cannot be cast to non-null type Key of androidx.compose.runtime.collection.ScopeMap"
            kotlin.jvm.internal.k.d(r12, r13)
            boolean r13 = r11 instanceof androidx.collection.MutableScatterSet
            if (r13 == 0) goto L53
            java.lang.String r13 = "null cannot be cast to non-null type androidx.collection.MutableScatterSet<Scope of androidx.compose.runtime.collection.ScopeMap>"
            kotlin.jvm.internal.k.d(r11, r13)
            androidx.collection.MutableScatterSet r11 = (androidx.collection.MutableScatterSet) r11
            java.util.Set r11 = r11.asSet()
            goto L6a
        L53:
            java.lang.String r13 = "null cannot be cast to non-null type Scope of androidx.compose.runtime.collection.ScopeMap"
            kotlin.jvm.internal.k.d(r11, r13)
            java.lang.Object[] r11 = new java.lang.Object[]{r11}
            java.util.LinkedHashSet r13 = new java.util.LinkedHashSet
            r14 = 1
            int r14 = kotlin.collections.a.P(r14)
            r13.<init>(r14)
            D7.q.F0(r11, r13)
            r11 = r13
        L6a:
            r0.put(r12, r11)
        L6d:
            long r6 = r6 >> r9
            int r10 = r10 + 1
            goto L2c
        L71:
            if (r8 != r9) goto L78
        L73:
            if (r5 == r3) goto L78
            int r5 = r5 + 1
            goto L12
        L78:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.collection.ScopeMap.m3570asMapimpl(androidx.collection.MutableScatterMap):java.util.Map");
    }

    /* renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ ScopeMap m3571boximpl(MutableScatterMap mutableScatterMap) {
        return new ScopeMap(mutableScatterMap);
    }

    /* renamed from: clear-impl, reason: not valid java name */
    public static final void m3572clearimpl(MutableScatterMap<Object, Object> mutableScatterMap) {
        mutableScatterMap.clear();
    }

    /* renamed from: constructor-impl, reason: not valid java name */
    public static <Key, Scope> MutableScatterMap<Object, Object> m3573constructorimpl(MutableScatterMap<Object, Object> mutableScatterMap) {
        return mutableScatterMap;
    }

    /* renamed from: constructor-impl$default, reason: not valid java name */
    public static /* synthetic */ MutableScatterMap m3574constructorimpl$default(MutableScatterMap mutableScatterMap, int i, e eVar) {
        if ((i & 1) != 0) {
            mutableScatterMap = ScatterMapKt.mutableScatterMapOf();
        }
        return m3573constructorimpl(mutableScatterMap);
    }

    /* renamed from: contains-impl, reason: not valid java name */
    public static final boolean m3575containsimpl(MutableScatterMap<Object, Object> mutableScatterMap, Key key) {
        return mutableScatterMap.containsKey(key);
    }

    /* renamed from: equals-impl, reason: not valid java name */
    public static boolean m3576equalsimpl(MutableScatterMap<Object, Object> mutableScatterMap, Object obj) {
        return (obj instanceof ScopeMap) && k.b(mutableScatterMap, ((ScopeMap) obj).getMap());
    }

    /* renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m3577equalsimpl0(MutableScatterMap<Object, Object> mutableScatterMap, MutableScatterMap<Object, Object> mutableScatterMap2) {
        return k.b(mutableScatterMap, mutableScatterMap2);
    }

    /* renamed from: forEachScopeOf-impl, reason: not valid java name */
    public static final void m3578forEachScopeOfimpl(MutableScatterMap<Object, Object> mutableScatterMap, Key key, S7.k kVar) {
        Object obj = mutableScatterMap.get(key);
        if (obj == null) {
            return;
        }
        if (!(obj instanceof MutableScatterSet)) {
            kVar.invoke(obj);
            return;
        }
        MutableScatterSet mutableScatterSet = (MutableScatterSet) obj;
        Object[] objArr = mutableScatterSet.elements;
        long[] jArr = mutableScatterSet.metadata;
        int length = jArr.length - 2;
        if (length < 0) {
            return;
        }
        int i = 0;
        while (true) {
            long j5 = jArr[i];
            if ((((~j5) << 7) & j5 & (-9187201950435737472L)) != -9187201950435737472L) {
                int i6 = 8 - ((~(i - length)) >>> 31);
                for (int i10 = 0; i10 < i6; i10++) {
                    if ((255 & j5) < 128) {
                        kVar.invoke(objArr[(i << 3) + i10]);
                    }
                    j5 >>= 8;
                }
                if (i6 != 8) {
                    return;
                }
            }
            if (i == length) {
                return;
            } else {
                i++;
            }
        }
    }

    /* renamed from: getSize-impl, reason: not valid java name */
    public static final int m3579getSizeimpl(MutableScatterMap<Object, Object> mutableScatterMap) {
        return mutableScatterMap.get_size();
    }

    /* renamed from: hashCode-impl, reason: not valid java name */
    public static int m3580hashCodeimpl(MutableScatterMap<Object, Object> mutableScatterMap) {
        return mutableScatterMap.hashCode();
    }

    /* renamed from: remove-impl, reason: not valid java name */
    public static final boolean m3581removeimpl(MutableScatterMap<Object, Object> mutableScatterMap, Key key, Scope scope) {
        Object obj = mutableScatterMap.get(key);
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof MutableScatterSet)) {
            if (!obj.equals(scope)) {
                return false;
            }
            mutableScatterMap.remove(key);
            return true;
        }
        MutableScatterSet mutableScatterSet = (MutableScatterSet) obj;
        boolean zRemove = mutableScatterSet.remove(scope);
        if (zRemove && mutableScatterSet.isEmpty()) {
            mutableScatterMap.remove(key);
        }
        return zRemove;
    }

    /* renamed from: removeIf-impl, reason: not valid java name */
    public static final void m3582removeIfimpl(MutableScatterMap<Object, Object> mutableScatterMap, n nVar) {
        long[] jArr;
        long[] jArr2;
        long j5;
        char c;
        long j6;
        int i;
        int i6;
        boolean zBooleanValue;
        long[] jArr3;
        long j10;
        long[] jArr4 = mutableScatterMap.metadata;
        int length = jArr4.length - 2;
        if (length < 0) {
            return;
        }
        int i10 = 0;
        while (true) {
            long j11 = jArr4[i10];
            char c2 = 7;
            long j12 = -9187201950435737472L;
            if ((((~j11) << 7) & j11 & (-9187201950435737472L)) != -9187201950435737472L) {
                int i11 = 8;
                int i12 = 8 - ((~(i10 - length)) >>> 31);
                int i13 = 0;
                while (i13 < i12) {
                    if ((j11 & 255) < 128) {
                        int i14 = (i10 << 3) + i13;
                        c = c2;
                        Object obj = mutableScatterMap.keys[i14];
                        j6 = j12;
                        Object obj2 = mutableScatterMap.values[i14];
                        k.d(obj, "null cannot be cast to non-null type Key of androidx.compose.runtime.collection.ScopeMap");
                        if (obj2 instanceof MutableScatterSet) {
                            k.d(obj2, "null cannot be cast to non-null type androidx.collection.MutableScatterSet<Scope of androidx.compose.runtime.collection.ScopeMap>");
                            MutableScatterSet mutableScatterSet = (MutableScatterSet) obj2;
                            Object[] objArr = mutableScatterSet.elements;
                            long[] jArr5 = mutableScatterSet.metadata;
                            int length2 = jArr5.length - 2;
                            if (length2 >= 0) {
                                j5 = j11;
                                int i15 = i11;
                                int i16 = 0;
                                while (true) {
                                    long j13 = jArr5[i16];
                                    Object[] objArr2 = objArr;
                                    i = i13;
                                    if ((((~j13) << c) & j13 & j6) != j6) {
                                        int i17 = 8 - ((~(i16 - length2)) >>> 31);
                                        int i18 = 0;
                                        while (i18 < i17) {
                                            if ((j13 & 255) < 128) {
                                                jArr3 = jArr4;
                                                int i19 = (i16 << 3) + i18;
                                                j10 = j13;
                                                if (((Boolean) nVar.invoke(obj, objArr2[i19])).booleanValue()) {
                                                    mutableScatterSet.removeElementAt(i19);
                                                }
                                            } else {
                                                jArr3 = jArr4;
                                                j10 = j13;
                                            }
                                            j13 = j10 >> i15;
                                            i18++;
                                            jArr4 = jArr3;
                                        }
                                        jArr2 = jArr4;
                                        if (i17 != i15) {
                                            break;
                                        }
                                    } else {
                                        jArr2 = jArr4;
                                    }
                                    if (i16 == length2) {
                                        break;
                                    }
                                    i16++;
                                    i13 = i;
                                    objArr = objArr2;
                                    jArr4 = jArr2;
                                    i15 = 8;
                                }
                            } else {
                                jArr2 = jArr4;
                                j5 = j11;
                                i = i13;
                            }
                            zBooleanValue = mutableScatterSet.isEmpty();
                        } else {
                            jArr2 = jArr4;
                            j5 = j11;
                            i = i13;
                            k.d(obj2, "null cannot be cast to non-null type Scope of androidx.compose.runtime.collection.ScopeMap");
                            zBooleanValue = ((Boolean) nVar.invoke(obj, obj2)).booleanValue();
                        }
                        if (zBooleanValue) {
                            mutableScatterMap.removeValueAt(i14);
                        }
                        i6 = 8;
                    } else {
                        jArr2 = jArr4;
                        j5 = j11;
                        c = c2;
                        j6 = j12;
                        i = i13;
                        i6 = i11;
                    }
                    j11 = j5 >> i6;
                    i13 = i + 1;
                    i11 = i6;
                    c2 = c;
                    j12 = j6;
                    jArr4 = jArr2;
                }
                jArr = jArr4;
                if (i12 != i11) {
                    return;
                }
            } else {
                jArr = jArr4;
            }
            if (i10 == length) {
                return;
            }
            i10++;
            jArr4 = jArr;
        }
    }

    /* renamed from: removeScope-impl, reason: not valid java name */
    public static final void m3583removeScopeimpl(MutableScatterMap<Object, Object> mutableScatterMap, Scope scope) {
        boolean zIsEmpty;
        long[] jArr = mutableScatterMap.metadata;
        int length = jArr.length - 2;
        if (length < 0) {
            return;
        }
        int i = 0;
        while (true) {
            long j5 = jArr[i];
            if ((((~j5) << 7) & j5 & (-9187201950435737472L)) != -9187201950435737472L) {
                int i6 = 8 - ((~(i - length)) >>> 31);
                for (int i10 = 0; i10 < i6; i10++) {
                    if ((255 & j5) < 128) {
                        int i11 = (i << 3) + i10;
                        Object obj = mutableScatterMap.keys[i11];
                        Object obj2 = mutableScatterMap.values[i11];
                        if (obj2 instanceof MutableScatterSet) {
                            k.d(obj2, "null cannot be cast to non-null type androidx.collection.MutableScatterSet<Scope of androidx.compose.runtime.collection.ScopeMap>");
                            MutableScatterSet mutableScatterSet = (MutableScatterSet) obj2;
                            mutableScatterSet.remove(scope);
                            zIsEmpty = mutableScatterSet.isEmpty();
                        } else {
                            zIsEmpty = obj2 == scope;
                        }
                        if (zIsEmpty) {
                            mutableScatterMap.removeValueAt(i11);
                        }
                    }
                    j5 >>= 8;
                }
                if (i6 != 8) {
                    return;
                }
            }
            if (i == length) {
                return;
            } else {
                i++;
            }
        }
    }

    /* renamed from: removeScopeIf-impl, reason: not valid java name */
    public static final void m3584removeScopeIfimpl(MutableScatterMap<Object, Object> mutableScatterMap, S7.k kVar) {
        long[] jArr;
        long[] jArr2;
        long j5;
        char c;
        long j6;
        int i;
        boolean zBooleanValue;
        MutableScatterSet mutableScatterSet;
        long[] jArr3;
        int i6;
        MutableScatterSet mutableScatterSet2;
        long[] jArr4 = mutableScatterMap.metadata;
        int length = jArr4.length - 2;
        if (length < 0) {
            return;
        }
        int i10 = 0;
        while (true) {
            long j10 = jArr4[i10];
            char c2 = 7;
            long j11 = -9187201950435737472L;
            if ((((~j10) << 7) & j10 & (-9187201950435737472L)) != -9187201950435737472L) {
                int i11 = 8;
                int i12 = 8 - ((~(i10 - length)) >>> 31);
                int i13 = 0;
                while (i13 < i12) {
                    if ((j10 & 255) < 128) {
                        int i14 = (i10 << 3) + i13;
                        c = c2;
                        Object obj = mutableScatterMap.keys[i14];
                        Object obj2 = mutableScatterMap.values[i14];
                        j6 = j11;
                        if (obj2 instanceof MutableScatterSet) {
                            k.d(obj2, "null cannot be cast to non-null type androidx.collection.MutableScatterSet<Scope of androidx.compose.runtime.collection.ScopeMap>");
                            MutableScatterSet mutableScatterSet3 = (MutableScatterSet) obj2;
                            Object[] objArr = mutableScatterSet3.elements;
                            long[] jArr5 = mutableScatterSet3.metadata;
                            int length2 = jArr5.length - 2;
                            if (length2 >= 0) {
                                int i15 = i11;
                                MutableScatterSet mutableScatterSet4 = mutableScatterSet3;
                                int i16 = 0;
                                while (true) {
                                    long j12 = jArr5[i16];
                                    j5 = j10;
                                    if ((((~j12) << c) & j12 & j6) != j6) {
                                        int i17 = 8 - ((~(i16 - length2)) >>> 31);
                                        int i18 = 0;
                                        while (i18 < i17) {
                                            if ((j12 & 255) < 128) {
                                                jArr3 = jArr4;
                                                int i19 = (i16 << 3) + i18;
                                                i6 = i18;
                                                if (((Boolean) kVar.invoke(objArr[i19])).booleanValue()) {
                                                    mutableScatterSet2 = mutableScatterSet4;
                                                    mutableScatterSet2.removeElementAt(i19);
                                                }
                                                j12 >>= i15;
                                                mutableScatterSet4 = mutableScatterSet2;
                                                i18 = i6 + 1;
                                                jArr4 = jArr3;
                                            } else {
                                                jArr3 = jArr4;
                                                i6 = i18;
                                            }
                                            mutableScatterSet2 = mutableScatterSet4;
                                            j12 >>= i15;
                                            mutableScatterSet4 = mutableScatterSet2;
                                            i18 = i6 + 1;
                                            jArr4 = jArr3;
                                        }
                                        jArr2 = jArr4;
                                        mutableScatterSet = mutableScatterSet4;
                                        if (i17 != i15) {
                                            break;
                                        }
                                    } else {
                                        jArr2 = jArr4;
                                        mutableScatterSet = mutableScatterSet4;
                                    }
                                    if (i16 == length2) {
                                        break;
                                    }
                                    i16++;
                                    mutableScatterSet4 = mutableScatterSet;
                                    j10 = j5;
                                    jArr4 = jArr2;
                                    i15 = 8;
                                }
                            } else {
                                jArr2 = jArr4;
                                j5 = j10;
                                mutableScatterSet = mutableScatterSet3;
                            }
                            zBooleanValue = mutableScatterSet.isEmpty();
                        } else {
                            jArr2 = jArr4;
                            j5 = j10;
                            k.d(obj2, "null cannot be cast to non-null type Scope of androidx.compose.runtime.collection.ScopeMap");
                            zBooleanValue = ((Boolean) kVar.invoke(obj2)).booleanValue();
                        }
                        if (zBooleanValue) {
                            mutableScatterMap.removeValueAt(i14);
                        }
                        i = 8;
                    } else {
                        jArr2 = jArr4;
                        j5 = j10;
                        c = c2;
                        j6 = j11;
                        i = i11;
                    }
                    j10 = j5 >> i;
                    i13++;
                    i11 = i;
                    c2 = c;
                    j11 = j6;
                    jArr4 = jArr2;
                }
                jArr = jArr4;
                if (i12 != i11) {
                    return;
                }
            } else {
                jArr = jArr4;
            }
            if (i10 == length) {
                return;
            }
            i10++;
            jArr4 = jArr;
        }
    }

    /* renamed from: set-impl, reason: not valid java name */
    public static final void m3585setimpl(MutableScatterMap<Object, Object> mutableScatterMap, Key key, Scope scope) {
        mutableScatterMap.set(key, scope);
    }

    /* renamed from: toString-impl, reason: not valid java name */
    public static String m3586toStringimpl(MutableScatterMap<Object, Object> mutableScatterMap) {
        return "ScopeMap(map=" + mutableScatterMap + ')';
    }

    public boolean equals(Object other) {
        return m3576equalsimpl(this.map, other);
    }

    public final MutableScatterMap<Object, Object> getMap() {
        return this.map;
    }

    public int hashCode() {
        return m3580hashCodeimpl(this.map);
    }

    public String toString() {
        return m3586toStringimpl(this.map);
    }

    /* renamed from: unbox-impl, reason: not valid java name and from getter */
    public final /* synthetic */ MutableScatterMap getMap() {
        return this.map;
    }
}
