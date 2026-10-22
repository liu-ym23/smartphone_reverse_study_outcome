package com.bytedance.apm.impl;

import com.bytedance.retrofit2.Call;
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
import g6.a;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public interface RetrofitMonitorService {
    @GET
    Call<TypedInput> fetch(@Url String r10, @QueryMap Map<String, String> r11, @AddCommonParam boolean r12);

    @POST
    Call<TypedInput> report(@Url String r10, @Body TypedOutput r11, @HeaderList List<a> r12, @AddCommonParam boolean r13);

    @Multipart
    @POST
    Call<TypedInput> uploadFiles(@Url String r10, @PartMap Map<String, TypedOutput> r11, @HeaderList List<a> r12);
}
