package com.obric.capabilitykit.entity.search;

import android.os.Parcel;
import android.os.Parcelable;
import com.obric.capabilitykit.entity.EntityExtKt;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public final class EntityChangeMonitorRequest implements Parcelable {
    public static final CREATOR CREATOR = null;
    private final List<Integer> entityTypeList;

    public static final class CREATOR implements Parcelable.Creator<EntityChangeMonitorRequest> {
        private CREATOR() {
        }

        public /* synthetic */ CREATOR(h r1) {
            this();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public EntityChangeMonitorRequest createFromParcel(Parcel r2) {
            o.e(r2, "parcel");
            Object r1 = EntityExtKt.a().fromJson(r2.readString(), EntityChangeMonitorRequest.class);
            o.c(r1, "entityGson.fromJson(parc…nitorRequest::class.java)");
            return (EntityChangeMonitorRequest) ZeusTransformUtils.preCheckCast(r1, EntityChangeMonitorRequest.class, "com.obric.aiagent.plugin");
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ EntityChangeMonitorRequest createFromParcel(Parcel r1) {
            return createFromParcel(r1);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public EntityChangeMonitorRequest[] newArray(int r1) {
            return new EntityChangeMonitorRequest[r1];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ EntityChangeMonitorRequest[] newArray(int r1) {
            return newArray(r1);
        }
    }

    static {
        CREATOR = new CREATOR(null);
    }

    public EntityChangeMonitorRequest(List<Integer> r3) {
        List<Integer> r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
        o.e(r4, "entityTypeList");
        this.entityTypeList = r4;
    }

    public static /* synthetic */ EntityChangeMonitorRequest copy$default(EntityChangeMonitorRequest r1, List r2, int r3, Object r4) {
        List<Integer> r5 = (List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.aiagent.plugin");
        if ((r3 & 1) == 0) goto L6;
        r5 = r1.entityTypeList;
    L6:
        return r1.copy(r5);
    }

    public final List<Integer> component1() {
        return this.entityTypeList;
    }

    public final EntityChangeMonitorRequest copy(List<Integer> r2) {
        List r1 = (List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.aiagent.plugin");
        o.e(r1, "entityTypeList");
        return new EntityChangeMonitorRequest(r1);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, EntityChangeMonitorRequest.class) == true) goto L8;
        return false;
    L8:
        EntityChangeMonitorRequest r6 = (EntityChangeMonitorRequest) ZeusTransformUtils.preCheckCast(r5, EntityChangeMonitorRequest.class, "com.obric.aiagent.plugin");
        if (o.a(this.entityTypeList, r6.entityTypeList) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final List<Integer> getEntityTypeList() {
        return this.entityTypeList;
    }

    public int hashCode() {
        return this.entityTypeList.hashCode();
    }

    public String toString() {
        return "EntityChangeMonitorRequest(entityTypeList=" + this.entityTypeList + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r1, int r2) {
        o.e(r1, "parcel");
        r1.writeString(EntityExtKt.a().toJson(this));
    }
}
