package com.bytedance.android.shopping.store.hybrid.api;

import com.bytedance.android.ec.sdk.helper.n;
import com.bytedance.retrofit2.Call;
import com.bytedance.retrofit2.http.GET;
import com.bytedance.retrofit2.http.Path;
import com.bytedance.retrofit2.http.Query;
import com.bytedance.retrofit2.http.QueryMap;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001:\u0001\u000eJf\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00020\f2\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0004\u001a\u00020\u00022\b\b\u0001\u0010\u0006\u001a\u00020\u00052\n\b\u0001\u0010\u0007\u001a\u0004\u0018\u00010\u00022\n\b\u0001\u0010\b\u001a\u0004\u0018\u00010\u00022\b\b\u0003\u0010\t\u001a\u00020\u00022\u0016\b\u0001\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\nH'¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/shopping/store/hybrid/api/ECStoreHybridTabApi;", "", "", "apiPath", "secShopId", "", "tabType", "passThroughApi", "localDecorationChannels", "clientExperimentList", "", "extraParams", "Lcom/bytedance/retrofit2/Call;", "getInitialDataRaw", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface ECStoreHybridTabApi {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f184820a = null;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final ECStoreHybridTabApi f184821a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ a f184822b = null;

        public a() {
        }

        static {
            f184822b = new a();
            f184821a = (ECStoreHybridTabApi) n.f48128a.create(gn.a.b(), ECStoreHybridTabApi.class);
        }
    }

    static {
        f184820a = a.f184822b;
    }

    @GET("{api_path}")
    Call<String> getInitialDataRaw(@Path(encode = false, value = "api_path") String r100, @Query("sec_shop_id") String r101, @Query("tab_type") int r102, @Query(com.bytedance.android.ec.core.event.a.KEY_PASS_THROUGH_API) String r103, @Query("local_decoration_channels") String r104, @Query("client_experiment_list") String r105, @QueryMap Map<String, String> r106);
}
