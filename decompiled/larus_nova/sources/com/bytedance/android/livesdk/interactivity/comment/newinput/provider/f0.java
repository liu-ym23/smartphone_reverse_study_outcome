package com.bytedance.android.livesdk.interactivity.comment.newinput.provider;

import android.view.View;
import com.bytedance.android.livesdk.interactivity.api.input.ActivityEmojiAutoTestUtil;

/* JADX INFO: loaded from: classes9.dex */
public final class f0 implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ e0.c f135876a;

    public f0(e0.c r100) {
        this.f135876a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        StringBuilder r101 = new StringBuilder("portrait send button click, panelBridge empty?");
        if (this.f135876a.f135871e.f135866a != null) goto L5;
        boolean r102 = true;
    L6:
        r101.append(r102);
        i40.h.c(r101.toString(), true);
        com.bytedance.android.livesdk.interactivity.comment.newinput.framework.g r103 = this.f135876a.f135871e.f135866a;
        if (r103 == null) goto L10;
        r103.p0();
    L10:
        if (com.bytedance.android.live.core.utils.v.a() == false) goto L18;
        ActivityEmojiAutoTestUtil.f133250c.getClass();
        if (ActivityEmojiAutoTestUtil.f133248a == true) goto L14;
        return;
    L14:
        if (com.bytedance.android.live.core.utils.v.a() == false) goto L20;
        ((com.bytedance.android.livesdk.interactivity.api.input.a) ActivityEmojiAutoTestUtil.f133249b.getValue()).f133254c = null;
        return;
    L20:
        return;
    L18:
        return;
    L5:
        r102 = false;
        goto L6
    }
}
