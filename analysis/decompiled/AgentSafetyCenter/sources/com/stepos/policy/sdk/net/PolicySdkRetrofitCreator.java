package com.stepos.policy.sdk.net;

import a2.i;
import ad.p;
import ad.q;
import ad.v;
import ad.w;
import android.content.Context;
import android.provider.Settings;
import com.fasterxml.jackson.core.JsonPointer;
import com.stepos.policy.sdk.BuildConfig;
import g5.f;
import ie.j;
import ie.k0;
import ie.n;
import ie.p0;
import ie.q0;
import java.lang.invoke.VarHandle;
import java.lang.reflect.Proxy;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import kb.u;
import m7.e;
import nd.a;
import nd.b;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class PolicySdkRetrofitCreator {
    public static final PolicySdkRetrofitCreator INSTANCE = new PolicySdkRetrofitCreator();
    private static volatile String cachedBaseUrl;
    private static volatile q0 retrofit;

    private PolicySdkRetrofitCreator() {
    }

    private final q0 buildRetrofit(String str) {
        a aVar = a.f8953a;
        b bVar = new b();
        bVar.f8954a = aVar;
        bVar.f8955b = u.f7406c;
        bVar.f8956c = 1;
        VarHandle.storeStoreFence();
        bVar.f8956c = 4;
        v vVar = new v();
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        vVar.a(500L, timeUnit);
        vVar.f602u = bd.b.b(500L, timeUnit);
        vVar.f601t = bd.b.b(500L, timeUnit);
        vVar.f585c.add(bVar);
        vVar.f584b = new i();
        w wVar = new w(vVar);
        k0 k0Var = k0.f6003b;
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        Objects.requireNonNull(str, "baseUrl == null");
        p pVar = new p();
        pVar.c(null, str);
        q qVarA = pVar.a();
        ArrayList arrayList3 = qVarA.f564f;
        if (!"".equals(arrayList3.get(arrayList3.size() - 1))) {
            f.p(qVarA, "baseUrl must end in /: ");
            return null;
        }
        e eVar = new e();
        je.a aVar2 = new je.a();
        aVar2.f6792a = eVar;
        VarHandle.storeStoreFence();
        arrayList.add(aVar2);
        Executor executorA = k0Var.a();
        ArrayList arrayList4 = new ArrayList(arrayList2);
        n nVar = new n();
        nVar.f6040a = executorA;
        VarHandle.storeStoreFence();
        arrayList4.addAll(Arrays.asList(j.f6002a, nVar));
        ArrayList arrayList5 = new ArrayList(arrayList.size() + 2);
        ie.b bVar2 = new ie.b();
        bVar2.f5977a = true;
        arrayList5.add(bVar2);
        arrayList5.addAll(arrayList);
        arrayList5.addAll(Collections.singletonList(ie.w.f6095a));
        List listUnmodifiableList = Collections.unmodifiableList(arrayList5);
        List listUnmodifiableList2 = Collections.unmodifiableList(arrayList4);
        q0 q0Var = new q0();
        q0Var.f6066a = new ConcurrentHashMap();
        q0Var.f6067b = wVar;
        q0Var.f6068c = qVarA;
        q0Var.f6069d = listUnmodifiableList;
        q0Var.f6070e = listUnmodifiableList2;
        q0Var.f6071f = executorA;
        VarHandle.storeStoreFence();
        return q0Var;
    }

    private final String getHost(Context context) {
        String netEnv = getNetEnv(context);
        if (netEnv == null) {
            return "stepos.com";
        }
        int iHashCode = netEnv.hashCode();
        return iHashCode != 99349 ? iHashCode != 114214 ? (iHashCode == 3556498 && netEnv.equals("test")) ? "t-stepos.com" : "stepos.com" : !netEnv.equals("stg") ? "stepos.com" : "s-stepos.com" : !netEnv.equals("dev") ? "stepos.com" : "d-stepos.com";
    }

    private final String getNetEnv(Context context) {
        return Settings.Secure.getString(context.getContentResolver(), "net_env");
    }

    private final q0 getRetrofit() {
        q0 q0VarBuildRetrofit;
        String str = cachedBaseUrl;
        if (str == null) {
            str = BuildConfig.POLICY_SDK_BASE_URL;
        }
        q0 q0Var = retrofit;
        if (q0Var != null && q0Var.f6068c.i.equals(str)) {
            return q0Var;
        }
        synchronized (this) {
            try {
                q0VarBuildRetrofit = retrofit;
                if (q0VarBuildRetrofit == null || !q0VarBuildRetrofit.f6068c.i.equals(str)) {
                    q0VarBuildRetrofit = INSTANCE.buildRetrofit(str);
                    retrofit = q0VarBuildRetrofit;
                }
            } finally {
            }
        }
        return q0VarBuildRetrofit;
    }

    private final String resolveBaseUrl(Context context) {
        return "https://policy." + getHost(context) + JsonPointer.SEPARATOR;
    }

    public final <T> T create(Class<T> cls) {
        cls.getClass();
        q0 retrofit2 = getRetrofit();
        retrofit2.getClass();
        if (!cls.isInterface()) {
            f.s("API declarations must be interfaces.");
            return null;
        }
        ArrayDeque arrayDeque = new ArrayDeque(1);
        arrayDeque.add(cls);
        while (!arrayDeque.isEmpty()) {
            Class<T> cls2 = (Class) arrayDeque.removeFirst();
            if (cls2.getTypeParameters().length != 0) {
                StringBuilder sb2 = new StringBuilder("Type parameters are unsupported on ");
                sb2.append(cls2.getName());
                if (cls2 != cls) {
                    sb2.append(" which is an interface of ");
                    sb2.append(cls.getName());
                }
                throw new IllegalArgumentException(sb2.toString());
            }
            Collections.addAll(arrayDeque, cls2.getInterfaces());
        }
        p0 p0Var = new p0();
        p0Var.f6063d = retrofit2;
        p0Var.f6062c = cls;
        p0Var.f6060a = k0.f6003b;
        p0Var.f6061b = new Object[0];
        VarHandle.storeStoreFence();
        return (T) Proxy.newProxyInstance(cls.getClassLoader(), new Class[]{cls}, p0Var);
    }

    public final /* synthetic */ <T> T createService(Class<T> cls) {
        cls.getClass();
        return (T) create(cls);
    }

    public final void init(Context context) {
        context.getClass();
        cachedBaseUrl = resolveBaseUrl(context);
        retrofit = null;
    }
}
