package com.google.android.gms.common.internal;

import android.app.PendingIntent;
import android.os.Bundle;
import com.google.android.gms.common.ConnectionResult;

/* loaded from: classes.dex */
public abstract class l {

    /* renamed from: a, reason: collision with root package name */
    public Object f9817a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f9818b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ c f9819c;

    /* renamed from: d, reason: collision with root package name */
    public final int f9820d;

    /* renamed from: e, reason: collision with root package name */
    public final Bundle f9821e;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ c f9822f;

    public l(c cVar, int i4, Bundle bundle) {
        this.f9822f = cVar;
        Boolean bool = Boolean.TRUE;
        this.f9819c = cVar;
        this.f9817a = bool;
        this.f9818b = false;
        this.f9820d = i4;
        this.f9821e = bundle;
    }

    public final /* bridge */ void a() {
        c cVar = this.f9822f;
        int i4 = this.f9820d;
        if (i4 != 0) {
            cVar.s(1, null);
            Bundle bundle = this.f9821e;
            b(new ConnectionResult(i4, bundle != null ? (PendingIntent) bundle.getParcelable("pendingIntent") : null));
        } else {
            if (c()) {
                return;
            }
            cVar.s(1, null);
            b(new ConnectionResult(8, null));
        }
    }

    public abstract void b(ConnectionResult connectionResult);

    public abstract boolean c();

    public final void d() {
        synchronized (this) {
            this.f9817a = null;
        }
        synchronized (this.f9819c.f9783k) {
            this.f9819c.f9783k.remove(this);
        }
    }
}
