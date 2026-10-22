package com.bytedance.android.shopping.infeed.data.idl;

import android.os.Parcel;
import android.os.Parcelable;
import com.bytedance.android.ec.model.ECUrlModel;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0019\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0004HÖ\u0001R\"\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\t\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/shopping/infeed/data/idl/InFeedUrlModel;", "Lcom/bytedance/android/ec/model/ECUrlModel;", "()V", "urlType", "", "getUrlType", "()Ljava/lang/Integer;", "setUrlType", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class InFeedUrlModel extends ECUrlModel {
    public static final Parcelable.Creator<InFeedUrlModel> CREATOR = null;

    @SerializedName("url_type")
    private Integer urlType;

    public static class a implements Parcelable.Creator<InFeedUrlModel> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final InFeedUrlModel createFromParcel(Parcel r100) {
            Intrinsics.checkNotNullParameter(r100, "in");
            if (r100.readInt() != 0) goto L7;
            return null;
        L7:
            return new InFeedUrlModel();
        }

        @Override // android.os.Parcelable.Creator
        public final InFeedUrlModel[] newArray(int r100) {
            return new InFeedUrlModel[r100];
        }
    }

    static {
        CREATOR = new a();
    }

    @Override // com.bytedance.android.ec.model.ECUrlModel, android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parcel");
        r100.writeInt(1);
    }

    public InFeedUrlModel() {
    }

    public final Integer getUrlType() {
        return this.urlType;
    }

    public final void setUrlType(Integer r100) {
        this.urlType = r100;
    }
}
