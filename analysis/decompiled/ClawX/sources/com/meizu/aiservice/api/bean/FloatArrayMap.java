package com.meizu.aiservice.api.bean;

import android.os.Parcel;
import android.os.Parcelable;
import b.a;
import java.util.HashMap;
import java.util.Map;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
@a
/* loaded from: classes.dex */
public class FloatArrayMap implements Parcelable {
    public static final Parcelable.Creator<FloatArrayMap> CREATOR = new a3.a(0);
    private final Map<String, float[]> stringMap;

    public FloatArrayMap(Map<String, float[]> map) {
        this.stringMap = map;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public float[] get(String str) {
        return this.stringMap.get(str);
    }

    public Map<String, float[]> getMap() {
        return this.stringMap;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i8) {
        parcel.writeInt(this.stringMap.size());
        for (Map.Entry<String, float[]> entry : this.stringMap.entrySet()) {
            float[] value = entry.getValue();
            parcel.writeString(entry.getKey());
            parcel.writeInt(value.length);
            parcel.writeFloatArray(value);
        }
    }

    public FloatArrayMap(Parcel parcel) {
        int i8 = parcel.readInt();
        this.stringMap = new HashMap();
        for (int i9 = 0; i9 < i8; i9++) {
            String string = parcel.readString();
            float[] fArr = new float[parcel.readInt()];
            parcel.readFloatArray(fArr);
            this.stringMap.put(string, fArr);
        }
    }
}
