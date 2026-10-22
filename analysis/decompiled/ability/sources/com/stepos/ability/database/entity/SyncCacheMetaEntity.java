package com.stepos.ability.database.entity;

import androidx.appfunctions.metadata.a;
import androidx.compose.foundation.b;
import androidx.room.Entity;
import kotlin.Metadata;
import kotlin.jvm.internal.k;

@Entity(tableName = "t_sync_cache_meta")
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/stepos/ability/database/entity/SyncCacheMetaEntity;", "", "database_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class SyncCacheMetaEntity {

    /* renamed from: a, reason: collision with root package name */
    public final int f3093a;
    public final long b;
    public final long c;
    public final long d;
    public final long e;
    public final long f;
    public final String g;

    public SyncCacheMetaEntity() {
        this(0);
    }

    public static SyncCacheMetaEntity a(SyncCacheMetaEntity syncCacheMetaEntity, long j5, long j6, long j10, long j11, long j12, String str, int i) {
        long j13 = j5;
        int i6 = syncCacheMetaEntity.f3093a;
        if ((i & 2) != 0) {
            j13 = syncCacheMetaEntity.b;
        }
        if ((i & 4) != 0) {
            j6 = syncCacheMetaEntity.c;
        }
        if ((i & 8) != 0) {
            j10 = syncCacheMetaEntity.d;
        }
        if ((i & 16) != 0) {
            j11 = syncCacheMetaEntity.e;
        }
        if ((i & 32) != 0) {
            j12 = syncCacheMetaEntity.f;
        }
        if ((i & 64) != 0) {
            str = syncCacheMetaEntity.g;
        }
        String deviceId = str;
        syncCacheMetaEntity.getClass();
        k.f(deviceId, "deviceId");
        return new SyncCacheMetaEntity(i6, j13, j6, j10, j11, j12, deviceId);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SyncCacheMetaEntity)) {
            return false;
        }
        SyncCacheMetaEntity syncCacheMetaEntity = (SyncCacheMetaEntity) obj;
        return this.f3093a == syncCacheMetaEntity.f3093a && this.b == syncCacheMetaEntity.b && this.c == syncCacheMetaEntity.c && this.d == syncCacheMetaEntity.d && this.e == syncCacheMetaEntity.e && this.f == syncCacheMetaEntity.f && k.b(this.g, syncCacheMetaEntity.g);
    }

    public final int hashCode() {
        return this.g.hashCode() + a.c(a.c(a.c(a.c(a.c(Integer.hashCode(this.f3093a) * 31, 31, this.b), 31, this.c), 31, this.d), 31, this.e), 31, this.f);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("SyncCacheMetaEntity(id=");
        sb.append(this.f3093a);
        sb.append(", localScanGeneration=");
        sb.append(this.b);
        b.y(this.c, ", cloudSyncGeneration=", ", localScanCompletedAt=", sb);
        sb.append(this.d);
        b.y(this.e, ", cloudSyncCompletedAt=", ", uploadLastSuccessAt=", sb);
        sb.append(this.f);
        sb.append(", deviceId=");
        sb.append(this.g);
        sb.append(")");
        return sb.toString();
    }

    public SyncCacheMetaEntity(int i, long j5, long j6, long j10, long j11, long j12, String deviceId) {
        k.f(deviceId, "deviceId");
        this.f3093a = i;
        this.b = j5;
        this.c = j6;
        this.d = j10;
        this.e = j11;
        this.f = j12;
        this.g = deviceId;
    }

    public /* synthetic */ SyncCacheMetaEntity(int i) {
        this(1, 0L, 0L, 0L, 0L, 0L, "");
    }
}
