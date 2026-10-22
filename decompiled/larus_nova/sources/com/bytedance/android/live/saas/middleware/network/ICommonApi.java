package com.bytedance.android.live.saas.middleware.network;

import com.bytedance.retrofit2.Call;
import com.bytedance.retrofit2.client.Header;
import com.bytedance.retrofit2.http.AddCommonParam;
import com.bytedance.retrofit2.http.Body;
import com.bytedance.retrofit2.http.ExtraInfo;
import com.bytedance.retrofit2.http.FieldMap;
import com.bytedance.retrofit2.http.FormUrlEncoded;
import com.bytedance.retrofit2.http.GET;
import com.bytedance.retrofit2.http.HeaderList;
import com.bytedance.retrofit2.http.MaxLength;
import com.bytedance.retrofit2.http.POST;
import com.bytedance.retrofit2.http.QueryMap;
import com.bytedance.retrofit2.http.Streaming;
import com.bytedance.retrofit2.http.Url;
import com.bytedance.retrofit2.mime.TypedInput;
import com.bytedance.retrofit2.mime.TypedOutput;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes47.dex */
public interface ICommonApi {
    @GET
    Call<String> get(@MaxLength int r100, @Url String r101, @HeaderList List<Header> r102, @AddCommonParam boolean r103);

    @GET
    Call<TypedInput> getRawPb(@AddCommonParam boolean r100, @MaxLength int r101, @Url String r102, @QueryMap(encode = true) Map<String, String> r103, @HeaderList List<Header> r104, @ExtraInfo Object r105);

    @GET
    @Streaming
    Call<TypedInput> getStream(@AddCommonParam boolean r100, @MaxLength int r101, @Url String r102, @QueryMap(encode = true) Map<String, String> r103, @HeaderList List<Header> r104, @ExtraInfo Object r105);

    @POST
    Call<String> postData(@MaxLength int r100, @Url String r101, @Body TypedOutput r102, @HeaderList List<Header> r103, @AddCommonParam boolean r104);

    @FormUrlEncoded
    @POST
    Call<String> postForm(@MaxLength int r100, @Url String r101, @FieldMap Map<String, String> r102, @HeaderList List<Header> r103, @AddCommonParam boolean r104);

    @POST
    @Streaming
    Call<TypedInput> postPbData(@MaxLength int r100, @Url String r101, @Body TypedOutput r102, @HeaderList List<Header> r103, @AddCommonParam boolean r104);

    @POST
    Call<TypedInput> postPbDataNoStream(@MaxLength int r100, @Url String r101, @Body TypedOutput r102, @HeaderList List<Header> r103, @AddCommonParam boolean r104);

    @FormUrlEncoded
    @POST
    Call<TypedInput> postRawPb(@MaxLength int r100, @Url String r101, @QueryMap Map<String, String> r102, @FieldMap(encode = true) Map<String, String> r103, @HeaderList List<Header> r104, @ExtraInfo Object r105);

    @FormUrlEncoded
    @POST
    @Streaming
    Call<TypedInput> postStream(@MaxLength int r100, @Url String r101, @QueryMap Map<String, String> r102, @FieldMap(encode = true) Map<String, String> r103, @HeaderList List<Header> r104, @ExtraInfo Object r105);
}
