package com.bytedance.android.ec.host.api.hybrid;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J&\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0014\u0010\u0006\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\b\u0012\u0004\u0012\u00020\u00030\u0007H&JW\u0010\t\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\u00052\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u000e\u001a\u00020\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u0013H&¢\u0006\u0002\u0010\u0014JW\u0010\u0015\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\u00052\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u000e\u001a\u00020\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u0013H&¢\u0006\u0002\u0010\u0014¨\u0006\u0016"}, d2 = {"Lcom/bytedance/android/ec/host/api/hybrid/IECForestHostService;", "", "fetchLiveResourceAsync", "", "url", "", "callback", "Lkotlin/Function1;", "", "preload", "subConfigs", "Lorg/json/JSONObject;", "from", "monitorID", "type", "Lcom/bytedance/android/ec/host/api/hybrid/ForestPreloadType;", "maxAge", "", "forceAsync", "", "(Ljava/lang/String;Lorg/json/JSONObject;Ljava/lang/String;Ljava/lang/String;Lcom/bytedance/android/ec/host/api/hybrid/ForestPreloadType;Ljava/lang/Integer;Z)V", "preloadWithProcessor", "ec-host-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface IECForestHostService {
    void fetchLiveResourceAsync(String r100, Function1<? super byte[], Unit> r101);

    void preload(String r100, JSONObject r101, String r102, String r103, ForestPreloadType r104, Integer r105, boolean r106);

    void preloadWithProcessor(String r100, JSONObject r101, String r102, String r103, ForestPreloadType r104, Integer r105, boolean r106);
}
