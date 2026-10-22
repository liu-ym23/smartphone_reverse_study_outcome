package com.bytedance.apm.trace.model.cross;

import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import dt3.b;
import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes14.dex */
public class TracingCrossManager {
    private static Map<Long, b> sCrossTracingContext;

    public TracingCrossManager() {
    }

    static {
        sCrossTracingContext = new ConcurrentHashMap();
    }

    public static void unRegisterCross(long r100) {
        sCrossTracingContext.remove(Long.valueOf(r100));
    }

    public static void registerCross(long r100, b r101) {
        sCrossTracingContext.put(Long.valueOf(r100), r101);
    }

    public static void onPassBackAsChild(String r100, String r101, ArrayList<NativeSpan> r102) {
        b r103 = sCrossTracingContext.get(Long.valueOf(CastLongProtector.parseLong(r100)));
        if (r103 == null) goto L8;
        sCrossTracingContext.remove(Long.valueOf(CastLongProtector.parseLong(r100)));
        monitor-enter(r103);
        monitor-exit(r103);
        return;
    }

    public static void onPassBackAsReference(String r100, String r101, ArrayList<NativeSpan> r102) {
        b r103 = sCrossTracingContext.get(Long.valueOf(CastLongProtector.parseLong(r100)));
        if (r103 == null) goto L8;
        sCrossTracingContext.remove(Long.valueOf(CastLongProtector.parseLong(r100)));
        monitor-enter(r103);
        monitor-exit(r103);
        return;
    }
}
