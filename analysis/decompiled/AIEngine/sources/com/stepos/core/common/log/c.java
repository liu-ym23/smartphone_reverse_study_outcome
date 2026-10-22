package com.stepos.core.common.log;

import kotlin.coroutines.CombinedContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.c;
import kotlin.coroutines.d;
import kotlin.jvm.internal.g;
import kotlinx.coroutines.flow.internal.SafeCollector;
import kotlinx.coroutines.internal.ThreadContextKt;
import zb.p;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final /* synthetic */ class c implements p {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7378a;

    public /* synthetic */ c(int i10) {
        this.f7378a = i10;
    }

    @Override // zb.p
    public final Object invoke(Object obj, Object obj2) {
        CombinedContext combinedContext;
        switch (this.f7378a) {
            case 0:
                return PerfettoTrace.incrementCounter$lambda$0((String) obj, (Long) obj2);
            case 1:
                return PerfettoTrace.decrementCounter$lambda$3((String) obj, (Long) obj2);
            case 2:
                return Integer.valueOf(SafeCollector.collectContextSize$lambda$0(((Integer) obj).intValue(), (d.a) obj2));
            case 3:
                return ThreadContextKt.countAll$lambda$0(obj, (d.a) obj2);
            default:
                kotlin.coroutines.d acc = (kotlin.coroutines.d) obj;
                d.a element = (d.a) obj2;
                g.f(acc, "acc");
                g.f(element, "element");
                kotlin.coroutines.d dVarMinusKey = acc.minusKey(element.getKey());
                EmptyCoroutineContext emptyCoroutineContext = EmptyCoroutineContext.f10057a;
                if (dVarMinusKey == emptyCoroutineContext) {
                    return element;
                }
                c.a aVar = c.a.f10058a;
                kotlin.coroutines.c cVar = (kotlin.coroutines.c) dVarMinusKey.get(aVar);
                if (cVar == null) {
                    combinedContext = new CombinedContext(dVarMinusKey, element);
                } else {
                    kotlin.coroutines.d dVarMinusKey2 = dVarMinusKey.minusKey(aVar);
                    if (dVarMinusKey2 == emptyCoroutineContext) {
                        return new CombinedContext(element, cVar);
                    }
                    combinedContext = new CombinedContext(new CombinedContext(dVarMinusKey2, element), cVar);
                }
                return combinedContext;
        }
    }
}
