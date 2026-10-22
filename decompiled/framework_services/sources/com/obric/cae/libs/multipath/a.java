package com.obric.cae.libs.multipath;

import android.os.IBinder;
import android.util.Log;

/* JADX INFO: compiled from: CaeMultipathClient.java */
/* JADX INFO: loaded from: classes3.dex */
public final class a implements IBinder.DeathRecipient {
    public final /* synthetic */ CaeMultipathClient a;

    public a(CaeMultipathClient r1) {
        this.a = r1;
    }

    @Override // android.os.IBinder.DeathRecipient
    public final void binderDied() {
        Log.w("CaeMultipathClient", "Service binder died, reconnecting...");
        CaeMultipathClient r0 = this.a;
        r0.a = null;
        r0.c.sendEmptyMessage(1);
    }
}
