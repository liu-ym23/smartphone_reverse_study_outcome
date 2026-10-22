package com.bytedance.android.gamecp.host_api.model.introducecard;

import android.view.View;
import java.util.Map;
import kotlin.Pair;

/* JADX INFO: loaded from: classes44.dex */
public interface q {
    void a(g r100, boolean r101);

    void b(int r100);

    void c(Map<String, ? extends Object> r100);

    void d(g r100);

    boolean e();

    Pair<Boolean, String> f();

    void g(a r100);

    View getView();

    void h(String r100);

    void i(View r100, g r101, o r102, p r103);

    void onViewDetached();
}
