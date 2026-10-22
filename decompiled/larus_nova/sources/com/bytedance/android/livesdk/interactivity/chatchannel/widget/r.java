package com.bytedance.android.livesdk.interactivity.chatchannel.widget;

import android.content.DialogInterface;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes9.dex */
public final class r implements DialogInterface.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function0 f134699a;

    public r(Function0 r100) {
        this.f134699a = r100;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r100, int r101) {
        this.f134699a.invoke();
        r100.dismiss();
    }
}
