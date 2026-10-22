package com.stepos.ailauncher.network;

import Y8.h;
import Z8.C1173v;
import android.app.Application;
import androidx.exifinterface.media.ExifInterface;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.stepos.ailauncher.common.utils.C3197a;
import com.stepos.ailauncher.network.RetrofitProvider;
import com.stepos.ailauncher.network.interceptor.BizInterceptor;
import com.stepos.ailauncher.network.interceptor.PrivacyNetworkInterceptor;
import h8.C4148a;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.C4848b;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import okhttp3.logging.HttpLoggingInterceptor;
import p9.InterfaceC5063a;
import tb.w;
import tb.z;
import yc.w;
import zc.a;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u001b\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003JG\u0010\u000e\u001a\u00020\r2\b\b\u0002\u0010\u0005\u001a\u00020\u00042\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\b\b\u0002\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u000b\u001a\u00020\t2\b\b\u0002\u0010\f\u001a\u00020\tH\u0007¢\u0006\u0004\b\u000e\u0010\u000fJC\u0010\u0014\u001a\u00020\u00132\b\b\u0002\u0010\u0011\u001a\u00020\u00102\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\r2\b\b\u0002\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u000b\u001a\u00020\t2\b\b\u0002\u0010\f\u001a\u00020\tH\u0007¢\u0006\u0004\b\u0014\u0010\u0015J!\u0010\u0019\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u00162\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00028\u00000\u0017¢\u0006\u0004\b\u0019\u0010\u001aR(\u0010\u0011\u001a\u00020\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0018\n\u0004\b\u0011\u0010\u001b\u0012\u0004\b \u0010\u0003\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u0014\u0010!\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b!\u0010\"R\u001b\u0010(\u001a\u00020#8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'R\u001b\u0010,\u001a\u00020\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b)\u0010%\u001a\u0004\b*\u0010+R\u001b\u0010/\u001a\u00020\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b-\u0010%\u001a\u0004\b.\u0010+R\u001b\u00102\u001a\u00020\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b0\u0010%\u001a\u0004\b1\u0010+R\u001b\u00105\u001a\u00020\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b3\u0010%\u001a\u0004\b4\u0010+R\u001b\u00108\u001a\u00020\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b6\u0010%\u001a\u0004\b7\u0010+R!\u0010=\u001a\u00020\u00138FX\u0087\u0084\u0002¢\u0006\u0012\n\u0004\b9\u0010%\u0012\u0004\b<\u0010\u0003\u001a\u0004\b:\u0010;¨\u0006>"}, d2 = {"Lcom/stepos/ailauncher/network/RetrofitProvider;", "", "<init>", "()V", "", "timeoutSeconds", "", "Ltb/w;", "extraInterceptors", "", "enablePrivacyGate", "includeDeviceId", "includeGatewayAuth", "Ltb/z;", "newOkHttpClient", "(JLjava/util/List;ZZZ)Ltb/z;", "", "baseUrl", "okHttpClient", "Lyc/w;", "newRetrofit", "(Ljava/lang/String;Ltb/z;ZZZ)Lyc/w;", ExifInterface.GPS_DIRECTION_TRUE, "Ljava/lang/Class;", "service", "create", "(Ljava/lang/Class;)Ljava/lang/Object;", "Ljava/lang/String;", "getBaseUrl", "()Ljava/lang/String;", "setBaseUrl", "(Ljava/lang/String;)V", "getBaseUrl$annotations", "DEFAULT_TIMEOUT_SECONDS", "J", "Lcom/google/gson/Gson;", "gson$delegate", "LY8/h;", "getGson", "()Lcom/google/gson/Gson;", "gson", "loggingInterceptor$delegate", "getLoggingInterceptor", "()Ltb/w;", "loggingInterceptor", "bizInterceptor$delegate", "getBizInterceptor", "bizInterceptor", "bizInterceptorNoDeviceId$delegate", "getBizInterceptorNoDeviceId", "bizInterceptorNoDeviceId", "bizInterceptorAnonymous$delegate", "getBizInterceptorAnonymous", "bizInterceptorAnonymous", "privacyInterceptor$delegate", "getPrivacyInterceptor", "privacyInterceptor", "retrofit$delegate", "getRetrofit", "()Lyc/w;", "getRetrofit$annotations", "retrofit", "network_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class RetrofitProvider {
    private static final long DEFAULT_TIMEOUT_SECONDS = 30;
    public static final RetrofitProvider INSTANCE = new RetrofitProvider();
    private static String baseUrl = "https://biz-gw-test.zyql.com/";

    /* renamed from: bizInterceptor$delegate, reason: from kotlin metadata */
    private static final h bizInterceptor;

    /* renamed from: bizInterceptorAnonymous$delegate, reason: from kotlin metadata */
    private static final h bizInterceptorAnonymous;

    /* renamed from: bizInterceptorNoDeviceId$delegate, reason: from kotlin metadata */
    private static final h bizInterceptorNoDeviceId;

    /* renamed from: gson$delegate, reason: from kotlin metadata */
    private static final h gson;

    /* renamed from: loggingInterceptor$delegate, reason: from kotlin metadata */
    private static final h loggingInterceptor;

    /* renamed from: privacyInterceptor$delegate, reason: from kotlin metadata */
    private static final h privacyInterceptor;

    /* renamed from: retrofit$delegate, reason: from kotlin metadata */
    private static final h retrofit;

    static {
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.SYNCHRONIZED;
        gson = C4848b.a(lazyThreadSafetyMode, new InterfaceC5063a() { // from class: e6.b
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return RetrofitProvider.gson_delegate$lambda$0();
            }
        });
        loggingInterceptor = C4848b.a(lazyThreadSafetyMode, new InterfaceC5063a() { // from class: e6.c
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return RetrofitProvider.loggingInterceptor_delegate$lambda$0();
            }
        });
        bizInterceptor = C4848b.a(lazyThreadSafetyMode, new InterfaceC5063a() { // from class: e6.d
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return RetrofitProvider.bizInterceptor_delegate$lambda$0();
            }
        });
        bizInterceptorNoDeviceId = C4848b.a(lazyThreadSafetyMode, new InterfaceC5063a() { // from class: e6.e
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return RetrofitProvider.bizInterceptorNoDeviceId_delegate$lambda$0();
            }
        });
        bizInterceptorAnonymous = C4848b.a(lazyThreadSafetyMode, new InterfaceC5063a() { // from class: e6.f
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return RetrofitProvider.bizInterceptorAnonymous_delegate$lambda$0();
            }
        });
        privacyInterceptor = C4848b.a(lazyThreadSafetyMode, new InterfaceC5063a() { // from class: e6.g
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return RetrofitProvider.privacyInterceptor_delegate$lambda$0();
            }
        });
        retrofit = C4848b.a(lazyThreadSafetyMode, new InterfaceC5063a() { // from class: e6.h
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return RetrofitProvider.retrofit_delegate$lambda$0();
            }
        });
    }

    private RetrofitProvider() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final BizInterceptor bizInterceptorAnonymous_delegate$lambda$0() {
        Application applicationA = C3197a.INSTANCE.a();
        p.g(applicationA, "null cannot be cast to non-null type android.content.Context");
        return new BizInterceptor(applicationA, false, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final BizInterceptor bizInterceptorNoDeviceId_delegate$lambda$0() {
        Application applicationA = C3197a.INSTANCE.a();
        p.g(applicationA, "null cannot be cast to non-null type android.content.Context");
        return new BizInterceptor(applicationA, false, false, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final BizInterceptor bizInterceptor_delegate$lambda$0() {
        Application applicationA = C3197a.INSTANCE.a();
        p.g(applicationA, "null cannot be cast to non-null type android.content.Context");
        return new BizInterceptor(applicationA, false, false, 6, null);
    }

    public static final String getBaseUrl() {
        return baseUrl;
    }

    public static /* synthetic */ void getBaseUrl$annotations() {
    }

    private final w getBizInterceptor() {
        return (w) bizInterceptor.getValue();
    }

    private final w getBizInterceptorAnonymous() {
        return (w) bizInterceptorAnonymous.getValue();
    }

    private final w getBizInterceptorNoDeviceId() {
        return (w) bizInterceptorNoDeviceId.getValue();
    }

    private final Gson getGson() {
        Object value = gson.getValue();
        p.h(value, "getValue(...)");
        return (Gson) value;
    }

    private final w getLoggingInterceptor() {
        return (w) loggingInterceptor.getValue();
    }

    private final w getPrivacyInterceptor() {
        return (w) privacyInterceptor.getValue();
    }

    public static final yc.w getRetrofit() {
        return (yc.w) retrofit.getValue();
    }

    public static /* synthetic */ void getRetrofit$annotations() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Gson gson_delegate$lambda$0() {
        return new GsonBuilder().serializeNulls().create();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final HttpLoggingInterceptor loggingInterceptor_delegate$lambda$0() {
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor(new HttpLoggingInterceptor.b() { // from class: e6.a
            @Override // okhttp3.logging.HttpLoggingInterceptor.b
            public final void a(String str) {
                RetrofitProvider.loggingInterceptor_delegate$lambda$0$0(str);
            }
        });
        httpLoggingInterceptor.c(HttpLoggingInterceptor.Level.BODY);
        return httpLoggingInterceptor;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void loggingInterceptor_delegate$lambda$0$0(String message) {
        p.i(message, "message");
        C4148a.j("OkHttp", message, true);
    }

    public static final z newOkHttpClient(long timeoutSeconds, List<? extends w> extraInterceptors, boolean enablePrivacyGate, boolean includeDeviceId, boolean includeGatewayAuth) {
        p.i(extraInterceptors, "extraInterceptors");
        z.a aVar = new z.a();
        TimeUnit timeUnit = TimeUnit.SECONDS;
        z.a aVarW = aVar.g(timeoutSeconds, timeUnit).T(timeoutSeconds, timeUnit).W(timeoutSeconds, timeUnit);
        if (enablePrivacyGate) {
            aVarW.a(INSTANCE.getPrivacyInterceptor());
        }
        aVarW.a(!includeGatewayAuth ? INSTANCE.getBizInterceptorAnonymous() : includeDeviceId ? INSTANCE.getBizInterceptor() : INSTANCE.getBizInterceptorNoDeviceId());
        Iterator<T> it = extraInterceptors.iterator();
        while (it.hasNext()) {
            aVarW.a((w) it.next());
        }
        aVarW.a(INSTANCE.getLoggingInterceptor());
        return aVarW.d();
    }

    public static /* synthetic */ z newOkHttpClient$default(long j10, List list, boolean z10, boolean z11, boolean z12, int i10, Object obj) {
        boolean z13;
        boolean z14;
        List list2;
        boolean z15;
        if ((i10 & 1) != 0) {
            j10 = 30;
        }
        if ((i10 & 2) != 0) {
            list = C1173v.m();
        }
        if ((i10 & 4) != 0) {
            z10 = true;
        }
        if ((i10 & 8) != 0) {
            z11 = true;
        }
        if ((i10 & 16) != 0) {
            z13 = true;
            z15 = z10;
            z14 = z11;
            list2 = list;
        } else {
            z13 = z12;
            z14 = z11;
            list2 = list;
            z15 = z10;
        }
        return newOkHttpClient(j10, list2, z15, z14, z13);
    }

    public static final yc.w newRetrofit(String baseUrl2, z okHttpClient, boolean enablePrivacyGate, boolean includeDeviceId, boolean includeGatewayAuth) {
        p.i(baseUrl2, "baseUrl");
        w.b bVarB = new w.b().b(baseUrl2);
        if (okHttpClient == null) {
            okHttpClient = newOkHttpClient$default(0L, null, enablePrivacyGate, includeDeviceId, includeGatewayAuth, 3, null);
        }
        yc.w wVarD = bVarB.f(okHttpClient).a(a.g(INSTANCE.getGson())).d();
        p.h(wVarD, "build(...)");
        return wVarD;
    }

    public static /* synthetic */ yc.w newRetrofit$default(String str, z zVar, boolean z10, boolean z11, boolean z12, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = baseUrl;
        }
        if ((i10 & 2) != 0) {
            zVar = null;
        }
        if ((i10 & 4) != 0) {
            z10 = true;
        }
        if ((i10 & 8) != 0) {
            z11 = true;
        }
        if ((i10 & 16) != 0) {
            z12 = true;
        }
        return newRetrofit(str, zVar, z10, z11, z12);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PrivacyNetworkInterceptor privacyInterceptor_delegate$lambda$0() {
        return new PrivacyNetworkInterceptor();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final yc.w retrofit_delegate$lambda$0() {
        return newRetrofit$default(null, null, false, false, false, 31, null);
    }

    public static final void setBaseUrl(String str) {
        p.i(str, "<set-?>");
        baseUrl = str;
    }

    public final <T> T create(Class<T> service) {
        p.i(service, "service");
        return (T) getRetrofit().c(service);
    }
}
