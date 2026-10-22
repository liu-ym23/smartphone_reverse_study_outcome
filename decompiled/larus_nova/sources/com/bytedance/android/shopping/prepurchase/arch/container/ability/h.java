package com.bytedance.android.shopping.prepurchase.arch.container.ability;

import android.view.View;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes13.dex */
public interface h {
    Boolean a(String r100, JSONObject r101);

    View b();

    ti.l c();

    void d(String r100, Map<String, ? extends Object> r101);

    void e(List<? extends com.bytedance.android.ecom.arch.slice.g> r100, Map<String, ? extends Object> r101, c r102);

    View f(String r100);

    void release();
}
