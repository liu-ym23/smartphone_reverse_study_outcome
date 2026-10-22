package com.bytedance.android.ec.core.vmsdk.module;

import com.bytedance.android.ec.sdk.helper.n;
import com.bytedance.retrofit2.Call;
import com.bytedance.retrofit2.http.FieldMap;
import com.bytedance.retrofit2.http.FormUrlEncoded;
import com.bytedance.retrofit2.http.GET;
import com.bytedance.retrofit2.http.HeaderMap;
import com.bytedance.retrofit2.http.POST;
import com.bytedance.retrofit2.http.QueryMap;
import com.bytedance.retrofit2.http.Url;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001:\u0001\u000bJH\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00020\u00072\b\b\u0001\u0010\u0003\u001a\u00020\u00022\u0016\b\u0001\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00042\u0016\b\u0001\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0004H'J`\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00020\u00072\b\b\u0001\u0010\u0003\u001a\u00020\u00022\u0016\b\u0001\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00042\u0016\b\u0001\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00042\u0016\b\u0001\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0004H'¨\u0006\f"}, d2 = {"Lcom/bytedance/android/ec/core/vmsdk/module/VmSdkApi;", "", "", "url", "", "headers", "params", "Lcom/bytedance/retrofit2/Call;", "fetchGet", "queryParams", "fetchPost", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface VmSdkApi {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f45793a = null;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final VmSdkApi f45794a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ a f45795b = null;

        public a() {
        }

        static {
            f45795b = new a();
            f45794a = (VmSdkApi) n.f48128a.create("https://ecom.snssdk.com", VmSdkApi.class);
        }
    }

    static {
        f45793a = a.f45795b;
    }

    @GET
    Call<String> fetchGet(@Url String r100, @HeaderMap Map<String, String> r101, @QueryMap Map<String, String> r102);

    @FormUrlEncoded
    @POST
    Call<String> fetchPost(@Url String r100, @HeaderMap Map<String, String> r101, @QueryMap Map<String, String> r102, @FieldMap Map<String, String> r103);
}
