package com.bytedance.security.zenmobile.profile;

import com.bytedance.security.zenmobile.boot.DeidentifierConfig;

/* JADX INFO: loaded from: classes.dex */
public class ProfileConfig {
    private static final String DEFAULT_PROFILE_KEY = "default_android";
    private DeidentifierConfig deidentifierConfig;
    private int maxDetectionLen;
    private String profileKey;
    private boolean skipFailureCompilation;
    private int truncationLen;

    public ProfileConfig(String r1, boolean r2, String r3, String r4, int r5, int r6) {
        this.profileKey = r1;
        this.skipFailureCompilation = r2;
        this.deidentifierConfig = new DeidentifierConfig(r3, r4);
        this.maxDetectionLen = r5;
        this.truncationLen = r6;
    }

    public static ProfileConfig defaultProfileConfig() {
        DeidentifierConfig r0 = DeidentifierConfig.defaultDeidentifierConfig();
        return new ProfileConfig(DEFAULT_PROFILE_KEY, false, r0.getMode(), r0.getValue(), 0, 0);
    }

    public String getProfileKey() {
        return this.profileKey;
    }

    public boolean isSkipFailureCompilation() {
        return this.skipFailureCompilation;
    }

    public DeidentifierConfig getDeidentifierConfig() {
        return this.deidentifierConfig;
    }

    public int getMaxDetectionLen() {
        return this.maxDetectionLen;
    }

    public int getTruncationLen() {
        return this.truncationLen;
    }
}
