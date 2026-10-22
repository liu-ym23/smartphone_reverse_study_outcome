package v1;

import com.bytedance.apm.constant.CommonServiceName;
import com.bytedance.apm.constant.SlardarSettingsConsts;
import com.bytedance.apm.util.i;
import com.bytedance.services.slardar.config.IConfigListener;
import com.bytedance.services.slardar.config.IConfigManager;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class c implements IConfigListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map f24973a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map f24974b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public List f24975c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public List f24976d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public List f24977e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Map f24978f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public volatile JSONObject f24979g;

    public static /* synthetic */ class a {
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c f24980a = null;

        static {
            f24980a = new c(null);
        }

        public static /* synthetic */ c a() {
            return f24980a;
        }
    }

    public /* synthetic */ c(a r10) {
        this();
    }

    public static c a() {
        return b.a();
    }

    public boolean b(String r10) {
        Boolean r11 = (Boolean) this.f24973a.get(r10);
        if (r11 != null) goto L7;
        return false;
    L7:
        return r11.booleanValue();
    }

    public boolean c(String r10, String r11) {
        Boolean r12 = (Boolean) this.f24974b.get(r10);
        if (this.f24979g != null) goto L5;
    L7:
        boolean r13 = false;
    L8:
        if (r12 != null) goto L10;
    L12:
        if (r13 == true) goto L14;
        return false;
    L14:
        return true;
    L10:
        if (r12.booleanValue() == false) goto L12;
    L5:
        if (this.f24979g.optInt(r11) != 1) goto L7;
        r13 = true;
        goto L8
    }

    public boolean d(String r10) {
        Boolean r11 = (Boolean) this.f24974b.get(r10);
        if (r11 != null) goto L7;
        return false;
    L7:
        return r11.booleanValue();
    }

    public final void e(JSONObject r10) {
        if (r10 != null) goto L4;
        return;
    L4:
        Map r11 = this.f24974b;
        boolean r12 = false;
        if (r10.optInt(SlardarSettingsConsts.PERF_KEY_BATTERY_TEMPERATURE_ENABLE_UPLOAD, 0) != 1) goto L7;
        boolean r13 = true;
    L8:
        r11.put(CommonServiceName.MONITOR_TYPE_TEMPERATURE, Boolean.valueOf(r13));
        Map r14 = this.f24974b;
        if (r10.optInt(SlardarSettingsConsts.PERF_BATTERY_EXCEPTION, 0) != 1) goto L11;
        r12 = true;
    L11:
        r14.put("battery_trace", Boolean.valueOf(r12));
        return;
    L7:
        r13 = false;
        goto L8
    }

    public final void f(JSONObject r10) {
        if (r10 != null) goto L4;
        return;
    L4:
        Map r11 = this.f24974b;
        boolean r12 = false;
        if (r10.optInt("exception", 0) != 1) goto L7;
        r12 = true;
    L7:
        r11.put("cpu_trace", Boolean.valueOf(r12));
    }

    public final void g(JSONObject r10) {
        if (r10 != null) goto L4;
        return;
    L4:
        Map r11 = this.f24974b;
        boolean r12 = false;
        if (r10.optInt("memory_object_monitor", 0) != 1) goto L7;
        r12 = true;
    L7:
        r11.put("memory_object_monitor", Boolean.valueOf(r12));
    }

    public final void h(JSONObject r10) {
        JSONObject r11 = r10.optJSONObject("performance_modules");
        if (r11 != null) goto L5;
        return;
    L5:
        Iterator r12 = this.f24975c.iterator();
    L7:
        if (r12.hasNext() == false) goto L28;
        String r13 = (String) r12.next();
        JSONObject r14 = r11.optJSONObject(r13);
        if (SlardarSettingsConsts.PERF_KEY_SMOOTH.equals(r13) == true) goto L10;
        if ("memory".equals(r13) == false) goto L15;
        g(r14);
    L15:
        if ("battery".equals(r13) == false) goto L18;
        e(r14);
    L18:
        if ("cpu".equals(r13) == false) goto L21;
        f(r14);
    L21:
        if ("start_trace".equals(r13) == false) goto L23;
        j(r14);
    L23:
        if (r14 == null) goto L27;
        if (r14.optInt("enable_upload", 0) != 1) goto L27;
        this.f24973a.put(r13, Boolean.TRUE);
    L27:
        this.f24973a.put(r13, Boolean.FALSE);
        goto L7
    L10:
        i(r14);
        goto L7
    L28:
        this.f24979g = i.g(r11, SlardarSettingsConsts.PERF_KEY_SMOOTH, SlardarSettingsConsts.PERF_SMOOTH_SCENE_ENABLE_UPLOAD);
    }

    public final void i(JSONObject r10) {
        if (r10 != null) goto L4;
        return;
    L4:
        Iterator r11 = this.f24976d.iterator();
    L6:
        if (r11.hasNext() == false) goto L15;
        String r12 = (String) r11.next();
        Map r13 = this.f24974b;     // Catch: Exception -> L13
        Object r14 = this.f24978f.get(r12);     // Catch: Exception -> L13
        boolean r15 = false;
        if (r10.optInt(r12, 0) != 1) goto L11;
        r15 = true;
    L11:
        r13.put(r14, Boolean.valueOf(r15));     // Catch: Exception -> L13
    L13:
        e = move-exception;
        e.printStackTrace();
        goto L6
    }

    public final void j(JSONObject r10) {
        if (r10 != null) goto L4;
        return;
    L4:
        Iterator r11 = this.f24977e.iterator();
    L6:
        if (r11.hasNext() == false) goto L15;
        String r12 = (String) r11.next();
        Map r13 = this.f24974b;     // Catch: Exception -> L13
        boolean r14 = false;
        if (r10.optInt(r12, 0) != 1) goto L11;
        r14 = true;
    L11:
        r13.put(r12, Boolean.valueOf(r14));     // Catch: Exception -> L13
    L13:
        e = move-exception;
        e.printStackTrace();
        goto L6
    }

    @Override // com.bytedance.services.slardar.config.IConfigListener
    public void onReady() {
    }

    @Override // com.bytedance.services.slardar.config.IConfigListener
    public void onRefresh(JSONObject r10, boolean r11) {
        if (r10 != null) goto L4;
        return;
    L4:
        h(r10);
    }

    public c() {
        this.f24973a = new ConcurrentHashMap();
        this.f24974b = new ConcurrentHashMap();
        this.f24978f = new HashMap();
        LinkedList r10 = new LinkedList();
        this.f24975c = r10;
        r10.addAll(Arrays.asList(new String[]{"battery", SlardarSettingsConsts.PERF_KEY_SMOOTH, "cpu", "disk", "memory", "thread", SlardarSettingsConsts.PERF_KEY_FD, "page_load", "page_load_trace", "start", "start_trace", "traffic", SlardarSettingsConsts.PERF_KEY_UI}));
        ArrayList r11 = new ArrayList();
        this.f24976d = r11;
        r11.add("enable_upload");
        this.f24976d.add(SlardarSettingsConsts.PERF_SMOOTH_DROP_ENABLE_UPLOAD);
        this.f24976d.add(SlardarSettingsConsts.PERF_SMOOTH_SERIOUS_BLOCK_ENABLE_UPLOAD);
        this.f24976d.add(SlardarSettingsConsts.PERF_SMOOTH_BLOCK_ENABLE_UPLOAD);
        this.f24976d.add(SlardarSettingsConsts.PERF_SMOOTH_SLOW_METHOD_ENABLE_UPLOAD);
        LinkedList r12 = new LinkedList();
        this.f24977e = r12;
        r12.add(SlardarSettingsConsts.PERF_KEY_PERF_DATA_COLLECT);
        this.f24978f.put("enable_upload", "fps");
        this.f24978f.put(SlardarSettingsConsts.PERF_SMOOTH_DROP_ENABLE_UPLOAD, "fps_drop");
        this.f24978f.put(SlardarSettingsConsts.PERF_SMOOTH_BLOCK_ENABLE_UPLOAD, "block_monitor");
        this.f24978f.put(SlardarSettingsConsts.PERF_SMOOTH_SLOW_METHOD_ENABLE_UPLOAD, "drop_frame_stack");
        this.f24978f.put(SlardarSettingsConsts.PERF_SMOOTH_SERIOUS_BLOCK_ENABLE_UPLOAD, "serious_block_monitor");
        ((IConfigManager) n5.b.a(IConfigManager.class)).registerConfigListener(this);
    }
}
