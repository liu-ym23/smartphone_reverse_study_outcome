package com.baidu.mapapi.search.core;

import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.mapapi.model.LatLng;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class PoiDetailInfo implements Parcelable {
    public static final Parcelable.Creator<PoiDetailInfo> CREATOR = new a();

    /* renamed from: a, reason: collision with root package name */
    private String f7290a;

    /* renamed from: b, reason: collision with root package name */
    private LatLng f7291b;
    public String brand;

    /* renamed from: c, reason: collision with root package name */
    private String f7292c;
    public int checkinNum;
    public int commentNum;

    /* renamed from: d, reason: collision with root package name */
    private String f7293d;
    public String detailUrl;
    public int discountNum;
    public int distance;

    /* renamed from: e, reason: collision with root package name */
    private String f7294e;
    public double environmentRating;

    /* renamed from: f, reason: collision with root package name */
    private String f7295f;
    public double facilityRating;
    public int favoriteNum;

    /* renamed from: g, reason: collision with root package name */
    private int f7296g;
    public int grouponNum;

    /* renamed from: h, reason: collision with root package name */
    private String f7297h;
    public double hygieneRating;

    /* renamed from: i, reason: collision with root package name */
    private String f7298i;
    public String image;
    public int imageNum;

    /* renamed from: j, reason: collision with root package name */
    private String f7299j;

    /* renamed from: k, reason: collision with root package name */
    private int f7300k;

    /* renamed from: l, reason: collision with root package name */
    private List<PoiChildrenInfo> f7301l;

    /* renamed from: m, reason: collision with root package name */
    private List<String> f7302m;

    /* renamed from: n, reason: collision with root package name */
    private String f7303n;
    public LatLng naviLocation;
    public double overallRating;
    public double price;
    public double serviceRating;
    public String shopHours;
    public String tag;
    public double tasteRating;
    public double technologyRating;
    public String type;

    public static class a implements Parcelable.Creator<PoiDetailInfo> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public PoiDetailInfo createFromParcel(Parcel parcel) {
            return new PoiDetailInfo(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public PoiDetailInfo[] newArray(int i4) {
            return new PoiDetailInfo[i4];
        }
    }

    public PoiDetailInfo() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getAdCode() {
        return this.f7296g;
    }

    public String getAddress() {
        return this.f7292c;
    }

    public String getArea() {
        return this.f7295f;
    }

    public String getBrand() {
        return this.brand;
    }

    public int getCheckinNum() {
        return this.checkinNum;
    }

    public String getCity() {
        return this.f7294e;
    }

    public int getCommentNum() {
        return this.commentNum;
    }

    public int getDetail() {
        return this.f7300k;
    }

    public String getDetailUrl() {
        return this.detailUrl;
    }

    public int getDiscountNum() {
        return this.discountNum;
    }

    public int getDistance() {
        return this.distance;
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

    public String getImage() {
        return this.image;
    }

    public int getImageNum() {
        return this.imageNum;
    }

    public String getLabel() {
        return this.f7303n;
    }

    public LatLng getLocation() {
        return this.f7291b;
    }

    public String getName() {
        return this.f7290a;
    }

    public LatLng getNaviLocation() {
        return this.naviLocation;
    }

    public double getOverallRating() {
        return this.overallRating;
    }

    public List<String> getPhotos() {
        return this.f7302m;
    }

    public List<PoiChildrenInfo> getPoiChildrenInfoList() {
        return this.f7301l;
    }

    public double getPrice() {
        return this.price;
    }

    public String getProvince() {
        return this.f7293d;
    }

    public double getServiceRating() {
        return this.serviceRating;
    }

    public String getShopHours() {
        return this.shopHours;
    }

    public String getStreetId() {
        return this.f7299j;
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
        return this.f7297h;
    }

    public String getType() {
        return this.type;
    }

    public String getUid() {
        return this.f7298i;
    }

    public void setAdCode(int i4) {
        this.f7296g = i4;
    }

    public void setAddress(String str) {
        this.f7292c = str;
    }

    public void setArea(String str) {
        this.f7295f = str;
    }

    public void setBrand(String str) {
        this.brand = str;
    }

    public void setCheckinNum(int i4) {
        this.checkinNum = i4;
    }

    public void setCity(String str) {
        this.f7294e = str;
    }

    public void setCommentNum(int i4) {
        this.commentNum = i4;
    }

    public void setDetail(String str) {
        try {
            this.f7300k = Integer.parseInt(str);
        } catch (NumberFormatException unused) {
            this.f7300k = 0;
        }
    }

    public void setDetailUrl(String str) {
        this.detailUrl = str;
    }

    public void setDiscountNum(int i4) {
        this.discountNum = i4;
    }

    public void setDistance(int i4) {
        this.distance = i4;
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

    public void setImage(String str) {
        this.image = str;
    }

    public void setImageNum(int i4) {
        this.imageNum = i4;
    }

    public void setLabel(String str) {
        this.f7303n = str;
    }

    public void setLocation(LatLng latLng) {
        this.f7291b = latLng;
    }

    public void setName(String str) {
        this.f7290a = str;
    }

    public void setNaviLocation(LatLng latLng) {
        this.naviLocation = latLng;
    }

    public void setOverallRating(double d4) {
        this.overallRating = d4;
    }

    public void setPhotos(List<String> list) {
        this.f7302m = list;
    }

    public void setPoiChildrenInfoList(List<PoiChildrenInfo> list) {
        this.f7301l = list;
    }

    public void setPrice(double d4) {
        this.price = d4;
    }

    public void setProvince(String str) {
        this.f7293d = str;
    }

    public void setServiceRating(double d4) {
        this.serviceRating = d4;
    }

    public void setShopHours(String str) {
        this.shopHours = str;
    }

    public void setStreetId(String str) {
        this.f7299j = str;
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
        this.f7297h = str;
    }

    public void setType(String str) {
        this.type = str;
    }

    public void setUid(String str) {
        this.f7298i = str;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer("PoiDetailInfo: name = ");
        stringBuffer.append(this.f7290a);
        stringBuffer.append("; location = ");
        LatLng latLng = this.f7291b;
        if (latLng != null) {
            stringBuffer.append(latLng.toString());
        } else {
            stringBuffer.append("null");
        }
        stringBuffer.append("; address = ");
        stringBuffer.append(this.f7292c);
        stringBuffer.append("; province = ");
        stringBuffer.append(this.f7293d);
        stringBuffer.append("; city = ");
        stringBuffer.append(this.f7294e);
        stringBuffer.append("; area = ");
        stringBuffer.append(this.f7295f);
        stringBuffer.append("; telephone = ");
        stringBuffer.append(this.f7297h);
        stringBuffer.append("; uid = ");
        stringBuffer.append(this.f7298i);
        stringBuffer.append("; detail = ");
        stringBuffer.append(this.f7300k);
        stringBuffer.append("; distance = ");
        stringBuffer.append(this.distance);
        stringBuffer.append("; type = ");
        stringBuffer.append(this.type);
        stringBuffer.append("; tag = ");
        stringBuffer.append(this.tag);
        stringBuffer.append("; naviLocation = ");
        LatLng latLng2 = this.naviLocation;
        if (latLng2 != null) {
            stringBuffer.append(latLng2.toString());
        } else {
            stringBuffer.append("null");
        }
        stringBuffer.append("; detailUrl = ");
        stringBuffer.append(this.detailUrl);
        stringBuffer.append("; price = ");
        stringBuffer.append(this.price);
        stringBuffer.append("; shopHours = ");
        stringBuffer.append(this.shopHours);
        stringBuffer.append("; overallRating = ");
        stringBuffer.append(this.overallRating);
        stringBuffer.append("; tasteRating = ");
        stringBuffer.append(this.tasteRating);
        stringBuffer.append("; serviceRating = ");
        stringBuffer.append(this.serviceRating);
        stringBuffer.append("; environmentRating = ");
        stringBuffer.append(this.environmentRating);
        stringBuffer.append("; facilityRating = ");
        stringBuffer.append(this.facilityRating);
        stringBuffer.append("; hygieneRating = ");
        stringBuffer.append(this.hygieneRating);
        stringBuffer.append("; technologyRating = ");
        stringBuffer.append(this.technologyRating);
        stringBuffer.append("; imageNum = ");
        stringBuffer.append(this.imageNum);
        stringBuffer.append("; grouponNum = ");
        stringBuffer.append(this.grouponNum);
        stringBuffer.append("; discountNum = ");
        stringBuffer.append(this.discountNum);
        stringBuffer.append("; commentNum = ");
        stringBuffer.append(this.commentNum);
        stringBuffer.append("; favoriteNum = ");
        stringBuffer.append(this.favoriteNum);
        stringBuffer.append("; checkinNum = ");
        stringBuffer.append(this.checkinNum);
        stringBuffer.append("; label = ");
        stringBuffer.append(this.f7303n);
        List<PoiChildrenInfo> list = this.f7301l;
        if (list != null && !list.isEmpty()) {
            for (int i4 = 0; i4 < this.f7301l.size(); i4++) {
                stringBuffer.append("; The ");
                stringBuffer.append(i4);
                stringBuffer.append(" poiChildrenInfo is: ");
                PoiChildrenInfo poiChildrenInfo = this.f7301l.get(i4);
                if (poiChildrenInfo != null) {
                    stringBuffer.append(poiChildrenInfo.toString());
                } else {
                    stringBuffer.append("null");
                }
            }
        }
        return stringBuffer.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        parcel.writeString(this.f7290a);
        parcel.writeParcelable(this.f7291b, i4);
        parcel.writeString(this.f7292c);
        parcel.writeString(this.f7293d);
        parcel.writeString(this.f7294e);
        parcel.writeString(this.f7295f);
        parcel.writeString(this.f7297h);
        parcel.writeString(this.f7298i);
        parcel.writeString(this.f7299j);
        parcel.writeInt(this.f7300k);
        parcel.writeInt(this.distance);
        parcel.writeString(this.type);
        parcel.writeString(this.tag);
        parcel.writeParcelable(this.naviLocation, i4);
        parcel.writeString(this.detailUrl);
        parcel.writeDouble(this.price);
        parcel.writeString(this.shopHours);
        parcel.writeDouble(this.overallRating);
        parcel.writeDouble(this.tasteRating);
        parcel.writeDouble(this.serviceRating);
        parcel.writeDouble(this.environmentRating);
        parcel.writeDouble(this.facilityRating);
        parcel.writeDouble(this.hygieneRating);
        parcel.writeDouble(this.technologyRating);
        parcel.writeInt(this.imageNum);
        parcel.writeString(this.image);
        parcel.writeInt(this.grouponNum);
        parcel.writeInt(this.discountNum);
        parcel.writeInt(this.commentNum);
        parcel.writeInt(this.favoriteNum);
        parcel.writeInt(this.checkinNum);
        parcel.writeString(this.f7303n);
        parcel.writeTypedList(this.f7301l);
        parcel.writeStringList(this.f7302m);
        parcel.writeString(this.brand);
        parcel.writeString(this.f7303n);
    }

    public PoiDetailInfo(Parcel parcel) {
        this.f7290a = parcel.readString();
        this.f7291b = (LatLng) parcel.readParcelable(LatLng.class.getClassLoader());
        this.f7292c = parcel.readString();
        this.f7293d = parcel.readString();
        this.f7294e = parcel.readString();
        this.f7295f = parcel.readString();
        this.f7297h = parcel.readString();
        this.f7298i = parcel.readString();
        this.f7299j = parcel.readString();
        this.f7300k = parcel.readInt();
        this.distance = parcel.readInt();
        this.type = parcel.readString();
        this.tag = parcel.readString();
        this.naviLocation = (LatLng) parcel.readParcelable(LatLng.class.getClassLoader());
        this.detailUrl = parcel.readString();
        this.price = parcel.readDouble();
        this.shopHours = parcel.readString();
        this.overallRating = parcel.readDouble();
        this.tasteRating = parcel.readDouble();
        this.serviceRating = parcel.readDouble();
        this.environmentRating = parcel.readDouble();
        this.facilityRating = parcel.readDouble();
        this.hygieneRating = parcel.readDouble();
        this.technologyRating = parcel.readDouble();
        this.imageNum = parcel.readInt();
        this.image = parcel.readString();
        this.grouponNum = parcel.readInt();
        this.discountNum = parcel.readInt();
        this.commentNum = parcel.readInt();
        this.favoriteNum = parcel.readInt();
        this.checkinNum = parcel.readInt();
        this.f7303n = parcel.readString();
        this.f7301l = parcel.createTypedArrayList(PoiChildrenInfo.CREATOR);
        ArrayList arrayList = new ArrayList();
        this.f7302m = arrayList;
        parcel.readStringList(arrayList);
        this.brand = parcel.readString();
        this.f7303n = parcel.readString();
    }
}
