package com.google.android.gms.common.internal;

import android.content.ComponentName;
import android.os.Handler;
import android.os.Message;
import android.util.Log;

/* loaded from: classes.dex */
public final class t implements Handler.Callback {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ u f9847a;

    public /* synthetic */ t(u uVar) {
        this.f9847a = uVar;
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message message) {
        int i4 = message.what;
        if (i4 == 0) {
            synchronized (this.f9847a.f9851a) {
                try {
                    r rVar = (r) message.obj;
                    s sVar = (s) this.f9847a.f9851a.get(rVar);
                    if (sVar != null && sVar.f9837a.isEmpty()) {
                        if (sVar.f9839c) {
                            sVar.f9843g.f9853c.removeMessages(1, sVar.f9841e);
                            u uVar = sVar.f9843g;
                            uVar.f9854d.a(uVar.f9852b, sVar);
                            sVar.f9839c = false;
                            sVar.f9838b = 2;
                        }
                        this.f9847a.f9851a.remove(rVar);
                    }
                } finally {
                }
            }
            return true;
        }
        if (i4 != 1) {
            return false;
        }
        synchronized (this.f9847a.f9851a) {
            try {
                r rVar2 = (r) message.obj;
                s sVar2 = (s) this.f9847a.f9851a.get(rVar2);
                if (sVar2 != null && sVar2.f9838b == 3) {
                    String strValueOf = String.valueOf(rVar2);
                    Log.e("GmsClientSupervisor", "Timeout waiting for ServiceConnection callback ".concat(strValueOf), new Exception());
                    ComponentName componentName = sVar2.f9842f;
                    if (componentName == null) {
                        rVar2.getClass();
                        componentName = null;
                    }
                    if (componentName == null) {
                        String str = rVar2.f9834b;
                        com.stepos.statsrpk.c.l(str);
                        componentName = new ComponentName(str, "unknown");
                    }
                    sVar2.onServiceDisconnected(componentName);
                }
            } finally {
            }
        }
        return true;
    }
}
