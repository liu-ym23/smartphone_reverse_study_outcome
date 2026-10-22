package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.settingpanel.item;

import android.view.View;
import android.widget.TextView;
import com.bytedance.android.live.core.setting.b6;
import com.bytedance.android.livesdk.chatroom.ui.LiveSwitchButton;
import com.bytedance.android.livesdk.sharedpref.e;
import com.bytedance.android.livesdk.sharedpref.f;
import rx1.m;

/* JADX INFO: loaded from: classes8.dex */
public final class d implements LiveSwitchButton.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ SmallWindowItem$PartSceneSmallWindowOpt$provide$1.AnonymousClass2.a f116756a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ View f116757b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ TextView f116758c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ LiveSwitchButton f116759d;

    public d(SmallWindowItem$PartSceneSmallWindowOpt$provide$1.AnonymousClass2.a r100, View r101, TextView r102, LiveSwitchButton r103) {
        this.f116756a = r100;
        this.f116757b = r101;
        this.f116758c = r102;
        this.f116759d = r103;
    }

    @Override // com.bytedance.android.livesdk.chatroom.ui.LiveSwitchButton.e
    public final void d0(LiveSwitchButton r100, boolean r101) {
        if (r101 == true) goto L4;
        e<Integer> r102 = b6.f65240j;
        r102.getClass();
        f.d(r102, 2);
        com.bytedance.android.livesdk.floatview.mob.a.c("close");
    L9:
        SmallWindowItem.d.a(SmallWindowItem.d.f116752a, this.f116757b, this.f116758c, this.f116759d, r101);
        return;
    L4:
        if (m.e(r100.getContext()) == false) goto L6;
        e<Integer> r103 = b6.f65240j;
        r103.getClass();
        f.d(r103, 1);
    L7:
        com.bytedance.android.livesdk.floatview.mob.a.c("open");
        goto L9
    L6:
        this.f116756a.f116748a.f520010c.closeSettingPanel();
        m.h(r100.getContext());
        e<Integer> r104 = b6.f65240j;
        r104.getClass();
        f.d(r104, 1);
        goto L7
    }
}
