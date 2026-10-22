package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.config;

import android.content.Context;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ToolbarButton;
import com.bytedance.android.livesdkapi.room.handler.toolbar.NewToolbarButtonConstants;
import com.bytedance.android.livesdkapi.room.handler.viewinterface.IExternalButton;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class d extends com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.a0 {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Context f115985f;

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.a0
    public final boolean m() {
        return false;
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.a0
    public final com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.w j() {
        return new com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.w(ToolbarButton.COMMERCE_IM, null, null, null);
    }

    public final Context getContext() {
        return this.f115985f;
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.a0
    public final NewToolbarButtonConstants k() {
        return NewToolbarButtonConstants.ToolbarCommerceIM.INSTANCE;
    }

    public d(Context r100, DataCenter r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "dataCenter");
        super(null, null, 7);
        this.f115985f = r100;
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.a0
    public final String i(boolean r100, boolean r101) {
        return NewToolbarButtonConstants.ToolbarCommerceIM.INSTANCE.getName();
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.a0
    public final com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b g(com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.s r100, boolean r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r100, "button");
        Object r103 = r100.f116202l.f116105c;
        if ((r103 instanceof IExternalButton) == true) goto L5;
        r103 = null;
    L5:
        IExternalButton r104 = (IExternalButton) r103;
        if (r104 != null) goto L8;
        return null;
    L8:
        return new com.bytedance.android.livesdk.room.placeholder.behavior.f(r104);
    }
}
