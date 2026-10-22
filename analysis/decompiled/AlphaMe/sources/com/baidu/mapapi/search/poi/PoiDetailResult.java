package com.baidu.mapapi.search.poi;

import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.search.core.SearchResult;

/* loaded from: classes.dex */
public class PoiDetailResult extends SearchResult implements Parcelable {
    public static final Parcelable.Creator<PoiDetailResult> CREATOR = new a();
    public String address;
    public int checkinNum;
    public int commentNum;
    public String detailUrl;
    public int discountNum;
    public double environmentRating;
    public double facilityRating;
    public int favoriteNum;
    public int grouponNum;
    public double hygieneRating;
    public int imageNum;
    public LatLng location;
    public String name;
    public double overallRating;
    public double price;
    public double serviceRating;
    public String shopHours;
    public String tag;
    public double tasteRating;
    public double technologyRating;
    public String telephone;
    public String type;
    public String uid;

    public static class a implements Parcelable.Creator<PoiDetailResult> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public PoiDetailResult createFromParcel(Parcel parcel) {
            return new PoiDetailResult(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public PoiDetailResult[] newArray(int i4) {
            return new PoiDetailResult[i4];
        }
    }

    public PoiDetailResult() {
    }

    @Override // com.baidu.mapapi.search.core.SearchResult, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getAddress() {
        return this.address;
    }

    public int getCheckinNum() {
        return this.checkinNum;
    }

    public int getCommentNum() {
        return this.commentNum;
    }

    public String getDetailUrl() {
        return this.detailUrl;
    }

    public int getDiscountNum() {
        return this.discountNum;
    }

    public double getEnvironmentRating() {
        return this.environmentRating;
    }

    public double getFacilityRating() {
        return this.facilityRating;
    }

    public int getFavoriteNum() {
        return this.favoriteNum;
    }

    public int getGrouponNum() {
        return this.grouponNum;
    }

    public double getHygieneRating() {
        return this.hygieneRating;
    }

    public int getImageNum() {
        return this.imageNum;
    }

    public LatLng getLocation() {
        return this.location;
    }

    public String getName() {
        return this.name;
    }

    public double getOverallRating() {
        return this.overallRating;
    }

    public double getPrice() {
        return this.price;
    }

    public double getServiceRating() {
        return this.serviceRating;
    }

    public String getShopHours() {
        return this.shopHours;
    }

    public String getTag() {
        return this.tag;
    }

    public double getTasteRating() {
        return this.tasteRating;
    }

    public double getTechnologyRating() {
        return this.technologyRating;
    }

    public String getTelephone() {
        return this.telephone;
    }

    public String getType() {
        return this.type;
    }

    public String getUid() {
        return this.uid;
    }

    public void setAddress(String str) {
        this.address = str;
    }

    public void setCheckinNum(int i4) {
        this.checkinNum = i4;
    }

    public void setCommentNum(int i4) {
        this.commentNum = i4;
    }

    public void setDetailUrl(String str) {
        this.detailUrl = str;
    }

    public void setDiscountNum(int i4) {
        this.discountNum = i4;
    }

    public void setEnvironmentRating(double d4) {
        this.environmentRating = d4;
    }

    public void setFacilityRating(double d4) {
        this.facilityRating = d4;
    }

    public void setFavoriteNum(int i4) {
        this.favoriteNum = i4;
    }

    public void setGrouponNum(int i4) {
        this.grouponNum = i4;
    }

    public void setHygieneRating(double d4) {
        this.hygieneRating = d4;
    }

    public void setImageNum(int i4) {
        this.imageNum = i4;
    }

    public void setLocation(LatLng latLng) {
        this.location = latLng;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setOverallRating(double d4) {
        this.overallRating = d4;
    }

    public void setPrice(double d4) {
        this.price = d4;
    }

    public void setServiceRating(double d4) {
        this.serviceRating = d4;
    }

    public void setShopHours(String str) {
        this.shopHours = str;
    }

    public void setTag(String str) {
        this.tag = str;
    }

    public void setTasteRating(double d4) {
        this.tasteRating = d4;
    }

    public void setTechnologyRating(double d4) {
        this.technologyRating = d4;
    }

    public void setTelephone(String str) {
        this.telephone = str;
    }

    public void setType(String str) {
        this.type = str;
    }

    public void setUid(String str) {
        this.uid = str;
    }

    @Override // com.baidu.mapapi.search.core.SearchResult, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        super.writeToParcel(parcel, i4);
        parcel.writeString(this.name);
        parcel.writeParcelable(this.location, i4);
        parcel.writeString(this.address);
        parcel.writeString(this.telephone);
        parcel.writeString(this.uid);
        parcel.writeString(this.tag);
        parcel.writeString(this.detailUrl);
        parcel.writeString(this.type);
        parcel.writeDouble(this.price);
        parcel.writeDouble(this.overallRating);
        parcel.writeDouble(this.tasteRating);
        parcel.writeDouble(this.serviceRating);
        parcel.writeDouble(this.environmentRating);
        parcel.writeDouble(this.facilityRating);
        parcel.writeDouble(this.hygieneRating);
        parcel.writeDouble(this.technologyRating);
        parcel.writeInt(this.imageNum);
        parcel.writeInt(this.grouponNum);
        parcel.writeInt(this.commentNum);
        parcel.writeInt(this.discountNum);
        parcel.writeInt(this.favoriteNum);
        parcel.writeInt(this.checkinNum);
        parcel.writeString(this.shopHours);
    }

    public PoiDetailResult(SearchResult.ERRORNO errorno) {
        super(errorno);
    }

    public PoiDetailResult(Parcel parcel) {
        super(parcel);
        this.name = parcel.readString();
        this.location = (LatLng) parcel.readParcelable(LatLng.class.getClassLoader());
        this.address = parcel.readString();
        this.telephone = parcel.readString();
        this.uid = parcel.readString();
        this.tag = parcel.readString();
        this.detailUrl = parcel.readString();
        this.type = parcel.readString();
        this.price = parcel.readDouble();
        this.overallRating = parcel.readDouble();
        this.tasteRating = parcel.readDouble();
        this.serviceRating = parcel.readDouble();
        this.environmentRating = parcel.readDouble();
        this.facilityRating = parcel.readDouble();
        this.hygieneRating = parcel.readDouble();
        this.technologyRating = parcel.readDouble();
        this.imageNum = parcel.readInt();
        this.grouponNum = parcel.readInt();
        this.commentNum = parcel.readInt();
        this.discountNum = parcel.readInt();
        this.favoriteNum = parcel.readInt();
        this.checkinNum = parcel.readInt();
        this.shopHours = parcel.readString();
    }
}
