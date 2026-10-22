package com.bytedance.android.livesdk.interactivity.interactive.dialog.provider;

import android.widget.CompoundButton;
import com.bytedance.android.livesdk.chatroom.ui.t9;

/* JADX INFO: loaded from: classes9.dex */
public final class r implements CompoundButton.OnCheckedChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ q.b f137330a;

    public r(q.b r100) {
        this.f137330a = r100;
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public final void onCheckedChanged(CompoundButton r100, boolean r101) {
        k82.a r102 = this.f137330a.f137328c.f137324c;
        if (r102 == null) goto L8;
        t9 r103 = r102.s();
        if (r103 == null) goto L9;
        r103.f114233q = r101;
        return;
    L9:
        return;
    }
}
