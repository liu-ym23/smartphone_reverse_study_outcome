package com.bytedance.apm.trace.model.cross;

import androidx.annotation.Keep;
import androidx.appcompat.widget.p;
import f2.a;
import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes.dex */
@Keep
public class TracingCrossManager {
    private static Map<Long, a> sCrossTracingContext;

    static {
        sCrossTracingContext = new ConcurrentHashMap();
    }

    public TracingCrossManager() {
    }

    public static void onPassBackAsChild(String r10, String r11, ArrayList<NativeSpan> r12) {
        p.a(sCrossTracingContext.get(Long.valueOf(Long.parseLong(r10))));
    }

    @Keep
    public static void onPassBackAsReference(String r10, String r11, ArrayList<NativeSpan> r12) {
        p.a(sCrossTracingContext.get(Long.valueOf(Long.parseLong(r10))));
    }

    public static void registerCross(long r10, a r11) {
        sCrossTracingContext.put(Long.valueOf(r10), r11);
    }

    public static void unRegisterCross(long r10) {
        sCrossTracingContext.remove(Long.valueOf(r10));
    }
}
