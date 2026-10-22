package com.android.ttcjpaysdk.thirdparty.data;

import android.os.Parcel;
import android.os.Parcelable;
import com.android.ttcjpaysdk.base.json.CJPayObject;
import com.android.ttcjpaysdk.base.utils.CJBasicCommonUtils;
import java.io.Serializable;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes39.dex */
public class CJPayUserAgreement implements Parcelable, CJPayObject, Serializable {
    public static final Parcelable.Creator<CJPayUserAgreement> CREATOR = null;
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

    public JSONObject toJson() {
        JSONObject r100 = new JSONObject();
        r100.put("content_url", this.content_url);     // Catch: JSONException -> L5
        r100.put("default_choose", this.default_choose);     // Catch: JSONException -> L5
        r100.put("title", this.title);     // Catch: JSONException -> L5
        return r100;
    L5:
        e = move-exception;
        CJBasicCommonUtils.reportCatchException("CJPayUserAgreement#toJson", e);
        CJBasicCommonUtils.logCatch("CJCatch", "CJPayUserAgreement#toJson", e);
        e.printStackTrace();
        return null;
    }

    public CJPayUserAgreement() {
        this.content_url = "";
        this.default_choose = false;
        this.title = "";
    }

    public CJPayUserAgreement(JSONObject r100) {
        this.content_url = "";
        this.default_choose = false;
        this.title = "";
        if (r100 == null) goto L6;
        this.content_url = r100.optString("content_url");
        this.default_choose = r100.optBoolean("default_choose");
        this.title = r100.optString("title");
        return;
    }

    public CJPayUserAgreement(Parcel r100) {
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
