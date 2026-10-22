package com.bytedance.android.livesdk.room;

import android.os.SystemClock;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.monitor.LiveMonitor;
import com.bytedance.android.live.core.monitor.LiveTracingMonitor;
import com.bytedance.android.livesdk.config.bo0;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes11.dex */
public final class RoomHookMethodMonitor {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Boolean f157550b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Lazy f157551c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<String, Map<String, Long>> f157552a;

    public static final class a {
        public static RoomHookMethodMonitor a() {
            return (RoomHookMethodMonitor) RoomHookMethodMonitor.f157551c.getValue();
        }
    }

    static {
        f157550b = bo0.f119888a.getValue();
        f157551c = LazyKt.lazy(LazyThreadSafetyMode.NONE, RoomHookMethodMonitor$Companion$INSTANCE$2.INSTANCE);
    }

    public RoomHookMethodMonitor() {
        this.f157552a = new LinkedHashMap();
    }

    public final void a(String r110) {
        Intrinsics.checkNotNullParameter(r110, "eventName");
        if (f157550b.booleanValue() == false) goto L35;
        Map<String, Map<String, Long>> r100 = this.f157552a;
        if (r100 != null) goto L7;
    L10:
        boolean r101 = true;
    L11:
        if (r101 == false) goto L13;
        return;
    L13:
        JSONObject r102 = new JSONObject();
        Iterator r103 = ((LinkedHashMap) this.f157552a).entrySet().iterator();
        long r104 = 0;
    L15:
        if (r103.hasNext() == false) goto L28;
        Map.Entry r105 = (Map.Entry) r103.next();
        String r106 = (String) r105.getKey();
        Map r107 = (Map) r105.getValue();
        if (r107 != null) goto L19;
    L22:
        boolean r108 = true;
    L23:
        if (r108 == true) goto L15;
        Iterator r109 = r107.entrySet().iterator();
    L26:
        if (r109.hasNext() == false) goto L15;
        Map.Entry r111 = (Map.Entry) r109.next();
        String r112 = (String) r111.getKey();
        long r113 = ((Number) r111.getValue()).longValue();
        r102.put(r106 + r112, r113);
        r104 = r104 + r113;
        goto L26
    L19:
        if (r107.isEmpty() == true) goto L22;
        r108 = false;
        goto L23
    L28:
        r102.put("total_cost_time", r104);
        ALogger.d("RoomObserverMonitor", r102.toString());
        LiveMonitor.a r114 = new LiveMonitor.a(r110, LiveTracingMonitor.EventModule.LIVE_ROOM_OBSERVER);
        r114.k(r102);
        r114.f64903f = true;
        r114.a().report();
        ((LinkedHashMap) this.f157552a).clear();
        return;
    L7:
        if (r100.isEmpty() == true) goto L10;
        r101 = false;
        goto L11
    }

    public final void b(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "methodName");
        Intrinsics.checkNotNullParameter(r101, "businessType");
        if (f157550b.booleanValue() == false) goto L9;
        Map<String, Long> r102 = (Map) ((LinkedHashMap) this.f157552a).get(r100);
        if (r102 != null) goto L7;
        r102 = new LinkedHashMap();
    L7:
        r102.put(r101, Long.valueOf(SystemClock.uptimeMillis()));
        this.f157552a.put(r100, r102);
        return;
    }

    public final void c(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "methodName");
        Intrinsics.checkNotNullParameter(r101, "businessType");
        if (f157550b.booleanValue() == false) goto L10;
        Map r102 = (Map) ((LinkedHashMap) this.f157552a).get(r100);
        if (r102 == null) goto L11;
        Long r103 = (Long) r102.get(r101);
        if (r103 == null) goto L12;
        long r104 = r103.longValue();
        r102.put(r101, Long.valueOf(SystemClock.uptimeMillis() - r104));
        return;
    L12:
        return;
    L11:
        return;
    }
}
