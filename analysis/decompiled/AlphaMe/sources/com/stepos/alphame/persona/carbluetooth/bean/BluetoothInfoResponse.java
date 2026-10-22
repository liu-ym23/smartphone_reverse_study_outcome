package com.stepos.alphame.persona.carbluetooth.bean;

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
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\t\u0010\u000e\u001a\u00020\u0003HÖ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\u0019\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u001b"}, d2 = {"Lcom/stepos/alphame/persona/carbluetooth/bean/BluetoothInfoResponse;", "Landroid/os/Parcelable;", "code", "", "bluetoothInfo", "Lcom/stepos/alphame/persona/carbluetooth/bean/BluetoothInfo;", "(ILcom/stepos/alphame/persona/carbluetooth/bean/BluetoothInfo;)V", "getBluetoothInfo", "()Lcom/stepos/alphame/persona/carbluetooth/bean/BluetoothInfo;", "getCode", "()I", "component1", "component2", "copy", "describeContents", "equals", "", "other", "", "hashCode", "toString", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes.dex */
public final /* data */ class BluetoothInfoResponse implements Parcelable {

    @NotNull
    public static final Parcelable.Creator<BluetoothInfoResponse> CREATOR = new Creator();

    @NotNull
    private final BluetoothInfo bluetoothInfo;
    private final int code;

    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<BluetoothInfoResponse> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final BluetoothInfoResponse createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new BluetoothInfoResponse(parcel.readInt(), BluetoothInfo.CREATOR.createFromParcel(parcel));
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final BluetoothInfoResponse[] newArray(int i4) {
            return new BluetoothInfoResponse[i4];
        }
    }

    public BluetoothInfoResponse(int i4, @NotNull BluetoothInfo bluetoothInfo) {
        Intrinsics.checkNotNullParameter(bluetoothInfo, "bluetoothInfo");
        this.code = i4;
        this.bluetoothInfo = bluetoothInfo;
    }

    public static /* synthetic */ BluetoothInfoResponse copy$default(BluetoothInfoResponse bluetoothInfoResponse, int i4, BluetoothInfo bluetoothInfo, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            i4 = bluetoothInfoResponse.code;
        }
        if ((i5 & 2) != 0) {
            bluetoothInfo = bluetoothInfoResponse.bluetoothInfo;
        }
        return bluetoothInfoResponse.copy(i4, bluetoothInfo);
    }

    /* renamed from: component1, reason: from getter */
    public final int getCode() {
        return this.code;
    }

    @NotNull
    /* renamed from: component2, reason: from getter */
    public final BluetoothInfo getBluetoothInfo() {
        return this.bluetoothInfo;
    }

    @NotNull
    public final BluetoothInfoResponse copy(int code, @NotNull BluetoothInfo bluetoothInfo) {
        Intrinsics.checkNotNullParameter(bluetoothInfo, "bluetoothInfo");
        return new BluetoothInfoResponse(code, bluetoothInfo);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof BluetoothInfoResponse)) {
            return false;
        }
        BluetoothInfoResponse bluetoothInfoResponse = (BluetoothInfoResponse) other;
        return this.code == bluetoothInfoResponse.code && Intrinsics.areEqual(this.bluetoothInfo, bluetoothInfoResponse.bluetoothInfo);
    }

    @NotNull
    public final BluetoothInfo getBluetoothInfo() {
        return this.bluetoothInfo;
    }

    public final int getCode() {
        return this.code;
    }

    public int hashCode() {
        return this.bluetoothInfo.hashCode() + (Integer.hashCode(this.code) * 31);
    }

    @NotNull
    public String toString() {
        return "BluetoothInfoResponse(code=" + this.code + ", bluetoothInfo=" + this.bluetoothInfo + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeInt(this.code);
        this.bluetoothInfo.writeToParcel(parcel, flags);
    }
}
