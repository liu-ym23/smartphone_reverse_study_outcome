package k2;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.google.android.datatransport.runtime.backends.BackendResponse;
import com.google.android.datatransport.runtime.synchronization.SynchronizationException;
import f2.AbstractC4050e;
import f2.InterfaceC4049d;
import h2.C4124a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.Executor;
import l2.AbstractC4869i;
import l2.InterfaceC4863c;
import m2.InterfaceC4893a;
import n2.InterfaceC4936a;

/* loaded from: classes2.dex */
public class i {

    /* renamed from: a, reason: collision with root package name */
    public final Context f34610a;

    /* renamed from: b, reason: collision with root package name */
    public final InterfaceC4049d f34611b;

    /* renamed from: c, reason: collision with root package name */
    public final InterfaceC4863c f34612c;

    /* renamed from: d, reason: collision with root package name */
    public final o f34613d;

    /* renamed from: e, reason: collision with root package name */
    public final Executor f34614e;

    /* renamed from: f, reason: collision with root package name */
    public final InterfaceC4893a f34615f;

    /* renamed from: g, reason: collision with root package name */
    public final InterfaceC4936a f34616g;

    public i(Context context, InterfaceC4049d interfaceC4049d, InterfaceC4863c interfaceC4863c, o oVar, Executor executor, InterfaceC4893a interfaceC4893a, InterfaceC4936a interfaceC4936a) {
        this.f34610a = context;
        this.f34611b = interfaceC4049d;
        this.f34612c = interfaceC4863c;
        this.f34613d = oVar;
        this.f34614e = executor;
        this.f34615f = interfaceC4893a;
        this.f34616g = interfaceC4936a;
    }

    public static /* synthetic */ Object c(i iVar, BackendResponse backendResponse, Iterable iterable, e2.m mVar, int i10) {
        if (backendResponse.c() == BackendResponse.Status.TRANSIENT_ERROR) {
            iVar.f34612c.r0(iterable);
            iVar.f34613d.a(mVar, i10 + 1);
            return null;
        }
        iVar.f34612c.r(iterable);
        if (backendResponse.c() == BackendResponse.Status.OK) {
            iVar.f34612c.d0(mVar, iVar.f34616g.a() + backendResponse.b());
        }
        if (!iVar.f34612c.C0(mVar)) {
            return null;
        }
        iVar.f34613d.b(mVar, 1, true);
        return null;
    }

    public static /* synthetic */ Object d(i iVar, e2.m mVar, int i10) {
        iVar.f34613d.a(mVar, i10 + 1);
        return null;
    }

    public static /* synthetic */ void e(i iVar, e2.m mVar, int i10, Runnable runnable) {
        try {
            try {
                InterfaceC4893a interfaceC4893a = iVar.f34615f;
                InterfaceC4863c interfaceC4863c = iVar.f34612c;
                interfaceC4863c.getClass();
                interfaceC4893a.b(g.a(interfaceC4863c));
                if (iVar.a()) {
                    iVar.f(mVar, i10);
                } else {
                    iVar.f34615f.b(h.a(iVar, mVar, i10));
                }
                runnable.run();
            } catch (SynchronizationException unused) {
                iVar.f34613d.a(mVar, i10 + 1);
                runnable.run();
            }
        } catch (Throwable th) {
            runnable.run();
            throw th;
        }
    }

    public boolean a() {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) this.f34610a.getSystemService("connectivity")).getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    public void f(e2.m mVar, int i10) {
        BackendResponse backendResponseA;
        f2.k kVar = this.f34611b.get(mVar.b());
        Iterable iterable = (Iterable) this.f34615f.b(e.a(this, mVar));
        if (iterable.iterator().hasNext()) {
            if (kVar == null) {
                C4124a.a("Uploader", "Unknown backend for %s, deleting event batch for it...", mVar);
                backendResponseA = BackendResponse.a();
            } else {
                ArrayList arrayList = new ArrayList();
                Iterator it = iterable.iterator();
                while (it.hasNext()) {
                    arrayList.add(((AbstractC4869i) it.next()).b());
                }
                backendResponseA = kVar.a(AbstractC4050e.a().b(arrayList).c(mVar.c()).a());
            }
            this.f34615f.b(f.a(this, backendResponseA, iterable, mVar, i10));
        }
    }

    public void g(e2.m mVar, int i10, Runnable runnable) {
        this.f34614e.execute(d.a(this, mVar, i10, runnable));
    }
}
