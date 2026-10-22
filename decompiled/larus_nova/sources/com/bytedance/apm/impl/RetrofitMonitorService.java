package com.bytedance.apm.impl;

import com.bytedance.retrofit2.Call;
import com.bytedance.retrofit2.client.Header;
import com.bytedance.retrofit2.http.AddCommonParam;
import com.bytedance.retrofit2.http.Body;
import com.bytedance.retrofit2.http.GET;
import com.bytedance.retrofit2.http.HeaderList;
import com.bytedance.retrofit2.http.Multipart;
import com.bytedance.retrofit2.http.POST;
import com.bytedance.retrofit2.http.PartMap;
import com.bytedance.retrofit2.http.QueryMap;
import com.bytedance.retrofit2.http.Url;
import com.bytedance.retrofit2.mime.TypedInput;
import com.bytedance.retrofit2.mime.TypedOutput;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public interface RetrofitMonitorService {
    @GET
    Call<TypedInput> fetch(@Url String r100, @HeaderList List<Header> r101, @QueryMap Map<String, String> r102, @AddCommonParam boolean r103);

    @GET
    Call<TypedInput> fetch(@Url String r100, @QueryMap Map<String, String> r101, @AddCommonParam boolean r102);

    @POST
    Call<TypedInput> report(@Url String r100, @Body TypedOutput r101, @HeaderList List<Header> r102, @AddCommonParam boolean r103);

    @Multipart
    @POST
    Call<TypedInput> uploadFiles(@Url String r100, @PartMap Map<String, TypedOutput> r101, @HeaderList List<Header> r102);
}
