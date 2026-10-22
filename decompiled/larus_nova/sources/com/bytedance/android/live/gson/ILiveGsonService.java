package com.bytedance.android.live.gson;

import com.bytedance.android.live.base.IService;
import com.bytedance.android.live.utility.ServiceLookup;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonParser;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes45.dex */
@ServiceLookup("com.bytedance.android.live.gson.LiveGsonService")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0005H&J\b\u0010\u0007\u001a\u00020\bH&¨\u0006\t"}, d2 = {"Lcom/bytedance/android/live/gson/ILiveGsonService;", "Lcom/bytedance/android/live/base/IService;", "builder", "Lcom/google/gson/GsonBuilder;", MonitorConstants.CONNECT_TYPE_GET, "Lcom/google/gson/Gson;", "getDefault", "parser", "Lcom/google/gson/JsonParser;", "livesdkapi-middleware_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface ILiveGsonService extends IService {
    GsonBuilder builder();

    Gson get();

    Gson getDefault();

    JsonParser parser();
}
