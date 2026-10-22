package com.obric.capabilitykit.entity;

import androidx.annotation.Keep;
import com.bytedanceos.common.model.AppInfo;
import com.obric.capabilitykit.EntitySupplier;
import com.obric.capabilitykit.sync.EntitySyncDataSupplier;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes3.dex */
@Keep
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B'\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0007HÆ\u0003J-\u0010\u0012\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0005HÖ\u0001R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0019"}, d2 = {"Lcom/obric/capabilitykit/entity/EntityInitParam;", "", "supplier", "Lcom/obric/capabilitykit/EntitySupplier;", "runProcessName", "", "entitySyncDataSupplier", "Lcom/obric/capabilitykit/sync/EntitySyncDataSupplier;", "(Lcom/obric/capabilitykit/EntitySupplier;Ljava/lang/String;Lcom/obric/capabilitykit/sync/EntitySyncDataSupplier;)V", "getEntitySyncDataSupplier", "()Lcom/obric/capabilitykit/sync/EntitySyncDataSupplier;", "getRunProcessName", "()Ljava/lang/String;", "getSupplier", "()Lcom/obric/capabilitykit/EntitySupplier;", "component1", "component2", "component3", "copy", "equals", "", AppInfo.SEARCH_SOURCE_EXTENAL, "hashCode", "", "toString", "capabilitykit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class EntityInitParam {

    @Nullable
    private final EntitySyncDataSupplier entitySyncDataSupplier;

    @Nullable
    private final String runProcessName;

    @Nullable
    private final EntitySupplier supplier;

    public EntityInitParam(@Nullable EntitySupplier r10, @Nullable String r11, @Nullable EntitySyncDataSupplier r12) {
        this.supplier = r10;
        this.runProcessName = r11;
        this.entitySyncDataSupplier = r12;
    }

    public static /* synthetic */ EntityInitParam copy$default(EntityInitParam r10, EntitySupplier r11, String r12, EntitySyncDataSupplier r13, int r14, Object r15) {
        if ((r14 & 1) == 0) goto L6;
        r11 = r10.supplier;
    L6:
        if ((r14 & 2) == 0) goto L9;
        r12 = r10.runProcessName;
    L9:
        if ((r14 & 4) == 0) goto L12;
        r13 = r10.entitySyncDataSupplier;
    L12:
        return r10.copy(r11, r12, r13);
    }

    @Nullable
    public final EntitySupplier component1() {
        return this.supplier;
    }

    @Nullable
    public final String component2() {
        return this.runProcessName;
    }

    @Nullable
    public final EntitySyncDataSupplier component3() {
        return this.entitySyncDataSupplier;
    }

    @NotNull
    public final EntityInitParam copy(@Nullable EntitySupplier r10, @Nullable String r11, @Nullable EntitySyncDataSupplier r12) {
        return new EntityInitParam(r10, r11, r12);
    }

    public boolean equals(@Nullable Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof EntityInitParam) == true) goto L8;
        return false;
    L8:
        EntityInitParam r11 = (EntityInitParam) r10;
        if (q.b(this.supplier, r11.supplier) == true) goto L12;
        return false;
    L12:
        if (q.b(this.runProcessName, r11.runProcessName) == true) goto L15;
        return false;
    L15:
        if (q.b(this.entitySyncDataSupplier, r11.entitySyncDataSupplier) == true) goto L17;
        return false;
    L17:
        return true;
    }

    @Nullable
    public final EntitySyncDataSupplier getEntitySyncDataSupplier() {
        return this.entitySyncDataSupplier;
    }

    @Nullable
    public final String getRunProcessName() {
        return this.runProcessName;
    }

    @Nullable
    public final EntitySupplier getSupplier() {
        return this.supplier;
    }

    public int hashCode() {
        EntitySupplier r10 = this.supplier;
        int r11 = 0;
        if (r10 != null) goto L5;
        int r12 = 0;
    L6:
        int r13 = r12 * 31;
        String r14 = this.runProcessName;
        if (r14 != null) goto L9;
        int r15 = 0;
    L10:
        int r16 = (r13 + r15) * 31;
        EntitySyncDataSupplier r17 = this.entitySyncDataSupplier;
        if (r17 == null) goto L15;
        r11 = r17.hashCode();
    L15:
        return r16 + r11;
    L9:
        r15 = r14.hashCode();
        goto L10
    L5:
        r12 = r10.hashCode();
        goto L6
    }

    @NotNull
    public String toString() {
        return "EntityInitParam(supplier=" + this.supplier + ", runProcessName=" + this.runProcessName + ", entitySyncDataSupplier=" + this.entitySyncDataSupplier + ')';
    }

    public /* synthetic */ EntityInitParam(EntitySupplier r10, String r11, EntitySyncDataSupplier r12, int r13, DefaultConstructorMarker r14) {
        if ((r13 & 2) == 0) goto L6;
        r11 = null;
    L6:
        if ((r13 & 4) == 0) goto L8;
        r12 = null;
    L8:
        this(r10, r11, r12);
    }
}
