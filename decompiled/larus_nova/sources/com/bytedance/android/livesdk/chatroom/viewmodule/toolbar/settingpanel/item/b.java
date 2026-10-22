package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.settingpanel.item;

import android.view.View;
import com.bytedance.android.livesdk.chatroom.ui.LiveSwitchButton;
import com.bytedance.android.livesdk.r3;

/* JADX INFO: loaded from: classes8.dex */
public final class b implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LiveSwitchButton f116754a;

    public b(LiveSwitchButton r100) {
        this.f116754a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        if (r3.l(r100.getContext()) == false) goto L8;
        LiveSwitchButton r101 = this.f116754a;
        if (r101 == null) goto L9;
        r101.performClick();
        return;
    L9:
        return;
    }
}
