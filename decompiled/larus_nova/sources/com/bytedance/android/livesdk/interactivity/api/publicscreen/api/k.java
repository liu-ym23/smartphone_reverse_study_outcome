package com.bytedance.android.livesdk.interactivity.api.publicscreen.api;

import android.content.Context;
import android.view.View;

/* JADX INFO: loaded from: classes9.dex */
public interface k {
    AudiencePanelItemSymbol a();

    void b(com.bytedance.android.live.base.model.message.t r100, v r101);

    boolean canShow();

    View getView(Context r100);

    void onClick(View r100);

    void onDestroyView();
}
