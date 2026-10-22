package com.obric.cloudsdk.kv.base;

import kotlin.Metadata;

/* JADX INFO: compiled from: KvConstant.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/obric/cloudsdk/kv/base/KvSyncStatus;", "", "()V", "CLOUD_SERVICE_NOT_READY", "", "KV_SYNC_CONFLICT", "KV_SYNC_DISABLED", "KV_SYNC_FAILED", "KV_SYNC_NOTHING_TO_SYNC", "KV_SYNC_NOT_STARTED", "KV_SYNC_SYNCED", "KV_SYNC_SYNCING", "cloudsdk_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class KvSyncStatus {
    public static final int CLOUD_SERVICE_NOT_READY = -2;
    public static final KvSyncStatus INSTANCE = null;
    public static final int KV_SYNC_CONFLICT = 4;
    public static final int KV_SYNC_DISABLED = -1;
    public static final int KV_SYNC_FAILED = 3;
    public static final int KV_SYNC_NOTHING_TO_SYNC = 5;
    public static final int KV_SYNC_NOT_STARTED = 0;
    public static final int KV_SYNC_SYNCED = 2;
    public static final int KV_SYNC_SYNCING = 1;

    static {
        INSTANCE = new KvSyncStatus();
    }

    private KvSyncStatus() {
    }
}
