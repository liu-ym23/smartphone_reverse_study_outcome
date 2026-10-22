package com.bytedance.android.livesdk.slideuptip;

import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: classes11.dex */
public final class LiveSlideUpTipsGuideUtil {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f158383a = null;

    static {
        f158383a = LazyKt.lazy(LiveSlideUpTipsGuideUtil$CONFIG$2.INSTANCE);
    }

    @JvmStatic
    public static final boolean a(String r100) {
        if (r100 != null) goto L5;
        return false;
    L5:
        if (r100.length() <= 0) goto L7;
        boolean r101 = true;
    L8:
        if (r101 != true) goto L16;
        Map r102 = (Map) f158383a.getValue();
        if (r102 != null) goto L12;
        return false;
    L12:
        if (r102.containsKey(r100) != true) goto L18;
        return true;
    L18:
        return false;
    L16:
        return false;
    L7:
        r101 = false;
        goto L8
    }
}
