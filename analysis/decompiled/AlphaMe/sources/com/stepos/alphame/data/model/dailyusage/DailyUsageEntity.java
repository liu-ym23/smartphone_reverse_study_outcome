package com.stepos.alphame.data.model.dailyusage;

import B0.g;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Keep;
import androidx.room.AbstractC0351g;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;
import com.stepos.alphame.data.DataContractKt;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Parcelize
@Keep
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001BI\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\fJ\t\u0010*\u001a\u00020\u0003HÆ\u0003J\t\u0010+\u001a\u00020\u0005HÆ\u0003J\t\u0010,\u001a\u00020\u0007HÆ\u0003J\t\u0010-\u001a\u00020\u0005HÆ\u0003J\u000b\u0010.\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010/\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00100\u001a\u0004\u0018\u00010\u0003HÆ\u0003JU\u00101\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00052\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\t\u00102\u001a\u00020\u0007HÖ\u0001J\u0013\u00103\u001a\u0002042\b\u00105\u001a\u0004\u0018\u000106HÖ\u0003J\t\u00107\u001a\u00020\u0007HÖ\u0001J\t\u00108\u001a\u00020\u0003HÖ\u0001J\u0019\u00109\u001a\u00020:2\u0006\u0010;\u001a\u00020<2\u0006\u0010=\u001a\u00020\u0007HÖ\u0001R\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0010R*\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00160\u00158\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u0018\u0010\n\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0010R*\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001f0\u00158\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b \u0010\u0018\u001a\u0004\b!\u0010\u001a\"\u0004\b\"\u0010\u001cR\u0018\u0010\t\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u0010R*\u0010$\u001a\b\u0012\u0004\u0012\u00020%0\u00158\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b&\u0010\u0018\u001a\u0004\b'\u0010\u001a\"\u0004\b(\u0010\u001cR\u0016\u0010\b\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b)\u0010\u000e¨\u0006>"}, d2 = {"Lcom/stepos/alphame/data/model/dailyusage/DailyUsageEntity;", "Landroid/os/Parcelable;", "id", "", "date", "", "mode", "", "userId", "timeUsagePath", "screenUsagePath", "notificationUsagePath", "(Ljava/lang/String;JIJLjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getDate", "()J", "getId", "()Ljava/lang/String;", "getMode", "()I", "getNotificationUsagePath", "notificationUsages", "", "Lcom/stepos/alphame/data/model/dailyusage/NotificationUsageEntity;", "getNotificationUsages$annotations", "()V", "getNotificationUsages", "()Ljava/util/List;", "setNotificationUsages", "(Ljava/util/List;)V", "getScreenUsagePath", "screenUsages", "Lcom/stepos/alphame/data/model/dailyusage/ScreenUsageEntity;", "getScreenUsages$annotations", "getScreenUsages", "setScreenUsages", "getTimeUsagePath", "timeUsages", "Lcom/stepos/alphame/data/model/dailyusage/TimeUsageEntity;", "getTimeUsages$annotations", "getTimeUsages", "setTimeUsages", "getUserId", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "data_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@Entity(tableName = DataContractKt.DAILY_USAGE_FILE_NAME)
/* loaded from: classes.dex */
public final /* data */ class DailyUsageEntity implements Parcelable {

    @NotNull
    public static final Parcelable.Creator<DailyUsageEntity> CREATOR = new Creator();

    @ColumnInfo(name = "date")
    private final long date;

    @PrimaryKey
    @NotNull
    private final String id;

    @ColumnInfo(name = "mode")
    private final int mode;

    @ColumnInfo(name = "notification_usage_path")
    @Nullable
    private final String notificationUsagePath;

    @Ignore
    @NotNull
    private List<NotificationUsageEntity> notificationUsages;

    @ColumnInfo(name = "screen_usage_path")
    @Nullable
    private final String screenUsagePath;

    @Ignore
    @NotNull
    private List<ScreenUsageEntity> screenUsages;

    @ColumnInfo(name = "time_usage_path")
    @Nullable
    private final String timeUsagePath;

    @Ignore
    @NotNull
    private List<TimeUsageEntity> timeUsages;

    @ColumnInfo(name = "user_id")
    private final long userId;

    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<DailyUsageEntity> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final DailyUsageEntity createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new DailyUsageEntity(parcel.readString(), parcel.readLong(), parcel.readInt(), parcel.readLong(), parcel.readString(), parcel.readString(), parcel.readString());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final DailyUsageEntity[] newArray(int i4) {
            return new DailyUsageEntity[i4];
        }
    }

    public DailyUsageEntity(@NotNull String id, long j4, int i4, long j5, @Nullable String str, @Nullable String str2, @Nullable String str3) {
        Intrinsics.checkNotNullParameter(id, "id");
        this.id = id;
        this.date = j4;
        this.mode = i4;
        this.userId = j5;
        this.timeUsagePath = str;
        this.screenUsagePath = str2;
        this.notificationUsagePath = str3;
        this.notificationUsages = new ArrayList();
        this.screenUsages = new ArrayList();
        this.timeUsages = new ArrayList();
    }

    public static /* synthetic */ void getNotificationUsages$annotations() {
    }

    public static /* synthetic */ void getScreenUsages$annotations() {
    }

    public static /* synthetic */ void getTimeUsages$annotations() {
    }

    @NotNull
    /* renamed from: component1, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* renamed from: component2, reason: from getter */
    public final long getDate() {
        return this.date;
    }

    /* renamed from: component3, reason: from getter */
    public final int getMode() {
        return this.mode;
    }

    /* renamed from: component4, reason: from getter */
    public final long getUserId() {
        return this.userId;
    }

    @Nullable
    /* renamed from: component5, reason: from getter */
    public final String getTimeUsagePath() {
        return this.timeUsagePath;
    }

    @Nullable
    /* renamed from: component6, reason: from getter */
    public final String getScreenUsagePath() {
        return this.screenUsagePath;
    }

    @Nullable
    /* renamed from: component7, reason: from getter */
    public final String getNotificationUsagePath() {
        return this.notificationUsagePath;
    }

    @NotNull
    public final DailyUsageEntity copy(@NotNull String id, long date, int mode, long userId, @Nullable String timeUsagePath, @Nullable String screenUsagePath, @Nullable String notificationUsagePath) {
        Intrinsics.checkNotNullParameter(id, "id");
        return new DailyUsageEntity(id, date, mode, userId, timeUsagePath, screenUsagePath, notificationUsagePath);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DailyUsageEntity)) {
            return false;
        }
        DailyUsageEntity dailyUsageEntity = (DailyUsageEntity) other;
        return Intrinsics.areEqual(this.id, dailyUsageEntity.id) && this.date == dailyUsageEntity.date && this.mode == dailyUsageEntity.mode && this.userId == dailyUsageEntity.userId && Intrinsics.areEqual(this.timeUsagePath, dailyUsageEntity.timeUsagePath) && Intrinsics.areEqual(this.screenUsagePath, dailyUsageEntity.screenUsagePath) && Intrinsics.areEqual(this.notificationUsagePath, dailyUsageEntity.notificationUsagePath);
    }

    public final long getDate() {
        return this.date;
    }

    @NotNull
    public final String getId() {
        return this.id;
    }

    public final int getMode() {
        return this.mode;
    }

    @Nullable
    public final String getNotificationUsagePath() {
        return this.notificationUsagePath;
    }

    @NotNull
    public final List<NotificationUsageEntity> getNotificationUsages() {
        return this.notificationUsages;
    }

    @Nullable
    public final String getScreenUsagePath() {
        return this.screenUsagePath;
    }

    @NotNull
    public final List<ScreenUsageEntity> getScreenUsages() {
        return this.screenUsages;
    }

    @Nullable
    public final String getTimeUsagePath() {
        return this.timeUsagePath;
    }

    @NotNull
    public final List<TimeUsageEntity> getTimeUsages() {
        return this.timeUsages;
    }

    public final long getUserId() {
        return this.userId;
    }

    public int hashCode() {
        int iF = g.f(this.userId, g.d(this.mode, g.f(this.date, this.id.hashCode() * 31, 31), 31), 31);
        String str = this.timeUsagePath;
        int iHashCode = (iF + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.screenUsagePath;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.notificationUsagePath;
        return iHashCode2 + (str3 != null ? str3.hashCode() : 0);
    }

    public final void setNotificationUsages(@NotNull List<NotificationUsageEntity> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.notificationUsages = list;
    }

    public final void setScreenUsages(@NotNull List<ScreenUsageEntity> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.screenUsages = list;
    }

    public final void setTimeUsages(@NotNull List<TimeUsageEntity> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.timeUsages = list;
    }

    @NotNull
    public String toString() {
        String str = this.id;
        long j4 = this.date;
        int i4 = this.mode;
        long j5 = this.userId;
        String str2 = this.timeUsagePath;
        String str3 = this.screenUsagePath;
        String str4 = this.notificationUsagePath;
        StringBuilder sb = new StringBuilder("DailyUsageEntity(id=");
        sb.append(str);
        sb.append(", date=");
        sb.append(j4);
        sb.append(", mode=");
        sb.append(i4);
        sb.append(", userId=");
        sb.append(j5);
        sb.append(", timeUsagePath=");
        sb.append(str2);
        AbstractC0351g.C(sb, ", screenUsagePath=", str3, ", notificationUsagePath=", str4);
        sb.append(")");
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.id);
        parcel.writeLong(this.date);
        parcel.writeInt(this.mode);
        parcel.writeLong(this.userId);
        parcel.writeString(this.timeUsagePath);
        parcel.writeString(this.screenUsagePath);
        parcel.writeString(this.notificationUsagePath);
    }

    public /* synthetic */ DailyUsageEntity(String str, long j4, int i4, long j5, String str2, String str3, String str4, int i5, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, j4, i4, j5, (i5 & 16) != 0 ? null : str2, (i5 & 32) != 0 ? null : str3, (i5 & 64) != 0 ? null : str4);
    }
}
