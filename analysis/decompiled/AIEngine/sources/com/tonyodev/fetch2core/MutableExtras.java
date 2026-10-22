package com.tonyodev.fetch2core;

import android.os.Parcel;
import android.os.Parcelable;
import java.io.Serializable;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.g;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public class MutableExtras extends Extras implements Serializable {
    public static final a CREATOR = new a();
    private final Map<String, String> mutableData;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class a implements Parcelable.Creator<MutableExtras> {
        @Override // android.os.Parcelable.Creator
        public final MutableExtras createFromParcel(Parcel source) {
            g.f(source, "source");
            Serializable serializable = source.readSerializable();
            g.d(serializable, "null cannot be cast to non-null type java.util.HashMap<kotlin.String, kotlin.String>");
            return new MutableExtras(kotlin.collections.b.o0((HashMap) serializable));
        }

        @Override // android.os.Parcelable.Creator
        public final MutableExtras[] newArray(int i10) {
            return new MutableExtras[i10];
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public MutableExtras() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public final void clear() {
        this.mutableData.clear();
    }

    @Override // com.tonyodev.fetch2core.Extras, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.tonyodev.fetch2core.Extras
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!getClass().equals(obj != null ? obj.getClass() : null) || !super.equals(obj)) {
            return false;
        }
        g.d(obj, "null cannot be cast to non-null type com.tonyodev.fetch2core.MutableExtras");
        return g.b(this.mutableData, ((MutableExtras) obj).mutableData);
    }

    public final Map<String, String> getMutableData() {
        return this.mutableData;
    }

    @Override // com.tonyodev.fetch2core.Extras
    public int hashCode() {
        return this.mutableData.hashCode() + (super.hashCode() * 31);
    }

    public final void putBoolean(String key, boolean z) {
        g.f(key, "key");
        this.mutableData.put(key, String.valueOf(z));
    }

    public final void putDouble(String key, double d8) {
        g.f(key, "key");
        this.mutableData.put(key, String.valueOf(d8));
    }

    public final void putFloat(String key, float f8) {
        g.f(key, "key");
        this.mutableData.put(key, String.valueOf(f8));
    }

    public final void putInt(String key, int i10) {
        g.f(key, "key");
        this.mutableData.put(key, String.valueOf(i10));
    }

    public final void putLong(String key, long j10) {
        g.f(key, "key");
        this.mutableData.put(key, String.valueOf(j10));
    }

    public final void putString(String key, String value) {
        g.f(key, "key");
        g.f(value, "value");
        this.mutableData.put(key, value);
    }

    public final Extras toExtras() {
        return new Extras(kotlin.collections.b.n0(this.mutableData));
    }

    @Override // com.tonyodev.fetch2core.Extras
    public String toString() {
        return toJSONString();
    }

    @Override // com.tonyodev.fetch2core.Extras, android.os.Parcelable
    public void writeToParcel(Parcel dest, int i10) {
        g.f(dest, "dest");
        dest.writeSerializable(new HashMap(this.mutableData));
    }

    public /* synthetic */ MutableExtras(Map map, int i10, e eVar) {
        this((i10 & 1) != 0 ? new LinkedHashMap() : map);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MutableExtras(Map<String, String> mutableData) {
        super(mutableData);
        g.f(mutableData, "mutableData");
        this.mutableData = mutableData;
    }
}
