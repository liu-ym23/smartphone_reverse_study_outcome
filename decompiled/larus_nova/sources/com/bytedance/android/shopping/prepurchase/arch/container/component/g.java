package com.bytedance.android.shopping.prepurchase.arch.container.component;

import android.view.View;
import android.view.ViewGroup;
import com.bytedance.android.shopping.prepurchase.arch.container.state.h;

/* JADX INFO: loaded from: classes13.dex */
public interface g<STATE extends com.bytedance.android.shopping.prepurchase.arch.container.state.h, STORE> {
    void a(ViewGroup r100, Component<STATE, STORE> r101, ViewGroup.LayoutParams r102, int r103);

    void c(Component<STATE, STORE> r100, View r101);

    void d(i<STATE, STORE> r100);

    void e(Component r100);

    boolean f(AbsComponent<?, ?> r100);
}
