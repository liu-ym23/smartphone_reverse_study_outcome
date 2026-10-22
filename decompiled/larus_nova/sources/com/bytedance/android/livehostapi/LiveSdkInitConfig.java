package com.bytedance.android.livehostapi;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0012\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/livehostapi/LiveSdkInitConfig;", "", "()V", "livePreinitOptV2", "", "hostapp-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveSdkInitConfig {
    public static final LiveSdkInitConfig INSTANCE = null;
    public static volatile boolean livePreinitOptV2;

    private LiveSdkInitConfig() {
    }

    static {
        INSTANCE = new LiveSdkInitConfig();
    }
}
