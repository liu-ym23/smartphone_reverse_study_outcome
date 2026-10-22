package com.bytedance.android.livesdk.chatroom.ui;

import android.view.View;

/* JADX INFO: loaded from: classes8.dex */
public abstract class u5 implements View.OnClickListener {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static boolean f114241b = true;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final t5 f114242c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f114243a;

    public abstract void a(View r100);

    /* JADX WARN: Type inference failed for: r0v0, types: [com.bytedance.android.livesdk.chatroom.ui.t5] */
    static {
        f114242c = new t5();
    }

    public u5() {
        this.f114243a = 500;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        if (f114241b == false) goto L6;
        f114241b = false;
        r100.postDelayed(f114242c, this.f114243a);
        a(r100);
        return;
    }
}
