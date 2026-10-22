package com.bytedance.android.livesdk.interactivity.api.publicscreenpanel.api;

import android.content.Context;
import android.view.View;
import com.bytedance.android.livesdk.interactivity.api.entity.l;
import com.bytedance.android.livesdk.interactivity.api.publicscreenpanel.enums.PanelItemSymbol;

/* JADX INFO: loaded from: classes9.dex */
public interface a {
    PanelItemSymbol a();

    boolean b(l r100);

    void c(l r100, e r101);

    View getView(Context r100);

    void onClick(View r100);

    void onDestroyView();
}
