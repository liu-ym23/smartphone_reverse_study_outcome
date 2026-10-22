package com.stepos.ability.screenops.service;

import C7.r;
import D7.N;
import G6.e;
import S7.n;
import android.util.Log;
import com.uxsense.ApexSDK;
import com.uxsense.ruleTrigger.TriggerRule;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.collections.EmptySet;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.k;
import m9.InterfaceC1733z;
import s9.C1923c;

@J7.c(c = "com.stepos.ability.screenops.service.RuleTriggerManager$init$1", f = "RuleTriggerManager.kt", l = {50}, m = "invokeSuspend", v = 1)
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lm9/z;", "LC7/r;", "<anonymous>", "(Lm9/z;)V"}, k = 3, mv = {2, 2, 0})
/* loaded from: classes3.dex */
final class RuleTriggerManager$init$1 extends SuspendLambda implements n {

    /* renamed from: a, reason: collision with root package name */
    public int f3229a;

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final H7.c create(Object obj, H7.c cVar) {
        return new RuleTriggerManager$init$1(2, cVar);
    }

    @Override // S7.n
    public final Object invoke(Object obj, Object obj2) {
        return ((RuleTriggerManager$init$1) create((InterfaceC1733z) obj, (H7.c) obj2)).invokeSuspend(r.f317a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Set setQ;
        Object objPutIfAbsent;
        Object objPutIfAbsent2;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
        int i = this.f3229a;
        if (i == 0) {
            kotlin.b.b(obj);
            C1923c c1923c = c.f3241a;
            this.f3229a = 1;
            if (c.a(this) == coroutineSingletons) {
                return coroutineSingletons;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            kotlin.b.b(obj);
        }
        C1923c c1923c2 = c.f3241a;
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        ConcurrentHashMap concurrentHashMap2 = new ConcurrentHashMap();
        ConcurrentHashMap.KeySetView keySetView = c.d;
        Iterator it = keySetView.iterator();
        k.e(it, "iterator(...)");
        while (it.hasNext()) {
            String str = (String) it.next();
            k.c(str);
            for (TriggerRule triggerRule : ApexSDK.listTriggerRules(str)) {
                if (triggerRule.isEnabled()) {
                    String activityClass = triggerRule.getActivityClass();
                    if (activityClass == null) {
                        activityClass = "";
                    }
                    int[] activityTriggers = triggerRule.getTrigger().getActivityTriggers();
                    k.e(activityTriggers, "getActivityTriggers(...)");
                    int length = activityTriggers.length;
                    if (length != 0) {
                        if (length != 1) {
                            setQ = new LinkedHashSet(kotlin.collections.a.P(activityTriggers.length));
                            for (int i6 : activityTriggers) {
                                setQ.add(Integer.valueOf(i6));
                            }
                        } else {
                            setQ = N.Q(Integer.valueOf(activityTriggers[0]));
                        }
                    } else {
                        setQ = EmptySet.f4895a;
                    }
                    String name = triggerRule.getName();
                    k.e(name, "getName(...)");
                    b bVar = new b(name, setQ);
                    Object arrayList = concurrentHashMap.get(activityClass);
                    if (arrayList == null && (objPutIfAbsent2 = concurrentHashMap.putIfAbsent(activityClass, (arrayList = new ArrayList()))) != null) {
                        arrayList = objPutIfAbsent2;
                    }
                    ((List) arrayList).add(bVar);
                    Object arrayList2 = concurrentHashMap2.get(str);
                    if (arrayList2 == null && (objPutIfAbsent = concurrentHashMap2.putIfAbsent(str, (arrayList2 = new ArrayList()))) != null) {
                        arrayList2 = objPutIfAbsent;
                    }
                    ((List) arrayList2).add(bVar);
                }
            }
            if (c.e.add(str)) {
                ApexSDK.INSTANCE.addOnTriggerEventListener(str, new e(str, 5));
            }
        }
        ConcurrentHashMap concurrentHashMap3 = c.b;
        concurrentHashMap3.clear();
        concurrentHashMap3.putAll(concurrentHashMap);
        ConcurrentHashMap concurrentHashMap4 = c.c;
        concurrentHashMap4.clear();
        concurrentHashMap4.putAll(concurrentHashMap2);
        Log.i("RuleTriggerManager", "Rebuilt: " + concurrentHashMap3.size() + " activity keys, packages=" + keySetView);
        return r.f317a;
    }
}
