package com.obric.capabilitykit.sync;

import com.obric.capabilitykit.entity.app.AppEntity;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public interface EntitySyncDataSupplier {
    List<AppEntity> getWholeEntities(List<String> r1, int r2);

    List<EntityIdData> provideSampleEntities();
}
