package com.stepos.alphame.persona.wifi.bean;

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
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0011\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0007\b\u0016¢\u0006\u0002\u0010\u0002B\u001f\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0002\u0010\bJ\t\u0010\u0013\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0006HÆ\u0003J'\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u0006HÆ\u0001J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cHÖ\u0003J\t\u0010\u001d\u001a\u00020\u0018HÖ\u0001J\u0006\u0010\u001e\u001a\u00020\u001aJ\t\u0010\u001f\u001a\u00020\u0006HÖ\u0001J\u0019\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\u0018HÖ\u0001R\u001a\u0010\u0007\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\n\"\u0004\b\u000e\u0010\fR\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012¨\u0006%"}, d2 = {"Lcom/stepos/alphame/persona/wifi/bean/WifiInfo;", "Landroid/os/Parcelable;", "()V", "type", "", "ssid", "", "bSsid", "(JLjava/lang/String;Ljava/lang/String;)V", "getBSsid", "()Ljava/lang/String;", "setBSsid", "(Ljava/lang/String;)V", "getSsid", "setSsid", "getType", "()J", "setType", "(J)V", "component1", "component2", "component3", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "isValid", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes.dex */
public final /* data */ class WifiInfo implements Parcelable {

    @NotNull
    public static final Parcelable.Creator<WifiInfo> CREATOR = new Creator();

    @NotNull
    private String bSsid;

    @NotNull
    private String ssid;
    private long type;

    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<WifiInfo> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final WifiInfo createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new WifiInfo(parcel.readLong(), parcel.readString(), parcel.readString());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final WifiInfo[] newArray(int i4) {
            return new WifiInfo[i4];
        }
    }

    public WifiInfo(long j4, @NotNull String ssid, @NotNull String bSsid) {
        Intrinsics.checkNotNullParameter(ssid, "ssid");
        Intrinsics.checkNotNullParameter(bSsid, "bSsid");
        this.type = j4;
        this.ssid = ssid;
        this.bSsid = bSsid;
    }

    public static /* synthetic */ WifiInfo copy$default(WifiInfo wifiInfo, long j4, String str, String str2, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            j4 = wifiInfo.type;
        }
        if ((i4 & 2) != 0) {
            str = wifiInfo.ssid;
        }
        if ((i4 & 4) != 0) {
            str2 = wifiInfo.bSsid;
        }
        return wifiInfo.copy(j4, str, str2);
    }

    /* renamed from: component1, reason: from getter */
    public final long getType() {
        return this.type;
    }

    @NotNull
    /* renamed from: component2, reason: from getter */
    public final String getSsid() {
        return this.ssid;
    }

    @NotNull
    /* renamed from: component3, reason: from getter */
    public final String getBSsid() {
        return this.bSsid;
    }

    @NotNull
    public final WifiInfo copy(long type, @NotNull String ssid, @NotNull String bSsid) {
        Intrinsics.checkNotNullParameter(ssid, "ssid");
        Intrinsics.checkNotNullParameter(bSsid, "bSsid");
        return new WifiInfo(type, ssid, bSsid);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WifiInfo)) {
            return false;
        }
        WifiInfo wifiInfo = (WifiInfo) other;
        return this.type == wifiInfo.type && Intrinsics.areEqual(this.ssid, wifiInfo.ssid) && Intrinsics.areEqual(this.bSsid, wifiInfo.bSsid);
    }

    @NotNull
    public final String getBSsid() {
        return this.bSsid;
    }

    @NotNull
    public final String getSsid() {
        return this.ssid;
    }

    public final long getType() {
        return this.type;
    }

    public int hashCode() {
        return this.bSsid.hashCode() + AbstractC0351g.d(this.ssid, Long.hashCode(this.type) * 31, 31);
    }

    public final boolean isValid() {
        return !TextUtils.isEmpty(this.ssid);
    }

    public final void setBSsid(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.bSsid = str;
    }

    public final void setSsid(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.ssid = str;
    }

    public final void setType(long j4) {
        this.type = j4;
    }

    @NotNull
    public String toString() {
        return "WifiInfo(type=" + this.type + ", ssid=" + this.ssid + ", bSsid=" + this.bSsid + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeLong(this.type);
        parcel.writeString(this.ssid);
        parcel.writeString(this.bSsid);
    }

    public /* synthetic */ WifiInfo(long j4, String str, String str2, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this((i4 & 1) != 0 ? PersonalDataType.CUSTOM.getType() : j4, str, str2);
    }

    public WifiInfo() {
        this(PersonalDataType.AUTO.getType(), "", "");
    }
}
