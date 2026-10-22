package com.bytedance.android.livesdk.gift.platform.core.ui.configuration;

import android.content.DialogInterface;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes9.dex */
public final class j implements DialogInterface.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function1 f131979a;

    public j(Function1 r100) {
        this.f131979a = r100;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r100, int r101) {
        this.f131979a.invoke(Boolean.TRUE);
        r100.dismiss();
    }
}
