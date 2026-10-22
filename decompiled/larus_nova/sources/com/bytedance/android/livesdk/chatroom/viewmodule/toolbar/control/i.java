package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.control;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import com.bytedance.android.live.base.model.PanelWidget;
import com.bytedance.android.live.core.utils.ContextUtil;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ToolbarButton;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.s;
import com.bytedance.android.livesdk.schema.interfaces.ILiveActionHandler;
import com.bytedance.android.livesdk.service.l;
import com.bytedance.ies.sdk.widgets.DataCenter;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class i implements c0.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final PanelWidget f115880a;

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ void Bh(ToolbarButton r100) {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ void Mr(s r100) {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ void R9(View r100, DataCenter r101) {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ void SY(s r100) {
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
    public final /* synthetic */ boolean showRedDot() {
        return false;
    }

    public i(PanelWidget r100) {
        Intrinsics.checkNotNullParameter(r100, "widget");
        this.f115880a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        String r101 = this.f115880a.getScheme();
        if (r101 != null) goto L5;
        return;
    L5:
        if (r101.length() <= 0) goto L7;
        boolean r102 = true;
    L8:
        if (r102 != true) goto L19;
        if (r100 == null) goto L20;
        Context r103 = r100.getContext();
        if (r103 == null) goto L21;
        Activity r104 = ContextUtil.contextToActivity(r103);
        if (r104 == null) goto L22;
        ILiveActionHandler r105 = l.d().a();
        if (r105 == null) goto L23;
        r105.handle(r104, this.f115880a.getScheme());
        return;
    L23:
        return;
    L22:
        return;
    L21:
        return;
    L20:
        return;
    L19:
        return;
    L7:
        r102 = false;
        goto L8
    }
}
