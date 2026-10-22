package com.obric.capabilitykit.entity.search.global;

import android.os.Parcel;
import android.os.Parcelable;
import com.obric.capabilitykit.entity.EntityExtKt;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public final class GlobalSearchResult implements Parcelable {
    public static final a CREATOR = null;
    private final List<GlobalSearchEntity> entities;
    private final int entityType;
    private final int sequence;

    public static final class a implements Parcelable.Creator<GlobalSearchResult> {
        private a() {
        }

        public /* synthetic */ a(h r1) {
            this();
        }

        public GlobalSearchResult a(Parcel r2) {
            o.e(r2, "parcel");
            Object r1 = EntityExtKt.a().fromJson(r2.readString(), GlobalSearchResult.class);
            o.c(r1, "entityGson.fromJson(parc…SearchResult::class.java)");
            return (GlobalSearchResult) ZeusTransformUtils.preCheckCast(r1, GlobalSearchResult.class, "com.obric.aiagent.plugin");
        }

        public GlobalSearchResult[] a(int r1) {
            return new GlobalSearchResult[r1];
        }

        @Override // android.os.Parcelable.Creator
        public /* synthetic */ GlobalSearchResult createFromParcel(Parcel r1) {
            return a(r1);
        }

        @Override // android.os.Parcelable.Creator
        public /* synthetic */ GlobalSearchResult[] newArray(int r1) {
            return a(r1);
        }
    }

    static {
        CREATOR = new a(null);
    }

    public GlobalSearchResult(int r3, List<GlobalSearchEntity> r4, int r5) {
        List<GlobalSearchEntity> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.aiagent.plugin");
        o.e(r6, "entities");
        this.entityType = r3;
        this.entities = r6;
        this.sequence = r5;
    }

    public /* synthetic */ GlobalSearchResult(int r2, List r3, int r4, int r5, h r6) {
        List r7 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
        if ((r5 & 4) == 0) goto L5;
        r4 = 0;
    L5:
        this(r2, r7, r4);
    }

    public static /* synthetic */ GlobalSearchResult copy$default(GlobalSearchResult r1, int r2, List r3, int r4, int r5, Object r6) {
        List<GlobalSearchEntity> r7 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
        if ((r5 & 1) == 0) goto L6;
        r2 = r1.entityType;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r7 = r1.entities;
    L9:
        if ((r5 & 4) == 0) goto L12;
        r4 = r1.sequence;
    L12:
        return r1.copy(r2, r7, r4);
    }

    public final int component1() {
        return this.entityType;
    }

    public final List<GlobalSearchEntity> component2() {
        return this.entities;
    }

    public final int component3() {
        return this.sequence;
    }

    public final GlobalSearchResult copy(int r2, List<GlobalSearchEntity> r3, int r4) {
        List r1 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
        o.e(r1, "entities");
        return new GlobalSearchResult(r2, r1, r4);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, GlobalSearchResult.class) == true) goto L8;
        return false;
    L8:
        GlobalSearchResult r6 = (GlobalSearchResult) ZeusTransformUtils.preCheckCast(r5, GlobalSearchResult.class, "com.obric.aiagent.plugin");
        if (this.entityType == r6.entityType) goto L12;
        return false;
    L12:
        if (o.a(this.entities, r6.entities) == true) goto L15;
        return false;
    L15:
        if (this.sequence == r6.sequence) goto L17;
        return false;
    L17:
        return true;
    }

    public final List<GlobalSearchEntity> getEntities() {
        return this.entities;
    }

    public final int getEntityType() {
        return this.entityType;
    }

    public final int getSequence() {
        return this.sequence;
    }

    public int hashCode() {
        return (((Integer.hashCode(this.entityType) * 31) + this.entities.hashCode()) * 31) + Integer.hashCode(this.sequence);
    }

    public String toString() {
        return "GlobalSearchResult(entityType=" + this.entityType + ", entities=" + this.entities + ", sequence=" + this.sequence + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r1, int r2) {
        o.e(r1, "parcel");
        r1.writeString(EntityExtKt.a().toJson(this));
    }
}
