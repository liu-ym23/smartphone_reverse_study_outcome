package com.bytedance.android.livesdk.interactivity.service.emoji.recent;

import com.byted.mgl.merge.service.api.ui.BdpGameHostBaseUIService;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\"\u0010\u0007\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006\"\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/service/emoji/recent/a;", "", "", BdpGameHostBaseUIService.DATE_PICKER_TYPE_DAY, "J", "b", "()J", "count", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "c", "(J)V", "community-service_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class a {

    @SerializedName("count")
    private long count;

    @SerializedName(BdpGameHostBaseUIService.DATE_PICKER_TYPE_DAY)
    private final long day;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof a) == false) goto L10;
        a r101 = (a) r100;
        if (this.day == r101.day) goto L8;
        return false;
    L8:
        if (this.count == r101.count) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        long r100 = this.day;
        int r101 = ((int) (r100 ^ (r100 >>> 32))) * 31;
        long r102 = this.count;
        return r101 + ((int) (r102 ^ (r102 >>> 32)));
    }

    public final String toString() {
        return "DayUseCount(day=" + this.day + ", count=" + this.count + ")";
    }

    public final long a() {
        return this.count;
    }

    public final long b() {
        return this.day;
    }

    public a(long r100) {
        this.day = r100;
        this.count = 1;
    }

    public final void c(long r100) {
        this.count = r100;
    }
}
