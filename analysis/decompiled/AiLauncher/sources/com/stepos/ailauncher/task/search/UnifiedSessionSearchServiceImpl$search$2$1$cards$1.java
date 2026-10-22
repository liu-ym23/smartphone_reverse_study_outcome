package com.stepos.ailauncher.task.search;

import Ua.M;
import Y8.t;
import Z8.C1174w;
import Z8.Q;
import com.stepos.ailauncher.taskstore.TaskStoreModule;
import com.stepos.ailauncher.taskstore.entity.TaskInfoCard;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import g9.h;
import h8.C4148a;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import p9.p;
import v9.C5685n;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"LUa/M;", "", "", "Lcom/stepos/ailauncher/taskstore/entity/TaskInfoCard;", "<anonymous>", "(LUa/M;)Ljava/util/Map;"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "com.stepos.ailauncher.task.search.UnifiedSessionSearchServiceImpl$search$2$1$cards$1", f = "UnifiedSessionSearchServiceImpl.kt", l = {105}, m = "invokeSuspend", v = 1)
/* loaded from: classes3.dex */
public final class UnifiedSessionSearchServiceImpl$search$2$1$cards$1 extends SuspendLambda implements p<M, InterfaceC4014c<? super Map<String, ? extends TaskInfoCard>>, Object> {
    int I$0;
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;

    public UnifiedSessionSearchServiceImpl$search$2$1$cards$1(InterfaceC4014c<? super UnifiedSessionSearchServiceImpl$search$2$1$cards$1> interfaceC4014c) {
        super(2, interfaceC4014c);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        UnifiedSessionSearchServiceImpl$search$2$1$cards$1 unifiedSessionSearchServiceImpl$search$2$1$cards$1 = new UnifiedSessionSearchServiceImpl$search$2$1$cards$1(interfaceC4014c);
        unifiedSessionSearchServiceImpl$search$2$1$cards$1.L$0 = obj;
        return unifiedSessionSearchServiceImpl$search$2$1$cards$1;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(M m10, InterfaceC4014c<? super Map<String, TaskInfoCard>> interfaceC4014c) {
        return ((UnifiedSessionSearchServiceImpl$search$2$1$cards$1) create(m10, interfaceC4014c)).invokeSuspend(t.f7040a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objB;
        M m10 = (M) this.L$0;
        Object objG = C4063a.g();
        int i10 = this.label;
        try {
            if (i10 == 0) {
                C4849c.b(obj);
                Result.Companion companion = Result.INSTANCE;
                com.stepos.ailauncher.taskstore.repository.a aVarN = TaskStoreModule.INSTANCE.n();
                this.L$0 = h.a(m10);
                this.L$1 = h.a(m10);
                this.I$0 = 0;
                this.label = 1;
                obj = aVarN.g(this);
                if (obj == objG) {
                    return objG;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                C4849c.b(obj);
            }
            Iterable iterable = (Iterable) obj;
            LinkedHashMap linkedHashMap = new LinkedHashMap(C5685n.f(Q.e(C1174w.x(iterable, 10)), 16));
            for (Object obj2 : iterable) {
                linkedHashMap.put(((TaskInfoCard) obj2).getTaskId(), obj2);
            }
            objB = Result.b(linkedHashMap);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        Throwable thE = Result.e(objB);
        if (thE != null) {
            C4148a.t("UnifiedSessionSearch", "Task search descriptions unavailable", thE, false, 8, null);
        }
        return Result.g(objB) ? kotlin.collections.a.i() : objB;
    }

    @Override // p9.p
    public /* bridge */ /* synthetic */ Object invoke(M m10, InterfaceC4014c<? super Map<String, ? extends TaskInfoCard>> interfaceC4014c) {
        return invoke2(m10, (InterfaceC4014c<? super Map<String, TaskInfoCard>>) interfaceC4014c);
    }
}
