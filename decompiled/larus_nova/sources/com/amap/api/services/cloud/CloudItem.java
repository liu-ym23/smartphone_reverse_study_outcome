package com.amap.api.services.cloud;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.services.core.LatLonPoint;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: loaded from: classes28.dex */
public class CloudItem implements Parcelable {
    public static final Parcelable.Creator<CloudItem> CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f28801a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f28802b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f28803c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f28804d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private HashMap<String, String> f28805e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private List<CloudImage> f28806f;
    protected final LatLonPoint mPoint;
    protected final String mSnippet;
    protected final String mTitle;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    static {
        CREATOR = new AnonymousClass1();
    }

    public int hashCode() {
        String r100 = this.f28801a;
        if (r100 != null) goto L5;
        int r101 = 0;
    L7:
        return r101 + 31;
    L5:
        r101 = r100.hashCode();
        goto L7
    }

    public List<CloudImage> getCloudImage() {
        return this.f28806f;
    }

    public String getCreatetime() {
        return this.f28803c;
    }

    public HashMap<String, String> getCustomfield() {
        return this.f28805e;
    }

    public int getDistance() {
        return this.f28802b;
    }

    public String getID() {
        return this.f28801a;
    }

    public LatLonPoint getLatLonPoint() {
        return this.mPoint;
    }

    public String getSnippet() {
        return this.mSnippet;
    }

    public String getTitle() {
        return this.mTitle;
    }

    public String getUpdatetime() {
        return this.f28804d;
    }

    public String toString() {
        return this.mTitle;
    }

    public CloudItem(Parcel r100) {
        this.f28802b = -1;
        this.f28801a = r100.readString();
        this.f28802b = r100.readInt();
        this.mPoint = (LatLonPoint) r100.readValue(LatLonPoint.class.getClassLoader());
        this.mTitle = r100.readString();
        this.mSnippet = r100.readString();
        this.f28803c = r100.readString();
        this.f28804d = r100.readString();
        HashMap<String, String> r101 = new HashMap();
        this.f28805e = r101;
        r100.readMap(r101, HashMap.class.getClassLoader());
        List r102 = new ArrayList();
        this.f28806f = r102;
        r100.readList(r102, getClass().getClassLoader());
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if (r100 != null) goto L9;
        return false;
    L9:
        if ((r100 instanceof CloudItem) == true) goto L11;
        return false;
    L11:
        CloudItem r101 = (CloudItem) r100;
        String r102 = this.f28801a;
        if (r102 != null) goto L17;
        if (r101.f28801a == null) goto L19;
        return false;
    L19:
        return true;
    L17:
        if (r102.equals(r101.f28801a) == true) goto L19;
        return false;
    }

    public void setCreatetime(String r100) {
        this.f28803c = r100;
    }

    public void setCustomfield(HashMap<String, String> r100) {
        this.f28805e = r100;
    }

    public void setDistance(int r100) {
        this.f28802b = r100;
    }

    public void setUpdatetime(String r100) {
        this.f28804d = r100;
    }

    public void setmCloudImage(List<CloudImage> r100) {
        this.f28806f = r100;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        r100.writeString(this.f28801a);
        r100.writeInt(this.f28802b);
        r100.writeValue(this.mPoint);
        r100.writeString(this.mTitle);
        r100.writeString(this.mSnippet);
        r100.writeString(this.f28803c);
        r100.writeString(this.f28804d);
        r100.writeMap(this.f28805e);
        r100.writeList(this.f28806f);
    }

    public CloudItem(String r100, LatLonPoint r101, String r102, String r103) {
        this.f28802b = -1;
        this.f28801a = r100;
        this.mPoint = r101;
        this.mTitle = r102;
        this.mSnippet = r103;
    }
}
