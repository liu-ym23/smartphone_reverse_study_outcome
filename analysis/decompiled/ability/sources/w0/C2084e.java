package w0;

import com.bytedance.services.slardar.config.IConfigManager;
import com.stepos.aiengine.algorithm.chat.LlmRuntimeArgsBundle;
import com.stepos.aiengine.args.SingleFileBundle;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

/* renamed from: w0.e, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C2084e implements C.a {

    /* renamed from: a, reason: collision with root package name */
    public final ConcurrentHashMap f6809a = new ConcurrentHashMap();
    public final ConcurrentHashMap b = new ConcurrentHashMap();
    public final LinkedList c;
    public final ArrayList d;
    public final LinkedList e;
    public final LinkedList f;
    public final HashMap g;
    public volatile JSONObject h;

    public C2084e() {
        HashMap map = new HashMap();
        this.g = map;
        LinkedList linkedList = new LinkedList();
        this.c = linkedList;
        linkedList.addAll(Arrays.asList("battery", "smooth", "cpu", "disk", "memory", "thread", SingleFileBundle.KEY_FILE_DESCRIPTOR, "page_load", "page_load_trace", "start", "user_indicator_module", "start_trace", "traffic", "ui"));
        ArrayList arrayList = new ArrayList();
        this.d = arrayList;
        arrayList.add("enable_upload");
        arrayList.add("drop_enable_upload");
        arrayList.add("serious_block_enable_upload");
        arrayList.add("block_enable_upload");
        arrayList.add("slow_method_enable_upload");
        LinkedList linkedList2 = new LinkedList();
        this.e = linkedList2;
        linkedList2.add("enable_perf_data_collect");
        LinkedList linkedList3 = new LinkedList();
        this.f = linkedList3;
        linkedList3.add("background_rate");
        linkedList3.add("foreground_rate");
        map.put("enable_upload", "fps");
        map.put("drop_enable_upload", "fps_drop");
        map.put("block_enable_upload", "block_monitor");
        map.put("slow_method_enable_upload", "drop_frame_stack");
        map.put("serious_block_enable_upload", "serious_block_monitor");
        ((IConfigManager) L2.a.a(IConfigManager.class)).registerConfigListener(this);
    }

    @Override // C.a
    public final void onReady() {
    }

    @Override // C.a
    public final void onRefresh(JSONObject jSONObject, boolean z10) {
        JSONObject jSONObjectOptJSONObject;
        if (jSONObject == null || (jSONObjectOptJSONObject = jSONObject.optJSONObject("performance_modules")) == null) {
            return;
        }
        for (String str : this.c) {
            JSONObject jSONObjectOptJSONObject2 = jSONObjectOptJSONObject.optJSONObject(str);
            if (!"smooth".equals(str)) {
                if ("memory".equals(str) && jSONObjectOptJSONObject2 != null) {
                    this.b.put("memory_object_monitor", Boolean.valueOf(jSONObjectOptJSONObject2.optInt("memory_object_monitor", 0) == 1));
                }
                if ("battery".equals(str) && jSONObjectOptJSONObject2 != null) {
                    this.b.put(LlmRuntimeArgsBundle.KEY_TEMPERATURE, Boolean.valueOf(jSONObjectOptJSONObject2.optInt("temperature_enable_upload", 0) == 1));
                    this.b.put("battery_trace", Boolean.valueOf(jSONObjectOptJSONObject2.optInt("exception_enable_upload", 0) == 1));
                }
                if ("cpu".equals(str) && jSONObjectOptJSONObject2 != null) {
                    this.b.put("cpu_trace", Boolean.valueOf(jSONObjectOptJSONObject2.optInt("exception", 0) == 1));
                }
                if ("start_trace".equals(str) && jSONObjectOptJSONObject2 != null) {
                    for (String str2 : this.e) {
                        try {
                            this.b.put(str2, Boolean.valueOf(jSONObjectOptJSONObject2.optInt(str2, 0) == 1));
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
                if ("user_indicator_module".equals(str) && jSONObjectOptJSONObject2 != null) {
                    for (String str3 : this.f) {
                        try {
                            this.b.put(str3, Boolean.valueOf(jSONObjectOptJSONObject2.optInt(str3, 0) == 1));
                        } catch (Exception e6) {
                            e6.printStackTrace();
                        }
                    }
                }
                if (jSONObjectOptJSONObject2 == null || jSONObjectOptJSONObject2.optInt("enable_upload", 0) != 1) {
                    this.f6809a.put(str, Boolean.FALSE);
                } else {
                    this.f6809a.put(str, Boolean.TRUE);
                }
            } else if (jSONObjectOptJSONObject2 != null) {
                Iterator it = this.d.iterator();
                while (it.hasNext()) {
                    String str4 = (String) it.next();
                    try {
                        this.b.put((String) this.g.get(str4), Boolean.valueOf(jSONObjectOptJSONObject2.optInt(str4, 0) == 1));
                    } catch (Exception e9) {
                        e9.printStackTrace();
                    }
                }
            }
        }
        this.h = S0.b.u("smooth", jSONObjectOptJSONObject, "scene_enable_upload");
    }
}
