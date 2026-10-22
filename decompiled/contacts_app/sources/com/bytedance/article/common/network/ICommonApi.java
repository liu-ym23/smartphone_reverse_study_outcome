package com.bytedance.article.common.network;

import com.bytedance.retrofit2.Call;
import com.bytedance.retrofit2.client.Header;
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
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public interface ICommonApi {
    @GET
    Call<String> get(@MaxLength int r1, @Url String r2, @HeaderList List<Header> r3, @AddCommonParam boolean r4);

    @POST
    Call<String> postData(@MaxLength int r1, @Url String r2, @Body TypedOutput r3, @HeaderList List<Header> r4, @AddCommonParam boolean r5);

    @POST
    Call<TypedInput> postDataStream(@MaxLength int r1, @Url String r2, @Body TypedOutput r3, @HeaderList List<Header> r4, @AddCommonParam boolean r5);

    @FormUrlEncoded
    @POST
    Call<String> postForm(@MaxLength int r1, @Url String r2, @FieldMap(encode = true) Map<String, String> r3, @HeaderList List<Header> r4, @AddCommonParam boolean r5);
}
