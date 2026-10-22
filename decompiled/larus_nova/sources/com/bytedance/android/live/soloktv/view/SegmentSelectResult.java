package com.bytedance.android.live.soloktv.view;

import android.os.Parcel;
import android.os.Parcelable;
import com.bytedance.android.livesdkapi.performance.ILoadStallMonitor;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.dypay.api.DyPayConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\b\u0018\u0000 \u00102\u00020\u0001:\u0001\bR\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001a\u0010\n\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u000b\u001a\u0004\b\u000f\u0010\r¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/live/soloktv/view/SegmentSelectResult;", "Landroid/os/Parcelable;", "", "startIndex", "I", "c", "()I", "endIndex", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "", DyPayConstant.KEY_START_TIME, "J", "d", "()J", "endTime", "b", "CREATOR", "soloktv-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class SegmentSelectResult implements Parcelable {
    public static final a CREATOR = null;

    @SerializedName("end_index")
    private final int endIndex;

    @SerializedName("end_time")
    private final long endTime;

    @SerializedName("start_index")
    private final int startIndex;

    @SerializedName(ILoadStallMonitor.START_TIME)
    private final long startTime;

    public static final class a implements Parcelable.Creator<SegmentSelectResult> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final SegmentSelectResult createFromParcel(Parcel r110) {
            Intrinsics.checkNotNullParameter(r110, "parcel");
            Intrinsics.checkNotNullParameter(r110, "parcel");
            return new SegmentSelectResult(r110.readInt(), r110.readInt(), r110.readLong(), r110.readLong());
        }

        @Override // android.os.Parcelable.Creator
        public final SegmentSelectResult[] newArray(int r100) {
            return new SegmentSelectResult[r100];
        }
    }

    static {
        CREATOR = new a();
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final int a() {
        return this.endIndex;
    }

    public final long b() {
        return this.endTime;
    }

    public final int c() {
        return this.startIndex;
    }

    public final long d() {
        return this.startTime;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parcel");
        r100.writeInt(this.startIndex);
        r100.writeInt(this.endIndex);
        r100.writeLong(this.startTime);
        r100.writeLong(this.endTime);
    }

    public SegmentSelectResult(int r100, int r101, long r102, long r103) {
        this.startIndex = r100;
        this.endIndex = r101;
        this.startTime = r102;
        this.endTime = r103;
    }
}
