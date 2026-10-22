package f3;

import com.bytedance.apm6.hub.config.internal.ConfigConstants;
import com.bytedance.apm6.hub.config.internal.IConfigChangeListener;
import com.bytedance.apm6.java_alloc.JavaAllocConfigService;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class f implements JavaAllocConfigService {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public com.bytedance.apm6.java_alloc.b f19456a;

    public class a implements IConfigChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ f f19457a;

        public a(f r10) {
            this.f19457a = r10;
        }

        @Override // com.bytedance.apm6.hub.config.internal.IConfigChangeListener
        public void onConfigChanged(JSONObject r10, boolean r11) {
            f.a(this.f19457a, r10, r11);
        }
    }

    public f() {
        g3.a.g().h();
        g3.a.g().k(new a(this));
    }

    public static /* synthetic */ void a(f r10, JSONObject r11, boolean r12) {
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
        boolean r14 = true;
        if (r13.optInt("enable_alloc_collect", 0) != 1) goto L11;
        boolean r15 = true;
    L13:
        if (r13.optInt("enable_alloc_upload", 0) == 1) goto L16;
        r14 = false;
    L16:
        this.f19456a = new com.bytedance.apm6.java_alloc.b(r15, r14, r13.optInt("alloc_collect_per_thousand_alloc", 0), r13.optInt("alloc_dump_per_thousand_collect", 0), r13.optInt("alloc_threshold_alloc_frequency", 0), r13.optLong("alloc_threshold_alloc_size", 0));
        if (r3.a.c() == false) goto L19;
        s3.a.a(ConfigConstants.LOG_TAG, "parsed JavaAllocConfig=" + this.f19456a);
    L19:
        com.bytedance.apm6.java_alloc.a.b().e(getConfig());
        return;
    L11:
        r15 = false;
        goto L13
    }

    @Override // com.bytedance.apm6.java_alloc.JavaAllocConfigService
    public com.bytedance.apm6.java_alloc.b getConfig() {
        return this.f19456a;
    }
}
