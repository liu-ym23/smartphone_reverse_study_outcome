package com.bytedance.android.live.openplatform.impl.minigameanchor.mount;

import android.content.DialogInterface;

/* JADX INFO: loaded from: classes46.dex */
public final class o implements DialogInterface.OnDismissListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LiveMgMountContextService$showStarAtlasAgreementDialog$1 f85247a;

    public o(LiveMgMountContextService$showStarAtlasAgreementDialog$1 r100) {
        this.f85247a = r100;
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public final void onDismiss(DialogInterface r100) {
        this.f85247a.invoke2("close");
    }
}
