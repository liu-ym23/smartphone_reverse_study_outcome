package com.bytedance.apm.config;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.bytedance.apm.util.p;

/* JADX INFO: loaded from: classes3.dex */
public final class g extends BroadcastReceiver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ j f190486a;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ g f190487a;

        @Override // java.lang.Runnable
        public final void run() {
            this.f190487a.f190486a.k();     // Catch: Throwable -> L4
            return;
        }

        public a(g r100) {
            this.f190487a = r100;
        }
    }

    public g(j r100) {
        this.f190486a = r100;
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context r100, Intent r101) {
        if (r101 == null) goto L17;
        String r102 = r101.getStringExtra("PROCESS_NAME");     // Catch: Throwable -> L14
        com.bytedance.apm.d.getContext();     // Catch: Throwable -> L14
        String r103 = p.a();     // Catch: Throwable -> L14
        if (com.bytedance.apm.d.j() == false) goto L7;
        ps3.b.a(new String[]{"BroadcastReceiver.onReceive, processName:", r102, "currentProcessName:", r103});     // Catch: Throwable -> L14
    L7:
        if (TextUtils.isEmpty(r102) == false) goto L9;
        return;
    L9:
        if (TextUtils.isEmpty(r103) == false) goto L11;
        return;
    L11:
        if (r102.equals(r103) == true) goto L20;
        bt3.b.d.f20539a.e(new a(this));     // Catch: Throwable -> L14
        return;
    L20:
        return;
    L21:
        return;
    }
}
