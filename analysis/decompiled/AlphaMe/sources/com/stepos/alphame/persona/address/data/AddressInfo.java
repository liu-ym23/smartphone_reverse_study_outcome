package com.stepos.alphame.persona.address.data;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Keep;
import androidx.room.AbstractC0351g;
import com.baidu.platform.comapi.map.MapController;
import com.stepos.alphame.persona.data.PersonalDataType;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.android.parcel.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Parcelize
@Keep
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0013\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0007\b\u0016¢\u0006\u0002\u0010\u0002B'\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\u0006¢\u0006\u0002\u0010\tJ\t\u0010\u0014\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0006HÆ\u0003J1\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u0006HÆ\u0001J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eHÖ\u0003J\t\u0010\u001f\u001a\u00020\u001aHÖ\u0001J\t\u0010 \u001a\u00020\u0006HÖ\u0001J\u0019\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\u001aHÖ\u0001R\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\b\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\u000b\"\u0004\b\r\u0010\u000eR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000bR\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013¨\u0006&"}, d2 = {"Lcom/stepos/alphame/persona/address/data/AddressInfo;", "Landroid/os/Parcelable;", "()V", "type", "", "name", "", "district", MapController.LOCATION_LAYER_TAG, "(JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getDistrict", "()Ljava/lang/String;", "getLocation", "setLocation", "(Ljava/lang/String;)V", "getName", "getType", "()J", "setType", "(J)V", "component1", "component2", "component3", "component4", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes.dex */
public final /* data */ class AddressInfo implements Parcelable {

    @NotNull
    public static final Parcelable.Creator<AddressInfo> CREATOR = new Creator();

    @NotNull
    private final String district;

    @NotNull
    private String location;

    @NotNull
    private final String name;
    private long type;

    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<AddressInfo> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final AddressInfo createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new AddressInfo(parcel.readLong(), parcel.readString(), parcel.readString(), parcel.readString());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final AddressInfo[] newArray(int i4) {
            return new AddressInfo[i4];
        }
    }

    public AddressInfo(long j4, @NotNull String name, @NotNull String district, @NotNull String location) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(district, "district");
        Intrinsics.checkNotNullParameter(location, "location");
        this.type = j4;
        this.name = name;
        this.district = district;
        this.location = location;
    }

    public static /* synthetic */ AddressInfo copy$default(AddressInfo addressInfo, long j4, String str, String str2, String str3, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            j4 = addressInfo.type;
        }
        long j5 = j4;
        if ((i4 & 2) != 0) {
            str = addressInfo.name;
        }
        String str4 = str;
        if ((i4 & 4) != 0) {
            str2 = addressInfo.district;
        }
        String str5 = str2;
        if ((i4 & 8) != 0) {
            str3 = addressInfo.location;
        }
        return addressInfo.copy(j5, str4, str5, str3);
    }

    /* renamed from: component1, reason: from getter */
    public final long getType() {
        return this.type;
    }

    @NotNull
    /* renamed from: component2, reason: from getter */
    public final String getName() {
        return this.name;
    }

    @NotNull
    /* renamed from: component3, reason: from getter */
    public final String getDistrict() {
        return this.district;
    }

    @NotNull
    /* renamed from: component4, reason: from getter */
    public final String getLocation() {
        return this.location;
    }

    @NotNull
    public final AddressInfo copy(long type, @NotNull String name, @NotNull String district, @NotNull String location) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(district, "district");
        Intrinsics.checkNotNullParameter(location, "location");
        return new AddressInfo(type, name, district, location);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AddressInfo)) {
            return false;
        }
        AddressInfo addressInfo = (AddressInfo) other;
        return this.type == addressInfo.type && Intrinsics.areEqual(this.name, addressInfo.name) && Intrinsics.areEqual(this.district, addressInfo.district) && Intrinsics.areEqual(this.location, addressInfo.location);
    }

    @NotNull
    public final String getDistrict() {
        return this.district;
    }

    @NotNull
    public final String getLocation() {
        return this.location;
    }

    @NotNull
    public final String getName() {
        return this.name;
    }

    public final long getType() {
        return this.type;
    }

    public int hashCode() {
        return this.location.hashCode() + AbstractC0351g.d(this.district, AbstractC0351g.d(this.name, Long.hashCode(this.type) * 31, 31), 31);
    }

    public final void setLocation(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.location = str;
    }

    public final void setType(long j4) {
        this.type = j4;
    }

    @NotNull
    public String toString() {
        long j4 = this.type;
        String str = this.name;
        String str2 = this.district;
        String str3 = this.location;
        StringBuilder sb = new StringBuilder("AddressInfo(type=");
        sb.append(j4);
        sb.append(", name=");
        sb.append(str);
        AbstractC0351g.C(sb, ", district=", str2, ", location=", str3);
        sb.append(")");
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeLong(this.type);
        parcel.writeString(this.name);
        parcel.writeString(this.district);
        parcel.writeString(this.location);
    }

    public /* synthetic */ AddressInfo(long j4, String str, String str2, String str3, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this((i4 & 1) != 0 ? PersonalDataType.CUSTOM.getType() : j4, str, str2, str3);
    }

    public AddressInfo() {
        this(PersonalDataType.AUTO.getType(), "", "", "");
    }
}
