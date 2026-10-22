package com.bytedance.android.live.broadcastgame.openplatform.miniapp;

import android.content.DialogInterface;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes45.dex */
public final class c implements DialogInterface.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function0 f61741a;

    public c(Function0 r100) {
        this.f61741a = r100;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r100, int r101) {
        this.f61741a.invoke();
        r100.dismiss();
    }
}
