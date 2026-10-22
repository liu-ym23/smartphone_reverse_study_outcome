package com.obric.cloudsdk.kv.room.dao;

import com.android.contacts.ContactSaveService;
import com.obric.cloudsdk.kv.room.model.DataSyncStateModel;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: compiled from: DataSyncStateDao.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\u0010\u0011\n\u0002\b\t\ba\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H'J\u0016\u0010\u0002\u001a\u00020\u00032\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0007H'J\u000e\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\u0007H'J\u001e\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00050\u00072\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH'J\u0018\u0010\u000e\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH'J\u0010\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u0005H'J!\u0010\u0010\u001a\u00020\u00112\u0012\u0010\u0006\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00050\u0012\"\u00020\u0005H'¢\u0006\u0002\u0010\u0013J\u0010\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u0005H'J \u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\r2\u0006\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\u0018\u001a\u00020\u000bH'J!\u0010\u0019\u001a\u00020\u00112\u0012\u0010\u001a\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00050\u0012\"\u00020\u0005H'¢\u0006\u0002\u0010\u0013¨\u0006\u001b"}, d2 = {"Lcom/obric/cloudsdk/kv/room/dao/DataSyncStateDao;", "", "delete", "", "state", "Lcom/obric/cloudsdk/kv/room/model/DataSyncStateModel;", "stateList", "", "getAll", "getDataSyncState", ContactSaveService.EXTRA_DATA_ID, "", "tableName", "", "getSyncId", "insert", "insertAll", "", "", "([Lcom/obric/cloudsdk/kv/room/model/DataSyncStateModel;)V", "update", "syncStateModel", "syncId", "updateTime", "updateTime2", "updateAll", "fileList", "cloudsdk_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface DataSyncStateDao {
    int delete(DataSyncStateModel r1);

    int delete(List<DataSyncStateModel> r1);

    List<DataSyncStateModel> getAll();

    List<DataSyncStateModel> getDataSyncState(long r1, String r3);

    DataSyncStateModel getSyncId(long r1, String r3);

    long insert(DataSyncStateModel r1);

    void insertAll(DataSyncStateModel... r1);

    int update(DataSyncStateModel r1);

    int update(String r1, long r2, long r4);

    void updateAll(DataSyncStateModel... r1);
}
