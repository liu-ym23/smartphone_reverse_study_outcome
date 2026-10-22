package com.stepos.alphame.persona.address.data;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Keep;
import androidx.room.AbstractC0351g;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;
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
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b \n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0007\b\u0016¢\u0006\u0002\u0010\u0002B7\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\u000b\u001a\u00020\f¢\u0006\u0002\u0010\rJ\t\u0010*\u001a\u00020\u0004HÆ\u0003J\t\u0010+\u001a\u00020\u0006HÆ\u0003J\t\u0010,\u001a\u00020\u0006HÆ\u0003J\t\u0010-\u001a\u00020\tHÆ\u0003J\t\u0010.\u001a\u00020\tHÆ\u0003J\t\u0010/\u001a\u00020\fHÆ\u0003JE\u00100\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u000b\u001a\u00020\fHÆ\u0001J\t\u00101\u001a\u00020\u0013HÖ\u0001J\u0013\u00102\u001a\u00020\f2\b\u00103\u001a\u0004\u0018\u000104HÖ\u0003J\t\u00105\u001a\u00020\u0013HÖ\u0001J\t\u00106\u001a\u00020\u0006HÖ\u0001J\u0019\u00107\u001a\u0002082\u0006\u00109\u001a\u00020:2\u0006\u0010;\u001a\u00020\u0013HÖ\u0001R\u001e\u0010\u0007\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001e\u0010\u0012\u001a\u00020\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001e\u0010\u000b\u001a\u00020\f8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001e\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001e\u0010\b\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u001c\"\u0004\b \u0010\u001eR\u001e\u0010\u0005\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u000f\"\u0004\b\"\u0010\u0011R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u001e\u0010'\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010$\"\u0004\b)\u0010&¨\u0006<"}, d2 = {"Lcom/stepos/alphame/persona/address/data/AddressEntity;", "Landroid/os/Parcelable;", "()V", "type", "", "name", "", "district", AppSuggestStorable.COLUMN_LONGITUDE, "", AppSuggestStorable.COLUMN_LATITUDE, "isChecked", "", "(JLjava/lang/String;Ljava/lang/String;DDZ)V", "getDistrict", "()Ljava/lang/String;", "setDistrict", "(Ljava/lang/String;)V", "id", "", "getId", "()I", "setId", "(I)V", "()Z", "setChecked", "(Z)V", "getLatitude", "()D", "setLatitude", "(D)V", "getLongitude", "setLongitude", "getName", "setName", "getType", "()J", "setType", "(J)V", "updateTime", "getUpdateTime", "setUpdateTime", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "describeContents", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@Entity(tableName = "history_address")
/* loaded from: classes.dex */
public final /* data */ class AddressEntity implements Parcelable {

    @NotNull
    public static final Parcelable.Creator<AddressEntity> CREATOR = new Creator();

    @ColumnInfo(name = "district")
    @NotNull
    private String district;

    @PrimaryKey(autoGenerate = true)
    private int id;

    @Ignore
    private transient boolean isChecked;

    @ColumnInfo(name = AppSuggestStorable.COLUMN_LATITUDE)
    private double latitude;

    @ColumnInfo(name = AppSuggestStorable.COLUMN_LONGITUDE)
    private double longitude;

    @ColumnInfo(name = "address_name")
    @NotNull
    private String name;

    @Ignore
    private transient long type;

    @ColumnInfo(name = "update_time")
    private long updateTime;

    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<AddressEntity> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final AddressEntity createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new AddressEntity(parcel.readLong(), parcel.readString(), parcel.readString(), parcel.readDouble(), parcel.readDouble(), parcel.readInt() != 0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final AddressEntity[] newArray(int i4) {
            return new AddressEntity[i4];
        }
    }

    public AddressEntity(long j4, @NotNull String name, @NotNull String district, double d4, double d5, boolean z4) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(district, "district");
        this.type = j4;
        this.name = name;
        this.district = district;
        this.longitude = d4;
        this.latitude = d5;
        this.isChecked = z4;
        this.updateTime = System.currentTimeMillis();
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

    /* renamed from: component4, reason: from getter */
    public final double getLongitude() {
        return this.longitude;
    }

    /* renamed from: component5, reason: from getter */
    public final double getLatitude() {
        return this.latitude;
    }

    /* renamed from: component6, reason: from getter */
    public final boolean getIsChecked() {
        return this.isChecked;
    }

    @NotNull
    public final AddressEntity copy(long type, @NotNull String name, @NotNull String district, double longitude, double latitude, boolean isChecked) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(district, "district");
        return new AddressEntity(type, name, district, longitude, latitude, isChecked);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AddressEntity)) {
            return false;
        }
        AddressEntity addressEntity = (AddressEntity) other;
        return this.type == addressEntity.type && Intrinsics.areEqual(this.name, addressEntity.name) && Intrinsics.areEqual(this.district, addressEntity.district) && Double.compare(this.longitude, addressEntity.longitude) == 0 && Double.compare(this.latitude, addressEntity.latitude) == 0 && this.isChecked == addressEntity.isChecked;
    }

    @NotNull
    public final String getDistrict() {
        return this.district;
    }

    public final int getId() {
        return this.id;
    }

    public final double getLatitude() {
        return this.latitude;
    }

    public final double getLongitude() {
        return this.longitude;
    }

    @NotNull
    public final String getName() {
        return this.name;
    }

    public final long getType() {
        return this.type;
    }

    public final long getUpdateTime() {
        return this.updateTime;
    }

    public int hashCode() {
        return Boolean.hashCode(this.isChecked) + ((Double.hashCode(this.latitude) + ((Double.hashCode(this.longitude) + AbstractC0351g.d(this.district, AbstractC0351g.d(this.name, Long.hashCode(this.type) * 31, 31), 31)) * 31)) * 31);
    }

    public final boolean isChecked() {
        return this.isChecked;
    }

    public final void setChecked(boolean z4) {
        this.isChecked = z4;
    }

    public final void setDistrict(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.district = str;
    }

    public final void setId(int i4) {
        this.id = i4;
    }

    public final void setLatitude(double d4) {
        this.latitude = d4;
    }

    public final void setLongitude(double d4) {
        this.longitude = d4;
    }

    public final void setName(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.name = str;
    }

    public final void setType(long j4) {
        this.type = j4;
    }

    public final void setUpdateTime(long j4) {
        this.updateTime = j4;
    }

    @NotNull
    public String toString() {
        long j4 = this.type;
        String str = this.name;
        String str2 = this.district;
        double d4 = this.longitude;
        double d5 = this.latitude;
        boolean z4 = this.isChecked;
        StringBuilder sb = new StringBuilder("AddressEntity(type=");
        sb.append(j4);
        sb.append(", name=");
        sb.append(str);
        AbstractC0831a.h(sb, ", district=", str2, ", longitude=");
        sb.append(d4);
        sb.append(", latitude=");
        sb.append(d5);
        sb.append(", isChecked=");
        sb.append(z4);
        sb.append(")");
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeLong(this.type);
        parcel.writeString(this.name);
        parcel.writeString(this.district);
        parcel.writeDouble(this.longitude);
        parcel.writeDouble(this.latitude);
        parcel.writeInt(this.isChecked ? 1 : 0);
    }

    public /* synthetic */ AddressEntity(long j4, String str, String str2, double d4, double d5, boolean z4, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this((i4 & 1) != 0 ? PersonalDataType.CUSTOM.getType() : j4, str, str2, d4, d5, z4);
    }

    public AddressEntity() {
        this(PersonalDataType.CUSTOM.getType(), "", "", 0.0d, 0.0d, false);
    }
}
