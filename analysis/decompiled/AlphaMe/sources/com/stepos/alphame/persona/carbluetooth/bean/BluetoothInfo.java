package com.stepos.alphame.persona.carbluetooth.bean;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.annotation.Keep;
import androidx.room.AbstractC0351g;
import com.stepos.alphame.persona.data.PersonalDataType;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.android.parcel.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Parcelize
@Keep
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0011\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0007\b\u0016¢\u0006\u0002\u0010\u0002B\u001f\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0002\u0010\bJ\t\u0010\u0013\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0006HÆ\u0003J'\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u0006HÆ\u0001J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cHÖ\u0003J\t\u0010\u001d\u001a\u00020\u0018HÖ\u0001J\u0006\u0010\u001e\u001a\u00020\u001aJ\t\u0010\u001f\u001a\u00020\u0006HÖ\u0001J\u0019\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\u0018HÖ\u0001R\u001a\u0010\u0007\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\n\"\u0004\b\u000e\u0010\fR\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012¨\u0006%"}, d2 = {"Lcom/stepos/alphame/persona/carbluetooth/bean/BluetoothInfo;", "Landroid/os/Parcelable;", "()V", "type", "", "bluetoothName", "", "bluetoothAddress", "(JLjava/lang/String;Ljava/lang/String;)V", "getBluetoothAddress", "()Ljava/lang/String;", "setBluetoothAddress", "(Ljava/lang/String;)V", "getBluetoothName", "setBluetoothName", "getType", "()J", "setType", "(J)V", "component1", "component2", "component3", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "isValid", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes.dex */
public final /* data */ class BluetoothInfo implements Parcelable {

    @NotNull
    public static final Parcelable.Creator<BluetoothInfo> CREATOR = new Creator();

    @NotNull
    private String bluetoothAddress;

    @NotNull
    private String bluetoothName;
    private long type;

    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<BluetoothInfo> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final BluetoothInfo createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new BluetoothInfo(parcel.readLong(), parcel.readString(), parcel.readString());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final BluetoothInfo[] newArray(int i4) {
            return new BluetoothInfo[i4];
        }
    }

    public BluetoothInfo(long j4, @NotNull String bluetoothName, @NotNull String bluetoothAddress) {
        Intrinsics.checkNotNullParameter(bluetoothName, "bluetoothName");
        Intrinsics.checkNotNullParameter(bluetoothAddress, "bluetoothAddress");
        this.type = j4;
        this.bluetoothName = bluetoothName;
        this.bluetoothAddress = bluetoothAddress;
    }

    public static /* synthetic */ BluetoothInfo copy$default(BluetoothInfo bluetoothInfo, long j4, String str, String str2, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            j4 = bluetoothInfo.type;
        }
        if ((i4 & 2) != 0) {
            str = bluetoothInfo.bluetoothName;
        }
        if ((i4 & 4) != 0) {
            str2 = bluetoothInfo.bluetoothAddress;
        }
        return bluetoothInfo.copy(j4, str, str2);
    }

    /* renamed from: component1, reason: from getter */
    public final long getType() {
        return this.type;
    }

    @NotNull
    /* renamed from: component2, reason: from getter */
    public final String getBluetoothName() {
        return this.bluetoothName;
    }

    @NotNull
    /* renamed from: component3, reason: from getter */
    public final String getBluetoothAddress() {
        return this.bluetoothAddress;
    }

    @NotNull
    public final BluetoothInfo copy(long type, @NotNull String bluetoothName, @NotNull String bluetoothAddress) {
        Intrinsics.checkNotNullParameter(bluetoothName, "bluetoothName");
        Intrinsics.checkNotNullParameter(bluetoothAddress, "bluetoothAddress");
        return new BluetoothInfo(type, bluetoothName, bluetoothAddress);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof BluetoothInfo)) {
            return false;
        }
        BluetoothInfo bluetoothInfo = (BluetoothInfo) other;
        return this.type == bluetoothInfo.type && Intrinsics.areEqual(this.bluetoothName, bluetoothInfo.bluetoothName) && Intrinsics.areEqual(this.bluetoothAddress, bluetoothInfo.bluetoothAddress);
    }

    @NotNull
    public final String getBluetoothAddress() {
        return this.bluetoothAddress;
    }

    @NotNull
    public final String getBluetoothName() {
        return this.bluetoothName;
    }

    public final long getType() {
        return this.type;
    }

    public int hashCode() {
        return this.bluetoothAddress.hashCode() + AbstractC0351g.d(this.bluetoothName, Long.hashCode(this.type) * 31, 31);
    }

    public final boolean isValid() {
        return (TextUtils.isEmpty(this.bluetoothName) || TextUtils.isEmpty(this.bluetoothAddress)) ? false : true;
    }

    public final void setBluetoothAddress(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.bluetoothAddress = str;
    }

    public final void setBluetoothName(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.bluetoothName = str;
    }

    public final void setType(long j4) {
        this.type = j4;
    }

    @NotNull
    public String toString() {
        return "BluetoothInfo(type=" + this.type + ", bluetoothName=" + this.bluetoothName + ", bluetoothAddress=" + this.bluetoothAddress + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeLong(this.type);
        parcel.writeString(this.bluetoothName);
        parcel.writeString(this.bluetoothAddress);
    }

    public /* synthetic */ BluetoothInfo(long j4, String str, String str2, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this((i4 & 1) != 0 ? PersonalDataType.CUSTOM.getType() : j4, str, str2);
    }

    public BluetoothInfo() {
        this(PersonalDataType.AUTO.getType(), "", "");
    }
}
