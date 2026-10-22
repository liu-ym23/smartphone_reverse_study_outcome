package com.obric.agent;

import com.obric.capabilitykit.entity.app.AppEntity;
import java.util.List;

/* JADX INFO: compiled from: IEntityManager.kt */
/* JADX INFO: loaded from: classes2.dex */
public interface IEntityManager {
    void addEntities(List<? extends AppEntity> r1);

    void addEntity(AppEntity r1);

    List<AppEntity> addVirtualEntities(List<? extends AppEntity> r1, String r2);

    List<AppEntity> checkDeletedEntitie(String r1, long r2);

    List<AppEntity> checkDeletedEntitie(List<? extends AppEntity> r1);

    com.obric.agent.entity.b entityNlg(AppEntity r1, boolean r2);

    com.obric.agent.entity.b entityNlg(List<? extends AppEntity> r1, boolean r2);

    List<AppEntity> getEntityByEcaId(String r1);

    void init();

    void removeEntities(List<? extends AppEntity> r1);

    String replaceECAIdToEntity(String r1, long r2);

    String replaceEntity(String r1, AppEntity r2);
}
