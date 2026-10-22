package com.bytedance.android.shopping.yata.ability;

import com.bytedance.kmp.ec.yata.view.render.controller.common.ContainerPosition;
import com.bytedance.retrofit2.Call;
import com.bytedance.retrofit2.client.Header;
import com.bytedance.retrofit2.http.Body;
import com.bytedance.retrofit2.http.GET;
import com.bytedance.retrofit2.http.HeaderList;
import com.bytedance.retrofit2.http.MaxLength;
import com.bytedance.retrofit2.http.POST;
import com.bytedance.retrofit2.http.QueryMap;
import com.bytedance.retrofit2.http.Url;
import com.bytedance.retrofit2.mime.TypedOutput;
import com.bytedance.ugc.glue.monitor.UGCMonitor;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import okhttp3.RequestBody;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001JO\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00042\u000e\b\u0001\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u001b\b\u0001\u0010\t\u001a\u0015\u0012\u0004\u0012\u00020\u0004\u0012\u000b\u0012\t\u0018\u00010\u0001¢\u0006\u0002\b\u000b0\n2\b\b\u0003\u0010\f\u001a\u00020\rH'J<\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00042\u000e\b\u0001\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\b\b\u0001\u0010\u000f\u001a\u00020\u00102\b\b\u0003\u0010\f\u001a\u00020\rH'J<\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00042\u000e\b\u0001\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\b\b\u0001\u0010\u000f\u001a\u00020\u00122\b\b\u0003\u0010\f\u001a\u00020\rH'¨\u0006\u0013"}, d2 = {"Lcom/bytedance/android/shopping/yata/ability/IYataNetworkAbilityApi;", "", MonitorConstants.CONNECT_TYPE_GET, "Lcom/bytedance/retrofit2/Call;", "", "url", "headerList", "", "Lcom/bytedance/retrofit2/client/Header;", "queryMap", "", "Lkotlin/jvm/JvmSuppressWildcards;", "maxLength", "", UGCMonitor.TYPE_POST, ContainerPosition.BODY, "Lokhttp3/RequestBody;", "postTypedByteOutput", "Lcom/bytedance/retrofit2/mime/TypedOutput;", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface IYataNetworkAbilityApi {
    @GET
    Call<String> get(@Url String r100, @HeaderList List<Header> r101, @QueryMap Map<String, Object> r102, @MaxLength int r103);

    @POST
    Call<String> post(@Url String r100, @HeaderList List<Header> r101, @Body RequestBody r102, @MaxLength int r103);

    @POST
    Call<String> postTypedByteOutput(@Url String r100, @HeaderList List<Header> r101, @Body TypedOutput r102, @MaxLength int r103);
}
