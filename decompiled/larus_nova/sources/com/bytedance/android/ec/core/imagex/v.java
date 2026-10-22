package com.bytedance.android.ec.core.imagex;

import com.bytedance.android.ec.core.imagex.opt.ECImageMultiSizeReuseOpt;

/* JADX INFO: loaded from: classes43.dex */
public final /* synthetic */ class v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f45065a = null;

    static {
        int[] r100 = new int[ECImageMultiSizeReuseOpt.CacheType.values().length];
        f45065a = r100;
        r100[ECImageMultiSizeReuseOpt.CacheType.REUSE_CACHE.ordinal()] = 1;
        r100[ECImageMultiSizeReuseOpt.CacheType.PRELOAD_REUSE_CACHE.ordinal()] = 2;
    }
}
