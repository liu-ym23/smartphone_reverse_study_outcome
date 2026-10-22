package androidx.room;

import android.content.Context;
import android.content.Intent;
import androidx.exifinterface.media.ExifInterface;
import androidx.room.coroutines.RunBlockingUninterruptible_androidKt;
import androidx.room.support.AutoCloser;
import com.autonavi.aps.amapapi.config.Const;
import e9.InterfaceC4014c;
import f9.C4063a;
import i1.InterfaceC4160b;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Metadata;
import kotlin.Pair;
import p9.InterfaceC5063a;

@Metadata(d1 = {"\u0000¬\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\"\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0016\u0018\u0000 #2\u00020\u0001:\u0002?;BS\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0018\u0010\b\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00070\u0004\u0012\u0012\u0010\n\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00050\t\"\u00020\u0005¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0015\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u0015\u0010\u0014J\u0015\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00100\u0016H\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\u001d\u0010\u001b\u001a\u00020\r2\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00190\u0007H\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ\u0017\u0010\u001f\u001a\u00020\r2\u0006\u0010\u001e\u001a\u00020\u001dH\u0000¢\u0006\u0004\b\u001f\u0010 J\u0017\u0010#\u001a\u00020\r2\u0006\u0010\"\u001a\u00020!H\u0000¢\u0006\u0004\b#\u0010$J\u0010\u0010%\u001a\u00020\rH\u0080@¢\u0006\u0004\b%\u0010&J\u000f\u0010'\u001a\u00020\rH\u0001¢\u0006\u0004\b'\u0010\u000fJ\r\u0010(\u001a\u00020\r¢\u0006\u0004\b(\u0010\u000fJ9\u0010,\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00070+2\u0012\u0010)\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00050\t\"\u00020\u00052\b\b\u0002\u0010*\u001a\u00020\u0012H\u0007¢\u0006\u0004\b,\u0010-J\u0017\u0010.\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u0010H\u0000¢\u0006\u0004\b.\u0010/J\u0017\u00100\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u0010H\u0017¢\u0006\u0004\b0\u0010/J\u000f\u00101\u001a\u00020\rH\u0016¢\u0006\u0004\b1\u0010\u000fJ\u001d\u00102\u001a\u00020\r2\f\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00050\u0007H\u0000¢\u0006\u0004\b2\u0010\u001cJ'\u00108\u001a\u00020\r2\u0006\u00104\u001a\u0002032\u0006\u00105\u001a\u00020\u00052\u0006\u00107\u001a\u000206H\u0000¢\u0006\u0004\b8\u00109J\u000f\u0010:\u001a\u00020\rH\u0000¢\u0006\u0004\b:\u0010\u000fR\u001a\u0010\u0003\u001a\u00020\u00028\u0000X\u0080\u0004¢\u0006\f\n\u0004\b;\u0010<\u001a\u0004\b=\u0010>R \u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b?\u0010@R&\u0010\b\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00070\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bA\u0010@R\"\u0010\n\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00050\t8\u0000X\u0080\u0004¢\u0006\f\n\u0004\bB\u0010C\u001a\u0004\bD\u0010ER\u0014\u0010I\u001a\u00020F8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bG\u0010HR \u0010M\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020K0J8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bL\u0010@R\u0018\u0010R\u001a\u00060Nj\u0002`O8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bP\u0010QR\u0018\u0010\u001e\u001a\u0004\u0018\u00010\u001d8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0013\u0010SR\u001a\u0010V\u001a\b\u0012\u0004\u0012\u00020\r0T8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b.\u0010UR\u001a\u0010W\u001a\b\u0012\u0004\u0012\u00020\r0T8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b,\u0010UR\u0014\u0010Z\u001a\u00020X8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010YR\u0018\u0010\\\u001a\u0004\u0018\u0001068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b=\u0010[R\u0018\u0010_\u001a\u0004\u0018\u00010]8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bD\u0010^R\u0014\u0010a\u001a\u00020\u00018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b8\u0010`¨\u0006b"}, d2 = {"Landroidx/room/InvalidationTracker;", "", "Landroidx/room/RoomDatabase;", "database", "", "", "shadowTablesMap", "", "viewTables", "", "tableNames", "<init>", "(Landroidx/room/RoomDatabase;Ljava/util/Map;Ljava/util/Map;[Ljava/lang/String;)V", "LY8/t;", "r", "()V", "Landroidx/room/InvalidationTracker$b;", "observer", "", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "(Landroidx/room/InvalidationTracker$b;)Z", "x", "", "k", "()Ljava/util/List;", "", "tableIds", "p", "(Ljava/util/Set;)V", "Landroidx/room/support/AutoCloser;", "autoCloser", "y", "(Landroidx/room/support/AutoCloser;)V", "Li1/b;", "connection", "o", "(Li1/b;)V", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "(Le9/c;)Ljava/lang/Object;", "B", "u", "tables", "emitInitialState", "LXa/b;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "([Ljava/lang/String;Z)LXa/b;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "(Landroidx/room/InvalidationTracker$b;)V", "w", "v", "q", "Landroid/content/Context;", "context", "name", "Landroid/content/Intent;", "serviceIntent", "n", "(Landroid/content/Context;Ljava/lang/String;Landroid/content/Intent;)V", "z", Const.INTENT_KEY_APIKEY, "Landroidx/room/RoomDatabase;", "l", "()Landroidx/room/RoomDatabase;", Const.INTENT_KEY_PKGNAME, "Ljava/util/Map;", "c", Const.INTENT_KEY_UMID, "[Ljava/lang/String;", "m", "()[Ljava/lang/String;", "Landroidx/room/TriggerBasedInvalidationTracker;", "e", "Landroidx/room/TriggerBasedInvalidationTracker;", "implementation", "", "Landroidx/room/k;", "f", "observerMap", "Ljava/util/concurrent/locks/ReentrantLock;", "Landroidx/room/concurrent/ReentrantLock;", Const.INTENT_KEY_BACKGROUND_COMMAND, "Ljava/util/concurrent/locks/ReentrantLock;", "observerMapLock", "Landroidx/room/support/AutoCloser;", "Lkotlin/Function0;", "Lp9/a;", "onRefreshScheduled", "onRefreshCompleted", "Landroidx/room/g;", "Landroidx/room/g;", "invalidationLiveDataContainer", "Landroid/content/Intent;", "multiInstanceInvalidationIntent", "Landroidx/room/MultiInstanceInvalidationClient;", "Landroidx/room/MultiInstanceInvalidationClient;", "multiInstanceInvalidationClient", "Ljava/lang/Object;", "trackerLock", "room-runtime"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes.dex */
public class InvalidationTracker {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final RoomDatabase database;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final Map<String, String> shadowTablesMap;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public final Map<String, Set<String>> viewTables;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public final String[] tableNames;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    public final TriggerBasedInvalidationTracker implementation;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    public final Map<b, k> observerMap;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    public final ReentrantLock observerMapLock;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    public AutoCloser autoCloser;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    public final InterfaceC5063a<Y8.t> onRefreshScheduled;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    public final InterfaceC5063a<Y8.t> onRefreshCompleted;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    public final g invalidationLiveDataContainer;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    public Intent multiInstanceInvalidationIntent;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    public MultiInstanceInvalidationClient multiInstanceInvalidationClient;

    /* renamed from: n, reason: collision with root package name and from kotlin metadata */
    public final Object trackerLock;

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\b&\u0018\u00002\u00020\u0001B\u0017\u0012\u000e\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u001d\u0010\t\u001a\u00020\b2\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007H&¢\u0006\u0004\b\t\u0010\nR\"\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u00028\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\u000b\u0010\rR\u0014\u0010\u0011\u001a\u00020\u000e8PX\u0090\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0012"}, d2 = {"Landroidx/room/InvalidationTracker$b;", "", "", "", "tables", "<init>", "([Ljava/lang/String;)V", "", "LY8/t;", "c", "(Ljava/util/Set;)V", Const.INTENT_KEY_APIKEY, "[Ljava/lang/String;", "()[Ljava/lang/String;", "", Const.INTENT_KEY_PKGNAME, "()Z", "isRemote", "room-runtime"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static abstract class b {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        public final String[] tables;

        public b(String[] tables) {
            kotlin.jvm.internal.p.i(tables, "tables");
            this.tables = tables;
        }

        /* renamed from: a, reason: from getter */
        public final String[] getTables() {
            return this.tables;
        }

        public boolean b() {
            return false;
        }

        public abstract void c(Set<String> tables);
    }

    public InvalidationTracker(RoomDatabase database, Map<String, String> shadowTablesMap, Map<String, Set<String>> viewTables, String... tableNames) {
        kotlin.jvm.internal.p.i(database, "database");
        kotlin.jvm.internal.p.i(shadowTablesMap, "shadowTablesMap");
        kotlin.jvm.internal.p.i(viewTables, "viewTables");
        kotlin.jvm.internal.p.i(tableNames, "tableNames");
        this.database = database;
        this.shadowTablesMap = shadowTablesMap;
        this.viewTables = viewTables;
        this.tableNames = tableNames;
        TriggerBasedInvalidationTracker triggerBasedInvalidationTracker = new TriggerBasedInvalidationTracker(database, shadowTablesMap, viewTables, tableNames, database.getUseTempTrackingTable(), new InvalidationTracker$implementation$1(this));
        this.implementation = triggerBasedInvalidationTracker;
        this.observerMap = new LinkedHashMap();
        this.observerMapLock = new ReentrantLock();
        this.onRefreshScheduled = new InterfaceC5063a() { // from class: androidx.room.h
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return InvalidationTracker.t(this.f14795a);
            }
        };
        this.onRefreshCompleted = new InterfaceC5063a() { // from class: androidx.room.i
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return InvalidationTracker.s(this.f14796a);
            }
        };
        this.invalidationLiveDataContainer = new g(database);
        this.trackerLock = new Object();
        triggerBasedInvalidationTracker.u(new InterfaceC5063a() { // from class: androidx.room.j
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return Boolean.valueOf(InvalidationTracker.d(this.f14797a));
            }
        });
    }

    public static final boolean d(InvalidationTracker invalidationTracker) {
        return !invalidationTracker.database.F() || invalidationTracker.database.M();
    }

    public static final Y8.t s(InvalidationTracker invalidationTracker) {
        AutoCloser autoCloser = invalidationTracker.autoCloser;
        if (autoCloser != null) {
            autoCloser.g();
        }
        return Y8.t.f7040a;
    }

    public static final Y8.t t(InvalidationTracker invalidationTracker) {
        AutoCloser autoCloser = invalidationTracker.autoCloser;
        if (autoCloser != null) {
            autoCloser.j();
        }
        return Y8.t.f7040a;
    }

    public final Object A(InterfaceC4014c<? super Y8.t> interfaceC4014c) throws Throwable {
        Object objX = this.implementation.x(interfaceC4014c);
        return objX == C4063a.g() ? objX : Y8.t.f7040a;
    }

    public final void B() {
        RunBlockingUninterruptible_androidKt.a(new InvalidationTracker$syncBlocking$1(this, null));
    }

    public final boolean h(b observer) {
        Pair<String[], int[]> pairY = this.implementation.y(observer.getTables());
        String[] strArrA = pairY.a();
        int[] iArrB = pairY.b();
        k kVar = new k(observer, iArrB, strArrA);
        ReentrantLock reentrantLock = this.observerMapLock;
        reentrantLock.lock();
        try {
            k kVarPut = this.observerMap.containsKey(observer) ? (k) kotlin.collections.a.j(this.observerMap, observer) : this.observerMap.put(observer, kVar);
            reentrantLock.unlock();
            return kVarPut == null && this.implementation.p(iArrB);
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    public final void i(b observer) {
        kotlin.jvm.internal.p.i(observer, "observer");
        if (!observer.b()) {
            throw new IllegalStateException("isRemote was false of observer argument");
        }
        h(observer);
    }

    public final Xa.b<Set<String>> j(String[] tables, boolean emitInitialState) {
        kotlin.jvm.internal.p.i(tables, "tables");
        Pair<String[], int[]> pairY = this.implementation.y(tables);
        String[] strArrA = pairY.a();
        Xa.b<Set<String>> bVarM = this.implementation.m(strArrA, pairY.b(), emitInitialState);
        MultiInstanceInvalidationClient multiInstanceInvalidationClient = this.multiInstanceInvalidationClient;
        Xa.b<Set<String>> bVarH = multiInstanceInvalidationClient != null ? multiInstanceInvalidationClient.h(strArrA) : null;
        return bVarH != null ? Xa.d.I(bVarM, bVarH) : bVarM;
    }

    public final List<b> k() {
        ReentrantLock reentrantLock = this.observerMapLock;
        reentrantLock.lock();
        try {
            return Z8.F.m1(this.observerMap.keySet());
        } finally {
            reentrantLock.unlock();
        }
    }

    /* renamed from: l, reason: from getter */
    public final RoomDatabase getDatabase() {
        return this.database;
    }

    /* renamed from: m, reason: from getter */
    public final String[] getTableNames() {
        return this.tableNames;
    }

    public final void n(Context context, String name, Intent serviceIntent) {
        kotlin.jvm.internal.p.i(context, "context");
        kotlin.jvm.internal.p.i(name, "name");
        kotlin.jvm.internal.p.i(serviceIntent, "serviceIntent");
        this.multiInstanceInvalidationIntent = serviceIntent;
        this.multiInstanceInvalidationClient = new MultiInstanceInvalidationClient(context, name, this);
    }

    public final void o(InterfaceC4160b connection) {
        kotlin.jvm.internal.p.i(connection, "connection");
        this.implementation.l(connection);
        synchronized (this.trackerLock) {
            try {
                MultiInstanceInvalidationClient multiInstanceInvalidationClient = this.multiInstanceInvalidationClient;
                if (multiInstanceInvalidationClient != null) {
                    Intent intent = this.multiInstanceInvalidationIntent;
                    if (intent == null) {
                        throw new IllegalStateException("Required value was null.");
                    }
                    multiInstanceInvalidationClient.k(intent);
                    Y8.t tVar = Y8.t.f7040a;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void p(Set<Integer> tableIds) {
        ReentrantLock reentrantLock = this.observerMapLock;
        reentrantLock.lock();
        try {
            List listM1 = Z8.F.m1(this.observerMap.values());
            reentrantLock.unlock();
            Iterator it = listM1.iterator();
            while (it.hasNext()) {
                ((k) it.next()).c(tableIds);
            }
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    public final void q(Set<String> tables) {
        kotlin.jvm.internal.p.i(tables, "tables");
        ReentrantLock reentrantLock = this.observerMapLock;
        reentrantLock.lock();
        try {
            List<k> listM1 = Z8.F.m1(this.observerMap.values());
            reentrantLock.unlock();
            for (k kVar : listM1) {
                if (!kVar.getObserver().b()) {
                    kVar.d(tables);
                }
            }
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    public final void r() {
        synchronized (this.trackerLock) {
            try {
                MultiInstanceInvalidationClient multiInstanceInvalidationClient = this.multiInstanceInvalidationClient;
                if (multiInstanceInvalidationClient != null) {
                    List<b> listK = k();
                    ArrayList arrayList = new ArrayList();
                    for (Object obj : listK) {
                        if (!((b) obj).b()) {
                            arrayList.add(obj);
                        }
                    }
                    if (arrayList.isEmpty()) {
                        multiInstanceInvalidationClient.l();
                    }
                }
                this.implementation.s();
                Y8.t tVar = Y8.t.f7040a;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void u() {
        this.implementation.r(this.onRefreshScheduled, this.onRefreshCompleted);
    }

    public void v() {
        this.implementation.r(this.onRefreshScheduled, this.onRefreshCompleted);
    }

    public void w(b observer) {
        kotlin.jvm.internal.p.i(observer, "observer");
        if (x(observer)) {
            RunBlockingUninterruptible_androidKt.a(new InvalidationTracker$removeObserver$1(this, null));
        }
    }

    public final boolean x(b observer) {
        ReentrantLock reentrantLock = this.observerMapLock;
        reentrantLock.lock();
        try {
            k kVarRemove = this.observerMap.remove(observer);
            return kVarRemove != null && this.implementation.q(kVarRemove.getTableIds());
        } finally {
            reentrantLock.unlock();
        }
    }

    public final void y(AutoCloser autoCloser) {
        kotlin.jvm.internal.p.i(autoCloser, "autoCloser");
        this.autoCloser = autoCloser;
        autoCloser.n(new InvalidationTracker$setAutoCloser$1(this));
    }

    public final void z() {
        MultiInstanceInvalidationClient multiInstanceInvalidationClient = this.multiInstanceInvalidationClient;
        if (multiInstanceInvalidationClient != null) {
            multiInstanceInvalidationClient.l();
        }
    }
}
