package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.internal.InterfaceC0406d;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;

/* loaded from: classes.dex */
public abstract class e extends c implements Z0.c {

    /* renamed from: x, reason: collision with root package name */
    public final Set f9804x;

    /* renamed from: y, reason: collision with root package name */
    public final Account f9805y;

    /* JADX WARN: Illegal instructions before constructor call */
    public e(Context context, Looper looper, int i4, d dVar, InterfaceC0406d interfaceC0406d, com.google.android.gms.common.api.internal.j jVar) {
        synchronized (u.f9848g) {
            try {
                if (u.f9849h == null) {
                    u.f9849h = new u(context.getApplicationContext(), context.getMainLooper());
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        u uVar = u.f9849h;
        Object obj = com.google.android.gms.common.b.f9700b;
        com.stepos.statsrpk.c.l(interfaceC0406d);
        com.stepos.statsrpk.c.l(jVar);
        super(context, looper, uVar, i4, new b(interfaceC0406d), new b(jVar), dVar.f9801g);
        this.f9805y = dVar.f9795a;
        Set set = dVar.f9797c;
        Iterator it = set.iterator();
        while (it.hasNext()) {
            if (!set.contains((Scope) it.next())) {
                throw new IllegalStateException("Expanding scopes is not permitted, use implied scopes instead");
            }
        }
        this.f9804x = set;
    }

    @Override // Z0.c
    public final Set a() {
        return g() ? this.f9804x : Collections.emptySet();
    }
}
