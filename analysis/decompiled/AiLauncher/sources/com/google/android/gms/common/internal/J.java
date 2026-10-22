package com.google.android.gms.common.internal;

import android.app.PendingIntent;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;

/* loaded from: classes2.dex */
public final class J extends x2.c {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ AbstractC1662c f19739b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public J(AbstractC1662c abstractC1662c, Looper looper) {
        super(looper);
        this.f19739b = abstractC1662c;
    }

    public static final void a(Message message) {
        K k10 = (K) message.obj;
        k10.b();
        k10.e();
    }

    public static final boolean b(Message message) {
        int i10 = message.what;
        return i10 == 2 || i10 == 1 || i10 == 7;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        if (this.f19739b.f19777C.get() != message.arg1) {
            if (b(message)) {
                a(message);
                return;
            }
            return;
        }
        int i10 = message.what;
        if ((i10 == 1 || i10 == 7 || ((i10 == 4 && !this.f19739b.q()) || message.what == 5)) && !this.f19739b.b()) {
            a(message);
            return;
        }
        int i11 = message.what;
        if (i11 == 4) {
            this.f19739b.f19803z = new ConnectionResult(message.arg2);
            if (AbstractC1662c.d0(this.f19739b)) {
                AbstractC1662c abstractC1662c = this.f19739b;
                if (!abstractC1662c.f19775A) {
                    abstractC1662c.e0(3, null);
                    return;
                }
            }
            AbstractC1662c abstractC1662c2 = this.f19739b;
            ConnectionResult connectionResult = abstractC1662c2.f19803z != null ? abstractC1662c2.f19803z : new ConnectionResult(8);
            this.f19739b.f19793p.a(connectionResult);
            this.f19739b.I(connectionResult);
            return;
        }
        if (i11 == 5) {
            AbstractC1662c abstractC1662c3 = this.f19739b;
            ConnectionResult connectionResult2 = abstractC1662c3.f19803z != null ? abstractC1662c3.f19803z : new ConnectionResult(8);
            this.f19739b.f19793p.a(connectionResult2);
            this.f19739b.I(connectionResult2);
            return;
        }
        if (i11 == 3) {
            Object obj = message.obj;
            ConnectionResult connectionResult3 = new ConnectionResult(message.arg2, obj instanceof PendingIntent ? (PendingIntent) obj : null);
            this.f19739b.f19793p.a(connectionResult3);
            this.f19739b.I(connectionResult3);
            return;
        }
        if (i11 == 6) {
            this.f19739b.e0(5, null);
            AbstractC1662c abstractC1662c4 = this.f19739b;
            if (abstractC1662c4.f19798u != null) {
                abstractC1662c4.f19798u.onConnectionSuspended(message.arg2);
            }
            this.f19739b.J(message.arg2);
            AbstractC1662c.c0(this.f19739b, 5, 1, null);
            return;
        }
        if (i11 == 2 && !this.f19739b.j()) {
            a(message);
            return;
        }
        if (b(message)) {
            ((K) message.obj).c();
            return;
        }
        Log.wtf("GmsClient", "Don't know how to handle message: " + message.what, new Exception());
    }
}
