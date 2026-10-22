package com.bytedance.android.livesdk.interactivity.api.comment;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/api/comment/CommonInputParams;", "Landroid/os/Parcelable;", "interactivity-platform-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class CommonInputParams implements Parcelable {
    public static final Parcelable.Creator<CommonInputParams> CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f133027a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f133028b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f133029c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f133030d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f133031e;

    public static class a implements Parcelable.Creator<CommonInputParams> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final CommonInputParams createFromParcel(Parcel r100) {
            Intrinsics.checkNotNullParameter(r100, "in");
            boolean r101 = false;
            if (r100.readInt() == 0) goto L5;
            boolean r102 = true;
        L7:
            if (r100.readInt() == 0) goto L9;
            r101 = true;
        L9:
            boolean r103 = r102;
            return new CommonInputParams(r103, r101, r100.readString(), r100.readString(), r100.readInt());
        L5:
            r102 = false;
            goto L7
        }

        @Override // android.os.Parcelable.Creator
        public final CommonInputParams[] newArray(int r100) {
            return new CommonInputParams[r100];
        }
    }

    static {
        CREATOR = new a();
    }

    public CommonInputParams() {
        this(false, false, null, null, 31, 0);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parcel");
        r100.writeInt(this.f133027a ? 1 : 0);
        r100.writeInt(this.f133028b ? 1 : 0);
        r100.writeString(this.f133029c);
        r100.writeString(this.f133030d);
        r100.writeInt(this.f133031e);
    }

    public CommonInputParams(boolean r100, boolean r101, String r102, String r103, int r104) {
        Intrinsics.checkNotNullParameter(r102, "hint");
        Intrinsics.checkNotNullParameter(r103, "input");
        this.f133027a = r100;
        this.f133028b = r101;
        this.f133029c = r102;
        this.f133030d = r103;
        this.f133031e = r104;
    }

    public /* synthetic */ CommonInputParams(boolean r100, boolean r101, String r110, String r111, int r112, int r113) {
        if ((r112 & 1) == 0) goto L5;
        boolean r102 = false;
    L7:
        if ((r112 & 2) == 0) goto L9;
        boolean r103 = false;
    L11:
        if ((r112 & 4) == 0) goto L13;
        String r104 = "";
    L15:
        if ((r112 & 8) == 0) goto L17;
        String r105 = "";
    L19:
        if ((r112 & 16) == 0) goto L21;
        int r106 = 50;
    L22:
        this(r102, r103, r104, r105, r106);
        return;
    L21:
        r106 = 0;
        goto L22
    L17:
        r105 = r111;
        goto L19
    L13:
        r104 = r110;
        goto L15
    L9:
        r103 = r101;
        goto L11
    L5:
        r102 = r100;
        goto L7
    }
}
