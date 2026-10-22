package com.bytedance.android.livesdk.interactivity.chatchannel.widget;

import android.content.DialogInterface;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes9.dex */
public final class x implements DialogInterface.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function0 f134705a;

    public x(Function0 r100) {
        this.f134705a = r100;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r100, int r101) {
        this.f134705a.invoke();
        r100.dismiss();
    }
}
