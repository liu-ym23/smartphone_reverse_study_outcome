package com.bytedanceos.common.networkv2.entity;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes2.dex */
public class SubAppEntity implements BaseInfo {
    public static final Parcelable.Creator<SubAppEntity> CREATOR = null;
    public static final int STATUS_SUB = 0;
    public static final int STATUS_SUBED = 1;
    private String banner;
    private String category;
    private String child_cid;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    private String f9898id;
    private String logo;
    private String name;
    private String online_time;
    private String parent_cid;
    private int status;

    static {
        CREATOR = new AnonymousClass1();
    }

    public SubAppEntity() {
        this.f9898id = "";
        this.name = "";
        this.logo = "";
        this.banner = "";
        this.online_time = "";
        this.category = "";
        this.parent_cid = "";
        this.child_cid = "";
        this.status = 0;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getBanner() {
        return this.banner;
    }

    @Override // com.bytedanceos.common.networkv2.entity.BaseInfo
    public String getCategory() {
        return this.category;
    }

    public String getChild_cid() {
        return this.child_cid;
    }

    @Override // com.bytedanceos.common.networkv2.entity.BaseInfo
    public String getId() {
        return this.f9898id;
    }

    public String getLogo() {
        return this.logo;
    }

    @Override // com.bytedanceos.common.networkv2.entity.BaseInfo
    public String getName() {
        return this.name;
    }

    @Override // com.bytedanceos.common.networkv2.entity.BaseInfo
    public String getOnline_time() {
        return this.online_time;
    }

    public String getParent_cid() {
        return this.parent_cid;
    }

    public int getStatus() {
        return this.status;
    }

    public boolean isSubcribed() {
        if (this.status == 1) goto L7;
        return false;
    L7:
        return true;
    }

    public void setBanner(String r10) {
        this.banner = r10;
    }

    public void setCategory(String r10) {
        this.category = r10;
    }

    public void setChild_cid(String r10) {
        this.child_cid = r10;
    }

    public void setId(String r10) {
        this.f9898id = r10;
    }

    public void setLogo(String r10) {
        this.logo = r10;
    }

    public void setName(String r10) {
        this.name = r10;
    }

    public void setOnline_time(String r10) {
        this.online_time = r10;
    }

    public void setParent_cid(String r10) {
        this.parent_cid = r10;
    }

    public void setStatus(int r10) {
        this.status = r10;
    }

    public void setSubcribe(boolean r10) {
        this.status = r10 ? 1 : 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r10, int r11) {
        r10.writeString(this.f9898id);
        r10.writeString(this.name);
        r10.writeString(this.logo);
        r10.writeString(this.banner);
        r10.writeString(this.online_time);
        r10.writeString(this.category);
        r10.writeString(this.parent_cid);
        r10.writeString(this.child_cid);
        r10.writeInt(this.status);
    }

    public SubAppEntity(Parcel r10) {
        this.f9898id = "";
        this.name = "";
        this.logo = "";
        this.banner = "";
        this.online_time = "";
        this.category = "";
        this.parent_cid = "";
        this.child_cid = "";
        this.status = 0;
        this.f9898id = r10.readString();
        this.name = r10.readString();
        this.logo = r10.readString();
        this.banner = r10.readString();
        this.online_time = r10.readString();
        this.category = r10.readString();
        this.parent_cid = r10.readString();
        this.child_cid = r10.readString();
        this.status = r10.readInt();
    }
}
