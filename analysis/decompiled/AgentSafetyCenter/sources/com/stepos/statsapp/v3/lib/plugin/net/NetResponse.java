package com.stepos.statsapp.v3.lib.plugin.net;

import android.os.Parcel;
import android.os.Parcelable;
import ia.b;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public class NetResponse implements Parcelable {
    public static final Parcelable.Creator<NetResponse> CREATOR = new b();

    /* renamed from: c, reason: collision with root package name */
    public int f2840c;

    /* renamed from: f, reason: collision with root package name */
    public String f2841f;

    public NetResponse(int i, String str) {
        this.f2840c = i;
        this.f2841f = str;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final String toString() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("code", this.f2840c);
            jSONObject.put("body", this.f2841f);
        } catch (JSONException e10) {
            e10.printStackTrace();
        }
        return "[NetResponse] " + jSONObject.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f2840c);
        parcel.writeString(this.f2841f);
    }
}
