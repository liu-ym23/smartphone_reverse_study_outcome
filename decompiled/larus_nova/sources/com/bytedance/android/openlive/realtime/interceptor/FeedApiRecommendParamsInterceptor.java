package com.bytedance.android.openlive.realtime.interceptor;

import android.net.Uri;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.openlive.realtime.IUserRealtimeSignalCenter;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.retrofit2.SsResponse;
import com.bytedance.retrofit2.client.Request;
import com.bytedance.retrofit2.intercept.Interceptor;
import com.google.gson.JsonObject;
import java.util.Iterator;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0014\u0010\r\u001a\u0006\u0012\u0002\b\u00030\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0012H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u001d\u0010\u0007\u001a\u0004\u0018\u00010\b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\n¨\u0006\u0014"}, d2 = {"Lcom/bytedance/android/openlive/realtime/interceptor/FeedApiRecommendParamsInterceptor;", "Lcom/bytedance/retrofit2/intercept/Interceptor;", "()V", "PARAMETER_NAME_CLIENT_PARAMS_FOR_RECOMMEND", "", "TAG", "TARGET_API_PATH", "userRealtimeSignalCenter", "Lcom/bytedance/android/openlive/realtime/IUserRealtimeSignalCenter;", "getUserRealtimeSignalCenter", "()Lcom/bytedance/android/openlive/realtime/IUserRealtimeSignalCenter;", "userRealtimeSignalCenter$delegate", "Lkotlin/Lazy;", "intercept", "Lcom/bytedance/retrofit2/SsResponse;", "chain", "Lcom/bytedance/retrofit2/intercept/Interceptor$Chain;", "tryAddClientParamsForRecommend", "Lcom/bytedance/retrofit2/client/Request;", "request", "live-impl-saas_release"}, k = 1, mv = {1, 4, 3})
public final class FeedApiRecommendParamsInterceptor implements Interceptor {
    public static final FeedApiRecommendParamsInterceptor INSTANCE = null;
    private static final String PARAMETER_NAME_CLIENT_PARAMS_FOR_RECOMMEND = "client_params_for_recommend";
    private static final String TAG = "RealtimeSignal_FeedApi";
    private static final String TARGET_API_PATH = "/webcast/content_open/feed";
    private static final Lazy userRealtimeSignalCenter$delegate = null;

    private FeedApiRecommendParamsInterceptor() {
    }

    private final IUserRealtimeSignalCenter getUserRealtimeSignalCenter() {
        return (IUserRealtimeSignalCenter) userRealtimeSignalCenter$delegate.getValue();
    }

    static {
        INSTANCE = new FeedApiRecommendParamsInterceptor();
        userRealtimeSignalCenter$delegate = LazyKt.lazy(FeedApiRecommendParamsInterceptor$userRealtimeSignalCenter$2.INSTANCE);
    }

    private final Request tryAddClientParamsForRecommend(Request r110) {
        String r100 = r110.getUrl();
        if (r100 != null) goto L47;
        ALogger.w(TAG, "tryAddClientParamsForRecommend() >>> url is null");
        return r110;
    L47:
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L8
        Object r102 = Result.m9449constructorimpl(Boolean.valueOf(UriProtector.getQueryParameterNames(UriProtector.parse(r100)).contains(PARAMETER_NAME_CLIENT_PARAMS_FOR_RECOMMEND)));     // Catch: Throwable -> L8
    L10:
        Object r103 = null;
        if (Result.m9455isFailureimpl(r102) == false) goto L14;
        r102 = null;
    L14:
        if (Intrinsics.areEqual((Boolean) r102, Boolean.TRUE) == false) goto L18;
        ALogger.i(TAG, "tryAddClientParamsForRecommend() >>> skip for duplicate add");
        return r110;
    L18:
        if (getUserRealtimeSignalCenter() != null) goto L21;
        ALogger.w(TAG, "tryAddClientParamsForRecommend() >>> userRealtimeSignalCenter is null");
        return r110;
    L21:
        JsonObject r104 = new JsonObject();
        IUserRealtimeSignalCenter r105 = getUserRealtimeSignalCenter();
        if (r105 == null) goto L24;
        r105.serialize(r104);
    L24:
        String r106 = r104.toString();
        ALogger.d(TAG, "tryAddClientParamsForRecommend() >>> json=" + r106);
        Uri r107 = UriProtector.parse(r100);     // Catch: Throwable -> L31
        Uri.Builder r108 = UriProtector.parse(r100).buildUpon().clearQuery();     // Catch: Throwable -> L31
        Iterator<T> r109 = UriProtector.getQueryParameterNames(r107).iterator();     // Catch: Throwable -> L31
    L27:
        if (r109.hasNext() == false) goto L29;
        String r111 = (String) r109.next();     // Catch: Throwable -> L31
        r108.appendQueryParameter(r111, UriProtector.getQueryParameter(r107, r111));     // Catch: Throwable -> L31
        goto L27
    L29:
        Object r112 = Result.m9449constructorimpl(r108.appendQueryParameter(PARAMETER_NAME_CLIENT_PARAMS_FOR_RECOMMEND, r106).toString());     // Catch: Throwable -> L31
    L33:
        Throwable r113 = Result.m9452exceptionOrNullimpl(r112);
        if (r113 == null) goto L37;
        ALogger.w(TAG, "tryAddClientParamsForRecommend() >>> build new url failed " + r113);
    L37:
        if (Result.m9455isFailureimpl(r112) == true) goto L40;
        r103 = r112;
    L40:
        String r114 = (String) r103;
        ALogger.d(TAG, "tryAddClientParamsForRecommend() >>> newUrl=" + r114);
        if (r114 != null) goto L43;
        return r110;
    L43:
        Request r115 = r110.newBuilder().url(r114).build();
        ALogger.d(TAG, "tryAddClientParamsForRecommend() >>> newRequest.url=" + r115.getUrl());
        return r115;
    L31:
        th = move-exception;
        Result.Companion r116 = Result.Companion;
        r112 = Result.m9449constructorimpl(ResultKt.createFailure(th));
    L8:
        th = move-exception;
        Result.Companion r117 = Result.Companion;
        r102 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L10
    }

    @Override // com.bytedance.retrofit2.intercept.Interceptor
    public SsResponse<?> intercept(Interceptor.Chain r100) {
        Intrinsics.checkNotNullParameter(r100, "chain");
        Request r101 = r100.request();
        String r102 = r101.getPath();
        if (r102 == null) goto L8;
        if (StringsKt.contains$default(r102, TARGET_API_PATH, false, 2, null) != true) goto L8;
        r101 = tryAddClientParamsForRecommend(r101);
    L8:
        return r100.proceed(r101);
    }
}
