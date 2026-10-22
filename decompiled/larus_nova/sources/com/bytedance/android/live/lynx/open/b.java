package com.bytedance.android.live.lynx.open;

import com.bytedance.android.live.browser.LynxThreadStrategy;

/* JADX INFO: loaded from: classes46.dex */
public final /* synthetic */ class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f82632a = null;

    static {
        int[] r100 = new int[LynxThreadStrategy.values().length];
        f82632a = r100;
        r100[LynxThreadStrategy.MOST_ON_TASM.ordinal()] = 1;
        r100[LynxThreadStrategy.PART_ON_LAYOUT.ordinal()] = 2;
        r100[LynxThreadStrategy.MULTI_THREADS.ordinal()] = 3;
    }
}
