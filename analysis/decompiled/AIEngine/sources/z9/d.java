package z9;

import android.os.IBinder;
import android.util.LruCache;
import com.stepos.deepbinder.core.entity.Call;
import com.stepos.deepbinder.core.exception.IPCException;
import com.stepos.deepbinder.service.cache.ServiceCache;
import h6.u;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.g;
import mb.l;
import n9.e;
import x9.h;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class d extends a {

    /* renamed from: i, reason: collision with root package name */
    public final Constructor<?> f14292i;

    /* renamed from: j, reason: collision with root package name */
    public final int[] f14293j;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(Call call) throws SecurityException {
        e.b bVar;
        super(call);
        g.f(call, "call");
        e.a aVar = e.f10682e;
        e eVarA = aVar.a();
        Class<?> clsF = f();
        Class<?>[] clsArrC = aVar.a().c(call.getParameterWrappers());
        String str = clsF.getSimpleName() + "(" + l.j0(clsArrC, new n9.d(4), 30) + ")";
        LruCache<String, Constructor<?>> lruCache = eVarA.f10686c;
        Constructor<?> constructor = lruCache.get(str);
        if (constructor != null) {
            Class<?>[] parameterTypes = constructor.getParameterTypes();
            g.e(parameterTypes, "getParameterTypes(...)");
            bVar = new e.b(constructor, h.a(parameterTypes, clsArrC));
        } else {
            Constructor<?>[] constructors = clsF.getConstructors();
            g.e(constructors, "getConstructors(...)");
            ArrayList arrayList = new ArrayList();
            for (Constructor<?> constructor2 : constructors) {
                Class<?>[] parameterTypes2 = constructor2.getParameterTypes();
                g.e(parameterTypes2, "getParameterTypes(...)");
                h.a aVarA = h.a(parameterTypes2, clsArrC);
                e.b bVar2 = aVarA.f13770a >= 0 ? new e.b(constructor2, aVarA) : null;
                if (bVar2 != null) {
                    arrayList.add(bVar2);
                }
            }
            if (arrayList.isEmpty()) {
                throw new IPCException(16, ai.onnxruntime.a.l("No matching constructor found in ", clsF.getName(), " for parameters: ", l.j0(clsArrC, new com.stepos.core.common.cloud.d(29), 31)));
            }
            List listI0 = kotlin.collections.a.I0(arrayList, new u(1));
            if (listI0.size() > 1 && ((e.b) listI0.get(0)).f10689b.f13770a == ((e.b) listI0.get(1)).f10689b.f13770a) {
                throw new IPCException(15, ai.onnxruntime.a.l("Ambiguous constructor call: ", clsF.getName(), " has multiple constructors with equal match score for parameters: ", l.j0(clsArrC, new n9.d(0), 31)));
            }
            e.b bVar3 = (e.b) kotlin.collections.a.t0(listI0);
            bVar3.f10688a.setAccessible(true);
            lruCache.put(str, bVar3.f10688a);
            bVar = bVar3;
        }
        this.f14292i = bVar.f10688a;
        this.f14293j = bVar.f10689b.f13771b;
        Class<?> clsF2 = f();
        String str2 = this.f14282c;
        if (str2 == null) {
            g.l("callerProcessName");
            throw null;
        }
        String strD = d();
        IBinder iBinder = this.f14284e;
        if (iBinder == null) {
            g.l("proxyStateBinder");
            throw null;
        }
        ServiceCache.b bVar4 = new ServiceCache.b();
        bVar4.f7643a = strD;
        bVar4.f7644b = str2;
        bVar4.f7645c = false;
        bVar4.f7646d = null;
        bVar4.f7647e = iBinder;
        bVar4.f7648f = null;
        bVar4.f7649g = clsF2;
        this.f14286g = bVar4;
    }

    @Override // z9.a
    public final Object g(Object[] objArr) {
        return a.h(23, new android.llama.cpp.b(11, this, objArr));
    }
}
