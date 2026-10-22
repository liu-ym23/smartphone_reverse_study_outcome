package com.zyql.ability.sdk.client;

import R5.d;
import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.zyql.ability.service.IAbilityService;
import h7.C1491a;

/* loaded from: classes3.dex */
public final class c implements ServiceConnection {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ d f4239a;

    public c(d dVar) {
        this.f4239a = dVar;
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        C1491a.a("ServiceConnector", "On IAbilityService service connected.");
        IAbilityService iAbilityServiceAsInterface = IAbilityService.Stub.asInterface(iBinder);
        d dVar = this.f4239a;
        dVar.c = iAbilityServiceAsInterface;
        dVar.b = false;
        com.uxsense.parse.b bVar = (com.uxsense.parse.b) dVar.e;
        if (bVar != null) {
            bVar.invoke(Boolean.TRUE);
        }
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        C1491a.a("ServiceConnector", "On IAbilityService service disconnected.");
        this.f4239a.c = null;
    }
}
