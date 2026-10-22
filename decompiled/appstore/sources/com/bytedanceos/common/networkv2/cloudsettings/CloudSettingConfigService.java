package com.bytedanceos.common.networkv2.cloudsettings;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Url;
import rx.Observable;

/* JADX INFO: loaded from: classes2.dex */
public interface CloudSettingConfigService {
    @GET
    Observable getSettingConfig(@Url String r10);

    @GET
    Call<ResponseBody> getSettingEntity(@Url String r10);
}
