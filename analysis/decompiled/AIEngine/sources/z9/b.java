package z9;

import android.os.IBinder;
import com.stepos.deepbinder.core.entity.Call;
import com.stepos.deepbinder.core.entity.internal.InternalMethod;
import com.stepos.deepbinder.core.exception.IPCException;
import com.stepos.deepbinder.core.log.IPCLog;
import com.stepos.deepbinder.service.cache.ServiceCache;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import kotlin.jvm.internal.g;
import n9.e;
import x9.h;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class b extends a {

    /* renamed from: i, reason: collision with root package name */
    public final boolean f14287i;

    /* renamed from: j, reason: collision with root package name */
    public final Object f14288j;

    /* renamed from: k, reason: collision with root package name */
    public final InternalMethod f14289k;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(Call call) throws SecurityException {
        super(call);
        e.a aVar = e.f10682e;
        g.f(call, "call");
        h.b bVarF = null;
        if (this.f14286g == null) {
            Class<?> clsF = f();
            String str = this.f14282c;
            if (str == null) {
                g.l("callerProcessName");
                throw null;
            }
            String strD = d();
            IBinder iBinder = this.f14284e;
            if (iBinder == null) {
                g.l("proxyStateBinder");
                throw null;
            }
            ServiceCache.b bVar = new ServiceCache.b();
            bVar.f7643a = strD;
            bVar.f7644b = str;
            bVar.f7645c = true;
            bVar.f7646d = null;
            bVar.f7647e = iBinder;
            bVar.f7648f = null;
            bVar.f7649g = clsF;
            this.f14286g = bVar;
        }
        try {
            Object obj = f().getField("Companion").get(f());
            this.f14288j = obj;
            if (obj != null) {
                Class<?> cls = obj.getClass();
                String methodName = call.getMethodWrapper().getName();
                Class<?>[] clsArrC = aVar.a().c(call.getParameterWrappers());
                Class<?> clsF2 = f();
                g.f(methodName, "methodName");
                h.b bVarF2 = h.f(cls, methodName, clsArrC, true);
                if (!g.b(bVarF2.f13772a.getReturnType(), clsF2)) {
                    throw new IPCException(34, ai.onnxruntime.a.l("Return type mismatch for ", methodName, " in ", cls.getName()));
                }
                bVarF = bVarF2;
            }
        } catch (Throwable th) {
            IPCLog.INSTANCE.w("GetInstanceReplyDisposer", "[getMethodForKtInstance] " + f(), "exception", th);
        }
        if (bVarF == null) {
            bVarF = h.f(f(), call.getMethodWrapper().getName(), aVar.a().c(call.getParameterWrappers()), false);
            Method method = bVarF.f13772a;
            if (!Modifier.isStatic(method.getModifiers())) {
                throw new IPCException(36, "Method " + method.getName() + " of class " + f().getName() + " is not static. Only the static method can be invoked to get an instance.");
            }
            this.f14287i = false;
        } else {
            this.f14287i = true;
        }
        InternalMethod internalMethod = new InternalMethod();
        internalMethod.setMethod(bVarF.f13772a);
        internalMethod.setParameterMapping(bVarF.f13773b.f13771b);
        this.f14289k = internalMethod;
    }

    @Override // z9.a
    public final Object g(Object[] objArr) {
        return a.h(24, new android.llama.cpp.b(10, this, objArr));
    }
}
