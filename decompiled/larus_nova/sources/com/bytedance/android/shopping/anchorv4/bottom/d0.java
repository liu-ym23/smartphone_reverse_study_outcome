package com.bytedance.android.shopping.anchorv4.bottom;

import android.view.View;
import com.bytedance.android.btm.api.model.PageFinder;
import com.bytedance.android.ec.model.sku.SkuRestoreState;
import com.bytedance.android.ecom.arch.slice.action.IAction;
import com.bytedance.android.shopping.anchorv4.dto.meta.CommonMeta;
import com.bytedance.android.shopping.anchorv4.params.V4NativeParams;
import io.reactivex.disposables.Disposable;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes12.dex */
public interface d0 extends j73.m {
    CommonMeta a();

    boolean e();

    void g(Disposable r100);

    String getSessionId();

    void h(List<String> r100);

    Boolean i();

    void k(SkuRestoreState r100);

    boolean m(IAction r100, View r101);

    void n(String r100, Map<String, ? extends Object> r101, boolean r102, boolean r103, String r104, PageFinder r105);

    int r();

    V4NativeParams w();
}
