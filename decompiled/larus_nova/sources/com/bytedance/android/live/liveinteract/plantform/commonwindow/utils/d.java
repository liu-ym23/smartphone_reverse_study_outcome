package com.bytedance.android.live.liveinteract.plantform.commonwindow.utils;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class d {
    public static final String a(ti6.f r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$toRegionString");
        return "Region(x=" + r100.f546162d + ", y=" + r100.f546163e + ", width=" + r100.f546164f + ", height=" + r100.f546165g + ')';
    }

    public static final h b(pn0.f.a r110) {
        Intrinsics.checkNotNullParameter(r110, "$this$toStreamRect");
        return new h(r110.f529925a, r110.f529926b, r110.f529927c, r110.f529928d);
    }

    public static final h c(pn0.f.b r110) {
        Intrinsics.checkNotNullParameter(r110, "$this$toStreamRect");
        return new h(r110.f529929a, r110.f529930b, r110.f529931c, r110.f529932d);
    }
}
