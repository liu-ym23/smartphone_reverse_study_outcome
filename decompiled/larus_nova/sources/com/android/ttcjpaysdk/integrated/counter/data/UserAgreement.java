package com.android.ttcjpaysdk.integrated.counter.data;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.android.ttcjpaysdk.base.json.CJPayObject;
import com.android.ttcjpaysdk.base.utils.CJBasicCommonUtils;
import java.io.Serializable;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes28.dex */
public class UserAgreement implements Parcelable, Serializable, CJPayObject {
    public static final Parcelable.Creator<UserAgreement> CREATOR = null;
    public String content_url;
    public boolean default_choose;
    public String title;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    static {
        CREATOR = new AnonymousClass1();
    }

    public void appendFrenchQuotes() {
        if (TextUtils.isEmpty(this.title) == true) goto L6;
        this.title = String.format("《%s》", new Object[]{this.title});
        return;
    }

    public JSONObject toJson() {
        JSONObject r100 = new JSONObject();
        r100.put("content_url", this.content_url);     // Catch: JSONException -> L5
        r100.put("default_choose", this.default_choose);     // Catch: JSONException -> L5
        r100.put("title", this.title);     // Catch: JSONException -> L5
        return r100;
    L5:
        e = move-exception;
        CJBasicCommonUtils.reportCatchException("UserAgreement#toJson", e);
        CJBasicCommonUtils.logCatch("CJCatch", "UserAgreement#toJson", e);
        e.printStackTrace();
        return null;
    }

    public UserAgreement() {
        this.content_url = "";
        this.default_choose = false;
        this.title = "";
    }

    public UserAgreement(JSONObject r100) {
        this.content_url = "";
        this.default_choose = false;
        this.title = "";
        if (r100 == null) goto L6;
        this.content_url = r100.optString("content_url");
        this.default_choose = r100.optBoolean("default_choose");
        this.title = r100.optString("title");
        return;
    }

    public UserAgreement(Parcel r100) {
        this.content_url = "";
        boolean r101 = false;
        this.default_choose = false;
        this.title = "";
        this.content_url = r100.readString();
        if (r100.readByte() == 0) goto L5;
        r101 = true;
    L5:
        this.default_choose = r101;
        this.title = r100.readString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        r100.writeString(this.content_url);
        r100.writeByte(this.default_choose ? 1 : 0);
        r100.writeString(this.title);
    }
}
