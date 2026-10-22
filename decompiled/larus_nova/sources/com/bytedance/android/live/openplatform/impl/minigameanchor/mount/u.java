package com.bytedance.android.live.openplatform.impl.minigameanchor.mount;

import android.content.DialogInterface;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes46.dex */
public final class u implements DialogInterface.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function0 f85255a;

    public u(Function0 r100) {
        this.f85255a = r100;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r100, int r101) {
        this.f85255a.invoke();
        r100.dismiss();
    }
}
