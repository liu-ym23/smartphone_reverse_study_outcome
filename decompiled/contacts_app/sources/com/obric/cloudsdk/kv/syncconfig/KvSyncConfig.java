package com.obric.cloudsdk.kv.syncconfig;

import com.google.gson.annotations.SerializedName;
import com.obric.aikernel.sdk.ext.CozeCloudExt;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: KvSyncConfig.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0080\b\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0002\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006HÆ\u0003J-\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001J\b\u0010\u0016\u001a\u00020\u0017H\u0016R\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u001c\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0018"}, d2 = {"Lcom/obric/cloudsdk/kv/syncconfig/KvSyncConfig;", "", "configVersion", "", "appId", "syncDataArray", "", "Lcom/obric/cloudsdk/kv/syncconfig/SyncData;", "(IILjava/util/List;)V", "getAppId", "()I", "getConfigVersion", "getSyncDataArray", "()Ljava/util/List;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "", "cloudsdk_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class KvSyncConfig {

    @SerializedName(CozeCloudExt.API_KEY_APP_ID)
    private final int appId;

    @SerializedName("config_version")
    private final int configVersion;

    @SerializedName("sync_data_array")
    private final List<SyncData> syncDataArray;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ KvSyncConfig copy$default(KvSyncConfig r0, int r1, int r2, List r3, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = r0.configVersion;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r2 = r0.appId;
    L9:
        if ((r4 & 4) == 0) goto L12;
        r3 = r0.syncDataArray;
    L12:
        return r0.copy(r1, r2, r3);
    }

    public final int component1() {
        return this.configVersion;
    }

    public final int component2() {
        return this.appId;
    }

    public final List<SyncData> component3() {
        return this.syncDataArray;
    }

    public final KvSyncConfig copy(int r1, int r2, List<SyncData> r3) {
        Intrinsics.checkNotNullParameter(r3, "syncDataArray");
        return new KvSyncConfig(r1, r2, r3);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof KvSyncConfig) == true) goto L8;
        return false;
    L8:
        KvSyncConfig r6 = (KvSyncConfig) r5;
        if (this.configVersion == r6.configVersion) goto L12;
        return false;
    L12:
        if (this.appId == r6.appId) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.syncDataArray, r6.syncDataArray) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        return (((Integer.hashCode(this.configVersion) * 31) + Integer.hashCode(this.appId)) * 31) + this.syncDataArray.hashCode();
    }

    public KvSyncConfig(int r2, int r3, List<SyncData> r4) {
        Intrinsics.checkNotNullParameter(r4, "syncDataArray");
        this.configVersion = r2;
        this.appId = r3;
        this.syncDataArray = r4;
    }

    public final int getConfigVersion() {
        return this.configVersion;
    }

    public final int getAppId() {
        return this.appId;
    }

    public final List<SyncData> getSyncDataArray() {
        return this.syncDataArray;
    }

    public String toString() {
        return "KvSyncConfig(configVersion=" + this.configVersion + ", appId=" + this.appId + ", syncDataArray=" + this.syncDataArray + ')';
    }
}
