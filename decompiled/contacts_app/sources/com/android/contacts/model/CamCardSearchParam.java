package com.android.contacts.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;

/* JADX INFO: loaded from: classes2.dex */
public class CamCardSearchParam implements Parcelable {
    public static final Parcelable.Creator<CamCardSearchParam> CREATOR = null;
    private String company;
    private String email;
    private String jobTitle;
    private String name;
    private String phone;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    /* synthetic */ CamCardSearchParam(Parcel r1, AnonymousClass1 r2) {
        this(r1);
    }

    public CamCardSearchParam() {
        this.jobTitle = "";
        this.name = "";
        this.email = "";
        this.phone = "";
    }

    public String getCompany() {
        return this.company;
    }

    public void setCompany(String r1) {
        this.company = r1;
    }

    public String getJobTitle() {
        return this.jobTitle;
    }

    public void setJobTitle(String r1) {
        this.jobTitle = r1;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String r1) {
        this.name = r1;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String r1) {
        this.email = r1;
    }

    public String getPhone() {
        return this.phone;
    }

    public void setPhone(String r1) {
        this.phone = r1;
    }

    public boolean isValid() {
        if (TextUtils.isEmpty(this.company) == false) goto L5;
        return false;
    L5:
        if (this.jobTitle != null) goto L7;
        return false;
    L7:
        if (this.name != null) goto L9;
        return false;
    L9:
        if (this.email != null) goto L11;
        return false;
    L11:
        if (this.phone == null) goto L19;
        return true;
    L19:
        return false;
    }

    private CamCardSearchParam(Parcel r2) {
        this.company = r2.readString();
        this.jobTitle = r2.readString();
        this.name = r2.readString();
        this.email = r2.readString();
        this.phone = r2.readString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r1, int r2) {
        r1.writeString(this.company);
        r1.writeString(this.jobTitle);
        r1.writeString(this.name);
        r1.writeString(this.email);
        r1.writeString(this.phone);
    }

    static {
        CREATOR = new AnonymousClass1();
    }

    public String toString() {
        return "CamCardSearchParam{company='" + this.company + "', jobTitle='" + this.jobTitle + "', name='" + this.name + "', email='" + this.email + "', phone='" + this.phone + "'}";
    }
}
