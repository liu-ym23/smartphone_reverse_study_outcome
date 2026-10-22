package com.bytedance.android.livesdk.quitroom;

import android.content.DialogInterface;
import io.reactivex.disposables.Disposable;

/* JADX INFO: loaded from: classes11.dex */
public final class c implements DialogInterface.OnDismissListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ NewRoomQuitDialog f156894a;

    public c(NewRoomQuitDialog r100) {
        this.f156894a = r100;
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public final void onDismiss(DialogInterface r100) {
        Disposable r101 = this.f156894a.f156886b;
        if (r101 == null) goto L5;
        r101.dispose();
    L5:
        this.f156894a.f156886b = null;
    }
}
