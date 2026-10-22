package com.stepos.ailauncher.foundation.appstore;

import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.common.utils.C3197a;
import com.stepos.ailauncher.foundation.appstore.api.AppVersionListApi;
import com.stepos.ailauncher.network.RetrofitProvider;
import com.stepos.ailauncher.network.interceptor.PrivacyNetworkInterceptor;
import h8.C4148a;
import java.util.concurrent.TimeUnit;
import kotlin.C4848b;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.jvm.internal.p;
import p9.InterfaceC5063a;
import p9.InterfaceC5074l;
import tb.z;

@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J$\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u0004H\u0086@¢\u0006\u0004\b\b\u0010\tJ\u001a\u0010\r\u001a\u0004\u0018\u00010\f2\u0006\u0010\u000b\u001a\u00020\nH\u0086@¢\u0006\u0004\b\r\u0010\u000eJ$\u0010\u0013\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0010\u001a\u00020\u000f2\b\b\u0002\u0010\u0011\u001a\u00020\u0004H\u0086@¢\u0006\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0015\u001a\u00020\u000f8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0017\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0014\u0010\u0019\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0019\u0010\u0018R\u001b\u0010\u001f\u001a\u00020\u001a8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u0014\u0010!\u001a\u00020 8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b!\u0010\"R\u0016\u0010&\u001a\u0004\u0018\u00010#8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b$\u0010%¨\u0006'"}, d2 = {"Lcom/stepos/ailauncher/foundation/appstore/AppVersionListRepository;", "", "<init>", "()V", "", "page", "pageSize", "Lcom/stepos/ailauncher/foundation/appstore/api/AppVersionPage;", "e", "(IILe9/c;)Ljava/lang/Object;", "", "appId", "Lcom/stepos/ailauncher/foundation/appstore/api/AppVersionDetail;", Const.INTENT_KEY_UMID, "(JLe9/c;)Ljava/lang/Object;", "", "query", "start", "Lcom/stepos/ailauncher/foundation/appstore/api/AppVersionSearchPage;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "(Ljava/lang/String;ILe9/c;)Ljava/lang/Object;", "TAG", "Ljava/lang/String;", "DEFAULT_PAGE_SIZE", "I", "MAX_PAGE_SIZE", "Ltb/z;", "httpClient$delegate", "LY8/h;", Const.INTENT_KEY_BACKGROUND_COMMAND, "()Ltb/z;", "httpClient", "Lcom/stepos/ailauncher/foundation/appstore/k;", "apiProvider", "Lcom/stepos/ailauncher/foundation/appstore/k;", "Lcom/stepos/ailauncher/foundation/appstore/api/AppVersionListApi;", "f", "()Lcom/stepos/ailauncher/foundation/appstore/api/AppVersionListApi;", "api", "foundation_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class AppVersionListRepository {
    public static final int DEFAULT_PAGE_SIZE = 15;
    private static final int MAX_PAGE_SIZE = 50;
    private static final String TAG = "AppVersionListRepo";
    public static final AppVersionListRepository INSTANCE = new AppVersionListRepository();

    /* renamed from: httpClient$delegate, reason: from kotlin metadata */
    private static final Y8.h httpClient = C4848b.b(new InterfaceC5063a() { // from class: com.stepos.ailauncher.foundation.appstore.l
        @Override // p9.InterfaceC5063a
        public final Object invoke() {
            return AppVersionListRepository.h();
        }
    });
    private static final k apiProvider = new k(new InterfaceC5074l() { // from class: com.stepos.ailauncher.foundation.appstore.m
        @Override // p9.InterfaceC5074l
        public final Object invoke(Object obj) {
            return AppVersionListRepository.c((String) obj);
        }
    });

    public static final AppVersionListApi c(String baseUrl) throws SecurityException {
        p.i(baseUrl, "baseUrl");
        Object objC = RetrofitProvider.newRetrofit$default(baseUrl, INSTANCE.g(), false, false, false, 28, null).c(AppVersionListApi.class);
        p.h(objC, "create(...)");
        return (AppVersionListApi) objC;
    }

    public static final z h() {
        z.a aVar = new z.a();
        TimeUnit timeUnit = TimeUnit.SECONDS;
        return aVar.g(15L, timeUnit).T(15L, timeUnit).W(15L, timeUnit).a(new PrivacyNetworkInterceptor()).d();
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object d(long r12, e9.InterfaceC4014c<? super com.stepos.ailauncher.foundation.appstore.api.AppVersionDetail> r14) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 220
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.foundation.appstore.AppVersionListRepository.d(long, e9.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x0074 A[Catch: Exception -> 0x0032, IOException -> 0x0037, CancellationException -> 0x00fe, TryCatch #3 {CancellationException -> 0x00fe, blocks: (B:13:0x002e, B:33:0x006c, B:35:0x0074, B:37:0x00a6, B:39:0x00ae, B:27:0x0050, B:29:0x0064), top: B:56:0x0024 }] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00a6 A[Catch: Exception -> 0x0032, IOException -> 0x0037, CancellationException -> 0x00fe, TryCatch #3 {CancellationException -> 0x00fe, blocks: (B:13:0x002e, B:33:0x006c, B:35:0x0074, B:37:0x00a6, B:39:0x00ae, B:27:0x0050, B:29:0x0064), top: B:56:0x0024 }] */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object e(int r10, int r11, e9.InterfaceC4014c<? super com.stepos.ailauncher.foundation.appstore.api.AppVersionPage> r12) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 257
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.foundation.appstore.AppVersionListRepository.e(int, int, e9.c):java.lang.Object");
    }

    public final AppVersionListApi f() {
        Object objB;
        try {
            Result.Companion companion = Result.INSTANCE;
            objB = Result.b(apiProvider.a(H5.a.INSTANCE.a(C3197a.INSTANCE.a()).s()));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        Throwable thE = Result.e(objB);
        if (thE != null) {
            C4148a.t(TAG, "create AppVersionListApi 失败", thE, false, 8, null);
        }
        if (Result.g(objB)) {
            objB = null;
        }
        return (AppVersionListApi) objB;
    }

    public final z g() {
        return (z) httpClient.getValue();
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x007d A[Catch: Exception -> 0x003a, IOException -> 0x003f, CancellationException -> 0x0118, TryCatch #3 {CancellationException -> 0x0118, blocks: (B:13:0x0036, B:32:0x0075, B:34:0x007d, B:36:0x00b4, B:38:0x00bc, B:26:0x0056, B:28:0x006d), top: B:55:0x0027 }] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00b4 A[Catch: Exception -> 0x003a, IOException -> 0x003f, CancellationException -> 0x0118, TryCatch #3 {CancellationException -> 0x0118, blocks: (B:13:0x0036, B:32:0x0075, B:34:0x007d, B:36:0x00b4, B:38:0x00bc, B:26:0x0056, B:28:0x006d), top: B:55:0x0027 }] */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object i(java.lang.String r13, int r14, e9.InterfaceC4014c<? super com.stepos.ailauncher.foundation.appstore.api.AppVersionSearchPage> r15) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 283
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.foundation.appstore.AppVersionListRepository.i(java.lang.String, int, e9.c):java.lang.Object");
    }
}
