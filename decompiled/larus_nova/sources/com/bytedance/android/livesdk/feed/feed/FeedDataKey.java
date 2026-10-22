package com.bytedance.android.livesdk.feed.feed;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;

/* JADX INFO: loaded from: classes8.dex */
public class FeedDataKey implements Parcelable {
    public static final Parcelable.Creator<FeedDataKey> CREATOR = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Integer f124001e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Integer f124002f = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f124003a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f124004b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f124005c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f124006d;

    public class a implements Parcelable.Creator<FeedDataKey> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final FeedDataKey createFromParcel(Parcel r100) {
            return new FeedDataKey(r100.readString(), r100.readString(), r100.readLong(), r100.readInt());
        }

        @Override // android.os.Parcelable.Creator
        public final FeedDataKey[] newArray(int r100) {
            return new FeedDataKey[r100];
        }
    }

    static {
        f124001e = 1;
        f124002f = 31;
        CREATOR = new a();
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final int hashCode() {
        Integer r100 = f124002f;
        int r101 = r100.intValue();
        String r102 = this.f124004b;
        int r103 = 0;
        if (r102 == null) goto L5;
        int r104 = r102.hashCode();
    L6:
        int r105 = r101 + r104;
        int r106 = r100.intValue() * r105;
        String r107 = this.f124003a;
        if (r107 == null) goto L9;
        r103 = r107.hashCode();
    L9:
        int r108 = r100.intValue();
        return (r108 * (r106 + r103)) + Long.valueOf(this.f124005c).hashCode();
    L5:
        r104 = 0;
        goto L6
    }

    public final String toString() {
        StringBuilder r100 = new StringBuilder("label: ");
        String r101 = this.f124004b;
        String r102 = "null";
        if (r101 != null) goto L5;
        r101 = "null";
    L5:
        r100.append(r101);
        r100.append("; url: ");
        String r103 = this.f124003a;
        if (r103 == null) goto L9;
        r102 = r103;
    L9:
        r100.append(r102);
        r100.append("; id: ");
        r100.append(this.f124005c);
        r100.append("; repeatCheck: ");
        r100.append(this.f124006d);
        return r100.toString();
    }

    public final boolean equals(Object r100) {
        if (r100 != null) goto L5;
        return false;
    L5:
        if ((r100 instanceof FeedDataKey) == false) goto L19;
        FeedDataKey r101 = (FeedDataKey) r100;
        if (TextUtils.equals(this.f124004b, r101.f124004b) == true) goto L10;
        return false;
    L10:
        if (TextUtils.equals(this.f124003a, r101.f124003a) == true) goto L12;
        return false;
    L12:
        if (this.f124005c != r101.f124005c) goto L18;
        return true;
    L18:
        return false;
    L19:
        return false;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        r100.writeString(this.f124004b);
        r100.writeString(this.f124003a);
        r100.writeLong(this.f124005c);
        r100.writeInt(this.f124006d);
    }

    public static FeedDataKey a(String r100, String r101, long r102) {
        int r103 = f124001e.intValue();
        if (TextUtils.isEmpty(r100) == true) goto L7;
        return new FeedDataKey(r100, r101, r102, r103);
    L7:
        throw new IllegalArgumentException("label must not be null or empty");
    }

    public FeedDataKey(String r100, String r101, long r102, int r103) {
        this.f124003a = "";
        this.f124004b = "";
        this.f124005c = Long.MIN_VALUE;
        this.f124006d = f124001e.intValue();
        this.f124004b = r100;
        this.f124003a = r101;
        this.f124005c = r102;
        this.f124006d = r103;
    }
}
