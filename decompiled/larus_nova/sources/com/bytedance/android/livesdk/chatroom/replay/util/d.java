package com.bytedance.android.livesdk.chatroom.replay.util;

import android.content.DialogInterface;
import android.view.KeyEvent;
import java.lang.ref.WeakReference;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class d implements DialogInterface.OnKeyListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final WeakReference<DialogInterface.OnKeyListener> f110269a;

    public d(WeakReference<DialogInterface.OnKeyListener> r100) {
        Intrinsics.checkNotNullParameter(r100, "weakReference");
        this.f110269a = r100;
    }

    @Override // android.content.DialogInterface.OnKeyListener
    public final boolean onKey(DialogInterface r100, int r101, KeyEvent r102) {
        Intrinsics.checkNotNullParameter(r100, "dialog");
        Intrinsics.checkNotNullParameter(r102, "event");
        if (this.f110269a.get() != null) goto L6;
        return false;
    L6:
        DialogInterface.OnKeyListener r103 = this.f110269a.get();
        Intrinsics.checkNotNull(r103);
        return r103.onKey(r100, r101, r102);
    }
}
