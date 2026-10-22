package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.morepanel.business.element;

import android.view.View;
import com.bytedance.android.livehostapi.business.shareinter.ILiveIMSharePostscriptComponent;

/* JADX INFO: loaded from: classes8.dex */
public final class f implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ILiveIMSharePostscriptComponent f116558a;

    public f(ILiveIMSharePostscriptComponent r100) {
        this.f116558a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        this.f116558a.onOutSideClick();
    }
}
