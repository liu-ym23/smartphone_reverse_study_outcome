package ad1;

import com.bytedance.android.live.wallet.pay.iap.model.LiveIAPProductType;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f2937a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f2938b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f2939c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final LiveIAPProductType f2940d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f2941e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f2942f;

    public final String toString() {
        return "LiveIAPPayParams(appId='" + this.f2937a + "', merchantId='" + this.f2938b + "', orderId='" + this.f2939c + "', productType=" + this.f2940d + ", productId='" + this.f2941e + "', sdkParams='" + this.f2942f + "')";
    }

    public b(String r100, String r101, String r102, LiveIAPProductType r103, String r104, String r105) {
        Intrinsics.checkNotNullParameter(r100, "appId");
        Intrinsics.checkNotNullParameter(r101, "merchantId");
        Intrinsics.checkNotNullParameter(r102, "orderId");
        Intrinsics.checkNotNullParameter(r103, "productType");
        Intrinsics.checkNotNullParameter(r104, "productId");
        Intrinsics.checkNotNullParameter(r105, "sdkParams");
        this.f2937a = r100;
        this.f2938b = r101;
        this.f2939c = r102;
        this.f2940d = r103;
        this.f2941e = r104;
        this.f2942f = r105;
    }
}
