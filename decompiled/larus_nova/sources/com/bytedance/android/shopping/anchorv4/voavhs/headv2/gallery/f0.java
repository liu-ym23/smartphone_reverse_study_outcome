package com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery;

import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes13.dex */
public final class f0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f169307a = 0;

    static {
    }

    public static String a(String r100) {
        if (r100 == null) goto L6;
        List r101 = StringsKt.split$default(r100, new String[]{"·"}, false, 0, 6, null);
        if (r101 == null) goto L6;
        return (String) CollectionsKt.getOrNull(r101, 1);
    L6:
        return null;
    }

    public static boolean b(int r100, c0 r101) {
        Intrinsics.checkNotNullParameter(r101, "tab");
        int r102 = r101.f169285a;
        if (r102 <= r100) goto L5;
    L7:
        return false;
    L5:
        if (r100 >= (r102 + r101.f169286b)) goto L7;
        return true;
    }
}
