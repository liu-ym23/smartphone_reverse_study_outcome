package com.bytedance.android.shopping.deepfeed.slice.action;

import android.view.View;
import com.bytedance.android.shopping.deepfeed.event.DeepFeedProductEventTracker;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes13.dex */
public interface w extends x, u, y {
    DeepFeedProductEventTracker A();

    void b(boolean r100);

    com.bytedance.android.shopping.deepfeed.action.d c();

    void d(String r100, List<String> r101, View r102);

    void g(String r100, String r101);

    void h(View r100, String r101);

    boolean i();

    vc3.c j(vc3.d r100);

    void m(Boolean r100, View r101);

    vc3.a n(String r100, String r101, String r102, boolean r103, View r104);

    vc3.b q();

    v r(String r100);

    String s(String r100);

    void t(Function1<? super String, Unit> r100);

    void u(String r100, boolean r101);

    boolean v();

    void w(int r100);

    void x(Function0<Unit> r100);

    void y(boolean r100);

    void z(int r100, String r101);
}
