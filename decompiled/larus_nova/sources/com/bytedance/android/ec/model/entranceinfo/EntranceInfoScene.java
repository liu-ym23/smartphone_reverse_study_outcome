package com.bytedance.android.ec.model.entranceinfo;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/ec/model/entranceinfo/EntranceInfoScene;", "Landroid/os/Parcelable;", "ec-model_release"}, k = 1, mv = {1, 4, 3})
public final class EntranceInfoScene implements Parcelable {
    public static final Parcelable.Creator<EntranceInfoScene> CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f47861a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f47862b;

    public static class a implements Parcelable.Creator<EntranceInfoScene> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final EntranceInfoScene createFromParcel(Parcel r100) {
            Intrinsics.checkNotNullParameter(r100, "in");
            return new EntranceInfoScene(r100.readString(), r100.readString());
        }

        @Override // android.os.Parcelable.Creator
        public final EntranceInfoScene[] newArray(int r100) {
            return new EntranceInfoScene[r100];
        }
    }

    static {
        CREATOR = new a();
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof EntranceInfoScene) == false) goto L10;
        EntranceInfoScene r101 = (EntranceInfoScene) r100;
        if (Intrinsics.areEqual(this.f47861a, r101.f47861a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f47862b, r101.f47862b) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        String r100 = this.f47861a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.f47862b;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        return r103 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "EntranceInfoScene(page=" + this.f47861a + ", scene=" + this.f47862b + ")";
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parcel");
        r100.writeString(this.f47861a);
        r100.writeString(this.f47862b);
    }

    public final String a() {
        return this.f47861a + '.' + this.f47862b;
    }

    public EntranceInfoScene(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "page");
        Intrinsics.checkNotNullParameter(r101, "scene");
        this.f47861a = r100;
        this.f47862b = r101;
    }
}
