package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar_behavior;

import android.view.View;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ToolbarButton;
import com.bytedance.android.livesdk.config.yo0;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.utils.PublicScreenStyleHelper;
import com.bytedance.ies.sdk.widgets.DataCenter;

/* JADX INFO: loaded from: classes8.dex */
public final class d0 implements com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b {
    public d0() {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ void Bh(ToolbarButton r100) {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ void Mr(com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.s r100) {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ void R9(View r100, DataCenter r101) {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ void SY(com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.s r100) {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ void Y6() {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ void dv(com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.e r100) {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ com.bytedance.android.livesdk.reddot.a h7() {
        return null;
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ void onHide(boolean r100) {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ void p4(View r100, DataCenter r101) {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ void setAlpha(float r100) {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final boolean showRedDot() {
        if (yo0.f121705a.getValue().booleanValue() == false) goto L6;
        return false;
    L6:
        if (PublicScreenStyleHelper.f133624n == true) goto L8;
        return false;
    L8:
        if (PublicScreenStyleHelper.f133619i.getValue().booleanValue() == false) goto L12;
        return true;
    L12:
        return false;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        xs2.b.a().post(new o42.k("live_more_panel"));
    }
}
