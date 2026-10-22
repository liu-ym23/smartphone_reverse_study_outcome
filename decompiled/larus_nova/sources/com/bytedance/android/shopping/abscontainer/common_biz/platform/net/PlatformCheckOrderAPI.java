package com.bytedance.android.shopping.abscontainer.common_biz.platform.net;

import com.bytedance.android.ec.sdk.helper.n;
import com.bytedance.android.shopping.orderlist.common.repo.OrderCommonApi;
import com.bytedance.retrofit2.SsResponse;
import com.bytedance.retrofit2.http.FieldMap;
import com.bytedance.retrofit2.http.FormUrlEncoded;
import com.bytedance.retrofit2.http.POST;
import com.bytedance.retrofit2.http.QueryMap;
import com.bytedance.retrofit2.http.Url;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.Map;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import r43.f;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001:\u0001\fJV\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b2\b\b\u0001\u0010\u0003\u001a\u00020\u00022\u0016\b\u0001\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00042\u0019\b\u0001\u0010\u0007\u001a\u0013\u0012\u0004\u0012\u00020\u0002\u0012\t\u0012\u00070\u0001¢\u0006\u0002\b\u00060\u0004H§@ø\u0001\u0000¢\u0006\u0004\b\n\u0010\u000b\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\r"}, d2 = {"Lcom/bytedance/android/shopping/abscontainer/common_biz/platform/net/PlatformCheckOrderAPI;", "", "", "url", "", "checkPayParams", "Lkotlin/jvm/JvmSuppressWildcards;", "urlParams", "Lcom/bytedance/retrofit2/SsResponse;", "Lr43/f;", "checkPayStatus", "(Ljava/lang/String;Ljava/util/Map;Ljava/util/Map;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface PlatformCheckOrderAPI {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f164349a = null;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final PlatformCheckOrderAPI f164350a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ a f164351b = null;

        public a() {
        }

        static {
            f164351b = new a();
            f164350a = (PlatformCheckOrderAPI) n.f48128a.create(OrderCommonApi.API_HOST, PlatformCheckOrderAPI.class);
        }
    }

    static {
        f164349a = a.f164351b;
    }

    @FormUrlEncoded
    @POST
    Object checkPayStatus(@Url String r100, @FieldMap Map<String, String> r101, @QueryMap Map<String, Object> r102, Continuation<? super SsResponse<f>> r103);
}
