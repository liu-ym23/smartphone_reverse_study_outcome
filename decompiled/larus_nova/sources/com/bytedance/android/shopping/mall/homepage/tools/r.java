package com.bytedance.android.shopping.mall.homepage.tools;

import com.bytedance.android.ec.hybrid.hostapi.IHybridHostService;
import com.bytedance.android.ec.hybrid.log.mall.ECMallLogUtil;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Lazy;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001:\u0001\fR\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001a\u0010\n\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/shopping/mall/homepage/tools/r;", "", "", "prefetchImageThread", "I", "c", "()I", "prefetchImageFirstCount", "b", "", "prefetchFirst", "Z", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Z", "mall_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final r f178540a = null;

    @SerializedName("gyl_prefetch_first")
    private final boolean prefetchFirst;

    @SerializedName("gyl_prefetch_image_count")
    private final int prefetchImageFirstCount;

    @SerializedName("prefetch_image_thread")
    private final int prefetchImageThread;

    public static final class a {
    }

    public r() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof r) == false) goto L12;
        r r101 = (r) r100;
        if (this.prefetchImageThread == r101.prefetchImageThread) goto L8;
        return false;
    L8:
        if (this.prefetchImageFirstCount == r101.prefetchImageFirstCount) goto L10;
        return false;
    L10:
        if (this.prefetchFirst == r101.prefetchFirst) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v4, types: [int] */
    /* JADX WARN: Type inference failed for: r1v2, types: [int] */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r1v4 */
    public final int hashCode() {
        int r100 = ((this.prefetchImageThread * 31) + this.prefetchImageFirstCount) * 31;
        boolean r101 = this.prefetchFirst;
        ?? r102 = r101;
        if (r101 == false) goto L6;
        r102 = 1;
    L6:
        return r100 + r102;
    }

    public final String toString() {
        return "MallFirstScreenPrefetchImageSetting(prefetchImageThread=" + this.prefetchImageThread + ", prefetchImageFirstCount=" + this.prefetchImageFirstCount + ", prefetchFirst=" + this.prefetchFirst + ")";
    }

    static {
        int r100 = s93.c.f541066a;
        Object r101 = new r(0);
        IHybridHostService r102 = com.bytedance.android.ec.hybrid.a.h();
        if (r102 == null) goto L10;
        yj.g r103 = r102.getHostAB();
        if (r103 == null) goto L10;
        Object r104 = r103.a("mall_first_screen_prefetch_image", r101);
        if (r104 == null) goto L10;
        r101 = r104;
    L10:
        Lazy r105 = ECMallLogUtil.f47441a;
        ECMallLogUtil.c(com.bytedance.android.ec.hybrid.log.mall.c.a.f47463b, "Key : mall_first_screen_prefetch_image, Value: " + r101);
        f178540a = (r) r101;
    }

    public final boolean a() {
        return this.prefetchFirst;
    }

    public final int b() {
        return this.prefetchImageFirstCount;
    }

    public final int c() {
        return this.prefetchImageThread;
    }

    public r(int r100) {
        this.prefetchImageThread = 0;
        this.prefetchImageFirstCount = 4;
        this.prefetchFirst = false;
    }
}
