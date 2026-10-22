package com.stepos.alphame.persona.address.data;

import B0.g;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Keep;
import androidx.room.AbstractC0351g;
import com.baidu.platform.comapi.map.MapController;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.android.parcel.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Parcelize
@Keep
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0007\b\u0016¢\u0006\u0002\u0010\u0002B\u001d\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0004¢\u0006\u0002\u0010\u0007J\t\u0010\u000e\u001a\u00020\u0004HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0004HÆ\u0003J'\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u0004HÆ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0004HÖ\u0001J\u0019\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u0013HÖ\u0001R\u0011\u0010\u0005\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001a\u0010\u0006\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\t\"\u0004\b\u000b\u0010\fR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\t¨\u0006\u001f"}, d2 = {"Lcom/stepos/alphame/persona/address/data/AddressTipBean;", "Landroid/os/Parcelable;", "()V", "name", "", "district", MapController.LOCATION_LAYER_TAG, "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getDistrict", "()Ljava/lang/String;", "getLocation", "setLocation", "(Ljava/lang/String;)V", "getName", "component1", "component2", "component3", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes.dex */
public final /* data */ class AddressTipBean implements Parcelable {

    @NotNull
    public static final Parcelable.Creator<AddressTipBean> CREATOR = new Creator();

    @NotNull
    private final String district;

    @NotNull
    private String location;

    @NotNull
    private final String name;

    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<AddressTipBean> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final AddressTipBean createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new AddressTipBean(parcel.readString(), parcel.readString(), parcel.readString());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final AddressTipBean[] newArray(int i4) {
            return new AddressTipBean[i4];
        }
    }

    public AddressTipBean(@NotNull String name, @NotNull String district, @NotNull String location) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(district, "district");
        Intrinsics.checkNotNullParameter(location, "location");
        this.name = name;
        this.district = district;
        this.location = location;
    }

    public static /* synthetic */ AddressTipBean copy$default(AddressTipBean addressTipBean, String str, String str2, String str3, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            str = addressTipBean.name;
        }
        if ((i4 & 2) != 0) {
            str2 = addressTipBean.district;
        }
        if ((i4 & 4) != 0) {
            str3 = addressTipBean.location;
        }
        return addressTipBean.copy(str, str2, str3);
    }

    @NotNull
    /* renamed from: component1, reason: from getter */
    public final String getName() {
        return this.name;
    }

    @NotNull
    /* renamed from: component2, reason: from getter */
    public final String getDistrict() {
        return this.district;
    }

    @NotNull
    /* renamed from: component3, reason: from getter */
    public final String getLocation() {
        return this.location;
    }

    @NotNull
    public final AddressTipBean copy(@NotNull String name, @NotNull String district, @NotNull String location) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(district, "district");
        Intrinsics.checkNotNullParameter(location, "location");
        return new AddressTipBean(name, district, location);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AddressTipBean)) {
            return false;
        }
        AddressTipBean addressTipBean = (AddressTipBean) other;
        return Intrinsics.areEqual(this.name, addressTipBean.name) && Intrinsics.areEqual(this.district, addressTipBean.district) && Intrinsics.areEqual(this.location, addressTipBean.location);
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

    public int hashCode() {
        return this.location.hashCode() + AbstractC0351g.d(this.district, this.name.hashCode() * 31, 31);
    }

    public final void setLocation(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.location = str;
    }

    @NotNull
    public String toString() {
        String str = this.name;
        String str2 = this.district;
        return g.r(g.x("AddressTipBean(name=", str, ", district=", str2, ", location="), this.location, ")");
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.name);
        parcel.writeString(this.district);
        parcel.writeString(this.location);
    }

    public AddressTipBean() {
        this("", "", "");
    }
}
