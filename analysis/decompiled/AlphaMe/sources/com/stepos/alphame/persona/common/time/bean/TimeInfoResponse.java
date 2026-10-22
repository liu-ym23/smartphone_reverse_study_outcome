package com.stepos.alphame.persona.common.time.bean;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Keep;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.android.parcel.Parcelize;
import org.jetbrains.annotations.NotNull;

@Parcelize
@Keep
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÖ\u0001J\u0019\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0011"}, d2 = {"Lcom/stepos/alphame/persona/common/time/bean/TimeInfoResponse;", "Landroid/os/Parcelable;", "code", "", "timeInfo", "Lcom/stepos/alphame/persona/common/time/bean/TimeInfo;", "(ILcom/stepos/alphame/persona/common/time/bean/TimeInfo;)V", "getCode", "()I", "getTimeInfo", "()Lcom/stepos/alphame/persona/common/time/bean/TimeInfo;", "describeContents", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes.dex */
public final class TimeInfoResponse implements Parcelable {

    @NotNull
    public static final Parcelable.Creator<TimeInfoResponse> CREATOR = new Creator();
    private final int code;

    @NotNull
    private final TimeInfo timeInfo;

    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<TimeInfoResponse> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final TimeInfoResponse createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new TimeInfoResponse(parcel.readInt(), TimeInfo.CREATOR.createFromParcel(parcel));
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final TimeInfoResponse[] newArray(int i4) {
            return new TimeInfoResponse[i4];
        }
    }

    public TimeInfoResponse(int i4, @NotNull TimeInfo timeInfo) {
        Intrinsics.checkNotNullParameter(timeInfo, "timeInfo");
        this.code = i4;
        this.timeInfo = timeInfo;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public final int getCode() {
        return this.code;
    }

    @NotNull
    public final TimeInfo getTimeInfo() {
        return this.timeInfo;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeInt(this.code);
        this.timeInfo.writeToParcel(parcel, flags);
    }
}
