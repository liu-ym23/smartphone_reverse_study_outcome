package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.morepanel.business.element;

import android.content.DialogInterface;
import android.view.KeyEvent;
import com.bytedance.android.livehostapi.business.shareinter.ILiveIMSharePostscriptComponent;

/* JADX INFO: loaded from: classes8.dex */
public final class g implements DialogInterface.OnKeyListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ILiveIMSharePostscriptComponent f116559a;

    public g(ILiveIMSharePostscriptComponent r100) {
        this.f116559a = r100;
    }

    @Override // android.content.DialogInterface.OnKeyListener
    public final boolean onKey(DialogInterface r100, int r101, KeyEvent r102) {
        if (r102.getAction() == 0) goto L5;
        return false;
    L5:
        if (r102.getKeyCode() == 4) goto L7;
        return false;
    L7:
        return this.f116559a.onBackPressed();
    }
}
