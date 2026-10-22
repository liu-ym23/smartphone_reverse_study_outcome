package com.stepos.aiengine.api;

import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000b\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\r\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u0005H\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/stepos/aiengine/api/IAlgorithmProperties;", "", "<init>", "()V", "PLUGINS", "", "ABILITIES", "MAX_TOKEN_LIMIT", "IS_BUSY", "CURRENT_MODEL", "SUPPORT_CLOUD", "INIT_TIME_MS", "MODEL_MEMORY_MB", "nameOfPlugin", "plugin", "property", "aiengine-api_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class IAlgorithmProperties {
    public static final String ABILITIES = "abilities";
    public static final String CURRENT_MODEL = "current_model";
    public static final String INIT_TIME_MS = "init_time_ms";
    public static final IAlgorithmProperties INSTANCE = new IAlgorithmProperties();
    public static final String IS_BUSY = "algorithm.is_busy";
    public static final String MAX_TOKEN_LIMIT = "token.limit";
    public static final String MODEL_MEMORY_MB = "model_memory_mb";
    public static final String PLUGINS = "plugins";
    public static final String SUPPORT_CLOUD = "support_cloud";

    public static final String nameOfPlugin(String plugin, String property) {
        p.i(plugin, "plugin");
        p.i(property, "property");
        return "plugin." + plugin + "." + property;
    }
}
