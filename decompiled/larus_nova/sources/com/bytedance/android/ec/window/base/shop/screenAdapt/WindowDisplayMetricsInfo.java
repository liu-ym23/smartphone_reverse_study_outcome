package com.bytedance.android.ec.window.base.shop.screenAdapt;

import android.os.Parcel;
import android.os.Parcelable;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00022\u00020\u0001:\u0001\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/ec/window/base/shop/screenAdapt/WindowDisplayMetricsInfo;", "Landroid/os/Parcelable;", "CREATOR", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class WindowDisplayMetricsInfo implements Parcelable {
    public static final a CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float f49657a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f49658b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final float f49659c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final float f49660d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f49661e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f49662f;

    public static final class a implements Parcelable.Creator<WindowDisplayMetricsInfo> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final WindowDisplayMetricsInfo createFromParcel(Parcel r100) {
            Intrinsics.checkNotNullParameter(r100, "source");
            return new WindowDisplayMetricsInfo(r100);
        }

        @Override // android.os.Parcelable.Creator
        public final WindowDisplayMetricsInfo[] newArray(int r100) {
            return new WindowDisplayMetricsInfo[r100];
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
        return "DisplayMetricsInfo{density=" + this.f49657a + ",densityDpi=" + this.f49658b + ",scaledDensity=" + this.f49659c + ",xdpi=" + this.f49660d + ",screenWidthDp=" + this.f49661e + ",screenHeightDp=" + this.f49662f;
    }

    public WindowDisplayMetricsInfo(Parcel r100) {
        Intrinsics.checkNotNullParameter(r100, "parcel");
        this.f49657a = r100.readFloat();
        this.f49658b = r100.readInt();
        this.f49659c = r100.readFloat();
        this.f49660d = r100.readFloat();
        this.f49661e = r100.readInt();
        this.f49662f = r100.readInt();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "dest");
        r100.writeFloat(this.f49657a);
        r100.writeInt(this.f49658b);
        r100.writeFloat(this.f49659c);
        r100.writeFloat(this.f49660d);
        r100.writeInt(this.f49661e);
        r100.writeInt(this.f49662f);
    }

    public WindowDisplayMetricsInfo(float r100, int r101, float r102, float r103, int r104, int r105) {
        this.f49657a = r100;
        this.f49658b = r101;
        this.f49659c = r102;
        this.f49660d = r103;
        this.f49661e = r104;
        this.f49662f = r105;
    }
}
