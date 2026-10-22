package com.bytedance.android.ec.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001R\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"Lcom/bytedance/android/ec/model/BuyNowSourcePageContext;", "Landroid/os/Parcelable;", "", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "Ljava/lang/String;", "getType", "()Ljava/lang/String;", "type", "ec-model_release"}, k = 1, mv = {1, 4, 3})
public final class BuyNowSourcePageContext implements Parcelable {
    public static final Parcelable.Creator<BuyNowSourcePageContext> CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f47849a;

    public static class a implements Parcelable.Creator<BuyNowSourcePageContext> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final BuyNowSourcePageContext createFromParcel(Parcel r100) {
            Intrinsics.checkNotNullParameter(r100, "in");
            return new BuyNowSourcePageContext(r100.readString());
        }

        @Override // android.os.Parcelable.Creator
        public final BuyNowSourcePageContext[] newArray(int r100) {
            return new BuyNowSourcePageContext[r100];
        }
    }

    static {
        CREATOR = new a();
    }

    public BuyNowSourcePageContext() {
        this(null);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parcel");
        r100.writeString(this.f47849a);
    }

    public final String getType() {
        return this.f47849a;
    }

    public BuyNowSourcePageContext(String r100) {
        this.f47849a = r100;
    }
}
