package com.google.android.gms.common.internal.service;

import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.internal.InterfaceC0406d;
import com.google.android.gms.common.api.internal.j;
import com.google.android.gms.common.internal.d;
import com.google.android.gms.common.internal.e;
import com.google.android.gms.common.internal.g;
import g1.AbstractC0574b;

/* loaded from: classes.dex */
public final class c extends e {

    /* renamed from: z, reason: collision with root package name */
    public final g f9846z;

    public c(Context context, Looper looper, d dVar, g gVar, InterfaceC0406d interfaceC0406d, j jVar) {
        super(context, looper, 270, dVar, interfaceC0406d, jVar);
        this.f9846z = gVar;
    }

    @Override // com.google.android.gms.common.internal.c, Z0.c
    public final int e() {
        return 203400000;
    }

    @Override // com.google.android.gms.common.internal.c
    public final /* synthetic */ IInterface i(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.service.IClientTelemetryService");
        return iInterfaceQueryLocalInterface instanceof zai ? (zai) iInterfaceQueryLocalInterface : new zai(iBinder);
    }

    @Override // com.google.android.gms.common.internal.c
    public final Feature[] j() {
        return AbstractC0574b.f12658b;
    }

    @Override // com.google.android.gms.common.internal.c
    public final Bundle k() {
        g gVar = this.f9846z;
        gVar.getClass();
        Bundle bundle = new Bundle();
        String str = gVar.f9809a;
        if (str != null) {
            bundle.putString("api", str);
        }
        return bundle;
    }

    @Override // com.google.android.gms.common.internal.c
    public final String m() {
        return "com.google.android.gms.common.internal.service.IClientTelemetryService";
    }

    @Override // com.google.android.gms.common.internal.c
    public final String n() {
        return "com.google.android.gms.common.telemetry.service.START";
    }

    @Override // com.google.android.gms.common.internal.c
    public final boolean o() {
        return true;
    }
}
