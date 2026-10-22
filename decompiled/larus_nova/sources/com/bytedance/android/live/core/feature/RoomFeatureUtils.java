package com.bytedance.android.live.core.feature;

import com.bytedance.android.livesdkapi.depend.model.live.StrategyRoomFeatureConfig;
import io.reactivex.disposables.Disposable;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class RoomFeatureUtils {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f64782a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a<String, DynamicDataRespItem> f64783b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final a<Long, Map<String, Object>> f64784c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static Disposable f64785d;

    static {
        Lazy r100 = LazyKt.lazy(RoomFeatureUtils$roomFeatureConfig$2.INSTANCE);
        f64782a = r100;
        f64783b = new a(((StrategyRoomFeatureConfig) r100.getValue()).getCacheSize());
        f64784c = new a(((StrategyRoomFeatureConfig) r100.getValue()).getCacheSize());
    }

    public static Map a(long r100) {
        Iterator r101 = CollectionsKt.toList(((ConcurrentHashMap) f64783b.f64787a).values()).iterator();
    L4:
        if (r101.hasNext() == false) goto L14;
        Object r102 = r101.next();
        Long r103 = ((DynamicDataRespItem) r102).getRoomId();
        if (r103 != null) goto L9;
    L11:
        boolean r104 = false;
    L12:
        if (r104 == false) goto L4;
    L15:
        DynamicDataRespItem r105 = (DynamicDataRespItem) r102;
        if (r105 == null) goto L26;
        LinkedHashMap r106 = new LinkedHashMap();
        Map<String, Object> r107 = r105.getTone();
        if (r107 == null) goto L20;
        r106.putAll(r107);
    L20:
        Map<String, Object> r108 = r105.getCae();
        if (r108 == null) goto L23;
        r106.putAll(r108);
    L23:
        a<Long, Map<String, Object>> r109 = f64784c;
        Long r110 = Long.valueOf(r100);
        Map r111 = (Map) ((ConcurrentHashMap) r109.f64787a).get(r110);
        if (r111 == null) goto L33;
        r106.putAll(r111);
        return r106;
    L33:
        return r106;
    L26:
        a<Long, Map<String, Object>> r112 = f64784c;
        Long r113 = Long.valueOf(r100);
        return (Map) ((ConcurrentHashMap) r112.f64787a).get(r113);
    L9:
        if (r103.longValue() != r100) goto L11;
        r104 = true;
        goto L12
    L14:
        r102 = null;
        goto L15
    }

    public static void b(long r100, String r101, Object r102) {
        Intrinsics.checkNotNullParameter(r101, "featureKey");
        Intrinsics.checkNotNullParameter(r102, "featureValue");
        a<Long, Map<String, Object>> r103 = f64784c;
        Long r104 = Long.valueOf(r100);
        Map r105 = (Map) ((ConcurrentHashMap) r103.f64787a).get(r104);
        if (r105 != null) goto L5;
        Long r106 = Long.valueOf(r100);
        ConcurrentHashMap r107 = new ConcurrentHashMap();
        r107.put(r101, r102);
        Unit r108 = Unit.INSTANCE;
        r103.a(r106, r107);
        return;
    L5:
        r105.put(r101, r102);
    }
}
