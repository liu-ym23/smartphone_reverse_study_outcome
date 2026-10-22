package androidx.work.impl.model;

import androidx.work.Data;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public interface WorkProgressDao {
    void delete(String r100);

    void deleteAll();

    Data getProgressForWorkSpecId(String r100);

    List<Data> getProgressForWorkSpecIds(List<String> r100);

    void insert(WorkProgress r100);
}
