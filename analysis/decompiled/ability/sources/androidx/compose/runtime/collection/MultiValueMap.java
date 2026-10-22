package androidx.compose.runtime.collection;

import D7.q;
import Y7.f;
import androidx.collection.MutableObjectList;
import androidx.collection.MutableScatterMap;
import androidx.collection.ObjectList;
import androidx.collection.ObjectListKt;
import androidx.exifinterface.media.ExifInterface;
import g1.AbstractC1451a;
import kotlin.Metadata;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\b\u0081@\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u0001*\b\b\u0001\u0010\u0003*\u00020\u00012\u00020\u0001B\u001d\u0012\u0014\b\u0002\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u001d\u0010\r\u001a\u00020\n2\u0006\u0010\b\u001a\u00028\u00002\u0006\u0010\t\u001a\u00028\u0001¢\u0006\u0004\b\u000b\u0010\fJ\r\u0010\u0010\u001a\u00020\n¢\u0006\u0004\b\u000e\u0010\u000fJ\u0018\u0010\u0014\u001a\u00020\u00112\u0006\u0010\b\u001a\u00028\u0000H\u0086\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u001e\u0010\u0018\u001a\b\u0012\u0004\u0012\u00028\u00010\u00152\u0006\u0010\b\u001a\u00028\u0000H\u0086\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\r\u0010\u001b\u001a\u00020\u0011¢\u0006\u0004\b\u0019\u0010\u001aJ\r\u0010\u001d\u001a\u00020\u0011¢\u0006\u0004\b\u001c\u0010\u001aJ\u0017\u0010 \u001a\u0004\u0018\u00018\u00012\u0006\u0010\b\u001a\u00028\u0000¢\u0006\u0004\b\u001e\u0010\u001fJ\u0017\u0010\"\u001a\u0004\u0018\u00018\u00012\u0006\u0010\b\u001a\u00028\u0000¢\u0006\u0004\b!\u0010\u001fJ\u0013\u0010%\u001a\b\u0012\u0004\u0012\u00028\u00010\u0015¢\u0006\u0004\b#\u0010$J,\u0010*\u001a\u00020\n2\u0006\u0010\b\u001a\u00028\u00002\u0012\u0010'\u001a\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00020\n0&H\u0086\b¢\u0006\u0004\b(\u0010)J)\u0010-\u001a\u00020\n2\u0006\u0010\b\u001a\u00028\u00002\u0012\u0010+\u001a\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00020\u00110&¢\u0006\u0004\b,\u0010)J\u0010\u0010/\u001a\u00020.HÖ\u0001¢\u0006\u0004\b/\u00100J\u0010\u00102\u001a\u000201HÖ\u0001¢\u0006\u0004\b2\u00103J\u001a\u00105\u001a\u00020\u00112\b\u00104\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b5\u00106R \u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00010\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u00107\u0088\u0001\u0005\u0092\u0001\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00010\u0004¨\u00068"}, d2 = {"Landroidx/compose/runtime/collection/MultiValueMap;", "", "K", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "Landroidx/collection/MutableScatterMap;", "map", "constructor-impl", "(Landroidx/collection/MutableScatterMap;)Landroidx/collection/MutableScatterMap;", "key", "value", "LC7/r;", "add-impl", "(Landroidx/collection/MutableScatterMap;Ljava/lang/Object;Ljava/lang/Object;)V", "add", "clear-impl", "(Landroidx/collection/MutableScatterMap;)V", "clear", "", "contains-impl", "(Landroidx/collection/MutableScatterMap;Ljava/lang/Object;)Z", "contains", "Landroidx/collection/ObjectList;", "get-impl", "(Landroidx/collection/MutableScatterMap;Ljava/lang/Object;)Landroidx/collection/ObjectList;", "get", "isEmpty-impl", "(Landroidx/collection/MutableScatterMap;)Z", "isEmpty", "isNotEmpty-impl", "isNotEmpty", "removeLast-impl", "(Landroidx/collection/MutableScatterMap;Ljava/lang/Object;)Ljava/lang/Object;", "removeLast", "removeFirst-impl", "removeFirst", "values-impl", "(Landroidx/collection/MutableScatterMap;)Landroidx/collection/ObjectList;", "values", "Lkotlin/Function1;", "block", "forEachValue-impl", "(Landroidx/collection/MutableScatterMap;Ljava/lang/Object;LS7/k;)V", "forEachValue", "condition", "removeValueIf-impl", "removeValueIf", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Landroidx/collection/MutableScatterMap;", "runtime"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class MultiValueMap<K, V> {
    private final MutableScatterMap<Object, Object> map;

    private /* synthetic */ MultiValueMap(MutableScatterMap mutableScatterMap) {
        this.map = mutableScatterMap;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: add-impl, reason: not valid java name */
    public static final void m3549addimpl(MutableScatterMap<Object, Object> mutableScatterMap, K k, V v10) {
        int iFindInsertIndex = mutableScatterMap.findInsertIndex(k);
        boolean z10 = iFindInsertIndex < 0;
        Object obj = z10 ? null : mutableScatterMap.values[iFindInsertIndex];
        if (obj != null) {
            if (obj instanceof MutableObjectList) {
                MutableObjectList mutableObjectList = (MutableObjectList) obj;
                mutableObjectList.add(v10);
                v10 = mutableObjectList;
            } else {
                v10 = (V) ObjectListKt.mutableObjectListOf(obj, v10);
            }
        }
        if (!z10) {
            mutableScatterMap.values[iFindInsertIndex] = v10;
            return;
        }
        int i = ~iFindInsertIndex;
        mutableScatterMap.keys[i] = k;
        mutableScatterMap.values[i] = v10;
    }

    /* renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ MultiValueMap m3550boximpl(MutableScatterMap mutableScatterMap) {
        return new MultiValueMap(mutableScatterMap);
    }

    /* renamed from: clear-impl, reason: not valid java name */
    public static final void m3551clearimpl(MutableScatterMap<Object, Object> mutableScatterMap) {
        mutableScatterMap.clear();
    }

    /* renamed from: constructor-impl, reason: not valid java name */
    public static <K, V> MutableScatterMap<Object, Object> m3552constructorimpl(MutableScatterMap<Object, Object> mutableScatterMap) {
        return mutableScatterMap;
    }

    /* renamed from: constructor-impl$default, reason: not valid java name */
    public static /* synthetic */ MutableScatterMap m3553constructorimpl$default(MutableScatterMap mutableScatterMap, int i, e eVar) {
        int i6 = 1;
        if ((i & 1) != 0) {
            mutableScatterMap = new MutableScatterMap(0, i6, null);
        }
        return m3552constructorimpl(mutableScatterMap);
    }

    /* renamed from: contains-impl, reason: not valid java name */
    public static final boolean m3554containsimpl(MutableScatterMap<Object, Object> mutableScatterMap, K k) {
        return mutableScatterMap.contains(k);
    }

    /* renamed from: equals-impl, reason: not valid java name */
    public static boolean m3555equalsimpl(MutableScatterMap<Object, Object> mutableScatterMap, Object obj) {
        return (obj instanceof MultiValueMap) && k.b(mutableScatterMap, ((MultiValueMap) obj).getMap());
    }

    /* renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m3556equalsimpl0(MutableScatterMap<Object, Object> mutableScatterMap, MutableScatterMap<Object, Object> mutableScatterMap2) {
        return k.b(mutableScatterMap, mutableScatterMap2);
    }

    /* renamed from: forEachValue-impl, reason: not valid java name */
    public static final void m3557forEachValueimpl(MutableScatterMap<Object, Object> mutableScatterMap, K k, S7.k kVar) {
        Object obj = mutableScatterMap.get(k);
        if (obj != null) {
            if (!(obj instanceof MutableObjectList)) {
                kVar.invoke(obj);
                return;
            }
            ObjectList objectList = (ObjectList) obj;
            Object[] objArr = objectList.content;
            int i = objectList._size;
            for (int i6 = 0; i6 < i; i6++) {
                Object obj2 = objArr[i6];
                k.d(obj2, "null cannot be cast to non-null type V of androidx.compose.runtime.collection.MultiValueMap");
                kVar.invoke(obj2);
            }
        }
    }

    /* renamed from: get-impl, reason: not valid java name */
    public static final ObjectList<V> m3558getimpl(MutableScatterMap<Object, Object> mutableScatterMap, K k) {
        Object obj = mutableScatterMap.get(k);
        return obj == null ? ObjectListKt.emptyObjectList() : obj instanceof MutableObjectList ? (ObjectList) obj : ObjectListKt.objectListOf(obj);
    }

    /* renamed from: hashCode-impl, reason: not valid java name */
    public static int m3559hashCodeimpl(MutableScatterMap<Object, Object> mutableScatterMap) {
        return mutableScatterMap.hashCode();
    }

    /* renamed from: isEmpty-impl, reason: not valid java name */
    public static final boolean m3560isEmptyimpl(MutableScatterMap<Object, Object> mutableScatterMap) {
        return mutableScatterMap.isEmpty();
    }

    /* renamed from: isNotEmpty-impl, reason: not valid java name */
    public static final boolean m3561isNotEmptyimpl(MutableScatterMap<Object, Object> mutableScatterMap) {
        return mutableScatterMap.isNotEmpty();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: removeFirst-impl, reason: not valid java name */
    public static final V m3562removeFirstimpl(MutableScatterMap<Object, Object> mutableScatterMap, K k) {
        V v10 = (V) mutableScatterMap.get(k);
        if (v10 == 0) {
            return null;
        }
        if (!(v10 instanceof MutableObjectList)) {
            mutableScatterMap.remove(k);
            return v10;
        }
        MutableObjectList mutableObjectList = (MutableObjectList) v10;
        V v11 = (V) mutableObjectList.removeAt(0);
        if (mutableObjectList.isEmpty()) {
            mutableScatterMap.remove(k);
        }
        if (mutableObjectList.getSize() == 1) {
            mutableScatterMap.set(k, mutableObjectList.first());
        }
        return v11;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: removeLast-impl, reason: not valid java name */
    public static final V m3563removeLastimpl(MutableScatterMap<Object, Object> mutableScatterMap, K k) {
        V v10 = (V) mutableScatterMap.get(k);
        if (v10 == 0) {
            return null;
        }
        if (!(v10 instanceof MutableObjectList)) {
            mutableScatterMap.remove(k);
            return v10;
        }
        MutableObjectList mutableObjectList = (MutableObjectList) v10;
        V v11 = (V) ExtensionsKt.removeLast(mutableObjectList);
        k.d(v11, "null cannot be cast to non-null type V of androidx.compose.runtime.collection.MultiValueMap");
        if (mutableObjectList.isEmpty()) {
            mutableScatterMap.remove(k);
        }
        if (mutableObjectList.getSize() == 1) {
            mutableScatterMap.set(k, mutableObjectList.first());
        }
        return v11;
    }

    /* renamed from: removeValueIf-impl, reason: not valid java name */
    public static final void m3564removeValueIfimpl(MutableScatterMap<Object, Object> mutableScatterMap, K k, S7.k kVar) {
        Object obj = mutableScatterMap.get(k);
        if (obj != null) {
            if (!(obj instanceof MutableObjectList)) {
                if (((Boolean) kVar.invoke(obj)).booleanValue()) {
                    mutableScatterMap.remove(k);
                    return;
                }
                return;
            }
            MutableObjectList mutableObjectList = (MutableObjectList) obj;
            int i = mutableObjectList._size;
            Object[] objArr = mutableObjectList.content;
            int i6 = 0;
            f fVarX = AbstractC1451a.X(0, i);
            int i10 = fVarX.f1569a;
            int i11 = fVarX.b;
            if (i10 <= i11) {
                while (true) {
                    objArr[i10 - i6] = objArr[i10];
                    if (((Boolean) kVar.invoke(objArr[i10])).booleanValue()) {
                        i6++;
                    }
                    if (i10 == i11) {
                        break;
                    } else {
                        i10++;
                    }
                }
            }
            q.f0(null, i - i6, objArr, i);
            mutableObjectList._size -= i6;
            if (mutableObjectList.isEmpty()) {
                mutableScatterMap.remove(k);
            }
            if (mutableObjectList.getSize() == 0) {
                mutableScatterMap.set(k, mutableObjectList.first());
            }
        }
    }

    /* renamed from: toString-impl, reason: not valid java name */
    public static String m3565toStringimpl(MutableScatterMap<Object, Object> mutableScatterMap) {
        return "MultiValueMap(map=" + mutableScatterMap + ')';
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0064  */
    /* renamed from: values-impl, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final androidx.collection.ObjectList<V> m3566valuesimpl(androidx.collection.MutableScatterMap<java.lang.Object, java.lang.Object> r14) {
        /*
            boolean r0 = r14.isEmpty()
            if (r0 == 0) goto Lb
            androidx.collection.ObjectList r14 = androidx.collection.ObjectListKt.emptyObjectList()
            return r14
        Lb:
            androidx.collection.MutableObjectList r0 = new androidx.collection.MutableObjectList
            r1 = 0
            r2 = 0
            r3 = 1
            r0.<init>(r2, r3, r1)
            java.lang.Object[] r1 = r14.values
            long[] r14 = r14.metadata
            int r3 = r14.length
            int r3 = r3 + (-2)
            if (r3 < 0) goto L69
            r4 = r2
        L1d:
            r5 = r14[r4]
            long r7 = ~r5
            r9 = 7
            long r7 = r7 << r9
            long r7 = r7 & r5
            r9 = -9187201950435737472(0x8080808080808080, double:-2.937446524422997E-306)
            long r7 = r7 & r9
            int r7 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r7 == 0) goto L64
            int r7 = r4 - r3
            int r7 = ~r7
            int r7 = r7 >>> 31
            r8 = 8
            int r7 = 8 - r7
            r9 = r2
        L37:
            if (r9 >= r7) goto L62
            r10 = 255(0xff, double:1.26E-321)
            long r10 = r10 & r5
            r12 = 128(0x80, double:6.3E-322)
            int r10 = (r10 > r12 ? 1 : (r10 == r12 ? 0 : -1))
            if (r10 >= 0) goto L5e
            int r10 = r4 << 3
            int r10 = r10 + r9
            r10 = r1[r10]
            boolean r11 = r10 instanceof androidx.collection.MutableObjectList
            if (r11 == 0) goto L56
            java.lang.String r11 = "null cannot be cast to non-null type androidx.collection.MutableObjectList<V of androidx.compose.runtime.collection.MultiValueMap>"
            kotlin.jvm.internal.k.d(r10, r11)
            androidx.collection.MutableObjectList r10 = (androidx.collection.MutableObjectList) r10
            r0.addAll(r10)
            goto L5e
        L56:
            java.lang.String r11 = "null cannot be cast to non-null type V of androidx.compose.runtime.collection.MultiValueMap"
            kotlin.jvm.internal.k.d(r10, r11)
            r0.add(r10)
        L5e:
            long r5 = r5 >> r8
            int r9 = r9 + 1
            goto L37
        L62:
            if (r7 != r8) goto L69
        L64:
            if (r4 == r3) goto L69
            int r4 = r4 + 1
            goto L1d
        L69:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.collection.MultiValueMap.m3566valuesimpl(androidx.collection.MutableScatterMap):androidx.collection.ObjectList");
    }

    public boolean equals(Object other) {
        return m3555equalsimpl(this.map, other);
    }

    public int hashCode() {
        return m3559hashCodeimpl(this.map);
    }

    public String toString() {
        return m3565toStringimpl(this.map);
    }

    /* renamed from: unbox-impl, reason: not valid java name and from getter */
    public final /* synthetic */ MutableScatterMap getMap() {
        return this.map;
    }
}
