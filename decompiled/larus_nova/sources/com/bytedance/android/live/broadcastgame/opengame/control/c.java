package com.bytedance.android.live.broadcastgame.opengame.control;

import android.content.DialogInterface;
import io.reactivex.disposables.Disposable;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes45.dex */
public final class c implements DialogInterface.OnDismissListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ OpenPlatformControlService.e f59869a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Function0 f59870b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Function0 f59871c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Function0 f59872d;

    public c(OpenPlatformControlService.e r100, Function0 r101, Function0 r102, Function0 r103) {
        this.f59869a = r100;
        this.f59870b = r101;
        this.f59871c = r102;
        this.f59872d = r103;
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public final void onDismiss(DialogInterface r100) {
        OpenPlatformControlService r101 = this.f59869a.f59859c;
        int r102 = OpenPlatformControlService.f59839j;
        r101.i();
        Disposable r103 = this.f59869a.f59857a;
        if (r103 == null) goto L6;
        r103.dispose();
        return;
    }
}
