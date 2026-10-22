package com.obric.cloudsdk.kv.room.dao;

import com.obric.cloudsdk.kv.room.model.KvFileInfoModel;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: compiled from: KvFileInfoDao.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\ba\u0018\u00002\u00020\u0001J\u000e\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H'J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0007H'J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0007H'J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0004H'J!\u0010\r\u001a\u00020\u000e2\u0012\u0010\u000f\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00040\u0010\"\u00020\u0004H'¢\u0006\u0002\u0010\u0011J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\f\u001a\u00020\u0004H'J!\u0010\u0014\u001a\u00020\u000e2\u0012\u0010\u000f\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00040\u0010\"\u00020\u0004H'¢\u0006\u0002\u0010\u0011¨\u0006\u0015"}, d2 = {"Lcom/obric/cloudsdk/kv/room/dao/KvFileInfoDao;", "", "getAll", "", "Lcom/obric/cloudsdk/kv/room/model/KvFileInfoModel;", "getByFileId", "fileId", "", "getByLocalPath", "localPath", "insert", "", "file", "insertAll", "", "fileList", "", "([Lcom/obric/cloudsdk/kv/room/model/KvFileInfoModel;)V", "update", "", "updateAll", "cloudsdk_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface KvFileInfoDao {
    List<KvFileInfoModel> getAll();

    KvFileInfoModel getByFileId(String r1);

    KvFileInfoModel getByLocalPath(String r1);

    long insert(KvFileInfoModel r1);

    void insertAll(KvFileInfoModel... r1);

    int update(KvFileInfoModel r1);

    void updateAll(KvFileInfoModel... r1);
}
