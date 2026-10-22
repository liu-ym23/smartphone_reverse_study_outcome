package com.bytedance.android.bst.api.config;

import kotlin.Metadata;
import rc.f;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016¨\u0006\b"}, d2 = {"Lcom/bytedance/android/bst/api/config/IBstConfigProvider;", "", "Lrc/f;", "getConfig", "", "isInitOptEnable", "", "updateDelayTime", "api_cnRelease"}, k = 1, mv = {1, 4, 0})
public interface IBstConfigProvider {
    f getConfig();

    boolean isInitOptEnable();

    long updateDelayTime();
}
