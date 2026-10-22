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
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0016\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001BY\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0005\u0012\u0006\u0010\n\u001a\u00020\u0005\u0012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f\u0012\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\f¢\u0006\u0002\u0010\u0010J\t\u0010#\u001a\u00020\u0003HÆ\u0003J\t\u0010$\u001a\u00020\u0005HÆ\u0003J\t\u0010%\u001a\u00020\u0003HÆ\u0003J\t\u0010&\u001a\u00020\u0003HÆ\u0003J\t\u0010'\u001a\u00020\u0003HÆ\u0003J\t\u0010(\u001a\u00020\u0005HÆ\u0003J\t\u0010)\u001a\u00020\u0005HÆ\u0003J\u000f\u0010*\u001a\b\u0012\u0004\u0012\u00020\r0\fHÆ\u0003J\u000f\u0010+\u001a\b\u0012\u0004\u0012\u00020\u000f0\fHÆ\u0003Jo\u0010,\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00052\b\b\u0002\u0010\n\u001a\u00020\u00052\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f2\u000e\b\u0002\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\fHÆ\u0001J\t\u0010-\u001a\u00020\u0005HÖ\u0001J\u0013\u0010.\u001a\u00020/2\b\u00100\u001a\u0004\u0018\u000101HÖ\u0003J\t\u00102\u001a\u00020\u0005HÖ\u0001J\b\u00103\u001a\u00020\u0018H\u0016J\u0019\u00104\u001a\u0002052\u0006\u00106\u001a\u0002072\u0006\u00108\u001a\u00020\u0005HÖ\u0001R\u0017\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0014R\u0017\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\f¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0012R\u0017\u0010\u0017\u001a\u00020\u0018¢\u0006\u000e\n\u0000\u0012\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0014R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0011\u0010\t\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u001fR\u0011\u0010\n\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u001fR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0014¨\u00069"}, d2 = {"Lcom/stepos/alphame/data/model/dailyusage/DailyUsageSummary;", "Landroid/os/Parcelable;", "date", "", "mode", "", "useId", "dailyUsedTime", "maximumUsageTime", "notificationNumbers", "screenOnTimes", "appDailyUsages", "", "Lcom/stepos/alphame/data/model/dailyusage/AppUsage;", "hourlyUsageSummaries", "Lcom/stepos/alphame/data/model/dailyusage/HourlyUsageSummary;", "(JIJJJIILjava/util/List;Ljava/util/List;)V", "getAppDailyUsages", "()Ljava/util/List;", "getDailyUsedTime", "()J", "getDate", "getHourlyUsageSummaries", "id", "", "getId$annotations", "()V", "getId", "()Ljava/lang/String;", "getMaximumUsageTime", "getMode", "()I", "getNotificationNumbers", "getScreenOnTimes", "getUseId", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "data_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes.dex */
public final /* data */ class DailyUsageSummary implements Parcelable {

    @NotNull
    public static final Parcelable.Creator<DailyUsageSummary> CREATOR = new Creator();

    @NotNull
    private final List<AppUsage> appDailyUsages;
    private final long dailyUsedTime;
    private final long date;

    @NotNull
    private final List<HourlyUsageSummary> hourlyUsageSummaries;

    @NotNull
    private final String id;
    private final long maximumUsageTime;
    private final int mode;
    private final int notificationNumbers;
    private final int screenOnTimes;
    private final long useId;

    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<DailyUsageSummary> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final DailyUsageSummary createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            long j4 = parcel.readLong();
            int i4 = parcel.readInt();
            long j5 = parcel.readLong();
            long j6 = parcel.readLong();
            long j7 = parcel.readLong();
            int i5 = parcel.readInt();
            int i6 = parcel.readInt();
            int i7 = parcel.readInt();
            ArrayList arrayList = new ArrayList(i7);
            for (int i8 = 0; i8 != i7; i8++) {
                arrayList.add(AppUsage.CREATOR.createFromParcel(parcel));
            }
            int i9 = parcel.readInt();
            ArrayList arrayList2 = new ArrayList(i9);
            int i10 = 0;
            while (i10 != i9) {
                arrayList2.add(HourlyUsageSummary.CREATOR.createFromParcel(parcel));
                i10++;
                i9 = i9;
            }
            return new DailyUsageSummary(j4, i4, j5, j6, j7, i5, i6, arrayList, arrayList2);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final DailyUsageSummary[] newArray(int i4) {
            return new DailyUsageSummary[i4];
        }
    }

    public DailyUsageSummary(long j4, int i4, long j5, long j6, long j7, int i5, int i6, @NotNull List<AppUsage> appDailyUsages, @NotNull List<HourlyUsageSummary> hourlyUsageSummaries) {
        Intrinsics.checkNotNullParameter(appDailyUsages, "appDailyUsages");
        Intrinsics.checkNotNullParameter(hourlyUsageSummaries, "hourlyUsageSummaries");
        this.date = j4;
        this.mode = i4;
        this.useId = j5;
        this.dailyUsedTime = j6;
        this.maximumUsageTime = j7;
        this.notificationNumbers = i5;
        this.screenOnTimes = i6;
        this.appDailyUsages = appDailyUsages;
        this.hourlyUsageSummaries = hourlyUsageSummaries;
        this.id = DailyUsageEntityKt.generateDailyUsageId(j4, i4, j5);
    }

    public static /* synthetic */ void getId$annotations() {
    }

    /* renamed from: component1, reason: from getter */
    public final long getDate() {
        return this.date;
    }

    /* renamed from: component2, reason: from getter */
    public final int getMode() {
        return this.mode;
    }

    /* renamed from: component3, reason: from getter */
    public final long getUseId() {
        return this.useId;
    }

    /* renamed from: component4, reason: from getter */
    public final long getDailyUsedTime() {
        return this.dailyUsedTime;
    }

    /* renamed from: component5, reason: from getter */
    public final long getMaximumUsageTime() {
        return this.maximumUsageTime;
    }

    /* renamed from: component6, reason: from getter */
    public final int getNotificationNumbers() {
        return this.notificationNumbers;
    }

    /* renamed from: component7, reason: from getter */
    public final int getScreenOnTimes() {
        return this.screenOnTimes;
    }

    @NotNull
    public final List<AppUsage> component8() {
        return this.appDailyUsages;
    }

    @NotNull
    public final List<HourlyUsageSummary> component9() {
        return this.hourlyUsageSummaries;
    }

    @NotNull
    public final DailyUsageSummary copy(long date, int mode, long useId, long dailyUsedTime, long maximumUsageTime, int notificationNumbers, int screenOnTimes, @NotNull List<AppUsage> appDailyUsages, @NotNull List<HourlyUsageSummary> hourlyUsageSummaries) {
        Intrinsics.checkNotNullParameter(appDailyUsages, "appDailyUsages");
        Intrinsics.checkNotNullParameter(hourlyUsageSummaries, "hourlyUsageSummaries");
        return new DailyUsageSummary(date, mode, useId, dailyUsedTime, maximumUsageTime, notificationNumbers, screenOnTimes, appDailyUsages, hourlyUsageSummaries);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DailyUsageSummary)) {
            return false;
        }
        DailyUsageSummary dailyUsageSummary = (DailyUsageSummary) other;
        return this.date == dailyUsageSummary.date && this.mode == dailyUsageSummary.mode && this.useId == dailyUsageSummary.useId && this.dailyUsedTime == dailyUsageSummary.dailyUsedTime && this.maximumUsageTime == dailyUsageSummary.maximumUsageTime && this.notificationNumbers == dailyUsageSummary.notificationNumbers && this.screenOnTimes == dailyUsageSummary.screenOnTimes && Intrinsics.areEqual(this.appDailyUsages, dailyUsageSummary.appDailyUsages) && Intrinsics.areEqual(this.hourlyUsageSummaries, dailyUsageSummary.hourlyUsageSummaries);
    }

    @NotNull
    public final List<AppUsage> getAppDailyUsages() {
        return this.appDailyUsages;
    }

    public final long getDailyUsedTime() {
        return this.dailyUsedTime;
    }

    public final long getDate() {
        return this.date;
    }

    @NotNull
    public final List<HourlyUsageSummary> getHourlyUsageSummaries() {
        return this.hourlyUsageSummaries;
    }

    @NotNull
    public final String getId() {
        return this.id;
    }

    public final long getMaximumUsageTime() {
        return this.maximumUsageTime;
    }

    public final int getMode() {
        return this.mode;
    }

    public final int getNotificationNumbers() {
        return this.notificationNumbers;
    }

    public final int getScreenOnTimes() {
        return this.screenOnTimes;
    }

    public final long getUseId() {
        return this.useId;
    }

    public int hashCode() {
        return this.hourlyUsageSummaries.hashCode() + ((this.appDailyUsages.hashCode() + g.d(this.screenOnTimes, g.d(this.notificationNumbers, g.f(this.maximumUsageTime, g.f(this.dailyUsedTime, g.f(this.useId, g.d(this.mode, Long.hashCode(this.date) * 31, 31), 31), 31), 31), 31), 31)) * 31);
    }

    @NotNull
    public String toString() {
        return "date " + TimeUtilsKt.formatDateDay(this.date) + " mode " + this.mode + " userId " + this.useId + "  daily usage time " + TimeUtilsKt.formatDuration(this.dailyUsedTime) + " max usage time " + TimeUtilsKt.formatDuration(this.maximumUsageTime) + " notificationNumbers " + this.notificationNumbers + " screenOnTimes " + this.screenOnTimes + "appDailyUsages " + this.appDailyUsages + " hourlyUsageSummaries " + this.hourlyUsageSummaries;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeLong(this.date);
        parcel.writeInt(this.mode);
        parcel.writeLong(this.useId);
        parcel.writeLong(this.dailyUsedTime);
        parcel.writeLong(this.maximumUsageTime);
        parcel.writeInt(this.notificationNumbers);
        parcel.writeInt(this.screenOnTimes);
        List<AppUsage> list = this.appDailyUsages;
        parcel.writeInt(list.size());
        Iterator<AppUsage> it = list.iterator();
        while (it.hasNext()) {
            it.next().writeToParcel(parcel, flags);
        }
        List<HourlyUsageSummary> list2 = this.hourlyUsageSummaries;
        parcel.writeInt(list2.size());
        Iterator<HourlyUsageSummary> it2 = list2.iterator();
        while (it2.hasNext()) {
            it2.next().writeToParcel(parcel, flags);
        }
    }
}
