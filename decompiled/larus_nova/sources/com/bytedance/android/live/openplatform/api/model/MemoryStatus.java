package com.bytedance.android.live.openplatform.api.model;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/live/openplatform/api/model/MemoryStatus;", "Landroid/os/Parcelable;", "liveopenplatform-middleware-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class MemoryStatus implements Parcelable {
    public static final Parcelable.Creator<MemoryStatus> CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f83961a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f83962b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f83963c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f83964d;

    public static class a implements Parcelable.Creator<MemoryStatus> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final MemoryStatus createFromParcel(Parcel r100) {
            Intrinsics.checkNotNullParameter(r100, "in");
            return new MemoryStatus(r100.readInt(), r100.readInt(), r100.readInt(), r100.readInt());
        }

        @Override // android.os.Parcelable.Creator
        public final MemoryStatus[] newArray(int r100) {
            return new MemoryStatus[r100];
        }
    }

    static {
        CREATOR = new a();
    }

    public MemoryStatus() {
        this(0);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof MemoryStatus) == false) goto L14;
        MemoryStatus r101 = (MemoryStatus) r100;
        if (this.f83961a == r101.f83961a) goto L8;
        return false;
    L8:
        if (this.f83962b == r101.f83962b) goto L10;
        return false;
    L10:
        if (this.f83963c == r101.f83963c) goto L12;
        return false;
    L12:
        if (this.f83964d == r101.f83964d) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    public final int hashCode() {
        return (((((this.f83961a * 31) + this.f83962b) * 31) + this.f83963c) * 31) + this.f83964d;
    }

    public final String toString() {
        return "MemoryStatus(rememberMiniAppStatus=" + this.f83961a + ", rememberCardStatus=" + this.f83962b + ", showLiveData=" + this.f83963c + ", showImportantCard=" + this.f83964d + ")";
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parcel");
        r100.writeInt(this.f83961a);
        r100.writeInt(this.f83962b);
        r100.writeInt(this.f83963c);
        r100.writeInt(this.f83964d);
    }

    public final boolean b() {
        if (this.f83962b == 1) goto L7;
        return false;
    L7:
        return true;
    }

    public /* synthetic */ MemoryStatus(int r100) {
        this(-1, -1, 1, -1);
    }

    public MemoryStatus(int r100, int r101, int r102, int r103) {
        this.f83961a = r100;
        this.f83962b = r101;
        this.f83963c = r102;
        this.f83964d = r103;
    }

    public static MemoryStatus a(MemoryStatus r100, int r101, int r102, int r103, int r104, int r105) {
        if ((r105 & 1) == 0) goto L6;
        r101 = r100.f83961a;
    L6:
        if ((r105 & 2) == 0) goto L9;
        r102 = r100.f83962b;
    L9:
        if ((r105 & 4) == 0) goto L12;
        r103 = r100.f83963c;
    L12:
        if ((r105 & 8) == 0) goto L14;
        r104 = r100.f83964d;
    L14:
        r100.getClass();
        return new MemoryStatus(r101, r102, r103, r104);
    }
}
