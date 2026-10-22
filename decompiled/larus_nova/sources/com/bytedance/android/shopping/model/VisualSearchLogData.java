package com.bytedance.android.shopping.model;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/shopping/model/VisualSearchLogData;", "Landroid/os/Parcelable;", "ec-shopping-api_release"}, k = 1, mv = {1, 4, 3})
public final class VisualSearchLogData implements Parcelable {
    public static final Parcelable.Creator<VisualSearchLogData> CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f178643a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f178644b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f178645c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f178646d;

    public static class a implements Parcelable.Creator<VisualSearchLogData> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final VisualSearchLogData createFromParcel(Parcel r100) {
            Intrinsics.checkNotNullParameter(r100, "in");
            return new VisualSearchLogData(r100.readString(), r100.readString(), r100.readString(), r100.readString());
        }

        @Override // android.os.Parcelable.Creator
        public final VisualSearchLogData[] newArray(int r100) {
            return new VisualSearchLogData[r100];
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
        if ((r100 instanceof VisualSearchLogData) == false) goto L14;
        VisualSearchLogData r101 = (VisualSearchLogData) r100;
        if (Intrinsics.areEqual(this.f178643a, r101.f178643a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f178644b, r101.f178644b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f178645c, r101.f178645c) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f178646d, r101.f178646d) == true) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    public final int hashCode() {
        String r100 = this.f178643a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.f178644b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.f178645c;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.f178646d;
        if (r110 == null) goto L18;
        r101 = r110.hashCode();
    L18:
        return r109 + r101;
    L13:
        r108 = 0;
        goto L14
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "VisualSearchLogData(groupId=" + this.f178643a + ", sessionId=" + this.f178644b + ", enterFrom=" + this.f178645c + ", labLuckPigObjString=" + this.f178646d + ")";
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parcel");
        r100.writeString(this.f178643a);
        r100.writeString(this.f178644b);
        r100.writeString(this.f178645c);
        r100.writeString(this.f178646d);
    }

    public VisualSearchLogData() {
        this("", "", "", "");
    }

    public VisualSearchLogData(String r100, String r101, String r102, String r103) {
        Intrinsics.checkNotNullParameter(r100, "groupId");
        Intrinsics.checkNotNullParameter(r101, "sessionId");
        Intrinsics.checkNotNullParameter(r102, "enterFrom");
        Intrinsics.checkNotNullParameter(r103, "labLuckPigObjString");
        this.f178643a = r100;
        this.f178644b = r101;
        this.f178645c = r102;
        this.f178646d = r103;
    }
}
