package e3;

import android.content.ContentProviderClient;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import android.util.ArraySet;
import d3.f;
import d3.i;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class d extends f {

    /* renamed from: j, reason: collision with root package name */
    public static final d f2358j = new d();

    /* renamed from: g, reason: collision with root package name */
    public final int f2359g = 15;

    /* renamed from: h, reason: collision with root package name */
    public final ConcurrentHashMap f2360h = new ConcurrentHashMap();

    /* renamed from: i, reason: collision with root package name */
    public final ConcurrentHashMap f2361i = new ConcurrentHashMap();

    public static a i(Context context) throws RemoteException {
        ContentResolver contentResolver = context.getApplicationContext().getContentResolver();
        if (contentResolver == null) {
            throw new RemoteException("get contentResolver failed");
        }
        ContentProviderClient contentProviderClientAcquireContentProviderClient = contentResolver.acquireContentProviderClient(Uri.parse("content://com.meizu.ai.engine.provider.CapabilityProvider"));
        if (contentProviderClientAcquireContentProviderClient != null) {
            return new a(contentProviderClientAcquireContentProviderClient);
        }
        throw new RemoteException("get capability provider failed");
    }

    @Override // d3.f
    public final IInterface a(IBinder iBinder) {
        int i8 = b3.b.f847a;
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.meizu.aiservice.api.service.IAIEngine");
        if (iInterfaceQueryLocalInterface != null && (iInterfaceQueryLocalInterface instanceof b3.c)) {
            return (b3.c) iInterfaceQueryLocalInterface;
        }
        b3.a aVar = new b3.a();
        aVar.f846a = iBinder;
        return aVar;
    }

    @Override // d3.f
    public final d3.e b(Context context, ServiceConnection serviceConnection) {
        context.startService(d());
        return super.b(context, serviceConnection);
    }

    @Override // d3.f
    public final Intent d() {
        Intent intent = new Intent("com.meizu.aiservice.engine.GET");
        intent.setPackage("com.meizu.superalgorithmservice");
        return intent;
    }

    @Override // d3.f
    public final String e() {
        return "AIEngineClient";
    }

    public final int j(Context context, String str, Bundle bundle) {
        ArraySet arraySet = new ArraySet();
        for (i iVar : this.f2360h.values()) {
            synchronized (iVar.f1808h) {
                try {
                    if (iVar.f1808h.contains(str)) {
                        iVar.f1808h.remove(str);
                        arraySet.add(iVar);
                    }
                } finally {
                }
            }
        }
        Iterator it = arraySet.iterator();
        int i8 = 0;
        while (it.hasNext()) {
            i iVar2 = (i) it.next();
            b3.f fVar = (b3.f) iVar2.f1801a;
            if (fVar != null) {
                iVar2.k(context);
                try {
                    ((b3.d) fVar).a(str, bundle);
                    if (iVar2.f1808h.isEmpty()) {
                        iVar2.h(context);
                    }
                    i8++;
                } catch (RemoteException unused) {
                    if (iVar2.f1808h.isEmpty()) {
                        iVar2.h(context);
                    }
                } catch (Throwable th) {
                    if (iVar2.f1808h.isEmpty()) {
                        iVar2.h(context);
                    }
                    throw th;
                }
            }
        }
        return i8;
    }
}
