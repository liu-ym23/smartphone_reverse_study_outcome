package com.bytedance.android.livesdkapi.roomplayer;

import com.bytedance.retrofit2.Call;
import com.bytedance.retrofit2.http.Body;
import com.bytedance.retrofit2.http.GET;
import com.bytedance.retrofit2.http.HeaderMap;
import com.bytedance.retrofit2.http.POST;
import com.bytedance.retrofit2.http.Url;
import com.bytedance.retrofit2.mime.TypedByteArray;
import com.bytedance.retrofit2.mime.TypedInput;
import java.util.Map;

/* JADX INFO: loaded from: classes12.dex */
public interface ILivePlayerApi {
    @GET
    Call<TypedInput> get(@Url String r100, @HeaderMap Map<String, String> r101);

    @POST
    Call<TypedInput> post(@Url String r100, @Body TypedByteArray r101, @HeaderMap Map<String, String> r102);
}
