package com.bytedance.android.livesdk.gift.platform.business.normal.utils;

import com.bytedance.android.livesdk.gift.model.o0;
import kotlin.Lazy;
import kotlin.LazyKt;
import py.k;

/* JADX INFO: loaded from: classes9.dex */
public final class GiftImageFormat {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f129798a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f129799b = null;

    static {
        f129798a = LazyKt.lazy(GiftImageFormat$giftImageFormatOpt$2.INSTANCE);
        f129799b = LazyKt.lazy(GiftImageFormat$giftImageTemplateOpt$2.INSTANCE);
    }

    public static k a(o0 r100) {
        if (r100 != null) goto L6;
        return null;
    L6:
        if (((Boolean) f129798a.getValue()).booleanValue() == false) goto L12;
        if (r100.getTrayBaseWebpImg() == null) goto L12;
        return r100.getTrayBaseWebpImg();
    L12:
        return r100.getTrayBaseImg();
    }
}
