package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar_behavior;

import com.huawei.hms.push.constant.RemoteMessageConst;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class h3 implements com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ToolbarGroupPurchaseWidgetBehavior f117206a;

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.i
    public final /* synthetic */ void a() {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.i
    public final /* synthetic */ void onCancelClick() {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.i
    public final /* synthetic */ void onConfirmClick() {
    }

    public h3(ToolbarGroupPurchaseWidgetBehavior r100) {
        this.f117206a = r100;
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.i
    public final void b(com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.s r100, com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.s r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r100, "from");
        Intrinsics.checkNotNullParameter(r101, RemoteMessageConst.TO);
        if (r102 == false) goto L6;
        ToolbarGroupPurchaseWidgetBehavior r103 = this.f117206a;
        int r104 = ToolbarGroupPurchaseWidgetBehavior.f116985l;
        r103.b();
        return;
    }
}
