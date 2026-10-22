package com.bytedance.android.livesdk.chatroom.viewmodule.sharelinkpanel;

import android.view.View;
import android.widget.ImageView;

/* JADX INFO: loaded from: classes8.dex */
public final class g implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LiveLinkShareToThirdDialogFragment f115496a;

    public g(LiveLinkShareToThirdDialogFragment r100) {
        this.f115496a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        LiveLinkShareToThirdDialogFragment r101 = this.f115496a;
        if (r101.f115470l == false) goto L5;
        String r102 = "cancel_choose_find_me";
    L6:
        LiveLinkShareToThirdDialogFragment.T90(r101, r102);
        LiveLinkShareToThirdDialogFragment r103 = this.f115496a;
        boolean r104 = !r103.f115470l;
        r103.f115470l = r104;
        ImageView r105 = r103.f115464f;
        if (r105 == null) goto L10;
        r105.setSelected(r104);
        return;
    L10:
        return;
    L5:
        r102 = "choose_find_me";
        goto L6
    }
}
