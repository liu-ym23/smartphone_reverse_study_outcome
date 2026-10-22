package com.bytedance.android.livesdk.chatroom.ui.record;

import android.view.View;
import com.bytedance.android.live.core.utils.f2;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.helpers.PopupWindowLancet;

/* JADX INFO: loaded from: classes8.dex */
public final class d implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ e f113987a;

    public d(e r100) {
        this.f113987a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        e r101 = this.f113987a;
        long r102 = r101.f113993f;
        if (r102 < 4000) goto L5;
    L7:
        r101.f113994g = r102;
        PopupWindowLancet.handleDismissBeforeOrigin(r101);
        r101.dismiss();
        return;
    L5:
        if (r102 == 0) goto L7;
        f2.c(r101.getContext().getString(R.string.ttlive_live_record_3s_hint, new Object[]{3}), 0);
    }
}
