package com.stepos.aiengine.api;

import androidx.constraintlayout.core.dsl.a;
import kotlin.Metadata;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\r\bÆ\u0002\u0018\u00002\u00020\u0001J\u001f\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\t\u0010\bR\u0014\u0010\n\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\n\u0010\bR\u0014\u0010\u000b\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u000b\u0010\bR\u0014\u0010\f\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\f\u0010\bR\u0014\u0010\r\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\r\u0010\bR\u0014\u0010\u000e\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u000e\u0010\b¨\u0006\u000f"}, d2 = {"Lcom/stepos/aiengine/api/IAlgorithmProperties;", "", "", "plugin", "property", "nameOfPlugin", "(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", "PLUGINS", "Ljava/lang/String;", "ABILITIES", "MAX_TOKEN_LIMIT", "IS_BUSY", "CURRENT_MODEL", "INIT_TIME_MS", "MODEL_MEMORY_MB", "aiengine-api_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class IAlgorithmProperties {
    public static final String ABILITIES = "abilities";
    public static final String CURRENT_MODEL = "current_model";
    public static final String INIT_TIME_MS = "init_time_ms";
    public static final IAlgorithmProperties INSTANCE = new IAlgorithmProperties();
    public static final String IS_BUSY = "algorithm.is_busy";
    public static final String MAX_TOKEN_LIMIT = "token.limit";
    public static final String MODEL_MEMORY_MB = "model_memory_mb";
    public static final String PLUGINS = "plugins";

    public static final String nameOfPlugin(String plugin, String property) {
        k.f(plugin, "plugin");
        k.f(property, "property");
        return a.j(new StringBuilder("plugin."), plugin, ".", property);
    }
}
