package com.stepos.appcenter.aidl;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class BaseAidlMsg implements Parcelable {
    public static final Parcelable.Creator<BaseAidlMsg> CREATOR = new Parcelable.Creator<BaseAidlMsg>() { // from class: com.stepos.appcenter.aidl.BaseAidlMsg.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public BaseAidlMsg createFromParcel(Parcel parcel) {
            return new BaseAidlMsg(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public BaseAidlMsg[] newArray(int i10) {
            return new BaseAidlMsg[i10];
        }
    };
    public int action;
    public int code;
    public String data;
    public int hostVersionCode;
    public String sourceApk;
    public String sourceApkInfo;

    public interface Action {
        public static final int ACTION_BATCH_INSTALL_APPS = 1004;
        public static final int ACTION_DELETE_DOWNLOAD = 8;
        public static final int ACTION_GET_APP_STATUS = 8004;
        public static final int ACTION_GET_LAUNCHERRECOMMEND_SWITCH = 12;
        public static final int ACTION_GET_PERSONADRECOMMEND_SWITCH = 13;
        public static final int ACTION_GET_RECOMMEND_APPS = 1002;
        public static final int ACTION_GET_TASKS = 10;
        public static final int ACTION_INSTALL_APP_BY_ID = 8002;
        public static final int ACTION_INSTALL_APP_BY_ID_CALLBACK = 9001;
        public static final int ACTION_INSTALL_BUTTON_CLICK = 8003;
        public static final int ACTION_INSTALL_BUTTON_CLICK_CALLBACK = 9002;
        public static final int ACTION_INSTALL_STATUS_CALLBACK = 1000;
        public static final int ACTION_INSTALL_SUC_REPORT_INFO = 1006;
        public static final int ACTION_IS_APP_INSTALL = 8001;
        public static final int ACTION_NOTIFY_DATA_CHANGE_BY_PACKAGE_NAME = 8007;
        public static final int ACTION_NOTIFY_DATA_CHANGE_CALLBACK = 9003;
        public static final int ACTION_ON_RECOMMEND_APPS_EXPOSURE = 1003;
        public static final int ACTION_ON_SWITCH_PHONE_MOVED_APPS_RECEIVED = 1005;
        public static final int ACTION_PACKAGE_INSTALL_CALLBACK = 1001;
        public static final int ACTION_PAUSE = 2;
        public static final int ACTION_PERFORM_DOWNLOAD_CLICK = 1;
        public static final int ACTION_PRIVACY_AGREED = 11;
        public static final int ACTION_REGISTER_GLOBAL_LISTENER = 5;
        public static final int ACTION_REGISTER_PACKAGE_LISTENER = 3;
        public static final int ACTION_REQUEST_API = 9;
        public static final int ACTION_REQUEST_DOWNLOAD = 8006;
        public static final int ACTION_STATISTICS = 7;
        public static final int ACTION_UNINSTALL_APP = 8005;
        public static final int ACTION_UNREGISTER_GLOBAL_LISTENER = 6;
        public static final int ACTION_UNREGISTER_PACKAGE_LISTENER = 4;
        public static final int ACTION_WEBVIEW_BIND_WX = 10000;
        public static final int ACTION_WEBVIEW_BIND_WX_RESPONE = 10001;
        public static final int ACTION_WEBVIEW_CALLBACK = 9000;
        public static final int ACTION_WEBVIEW_SINGLE_PROCESS = 8000;
    }

    public interface Api {
        public static final String DETAIL = "detail";
    }

    public interface Code {
        public static final int ERROR = -1;
        public static final int SUCCESS = 0;
    }

    public BaseAidlMsg() {
        this.data = "";
        this.sourceApk = "";
        this.sourceApkInfo = "";
    }

    public static String createPackageInfo(String str, int i10, int i11) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        try {
            if (!TextUtils.isEmpty(str)) {
                jSONObject.put("pkgname", str);
            }
            if (i10 != 0) {
                jSONObject.put("appId", i10);
            }
            if (i11 != 0) {
                jSONObject.put("versioncode", i11);
            }
        } catch (JSONException e10) {
            e10.printStackTrace();
        }
        return jSONObject.toString();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            BaseAidlMsg baseAidlMsg = (BaseAidlMsg) obj;
            if (this.action != baseAidlMsg.action || this.code != baseAidlMsg.code) {
                return false;
            }
            String str = this.data;
            if (str != null) {
                return str.equals(baseAidlMsg.data);
            }
            if (baseAidlMsg.data == null) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        int i10 = ((this.action * 31) + this.code) * 31;
        String str = this.data;
        return i10 + (str != null ? str.hashCode() : 0);
    }

    public String toString() {
        return "BaseAidlMsg{action=" + this.action + ", code=" + this.code + ", data='" + this.data + "'}";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeInt(this.action);
        parcel.writeInt(this.code);
        parcel.writeString(this.data);
        parcel.writeString(this.sourceApk);
        parcel.writeString(this.sourceApkInfo);
        parcel.writeInt(this.hostVersionCode);
    }

    public BaseAidlMsg(Parcel parcel) {
        this.data = "";
        this.sourceApk = "";
        this.sourceApkInfo = "";
        this.action = parcel.readInt();
        this.code = parcel.readInt();
        this.data = parcel.readString();
        this.sourceApk = parcel.readString();
        this.sourceApkInfo = parcel.readString();
        this.hostVersionCode = parcel.readInt();
    }
}
