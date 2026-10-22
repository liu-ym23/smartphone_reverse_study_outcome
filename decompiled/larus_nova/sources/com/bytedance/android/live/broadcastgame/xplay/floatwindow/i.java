package com.bytedance.android.live.broadcastgame.xplay.floatwindow;

import android.text.TextUtils;
import com.bytedance.android.livesdk.message.model.mk;
import vlc.l;

/* JADX INFO: loaded from: classes45.dex */
public final class i implements l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ XplayFloatWindowView.ViewHolder f62163a;

    public i(XplayFloatWindowView.ViewHolder r100) {
        this.f62163a = r100;
    }

    @Override // vlc.l
    public final void onMessage(tlc.d r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        String r101 = r100.getMessageMethod();
        if (r101 != null) goto L8;
        return;
    L8:
        if (r101.hashCode() == 654092662) goto L11;
        return;
    L11:
        if (r101.equals("WebcastRoomStatsMessage") == false) goto L24;
        XplayFloatWindowView.ViewHolder r102 = this.f62163a;
        if (r102 == null) goto L25;
        String r103 = null;
        if ((r100 instanceof mk) == true) goto L17;
        r100 = null;
    L17:
        mk r104 = (mk) r100;
        if (r104 == null) goto L21;
        r103 = r104.getDisplayMiddle();
    L21:
        if (TextUtils.isEmpty(r103) == true) goto L26;
        r102.f62102h.setText(r103);
        return;
    L26:
        return;
    L25:
        return;
    }
}
