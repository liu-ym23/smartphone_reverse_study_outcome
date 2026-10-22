package com.stepos.statsapp.v3.lib.plugin.net;

import android.os.Parcel;
import android.os.Parcelable;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public class NetResponse implements Parcelable {
    public static final Parcelable.Creator<NetResponse> CREATOR = new a();
    private String responseBody;
    private int responseCode;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public class a implements Parcelable.Creator<NetResponse> {
        @Override // android.os.Parcelable.Creator
        public final NetResponse createFromParcel(Parcel parcel) {
            return new NetResponse(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final NetResponse[] newArray(int i10) {
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
