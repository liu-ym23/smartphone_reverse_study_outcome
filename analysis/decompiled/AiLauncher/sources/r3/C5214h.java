package r3;

import android.content.Context;
import com.google.android.gms.common.internal.C1669j;
import com.google.mlkit.common.internal.MlKitComponentDiscoveryService;
import h3.C4127c;
import h3.C4130f;
import h3.C4137m;
import java.util.concurrent.Executor;

/* renamed from: r3.h, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public class C5214h {

    /* renamed from: b, reason: collision with root package name */
    public static final Object f38764b = new Object();

    /* renamed from: c, reason: collision with root package name */
    public static C5214h f38765c;

    /* renamed from: a, reason: collision with root package name */
    public C4137m f38766a;

    public static C5214h c() {
        C5214h c5214h;
        synchronized (f38764b) {
            C1669j.o(f38765c != null, "MlKitContext has not been initialized");
            c5214h = (C5214h) C1669j.k(f38765c);
        }
        return c5214h;
    }

    public static C5214h d(Context context) {
        C5214h c5214hE;
        synchronized (f38764b) {
            c5214hE = e(context, D2.k.f2218a);
        }
        return c5214hE;
    }

    public static C5214h e(Context context, Executor executor) {
        C5214h c5214h;
        synchronized (f38764b) {
            C1669j.o(f38765c == null, "MlKitContext is already initialized");
            C5214h c5214h2 = new C5214h();
            f38765c = c5214h2;
            Context contextF = f(context);
            C4137m c4137mC = C4137m.d(executor).b(C4130f.b(contextF, MlKitComponentDiscoveryService.class).a()).a(C4127c.l(contextF, Context.class, new Class[0])).a(C4127c.l(c5214h2, C5214h.class, new Class[0])).c();
            c5214h2.f38766a = c4137mC;
            c4137mC.g(true);
            c5214h = f38765c;
        }
        return c5214h;
    }

    public static Context f(Context context) {
        Context applicationContext = context.getApplicationContext();
        return applicationContext != null ? applicationContext : context;
    }

    public <T> T a(Class<T> cls) {
        C1669j.o(f38765c == this, "MlKitContext has been deleted");
        C1669j.k(this.f38766a);
        return (T) this.f38766a.get(cls);
    }

    public Context b() {
        return (Context) a(Context.class);
    }
}
