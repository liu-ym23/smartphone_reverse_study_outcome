package com.stepos.statsapp.v3.lib.plugin.net;

import android.os.Parcel;
import android.os.Parcelable;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class NetResponse implements Parcelable {
    public static final Parcelable.Creator<NetResponse> CREATOR = new a();
    private String responseBody;
    private int responseCode;

    public class a implements Parcelable.Creator<NetResponse> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public NetResponse createFromParcel(Parcel parcel) {
            return new NetResponse(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public NetResponse[] newArray(int i10) {
            return new NetResponse[i10];
        }
    }

    public NetResponse(int i10, String str) {
        this.responseCode = i10;
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

    public String toString() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("code", this.responseCode);
            jSONObject.put("body", this.responseBody);
        } catch (JSONException e10) {
            e10.printStackTrace();
        }
        return "[NetResponse] " + jSONObject.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeInt(this.responseCode);
        parcel.writeString(this.responseBody);
    }

    public NetResponse(Parcel parcel) {
        this.responseCode = parcel.readInt();
        this.responseBody = parcel.readString();
    }
}
