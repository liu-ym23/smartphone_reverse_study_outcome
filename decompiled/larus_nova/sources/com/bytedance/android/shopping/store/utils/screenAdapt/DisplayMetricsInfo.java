package com.bytedance.android.shopping.store.utils.screenAdapt;

import android.os.Parcel;
import android.os.Parcelable;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00022\u00020\u0001:\u0001\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/shopping/store/utils/screenAdapt/DisplayMetricsInfo;", "Landroid/os/Parcelable;", "CREATOR", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class DisplayMetricsInfo implements Parcelable {
    public static final a CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float f186966a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f186967b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final float f186968c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final float f186969d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f186970e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f186971f;

    public static final class a implements Parcelable.Creator<DisplayMetricsInfo> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final DisplayMetricsInfo createFromParcel(Parcel r100) {
            Intrinsics.checkNotNullParameter(r100, "source");
            return new DisplayMetricsInfo(r100);
        }

        @Override // android.os.Parcelable.Creator
        public final DisplayMetricsInfo[] newArray(int r100) {
            return new DisplayMetricsInfo[r100];
        }
    }

    static {
        CREATOR = new a();
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final String toString() {
        return "DisplayMetricsInfo{density=" + this.f186966a + ",densityDpi=" + this.f186967b + ",scaledDensity=" + this.f186968c + ",xdpi=" + this.f186969d + ",screenWidthDp=" + this.f186970e + ",screenHeightDp=" + this.f186971f;
    }

    public DisplayMetricsInfo(Parcel r100) {
        Intrinsics.checkNotNullParameter(r100, "parcel");
        this.f186966a = r100.readFloat();
        this.f186967b = r100.readInt();
        this.f186968c = r100.readFloat();
        this.f186969d = r100.readFloat();
        this.f186970e = r100.readInt();
        this.f186971f = r100.readInt();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "dest");
        r100.writeFloat(this.f186966a);
        r100.writeInt(this.f186967b);
        r100.writeFloat(this.f186968c);
        r100.writeFloat(this.f186969d);
        r100.writeInt(this.f186970e);
        r100.writeInt(this.f186971f);
    }

    public DisplayMetricsInfo(float r100, int r101, float r102, float r103, int r104, int r105) {
        this.f186966a = r100;
        this.f186967b = r101;
        this.f186968c = r102;
        this.f186969d = r103;
        this.f186970e = r104;
        this.f186971f = r105;
    }
}
