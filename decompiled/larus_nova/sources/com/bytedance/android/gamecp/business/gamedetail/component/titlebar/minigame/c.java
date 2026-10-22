package com.bytedance.android.gamecp.business.gamedetail.component.titlebar.minigame;

import android.view.View;
import com.bytedance.android.gamecp.common.utils.n;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes44.dex */
public final class c implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function0 f55229a;

    public c(Function0 r100) {
        this.f55229a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        if (n.c("TitleMiniGameButtonWidget") == false) goto L6;
        yr.c.e("TitleMiniGameButtonWidget", "miniGameButton double click");
        return;
    L6:
        this.f55229a.invoke();
    }
}
