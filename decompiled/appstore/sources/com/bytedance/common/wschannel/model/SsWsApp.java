package com.bytedance.common.wschannel.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.bytedance.common.utility.e;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.common.wschannel.app.IWsApp;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class SsWsApp implements IWsApp, Parcelable {
    public static final Parcelable.Creator<SsWsApp> CREATOR = null;
    private String appKey;
    private int channelId;
    private String extra;
    private int fPid;
    private int mAppId;
    private int mAppVersion;
    private String mDeviceId;
    private String mInstallId;
    private int mPlatform;
    private List<String> urls;

    public static class a implements Parcelable.Creator {
        public a() {
        }

        public SsWsApp a(Parcel r10) {
            return new SsWsApp(r10);
        }

        public SsWsApp[] b(int r10) {
            return new SsWsApp[r10];
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

    public static class b {
        public b() {
        }

        public SsWsApp a(JSONObject r10) {
            SsWsApp r11 = new SsWsApp();
            r11.parseFromJson(r10);
            return r11;
        }
    }

    static {
        CREATOR = new a();
    }

    public /* synthetic */ SsWsApp(int r10, int r11, String r12, String r13, List r14, int r15, int r16, int r17, String r18, String r19, a r110) {
        this(r10, r11, r12, r13, r14, r15, r16, r17, r18, r19);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if (r10 != null) goto L8;
    L60:
        return false;
    L8:
        if (getClass() != r10.getClass()) goto L60;
        SsWsApp r11 = (SsWsApp) r10;
        if (this.channelId == r11.channelId) goto L14;
        return false;
    L14:
        if (this.mAppId == r11.mAppId) goto L17;
        return false;
    L17:
        if (this.mAppVersion == r11.mAppVersion) goto L20;
        return false;
    L20:
        if (this.mPlatform == r11.mPlatform) goto L22;
        return false;
    L22:
        String r12 = this.mDeviceId;
        if (r12 == null) goto L28;
        if (r12.equals(r11.mDeviceId) == false) goto L29;
    L30:
        String r13 = this.mInstallId;
        if (r13 == null) goto L36;
        if (r13.equals(r11.mInstallId) == true) goto L39;
    L37:
        return false;
    L39:
        if (this.fPid == r11.fPid) goto L41;
        return false;
    L41:
        String r14 = this.appKey;
        if (r14 == null) goto L47;
        if (r14.equals(r11.appKey) == true) goto L50;
    L48:
        return false;
    L50:
        if (this.urls.size() == r11.urls.size()) goto L52;
        return false;
    L52:
        Iterator<String> r15 = this.urls.iterator();
    L54:
        if (r15.hasNext() == false) goto L59;
        String r16 = r15.next();
        if (r11.urls.contains(r16) == true) goto L54;
        return false;
    L59:
        return e.a(this.extra, r11.extra);
    L47:
        if (r11.appKey == null) goto L50;
    L36:
        if (r11.mInstallId == null) goto L39;
    L29:
        return false;
    L28:
        if (r11.mDeviceId == null) goto L30;
        goto L29
    }

    @Override // com.bytedance.common.wschannel.app.IWsApp
    public int getAppId() {
        return this.mAppId;
    }

    @Override // com.bytedance.common.wschannel.app.IWsApp
    public String getAppKey() {
        return this.appKey;
    }

    @Override // com.bytedance.common.wschannel.app.IWsApp
    public int getAppVersion() {
        return this.mAppVersion;
    }

    @Override // com.bytedance.common.wschannel.app.IWsApp
    public int getChannelId() {
        return this.channelId;
    }

    @Override // com.bytedance.common.wschannel.app.IWsApp
    public List<String> getConnectUrls() {
        return this.urls;
    }

    @Override // com.bytedance.common.wschannel.app.IWsApp
    public String getDeviceId() {
        return this.mDeviceId;
    }

    @Override // com.bytedance.common.wschannel.app.IWsApp
    public String getExtra() {
        return this.extra;
    }

    @Override // com.bytedance.common.wschannel.app.IWsApp
    public int getFPID() {
        return this.fPid;
    }

    @Override // com.bytedance.common.wschannel.app.IWsApp
    public String getInstallId() {
        return this.mInstallId;
    }

    @Override // com.bytedance.common.wschannel.app.IWsApp
    public int getPlatform() {
        return this.mPlatform;
    }

    public int hashCode() {
        int r10 = ((this.mAppId * 31) + this.channelId) * 31;
        String r11 = this.mDeviceId;
        int r12 = 0;
        if (r11 == null) goto L5;
        int r13 = r11.hashCode();
    L6:
        int r14 = (r10 + r13) * 31;
        String r15 = this.mInstallId;
        if (r15 == null) goto L9;
        int r16 = r15.hashCode();
    L10:
        int r17 = (r14 + r16) * 31;
        String r18 = this.extra;
        if (r18 == null) goto L14;
        r12 = r18.hashCode();
    L14:
        return ((((r17 + r12) * 31) + this.mAppVersion) * 31) + this.mPlatform;
    L9:
        r16 = 0;
        goto L10
    L5:
        r13 = 0;
        goto L6
    }

    @Override // com.bytedance.common.wschannel.app.IWsApp
    public void parseFromJson(JSONObject r10) {
        if (r10 != null) goto L4;
        return;
    L4:
        this.channelId = r10.optInt(WsConstants.KEY_CHANNEL_ID);
        this.mAppId = r10.optInt("app_id");
        this.mDeviceId = r10.optString("device_id");
        this.mInstallId = r10.optString("install_id");
        this.mAppVersion = r10.optInt("app_version");
        this.mPlatform = r10.optInt(WsConstants.KEY_PLATFORM);
        this.fPid = r10.optInt(WsConstants.KEY_FPID);
        this.appKey = r10.optString("app_kay");
        this.extra = r10.optString(WsConstants.KEY_EXTRA);
        JSONArray r11 = r10.optJSONArray("urls");
        this.urls.clear();
        if (r11 == null) goto L9;
        int r12 = r11.length();
        int r13 = 0;
    L7:
        if (r13 >= r12) goto L11;
        this.urls.add(r11.optString(r13));
        r13 = r13 + 1;
        goto L7
    L11:
        return;
    }

    @Override // com.bytedance.common.wschannel.app.IWsApp
    public JSONObject toJson() throws JSONException {
        JSONObject r10 = new JSONObject();
        r10.put(WsConstants.KEY_CHANNEL_ID, this.channelId);
        r10.put("app_id", this.mAppId);
        r10.put("device_id", this.mDeviceId);
        r10.put("install_id", this.mInstallId);
        JSONArray r11 = new JSONArray();
        List<String> r12 = this.urls;
        if (r12 == null) goto L8;
        Iterator<String> r13 = r12.iterator();
    L6:
        if (r13.hasNext() == false) goto L8;
        r11.put(r13.next());
    L8:
        r10.put("urls", r11);
        r10.put("app_version", this.mAppVersion);
        r10.put(WsConstants.KEY_PLATFORM, this.mPlatform);
        r10.put(WsConstants.KEY_FPID, this.fPid);
        r10.put("app_kay", this.appKey);
        r10.put(WsConstants.KEY_EXTRA, this.extra);
        return r10;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r10, int r11) {
        r10.writeStringList(this.urls);
        r10.writeInt(this.channelId);
        r10.writeString(this.extra);
        r10.writeInt(this.mAppId);
        r10.writeString(this.mDeviceId);
        r10.writeString(this.mInstallId);
        r10.writeInt(this.mAppVersion);
        r10.writeInt(this.mPlatform);
        r10.writeInt(this.fPid);
        r10.writeString(this.appKey);
    }

    public SsWsApp() {
        this.urls = new ArrayList();
    }

    private SsWsApp(int r10, int r11, String r12, String r13, List<String> r14, int r15, int r16, int r17, String r18, String r19) {
        ArrayList r20 = new ArrayList();
        this.urls = r20;
        this.mAppId = r11;
        this.channelId = r10;
        this.mDeviceId = r12;
        this.mInstallId = r13;
        if (r14 == null) goto L5;
        r20.addAll(r14);
    L5:
        this.mAppVersion = r15;
        this.mPlatform = r16;
        this.fPid = r17;
        this.appKey = r18;
        this.extra = r19;
    }

    public SsWsApp(Parcel r10) {
        this.urls = new ArrayList();
        this.urls = r10.createStringArrayList();
        this.channelId = r10.readInt();
        this.extra = r10.readString();
        this.mAppId = r10.readInt();
        this.mDeviceId = r10.readString();
        this.mInstallId = r10.readString();
        this.mAppVersion = r10.readInt();
        this.mPlatform = r10.readInt();
        this.fPid = r10.readInt();
        this.appKey = r10.readString();
    }
}
