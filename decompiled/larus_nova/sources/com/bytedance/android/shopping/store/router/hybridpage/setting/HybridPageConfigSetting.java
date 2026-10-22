package com.bytedance.android.shopping.store.router.hybridpage.setting;

import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: classes14.dex */
public final class HybridPageConfigSetting {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f185949a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f185950b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Lazy f185951c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final boolean f185952d = false;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Lazy f185953e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final boolean f185954f = false;

    static {
        f185949a = LazyKt.lazy(HybridPageConfigSetting$sliceConfigSetting$2.INSTANCE);
        f185950b = LazyKt.lazy(HybridPageConfigSetting$classificationSliceConfigSetting$2.INSTANCE);
        Lazy r100 = LazyKt.lazy(HybridPageConfigSetting$sliceSearchResultPage$2.INSTANCE);
        f185951c = r100;
        boolean r101 = false;
        if (((Number) r100.getValue()).intValue() <= 0) goto L5;
        boolean r102 = true;
    L6:
        f185952d = r102;
        Lazy r103 = LazyKt.lazy(HybridPageConfigSetting$sliceClassificationPage$2.INSTANCE);
        f185953e = r103;
        if (((Number) r103.getValue()).intValue() <= 0) goto L9;
        r101 = true;
    L9:
        f185954f = r101;
        return;
    L5:
        r102 = false;
        goto L6
    }
}
