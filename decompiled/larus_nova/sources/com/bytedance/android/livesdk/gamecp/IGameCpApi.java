package com.bytedance.android.livesdk.gamecp;

import com.bytedance.kmp.ec.yata.view.render.controller.common.ContainerPosition;
import com.bytedance.retrofit2.Call;
import com.bytedance.retrofit2.http.AddCommonParam;
import com.bytedance.retrofit2.http.Body;
import com.bytedance.retrofit2.http.ExtraInfo;
import com.bytedance.retrofit2.http.GET;
import com.bytedance.retrofit2.http.HeaderMap;
import com.bytedance.retrofit2.http.MaxLength;
import com.bytedance.retrofit2.http.POST;
import com.bytedance.retrofit2.http.Streaming;
import com.bytedance.retrofit2.http.Url;
import com.bytedance.retrofit2.mime.TypedByteArray;
import com.bytedance.retrofit2.mime.TypedInput;
import com.bytedance.retrofit2.mime.TypedOutput;
import com.bytedance.ugc.glue.monitor.UGCMonitor;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001JP\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\b2\b\b\u0001\u0010\t\u001a\u00020\n2\u0014\b\u0001\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\f2\n\b\u0001\u0010\r\u001a\u0004\u0018\u00010\u0001H'J1\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\b\b\u0001\u0010\u000f\u001a\u00020\n2\u0014\b\u0001\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\fH§\u0002JB\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\b\b\u0001\u0010\u000f\u001a\u00020\n2\u0014\b\u0001\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\f2\n\b\u0001\u0010\u0010\u001a\u0004\u0018\u00010\u0006H§\u0002¢\u0006\u0002\u0010\u0011J:\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\b\b\u0001\u0010\u000f\u001a\u00020\n2\b\b\u0001\u0010\u0013\u001a\u00020\u00142\u0014\b\u0001\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\fH'JK\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\b\b\u0001\u0010\u000f\u001a\u00020\n2\b\b\u0001\u0010\u0013\u001a\u00020\u00142\u0014\b\u0001\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\f2\n\b\u0001\u0010\u0010\u001a\u0004\u0018\u00010\u0006H'¢\u0006\u0002\u0010\u0015JD\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\b\b\u0001\u0010\u0007\u001a\u00020\b2\b\b\u0001\u0010\t\u001a\u00020\n2\u0014\b\u0001\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\f2\b\b\u0001\u0010\u0013\u001a\u00020\u0017H'¨\u0006\u0018"}, d2 = {"Lcom/bytedance/android/livesdk/gamecp/IGameCpApi;", "", "downloadFile", "Lcom/bytedance/retrofit2/Call;", "Lcom/bytedance/retrofit2/mime/TypedInput;", "addCommonPara", "", "maxLength", "", "relativePath", "", "map", "", "extraInfo", MonitorConstants.CONNECT_TYPE_GET, "url", "addCommonParam", "(Ljava/lang/String;Ljava/util/Map;Ljava/lang/Boolean;)Lcom/bytedance/retrofit2/Call;", UGCMonitor.TYPE_POST, ContainerPosition.BODY, "Lcom/bytedance/retrofit2/mime/TypedByteArray;", "(Ljava/lang/String;Lcom/bytedance/retrofit2/mime/TypedByteArray;Ljava/util/Map;Ljava/lang/Boolean;)Lcom/bytedance/retrofit2/Call;", "postMultiPart", "Lcom/bytedance/retrofit2/mime/TypedOutput;", "live-impl-saas_release"}, k = 1, mv = {1, 4, 3})
public interface IGameCpApi {
    @GET
    @Streaming
    Call<TypedInput> downloadFile(@AddCommonParam boolean r100, @MaxLength int r101, @Url String r102, @HeaderMap Map<String, String> r103, @ExtraInfo Object r104);

    @GET
    Call<TypedInput> get(@Url String r100, @HeaderMap Map<String, String> r101);

    @GET
    Call<TypedInput> get(@Url String r100, @HeaderMap Map<String, String> r101, @AddCommonParam Boolean r102);

    @POST
    Call<TypedInput> post(@Url String r100, @Body TypedByteArray r101, @HeaderMap Map<String, String> r102);

    @POST
    Call<TypedInput> post(@Url String r100, @Body TypedByteArray r101, @HeaderMap Map<String, String> r102, @AddCommonParam Boolean r103);

    @POST
    Call<TypedInput> postMultiPart(@MaxLength int r100, @Url String r101, @HeaderMap Map<String, String> r102, @Body TypedOutput r103);
}
