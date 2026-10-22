package com.bytedance.android.livesdk.livecommerce.intro.model.resp;

import com.bytedance.android.ec.model.response.ECAuctionAtmosphere;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/intro/model/resp/d;", "", "Lcom/bytedance/android/livesdk/livecommerce/intro/model/resp/n;", "countdown", "Lcom/bytedance/android/livesdk/livecommerce/intro/model/resp/n;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Lcom/bytedance/android/livesdk/livecommerce/intro/model/resp/n;", "Lcom/bytedance/android/livesdk/livecommerce/intro/model/resp/p;", ECAuctionAtmosphere.TYPE_DIGITAL, "Lcom/bytedance/android/livesdk/livecommerce/intro/model/resp/p;", "b", "()Lcom/bytedance/android/livesdk/livecommerce/intro/model/resp/p;", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class d {

    @SerializedName("count_down")
    private final n countdown;

    @SerializedName(ECAuctionAtmosphere.TYPE_DIGITAL)
    private final p digital;

    public d() {
        this(null, null);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof d) == false) goto L10;
        d r101 = (d) r100;
        if (Intrinsics.areEqual(this.countdown, r101.countdown) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.digital, r101.digital) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        n r100 = this.countdown;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        p r104 = this.digital;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        return r103 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "IntroAuctionAtmosphere(countdown=" + this.countdown + ", digital=" + this.digital + ")";
    }

    public final n a() {
        return this.countdown;
    }

    public final p b() {
        return this.digital;
    }

    public d(n r100, p r101) {
        this.countdown = r100;
        this.digital = r101;
    }
}
