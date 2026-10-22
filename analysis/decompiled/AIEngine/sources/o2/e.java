package o2;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public abstract class e<T> extends g<T> {

    /* renamed from: f, reason: collision with root package name */
    public final b6.j f10719f;

    public e(Context context, s2.c cVar) {
        super(context, cVar);
        this.f10719f = new b6.j(this, 2);
    }

    @Override // o2.g
    public final void c() {
        h2.j.d().a(f.f10720a, getClass().getSimpleName().concat(": registering receiver"));
        this.f10722b.registerReceiver(this.f10719f, e());
    }

    @Override // o2.g
    public final void d() {
        h2.j.d().a(f.f10720a, getClass().getSimpleName().concat(": unregistering receiver"));
        this.f10722b.unregisterReceiver(this.f10719f);
    }

    public abstract IntentFilter e();

    public abstract void f(Intent intent);
}
