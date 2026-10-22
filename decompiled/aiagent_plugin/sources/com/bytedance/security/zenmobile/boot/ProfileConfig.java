package com.bytedance.security.zenmobile.boot;

import com.fasterxml.jackson.annotation.JsonProperty;

/* JADX INFO: loaded from: classes.dex */
public class ProfileConfig {
    static final String LOADER_PUBLIC_TCC = "public_tcc";

    @JsonProperty("fallback_local_loader")
    boolean fallbackLocalLoader;

    @JsonProperty("keys")
    String[] keys;

    @JsonProperty("loader")
    String loader;

    @JsonProperty("only_enable_rules")
    long[] onlyEnableRules;

    public ProfileConfig() {
    }

    public static ProfileConfig defaultProfileConfig() {
        ProfileConfig r0 = new ProfileConfig();
        r0.keys = new String[]{"default_android"};
        r0.loader = LOADER_PUBLIC_TCC;
        r0.fallbackLocalLoader = true;
        r0.onlyEnableRules = new long[0];
        return r0;
    }
}
