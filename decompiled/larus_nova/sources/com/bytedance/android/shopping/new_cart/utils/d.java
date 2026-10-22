package com.bytedance.android.shopping.new_cart.utils;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class d extends Handler {
    public d(Looper r100) {
        Intrinsics.checkNotNullParameter(r100, "looper");
        super(r100);
    }

    @Override // android.os.Handler
    public final void handleMessage(Message r100) {
        Intrinsics.checkNotNullParameter(r100, "msg");
        super.handleMessage(r100);     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        bg3.a r101 = a.f179357a;
        StringBuilder r102 = new StringBuilder();
        r102.append(String.valueOf(e.getMessage()));
        r102.append(", ");
        Throwable r103 = e.getCause();
        if (r103 == null) goto L9;
        String r104 = r103.getMessage();
    L10:
        r102.append(r104);
        r102.append(", ");
        r102.append(e.getClass().getName());
        a.j("CartHandler error", r102.toString(), null, 12);
        return;
    L9:
        r104 = null;
        goto L10
    }
}
