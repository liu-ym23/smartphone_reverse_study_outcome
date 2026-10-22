package com.bytedance.android.livesdk.livecommerce.intro.model.resp;

import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.livesdkapi.performance.ILoadStallMonitor;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.dypay.api.DyPayConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001:\u0001\u000fR\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001c\u0010\n\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u000b\u001a\u0004\b\u000f\u0010\r¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/intro/model/resp/n;", "", "", DyPayConstant.KEY_START_TIME, "J", "d", "()J", "endTime", "b", "Lcom/bytedance/android/ec/model/ECUrlModel;", "leftIcon", "Lcom/bytedance/android/ec/model/ECUrlModel;", "c", "()Lcom/bytedance/android/ec/model/ECUrlModel;", "background", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f148476a = 0;

    @SerializedName("background")
    private final ECUrlModel background;

    @SerializedName("end_time")
    private final long endTime;

    @SerializedName("left_icon")
    private final ECUrlModel leftIcon;

    @SerializedName(ILoadStallMonitor.START_TIME)
    private final long startTime;

    public static final class a {
    }

    static {
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof n) == false) goto L14;
        n r101 = (n) r100;
        if (this.startTime == r101.startTime) goto L8;
        return false;
    L8:
        if (this.endTime == r101.endTime) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.leftIcon, r101.leftIcon) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.background, r101.background) == true) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    public final int hashCode() {
        long r100 = this.startTime;
        int r101 = ((int) (r100 ^ (r100 >>> 32))) * 31;
        long r102 = this.endTime;
        int r103 = (r101 + ((int) (r102 ^ (r102 >>> 32)))) * 31;
        ECUrlModel r104 = this.leftIcon;
        int r105 = 0;
        if (r104 == null) goto L5;
        int r106 = r104.hashCode();
    L6:
        int r107 = (r103 + r106) * 31;
        ECUrlModel r108 = this.background;
        if (r108 == null) goto L10;
        r105 = r108.hashCode();
    L10:
        return r107 + r105;
    L5:
        r106 = 0;
        goto L6
    }

    public final String toString() {
        return "IntroCountdownAtmosphere(startTime=" + this.startTime + ", endTime=" + this.endTime + ", leftIcon=" + this.leftIcon + ", background=" + this.background + ")";
    }

    public n() {
        this(0, 0, null, null);
    }

    public final ECUrlModel a() {
        return this.background;
    }

    public final long b() {
        return this.endTime;
    }

    public final ECUrlModel c() {
        return this.leftIcon;
    }

    public final long d() {
        return this.startTime;
    }

    public n(long r100, long r101, ECUrlModel r102, ECUrlModel r103) {
        this.startTime = r100;
        this.endTime = r101;
        this.leftIcon = r102;
        this.background = r103;
    }
}
