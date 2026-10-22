package com.bytedance.android.service.manager.push.notification;

import android.os.Parcel;
import android.os.Parcelable;
import com.bytedance.push.utils.f;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes12.dex */
public class PushNotificationButtonInfo implements Parcelable {
    public static final Parcelable.Creator<PushNotificationButtonInfo> CREATOR = null;
    public String mButtonAction;
    public String mButtonOpenUrl;
    public String mButtonRawText;
    public String mButtonToast;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    static {
        CREATOR = new AnonymousClass1();
    }

    public JSONObject toJsonForEventV3() {
        JSONObject r100 = new JSONObject();
        r100.put("text", this.mButtonRawText);     // Catch: JSONException -> L5
        r100.put("action", this.mButtonAction);     // Catch: JSONException -> L5
        r100.put("toast", this.mButtonToast);     // Catch: JSONException -> L5
    L7:
        return r100;
    L5:
        e = move-exception;
        f.e(getClass().getSimpleName(), e.getMessage());
        goto L7
    }

    public PushNotificationButtonInfo(JSONObject r100) {
        if (r100 == null) goto L6;
        this.mButtonRawText = r100.optString("text");
        this.mButtonAction = r100.optString("action");
        this.mButtonToast = r100.optString("toast");
        this.mButtonOpenUrl = r100.optString("open_url");
        return;
    }

    public PushNotificationButtonInfo(Parcel r100) {
        this.mButtonRawText = r100.readString();
        this.mButtonAction = r100.readString();
        this.mButtonToast = r100.readString();
        this.mButtonOpenUrl = r100.readString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        r100.writeString(this.mButtonRawText);
        r100.writeString(this.mButtonAction);
        r100.writeString(this.mButtonToast);
        r100.writeString(this.mButtonOpenUrl);
    }
}
