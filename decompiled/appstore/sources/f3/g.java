package f3;

import com.bytedance.apm.constant.SlardarSettingsConsts;
import com.bytedance.apm6.hub.config.internal.ConfigConstants;
import com.bytedance.apm6.hub.config.internal.IConfigChangeListener;
import com.bytedance.apm6.hub.config.internal.SlardarSettingsConstants;
import com.bytedance.apm6.memory.MemoryCollector;
import com.bytedance.apm6.memory.config.MemoryConfigService;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public abstract class g implements MemoryConfigService {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public j3.a f19458a;

    public class a implements IConfigChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ g f19459a;

        public a(g r10) {
            this.f19459a = r10;
        }

        @Override // com.bytedance.apm6.hub.config.internal.IConfigChangeListener
        public void onConfigChanged(JSONObject r10, boolean r11) {
            g.a(this.f19459a, r10, r11);
        }
    }

    public g() {
        g3.a.g().h();
        g3.a.g().k(new a(this));
    }

    public static /* synthetic */ void a(g r10, JSONObject r11, boolean r12) {
        r10.b(r11, r12);
    }

    public final void b(JSONObject r10, boolean r11) {
        JSONObject r12 = r10.optJSONObject("performance_modules");
        if (r12 != null) goto L5;
        return;
    L5:
        JSONObject r13 = r12.optJSONObject("memory");
        if (r13 != null) goto L8;
        return;
    L8:
        long r14 = r13.optLong("collect_interval", 120);
        double r15 = r13.optDouble(SlardarSettingsConsts.PERF_MEMORY_REACHTOP_RATE, 0.8d);
        if (r13.optInt("enable_upload", 0) != 1) goto L11;
        boolean r16 = true;
    L13:
        if (r13.optInt(SlardarSettingsConstants.PERF_MEMORY_CLOSE_COLLECT) == 1) goto L15;
        boolean r17 = true;
    L16:
        this.f19458a = new j3.a(r14, r15, false, false, r16, r17);
        if (r3.a.c() == false) goto L19;
        s3.a.a(ConfigConstants.LOG_TAG, "parsed MemoryConfig=" + this.f19458a);
    L19:
        MemoryCollector.getInstance().updateConfig(getConfig());
        return;
    L15:
        r17 = false;
        goto L16
    L11:
        r16 = false;
        goto L13
    }

    @Override // com.bytedance.apm6.memory.config.MemoryConfigService
    public j3.a getConfig() {
        return this.f19458a;
    }
}
