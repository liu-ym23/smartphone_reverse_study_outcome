package com.obric.capabilitykit;

import com.obric.capabilitykit.entity.app.AppEntity;
import com.obric.capabilitykit.sync.EntityIdData;
import com.obric.capabilitykit.sync.EntitySyncDataSupplier;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.ao;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public final class t implements EntitySyncDataSupplier {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final EntitySupplier f32243a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Map<EntityIdData, ? extends AppEntity> f32244b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private List<? extends AppEntity> f32245c;

    public t(EntitySupplier r3) {
        this.f32243a = (EntitySupplier) ZeusTransformUtils.wrapperContextForParams(r3, EntitySupplier.class, "com.obric.aiagent.plugin");
    }

    private final void a() {
        List<? extends AppEntity> r0 = this.f32245c;
        if (r0 == null) goto L8;
        LinkedHashMap r3 = new LinkedHashMap(d.l.n.c(ao.a(d.a.p.a(r0, 10)), 16));
        Iterator<T> r1 = r0.iterator();
    L6:
        if (r1.hasNext() == false) goto L9;
        Object r2 = r1.next();
        AppEntity r4 = (AppEntity) ZeusTransformUtils.preCheckCast(r2, AppEntity.class, "com.obric.aiagent.plugin");
        r3.put(new EntityIdData(r4.getId(), r4.getType(), r4.getLastModifiedTime()), r2);
    L9:
        this.f32244b = r3;
        this.f32245c = null;
        return;
    L8:
        r3 = null;
        goto L9
    }

    @Override // com.obric.capabilitykit.sync.EntitySyncDataSupplier
    public List<AppEntity> getWholeEntities(List<String> r8, int r9) {
        List r10 = (List) ZeusTransformUtils.wrapperContextForParams(r8, List.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r10, "idList");
        ArrayList r0 = new ArrayList();
        if (this.f32245c == null) goto L6;
        a();
    L6:
        if (this.f32244b != null) goto L8;
        return r0;
    L8:
        Iterator r11 = r10.iterator();
    L10:
        if (r11.hasNext() == false) goto L17;
        String r2 = (String) ZeusTransformUtils.preCheckCast(r11.next(), String.class, "com.obric.aiagent.plugin");
        Map<EntityIdData, ? extends AppEntity> r3 = this.f32244b;
        if (r3 == null) goto L10;
        AppEntity r4 = (AppEntity) ZeusTransformUtils.preCheckCast(r3.get(new EntityIdData(r2, r9, 0)), AppEntity.class, "com.obric.aiagent.plugin");
        if (r4 == null) goto L10;
        r0.add(r4);
        goto L10
    L17:
        return r0;
    }

    @Override // com.obric.capabilitykit.sync.EntitySyncDataSupplier
    public List<EntityIdData> provideSampleEntities() {
        EntitySupplier r0 = this.f32243a;
        if (r0 == null) goto L5;
        List<AppEntity> r1 = r0.provideAllEntities();
    L6:
        this.f32245c = r1;
        if (r1 == null) goto L13;
        ArrayList r7 = new ArrayList(d.a.p.a(r1, 10));
        Iterator<T> r2 = r1.iterator();
    L10:
        if (r2.hasNext() == false) goto L15;
        AppEntity r3 = (AppEntity) ZeusTransformUtils.preCheckCast(r2.next(), AppEntity.class, "com.obric.aiagent.plugin");
        r7.add(new EntityIdData(r3.getId(), r3.getType(), r3.getLastModifiedTime()));
        goto L10
    L15:
        return r7;
    L13:
        return d.a.p.b();
    L5:
        r1 = null;
        goto L6
    }
}
