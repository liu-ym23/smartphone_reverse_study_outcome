package com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.nav.legacy;

import com.bytedance.android.shopping.anchorv4.params.V4NativeParams;
import com.google.gson.internal.LinkedTreeMap;
import io.reactivex.disposables.CompositeDisposable;

/* JADX INFO: loaded from: classes13.dex */
public interface a0 extends l {
    LinkedTreeMap<String, Object> b();

    V4NativeParams c();

    CompositeDisposable compositeDisposable();

    boolean e();

    boolean isExpanded();

    boolean n();

    void o(String r100);

    void openSchema(String r100);

    long p();

    void q(com.bytedance.android.shopping.anchorv4.log.d r100, Object r101, int r102);

    void s(boolean r100);

    void t(com.bytedance.android.shopping.prepurchase.arch.container.ability.b r100);
}
