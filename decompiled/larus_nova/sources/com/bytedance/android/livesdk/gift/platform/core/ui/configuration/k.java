package com.bytedance.android.livesdk.gift.platform.core.ui.configuration;

import android.content.DialogInterface;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes9.dex */
public final class k implements DialogInterface.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function1 f131980a;

    public k(Function1 r100) {
        this.f131980a = r100;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r100, int r101) {
        this.f131980a.invoke(Boolean.FALSE);
        r100.dismiss();
    }
}
