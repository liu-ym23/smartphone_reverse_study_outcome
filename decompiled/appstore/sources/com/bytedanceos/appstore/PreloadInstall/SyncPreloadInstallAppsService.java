package com.bytedanceos.appstore.PreloadInstall;

import java.util.Map;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;
import rx.Observable;

/* JADX INFO: loaded from: classes2.dex */
public interface SyncPreloadInstallAppsService {
    @GET("api/v1/ota/pre-install")
    Observable getNeedInstallPreloadApps(@QueryMap Map<String, String> r10);
}
