package androidx.work.impl.model;

import java.util.List;

/* JADX INFO: loaded from: classes17.dex */
public interface WorkNameDao {
    List<String> getNamesForWorkSpecId(String r100);

    List<String> getWorkSpecIdsWithName(String r100);

    void insert(WorkName r100);
}
