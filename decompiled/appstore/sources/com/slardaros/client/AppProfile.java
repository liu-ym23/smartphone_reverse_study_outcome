package com.slardaros.client;

import android.os.Parcel;
import android.os.Parcelable;
import com.bytedance.apm.constant.CommonKey;
import com.bytedanceos.common.tracker.TrackerElement;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public class AppProfile implements Parcelable {
    public static final Parcelable.Creator<AppProfile> CREATOR = null;
    public String filePath;
    public boolean isQuery;
    public String packageName;
    public String type;
    public String versionCode;
    public String versionName;

    public class a implements Parcelable.Creator {
        public a() {
        }

        public AppProfile a(Parcel r10) {
            return new AppProfile(r10);
        }

        public AppProfile[] b(int r10) {
            return new AppProfile[r10];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ Object createFromParcel(Parcel r10) {
            return a(r10);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ Object[] newArray(int r10) {
            return b(r10);
        }
    }

    static {
        CREATOR = new a();
    }

    public AppProfile(String r10, String r11, String r12, String r13, String r14, boolean r15) {
        this.packageName = r10;
        this.versionName = r11;
        this.versionCode = r12;
        this.filePath = r13;
        this.type = r14;
        this.isQuery = r15;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getFilePath() {
        return this.filePath;
    }

    public String getPackageName() {
        return this.packageName;
    }

    public String getType() {
        return this.type;
    }

    public String getVersionCode() {
        return this.versionCode;
    }

    public String getVersionName() {
        return this.versionName;
    }

    public boolean isQuery() {
        return this.isQuery;
    }

    public void setFilePath(String r10) {
        this.filePath = r10;
    }

    public void setPackageName(String r10) {
        this.packageName = r10;
    }

    public void setQuery(boolean r10) {
        this.isQuery = r10;
    }

    public void setType(String r10) {
        this.type = r10;
    }

    public void setVersionCode(String r10) {
        this.versionCode = r10;
    }

    public void setVersionName(String r10) {
        this.versionName = r10;
    }

    public JSONObject toJson(int r10) {
        JSONObject r11 = new JSONObject();
        r11.put("product_id", r10);     // Catch: JSONException -> L5
        r11.put(TrackerElement.PACKAGE_NAME, this.packageName);     // Catch: JSONException -> L5
        r11.put(CommonKey.KEY_VERSION_NAME, this.versionName);     // Catch: JSONException -> L5
        r11.put("version_code", this.versionCode);     // Catch: JSONException -> L5
        r11.put("profile_type", this.type);     // Catch: JSONException -> L5
    L7:
        return r11;
    L5:
        e = move-exception;
        e.printStackTrace();
        goto L7
    }

    public String toString() {
        return "AppProfile{packageName='" + this.packageName + "', versionName='" + this.versionName + "', versionCode='" + this.versionCode + "', filePath='" + this.filePath + "', type='" + this.type + "', isQuery=" + this.isQuery + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r10, int r11) {
        r10.writeString(this.packageName);
        r10.writeString(this.versionName);
        r10.writeString(this.versionCode);
        r10.writeString(this.filePath);
        r10.writeString(this.type);
        r10.writeByte(this.isQuery ? 1 : 0);
    }

    public AppProfile(Parcel r10) {
        this.packageName = r10.readString();
        this.versionName = r10.readString();
        this.versionCode = r10.readString();
        this.filePath = r10.readString();
        this.type = r10.readString();
        if (r10.readByte() == 0) goto L5;
        boolean r11 = true;
    L6:
        this.isQuery = r11;
        return;
    L5:
        r11 = false;
        goto L6
    }
}
