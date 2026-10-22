package com.stepos.ailauncher.foundation.appstore;

import Ua.C1060i;
import Ua.L0;
import Ua.M;
import Ua.Q;
import Ua.Y;
import Y8.t;
import android.os.SystemClock;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.foundation.appstore.api.AppDetail;
import com.stepos.ailauncher.foundation.appstore.api.AppDetailApi;
import com.stepos.ailauncher.network.RetrofitProvider;
import com.stepos.ailauncher.network.interceptor.PrivacyNetworkInterceptor;
import eb.InterfaceC4021a;
import h8.C4148a;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import kotlin.C4848b;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.jvm.internal.p;
import p9.InterfaceC5063a;
import p9.InterfaceC5074l;
import tb.z;

@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ+\u0010\f\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\u0014\u0010\u000b\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0012\u0004\u0012\u00020\n0\t¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u001a\u0010\u0011\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0082@¢\u0006\u0004\b\u0011\u0010\u0012J\u001a\u0010\u0013\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0082@¢\u0006\u0004\b\u0013\u0010\u0012J\u001a\u0010\u0014\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0082@¢\u0006\u0004\b\u0014\u0010\u0012J\u001a\u0010\u0015\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0082@¢\u0006\u0004\b\u0015\u0010\u0012J\u0013\u0010\u0016\u001a\u00020\u000e*\u00020\u0006H\u0002¢\u0006\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0018\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001a\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u001a\u0010\u0019R\u0014\u0010\u001b\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u001b\u0010\u0019R\u0014\u0010\u001d\u001a\u00020\u001c8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR \u0010 \u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00060\u001f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b \u0010!R \u0010#\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\"0\u001f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b#\u0010!R\u0014\u0010$\u001a\u00020\"8\u0002X\u0082T¢\u0006\u0006\n\u0004\b$\u0010%R\u0014\u0010'\u001a\u00020&8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b'\u0010(R(\u0010+\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060*0)8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b+\u0010,R\u001d\u00102\u001a\u0004\u0018\u00010-8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b.\u0010/\u001a\u0004\b0\u00101¨\u00063"}, d2 = {"Lcom/stepos/ailauncher/foundation/appstore/AppDetailRepository;", "", "<init>", "()V", "", "packageName", "Lcom/stepos/ailauncher/foundation/appstore/api/AppDetail;", "p", "(Ljava/lang/String;)Lcom/stepos/ailauncher/foundation/appstore/api/AppDetail;", "Lkotlin/Function1;", "LY8/t;", "onResult", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "(Ljava/lang/String;Lp9/l;)V", "", "o", "(Ljava/lang/String;)Z", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "(Ljava/lang/String;Le9/c;)Ljava/lang/Object;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "l", "k", "n", "(Lcom/stepos/ailauncher/foundation/appstore/api/AppDetail;)Z", "TAG", "Ljava/lang/String;", "APP_STORE_PUBLIC_BASE_URL", "BASE_URL_KEY", "LUa/M;", "scope", "LUa/M;", "Ljava/util/concurrent/ConcurrentHashMap;", "cache", "Ljava/util/concurrent/ConcurrentHashMap;", "", "failedAt", "NEGATIVE_TTL_MS", "J", "Leb/a;", "mutex", "Leb/a;", "", "LUa/Q;", "inflight", "Ljava/util/Map;", "Lcom/stepos/ailauncher/foundation/appstore/api/AppDetailApi;", "api$delegate", "LY8/h;", "m", "()Lcom/stepos/ailauncher/foundation/appstore/api/AppDetailApi;", "api", "foundation_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class AppDetailRepository {
    private static final String APP_STORE_PUBLIC_BASE_URL = "https://api-app.meizu.com/";
    private static final String BASE_URL_KEY = "appStore";
    private static final long NEGATIVE_TTL_MS = 300000;
    private static final String TAG = "AppDetailRepo";
    public static final AppDetailRepository INSTANCE = new AppDetailRepository();
    private static final M scope = kotlinx.coroutines.d.a(L0.b(null, 1, null).plus(Y.b()));
    private static final ConcurrentHashMap<String, AppDetail> cache = new ConcurrentHashMap<>();
    private static final ConcurrentHashMap<String, Long> failedAt = new ConcurrentHashMap<>();
    private static final InterfaceC4021a mutex = eb.f.b(false, 1, null);
    private static final Map<String, Q<AppDetail>> inflight = new LinkedHashMap();

    /* renamed from: api$delegate, reason: from kotlin metadata */
    private static final Y8.h api = C4848b.b(new InterfaceC5063a() { // from class: com.stepos.ailauncher.foundation.appstore.a
        @Override // p9.InterfaceC5063a
        public final Object invoke() {
            return AppDetailRepository.g();
        }
    });

    public static final AppDetailApi g() {
        Object objB;
        try {
            Result.Companion companion = Result.INSTANCE;
            z.a aVar = new z.a();
            TimeUnit timeUnit = TimeUnit.SECONDS;
            objB = Result.b((AppDetailApi) RetrofitProvider.newRetrofit$default(APP_STORE_PUBLIC_BASE_URL, aVar.g(15L, timeUnit).T(15L, timeUnit).W(15L, timeUnit).a(new PrivacyNetworkInterceptor()).d(), false, false, false, 28, null).c(AppDetailApi.class));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        Throwable thE = Result.e(objB);
        if (thE != null) {
            C4148a.t(TAG, "create AppDetailApi 失败", thE, false, 8, null);
        }
        if (Result.g(objB)) {
            objB = null;
        }
        return (AppDetailApi) objB;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object h(java.lang.String r6, e9.InterfaceC4014c<? super com.stepos.ailauncher.foundation.appstore.api.AppDetail> r7) throws java.lang.Throwable {
        /*
            r5 = this;
            boolean r0 = r7 instanceof com.stepos.ailauncher.foundation.appstore.AppDetailRepository$doFetch$1
            if (r0 == 0) goto L13
            r0 = r7
            com.stepos.ailauncher.foundation.appstore.AppDetailRepository$doFetch$1 r0 = (com.stepos.ailauncher.foundation.appstore.AppDetailRepository$doFetch$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.stepos.ailauncher.foundation.appstore.AppDetailRepository$doFetch$1 r0 = new com.stepos.ailauncher.foundation.appstore.AppDetailRepository$doFetch$1
            r0.<init>(r5, r7)
        L18:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = f9.C4063a.g()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L40
            if (r2 == r4) goto L38
            if (r2 != r3) goto L30
            java.lang.Object r5 = r0.L$0
            java.lang.String r5 = (java.lang.String) r5
            kotlin.C4849c.b(r7)
            return r7
        L30:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L38:
            java.lang.Object r6 = r0.L$0
            java.lang.String r6 = (java.lang.String) r6
            kotlin.C4849c.b(r7)
            goto L4e
        L40:
            kotlin.C4849c.b(r7)
            r0.L$0 = r6
            r0.label = r4
            java.lang.Object r7 = r5.k(r6, r0)
            if (r7 != r1) goto L4e
            goto L61
        L4e:
            com.stepos.ailauncher.foundation.appstore.api.AppDetail r7 = (com.stepos.ailauncher.foundation.appstore.api.AppDetail) r7
            if (r7 == 0) goto L53
            return r7
        L53:
            java.lang.Object r7 = g9.h.a(r6)
            r0.L$0 = r7
            r0.label = r3
            java.lang.Object r5 = r5.l(r6, r0)
            if (r5 != r1) goto L62
        L61:
            return r1
        L62:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.foundation.appstore.AppDetailRepository.h(java.lang.String, e9.c):java.lang.Object");
    }

    public final void i(String packageName, InterfaceC5074l<? super AppDetail, t> onResult) {
        p.i(packageName, "packageName");
        p.i(onResult, "onResult");
        AppDetail appDetail = cache.get(packageName);
        if (appDetail != null) {
            onResult.invoke(appDetail);
        } else if (o(packageName)) {
            onResult.invoke(null);
        } else {
            C1060i.d(scope, null, null, new AppDetailRepository$fetch$2(packageName, onResult, null), 3, null);
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(15:0|2|(2:4|(1:6)(1:7))(0)|8|(1:(1:(1:(1:(7:14|84|66|(1:68)|71|72|73)(2:15|16))(7:17|78|50|(1:52)|55|56|57))(7:18|82|19|45|46|(7:49|78|50|(0)|55|56|57)|64))(1:24))(3:25|(1:28)|64)|80|29|(8:31|(1:33)(1:34)|(1:36)|40|86|41|(4:44|45|46|(0))|64)|39|40|86|41|(0)|64|(1:(0))) */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x010c, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00d7  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00f0  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00fc A[Catch: all -> 0x0100, TryCatch #0 {all -> 0x0100, blocks: (B:50:0x00f4, B:52:0x00fc, B:55:0x0102), top: B:78:0x00f4 }] */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0124  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x012f A[Catch: all -> 0x0133, TryCatch #3 {all -> 0x0133, blocks: (B:66:0x0127, B:68:0x012f, B:71:0x0135), top: B:84:0x0127 }] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0015  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object j(java.lang.String r17, e9.InterfaceC4014c<? super com.stepos.ailauncher.foundation.appstore.api.AppDetail> r18) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 323
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.foundation.appstore.AppDetailRepository.j(java.lang.String, e9.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object k(java.lang.String r12, e9.InterfaceC4014c<? super com.stepos.ailauncher.foundation.appstore.api.AppDetail> r13) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 243
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.foundation.appstore.AppDetailRepository.k(java.lang.String, e9.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object l(java.lang.String r5, e9.InterfaceC4014c<? super com.stepos.ailauncher.foundation.appstore.api.AppDetail> r6) throws java.lang.Throwable {
        /*
            r4 = this;
            boolean r0 = r6 instanceof com.stepos.ailauncher.foundation.appstore.AppDetailRepository$fetchViaSdk$1
            if (r0 == 0) goto L13
            r0 = r6
            com.stepos.ailauncher.foundation.appstore.AppDetailRepository$fetchViaSdk$1 r0 = (com.stepos.ailauncher.foundation.appstore.AppDetailRepository$fetchViaSdk$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.stepos.ailauncher.foundation.appstore.AppDetailRepository$fetchViaSdk$1 r0 = new com.stepos.ailauncher.foundation.appstore.AppDetailRepository$fetchViaSdk$1
            r0.<init>(r4, r6)
        L18:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = f9.C4063a.g()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L35
            if (r2 != r3) goto L2d
            java.lang.Object r5 = r0.L$0
            java.lang.String r5 = (java.lang.String) r5
            kotlin.C4849c.b(r6)
            goto L45
        L2d:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L35:
            kotlin.C4849c.b(r6)
            com.stepos.ailauncher.foundation.appstore.AppStoreSdkSource r6 = com.stepos.ailauncher.foundation.appstore.AppStoreSdkSource.INSTANCE
            r0.L$0 = r5
            r0.label = r3
            java.lang.Object r6 = r6.d(r5, r0)
            if (r6 != r1) goto L45
            return r1
        L45:
            com.stepos.ailauncher.foundation.appstore.api.AppDetailDto r6 = (com.stepos.ailauncher.foundation.appstore.api.AppDetailDto) r6
            r0 = 0
            if (r6 == 0) goto L7b
            com.stepos.ailauncher.foundation.appstore.api.AppDetail r6 = com.stepos.ailauncher.foundation.appstore.api.AppDetailApiKt.toAppDetail(r6)
            if (r6 != 0) goto L51
            goto L7b
        L51:
            boolean r4 = r4.n(r6)
            if (r4 != 0) goto L75
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r6 = "AIDL 返回的详情无可渲染字段 pkg="
            r4.append(r6)
            r4.append(r5)
            java.lang.String r5 = " —— 字段名多半对不上，见 AppStoreSdkSource 打的原始响应日志"
            r4.append(r5)
            java.lang.String r4 = r4.toString()
            r5 = 0
            r6 = 4
            java.lang.String r1 = "AppDetailRepo"
            h8.C4148a.u(r1, r4, r5, r6, r0)
            return r0
        L75:
            java.util.concurrent.ConcurrentHashMap<java.lang.String, com.stepos.ailauncher.foundation.appstore.api.AppDetail> r4 = com.stepos.ailauncher.foundation.appstore.AppDetailRepository.cache
            r4.put(r5, r6)
            return r6
        L7b:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.foundation.appstore.AppDetailRepository.l(java.lang.String, e9.c):java.lang.Object");
    }

    public final AppDetailApi m() {
        return (AppDetailApi) api.getValue();
    }

    public final boolean n(AppDetail appDetail) {
        return (appDetail.getName() == null && appDetail.getSizeText() == null && appDetail.getIconUrl() == null && appDetail.getDescription() == null && appDetail.getPublisher() == null) ? false : true;
    }

    public final boolean o(String packageName) {
        ConcurrentHashMap<String, Long> concurrentHashMap = failedAt;
        Long l10 = concurrentHashMap.get(packageName);
        if (l10 != null) {
            if (SystemClock.elapsedRealtime() - l10.longValue() < 300000) {
                return true;
            }
            concurrentHashMap.remove(packageName);
        }
        return false;
    }

    public final AppDetail p(String packageName) {
        p.i(packageName, "packageName");
        return cache.get(packageName);
    }
}
