package com.obric.capabilitykit;

import com.obric.capabilitykit.entity.app.AppEntity;
import com.obric.capabilitykit.sync.EntityIdData;
import com.obric.capabilitykit.sync.EntitySyncDataSupplier;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\r\u001a\u00020\u000eH\u0002J$\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\u00062\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\u000e\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\n0\u0006H\u0016R\u0016\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0015"}, d2 = {"Lcom/obric/capabilitykit/sync/DefaultEntitySyncDataSupplier;", "Lcom/obric/capabilitykit/sync/EntitySyncDataSupplier;", "entitySupplier", "Lcom/obric/capabilitykit/EntitySupplier;", "(Lcom/obric/capabilitykit/EntitySupplier;)V", "appEntityList", "", "Lcom/obric/capabilitykit/entity/app/AppEntity;", "appEntityMap", "", "Lcom/obric/capabilitykit/sync/EntityIdData;", "getEntitySupplier", "()Lcom/obric/capabilitykit/EntitySupplier;", "buildAppEntityMap", "", "getWholeEntities", "idList", "", "type", "", "provideSampleEntities", "capabilitykit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class y implements EntitySyncDataSupplier {
    private final EntitySupplier a;
    private Map<EntityIdData, ? extends AppEntity> b;
    private List<? extends AppEntity> c;

    public y(EntitySupplier r1) {
        this.a = r1;
    }

    private final void a() {
        List<? extends AppEntity> r0 = this.c;
        if (r0 == null) goto L8;
        LinkedHashMap r3 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(r0, 10)), 16));
        Iterator<T> r1 = r0.iterator();
    L6:
        if (r1.hasNext() == false) goto L9;
        Object r2 = r1.next();
        AppEntity r4 = (AppEntity) r2;
        r3.put(new EntityIdData(r4.getId(), r4.getType(), r4.getLastModifiedTime()), r2);
    L9:
        this.b = r3;
        this.c = null;
        return;
    L8:
        r3 = null;
        goto L9
    }

    public final EntitySupplier b() {
        return this.a;
    }

    @Override // com.obric.capabilitykit.sync.EntitySyncDataSupplier
    public List<AppEntity> getWholeEntities(List<String> r7, int r8) {
        Intrinsics.checkNotNullParameter(r7, "idList");
        ArrayList r0 = new ArrayList();
        if (this.c == null) goto L6;
        a();
    L6:
        if (this.b != null) goto L8;
        return r0;
    L8:
        Iterator<T> r9 = r7.iterator();
    L10:
        if (r9.hasNext() == false) goto L17;
        String r1 = (String) r9.next();
        Map<EntityIdData, ? extends AppEntity> r2 = this.b;
        if (r2 == null) goto L10;
        AppEntity r3 = r2.get(new EntityIdData(r1, r8, 0));
        if (r3 == null) goto L10;
        r0.add(r3);
        goto L10
    L17:
        return r0;
    }

    @Override // com.obric.capabilitykit.sync.EntitySyncDataSupplier
    public List<EntityIdData> provideSampleEntities() {
        EntitySupplier r0 = this.a;
        if (r0 == null) goto L5;
        List<AppEntity> r1 = r0.provideAllEntities();
    L6:
        this.c = r1;
        if (r1 == null) goto L13;
        ArrayList r7 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r1, 10));
        Iterator<T> r2 = r1.iterator();
    L10:
        if (r2.hasNext() == false) goto L15;
        AppEntity r3 = (AppEntity) r2.next();
        r7.add(new EntityIdData(r3.getId(), r3.getType(), r3.getLastModifiedTime()));
        goto L10
    L15:
        return r7;
    L13:
        return CollectionsKt.emptyList();
    L5:
        r1 = null;
        goto L6
    }
}
