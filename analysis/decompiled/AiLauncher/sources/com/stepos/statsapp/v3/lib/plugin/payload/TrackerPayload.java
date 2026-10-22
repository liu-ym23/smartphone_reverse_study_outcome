package com.stepos.statsapp.v3.lib.plugin.payload;

import android.os.Parcel;
import android.os.Parcelable;
import com.stepos.statsapp.v3.lib.plugin.utils.Utils;
import com.stepos.statsapp.v3.utils.log.Logger;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class TrackerPayload implements Parcelable {
    public static final Parcelable.Creator<TrackerPayload> CREATOR = new a();
    private static final String KEY_HEADER = "header";
    private static final String KEY_VALUE = "value";
    private static final String TAG = "TrackerPayload";
    private HashMap<String, Object> headerMap;
    private HashMap<String, String> valueMap;

    public class a implements Parcelable.Creator<TrackerPayload> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public TrackerPayload createFromParcel(Parcel parcel) {
            return new TrackerPayload(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public TrackerPayload[] newArray(int i10) {
            return new TrackerPayload[i10];
        }
    }

    public TrackerPayload() {
        this.headerMap = new HashMap<>();
        this.valueMap = new HashMap<>();
    }

    private void addValueMapInner(Map<String, Object> map) {
        if (map == null) {
            Logger.v(TAG, "Map passed in is null, returning without adding map.");
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
            trackerPayload.addHeaderMap(Utils.jsonObjectToMap(jSONObject.getJSONObject(KEY_HEADER)));
            trackerPayload.addValueMapInner(Utils.jsonObjectToMap(jSONObject.getJSONObject("value")));
            return trackerPayload;
        } catch (Exception e10) {
            Logger.e(TAG, "fromString error " + e10);
            return null;
        }
    }

    public void addHeader(String str, Object obj) {
        if (obj == null) {
            Logger.v(TAG, "The keys value is empty, returning without add");
        } else {
            this.headerMap.put(str, obj);
        }
    }

    public void addHeaderMap(Map<String, Object> map) {
        if (map == null) {
            Logger.v(TAG, "Map passed in is null, returning without adding map.");
        } else {
            this.headerMap.putAll(map);
        }
    }

    public void addValueMap(Map<String, String> map) {
        if (map == null) {
            Logger.v(TAG, "Map passed in is null, returning without adding map.");
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
        Logger.v(TAG, "Removing key: " + str);
        this.headerMap.remove(str);
    }

    public String toString() throws JSONException {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(KEY_HEADER, new JSONObject(this.headerMap));
            jSONObject.put("value", new JSONObject(this.valueMap));
            return jSONObject.toString();
        } catch (Exception e10) {
            Logger.e(TAG, "toString error " + e10);
            return "";
        }
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeMap(this.headerMap);
        parcel.writeMap(this.valueMap);
    }

    public TrackerPayload(Parcel parcel) {
        this.headerMap = parcel.readHashMap(HashMap.class.getClassLoader());
        this.valueMap = parcel.readHashMap(HashMap.class.getClassLoader());
    }
}
