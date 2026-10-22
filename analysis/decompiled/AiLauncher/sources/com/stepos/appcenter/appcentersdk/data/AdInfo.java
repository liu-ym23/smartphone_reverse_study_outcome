package com.stepos.appcenter.appcentersdk.data;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
public class AdInfo implements Parcelable {
    public static final Parcelable.Creator<AdInfo> CREATOR = new Parcelable.Creator<AdInfo>() { // from class: com.stepos.appcenter.appcentersdk.data.AdInfo.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public AdInfo createFromParcel(Parcel parcel) {
            return new AdInfo(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public AdInfo[] newArray(int i10) {
            return new AdInfo[i10];
        }
    };
    public long app_id;
    public String app_name;
    public int bid_type;
    public List<String> click_notice_urls;
    public List<String> download_notice_urls;
    public List<String> downloaded_notice_urls;
    public List<String> exposure_notice_urls;
    public List<String> install_notice_urls;
    public List<String> installed_notice_urls;
    public AdImage main_image;
    public List<AdImage> multi_images;
    public int mzid;
    public List<String> pull_notice_urls;
    public String title;

    public static class AdImage implements Parcelable {
        public static final Parcelable.Creator<AdImage> CREATOR = new Parcelable.Creator<AdImage>() { // from class: com.stepos.appcenter.appcentersdk.data.AdInfo.AdImage.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public AdImage createFromParcel(Parcel parcel) {
                return new AdImage(parcel);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public AdImage[] newArray(int i10) {
                return new AdImage[i10];
            }
        };
        public int height;
        public String url;
        public int width;

        public AdImage() {
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i10) {
            parcel.writeInt(this.height);
            parcel.writeInt(this.width);
            parcel.writeString(this.url);
        }

        public AdImage(Parcel parcel) {
            this.height = parcel.readInt();
            this.width = parcel.readInt();
            this.url = parcel.readString();
        }
    }

    public AdInfo() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeLong(this.app_id);
        parcel.writeString(this.app_name);
        parcel.writeInt(this.mzid);
        parcel.writeStringList(this.click_notice_urls);
        parcel.writeStringList(this.download_notice_urls);
        parcel.writeStringList(this.downloaded_notice_urls);
        parcel.writeStringList(this.install_notice_urls);
        parcel.writeStringList(this.installed_notice_urls);
        parcel.writeStringList(this.exposure_notice_urls);
        parcel.writeStringList(this.pull_notice_urls);
        parcel.writeInt(this.bid_type);
        parcel.writeString(this.title);
        parcel.writeParcelable(this.main_image, i10);
        parcel.writeList(this.multi_images);
    }

    public AdInfo(Parcel parcel) {
        this.app_id = parcel.readLong();
        this.app_name = parcel.readString();
        this.mzid = parcel.readInt();
        this.click_notice_urls = parcel.createStringArrayList();
        this.download_notice_urls = parcel.createStringArrayList();
        this.downloaded_notice_urls = parcel.createStringArrayList();
        this.install_notice_urls = parcel.createStringArrayList();
        this.installed_notice_urls = parcel.createStringArrayList();
        this.exposure_notice_urls = parcel.createStringArrayList();
        this.pull_notice_urls = parcel.createStringArrayList();
        this.bid_type = parcel.readInt();
        this.title = parcel.readString();
        this.main_image = (AdImage) parcel.readParcelable(AdImage.class.getClassLoader());
        ArrayList arrayList = new ArrayList();
        this.multi_images = arrayList;
        parcel.readList(arrayList, AdImage.class.getClassLoader());
    }
}
