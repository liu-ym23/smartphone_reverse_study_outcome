package com.obric.appstore.network;

import com.bytedanceos.common.ui.AppPermissionActivity;
import com.obric.appstore.network.entity.AppDetailReq;
import com.obric.appstore.network.entity.AppDetailResp;
import com.obric.appstore.network.entity.AppInfoResp;
import com.obric.appstore.network.entity.CategoryListReq;
import com.obric.appstore.network.entity.CategoryListResp;
import com.obric.appstore.network.entity.CommonAppEntity;
import com.obric.appstore.network.entity.DevelopAppsReq;
import com.obric.appstore.network.entity.HotWordsReq;
import com.obric.appstore.network.entity.HttpResp;
import com.obric.appstore.network.entity.LocalAppsOnlineReq;
import com.obric.appstore.network.entity.PageAppsResp;
import com.obric.appstore.network.entity.PageListResp;
import com.obric.appstore.network.entity.PageReq;
import com.obric.appstore.network.entity.PageTypeReq;
import com.obric.appstore.network.entity.SearchAppsReq;
import com.obric.appstore.network.entity.SearchSuggestReq;
import com.obric.appstore.network.entity.SearchSuggestResp;
import com.obric.appstore.network.entity.SysAppAutoUpdateReportReq;
import com.obric.appstore.network.entity.TemplateResp;
import com.obric.appstore.network.entity.UpdateAppListReq;
import com.obric.appstore.network.entity.UpdateAppListResp;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlinx.coroutines.Deferred;
import org.jetbrains.annotations.NotNull;
import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Query;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000¶\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\bf\u0018\u0000 D2\u00020\u0001:\u0001EJ1\u0010\t\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u00060\u00050\u00042\b\b\u0001\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\t\u0010\nJE\u0010\u000f\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u00060\u00050\u00042\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\f\u001a\u00020\u000b2\b\b\u0001\u0010\u000e\u001a\u00020\rH'¢\u0006\u0004\b\u000f\u0010\u0010J5\u0010\u0014\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130\u00060\u00050\u00042\b\b\u0001\u0010\u0012\u001a\u00020\u00112\b\b\u0001\u0010\u000e\u001a\u00020\rH'¢\u0006\u0004\b\u0014\u0010\u0015J+\u0010\u0019\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00180\u00060\u00050\u00042\b\b\u0001\u0010\u0017\u001a\u00020\u0016H'¢\u0006\u0004\b\u0019\u0010\u001aJ+\u0010\u001e\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001d0\u00060\u00050\u00042\b\b\u0001\u0010\u001c\u001a\u00020\u001bH'¢\u0006\u0004\b\u001e\u0010\u001fJ1\u0010#\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\"0!0\u00060\u00050\u00042\b\b\u0001\u0010\u001c\u001a\u00020 H'¢\u0006\u0004\b#\u0010$J+\u0010(\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020'0\u00060\u00050\u00042\b\b\u0001\u0010&\u001a\u00020%H'¢\u0006\u0004\b(\u0010)J1\u0010,\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\"0!0\u00060\u00050\u00042\b\b\u0001\u0010+\u001a\u00020*H'¢\u0006\u0004\b,\u0010-J;\u00101\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b000\u00060\u00050\u00042\b\b\u0001\u0010.\u001a\u00020\u000b2\b\b\u0003\u0010/\u001a\u00020\u000bH'¢\u0006\u0004\b1\u00102J+\u00106\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002050\u00060\u00050\u00042\b\b\u0001\u00104\u001a\u000203H'¢\u0006\u0004\b6\u00107J1\u0010;\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020:000\u00060\u00050\u00042\b\b\u0001\u00109\u001a\u000208H'¢\u0006\u0004\b;\u0010<J+\u0010@\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020?0\u00060\u00050\u00042\b\b\u0001\u0010>\u001a\u00020=H'¢\u0006\u0004\b@\u0010AJ1\u0010B\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020?0\u00060\u00050\u00042\u000e\b\u0001\u0010>\u001a\b\u0012\u0004\u0012\u00020=00H'¢\u0006\u0004\bB\u0010C¨\u0006F"}, d2 = {"Lcom/obric/appstore/network/StoreService;", "", "Lcom/obric/appstore/network/entity/PageTypeReq;", "pageType", "Lkotlinx/coroutines/Deferred;", "Lretrofit2/Response;", "Lcom/obric/appstore/network/entity/HttpResp;", "Lcom/obric/appstore/network/entity/PageListResp;", "Lcom/obric/appstore/network/entity/TemplateResp;", "getPageApps", "(Lcom/obric/appstore/network/entity/PageTypeReq;)Lkotlinx/coroutines/Deferred;", "", "postfix", "", "expired", "getPageAppsWithCache", "(Lcom/obric/appstore/network/entity/PageTypeReq;Ljava/lang/String;I)Lkotlinx/coroutines/Deferred;", "Lcom/obric/appstore/network/entity/PageReq;", "pageReq", "Lcom/obric/appstore/network/entity/HotWordsReq;", "getSearchHotWords", "(Lcom/obric/appstore/network/entity/PageReq;I)Lkotlinx/coroutines/Deferred;", "Lcom/obric/appstore/network/entity/CategoryListReq;", "categoryListReq", "Lcom/obric/appstore/network/entity/CategoryListResp;", "getCategoryFirst", "(Lcom/obric/appstore/network/entity/CategoryListReq;)Lkotlinx/coroutines/Deferred;", "Lcom/obric/appstore/network/entity/AppDetailReq;", "appDetailReq", "Lcom/obric/appstore/network/entity/AppDetailResp;", "getAppDetail", "(Lcom/obric/appstore/network/entity/AppDetailReq;)Lkotlinx/coroutines/Deferred;", "Lcom/obric/appstore/network/entity/DevelopAppsReq;", "Lcom/obric/appstore/network/entity/PageAppsResp;", "Lcom/obric/appstore/network/entity/CommonAppEntity;", "getDevelopApps", "(Lcom/obric/appstore/network/entity/DevelopAppsReq;)Lkotlinx/coroutines/Deferred;", "Lcom/obric/appstore/network/entity/SearchSuggestReq;", "searchSuggestReq", "Lcom/obric/appstore/network/entity/SearchSuggestResp;", "getSearchSuggestApps", "(Lcom/obric/appstore/network/entity/SearchSuggestReq;)Lkotlinx/coroutines/Deferred;", "Lcom/obric/appstore/network/entity/SearchAppsReq;", "searchAppsReq", "getSearchApps", "(Lcom/obric/appstore/network/entity/SearchAppsReq;)Lkotlinx/coroutines/Deferred;", AppPermissionActivity.EXTRA_APP_PKG, "appId", "", "getAppPerms", "(Ljava/lang/String;Ljava/lang/String;)Lkotlinx/coroutines/Deferred;", "Lcom/obric/appstore/network/entity/UpdateAppListReq;", "updateAppListReq", "Lcom/obric/appstore/network/entity/UpdateAppListResp;", "updateAppList", "(Lcom/obric/appstore/network/entity/UpdateAppListReq;)Lkotlinx/coroutines/Deferred;", "Lcom/obric/appstore/network/entity/LocalAppsOnlineReq;", "localAppsOnlineReq", "Lcom/obric/appstore/network/entity/AppInfoResp;", "getLocalAppsOnline", "(Lcom/obric/appstore/network/entity/LocalAppsOnlineReq;)Lkotlinx/coroutines/Deferred;", "Lcom/obric/appstore/network/entity/SysAppAutoUpdateReportReq;", "reportReq", "", "sysAppAutoUpdateReport", "(Lcom/obric/appstore/network/entity/SysAppAutoUpdateReportReq;)Lkotlinx/coroutines/Deferred;", "sysAppAutoUpdateReportBatch", "(Ljava/util/List;)Lkotlinx/coroutines/Deferred;", "Companion", "a", "obriccommon_sysapp_updateRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public interface StoreService {

    @NotNull
    public static final a Companion = null;

    @NotNull
    public static final String URL = "https://platform-api.obriccloud.com";

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f10960a = null;

        static {
            f10960a = new a();
        }

        public a() {
        }
    }

    public static final class b {
        public static /* synthetic */ Deferred a(StoreService r10, String r11, String r12, int r13, Object r14) {
            if (r14 != null) goto L9;
            if ((r13 & 2) == 0) goto L7;
            r12 = "ocean_store";
        L7:
            return r10.getAppPerms(r11, r12);
        L9:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getAppPerms");
        }
    }

    static {
        Companion = a.f10960a;
    }

    @POST("/api/business/v1/app/info")
    @NotNull
    Deferred<Response<HttpResp<AppDetailResp>>> getAppDetail(@Body @NotNull AppDetailReq r10);

    @GET("/api/business/v1/app/permission")
    @NotNull
    Deferred<Response<HttpResp<List<String>>>> getAppPerms(@NotNull @Query("package") String r10, @NotNull @Query("app_id") String r11);

    @POST("/api/business/v1/category/first")
    @NotNull
    Deferred<Response<HttpResp<CategoryListResp>>> getCategoryFirst(@Body @NotNull CategoryListReq r10);

    @POST("/api/business/v1/dev/apps")
    @NotNull
    Deferred<Response<HttpResp<PageAppsResp<CommonAppEntity>>>> getDevelopApps(@Body @NotNull DevelopAppsReq r10);

    @POST("api/business/v1/app/list")
    @NotNull
    Deferred<Response<HttpResp<List<AppInfoResp>>>> getLocalAppsOnline(@Body @NotNull LocalAppsOnlineReq r10);

    @POST("/api/business/v1/page/apps")
    @NotNull
    Deferred<Response<HttpResp<PageListResp<TemplateResp>>>> getPageApps(@Body @NotNull PageTypeReq r10);

    @POST("/api/business/v1/page/apps")
    @NotNull
    Deferred<Response<HttpResp<PageListResp<TemplateResp>>>> getPageAppsWithCache(@Body @NotNull PageTypeReq r10, @NotNull @Query("obric_cache_key_postfix") String r11, @Header("obric_cache_expired") int r12);

    @POST("/api/business/v1/search/apps")
    @NotNull
    Deferred<Response<HttpResp<PageAppsResp<CommonAppEntity>>>> getSearchApps(@Body @NotNull SearchAppsReq r10);

    @POST("/api/business/v1/search/hotwords")
    @NotNull
    Deferred<Response<HttpResp<HotWordsReq>>> getSearchHotWords(@Body @NotNull PageReq r10, @Header("obric_cache_expired") int r11);

    @POST("/api/business/v1/search/suggest")
    @NotNull
    Deferred<Response<HttpResp<SearchSuggestResp>>> getSearchSuggestApps(@Body @NotNull SearchSuggestReq r10);

    @POST("api/business/v1/update/reportUpgrade")
    @NotNull
    Deferred<Response<HttpResp<Unit>>> sysAppAutoUpdateReport(@Body @NotNull SysAppAutoUpdateReportReq r10);

    @POST("api/business/v1/update/batchReportUpgrade")
    @NotNull
    Deferred<Response<HttpResp<Unit>>> sysAppAutoUpdateReportBatch(@Body @NotNull List<SysAppAutoUpdateReportReq> r10);

    @POST("/api/business/v1/update/apps")
    @NotNull
    Deferred<Response<HttpResp<UpdateAppListResp>>> updateAppList(@Body @NotNull UpdateAppListReq r10);
}
