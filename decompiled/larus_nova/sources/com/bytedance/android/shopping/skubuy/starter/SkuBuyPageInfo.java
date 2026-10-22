package com.bytedance.android.shopping.skubuy.starter;

import android.os.Parcel;
import android.os.Parcelable;
import com.bytedance.android.ec.model.abscontainer.ISkuBuySchemaModel;
import com.bytedance.android.shopping.abscontainer.arch.core.starter.PageInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/shopping/skubuy/starter/SkuBuyPageInfo;", "Lcom/bytedance/android/shopping/abscontainer/arch/core/starter/PageInfo;", "Landroid/os/Parcelable;", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class SkuBuyPageInfo extends PageInfo {
    public static final Parcelable.Creator<SkuBuyPageInfo> CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f183202a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f183203b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ISkuBuySchemaModel f183204c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f183205d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f183206e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f183207f;

    public static class a implements Parcelable.Creator<SkuBuyPageInfo> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final SkuBuyPageInfo createFromParcel(Parcel r100) {
            Intrinsics.checkNotNullParameter(r100, "in");
            String r101 = r100.readString();
            String r102 = r100.readString();
            ISkuBuySchemaModel r103 = (ISkuBuySchemaModel) r100.readParcelable(SkuBuyPageInfo.class.getClassLoader());
            boolean r104 = false;
            if (r100.readInt() == 0) goto L5;
            boolean r105 = true;
        L7:
            if (r100.readInt() == 0) goto L9;
            r104 = true;
        L9:
            boolean r106 = r105;
            return new SkuBuyPageInfo(r101, r102, r103, r106, r104, r100.readString());
        L5:
            r105 = false;
            goto L7
        }

        @Override // android.os.Parcelable.Creator
        public final SkuBuyPageInfo[] newArray(int r100) {
            return new SkuBuyPageInfo[r100];
        }
    }

    static {
        CREATOR = new a();
    }

    @Override // com.bytedance.android.shopping.abscontainer.arch.core.starter.PageInfo, android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parcel");
        r100.writeString(this.f183202a);
        r100.writeString(this.f183203b);
        r100.writeParcelable(this.f183204c, r101);
        r100.writeInt(this.f183205d ? 1 : 0);
        r100.writeInt(this.f183206e ? 1 : 0);
        r100.writeString(this.f183207f);
    }

    @Override // com.bytedance.android.shopping.abscontainer.arch.core.starter.PageInfo
    public final String getBizCode() {
        return this.f183202a;
    }

    @Override // com.bytedance.android.shopping.abscontainer.arch.core.starter.PageInfo
    public final boolean getInSplitScreen() {
        return this.f183205d;
    }

    @Override // com.bytedance.android.shopping.abscontainer.arch.core.starter.PageInfo
    public final String getSessionID() {
        return this.f183203b;
    }

    @Override // com.bytedance.android.shopping.abscontainer.arch.core.starter.PageInfo
    public final boolean isSplitScreenOpened() {
        return this.f183206e;
    }

    public SkuBuyPageInfo(String r100, String r101, ISkuBuySchemaModel r102, boolean r103, boolean r104, String r105) {
        Intrinsics.checkNotNullParameter(r100, "bizCode");
        Intrinsics.checkNotNullParameter(r101, "sessionID");
        Intrinsics.checkNotNullParameter(r102, "skuBuySchemaModel");
        super(r100, r101, r102, r103, r104);
        this.f183202a = r100;
        this.f183203b = r101;
        this.f183204c = r102;
        this.f183205d = r103;
        this.f183206e = r104;
        this.f183207f = r105;
    }
}
