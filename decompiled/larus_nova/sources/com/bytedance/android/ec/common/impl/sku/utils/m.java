package com.bytedance.android.ec.common.impl.sku.utils;

import androidx.core.graphics.ColorUtils;

/* JADX INFO: loaded from: classes43.dex */
public final class m {
    static {
    }

    public static int a(int r100, float r101) {
        return ColorUtils.setAlphaComponent(r100, (int) (r101 * 255));
    }
}
