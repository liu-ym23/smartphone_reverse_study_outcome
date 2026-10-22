package com.google.android.gms.common.api.internal;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;

/* loaded from: classes2.dex */
public final class Q extends BroadcastReceiver {

    /* renamed from: a, reason: collision with root package name */
    public Context f19567a;

    /* renamed from: b, reason: collision with root package name */
    public final P f19568b;

    public Q(P p10) {
        this.f19568b = p10;
    }

    public final void a(Context context) {
        this.f19567a = context;
    }

    public final synchronized void b() {
        try {
            Context context = this.f19567a;
            if (context != null) {
                context.unregisterReceiver(this);
            }
            this.f19567a = null;
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        Uri data = intent.getData();
        if ("com.google.android.gms".equals(data != null ? data.getSchemeSpecificPart() : null)) {
            this.f19568b.a();
            b();
        }
    }
}
