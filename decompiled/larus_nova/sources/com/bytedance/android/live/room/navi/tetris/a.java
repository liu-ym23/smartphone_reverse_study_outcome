package com.bytedance.android.live.room.navi.tetris;

import android.os.Bundle;
import android.view.View;
import com.bytedance.android.livesdk.popup.manager.LivePopupWindow;
import com.obric.assistant.interaction.impl.window.helpers.PopupWindowLancet;
import kotlin.Unit;
import zg1.h1;

/* JADX INFO: loaded from: classes47.dex */
public final class a implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AnchorRoomNavigatorTetris f99756a;

    public a(AnchorRoomNavigatorTetris r100) {
        this.f99756a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        LivePopupWindow r101 = this.f99756a.f99718w;
        if (r101 != null) goto L5;
    L15:
        h1 r102 = new h1(6);
        Bundle r103 = new Bundle();
        r103.putLong("time", System.currentTimeMillis());
        r103.putString("action_type", "click");
        Unit r104 = Unit.INSTANCE;
        r102.f571839d = r103;
        xs2.b.a().post(r102);
        return;
    L5:
        if (r101.isShowing() == true) goto L7;
    L9:
        boolean r105 = false;
    L10:
        if (r105 == true) goto L13;
        r101 = null;
    L13:
        if (r101 == null) goto L15;
        PopupWindowLancet.handleDismissBeforeOrigin(r101);
        r101.dismiss();
        goto L15
    L7:
        if (this.f99756a.W() == false) goto L9;
        r105 = true;
        goto L10
    }
}
