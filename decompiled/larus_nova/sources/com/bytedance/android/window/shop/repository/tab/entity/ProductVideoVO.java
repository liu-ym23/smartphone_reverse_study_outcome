package com.bytedance.android.window.shop.repository.tab.entity;

import com.bytedance.android.ec.model.ECUrlModel;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes14.dex */
public final class ProductVideoVO extends e {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final /* synthetic */ int f189499i = 0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Lazy f189500f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final double f189501g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Long f189502h;

    public static final class a {
        public static ProductVideoVO a(com.bytedance.android.window.shop.repository.dto.j r110) {
            ProductVideoVO r100 = null;
            if (r110 != null) goto L6;
            return null;
        L6:
            if (r110.a() != null) goto L8;
            return null;
        L8:
            Long r101 = r110.d();
            if (r101 == null) goto L15;
            r101.longValue();
            ECUrlModel r102 = r110.f();
            ECUrlModel r103 = r110.a();
            long r104 = r110.d().longValue();
            String r105 = r110.c();
            Double r106 = r110.b();
            if (r106 == null) goto L13;
            double r107 = r106.doubleValue();
        L14:
            r100 = new ProductVideoVO(r102, r103, r104, r105, r107, r110.e());
            goto L15
        L13:
            r107 = 1.0d;
        L15:
            return r100;
        }
    }

    static {
    }

    @Override // com.bytedance.android.window.shop.repository.tab.entity.e, com.ss.android.ugc.aweme.kiwi.model.QModel
    public final int modelType() {
        return 0;
    }

    @Override // com.bytedance.android.window.shop.repository.tab.entity.e
    public final float b() {
        if (this.f189544a != null) goto L7;
        return RangesKt.coerceIn((float) this.f189501g, 0.01f, 100.0f);
    L7:
        return super.b();
    }

    public ProductVideoVO(ECUrlModel r100, ECUrlModel r101, long r102, String r103, double r104, Long r105) {
        Intrinsics.checkNotNullParameter(r101, "cover");
        super(r100, r101, r102, r103);
        this.f189501g = r104;
        this.f189502h = r105;
        this.f189500f = LazyKt.lazy(new ProductVideoVO$ecVideoModel$2(this));
    }
}
