package com.obric.capabilitykit.entity.search.global;

import android.os.Parcel;
import android.os.Parcelable;
import com.bytedance.apm.constant.PerfConsts;
import com.obric.capabilitykit.entity.EntityExtKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\b\u0018\u0000 \u001f2\u00020\u0001:\u0001\u001fB%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003¢\u0006\u0002\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J-\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u0003HÆ\u0001J\b\u0010\u0012\u001a\u00020\u0003H\u0016J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\u0018\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u0003H\u0016R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\f¨\u0006 "}, d2 = {"Lcom/obric/capabilitykit/entity/search/global/GlobalSearchResult;", "Landroid/os/Parcelable;", "entityType", "", "entities", "", "Lcom/obric/capabilitykit/entity/search/global/GlobalSearchEntity;", "sequence", "(ILjava/util/List;I)V", "getEntities", "()Ljava/util/List;", "getEntityType", "()I", "getSequence", "component1", "component2", "component3", "copy", "describeContents", "equals", "", "other", "", "hashCode", "toString", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "CREATOR", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class GlobalSearchResult implements Parcelable {
    public static final a CREATOR = null;
    private final List<GlobalSearchEntity> entities;
    private final int entityType;
    private final int sequence;

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u001d\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016¢\u0006\u0002\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/obric/capabilitykit/entity/search/global/GlobalSearchResult$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/obric/capabilitykit/entity/search/global/GlobalSearchResult;", "()V", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", PerfConsts.PERF_DISK_FILE_SIZE, "", "(I)[Lcom/obric/capabilitykit/entity/search/global/GlobalSearchResult;", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class a implements Parcelable.Creator<GlobalSearchResult> {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }

        public GlobalSearchResult a(Parcel r2) {
            Intrinsics.checkNotNullParameter(r2, "parcel");
            Object r1 = EntityExtKt.getEntityGson().fromJson(r2.readString(), GlobalSearchResult.class);
            Intrinsics.checkNotNullExpressionValue(r1, "entityGson.fromJson(parc…SearchResult::class.java)");
            return (GlobalSearchResult) r1;
        }

        public GlobalSearchResult[] a(int r1) {
            return new GlobalSearchResult[r1];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ GlobalSearchResult createFromParcel(Parcel r1) {
            return a(r1);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ GlobalSearchResult[] newArray(int r1) {
            return a(r1);
        }
    }

    static {
        CREATOR = new a(null);
    }

    public GlobalSearchResult(int r2, List<GlobalSearchEntity> r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "entities");
        this.entityType = r2;
        this.entities = r3;
        this.sequence = r4;
    }

    public /* synthetic */ GlobalSearchResult(int r1, List r2, int r3, int r4, DefaultConstructorMarker r5) {
        if ((r4 & 4) == 0) goto L5;
        r3 = 0;
    L5:
        this(r1, r2, r3);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ GlobalSearchResult copy$default(GlobalSearchResult r0, int r1, List r2, int r3, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = r0.entityType;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r2 = r0.entities;
    L9:
        if ((r4 & 4) == 0) goto L12;
        r3 = r0.sequence;
    L12:
        return r0.copy(r1, r2, r3);
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

    public final GlobalSearchResult copy(int r1, List<GlobalSearchEntity> r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "entities");
        return new GlobalSearchResult(r1, r2, r3);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof GlobalSearchResult) == true) goto L8;
        return false;
    L8:
        GlobalSearchResult r6 = (GlobalSearchResult) r5;
        if (this.entityType == r6.entityType) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.entities, r6.entities) == true) goto L15;
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
        Intrinsics.checkNotNullParameter(r1, "parcel");
        r1.writeString(EntityExtKt.getEntityGson().toJson(this));
    }
}
