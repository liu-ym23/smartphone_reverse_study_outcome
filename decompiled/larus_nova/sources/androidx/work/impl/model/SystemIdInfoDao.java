package androidx.work.impl.model;

import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public interface SystemIdInfoDao {
    SystemIdInfo getSystemIdInfo(String r100);

    List<String> getWorkSpecIds();

    void insertSystemIdInfo(SystemIdInfo r100);

    void removeSystemIdInfo(String r100);
}
