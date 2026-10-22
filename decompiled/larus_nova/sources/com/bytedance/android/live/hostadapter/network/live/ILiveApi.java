package com.bytedance.android.live.hostadapter.network.live;

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
import com.bytedance.retrofit2.http.Streaming;
import com.bytedance.retrofit2.http.Url;
import com.bytedance.retrofit2.mime.TypedByteArray;
import com.bytedance.retrofit2.mime.TypedInput;
import com.bytedance.retrofit2.mime.TypedOutput;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes45.dex */
public interface ILiveApi {
    @FormUrlEncoded
    @POST
    Call<TypedInput> doPost(@Url String r100, @HeaderList List<Header> r101, @FieldMap Map<String, String> r102);

    @GET
    @Streaming
    Call<TypedInput> downloadFile(@AddCommonParam boolean r100, @MaxLength int r101, @Url String r102, @HeaderList List<Header> r103, @ExtraInfo Object r104);

    @GET
    Call<TypedInput> get(@Url String r100, @HeaderList List<Header> r101);

    @POST
    Call<TypedInput> post(@Url String r100, @Body TypedByteArray r101, @HeaderList List<Header> r102);

    @POST
    Call<TypedInput> postMultiPart(@MaxLength int r100, @Url String r101, @HeaderList List<Header> r102, @Body TypedOutput r103);
}
