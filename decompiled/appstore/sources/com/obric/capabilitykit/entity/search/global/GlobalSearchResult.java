package com.obric.capabilitykit.entity.search.global;

import android.os.Parcel;
import android.os.Parcelable;
import com.bytedanceos.common.model.AppInfo;
import com.obric.capabilitykit.entity.EntityExtKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\b\u0018\u0000 \u001f2\u00020\u0001:\u0001\u001fB%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003¢\u0006\u0002\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J-\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u0003HÆ\u0001J\b\u0010\u0012\u001a\u00020\u0003H\u0016J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\u0018\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u0003H\u0016R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\f¨\u0006 "}, d2 = {"Lcom/obric/capabilitykit/entity/search/global/GlobalSearchResult;", "Landroid/os/Parcelable;", "entityType", "", "entities", "", "Lcom/obric/capabilitykit/entity/search/global/GlobalSearchEntity;", "sequence", "(ILjava/util/List;I)V", "getEntities", "()Ljava/util/List;", "getEntityType", "()I", "getSequence", "component1", "component2", "component3", "copy", "describeContents", "equals", "", AppInfo.SEARCH_SOURCE_EXTENAL, "", "hashCode", "toString", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "CREATOR", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class GlobalSearchResult implements Parcelable {

    @NotNull
    public static final a CREATOR = null;

    @NotNull
    private final List<GlobalSearchEntity> entities;
    private final int entityType;
    private final int sequence;

    public static final class a implements Parcelable.Creator {
        public a() {
        }

        public GlobalSearchResult a(Parcel r10) {
            q.g(r10, "parcel");
            Object r11 = EntityExtKt.a().fromJson(r10.readString(), GlobalSearchResult.class);
            q.f(r11, "entityGson.fromJson(parc…SearchResult::class.java)");
            return (GlobalSearchResult) r11;
        }

        public GlobalSearchResult[] b(int r10) {
            return new GlobalSearchResult[r10];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ Object createFromParcel(Parcel r10) {
            return a(r10);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ Object[] newArray(int r10) {
            return b(r10);
        }

        public /* synthetic */ a(DefaultConstructorMarker r10) {
            this();
        }
    }

    static {
        CREATOR = new a(null);
    }

    public GlobalSearchResult(int r10, @NotNull List<GlobalSearchEntity> r11, int r12) {
        q.g(r11, "entities");
        this.entityType = r10;
        this.entities = r11;
        this.sequence = r12;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ GlobalSearchResult copy$default(GlobalSearchResult r10, int r11, List r12, int r13, int r14, Object r15) {
        if ((r14 & 1) == 0) goto L6;
        r11 = r10.entityType;
    L6:
        if ((r14 & 2) == 0) goto L9;
        r12 = r10.entities;
    L9:
        if ((r14 & 4) == 0) goto L12;
        r13 = r10.sequence;
    L12:
        return r10.copy(r11, r12, r13);
    }

    public final int component1() {
        return this.entityType;
    }

    @NotNull
    public final List<GlobalSearchEntity> component2() {
        return this.entities;
    }

    public final int component3() {
        return this.sequence;
    }

    @NotNull
    public final GlobalSearchResult copy(int r10, @NotNull List<GlobalSearchEntity> r11, int r12) {
        q.g(r11, "entities");
        return new GlobalSearchResult(r10, r11, r12);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof GlobalSearchResult) == true) goto L8;
        return false;
    L8:
        GlobalSearchResult r11 = (GlobalSearchResult) r10;
        if (this.entityType == r11.entityType) goto L12;
        return false;
    L12:
        if (q.b(this.entities, r11.entities) == true) goto L15;
        return false;
    L15:
        if (this.sequence == r11.sequence) goto L17;
        return false;
    L17:
        return true;
    }

    @NotNull
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

    @NotNull
    public String toString() {
        return "GlobalSearchResult(entityType=" + this.entityType + ", entities=" + this.entities + ", sequence=" + this.sequence + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel r10, int r11) {
        q.g(r10, "parcel");
        r10.writeString(EntityExtKt.a().toJson(this));
    }

    public /* synthetic */ GlobalSearchResult(int r10, List r11, int r12, int r13, DefaultConstructorMarker r14) {
        if ((r13 & 4) == 0) goto L5;
        r12 = 0;
    L5:
        this(r10, r11, r12);
    }
}
