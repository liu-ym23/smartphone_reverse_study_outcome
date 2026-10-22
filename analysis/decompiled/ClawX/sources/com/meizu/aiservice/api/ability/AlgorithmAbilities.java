package com.meizu.aiservice.api.ability;

import android.os.Parcel;
import android.os.Parcelable;
import b.a;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
@a
/* loaded from: classes.dex */
public class AlgorithmAbilities implements Parcelable {
    public static final Parcelable.Creator<AlgorithmAbilities> CREATOR = new a3.a(15);
    private final String[] abilities;
    private final String algorithm;
    private final String category;

    public AlgorithmAbilities(String str, String str2, String[] strArr) {
        this.algorithm = str;
        this.category = str2;
        this.abilities = strArr;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String[] getAbilities() {
        return this.abilities;
    }

    public String getAlgorithm() {
        return this.algorithm;
    }

    public String getCategory() {
        return this.category;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i8) {
        parcel.writeString(this.algorithm);
        parcel.writeStringArray(this.abilities);
        parcel.writeString(this.category);
    }

    public AlgorithmAbilities(Parcel parcel) {
        this.algorithm = parcel.readString();
        this.abilities = parcel.createStringArray();
        this.category = parcel.readString();
    }
}
