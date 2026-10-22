package com.stepos.ability.screenops.internal;

import Ua.C1060i;
import Ua.L0;
import Ua.M;
import Ua.Y;
import W3.EditTextNode;
import W3.SetTextTarget;
import W3.b;
import W3.g;
import X3.a;
import Y8.t;
import Z8.C1173v;
import Z8.C1174w;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ability.IScreenOpsService;
import com.stepos.ability.screenops.internal.ServiceConnector;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import kotlinx.coroutines.d;
import kotlinx.coroutines.g;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001eB\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J!\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u00062\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0004\b\n\u0010\u000bJ\u0019\u0010\u000f\u001a\u00020\u000e2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\u000f\u0010\u0010J+\u0010\u0015\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\u00112\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00028\u00000\u0012H\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u0011\u0010\u0017\u001a\u0004\u0018\u00010\u0013H\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u001a\u001a\u00020\u0019H\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ\u000f\u0010\u001c\u001a\u00020\u0019H\u0002¢\u0006\u0004\b\u001c\u0010\u001bJ\u000f\u0010\u001d\u001a\u00020\u0019H\u0002¢\u0006\u0004\b\u001d\u0010\u001bR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0014\u0010#\u001a\u00020 8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b!\u0010\"R\u0014\u0010%\u001a\u00020 8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b$\u0010\"R\u0018\u0010(\u001a\u0004\u0018\u00010\u00138\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b&\u0010'R\u0018\u0010,\u001a\u0004\u0018\u00010)8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b*\u0010+R\u0016\u00100\u001a\u00020-8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b.\u0010/R\u0014\u00104\u001a\u0002018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b2\u00103R\u0018\u00108\u001a\u0004\u0018\u0001058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b6\u00107R\u0014\u0010;\u001a\u0002098\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010:¨\u0006<"}, d2 = {"Lcom/stepos/ability/screenops/internal/ServiceConnector;", "", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "", "LW3/h;", "targets", "LW3/g;", "o", "(Ljava/util/List;)Ljava/util/List;", "", "packageName", "LW3/b;", "l", "(Ljava/lang/String;)LW3/b;", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlin/Function1;", "Lcom/stepos/ability/IScreenOpsService;", "block", "q", "(Lp9/l;)Ljava/lang/Object;", "k", "()Lcom/stepos/ability/IScreenOpsService;", "LY8/t;", "n", "()V", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, Const.INTENT_KEY_APIKEY, "Landroid/content/Context;", "Ljava/util/concurrent/locks/ReentrantLock;", Const.INTENT_KEY_PKGNAME, "Ljava/util/concurrent/locks/ReentrantLock;", "lock", "c", "connectLock", Const.INTENT_KEY_UMID, "Lcom/stepos/ability/IScreenOpsService;", "service", "Landroid/content/ServiceConnection;", "e", "Landroid/content/ServiceConnection;", "connection", "", "f", "Z", "bound", "LUa/M;", Const.INTENT_KEY_BACKGROUND_COMMAND, "LUa/M;", "scope", "Lkotlinx/coroutines/g;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "Lkotlinx/coroutines/g;", "idleJob", "Landroid/os/IBinder$DeathRecipient;", "Landroid/os/IBinder$DeathRecipient;", "deathRecipient", "sdk_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class ServiceConnector {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final Context context;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final ReentrantLock lock;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public final ReentrantLock connectLock;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public IScreenOpsService service;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    public ServiceConnection connection;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    public boolean bound;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    public final M scope;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    public g idleJob;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    public final IBinder.DeathRecipient deathRecipient;

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\t\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"com/stepos/ability/screenops/internal/ServiceConnector$b", "Landroid/content/ServiceConnection;", "Landroid/content/ComponentName;", "name", "Landroid/os/IBinder;", "binder", "LY8/t;", "onServiceConnected", "(Landroid/content/ComponentName;Landroid/os/IBinder;)V", "onServiceDisconnected", "(Landroid/content/ComponentName;)V", "sdk_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class b implements ServiceConnection {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ CountDownLatch f22082b;

        public b(CountDownLatch countDownLatch) {
            this.f22082b = countDownLatch;
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName name, IBinder binder) {
            p.i(name, "name");
            p.i(binder, "binder");
            ReentrantLock reentrantLock = ServiceConnector.this.lock;
            ServiceConnector serviceConnector = ServiceConnector.this;
            reentrantLock.lock();
            try {
                serviceConnector.service = IScreenOpsService.Stub.asInterface(binder);
                try {
                    binder.linkToDeath(serviceConnector.deathRecipient, 0);
                    t tVar = t.f7040a;
                } catch (Exception e10) {
                    Log.w("ServiceConnector", "linkToDeath failed", e10);
                }
                reentrantLock.unlock();
                this.f22082b.countDown();
            } catch (Throwable th) {
                reentrantLock.unlock();
                throw th;
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName name) {
            p.i(name, "name");
            ReentrantLock reentrantLock = ServiceConnector.this.lock;
            ServiceConnector serviceConnector = ServiceConnector.this;
            reentrantLock.lock();
            try {
                serviceConnector.service = null;
                t tVar = t.f7040a;
            } finally {
                reentrantLock.unlock();
            }
        }
    }

    public ServiceConnector(Context context) {
        p.i(context, "context");
        this.context = context;
        this.lock = new ReentrantLock();
        this.connectLock = new ReentrantLock();
        this.scope = d.a(L0.b(null, 1, null).plus(Y.c()));
        this.deathRecipient = new IBinder.DeathRecipient() { // from class: X3.d
            @Override // android.os.IBinder.DeathRecipient
            public final void binderDied() {
                ServiceConnector.h(this.f6858a);
            }
        };
    }

    public static final void h(ServiceConnector serviceConnector) {
        Log.w("ServiceConnector", "Service binder died, cleaning up");
        ReentrantLock reentrantLock = serviceConnector.lock;
        reentrantLock.lock();
        try {
            serviceConnector.service = null;
            serviceConnector.bound = false;
            serviceConnector.connection = null;
            t tVar = t.f7040a;
        } finally {
            reentrantLock.unlock();
        }
    }

    public static final W3.b m(String str, IScreenOpsService svc) throws RemoteException {
        String string;
        String string2;
        List<EditTextNode> listM;
        p.i(svc, "svc");
        Bundle bundle = new Bundle();
        if (str != null) {
            bundle.putString("packageName", str);
        }
        Bundle editContent = svc.getEditContent(bundle);
        int i10 = editContent != null ? editContent.getInt("code", -1) : -1;
        if (i10 != 0) {
            if (editContent == null || (string = editContent.getString("message")) == null) {
                string = "no response";
            }
            return new b.Failure(i10, string);
        }
        if (editContent == null || (string2 = editContent.getString("extra")) == null) {
            string2 = "";
        }
        if (editContent == null || (listM = a.f6855a.d(editContent)) == null) {
            listM = C1173v.m();
        }
        return new b.Success(listM, string2);
    }

    public static final List p(List list, IScreenOpsService svc) throws RemoteException {
        List<W3.g> listF;
        p.i(svc, "svc");
        a aVar = a.f6855a;
        Bundle editContentBatch = svc.setEditContentBatch(aVar.a(list));
        if (editContentBatch != null && (listF = aVar.f(editContentBatch)) != null) {
            return listF;
        }
        List<SetTextTarget> list2 = list;
        ArrayList arrayList = new ArrayList(C1174w.x(list2, 10));
        for (SetTextTarget setTextTarget : list2) {
            arrayList.add(new g.Failure(-1, "no response"));
        }
        return arrayList;
    }

    public final void i() {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            j();
            t tVar = t.f7040a;
        } finally {
            reentrantLock.unlock();
        }
    }

    public final void j() {
        IBinder iBinderAsBinder;
        IScreenOpsService iScreenOpsService = this.service;
        if (iScreenOpsService != null && (iBinderAsBinder = iScreenOpsService.asBinder()) != null) {
            try {
                iBinderAsBinder.unlinkToDeath(this.deathRecipient, 0);
            } catch (Exception unused) {
                t tVar = t.f7040a;
            }
        }
        this.service = null;
        if (this.bound) {
            try {
                ServiceConnection serviceConnection = this.connection;
                if (serviceConnection != null) {
                    this.context.unbindService(serviceConnection);
                }
            } catch (Exception e10) {
                Log.w("ServiceConnector", "unbindService failed", e10);
            }
            this.bound = false;
            this.connection = null;
        }
        kotlinx.coroutines.g gVar = this.idleJob;
        if (gVar != null) {
            kotlinx.coroutines.g.Y0(gVar, null, 1, null);
        }
        this.idleJob = null;
    }

    public final IScreenOpsService k() {
        boolean zBindService;
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            IScreenOpsService iScreenOpsService = this.service;
            if (iScreenOpsService != null) {
                if (iScreenOpsService.asBinder().isBinderAlive()) {
                    return iScreenOpsService;
                }
                j();
                t tVar = t.f7040a;
            }
            reentrantLock.unlock();
            ReentrantLock reentrantLock2 = this.connectLock;
            reentrantLock2.lock();
            try {
                reentrantLock = this.lock;
                reentrantLock.lock();
                try {
                    IScreenOpsService iScreenOpsService2 = this.service;
                    if (iScreenOpsService2 != null) {
                        if (iScreenOpsService2.asBinder().isBinderAlive()) {
                            return iScreenOpsService2;
                        }
                        t tVar2 = t.f7040a;
                    }
                    reentrantLock.unlock();
                    CountDownLatch countDownLatch = new CountDownLatch(1);
                    b bVar = new b(countDownLatch);
                    Intent intent = new Intent("com.screenops.BIND_SERVICE");
                    intent.setPackage("com.stepos.ability");
                    try {
                        zBindService = this.context.bindService(intent, bVar, 1);
                    } catch (Exception e10) {
                        Log.e("ServiceConnector", "bindService failed", e10);
                        zBindService = false;
                    }
                    IScreenOpsService iScreenOpsService3 = null;
                    if (!zBindService) {
                        Log.e("ServiceConnector", "bindService returned false");
                        return null;
                    }
                    reentrantLock = this.lock;
                    reentrantLock.lock();
                    try {
                        this.connection = bVar;
                        this.bound = true;
                        t tVar3 = t.f7040a;
                        reentrantLock.unlock();
                        if (countDownLatch.await(5000L, TimeUnit.MILLISECONDS)) {
                            n();
                            reentrantLock = this.lock;
                            reentrantLock.lock();
                            try {
                                iScreenOpsService3 = this.service;
                                reentrantLock.unlock();
                            } finally {
                            }
                        } else {
                            Log.e("ServiceConnector", "Bind timeout");
                            i();
                        }
                        return iScreenOpsService3;
                    } finally {
                    }
                } finally {
                }
            } finally {
                reentrantLock2.unlock();
            }
        } finally {
        }
    }

    public final W3.b l(final String packageName) {
        W3.b bVar = (W3.b) q(new InterfaceC5074l() { // from class: X3.b
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return ServiceConnector.m(packageName, (IScreenOpsService) obj);
            }
        });
        return bVar == null ? new b.Failure(-1, "Failed to connect to service") : bVar;
    }

    public final void n() {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            kotlinx.coroutines.g gVar = this.idleJob;
            if (gVar != null) {
                kotlinx.coroutines.g.Y0(gVar, null, 1, null);
            }
            this.idleJob = C1060i.d(this.scope, null, null, new ServiceConnector$resetIdleTimer$1$1(this, null), 3, null);
            t tVar = t.f7040a;
            reentrantLock.unlock();
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    public final List<W3.g> o(final List<SetTextTarget> targets) {
        p.i(targets, "targets");
        List<W3.g> arrayList = (List) q(new InterfaceC5074l() { // from class: X3.c
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return ServiceConnector.p(targets, (IScreenOpsService) obj);
            }
        });
        if (arrayList == null) {
            List<SetTextTarget> list = targets;
            arrayList = new ArrayList<>(C1174w.x(list, 10));
            for (SetTextTarget setTextTarget : list) {
                arrayList.add(new g.Failure(-1, "Failed to connect to service"));
            }
        }
        return arrayList;
    }

    public final <T> T q(InterfaceC5074l<? super IScreenOpsService, ? extends T> block) {
        IScreenOpsService iScreenOpsServiceK = k();
        if (iScreenOpsServiceK == null) {
            return null;
        }
        try {
            T tInvoke = block.invoke(iScreenOpsServiceK);
            n();
            return tInvoke;
        } catch (Exception e10) {
            Log.e("ServiceConnector", "Service call failed", e10);
            i();
            return null;
        }
    }
}
