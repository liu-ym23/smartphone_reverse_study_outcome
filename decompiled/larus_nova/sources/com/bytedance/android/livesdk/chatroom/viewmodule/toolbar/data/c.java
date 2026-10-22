package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.data;

import com.bytedance.android.livesdk.widget.CommonStandardBottomDialog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class c implements com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.control.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AudienceMoreDialogManagerService f115907a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f115908b;

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.control.a
    public final void onFailed(Throwable r100) {
        Intrinsics.checkNotNullParameter(r100, "t");
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.control.a
    public final void a() {
        this.f115907a.i(this.f115908b);
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.control.a
    public final void b() {
        AudienceMoreDialogManagerService.c(this.f115907a);
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.control.a
    public final boolean isShowing() {
        CommonStandardBottomDialog r100 = this.f115907a.f115895c;
        if (r100 != null) goto L5;
    L7:
        return false;
    L5:
        if (r100.isShowing() != true) goto L7;
        return true;
    }

    public c(AudienceMoreDialogManagerService r100, String r101) {
        this.f115907a = r100;
        this.f115908b = r101;
    }
}
