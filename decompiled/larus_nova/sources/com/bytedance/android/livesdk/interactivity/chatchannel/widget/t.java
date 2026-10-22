package com.bytedance.android.livesdk.interactivity.chatchannel.widget;

import android.content.DialogInterface;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes9.dex */
public final class t implements DialogInterface.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function0 f134701a;

    public t(Function0 r100) {
        this.f134701a = r100;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r100, int r101) {
        this.f134701a.invoke();
        r100.dismiss();
    }
}
