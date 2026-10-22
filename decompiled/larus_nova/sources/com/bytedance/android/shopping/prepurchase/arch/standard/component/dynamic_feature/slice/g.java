package com.bytedance.android.shopping.prepurchase.arch.standard.component.dynamic_feature.slice;

import android.view.View;
import java.util.Map;

/* JADX INFO: loaded from: classes13.dex */
public interface g {
    View a(String r100);

    c asView();

    boolean b(com.bytedance.android.ecom.arch.slice.g r100, Map<String, ? extends Object> r101, String r102);

    void setDisableTouchEvent(boolean r100);

    void setOnViewReadyCallback(l r100);
}
