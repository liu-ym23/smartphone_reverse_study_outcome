package co2;

import com.bytedance.android.livehostapi.platform.base.IBaseHostPerformanceMonitor;
import com.bytedance.android.livesdk.performance.o0;
import com.bytedance.android.livesdk.performance.q;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes11.dex */
public final class e implements q {
    public e() {
    }

    @Override // com.bytedance.android.livesdk.performance.q
    public final void a(Map<String, String> r110, o0 r111) {
        if (r111 == null) goto L14;
        JSONObject r100 = new JSONObject();
        Map<String, String> r112 = r111.f154694a0;     // Catch: Exception -> L11
        if (r112 == null) goto L9;
        r100.put(IBaseHostPerformanceMonitor.CACHE_BITMAP_HIT_RATIO, r112.get(IBaseHostPerformanceMonitor.CACHE_BITMAP_HIT_RATIO));     // Catch: Exception -> L11
        r100.put(IBaseHostPerformanceMonitor.CACHE_BITMAP_COUNT, r112.get(IBaseHostPerformanceMonitor.CACHE_BITMAP_COUNT));     // Catch: Exception -> L11
        r100.put(IBaseHostPerformanceMonitor.CACHE_BITMAP_MEMORY_SIZE, r112.get(IBaseHostPerformanceMonitor.CACHE_BITMAP_MEMORY_SIZE));     // Catch: Exception -> L11
        r100.put(IBaseHostPerformanceMonitor.CACHE_ENCODED_HIT_RATIO, r112.get(IBaseHostPerformanceMonitor.CACHE_ENCODED_HIT_RATIO));     // Catch: Exception -> L11
        r100.put(IBaseHostPerformanceMonitor.CACHE_ENCODED_COUNT, r112.get(IBaseHostPerformanceMonitor.CACHE_ENCODED_COUNT));     // Catch: Exception -> L11
        r100.put(IBaseHostPerformanceMonitor.CACHE_ENCODED_MEMORY_SIZE, r112.get(IBaseHostPerformanceMonitor.CACHE_ENCODED_MEMORY_SIZE));     // Catch: Exception -> L11
        r100.put(IBaseHostPerformanceMonitor.CACHE_DISK_HIT_RATIO, r112.get(IBaseHostPerformanceMonitor.CACHE_DISK_HIT_RATIO));     // Catch: Exception -> L11
    L9:
        HashMap r113 = (HashMap) r110;
        r113.put("pic_cache", r100.toString());
        return;
    }
}
