package com.bytedance.android.livesdkapi.room.state;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\b¨\u0006\f"}, d2 = {"Lcom/bytedance/android/livesdkapi/room/state/AppState;", "", "()V", "appName", "", "getAppName", "()Ljava/lang/String;", "setAppName", "(Ljava/lang/String;)V", "clientKey", "getClientKey", "setClientKey", "livesdkapi_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AppState {
    private String appName;
    private String clientKey;

    public AppState() {
    }

    public final String getAppName() {
        return this.appName;
    }

    public final String getClientKey() {
        return this.clientKey;
    }

    public final void setAppName(String r100) {
        this.appName = r100;
    }

    public final void setClientKey(String r100) {
        this.clientKey = r100;
    }
}
