package com.bytedance.android.ecom.bcm.track.impl.entranceinfo;

import com.bytedance.android.btm.api.inner.ALogger;
import com.bytedance.android.btm.impl.thread.b;
import com.bytedance.android.ecom.bcm.track.impl.setting.Setting;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes44.dex */
public final class EntranceInfoHandler {
    static {
    }

    public static void a(final JSONObject r110) {
        ALogger r100 = ALogger.f41996d;
        r100.a(com.bytedance.android.ec.core.event.a.KEY_ENTRANCE_INFO, false, EntranceInfoHandler$handle$1.INSTANCE);
        final HashMap r101 = null;
        if (Setting.f51149a.f().f() != 1) goto L30;
        r100.a(com.bytedance.android.ec.core.event.a.KEY_ENTRANCE_INFO, false, EntranceInfoHandler$removeOversizeKey$1.INSTANCE);
        final LinkedHashMap r102 = new LinkedHashMap();
        Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L26
        Iterator<Map.Entry<String, Integer>> r104 = Setting.f51149a.f().e().entrySet().iterator();     // Catch: Throwable -> L26
    L8:
        if (r104.hasNext() == false) goto L24;
        final Map.Entry<String, Integer> r105 = r104.next();     // Catch: Throwable -> L26
        Object r106 = r110.opt(r105.getKey());     // Catch: Throwable -> L26
        if (r106 == null) goto L8;
        final String r107 = r106.toString();     // Catch: Throwable -> L26
        if (r107 == null) goto L8;
        if (r105.getValue().intValue() > 0) goto L16;
    L18:
        boolean r108 = false;
    L19:
        if (r108 == true) goto L22;
        r107 = null;
    L22:
        if (r107 == null) goto L8;
        r102.put(r105.getKey(), r107);     // Catch: Throwable -> L26
        r110.remove(r105.getKey());     // Catch: Throwable -> L26
        ALogger.f41996d.a(com.bytedance.android.ec.core.event.a.KEY_ENTRANCE_INFO, false, new EntranceInfoHandler$removeOversizeKey$$inlined$runCatching$lambda$1(r107, r105, r110, r102));     // Catch: Throwable -> L26
        goto L8
    L16:
        if (r107.length() <= r105.getValue().intValue()) goto L18;
        r108 = true;
        goto L19
    L24:
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L26
    L28:
        ALogger.f41996d.a(com.bytedance.android.ec.core.event.a.KEY_ENTRANCE_INFO, false, new EntranceInfoHandler$removeOversizeKey$3(r102));
        r101 = r102;
    L26:
        th = move-exception;
        Result.Companion r109 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
    L30:
        if (Setting.f51149a.f().d() != 1) goto L49;
        ALogger.f41996d.a(com.bytedance.android.ec.core.event.a.KEY_ENTRANCE_INFO, false, EntranceInfoHandler$monitorKeySize$1.INSTANCE);
        if (r101 != null) goto L36;
        r101 = new HashMap();
    L36:
        b.f42488e.a(new EntranceInfoHandler$monitorKeySize$2(r110, r101), true);
        return;
    }
}
