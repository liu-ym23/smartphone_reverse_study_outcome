package com.bytedance.android.ec.core.imagex;

import com.facebook.imagepipeline.image.CloseableImage;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f44665a = 0;

    static {
    }

    public static int a(CloseableImage r100) {
        Intrinsics.checkNotNullParameter(r100, "closeableImage");
        m0.c("ECImageBreakChangeHelper.getImageFrom");
        if (m0.a() == true) goto L15;
        if (r100.isRequestInternet() == false) goto L8;
        return 0;
    L8:
        if (r100.isHitDiskCache() == false) goto L11;
        return 2;
    L11:
        if (r100.isHitMemoryCache() == false) goto L13;
        return 1;
    L13:
        return -1;
    L15:
        if (r100.isRequestInternet() == false) goto L18;
        return 0;
    L18:
        if (r100.isHitDiskCache() == false) goto L21;
        return 2;
    L21:
        if (r100.isHitBitmapMemoryCache() == false) goto L24;
        return 3;
    L24:
        if (r100.isHitEncodeMemoryCache() == true) goto L31;
        return -1;
    L31:
        return 1;
    }
}
