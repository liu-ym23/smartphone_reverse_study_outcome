package com.bytedanceos.appstore.buss.entity;

import android.os.Parcel;
import android.os.Parcelable;
import com.bytedanceos.common.model.AppInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@Parcelize
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005J\u000b\u0010\t\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\n\u001a\u0004\u0018\u00010\u0003HÆ\u0003J!\u0010\u000b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\t\u0010\f\u001a\u00020\rHÖ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\rHÖ\u0001J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001J\u0019\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\rHÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0019"}, d2 = {"Lcom/bytedanceos/appstore/buss/entity/TvAppInfoCategoryInfoEntity;", "Landroid/os/Parcelable;", "id", "", "name", "(Ljava/lang/String;Ljava/lang/String;)V", "getId", "()Ljava/lang/String;", "getName", "component1", "component2", "copy", "describeContents", "", "equals", "", AppInfo.SEARCH_SOURCE_EXTENAL, "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "app_sysapp_updateRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class TvAppInfoCategoryInfoEntity implements Parcelable {

    @NotNull
    public static final Parcelable.Creator<TvAppInfoCategoryInfoEntity> CREATOR = null;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    @Nullable
    private final String f8434id;

    @Nullable
    private final String name;

    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<TvAppInfoCategoryInfoEntity> {
        public Creator() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final TvAppInfoCategoryInfoEntity createFromParcel(@NotNull Parcel r10) {
            q.g(r10, "parcel");
            return new TvAppInfoCategoryInfoEntity(r10.readString(), r10.readString());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final TvAppInfoCategoryInfoEntity[] newArray(int r10) {
            return new TvAppInfoCategoryInfoEntity[r10];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ TvAppInfoCategoryInfoEntity createFromParcel(Parcel r10) {
            return createFromParcel(r10);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ TvAppInfoCategoryInfoEntity[] newArray(int r10) {
            return newArray(r10);
        }
    }

    static {
        CREATOR = new Creator();
    }

    public TvAppInfoCategoryInfoEntity(@Nullable String r10, @Nullable String r11) {
        this.f8434id = r10;
        this.name = r11;
    }

    public static /* synthetic */ TvAppInfoCategoryInfoEntity copy$default(TvAppInfoCategoryInfoEntity r10, String r11, String r12, int r13, Object r14) {
        if ((r13 & 1) == 0) goto L6;
        r11 = r10.f8434id;
    L6:
        if ((r13 & 2) == 0) goto L9;
        r12 = r10.name;
    L9:
        return r10.copy(r11, r12);
    }

    @Nullable
    public final String component1() {
        return this.f8434id;
    }

    @Nullable
    public final String component2() {
        return this.name;
    }

    @NotNull
    public final TvAppInfoCategoryInfoEntity copy(@Nullable String r10, @Nullable String r11) {
        return new TvAppInfoCategoryInfoEntity(r10, r11);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof TvAppInfoCategoryInfoEntity) == true) goto L8;
        return false;
    L8:
        TvAppInfoCategoryInfoEntity r11 = (TvAppInfoCategoryInfoEntity) r10;
        if (q.b(this.f8434id, r11.f8434id) == true) goto L12;
        return false;
    L12:
        if (q.b(this.name, r11.name) == true) goto L14;
        return false;
    L14:
        return true;
    }

    @Nullable
    public final String getId() {
        return this.f8434id;
    }

    @Nullable
    public final String getName() {
        return this.name;
    }

    public int hashCode() {
        String r10 = this.f8434id;
        int r11 = 0;
        if (r10 != null) goto L5;
        int r12 = 0;
    L6:
        int r13 = r12 * 31;
        String r14 = this.name;
        if (r14 == null) goto L11;
        r11 = r14.hashCode();
    L11:
        return r13 + r11;
    L5:
        r12 = r10.hashCode();
        goto L6
    }

    @NotNull
    public String toString() {
        return "TvAppInfoCategoryInfoEntity(id=" + this.f8434id + ", name=" + this.name + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel r10, int r11) {
        q.g(r10, "out");
        r10.writeString(this.f8434id);
        r10.writeString(this.name);
    }
}
