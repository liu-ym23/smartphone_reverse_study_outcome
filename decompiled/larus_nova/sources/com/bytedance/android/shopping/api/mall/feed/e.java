package com.bytedance.android.shopping.api.mall.feed;

import androidx.lifecycle.LifecycleOwner;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes13.dex */
public interface e {
    Map<String, Object> PN(String r100, int r101);

    yj.e Pn();

    Map<String, String> Xj(String r100, int r101);

    Map<String, Object> getGlobalProps();

    boolean isDarkMode();

    void jq(Map<String, ? extends Object> r100, Set<String> r101);

    boolean oi();

    LifecycleOwner s4();

    void sj();
}
