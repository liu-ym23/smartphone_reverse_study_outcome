package com.bytedance.android.shopping.prepurchase.arch.standard.component.dynamic_feature.slice;

import android.view.View;
import com.bytedance.android.ecom.arch.slice.action.IAction;
import com.bytedance.android.ecom.arch.slice.render.SlcElement;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes13.dex */
public interface f extends com.bytedance.android.shopping.prepurchase.arch.container.ability.a {

    public static final class a {
        public static /* synthetic */ void a(f r100, IAction r101, com.bytedance.android.ecom.arch.slice.action.c r102, boolean r103, int r104) {
            if ((r104 & 2) == 0) goto L5;
            r102 = null;
        L5:
            r100.y0(r101, r102, null);
        }

        public static /* synthetic */ void b(f r100, com.bytedance.android.ecom.arch.slice.g r101, IAction r102, View r103, int r104) {
            if ((r104 & 1) == 0) goto L5;
            r101 = null;
        L5:
            r100.O0(r101, r102, r103, null);
        }
    }

    List<com.bytedance.android.ecom.arch.slice.g> F();

    void M0(Map<String, ? extends Object> r100);

    void O0(com.bytedance.android.ecom.arch.slice.g r100, IAction r101, View r102, Map<String, ? extends Object> r103);

    void o1(Map<String, SlcElement> r100);

    void y0(IAction r100, com.bytedance.android.ecom.arch.slice.action.c r101, Map r102);
}
