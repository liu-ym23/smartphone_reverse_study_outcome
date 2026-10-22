package com.bytedance.android.openlive.utils;

import com.bytedance.retrofit2.Call;
import com.bytedance.retrofit2.http.GET;
import com.bytedance.retrofit2.http.Url;
import com.bytedance.retrofit2.mime.TypedInput;

/* JADX INFO: loaded from: classes12.dex */
public interface TemplateApi {
    @GET
    Call<TypedInput> getTemplate(@Url String r100);
}
