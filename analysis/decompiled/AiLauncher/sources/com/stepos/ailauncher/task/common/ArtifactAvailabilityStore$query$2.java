package com.stepos.ailauncher.task.common;

import Ua.C1060i;
import Ua.M;
import Ua.Y;
import Y8.t;
import com.stepos.ailauncher.contract.model.ArtifactAvailability;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import p9.InterfaceC5074l;
import p9.p;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "com.stepos.ailauncher.task.common.ArtifactAvailabilityStore$query$2", f = "ArtifactAvailabilityStore.kt", l = {}, m = "invokeSuspend", v = 1)
/* loaded from: classes3.dex */
public final class ArtifactAvailabilityStore$query$2 extends SuspendLambda implements p<M, InterfaceC4014c<? super t>, Object> {
    final /* synthetic */ List<String> $ids;
    final /* synthetic */ InterfaceC5074l<Map<String, ? extends ArtifactAvailability>, t> $onResult;
    int label;

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final /* synthetic */ class a {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ArtifactAvailability.values().length];
            try {
                iArr[ArtifactAvailability.UNAVAILABLE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ArtifactAvailability.BLOCKED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[ArtifactAvailability.AVAILABLE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[ArtifactAvailability.UNKNOWN.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public ArtifactAvailabilityStore$query$2(List<String> list, InterfaceC5074l<? super Map<String, ? extends ArtifactAvailability>, t> interfaceC5074l, InterfaceC4014c<? super ArtifactAvailabilityStore$query$2> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.$ids = list;
        this.$onResult = interfaceC5074l;
    }

    public static final t h(List list, Map map, InterfaceC5074l interfaceC5074l, Map map2) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            ArtifactAvailability artifactAvailability = (ArtifactAvailability) map2.get(str);
            if (artifactAvailability != null) {
                map.put(str, artifactAvailability);
            }
        }
        C1060i.d(ArtifactAvailabilityStore.scope, Y.c().getImmediate(), null, new ArtifactAvailabilityStore$query$2$invokeSuspend$lambda$2$$inlined$dispatchMain$1(null, interfaceC5074l, map), 2, null);
        return t.f7040a;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        return new ArtifactAvailabilityStore$query$2(this.$ids, this.$onResult, interfaceC4014c);
    }

    @Override // p9.p
    public final Object invoke(M m10, InterfaceC4014c<? super t> interfaceC4014c) {
        return ((ArtifactAvailabilityStore$query$2) create(m10, interfaceC4014c)).invokeSuspend(t.f7040a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        C4063a.g();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        C4849c.b(obj);
        Map mapU = ArtifactAvailabilityStore.INSTANCE.u(this.$ids);
        final Map mapC = kotlin.collections.a.C(mapU);
        List<String> list = this.$ids;
        ArrayList arrayList = new ArrayList();
        for (Object obj2 : list) {
            ArtifactAvailability artifactAvailability = (ArtifactAvailability) mapU.get((String) obj2);
            int i10 = artifactAvailability == null ? -1 : a.$EnumSwitchMapping$0[artifactAvailability.ordinal()];
            if (i10 != -1) {
                if (i10 != 1 && i10 != 2 && i10 != 3) {
                    if (i10 != 4) {
                        throw new NoWhenBranchMatchedException();
                    }
                }
            }
            arrayList.add(obj2);
        }
        if (arrayList.isEmpty()) {
            ArtifactAvailabilityStore artifactAvailabilityStore = ArtifactAvailabilityStore.INSTANCE;
            C1060i.d(ArtifactAvailabilityStore.scope, Y.c().getImmediate(), null, new ArtifactAvailabilityStore$query$2$invokeSuspend$$inlined$dispatchMain$1(null, this.$onResult, mapC), 2, null);
            return t.f7040a;
        }
        ArtifactAvailabilityStore artifactAvailabilityStore2 = ArtifactAvailabilityStore.INSTANCE;
        final List<String> list2 = this.$ids;
        final InterfaceC5074l<Map<String, ? extends ArtifactAvailability>, t> interfaceC5074l = this.$onResult;
        artifactAvailabilityStore2.k(arrayList, new InterfaceC5074l() { // from class: com.stepos.ailauncher.task.common.e
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj3) {
                return ArtifactAvailabilityStore$query$2.h(list2, mapC, interfaceC5074l, (Map) obj3);
            }
        });
        return t.f7040a;
    }
}
