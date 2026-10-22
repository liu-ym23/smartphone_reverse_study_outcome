package com.obric.cloudsdk.kv.base;

import kotlin.Metadata;

/* JADX INFO: compiled from: KvConstant.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/obric/cloudsdk/kv/base/KvSyncError;", "", "()V", "CLOUD_SERVICE_NOT_READY", "", "DEVICE_NOT_OK", "NO_ERROR", "SYNC_DISABLED", "USER_NOT_LOGIN", "WRONG_PARAMETER", "cloudsdk_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class KvSyncError {
    public static final int CLOUD_SERVICE_NOT_READY = 3;
    public static final int DEVICE_NOT_OK = 2;
    public static final KvSyncError INSTANCE = null;
    public static final int NO_ERROR = 0;
    public static final int SYNC_DISABLED = 5;
    public static final int USER_NOT_LOGIN = 4;
    public static final int WRONG_PARAMETER = 1;

    static {
        INSTANCE = new KvSyncError();
    }

    private KvSyncError() {
    }
}
