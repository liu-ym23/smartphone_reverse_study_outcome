package com.bytedance.android.shopping.api.mall.common.tools;

import com.bytedance.android.ec.hybrid.list.util.CommonUtilKt;
import com.bytedance.android.ec.hybrid.log.mall.ECMallLogUtil;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class MallBehaviorUtil {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f170407a = null;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f170408a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f170409b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof a) == false) goto L10;
            a r101 = (a) r100;
            if (Intrinsics.areEqual(this.f170408a, r101.f170408a) == true) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.f170409b, r101.f170409b) == true) goto L16;
            return false;
        L16:
            return true;
        L10:
            return false;
        }

        public final int hashCode() {
            String r100 = this.f170408a;
            int r101 = 0;
            if (r100 == null) goto L5;
            int r102 = r100.hashCode();
        L6:
            int r103 = r102 * 31;
            String r104 = this.f170409b;
            if (r104 == null) goto L10;
            r101 = r104.hashCode();
        L10:
            return r103 + r101;
        L5:
            r102 = 0;
            goto L6
        }

        public final String toString() {
            return "MallBehaviorInjectCheckParam(pageName=" + this.f170408a + ", cardSchema=" + this.f170409b + ")";
        }

        public a(String r100, String r101) {
            Intrinsics.checkNotNullParameter(r100, "pageName");
            Intrinsics.checkNotNullParameter(r101, "cardSchema");
            this.f170408a = r100;
            this.f170409b = r101;
        }
    }

    static {
        f170407a = LazyKt.lazy(MallBehaviorUtil$elementSetting$2.INSTANCE);
    }

    public static List a(a r110) {
        Intrinsics.checkNotNullParameter(r110, "param");
        ArrayList r100 = new ArrayList();
        String r101 = r110.f170409b;
        Intrinsics.checkNotNullParameter(r101, "schema");
        ArrayList r102 = new ArrayList();
        r102.addAll(CommonUtilKt.a(r101));
        r102.add(new com.bytedance.android.ec.hybrid.list.util.b());
        r102.add(new com.bytedance.android.ec.hybrid.list.util.a());
        int r103 = jk.a.f499468a;
        r100.addAll(r102);
        Intrinsics.checkNotNullParameter(r110, "params");
        ArrayList r104 = new ArrayList();
        Lazy r105 = f170407a;
        com.bytedance.android.shopping.api.mall.opt.d r106 = (com.bytedance.android.shopping.api.mall.opt.d) r105.getValue();
        if (r106 == null) goto L11;
        List<String> r107 = r106.b();
        if (r107 == null) goto L11;
        if (r107.contains(r110.f170408a) != true) goto L11;
        com.bytedance.android.ec.hybrid.card.util.h r108 = CommonUtilKt.b();
        if (r108 == null) goto L11;
        r104.add(r108);
    L11:
        com.bytedance.android.shopping.api.mall.opt.d r109 = (com.bytedance.android.shopping.api.mall.opt.d) r105.getValue();
        if (r109 == null) goto L18;
        List<String> r111 = r109.c();
        if (r111 == null) goto L18;
        if (r111.contains(r110.f170408a) != true) goto L18;
        int r112 = bk.c.f19283a;
    L18:
        r100.addAll(r104);
        Lazy r113 = ECMallLogUtil.f47441a;
        ECMallLogUtil.c(com.bytedance.android.ec.hybrid.log.mall.b.g.f47461b, "inject xElement is " + CollectionsKt.joinToString$default(r100, "_", null, null, 0, null, null, 62, null) + ", pageName: " + r110.f170408a + ", card is " + r110.f170409b);
        return r100;
    }
}
