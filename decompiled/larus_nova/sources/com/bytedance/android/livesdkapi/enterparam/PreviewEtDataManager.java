package com.bytedance.android.livesdkapi.enterparam;

import android.util.LruCache;
import com.bytedance.android.livesdkapi.depend.model.live.PreviewEtData;
import com.bytedance.android.livesdkapi.service.IMiddlewareLiveService;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import jc1.k;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0014\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0018\u001a\u00020\u0016J\u001a\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u000b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dJ4\u0010\u001e\u001a\u00020\u001a2\u0014\u0010\u001f\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010 2\u0014\u0010!\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\"H\u0007J\u0018\u0010!\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040 *\u00020\u0004H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u000b0\nX\u0082\u0004¢\u0006\u0002\n\u0000R/\u0010\f\u001a\u0016\u0012\u0004\u0012\u00020\u0004 \u000e*\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\r0\r8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00040\rX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006#"}, d2 = {"Lcom/bytedance/android/livesdkapi/enterparam/PreviewEtDataManager;", "", "()V", "DATA_CHECK_ERROR", "", "DATA_PARSE_ERROR", "MAX_CACHE_SIZE", "", "TAG", "etDataCacheMap", "Landroid/util/LruCache;", "Lcom/bytedance/android/livesdkapi/enterparam/PreviewEtDataCache;", "supportedKeyList", "", "kotlin.jvm.PlatformType", "getSupportedKeyList", "()Ljava/util/List;", "supportedKeyList$delegate", "Lkotlin/Lazy;", "unSupportCoreParams", "generateEtDataCache", "previewEtData", "Lcom/bytedance/android/livesdkapi/depend/model/live/PreviewEtData;", "getPreviewEtDataCache", "etData", "putIntoCommonData", "", "etDataCache", "commonEnterParamsData", "Lcom/bytedance/android/livesdkapi/enterparam/CommonEnterParamsData;", "safePutAll", "fromMap", "", "toMap", "Ljava/util/HashMap;", "room_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PreviewEtDataManager {
    private static final String DATA_CHECK_ERROR = "ttlive_preview_et_data_check_error";
    private static final String DATA_PARSE_ERROR = "ttlive_preview_et_data_parse_error";
    public static final PreviewEtDataManager INSTANCE = null;
    private static final int MAX_CACHE_SIZE = 20;
    private static final String TAG = "PreviewEtDataManager";
    private static final LruCache<Integer, PreviewEtDataCache> etDataCacheMap = null;
    private static final Lazy supportedKeyList$delegate = null;
    private static final List<String> unSupportCoreParams = null;

    private PreviewEtDataManager() {
    }

    private final List<String> getSupportedKeyList() {
        return (List) supportedKeyList$delegate.getValue();
    }

    static {
        INSTANCE = new PreviewEtDataManager();
        supportedKeyList$delegate = LazyKt.lazy(PreviewEtDataManager$supportedKeyList$2.INSTANCE);
        unSupportCoreParams = CollectionsKt.listOf(new String[]{"enter_method", "enter_from_merge", "enter_from", "is_other_channel", "source", "enter_from_ad_type"});
        etDataCacheMap = new LruCache(20);
    }

    private final PreviewEtDataCache generateEtDataCache(PreviewEtData r100) {
        String r101 = r100.getEnterRoom();
        if (r101 == null) goto L6;
        Map<String, String> r102 = toMap(r101);
        if (r102 == null) goto L6;
    L7:
        Map<String, String> r103 = r102;
        String r104 = r100.getMobParams();
        if (r104 == null) goto L11;
        Map<String, String> r105 = toMap(r104);
        if (r105 == null) goto L11;
    L12:
        Map<String, String> r106 = r105;
        String r107 = r100.getParams();
        if (r107 == null) goto L16;
        Map<String, String> r108 = toMap(r107);
        if (r108 == null) goto L16;
    L17:
        Map<String, String> r109 = r108;
        String r110 = r100.getFirstRoomParams();
        if (r110 == null) goto L21;
        Map<String, String> r111 = toMap(r110);
        if (r111 == null) goto L21;
    L22:
        Map<String, String> r112 = r111;
        String r113 = r100.getFirstRoomMobParams();
        if (r113 == null) goto L26;
        Map<String, String> r114 = toMap(r113);
        if (r114 == null) goto L26;
    L27:
        Map<String, String> r115 = r114;
        String r116 = r100.getFirstShowRoomParams();
        if (r116 == null) goto L31;
        Map<String, String> r117 = toMap(r116);
        if (r117 == null) goto L31;
    L33:
        return new PreviewEtDataCache(r103, r106, r109, r112, r115, r117);
    L31:
        r117 = Collections.emptyMap();
    L26:
        r114 = Collections.emptyMap();
    L21:
        r111 = Collections.emptyMap();
    L16:
        r108 = Collections.emptyMap();
    L11:
        r105 = Collections.emptyMap();
    L6:
        r102 = Collections.emptyMap();
        goto L7
    }

    private final Map<String, String> toMap(String r100) {
        LinkedHashMap r101 = new LinkedHashMap();
        JSONObject r102 = new JSONObject(r100);     // Catch: JSONException -> L8
        Iterator<String> r103 = r102.keys();     // Catch: JSONException -> L8
    L5:
        if (r103.hasNext() == false) goto L25;
        String r104 = r103.next();     // Catch: JSONException -> L8
        r101.put(r104, JSONObjectProtectorUtils.getString(r102, r104));     // Catch: JSONException -> L8
    L25:
        return r101;
    L8:
        e = move-exception;
        e.toString();
        Result.Companion r105 = Result.Companion;     // Catch: Throwable -> L15
        JSONObject r106 = new JSONObject();     // Catch: Throwable -> L15
        Object r107 = e.getMessage();     // Catch: Throwable -> L15
        if (r107 != null) goto L13;
        r107 = "";
    L13:
        r106.put("message", r107);     // Catch: Throwable -> L15
        r106.put("extra", e.toString());     // Catch: Throwable -> L15
        r106.put("value", r106);     // Catch: Throwable -> L15
        Object r108 = Result.m9449constructorimpl(r106);     // Catch: Throwable -> L15
    L18:
        if (Result.m9455isFailureimpl(r108) == false) goto L20;
        r108 = null;
    L20:
        JSONObject r109 = (JSONObject) r108;
        IMiddlewareLiveService r110 = (IMiddlewareLiveService) k.f(IMiddlewareLiveService.class);
        if (r110 == null) goto L25;
        ILiveCommonMonitorService r111 = r110.getCommonMonitorService();
        if (r111 == null) goto L25;
        r111.monitorEvent(DATA_PARSE_ERROR, r109, null, null);
    L15:
        th = move-exception;
        Result.Companion r112 = Result.Companion;
        r108 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L18
    }

    public final PreviewEtDataCache getPreviewEtDataCache(PreviewEtData r100) {
        Intrinsics.checkNotNullParameter(r100, "etData");
        LruCache<Integer, PreviewEtDataCache> r101 = etDataCacheMap;
        if (r101.get(Integer.valueOf(r100.hashCode())) != null) goto L5;
        PreviewEtDataCache r102 = generateEtDataCache(r100);
        r101.put(Integer.valueOf(r100.hashCode()), r102);
        return r102;
    L5:
        return r101.get(Integer.valueOf(r100.hashCode()));
    }

    @JvmStatic
    public static final void safePutAll(Map<String, String> r100, HashMap<String, String> r101) {
        if (r100 == null) goto L8;
        if (r101 == null) goto L10;
        Iterator<Map.Entry<String, String>> r102 = r100.entrySet().iterator();
    L6:
        if (r102.hasNext() == false) goto L11;
        Map.Entry<String, String> r103 = r102.next();
        r101.put(r103.getKey(), r103.getValue());
        goto L6
    L11:
        return;
    L10:
        return;
    }

    public final void putIntoCommonData(PreviewEtDataCache r100, CommonEnterParamsData r101) {
        HashMap<String, String> r102 = null;
        if (r100 == null) goto L5;
        Map<String, String> r103 = r100.getEnterRoomCache();
    L6:
        if (r101 == null) goto L8;
        HashMap<String, String> r104 = r101.getEnterRoom();
    L9:
        safePutAll(r103, r104);
        if (r100 == null) goto L12;
        Map<String, String> r105 = r100.getMobParamsCache();
    L13:
        if (r101 == null) goto L15;
        HashMap<String, String> r106 = r101.getMobParams();
    L16:
        safePutAll(r105, r106);
        if (r100 == null) goto L19;
        Map<String, String> r107 = r100.getParamsCache();
    L20:
        if (r101 == null) goto L22;
        HashMap<String, String> r108 = r101.getParams();
    L23:
        safePutAll(r107, r108);
        if (r100 == null) goto L26;
        Map<String, String> r109 = r100.getFirstRoomParamsCache();
    L27:
        if (r101 == null) goto L29;
        HashMap<String, String> r110 = r101.getFirstRoomParams();
    L30:
        safePutAll(r109, r110);
        if (r100 == null) goto L33;
        Map<String, String> r111 = r100.getFirstRoomMobParamsCache();
    L34:
        if (r101 == null) goto L36;
        HashMap<String, String> r112 = r101.getFirstRoomMobParams();
    L37:
        safePutAll(r111, r112);
        if (r100 == null) goto L40;
        Map<String, String> r113 = r100.getFirstShowRoomParamsCache();
    L41:
        if (r101 == null) goto L43;
        r102 = r101.getFirstShowRoomParams();
    L43:
        safePutAll(r113, r102);
        return;
    L40:
        r113 = null;
        goto L41
    L36:
        r112 = null;
        goto L37
    L33:
        r111 = null;
        goto L34
    L29:
        r110 = null;
        goto L30
    L26:
        r109 = null;
        goto L27
    L22:
        r108 = null;
        goto L23
    L19:
        r107 = null;
        goto L20
    L15:
        r106 = null;
        goto L16
    L12:
        r105 = null;
        goto L13
    L8:
        r104 = null;
        goto L9
    L5:
        r103 = null;
        goto L6
    }
}
