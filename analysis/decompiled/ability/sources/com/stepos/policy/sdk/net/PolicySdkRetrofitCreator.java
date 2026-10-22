package com.stepos.policy.sdk.net;

import E5.a;
import F9.C0233k;
import F9.E;
import F9.F;
import F9.M;
import F9.z;
import K9.g;
import T9.b;
import android.content.Context;
import android.provider.Settings;
import androidx.exifinterface.media.ExifInterface;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.fasterxml.jackson.core.JsonPointer;
import com.google.gson.Gson;
import com.stepos.policy.sdk.util.PolicySdkNetworkGate;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.k;
import okhttp3.logging.HttpLoggingInterceptor$Level;
import qa.N;
import ra.C1884a;
import u1.d;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\t\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\t\u0010\bJ\u0019\u0010\n\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\n\u0010\bJ\u0017\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\fH\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u0015\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0012\u0010\u0013J!\u0010\u0017\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u00142\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00028\u00000\u0015¢\u0006\u0004\b\u0017\u0010\u0018J&\u0010\u0019\u001a\u00028\u0000\"\u0006\b\u0000\u0010\u0014\u0018\u00012\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00028\u00000\u0015H\u0086\b¢\u0006\u0004\b\u0019\u0010\u0018R\u0018\u0010\u001a\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0018\u0010\u001c\u001a\u0004\u0018\u00010\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001c\u0010\u001d¨\u0006\u001e"}, d2 = {"Lcom/stepos/policy/sdk/net/PolicySdkRetrofitCreator;", "", AppAgent.CONSTRUCT, "()V", "Landroid/content/Context;", "context", "", "resolveBaseUrl", "(Landroid/content/Context;)Ljava/lang/String;", "getHost", "getNetEnv", "baseUrl", "Lqa/N;", "buildRetrofit", "(Ljava/lang/String;)Lqa/N;", "getRetrofit", "()Lqa/N;", "LC7/r;", "init", "(Landroid/content/Context;)V", ExifInterface.GPS_DIRECTION_TRUE, "Ljava/lang/Class;", "clazz", "create", "(Ljava/lang/Class;)Ljava/lang/Object;", "createService", "cachedBaseUrl", "Ljava/lang/String;", "retrofit", "Lqa/N;", "policysdk_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class PolicySdkRetrofitCreator {
    public static final PolicySdkRetrofitCreator INSTANCE = new PolicySdkRetrofitCreator();
    private static volatile String cachedBaseUrl;
    private static volatile N retrofit;

    private PolicySdkRetrofitCreator() {
    }

    private final N buildRetrofit(String baseUrl) {
        b bVar = new b();
        bVar.b = HttpLoggingInterceptor$Level.c;
        a aVar = new a();
        E e = new E();
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        e.b(500L, timeUnit);
        e.e(500L, timeUnit);
        e.c(500L, timeUnit);
        e.a(aVar);
        e.a(bVar);
        e.b = new C0233k();
        F f = new F(e);
        d dVar = new d(20);
        dVar.I(baseUrl);
        ((ArrayList) dVar.d).add(C1884a.c(new Gson()));
        dVar.b = f;
        return dVar.J();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final M buildRetrofit$lambda$1(z zVar) throws IOException {
        if (PolicySdkNetworkGate.shouldBlock()) {
            throw PolicySdkNetworkGate.blockedIOException();
        }
        return ((g) zVar).b(((g) zVar).e);
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

    private final N getRetrofit() {
        N nBuildRetrofit;
        String str = cachedBaseUrl;
        if (str == null) {
            str = "https://policy.stepos.com/";
        }
        N n = retrofit;
        if (n != null && k.b(n.c.i, str)) {
            return n;
        }
        synchronized (this) {
            try {
                nBuildRetrofit = retrofit;
                if (nBuildRetrofit == null || !k.b(nBuildRetrofit.c.i, str)) {
                    nBuildRetrofit = INSTANCE.buildRetrofit(str);
                    retrofit = nBuildRetrofit;
                }
            } finally {
            }
        }
        return nBuildRetrofit;
    }

    private final String resolveBaseUrl(Context context) {
        return androidx.compose.foundation.b.m(JsonPointer.SEPARATOR, "https://policy.", getHost(context));
    }

    public final <T> T create(Class<T> clazz) {
        k.f(clazz, "clazz");
        return (T) getRetrofit().b(clazz);
    }

    public final /* synthetic */ <T> T createService(Class<T> clazz) {
        k.f(clazz, "clazz");
        return (T) create(clazz);
    }

    public final void init(Context context) {
        k.f(context, "context");
        cachedBaseUrl = resolveBaseUrl(context);
        retrofit = null;
    }
}
