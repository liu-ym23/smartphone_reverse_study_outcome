package com.bytedance.android.ec.model.response;

import com.bytedance.android.livesdkapi.performance.ILoadStallMonitor;
import com.google.gson.annotations.SerializedName;
import com.ss.android.dypay.api.DyPayConstant;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0006HÆ\u0003J)\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000b¨\u0006\u0019"}, d2 = {"Lcom/bytedance/android/ec/model/response/ECAuctionCountdownAtmosphere;", "Ljava/io/Serializable;", DyPayConstant.KEY_START_TIME, "", "endTime", "data", "Lcom/bytedance/android/ec/model/response/ECAuctionAtmosphereData;", "(JJLcom/bytedance/android/ec/model/response/ECAuctionAtmosphereData;)V", "getData", "()Lcom/bytedance/android/ec/model/response/ECAuctionAtmosphereData;", "getEndTime", "()J", "getStartTime", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "ec-model_release"}, k = 1, mv = {1, 4, 3})
public final class ECAuctionCountdownAtmosphere implements Serializable {

    @SerializedName("data")
    private final ECAuctionAtmosphereData data;

    @SerializedName("end_time")
    private final long endTime;

    @SerializedName(ILoadStallMonitor.START_TIME)
    private final long startTime;

    public ECAuctionCountdownAtmosphere() {
        this(0, 0, null, 7, null);
    }

    public static /* synthetic */ ECAuctionCountdownAtmosphere copy$default(ECAuctionCountdownAtmosphere r100, long r101, long r102, ECAuctionAtmosphereData r110, int r111, Object r112) {
        if ((r111 & 1) == 0) goto L5;
        r101 = r100.startTime;
    L5:
        long r103 = r101;
        if ((r111 & 2) == 0) goto L8;
        r102 = r100.endTime;
    L8:
        long r104 = r102;
        if ((r111 & 4) == 0) goto L12;
        r110 = r100.data;
    L12:
        return r100.copy(r103, r104, r110);
    }

    public final long component1() {
        return this.startTime;
    }

    public final long component2() {
        return this.endTime;
    }

    public final ECAuctionAtmosphereData component3() {
        return this.data;
    }

    public final ECAuctionCountdownAtmosphere copy(long r100, long r110, ECAuctionAtmosphereData r111) {
        return new ECAuctionCountdownAtmosphere(r100, r110, r111);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof ECAuctionCountdownAtmosphere) == false) goto L12;
        ECAuctionCountdownAtmosphere r101 = (ECAuctionCountdownAtmosphere) r100;
        if (this.startTime == r101.startTime) goto L8;
        return false;
    L8:
        if (this.endTime == r101.endTime) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.data, r101.data) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public int hashCode() {
        long r100 = this.startTime;
        int r101 = ((int) (r100 ^ (r100 >>> 32))) * 31;
        long r102 = this.endTime;
        int r103 = (r101 + ((int) (r102 ^ (r102 >>> 32)))) * 31;
        ECAuctionAtmosphereData r104 = this.data;
        if (r104 == null) goto L5;
        int r105 = r104.hashCode();
    L7:
        return r103 + r105;
    L5:
        r105 = 0;
        goto L7
    }

    public String toString() {
        return "ECAuctionCountdownAtmosphere(startTime=" + this.startTime + ", endTime=" + this.endTime + ", data=" + this.data + ")";
    }

    public final ECAuctionAtmosphereData getData() {
        return this.data;
    }

    public final long getEndTime() {
        return this.endTime;
    }

    public final long getStartTime() {
        return this.startTime;
    }

    public ECAuctionCountdownAtmosphere(long r100, long r101, ECAuctionAtmosphereData r102) {
        this.startTime = r100;
        this.endTime = r101;
        this.data = r102;
    }

    public /* synthetic */ ECAuctionCountdownAtmosphere(long r100, long r101, ECAuctionAtmosphereData r102, int r110, DefaultConstructorMarker r111) {
        long r103 = 0;
        if ((r110 & 1) == 0) goto L5;
        long r104 = 0;
    L7:
        if ((r110 & 2) != 0) goto L11;
        r103 = r101;
    L11:
        if ((r110 & 4) == 0) goto L13;
        r102 = null;
    L13:
        this(r104, r103, r102);
        return;
    L5:
        r104 = r100;
        goto L7
    }
}
