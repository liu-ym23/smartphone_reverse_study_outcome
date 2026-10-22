package com.bytedance.android.livesdk.gift.platform.business;

import android.content.Context;
import com.bytedance.android.livesdk.gift.model.h1;
import com.bytedance.android.livesdk.gift.model.w1;
import com.bytedance.android.livesdk.gift.platform.business.dialog.ui.panel.AbsPanel;
import com.bytedance.ies.sdk.widgets.DataCenter;

/* JADX INFO: loaded from: classes9.dex */
public interface h {

    public interface a {
        h a(DataCenter r100, Context r101);
    }

    com.bytedance.android.livesdk.gift.platform.business.dialog.topview.i<?> E();

    void a();

    AbsPanel<?> f(h1 r100);

    void g(w1 r100);

    void k(Context r100);

    void onDestroy();

    void w();
}
