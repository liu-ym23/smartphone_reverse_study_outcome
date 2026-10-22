package com.stepos.statsapp.v3.lib.plugin.payload;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.os.a;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
import ra.b;
import ua.c;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public class TrackerPayload implements Parcelable {
    public static final Parcelable.Creator<TrackerPayload> CREATOR = new a(15);

    /* renamed from: c, reason: collision with root package name */
    public HashMap f2842c = new HashMap();

    /* renamed from: f, reason: collision with root package name */
    public HashMap f2843f = new HashMap();

    public static TrackerPayload c(String str) throws JSONException {
        try {
            TrackerPayload trackerPayload = new TrackerPayload();
            JSONObject jSONObject = new JSONObject(str);
            JSONObject jSONObject2 = jSONObject.getJSONObject("header");
            HashMap map = new HashMap();
            Object obj = JSONObject.NULL;
            if (jSONObject2 != obj) {
                map = b.i(jSONObject2);
            }
            trackerPayload.b(map);
            JSONObject jSONObject3 = jSONObject.getJSONObject("value");
            HashMap map2 = new HashMap();
            if (jSONObject3 != obj) {
                map2 = b.i(jSONObject3);
            }
            for (Map.Entry entry : map2.entrySet()) {
                trackerPayload.f2843f.put((String) entry.getKey(), String.valueOf(entry.getValue()));
            }
            return trackerPayload;
        } catch (Exception e10) {
            c.b("TrackerPayload", "fromString error " + e10);
            return null;
        }
    }

    public final void a(Object obj, String str) {
        if (obj == null) {
            c.e("TrackerPayload", "The keys value is empty, returning without add");
        } else {
            this.f2842c.put(str, obj);
        }
    }

    public final void b(Map map) {
        if (map == null) {
            c.e("TrackerPayload", "Map passed in is null, returning without adding map.");
        } else {
            this.f2842c.putAll(map);
        }
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final String toString() throws JSONException {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("header", new JSONObject(this.f2842c));
            jSONObject.put("value", new JSONObject(this.f2843f));
            return jSONObject.toString();
        } catch (Exception e10) {
            c.b("TrackerPayload", "toString error " + e10);
            return "";
        }
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeMap(this.f2842c);
        parcel.writeMap(this.f2843f);
    }
}
