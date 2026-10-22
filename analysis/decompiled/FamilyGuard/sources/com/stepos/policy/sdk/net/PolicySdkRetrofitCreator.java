package com.stepos.policy.sdk.net;

import C4.A;
import C4.F;
import C4.k;
import C4.x;
import R4.u;
import V3.v;
import android.content.Context;
import android.provider.Settings;
import com.stepos.policy.sdk.util.PolicySdkLogUtils;
import com.stepos.policy.sdk.util.PolicySdkNetworkGate;
import com.stepos.policy.sdk.util.PolicySecretLogRedactor;
import i4.InterfaceC0761a;
import j4.l;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import okhttp3.logging.HttpLoggingInterceptor;

/* loaded from: classes.dex */
public final class PolicySdkRetrofitCreator {
    private static volatile String cachedBaseUrl;
    private static volatile u retrofit;
    public static final PolicySdkRetrofitCreator INSTANCE = new PolicySdkRetrofitCreator();
    private static final AtomicBoolean netEnvLoadStarted = new AtomicBoolean(false);

    /* renamed from: com.stepos.policy.sdk.net.PolicySdkRetrofitCreator$scheduleNetEnvLoad$1, reason: invalid class name */
    static final class AnonymousClass1 extends l implements InterfaceC0761a<v> {
        final /* synthetic */ Context $appContext;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(Context context) {
            super(0);
            this.$appContext = context;
        }

        @Override // i4.InterfaceC0761a
        public /* bridge */ /* synthetic */ v invoke() {
            invoke2();
            return v.f5542a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            String string;
            try {
                string = Settings.Secure.getString(this.$appContext.getContentResolver(), "net_env");
            } catch (Throwable th) {
                PolicySdkLogUtils.Companion.e("PolicySdkRetrofitCreator", "read net_env failed, keep production default: " + th);
                string = null;
            }
            String strResolveBaseUrlFromEnv = PolicySdkRetrofitCreator.INSTANCE.resolveBaseUrlFromEnv(string);
            PolicySdkRetrofitCreator.cachedBaseUrl = strResolveBaseUrlFromEnv;
            PolicySdkRetrofitCreator.retrofit = null;
            PolicySdkLogUtils.Companion.d("PolicySdkRetrofitCreator", "net_env=" + string + " baseUrl=" + strResolveBaseUrlFromEnv);
        }
    }

    private PolicySdkRetrofitCreator() {
    }

    private final u buildRetrofit(String str) {
        x httpLoggingInterceptor = new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() { // from class: com.stepos.policy.sdk.net.a
        });
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        x xVar = new x() { // from class: com.stepos.policy.sdk.net.b
            @Override // C4.x
            public final F a(x.a aVar) {
                return PolicySdkRetrofitCreator.buildRetrofit$lambda$2(aVar);
            }
        };
        A.b bVar = new A.b();
        TimeUnit timeUnit = TimeUnit.SECONDS;
        u uVarE = new u.b().d(str).b(T4.a.f()).g(bVar.c(5L, timeUnit).g(5L, timeUnit).e(5L, timeUnit).a(xVar).a(httpLoggingInterceptor).d(new k()).b()).e();
        j4.k.f(uVarE, "Builder()\n            .b…ent)\n            .build()");
        return uVarE;
    }

    private static final void buildRetrofit$lambda$0(String str) {
        PolicySdkLogUtils.Companion companion = PolicySdkLogUtils.Companion;
        j4.k.f(str, "message");
        companion.d("OkHttp", PolicySecretLogRedactor.redact(str));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final F buildRetrofit$lambda$2(x.a aVar) throws IOException {
        if (PolicySdkNetworkGate.shouldBlock()) {
            throw PolicySdkNetworkGate.blockedIOException();
        }
        return aVar.b(aVar.a());
    }

    private final u getRetrofit() {
        u uVarBuildRetrofit;
        String str = cachedBaseUrl;
        if (str == null) {
            str = "https://policy.stepaos.com/";
        }
        u uVar = retrofit;
        if (uVar != null && j4.k.b(uVar.a().toString(), str)) {
            return uVar;
        }
        synchronized (this) {
            try {
                uVarBuildRetrofit = retrofit;
                if (uVarBuildRetrofit == null || !j4.k.b(uVarBuildRetrofit.a().toString(), str)) {
                    uVarBuildRetrofit = INSTANCE.buildRetrofit(str);
                    retrofit = uVarBuildRetrofit;
                }
            } finally {
            }
        }
        return uVarBuildRetrofit;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String resolveBaseUrlFromEnv(String str) {
        return "https://policy." + resolveHttpHostFromEnv(str) + '/';
    }

    private final String resolveHttpHostFromEnv(String str) {
        if (str == null) {
            return "stepaos.com";
        }
        int iHashCode = str.hashCode();
        return iHashCode != 99349 ? iHashCode != 114214 ? (iHashCode == 3556498 && str.equals("test")) ? "t-stepos.com" : "stepaos.com" : !str.equals("stg") ? "stepaos.com" : "s-stepaos.com" : !str.equals("dev") ? "stepaos.com" : "d-stepaos.com";
    }

    private final void scheduleNetEnvLoad(Context context) {
        if (netEnvLoadStarted.compareAndSet(false, true)) {
            Y3.a.b(false, true, null, "PolicySdk-netEnv", 0, new AnonymousClass1(context), 21, null);
        }
    }

    public final <T> T create(Class<T> cls) {
        j4.k.g(cls, "clazz");
        return (T) getRetrofit().c(cls);
    }

    public final /* synthetic */ <T> T createService(Class<T> cls) {
        j4.k.g(cls, "clazz");
        return (T) create(cls);
    }

    public final void init(Context context) {
        j4.k.g(context, "context");
        if (cachedBaseUrl == null) {
            cachedBaseUrl = resolveBaseUrlFromEnv(null);
        }
        retrofit = null;
        Context applicationContext = context.getApplicationContext();
        j4.k.f(applicationContext, "context.applicationContext");
        scheduleNetEnvLoad(applicationContext);
    }

    public final String resolveHttpHostFromNetEnv(Context context) {
        String string;
        j4.k.g(context, "context");
        try {
            string = Settings.Secure.getString(context.getContentResolver(), "net_env");
        } catch (Throwable th) {
            PolicySdkLogUtils.Companion.e("PolicySdkRetrofitCreator", "read net_env for account host failed, use production default: " + th);
            string = null;
        }
        return resolveHttpHostFromEnv(string);
    }
}
