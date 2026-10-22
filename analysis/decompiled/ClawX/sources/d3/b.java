package d3;

import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Process;
import android.os.RemoteException;
import android.util.Log;
import d3.i;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.function.Function;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class b implements g {

    /* renamed from: a, reason: collision with root package name */
    public final String f1793a;

    /* renamed from: b, reason: collision with root package name */
    public final Function f1794b;

    /* renamed from: c, reason: collision with root package name */
    public IInterface f1795c;
    public final Object d = new Object();

    /* renamed from: e, reason: collision with root package name */
    public final ArrayList f1796e;

    public b(String str, Function function) {
        new HashSet();
        this.f1796e = new ArrayList();
        this.f1794b = function;
        this.f1793a = str;
        e3.e.f2362a.put(str, this);
    }

    @Override // d3.g
    public final boolean a() {
        boolean z;
        synchronized (this.f1796e) {
            this.f1796e.removeIf(new a(1));
            z = !this.f1796e.isEmpty();
        }
        return z;
    }

    @Override // d3.g
    public final boolean b() {
        boolean z;
        synchronized (this.f1796e) {
            this.f1796e.removeIf(new a(0));
            z = !this.f1796e.isEmpty();
        }
        return z;
    }

    public final i c(final Context context, Bundle bundle) throws RemoteException {
        i iVar;
        final e3.d dVar = e3.d.f2358j;
        String str = this.f1793a;
        synchronized (dVar) {
            iVar = (i) dVar.f2360h.get(str);
            if (iVar == null) {
                try {
                    e3.a aVarI = e3.d.i(context);
                    try {
                        System.currentTimeMillis();
                        Bundle bundleCall = aVarI.f2353a.call("getWorkerProcess", str, bundle);
                        String string = bundleCall == null ? null : bundleCall.getString("string");
                        Log.d("AIEngineClient", "worker process: " + str + "/" + string);
                        if (string == null || string.isEmpty()) {
                            throw new RemoteException("getWorkerProcess failed");
                        }
                        i iVar2 = (i) dVar.f2361i.computeIfAbsent(string, new Function() { // from class: e3.b
                            @Override // java.util.function.Function
                            public final Object apply(Object obj) {
                                d dVar2 = dVar;
                                Context context2 = context;
                                dVar2.getClass();
                                i iVar3 = new i((String) obj);
                                c cVar = new c(iVar3, context2);
                                synchronized (iVar3.d) {
                                    try {
                                        if (iVar3.d.contains(cVar)) {
                                            return iVar3;
                                        }
                                        iVar3.d.add(cVar);
                                        return iVar3;
                                    } catch (Throwable th) {
                                        throw th;
                                    }
                                }
                            }
                        });
                        dVar.f2360h.put(str, iVar2);
                        aVarI.close();
                        iVar = iVar2;
                    } catch (Throwable th) {
                        try {
                            aVarI.close();
                        } catch (Throwable th2) {
                            th.addSuppressed(th2);
                        }
                        throw th;
                    }
                } catch (Exception e9) {
                    throw new RemoteException(e9.getMessage());
                }
            } else if (iVar.f1801a != null && !iVar.f()) {
                Log.i("AIEngineClient", "worker disconnected, release client");
                iVar.h(context);
            }
        }
        if (iVar != null) {
            return iVar;
        }
        throw new RemoteException("getWorkerClient failed");
    }

    public final IInterface d(Context context, Bundle bundle) {
        IInterface iInterface;
        boolean z;
        IInterface iInterface2 = this.f1795c;
        if (iInterface2 != null) {
            synchronized (this.d) {
                try {
                    IInterface iInterface3 = this.f1795c;
                    z = iInterface3 != null && iInterface3.asBinder().isBinderAlive() && this.f1795c.asBinder().pingBinder();
                } catch (Throwable th) {
                    throw th;
                }
            }
            if (z) {
                try {
                    c(context, bundle).i(context, this.f1793a);
                    return iInterface2;
                } catch (Exception e9) {
                    Log.w("AlgorithmClient", "cancelDelayRelease error: " + e9.getMessage());
                    return iInterface2;
                }
            }
        }
        try {
            IBinder iBinderL = c(context, bundle).l(context, this.f1793a, bundle);
            synchronized (this.d) {
                iInterface = (IInterface) this.f1794b.apply(iBinderL);
                this.f1795c = iInterface;
            }
            return iInterface;
        } catch (Exception e10) {
            Log.e("AlgorithmClient", "loadAlgorithm error: " + e10.getMessage());
            return null;
        }
    }

    public final void e(Context context) {
        if (this.f1795c == null) {
            return;
        }
        try {
            e3.d dVar = e3.d.f2358j;
            new Bundle().putInt("release_type", 1);
            Bundle bundle = new Bundle();
            bundle.putInt("release_type", 0);
            String str = this.f1793a;
            bundle.putInt("uid", Process.myUid());
            bundle.putInt("pid", Process.myPid());
            Log.d("AlgorithmClient", "releaseAlgorithm released: " + dVar.j(context, str, bundle));
        } catch (Exception unused) {
        }
        synchronized (this.d) {
            this.f1795c = null;
        }
    }
}
