package com.bytedance.android.ec.core.imagex;

import android.util.Pair;
import com.bytedance.android.ec.core.utils.OptCardUtil;
import com.bytedance.common.utility.Logger;
import com.facebook.imagepipeline.request.ImageRequest;
import com.optimize.statistics.FrescoMonitorConst;
import com.optimize.statistics.IMonitorHookV2;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes43.dex */
public final class c implements IMonitorHookV2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f44545a;

    public interface a {
        boolean match(Object r100);
    }

    public c(k0 r100) {
        this.f44545a = r100;
    }

    @Override // com.optimize.statistics.IMonitorHookV2
    public final Pair<Boolean, Map<String, Object>> onMonitorCompleted(ImageRequest r100, Object r110, String r111, JSONObject r112, boolean r113, boolean r114) {
        m0.c("ImageMonitorHook.onMonitorCompleted()");
        if (m0.a() == true) goto L5;
        return null;
    L5:
        a r115 = this.f44545a;
        if (r115 != null) goto L8;
    L10:
        boolean r116 = r110 instanceof u;
        if (r116 == true) goto L13;
        Object r101 = null;
    L14:
        u r102 = (u) r101;
        if (r102 == null) goto L17;
        ECImageTrackHandlerKt.b(r102, r100, r112);
    L17:
        if (r116 == true) goto L19;
        Object r103 = null;
    L20:
        u r104 = (u) r103;
        if (r104 != null) goto L23;
    L49:
        if (r116 == true) goto L51;
        Object r117 = null;
    L52:
        u r118 = (u) r117;
        if (r118 == null) goto L66;
        WeakReference<Function0<Map<String, Object>>> r119 = r118.f44942e;
        if (r119 == null) goto L66;
        Function0<Map<String, Object>> r120 = r119.get();
        if (r120 == null) goto L66;
        Map<String, Object> r121 = r120.invoke();
        if (r121 == null) goto L66;
        Iterator<Map.Entry<String, Object>> r122 = r121.entrySet().iterator();
    L62:
        if (r122.hasNext() == false) goto L66;
        Map.Entry<String, Object> r105 = r122.next();
        if (r112 == null) goto L62;
        r112.put(r105.getKey(), r105.getValue());
    L66:
        if (r112 != null) goto L84;
    L72:
        boolean r123 = false;
    L73:
        ImageMonitor r106 = ImageMonitor.f44455g;     // Catch: Throwable -> L70
        if ((r110 instanceof r) == true) goto L76;
        Object r107 = null;
    L77:
        r106.h(r100, (r) r107, r112, r113, r123, r114);     // Catch: Throwable -> L70
        LinkedHashMap r108 = new LinkedHashMap();     // Catch: Throwable -> L70
        if ((r110 instanceof r) == false) goto L80;
        r108.put("biz_tag", ((r) r110).f44943f);     // Catch: Throwable -> L70
        r108.put(FrescoMonitorConst.SCENE_TAG, ((r) r110).f44944g);     // Catch: Throwable -> L70
        r108.putAll(((r) r110).f44941d);     // Catch: Throwable -> L70
    L80:
        return new Pair(Boolean.valueOf(r123), r108);
    L70:
        th = move-exception;
        Logger.e("ImageMonitorReportDebug", String.valueOf(th.getMessage()));
        return null;
    L76:
        r107 = r110;
        goto L77
    L84:
        if (r112.optBoolean(FrescoMonitorConst.IS_NETWORK_DOWNLOAD) != true) goto L72;
        r123 = true;
        goto L73
    L51:
        r117 = r110;
        goto L52
    L23:
        if (Intrinsics.areEqual(r104.f44943f, "ec_live") == true) goto L25;
    L27:
        boolean r109 = false;
    L28:
        if (r109 == true) goto L31;
        r104 = null;
    L31:
        if (r104 == null) goto L49;
        StringBuilder r124 = new StringBuilder("monitorData: is_request_network=");
        if (r112 == null) goto L35;
        Boolean r125 = Boolean.valueOf(r112.optBoolean(FrescoMonitorConst.IS_NETWORK_DOWNLOAD));
    L36:
        r124.append(r125);
        r124.append(" queue_duration=");
        if (r112 == null) goto L39;
        Integer r126 = Integer.valueOf(r112.optInt("queue_duration"));
    L40:
        r124.append(r126);
        r124.append(" download_duration=");
        if (r112 == null) goto L43;
        Integer r127 = Integer.valueOf(r112.optInt("download_duration"));
    L44:
        r124.append(r127);
        r124.append(" decode_duration=");
        if (r112 == null) goto L47;
        Integer r128 = Integer.valueOf(r112.optInt(FrescoMonitorConst.DECODE_DURATION));
    L48:
        r124.append(r128);
        OptCardUtil.b("image", r124.toString());
        goto L49
    L47:
        r128 = null;
        goto L48
    L43:
        r127 = null;
        goto L44
    L39:
        r126 = null;
        goto L40
    L35:
        r125 = null;
        goto L36
    L25:
        if (Intrinsics.areEqual(r104.f44944g, "goods_card_view") == false) goto L27;
        r109 = true;
        goto L28
    L19:
        r103 = r110;
        goto L20
    L13:
        r101 = r110;
        goto L14
    L8:
        if (r115.match(r110) == true) goto L10;
        return null;
    }
}
