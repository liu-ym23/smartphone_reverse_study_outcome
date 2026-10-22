package s6;

import android.content.Context;
import android.content.Intent;

/* loaded from: classes.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    public final String f9502a = getClass().getSimpleName();

    public abstract Object a(Context context, Intent intent);

    public abstract String b();

    public abstract void c(Context context, Object obj, q6.c cVar);

    public abstract boolean d(Context context, Object obj, Intent intent);

    public final boolean e(Context context, Intent intent, q6.c cVar) {
        if (!"com.stepos.push.intent.MESSAGE".equals(intent.getAction()) || !b().equals(intent.getStringExtra("method"))) {
            return false;
        }
        Object objA = a(context, intent);
        boolean zD = d(context, objA, intent);
        String str = this.f9502a;
        if (!zD) {
            j6.a.c(str, "invalid push message");
            return false;
        }
        j6.a.b(str, "current Handler message " + objA);
        c(context, objA, cVar);
        j6.a.a(str, "send message end ");
        return true;
    }
}
