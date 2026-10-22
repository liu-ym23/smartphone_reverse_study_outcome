package com.bytedance.android.ec.hybrid.list.opt;

import com.bytedance.android.ec.hybrid.hostapi.IHybridHostService;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.WeakHashMap;
import yj.l;

/* JADX INFO: loaded from: classes44.dex */
public final class ImageRequestOpt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Set<String> f47208a = null;

    public static final class a {
        public a() {
        }
    }

    static {
        new WeakHashMap();
        f47208a = new LinkedHashSet();
    }

    public static void a(String r100, String r101, String r102) {
        if (r100 != null) goto L5;
        return;
    L5:
        if (f47208a.contains(r100) == false) goto L7;
        return;
    L7:
        if (r101 != null) goto L9;
        r101 = "ec_na_mall";
    L9:
        if (r102 != null) goto L11;
        r102 = "ec_na_mall_product";
    L11:
        final a r103 = new a();
        IHybridHostService r104 = com.bytedance.android.ec.hybrid.a.h();
        if (r104 == null) goto L17;
        l r105 = r104.getIHybridHostFrescoService();
        if (r105 == null) goto L18;
        new ImageRequestOpt$createImageRequestCache$1(r103);
        r105.g(r100, r101, r102);
        return;
    L18:
        return;
    }
}
