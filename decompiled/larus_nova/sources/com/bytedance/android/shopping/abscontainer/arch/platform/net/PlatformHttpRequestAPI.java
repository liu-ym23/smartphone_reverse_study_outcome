package com.bytedance.android.shopping.abscontainer.arch.platform.net;

import com.bytedance.kmp.ec.yata.view.render.controller.common.ContainerPosition;
import com.bytedance.retrofit2.SsResponse;
import com.bytedance.retrofit2.http.Body;
import com.bytedance.retrofit2.http.GET;
import com.bytedance.retrofit2.http.POST;
import com.bytedance.retrofit2.http.Url;
import com.bytedance.ugc.glue.monitor.UGCMonitor;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import io.reactivex.Observable;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J;\u0010\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00032\b\b\u0001\u0010\u0006\u001a\u00020\u00052\u001b\b\u0001\u0010\u0007\u001a\u0015\u0012\u0004\u0012\u00020\u0005\u0012\u000b\u0012\t\u0018\u00010\u0001¢\u0006\u0002\b\t0\bH'J;\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00032\b\b\u0001\u0010\u0006\u001a\u00020\u00052\u001b\b\u0001\u0010\u0007\u001a\u0015\u0012\u0004\u0012\u00020\u0005\u0012\u000b\u0012\t\u0018\u00010\u0001¢\u0006\u0002\b\t0\bH'¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/shopping/abscontainer/arch/platform/net/PlatformHttpRequestAPI;", "", MonitorConstants.CONNECT_TYPE_GET, "Lio/reactivex/Observable;", "Lcom/bytedance/retrofit2/SsResponse;", "", "path", ContainerPosition.BODY, "", "Lkotlin/jvm/JvmSuppressWildcards;", UGCMonitor.TYPE_POST, "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface PlatformHttpRequestAPI {
    @GET
    Observable<SsResponse<String>> get(@Url String r100, @Body Map<String, Object> r101);

    @POST
    Observable<SsResponse<String>> post(@Url String r100, @Body Map<String, Object> r101);
}
