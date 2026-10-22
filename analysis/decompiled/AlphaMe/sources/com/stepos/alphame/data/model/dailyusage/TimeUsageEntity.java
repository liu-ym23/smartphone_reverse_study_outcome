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
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0016\u001a\u00020\bHÆ\u0003J1\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\t\u0010\u0018\u001a\u00020\bHÖ\u0001J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cHÖ\u0003J\t\u0010\u001d\u001a\u00020\bHÖ\u0001J\b\u0010\u001e\u001a\u00020\u0003H\u0016J\u0019\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\bHÖ\u0001R\u001a\u0010\u0006\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000bR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006$"}, d2 = {"Lcom/stepos/alphame/data/model/dailyusage/TimeUsageEntity;", "Landroid/os/Parcelable;", AppInfoDbHelper.TAG_U_PACKAGE_NAME, "", "startTime", "", "endTime", "type", "", "(Ljava/lang/String;JJI)V", "getEndTime", "()J", "setEndTime", "(J)V", "getPackageName", "()Ljava/lang/String;", "getStartTime", "getType", "()I", "component1", "component2", "component3", "component4", "copy", "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "data_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes.dex */
public final /* data */ class TimeUsageEntity implements Parcelable {

    @NotNull
    public static final Parcelable.Creator<TimeUsageEntity> CREATOR = new Creator();
    private long endTime;

    @NotNull
    private final String packageName;
    private final long startTime;
    private final int type;

    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<TimeUsageEntity> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final TimeUsageEntity createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new TimeUsageEntity(parcel.readString(), parcel.readLong(), parcel.readLong(), parcel.readInt());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final TimeUsageEntity[] newArray(int i4) {
            return new TimeUsageEntity[i4];
        }
    }

    public TimeUsageEntity(@NotNull String packageName, long j4, long j5, int i4) {
        Intrinsics.checkNotNullParameter(packageName, "packageName");
        this.packageName = packageName;
        this.startTime = j4;
        this.endTime = j5;
        this.type = i4;
    }

    public static /* synthetic */ TimeUsageEntity copy$default(TimeUsageEntity timeUsageEntity, String str, long j4, long j5, int i4, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            str = timeUsageEntity.packageName;
        }
        if ((i5 & 2) != 0) {
            j4 = timeUsageEntity.startTime;
        }
        long j6 = j4;
        if ((i5 & 4) != 0) {
            j5 = timeUsageEntity.endTime;
        }
        long j7 = j5;
        if ((i5 & 8) != 0) {
            i4 = timeUsageEntity.type;
        }
        return timeUsageEntity.copy(str, j6, j7, i4);
    }

    @NotNull
    /* renamed from: component1, reason: from getter */
    public final String getPackageName() {
        return this.packageName;
    }

    /* renamed from: component2, reason: from getter */
    public final long getStartTime() {
        return this.startTime;
    }

    /* renamed from: component3, reason: from getter */
    public final long getEndTime() {
        return this.endTime;
    }

    /* renamed from: component4, reason: from getter */
    public final int getType() {
        return this.type;
    }

    @NotNull
    public final TimeUsageEntity copy(@NotNull String packageName, long startTime, long endTime, int type) {
        Intrinsics.checkNotNullParameter(packageName, "packageName");
        return new TimeUsageEntity(packageName, startTime, endTime, type);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TimeUsageEntity)) {
            return false;
        }
        TimeUsageEntity timeUsageEntity = (TimeUsageEntity) other;
        return Intrinsics.areEqual(this.packageName, timeUsageEntity.packageName) && this.startTime == timeUsageEntity.startTime && this.endTime == timeUsageEntity.endTime && this.type == timeUsageEntity.type;
    }

    public final long getEndTime() {
        return this.endTime;
    }

    @NotNull
    public final String getPackageName() {
        return this.packageName;
    }

    public final long getStartTime() {
        return this.startTime;
    }

    public final int getType() {
        return this.type;
    }

    public int hashCode() {
        return Integer.hashCode(this.type) + g.f(this.endTime, g.f(this.startTime, this.packageName.hashCode() * 31, 31), 31);
    }

    public final void setEndTime(long j4) {
        this.endTime = j4;
    }

    @NotNull
    public String toString() {
        String str = this.packageName;
        String duration = TimeUtilsKt.formatDuration(this.endTime - this.startTime);
        String dateYear = TimeUtilsKt.formatDateYear(this.endTime);
        String dateYear2 = TimeUtilsKt.formatDateYear(this.startTime);
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(" use time ");
        sb.append(duration);
        sb.append(", end time ");
        sb.append(dateYear);
        return g.r(sb, " start time ", dateYear2);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.packageName);
        parcel.writeLong(this.startTime);
        parcel.writeLong(this.endTime);
        parcel.writeInt(this.type);
    }
}
