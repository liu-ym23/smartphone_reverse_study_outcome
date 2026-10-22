package androidx.work;

import a2.i;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import b5.b;
import com.google.crypto.tink.shaded.protobuf.Reader;
import g5.a;
import g5.j;
import g5.u;
import h5.r;
import h5.t;
import java.lang.invoke.VarHandle;
import java.util.Collections;
import java.util.List;
import kc.e0;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class WorkManagerInitializer implements b {

    /* renamed from: a, reason: collision with root package name */
    public static final String f1659a = u.f("WrkMgrInitializer");

    @Override // b5.b
    public final List a() {
        return Collections.EMPTY_LIST;
    }

    @Override // b5.b
    public final Object b(Context context) {
        u.d().a(f1659a, "Initializing WorkManager with default configuration.");
        a aVar = new a();
        aVar.f4268a = a.a.f(false);
        aVar.f4269b = e0.f7430a;
        aVar.f4270c = a.a.f(true);
        aVar.f4271d = new j();
        aVar.f4272e = j.f4321a;
        aVar.f4273f = j.f4322b;
        i iVar = new i(10);
        iVar.f49f = Handler.createAsync(Looper.getMainLooper());
        VarHandle.storeStoreFence();
        aVar.f4274g = iVar;
        aVar.f4275h = 4;
        aVar.i = Reader.READ_DONE;
        aVar.f4277k = 20;
        aVar.f4276j = 8;
        aVar.f4278l = true;
        aVar.f4279m = new j();
        VarHandle.storeStoreFence();
        context.getClass();
        synchronized (r.f5369m) {
            try {
                r rVar = r.f5367k;
                if (rVar != null && r.f5368l != null) {
                    throw new IllegalStateException("WorkManager is already initialized.  Did you try to initialize it manually without disabling WorkManagerInitializer? See WorkManager#initialize(Context, Configuration) or the class level Javadoc for more information.");
                }
                if (rVar == null) {
                    Context applicationContext = context.getApplicationContext();
                    if (r.f5368l == null) {
                        r.f5368l = t.v(applicationContext, aVar);
                    }
                    r.f5367k = r.f5368l;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return r.b(context);
    }
}
