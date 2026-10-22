package com.tmall.wireless.tangram.dataparser.concrete;

import androidx.annotation.Nullable;
import com.alibaba.android.vlayout.LayoutHelper;
import com.tmall.wireless.tangram.core.protocol.LayoutBinder;

/* JADX INFO: loaded from: classes4.dex */
public class BaseLayoutBinder implements LayoutBinder<Card> {
    public BaseLayoutBinder() {
    }

    @Override // com.tmall.wireless.tangram.core.protocol.LayoutBinder
    @Nullable
    public /* bridge */ /* synthetic */ LayoutHelper getHelper(int r10, Card r11) {
        return getHelper2(r10, r11);
    }

    @Nullable
    /* JADX INFO: renamed from: getHelper, reason: avoid collision after fix types in other method */
    public LayoutHelper getHelper2(int r10, Card r11) {
        if (r11 != null) goto L6;
        return null;
    L6:
        return r11.getLayoutHelper();
    }
}
