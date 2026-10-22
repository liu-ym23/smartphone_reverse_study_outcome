package com.bytedance.android.shopping.buynow.data.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.bytedance.android.ec.model.entranceinfo.EntranceInfoScene;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/shopping/buynow/data/model/BuyNowOrderSchema;", "Landroid/os/Parcelable;", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class BuyNowOrderSchema implements Parcelable {
    public static final Parcelable.Creator<BuyNowOrderSchema> CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f170879a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final EntranceInfoScene f170880b;

    public static class a implements Parcelable.Creator<BuyNowOrderSchema> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final BuyNowOrderSchema createFromParcel(Parcel r100) {
            Intrinsics.checkNotNullParameter(r100, "in");
            return new BuyNowOrderSchema(r100.readString(), (EntranceInfoScene) r100.readParcelable(BuyNowOrderSchema.class.getClassLoader()));
        }

        @Override // android.os.Parcelable.Creator
        public final BuyNowOrderSchema[] newArray(int r100) {
            return new BuyNowOrderSchema[r100];
        }
    }

    static {
        CREATOR = new a();
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parcel");
        r100.writeString(this.f170879a);
        r100.writeParcelable(this.f170880b, r101);
    }

    public BuyNowOrderSchema(String r100, EntranceInfoScene r101) {
        Intrinsics.checkNotNullParameter(r100, "finalUrl");
        Intrinsics.checkNotNullParameter(r101, "entranceInfoScene");
        this.f170879a = r100;
        this.f170880b = r101;
    }
}
