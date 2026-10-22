package com.bytedance.android.shopping.mall.homepage.card.headercard.toolarea;

import com.bytedance.android.ec.hybrid.card.event.ECEventCenter;
import com.bytedance.android.shopping.api.mall.common.homepage.card.headercard.model.ToolVO;
import java.util.ArrayList;
import java.util.List;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<C2638a> f177854a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.bytedance.android.shopping.mall.homepage.card.headercard.a f177855b;

    /* JADX INFO: renamed from: com.bytedance.android.shopping.mall.homepage.card.headercard.toolarea.a$a, reason: collision with other inner class name */
    public static final class C2638a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f177856a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public ToolVO.Corner f177857b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Integer f177858c;

        public C2638a(int r100, ToolVO.Corner r101, Integer r102) {
            this.f177856a = r100;
            this.f177857b = r101;
            this.f177858c = r102;
        }
    }

    public static final class b {
    }

    static {
    }

    public a(com.bytedance.android.shopping.mall.homepage.card.headercard.a r100) {
        Intrinsics.checkNotNullParameter(r100, "mallContext");
        this.f177855b = r100;
        this.f177854a = new ArrayList();
    }

    public final void a(boolean r110) {
        ECEventCenter.c(new com.bytedance.android.ec.hybrid.card.event.b("search_cart_corner_send_event", System.currentTimeMillis(), this.f177855b.f472425i, false, MapsKt.mapOf(TuplesKt.to("data", Boolean.valueOf(r110))), false, 40));
    }
}
