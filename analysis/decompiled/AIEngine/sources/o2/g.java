package o2;

import android.content.Context;
import androidx.room.o;
import java.util.LinkedHashSet;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public abstract class g<T> {

    /* renamed from: a, reason: collision with root package name */
    public final s2.c f10721a;

    /* renamed from: b, reason: collision with root package name */
    public final Context f10722b;

    /* renamed from: c, reason: collision with root package name */
    public final Object f10723c;

    /* renamed from: d, reason: collision with root package name */
    public final LinkedHashSet<m2.a<T>> f10724d;

    /* renamed from: e, reason: collision with root package name */
    public T f10725e;

    public g(Context context, s2.c cVar) {
        this.f10721a = cVar;
        Context applicationContext = context.getApplicationContext();
        kotlin.jvm.internal.g.e(applicationContext, "context.applicationContext");
        this.f10722b = applicationContext;
        this.f10723c = new Object();
        this.f10724d = new LinkedHashSet<>();
    }

    public abstract T a();

    public final void b(T t8) {
        synchronized (this.f10723c) {
            T t10 = this.f10725e;
            if (t10 == null || !t10.equals(t8)) {
                this.f10725e = t8;
                this.f10721a.f11881d.execute(new o(16, kotlin.collections.a.O0(this.f10724d), this));
                lb.n nVar = lb.n.f10413a;
            }
        }
    }

    public abstract void c();

    public abstract void d();
}
