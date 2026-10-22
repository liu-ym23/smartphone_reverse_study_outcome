package com.bytedance.android.shopping.card_list.container.init;

import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Map<LauncherBizType, Function0<f>> f171553a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Map<LauncherBizType, f> f171554b = null;

    static {
        f171553a = new LinkedHashMap();
        f171554b = new LinkedHashMap();
    }

    public static final f a(LauncherBizType r100) {
        Intrinsics.checkNotNullParameter(r100, "type");
        Map<LauncherBizType, f> r101 = f171554b;
        if (((LinkedHashMap) r101).get(r100) != null) goto L10;
        Function0 r102 = (Function0) ((LinkedHashMap) f171553a).get(r100);
        if (r102 == null) goto L10;
        f r103 = (f) r102.invoke();
        if (r103 == null) goto L10;
        r101.put(r100, r103);
    L10:
        return (f) ((LinkedHashMap) r101).get(r100);
    }
}
