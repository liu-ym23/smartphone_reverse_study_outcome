package com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability;

import android.graphics.Rect;
import android.view.View;
import com.bytedance.android.ecom.arch.slice.SlcContext;
import com.bytedance.android.ecom.arch.slice.action.ActionContext;
import com.bytedance.android.ecom.arch.slice.action.IAction;
import com.bytedance.android.shopping.anchorv4.dto.business.GalleryVO;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes13.dex */
public interface v extends d83.c {
    List<String> getImages();

    void k0(String r100);

    void l0(int r100, String r101);

    void l9(GalleryVO r100);

    boolean m0(Boolean r100, boolean r101);

    Rect m9();

    ActionContext n0();

    float n9();

    void o9(boolean r100, int r101);

    void p9(com.bytedance.android.ecom.arch.slice.g r100, IAction r101, View r102, Map<String, ? extends Object> r103);

    SlcContext q9();

    void r9();

    boolean s();

    void s9(int r100);

    void t(b0 r100);

    void w5(Map<Integer, String> r100);

    void x(p r100);

    void y5(String r100);

    void z(View r100, String r101, Map<String, ? extends Object> r102, Map<String, ? extends Object> r103);

    void z5(boolean r100);
}
