package com.bytedance.apm6.hub.config;

import com.bytedance.apm6.foundation.context.ApmContext;
import com.bytedance.apm6.hub.config.internal.ConfigConstants;
import com.bytedance.apm6.hub.config.internal.ConfigManager;
import com.bytedance.apm6.java_alloc.JavaAllocCollector;
import com.bytedance.apm6.java_alloc.JavaAllocConfig;
import com.bytedance.apm6.java_alloc.JavaAllocConfigService;
import com.bytedance.apm6.util.log.Logger;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class JavaAllocConfigManager implements JavaAllocConfigService {
    private JavaAllocConfig config;

    static /* synthetic */ void access$000(JavaAllocConfigManager r0, JSONObject r1, boolean r2) {
        r0.parseConfig(r1, r2);
    }

    public JavaAllocConfigManager() {
        ConfigManager.getInstance().init();
        ConfigManager.getInstance().registerConfigListener(new AnonymousClass1(this));
    }

    @Override // com.bytedance.apm6.java_alloc.JavaAllocConfigService
    public JavaAllocConfig getConfig() {
        return this.config;
    }

    private void parseConfig(JSONObject r10, boolean r11) {
        JSONObject r12 = r10.optJSONObject("performance_modules");
        if (r12 != null) goto L5;
        return;
    L5:
        JSONObject r13 = r12.optJSONObject("memory");
        if (r13 != null) goto L8;
        return;
    L8:
        boolean r2 = true;
        if (r13.optInt(JavaAllocConfig.KEY_CONF_COLLECT, 0) != 1) goto L11;
        boolean r3 = true;
    L13:
        if (r13.optInt(JavaAllocConfig.KEY_CONF_UPLOAD, 0) == 1) goto L16;
        r2 = false;
    L16:
        this.config = new JavaAllocConfig(r3, r2, r13.optInt(JavaAllocConfig.KEY_CONF_COLLECT_PER_THOUSAND_ALLOC, 0), r13.optInt(JavaAllocConfig.KEY_CONF_DUMP_PER_THOUSAND_COLLECT, 0), r13.optInt(JavaAllocConfig.KEY_CONF_THRESHOLD_ALLOC_FREQ, 0), r13.optLong(JavaAllocConfig.KEY_CONF_THRESHOLD_ALLOC_SIZE, 0));
        if (ApmContext.isDebugMode() == false) goto L19;
        Logger.d(ConfigConstants.LOG_TAG, "parsed JavaAllocConfig=" + this.config);
    L19:
        JavaAllocCollector.getInstance().updateConfig(getConfig());
        return;
    L11:
        r3 = false;
        goto L13
    }
}
