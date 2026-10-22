package com.stepos.ailauncher.task.common;

import La.H;
import P6.BatchQueryStorageObjectResponse;
import P6.StorageObjectDetail;
import Ua.C1056g;
import Ua.C1060i;
import Ua.L0;
import Ua.M;
import Ua.Y;
import Y8.t;
import Z8.C1173v;
import Z8.C1174w;
import Z8.F;
import Z8.Q;
import com.stepos.ailauncher.contract.model.ArtifactAvailability;
import com.stepos.ailauncher.task.common.a;
import com.stepos.common.utils.filestorage.FileStorageManager;
import com.stepos.common.utils.filestorage.exceptions.FileStorageException;
import e9.InterfaceC4014c;
import f9.C4063a;
import h8.C4148a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlin.jvm.internal.p;
import p9.InterfaceC5074l;
import q4.C5148a;
import v9.C5685n;
import w4.ArtifactAvailabilityRow;

@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J;\u0010\f\u001a\u00020\n2\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u001e\u0010\u000b\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\t0\b\u0012\u0004\u0012\u00020\n0\u0007¢\u0006\u0004\b\f\u0010\rJ;\u0010\u000e\u001a\u00020\n2\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u001e\u0010\u000b\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\t0\b\u0012\u0004\u0012\u00020\n0\u0007¢\u0006\u0004\b\u000e\u0010\rJ'\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\t0\b2\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\u000f\u0010\u0010J=\u0010\u0013\u001a\u00020\n2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u001e\u0010\u0012\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\t0\b\u0012\u0004\u0012\u00020\n0\u0007H\u0002¢\u0006\u0004\b\u0013\u0010\rJ\u0010\u0010\u0014\u001a\u00020\nH\u0082@¢\u0006\u0004\b\u0014\u0010\u0015J)\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\t0\b2\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0002¢\u0006\u0004\b\u0016\u0010\u0010J!\u0010\u001b\u001a\u00020\t2\b\u0010\u0018\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u001a\u001a\u00020\u0019H\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ=\u0010\u001e\u001a\u00020\n2\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u001e\u0010\u001d\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\t0\b\u0012\u0004\u0012\u00020\n0\u0007H\u0002¢\u0006\u0004\b\u001e\u0010\rJ$\u0010 \u001a\u00020\n2\u0012\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\t0\bH\u0082@¢\u0006\u0004\b \u0010!J\u0013\u0010$\u001a\u00020#*\u00020\"H\u0002¢\u0006\u0004\b$\u0010%J\u000f\u0010&\u001a\u00020\nH\u0002¢\u0006\u0004\b&\u0010\u0003R\u0014\u0010'\u001a\u00020\u00058\u0002X\u0082T¢\u0006\u0006\n\u0004\b'\u0010(R\u0014\u0010)\u001a\u00020\u00198\u0002X\u0082T¢\u0006\u0006\n\u0004\b)\u0010*R\u0014\u0010+\u001a\u00020\u00198\u0002X\u0082T¢\u0006\u0006\n\u0004\b+\u0010*R\u0014\u0010-\u001a\u00020,8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b-\u0010.R\u0014\u0010/\u001a\u00020\u00018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b/\u00100R$\u00103\u001a\u0012\u0012\u0004\u0012\u00020\u000501j\b\u0012\u0004\u0012\u00020\u0005`28\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b3\u00104R2\u00106\u001a \u0012\u001c\u0012\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\t0\b\u0012\u0004\u0012\u00020\n0\u0007058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b6\u00107R\u0018\u00109\u001a\u0004\u0018\u0001088\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b9\u0010:¨\u0006;"}, d2 = {"Lcom/stepos/ailauncher/task/common/ArtifactAvailabilityStore;", "", "<init>", "()V", "", "", "fileIds", "Lkotlin/Function1;", "", "Lcom/stepos/ailauncher/contract/model/ArtifactAvailability;", "LY8/t;", "onResult", "t", "(Ljava/util/List;Lp9/l;)V", "r", "v", "(Ljava/util/List;)Ljava/util/Map;", "needQuery", "waiter", "k", "o", "(Le9/c;)Ljava/lang/Object;", "u", "Lw4/b;", "row", "", "now", "w", "(Lw4/b;J)Lcom/stepos/ailauncher/contract/model/ArtifactAvailability;", "onDone", "l", "mapped", "s", "(Ljava/util/Map;Le9/c;)Ljava/lang/Object;", "LP6/i;", "Lcom/stepos/ailauncher/task/common/a$a;", "x", "(LP6/i;)Lcom/stepos/ailauncher/task/common/a$a;", "q", "TAG", "Ljava/lang/String;", "TTL_MS", "J", "BATCH_DEBOUNCE_MS", "LUa/M;", "scope", "LUa/M;", "pendingLock", "Ljava/lang/Object;", "Ljava/util/LinkedHashSet;", "Lkotlin/collections/LinkedHashSet;", "pendingIds", "Ljava/util/LinkedHashSet;", "", "pendingWaiters", "Ljava/util/List;", "Lkotlinx/coroutines/g;", "flushJob", "Lkotlinx/coroutines/g;", "task_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ArtifactAvailabilityStore {
    private static final long BATCH_DEBOUNCE_MS = 64;
    private static final String TAG = "ArtifactAvailabilityStore";
    private static final long TTL_MS = 900000;
    private static kotlinx.coroutines.g flushJob;
    public static final ArtifactAvailabilityStore INSTANCE = new ArtifactAvailabilityStore();
    private static final M scope = kotlinx.coroutines.d.a(L0.b(null, 1, null).plus(Y.b()));
    private static final Object pendingLock = new Object();
    private static final LinkedHashSet<String> pendingIds = new LinkedHashSet<>();
    private static final List<InterfaceC5074l<Map<String, ? extends ArtifactAvailability>, t>> pendingWaiters = new ArrayList();

    public static final t m(List list, InterfaceC5074l interfaceC5074l, BatchQueryStorageObjectResponse resp) {
        p.i(resp, "resp");
        C1060i.d(scope, null, null, new ArtifactAvailabilityStore$fetchAndPersist$1$1(resp, list, interfaceC5074l, null), 3, null);
        return t.f7040a;
    }

    public static final t n(List list, InterfaceC5074l interfaceC5074l, Throwable e10) {
        p.i(e10, "e");
        C4148a.t(TAG, "batchGetObjectDetails failed count=" + list.size(), e10, false, 8, null);
        List list2 = list;
        LinkedHashMap linkedHashMap = new LinkedHashMap(C5685n.f(Q.e(C1174w.x(list2, 10)), 16));
        for (Object obj : list2) {
            linkedHashMap.put(obj, ArtifactAvailability.UNKNOWN);
        }
        C1060i.d(scope, Y.c().getImmediate(), null, new ArtifactAvailabilityStore$fetchAndPersist$lambda$1$$inlined$dispatchMain$1(null, interfaceC5074l, linkedHashMap), 2, null);
        return t.f7040a;
    }

    public static final t p(Ref$ObjectRef ref$ObjectRef, Map fetched) {
        p.i(fetched, "fetched");
        Iterator it = ((Iterable) ref$ObjectRef.f34820a).iterator();
        while (it.hasNext()) {
            ((InterfaceC5074l) it.next()).invoke(fetched);
        }
        return t.f7040a;
    }

    public final void k(List<String> needQuery, InterfaceC5074l<? super Map<String, ? extends ArtifactAvailability>, t> waiter) {
        synchronized (pendingLock) {
            pendingIds.addAll(needQuery);
            pendingWaiters.add(waiter);
            kotlinx.coroutines.g gVar = flushJob;
            if (gVar == null || !gVar.b()) {
                flushJob = C1060i.d(scope, null, null, new ArtifactAvailabilityStore$enqueue$1$1(null), 3, null);
                t tVar = t.f7040a;
            }
        }
    }

    public final void l(final List<String> fileIds, final InterfaceC5074l<? super Map<String, ? extends ArtifactAvailability>, t> onDone) throws FileStorageException.NotInitialized {
        FileStorageManager.INSTANCE.d(fileIds, new InterfaceC5074l() { // from class: com.stepos.ailauncher.task.common.c
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return ArtifactAvailabilityStore.m(fileIds, onDone, (BatchQueryStorageObjectResponse) obj);
            }
        }, new InterfaceC5074l() { // from class: com.stepos.ailauncher.task.common.d
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return ArtifactAvailabilityStore.n(fileIds, onDone, (Throwable) obj);
            }
        });
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Type inference failed for: r4v2, types: [T, java.util.List] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object o(e9.InterfaceC4014c<? super Y8.t> r7) throws java.lang.Throwable {
        /*
            r6 = this;
            boolean r0 = r7 instanceof com.stepos.ailauncher.task.common.ArtifactAvailabilityStore$flushPending$1
            if (r0 == 0) goto L13
            r0 = r7
            com.stepos.ailauncher.task.common.ArtifactAvailabilityStore$flushPending$1 r0 = (com.stepos.ailauncher.task.common.ArtifactAvailabilityStore$flushPending$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.stepos.ailauncher.task.common.ArtifactAvailabilityStore$flushPending$1 r0 = new com.stepos.ailauncher.task.common.ArtifactAvailabilityStore$flushPending$1
            r0.<init>(r6, r7)
        L18:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = f9.C4063a.g()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 != r3) goto L29
            kotlin.C4849c.b(r7)
            goto L3f
        L29:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L31:
            kotlin.C4849c.b(r7)
            r0.label = r3
            r2 = 64
            java.lang.Object r7 = Ua.U.a(r2, r0)
            if (r7 != r1) goto L3f
            return r1
        L3f:
            kotlin.jvm.internal.Ref$ObjectRef r7 = new kotlin.jvm.internal.Ref$ObjectRef
            r7.<init>()
            java.lang.Object r0 = com.stepos.ailauncher.task.common.ArtifactAvailabilityStore.pendingLock
            monitor-enter(r0)
            java.util.LinkedHashSet<java.lang.String> r1 = com.stepos.ailauncher.task.common.ArtifactAvailabilityStore.pendingIds     // Catch: java.lang.Throwable -> L94
            java.util.List r2 = Z8.F.m1(r1)     // Catch: java.lang.Throwable -> L94
            java.util.List<p9.l<java.util.Map<java.lang.String, ? extends com.stepos.ailauncher.contract.model.ArtifactAvailability>, Y8.t>> r3 = com.stepos.ailauncher.task.common.ArtifactAvailabilityStore.pendingWaiters     // Catch: java.lang.Throwable -> L94
            r4 = r3
            java.lang.Iterable r4 = (java.lang.Iterable) r4     // Catch: java.lang.Throwable -> L94
            java.util.List r4 = Z8.F.m1(r4)     // Catch: java.lang.Throwable -> L94
            r7.f34820a = r4     // Catch: java.lang.Throwable -> L94
            r1.clear()     // Catch: java.lang.Throwable -> L94
            r3.clear()     // Catch: java.lang.Throwable -> L94
            r1 = 0
            com.stepos.ailauncher.task.common.ArtifactAvailabilityStore.flushJob = r1     // Catch: java.lang.Throwable -> L94
            Y8.t r3 = Y8.t.f7040a     // Catch: java.lang.Throwable -> L94
            monitor-exit(r0)
            boolean r0 = r2.isEmpty()
            if (r0 == 0) goto L6d
            Y8.t r6 = Y8.t.f7040a
            return r6
        L6d:
            java.lang.String r0 = "ArtifactAvailabilityStore"
            int r3 = r2.size()
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "flush availability batch count="
            r4.append(r5)
            r4.append(r3)
            java.lang.String r3 = r4.toString()
            r4 = 0
            r5 = 4
            h8.C4148a.k(r0, r3, r4, r5, r1)
            com.stepos.ailauncher.task.common.b r0 = new com.stepos.ailauncher.task.common.b
            r0.<init>()
            r6.l(r2, r0)
            Y8.t r6 = Y8.t.f7040a
            return r6
        L94:
            r6 = move-exception
            monitor-exit(r0)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.task.common.ArtifactAvailabilityStore.o(e9.c):java.lang.Object");
    }

    public final void q() {
        C1060i.d(scope, Y.c().getImmediate(), null, new ArtifactAvailabilityStore$notifyUiListeners$1(null), 2, null);
    }

    public final void r(List<String> fileIds, InterfaceC5074l<? super Map<String, ? extends ArtifactAvailability>, t> onResult) {
        p.i(fileIds, "fileIds");
        p.i(onResult, "onResult");
        List<String> list = fileIds;
        ArrayList arrayList = new ArrayList(C1174w.x(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(H.D1((String) it.next()).toString());
        }
        ArrayList arrayList2 = new ArrayList();
        for (Object obj : arrayList) {
            if (((String) obj).length() > 0) {
                arrayList2.add(obj);
            }
        }
        List listG0 = F.g0(arrayList2);
        if (listG0.isEmpty()) {
            onResult.invoke(kotlin.collections.a.i());
            return;
        }
        if (C5148a.INSTANCE.a()) {
            C1060i.d(scope, null, null, new ArtifactAvailabilityStore$peek$2(listG0, onResult, null), 3, null);
            return;
        }
        List list2 = listG0;
        LinkedHashMap linkedHashMap = new LinkedHashMap(C5685n.f(Q.e(C1174w.x(list2, 10)), 16));
        for (Object obj2 : list2) {
            linkedHashMap.put(obj2, ArtifactAvailability.UNKNOWN);
        }
        onResult.invoke(linkedHashMap);
    }

    public final Object s(Map<String, ? extends ArtifactAvailability> map, InterfaceC4014c<? super t> interfaceC4014c) {
        Object objJ = C1056g.j(Y.b(), new ArtifactAvailabilityStore$persistResults$2(map, null), interfaceC4014c);
        return objJ == C4063a.g() ? objJ : t.f7040a;
    }

    public final void t(List<String> fileIds, InterfaceC5074l<? super Map<String, ? extends ArtifactAvailability>, t> onResult) {
        p.i(fileIds, "fileIds");
        p.i(onResult, "onResult");
        List<String> list = fileIds;
        ArrayList arrayList = new ArrayList(C1174w.x(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(H.D1((String) it.next()).toString());
        }
        ArrayList arrayList2 = new ArrayList();
        for (Object obj : arrayList) {
            if (((String) obj).length() > 0) {
                arrayList2.add(obj);
            }
        }
        List listG0 = F.g0(arrayList2);
        if (listG0.isEmpty()) {
            onResult.invoke(kotlin.collections.a.i());
            return;
        }
        if (C5148a.INSTANCE.a()) {
            C1060i.d(scope, null, null, new ArtifactAvailabilityStore$query$2(listG0, onResult, null), 3, null);
            return;
        }
        List list2 = listG0;
        LinkedHashMap linkedHashMap = new LinkedHashMap(C5685n.f(Q.e(C1174w.x(list2, 10)), 16));
        for (Object obj2 : list2) {
            linkedHashMap.put(obj2, ArtifactAvailability.UNKNOWN);
        }
        onResult.invoke(linkedHashMap);
    }

    public final Map<String, ArtifactAvailability> u(List<String> fileIds) {
        Object objB;
        if (fileIds.isEmpty()) {
            return kotlin.collections.a.i();
        }
        try {
            Result.Companion companion = Result.INSTANCE;
            objB = Result.b(C5148a.INSTANCE.b(fileIds));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        Throwable thE = Result.e(objB);
        if (thE != null) {
            C4148a.t(TAG, "read cache failed", thE, false, 8, null);
        }
        List listM = C1173v.m();
        if (Result.g(objB)) {
            objB = listM;
        }
        List list = (List) objB;
        LinkedHashMap linkedHashMap = new LinkedHashMap(C5685n.f(Q.e(C1174w.x(list, 10)), 16));
        for (Object obj : list) {
            linkedHashMap.put(((ArtifactAvailabilityRow) obj).getFileId(), obj);
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        List<String> list2 = fileIds;
        LinkedHashMap linkedHashMap2 = new LinkedHashMap(C5685n.f(Q.e(C1174w.x(list2, 10)), 16));
        for (Object obj2 : list2) {
            linkedHashMap2.put(obj2, INSTANCE.w((ArtifactAvailabilityRow) linkedHashMap.get((String) obj2), jCurrentTimeMillis));
        }
        return linkedHashMap2;
    }

    public final Map<String, ArtifactAvailability> v(List<String> fileIds) {
        p.i(fileIds, "fileIds");
        if (C5148a.INSTANCE.a()) {
            ArrayList arrayList = new ArrayList();
            for (Object obj : fileIds) {
                if (!H.x0((String) obj)) {
                    arrayList.add(obj);
                }
            }
            return u(F.g0(arrayList));
        }
        ArrayList arrayList2 = new ArrayList();
        for (Object obj2 : fileIds) {
            if (!H.x0((String) obj2)) {
                arrayList2.add(obj2);
            }
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(C5685n.f(Q.e(C1174w.x(arrayList2, 10)), 16));
        for (Object obj3 : arrayList2) {
            linkedHashMap.put(obj3, ArtifactAvailability.UNKNOWN);
        }
        return linkedHashMap;
    }

    public final ArtifactAvailability w(ArtifactAvailabilityRow row, long now) {
        if (row == null) {
            return ArtifactAvailability.UNKNOWN;
        }
        int availability = row.getAvailability();
        return availability != 1 ? availability != 2 ? (row.getCheckedAt() <= 0 || now - row.getCheckedAt() >= TTL_MS) ? ArtifactAvailability.UNKNOWN : ArtifactAvailability.AVAILABLE : ArtifactAvailability.BLOCKED : ArtifactAvailability.UNAVAILABLE;
    }

    public final a.DetailFields x(StorageObjectDetail storageObjectDetail) {
        return new a.DetailFields(storageObjectDetail.getStatus(), storageObjectDetail.getDetectPassed());
    }
}
