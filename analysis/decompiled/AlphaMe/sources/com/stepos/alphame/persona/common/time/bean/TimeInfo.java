package com.stepos.alphame.persona.common.time.bean;

import B0.g;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Keep;
import com.stepos.alphame.persona.data.PersonalDataType;
import com.stepos.alphame.suggest.AppSuggestStorable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.android.parcel.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import s.AbstractC0831a;

@Parcelize
@Keep
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0007\b\u0016¢\u0006\u0002\u0010\u0002B\u0017\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0002\u0010\u0006J\t\u0010\r\u001a\u00020\u0004HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0004HÆ\u0003J\u001d\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u0004HÆ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\u0019\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u0011HÖ\u0001R\u001a\u0010\u0005\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\b\"\u0004\b\f\u0010\n¨\u0006\u001e"}, d2 = {"Lcom/stepos/alphame/persona/common/time/bean/TimeInfo;", "Landroid/os/Parcelable;", "()V", "type", "", AppSuggestStorable.COLUMN_TIME, "(JJ)V", "getTime", "()J", "setTime", "(J)V", "getType", "setType", "component1", "component2", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes.dex */
public final /* data */ class TimeInfo implements Parcelable {

    @NotNull
    public static final Parcelable.Creator<TimeInfo> CREATOR = new Creator();
    private long time;
    private long type;

    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<TimeInfo> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final TimeInfo createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new TimeInfo(parcel.readLong(), parcel.readLong());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final TimeInfo[] newArray(int i4) {
            return new TimeInfo[i4];
        }
    }

    public TimeInfo(long j4, long j5) {
        this.type = j4;
        this.time = j5;
    }

    public static /* synthetic */ TimeInfo copy$default(TimeInfo timeInfo, long j4, long j5, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            j4 = timeInfo.type;
        }
        if ((i4 & 2) != 0) {
            j5 = timeInfo.time;
        }
        return timeInfo.copy(j4, j5);
    }

    /* renamed from: component1, reason: from getter */
    public final long getType() {
        return this.type;
    }

    /* renamed from: component2, reason: from getter */
    public final long getTime() {
        return this.time;
    }

    @NotNull
    public final TimeInfo copy(long type, long time) {
        return new TimeInfo(type, time);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TimeInfo)) {
            return false;
        }
        TimeInfo timeInfo = (TimeInfo) other;
        return this.type == timeInfo.type && this.time == timeInfo.time;
    }

    public final long getTime() {
        return this.time;
    }

    public final long getType() {
        return this.type;
    }

    public int hashCode() {
        return Long.hashCode(this.time) + (Long.hashCode(this.type) * 31);
    }

    public final void setTime(long j4) {
        this.time = j4;
    }

    public final void setType(long j4) {
        this.type = j4;
    }

    @NotNull
    public String toString() {
        long j4 = this.type;
        return g.p(AbstractC0831a.e("TimeInfo(type=", j4, ", time="), this.time, ")");
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeLong(this.type);
        parcel.writeLong(this.time);
    }

    public /* synthetic */ TimeInfo(long j4, long j5, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this((i4 & 1) != 0 ? PersonalDataType.CUSTOM.getType() : j4, j5);
    }

    public TimeInfo() {
        this(PersonalDataType.AUTO.getType(), 0L);
    }
}
