package com.bytedance.android.live.lynx.components;

import com.bytedance.retrofit2.Call;
import com.bytedance.retrofit2.http.GET;
import com.bytedance.retrofit2.http.Url;
import com.bytedance.retrofit2.mime.TypedInput;

/* JADX INFO: loaded from: classes46.dex */
public interface TemplateApi {
    @GET
    Call<TypedInput> getTemplate(@Url String r100);
}
