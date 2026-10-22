package com.baidu.mapapi.search.geocode;

import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.search.core.PoiInfo;
import com.baidu.mapapi.search.core.SearchResult;
import java.util.List;

/* loaded from: classes.dex */
public class ReverseGeoCodeResult extends SearchResult {
    public static final Parcelable.Creator<ReverseGeoCodeResult> CREATOR = new a();

    /* renamed from: a, reason: collision with root package name */
    private String f7377a;

    /* renamed from: b, reason: collision with root package name */
    private String f7378b;

    /* renamed from: c, reason: collision with root package name */
    private AddressComponent f7379c;

    /* renamed from: d, reason: collision with root package name */
    private LatLng f7380d;

    /* renamed from: e, reason: collision with root package name */
    private int f7381e;

    /* renamed from: f, reason: collision with root package name */
    private List<PoiInfo> f7382f;

    /* renamed from: g, reason: collision with root package name */
    private String f7383g;

    /* renamed from: h, reason: collision with root package name */
    private String f7384h;

    /* renamed from: i, reason: collision with root package name */
    private List<PoiRegionsInfo> f7385i;

    /* renamed from: j, reason: collision with root package name */
    private List<RoadInfo> f7386j;

    /* renamed from: k, reason: collision with root package name */
    private int f7387k;

    public static class AddressComponent implements Parcelable {
        public static final Parcelable.Creator<AddressComponent> CREATOR = new a();
        public int adcode;
        public String city;
        public int cityLevel;
        public int countryCode;
        public String countryCodeIso;
        public String countryCodeIso2;
        public String countryName;
        public String direction;
        public String distance;
        public String district;
        public String province;
        public String street;
        public String streetNumber;
        public String town;
        public String townCode;

        public static class a implements Parcelable.Creator<AddressComponent> {
            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public AddressComponent createFromParcel(Parcel parcel) {
                return new AddressComponent(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public AddressComponent[] newArray(int i4) {
                return new AddressComponent[i4];
            }
        }

        public AddressComponent() {
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public String getDirection() {
            return this.direction;
        }

        public String getDistance() {
            return this.distance;
        }

        public String getTown() {
            return this.town;
        }

        public void setDirection(String str) {
            this.direction = str;
        }

        public void setDistance(String str) {
            this.distance = str;
        }

        public void setTown(String str) {
            this.town = str;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i4) {
            parcel.writeString(this.streetNumber);
            parcel.writeString(this.street);
            parcel.writeString(this.town);
            parcel.writeString(this.district);
            parcel.writeString(this.city);
            parcel.writeString(this.province);
            parcel.writeString(this.countryName);
            parcel.writeInt(this.countryCode);
            parcel.writeInt(this.adcode);
            parcel.writeString(this.direction);
            parcel.writeString(this.distance);
            parcel.writeString(this.countryCodeIso);
            parcel.writeString(this.countryCodeIso2);
            parcel.writeString(this.townCode);
            parcel.writeInt(this.cityLevel);
        }

        public AddressComponent(Parcel parcel) {
            this.streetNumber = parcel.readString();
            this.street = parcel.readString();
            this.town = parcel.readString();
            this.district = parcel.readString();
            this.city = parcel.readString();
            this.province = parcel.readString();
            this.countryName = parcel.readString();
            this.countryCode = parcel.readInt();
            this.adcode = parcel.readInt();
            this.direction = parcel.readString();
            this.distance = parcel.readString();
            this.countryCodeIso = parcel.readString();
            this.countryCodeIso2 = parcel.readString();
            this.townCode = parcel.readString();
            this.cityLevel = parcel.readInt();
        }
    }

    public static class PoiRegionsInfo implements Parcelable {
        public static final Parcelable.Creator<PoiRegionsInfo> CREATOR = new a();
        public String directionDesc;
        public String regionName;
        public String regionTag;

        public static class a implements Parcelable.Creator<PoiRegionsInfo> {
            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public PoiRegionsInfo createFromParcel(Parcel parcel) {
                return new PoiRegionsInfo(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public PoiRegionsInfo[] newArray(int i4) {
                return new PoiRegionsInfo[i4];
            }
        }

        public PoiRegionsInfo() {
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public String getDirectionDesc() {
            return this.directionDesc;
        }

        public String getRegionName() {
            return this.regionName;
        }

        public String getRegionTag() {
            return this.regionTag;
        }

        public void setDirectionDesc(String str) {
            this.directionDesc = str;
        }

        public void setRegionName(String str) {
            this.regionName = str;
        }

        public void setRegionTag(String str) {
            this.regionTag = str;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i4) {
            parcel.writeString(this.directionDesc);
            parcel.writeString(this.regionName);
            parcel.writeString(this.regionTag);
        }

        public PoiRegionsInfo(Parcel parcel) {
            this.directionDesc = parcel.readString();
            this.regionName = parcel.readString();
            this.regionTag = parcel.readString();
        }
    }

    public static class RoadInfo implements Parcelable {
        public static final Parcelable.Creator<RoadInfo> CREATOR = new a();
        public String distance;
        public String name;

        public static class a implements Parcelable.Creator<RoadInfo> {
            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public RoadInfo createFromParcel(Parcel parcel) {
                return new RoadInfo(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public RoadInfo[] newArray(int i4) {
                return new RoadInfo[i4];
            }
        }

        public RoadInfo() {
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i4) {
            parcel.writeString(this.name);
            parcel.writeString(this.distance);
        }

        public RoadInfo(Parcel parcel) {
            this.name = parcel.readString();
            this.distance = parcel.readString();
        }
    }

    public static class a implements Parcelable.Creator<ReverseGeoCodeResult> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public ReverseGeoCodeResult createFromParcel(Parcel parcel) {
            return new ReverseGeoCodeResult(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public ReverseGeoCodeResult[] newArray(int i4) {
            return new ReverseGeoCodeResult[i4];
        }
    }

    public ReverseGeoCodeResult() {
    }

    @Override // com.baidu.mapapi.search.core.SearchResult, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getAdcode() {
        return this.f7387k;
    }

    public String getAddress() {
        return this.f7378b;
    }

    public AddressComponent getAddressDetail() {
        return this.f7379c;
    }

    public String getBusinessCircle() {
        return this.f7377a;
    }

    public int getCityCode() {
        return this.f7381e;
    }

    public String getFormattedPoiAddress() {
        return this.f7384h;
    }

    public LatLng getLocation() {
        return this.f7380d;
    }

    public List<PoiInfo> getPoiList() {
        return this.f7382f;
    }

    public List<PoiRegionsInfo> getPoiRegionsInfoList() {
        return this.f7385i;
    }

    public List<RoadInfo> getRoadInfoList() {
        return this.f7386j;
    }

    public String getSematicDescription() {
        return this.f7383g;
    }

    public void setAdcode(int i4) {
        this.f7387k = i4;
    }

    public void setAddress(String str) {
        this.f7378b = str;
    }

    public void setAddressDetail(AddressComponent addressComponent) {
        this.f7379c = addressComponent;
    }

    public void setBusinessCircle(String str) {
        this.f7377a = str;
    }

    public void setCityCode(int i4) {
        this.f7381e = i4;
    }

    public void setFormattedPoiAddress(String str) {
        this.f7384h = str;
    }

    public void setLocation(LatLng latLng) {
        this.f7380d = latLng;
    }

    public void setPoiList(List<PoiInfo> list) {
        this.f7382f = list;
    }

    public void setPoiRegionsInfoList(List<PoiRegionsInfo> list) {
        this.f7385i = list;
    }

    public void setRoadInfoList(List<RoadInfo> list) {
        this.f7386j = list;
    }

    public void setSematicDescription(String str) {
        this.f7383g = str;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer("ReverseGeoCodeResult: \nbusinessCircle = ");
        stringBuffer.append(this.f7377a);
        stringBuffer.append("; address = ");
        stringBuffer.append(this.f7378b);
        stringBuffer.append("; location = ");
        stringBuffer.append(this.f7380d);
        stringBuffer.append("; sematicDescription = ");
        stringBuffer.append(this.f7383g);
        stringBuffer.append("; formattedPoiAddress = ");
        stringBuffer.append(this.f7384h);
        if (this.f7379c != null) {
            stringBuffer.append("\n#AddressComponent Info BEGIN# \nstreetNumber = ");
            stringBuffer.append(this.f7379c.streetNumber);
            stringBuffer.append("; street = ");
            stringBuffer.append(this.f7379c.street);
            stringBuffer.append("; town = ");
            stringBuffer.append(this.f7379c.town);
            stringBuffer.append("; district = ");
            stringBuffer.append(this.f7379c.district);
            stringBuffer.append("; city = ");
            stringBuffer.append(this.f7379c.city);
            stringBuffer.append("; province = ");
            stringBuffer.append(this.f7379c.province);
            stringBuffer.append("; countryName = ");
            stringBuffer.append(this.f7379c.countryName);
            stringBuffer.append("; countryCode = ");
            stringBuffer.append(this.f7379c.countryCode);
            stringBuffer.append("; adcode = ");
            stringBuffer.append(this.f7379c.adcode);
            stringBuffer.append("; direction = ");
            stringBuffer.append(this.f7379c.direction);
            stringBuffer.append("; distance = ");
            stringBuffer.append(this.f7379c.distance);
            stringBuffer.append("; countryCodeIso = ");
            stringBuffer.append(this.f7379c.countryCodeIso);
            stringBuffer.append("; countryCodeIso2 = ");
            stringBuffer.append(this.f7379c.countryCodeIso2);
            stringBuffer.append("; townCode = ");
            stringBuffer.append(this.f7379c.townCode);
            stringBuffer.append("; cityLevel = ");
            stringBuffer.append(this.f7379c.cityLevel);
            stringBuffer.append("\n#AddressComponent Info END# \n");
        }
        List<PoiRegionsInfo> list = this.f7385i;
        if (list != null && !list.isEmpty()) {
            stringBuffer.append("\n#PoiRegions Info  BEGIN#");
            for (int i4 = 0; i4 < this.f7385i.size(); i4++) {
                PoiRegionsInfo poiRegionsInfo = this.f7385i.get(i4);
                if (poiRegionsInfo != null) {
                    stringBuffer.append("\ndirectionDesc = ");
                    stringBuffer.append(poiRegionsInfo.getDirectionDesc());
                    stringBuffer.append("; regionName = ");
                    stringBuffer.append(poiRegionsInfo.getRegionName());
                    stringBuffer.append("; regionTag = ");
                    stringBuffer.append(poiRegionsInfo.getRegionTag());
                }
            }
            stringBuffer.append("\n#PoiRegions Info  END# \n");
        }
        List<PoiInfo> list2 = this.f7382f;
        if (list2 != null && !list2.isEmpty()) {
            stringBuffer.append("\n #PoiList Info  BEGIN#");
            for (int i5 = 0; i5 < this.f7382f.size(); i5++) {
                PoiInfo poiInfo = this.f7382f.get(i5);
                if (poiInfo != null) {
                    stringBuffer.append("\n address = ");
                    stringBuffer.append(poiInfo.getAddress());
                    stringBuffer.append("; phoneNumber = ");
                    stringBuffer.append(poiInfo.getPhoneNum());
                    stringBuffer.append("; uid = ");
                    stringBuffer.append(poiInfo.getUid());
                    stringBuffer.append("; postCode = ");
                    stringBuffer.append(poiInfo.getPostCode());
                    stringBuffer.append("; name = ");
                    stringBuffer.append(poiInfo.getName());
                    stringBuffer.append("; location = ");
                    stringBuffer.append(poiInfo.getLocation());
                    stringBuffer.append("; city = ");
                    stringBuffer.append(poiInfo.getCity());
                    stringBuffer.append("; direction = ");
                    stringBuffer.append(poiInfo.getDirection());
                    stringBuffer.append("; distance = ");
                    stringBuffer.append(poiInfo.getDistance());
                    if (poiInfo.getParentPoi() != null) {
                        stringBuffer.append("\n parentPoiAddress = ");
                        stringBuffer.append(poiInfo.getParentPoi().getParentPoiAddress());
                        stringBuffer.append("; parentPoiDirection = ");
                        stringBuffer.append(poiInfo.getParentPoi().getParentPoiDirection());
                        stringBuffer.append("; parentPoiDistance = ");
                        stringBuffer.append(poiInfo.getParentPoi().getParentPoiDistance());
                        stringBuffer.append("; parentPoiName = ");
                        stringBuffer.append(poiInfo.getParentPoi().getParentPoiName());
                        stringBuffer.append("; parentPoiTag = ");
                        stringBuffer.append(poiInfo.getParentPoi().getParentPoiTag());
                        stringBuffer.append("; parentPoiUid = ");
                        stringBuffer.append(poiInfo.getParentPoi().getParentPoiUid());
                        stringBuffer.append("; parentPoiLocation = ");
                        stringBuffer.append(poiInfo.getParentPoi().getParentPoiLocation());
                    }
                }
            }
            stringBuffer.append("\n #PoiList Info  END# \n");
        }
        List<RoadInfo> list3 = this.f7386j;
        if (list3 != null && !list3.isEmpty()) {
            stringBuffer.append("\n #RoadInfoList Info  BEGIN#");
            for (int i6 = 0; i6 < this.f7386j.size(); i6++) {
                RoadInfo roadInfo = this.f7386j.get(i6);
                if (roadInfo != null) {
                    stringBuffer.append("; name = ");
                    stringBuffer.append(roadInfo.name);
                    stringBuffer.append("; distance = ");
                    stringBuffer.append(roadInfo.distance);
                }
            }
            stringBuffer.append("\n #RoadInfoList Info  END# \n");
        }
        return stringBuffer.toString();
    }

    @Override // com.baidu.mapapi.search.core.SearchResult, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        super.writeToParcel(parcel, i4);
        parcel.writeString(this.f7377a);
        parcel.writeString(this.f7378b);
        parcel.writeParcelable(this.f7379c, 0);
        parcel.writeValue(this.f7380d);
        parcel.writeTypedList(this.f7382f);
        parcel.writeString(this.f7383g);
        parcel.writeString(this.f7384h);
        parcel.writeTypedList(this.f7385i);
        parcel.writeTypedList(this.f7386j);
    }

    public ReverseGeoCodeResult(Parcel parcel) {
        super(parcel);
        this.f7377a = parcel.readString();
        this.f7378b = parcel.readString();
        this.f7379c = (AddressComponent) parcel.readParcelable(AddressComponent.class.getClassLoader());
        this.f7380d = (LatLng) parcel.readValue(LatLng.class.getClassLoader());
        this.f7382f = parcel.createTypedArrayList(PoiInfo.CREATOR);
        this.f7383g = parcel.readString();
        this.f7384h = parcel.readString();
        this.f7385i = parcel.createTypedArrayList(PoiRegionsInfo.CREATOR);
        this.f7386j = parcel.createTypedArrayList(RoadInfo.CREATOR);
    }
}
