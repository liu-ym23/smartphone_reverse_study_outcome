package com.bytedanceos.appstore.buss.entity;

import android.os.Parcel;
import android.os.Parcelable;
import com.bytedanceos.common.model.AppInfo;
import com.bytedanceos.common.toolbox.ServerElements;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@Parcelize
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B+\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0007J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J7\u0010\u0011\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001J\u0019\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u0013HÖ\u0001R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\u001f"}, d2 = {"Lcom/bytedanceos/appstore/buss/entity/TvAppInfoFromEntity;", "Landroid/os/Parcelable;", ServerElements.MARK, "", "name", ServerElements.LOGO, "url", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getLogo", "()Ljava/lang/String;", "getMark", "getName", "getUrl", "component1", "component2", "component3", "component4", "copy", "describeContents", "", "equals", "", AppInfo.SEARCH_SOURCE_EXTENAL, "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "app_sysapp_updateRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class TvAppInfoFromEntity implements Parcelable {

    @NotNull
    public static final Parcelable.Creator<TvAppInfoFromEntity> CREATOR = null;

    @NotNull
    private final String logo;

    @Nullable
    private final String mark;

    @Nullable
    private final String name;

    @Nullable
    private final String url;

    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<TvAppInfoFromEntity> {
        public Creator() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final TvAppInfoFromEntity createFromParcel(@NotNull Parcel r10) {
            q.g(r10, "parcel");
            return new TvAppInfoFromEntity(r10.readString(), r10.readString(), r10.readString(), r10.readString());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final TvAppInfoFromEntity[] newArray(int r10) {
            return new TvAppInfoFromEntity[r10];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ TvAppInfoFromEntity createFromParcel(Parcel r10) {
            return createFromParcel(r10);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ TvAppInfoFromEntity[] newArray(int r10) {
            return newArray(r10);
        }
    }

    static {
        CREATOR = new Creator();
    }

    public TvAppInfoFromEntity(@Nullable String r10, @Nullable String r11, @NotNull String r12, @Nullable String r13) {
        q.g(r12, ServerElements.LOGO);
        this.mark = r10;
        this.name = r11;
        this.logo = r12;
        this.url = r13;
    }

    public static /* synthetic */ TvAppInfoFromEntity copy$default(TvAppInfoFromEntity r10, String r11, String r12, String r13, String r14, int r15, Object r16) {
        if ((r15 & 1) == 0) goto L6;
        r11 = r10.mark;
    L6:
        if ((r15 & 2) == 0) goto L9;
        r12 = r10.name;
    L9:
        if ((r15 & 4) == 0) goto L12;
        r13 = r10.logo;
    L12:
        if ((r15 & 8) == 0) goto L15;
        r14 = r10.url;
    L15:
        return r10.copy(r11, r12, r13, r14);
    }

    @Nullable
    public final String component1() {
        return this.mark;
    }

    @Nullable
    public final String component2() {
        return this.name;
    }

    @NotNull
    public final String component3() {
        return this.logo;
    }

    @Nullable
    public final String component4() {
        return this.url;
    }

    @NotNull
    public final TvAppInfoFromEntity copy(@Nullable String r10, @Nullable String r11, @NotNull String r12, @Nullable String r13) {
        q.g(r12, ServerElements.LOGO);
        return new TvAppInfoFromEntity(r10, r11, r12, r13);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof TvAppInfoFromEntity) == true) goto L8;
        return false;
    L8:
        TvAppInfoFromEntity r11 = (TvAppInfoFromEntity) r10;
        if (q.b(this.mark, r11.mark) == true) goto L12;
        return false;
    L12:
        if (q.b(this.name, r11.name) == true) goto L15;
        return false;
    L15:
        if (q.b(this.logo, r11.logo) == true) goto L18;
        return false;
    L18:
        if (q.b(this.url, r11.url) == true) goto L20;
        return false;
    L20:
        return true;
    }

    @NotNull
    public final String getLogo() {
        return this.logo;
    }

    @Nullable
    public final String getMark() {
        return this.mark;
    }

    @Nullable
    public final String getName() {
        return this.name;
    }

    @Nullable
    public final String getUrl() {
        return this.url;
    }

    public int hashCode() {
        String r10 = this.mark;
        int r11 = 0;
        if (r10 != null) goto L5;
        int r12 = 0;
    L6:
        int r13 = r12 * 31;
        String r14 = this.name;
        if (r14 != null) goto L9;
        int r15 = 0;
    L10:
        int r16 = (((r13 + r15) * 31) + this.logo.hashCode()) * 31;
        String r17 = this.url;
        if (r17 == null) goto L15;
        r11 = r17.hashCode();
    L15:
        return r16 + r11;
    L9:
        r15 = r14.hashCode();
        goto L10
    L5:
        r12 = r10.hashCode();
        goto L6
    }

    @NotNull
    public String toString() {
        return "TvAppInfoFromEntity(mark=" + this.mark + ", name=" + this.name + ", logo=" + this.logo + ", url=" + this.url + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel r10, int r11) {
        q.g(r10, "out");
        r10.writeString(this.mark);
        r10.writeString(this.name);
        r10.writeString(this.logo);
        r10.writeString(this.url);
    }
}
