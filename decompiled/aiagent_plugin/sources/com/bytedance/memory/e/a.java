package com.bytedance.memory.e;

import com.bytedance.crash.CrashType;
import com.bytedance.crash.IOOMCallback;
import com.bytedance.memory.c.c;

/* JADX INFO: compiled from: MemoryWidgetOomCallBack.java */
/* JADX INFO: loaded from: classes.dex */
public class a implements IOOMCallback {
    public a() {
    }

    @Override // com.bytedance.crash.IOOMCallback
    public void onCrash(CrashType r1, Throwable r2, Thread r3, long r4) {
    L6:
        th = move-exception;
        th.printStackTrace();
        return;
    L3:
        if (com.bytedance.memory.c.b.i().e() == true) goto L11;
        c.a().a(r4);     // Catch: Throwable -> L6
        return;
    }
}
