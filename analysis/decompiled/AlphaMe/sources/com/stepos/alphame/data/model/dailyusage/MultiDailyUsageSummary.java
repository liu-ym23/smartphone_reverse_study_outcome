package com.stepos.alphame.data.model.dailyusage;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Parcelize
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u001b\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u000f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0006HÆ\u0003J#\u0010\u000e\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\u0019\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u0010HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u001d"}, d2 = {"Lcom/stepos/alphame/data/model/dailyusage/MultiDailyUsageSummary;", "Landroid/os/Parcelable;", "dailyUsageSummaries", "", "Lcom/stepos/alphame/data/model/dailyusage/DailyUsageSummary;", "requestTime", "", "(Ljava/util/List;J)V", "getDailyUsageSummaries", "()Ljava/util/List;", "getRequestTime", "()J", "component1", "component2", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "data_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes.dex */
public final /* data */ class MultiDailyUsageSummary implements Parcelable {

    @NotNull
    public static final Parcelable.Creator<MultiDailyUsageSummary> CREATOR = new Creator();

    @NotNull
    private final List<DailyUsageSummary> dailyUsageSummaries;
    private final long requestTime;

    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<MultiDailyUsageSummary> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final MultiDailyUsageSummary createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            int i4 = parcel.readInt();
            ArrayList arrayList = new ArrayList(i4);
            for (int i5 = 0; i5 != i4; i5++) {
                arrayList.add(DailyUsageSummary.CREATOR.createFromParcel(parcel));
            }
            return new MultiDailyUsageSummary(arrayList, parcel.readLong());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final MultiDailyUsageSummary[] newArray(int i4) {
            return new MultiDailyUsageSummary[i4];
        }
    }

    public MultiDailyUsageSummary(@NotNull List<DailyUsageSummary> dailyUsageSummaries, long j4) {
        Intrinsics.checkNotNullParameter(dailyUsageSummaries, "dailyUsageSummaries");
        this.dailyUsageSummaries = dailyUsageSummaries;
        this.requestTime = j4;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ MultiDailyUsageSummary copy$default(MultiDailyUsageSummary multiDailyUsageSummary, List list, long j4, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            list = multiDailyUsageSummary.dailyUsageSummaries;
        }
        if ((i4 & 2) != 0) {
            j4 = multiDailyUsageSummary.requestTime;
        }
        return multiDailyUsageSummary.copy(list, j4);
    }

    @NotNull
    public final List<DailyUsageSummary> component1() {
        return this.dailyUsageSummaries;
    }

    /* renamed from: component2, reason: from getter */
    public final long getRequestTime() {
        return this.requestTime;
    }

    @NotNull
    public final MultiDailyUsageSummary copy(@NotNull List<DailyUsageSummary> dailyUsageSummaries, long requestTime) {
        Intrinsics.checkNotNullParameter(dailyUsageSummaries, "dailyUsageSummaries");
        return new MultiDailyUsageSummary(dailyUsageSummaries, requestTime);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MultiDailyUsageSummary)) {
            return false;
        }
        MultiDailyUsageSummary multiDailyUsageSummary = (MultiDailyUsageSummary) other;
        return Intrinsics.areEqual(this.dailyUsageSummaries, multiDailyUsageSummary.dailyUsageSummaries) && this.requestTime == multiDailyUsageSummary.requestTime;
    }

    @NotNull
    public final List<DailyUsageSummary> getDailyUsageSummaries() {
        return this.dailyUsageSummaries;
    }

    public final long getRequestTime() {
        return this.requestTime;
    }

    public int hashCode() {
        return Long.hashCode(this.requestTime) + (this.dailyUsageSummaries.hashCode() * 31);
    }

    @NotNull
    public String toString() {
        return "MultiDailyUsageSummary(dailyUsageSummaries=" + this.dailyUsageSummaries + ", requestTime=" + this.requestTime + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        List<DailyUsageSummary> list = this.dailyUsageSummaries;
        parcel.writeInt(list.size());
        Iterator<DailyUsageSummary> it = list.iterator();
        while (it.hasNext()) {
            it.next().writeToParcel(parcel, flags);
        }
        parcel.writeLong(this.requestTime);
    }
}
