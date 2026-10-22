package com.stepos.statsapp.v3.lib.plugin.net;

import android.os.Parcel;
import android.os.Parcelable;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class NetResponse implements Parcelable {
    public static final Parcelable.Creator<NetResponse> CREATOR = new a();

    /* renamed from: a, reason: collision with root package name */
    private int f15919a;

    /* renamed from: b, reason: collision with root package name */
    private String f15920b;

    class a implements Parcelable.Creator<NetResponse> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public NetResponse createFromParcel(Parcel parcel) {
            return new NetResponse(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public NetResponse[] newArray(int i5) {
            return new NetResponse[i5];
        }
    }

    public NetResponse(int i5, String str) {
        this.f15919a = i5;
        this.f15920b = str;
    }

    public String a() {
        return this.f15920b;
    }

    public int c() {
        return this.f15919a;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("code", this.f15919a);
            jSONObject.put("body", this.f15920b);
        } catch (JSONException e6) {
            e6.printStackTrace();
        }
        return "[NetResponse] " + jSONObject.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i5) {
        parcel.writeInt(this.f15919a);
        parcel.writeString(this.f15920b);
    }

    protected NetResponse(Parcel parcel) {
        this.f15919a = parcel.readInt();
        this.f15920b = parcel.readString();
    }
}
