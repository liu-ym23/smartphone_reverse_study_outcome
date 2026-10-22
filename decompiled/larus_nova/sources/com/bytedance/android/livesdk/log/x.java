package com.bytedance.android.livesdk.log;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdk.b8;
import com.bytedance.android.livesdk.config.LiveTeaDynamicConfig;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes10.dex */
public final class x {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static LiveTeaDynamicConfig f153449a;

    static {
    }

    public static Map a(String r100, Map r101) {
        Intrinsics.checkNotNullParameter(r100, "eventName");
        if (r101 != null) goto L5;
        return r101;
    L5:
        if (StringsKt.startsWith$default(r100, "livesdk_", false, 2, null) == true) goto L8;
        return r101;
    L8:
        if (f153449a != null) goto L10;
        f153449a = b8.f104237a.getValue();
    L10:
        LiveTeaDynamicConfig r102 = f153449a;
        if (r102 != null) goto L15;
        ALogger.i("LiveLoggerHelper", "mConfig is null");
        return r101;
    L15:
        if (r102.getEnable() == true) goto L18;
        return r101;
    L18:
        if (r102.getParamBlockList() != null) goto L22;
        ALogger.i("LiveLoggerHelper", "paramAllowList is null");
        return r101;
    L22:
        if (r102.isTrackAll() == true) goto L28;
        List<String> r103 = r102.getEventAllowList();
        if (r103 != null) goto L26;
        return r101;
    L26:
        if (r103.contains(r100) != true) goto L33;
        ALogger.i("LiveLoggerHelper", "isTrackAll=false, eventName=" + r100);
        Map r104 = c(r102.getParamBlockList(), r101);
        b(r100, r101, r104);
    L30:
        return r104;
    L33:
        return r101;
    L28:
        ALogger.i("LiveLoggerHelper", "isTrackAll=true, eventName=" + r100);
        r104 = c(r102.getParamBlockList(), r101);
        b(r100, r101, r104);
        goto L30
    }

    public static Map c(List r100, Map r101) {
        if (r100 == null) goto L9;
        LinkedHashMap r102 = new LinkedHashMap();
        Iterator r103 = r101.entrySet().iterator();
    L5:
        if (r103.hasNext() == false) goto L16;
        Map.Entry r104 = (Map.Entry) r103.next();
        if ((!CollectionsKt.contains(r100, (String) r104.getKey())) == false) goto L5;
        r102.put(r104.getKey(), r104.getValue());
        goto L5
    L16:
        return r102;
    L9:
        return null;
    }

    public static void b(String r100, Map r101, Map r102) {
        if (com.bytedance.android.live.core.utils.v.a() == false) goto L22;
        StringBuilder r103 = new StringBuilder("触发埋点参数裁剪->【eventName=");
        r103.append(r100);
        r103.append(", list =");
        String r104 = null;
        Set r105 = null;
        if (r102 == null) goto L15;
        if (r101 == null) goto L14;
        LinkedHashMap r106 = new LinkedHashMap();
        Iterator r107 = r101.entrySet().iterator();
    L9:
        if (r107.hasNext() == false) goto L13;
        Map.Entry r108 = (Map.Entry) r107.next();
        if ((!r102.keySet().contains((String) r108.getKey())) == false) goto L9;
        r106.put(r108.getKey(), r108.getValue());
        goto L9
    L13:
        r105 = r106.keySet();
    L14:
        r104 = String.valueOf(r105);
    L15:
        r103.append(r104);
        r103.append(12305);
        ALogger.i("LiveLoggerHelper", r103.toString());
        return;
    }
}
