package com.bytedance.android.shopping.deepfeed.data.repo;

import com.bytedance.android.shopping.infeed.data.idl.InFeedProductV2;
import he3.e1;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class DeepFeedRepHelpKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f173174a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f173175b = null;

    public static final int b() {
        return ((Number) f173174a.getValue()).intValue();
    }

    static {
        f173174a = LazyKt.lazy(DeepFeedRepHelpKt$skeletonTime$2.INSTANCE);
        f173175b = LazyKt.lazy(DeepFeedRepHelpKt$rebuildFix$2.INSTANCE);
    }

    public static final String a(InFeedProductV2 r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$constructFilter");
        e1 r101 = com.bytedance.android.shopping.deepfeed.utlis.a.a(r100);
        if (r101 == null) goto L21;
        String r102 = r101.c();
        if (r102 == null) goto L21;
        e1 r103 = com.bytedance.android.shopping.deepfeed.utlis.a.a(r100);
        if (r103 == null) goto L10;
        String r104 = r103.a();
        if (r104 == null) goto L10;
    L12:
        if (r104.length() != 0) goto L14;
        boolean r105 = true;
    L16:
        if (r105 == false) goto L20;
        return "1_".concat(r102);
    L20:
        return "1_" + r102 + ",2_" + r104;
    L14:
        r105 = false;
    L10:
        r104 = "";
    L21:
        e1 r106 = com.bytedance.android.shopping.deepfeed.utlis.a.a(r100);
        if (r106 == null) goto L27;
        String r107 = r106.a();
        if (r107 != null) goto L26;
        return null;
    L26:
        return "2_".concat(r107);
    L27:
        return null;
    }
}
