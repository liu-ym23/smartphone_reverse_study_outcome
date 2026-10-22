package com.obric.memorydata.sdk.entity.global;

import android.os.Parcel;
import android.os.Parcelable;
import com.obric.capabilitykit.entity.app.AppEntity;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.p;
import d.h.b.h;
import d.h.b.o;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: GlobalAssistantSearchResponse.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class GlobalAssistantSearchEntityResult implements Parcelable {
    public static final CREATOR CREATOR = null;
    private final List<AppEntity> entityList;
    private final int recallTotalCount;

    /* JADX INFO: compiled from: GlobalAssistantSearchResponse.kt */
    public static final class CREATOR implements Parcelable.Creator<GlobalAssistantSearchEntityResult> {
        public /* synthetic */ CREATOR(h r1) {
            this();
        }

        private CREATOR() {
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ GlobalAssistantSearchEntityResult createFromParcel(Parcel r1) {
            return createFromParcel(r1);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ GlobalAssistantSearchEntityResult[] newArray(int r1) {
            return newArray(r1);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public GlobalAssistantSearchEntityResult createFromParcel(Parcel r1) {
            o.e(r1, "parcel");
            return new GlobalAssistantSearchEntityResult(r1);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public GlobalAssistantSearchEntityResult[] newArray(int r1) {
            return new GlobalAssistantSearchEntityResult[r1];
        }
    }

    static {
        CREATOR = new CREATOR(null);
    }

    public static /* synthetic */ GlobalAssistantSearchEntityResult copy$default(GlobalAssistantSearchEntityResult r1, List r2, int r3, int r4, Object r5) {
        List<AppEntity> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.aiagent.plugin");
        if ((r4 & 1) == 0) goto L6;
        r6 = r1.entityList;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r3 = r1.recallTotalCount;
    L9:
        return r1.copy(r6, r3);
    }

    public final List<AppEntity> component1() {
        return this.entityList;
    }

    public final int component2() {
        return this.recallTotalCount;
    }

    public final GlobalAssistantSearchEntityResult copy(List<? extends AppEntity> r2, int r3) {
        List r1 = (List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.aiagent.plugin");
        o.e(r1, "entityList");
        return new GlobalAssistantSearchEntityResult(r1, r3);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, GlobalAssistantSearchEntityResult.class) == true) goto L8;
        return false;
    L8:
        GlobalAssistantSearchEntityResult r6 = (GlobalAssistantSearchEntityResult) ZeusTransformUtils.preCheckCast(r5, GlobalAssistantSearchEntityResult.class, "com.obric.aiagent.plugin");
        if (o.a(this.entityList, r6.entityList) == true) goto L12;
        return false;
    L12:
        if (this.recallTotalCount == r6.recallTotalCount) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        return (this.entityList.hashCode() * 31) + Integer.hashCode(this.recallTotalCount);
    }

    public String toString() {
        return "GlobalAssistantSearchEntityResult(entityList=" + this.entityList + ", recallTotalCount=" + this.recallTotalCount + ')';
    }

    public GlobalAssistantSearchEntityResult(List<? extends AppEntity> r3, int r4) {
        List<AppEntity> r5 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
        o.e(r5, "entityList");
        this.entityList = r5;
        this.recallTotalCount = r4;
    }

    public final List<AppEntity> getEntityList() {
        return this.entityList;
    }

    public /* synthetic */ GlobalAssistantSearchEntityResult(List r2, int r3, int r4, h r5) {
        List r6 = (List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.aiagent.plugin");
        if ((r4 & 2) == 0) goto L5;
        r3 = r6.size();
    L5:
        this(r6, r3);
    }

    public final int getRecallTotalCount() {
        return this.recallTotalCount;
    }

    public GlobalAssistantSearchEntityResult(Parcel r4) {
        o.e(r4, "parcel");
        ArrayList r0 = r4.createTypedArrayList((Parcelable.Creator) ZeusTransformUtils.preCheckCast(AppEntity.CREATOR, Parcelable.Creator.class, "com.obric.aiagent.plugin"));
        if (r0 == null) goto L5;
        List r1 = (List) ZeusTransformUtils.preCheckCast(r0, List.class, "com.obric.aiagent.plugin");
    L6:
        this(r1, r4.readInt());
        return;
    L5:
        r1 = p.b();
        goto L6
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r1, int r2) {
        o.e(r1, "parcel");
        r1.writeTypedList(this.entityList);
        r1.writeInt(this.recallTotalCount);
    }
}
