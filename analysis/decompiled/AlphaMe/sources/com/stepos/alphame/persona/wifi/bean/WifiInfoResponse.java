package com.stepos.alphame.persona.wifi.bean;

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
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\t\u0010\u000e\u001a\u00020\u0003HÖ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\u0019\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u001b"}, d2 = {"Lcom/stepos/alphame/persona/wifi/bean/WifiInfoResponse;", "Landroid/os/Parcelable;", "code", "", "wifiInfo", "Lcom/stepos/alphame/persona/wifi/bean/WifiInfo;", "(ILcom/stepos/alphame/persona/wifi/bean/WifiInfo;)V", "getCode", "()I", "getWifiInfo", "()Lcom/stepos/alphame/persona/wifi/bean/WifiInfo;", "component1", "component2", "copy", "describeContents", "equals", "", "other", "", "hashCode", "toString", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes.dex */
public final /* data */ class WifiInfoResponse implements Parcelable {

    @NotNull
    public static final Parcelable.Creator<WifiInfoResponse> CREATOR = new Creator();
    private final int code;

    @NotNull
    private final WifiInfo wifiInfo;

    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<WifiInfoResponse> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final WifiInfoResponse createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new WifiInfoResponse(parcel.readInt(), WifiInfo.CREATOR.createFromParcel(parcel));
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final WifiInfoResponse[] newArray(int i4) {
            return new WifiInfoResponse[i4];
        }
    }

    public WifiInfoResponse(int i4, @NotNull WifiInfo wifiInfo) {
        Intrinsics.checkNotNullParameter(wifiInfo, "wifiInfo");
        this.code = i4;
        this.wifiInfo = wifiInfo;
    }

    public static /* synthetic */ WifiInfoResponse copy$default(WifiInfoResponse wifiInfoResponse, int i4, WifiInfo wifiInfo, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            i4 = wifiInfoResponse.code;
        }
        if ((i5 & 2) != 0) {
            wifiInfo = wifiInfoResponse.wifiInfo;
        }
        return wifiInfoResponse.copy(i4, wifiInfo);
    }

    /* renamed from: component1, reason: from getter */
    public final int getCode() {
        return this.code;
    }

    @NotNull
    /* renamed from: component2, reason: from getter */
    public final WifiInfo getWifiInfo() {
        return this.wifiInfo;
    }

    @NotNull
    public final WifiInfoResponse copy(int code, @NotNull WifiInfo wifiInfo) {
        Intrinsics.checkNotNullParameter(wifiInfo, "wifiInfo");
        return new WifiInfoResponse(code, wifiInfo);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WifiInfoResponse)) {
            return false;
        }
        WifiInfoResponse wifiInfoResponse = (WifiInfoResponse) other;
        return this.code == wifiInfoResponse.code && Intrinsics.areEqual(this.wifiInfo, wifiInfoResponse.wifiInfo);
    }

    public final int getCode() {
        return this.code;
    }

    @NotNull
    public final WifiInfo getWifiInfo() {
        return this.wifiInfo;
    }

    public int hashCode() {
        return this.wifiInfo.hashCode() + (Integer.hashCode(this.code) * 31);
    }

    @NotNull
    public String toString() {
        return "WifiInfoResponse(code=" + this.code + ", wifiInfo=" + this.wifiInfo + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeInt(this.code);
        this.wifiInfo.writeToParcel(parcel, flags);
    }
}
