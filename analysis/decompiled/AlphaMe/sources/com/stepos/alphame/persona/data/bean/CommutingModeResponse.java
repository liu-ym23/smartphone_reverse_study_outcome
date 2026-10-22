package com.stepos.alphame.persona.data.bean;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Keep;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.android.parcel.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Parcelize
@Keep
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\t\u0010\u000e\u001a\u00020\u0003HÖ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\u0019\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u001b"}, d2 = {"Lcom/stepos/alphame/persona/data/bean/CommutingModeResponse;", "Landroid/os/Parcelable;", "code", "", "mode", "", "(IJ)V", "getCode", "()I", "getMode", "()J", "component1", "component2", "copy", "describeContents", "equals", "", "other", "", "hashCode", "toString", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes.dex */
public final /* data */ class CommutingModeResponse implements Parcelable {

    @NotNull
    public static final Parcelable.Creator<CommutingModeResponse> CREATOR = new Creator();
    private final int code;
    private final long mode;

    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<CommutingModeResponse> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final CommutingModeResponse createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new CommutingModeResponse(parcel.readInt(), parcel.readLong());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final CommutingModeResponse[] newArray(int i4) {
            return new CommutingModeResponse[i4];
        }
    }

    public CommutingModeResponse(int i4, long j4) {
        this.code = i4;
        this.mode = j4;
    }

    public static /* synthetic */ CommutingModeResponse copy$default(CommutingModeResponse commutingModeResponse, int i4, long j4, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            i4 = commutingModeResponse.code;
        }
        if ((i5 & 2) != 0) {
            j4 = commutingModeResponse.mode;
        }
        return commutingModeResponse.copy(i4, j4);
    }

    /* renamed from: component1, reason: from getter */
    public final int getCode() {
        return this.code;
    }

    /* renamed from: component2, reason: from getter */
    public final long getMode() {
        return this.mode;
    }

    @NotNull
    public final CommutingModeResponse copy(int code, long mode) {
        return new CommutingModeResponse(code, mode);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CommutingModeResponse)) {
            return false;
        }
        CommutingModeResponse commutingModeResponse = (CommutingModeResponse) other;
        return this.code == commutingModeResponse.code && this.mode == commutingModeResponse.mode;
    }

    public final int getCode() {
        return this.code;
    }

    public final long getMode() {
        return this.mode;
    }

    public int hashCode() {
        return Long.hashCode(this.mode) + (Integer.hashCode(this.code) * 31);
    }

    @NotNull
    public String toString() {
        return "CommutingModeResponse(code=" + this.code + ", mode=" + this.mode + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeInt(this.code);
        parcel.writeLong(this.mode);
    }
}
