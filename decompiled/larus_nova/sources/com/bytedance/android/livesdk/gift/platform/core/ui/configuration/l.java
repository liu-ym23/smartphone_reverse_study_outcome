package com.bytedance.android.livesdk.gift.platform.core.ui.configuration;

import android.content.DialogInterface;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes9.dex */
public final class l implements DialogInterface.OnCancelListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function1 f131981a;

    public l(Function1 r100) {
        this.f131981a = r100;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public final void onCancel(DialogInterface r100) {
        this.f131981a.invoke(Boolean.FALSE);
    }
}
