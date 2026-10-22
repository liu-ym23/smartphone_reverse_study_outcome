package com.bytedance.android.livesdk.chatroom.multitask;

import android.app.Dialog;
import android.content.DialogInterface;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes7.dex */
public final class d implements DialogInterface.OnDismissListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ e f107025a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ e.a f107026b;

    public d(e r100, e.a r101) {
        this.f107025a = r100;
        this.f107026b = r101;
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public final void onDismiss(DialogInterface r100) {
        Function1<? super Dialog, Unit> r101 = this.f107026b.f107029a.f107035e;
        if (r101 == null) goto L6;
        Unit r102 = r101.invoke(this.f107025a);
        return;
    }
}
