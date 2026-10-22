package com.obric.capabilitykit.entity;

import com.obric.capabilitykit.EntitySupplier;
import com.obric.capabilitykit.sync.EntitySyncDataSupplier;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;

/* JADX INFO: loaded from: classes4.dex */
public final class EntityInitParam {
    private final EntitySyncDataSupplier entitySyncDataSupplier;
    private final String runProcessName;
    private final EntitySupplier supplier;

    public EntityInitParam(EntitySupplier r3, String r4, EntitySyncDataSupplier r5) {
        EntitySupplier r6 = (EntitySupplier) ZeusTransformUtils.wrapperContextForParams(r3, EntitySupplier.class, "com.obric.aiagent.plugin");
        EntitySyncDataSupplier r7 = (EntitySyncDataSupplier) ZeusTransformUtils.wrapperContextForParams(r5, EntitySyncDataSupplier.class, "com.obric.aiagent.plugin");
        this.supplier = r6;
        this.runProcessName = r4;
        this.entitySyncDataSupplier = r7;
    }

    public /* synthetic */ EntityInitParam(EntitySupplier r2, String r3, EntitySyncDataSupplier r4, int r5, h r6) {
        EntitySupplier r7 = (EntitySupplier) ZeusTransformUtils.wrapperContextForParams(r2, EntitySupplier.class, "com.obric.aiagent.plugin");
        EntitySyncDataSupplier r8 = (EntitySyncDataSupplier) ZeusTransformUtils.wrapperContextForParams(r4, EntitySyncDataSupplier.class, "com.obric.aiagent.plugin");
        if ((r5 & 2) == 0) goto L6;
        r3 = null;
    L6:
        if ((r5 & 4) == 0) goto L8;
        r8 = null;
    L8:
        this(r7, r3, r8);
    }

    public static /* synthetic */ EntityInitParam copy$default(EntityInitParam r1, EntitySupplier r2, String r3, EntitySyncDataSupplier r4, int r5, Object r6) {
        EntitySupplier r7 = (EntitySupplier) ZeusTransformUtils.wrapperContextForParams(r2, EntitySupplier.class, "com.obric.aiagent.plugin");
        EntitySyncDataSupplier r8 = (EntitySyncDataSupplier) ZeusTransformUtils.wrapperContextForParams(r4, EntitySyncDataSupplier.class, "com.obric.aiagent.plugin");
        if ((r5 & 1) == 0) goto L6;
        r7 = r1.supplier;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r3 = r1.runProcessName;
    L9:
        if ((r5 & 4) == 0) goto L12;
        r8 = r1.entitySyncDataSupplier;
    L12:
        return r1.copy(r7, r3, r8);
    }

    public final EntitySupplier component1() {
        return this.supplier;
    }

    public final String component2() {
        return this.runProcessName;
    }

    public final EntitySyncDataSupplier component3() {
        return this.entitySyncDataSupplier;
    }

    public final EntityInitParam copy(EntitySupplier r2, String r3, EntitySyncDataSupplier r4) {
        return new EntityInitParam((EntitySupplier) ZeusTransformUtils.wrapperContextForParams(r2, EntitySupplier.class, "com.obric.aiagent.plugin"), r3, (EntitySyncDataSupplier) ZeusTransformUtils.wrapperContextForParams(r4, EntitySyncDataSupplier.class, "com.obric.aiagent.plugin"));
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, EntityInitParam.class) == true) goto L8;
        return false;
    L8:
        EntityInitParam r6 = (EntityInitParam) ZeusTransformUtils.preCheckCast(r5, EntityInitParam.class, "com.obric.aiagent.plugin");
        if (o.a(this.supplier, r6.supplier) == true) goto L12;
        return false;
    L12:
        if (o.a(this.runProcessName, r6.runProcessName) == true) goto L15;
        return false;
    L15:
        if (o.a(this.entitySyncDataSupplier, r6.entitySyncDataSupplier) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final EntitySyncDataSupplier getEntitySyncDataSupplier() {
        return this.entitySyncDataSupplier;
    }

    public final String getRunProcessName() {
        return this.runProcessName;
    }

    public final EntitySupplier getSupplier() {
        return this.supplier;
    }

    public int hashCode() {
        EntitySupplier r0 = this.supplier;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        String r4 = this.runProcessName;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        EntitySyncDataSupplier r7 = this.entitySyncDataSupplier;
        if (r7 == null) goto L15;
        r1 = r7.hashCode();
    L15:
        return r6 + r1;
    L9:
        r5 = r4.hashCode();
        goto L10
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public String toString() {
        return "EntityInitParam(supplier=" + this.supplier + ", runProcessName=" + this.runProcessName + ", entitySyncDataSupplier=" + this.entitySyncDataSupplier + ')';
    }
}
