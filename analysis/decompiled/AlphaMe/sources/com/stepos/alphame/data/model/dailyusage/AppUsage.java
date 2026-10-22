package com.stepos.alphame.data.model.dailyusage;

import B0.g;
import android.os.Parcel;
import android.os.Parcelable;
import com.stepos.alphame.appinfo.AppInfoDbHelper;
import com.stepos.alphame.common.utils.TimeUtilsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Parcelize
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0007HÆ\u0003J'\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\t\u0010\u0013\u001a\u00020\u0005HÖ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0005HÖ\u0001J\b\u0010\u0019\u001a\u00020\u0003H\u0016J\u0019\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u001f"}, d2 = {"Lcom/stepos/alphame/data/model/dailyusage/AppUsage;", "Landroid/os/Parcelable;", AppInfoDbHelper.TAG_U_PACKAGE_NAME, "", "notificationNumber", "", "usedTime", "", "(Ljava/lang/String;IJ)V", "getNotificationNumber", "()I", "getPackageName", "()Ljava/lang/String;", "getUsedTime", "()J", "component1", "component2", "component3", "copy", "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "data_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes.dex */
public final /* data */ class AppUsage implements Parcelable {

    @NotNull
    public static final Parcelable.Creator<AppUsage> CREATOR = new Creator();
    private final int notificationNumber;

    @NotNull
    private final String packageName;
    private final long usedTime;

    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<AppUsage> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final AppUsage createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new AppUsage(parcel.readString(), parcel.readInt(), parcel.readLong());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final AppUsage[] newArray(int i4) {
            return new AppUsage[i4];
        }
    }

    public AppUsage(@NotNull String packageName, int i4, long j4) {
        Intrinsics.checkNotNullParameter(packageName, "packageName");
        this.packageName = packageName;
        this.notificationNumber = i4;
        this.usedTime = j4;
    }

    public static /* synthetic */ AppUsage copy$default(AppUsage appUsage, String str, int i4, long j4, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            str = appUsage.packageName;
        }
        if ((i5 & 2) != 0) {
            i4 = appUsage.notificationNumber;
        }
        if ((i5 & 4) != 0) {
            j4 = appUsage.usedTime;
        }
        return appUsage.copy(str, i4, j4);
    }

    @NotNull
    /* renamed from: component1, reason: from getter */
    public final String getPackageName() {
        return this.packageName;
    }

    /* renamed from: component2, reason: from getter */
    public final int getNotificationNumber() {
        return this.notificationNumber;
    }

    /* renamed from: component3, reason: from getter */
    public final long getUsedTime() {
        return this.usedTime;
    }

    @NotNull
    public final AppUsage copy(@NotNull String packageName, int notificationNumber, long usedTime) {
        Intrinsics.checkNotNullParameter(packageName, "packageName");
        return new AppUsage(packageName, notificationNumber, usedTime);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AppUsage)) {
            return false;
        }
        AppUsage appUsage = (AppUsage) other;
        return Intrinsics.areEqual(this.packageName, appUsage.packageName) && this.notificationNumber == appUsage.notificationNumber && this.usedTime == appUsage.usedTime;
    }

    public final int getNotificationNumber() {
        return this.notificationNumber;
    }

    @NotNull
    public final String getPackageName() {
        return this.packageName;
    }

    public final long getUsedTime() {
        return this.usedTime;
    }

    public int hashCode() {
        return Long.hashCode(this.usedTime) + g.d(this.notificationNumber, this.packageName.hashCode() * 31, 31);
    }

    @NotNull
    public String toString() {
        return this.packageName + " notificationNumber " + this.notificationNumber + " usage time " + TimeUtilsKt.formatDuration(this.usedTime);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.packageName);
        parcel.writeInt(this.notificationNumber);
        parcel.writeLong(this.usedTime);
    }
}
