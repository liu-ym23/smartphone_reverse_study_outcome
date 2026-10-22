package com.stepos.alphame.data.model.dailyusage;

import B0.g;
import android.os.Parcel;
import android.os.Parcelable;
import com.stepos.alphame.common.utils.TimeUtilsKt;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Parcelize
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\u0002\u0010\nJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J\u000f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\t0\bHÆ\u0003J7\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bHÆ\u0001J\t\u0010\u0017\u001a\u00020\u0005HÖ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bHÖ\u0003J\t\u0010\u001c\u001a\u00020\u0005HÖ\u0001J\b\u0010\u001d\u001a\u00020\u001eH\u0016J\u0019\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u0005HÖ\u0001R\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010¨\u0006$"}, d2 = {"Lcom/stepos/alphame/data/model/dailyusage/HourlyUsageSummary;", "Landroid/os/Parcelable;", "hourlyUsageTime", "", "screenOnTimes", "", "notificationNumber", "appUsages", "", "Lcom/stepos/alphame/data/model/dailyusage/AppUsage;", "(JIILjava/util/List;)V", "getAppUsages", "()Ljava/util/List;", "getHourlyUsageTime", "()J", "getNotificationNumber", "()I", "getScreenOnTimes", "component1", "component2", "component3", "component4", "copy", "describeContents", "equals", "", "other", "", "hashCode", "toString", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "data_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes.dex */
public final /* data */ class HourlyUsageSummary implements Parcelable {

    @NotNull
    public static final Parcelable.Creator<HourlyUsageSummary> CREATOR = new Creator();

    @NotNull
    private final List<AppUsage> appUsages;
    private final long hourlyUsageTime;
    private final int notificationNumber;
    private final int screenOnTimes;

    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<HourlyUsageSummary> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final HourlyUsageSummary createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            long j4 = parcel.readLong();
            int i4 = parcel.readInt();
            int i5 = parcel.readInt();
            int i6 = parcel.readInt();
            ArrayList arrayList = new ArrayList(i6);
            for (int i7 = 0; i7 != i6; i7++) {
                arrayList.add(AppUsage.CREATOR.createFromParcel(parcel));
            }
            return new HourlyUsageSummary(j4, i4, i5, arrayList);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final HourlyUsageSummary[] newArray(int i4) {
            return new HourlyUsageSummary[i4];
        }
    }

    public HourlyUsageSummary(long j4, int i4, int i5, @NotNull List<AppUsage> appUsages) {
        Intrinsics.checkNotNullParameter(appUsages, "appUsages");
        this.hourlyUsageTime = j4;
        this.screenOnTimes = i4;
        this.notificationNumber = i5;
        this.appUsages = appUsages;
    }

    public static /* synthetic */ HourlyUsageSummary copy$default(HourlyUsageSummary hourlyUsageSummary, long j4, int i4, int i5, List list, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            j4 = hourlyUsageSummary.hourlyUsageTime;
        }
        long j5 = j4;
        if ((i6 & 2) != 0) {
            i4 = hourlyUsageSummary.screenOnTimes;
        }
        int i7 = i4;
        if ((i6 & 4) != 0) {
            i5 = hourlyUsageSummary.notificationNumber;
        }
        int i8 = i5;
        if ((i6 & 8) != 0) {
            list = hourlyUsageSummary.appUsages;
        }
        return hourlyUsageSummary.copy(j5, i7, i8, list);
    }

    /* renamed from: component1, reason: from getter */
    public final long getHourlyUsageTime() {
        return this.hourlyUsageTime;
    }

    /* renamed from: component2, reason: from getter */
    public final int getScreenOnTimes() {
        return this.screenOnTimes;
    }

    /* renamed from: component3, reason: from getter */
    public final int getNotificationNumber() {
        return this.notificationNumber;
    }

    @NotNull
    public final List<AppUsage> component4() {
        return this.appUsages;
    }

    @NotNull
    public final HourlyUsageSummary copy(long hourlyUsageTime, int screenOnTimes, int notificationNumber, @NotNull List<AppUsage> appUsages) {
        Intrinsics.checkNotNullParameter(appUsages, "appUsages");
        return new HourlyUsageSummary(hourlyUsageTime, screenOnTimes, notificationNumber, appUsages);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof HourlyUsageSummary)) {
            return false;
        }
        HourlyUsageSummary hourlyUsageSummary = (HourlyUsageSummary) other;
        return this.hourlyUsageTime == hourlyUsageSummary.hourlyUsageTime && this.screenOnTimes == hourlyUsageSummary.screenOnTimes && this.notificationNumber == hourlyUsageSummary.notificationNumber && Intrinsics.areEqual(this.appUsages, hourlyUsageSummary.appUsages);
    }

    @NotNull
    public final List<AppUsage> getAppUsages() {
        return this.appUsages;
    }

    public final long getHourlyUsageTime() {
        return this.hourlyUsageTime;
    }

    public final int getNotificationNumber() {
        return this.notificationNumber;
    }

    public final int getScreenOnTimes() {
        return this.screenOnTimes;
    }

    public int hashCode() {
        return this.appUsages.hashCode() + g.d(this.notificationNumber, g.d(this.screenOnTimes, Long.hashCode(this.hourlyUsageTime) * 31, 31), 31);
    }

    @NotNull
    public String toString() {
        return "hourly usage time " + TimeUtilsKt.formatDuration(this.hourlyUsageTime) + " screenTime " + this.screenOnTimes + " notificationNum " + this.notificationNumber + " app usage " + this.appUsages;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeLong(this.hourlyUsageTime);
        parcel.writeInt(this.screenOnTimes);
        parcel.writeInt(this.notificationNumber);
        List<AppUsage> list = this.appUsages;
        parcel.writeInt(list.size());
        Iterator<AppUsage> it = list.iterator();
        while (it.hasNext()) {
            it.next().writeToParcel(parcel, flags);
        }
    }
}
