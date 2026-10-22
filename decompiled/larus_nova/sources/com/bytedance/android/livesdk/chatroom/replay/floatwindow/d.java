package com.bytedance.android.livesdk.chatroom.replay.floatwindow;

import android.media.AudioManager;
import android.view.View;
import com.bytedance.android.live.core.log.ALogger;
import com.larus.nova.R;
import com.ss.android.videoshop.mediaview.SimpleMediaView;

/* JADX INFO: loaded from: classes7.dex */
public final class d implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ b f108659a;

    public d(b r100) {
        this.f108659a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        this.f108659a.a(R.id.float_mute).setSelected(!this.f108659a.a(R.id.float_mute).isSelected());
        if (this.f108659a.a(R.id.float_mute).isSelected() == false) goto L16;
        SimpleMediaView r101 = this.f108659a.f108655n;
        if (r101 == null) goto L18;
        r101.setMute(true);
        return;
    L18:
        return;
    L16:
        AudioManager r102 = com.bytedance.android.livesdk.chatroom.vs_base.base.util.c.f117924a;     // Catch: Exception -> L11
        if (r102.requestAudioFocus(com.bytedance.android.livesdk.chatroom.vs_base.base.util.c.f117927d, 3, 2) != 1) goto L12;
        r102.registerMediaButtonEventReceiver(com.bytedance.android.livesdk.chatroom.vs_base.base.util.c.f117925b);     // Catch: Exception -> L11
    L12:
        SimpleMediaView r103 = this.f108659a.f108655n;
        if (r103 == null) goto L20;
        r103.setMute(false);
        return;
    L20:
        return;
    L11:
        ALogger.w("ReplayAudioUtils", "gainFocus error");
        goto L12
    }
}
