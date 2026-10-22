package com.stepos.policy.sdk.net;

import Y8.t;
import android.content.Context;
import android.provider.Settings;
import androidx.exifinterface.media.ExifInterface;
import c9.C1507a;
import com.fasterxml.jackson.core.JsonPointer;
import com.stepos.policy.sdk.util.PolicySdkLogUtils;
import com.stepos.policy.sdk.util.PolicySdkNetworkGate;
import com.stepos.policy.sdk.util.PolicySecretLogRedactor;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import okhttp3.logging.HttpLoggingInterceptor;
import p9.InterfaceC5063a;
import tb.C5530C;
import tb.C5544k;
import tb.w;
import tb.z;
import yc.w;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\u000b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0019\u0010\r\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0002¢\u0006\u0004\b\r\u0010\fJ\u0017\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\tH\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u0015\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u0004¢\u0006\u0004\b\u0015\u0010\bJ\u0015\u0010\u0016\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\u0004¢\u0006\u0004\b\u0016\u0010\u0017J!\u0010\u001b\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u00182\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00028\u00000\u0019¢\u0006\u0004\b\u001b\u0010\u001cJ&\u0010\u001d\u001a\u00028\u0000\"\u0006\b\u0000\u0010\u0018\u0018\u00012\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00028\u00000\u0019H\u0086\b¢\u0006\u0004\b\u001d\u0010\u001cR\u0018\u0010\u001e\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0018\u0010 \u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b \u0010!R\u0014\u0010#\u001a\u00020\"8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b#\u0010$¨\u0006%"}, d2 = {"Lcom/stepos/policy/sdk/net/PolicySdkRetrofitCreator;", "", "<init>", "()V", "Landroid/content/Context;", "appContext", "LY8/t;", "scheduleNetEnvLoad", "(Landroid/content/Context;)V", "", "netEnv", "resolveHttpHostFromEnv", "(Ljava/lang/String;)Ljava/lang/String;", "resolveBaseUrlFromEnv", "baseUrl", "Lyc/w;", "buildRetrofit", "(Ljava/lang/String;)Lyc/w;", "getRetrofit", "()Lyc/w;", "context", "init", "resolveHttpHostFromNetEnv", "(Landroid/content/Context;)Ljava/lang/String;", ExifInterface.GPS_DIRECTION_TRUE, "Ljava/lang/Class;", "clazz", "create", "(Ljava/lang/Class;)Ljava/lang/Object;", "createService", "cachedBaseUrl", "Ljava/lang/String;", "retrofit", "Lyc/w;", "Ljava/util/concurrent/atomic/AtomicBoolean;", "netEnvLoadStarted", "Ljava/util/concurrent/atomic/AtomicBoolean;", "policysdk_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class PolicySdkRetrofitCreator {
    private static volatile String cachedBaseUrl;
    private static volatile w retrofit;
    public static final PolicySdkRetrofitCreator INSTANCE = new PolicySdkRetrofitCreator();
    private static final AtomicBoolean netEnvLoadStarted = new AtomicBoolean(false);

    private PolicySdkRetrofitCreator() {
    }

    private final w buildRetrofit(String baseUrl) {
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor(new HttpLoggingInterceptor.b() { // from class: com.stepos.policy.sdk.net.a
            @Override // okhttp3.logging.HttpLoggingInterceptor.b
            public final void a(String str) {
                PolicySdkRetrofitCreator.buildRetrofit$lambda$0(str);
            }
        });
        httpLoggingInterceptor.g(HttpLoggingInterceptor.Level.BODY);
        tb.w wVar = new tb.w() { // from class: com.stepos.policy.sdk.net.b
            @Override // tb.w
            public final C5530C intercept(w.a aVar) {
                return PolicySdkRetrofitCreator.buildRetrofit$lambda$2(aVar);
            }
        };
        z.a aVar = new z.a();
        TimeUnit timeUnit = TimeUnit.SECONDS;
        yc.w wVarD = new w.b().b(baseUrl).a(zc.a.f()).f(aVar.g(5L, timeUnit).W(5L, timeUnit).T(5L, timeUnit).a(wVar).a(httpLoggingInterceptor).h(new C5544k()).d()).d();
        p.h(wVarD, "Builder()\n            .b…ent)\n            .build()");
        return wVarD;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void buildRetrofit$lambda$0(String message) {
        PolicySdkLogUtils.Companion companion = PolicySdkLogUtils.INSTANCE;
        p.h(message, "message");
        companion.d("OkHttp", PolicySecretLogRedactor.redact(message));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C5530C buildRetrofit$lambda$2(w.a aVar) throws IOException {
        if (PolicySdkNetworkGate.shouldBlock()) {
            throw PolicySdkNetworkGate.blockedIOException();
        }
        return aVar.i(aVar.b());
    }

    private final yc.w getRetrofit() {
        yc.w wVarBuildRetrofit;
        String str = cachedBaseUrl;
        if (str == null) {
            str = "https://policy.stepaos.com/";
        }
        yc.w wVar = retrofit;
        if (wVar != null && p.d(wVar.a().getUrl(), str)) {
            return wVar;
        }
        synchronized (this) {
            try {
                wVarBuildRetrofit = retrofit;
                if (wVarBuildRetrofit == null || !p.d(wVarBuildRetrofit.a().getUrl(), str)) {
                    wVarBuildRetrofit = INSTANCE.buildRetrofit(str);
                    retrofit = wVarBuildRetrofit;
                }
            } finally {
            }
        }
        return wVarBuildRetrofit;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String resolveBaseUrlFromEnv(String netEnv) {
        return "https://policy." + resolveHttpHostFromEnv(netEnv) + JsonPointer.SEPARATOR;
    }

    private final String resolveHttpHostFromEnv(String netEnv) {
        if (netEnv == null) {
            return "stepaos.com";
        }
        int iHashCode = netEnv.hashCode();
        return iHashCode != 99349 ? iHashCode != 114214 ? (iHashCode == 3556498 && netEnv.equals("test")) ? "t-stepos.com" : "stepaos.com" : !netEnv.equals("stg") ? "stepaos.com" : "s-stepaos.com" : !netEnv.equals("dev") ? "stepaos.com" : "d-stepaos.com";
    }

    private final void scheduleNetEnvLoad(final Context appContext) {
        if (netEnvLoadStarted.compareAndSet(false, true)) {
            C1507a.b(false, true, null, "PolicySdk-netEnv", 0, new InterfaceC5063a<t>() { // from class: com.stepos.policy.sdk.net.PolicySdkRetrofitCreator.scheduleNetEnvLoad.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // p9.InterfaceC5063a
                public /* bridge */ /* synthetic */ t invoke() {
                    invoke2();
                    return t.f7040a;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    String string;
                    try {
                        string = Settings.Secure.getString(appContext.getContentResolver(), "net_env");
                    } catch (Throwable th) {
                        PolicySdkLogUtils.INSTANCE.e("PolicySdkRetrofitCreator", "read net_env failed, keep production default: " + th);
                        string = null;
                    }
                    String strResolveBaseUrlFromEnv = PolicySdkRetrofitCreator.INSTANCE.resolveBaseUrlFromEnv(string);
                    PolicySdkRetrofitCreator.cachedBaseUrl = strResolveBaseUrlFromEnv;
                    PolicySdkRetrofitCreator.retrofit = null;
                    PolicySdkLogUtils.INSTANCE.d("PolicySdkRetrofitCreator", "net_env=" + string + " baseUrl=" + strResolveBaseUrlFromEnv);
                }
            }, 21, null);
        }
    }

    public final <T> T create(Class<T> clazz) {
        p.i(clazz, "clazz");
        return (T) getRetrofit().c(clazz);
    }

    public final /* synthetic */ <T> T createService(Class<T> clazz) {
        p.i(clazz, "clazz");
        return (T) create(clazz);
    }

    public final void init(Context context) {
        p.i(context, "context");
        if (cachedBaseUrl == null) {
            cachedBaseUrl = resolveBaseUrlFromEnv(null);
        }
        retrofit = null;
        Context applicationContext = context.getApplicationContext();
        p.h(applicationContext, "context.applicationContext");
        scheduleNetEnvLoad(applicationContext);
    }

    public final String resolveHttpHostFromNetEnv(Context context) {
        String string;
        p.i(context, "context");
        try {
            string = Settings.Secure.getString(context.getContentResolver(), "net_env");
        } catch (Throwable th) {
            PolicySdkLogUtils.INSTANCE.e("PolicySdkRetrofitCreator", "read net_env for account host failed, use production default: " + th);
            string = null;
        }
        return resolveHttpHostFromEnv(string);
    }
}
