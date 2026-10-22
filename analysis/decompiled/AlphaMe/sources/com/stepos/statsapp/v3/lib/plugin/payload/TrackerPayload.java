package com.stepos.statsapp.v3.lib.plugin.payload;

import Q2.c;
import T2.d;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.material.internal.f;
import java.util.AbstractMap;
import java.util.HashMap;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class TrackerPayload implements Parcelable {
    public static final Parcelable.Creator<TrackerPayload> CREATOR = new f(5);

    /* renamed from: a, reason: collision with root package name */
    public HashMap f12343a = new HashMap();

    public static TrackerPayload g(String str) {
        try {
            TrackerPayload trackerPayload = new TrackerPayload();
            JSONObject jSONObject = new JSONObject(str);
            HashMap map = new HashMap();
            if (jSONObject != JSONObject.NULL) {
                map = c.f(jSONObject);
            }
            trackerPayload.f(map);
            return trackerPayload;
        } catch (Exception e4) {
            d.b("TrackerPayload", "fromString error " + e4);
            return null;
        }
    }

    public final void c(Object obj, String str) {
        if (obj == null) {
            d.e("TrackerPayload", "The keys value is empty, returning without add");
        } else {
            this.f12343a.put(str, obj);
        }
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final void f(AbstractMap abstractMap) {
        if (abstractMap == null) {
            d.e("TrackerPayload", "Map passed in is null, returning without adding map.");
        } else {
            this.f12343a.putAll(abstractMap);
        }
    }

    public final String toString() {
        try {
            return new JSONObject(this.f12343a).toString();
        } catch (Exception e4) {
            d.b("TrackerPayload", "toString error " + e4);
            return "";
        }
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i4) {
        parcel.writeMap(this.f12343a);
    }
}
