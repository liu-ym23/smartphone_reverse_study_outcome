package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic;

import android.content.DialogInterface;

/* JADX INFO: loaded from: classes8.dex */
public final class g implements DialogInterface.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ d f116106a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ long f116107b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ s f116108c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ s f116109d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ i f116110e;

    public g(d r100, long r101, s r102, s r103, i r104) {
        this.f116106a = r100;
        this.f116107b = r101;
        this.f116108c = r102;
        this.f116109d = r103;
        this.f116110e = r104;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r100, int r101) {
        this.f116106a.b(this.f116107b, this.f116108c, this.f116109d, this.f116110e);
        r100.dismiss();
    }
}
