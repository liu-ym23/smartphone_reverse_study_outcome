package com.stepos.statsapp.v3.lib.plugin.payload;

import android.os.Parcel;
import android.os.Parcelable;
import d3.C0672h;
import g3.C0742e;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
import org.libpag.BuildConfig;

/* loaded from: classes.dex */
public class TrackerPayload implements Parcelable {
    public static final Parcelable.Creator<TrackerPayload> CREATOR = new a();

    /* renamed from: a, reason: collision with root package name */
    private HashMap<String, Object> f15921a;

    /* renamed from: b, reason: collision with root package name */
    private HashMap<String, String> f15922b;

    class a implements Parcelable.Creator<TrackerPayload> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public TrackerPayload createFromParcel(Parcel parcel) {
            return new TrackerPayload(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public TrackerPayload[] newArray(int i5) {
            return new TrackerPayload[i5];
        }
    }

    public TrackerPayload() {
        this.f15921a = new HashMap<>();
        this.f15922b = new HashMap<>();
    }

    private void A(Map<String, Object> map) {
        if (map == null) {
            C0742e.k("TrackerPayload", "Map passed in is null, returning without adding map.");
            return;
        }
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            this.f15922b.put(entry.getKey(), String.valueOf(entry.getValue()));
        }
    }

    public static TrackerPayload B(String str) {
        try {
            TrackerPayload trackerPayload = new TrackerPayload();
            JSONObject jSONObject = new JSONObject(str);
            trackerPayload.c(C0672h.d(jSONObject.getJSONObject("header")));
            trackerPayload.A(C0672h.d(jSONObject.getJSONObject("value")));
            return trackerPayload;
        } catch (Exception e6) {
            C0742e.d("TrackerPayload", "fromString error " + e6);
            return null;
        }
    }

    public Map D() {
        return this.f15921a;
    }

    public Map<String, String> F() {
        return this.f15922b;
    }

    public void a(String str, Object obj) {
        if (obj == null) {
            C0742e.k("TrackerPayload", "The keys value is empty, returning without add");
        } else {
            this.f15921a.put(str, obj);
        }
    }

    public void c(Map<String, Object> map) {
        if (map == null) {
            C0742e.k("TrackerPayload", "Map passed in is null, returning without adding map.");
        } else {
            this.f15921a.putAll(map);
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public void f(Map<String, String> map) {
        if (map == null) {
            C0742e.k("TrackerPayload", "Map passed in is null, returning without adding map.");
        } else {
            this.f15922b.putAll(map);
        }
    }

    public String toString() throws JSONException {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("header", new JSONObject(this.f15921a));
            jSONObject.put("value", new JSONObject(this.f15922b));
            return jSONObject.toString();
        } catch (Exception e6) {
            C0742e.d("TrackerPayload", "toString error " + e6);
            return BuildConfig.FLAVOR;
        }
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i5) {
        parcel.writeMap(this.f15921a);
        parcel.writeMap(this.f15922b);
    }

    public TrackerPayload(Parcel parcel) {
        this.f15921a = parcel.readHashMap(HashMap.class.getClassLoader());
        this.f15922b = parcel.readHashMap(HashMap.class.getClassLoader());
    }
}
