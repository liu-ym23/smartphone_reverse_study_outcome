package com.bytedance.android.live.broadcastgame.opengame.cloud;

import com.bytedance.kmp.ec.yata.view.render.controller.common.ContainerPosition;
import com.bytedance.retrofit2.Call;
import com.bytedance.retrofit2.http.AddCommonParam;
import com.bytedance.retrofit2.http.Body;
import com.bytedance.retrofit2.http.DELETE;
import com.bytedance.retrofit2.http.GET;
import com.bytedance.retrofit2.http.HEAD;
import com.bytedance.retrofit2.http.HeaderMap;
import com.bytedance.retrofit2.http.MaxLength;
import com.bytedance.retrofit2.http.OPTIONS;
import com.bytedance.retrofit2.http.POST;
import com.bytedance.retrofit2.http.PUT;
import com.bytedance.retrofit2.http.QueryMap;
import com.bytedance.retrofit2.http.Url;
import com.bytedance.retrofit2.mime.TypedByteArray;
import com.bytedance.retrofit2.mime.TypedInput;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001Jb\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0003\u0010\u0005\u001a\u00020\u00062\b\b\u0003\u0010\u0007\u001a\u00020\b2\b\b\u0001\u0010\t\u001a\u00020\n2\u0014\b\u0001\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\f2\u0014\b\u0001\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\f2\b\b\u0003\u0010\u000e\u001a\u00020\u000fH'JX\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0003\u0010\u0005\u001a\u00020\u00062\b\b\u0003\u0010\u0007\u001a\u00020\b2\b\b\u0001\u0010\t\u001a\u00020\n2\u0014\b\u0001\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\f2\u0014\b\u0001\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\fH'JX\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00120\u00032\b\b\u0003\u0010\u0005\u001a\u00020\u00062\b\b\u0003\u0010\u0007\u001a\u00020\b2\b\b\u0001\u0010\t\u001a\u00020\n2\u0014\b\u0001\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\f2\u0014\b\u0001\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\fH'Jb\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0003\u0010\u0005\u001a\u00020\u00062\b\b\u0003\u0010\u0007\u001a\u00020\b2\b\b\u0001\u0010\t\u001a\u00020\n2\u0014\b\u0001\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\f2\u0014\b\u0001\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\f2\b\b\u0003\u0010\u000e\u001a\u00020\u000fH'Jb\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0003\u0010\u0005\u001a\u00020\u00062\b\b\u0003\u0010\u0007\u001a\u00020\b2\b\b\u0001\u0010\t\u001a\u00020\n2\u0014\b\u0001\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\f2\u0014\b\u0001\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\f2\b\b\u0003\u0010\u000e\u001a\u00020\u000fH'Jb\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0003\u0010\u0005\u001a\u00020\u00062\b\b\u0003\u0010\u0007\u001a\u00020\b2\b\b\u0001\u0010\t\u001a\u00020\n2\u0014\b\u0001\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\f2\u0014\b\u0001\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\f2\b\b\u0003\u0010\u000e\u001a\u00020\u000fH'¨\u0006\u0016"}, d2 = {"Lcom/bytedance/android/live/broadcastgame/opengame/cloud/ICloudNetworkApi;", "", "doDelete", "Lcom/bytedance/retrofit2/Call;", "Lcom/bytedance/retrofit2/mime/TypedInput;", "addCommonParam", "", "maxLength", "", "url", "", "headMap", "", "queryMap", ContainerPosition.BODY, "Lcom/bytedance/retrofit2/mime/TypedByteArray;", "doGet", "doHead", "", "doOptions", "doPost", "doPut", "livebroadcastgame-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface ICloudNetworkApi {
    @DELETE
    Call<TypedInput> doDelete(@AddCommonParam boolean r100, @MaxLength int r101, @Url String r102, @HeaderMap Map<String, String> r103, @QueryMap Map<String, String> r104, @Body TypedByteArray r105);

    @GET
    Call<TypedInput> doGet(@AddCommonParam boolean r100, @MaxLength int r101, @Url String r102, @HeaderMap Map<String, String> r103, @QueryMap Map<String, String> r104);

    @HEAD
    Call<Unit> doHead(@AddCommonParam boolean r100, @MaxLength int r101, @Url String r102, @HeaderMap Map<String, String> r103, @QueryMap Map<String, String> r104);

    @OPTIONS
    Call<TypedInput> doOptions(@AddCommonParam boolean r100, @MaxLength int r101, @Url String r102, @HeaderMap Map<String, String> r103, @QueryMap Map<String, String> r104, @Body TypedByteArray r105);

    @POST
    Call<TypedInput> doPost(@AddCommonParam boolean r100, @MaxLength int r101, @Url String r102, @HeaderMap Map<String, String> r103, @QueryMap Map<String, String> r104, @Body TypedByteArray r105);

    @PUT
    Call<TypedInput> doPut(@AddCommonParam boolean r100, @MaxLength int r101, @Url String r102, @HeaderMap Map<String, String> r103, @QueryMap Map<String, String> r104, @Body TypedByteArray r105);
}
