package androidx.work.impl.model;

import java.util.List;

/* JADX INFO: loaded from: classes17.dex */
public interface WorkTagDao {
    List<String> getTagsForWorkSpecId(String r100);

    List<String> getWorkSpecIdsWithTag(String r100);

    void insert(WorkTag r100);
}
