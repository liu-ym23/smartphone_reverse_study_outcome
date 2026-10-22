package com.bytedance.common.wschannel.model;

import android.os.Parcel;
import android.os.Parcelable;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class WsApi implements Parcelable {
    public static final Parcelable.Creator<WsApi> CREATOR = null;
    int method;
    int service;

    public static class a implements Parcelable.Creator {
        public a() {
        }

        public WsApi a(Parcel r10) {
            WsApi r11 = new WsApi();
            r11.service = r10.readInt();
            r11.method = r10.readInt();
            return r11;
        }

        public WsApi[] b(int r10) {
            return new WsApi[r10];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ Object createFromParcel(Parcel r10) {
            return a(r10);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ Object[] newArray(int r10) {
            return b(r10);
        }
    }

    static {
        CREATOR = new a();
    }

    public WsApi() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getMethod() {
        return this.method;
    }

    public int getService() {
        return this.service;
    }

    public void parseFromJson(JSONObject r10) {
        if (r10 != null) goto L4;
        return;
    L4:
        this.service = r10.optInt("service");
        this.method = r10.optInt("method");
    }

    public void setMethod(int r10) {
        this.method = r10;
    }

    public void setService(int r10) {
        this.service = r10;
    }

    public JSONObject toJson() throws JSONException {
        JSONObject r10 = new JSONObject();
        r10.put("service", this.service);
        r10.put("method", this.method);
        return r10;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r10, int r11) {
        r10.writeInt(this.service);
        r10.writeInt(this.method);
    }
}
