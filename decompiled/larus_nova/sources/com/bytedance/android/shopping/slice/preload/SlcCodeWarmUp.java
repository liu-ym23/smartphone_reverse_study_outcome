package com.bytedance.android.shopping.slice.preload;

import kotlin.Metadata;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0005\u001a\u00020\u0006H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/shopping/slice/preload/SlcCodeWarmUp;", "", "()V", "hasWarmUp", "", "warmUp", "", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class SlcCodeWarmUp {
    public static final SlcCodeWarmUp INSTANCE = null;
    private static boolean hasWarmUp;

    private SlcCodeWarmUp() {
    }

    static {
        INSTANCE = new SlcCodeWarmUp();
    }

    @JvmStatic
    public static final void warmUp() {
        if (hasWarmUp == false) goto L5;
        return;
    L5:
        hasWarmUp = true;
    }
}
