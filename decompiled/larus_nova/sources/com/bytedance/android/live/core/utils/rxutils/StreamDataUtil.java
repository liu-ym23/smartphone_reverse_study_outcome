package com.bytedance.android.live.core.utils.rxutils;

import com.bytedance.android.live.wallet.model.OrderParamsKey;
import com.bytedance.android.livesdkapi.depend.model.live.SdkParamsOptimizeConfig;
import com.bytedance.android.livesdkapi.depend.model.live.StreamDataOptimizeConfig;
import com.bytedance.android.livesdkapi.player.resolution.PlayerResolution;
import com.bytedance.android.service.manager.pull.PullConfiguration;
import com.bytedance.bdlocation.exception.BDLocationException;
import com.ss.android.cert.manager.constants.EventConstant;
import java.net.URL;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000e\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u001a\u001a\u0004\u0018\u00010\r2\b\u0010\u001b\u001a\u0004\u0018\u00010\u000eJ\u0018\u0010\u001c\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u001d\u001a\u00020\r2\u0006\u0010\u001e\u001a\u00020\rJ,\u0010\u001f\u001a\u00020\u000e2\u0006\u0010\u001d\u001a\u00020\r2\b\u0010\u001b\u001a\u0004\u0018\u00010\u000e2\b\b\u0002\u0010 \u001a\u00020\r2\b\b\u0002\u0010!\u001a\u00020\rJ\u000e\u0010\"\u001a\u00020\u000e2\u0006\u0010#\u001a\u00020\rR#\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u00048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007R(\u0010\n\u001a\u001c\u0012\u0004\u0012\u00020\u0004\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\f\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R#\u0010\u000f\u001a\n \u0005*\u0004\u0018\u00010\u00100\u00108BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0013\u0010\t\u001a\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0014\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R#\u0010\u0015\u001a\n \u0005*\u0004\u0018\u00010\u00160\u00168BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0019\u0010\t\u001a\u0004\b\u0017\u0010\u0018¨\u0006$"}, d2 = {"Lcom/bytedance/android/live/core/utils/rxutils/StreamDataUtil;", "", "()V", "parseCdnName", "", "kotlin.jvm.PlatformType", "getParseCdnName", "()Ljava/lang/Integer;", "parseCdnName$delegate", "Lkotlin/Lazy;", "sdkParamsCache", "Lcom/bytedance/android/live/core/utils/rxutils/FIFOConcurrentMap;", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lorg/json/JSONObject;", "sdkParamsOptimizeConfig", "Lcom/bytedance/android/livesdkapi/depend/model/live/SdkParamsOptimizeConfig;", "getSdkParamsOptimizeConfig", "()Lcom/bytedance/android/livesdkapi/depend/model/live/SdkParamsOptimizeConfig;", "sdkParamsOptimizeConfig$delegate", "streamDataCache", "streamDataOptimizeConfig", "Lcom/bytedance/android/livesdkapi/depend/model/live/StreamDataOptimizeConfig;", "getStreamDataOptimizeConfig", "()Lcom/bytedance/android/livesdkapi/depend/model/live/StreamDataOptimizeConfig;", "streamDataOptimizeConfig$delegate", "getCdnName", "dataObj", "getResolutionSdkParamsObj", "streamDataString", "sdkKey", "getSdkParamsObject", "currentResolution", "level", "getStreamDataObject", "multiStreamData", "infrastructure_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class StreamDataUtil {
    public static final StreamDataUtil INSTANCE = null;
    private static final Lazy parseCdnName$delegate = null;
    private static FIFOConcurrentMap<Integer, ConcurrentHashMap<String, JSONObject>> sdkParamsCache;
    private static final Lazy sdkParamsOptimizeConfig$delegate = null;
    private static FIFOConcurrentMap<Integer, JSONObject> streamDataCache;
    private static final Lazy streamDataOptimizeConfig$delegate = null;

    private StreamDataUtil() {
    }

    private final Integer getParseCdnName() {
        return (Integer) parseCdnName$delegate.getValue();
    }

    private final SdkParamsOptimizeConfig getSdkParamsOptimizeConfig() {
        return (SdkParamsOptimizeConfig) sdkParamsOptimizeConfig$delegate.getValue();
    }

    private final StreamDataOptimizeConfig getStreamDataOptimizeConfig() {
        return (StreamDataOptimizeConfig) streamDataOptimizeConfig$delegate.getValue();
    }

    static {
        StreamDataUtil r100 = new StreamDataUtil();
        INSTANCE = r100;
        streamDataOptimizeConfig$delegate = LazyKt.lazy(StreamDataUtil$streamDataOptimizeConfig$2.INSTANCE);
        sdkParamsOptimizeConfig$delegate = LazyKt.lazy(StreamDataUtil$sdkParamsOptimizeConfig$2.INSTANCE);
        parseCdnName$delegate = LazyKt.lazy(StreamDataUtil$parseCdnName$2.INSTANCE);
        if (r100.getStreamDataOptimizeConfig().getEnableOptimize() == false) goto L6;
        streamDataCache = new FIFOConcurrentMap(r100.getStreamDataOptimizeConfig().getCacheSize(), r100.getStreamDataOptimizeConfig().getEnableRemoveAll());
    L6:
        if (r100.getSdkParamsOptimizeConfig().getEnableOptimize() == false) goto L9;
        sdkParamsCache = new FIFOConcurrentMap(r100.getSdkParamsOptimizeConfig().getCacheSize(), r100.getSdkParamsOptimizeConfig().getEnableRemoveAll());
        return;
    }

    public final String getCdnName(JSONObject r100) {
        Integer r101 = getParseCdnName();
        if (r101 != null) goto L6;
    L7:
        return null;
    L6:
        if (r101.intValue() != 1) goto L7;
        if (r100 == null) goto L14;
        JSONObject r102 = r100.optJSONObject(PlayerResolution.SDKKEY.ORIGIN);
        if (r102 == null) goto L14;
        JSONObject r103 = r102.optJSONObject(PullConfiguration.PROCESS_NAME_MAIN);
        if (r103 == null) goto L14;
        String r104 = r103.optString("flv");
    L15:
        if (r104 != null) goto L48;
        return null;
    L48:
        String r105 = new URL(r104).getHost();     // Catch: Exception -> L47
        if (StringsKt.contains$default(r105, BDLocationException.ERROR_BEACON_NOT_ALLOW_USE, false, 2, null) == false) goto L22;
        String r106 = "mobile_cdn";
    L46:
        return r106;
    L22:
        if (StringsKt.contains$default(r105, "95", false, 2, null) == false) goto L25;
        r106 = "telecom_cdn";
        goto L46
    L25:
        if (StringsKt.contains$default(r105, "26", false, 2, null) == false) goto L28;
        r106 = "hw";
        goto L46
    L28:
        if (StringsKt.contains$default(r105, "13", false, 2, null) == false) goto L31;
        r106 = "baidu";
        goto L46
    L31:
        if (StringsKt.contains$default(r105, "11", false, 2, null) == false) goto L34;
        r106 = "tencent";
        goto L46
    L34:
        if (StringsKt.contains$default(r105, "6", false, 2, null) == false) goto L37;
        r106 = "ksyun";
        goto L46
    L37:
        if (StringsKt.contains$default(r105, "5", false, 2, null) == false) goto L40;
        r106 = "fcdn";
        goto L46
    L40:
        if (StringsKt.contains$default(r105, "3", false, 2, null) == false) goto L42;
        r106 = EventConstant.Value.ALIYUN;
        goto L46
    L42:
        if (StringsKt.contains$default(r105, "1", false, 2, null) == false) goto L50;
        r106 = "wangsu";
        goto L46
    L50:
        return null;
    L51:
        return null;
    L14:
        r104 = null;
        goto L15
    }

    public final JSONObject getStreamDataObject(String r100) {
        Intrinsics.checkNotNullParameter(r100, "multiStreamData");
        if (r100.length() != 0) goto L5;
        boolean r101 = true;
    L6:
        if (r101 == true) goto L8;
        if (getStreamDataOptimizeConfig().getEnableOptimize() == false) goto L27;
        FIFOConcurrentMap<Integer, JSONObject> r102 = streamDataCache;     // Catch: Exception -> L21
        if (r102 == null) goto L14;
        JSONObject r103 = r102.get(Integer.valueOf(r100.hashCode()));     // Catch: Exception -> L21
    L15:
        if (r103 != null) goto L24;
        JSONObject r104 = new JSONObject(r100);     // Catch: Exception -> L21
        FIFOConcurrentMap<Integer, JSONObject> r105 = streamDataCache;     // Catch: Exception -> L21
        if (r105 == null) goto L25;
        r105.put(Integer.valueOf(r100.hashCode()), r104);     // Catch: Exception -> L21
        return r104;
    L25:
        return r104;
    L24:
        return r103;
    L14:
        r103 = null;
        goto L15
    L27:
        return new JSONObject(r100);
    L22:
        return new JSONObject();
    L8:
        return new JSONObject();
    L5:
        r101 = false;
        goto L6
    }

    public final JSONObject getResolutionSdkParamsObj(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "streamDataString");
        Intrinsics.checkNotNullParameter(r101, "sdkKey");
        FIFOConcurrentMap<Integer, ConcurrentHashMap<String, JSONObject>> r102 = sdkParamsCache;
        if (r102 == null) goto L7;
        ConcurrentHashMap<String, JSONObject> r103 = r102.get(Integer.valueOf(r100.hashCode()));
        if (r103 == null) goto L7;
        return r103.get(r101);
    L7:
        return null;
    }

    public final JSONObject getSdkParamsObject(String r100, JSONObject r101, String r102, String r103) {
        Intrinsics.checkNotNullParameter(r100, "streamDataString");
        Intrinsics.checkNotNullParameter(r102, "currentResolution");
        Intrinsics.checkNotNullParameter(r103, "level");
        boolean r104 = true;
        if (r100.length() != 0) goto L5;
        boolean r105 = true;
    L6:
        if (r105 == true) goto L42;
        if (r101 == null) goto L42;
        JSONObject r106 = r101.optJSONObject(r102);
        if (r106 == null) goto L15;
        JSONObject r107 = r106.optJSONObject(r103);
        if (r107 == null) goto L15;
        String r108 = r107.optString(OrderParamsKey.KEY_SDK_PARAM);
        if (r108 == null) goto L15;
    L17:
        if (r108.length() == 0) goto L20;
        r104 = false;
    L20:
        if (r104 == true) goto L22;
        if (getSdkParamsOptimizeConfig().getEnableOptimize() == false) goto L46;
        FIFOConcurrentMap<Integer, ConcurrentHashMap<String, JSONObject>> r109 = sdkParamsCache;     // Catch: Exception -> L39
        if (r109 == null) goto L45;
        ConcurrentHashMap<String, JSONObject> r110 = r109.get(Integer.valueOf(r100.hashCode()));     // Catch: Exception -> L39
        if (r110 == null) goto L30;
        JSONObject r111 = r110.get(r102);     // Catch: Exception -> L39
    L31:
        if (r110 != null) goto L33;
        r110 = new ConcurrentHashMap();     // Catch: Exception -> L39
        r111 = new JSONObject(r108);     // Catch: Exception -> L39
        r110.put(r102, r111);     // Catch: Exception -> L39
    L35:
        r109.put(Integer.valueOf(r100.hashCode()), r110);     // Catch: Exception -> L39
        return r111;
    L33:
        if (r111 != null) goto L35;
        r111 = new JSONObject(r108);     // Catch: Exception -> L39
        r110.put(r102, r111);     // Catch: Exception -> L39
        goto L35
    L30:
        r111 = null;
        goto L31
    L45:
        return new JSONObject(r108);
    L46:
        return new JSONObject(r108);
    L40:
        return new JSONObject();
    L22:
        return new JSONObject();
    L15:
        r108 = "";
    L42:
        return new JSONObject();
    L5:
        r105 = false;
        goto L6
    }

    public static /* synthetic */ JSONObject getSdkParamsObject$default(StreamDataUtil r100, String r101, JSONObject r102, String r103, String r104, int r105, Object r106) {
        if ((r105 & 4) == 0) goto L6;
        r103 = PlayerResolution.SDKKEY.ORIGIN;
    L6:
        if ((r105 & 8) == 0) goto L9;
        r104 = PullConfiguration.PROCESS_NAME_MAIN;
    L9:
        return r100.getSdkParamsObject(r101, r102, r103, r104);
    }
}
