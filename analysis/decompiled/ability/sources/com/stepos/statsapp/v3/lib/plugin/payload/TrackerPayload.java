package com.stepos.statsapp.v3.lib.plugin.payload;

import L.g;
import T5.b;
import W5.c;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class TrackerPayload implements Parcelable {
    public static final Parcelable.Creator<TrackerPayload> CREATOR = new g(2);
    private static final String KEY_HEADER = "header";
    private static final String KEY_VALUE = "value";
    private static final String TAG = "TrackerPayload";
    private HashMap<String, Object> headerMap;
    private HashMap<String, String> valueMap;

    public TrackerPayload() {
        this.headerMap = new HashMap<>();
        this.valueMap = new HashMap<>();
    }

    private void addValueMapInner(Map<String, Object> map) {
        if (map == null) {
            c.e(TAG, "Map passed in is null, returning without adding map.");
            return;
        }
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            this.valueMap.put(entry.getKey(), String.valueOf(entry.getValue()));
        }
    }

    public static TrackerPayload fromString(String str) {
        try {
            TrackerPayload trackerPayload = new TrackerPayload();
            JSONObject jSONObject = new JSONObject(str);
            JSONObject jSONObject2 = jSONObject.getJSONObject(KEY_HEADER);
            HashMap map = new HashMap();
            Object obj = JSONObject.NULL;
            if (jSONObject2 != obj) {
                map = b.i(jSONObject2);
            }
            trackerPayload.addHeaderMap(map);
            JSONObject jSONObject3 = jSONObject.getJSONObject(KEY_VALUE);
            HashMap map2 = new HashMap();
            if (jSONObject3 != obj) {
                map2 = b.i(jSONObject3);
            }
            trackerPayload.addValueMapInner(map2);
            return trackerPayload;
        } catch (Exception e) {
            c.b(TAG, "fromString error " + e);
            return null;
        }
    }

    public void addHeader(String str, Object obj) {
        if (obj == null) {
            c.e(TAG, "The keys value is empty, returning without add");
        } else {
            this.headerMap.put(str, obj);
        }
    }

    public void addHeaderMap(Map<String, Object> map) {
        if (map == null) {
            c.e(TAG, "Map passed in is null, returning without adding map.");
        } else {
            this.headerMap.putAll(map);
        }
    }

    public void addValueMap(Map<String, String> map) {
        if (map == null) {
            c.e(TAG, "Map passed in is null, returning without adding map.");
        } else {
            this.valueMap.putAll(map);
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public Map getHeaderMap() {
        return this.headerMap;
    }

    public Map<String, String> getValueMap() {
        return this.valueMap;
    }

    public void remove(String str) {
        c.e(TAG, "Removing key: " + str);
        this.headerMap.remove(str);
    }

    public String toString() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(KEY_HEADER, new JSONObject((Map<?, ?>) this.headerMap));
            jSONObject.put(KEY_VALUE, new JSONObject((Map<?, ?>) this.valueMap));
            return jSONObject.toString();
        } catch (Exception e) {
            c.b(TAG, "toString error " + e);
            return "";
        }
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeMap(this.headerMap);
        parcel.writeMap(this.valueMap);
    }

    public TrackerPayload(Parcel parcel) {
        this.headerMap = parcel.readHashMap(HashMap.class.getClassLoader());
        this.valueMap = parcel.readHashMap(HashMap.class.getClassLoader());
    }
}
