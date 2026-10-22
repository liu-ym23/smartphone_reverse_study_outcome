package com.bytedanceos.appstore.buss.network.ad;

import com.bytedanceos.common.ad.entity.rep.RepAdEntity;
import com.bytedanceos.common.ad.entity.rep.media.RepSplashMediaEntity;
import kotlin.Metadata;
import kotlinx.coroutines.Deferred;
import okhttp3.RequestBody;
import org.jetbrains.annotations.NotNull;
import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.POST;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u0000 \u000b2\u00020\u0001:\u0001\fJ1\u0010\t\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u00060\u00050\u00042\b\b\u0001\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\t\u0010\n¨\u0006\r"}, d2 = {"Lcom/bytedanceos/appstore/buss/network/ad/AdService;", "", "Lokhttp3/RequestBody;", "json", "Lkotlinx/coroutines/Deferred;", "Lretrofit2/Response;", "Lcom/bytedanceos/appstore/buss/network/ad/AdHttpResult;", "Lcom/bytedanceos/common/ad/entity/rep/RepAdEntity;", "Lcom/bytedanceos/common/ad/entity/rep/media/RepSplashMediaEntity;", "getAd", "(Lokhttp3/RequestBody;)Lkotlinx/coroutines/Deferred;", "Companion", "a", "app_sysapp_updateRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public interface AdService {

    @NotNull
    public static final a Companion = null;

    @NotNull
    public static final String URL = "";

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f8786a = null;

        static {
            f8786a = new a();
        }

        public a() {
        }
    }

    static {
        Companion = a.f8786a;
    }

    @POST("ad")
    @NotNull
    Deferred<Response<AdHttpResult<RepAdEntity<RepSplashMediaEntity>>>> getAd(@Body @NotNull RequestBody r10);
}
