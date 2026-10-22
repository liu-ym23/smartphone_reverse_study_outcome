package m3;

import android.os.Debug;
import android.support.v4.media.session.PlaybackStateCompat;
import android.text.TextUtils;
import com.bytedance.apm.constant.PerfConsts;
import com.bytedance.apm.util.d;
import com.bytedance.apm.util.g;
import com.bytedance.apm6.service.lifecycle.ActivityLifecycleService;
import com.bytedance.apm6.service.perf.IPerfFilterManager;
import com.bytedance.apm6.util.ListUtils;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class c implements IPerfFilterManager {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static volatile c f22064g;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public CopyOnWriteArraySet f22065a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ConcurrentHashMap f22066b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f22067c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f22068d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f22069e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f22070f;

    public c() {
        this.f22065a = new CopyOnWriteArraySet();
        this.f22066b = new ConcurrentHashMap();
    }

    public static c a() {
        if (f22064g != null) goto L16;
        monitor-enter(c.class);
    L9:
        th = move-exception;
        throw th;
    L7:
        if (f22064g != null) goto L11;
        f22064g = new c();     // Catch: Throwable -> L9
    L11:
        monitor-exit(c.class);     // Catch: Throwable -> L9
    L16:
        return f22064g;
    }

    @Override // com.bytedance.apm6.service.perf.IPerfFilterManager
    public void addPerfTag(String r10, String r11) {
        this.f22066b.put(r10, r11);
    }

    public JSONObject b(boolean r10) {
        JSONObject r11 = new JSONObject();
        Iterator r12 = this.f22066b.entrySet().iterator();     // Catch: JSONException -> L11
    L5:
        if (r12.hasNext() == false) goto L7;
        Map.Entry r13 = (Map.Entry) r12.next();     // Catch: JSONException -> L11
        r11.put((String) r13.getKey(), r13.getValue());     // Catch: JSONException -> L11
        goto L5
    L7:
        r11.put("RealRefreshRate", String.valueOf(g.d()));     // Catch: JSONException -> L11
        r11.put("RealMaxRefreshRate", String.valueOf(g.d()));     // Catch: JSONException -> L11
        if (r10 == false) goto L10;
        d.k().e(r11);     // Catch: JSONException -> L11
        d.k().a(r11);     // Catch: JSONException -> L11
    L10:
        return r11;
    }

    public final void c() {
        this.f22067c = Debug.getNativeHeapAllocatedSize() / PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED;
        Runtime r10 = Runtime.getRuntime();
        long r11 = r10.maxMemory();
        long r12 = r10.freeMemory();
        long r13 = r10.totalMemory();
        this.f22069e = r11 / PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED;
        long r14 = r13 - r12;
        this.f22070f = r14 / PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED;
        if (r14 <= (r11 * 0.95f)) goto L5;
        boolean r15 = true;
    L6:
        this.f22068d = r15;
        return;
    L5:
        r15 = false;
        goto L6
    }

    @Override // com.bytedance.apm6.service.perf.IPerfFilterManager
    public ConcurrentHashMap getPerfFilters() {
        return this.f22066b;
    }

    @Override // com.bytedance.apm6.service.perf.IPerfFilterManager
    public JSONObject getPerfFiltersJson() {
        JSONObject r10 = new JSONObject();
        Iterator r11 = this.f22066b.entrySet().iterator();     // Catch: JSONException -> L9
    L5:
        if (r11.hasNext() == false) goto L8;
        Map.Entry r12 = (Map.Entry) r11.next();     // Catch: JSONException -> L9
        r10.put((String) r12.getKey(), r12.getValue());     // Catch: JSONException -> L9
    L8:
        return r10;
    }

    @Override // com.bytedance.apm6.service.perf.IPerfFilterManager
    public JSONObject getRealTimeMemInfo() {
        JSONObject r10 = new JSONObject();     // Catch: Exception -> L4
        c();     // Catch: Exception -> L4
        r10.put(PerfConsts.PERF_KEY_HAS_NATIVE_HEAP_SIZE, this.f22067c);     // Catch: Exception -> L4
        r10.put(PerfConsts.PERF_KEY_HAS_JAVA_HEAP_LEAK, this.f22068d);     // Catch: Exception -> L4
        r10.put(PerfConsts.PERF_KEY_JAVA_HEAP_USED, this.f22070f);     // Catch: Exception -> L4
        r10.put(PerfConsts.PERF_KEY_JAVA_HEAP_MAX, this.f22069e);     // Catch: Exception -> L4
        return r10;
    L4:
        return null;
    }

    @Override // com.bytedance.apm6.service.perf.IPerfFilterManager
    public CopyOnWriteArraySet getSceneSet() {
        return this.f22065a;
    }

    @Override // com.bytedance.apm6.service.perf.IPerfFilterManager
    public String getSceneString() {
        String r10 = ListUtils.a(this.f22065a.toArray(), "#");
        if (TextUtils.isEmpty(r10) == true) goto L5;
        return r10;
    L5:
        ActivityLifecycleService r11 = (ActivityLifecycleService) o3.a.a(ActivityLifecycleService.class);
        if (r11 != null) goto L8;
        return "";
    L8:
        return r11.getTopActivityClassName();
    }

    @Override // com.bytedance.apm6.service.perf.IPerfFilterManager
    public void removePerfTag(String r10, String r11) {
        this.f22066b.remove(r10, r11);
    }

    @Override // com.bytedance.apm6.service.perf.IPerfFilterManager
    public void startScene(String r10) {
        this.f22065a.add(r10);
    }

    @Override // com.bytedance.apm6.service.perf.IPerfFilterManager
    public void stopScene(String r10) {
        this.f22065a.remove(r10);
    }
}
