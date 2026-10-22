package com.stepos.statsapp.v3.lib.plugin.net;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.material.internal.f;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class NetResponse implements Parcelable {
    public static final Parcelable.Creator<NetResponse> CREATOR = new f(4);

    /* renamed from: a, reason: collision with root package name */
    public int f12341a;

    /* renamed from: b, reason: collision with root package name */
    public String f12342b;

    public NetResponse(int i4, String str) {
        this.f12341a = i4;
        this.f12342b = str;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final String toString() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("code", this.f12341a);
            jSONObject.put("body", this.f12342b);
        } catch (JSONException e4) {
            e4.printStackTrace();
        }
        return "[NetResponse] " + jSONObject.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i4) {
        parcel.writeInt(this.f12341a);
        parcel.writeString(this.f12342b);
    }
}
