package androidx.work;

import android.content.Context;
import com.google.android.gms.common.internal.f;
import java.util.Collections;
import java.util.List;
import n0.b;
import s0.C0844b;
import s0.t;
import t0.C0913H;
import t0.J;

/* loaded from: classes.dex */
public final class WorkManagerInitializer implements b {

    /* renamed from: a, reason: collision with root package name */
    public static final String f4310a = t.f("WrkMgrInitializer");

    @Override // n0.b
    public final Object create(Context context) {
        t.d().a(f4310a, "Initializing WorkManager with default configuration.");
        C0844b c0844b = new C0844b(new f());
        synchronized (C0913H.f15324n) {
            try {
                C0913H c0913h = C0913H.f15322l;
                if (c0913h != null && C0913H.f15323m != null) {
                    throw new IllegalStateException("WorkManager is already initialized.  Did you try to initialize it manually without disabling WorkManagerInitializer? See WorkManager#initialize(Context, Configuration) or the class level Javadoc for more information.");
                }
                if (c0913h == null) {
                    Context applicationContext = context.getApplicationContext();
                    if (C0913H.f15323m == null) {
                        C0913H.f15323m = J.s(applicationContext, c0844b);
                    }
                    C0913H.f15322l = C0913H.f15323m;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return C0913H.e0(context);
    }

    @Override // n0.b
    public final List dependencies() {
        return Collections.emptyList();
    }
}
