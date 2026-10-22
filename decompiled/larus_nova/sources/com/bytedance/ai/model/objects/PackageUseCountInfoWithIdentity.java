package com.bytedance.ai.model.objects;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.bytedance.ai.utils.g;
import com.ss.android.socialbase.downloader.utils.DownloadHelper;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0007\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u0018\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\b\u0010\u0013\u001a\u00020\u0012H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0015"}, d2 = {"Lcom/bytedance/ai/model/objects/PackageUseCountInfoWithIdentity;", "Landroid/os/Parcelable;", DownloadHelper.IDENTITY, "Landroid/os/IBinder;", "packageUseCountInfo", "", "Lcom/bytedance/ai/model/objects/PackageUseCountInfo;", "<init>", "(Landroid/os/IBinder;Ljava/util/List;)V", "getIdentity", "()Landroid/os/IBinder;", "getPackageUseCountInfo", "()Ljava/util/List;", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "", "describeContents", "CREATOR", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class PackageUseCountInfoWithIdentity implements Parcelable {
    public static final a CREATOR = null;
    private final IBinder identity;
    private final List<PackageUseCountInfo> packageUseCountInfo;

    public static final class a implements Parcelable.Creator<PackageUseCountInfoWithIdentity> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final PackageUseCountInfoWithIdentity createFromParcel(Parcel r100) {
            Intrinsics.checkNotNullParameter(r100, "parcel");
            IBinder r101 = r100.readStrongBinder();     // Catch: Exception -> L8
            ArrayList r102 = r100.createTypedArrayList(PackageUseCountInfo.CREATOR);     // Catch: Exception -> L8
            if (r102 != null) goto L6;
            r102 = new ArrayList();     // Catch: Exception -> L8
        L6:
            Intrinsics.checkNotNull(r101);     // Catch: Exception -> L8
            return new PackageUseCountInfoWithIdentity(r101, r102);
        L8:
            e = move-exception;
            g.f37637a.e("AIManager", "createFromParcel exception: " + e);
            throw e;
        }

        @Override // android.os.Parcelable.Creator
        public final PackageUseCountInfoWithIdentity[] newArray(int r100) {
            return new PackageUseCountInfoWithIdentity[r100];
        }
    }

    static {
        CREATOR = new a();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public final IBinder getIdentity() {
        return this.identity;
    }

    public final List<PackageUseCountInfo> getPackageUseCountInfo() {
        return this.packageUseCountInfo;
    }

    public PackageUseCountInfoWithIdentity(IBinder r100, List<PackageUseCountInfo> r101) {
        Intrinsics.checkNotNullParameter(r100, DownloadHelper.IDENTITY);
        Intrinsics.checkNotNullParameter(r101, "packageUseCountInfo");
        this.identity = r100;
        this.packageUseCountInfo = r101;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parcel");
        r100.writeStrongBinder(this.identity);
        r100.writeTypedList(this.packageUseCountInfo);
    }
}
