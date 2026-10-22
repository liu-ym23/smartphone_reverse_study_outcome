package com.bytedance.android.livesdk.test.network;

import com.bytedance.kmp.ec.yata.view.render.controller.common.ContainerPosition;
import com.bytedance.retrofit2.http.Body;
import com.bytedance.retrofit2.http.GET;
import com.bytedance.retrofit2.http.POST;
import com.bytedance.retrofit2.http.QueryMap;
import com.bytedance.retrofit2.http.Url;
import com.bytedance.ugc.glue.monitor.UGCMonitor;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import io.reactivex.Observable;
import java.util.Map;
import kotlin.Metadata;
import okhttp3.RequestBody;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u0004H'J.\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00042\u0014\b\u0001\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0007H'J\u0018\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u0004H'J\"\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00042\b\b\u0001\u0010\t\u001a\u00020\nH'¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/livesdk/test/network/IHttpApi;", "", MonitorConstants.CONNECT_TYPE_GET, "Lio/reactivex/Observable;", "", "url", "queryMap", "", UGCMonitor.TYPE_POST, ContainerPosition.BODY, "Lokhttp3/RequestBody;", "liveutility_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface IHttpApi {
    @GET
    Observable<String> get(@Url String r100);

    @GET
    Observable<String> get(@Url String r100, @QueryMap Map<String, String> r101);

    @POST
    Observable<String> post(@Url String r100);

    @POST
    Observable<String> post(@Url String r100, @Body RequestBody r101);
}
