package com.bytedance.android.shopping.model;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/shopping/model/BoughtParam;", "Landroid/os/Parcelable;", "ec-shopping-api_release"}, k = 1, mv = {1, 4, 3})
public final class BoughtParam implements Parcelable {
    public static final Parcelable.Creator<BoughtParam> CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f178641a;

    public static class a implements Parcelable.Creator<BoughtParam> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final BoughtParam createFromParcel(Parcel r100) {
            Intrinsics.checkNotNullParameter(r100, "in");
            return new BoughtParam(r100.readString());
        }

        @Override // android.os.Parcelable.Creator
        public final BoughtParam[] newArray(int r100) {
            return new BoughtParam[r100];
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
        if ((r100 instanceof BoughtParam) == true) goto L6;
        return false;
    L6:
        if (Intrinsics.areEqual(this.f178641a, ((BoughtParam) r100).f178641a) == true) goto L13;
        return false;
    L13:
        return true;
    }

    public final int hashCode() {
        String r100 = this.f178641a;
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.hashCode();
    }

    public final String toString() {
        return "BoughtParam(id=" + this.f178641a + ")";
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parcel");
        r100.writeString(this.f178641a);
    }

    public BoughtParam(String r100) {
        Intrinsics.checkNotNullParameter(r100, "id");
        this.f178641a = r100;
    }
}
