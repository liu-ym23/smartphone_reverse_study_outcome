package com.bytedance.android.livesdk.chatroom.ui;

import android.widget.EditText;

/* JADX INFO: loaded from: classes8.dex */
public final /* synthetic */ class j9 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ SimpleInputDialogFragment f113635a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ long f113636b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f113637c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ int f113638d;

    public /* synthetic */ j9(SimpleInputDialogFragment r100, long r101, int r102, int r103) {
        this.f113635a = r100;
        this.f113636b = r101;
        this.f113637c = r102;
        this.f113638d = r103;
    }

    @Override // java.lang.Runnable
    public final void run() {
        SimpleInputDialogFragment r100 = this.f113635a;
        long r101 = this.f113636b;
        int r102 = this.f113637c;
        int r103 = this.f113638d;
        int r104 = SimpleInputDialogFragment.f112530p;
        if (r100.isResumed() == true) goto L5;
        return;
    L5:
        if (r100.f112532e == false) goto L15;
        com.bytedance.android.livesdk.utils.t2.b(r100.getContext(), r100.f112535h);
        int r105 = r102 + 1;
        EditText r106 = r100.f112535h;
        if (r106 == null) goto L14;
        if (r105 > r103) goto L16;
        r106.postDelayed(new j9(r100, r101, r105, r103), r101);
        return;
    L16:
        return;
    L14:
        return;
    }
}
