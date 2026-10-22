package com.bytedance.android.shopping.prepurchase.arch.standard.component.dynamic_feature;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import com.bytedance.android.ecom.arch.slice.action.IAction;
import com.bytedance.android.shopping.anchorv4.helper.SlcTemplateViewHelper;
import java.util.Map;
import ti.l;

/* JADX INFO: loaded from: classes13.dex */
public interface e {
    l a(Context r100, String r101, FrameLayout r102, Map<String, ? extends Object> r103);

    SlcTemplateViewHelper b();

    View c(c r100, String r101);

    void d(com.bytedance.android.ecom.arch.slice.g r100, IAction r101, c r102);
}
