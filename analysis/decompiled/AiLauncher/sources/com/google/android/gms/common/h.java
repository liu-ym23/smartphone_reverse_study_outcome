package com.google.android.gms.common;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.os.Looper;
import android.os.Message;
import android.util.Log;

@SuppressLint({"HandlerLeak"})
/* loaded from: classes2.dex */
public final class h extends w2.i {

    /* renamed from: b, reason: collision with root package name */
    public final Context f19722b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ b f19723c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(b bVar, Context context) {
        super(Looper.myLooper() == null ? Looper.getMainLooper() : Looper.myLooper());
        this.f19723c = bVar;
        this.f19722b = context.getApplicationContext();
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) throws Resources.NotFoundException {
        int i10 = message.what;
        if (i10 != 1) {
            Log.w("GoogleApiAvailability", "Don't know how to handle this message: " + i10);
            return;
        }
        b bVar = this.f19723c;
        int iG = bVar.g(this.f19722b);
        if (bVar.j(iG)) {
            this.f19723c.o(this.f19722b, iG);
        }
    }
}
