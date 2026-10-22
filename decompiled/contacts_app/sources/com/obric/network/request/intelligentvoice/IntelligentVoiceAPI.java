package com.obric.network.request.intelligentvoice;

import com.bytedance.retrofit2.Call;
import com.bytedance.retrofit2.http.Body;
import com.bytedance.retrofit2.http.GET;
import com.bytedance.retrofit2.http.Header;
import com.bytedance.retrofit2.http.POST;
import com.bytedance.retrofit2.http.Query;
import com.obric.network.request.data.DataResponse;
import kotlin.Metadata;
import okhttp3.MultipartBody;
import org.json.JSONObject;

/* JADX INFO: compiled from: IntelligentVoiceAPI.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J0\u0010\u0002\u001a\u0014\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\u0004\u0018\u00010\u00032\n\b\u0001\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\b\u0001\u0010\b\u001a\u00020\tH'J&\u0010\n\u001a\u0014\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0018\u00010\u0004\u0018\u00010\u00032\n\b\u0001\u0010\u0006\u001a\u0004\u0018\u00010\u0007H'J2\u0010\f\u001a\u0014\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\r\u0018\u00010\u0004\u0018\u00010\u00032\n\b\u0001\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0001\u0010\u000e\u001a\u0004\u0018\u00010\u0007H'J.\u0010\u000f\u001a\u0012\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\u0010\u0018\u00010\u00040\u00032\n\b\u0001\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\b\u0001\u0010\b\u001a\u00020\u0011H'J:\u0010\u0012\u001a\u0012\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\u0013\u0018\u00010\u00040\u00032\n\b\u0001\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\b\u0001\u0010\u0014\u001a\u00020\u00072\n\b\u0001\u0010\u0015\u001a\u0004\u0018\u00010\u0016H'¨\u0006\u0017"}, d2 = {"Lcom/obric/network/request/intelligentvoice/IntelligentVoiceAPI;", "", "deleteSound", "Lcom/bytedance/retrofit2/Call;", "Lcom/obric/network/request/data/DataResponse;", "Lorg/json/JSONObject;", "idAttestation", "", "message", "Lcom/obric/network/request/intelligentvoice/SoundDeleteRequestBody;", "getSoundCopyText", "Lcom/obric/network/request/intelligentvoice/SoundCopyTextResponseBody;", "getSoundList", "Lcom/obric/network/request/intelligentvoice/SoundListGetResponseBody;", "soundVersion", "soundCopy", "Lcom/obric/network/request/intelligentvoice/SoundCopyResponseBody;", "Lcom/obric/network/request/intelligentvoice/SoundCopyRequestBody;", "uploadFile", "Lcom/obric/network/request/intelligentvoice/SoundFailResponseBody;", "contentLength", "body", "Lokhttp3/MultipartBody;", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface IntelligentVoiceAPI {
    @POST("/phone/api/v2/sound/delete")
    Call<DataResponse<JSONObject>> deleteSound(@Header("x-att-certchain") String r1, @Body SoundDeleteRequestBody r2);

    @GET("/phone/api/v2/sound/copy_text")
    Call<DataResponse<SoundCopyTextResponseBody>> getSoundCopyText(@Header("x-att-certchain") String r1);

    @GET("/phone/api/v2/sound/get")
    Call<DataResponse<SoundListGetResponseBody>> getSoundList(@Header("x-att-certchain") String r1, @Query("sound_version") String r2);

    @POST("/phone/api/v2/sound/copy")
    Call<DataResponse<SoundCopyResponseBody>> soundCopy(@Header("x-att-certchain") String r1, @Body SoundCopyRequestBody r2);

    @POST("/phone/api/v2/file/upload")
    Call<DataResponse<SoundFailResponseBody>> uploadFile(@Header("x-att-certchain") String r1, @Header("Content-Length") String r2, @Body MultipartBody r3);
}
