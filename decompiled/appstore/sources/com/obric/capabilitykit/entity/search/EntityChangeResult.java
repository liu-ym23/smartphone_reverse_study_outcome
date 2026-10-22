package com.obric.capabilitykit.entity.search;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Keep;
import com.bytedanceos.common.model.AppInfo;
import com.obric.capabilitykit.entity.EntityExtKt;
import com.obric.capabilitykit.entity.app.AppEntity;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes3.dex */
@Keep
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0087\b\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cB\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J#\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0001J\b\u0010\u000f\u001a\u00020\u0003H\u0016J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\u0018\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u0003H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u001d"}, d2 = {"Lcom/obric/capabilitykit/entity/search/EntityChangeResult;", "Landroid/os/Parcelable;", "changeType", "", "entities", "", "Lcom/obric/capabilitykit/entity/app/AppEntity;", "(ILjava/util/List;)V", "getChangeType", "()I", "getEntities", "()Ljava/util/List;", "component1", "component2", "copy", "describeContents", "equals", "", AppInfo.SEARCH_SOURCE_EXTENAL, "", "hashCode", "toString", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "CREATOR", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class EntityChangeResult implements Parcelable {

    @NotNull
    public static final CREATOR CREATOR = null;
    private final int changeType;

    @NotNull
    private final List<AppEntity> entities;

    @Keep
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u001d\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016¢\u0006\u0002\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/obric/capabilitykit/entity/search/EntityChangeResult$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/obric/capabilitykit/entity/search/EntityChangeResult;", "()V", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/obric/capabilitykit/entity/search/EntityChangeResult;", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class CREATOR implements Parcelable.Creator<EntityChangeResult> {
        private CREATOR() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public EntityChangeResult createFromParcel(@NotNull Parcel r10) {
            q.g(r10, "parcel");
            Object r11 = EntityExtKt.a().fromJson(r10.readString(), EntityChangeResult.class);
            q.f(r11, "entityGson.fromJson(parc…ChangeResult::class.java)");
            return (EntityChangeResult) r11;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public EntityChangeResult[] newArray(int r10) {
            return new EntityChangeResult[r10];
        }

        public /* synthetic */ CREATOR(DefaultConstructorMarker r10) {
            this();
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ EntityChangeResult createFromParcel(Parcel r10) {
            return createFromParcel(r10);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ EntityChangeResult[] newArray(int r10) {
            return newArray(r10);
        }
    }

    static {
        CREATOR = new CREATOR(null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public EntityChangeResult(int r10, @NotNull List<? extends AppEntity> r11) {
        q.g(r11, "entities");
        this.changeType = r10;
        this.entities = r11;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ EntityChangeResult copy$default(EntityChangeResult r10, int r11, List r12, int r13, Object r14) {
        if ((r13 & 1) == 0) goto L6;
        r11 = r10.changeType;
    L6:
        if ((r13 & 2) == 0) goto L9;
        r12 = r10.entities;
    L9:
        return r10.copy(r11, r12);
    }

    public final int component1() {
        return this.changeType;
    }

    @NotNull
    public final List<AppEntity> component2() {
        return this.entities;
    }

    @NotNull
    public final EntityChangeResult copy(int r10, @NotNull List<? extends AppEntity> r11) {
        q.g(r11, "entities");
        return new EntityChangeResult(r10, r11);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof EntityChangeResult) == true) goto L8;
        return false;
    L8:
        EntityChangeResult r11 = (EntityChangeResult) r10;
        if (this.changeType == r11.changeType) goto L12;
        return false;
    L12:
        if (q.b(this.entities, r11.entities) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int getChangeType() {
        return this.changeType;
    }

    @NotNull
    public final List<AppEntity> getEntities() {
        return this.entities;
    }

    public int hashCode() {
        return (Integer.hashCode(this.changeType) * 31) + this.entities.hashCode();
    }

    @NotNull
    public String toString() {
        return "EntityChangeResult(changeType=" + this.changeType + ", entities=" + this.entities + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel r10, int r11) {
        q.g(r10, "parcel");
        r10.writeString(EntityExtKt.a().toJson(this));
    }
}
