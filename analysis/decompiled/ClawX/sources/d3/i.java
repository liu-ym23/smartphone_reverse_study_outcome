package d3;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Process;
import android.os.RemoteException;
import android.util.ArraySet;
import android.util.Log;
import java.util.Iterator;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class i extends f {

    /* renamed from: g, reason: collision with root package name */
    public final String f1807g;

    /* renamed from: h, reason: collision with root package name */
    public final ArraySet f1808h = new ArraySet();

    public i(String str) {
        this.f1807g = str;
    }

    @Override // d3.f
    public final IInterface a(IBinder iBinder) {
        int i8 = b3.e.f849a;
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.meizu.aiservice.api.service.IAlgorithmWorker");
        if (iInterfaceQueryLocalInterface != null && (iInterfaceQueryLocalInterface instanceof b3.f)) {
            return (b3.f) iInterfaceQueryLocalInterface;
        }
        b3.d dVar = new b3.d();
        dVar.f848a = iBinder;
        return dVar;
    }

    @Override // d3.f
    public final Intent d() {
        String str = this.f1807g;
        Intent intent = new Intent(m0.f.c("com.meizu.aiservice.engine.worker.BIND:", str));
        intent.putExtra("process.type", str);
        e3.d dVar = e3.d.f2358j;
        intent.setPackage("com.meizu.superalgorithmservice");
        return intent;
    }

    @Override // d3.f
    public final String e() {
        return "LocalWorkerClient";
    }

    @Override // d3.f
    public final void g(Context context, IInterface iInterface) {
        h hVar = new h(context);
        b3.d dVar = (b3.d) ((b3.f) iInterface);
        dVar.getClass();
        Parcel parcelObtain = Parcel.obtain();
        Parcel parcelObtain2 = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken("com.meizu.aiservice.api.service.IAlgorithmWorker");
            parcelObtain.writeStrongInterface(hVar);
            dVar.f848a.transact(11, parcelObtain, parcelObtain2, 0);
            parcelObtain2.readException();
        } finally {
            parcelObtain2.recycle();
            parcelObtain.recycle();
        }
    }

    public final void i(Context context, String str) throws RemoteException {
        b3.f fVarK = k(context);
        if (fVarK == null) {
            throw new RemoteException("fetch remote failed");
        }
        b3.d dVar = (b3.d) fVarK;
        Parcel parcelObtain = Parcel.obtain();
        Parcel parcelObtain2 = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken("com.meizu.aiservice.api.service.IAlgorithmWorker");
            parcelObtain.writeString(str);
            dVar.f848a.transact(8, parcelObtain, parcelObtain2, 0);
            parcelObtain2.readException();
            parcelObtain2.readInt();
        } finally {
            parcelObtain2.recycle();
            parcelObtain.recycle();
        }
    }

    public final void j(Context context) {
        b3.f fVar = (b3.f) this.f1801a;
        if (fVar != null && ((b3.d) fVar).f848a.isBinderAlive()) {
            try {
                int iMyUid = Process.myUid();
                int iMyPid = Process.myPid();
                b3.d dVar = (b3.d) fVar;
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.meizu.aiservice.api.service.IAlgorithmWorker");
                    parcelObtain.writeInt(iMyUid);
                    parcelObtain.writeInt(iMyPid);
                    dVar.f848a.transact(12, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                } catch (Throwable th) {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    throw th;
                }
            } catch (RemoteException unused) {
                Log.e("LocalWorkerClient", "removeClientUser failed");
            }
        }
        synchronized (this.f1808h) {
            try {
                Iterator it = this.f1808h.iterator();
                while (it.hasNext()) {
                    e3.d.f2358j.f2360h.remove((String) it.next());
                }
                this.f1808h.clear();
            } catch (Throwable th2) {
                throw th2;
            }
        }
        try {
            context.unbindService(this.f1805f);
        } catch (Exception unused2) {
        }
    }

    public final synchronized b3.f k(Context context) {
        return (b3.f) c(context, 15);
    }

    public final IBinder l(Context context, String str, Bundle bundle) throws RemoteException {
        b3.f fVarK = k(context);
        if (fVarK == null) {
            throw new RemoteException("fetch remote failed");
        }
        b3.d dVar = (b3.d) fVarK;
        Parcel parcelObtain = Parcel.obtain();
        Parcel parcelObtain2 = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken("com.meizu.aiservice.api.service.IAlgorithmWorker");
            parcelObtain.writeString(str);
            parcelObtain.writeInt(1);
            bundle.writeToParcel(parcelObtain, 0);
            dVar.f848a.transact(3, parcelObtain, parcelObtain2, 0);
            parcelObtain2.readException();
            IBinder strongBinder = parcelObtain2.readStrongBinder();
            if (strongBinder == null) {
                throw new RemoteException("loadAlgorithmWith null");
            }
            synchronized (this.f1808h) {
                this.f1808h.add(str);
            }
            return strongBinder;
        } finally {
            parcelObtain2.recycle();
            parcelObtain.recycle();
        }
    }

    public final String toString() {
        return "LocalWorkerClient{type='" + this.f1807g + "', fetchedAlgorithms=" + this.f1808h + ", connected=" + f() + ", client=" + this.f1801a + AbstractJsonLexerKt.END_OBJ;
    }
}
