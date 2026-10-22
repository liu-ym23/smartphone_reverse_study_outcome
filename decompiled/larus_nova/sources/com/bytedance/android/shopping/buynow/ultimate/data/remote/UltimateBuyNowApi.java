package com.bytedance.android.shopping.buynow.ultimate.data.remote;

import com.bytedance.android.ec.core.buynow.BuyNowPerformanceOpt;
import com.bytedance.android.ec.sdk.helper.n;
import com.bytedance.android.shopping.orderlist.common.repo.OrderCommonApi;
import com.bytedance.retrofit2.Call;
import com.bytedance.retrofit2.SsResponse;
import com.bytedance.retrofit2.http.Body;
import com.bytedance.retrofit2.http.POST;
import com.bytedance.retrofit2.http.Query;
import com.bytedance.retrofit2.http.Url;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import io.reactivex.Observable;
import kotlin.Metadata;
import ma3.j;
import ma3.k;
import ma3.r;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001:\u0001\u001aJ[\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\f0\u000b2\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0005\u001a\u00020\u00042\b\b\u0001\u0010\u0007\u001a\u00020\u00062\b\b\u0001\u0010\b\u001a\u00020\u00062\n\b\u0003\u0010\t\u001a\u0004\u0018\u00010\u00062\n\b\u0003\u0010\n\u001a\u0004\u0018\u00010\u0002H'¢\u0006\u0004\b\r\u0010\u000eJO\u0010\u0010\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0018\u00010\u000f2\b\b\u0001\u0010\u0005\u001a\u00020\u00042\b\b\u0001\u0010\u0007\u001a\u00020\u00062\b\b\u0001\u0010\b\u001a\u00020\u00062\n\b\u0003\u0010\t\u001a\u0004\u0018\u00010\u00062\n\b\u0003\u0010\n\u001a\u0004\u0018\u00010\u0002H'¢\u0006\u0004\b\u0010\u0010\u0011JQ\u0010\u0013\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\f0\u000b2\b\b\u0001\u0010\u0005\u001a\u00020\u00042\b\b\u0001\u0010\u0007\u001a\u00020\u00062\b\b\u0001\u0010\b\u001a\u00020\u00062\n\b\u0001\u0010\t\u001a\u0004\u0018\u00010\u00062\n\b\u0001\u0010\u0012\u001a\u0004\u0018\u00010\u0002H'¢\u0006\u0004\b\u0013\u0010\u0014JQ\u0010\u0018\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00170\f0\u000b2\b\b\u0001\u0010\u0016\u001a\u00020\u00152\b\b\u0001\u0010\u0007\u001a\u00020\u00062\b\b\u0001\u0010\b\u001a\u00020\u00062\n\b\u0003\u0010\t\u001a\u0004\u0018\u00010\u00062\n\b\u0003\u0010\n\u001a\u0004\u0018\u00010\u0002H'¢\u0006\u0004\b\u0018\u0010\u0019¨\u0006\u001b"}, d2 = {"Lcom/bytedance/android/shopping/buynow/ultimate/data/remote/UltimateBuyNowApi;", "", "", "path", "Lma3/r;", "data", "", "bTypeNew", "subBType", "shape", "webcastAppId", "Lio/reactivex/Observable;", "Lcom/bytedance/retrofit2/SsResponse;", "getQueryForUltimateBuy", "(Ljava/lang/String;Lma3/r;IILjava/lang/Integer;Ljava/lang/String;)Lio/reactivex/Observable;", "Lcom/bytedance/retrofit2/Call;", "getQueryForUltimateBuyHighPriority", "(Lma3/r;IILjava/lang/Integer;Ljava/lang/String;)Lcom/bytedance/retrofit2/Call;", "bizIdentity", "getPrefetchForUltimateBuy", "(Lma3/r;IILjava/lang/Integer;Ljava/lang/String;)Lio/reactivex/Observable;", "Lma3/j;", "params", "Lma3/k;", "createOrderForUltimateBuy", "(Lma3/j;IILjava/lang/Integer;Ljava/lang/String;)Lio/reactivex/Observable;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface UltimateBuyNowApi {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f171179a = null;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final String f171180a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final UltimateBuyNowApi f171181b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final /* synthetic */ a f171182c = null;

        public a() {
        }

        static {
            f171182c = new a();
            if (BuyNowPerformanceOpt.k() == false) goto L5;
            String r100 = "https://ec5-core.ecombdapi.com/";
        L6:
            f171180a = r100;
            f171181b = (UltimateBuyNowApi) n.f48128a.create(r100, UltimateBuyNowApi.class);
            return;
        L5:
            r100 = OrderCommonApi.API_HOST;
            goto L6
        }
    }

    static {
        f171179a = a.f171182c;
    }

    @POST("/order/component/createOrder/")
    Observable<SsResponse<k>> createOrderForUltimateBuy(@Body j r100, @Query("b_type_new") int r101, @Query("sub_b_type") int r102, @Query("buy_render_shape") Integer r103, @Query("webcast_appid") String r104);

    @POST("/order/component/confirmOrderPrefetch/")
    Observable<SsResponse<String>> getPrefetchForUltimateBuy(@Body r r100, @Query("b_type_new") int r101, @Query("sub_b_type") int r102, @Query("buy_render_shape") Integer r103, @Query("biz_identity") String r104);

    @POST
    Observable<SsResponse<String>> getQueryForUltimateBuy(@Url String r100, @Body r r101, @Query("b_type_new") int r102, @Query("sub_b_type") int r103, @Query("buy_render_shape") Integer r104, @Query("webcast_appid") String r105);

    @POST("/order/component/confirmOrder/")
    Call<String> getQueryForUltimateBuyHighPriority(@Body r r100, @Query("b_type_new") int r101, @Query("sub_b_type") int r102, @Query("buy_render_shape") Integer r103, @Query("webcast_appid") String r104);
}
