package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar_behavior;

import android.content.Context;
import android.content.DialogInterface;

/* JADX INFO: loaded from: classes8.dex */
public final class o3 implements DialogInterface.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ToolbarLiteCommerceBehavior f117323a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Context f117324b;

    public o3(ToolbarLiteCommerceBehavior r100, Context r101) {
        this.f117323a = r100;
        this.f117324b = r101;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r100, int r101) {
        ToolbarLiteCommerceBehavior r102 = this.f117323a;
        Context r103 = this.f117324b;
        int r104 = ToolbarLiteCommerceBehavior.f116997g;
        r102.a(r103);
        r100.cancel();
    }
}
