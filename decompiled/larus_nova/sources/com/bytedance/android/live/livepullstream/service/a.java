package com.bytedance.android.live.livepullstream.service;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.setting.SettingUtil;
import com.bytedance.android.live.network.api.INetworkService;
import com.bytedance.android.livehostapi.TTMiddlewareLiveSDK;
import com.bytedance.android.livesdk.i2;
import com.ss.videoarch.strategy.IAppInfoBundle;
import java.io.File;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import jc1.k;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes46.dex */
public final class a implements IAppInfoBundle {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Boolean f82512a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ConcurrentHashMap<String, Object> f82513b;

    @Override // com.ss.videoarch.strategy.IAppInfoBundle
    public final /* synthetic */ void onStrategyResult(String r100, JSONObject r101) {
        IAppInfoBundle.CC.$default$onStrategyResult(this, r100, r101);
    }

    public a() {
        this.f82512a = i2.f132639a.getValue();
        this.f82513b = new ConcurrentHashMap();
    }

    @Override // com.ss.videoarch.strategy.IAppInfoBundle
    public final <T> T getAppInfoForKey(String r100, T r101) {
        Intrinsics.checkNotNullParameter(r101, "defaultValue");
        Object r102 = null;
        if (Intrinsics.areEqual(r100, "TTNet_NQE_INFO") == false) goto L13;
        String r103 = ao0.g.a().toString();
        if ((r103 instanceof Object) == false) goto L8;
        r102 = r103;
    L8:
        if (r102 != null) goto L11;
        return r101;
    L11:
        return (T) r102;
    L13:
        if (Intrinsics.areEqual(r100, "live_stream_strategy_sr_kernal_bin_path") == false) goto L28;
        File r104 = TTMiddlewareLiveSDK.getContext().getExternalCacheDir();     // Catch: Exception -> L24
        if (r104 == null) goto L26;
        String r105 = r104.getAbsolutePath();     // Catch: Exception -> L24
        if ((r105 instanceof Object) == false) goto L20;
        r102 = r105;
    L20:
        if (r102 != null) goto L23;
        return r101;
    L23:
        return (T) r102;
    L26:
        return r101;
    L24:
        e = move-exception;
        ALogger.d("LiveStreamManager", e.toString());
        goto L26
    L28:
        if (Intrinsics.areEqual(r100, "url_common_params") == false) goto L37;
        INetworkService r106 = (INetworkService) k.f(INetworkService.class);
        if (r106 == null) goto L32;
        Map<String, String> r107 = r106.getCommonParams();
    L33:
        if (r107 == null) goto L37;
        return (T) new JSONObject(r107);
    L32:
        r107 = null;
    L37:
        if (this.f82512a.booleanValue() == false) goto L55;
        ConcurrentHashMap<String, Object> r108 = this.f82513b;
        if (r108 == null) goto L53;
        if (r108.containsKey(r100) == false) goto L49;
        Object r109 = this.f82513b.get(r100);
        if ((r109 instanceof Object) == false) goto L46;
        r102 = r109;
    L46:
        if (r102 != null) goto L60;
        return r101;
    L60:
        return (T) r102;
    L49:
        T r110 = (T) SettingUtil.getValue("key_ttlive_sdk_setting", r100, r101.getClass(), r101);
        if (r100 == null) goto L61;
        this.f82513b.put(r100, r110);
        return r110;
    L61:
        return r110;
    L53:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.Map<K, *>");
    L55:
        return (T) SettingUtil.getValue("key_ttlive_sdk_setting", r100, r101.getClass(), r101);
    }
}
