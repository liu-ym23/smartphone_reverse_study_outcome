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
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0013\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J\u000f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0019\u0010\t\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÖ\u0003J\t\u0010\u0010\u001a\u00020\u000bHÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\u0019\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u000bHÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0018"}, d2 = {"Lcom/stepos/alphame/data/model/dailyusage/MultiDailyUsageEntity;", "Landroid/os/Parcelable;", "dailyUsageEntities", "", "Lcom/stepos/alphame/data/model/dailyusage/DailyUsageEntity;", "(Ljava/util/List;)V", "getDailyUsageEntities", "()Ljava/util/List;", "component1", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "data_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes.dex */
public final /* data */ class MultiDailyUsageEntity implements Parcelable {

    @NotNull
    public static final Parcelable.Creator<MultiDailyUsageEntity> CREATOR = new Creator();

    @NotNull
    private final List<DailyUsageEntity> dailyUsageEntities;

    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<MultiDailyUsageEntity> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final MultiDailyUsageEntity createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            int i4 = parcel.readInt();
            ArrayList arrayList = new ArrayList(i4);
            for (int i5 = 0; i5 != i4; i5++) {
                arrayList.add(DailyUsageEntity.CREATOR.createFromParcel(parcel));
            }
            return new MultiDailyUsageEntity(arrayList);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final MultiDailyUsageEntity[] newArray(int i4) {
            return new MultiDailyUsageEntity[i4];
        }
    }

    public MultiDailyUsageEntity(@NotNull List<DailyUsageEntity> dailyUsageEntities) {
        Intrinsics.checkNotNullParameter(dailyUsageEntities, "dailyUsageEntities");
        this.dailyUsageEntities = dailyUsageEntities;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ MultiDailyUsageEntity copy$default(MultiDailyUsageEntity multiDailyUsageEntity, List list, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            list = multiDailyUsageEntity.dailyUsageEntities;
        }
        return multiDailyUsageEntity.copy(list);
    }

    @NotNull
    public final List<DailyUsageEntity> component1() {
        return this.dailyUsageEntities;
    }

    @NotNull
    public final MultiDailyUsageEntity copy(@NotNull List<DailyUsageEntity> dailyUsageEntities) {
        Intrinsics.checkNotNullParameter(dailyUsageEntities, "dailyUsageEntities");
        return new MultiDailyUsageEntity(dailyUsageEntities);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof MultiDailyUsageEntity) && Intrinsics.areEqual(this.dailyUsageEntities, ((MultiDailyUsageEntity) other).dailyUsageEntities);
    }

    @NotNull
    public final List<DailyUsageEntity> getDailyUsageEntities() {
        return this.dailyUsageEntities;
    }

    public int hashCode() {
        return this.dailyUsageEntities.hashCode();
    }

    @NotNull
    public String toString() {
        return "MultiDailyUsageEntity(dailyUsageEntities=" + this.dailyUsageEntities + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        List<DailyUsageEntity> list = this.dailyUsageEntities;
        parcel.writeInt(list.size());
        Iterator<DailyUsageEntity> it = list.iterator();
        while (it.hasNext()) {
            it.next().writeToParcel(parcel, flags);
        }
    }
}
