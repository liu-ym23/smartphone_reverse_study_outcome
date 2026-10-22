package com.obric.memorydata.sdk.entity.global;

import android.os.Parcel;
import android.os.Parcelable;
import com.obric.capabilitykit.entity.memory.MemoryEntity;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.p;
import d.h.b.h;
import d.h.b.o;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: GlobalAssistantSearchResponse.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class GlobalAssistantSearchMemoryResult implements Parcelable {
    public static final CREATOR CREATOR = null;
    private final List<MemoryEntity> entityList;

    /* JADX INFO: compiled from: GlobalAssistantSearchResponse.kt */
    public static final class CREATOR implements Parcelable.Creator<GlobalAssistantSearchMemoryResult> {
        public /* synthetic */ CREATOR(h r1) {
            this();
        }

        private CREATOR() {
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ GlobalAssistantSearchMemoryResult createFromParcel(Parcel r1) {
            return createFromParcel(r1);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ GlobalAssistantSearchMemoryResult[] newArray(int r1) {
            return newArray(r1);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public GlobalAssistantSearchMemoryResult createFromParcel(Parcel r1) {
            o.e(r1, "parcel");
            return new GlobalAssistantSearchMemoryResult(r1);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public GlobalAssistantSearchMemoryResult[] newArray(int r1) {
            return new GlobalAssistantSearchMemoryResult[r1];
        }
    }

    static {
        CREATOR = new CREATOR(null);
    }

    public static /* synthetic */ GlobalAssistantSearchMemoryResult copy$default(GlobalAssistantSearchMemoryResult r1, List r2, int r3, Object r4) {
        List<MemoryEntity> r5 = (List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.aiagent.plugin");
        if ((r3 & 1) == 0) goto L6;
        r5 = r1.entityList;
    L6:
        return r1.copy(r5);
    }

    public final List<MemoryEntity> component1() {
        return this.entityList;
    }

    public final GlobalAssistantSearchMemoryResult copy(List<? extends MemoryEntity> r2) {
        List r1 = (List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.aiagent.plugin");
        o.e(r1, "entityList");
        return new GlobalAssistantSearchMemoryResult(r1);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, GlobalAssistantSearchMemoryResult.class) == true) goto L8;
        return false;
    L8:
        GlobalAssistantSearchMemoryResult r6 = (GlobalAssistantSearchMemoryResult) ZeusTransformUtils.preCheckCast(r5, GlobalAssistantSearchMemoryResult.class, "com.obric.aiagent.plugin");
        if (o.a(this.entityList, r6.entityList) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public int hashCode() {
        return this.entityList.hashCode();
    }

    public String toString() {
        return "GlobalAssistantSearchMemoryResult(entityList=" + this.entityList + ')';
    }

    public GlobalAssistantSearchMemoryResult(List<? extends MemoryEntity> r3) {
        List<MemoryEntity> r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
        o.e(r4, "entityList");
        this.entityList = r4;
    }

    public final List<MemoryEntity> getEntityList() {
        return this.entityList;
    }

    public GlobalAssistantSearchMemoryResult(Parcel r4) {
        o.e(r4, "parcel");
        ArrayList r5 = r4.createTypedArrayList((Parcelable.Creator) ZeusTransformUtils.preCheckCast(MemoryEntity.CREATOR, Parcelable.Creator.class, "com.obric.aiagent.plugin"));
        if (r5 == null) goto L5;
        List r6 = (List) ZeusTransformUtils.preCheckCast(r5, List.class, "com.obric.aiagent.plugin");
    L6:
        this(r6);
        return;
    L5:
        r6 = p.b();
        goto L6
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r1, int r2) {
        o.e(r1, "parcel");
        r1.writeTypedList(this.entityList);
    }
}
