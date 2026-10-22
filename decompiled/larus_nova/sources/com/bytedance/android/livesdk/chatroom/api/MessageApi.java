package com.bytedance.android.livesdk.chatroom.api;

import am3.f;
import com.bytedance.retrofit2.Call;
import com.bytedance.retrofit2.http.Field;
import com.bytedance.retrofit2.http.FieldMap;
import com.bytedance.retrofit2.http.FormUrlEncoded;
import com.bytedance.retrofit2.http.POST;
import com.bytedance.retrofit2.http.Query;
import com.bytedance.retrofit2.http.Url;
import java.util.Map;

/* JADX INFO: loaded from: classes7.dex */
public interface MessageApi {
    @FormUrlEncoded
    @POST("/webcast/im/fetch/")
    Call<f> fetchMessagePbByteArraySource(@Field("room_id") long r100, @Field("fetch_rule") int r101, @FieldMap Map<String, String> r102, @Query("keep_method") String r103);

    @FormUrlEncoded
    @POST
    Call<f> fetchMessagePbByteArraySource(@Url String r100, @FieldMap Map<String, String> r101, @Query("keep_method") String r102);
}
