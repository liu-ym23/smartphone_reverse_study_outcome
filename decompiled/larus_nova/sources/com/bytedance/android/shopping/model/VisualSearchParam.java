package com.bytedance.android.shopping.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.bytedance.android.ec.model.ECUrlModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/shopping/model/VisualSearchParam;", "Landroid/os/Parcelable;", "ec-shopping-api_release"}, k = 1, mv = {1, 4, 3})
public final class VisualSearchParam implements Parcelable {
    public static final Parcelable.Creator<VisualSearchParam> CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f178647a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f178648b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ECUrlModel f178649c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final VisualSearchLogData f178650d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f178651e;

    public static class a implements Parcelable.Creator<VisualSearchParam> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final VisualSearchParam createFromParcel(Parcel r100) {
            Intrinsics.checkNotNullParameter(r100, "in");
            return new VisualSearchParam(r100.readString(), r100.readInt(), (ECUrlModel) r100.readParcelable(VisualSearchParam.class.getClassLoader()), VisualSearchLogData.CREATOR.createFromParcel(r100), r100.readLong());
        }

        @Override // android.os.Parcelable.Creator
        public final VisualSearchParam[] newArray(int r100) {
            return new VisualSearchParam[r100];
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
        if ((r100 instanceof VisualSearchParam) == false) goto L16;
        VisualSearchParam r101 = (VisualSearchParam) r100;
        if (Intrinsics.areEqual(this.f178647a, r101.f178647a) == true) goto L8;
        return false;
    L8:
        if (this.f178648b == r101.f178648b) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f178649c, r101.f178649c) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f178650d, r101.f178650d) == true) goto L14;
        return false;
    L14:
        if (this.f178651e == r101.f178651e) goto L25;
        return false;
    L25:
        return true;
    L16:
        return false;
    }

    public final int hashCode() {
        String r100 = this.f178647a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = ((r102 * 31) + this.f178648b) * 31;
        ECUrlModel r104 = this.f178649c;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        VisualSearchLogData r107 = this.f178650d;
        if (r107 == null) goto L13;
        r101 = r107.hashCode();
    L13:
        int r108 = (r106 + r101) * 31;
        long r109 = this.f178651e;
        return r108 + ((int) (r109 ^ (r109 >>> 32)));
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "VisualSearchParam(itemId=" + this.f178647a + ", searchType=" + this.f178648b + ", imageUrl=" + this.f178649c + ", logData=" + this.f178650d + ", clickTimestamp=" + this.f178651e + ")";
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parcel");
        r100.writeString(this.f178647a);
        r100.writeInt(this.f178648b);
        r100.writeParcelable(this.f178649c, r101);
        this.f178650d.writeToParcel(r100, 0);
        r100.writeLong(this.f178651e);
    }

    public VisualSearchParam(String r100, int r101, ECUrlModel r102, VisualSearchLogData r103, long r104) {
        Intrinsics.checkNotNullParameter(r100, "itemId");
        Intrinsics.checkNotNullParameter(r103, "logData");
        this.f178647a = r100;
        this.f178648b = r101;
        this.f178649c = r102;
        this.f178650d = r103;
        this.f178651e = r104;
    }
}
