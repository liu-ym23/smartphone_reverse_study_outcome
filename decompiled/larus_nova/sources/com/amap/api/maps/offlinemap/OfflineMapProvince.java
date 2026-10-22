package com.amap.api.maps.offlinemap;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes28.dex */
public class OfflineMapProvince extends Province {
    public static final Parcelable.Creator<OfflineMapProvince> CREATOR = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f28730e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f28731f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private long f28732g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private String f28733h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f28734i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private ArrayList<OfflineMapCity> f28735j;

    public static class a implements Parcelable.Creator<OfflineMapProvince> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public OfflineMapProvince createFromParcel(Parcel r100) {
            return new OfflineMapProvince(r100);
        }

        @Override // android.os.Parcelable.Creator
        public OfflineMapProvince[] newArray(int r100) {
            return new OfflineMapProvince[r100];
        }
    }

    @Override // com.amap.api.maps.offlinemap.Province, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    static {
        CREATOR = new a();
    }

    public ArrayList<OfflineMapCity> getCityList() {
        ArrayList<OfflineMapCity> r100 = this.f28735j;
        if (r100 == null) goto L5;
        return r100;
    L5:
        return new ArrayList();
    }

    public ArrayList<OfflineMapCity> getDownloadedCityList() {
        ArrayList<OfflineMapCity> r100 = new ArrayList();
        ArrayList<OfflineMapCity> r101 = this.f28735j;
        if (r101 != null) goto L5;
        return r100;
    L5:
        Iterator<OfflineMapCity> r102 = r101.iterator();
    L7:
        if (r102.hasNext() == false) goto L11;
        OfflineMapCity r103 = r102.next();
        if (r103.getState() == 6) goto L7;
        r100.add(r103);
        goto L7
    L11:
        return r100;
    }

    public OfflineMapProvince() {
        this.f28731f = 6;
        this.f28734i = 0;
    }

    public int getCompleteCode() {
        return this.f28734i;
    }

    public long getSize() {
        return this.f28732g;
    }

    public int getState() {
        return this.f28731f;
    }

    public String getUrl() {
        return this.f28730e;
    }

    public String getVersion() {
        return this.f28733h;
    }

    public OfflineMapProvince(Parcel r100) {
        super(r100);
        this.f28731f = 6;
        this.f28734i = 0;
        this.f28730e = r100.readString();
        this.f28731f = r100.readInt();
        this.f28732g = r100.readLong();
        this.f28733h = r100.readString();
        this.f28734i = r100.readInt();
        this.f28735j = r100.createTypedArrayList(OfflineMapCity.CREATOR);
    }

    public void setCityList(ArrayList<OfflineMapCity> r100) {
        this.f28735j = r100;
    }

    public void setCompleteCode(int r100) {
        this.f28734i = r100;
    }

    public void setSize(long r100) {
        this.f28732g = r100;
    }

    public void setState(int r100) {
        this.f28731f = r100;
    }

    public void setUrl(String r100) {
        this.f28730e = r100;
    }

    public void setVersion(String r100) {
        this.f28733h = r100;
    }

    @Override // com.amap.api.maps.offlinemap.Province, android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        super.writeToParcel(r100, r101);
        r100.writeString(this.f28730e);
        r100.writeInt(this.f28731f);
        r100.writeLong(this.f28732g);
        r100.writeString(this.f28733h);
        r100.writeInt(this.f28734i);
        r100.writeTypedList(this.f28735j);
    }
}
