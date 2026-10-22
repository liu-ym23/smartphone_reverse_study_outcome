package com.bytedance.android.shopping.prepurchase.arch.container.intf;

import com.bytedance.android.shopping.prepurchase.arch.container.state.ObservableData;

/* JADX INFO: loaded from: classes13.dex */
public interface j<STORE> extends com.bytedance.android.shopping.prepurchase.arch.container.ability.a {
    STORE getData();

    ObservableData q0();

    void retry();
}
