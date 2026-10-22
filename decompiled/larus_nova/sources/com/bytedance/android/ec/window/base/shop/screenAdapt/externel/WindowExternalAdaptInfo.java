package com.bytedance.android.ec.window.base.shop.screenAdapt.externel;

import android.os.Parcel;
import android.os.Parcelable;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00022\u00020\u0001:\u0001\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/ec/window/base/shop/screenAdapt/externel/WindowExternalAdaptInfo;", "Landroid/os/Parcelable;", "CREATOR", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class WindowExternalAdaptInfo implements Parcelable {
    public static final a CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f49664a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float f49665b;

    public static final class a implements Parcelable.Creator<WindowExternalAdaptInfo> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final WindowExternalAdaptInfo createFromParcel(Parcel r100) {
            Intrinsics.checkNotNullParameter(r100, "parcel");
            return new WindowExternalAdaptInfo(r100);
        }

        @Override // android.os.Parcelable.Creator
        public final WindowExternalAdaptInfo[] newArray(int r100) {
            return new WindowExternalAdaptInfo[r100];
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
        return "ExternalAdaptInfo{isBaseOnWidth=" + this.f49664a + ",sizeInDp=" + this.f49665b + '}';
    }

    public WindowExternalAdaptInfo(Parcel r100) {
        Intrinsics.checkNotNullParameter(r100, "parcel");
        boolean r101 = false;
        if (r100.readByte() == ((byte) 0)) goto L5;
        r101 = true;
    L5:
        this.f49664a = r101;
        this.f49665b = r100.readFloat();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "dest");
        if (this.f49664a == false) goto L5;
        int r102 = 1;
    L6:
        r100.writeByte((byte) r102);
        r100.writeFloat(this.f49665b);
        return;
    L5:
        r102 = 0;
        goto L6
    }
}
