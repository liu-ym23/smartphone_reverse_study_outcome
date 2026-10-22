package com.bytedance.android.shopping.anchorv4.event_chain.custom_event.v2;

import com.bytedance.retrofit2.Call;
import com.bytedance.retrofit2.http.FieldMap;
import com.bytedance.retrofit2.http.FormUrlEncoded;
import com.bytedance.retrofit2.http.GET;
import com.bytedance.retrofit2.http.POST;
import com.bytedance.retrofit2.http.QueryMap;
import com.bytedance.retrofit2.http.Url;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001:\u0001\nJ0\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00020\u00062\b\b\u0001\u0010\u0003\u001a\u00020\u00022\u0016\b\u0001\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0004H'J0\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00020\u00062\b\b\u0001\u0010\u0003\u001a\u00020\u00022\u0016\b\u0001\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0004H'¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/event_chain/custom_event/v2/PDPFetchDataApi;", "", "", "url", "", "params", "Lcom/bytedance/retrofit2/Call;", "fetchGet", "bodyParams", "fetchPost", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface PDPFetchDataApi {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f166579a = null;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final PDPFetchDataApi f166580a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ a f166581b = null;

        public a() {
        }

        static {
            f166581b = new a();
            f166580a = (PDPFetchDataApi) com.bytedance.android.ec.sdk.helper.n.f48128a.create(com.bytedance.android.shopping.utils.k.a(), PDPFetchDataApi.class);
        }
    }

    static {
        f166579a = a.f166581b;
    }

    @GET
    Call<String> fetchGet(@Url String r100, @QueryMap Map<String, String> r101);

    @FormUrlEncoded
    @POST
    Call<String> fetchPost(@Url String r100, @FieldMap Map<String, String> r101);
}
