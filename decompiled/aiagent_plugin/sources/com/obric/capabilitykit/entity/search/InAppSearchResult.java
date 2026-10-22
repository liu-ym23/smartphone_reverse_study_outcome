package com.obric.capabilitykit.entity.search;

import android.os.Parcel;
import android.os.Parcelable;
import com.obric.capabilitykit.entity.EntityExtKt;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public final class InAppSearchResult implements Parcelable {
    public static final CREATOR CREATOR = null;
    private final List<InAppSearchEntity> entities;

    public static final class CREATOR implements Parcelable.Creator<InAppSearchResult> {
        private CREATOR() {
        }

        public /* synthetic */ CREATOR(h r1) {
            this();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public InAppSearchResult createFromParcel(Parcel r2) {
            o.e(r2, "parcel");
            Object r1 = EntityExtKt.a().fromJson(r2.readString(), InAppSearchResult.class);
            o.c(r1, "entityGson.fromJson(parc…SearchResult::class.java)");
            return (InAppSearchResult) ZeusTransformUtils.preCheckCast(r1, InAppSearchResult.class, "com.obric.aiagent.plugin");
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ InAppSearchResult createFromParcel(Parcel r1) {
            return createFromParcel(r1);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public InAppSearchResult[] newArray(int r1) {
            return new InAppSearchResult[r1];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ InAppSearchResult[] newArray(int r1) {
            return newArray(r1);
        }
    }

    static {
        CREATOR = new CREATOR(null);
    }

    public InAppSearchResult(List<InAppSearchEntity> r3) {
        List<InAppSearchEntity> r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
        o.e(r4, "entities");
        this.entities = r4;
    }

    public static /* synthetic */ InAppSearchResult copy$default(InAppSearchResult r1, List r2, int r3, Object r4) {
        List<InAppSearchEntity> r5 = (List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.aiagent.plugin");
        if ((r3 & 1) == 0) goto L6;
        r5 = r1.entities;
    L6:
        return r1.copy(r5);
    }

    public final List<InAppSearchEntity> component1() {
        return this.entities;
    }

    public final InAppSearchResult copy(List<InAppSearchEntity> r2) {
        List r1 = (List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.aiagent.plugin");
        o.e(r1, "entities");
        return new InAppSearchResult(r1);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, InAppSearchResult.class) == true) goto L8;
        return false;
    L8:
        InAppSearchResult r6 = (InAppSearchResult) ZeusTransformUtils.preCheckCast(r5, InAppSearchResult.class, "com.obric.aiagent.plugin");
        if (o.a(this.entities, r6.entities) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final List<InAppSearchEntity> getEntities() {
        return this.entities;
    }

    public int hashCode() {
        return this.entities.hashCode();
    }

    public String toString() {
        return "InAppSearchResult(entities=" + this.entities + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r1, int r2) {
        o.e(r1, "parcel");
        r1.writeString(EntityExtKt.a().toJson(this));
    }
}
