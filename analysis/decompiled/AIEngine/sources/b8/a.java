package b8;

import android.content.Context;
import android.content.Intent;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public abstract class a<T> {

    /* renamed from: a, reason: collision with root package name */
    public final String f3128a = getClass().getSimpleName();

    public abstract T a(Context context, Intent intent);

    public abstract String b();

    public abstract void c(Context context, Object obj, n7.b bVar);

    public abstract boolean d(Context context, T t8, Intent intent);

    public final boolean e(Context context, Intent intent, n7.b bVar) {
        if (!"com.stepos.push.intent.MESSAGE".equals(intent.getAction()) || !b().equals(intent.getStringExtra("method"))) {
            return false;
        }
        T tA = a(context, intent);
        boolean zD = d(context, tA, intent);
        String str = this.f3128a;
        if (!zD) {
            s7.a.c(str, "invalid push message");
            return false;
        }
        s7.a.b(str, "current Handler message " + tA);
        c(context, tA, bVar);
        s7.a.a(str, "send message end ");
        return true;
    }
}
