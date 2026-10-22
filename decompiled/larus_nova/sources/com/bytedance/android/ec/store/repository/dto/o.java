package com.bytedance.android.ec.store.repository.dto;

import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.livesdkapi.performance.ILoadStallMonitor;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.dypay.api.DyPayConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\f\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\t\u001a\u0004\b\r\u0010\u000bR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u000e8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u000f\u0010\u0011R\u001a\u0010\u0013\u001a\u00020\u00128\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0017\u0010\t\u001a\u0004\b\u0018\u0010\u000b¨\u0006\u0019"}, d2 = {"Lcom/bytedance/android/ec/store/repository/dto/o;", "", "Lcom/bytedance/android/ec/model/ECUrlModel;", "appointIcon", "Lcom/bytedance/android/ec/model/ECUrlModel;", "getAppointIcon", "()Lcom/bytedance/android/ec/model/ECUrlModel;", "", "appointText", "Ljava/lang/String;", "getAppointText", "()Ljava/lang/String;", "appointedText", "getAppointedText", "", "isAppointed", "Ljava/lang/Boolean;", "()Ljava/lang/Boolean;", "", DyPayConstant.KEY_START_TIME, "J", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()J", com.heytap.mcssdk.constant.b.f276369s, "getStartDate", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class o {

    @SerializedName("appoint_icon")
    private final ECUrlModel appointIcon;

    @SerializedName("appoint_text")
    private final String appointText;

    @SerializedName("appointed_text")
    private final String appointedText;

    @SerializedName("is_appointed")
    private final Boolean isAppointed;

    @SerializedName("start_date")
    private final String startDate;

    @SerializedName(ILoadStallMonitor.START_TIME)
    private final long startTime;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof o) == false) goto L18;
        o r101 = (o) r100;
        if (Intrinsics.areEqual(this.appointIcon, r101.appointIcon) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.appointText, r101.appointText) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.appointedText, r101.appointedText) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.isAppointed, r101.isAppointed) == true) goto L14;
        return false;
    L14:
        if (this.startTime == r101.startTime) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.startDate, r101.startDate) == true) goto L28;
        return false;
    L28:
        return true;
    L18:
        return false;
    }

    public final int hashCode() {
        ECUrlModel r100 = this.appointIcon;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.appointText;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.appointedText;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        Boolean r110 = this.isAppointed;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        long r113 = this.startTime;
        int r114 = (r112 + ((int) (r113 ^ (r113 >>> 32)))) * 31;
        String r115 = this.startDate;
        if (r115 == null) goto L22;
        r101 = r115.hashCode();
    L22:
        return r114 + r101;
    L17:
        r111 = 0;
        goto L18
    L13:
        r108 = 0;
        goto L14
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "TimingSaleInfo(appointIcon=" + this.appointIcon + ", appointText=" + this.appointText + ", appointedText=" + this.appointedText + ", isAppointed=" + this.isAppointed + ", startTime=" + this.startTime + ", startDate=" + this.startDate + ")";
    }

    public o() {
        this.appointIcon = null;
        this.appointText = null;
        this.appointedText = null;
        this.isAppointed = null;
        this.startTime = 0;
        this.startDate = null;
    }

    public final long a() {
        return this.startTime;
    }
}
