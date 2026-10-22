package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.settingpanel.ui;

import com.bytedance.android.livesdk.chatroom.ui.LiveSwitchButton;
import np1.f;

/* JADX INFO: loaded from: classes8.dex */
public final class b implements LiveSwitchButton.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ OptionNormalView f116774a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ f f116775b;

    public b(OptionNormalView r100, f r101) {
        this.f116774a = r100;
        this.f116775b = r101;
    }

    @Override // com.bytedance.android.livesdk.chatroom.ui.LiveSwitchButton.e
    public final void d0(LiveSwitchButton r100, boolean r101) {
        this.f116775b.f520014d.a(Boolean.valueOf(r101));
        OptionNormalView r102 = this.f116774a;
        int r103 = OptionNormalView.f116765f;
        r102.R5(r101);
    }
}
