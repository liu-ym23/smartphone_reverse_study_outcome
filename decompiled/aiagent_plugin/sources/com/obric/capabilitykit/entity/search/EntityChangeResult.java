package com.obric.capabilitykit.entity.search;

import android.os.Parcel;
import android.os.Parcelable;
import com.obric.capabilitykit.entity.EntityExtKt;
import com.obric.capabilitykit.entity.app.AppEntity;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public final class EntityChangeResult implements Parcelable {
    public static final CREATOR CREATOR = null;
    private final int changeType;
    private final List<AppEntity> entities;

    public static final class CREATOR implements Parcelable.Creator<EntityChangeResult> {
        private CREATOR() {
        }

        public /* synthetic */ CREATOR(h r1) {
            this();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public EntityChangeResult createFromParcel(Parcel r2) {
            o.e(r2, "parcel");
            Object r1 = EntityExtKt.a().fromJson(r2.readString(), EntityChangeResult.class);
            o.c(r1, "entityGson.fromJson(parc…ChangeResult::class.java)");
            return (EntityChangeResult) ZeusTransformUtils.preCheckCast(r1, EntityChangeResult.class, "com.obric.aiagent.plugin");
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ EntityChangeResult createFromParcel(Parcel r1) {
            return createFromParcel(r1);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public EntityChangeResult[] newArray(int r1) {
            return new EntityChangeResult[r1];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ EntityChangeResult[] newArray(int r1) {
            return newArray(r1);
        }
    }

    static {
        CREATOR = new CREATOR(null);
    }

    public EntityChangeResult(int r3, List<? extends AppEntity> r4) {
        List<AppEntity> r5 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.aiagent.plugin");
        o.e(r5, "entities");
        this.changeType = r3;
        this.entities = r5;
    }

    public static /* synthetic */ EntityChangeResult copy$default(EntityChangeResult r1, int r2, List r3, int r4, Object r5) {
        List<AppEntity> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
        if ((r4 & 1) == 0) goto L6;
        r2 = r1.changeType;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r6 = r1.entities;
    L9:
        return r1.copy(r2, r6);
    }

    public final int component1() {
        return this.changeType;
    }

    public final List<AppEntity> component2() {
        return this.entities;
    }

    public final EntityChangeResult copy(int r2, List<? extends AppEntity> r3) {
        List r1 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
        o.e(r1, "entities");
        return new EntityChangeResult(r2, r1);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, EntityChangeResult.class) == true) goto L8;
        return false;
    L8:
        EntityChangeResult r6 = (EntityChangeResult) ZeusTransformUtils.preCheckCast(r5, EntityChangeResult.class, "com.obric.aiagent.plugin");
        if (this.changeType == r6.changeType) goto L12;
        return false;
    L12:
        if (o.a(this.entities, r6.entities) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int getChangeType() {
        return this.changeType;
    }

    public final List<AppEntity> getEntities() {
        return this.entities;
    }

    public int hashCode() {
        return (Integer.hashCode(this.changeType) * 31) + this.entities.hashCode();
    }

    public String toString() {
        return "EntityChangeResult(changeType=" + this.changeType + ", entities=" + this.entities + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r1, int r2) {
        o.e(r1, "parcel");
        r1.writeString(EntityExtKt.a().toJson(this));
    }
}
