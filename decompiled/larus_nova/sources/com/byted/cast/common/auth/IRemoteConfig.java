package com.byted.cast.common.auth;

import com.byted.cast.common.ContextManager;
import com.byted.cast.common.config.Config;
import com.byted.cast.common.config.ConfigManager;

/* JADX INFO: loaded from: classes39.dex */
public interface IRemoteConfig {
    void init(ContextManager.CastContext r100, Config r101);

    void pullConfig(ConfigManager r100, IPullRemoteConfigListener r101);
}
