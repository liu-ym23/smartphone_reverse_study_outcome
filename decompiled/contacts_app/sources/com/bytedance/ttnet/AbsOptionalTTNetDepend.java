package com.bytedance.ttnet;

import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public abstract class AbsOptionalTTNetDepend {
    public String[] getHttpDnsHardCodeIps() {
        return null;
    }

    public String[] getPreloadDomains() {
        return null;
    }

    public int getProcessFlag() {
        return 0;
    }

    public boolean getRefineAppDelayEnable() {
        return true;
    }

    public Map<String, String> getTNCExtraParam() {
        return null;
    }

    public boolean isPrivacyAccessEnabled() {
        return false;
    }

    public AbsOptionalTTNetDepend() {
    }
}
