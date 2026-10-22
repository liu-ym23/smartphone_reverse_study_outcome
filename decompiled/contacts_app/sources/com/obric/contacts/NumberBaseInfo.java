package com.obric.contacts;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.android.contacts.util.HanziToPinyin;

/* JADX INFO: loaded from: classes3.dex */
public class NumberBaseInfo implements Parcelable {
    public static final Parcelable.Creator<NumberBaseInfo> CREATOR = null;
    private static String sAreaHongkong = "香港";
    private static String sAreaMacao = "澳门";
    private static String sAreaTaiwan = "台湾";
    private static String sCountryChina = "中国";
    private String mArea;
    private String mCountry;
    private String mLogoUrl;
    private String mNumber;
    private String mOperator;
    private String mOrganizationName;

    public static class Builder {
        private NumberBaseInfo numberBaseInfo;

        public Builder() {
            this.numberBaseInfo = new NumberBaseInfo();
        }

        public Builder(String r2) {
            this.numberBaseInfo = new NumberBaseInfo(r2);
        }

        public NumberBaseInfo build() {
            return this.numberBaseInfo;
        }

        public Builder setNumber(String r2) {
            NumberBaseInfo.access$002(this.numberBaseInfo, r2);
            return this;
        }

        public Builder setCountry(String r2) {
            NumberBaseInfo.access$102(this.numberBaseInfo, r2);
            return this;
        }

        public Builder setArea(String r2) {
            NumberBaseInfo.access$202(this.numberBaseInfo, r2);
            return this;
        }

        public Builder setOperator(String r2) {
            NumberBaseInfo.access$302(this.numberBaseInfo, r2);
            return this;
        }

        public Builder setOrganizationName(String r2) {
            NumberBaseInfo.access$402(this.numberBaseInfo, r2);
            return this;
        }

        public Builder setLogoUrl(String r2) {
            NumberBaseInfo.access$502(this.numberBaseInfo, r2);
            return this;
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    static /* synthetic */ String access$002(NumberBaseInfo r0, String r1) {
        r0.mNumber = r1;
        return r1;
    }

    static /* synthetic */ String access$102(NumberBaseInfo r0, String r1) {
        r0.mCountry = r1;
        return r1;
    }

    static /* synthetic */ String access$202(NumberBaseInfo r0, String r1) {
        r0.mArea = r1;
        return r1;
    }

    static /* synthetic */ String access$302(NumberBaseInfo r0, String r1) {
        r0.mOperator = r1;
        return r1;
    }

    static /* synthetic */ String access$402(NumberBaseInfo r0, String r1) {
        r0.mOrganizationName = r1;
        return r1;
    }

    static /* synthetic */ String access$502(NumberBaseInfo r0, String r1) {
        r0.mLogoUrl = r1;
        return r1;
    }

    static {
        CREATOR = new AnonymousClass1();
    }

    public NumberBaseInfo() {
        this("");
    }

    public NumberBaseInfo(String r1) {
        this.mNumber = r1;
    }

    public NumberBaseInfo(Parcel r2) {
        this.mNumber = r2.readString();
        this.mCountry = r2.readString();
        this.mArea = r2.readString();
        this.mOperator = r2.readString();
        this.mOrganizationName = r2.readString();
        this.mLogoUrl = r2.readString();
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder("[number=");
        r0.append(this.mNumber).append(", country=").append(this.mCountry).append(", area=").append(this.mArea).append(", operator=").append(this.mOperator).append(", organizationName=").append(this.mOrganizationName).append(", logoUrl=").append(this.mLogoUrl).append("]");
        return r0.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r1, int r2) {
        r1.writeString(this.mNumber);
        r1.writeString(this.mCountry);
        r1.writeString(this.mArea);
        r1.writeString(this.mOperator);
        r1.writeString(this.mOrganizationName);
        r1.writeString(this.mLogoUrl);
    }

    public String getNumber() {
        String r0 = this.mNumber;
        if (r0 != null) goto L6;
        return "";
    L6:
        return r0;
    }

    public void setNumber(String r1) {
        this.mNumber = r1;
    }

    public String getCountry() {
        String r0 = this.mCountry;
        if (r0 != null) goto L6;
        return "";
    L6:
        return r0;
    }

    public void setCountry(String r1) {
        this.mCountry = r1;
    }

    public String getArea() {
        String r0 = this.mArea;
        if (r0 != null) goto L6;
        return "";
    L6:
        return r0;
    }

    public void setArea(String r1) {
        this.mArea = r1;
    }

    public String getOperator() {
        String r0 = this.mOperator;
        if (r0 != null) goto L6;
        return "";
    L6:
        return r0;
    }

    public void setOperator(String r1) {
        this.mOperator = r1;
    }

    public String getOrganizationName() {
        String r0 = this.mOrganizationName;
        if (r0 != null) goto L6;
        return "";
    L6:
        return r0;
    }

    public void setOrganizationName(String r1) {
        this.mOrganizationName = r1;
    }

    public String getLogoUrl() {
        String r0 = this.mLogoUrl;
        if (r0 != null) goto L6;
        return "";
    L6:
        return r0;
    }

    public void setLogoUrl(String r1) {
        this.mLogoUrl = r1;
    }

    public String getLocation() {
        String r1 = "";
        if (sAreaHongkong.equals(this.mArea) == false) goto L5;
    L12:
        String r0 = sCountryChina;
    L14:
        if (TextUtils.isEmpty(this.mArea) == false) goto L16;
        return r0;
    L16:
        if (TextUtils.isEmpty(r0) == true) goto L25;
        StringBuilder r2 = new StringBuilder().append(r0);
        if (sCountryChina.equals(r0) == true) goto L23;
        r1 = HanziToPinyin.Token.SEPARATOR;
    L23:
        return r2.append(r1).append(getArea()).toString();
    L25:
        return getArea();
    L5:
        if (sAreaMacao.equals(this.mArea) == true) goto L12;
        if (sAreaTaiwan.equals(this.mArea) == true) goto L12;
        if (sCountryChina.equals(this.mCountry) == true) goto L11;
        r0 = getCountry();
        goto L14
    L11:
        r0 = "";
        goto L14
    }
}
