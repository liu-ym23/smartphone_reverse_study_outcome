package androidx.work.impl.model;

import java.util.List;

/* JADX INFO: loaded from: classes17.dex */
public interface DependencyDao {
    List<String> getDependentWorkIds(String r100);

    List<String> getPrerequisites(String r100);

    boolean hasCompletedAllPrerequisites(String r100);

    boolean hasDependents(String r100);

    void insertDependency(Dependency r100);
}
