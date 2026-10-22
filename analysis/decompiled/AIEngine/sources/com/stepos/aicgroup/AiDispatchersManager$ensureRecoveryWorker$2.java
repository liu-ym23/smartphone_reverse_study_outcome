package com.stepos.aicgroup;

import android.util.Log;
import com.stepos.aicgroup.AiDispatchers;
import com.stepos.core.common.cloud.FileStorageUploader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.DelayKt;
import lb.n;
import mb.m;
import mb.v;
import zb.p;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
@rb.c(c = "com.stepos.aicgroup.AiDispatchersManager$ensureRecoveryWorker$2", f = "AiDispatchersManager.kt", l = {285}, m = "invokeSuspend")
/* loaded from: classes.dex */
final class AiDispatchersManager$ensureRecoveryWorker$2 extends SuspendLambda implements p<CoroutineScope, qb.b<? super n>, Object> {

    /* renamed from: a, reason: collision with root package name */
    public Map f5630a;

    /* renamed from: b, reason: collision with root package name */
    public int f5631b;

    /* renamed from: c, reason: collision with root package name */
    public /* synthetic */ Object f5632c;

    public AiDispatchersManager$ensureRecoveryWorker$2() {
        throw null;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final qb.b<n> create(Object obj, qb.b<?> bVar) {
        AiDispatchersManager$ensureRecoveryWorker$2 aiDispatchersManager$ensureRecoveryWorker$2 = new AiDispatchersManager$ensureRecoveryWorker$2(2, bVar);
        aiDispatchersManager$ensureRecoveryWorker$2.f5632c = obj;
        return aiDispatchersManager$ensureRecoveryWorker$2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CoroutineScope coroutineScope;
        Map map;
        Object obj2;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f10059a;
        int i10 = this.f5631b;
        if (i10 == 0) {
            kotlin.c.b(obj);
            CoroutineScope coroutineScope2 = (CoroutineScope) this.f5632c;
            List<AiDispatchers.DispatcherState> allDispatcherStates$aicgroup_release = AiDispatchers.INSTANCE.getAllDispatcherStates$aicgroup_release();
            int iA0 = v.a0(m.Z(allDispatcherStates$aicgroup_release, 10));
            if (iA0 < 16) {
                iA0 = 16;
            }
            LinkedHashMap linkedHashMap = new LinkedHashMap(iA0);
            for (AiDispatchers.DispatcherState dispatcherState : allDispatcherStates$aicgroup_release) {
                linkedHashMap.put(dispatcherState.getName(), new Integer(dispatcherState.getPriority().getLevel()));
            }
            coroutineScope = coroutineScope2;
            map = linkedHashMap;
        } else {
            if (i10 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            map = this.f5630a;
            coroutineScope = (CoroutineScope) this.f5632c;
            kotlin.c.b(obj);
        }
        loop0: while (CoroutineScopeKt.isActive(coroutineScope)) {
            Set setKeySet = AiDispatchersManager.f5626o.keySet();
            kotlin.jvm.internal.g.e(setKeySet, "<get-keys>(...)");
            ArrayList arrayList = new ArrayList();
            for (Object obj3 : setKeySet) {
                if (!AiDispatchersManager.f5627p.contains((String) obj3)) {
                    arrayList.add(obj3);
                }
            }
            Iterator it = arrayList.iterator();
            if (it.hasNext()) {
                Object next = it.next();
                if (it.hasNext()) {
                    Integer num = (Integer) map.get((String) next);
                    int iIntValue = num != null ? num.intValue() : 0;
                    do {
                        Object next2 = it.next();
                        Integer num2 = (Integer) map.get((String) next2);
                        int iIntValue2 = num2 != null ? num2.intValue() : 0;
                        if (iIntValue < iIntValue2) {
                            next = next2;
                            iIntValue = iIntValue2;
                        }
                    } while (it.hasNext());
                }
                obj2 = next;
            } else {
                obj2 = null;
            }
            String str = (String) obj2;
            if (str == null) {
                break;
            }
            if (AiDispatchers.INSTANCE.recoverOneThread$aicgroup_release(str)) {
                Log.i("AiDispatchersManager", "✓ 调度器 " + str + " 已逐线程恢复完毕");
                AiDispatchersManager.f5626o.remove(str);
            } else {
                jd.b.g(Log.i("AiDispatchersManager", "↑ 调度器 " + str + " 恢复一条线程（尚未满）"));
            }
            Set setKeySet2 = AiDispatchersManager.f5626o.keySet();
            kotlin.jvm.internal.g.e(setKeySet2, "<get-keys>(...)");
            Set set = setKeySet2;
            if (!(set instanceof Collection) || !set.isEmpty()) {
                Iterator it2 = set.iterator();
                while (it2.hasNext()) {
                    if (!AiDispatchersManager.f5627p.contains((String) it2.next())) {
                        this.f5632c = coroutineScope;
                        this.f5630a = map;
                        this.f5631b = 1;
                        if (DelayKt.delay(FileStorageUploader.LOG_HEARTBEAT_MS, this) == coroutineSingletons) {
                            return coroutineSingletons;
                        }
                    }
                }
                break loop0;
            }
            break;
        }
        return n.f10413a;
    }

    @Override // zb.p
    public final Object invoke(CoroutineScope coroutineScope, qb.b<? super n> bVar) {
        return ((AiDispatchersManager$ensureRecoveryWorker$2) create(coroutineScope, bVar)).invokeSuspend(n.f10413a);
    }
}
