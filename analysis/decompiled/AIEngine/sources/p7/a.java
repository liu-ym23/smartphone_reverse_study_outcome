package p7;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import androidx.room.o;
import x7.b;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    public final String f11457a = getClass().getSimpleName();

    /* renamed from: b, reason: collision with root package name */
    public String f11458b;

    /* renamed from: c, reason: collision with root package name */
    public String f11459c;

    public abstract String a(l.b bVar);

    public abstract l.b b();

    public final boolean c(Context context) {
        if ("StepX".equalsIgnoreCase(Build.BRAND)) {
            b.a.f13758a.execute(new o(17, this, context));
            return true;
        }
        s7.a.c(this.f11457a, "please invoke api on device Build-in StepOS");
        return false;
    }

    public abstract Intent[] d(Context context);

    public abstract String e();

    public abstract boolean f();
}
