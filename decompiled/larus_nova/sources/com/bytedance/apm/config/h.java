package com.bytedance.apm.config;

import android.content.Intent;
import com.bytedance.apm.util.p;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes14.dex */
public final class h implements Runnable {
    @Override // java.lang.Runnable
    public final void run() {
        Intent r100 = new Intent("com.apm.setting.update.action");     // Catch: Throwable -> L6 Exception -> L12
        com.bytedance.apm.d.getContext();     // Catch: Throwable -> L6 Exception -> L12
        r100.putExtra("PROCESS_NAME", p.a());     // Catch: Throwable -> L6 Exception -> L12
        com.bytedance.apm.d.getContext().sendBroadcast(r100);     // Catch: Throwable -> L6 Exception -> L12
        if (com.bytedance.apm.d.j() == false) goto L11;
        ps3.b.a(new String[]{"BroadcastReceiver.sendBroadUpdateSetting"});     // Catch: Throwable -> L6 Exception -> L12
        goto L17
    L15:
        return;
    L11:
        return;
    L6:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L16;
        throw th;
    L16:
        return;
    }

    public h() {
    }
}
