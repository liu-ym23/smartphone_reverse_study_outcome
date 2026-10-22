package com.stepos.alphame.location.data;

import B0.g;
import androidx.room.AbstractC0351g;
import com.stepos.alphame.suggest.AppSuggestStorable;
import com.stepos.alphame.utils.Property;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b?\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0007\b\u0016¢\u0006\u0002\u0010\u0002B\u0093\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\b\u0012\b\u0010\n\u001a\u0004\u0018\u00010\b\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\b\u0012\b\u0010\f\u001a\u0004\u0018\u00010\b\u0012\b\u0010\r\u001a\u0004\u0018\u00010\b\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\b\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\b\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\b\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\b\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\b\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\u0014J\t\u00107\u001a\u00020\u0004HÆ\u0003J\u000b\u00108\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u00109\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010:\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010;\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010<\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010=\u001a\u0004\u0018\u00010\bHÆ\u0003J\t\u0010>\u001a\u00020\u0004HÆ\u0003J\t\u0010?\u001a\u00020\u0004HÆ\u0003J\t\u0010@\u001a\u00020\bHÆ\u0003J\u000b\u0010A\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010B\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010C\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010D\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010E\u001a\u0004\u0018\u00010\bHÆ\u0003Jµ\u0001\u0010F\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\bHÆ\u0001J\u0013\u0010G\u001a\u00020H2\b\u0010I\u001a\u0004\u0018\u00010JHÖ\u0003J\t\u0010K\u001a\u00020LHÖ\u0001J\t\u0010M\u001a\u00020\bHÖ\u0001R\u001a\u0010\u0006\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001c\u0010\u0010\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001a\"\u0004\b\u001e\u0010\u001cR\u001c\u0010\u0011\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u001a\"\u0004\b \u0010\u001cR\u001c\u0010\u0012\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u001a\"\u0004\b\"\u0010\u001cR\u001c\u0010\u000b\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u001a\"\u0004\b$\u0010\u001cR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u001a\"\u0004\b&\u0010\u001cR\u001c\u0010\t\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010\u001a\"\u0004\b(\u0010\u001cR\u001c\u0010\f\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\u001a\"\u0004\b*\u0010\u001cR\u001c\u0010\u0013\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010\u001a\"\u0004\b,\u0010\u001cR\u001a\u0010\u0005\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010\u0016\"\u0004\b.\u0010\u0018R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u0010\u0016\"\u0004\b0\u0010\u0018R\u001c\u0010\n\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u0010\u001a\"\u0004\b2\u0010\u001cR\u001c\u0010\r\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u0010\u001a\"\u0004\b4\u0010\u001cR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u0010\u001a\"\u0004\b6\u0010\u001c¨\u0006N"}, d2 = {"Lcom/stepos/alphame/location/data/LocationInfo;", "Ljava/io/Serializable;", "()V", AppSuggestStorable.COLUMN_LONGITUDE, "", AppSuggestStorable.COLUMN_LATITUDE, "accuracy", "address", "", "country", "province", "city", "district", "street", "streetNum", "cityCode", "adCode", "aoiName", "buildingId", "floor", "(FFFLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAccuracy", "()F", "setAccuracy", "(F)V", "getAdCode", "()Ljava/lang/String;", "setAdCode", "(Ljava/lang/String;)V", "getAddress", "setAddress", "getAoiName", "setAoiName", "getBuildingId", "setBuildingId", "getCity", "setCity", "getCityCode", "setCityCode", "getCountry", "setCountry", "getDistrict", "setDistrict", "getFloor", "setFloor", "getLatitude", "setLatitude", "getLongitude", "setLongitude", "getProvince", "setProvince", "getStreet", "setStreet", "getStreetNum", "setStreetNum", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "", "hashCode", "", "toString", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes.dex */
public final /* data */ class LocationInfo implements Serializable {
    private float accuracy;

    @Nullable
    private String adCode;

    @NotNull
    private String address;

    @Nullable
    private String aoiName;

    @Nullable
    private String buildingId;

    @Nullable
    private String city;

    @Nullable
    private String cityCode;

    @Nullable
    private String country;

    @Nullable
    private String district;

    @Nullable
    private String floor;
    private float latitude;
    private float longitude;

    @Nullable
    private String province;

    @Nullable
    private String street;

    @Nullable
    private String streetNum;

    public LocationInfo(float f4, float f5, float f6, @NotNull String address, @Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable String str5, @Nullable String str6, @Nullable String str7, @Nullable String str8, @Nullable String str9, @Nullable String str10, @Nullable String str11) {
        Intrinsics.checkNotNullParameter(address, "address");
        this.longitude = f4;
        this.latitude = f5;
        this.accuracy = f6;
        this.address = address;
        this.country = str;
        this.province = str2;
        this.city = str3;
        this.district = str4;
        this.street = str5;
        this.streetNum = str6;
        this.cityCode = str7;
        this.adCode = str8;
        this.aoiName = str9;
        this.buildingId = str10;
        this.floor = str11;
    }

    /* renamed from: component1, reason: from getter */
    public final float getLongitude() {
        return this.longitude;
    }

    @Nullable
    /* renamed from: component10, reason: from getter */
    public final String getStreetNum() {
        return this.streetNum;
    }

    @Nullable
    /* renamed from: component11, reason: from getter */
    public final String getCityCode() {
        return this.cityCode;
    }

    @Nullable
    /* renamed from: component12, reason: from getter */
    public final String getAdCode() {
        return this.adCode;
    }

    @Nullable
    /* renamed from: component13, reason: from getter */
    public final String getAoiName() {
        return this.aoiName;
    }

    @Nullable
    /* renamed from: component14, reason: from getter */
    public final String getBuildingId() {
        return this.buildingId;
    }

    @Nullable
    /* renamed from: component15, reason: from getter */
    public final String getFloor() {
        return this.floor;
    }

    /* renamed from: component2, reason: from getter */
    public final float getLatitude() {
        return this.latitude;
    }

    /* renamed from: component3, reason: from getter */
    public final float getAccuracy() {
        return this.accuracy;
    }

    @NotNull
    /* renamed from: component4, reason: from getter */
    public final String getAddress() {
        return this.address;
    }

    @Nullable
    /* renamed from: component5, reason: from getter */
    public final String getCountry() {
        return this.country;
    }

    @Nullable
    /* renamed from: component6, reason: from getter */
    public final String getProvince() {
        return this.province;
    }

    @Nullable
    /* renamed from: component7, reason: from getter */
    public final String getCity() {
        return this.city;
    }

    @Nullable
    /* renamed from: component8, reason: from getter */
    public final String getDistrict() {
        return this.district;
    }

    @Nullable
    /* renamed from: component9, reason: from getter */
    public final String getStreet() {
        return this.street;
    }

    @NotNull
    public final LocationInfo copy(float longitude, float latitude, float accuracy, @NotNull String address, @Nullable String country, @Nullable String province, @Nullable String city, @Nullable String district, @Nullable String street, @Nullable String streetNum, @Nullable String cityCode, @Nullable String adCode, @Nullable String aoiName, @Nullable String buildingId, @Nullable String floor) {
        Intrinsics.checkNotNullParameter(address, "address");
        return new LocationInfo(longitude, latitude, accuracy, address, country, province, city, district, street, streetNum, cityCode, adCode, aoiName, buildingId, floor);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof LocationInfo)) {
            return false;
        }
        LocationInfo locationInfo = (LocationInfo) other;
        return Float.compare(this.longitude, locationInfo.longitude) == 0 && Float.compare(this.latitude, locationInfo.latitude) == 0 && Float.compare(this.accuracy, locationInfo.accuracy) == 0 && Intrinsics.areEqual(this.address, locationInfo.address) && Intrinsics.areEqual(this.country, locationInfo.country) && Intrinsics.areEqual(this.province, locationInfo.province) && Intrinsics.areEqual(this.city, locationInfo.city) && Intrinsics.areEqual(this.district, locationInfo.district) && Intrinsics.areEqual(this.street, locationInfo.street) && Intrinsics.areEqual(this.streetNum, locationInfo.streetNum) && Intrinsics.areEqual(this.cityCode, locationInfo.cityCode) && Intrinsics.areEqual(this.adCode, locationInfo.adCode) && Intrinsics.areEqual(this.aoiName, locationInfo.aoiName) && Intrinsics.areEqual(this.buildingId, locationInfo.buildingId) && Intrinsics.areEqual(this.floor, locationInfo.floor);
    }

    public final float getAccuracy() {
        return this.accuracy;
    }

    @Nullable
    public final String getAdCode() {
        return this.adCode;
    }

    @NotNull
    public final String getAddress() {
        return this.address;
    }

    @Nullable
    public final String getAoiName() {
        return this.aoiName;
    }

    @Nullable
    public final String getBuildingId() {
        return this.buildingId;
    }

    @Nullable
    public final String getCity() {
        return this.city;
    }

    @Nullable
    public final String getCityCode() {
        return this.cityCode;
    }

    @Nullable
    public final String getCountry() {
        return this.country;
    }

    @Nullable
    public final String getDistrict() {
        return this.district;
    }

    @Nullable
    public final String getFloor() {
        return this.floor;
    }

    public final float getLatitude() {
        return this.latitude;
    }

    public final float getLongitude() {
        return this.longitude;
    }

    @Nullable
    public final String getProvince() {
        return this.province;
    }

    @Nullable
    public final String getStreet() {
        return this.street;
    }

    @Nullable
    public final String getStreetNum() {
        return this.streetNum;
    }

    public int hashCode() {
        int iD = AbstractC0351g.d(this.address, (Float.hashCode(this.accuracy) + ((Float.hashCode(this.latitude) + (Float.hashCode(this.longitude) * 31)) * 31)) * 31, 31);
        String str = this.country;
        int iHashCode = (iD + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.province;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.city;
        int iHashCode3 = (iHashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.district;
        int iHashCode4 = (iHashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.street;
        int iHashCode5 = (iHashCode4 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.streetNum;
        int iHashCode6 = (iHashCode5 + (str6 == null ? 0 : str6.hashCode())) * 31;
        String str7 = this.cityCode;
        int iHashCode7 = (iHashCode6 + (str7 == null ? 0 : str7.hashCode())) * 31;
        String str8 = this.adCode;
        int iHashCode8 = (iHashCode7 + (str8 == null ? 0 : str8.hashCode())) * 31;
        String str9 = this.aoiName;
        int iHashCode9 = (iHashCode8 + (str9 == null ? 0 : str9.hashCode())) * 31;
        String str10 = this.buildingId;
        int iHashCode10 = (iHashCode9 + (str10 == null ? 0 : str10.hashCode())) * 31;
        String str11 = this.floor;
        return iHashCode10 + (str11 != null ? str11.hashCode() : 0);
    }

    public final void setAccuracy(float f4) {
        this.accuracy = f4;
    }

    public final void setAdCode(@Nullable String str) {
        this.adCode = str;
    }

    public final void setAddress(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.address = str;
    }

    public final void setAoiName(@Nullable String str) {
        this.aoiName = str;
    }

    public final void setBuildingId(@Nullable String str) {
        this.buildingId = str;
    }

    public final void setCity(@Nullable String str) {
        this.city = str;
    }

    public final void setCityCode(@Nullable String str) {
        this.cityCode = str;
    }

    public final void setCountry(@Nullable String str) {
        this.country = str;
    }

    public final void setDistrict(@Nullable String str) {
        this.district = str;
    }

    public final void setFloor(@Nullable String str) {
        this.floor = str;
    }

    public final void setLatitude(float f4) {
        this.latitude = f4;
    }

    public final void setLongitude(float f4) {
        this.longitude = f4;
    }

    public final void setProvince(@Nullable String str) {
        this.province = str;
    }

    public final void setStreet(@Nullable String str) {
        this.street = str;
    }

    public final void setStreetNum(@Nullable String str) {
        this.streetNum = str;
    }

    @NotNull
    public String toString() {
        float f4 = this.longitude;
        float f5 = this.latitude;
        float f6 = this.accuracy;
        String str = this.address;
        String str2 = this.country;
        String str3 = this.province;
        String str4 = this.city;
        String str5 = this.district;
        String str6 = this.street;
        String str7 = this.streetNum;
        String str8 = this.cityCode;
        String str9 = this.adCode;
        String str10 = this.aoiName;
        String str11 = this.buildingId;
        String str12 = this.floor;
        StringBuilder sb = new StringBuilder("LocationInfo(longitude=");
        sb.append(f4);
        sb.append(", latitude=");
        sb.append(f5);
        sb.append(", accuracy=");
        sb.append(f6);
        sb.append(", address=");
        sb.append(str);
        sb.append(", country=");
        AbstractC0351g.C(sb, str2, ", province=", str3, ", city=");
        AbstractC0351g.C(sb, str4, ", district=", str5, ", street=");
        AbstractC0351g.C(sb, str6, ", streetNum=", str7, ", cityCode=");
        AbstractC0351g.C(sb, str8, ", adCode=", str9, ", aoiName=");
        AbstractC0351g.C(sb, str10, ", buildingId=", str11, ", floor=");
        return g.r(sb, str12, ")");
    }

    public LocationInfo() {
        this(Property.DEFAULT_FLOAT_VALUE, Property.DEFAULT_FLOAT_VALUE, Property.DEFAULT_FLOAT_VALUE, "", "", "", "", "", "", "", "", "", "", "", "");
    }
}
