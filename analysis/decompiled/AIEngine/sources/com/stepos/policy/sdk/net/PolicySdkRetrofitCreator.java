package com.stepos.policy.sdk.net;

import ad.k;
import ad.n;
import android.content.Context;
import android.provider.Settings;
import com.stepos.core.common.net.NetEnv;
import com.stepos.policy.sdk.util.PolicySdkLogUtils;
import com.stepos.policy.sdk.util.PolicySdkNetworkGate;
import com.stepos.policy.sdk.util.PolicySecretLogRedactor;
import d5.i;
import java.io.IOException;
import java.lang.reflect.Proxy;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Objects;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import mb.y;
import okhttp3.Response;
import okhttp3.d;
import okhttp3.g;
import okhttp3.logging.HttpLoggingInterceptor;
import xd.e;
import xd.h;
import xd.k;
import xd.o;
import xd.s;
import xd.t;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class PolicySdkRetrofitCreator {
    private static volatile String cachedBaseUrl;
    private static volatile t retrofit;
    public static final PolicySdkRetrofitCreator INSTANCE = new PolicySdkRetrofitCreator();
    private static final AtomicBoolean netEnvLoadStarted = new AtomicBoolean(false);

    private PolicySdkRetrofitCreator() {
    }

    private final t buildRetrofit(String str) {
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor(new ai.onnxruntime.a(25));
        httpLoggingInterceptor.f11305d = HttpLoggingInterceptor.Level.f11309d;
        a aVar = new a();
        n.a aVar2 = new n.a();
        TimeUnit timeUnit = TimeUnit.SECONDS;
        aVar2.b(5L, timeUnit);
        aVar2.d(5L, timeUnit);
        aVar2.c(5L, timeUnit);
        aVar2.a(aVar);
        aVar2.a(httpLoggingInterceptor);
        TimeUnit timeUnit2 = TimeUnit.MINUTES;
        aVar2.f141b = new d();
        n nVar = new n(aVar2);
        o oVar = o.f13857b;
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        Objects.requireNonNull(str, "baseUrl == null");
        g.a aVar3 = new g.a();
        aVar3.d(null, str);
        g gVarB = aVar3.b();
        ArrayList arrayList3 = gVarB.f10982f;
        if (!"".equals(arrayList3.get(arrayList3.size() - 1))) {
            throw new IllegalArgumentException("baseUrl must end in /: " + gVarB);
        }
        arrayList.add(new yd.a(new i()));
        Executor executorA = oVar.a();
        ArrayList arrayList4 = new ArrayList(arrayList2);
        arrayList4.addAll(Arrays.asList(e.f13786a, new h(executorA)));
        ArrayList arrayList5 = new ArrayList(arrayList.size() + 2);
        xd.a aVar4 = new xd.a();
        aVar4.f13779a = true;
        arrayList5.add(aVar4);
        arrayList5.addAll(arrayList);
        arrayList5.addAll(Collections.singletonList(k.f13814a));
        return new t(nVar, gVarB, Collections.unmodifiableList(arrayList5), Collections.unmodifiableList(arrayList4), executorA);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void buildRetrofit$lambda$0(String message) {
        PolicySdkLogUtils.Companion companion = PolicySdkLogUtils.Companion;
        kotlin.jvm.internal.g.e(message, "message");
        companion.d("OkHttp", PolicySecretLogRedactor.redact(message));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Response buildRetrofit$lambda$2(k.a aVar) throws IOException {
        if (PolicySdkNetworkGate.shouldBlock()) {
            throw PolicySdkNetworkGate.blockedIOException();
        }
        return aVar.b(aVar.a());
    }

    private final t getRetrofit() {
        t tVarBuildRetrofit;
        String str = cachedBaseUrl;
        if (str == null) {
            str = "https://policy.stepaos.com/";
        }
        t tVar = retrofit;
        if (tVar != null && kotlin.jvm.internal.g.b(tVar.f13915c.f10984i, str)) {
            return tVar;
        }
        synchronized (this) {
            try {
                tVarBuildRetrofit = retrofit;
                if (tVarBuildRetrofit == null || !kotlin.jvm.internal.g.b(tVarBuildRetrofit.f13915c.f10984i, str)) {
                    tVarBuildRetrofit = INSTANCE.buildRetrofit(str);
                    retrofit = tVarBuildRetrofit;
                }
            } finally {
            }
        }
        return tVarBuildRetrofit;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String resolveBaseUrlFromEnv(String str) {
        return ai.onnxruntime.a.n(new StringBuilder("https://policy."), resolveHttpHostFromEnv(str), '/');
    }

    private final String resolveHttpHostFromEnv(String str) {
        if (str == null) {
            return NetEnv.PROD_HOST;
        }
        int iHashCode = str.hashCode();
        return iHashCode != 99349 ? iHashCode != 114214 ? (iHashCode == 3556498 && str.equals("test")) ? "t-stepos.com" : NetEnv.PROD_HOST : !str.equals("stg") ? NetEnv.PROD_HOST : "s-stepaos.com" : !str.equals("dev") ? NetEnv.PROD_HOST : "d-stepaos.com";
    }

    private final void scheduleNetEnvLoad(final Context context) {
        if (netEnvLoadStarted.compareAndSet(false, true)) {
            y.N("PolicySdk-netEnv", new zb.a<lb.n>() { // from class: com.stepos.policy.sdk.net.PolicySdkRetrofitCreator.scheduleNetEnvLoad.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // zb.a
                public /* bridge */ /* synthetic */ lb.n invoke() {
                    invoke2();
                    return lb.n.f10413a;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    String string;
                    try {
                        string = Settings.Secure.getString(context.getContentResolver(), "net_env");
                    } catch (Throwable th) {
                        PolicySdkLogUtils.Companion.e("PolicySdkRetrofitCreator", "read net_env failed, keep production default: " + th);
                        string = null;
                    }
                    String strResolveBaseUrlFromEnv = PolicySdkRetrofitCreator.INSTANCE.resolveBaseUrlFromEnv(string);
                    PolicySdkRetrofitCreator.cachedBaseUrl = strResolveBaseUrlFromEnv;
                    PolicySdkRetrofitCreator.retrofit = null;
                    PolicySdkLogUtils.Companion.d("PolicySdkRetrofitCreator", ai.onnxruntime.a.l("net_env=", string, " baseUrl=", strResolveBaseUrlFromEnv));
                }
            }, 21);
        }
    }

    public final <T> T create(Class<T> clazz) {
        kotlin.jvm.internal.g.f(clazz, "clazz");
        t retrofit3 = getRetrofit();
        retrofit3.getClass();
        if (!clazz.isInterface()) {
            throw new IllegalArgumentException("API declarations must be interfaces.");
        }
        ArrayDeque arrayDeque = new ArrayDeque(1);
        arrayDeque.add(clazz);
        while (!arrayDeque.isEmpty()) {
            Class<T> cls = (Class) arrayDeque.removeFirst();
            if (cls.getTypeParameters().length != 0) {
                StringBuilder sb2 = new StringBuilder("Type parameters are unsupported on ");
                sb2.append(cls.getName());
                if (cls != clazz) {
                    sb2.append(" which is an interface of ");
                    sb2.append(clazz.getName());
                }
                throw new IllegalArgumentException(sb2.toString());
            }
            Collections.addAll(arrayDeque, cls.getInterfaces());
        }
        return (T) Proxy.newProxyInstance(clazz.getClassLoader(), new Class[]{clazz}, new s(retrofit3, clazz));
    }

    public final /* synthetic */ <T> T createService(Class<T> clazz) {
        kotlin.jvm.internal.g.f(clazz, "clazz");
        return (T) create(clazz);
    }

    public final void init(Context context) {
        kotlin.jvm.internal.g.f(context, "context");
        if (cachedBaseUrl == null) {
            cachedBaseUrl = resolveBaseUrlFromEnv(null);
        }
        retrofit = null;
        Context applicationContext = context.getApplicationContext();
        kotlin.jvm.internal.g.e(applicationContext, "context.applicationContext");
        scheduleNetEnvLoad(applicationContext);
    }

    public final String resolveHttpHostFromNetEnv(Context context) {
        String string;
        kotlin.jvm.internal.g.f(context, "context");
        try {
            string = Settings.Secure.getString(context.getContentResolver(), "net_env");
        } catch (Throwable th) {
            PolicySdkLogUtils.Companion.e("PolicySdkRetrofitCreator", "read net_env for account host failed, use production default: " + th);
            string = null;
        }
        return resolveHttpHostFromEnv(string);
    }
}
