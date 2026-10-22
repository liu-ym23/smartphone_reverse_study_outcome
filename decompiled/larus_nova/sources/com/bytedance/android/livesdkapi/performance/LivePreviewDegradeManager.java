package com.bytedance.android.livesdkapi.performance;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u000e\u001a\u00020\u0004H\u0002J\u0016\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u000e\u001a\u00020\u0004J1\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\n2!\u0010\u0016\u001a\u001d\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\u000f0\u000bJ\u0010\u0010\u0017\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\u0004H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R5\u0010\b\u001a)\u0012\u0004\u0012\u00020\n\u0012\u001f\u0012\u001d\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\u000f0\u000b0\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/bytedance/android/livesdkapi/performance/LivePreviewDegradeManager;", "", "()V", "PERFORMANCE_DEGRADE_CRITICAL", "", "PERFORMANCE_DEGRADE_SERIOUS", "PERFORMANCE_NORMAL", "currentLevel", "listenerMap", "", "", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "level", "", "calibratePerformanceLevel", "isDegrade", "", "onPerformanceLevelChanged", "registerPreviewPerformanceLevelChange", "key", "listener", "triggerPerformanceLevelChanged", "livesdkapi_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LivePreviewDegradeManager {
    public static final LivePreviewDegradeManager INSTANCE = null;
    public static final int PERFORMANCE_DEGRADE_CRITICAL = -2;
    public static final int PERFORMANCE_DEGRADE_SERIOUS = -1;
    public static final int PERFORMANCE_NORMAL = 0;
    private static int currentLevel;
    private static Map<String, Function1<Integer, Unit>> listenerMap;

    private LivePreviewDegradeManager() {
    }

    private final int calibratePerformanceLevel(boolean r100, int r101) {
        if (r100 == true) goto L4;
        return 0;
    L4:
        if (r101 >= (-2)) goto L7;
        return -2;
    L7:
        if (r101 <= (-1)) goto L12;
        return -1;
    L12:
        return r101;
    }

    static {
        INSTANCE = new LivePreviewDegradeManager();
        listenerMap = new LinkedHashMap();
    }

    private final void triggerPerformanceLevelChanged(int r100) {
        Iterator<Map.Entry<String, Function1<Integer, Unit>>> r101 = listenerMap.entrySet().iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        r101.next().getValue().invoke(Integer.valueOf(r100));
        goto L4
    }

    public final void onPerformanceLevelChanged(boolean r100, int r101) {
        int r102 = calibratePerformanceLevel(r100, r101);
        currentLevel = r102;
        triggerPerformanceLevelChanged(r102);
    }

    public final void registerPreviewPerformanceLevelChange(String r100, Function1<? super Integer, Unit> r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter(r101, "listener");
        if (listenerMap.containsKey(r100) == true) goto L6;
        listenerMap.put(r100, r101);
        return;
    }
}
