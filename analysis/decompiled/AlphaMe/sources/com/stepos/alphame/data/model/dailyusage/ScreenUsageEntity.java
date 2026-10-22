package com.stepos.alphame.data.model.dailyusage;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.room.AbstractC0351g;
import com.stepos.alphame.appinfo.AppInfoDbHelper;
import com.stepos.alphame.awareness.AwarenessDataItem;
import com.stepos.alphame.common.utils.TimeUtilsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Parcelize
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013HÖ\u0003J\t\u0010\u0014\u001a\u00020\u000fHÖ\u0001J\b\u0010\u0015\u001a\u00020\u0003H\u0016J\u0019\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u000fHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u001b"}, d2 = {"Lcom/stepos/alphame/data/model/dailyusage/ScreenUsageEntity;", "Landroid/os/Parcelable;", AppInfoDbHelper.TAG_U_PACKAGE_NAME, "", "triggerTime", "", "(Ljava/lang/String;J)V", "getPackageName", "()Ljava/lang/String;", "getTriggerTime", "()J", "component1", "component2", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "data_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes.dex */
public final /* data */ class ScreenUsageEntity implements Parcelable {

    @NotNull
    public static final Parcelable.Creator<ScreenUsageEntity> CREATOR = new Creator();

    @NotNull
    private final String packageName;
    private final long triggerTime;

    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<ScreenUsageEntity> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final ScreenUsageEntity createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new ScreenUsageEntity(parcel.readString(), parcel.readLong());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final ScreenUsageEntity[] newArray(int i4) {
            return new ScreenUsageEntity[i4];
        }
    }

    public ScreenUsageEntity(@NotNull String packageName, long j4) {
        Intrinsics.checkNotNullParameter(packageName, "packageName");
        this.packageName = packageName;
        this.triggerTime = j4;
    }

    public static /* synthetic */ ScreenUsageEntity copy$default(ScreenUsageEntity screenUsageEntity, String str, long j4, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            str = screenUsageEntity.packageName;
        }
        if ((i4 & 2) != 0) {
            j4 = screenUsageEntity.triggerTime;
        }
        return screenUsageEntity.copy(str, j4);
    }

    @NotNull
    /* renamed from: component1, reason: from getter */
    public final String getPackageName() {
        return this.packageName;
    }

    /* renamed from: component2, reason: from getter */
    public final long getTriggerTime() {
        return this.triggerTime;
    }

    @NotNull
    public final ScreenUsageEntity copy(@NotNull String packageName, long triggerTime) {
        Intrinsics.checkNotNullParameter(packageName, "packageName");
        return new ScreenUsageEntity(packageName, triggerTime);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ScreenUsageEntity)) {
            return false;
        }
        ScreenUsageEntity screenUsageEntity = (ScreenUsageEntity) other;
        return Intrinsics.areEqual(this.packageName, screenUsageEntity.packageName) && this.triggerTime == screenUsageEntity.triggerTime;
    }

    @NotNull
    public final String getPackageName() {
        return this.packageName;
    }

    public final long getTriggerTime() {
        return this.triggerTime;
    }

    public int hashCode() {
        return Long.hashCode(this.triggerTime) + (this.packageName.hashCode() * 31);
    }

    @NotNull
    public String toString() {
        return AbstractC0351g.q(this.packageName, AwarenessDataItem.PERMISSION_SPLITTER, TimeUtilsKt.formatDateYear(this.triggerTime));
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.packageName);
        parcel.writeLong(this.triggerTime);
    }
}
