package com.bytedance.android.livesdk.chatroom.widget;

import android.widget.ImageView;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes8.dex */
public final class w implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ u.d f119254a;

    public w(u.d r100) {
        this.f119254a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        u r100 = this.f119254a.f119216b;     // Catch: Throwable -> L8
        ImageView r101 = r100.f119190b;     // Catch: Throwable -> L8
        if (r101 == null) goto L5;
        Integer r102 = Integer.valueOf(r101.getWidth());     // Catch: Throwable -> L8
    L6:
        u.a(r100, r102);     // Catch: Throwable -> L8
        return;
    L5:
        r102 = null;
    L8:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L12;
        return;
    L12:
        throw th;
    }
}
