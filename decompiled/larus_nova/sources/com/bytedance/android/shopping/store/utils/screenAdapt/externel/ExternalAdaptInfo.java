package com.bytedance.android.shopping.store.utils.screenAdapt.externel;

import android.os.Parcel;
import android.os.Parcelable;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00022\u00020\u0001:\u0001\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/shopping/store/utils/screenAdapt/externel/ExternalAdaptInfo;", "Landroid/os/Parcelable;", "CREATOR", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ExternalAdaptInfo implements Parcelable {
    public static final a CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f186973a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float f186974b;

    public static final class a implements Parcelable.Creator<ExternalAdaptInfo> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final ExternalAdaptInfo createFromParcel(Parcel r100) {
            Intrinsics.checkNotNullParameter(r100, "parcel");
            return new ExternalAdaptInfo(r100);
        }

        @Override // android.os.Parcelable.Creator
        public final ExternalAdaptInfo[] newArray(int r100) {
            return new ExternalAdaptInfo[r100];
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
        return "ExternalAdaptInfo{isBaseOnWidth=" + this.f186973a + ",sizeInDp=" + this.f186974b + '}';
    }

    public ExternalAdaptInfo(Parcel r100) {
        Intrinsics.checkNotNullParameter(r100, "parcel");
        boolean r101 = false;
        if (r100.readByte() == ((byte) 0)) goto L5;
        r101 = true;
    L5:
        this.f186973a = r101;
        this.f186974b = r100.readFloat();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "dest");
        if (this.f186973a == false) goto L5;
        int r102 = 1;
    L6:
        r100.writeByte((byte) r102);
        r100.writeFloat(this.f186974b);
        return;
    L5:
        r102 = 0;
        goto L6
    }
}
