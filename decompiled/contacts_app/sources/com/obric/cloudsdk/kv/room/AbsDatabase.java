package com.obric.cloudsdk.kv.room;

import androidx.room.RoomDatabase;
import com.obric.cloudsdk.kv.room.dao.DataSyncStateDao;
import com.obric.cloudsdk.kv.room.dao.KvFileInfoDao;
import kotlin.Metadata;

/* JADX INFO: compiled from: AbsDatabase.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b!\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H&J\b\u0010\u0005\u001a\u00020\u0006H&¨\u0006\u0007"}, d2 = {"Lcom/obric/cloudsdk/kv/room/AbsDatabase;", "Landroidx/room/RoomDatabase;", "()V", "dataSyncStateDao", "Lcom/obric/cloudsdk/kv/room/dao/DataSyncStateDao;", "kvFileInfoDao", "Lcom/obric/cloudsdk/kv/room/dao/KvFileInfoDao;", "cloudsdk_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public abstract class AbsDatabase extends RoomDatabase {
    public abstract DataSyncStateDao dataSyncStateDao();

    public abstract KvFileInfoDao kvFileInfoDao();

    public AbsDatabase() {
    }
}
