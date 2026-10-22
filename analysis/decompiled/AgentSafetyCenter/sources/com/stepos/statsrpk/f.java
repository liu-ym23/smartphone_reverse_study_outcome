package com.stepos.statsrpk;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.stepos.statsrpk.IRpkStatsInterface;
import p5.u;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class f implements ServiceConnection {

    /* renamed from: a, reason: collision with root package name */
    public /* synthetic */ u f2861a;

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        try {
            ua.c.a("RpkEmitter", "onServiceConnected, " + iBinder);
            this.f2861a.f9808g = IRpkStatsInterface.Stub.asInterface(iBinder);
        } catch (Exception e10) {
            ua.c.b("RpkEmitter", "Exception onServiceConnected:" + e10.toString() + " -Cause:" + e10.getCause());
        }
        synchronized (this) {
            notifyAll();
        }
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        ua.c.a("RpkEmitter", "onServiceDisconnected, " + componentName);
        u uVar = this.f2861a;
        uVar.f9808g = null;
        ((Context) uVar.f9807f).unbindService(this);
    }
}
