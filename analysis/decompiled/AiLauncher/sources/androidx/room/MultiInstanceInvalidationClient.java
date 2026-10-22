package androidx.room;

import Ua.C1060i;
import Ua.M;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import androidx.exifinterface.media.ExifInterface;
import androidx.room.IMultiInstanceInvalidationCallback;
import androidx.room.IMultiInstanceInvalidationService;
import androidx.room.InvalidationTracker;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlinx.coroutines.channels.BufferOverflow;

@Metadata(d1 = {"\u0000{\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\"\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003*\u00017\b\u0000\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u0015\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\r\u0010\u000eJ\r\u0010\u000f\u001a\u00020\f¢\u0006\u0004\b\u000f\u0010\u0010J)\u0010\u0015\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00140\u00132\u000e\u0010\u0012\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00040\u0011¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0017\u001a\u00020\fH\u0002¢\u0006\u0004\b\u0017\u0010\u0010R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u0017\u0010\u0007\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u001c\u0010#\u001a\n  *\u0004\u0018\u00010\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b!\u0010\"R\u0014\u0010'\u001a\u00020$8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b%\u0010&R\u0014\u0010+\u001a\u00020(8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b)\u0010*R\u0016\u0010/\u001a\u00020,8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b-\u0010.R\u0018\u00103\u001a\u0004\u0018\u0001008\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b1\u00102R \u00106\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u0014048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u00105R\u0014\u00109\u001a\u0002078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001e\u00108R\u0014\u0010<\u001a\u00020:8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010;R\u0014\u0010?\u001a\u00020=8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010>¨\u0006@"}, d2 = {"Landroidx/room/MultiInstanceInvalidationClient;", "", "Landroid/content/Context;", "context", "", "name", "Landroidx/room/InvalidationTracker;", "invalidationTracker", "<init>", "(Landroid/content/Context;Ljava/lang/String;Landroidx/room/InvalidationTracker;)V", "Landroid/content/Intent;", "serviceIntent", "LY8/t;", "k", "(Landroid/content/Intent;)V", "l", "()V", "", "resolvedTableNames", "LXa/b;", "", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "([Ljava/lang/String;)LXa/b;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, Const.INTENT_KEY_APIKEY, "Ljava/lang/String;", "getName", "()Ljava/lang/String;", Const.INTENT_KEY_PKGNAME, "Landroidx/room/InvalidationTracker;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "()Landroidx/room/InvalidationTracker;", "kotlin.jvm.PlatformType", "c", "Landroid/content/Context;", "appContext", "LUa/M;", Const.INTENT_KEY_UMID, "LUa/M;", "coroutineScope", "Ljava/util/concurrent/atomic/AtomicBoolean;", "e", "Ljava/util/concurrent/atomic/AtomicBoolean;", "stopped", "", "f", "I", "clientId", "Landroidx/room/IMultiInstanceInvalidationService;", Const.INTENT_KEY_BACKGROUND_COMMAND, "Landroidx/room/IMultiInstanceInvalidationService;", "invalidationService", "LXa/j;", "LXa/j;", "invalidatedTables", "androidx/room/MultiInstanceInvalidationClient$a", "Landroidx/room/MultiInstanceInvalidationClient$a;", "observer", "Landroidx/room/IMultiInstanceInvalidationCallback;", "Landroidx/room/IMultiInstanceInvalidationCallback;", "invalidationCallback", "Landroid/content/ServiceConnection;", "Landroid/content/ServiceConnection;", "serviceConnection", "room-runtime"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes.dex */
public final class MultiInstanceInvalidationClient {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final String name;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final InvalidationTracker invalidationTracker;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public final Context appContext;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public final M coroutineScope;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    public final AtomicBoolean stopped;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    public int clientId;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    public IMultiInstanceInvalidationService invalidationService;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    public final Xa.j<Set<String>> invalidatedTables;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    public final a observer;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    public final IMultiInstanceInvalidationCallback invalidationCallback;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    public final ServiceConnection serviceConnection;

    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001d\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\u000b\u001a\u00020\b8PX\u0090\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\n¨\u0006\f"}, d2 = {"androidx/room/MultiInstanceInvalidationClient$a", "Landroidx/room/InvalidationTracker$b;", "", "", "tables", "LY8/t;", "c", "(Ljava/util/Set;)V", "", Const.INTENT_KEY_PKGNAME, "()Z", "isRemote", "room-runtime"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class a extends InvalidationTracker.b {
        public a(String[] strArr) {
            super(strArr);
        }

        @Override // androidx.room.InvalidationTracker.b
        public boolean b() {
            return true;
        }

        @Override // androidx.room.InvalidationTracker.b
        public void c(Set<String> tables) {
            kotlin.jvm.internal.p.i(tables, "tables");
            if (MultiInstanceInvalidationClient.this.stopped.get()) {
                return;
            }
            try {
                IMultiInstanceInvalidationService iMultiInstanceInvalidationService = MultiInstanceInvalidationClient.this.invalidationService;
                if (iMultiInstanceInvalidationService != null) {
                    iMultiInstanceInvalidationService.broadcastInvalidation(MultiInstanceInvalidationClient.this.clientId, (String[]) tables.toArray(new String[0]));
                }
            } catch (RemoteException e10) {
                Log.w("ROOM", "Cannot broadcast invalidation", e10);
            }
        }
    }

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\t\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"androidx/room/MultiInstanceInvalidationClient$b", "Landroid/content/ServiceConnection;", "Landroid/content/ComponentName;", "name", "Landroid/os/IBinder;", "service", "LY8/t;", "onServiceConnected", "(Landroid/content/ComponentName;Landroid/os/IBinder;)V", "onServiceDisconnected", "(Landroid/content/ComponentName;)V", "room-runtime"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class b implements ServiceConnection {
        public b() {
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName name, IBinder service) {
            kotlin.jvm.internal.p.i(name, "name");
            kotlin.jvm.internal.p.i(service, "service");
            MultiInstanceInvalidationClient.this.invalidationService = IMultiInstanceInvalidationService.Stub.asInterface(service);
            MultiInstanceInvalidationClient.this.j();
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName name) {
            kotlin.jvm.internal.p.i(name, "name");
            MultiInstanceInvalidationClient.this.invalidationService = null;
        }
    }

    public MultiInstanceInvalidationClient(Context context, String name, InvalidationTracker invalidationTracker) {
        kotlin.jvm.internal.p.i(context, "context");
        kotlin.jvm.internal.p.i(name, "name");
        kotlin.jvm.internal.p.i(invalidationTracker, "invalidationTracker");
        this.name = name;
        this.invalidationTracker = invalidationTracker;
        this.appContext = context.getApplicationContext();
        this.coroutineScope = invalidationTracker.getDatabase().s();
        this.stopped = new AtomicBoolean(true);
        this.invalidatedTables = Xa.p.a(0, 0, BufferOverflow.SUSPEND);
        this.observer = new a(invalidationTracker.getTableNames());
        this.invalidationCallback = new IMultiInstanceInvalidationCallback.Stub() { // from class: androidx.room.MultiInstanceInvalidationClient$invalidationCallback$1
            @Override // androidx.room.IMultiInstanceInvalidationCallback
            public void onInvalidation(String[] tables) {
                kotlin.jvm.internal.p.i(tables, "tables");
                C1060i.d(this.this$0.coroutineScope, null, null, new MultiInstanceInvalidationClient$invalidationCallback$1$onInvalidation$1(tables, this.this$0, null), 3, null);
            }
        };
        this.serviceConnection = new b();
    }

    public final Xa.b<Set<String>> h(final String[] resolvedTableNames) {
        kotlin.jvm.internal.p.i(resolvedTableNames, "resolvedTableNames");
        final Xa.j<Set<String>> jVar = this.invalidatedTables;
        return new Xa.b<Set<? extends String>>() { // from class: androidx.room.MultiInstanceInvalidationClient$createFlow$$inlined$mapNotNull$1

            @Metadata(d1 = {"\u0000\f\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u00012\u0006\u0010\u0002\u001a\u00028\u0000H\u008a@¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "R", UxipConstants.f30680s, "LY8/t;", "emit", "(Ljava/lang/Object;Le9/c;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {2, 1, 0})
            /* renamed from: androidx.room.MultiInstanceInvalidationClient$createFlow$$inlined$mapNotNull$1$2, reason: invalid class name */
            public static final class AnonymousClass2<T> implements Xa.c {

                /* renamed from: a, reason: collision with root package name */
                public final /* synthetic */ Xa.c f14477a;

                /* renamed from: b, reason: collision with root package name */
                public final /* synthetic */ String[] f14478b;

                @InterfaceC4112d(c = "androidx.room.MultiInstanceInvalidationClient$createFlow$$inlined$mapNotNull$1$2", f = "MultiInstanceInvalidationClient.android.kt", l = {235}, m = "emit")
                @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
                /* renamed from: androidx.room.MultiInstanceInvalidationClient$createFlow$$inlined$mapNotNull$1$2$1, reason: invalid class name */
                public static final class AnonymousClass1 extends ContinuationImpl {

                    /* renamed from: a, reason: collision with root package name */
                    public /* synthetic */ Object f14479a;

                    /* renamed from: b, reason: collision with root package name */
                    public int f14480b;

                    public AnonymousClass1(InterfaceC4014c interfaceC4014c) {
                        super(interfaceC4014c);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object obj) {
                        this.f14479a = obj;
                        this.f14480b |= Integer.MIN_VALUE;
                        return AnonymousClass2.this.emit(null, this);
                    }
                }

                public AnonymousClass2(Xa.c cVar, String[] strArr) {
                    this.f14477a = cVar;
                    this.f14478b = strArr;
                }

                /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
                @Override // Xa.c
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct add '--show-bad-code' argument
                */
                public final java.lang.Object emit(java.lang.Object r10, e9.InterfaceC4014c r11) throws java.lang.Throwable {
                    /*
                        r9 = this;
                        boolean r0 = r11 instanceof androidx.room.MultiInstanceInvalidationClient$createFlow$$inlined$mapNotNull$1.AnonymousClass2.AnonymousClass1
                        if (r0 == 0) goto L13
                        r0 = r11
                        androidx.room.MultiInstanceInvalidationClient$createFlow$$inlined$mapNotNull$1$2$1 r0 = (androidx.room.MultiInstanceInvalidationClient$createFlow$$inlined$mapNotNull$1.AnonymousClass2.AnonymousClass1) r0
                        int r1 = r0.f14480b
                        r2 = -2147483648(0xffffffff80000000, float:-0.0)
                        r3 = r1 & r2
                        if (r3 == 0) goto L13
                        int r1 = r1 - r2
                        r0.f14480b = r1
                        goto L18
                    L13:
                        androidx.room.MultiInstanceInvalidationClient$createFlow$$inlined$mapNotNull$1$2$1 r0 = new androidx.room.MultiInstanceInvalidationClient$createFlow$$inlined$mapNotNull$1$2$1
                        r0.<init>(r11)
                    L18:
                        java.lang.Object r11 = r0.f14479a
                        java.lang.Object r1 = f9.C4063a.g()
                        int r2 = r0.f14480b
                        r3 = 1
                        if (r2 == 0) goto L31
                        if (r2 != r3) goto L29
                        kotlin.C4849c.b(r11)
                        goto L7c
                    L29:
                        java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
                        java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
                        r9.<init>(r10)
                        throw r9
                    L31:
                        kotlin.C4849c.b(r11)
                        Xa.c r11 = r9.f14477a
                        java.util.Set r10 = (java.util.Set) r10
                        java.util.Set r2 = Z8.X.b()
                        java.lang.String[] r9 = r9.f14478b
                        int r4 = r9.length
                        r5 = 0
                    L40:
                        if (r5 >= r4) goto L64
                        r6 = r9[r5]
                        r7 = r10
                        java.lang.Iterable r7 = (java.lang.Iterable) r7
                        java.util.Iterator r7 = r7.iterator()
                    L4b:
                        boolean r8 = r7.hasNext()
                        if (r8 == 0) goto L61
                        java.lang.Object r8 = r7.next()
                        java.lang.String r8 = (java.lang.String) r8
                        boolean r8 = La.D.L(r6, r8, r3)
                        if (r8 == 0) goto L4b
                        r2.add(r6)
                        goto L4b
                    L61:
                        int r5 = r5 + 1
                        goto L40
                    L64:
                        java.util.Set r9 = Z8.X.a(r2)
                        java.util.Collection r9 = (java.util.Collection) r9
                        boolean r10 = r9.isEmpty()
                        if (r10 == 0) goto L71
                        r9 = 0
                    L71:
                        if (r9 == 0) goto L7c
                        r0.f14480b = r3
                        java.lang.Object r9 = r11.emit(r9, r0)
                        if (r9 != r1) goto L7c
                        return r1
                    L7c:
                        Y8.t r9 = Y8.t.f7040a
                        return r9
                    */
                    throw new UnsupportedOperationException("Method not decompiled: androidx.room.MultiInstanceInvalidationClient$createFlow$$inlined$mapNotNull$1.AnonymousClass2.emit(java.lang.Object, e9.c):java.lang.Object");
                }
            }

            @Override // Xa.b
            public Object collect(Xa.c<? super Set<? extends String>> cVar, InterfaceC4014c interfaceC4014c) {
                Object objCollect = jVar.collect(new AnonymousClass2(cVar, resolvedTableNames), interfaceC4014c);
                return objCollect == C4063a.g() ? objCollect : Y8.t.f7040a;
            }
        };
    }

    /* renamed from: i, reason: from getter */
    public final InvalidationTracker getInvalidationTracker() {
        return this.invalidationTracker;
    }

    public final void j() {
        try {
            IMultiInstanceInvalidationService iMultiInstanceInvalidationService = this.invalidationService;
            if (iMultiInstanceInvalidationService != null) {
                this.clientId = iMultiInstanceInvalidationService.registerCallback(this.invalidationCallback, this.name);
            }
        } catch (RemoteException e10) {
            Log.w("ROOM", "Cannot register multi-instance invalidation callback", e10);
        }
    }

    public final void k(Intent serviceIntent) {
        kotlin.jvm.internal.p.i(serviceIntent, "serviceIntent");
        if (this.stopped.compareAndSet(true, false)) {
            this.appContext.bindService(serviceIntent, this.serviceConnection, 1);
            this.invalidationTracker.i(this.observer);
        }
    }

    public final void l() {
        if (this.stopped.compareAndSet(false, true)) {
            this.invalidationTracker.w(this.observer);
            try {
                IMultiInstanceInvalidationService iMultiInstanceInvalidationService = this.invalidationService;
                if (iMultiInstanceInvalidationService != null) {
                    iMultiInstanceInvalidationService.unregisterCallback(this.invalidationCallback, this.clientId);
                }
            } catch (RemoteException e10) {
                Log.w("ROOM", "Cannot unregister multi-instance invalidation callback", e10);
            }
            this.appContext.unbindService(this.serviceConnection);
        }
    }
}
