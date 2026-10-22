package com.tonyodev.fetch2core;

import android.os.Parcel;
import android.os.Parcelable;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.internal.g;
import org.json.JSONObject;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public class Extras implements Parcelable, Serializable {
    public static final a CREATOR = new a();
    private static final Extras emptyExtras = new Extras(kotlin.collections.b.d0());
    private final Map<String, String> data;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class a implements Parcelable.Creator<Extras> {
        @Override // android.os.Parcelable.Creator
        public final Extras createFromParcel(Parcel source) {
            g.f(source, "source");
            Serializable serializable = source.readSerializable();
            g.d(serializable, "null cannot be cast to non-null type java.util.HashMap<kotlin.String, kotlin.String>");
            return new Extras((HashMap) serializable);
        }

        @Override // android.os.Parcelable.Creator
        public final Extras[] newArray(int i10) {
            return new Extras[i10];
        }
    }

    public Extras(Map<String, String> data) {
        g.f(data, "data");
        this.data = data;
    }

    public static final Extras getEmptyExtras() {
        CREATOR.getClass();
        return emptyExtras;
    }

    public Extras copy() {
        return new Extras(kotlin.collections.b.n0(this.data));
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!getClass().equals(obj != null ? obj.getClass() : null)) {
            return false;
        }
        g.d(obj, "null cannot be cast to non-null type com.tonyodev.fetch2core.Extras");
        return g.b(this.data, ((Extras) obj).data);
    }

    public final boolean getBoolean(String key, boolean z) {
        g.f(key, "key");
        String str = this.data.get(key);
        return str != null ? Boolean.parseBoolean(str) : z;
    }

    public final Map<String, String> getData() {
        return this.data;
    }

    public final double getDouble(String key, double d8) {
        g.f(key, "key");
        String str = this.data.get(key);
        return str != null ? Double.parseDouble(str) : d8;
    }

    public final float getFloat(String key, float f8) {
        g.f(key, "key");
        String str = this.data.get(key);
        return str != null ? Float.parseFloat(str) : f8;
    }

    public final int getInt(String key, int i10) {
        g.f(key, "key");
        String str = this.data.get(key);
        return str != null ? Integer.parseInt(str) : i10;
    }

    public final long getLong(String key, long j10) {
        g.f(key, "key");
        String str = this.data.get(key);
        return str != null ? Long.parseLong(str) : j10;
    }

    public final Map<String, String> getMap() {
        return kotlin.collections.b.n0(this.data);
    }

    public final int getSize() {
        return this.data.size();
    }

    public final String getString(String key, String defaultValue) {
        g.f(key, "key");
        g.f(defaultValue, "defaultValue");
        String str = this.data.get(key);
        return str == null ? defaultValue : str;
    }

    public int hashCode() {
        return this.data.hashCode();
    }

    public final boolean isEmpty() {
        return this.data.isEmpty();
    }

    public final boolean isNotEmpty() {
        return !this.data.isEmpty();
    }

    public final JSONObject toJSONObject() {
        return isEmpty() ? new JSONObject() : new JSONObject(getMap());
    }

    public final String toJSONString() {
        if (isEmpty()) {
            return "{}";
        }
        String string = new JSONObject(getMap()).toString();
        g.c(string);
        return string;
    }

    public final MutableExtras toMutableExtras() {
        return new MutableExtras(kotlin.collections.b.o0(this.data));
    }

    public String toString() {
        return toJSONString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int i10) {
        g.f(dest, "dest");
        dest.writeSerializable(new HashMap(this.data));
    }
}
