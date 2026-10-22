package com.stepos.statsapp.v3.lib.plugin.net;

import K5.b;
import android.os.Parcel;
import android.os.Parcelable;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class NetResponse implements Parcelable {
    public static final Parcelable.Creator<NetResponse> CREATOR = new b();
    private String responseBody;
    private int responseCode;

    public NetResponse(int i, String str) {
        this.responseCode = i;
        this.responseBody = str;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getResponseBody() {
        return this.responseBody;
    }

    public int getResponseCode() {
        return this.responseCode;
    }

    public String toString() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("code", this.responseCode);
            jSONObject.put("body", this.responseBody);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return "[NetResponse] " + jSONObject.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.responseCode);
        parcel.writeString(this.responseBody);
    }

    public NetResponse(Parcel parcel) {
        this.responseCode = parcel.readInt();
        this.responseBody = parcel.readString();
    }
}
