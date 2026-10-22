package com.bytedance.article.common.network;

import com.bytedance.retrofit2.Call;
import com.bytedance.retrofit2.http.AddCommonParam;
import com.bytedance.retrofit2.http.Body;
import com.bytedance.retrofit2.http.FieldMap;
import com.bytedance.retrofit2.http.FormUrlEncoded;
import com.bytedance.retrofit2.http.GET;
import com.bytedance.retrofit2.http.HeaderList;
import com.bytedance.retrofit2.http.MaxLength;
import com.bytedance.retrofit2.http.POST;
import com.bytedance.retrofit2.http.Url;
import com.bytedance.retrofit2.mime.TypedInput;
import com.bytedance.retrofit2.mime.TypedOutput;
import g6.a;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public interface ICommonApi {
    @GET
    Call<String> get(@MaxLength int r10, @Url String r11, @HeaderList List<a> r12, @AddCommonParam boolean r13);

    @POST
    Call<String> postData(@MaxLength int r10, @Url String r11, @Body TypedOutput r12, @HeaderList List<a> r13, @AddCommonParam boolean r14);

    @POST
    Call<TypedInput> postDataStream(@MaxLength int r10, @Url String r11, @Body TypedOutput r12, @HeaderList List<a> r13, @AddCommonParam boolean r14);

    @FormUrlEncoded
    @POST
    Call<String> postForm(@MaxLength int r10, @Url String r11, @FieldMap(encode = true) Map<String, String> r12, @HeaderList List<a> r13, @AddCommonParam boolean r14);
}
