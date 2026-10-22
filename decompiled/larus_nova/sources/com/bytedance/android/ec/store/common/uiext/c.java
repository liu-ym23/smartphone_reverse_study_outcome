package com.bytedance.android.ec.store.common.uiext;

import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;

/* JADX INFO: loaded from: classes44.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Integer[] f48237a = null;

    static {
        f48237a = new Integer[]{1, 2, 4};
    }

    public static final Animation a(boolean r100, boolean r110) {
        if (r110 == false) goto L4;
        float r101 = 0.8f;
    L5:
        if (r100 == false) goto L8;
        return new ScaleAnimation(r101, 1.0f, r101, 1.0f, 1, 0.5f, 1, 0.5f);
    L8:
        return new ScaleAnimation(1.0f, r101, 1.0f, r101, 1, 0.5f, 1, 0.5f);
    L4:
        r101 = 1.2f;
        goto L5
    }
}
