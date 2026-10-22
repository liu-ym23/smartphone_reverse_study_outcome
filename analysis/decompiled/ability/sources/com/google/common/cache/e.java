package com.google.common.cache;

import androidx.collection.SieveCacheKt;
import androidx.constraintlayout.core.widgets.analyzer.BasicMeasure;
import com.google.common.cache.LocalCache$Strength;
import java.util.AbstractCollection;
import java.util.AbstractMap;
import java.util.AbstractQueue;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.logging.Logger;
import k3.AbstractC1622a;
import l3.C1658b;
import l3.InterfaceC1656A;
import l3.f;
import l3.g;
import l3.l;
import l3.r;
import l3.s;
import l3.y;
import l3.z;

/* loaded from: classes3.dex */
public final class e extends AbstractMap implements ConcurrentMap {
    public static final Logger u = Logger.getLogger(e.class.getName());

    /* renamed from: v, reason: collision with root package name */
    public static final f f2738v = new f();

    /* renamed from: w, reason: collision with root package name */
    public static final g f2739w = new g();

    /* renamed from: a, reason: collision with root package name */
    public final int f2740a;
    public final int b;
    public final LocalCache$Segment[] c;
    public final int d;
    public final com.google.common.base.a e;
    public final com.google.common.base.a f;
    public final LocalCache$Strength g;
    public final LocalCache$Strength h;
    public final long i;

    /* renamed from: j, reason: collision with root package name */
    public final InterfaceC1656A f2741j;
    public final long k;
    public final long l;
    public final AbstractQueue m;
    public final z n;
    public final k3.e o;
    public final LocalCache$EntryFactory p;

    /* renamed from: q, reason: collision with root package name */
    public final s6.e f2742q;

    /* renamed from: r, reason: collision with root package name */
    public l f2743r;

    /* renamed from: s, reason: collision with root package name */
    public s f2744s;

    /* renamed from: t, reason: collision with root package name */
    public l f2745t;

    /* JADX WARN: Type inference failed for: r1v0, types: [com.google.common.cache.e, java.util.AbstractMap] */
    public e(a aVar, s6.e eVar) {
        ?? abstractMap = new AbstractMap();
        int i = aVar.b;
        k3.c cVar = aVar.n;
        abstractMap.d = Math.min(i == -1 ? 4 : i, 65536);
        LocalCache$Strength localCache$Strength = aVar.f;
        LocalCache$Strength.AnonymousClass1 anonymousClass1 = LocalCache$Strength.f2732a;
        LocalCache$Strength localCache$Strength2 = (LocalCache$Strength) AbstractC1622a.g(localCache$Strength, anonymousClass1);
        abstractMap.g = localCache$Strength2;
        abstractMap.h = (LocalCache$Strength) AbstractC1622a.g(aVar.g, anonymousClass1);
        abstractMap.e = (com.google.common.base.a) AbstractC1622a.g(aVar.f2735j, ((LocalCache$Strength) AbstractC1622a.g(aVar.f, anonymousClass1)).a());
        abstractMap.f = (com.google.common.base.a) AbstractC1622a.g(aVar.k, ((LocalCache$Strength) AbstractC1622a.g(aVar.g, anonymousClass1)).a());
        long j5 = (aVar.h == 0 || aVar.i == 0) ? 0L : aVar.e == null ? aVar.c : aVar.d;
        abstractMap.i = j5;
        InterfaceC1656A interfaceC1656A = aVar.e;
        CacheBuilder$OneWeigher cacheBuilder$OneWeigher = CacheBuilder$OneWeigher.f2724a;
        InterfaceC1656A interfaceC1656A2 = (InterfaceC1656A) AbstractC1622a.g(interfaceC1656A, cacheBuilder$OneWeigher);
        abstractMap.f2741j = interfaceC1656A2;
        long j6 = aVar.i;
        abstractMap.k = j6 == -1 ? 0L : j6;
        long j10 = aVar.h;
        abstractMap.l = j10 != -1 ? j10 : 0L;
        z zVar = aVar.l;
        CacheBuilder$NullListener cacheBuilder$NullListener = CacheBuilder$NullListener.f2723a;
        z zVar2 = (z) AbstractC1622a.g(zVar, cacheBuilder$NullListener);
        abstractMap.n = zVar2;
        abstractMap.m = zVar2 == cacheBuilder$NullListener ? f2739w : new ConcurrentLinkedQueue();
        int i6 = 0;
        int i10 = 1;
        boolean z10 = abstractMap.e() || abstractMap.d();
        k3.e eVar2 = aVar.m;
        abstractMap.o = eVar2 == null ? z10 ? k3.e.f4794a : a.p : eVar2;
        abstractMap.p = LocalCache$EntryFactory.f2725a[((abstractMap.d() || abstractMap.b() || abstractMap.d()) ? (char) 1 : (char) 0) | (localCache$Strength2 != LocalCache$Strength.b ? (char) 0 : (char) 4) | (abstractMap.e() || abstractMap.e() ? 2 : 0)];
        abstractMap.f2742q = eVar;
        int iMin = Math.min(16, BasicMeasure.EXACTLY);
        if (abstractMap.b() && interfaceC1656A2 == cacheBuilder$OneWeigher) {
            iMin = (int) Math.min(iMin, j5);
        }
        int i11 = 0;
        int i12 = 1;
        while (i12 < abstractMap.d && (!abstractMap.b() || i12 * 20 <= abstractMap.i)) {
            i11++;
            i12 <<= 1;
        }
        abstractMap.b = 32 - i11;
        abstractMap.f2740a = i12 - 1;
        abstractMap.c = new LocalCache$Segment[i12];
        int i13 = iMin / i12;
        while (i10 < (i13 * i12 < iMin ? i13 + 1 : i13)) {
            i10 <<= 1;
        }
        if (abstractMap.b()) {
            long j11 = abstractMap.i;
            long j12 = i12;
            long j13 = (j11 / j12) + 1;
            long j14 = j11 % j12;
            while (true) {
                LocalCache$Segment[] localCache$SegmentArr = abstractMap.c;
                if (i6 >= localCache$SegmentArr.length) {
                    return;
                }
                if (i6 == j14) {
                    j13--;
                }
                long j15 = j13;
                localCache$SegmentArr[i6] = new LocalCache$Segment(abstractMap, i10, j15, (C1658b) cVar.get());
                i6++;
                j13 = j15;
            }
        } else {
            int i14 = i10;
            e eVar3 = abstractMap;
            while (true) {
                LocalCache$Segment[] localCache$SegmentArr2 = eVar3.c;
                if (i6 >= localCache$SegmentArr2.length) {
                    return;
                }
                localCache$SegmentArr2[i6] = new LocalCache$Segment(eVar3, i14, -1L, (C1658b) cVar.get());
                i6++;
                eVar3 = this;
            }
        }
    }

    public static ArrayList a(AbstractCollection abstractCollection) {
        ArrayList arrayList = new ArrayList(abstractCollection.size());
        Iterator it = abstractCollection.iterator();
        it.getClass();
        while (it.hasNext()) {
            arrayList.add(it.next());
        }
        return arrayList;
    }

    public final boolean b() {
        return this.i >= 0;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final void clear() {
        LocalCache$Strength.AnonymousClass1 anonymousClass1 = LocalCache$Strength.f2732a;
        for (LocalCache$Segment localCache$Segment : this.c) {
            if (localCache$Segment.b != 0) {
                localCache$Segment.lock();
                try {
                    localCache$Segment.o(localCache$Segment.f2730a.o.a());
                    AtomicReferenceArray atomicReferenceArray = localCache$Segment.f;
                    for (int i = 0; i < atomicReferenceArray.length(); i++) {
                        for (y next = (y) atomicReferenceArray.get(i); next != null; next = next.getNext()) {
                            if (next.d().isActive()) {
                                Object key = next.getKey();
                                Object obj = next.d().get();
                                RemovalCause removalCause = (key == null || obj == null) ? RemovalCause.c : RemovalCause.f2733a;
                                next.g();
                                localCache$Segment.d(key, obj, next.d().getWeight(), removalCause);
                            }
                        }
                    }
                    for (int i6 = 0; i6 < atomicReferenceArray.length(); i6++) {
                        atomicReferenceArray.set(i6, null);
                    }
                    e eVar = localCache$Segment.f2730a;
                    if (eVar.g != anonymousClass1) {
                        while (localCache$Segment.h.poll() != null) {
                        }
                    }
                    if (eVar.h != anonymousClass1) {
                        while (localCache$Segment.i.poll() != null) {
                        }
                    }
                    localCache$Segment.l.clear();
                    localCache$Segment.m.clear();
                    localCache$Segment.k.set(0);
                    localCache$Segment.d++;
                    localCache$Segment.b = 0;
                    localCache$Segment.unlock();
                    localCache$Segment.p();
                } catch (Throwable th) {
                    localCache$Segment.unlock();
                    localCache$Segment.p();
                    throw th;
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0040 A[DONT_GENERATE] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0044 A[Catch: all -> 0x0053, TRY_ENTER, TRY_LEAVE, TryCatch #0 {all -> 0x0053, blocks: (B:6:0x000f, B:8:0x0013, B:24:0x0044, B:11:0x0023, B:13:0x002b, B:16:0x0034, B:19:0x003a, B:20:0x003d, B:15:0x0031), top: B:35:0x000f, inners: #1 }] */
    @Override // java.util.AbstractMap, java.util.Map
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean containsKey(java.lang.Object r6) {
        /*
            r5 = this;
            r0 = 0
            if (r6 != 0) goto L4
            return r0
        L4:
            int r1 = r5.f(r6)
            com.google.common.cache.LocalCache$Segment r5 = r5.h(r1)
            r5.getClass()
            int r2 = r5.b     // Catch: java.lang.Throwable -> L53
            if (r2 == 0) goto L55
            com.google.common.cache.e r2 = r5.f2730a     // Catch: java.lang.Throwable -> L53
            k3.e r2 = r2.o     // Catch: java.lang.Throwable -> L53
            long r2 = r2.a()     // Catch: java.lang.Throwable -> L53
            l3.y r6 = r5.h(r1, r6)     // Catch: java.lang.Throwable -> L53
            r1 = 0
            if (r6 != 0) goto L23
            goto L37
        L23:
            com.google.common.cache.e r4 = r5.f2730a     // Catch: java.lang.Throwable -> L53
            boolean r4 = r4.g(r6, r2)     // Catch: java.lang.Throwable -> L53
            if (r4 == 0) goto L3e
            boolean r6 = r5.tryLock()     // Catch: java.lang.Throwable -> L53
            if (r6 == 0) goto L37
            r5.g(r2)     // Catch: java.lang.Throwable -> L39
            r5.unlock()     // Catch: java.lang.Throwable -> L53
        L37:
            r6 = r1
            goto L3e
        L39:
            r6 = move-exception
            r5.unlock()     // Catch: java.lang.Throwable -> L53
            throw r6     // Catch: java.lang.Throwable -> L53
        L3e:
            if (r6 != 0) goto L44
            r5.i()
            return r0
        L44:
            l3.r r6 = r6.d()     // Catch: java.lang.Throwable -> L53
            java.lang.Object r6 = r6.get()     // Catch: java.lang.Throwable -> L53
            if (r6 == 0) goto L4f
            r0 = 1
        L4f:
            r5.i()
            return r0
        L53:
            r6 = move-exception
            goto L59
        L55:
            r5.i()
            return r0
        L59:
            r5.i()
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.common.cache.e.containsKey(java.lang.Object):boolean");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0076  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0080 A[ADDED_TO_REGION, REMOVE, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r12v0 */
    /* JADX WARN: Type inference failed for: r12v1, types: [int] */
    /* JADX WARN: Type inference failed for: r12v3 */
    /* JADX WARN: Type inference failed for: r14v1, types: [java.util.concurrent.atomic.AtomicReferenceArray] */
    /* JADX WARN: Type inference failed for: r15v1, types: [int] */
    /* JADX WARN: Type inference failed for: r15v3 */
    /* JADX WARN: Type inference failed for: r15v4 */
    @Override // java.util.AbstractMap, java.util.Map
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean containsValue(java.lang.Object r21) {
        /*
            r20 = this;
            r0 = r20
            r1 = r21
            r2 = 0
            if (r1 != 0) goto L8
            return r2
        L8:
            k3.e r3 = r0.o
            long r3 = r3.a()
            com.google.common.cache.LocalCache$Segment[] r5 = r0.c
            r6 = -1
            r8 = r2
        L13:
            r9 = 3
            if (r8 >= r9) goto La9
            int r9 = r5.length
            r10 = 0
            r12 = r2
        L1a:
            if (r12 >= r9) goto L97
            r13 = r5[r12]
            int r14 = r13.b
            java.util.concurrent.atomic.AtomicReferenceArray r14 = r13.f
            r15 = r2
            r16 = r15
        L25:
            int r2 = r14.length()
            if (r15 >= r2) goto L8c
            java.lang.Object r2 = r14.get(r15)
            l3.y r2 = (l3.y) r2
        L31:
            if (r2 == 0) goto L87
            r13.getClass()
            java.lang.Object r17 = r2.getKey()
            r18 = 0
            if (r17 != 0) goto L46
            r13.r()
        L41:
            r19 = r5
        L43:
            r5 = r18
            goto L72
        L46:
            l3.r r17 = r2.d()
            java.lang.Object r17 = r17.get()
            if (r17 != 0) goto L54
            r13.r()
            goto L41
        L54:
            r19 = r5
            com.google.common.cache.e r5 = r13.f2730a
            boolean r5 = r5.g(r2, r3)
            if (r5 == 0) goto L70
            boolean r5 = r13.tryLock()
            if (r5 == 0) goto L43
            r13.g(r3)     // Catch: java.lang.Throwable -> L6b
            r13.unlock()
            goto L43
        L6b:
            r0 = move-exception
            r13.unlock()
            throw r0
        L70:
            r5 = r17
        L72:
            r17 = r2
            if (r5 == 0) goto L80
            com.google.common.base.a r2 = r0.f
            boolean r2 = r2.d(r1, r5)
            if (r2 == 0) goto L80
            r0 = 1
            return r0
        L80:
            l3.y r2 = r17.getNext()
            r5 = r19
            goto L31
        L87:
            r19 = r5
            int r15 = r15 + 1
            goto L25
        L8c:
            r19 = r5
            int r2 = r13.d
            long r13 = (long) r2
            long r10 = r10 + r13
            int r12 = r12 + 1
            r2 = r16
            goto L1a
        L97:
            r16 = r2
            r19 = r5
            int r2 = (r10 > r6 ? 1 : (r10 == r6 ? 0 : -1))
            if (r2 != 0) goto La0
            goto Lab
        La0:
            int r8 = r8 + 1
            r6 = r10
            r2 = r16
            r5 = r19
            goto L13
        La9:
            r16 = r2
        Lab:
            return r16
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.common.cache.e.containsValue(java.lang.Object):boolean");
    }

    public final boolean d() {
        return this.k > 0;
    }

    public final boolean e() {
        return this.l > 0;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Set entrySet() {
        l lVar = this.f2745t;
        if (lVar != null) {
            return lVar;
        }
        l lVar2 = new l(this, 0);
        this.f2745t = lVar2;
        return lVar2;
    }

    public final int f(Object obj) {
        int iB;
        com.google.common.base.a aVar = this.e;
        if (obj == null) {
            aVar.getClass();
            iB = 0;
        } else {
            iB = aVar.b(obj);
        }
        int i = iB + ((iB << 15) ^ (-12931));
        int i6 = i ^ (i >>> 10);
        int i10 = i6 + (i6 << 3);
        int i11 = i10 ^ (i10 >>> 6);
        int i12 = (i11 << 2) + (i11 << 14) + i11;
        return (i12 >>> 16) ^ i12;
    }

    public final boolean g(y yVar, long j5) {
        yVar.getClass();
        if (!d() || j5 - yVar.l() < this.k) {
            return e() && j5 - yVar.h() >= this.l;
        }
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x003f A[DONT_GENERATE] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0043 A[Catch: all -> 0x006b, TRY_ENTER, TryCatch #1 {all -> 0x006b, blocks: (B:6:0x000f, B:8:0x0013, B:24:0x0043, B:26:0x004d, B:28:0x0055, B:29:0x0058, B:34:0x006d, B:11:0x0022, B:13:0x002a, B:16:0x0033, B:19:0x0039, B:20:0x003c, B:15:0x0030), top: B:41:0x000f, inners: #0 }] */
    @Override // java.util.AbstractMap, java.util.Map
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object get(java.lang.Object r5) {
        /*
            r4 = this;
            r0 = 0
            if (r5 != 0) goto L4
            return r0
        L4:
            int r1 = r4.f(r5)
            com.google.common.cache.LocalCache$Segment r4 = r4.h(r1)
            r4.getClass()
            int r2 = r4.b     // Catch: java.lang.Throwable -> L6b
            if (r2 == 0) goto L70
            com.google.common.cache.e r2 = r4.f2730a     // Catch: java.lang.Throwable -> L6b
            k3.e r2 = r2.o     // Catch: java.lang.Throwable -> L6b
            long r2 = r2.a()     // Catch: java.lang.Throwable -> L6b
            l3.y r5 = r4.h(r1, r5)     // Catch: java.lang.Throwable -> L6b
            if (r5 != 0) goto L22
            goto L36
        L22:
            com.google.common.cache.e r1 = r4.f2730a     // Catch: java.lang.Throwable -> L6b
            boolean r1 = r1.g(r5, r2)     // Catch: java.lang.Throwable -> L6b
            if (r1 == 0) goto L3d
            boolean r5 = r4.tryLock()     // Catch: java.lang.Throwable -> L6b
            if (r5 == 0) goto L36
            r4.g(r2)     // Catch: java.lang.Throwable -> L38
            r4.unlock()     // Catch: java.lang.Throwable -> L6b
        L36:
            r5 = r0
            goto L3d
        L38:
            r5 = move-exception
            r4.unlock()     // Catch: java.lang.Throwable -> L6b
            throw r5     // Catch: java.lang.Throwable -> L6b
        L3d:
            if (r5 != 0) goto L43
            r4.i()
            return r0
        L43:
            l3.r r1 = r5.d()     // Catch: java.lang.Throwable -> L6b
            java.lang.Object r1 = r1.get()     // Catch: java.lang.Throwable -> L6b
            if (r1 == 0) goto L6d
            com.google.common.cache.e r0 = r4.f2730a     // Catch: java.lang.Throwable -> L6b
            boolean r0 = r0.d()     // Catch: java.lang.Throwable -> L6b
            if (r0 == 0) goto L58
            r5.j(r2)     // Catch: java.lang.Throwable -> L6b
        L58:
            java.util.AbstractQueue r0 = r4.f2731j     // Catch: java.lang.Throwable -> L6b
            r0.add(r5)     // Catch: java.lang.Throwable -> L6b
            r5.getKey()     // Catch: java.lang.Throwable -> L6b
            com.google.common.cache.e r5 = r4.f2730a     // Catch: java.lang.Throwable -> L6b
            s6.e r0 = r5.f2742q     // Catch: java.lang.Throwable -> L6b
            r5.getClass()     // Catch: java.lang.Throwable -> L6b
            r4.i()
            return r1
        L6b:
            r5 = move-exception
            goto L74
        L6d:
            r4.r()     // Catch: java.lang.Throwable -> L6b
        L70:
            r4.i()
            return r0
        L74:
            r4.i()
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.common.cache.e.get(java.lang.Object):java.lang.Object");
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    public final Object getOrDefault(Object obj, Object obj2) {
        Object obj3 = get(obj);
        return obj3 != null ? obj3 : obj2;
    }

    public final LocalCache$Segment h(int i) {
        return this.c[(i >>> this.b) & this.f2740a];
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final boolean isEmpty() {
        LocalCache$Segment[] localCache$SegmentArr = this.c;
        long j5 = 0;
        for (LocalCache$Segment localCache$Segment : localCache$SegmentArr) {
            if (localCache$Segment.b != 0) {
                return false;
            }
            j5 += r7.d;
        }
        if (j5 == 0) {
            return true;
        }
        for (LocalCache$Segment localCache$Segment2 : localCache$SegmentArr) {
            if (localCache$Segment2.b != 0) {
                return false;
            }
            j5 -= r8.d;
        }
        return j5 == 0;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Set keySet() {
        l lVar = this.f2743r;
        if (lVar != null) {
            return lVar;
        }
        l lVar2 = new l(this, 1);
        this.f2743r = lVar2;
        return lVar2;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Object put(Object obj, Object obj2) {
        obj.getClass();
        obj2.getClass();
        int iF = f(obj);
        return h(iF).j(iF, obj, false, obj2);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final void putAll(Map map) {
        for (Map.Entry entry : map.entrySet()) {
            put(entry.getKey(), entry.getValue());
        }
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    public final Object putIfAbsent(Object obj, Object obj2) {
        obj.getClass();
        obj2.getClass();
        int iF = f(obj);
        return h(iF).j(iF, obj, true, obj2);
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0043, code lost:
    
        r7 = r4.d();
        r6 = r7.get();
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x004b, code lost:
    
        if (r6 == null) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x004d, code lost:
    
        r11 = com.google.common.cache.RemovalCause.f2733a;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x004f, code lost:
    
        r8 = r11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0058, code lost:
    
        if (r7.isActive() == false) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x005a, code lost:
    
        r11 = com.google.common.cache.RemovalCause.c;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x005d, code lost:
    
        r2.d++;
        r11 = r2.n(r3, r4, r5, r6, r7, r8);
        r0 = r2.b - 1;
        r10.set(r9, r11);
        r2.b = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0070, code lost:
    
        r2.unlock();
        r2.p();
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0076, code lost:
    
        return r6;
     */
    @Override // java.util.AbstractMap, java.util.Map
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object remove(java.lang.Object r11) {
        /*
            r10 = this;
            r0 = 0
            if (r11 != 0) goto L4
            return r0
        L4:
            int r1 = r10.f(r11)
            com.google.common.cache.LocalCache$Segment r2 = r10.h(r1)
            r2.lock()
            com.google.common.cache.e r10 = r2.f2730a     // Catch: java.lang.Throwable -> L51
            k3.e r10 = r10.o     // Catch: java.lang.Throwable -> L51
            long r3 = r10.a()     // Catch: java.lang.Throwable -> L51
            r2.o(r3)     // Catch: java.lang.Throwable -> L51
            java.util.concurrent.atomic.AtomicReferenceArray r10 = r2.f     // Catch: java.lang.Throwable -> L51
            int r3 = r10.length()     // Catch: java.lang.Throwable -> L51
            int r3 = r3 + (-1)
            r9 = r1 & r3
            java.lang.Object r3 = r10.get(r9)     // Catch: java.lang.Throwable -> L51
            l3.y r3 = (l3.y) r3     // Catch: java.lang.Throwable -> L51
            r4 = r3
        L2b:
            if (r4 == 0) goto L77
            java.lang.Object r5 = r4.getKey()     // Catch: java.lang.Throwable -> L51
            int r6 = r4.g()     // Catch: java.lang.Throwable -> L51
            if (r6 != r1) goto L7e
            if (r5 == 0) goto L7e
            com.google.common.cache.e r6 = r2.f2730a     // Catch: java.lang.Throwable -> L51
            com.google.common.base.a r6 = r6.e     // Catch: java.lang.Throwable -> L51
            boolean r6 = r6.d(r11, r5)     // Catch: java.lang.Throwable -> L51
            if (r6 == 0) goto L7e
            l3.r r7 = r4.d()     // Catch: java.lang.Throwable -> L51
            java.lang.Object r6 = r7.get()     // Catch: java.lang.Throwable -> L51
            if (r6 == 0) goto L54
            com.google.common.cache.RemovalCause r11 = com.google.common.cache.RemovalCause.f2733a     // Catch: java.lang.Throwable -> L51
        L4f:
            r8 = r11
            goto L5d
        L51:
            r0 = move-exception
            r10 = r0
            goto L83
        L54:
            boolean r11 = r7.isActive()     // Catch: java.lang.Throwable -> L51
            if (r11 == 0) goto L77
            com.google.common.cache.RemovalCause r11 = com.google.common.cache.RemovalCause.c     // Catch: java.lang.Throwable -> L51
            goto L4f
        L5d:
            int r11 = r2.d     // Catch: java.lang.Throwable -> L51
            int r11 = r11 + 1
            r2.d = r11     // Catch: java.lang.Throwable -> L51
            l3.y r11 = r2.n(r3, r4, r5, r6, r7, r8)     // Catch: java.lang.Throwable -> L51
            int r0 = r2.b     // Catch: java.lang.Throwable -> L51
            int r0 = r0 + (-1)
            r10.set(r9, r11)     // Catch: java.lang.Throwable -> L51
            r2.b = r0     // Catch: java.lang.Throwable -> L51
            r2.unlock()
            r2.p()
            return r6
        L77:
            r2.unlock()
            r2.p()
            return r0
        L7e:
            l3.y r4 = r4.getNext()     // Catch: java.lang.Throwable -> L51
            goto L2b
        L83:
            r2.unlock()
            r2.p()
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.common.cache.e.remove(java.lang.Object):java.lang.Object");
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0078, code lost:
    
        return null;
     */
    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object replace(java.lang.Object r13, java.lang.Object r14) {
        /*
            r12 = this;
            r13.getClass()
            r14.getClass()
            int r0 = r12.f(r13)
            com.google.common.cache.LocalCache$Segment r1 = r12.h(r0)
            r1.lock()
            com.google.common.cache.e r12 = r1.f2730a     // Catch: java.lang.Throwable -> L6f
            k3.e r12 = r12.o     // Catch: java.lang.Throwable -> L6f
            long r2 = r12.a()     // Catch: java.lang.Throwable -> L6f
            r1.o(r2)     // Catch: java.lang.Throwable -> L6f
            java.util.concurrent.atomic.AtomicReferenceArray r12 = r1.f     // Catch: java.lang.Throwable -> L6f
            int r4 = r12.length()     // Catch: java.lang.Throwable -> L6f
            int r4 = r4 + (-1)
            r8 = r0 & r4
            java.lang.Object r4 = r12.get(r8)     // Catch: java.lang.Throwable -> L6f
            l3.y r4 = (l3.y) r4     // Catch: java.lang.Throwable -> L6f
            r5 = r2
            r3 = r4
        L2e:
            r9 = 0
            if (r3 == 0) goto L72
            r2 = r4
            java.lang.Object r4 = r3.getKey()     // Catch: java.lang.Throwable -> L6f
            int r7 = r3.g()     // Catch: java.lang.Throwable -> L6f
            if (r7 != r0) goto L95
            if (r4 == 0) goto L95
            com.google.common.cache.e r7 = r1.f2730a     // Catch: java.lang.Throwable -> L6f
            com.google.common.base.a r7 = r7.e     // Catch: java.lang.Throwable -> L6f
            boolean r7 = r7.d(r13, r4)     // Catch: java.lang.Throwable -> L6f
            if (r7 == 0) goto L95
            r10 = r5
            l3.r r6 = r3.d()     // Catch: java.lang.Throwable -> L6f
            java.lang.Object r5 = r6.get()     // Catch: java.lang.Throwable -> L6f
            if (r5 != 0) goto L79
            boolean r13 = r6.isActive()     // Catch: java.lang.Throwable -> L6f
            if (r13 == 0) goto L72
            int r13 = r1.d     // Catch: java.lang.Throwable -> L6f
            int r13 = r13 + 1
            r1.d = r13     // Catch: java.lang.Throwable -> L6f
            com.google.common.cache.RemovalCause r7 = com.google.common.cache.RemovalCause.c     // Catch: java.lang.Throwable -> L6f
            l3.y r13 = r1.n(r2, r3, r4, r5, r6, r7)     // Catch: java.lang.Throwable -> L6f
            int r14 = r1.b     // Catch: java.lang.Throwable -> L6f
            int r14 = r14 + (-1)
            r12.set(r8, r13)     // Catch: java.lang.Throwable -> L6f
            r1.b = r14     // Catch: java.lang.Throwable -> L6f
            goto L72
        L6f:
            r0 = move-exception
            r12 = r0
            goto L9d
        L72:
            r1.unlock()
            r1.p()
            return r9
        L79:
            int r12 = r1.d     // Catch: java.lang.Throwable -> L6f
            int r12 = r12 + 1
            r1.d = r12     // Catch: java.lang.Throwable -> L6f
            int r12 = r6.getWeight()     // Catch: java.lang.Throwable -> L6f
            com.google.common.cache.RemovalCause r0 = com.google.common.cache.RemovalCause.b     // Catch: java.lang.Throwable -> L6f
            r1.d(r13, r5, r12, r0)     // Catch: java.lang.Throwable -> L6f
            r1.q(r3, r14, r10)     // Catch: java.lang.Throwable -> L6f
            r1.e(r3)     // Catch: java.lang.Throwable -> L6f
            r1.unlock()
            r1.p()
            return r5
        L95:
            r10 = r5
            l3.y r3 = r3.getNext()     // Catch: java.lang.Throwable -> L6f
            r4 = r2
            r5 = r10
            goto L2e
        L9d:
            r1.unlock()
            r1.p()
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.common.cache.e.replace(java.lang.Object, java.lang.Object):java.lang.Object");
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final int size() {
        long jMax = 0;
        for (int i = 0; i < this.c.length; i++) {
            jMax += Math.max(0, r7[i].b);
        }
        if (jMax > SieveCacheKt.NodeLinkMask) {
            return Integer.MAX_VALUE;
        }
        if (jMax < SieveCacheKt.NodeMetaAndPreviousMask) {
            return Integer.MIN_VALUE;
        }
        return (int) jMax;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Collection values() {
        s sVar = this.f2744s;
        if (sVar != null) {
            return sVar;
        }
        s sVar2 = new s(this);
        this.f2744s = sVar2;
        return sVar2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0048, code lost:
    
        r7 = r4.d();
        r6 = r7.get();
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0058, code lost:
    
        if (r2.f2730a.f.d(r14, r6) == false) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x005a, code lost:
    
        r8 = r12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x005c, code lost:
    
        if (r6 != null) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0062, code lost:
    
        if (r7.isActive() == false) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0064, code lost:
    
        r8 = com.google.common.cache.RemovalCause.c;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0067, code lost:
    
        r2.d++;
        r13 = r2.n(r3, r4, r5, r6, r7, r8);
        r14 = r2.b - 1;
        r9.set(r11, r13);
        r2.b = r14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0078, code lost:
    
        if (r8 != r12) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x007a, code lost:
    
        r0 = true;
     */
    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean remove(java.lang.Object r13, java.lang.Object r14) {
        /*
            r12 = this;
            r0 = 0
            if (r13 == 0) goto L91
            if (r14 != 0) goto L7
            goto L91
        L7:
            int r1 = r12.f(r13)
            com.google.common.cache.LocalCache$Segment r2 = r12.h(r1)
            com.google.common.cache.RemovalCause r12 = com.google.common.cache.RemovalCause.f2733a
            r2.lock()
            com.google.common.cache.e r3 = r2.f2730a     // Catch: java.lang.Throwable -> L82
            k3.e r3 = r3.o     // Catch: java.lang.Throwable -> L82
            long r3 = r3.a()     // Catch: java.lang.Throwable -> L82
            r2.o(r3)     // Catch: java.lang.Throwable -> L82
            java.util.concurrent.atomic.AtomicReferenceArray r9 = r2.f     // Catch: java.lang.Throwable -> L82
            int r3 = r9.length()     // Catch: java.lang.Throwable -> L82
            r10 = 1
            int r3 = r3 - r10
            r11 = r1 & r3
            java.lang.Object r3 = r9.get(r11)     // Catch: java.lang.Throwable -> L82
            l3.y r3 = (l3.y) r3     // Catch: java.lang.Throwable -> L82
            r4 = r3
        L30:
            if (r4 == 0) goto L7b
            java.lang.Object r5 = r4.getKey()     // Catch: java.lang.Throwable -> L82
            int r6 = r4.g()     // Catch: java.lang.Throwable -> L82
            if (r6 != r1) goto L85
            if (r5 == 0) goto L85
            com.google.common.cache.e r6 = r2.f2730a     // Catch: java.lang.Throwable -> L82
            com.google.common.base.a r6 = r6.e     // Catch: java.lang.Throwable -> L82
            boolean r6 = r6.d(r13, r5)     // Catch: java.lang.Throwable -> L82
            if (r6 == 0) goto L85
            l3.r r7 = r4.d()     // Catch: java.lang.Throwable -> L82
            java.lang.Object r6 = r7.get()     // Catch: java.lang.Throwable -> L82
            com.google.common.cache.e r13 = r2.f2730a     // Catch: java.lang.Throwable -> L82
            com.google.common.base.a r13 = r13.f     // Catch: java.lang.Throwable -> L82
            boolean r13 = r13.d(r14, r6)     // Catch: java.lang.Throwable -> L82
            if (r13 == 0) goto L5c
            r8 = r12
            goto L67
        L5c:
            if (r6 != 0) goto L7b
            boolean r13 = r7.isActive()     // Catch: java.lang.Throwable -> L82
            if (r13 == 0) goto L7b
            com.google.common.cache.RemovalCause r13 = com.google.common.cache.RemovalCause.c     // Catch: java.lang.Throwable -> L82
            r8 = r13
        L67:
            int r13 = r2.d     // Catch: java.lang.Throwable -> L82
            int r13 = r13 + r10
            r2.d = r13     // Catch: java.lang.Throwable -> L82
            l3.y r13 = r2.n(r3, r4, r5, r6, r7, r8)     // Catch: java.lang.Throwable -> L82
            int r14 = r2.b     // Catch: java.lang.Throwable -> L82
            int r14 = r14 - r10
            r9.set(r11, r13)     // Catch: java.lang.Throwable -> L82
            r2.b = r14     // Catch: java.lang.Throwable -> L82
            if (r8 != r12) goto L7b
            r0 = r10
        L7b:
            r2.unlock()
            r2.p()
            return r0
        L82:
            r0 = move-exception
            r12 = r0
            goto L8a
        L85:
            l3.y r4 = r4.getNext()     // Catch: java.lang.Throwable -> L82
            goto L30
        L8a:
            r2.unlock()
            r2.p()
            throw r12
        L91:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.common.cache.e.remove(java.lang.Object, java.lang.Object):boolean");
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    public final boolean replace(Object obj, Object obj2, Object obj3) {
        obj.getClass();
        obj3.getClass();
        if (obj2 == null) {
            return false;
        }
        int iF = f(obj);
        LocalCache$Segment localCache$SegmentH = h(iF);
        localCache$SegmentH.lock();
        try {
            long jA = localCache$SegmentH.f2730a.o.a();
            localCache$SegmentH.o(jA);
            AtomicReferenceArray atomicReferenceArray = localCache$SegmentH.f;
            int length = iF & (atomicReferenceArray.length() - 1);
            y yVar = (y) atomicReferenceArray.get(length);
            long j5 = jA;
            y next = yVar;
            while (true) {
                if (next == null) {
                    break;
                }
                y yVar2 = yVar;
                Object key = next.getKey();
                if (next.g() == iF && key != null && localCache$SegmentH.f2730a.e.d(obj, key)) {
                    long j6 = j5;
                    r rVarD = next.d();
                    Object obj4 = rVarD.get();
                    if (obj4 == null) {
                        if (rVarD.isActive()) {
                            localCache$SegmentH.d++;
                            y yVarN = localCache$SegmentH.n(yVar2, next, key, obj4, rVarD, RemovalCause.c);
                            int i = localCache$SegmentH.b - 1;
                            atomicReferenceArray.set(length, yVarN);
                            localCache$SegmentH.b = i;
                        }
                    } else {
                        if (localCache$SegmentH.f2730a.f.d(obj2, obj4)) {
                            localCache$SegmentH.d++;
                            localCache$SegmentH.d(obj, obj4, rVarD.getWeight(), RemovalCause.b);
                            localCache$SegmentH.q(next, obj3, j6);
                            localCache$SegmentH.e(next);
                            return true;
                        }
                        localCache$SegmentH.k(next, j6);
                    }
                } else {
                    yVar = yVar2;
                    long j10 = j5;
                    next = next.getNext();
                    j5 = j10;
                }
            }
            return false;
        } finally {
            localCache$SegmentH.unlock();
            localCache$SegmentH.p();
        }
    }
}
