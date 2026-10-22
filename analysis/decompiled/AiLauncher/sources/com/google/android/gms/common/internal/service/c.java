package com.google.android.gms.common.internal.service;

import D2.i;
import D2.j;
import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.api.c;
import com.google.android.gms.common.api.internal.AbstractC1651q;
import com.google.android.gms.common.api.internal.InterfaceC1649o;
import com.google.android.gms.common.internal.C1673n;
import com.google.android.gms.common.internal.InterfaceC1672m;
import com.google.android.gms.common.internal.TelemetryData;
import w2.C5720d;

/* loaded from: classes2.dex */
public final class c extends com.google.android.gms.common.api.c implements InterfaceC1672m {

    /* renamed from: k, reason: collision with root package name */
    public static final a.g f19843k;

    /* renamed from: l, reason: collision with root package name */
    public static final a.AbstractC0224a f19844l;

    /* renamed from: m, reason: collision with root package name */
    public static final com.google.android.gms.common.api.a f19845m;

    static {
        a.g gVar = new a.g();
        f19843k = gVar;
        b bVar = new b();
        f19844l = bVar;
        f19845m = new com.google.android.gms.common.api.a("ClientTelemetry.API", bVar, gVar);
    }

    public c(Context context, C1673n c1673n) {
        super(context, f19845m, c1673n, c.a.f19506c);
    }

    @Override // com.google.android.gms.common.internal.InterfaceC1672m
    public final i<Void> a(final TelemetryData telemetryData) {
        AbstractC1651q.a aVarA = AbstractC1651q.a();
        aVarA.d(C5720d.f43049a);
        aVarA.c(false);
        aVarA.b(new InterfaceC1649o() { // from class: com.google.android.gms.common.internal.service.a
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.google.android.gms.common.api.internal.InterfaceC1649o
            public final void accept(Object obj, Object obj2) throws RemoteException {
                a.g gVar = c.f19843k;
                ((zai) ((d) obj).A()).zae(telemetryData);
                ((j) obj2).c(null);
            }
        });
        return e(aVarA.a());
    }
}
