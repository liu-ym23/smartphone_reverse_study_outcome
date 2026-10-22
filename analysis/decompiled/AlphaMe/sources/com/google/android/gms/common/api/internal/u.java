package com.google.android.gms.common.api.internal;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;

/* loaded from: classes.dex */
public final class u extends BroadcastReceiver {

    /* renamed from: a, reason: collision with root package name */
    public Context f9685a;

    /* renamed from: b, reason: collision with root package name */
    public final B0.c f9686b;

    public u(B0.c cVar) {
        this.f9686b = cVar;
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        Uri data = intent.getData();
        if ("com.google.android.gms".equals(data != null ? data.getSchemeSpecificPart() : null)) {
            this.f9686b.n();
            synchronized (this) {
                try {
                    Context context2 = this.f9685a;
                    if (context2 != null) {
                        context2.unregisterReceiver(this);
                    }
                    this.f9685a = null;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }
}
