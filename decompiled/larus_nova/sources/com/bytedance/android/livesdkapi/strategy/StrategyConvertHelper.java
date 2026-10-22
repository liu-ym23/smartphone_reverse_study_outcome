package com.bytedance.android.livesdkapi.strategy;

import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.LiveData;
import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.live.strategy.api.IStrategyService;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.ai.AiStrategyStatus;
import com.google.gson.Gson;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import jc1.k;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J7\u0010\t\u001a\u0002H\n\"\u0004\b\u0000\u0010\n2\u0006\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u0002H\n2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u000eH\u0007¢\u0006\u0002\u0010\u0010J7\u0010\u0011\u001a\u0002H\n\"\u0004\b\u0000\u0010\n2\u0006\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u0002H\n2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u000eH\u0007¢\u0006\u0002\u0010\u0010R\u001a\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/livesdkapi/strategy/StrategyConvertHelper;", "", "()V", "cache", "Ljava/util/concurrent/ConcurrentHashMap;", "", "noStrategyMark", "", "", "getObjectStrategyValue", ExifInterface.GPS_DIRECTION_TRUE, "faName", "default", "sendTeaLog", "", "useCache", "(Ljava/lang/String;Ljava/lang/Object;ZZ)Ljava/lang/Object;", "getObjectStrategyValueByGson", "livesdkapi-middleware_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class StrategyConvertHelper {
    public static final StrategyConvertHelper INSTANCE = null;
    private static final ConcurrentHashMap<Integer, Object> cache = null;
    private static final Map<String, String> noStrategyMark = null;

    private StrategyConvertHelper() {
    }

    static {
        INSTANCE = new StrategyConvertHelper();
        noStrategyMark = MapsKt.mapOf(TuplesKt.to(AiStrategyStatus.NO_STRATEGY, "1"));
        cache = new ConcurrentHashMap();
    }

    @JvmStatic
    public static final <T> T getObjectStrategyValue(String r100, T r101, boolean r102, boolean r103) {
        Intrinsics.checkNotNullParameter(r100, "faName");
        IStrategyService r104 = (IStrategyService) k.f(IStrategyService.class);     // Catch: Exception -> L23
        if (r104 == null) goto L9;
        LiveData<T> r105 = r104.getFactor(r100, noStrategyMark, r102, r103);     // Catch: Exception -> L23
        if (r105 == null) goto L9;
        Map<String, String> r106 = (Map) r105.getValue();     // Catch: Exception -> L23
        if (r106 == null) goto L9;
    L11:
        if (Intrinsics.areEqual(r106, noStrategyMark) == true) goto L22;
        if (r101 == null) goto L22;
        if (r106.hashCode() == 0) goto L22;
        ConcurrentHashMap<Integer, Object> r107 = cache;     // Catch: Exception -> L23
        if (r107.containsKey(Integer.valueOf(r106.hashCode())) == true) goto L19;
        new Gson().toJson(r106.toString());     // Catch: Exception -> L23
        GsonHelper.get().fromJson(r106.toString(), r101.getClass());     // Catch: Exception -> L23
        T r108 = (T) GsonHelper.get().fromJson(r106.toString(), r101.getClass());
        r107.put(Integer.valueOf(r106.hashCode()), r108);     // Catch: Exception -> L23
        return r108;
    L19:
        return (T) r107.get(Integer.valueOf(r106.hashCode()));
    L9:
        r106 = noStrategyMark;     // Catch: Exception -> L23
    L22:
        return r101;
    }

    @JvmStatic
    public static final <T> T getObjectStrategyValueByGson(String r100, T r101, boolean r102, boolean r103) {
        Intrinsics.checkNotNullParameter(r100, "faName");
        IStrategyService r104 = (IStrategyService) k.f(IStrategyService.class);     // Catch: Exception -> L23
        if (r104 == null) goto L9;
        LiveData<T> r105 = r104.getFactor(r100, noStrategyMark, r102, r103);     // Catch: Exception -> L23
        if (r105 == null) goto L9;
        Map<String, String> r106 = (Map) r105.getValue();     // Catch: Exception -> L23
        if (r106 == null) goto L9;
    L11:
        if (Intrinsics.areEqual(r106, noStrategyMark) == true) goto L22;
        if (r101 == null) goto L22;
        if (r106.hashCode() == 0) goto L22;
        ConcurrentHashMap<Integer, Object> r107 = cache;     // Catch: Exception -> L23
        if (r107.containsKey(Integer.valueOf(r106.hashCode())) == true) goto L19;
        T r108 = (T) GsonHelper.get().fromJson(new Gson().toJson(r106), r101.getClass());
        r107.put(Integer.valueOf(r106.hashCode()), r108);     // Catch: Exception -> L23
        return r108;
    L19:
        return (T) r107.get(Integer.valueOf(r106.hashCode()));
    L9:
        r106 = noStrategyMark;     // Catch: Exception -> L23
    L22:
        return r101;
    }

    public static /* synthetic */ Object getObjectStrategyValue$default(String r100, Object r101, boolean r102, boolean r103, int r104, Object r105) {
        if ((r104 & 4) == 0) goto L6;
        r102 = true;
    L6:
        if ((r104 & 8) == 0) goto L9;
        r103 = true;
    L9:
        return getObjectStrategyValue(r100, r101, r102, r103);
    }

    public static /* synthetic */ Object getObjectStrategyValueByGson$default(String r100, Object r101, boolean r102, boolean r103, int r104, Object r105) {
        if ((r104 & 4) == 0) goto L6;
        r102 = true;
    L6:
        if ((r104 & 8) == 0) goto L9;
        r103 = true;
    L9:
        return getObjectStrategyValueByGson(r100, r101, r102, r103);
    }
}
