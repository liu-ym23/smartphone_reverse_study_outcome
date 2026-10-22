package com.bytedance.rpc.transport.ttnet;

import com.bytedance.retrofit2.Call;
import com.bytedance.retrofit2.client.Header;
import com.bytedance.retrofit2.http.AddCommonParam;
import com.bytedance.retrofit2.http.Body;
import com.bytedance.retrofit2.http.ExtraInfo;
import com.bytedance.retrofit2.http.FieldMap;
import com.bytedance.retrofit2.http.FormUrlEncoded;
import com.bytedance.retrofit2.http.GET;
import com.bytedance.retrofit2.http.HeaderList;
import com.bytedance.retrofit2.http.POST;
import com.bytedance.retrofit2.http.QueryMap;
import com.bytedance.retrofit2.http.Streaming;
import com.bytedance.retrofit2.http.Url;
import com.bytedance.retrofit2.mime.TypedInput;
import com.bytedance.retrofit2.mime.TypedOutput;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
interface RetrofitApi {
    @FormUrlEncoded
    @POST
    @Streaming
    Call<TypedInput> form(@AddCommonParam boolean r1, @Url String r2, @QueryMap Map<String, String> r3, @FieldMap(encode = true) Map<String, String> r4, @HeaderList List<Header> r5, @ExtraInfo Object r6);

    @GET
    @Streaming
    Call<TypedInput> get(@AddCommonParam boolean r1, @Url String r2, @QueryMap(encode = true) Map<String, String> r3, @HeaderList List<Header> r4, @ExtraInfo Object r5);

    @POST
    @Streaming
    Call<TypedInput> post(@AddCommonParam boolean r1, @Url String r2, @QueryMap Map<String, String> r3, @Body TypedOutput r4, @HeaderList List<Header> r5, @ExtraInfo Object r6);
}
