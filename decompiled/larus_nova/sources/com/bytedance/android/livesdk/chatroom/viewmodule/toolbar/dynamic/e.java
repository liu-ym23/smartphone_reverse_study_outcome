package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic;

import android.content.DialogInterface;

/* JADX INFO: loaded from: classes8.dex */
public final class e implements DialogInterface.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ d f116097a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ long f116098b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ s f116099c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ s f116100d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ i f116101e;

    public e(d r100, long r101, s r102, s r103, i r104) {
        this.f116097a = r100;
        this.f116098b = r101;
        this.f116099c = r102;
        this.f116100d = r103;
        this.f116101e = r104;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r100, int r101) {
        this.f116097a.b(this.f116098b, this.f116099c, this.f116100d, this.f116101e);
        i r102 = this.f116101e;
        if (r102 == null) goto L5;
        r102.onConfirmClick();
    L5:
        r100.dismiss();
    }
}
