package com.google.android.gms.common.internal;

import android.content.ComponentName;
import android.os.Handler;
import android.os.Message;
import android.util.Log;

/* loaded from: classes2.dex */
public final class X implements Handler.Callback {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Y f19761a;

    public /* synthetic */ X(Y y10, W w10) {
        this.f19761a = y10;
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message message) {
        int i10 = message.what;
        if (i10 == 0) {
            synchronized (this.f19761a.f19762f) {
                try {
                    U u10 = (U) message.obj;
                    V v10 = (V) this.f19761a.f19762f.get(u10);
                    if (v10 != null && v10.i()) {
                        if (v10.j()) {
                            v10.g("GmsClientSupervisor");
                        }
                        this.f19761a.f19762f.remove(u10);
                    }
                } finally {
                }
            }
            return true;
        }
        if (i10 != 1) {
            return false;
        }
        synchronized (this.f19761a.f19762f) {
            try {
                U u11 = (U) message.obj;
                V v11 = (V) this.f19761a.f19762f.get(u11);
                if (v11 != null && v11.a() == 3) {
                    Log.e("GmsClientSupervisor", "Timeout waiting for ServiceConnection callback " + String.valueOf(u11), new Exception());
                    ComponentName componentNameB = v11.b();
                    if (componentNameB == null) {
                        componentNameB = u11.a();
                    }
                    if (componentNameB == null) {
                        String strC = u11.c();
                        C1669j.k(strC);
                        componentNameB = new ComponentName(strC, "unknown");
                    }
                    v11.onServiceDisconnected(componentNameB);
                }
            } finally {
            }
        }
        return true;
    }
}
