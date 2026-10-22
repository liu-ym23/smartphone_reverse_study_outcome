package z9;

import android.os.IBinder;
import android.os.SystemClock;
import android.util.Pair;
import com.stepos.deepbinder.core.DeepBinderInternal;
import com.stepos.deepbinder.core.entity.Call;
import com.stepos.deepbinder.core.entity.Reply;
import com.stepos.deepbinder.core.entity.ext.BlackAndWhiteConfig;
import com.stepos.deepbinder.core.entity.ext.CallerData;
import com.stepos.deepbinder.core.entity.internal.InternalMethod;
import com.stepos.deepbinder.service.api.BaseDynamicConfig;
import com.stepos.deepbinder.service.cache.ServiceCache;
import java.lang.reflect.Method;
import java.util.ArrayList;
import kotlin.jvm.internal.g;
import lb.n;
import mb.l;
import n9.e;
import y9.a;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    public final Call f14280a;

    /* renamed from: b, reason: collision with root package name */
    public final String f14281b;

    /* renamed from: c, reason: collision with root package name */
    public final String f14282c;

    /* renamed from: d, reason: collision with root package name */
    public InternalMethod f14283d;

    /* renamed from: e, reason: collision with root package name */
    public final IBinder f14284e;

    /* renamed from: f, reason: collision with root package name */
    public final Class<?> f14285f;

    /* renamed from: g, reason: collision with root package name */
    public ServiceCache.b f14286g;
    public final long h;

    public a(Call call) {
        String str;
        g.f(call, "call");
        this.f14280a = call;
        long timeStamp = call.getServiceWrapper().getTimeStamp();
        this.h = timeStamp;
        int type = call.getServiceWrapper().getType();
        if (type == 0 || type == 1 || type == 4) {
            String callerProcessName = call.getServiceWrapper().getCallerProcessName();
            g.f(callerProcessName, "<set-?>");
            this.f14282c = callerProcessName;
            String callerPackageName = call.getServiceWrapper().getCallerPackageName();
            g.f(callerPackageName, "<set-?>");
            this.f14281b = callerPackageName;
            if (call.getServiceWrapper().getType() != 4) {
                IBinder proxyStateBinder = call.getServiceWrapper().getProxyStateBinder();
                g.f(proxyStateBinder, "<set-?>");
                this.f14284e = proxyStateBinder;
                Class<?> clsA = e.f10682e.a().a(call.getServiceWrapper());
                g.c(clsA);
                this.f14285f = clsA;
            }
        }
        if (call.getServiceWrapper().getType() != 0) {
            boolean zContains = l.s0(new Integer[]{1, 4}).contains(Integer.valueOf(call.getServiceWrapper().getType()));
            int pid = zContains ? -1 : call.getCallerData().getPid();
            String name = zContains ? call.getServiceWrapper().getName() : String.valueOf(timeStamp);
            ServiceCache serviceCacheA = ServiceCache.f7640b.a();
            g.c(name);
            ServiceCache.b bVar = serviceCacheA.f7642a.get(new Pair(Integer.valueOf(pid), name));
            this.f14286g = bVar;
            if (zContains || bVar == null) {
                return;
            }
            String str2 = bVar.f7643a;
            String str3 = "";
            this.f14281b = str2 == null ? "" : str2;
            if (bVar != null && (str = bVar.f7644b) != null) {
                str3 = str;
            }
            this.f14282c = str3;
        }
    }

    public static Object h(int i10, zb.a aVar) {
        try {
            return aVar.invoke();
        } finally {
            th = th;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Reply a() {
        kotlin.Pair pair;
        Call call = this.f14280a;
        call.getCallerData().setCallerPackageName(d());
        CallerData callerData = call.getCallerData();
        String str = this.f14282c;
        if (str == null) {
            g.l("callerProcessName");
            throw null;
        }
        callerData.setCallerProcessName(str);
        a.C0178a c0178a = y9.a.f14176c;
        y9.a aVarA = c0178a.a();
        CallerData callerData2 = call.getCallerData();
        g.f(callerData2, "callerData");
        aVarA.f14179b.set(callerData2);
        if (!g.b(DeepBinderInternal.getContext().getPackageName(), d()) && call.getServiceWrapper().getType() != 0) {
            Method method = e().getMethod();
            g.c(method);
            String name = method.getName();
            Class<?>[] parameterTypes = method.getParameterTypes();
            g.e(parameterTypes, "getParameterTypes(...)");
            String str2 = name + "(" + l.j0(parameterTypes, new n9.d(4), 30) + ")";
            ServiceCache.b bVar = this.f14286g;
            g.c(bVar);
            boolean z = true;
            boolean z3 = false;
            if (BaseDynamicConfig.class.isAssignableFrom(bVar.f7649g)) {
                ServiceCache.b bVar2 = this.f14286g;
                g.c(bVar2);
                Object obj = bVar2.f7648f;
                g.d(obj, "null cannot be cast to non-null type com.stepos.deepbinder.service.api.BaseDynamicConfig");
                BaseDynamicConfig baseDynamicConfig = (BaseDynamicConfig) obj;
                ServiceCache.b bVar3 = this.f14286g;
                g.c(bVar3);
                Class<?> cls = bVar3.f7649g;
                g.c(cls);
                BlackAndWhiteConfig methodBlackWhiteConfig = baseDynamicConfig.getMethodBlackWhiteConfig(cls.getName(), str2);
                if (methodBlackWhiteConfig != null) {
                    Pair pair2 = new Pair(methodBlackWhiteConfig.getWhitelistedItems(), methodBlackWhiteConfig.getBlacklistedItems());
                    String strD = d();
                    ServiceCache.b bVar4 = this.f14286g;
                    g.c(bVar4);
                    bVar4.f7646d = str2;
                    n nVar = n.f10413a;
                    aa.a.a(pair2, strD, bVar4);
                    z3 = true;
                }
                if (!z3) {
                    ServiceCache.b bVar5 = this.f14286g;
                    g.c(bVar5);
                    Class<?> cls2 = bVar5.f7649g;
                    g.c(cls2);
                    BlackAndWhiteConfig serviceBlackWhiteConfig = baseDynamicConfig.getServiceBlackWhiteConfig(cls2.getName());
                    if (serviceBlackWhiteConfig != null) {
                        Pair pair3 = new Pair(serviceBlackWhiteConfig.getWhitelistedItems(), serviceBlackWhiteConfig.getBlacklistedItems());
                        String strD2 = d();
                        ServiceCache.b bVar6 = this.f14286g;
                        g.c(bVar6);
                        aa.a.a(pair3, strD2, bVar6);
                        z3 = true;
                    }
                }
            }
            if (!z3) {
                y9.a aVarA2 = c0178a.a();
                Method method2 = e().getMethod();
                g.c(method2);
                Pair<ArrayList<String>, ArrayList<String>> pairB = aVarA2.b(null, str2, method2);
                if (pairB != null) {
                    String strD3 = d();
                    ServiceCache.b bVar7 = this.f14286g;
                    g.c(bVar7);
                    bVar7.f7646d = str2;
                    n nVar2 = n.f10413a;
                    aa.a.a(pairB, strD3, bVar7);
                } else {
                    z = z3;
                }
                if (!z) {
                    y9.a aVarA3 = c0178a.a();
                    ServiceCache.b bVar8 = this.f14286g;
                    g.c(bVar8);
                    Pair<ArrayList<String>, ArrayList<String>> pairB2 = aVarA3.b(bVar8.f7649g, null, null);
                    if (pairB2 != null) {
                        String strD4 = d();
                        ServiceCache.b bVar9 = this.f14286g;
                        g.c(bVar9);
                        aa.a.a(pairB2, strD4, bVar9);
                    }
                }
            }
        }
        ArrayList arrayList = new ArrayList();
        Object[] objArrC = x9.e.c(d(), call.getParameterWrappers(), arrayList, call.getProtocolVersion());
        if (c()) {
            pair = new kotlin.Pair(g(objArrC), Long.valueOf(SystemClock.currentThreadTimeMillis() - SystemClock.currentThreadTimeMillis()));
        } else {
            pair = new kotlin.Pair(null, 0L);
        }
        Reply replyWithInvokeTime = Reply.CREATOR.obtain().withResult(b(pair.f9985a)).withInvokeTime(((Number) pair.f9986b).longValue());
        if (!arrayList.isEmpty()) {
            replyWithInvokeTime.setFlowParameterWrappers(x9.e.a(objArrC, arrayList));
        }
        return replyWithInvokeTime;
    }

    public boolean c() {
        return true;
    }

    public final String d() {
        String str = this.f14281b;
        if (str != null) {
            return str;
        }
        g.l("callerPackageName");
        throw null;
    }

    public final InternalMethod e() {
        InternalMethod internalMethod = this.f14283d;
        if (internalMethod != null) {
            return internalMethod;
        }
        g.l("method");
        throw null;
    }

    public final Class<?> f() {
        Class<?> cls = this.f14285f;
        if (cls != null) {
            return cls;
        }
        g.l("serviceClass");
        throw null;
    }

    public abstract Object g(Object[] objArr);

    public Object b(Object obj) {
        return obj;
    }
}
