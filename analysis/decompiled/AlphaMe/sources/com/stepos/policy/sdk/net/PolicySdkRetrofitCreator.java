package com.stepos.policy.sdk.net;

import android.content.Context;
import android.provider.Settings;
import androidx.exifinterface.media.ExifInterface;
import ch.qos.logback.core.CoreConstants;
import com.stepos.alphame.app.AppEventDataItem;
import h3.Q;
import h3.S;
import h3.r;
import j3.C0639c;
import j3.EnumC0637a;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.internal.Util;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0004H\u0002J\u001f\u0010\t\u001a\u0002H\n\"\u0004\b\u0000\u0010\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\n0\f¢\u0006\u0002\u0010\rJ$\u0010\u000e\u001a\u0002H\n\"\u0006\b\u0000\u0010\n\u0018\u00012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\n0\fH\u0086\b¢\u0006\u0002\u0010\rJ\u0010\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\u0012\u0010\u0012\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\b\u0010\u0013\u001a\u00020\u0006H\u0002J\u000e\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0010\u001a\u00020\u0011J\u0010\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u0011H\u0002R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/stepos/policy/sdk/net/PolicySdkRetrofitCreator;", "", "()V", "cachedBaseUrl", "", "retrofit", "Lretrofit2/Retrofit;", "buildRetrofit", "baseUrl", AppEventDataItem.APP_CREATE, ExifInterface.GPS_DIRECTION_TRUE, "clazz", "Ljava/lang/Class;", "(Ljava/lang/Class;)Ljava/lang/Object;", "createService", "getHost", CoreConstants.CONTEXT_SCOPE_VALUE, "Landroid/content/Context;", "getNetEnv", "getRetrofit", "init", "", "resolveBaseUrl", "policysdk_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class PolicySdkRetrofitCreator {

    @NotNull
    public static final PolicySdkRetrofitCreator INSTANCE = new PolicySdkRetrofitCreator();

    @Nullable
    private static volatile String cachedBaseUrl;

    @Nullable
    private static volatile Retrofit retrofit;

    private PolicySdkRetrofitCreator() {
    }

    private final Retrofit buildRetrofit(String baseUrl) {
        C0639c interceptor = new C0639c();
        EnumC0637a level = EnumC0637a.f13135c;
        Intrinsics.checkNotNullParameter(level, "level");
        Intrinsics.checkNotNullParameter(level, "<set-?>");
        interceptor.f13139b = level;
        Q q4 = new Q();
        TimeUnit unit = TimeUnit.MILLISECONDS;
        Intrinsics.checkNotNullParameter(unit, "unit");
        q4.f12779y = Util.checkDuration("timeout", 500L, unit);
        Intrinsics.checkNotNullParameter(unit, "unit");
        q4.f12751A = Util.checkDuration("timeout", 500L, unit);
        Intrinsics.checkNotNullParameter(unit, "unit");
        q4.f12780z = Util.checkDuration("timeout", 500L, unit);
        Intrinsics.checkNotNullParameter(interceptor, "interceptor");
        q4.f12757c.add(interceptor);
        r connectionPool = new r();
        Intrinsics.checkNotNullParameter(connectionPool, "connectionPool");
        Intrinsics.checkNotNullParameter(connectionPool, "<set-?>");
        q4.f12756b = connectionPool;
        Retrofit retrofitBuild = new Retrofit.Builder().baseUrl(baseUrl).addConverterFactory(GsonConverterFactory.create()).client(new S(q4)).build();
        Intrinsics.checkNotNullExpressionValue(retrofitBuild, "Builder()\n            .b…ent)\n            .build()");
        return retrofitBuild;
    }

    private final String getHost(Context context) {
        String str;
        String netEnv = getNetEnv(context);
        if (netEnv == null) {
            return "stepos.com";
        }
        int iHashCode = netEnv.hashCode();
        if (iHashCode == 99349) {
            str = "dev";
        } else if (iHashCode == 114214) {
            str = "stg";
        } else {
            if (iHashCode != 3556498) {
                return "stepos.com";
            }
            str = "test";
        }
        netEnv.equals(str);
        return "stepos.com";
    }

    private final String getNetEnv(Context context) {
        return Settings.Secure.getString(context.getContentResolver(), "net_env");
    }

    private final Retrofit getRetrofit() {
        Retrofit retrofitBuildRetrofit;
        String str = cachedBaseUrl;
        if (str == null) {
            str = "https://policy.stepos.com/";
        }
        Retrofit retrofit3 = retrofit;
        if (retrofit3 != null && Intrinsics.areEqual(retrofit3.baseUrl().f12730i, str)) {
            return retrofit3;
        }
        synchronized (this) {
            try {
                retrofitBuildRetrofit = retrofit;
                if (retrofitBuildRetrofit == null || !Intrinsics.areEqual(retrofitBuildRetrofit.baseUrl().f12730i, str)) {
                    retrofitBuildRetrofit = INSTANCE.buildRetrofit(str);
                    retrofit = retrofitBuildRetrofit;
                }
            } finally {
            }
        }
        return retrofitBuildRetrofit;
    }

    private final String resolveBaseUrl(Context context) {
        return "https://policy." + getHost(context) + '/';
    }

    public final <T> T create(@NotNull Class<T> clazz) {
        Intrinsics.checkNotNullParameter(clazz, "clazz");
        return (T) getRetrofit().create(clazz);
    }

    public final /* synthetic */ <T> T createService(Class<T> clazz) {
        Intrinsics.checkNotNullParameter(clazz, "clazz");
        return (T) create(clazz);
    }

    public final void init(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        cachedBaseUrl = resolveBaseUrl(context);
        retrofit = null;
    }
}
