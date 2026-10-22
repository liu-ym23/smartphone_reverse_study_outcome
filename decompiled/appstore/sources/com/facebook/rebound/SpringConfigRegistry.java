package com.facebook.rebound;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class SpringConfigRegistry {
    private static final SpringConfigRegistry INSTANCE = null;
    private final Map<SpringConfig, String> mSpringConfigMap;

    static {
        INSTANCE = new SpringConfigRegistry(true);
    }

    public SpringConfigRegistry(boolean r10) {
        this.mSpringConfigMap = new HashMap();
        if (r10 == false) goto L6;
        addSpringConfig(SpringConfig.defaultConfig, "default config");
        return;
    }

    public static SpringConfigRegistry getInstance() {
        return INSTANCE;
    }

    public boolean addSpringConfig(SpringConfig r10, String r11) {
        if (r10 == null) goto L13;
        if (r11 == null) goto L11;
        if (this.mSpringConfigMap.containsKey(r10) == false) goto L8;
        return false;
    L8:
        this.mSpringConfigMap.put(r10, r11);
        return true;
    L11:
        throw new IllegalArgumentException("configName is required");
    L13:
        throw new IllegalArgumentException("springConfig is required");
    }

    public Map<SpringConfig, String> getAllSpringConfig() {
        return Collections.unmodifiableMap(this.mSpringConfigMap);
    }

    public void removeAllSpringConfig() {
        this.mSpringConfigMap.clear();
    }

    public boolean removeSpringConfig(SpringConfig r10) {
        if (r10 == null) goto L9;
        if (this.mSpringConfigMap.remove(r10) == null) goto L6;
        return true;
    L6:
        return false;
    L9:
        throw new IllegalArgumentException("springConfig is required");
    }
}
