package com.alibaba.android.vlayout.layout;

import com.alibaba.android.vlayout.LayoutHelper;

/* JADX INFO: loaded from: classes.dex */
public class DefaultLayoutHelper extends LinearLayoutHelper {
    public DefaultLayoutHelper() {
    }

    public static LayoutHelper newHelper(int r10) {
        DefaultLayoutHelper r11 = new DefaultLayoutHelper();
        r11.setItemCount(r10);
        return r11;
    }

    @Override // com.alibaba.android.vlayout.LayoutHelper
    public boolean isOutOfRange(int r10) {
        return false;
    }
}
