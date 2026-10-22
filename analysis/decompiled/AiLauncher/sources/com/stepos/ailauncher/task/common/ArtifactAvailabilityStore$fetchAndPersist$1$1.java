package com.stepos.ailauncher.task.common;

import P6.BatchQueryStorageObjectResponse;
import P6.StorageObjectDetail;
import Ua.C1060i;
import Ua.M;
import Ua.Y;
import Y8.t;
import Z8.C1174w;
import Z8.F;
import Z8.Q;
import com.stepos.ailauncher.contract.model.ArtifactAvailability;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import p9.InterfaceC5074l;
import p9.p;
import v9.C5685n;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "com.stepos.ailauncher.task.common.ArtifactAvailabilityStore$fetchAndPersist$1$1", f = "ArtifactAvailabilityStore.kt", l = {185}, m = "invokeSuspend", v = 1)
/* loaded from: classes3.dex */
public final class ArtifactAvailabilityStore$fetchAndPersist$1$1 extends SuspendLambda implements p<M, InterfaceC4014c<? super t>, Object> {
    final /* synthetic */ List<String> $fileIds;
    final /* synthetic */ InterfaceC5074l<Map<String, ? extends ArtifactAvailability>, t> $onDone;
    final /* synthetic */ BatchQueryStorageObjectResponse $resp;
    Object L$0;
    Object L$1;
    Object L$2;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public ArtifactAvailabilityStore$fetchAndPersist$1$1(BatchQueryStorageObjectResponse batchQueryStorageObjectResponse, List<String> list, InterfaceC5074l<? super Map<String, ? extends ArtifactAvailability>, t> interfaceC5074l, InterfaceC4014c<? super ArtifactAvailabilityStore$fetchAndPersist$1$1> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.$resp = batchQueryStorageObjectResponse;
        this.$fileIds = list;
        this.$onDone = interfaceC5074l;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        return new ArtifactAvailabilityStore$fetchAndPersist$1$1(this.$resp, this.$fileIds, this.$onDone, interfaceC4014c);
    }

    @Override // p9.p
    public final Object invoke(M m10, InterfaceC4014c<? super t> interfaceC4014c) {
        return ((ArtifactAvailabilityStore$fetchAndPersist$1$1) create(m10, interfaceC4014c)).invokeSuspend(t.f7040a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Map map;
        Object objG = C4063a.g();
        int i10 = this.label;
        if (i10 == 0) {
            C4849c.b(obj);
            Set setQ1 = F.q1(this.$resp.d());
            for (StorageObjectDetail storageObjectDetail : this.$resp.c()) {
                if (kotlin.jvm.internal.p.d(storageObjectDetail.getStatus(), "SOFT_DELETED")) {
                    setQ1.add(storageObjectDetail.getFileId());
                }
            }
            Map<String, StorageObjectDetail> mapB = this.$resp.b();
            List<String> list = this.$fileIds;
            LinkedHashMap linkedHashMap = new LinkedHashMap(C5685n.f(Q.e(C1174w.x(list, 10)), 16));
            for (Object obj2 : list) {
                String str = (String) obj2;
                StorageObjectDetail storageObjectDetail2 = mapB.get(str);
                linkedHashMap.put(obj2, a.INSTANCE.a(str, F.r1(setQ1), storageObjectDetail2 != null ? ArtifactAvailabilityStore.INSTANCE.x(storageObjectDetail2) : null));
            }
            ArtifactAvailabilityStore artifactAvailabilityStore = ArtifactAvailabilityStore.INSTANCE;
            this.L$0 = g9.h.a(setQ1);
            this.L$1 = g9.h.a(mapB);
            this.L$2 = linkedHashMap;
            this.label = 1;
            if (artifactAvailabilityStore.s(linkedHashMap, this) == objG) {
                return objG;
            }
            map = linkedHashMap;
        } else {
            if (i10 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            map = (Map) this.L$2;
            C4849c.b(obj);
        }
        Collection collectionValues = map.values();
        if (!(collectionValues instanceof Collection) || !collectionValues.isEmpty()) {
            Iterator it = collectionValues.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                if (((ArtifactAvailability) it.next()) == ArtifactAvailability.UNAVAILABLE) {
                    ArtifactAvailabilityStore.INSTANCE.q();
                    break;
                }
            }
        }
        ArtifactAvailabilityStore artifactAvailabilityStore2 = ArtifactAvailabilityStore.INSTANCE;
        C1060i.d(ArtifactAvailabilityStore.scope, Y.c().getImmediate(), null, new ArtifactAvailabilityStore$fetchAndPersist$1$1$invokeSuspend$$inlined$dispatchMain$1(null, this.$onDone, map), 2, null);
        return t.f7040a;
    }
}
