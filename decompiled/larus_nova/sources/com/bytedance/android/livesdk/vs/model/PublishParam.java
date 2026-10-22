package com.bytedance.android.livesdk.vs.model;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/livesdk/vs/model/PublishParam;", "Landroid/os/Parcelable;", "vs-model_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PublishParam implements Parcelable {
    public static final Parcelable.Creator<PublishParam> CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f159394a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f159395b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f159396c;

    public static class a implements Parcelable.Creator<PublishParam> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final PublishParam createFromParcel(Parcel r100) {
            Intrinsics.checkNotNullParameter(r100, "in");
            return new PublishParam(r100.readString(), r100.readString(), r100.readInt());
        }

        @Override // android.os.Parcelable.Creator
        public final PublishParam[] newArray(int r100) {
            return new PublishParam[r100];
        }
    }

    static {
        CREATOR = new a();
    }

    public PublishParam() {
        String r100 = null;
        this(r100, r100, 7, 0);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof PublishParam) == false) goto L12;
        PublishParam r101 = (PublishParam) r100;
        if (Intrinsics.areEqual(this.f159394a, r101.f159394a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f159395b, r101.f159395b) == true) goto L10;
        return false;
    L10:
        if (this.f159396c == r101.f159396c) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        String r100 = this.f159394a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.f159395b;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        return ((r103 + r101) * 31) + this.f159396c;
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "PublishParam(shareFromKey=" + this.f159394a + ", shareFromType=" + this.f159395b + ", activityVideoType=" + this.f159396c + ")";
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parcel");
        r100.writeString(this.f159394a);
        r100.writeString(this.f159395b);
        r100.writeInt(this.f159396c);
    }

    public PublishParam(String r100, String r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "shareFromKey");
        Intrinsics.checkNotNullParameter(r101, "shareFromType");
        this.f159394a = r100;
        this.f159395b = r101;
        this.f159396c = r102;
    }

    public /* synthetic */ PublishParam(String r100, String r101, int r102, int r103) {
        if ((r102 & 1) == 0) goto L6;
        r100 = "";
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = "";
    L8:
        this(r100, r101, 0);
    }
}
