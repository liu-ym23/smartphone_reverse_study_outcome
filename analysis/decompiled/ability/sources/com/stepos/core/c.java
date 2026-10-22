package com.stepos.core;

import C7.r;
import S7.k;
import S7.n;
import S7.o;
import android.os.RemoteException;
import android.util.Log;
import com.stepos.core.data.AudioContent;
import com.stepos.core.data.base.Content;
import com.stepos.core.deepbinder.IAbilityDeepBinderService;
import com.stepos.core.transport.bridge.e;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import z2.l;

/* loaded from: classes3.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public final DeepBinderAbilityProxy f3825a;
    public final A8.d b;
    public final ConcurrentHashMap c = new ConcurrentHashMap();

    public c(DeepBinderAbilityProxy deepBinderAbilityProxy, A8.d dVar) {
        this.f3825a = deepBinderAbilityProxy;
        this.b = dVar;
    }

    public static void h(c cVar, Content content, n nVar, o oVar, k kVar) {
        cVar.f(content, new b(nVar, oVar, new androidx.compose.runtime.changelist.a(2), new a(0), kVar, 1));
    }

    public static void i(c cVar, String requestId, Content content, n nVar, o oVar, k kVar) {
        androidx.compose.runtime.changelist.a aVar = new androidx.compose.runtime.changelist.a(1);
        H7.b bVar = new H7.b(29);
        cVar.getClass();
        kotlin.jvm.internal.k.f(requestId, "requestId");
        cVar.g(requestId, content, new b(nVar, oVar, aVar, bVar, kVar, 0));
    }

    public final boolean a(String inferId) {
        Object objA;
        kotlin.jvm.internal.k.f(inferId, "inferId");
        this.c.remove(inferId);
        A8.d dVar = this.b;
        Log.d("DeepBinderTransportBridge", "cancel: inferId=".concat(inferId));
        try {
            objA = Boolean.valueOf(((IAbilityDeepBinderService) dVar.b).cancelInfer(inferId));
        } catch (Throwable th) {
            objA = kotlin.b.a(th);
        }
        Object obj = Boolean.FALSE;
        if (objA instanceof Result.Failure) {
            objA = obj;
        }
        return ((Boolean) objA).booleanValue();
    }

    public final void b(String str) {
        Object objA;
        try {
            ((IAbilityDeepBinderService) this.b.b).completeInput(str);
            objA = r.f317a;
        } catch (Throwable th) {
            objA = kotlin.b.a(th);
        }
        Throwable thA = Result.a(objA);
        if (thA != null) {
            Log.e("DeepBinderTransportBridge", "completeInput failed: inferId=".concat(str), thA);
        }
    }

    public final Content c(String str, Content content) {
        Object objA;
        try {
            objA = ((IAbilityDeepBinderService) this.b.b).execute(str, content);
        } catch (Throwable th) {
            objA = kotlin.b.a(th);
        }
        Throwable thA = Result.a(objA);
        if (thA != null) {
            Log.e("DeepBinderTransportBridge", "execute failed: action=".concat(str), thA);
        }
        if (objA instanceof Result.Failure) {
            objA = null;
        }
        return (Content) objA;
    }

    public final void d() {
        Object objA;
        ConcurrentHashMap concurrentHashMap = this.c;
        Map mapY = kotlin.collections.a.Y(concurrentHashMap);
        concurrentHashMap.clear();
        for (Map.Entry entry : mapY.entrySet()) {
            String str = (String) entry.getKey();
            try {
                ((d) entry.getValue()).onNext(str, new com.stepos.core.callback.b(-1000, "AIEngine service died"));
                objA = r.f317a;
            } catch (Throwable th) {
                objA = kotlin.b.a(th);
            }
            Throwable thA = Result.a(objA);
            if (thA != null) {
                Log.w("AbilityHandle", "failAllPending: callback(" + str + ") threw", thA);
            }
        }
        if (!mapY.isEmpty()) {
            Log.w("AbilityHandle", "failAllPending: notified " + mapY.size() + " pending callbacks with code=-1000");
        }
        mapY.size();
    }

    public final void e(String str, AudioContent audioContent) {
        Object objA;
        try {
            ((IAbilityDeepBinderService) this.b.b).feedInput(str, audioContent);
            objA = r.f317a;
        } catch (Throwable th) {
            objA = kotlin.b.a(th);
        }
        Throwable thA = Result.a(objA);
        if (thA != null) {
            Log.e("DeepBinderTransportBridge", "feedInput failed: inferId=".concat(str), thA);
        }
    }

    public final String f(Content content, d dVar) {
        String string = UUID.randomUUID().toString();
        kotlin.jvm.internal.k.e(string, "toString(...)");
        ConcurrentHashMap concurrentHashMap = this.c;
        concurrentHashMap.put(string, dVar);
        Log.d("AbilityHandle", "infer: requestId=" + string + ", inputType=" + content.getClass().getSimpleName());
        l lVarE = this.b.E(new com.stepos.core.transport.bridge.b(string, content));
        if (lVarE instanceof e) {
            Log.d("AbilityHandle", "Request sent successfully: ".concat(string));
            return string;
        }
        if (!(lVarE instanceof com.stepos.core.transport.bridge.d)) {
            throw new NoWhenBranchMatchedException();
        }
        String str = ((com.stepos.core.transport.bridge.d) lVarE).n.f3829a;
        Log.e("AbilityHandle", "Request failed: ".concat(str));
        concurrentHashMap.remove(string);
        dVar.onNext(string, new com.stepos.core.callback.b(130001, str));
        return string;
    }

    public final void g(String requestId, Content content, d dVar) {
        kotlin.jvm.internal.k.f(requestId, "requestId");
        ConcurrentHashMap concurrentHashMap = this.c;
        concurrentHashMap.put(requestId, dVar);
        Log.d("AbilityHandle", "infer: requestId=" + requestId + ", inputType=" + content.getClass().getSimpleName());
        l lVarE = this.b.E(new com.stepos.core.transport.bridge.b(requestId, content));
        if (lVarE instanceof e) {
            Log.d("AbilityHandle", "Request sent successfully: ".concat(requestId));
        } else {
            if (!(lVarE instanceof com.stepos.core.transport.bridge.d)) {
                throw new NoWhenBranchMatchedException();
            }
            String str = ((com.stepos.core.transport.bridge.d) lVarE).n.f3829a;
            Log.e("AbilityHandle", "Request failed: ".concat(str));
            concurrentHashMap.remove(requestId);
            dVar.onNext(requestId, new com.stepos.core.callback.b(130001, str));
        }
    }

    public final void j() throws RemoteException {
        this.c.clear();
        try {
            ((IAbilityDeepBinderService) this.b.b).release();
        } catch (Throwable th) {
            kotlin.b.a(th);
        }
        this.f3825a.release();
    }
}
