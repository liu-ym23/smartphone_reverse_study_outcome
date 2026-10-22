package com.google.android.gms.common;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import g1.HandlerC0575c;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes.dex */
public final class h extends HandlerC0575c {

    /* renamed from: b, reason: collision with root package name */
    public final Context f9722b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ b f9723c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(b bVar, Context context) {
        super(Looper.myLooper() == null ? Looper.getMainLooper() : Looper.myLooper(), 0);
        this.f9723c = bVar;
        this.f9722b = context.getApplicationContext();
    }

    @Override // g1.HandlerC0575c, android.os.Handler
    public final void handleMessage(Message message) throws Resources.NotFoundException {
        int i4 = message.what;
        if (i4 != 1) {
            Log.w("GoogleApiAvailability", "Don't know how to handle this message: " + i4);
            return;
        }
        int i5 = c.f9702a;
        b bVar = this.f9723c;
        Context context = this.f9722b;
        int iB = bVar.b(i5, context);
        AtomicBoolean atomicBoolean = e.f9716a;
        if (iB == 1 || iB == 2 || iB == 3 || iB == 9) {
            Intent intentA = bVar.a(context, "n", iB);
            bVar.f(context, iB, intentA == null ? null : PendingIntent.getActivity(context, 0, intentA, 201326592));
        }
    }
}
