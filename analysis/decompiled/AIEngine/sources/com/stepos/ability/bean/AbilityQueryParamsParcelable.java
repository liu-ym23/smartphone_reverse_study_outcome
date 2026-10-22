package com.stepos.ability.bean;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.jvm.internal.g;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class AbilityQueryParamsParcelable implements Parcelable {
    public static final a CREATOR = new a();
    private final String type;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class a implements Parcelable.Creator<AbilityQueryParamsParcelable> {
        @Override // android.os.Parcelable.Creator
        public final AbilityQueryParamsParcelable createFromParcel(Parcel parcel) {
            g.f(parcel, "parcel");
            return new AbilityQueryParamsParcelable(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final AbilityQueryParamsParcelable[] newArray(int i10) {
            return new AbilityQueryParamsParcelable[i10];
        }
    }

    public AbilityQueryParamsParcelable(String type) {
        g.f(type, "type");
        this.type = type;
    }

    public static /* synthetic */ AbilityQueryParamsParcelable copy$default(AbilityQueryParamsParcelable abilityQueryParamsParcelable, String str, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = abilityQueryParamsParcelable.type;
        }
        return abilityQueryParamsParcelable.copy(str);
    }

    public final String component1() {
        return this.type;
    }

    public final AbilityQueryParamsParcelable copy(String type) {
        g.f(type, "type");
        return new AbilityQueryParamsParcelable(type);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof AbilityQueryParamsParcelable) && g.b(this.type, ((AbilityQueryParamsParcelable) obj).type);
    }

    public final String getType() {
        return this.type;
    }

    public int hashCode() {
        return this.type.hashCode();
    }

    public String toString() {
        return a0.a.k("AbilityQueryParamsParcelable(type=", this.type, ")");
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int i10) {
        g.f(dest, "dest");
        dest.writeString(this.type);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public AbilityQueryParamsParcelable(Parcel parcel) {
        g.f(parcel, "parcel");
        String string = parcel.readString();
        this(string == null ? "" : string);
    }
}
