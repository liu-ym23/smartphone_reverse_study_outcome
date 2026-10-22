package com.bytedance.android.live.gson;

import com.bytedance.android.live.GsonHelper;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonParser;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0017\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\b\u001a\u00020\tH\u0016¨\u0006\n"}, d2 = {"Lcom/bytedance/android/live/gson/LiveGsonService;", "Lcom/bytedance/android/live/gson/ILiveGsonService;", "()V", "builder", "Lcom/google/gson/GsonBuilder;", MonitorConstants.CONNECT_TYPE_GET, "Lcom/google/gson/Gson;", "getDefault", "parser", "Lcom/google/gson/JsonParser;", "livesdkapi_saasRelease"}, k = 1, mv = {1, 4, 3})
public class LiveGsonService implements ILiveGsonService {
    public LiveGsonService() {
    }

    @Override // com.bytedance.android.live.gson.ILiveGsonService
    public GsonBuilder builder() {
        return GsonHelper.builder();
    }

    @Override // com.bytedance.android.live.gson.ILiveGsonService
    public Gson get() {
        return GsonHelper.get();
    }

    @Override // com.bytedance.android.live.gson.ILiveGsonService
    public Gson getDefault() {
        return GsonHelper.getDefault();
    }

    @Override // com.bytedance.android.live.gson.ILiveGsonService
    public JsonParser parser() {
        return GsonHelper.parser();
    }
}
