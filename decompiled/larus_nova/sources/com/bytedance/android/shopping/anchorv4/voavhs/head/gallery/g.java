package com.bytedance.android.shopping.anchorv4.voavhs.head.gallery;

import com.bytedance.android.shopping.anchorv4.voavhs.head.base.HeadViewType;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static int f168664a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Map<String, String> f168665b = null;

    static {
        f168664a = 100;
        f168665b = new LinkedHashMap();
    }

    public static int a(String r100, String r101) {
        HeadViewType r102 = HeadViewType.PICTURE;
        if (Intrinsics.areEqual(r100, r102.getType()) == false) goto L8;
        if (com.bytedance.android.shopping.extensions.k.c(r101) == false) goto L8;
        return 5;
    L8:
        if (Intrinsics.areEqual(r100, r102.getType()) == false) goto L11;
        return 0;
    L11:
        if (Intrinsics.areEqual(r100, HeadViewType.SKU.getType()) == false) goto L13;
        return 6;
    L13:
        int r103 = f168664a;
        f168664a = r103 + 1;
        return r103;
    }
}
