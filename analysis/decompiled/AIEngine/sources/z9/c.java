package z9;

import com.stepos.deepbinder.core.entity.Call;
import com.stepos.deepbinder.core.entity.wrapper.ParameterWrapper;
import com.stepos.deepbinder.core.exception.IPCException;
import com.stepos.deepbinder.core.log.IPCLog;
import com.stepos.deepbinder.service.api.ServiceInterceptor;
import com.stepos.deepbinder.service.cache.ServiceCache;
import java.lang.reflect.Method;
import kotlin.jvm.internal.g;
import mb.l;
import n9.e;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class c extends a {

    /* renamed from: i, reason: collision with root package name */
    public final boolean f14290i;

    /* renamed from: j, reason: collision with root package name */
    public final boolean f14291j;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(Call call) {
        String strJ0;
        super(call);
        g.f(call, "call");
        this.f14290i = call.getMethodWrapper().isSync();
        if (this.f14286g == null) {
            IPCLog.INSTANCE.w("MethodInvokeReplyDisposer", "serviceContext is null", "serviceWrapper ", call.getServiceWrapper());
            throw new IPCException(22, "can't find ipc object proxy", String.valueOf(this.h));
        }
        e eVarA = e.f10682e.a();
        ServiceCache.b bVar = this.f14286g;
        g.c(bVar);
        Class<?> cls = bVar.f7649g;
        g.c(cls);
        String methodName = call.getMethodWrapper().getName();
        ParameterWrapper[] parameterWrappers = call.getParameterWrappers();
        g.f(methodName, "methodName");
        this.f14283d = eVarA.d(cls, methodName + "(" + ((parameterWrappers == null || (strJ0 = l.j0(parameterWrappers, new n9.d(5), 30)) == null) ? "" : strJ0) + ")", call.getMethodWrapper(), call.getParameterWrappers());
        ServiceCache.b bVar2 = this.f14286g;
        g.c(bVar2);
        this.f14291j = bVar2.f7648f instanceof ServiceInterceptor;
    }

    @Override // z9.a
    public final Object b(Object obj) {
        if (!this.f14291j) {
            return obj;
        }
        try {
            ServiceCache.b bVar = this.f14286g;
            g.c(bVar);
            Object obj2 = bVar.f7648f;
            g.d(obj2, "null cannot be cast to non-null type com.stepos.deepbinder.service.api.ServiceInterceptor");
            Method method = e().getMethod();
            g.c(method);
            return ((ServiceInterceptor) obj2).afterMethodInvoke(method, obj);
        } catch (Throwable th) {
            throw new IPCException(50, th);
        }
    }

    @Override // z9.a
    public final boolean c() {
        if (!this.f14291j) {
            return true;
        }
        try {
            ServiceCache.b bVar = this.f14286g;
            g.c(bVar);
            Object obj = bVar.f7648f;
            g.d(obj, "null cannot be cast to non-null type com.stepos.deepbinder.service.api.ServiceInterceptor");
            Method method = e().getMethod();
            g.c(method);
            return ((ServiceInterceptor) obj).beforeMethodInvoke(method);
        } catch (Throwable th) {
            throw new IPCException(49, th);
        }
    }

    @Override // z9.a
    public final Object g(Object[] objArr) {
        return a.h(3, new cb.d(13, this, objArr));
    }
}
