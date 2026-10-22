package androidx.room;

import android.database.Cursor;
import android.os.CancellationSignal;
import android.os.Looper;
import android.util.Log;
import androidx.annotation.CallSuper;
import androidx.annotation.RestrictTo;
import androidx.annotation.WorkerThread;
import e.EnumC0546d;
import h0.AbstractC0587a;
import java.util.BitSet;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import k0.C0673a;
import k0.InterfaceC0674b;
import kotlin.Deprecated;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.JvmSuppressWildcards;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t0.C0916b;

/* loaded from: classes.dex */
public abstract class A {

    @NotNull
    public static final x Companion = new x();

    @RestrictTo({EnumC0546d.f12494c})
    public static final int MAX_BIND_PARAMETER_CNT = 999;
    private boolean allowMainThreadQueries;

    @Nullable
    private AbstractC0345a autoCloser;

    @NotNull
    private final Map<String, Object> backingFieldMap;
    private k0.g internalOpenHelper;
    private Executor internalQueryExecutor;
    private Executor internalTransactionExecutor;

    @JvmField
    @RestrictTo({EnumC0546d.f12494c})
    @Nullable
    protected List<? extends C0916b> mCallbacks;

    @JvmField
    @Nullable
    protected volatile InterfaceC0674b mDatabase;

    @NotNull
    private final Map<Class<?>, Object> typeConverters;
    private boolean writeAheadLoggingEnabled;

    @NotNull
    private final r invalidationTracker = createInvalidationTracker();

    @NotNull
    private Map<Class<Object>, Object> autoMigrationSpecs = new LinkedHashMap();

    @NotNull
    private final ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();

    @NotNull
    private final ThreadLocal<Integer> suspendingTransactionId = new ThreadLocal<>();

    public A() {
        Map<String, Object> mapSynchronizedMap = Collections.synchronizedMap(new LinkedHashMap());
        Intrinsics.checkNotNullExpressionValue(mapSynchronizedMap, "synchronizedMap(mutableMapOf())");
        this.backingFieldMap = mapSynchronizedMap;
        this.typeConverters = new LinkedHashMap();
    }

    public static final void access$internalBeginTransaction(A a4) {
        a4.assertNotMainThread();
        InterfaceC0674b writableDatabase = a4.getOpenHelper().getWritableDatabase();
        a4.getInvalidationTracker().d(writableDatabase);
        if (writableDatabase.isWriteAheadLoggingEnabled()) {
            writableDatabase.beginTransactionNonExclusive();
        } else {
            writableDatabase.beginTransaction();
        }
    }

    @Deprecated(message = "Will be hidden in a future release.")
    public static /* synthetic */ void getMCallbacks$annotations() {
    }

    @Deprecated(message = "Will be hidden in the next release.")
    public static /* synthetic */ void getMDatabase$annotations() {
    }

    public static /* synthetic */ void isOpen$annotations() {
    }

    public static /* synthetic */ void isOpenInternal$annotations() {
    }

    public static /* synthetic */ Cursor query$default(A a4, k0.i iVar, CancellationSignal cancellationSignal, int i4, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: query");
        }
        if ((i4 & 2) != 0) {
            cancellationSignal = null;
        }
        return a4.query(iVar, cancellationSignal);
    }

    public final void a() {
        getOpenHelper().getWritableDatabase().endTransaction();
        if (inTransaction()) {
            return;
        }
        r invalidationTracker = getInvalidationTracker();
        if (invalidationTracker.f4235f.compareAndSet(false, true)) {
            invalidationTracker.f4230a.getQueryExecutor().execute(invalidationTracker.f4242m);
        }
    }

    @RestrictTo({EnumC0546d.f12494c})
    public void assertNotMainThread() {
        if (!this.allowMainThreadQueries && !(!isMainThread$room_runtime_release())) {
            throw new IllegalStateException("Cannot access database on the main thread since it may potentially lock the UI for a long period of time.".toString());
        }
    }

    @RestrictTo({EnumC0546d.f12493b})
    public void assertNotSuspendingTransaction() {
        if (!inTransaction() && this.suspendingTransactionId.get() != null) {
            throw new IllegalStateException("Cannot access database on a different coroutine context inherited from a suspending transaction.".toString());
        }
    }

    @Deprecated(message = "beginTransaction() is deprecated", replaceWith = @ReplaceWith(expression = "runInTransaction(Runnable)", imports = {}))
    public void beginTransaction() {
        assertNotMainThread();
        assertNotMainThread();
        InterfaceC0674b writableDatabase = getOpenHelper().getWritableDatabase();
        getInvalidationTracker().d(writableDatabase);
        if (writableDatabase.isWriteAheadLoggingEnabled()) {
            writableDatabase.beginTransactionNonExclusive();
        } else {
            writableDatabase.beginTransaction();
        }
    }

    @WorkerThread
    public abstract void clearAllTables();

    public void close() {
        if (isOpen()) {
            ReentrantReadWriteLock.WriteLock writeLock = this.readWriteLock.writeLock();
            Intrinsics.checkNotNullExpressionValue(writeLock, "readWriteLock.writeLock()");
            writeLock.lock();
            try {
                getInvalidationTracker().c();
                getOpenHelper().close();
            } finally {
                writeLock.unlock();
            }
        }
    }

    @NotNull
    public k0.j compileStatement(@NotNull String sql) {
        Intrinsics.checkNotNullParameter(sql, "sql");
        assertNotMainThread();
        assertNotSuspendingTransaction();
        return getOpenHelper().getWritableDatabase().compileStatement(sql);
    }

    @NotNull
    public abstract r createInvalidationTracker();

    @NotNull
    public abstract k0.g createOpenHelper(@NotNull C0353i c0353i);

    @Deprecated(message = "endTransaction() is deprecated", replaceWith = @ReplaceWith(expression = "runInTransaction(Runnable)", imports = {}))
    public void endTransaction() {
        a();
    }

    @RestrictTo({EnumC0546d.f12493b})
    @NotNull
    public final Map<Class<Object>, Object> getAutoMigrationSpecs() {
        return this.autoMigrationSpecs;
    }

    @RestrictTo({EnumC0546d.f12493b})
    @JvmSuppressWildcards
    @NotNull
    public List<AbstractC0587a> getAutoMigrations(@NotNull Map<Class<Object>, Object> autoMigrationSpecs) {
        Intrinsics.checkNotNullParameter(autoMigrationSpecs, "autoMigrationSpecs");
        return CollectionsKt.emptyList();
    }

    @RestrictTo({EnumC0546d.f12493b})
    @NotNull
    public final Map<String, Object> getBackingFieldMap() {
        return this.backingFieldMap;
    }

    @NotNull
    public final Lock getCloseLock$room_runtime_release() {
        ReentrantReadWriteLock.ReadLock lock = this.readWriteLock.readLock();
        Intrinsics.checkNotNullExpressionValue(lock, "readWriteLock.readLock()");
        return lock;
    }

    @NotNull
    public r getInvalidationTracker() {
        return this.invalidationTracker;
    }

    @NotNull
    public k0.g getOpenHelper() {
        k0.g gVar = this.internalOpenHelper;
        if (gVar != null) {
            return gVar;
        }
        Intrinsics.throwUninitializedPropertyAccessException("internalOpenHelper");
        return null;
    }

    @NotNull
    public Executor getQueryExecutor() {
        Executor executor = this.internalQueryExecutor;
        if (executor != null) {
            return executor;
        }
        Intrinsics.throwUninitializedPropertyAccessException("internalQueryExecutor");
        return null;
    }

    @RestrictTo({EnumC0546d.f12493b})
    @NotNull
    public Set<Class<Object>> getRequiredAutoMigrationSpecs() {
        return SetsKt.emptySet();
    }

    @RestrictTo({EnumC0546d.f12493b})
    @NotNull
    public Map<Class<?>, List<Class<?>>> getRequiredTypeConverters() {
        return MapsKt.emptyMap();
    }

    @RestrictTo({EnumC0546d.f12493b})
    @NotNull
    public final ThreadLocal<Integer> getSuspendingTransactionId() {
        return this.suspendingTransactionId;
    }

    @NotNull
    public Executor getTransactionExecutor() {
        Executor executor = this.internalTransactionExecutor;
        if (executor != null) {
            return executor;
        }
        Intrinsics.throwUninitializedPropertyAccessException("internalTransactionExecutor");
        return null;
    }

    @Nullable
    public <T> T getTypeConverter(@NotNull Class<T> klass) {
        Intrinsics.checkNotNullParameter(klass, "klass");
        return (T) this.typeConverters.get(klass);
    }

    public boolean inTransaction() {
        return getOpenHelper().getWritableDatabase().inTransaction();
    }

    @CallSuper
    public void init(@NotNull C0353i configuration) {
        Intrinsics.checkNotNullParameter(configuration, "configuration");
        this.internalOpenHelper = createOpenHelper(configuration);
        Set<Class<Object>> requiredAutoMigrationSpecs = getRequiredAutoMigrationSpecs();
        BitSet bitSet = new BitSet();
        Iterator<Class<Object>> it = requiredAutoMigrationSpecs.iterator();
        while (true) {
            int i4 = -1;
            if (it.hasNext()) {
                Class<Object> next = it.next();
                int size = configuration.f4218n.size() - 1;
                List list = configuration.f4218n;
                if (size >= 0) {
                    while (true) {
                        int i5 = size - 1;
                        if (next.isAssignableFrom(list.get(size).getClass())) {
                            bitSet.set(size);
                            i4 = size;
                            break;
                        } else if (i5 < 0) {
                            break;
                        } else {
                            size = i5;
                        }
                    }
                }
                if (i4 < 0) {
                    throw new IllegalArgumentException(("A required auto migration spec (" + next.getCanonicalName() + ") is missing in the database configuration.").toString());
                }
                this.autoMigrationSpecs.put(next, list.get(i4));
            } else {
                int size2 = configuration.f4218n.size() - 1;
                if (size2 >= 0) {
                    while (true) {
                        int i6 = size2 - 1;
                        if (!bitSet.get(size2)) {
                            throw new IllegalArgumentException("Unexpected auto migration specs found. Annotate AutoMigrationSpec implementation with @ProvidedAutoMigrationSpec annotation or remove this spec from the builder.".toString());
                        }
                        if (i6 < 0) {
                            break;
                        } else {
                            size2 = i6;
                        }
                    }
                }
                for (AbstractC0587a abstractC0587a : getAutoMigrations(this.autoMigrationSpecs)) {
                    int i7 = abstractC0587a.startVersion;
                    int i8 = abstractC0587a.endVersion;
                    z zVar = configuration.f4208d;
                    HashMap map = zVar.f4268a;
                    if (map.containsKey(Integer.valueOf(i7))) {
                        Map mapEmptyMap = (Map) map.get(Integer.valueOf(i7));
                        if (mapEmptyMap == null) {
                            mapEmptyMap = MapsKt.emptyMap();
                        }
                        if (!mapEmptyMap.containsKey(Integer.valueOf(i8))) {
                        }
                    }
                    zVar.a(abstractC0587a);
                }
                k0.g openHelper = getOpenHelper();
                if (!F.class.isInstance(openHelper)) {
                    openHelper = null;
                }
                B0.g.y(openHelper);
                k0.g openHelper2 = getOpenHelper();
                B0.g.y(AbstractC0348d.class.isInstance(openHelper2) ? openHelper2 : null);
                boolean z4 = configuration.f4211g == y.f4266c;
                getOpenHelper().setWriteAheadLoggingEnabled(z4);
                this.mCallbacks = configuration.f4209e;
                this.internalQueryExecutor = configuration.f4212h;
                this.internalTransactionExecutor = new androidx.appcompat.app.p(configuration.f4213i);
                this.allowMainThreadQueries = configuration.f4210f;
                this.writeAheadLoggingEnabled = z4;
                Map<Class<?>, List<Class<?>>> requiredTypeConverters = getRequiredTypeConverters();
                BitSet bitSet2 = new BitSet();
                Iterator<Map.Entry<Class<?>, List<Class<?>>>> it2 = requiredTypeConverters.entrySet().iterator();
                while (true) {
                    boolean zHasNext = it2.hasNext();
                    List list2 = configuration.f4217m;
                    if (zHasNext) {
                        Map.Entry<Class<?>, List<Class<?>>> next2 = it2.next();
                        Class<?> key = next2.getKey();
                        for (Class<?> cls : next2.getValue()) {
                            int size3 = list2.size() - 1;
                            if (size3 >= 0) {
                                while (true) {
                                    int i9 = size3 - 1;
                                    if (cls.isAssignableFrom(list2.get(size3).getClass())) {
                                        bitSet2.set(size3);
                                        break;
                                    } else if (i9 < 0) {
                                        break;
                                    } else {
                                        size3 = i9;
                                    }
                                }
                                size3 = -1;
                            } else {
                                size3 = -1;
                            }
                            if (size3 < 0) {
                                throw new IllegalArgumentException(("A required type converter (" + cls + ") for " + key.getCanonicalName() + " is missing in the database configuration.").toString());
                            }
                            this.typeConverters.put(cls, list2.get(size3));
                        }
                    } else {
                        int size4 = list2.size() - 1;
                        if (size4 < 0) {
                            return;
                        }
                        while (true) {
                            int i10 = size4 - 1;
                            if (!bitSet2.get(size4)) {
                                throw new IllegalArgumentException("Unexpected type converter " + list2.get(size4) + ". Annotate TypeConverter class with @ProvidedTypeConverter annotation or remove this converter from the builder.");
                            }
                            if (i10 < 0) {
                                return;
                            } else {
                                size4 = i10;
                            }
                        }
                    }
                }
            }
        }
    }

    public void internalInitInvalidationTracker(@NotNull InterfaceC0674b database) {
        Intrinsics.checkNotNullParameter(database, "db");
        r invalidationTracker = getInvalidationTracker();
        invalidationTracker.getClass();
        Intrinsics.checkNotNullParameter(database, "database");
        synchronized (invalidationTracker.f4241l) {
            if (invalidationTracker.f4236g) {
                Log.e("ROOM", "Invalidation tracker is initialized twice :/.");
                return;
            }
            database.execSQL("PRAGMA temp_store = MEMORY;");
            database.execSQL("PRAGMA recursive_triggers='ON';");
            database.execSQL("CREATE TEMP TABLE room_table_modification_log (table_id INTEGER PRIMARY KEY, invalidated INTEGER NOT NULL DEFAULT 0)");
            invalidationTracker.d(database);
            invalidationTracker.f4237h = database.compileStatement("UPDATE room_table_modification_log SET invalidated = 0 WHERE invalidated = 1");
            invalidationTracker.f4236g = true;
            Unit unit = Unit.INSTANCE;
        }
    }

    public final boolean isMainThread$room_runtime_release() {
        return Looper.getMainLooper().getThread() == Thread.currentThread();
    }

    public boolean isOpen() {
        InterfaceC0674b interfaceC0674b = this.mDatabase;
        return Intrinsics.areEqual(interfaceC0674b != null ? Boolean.valueOf(interfaceC0674b.isOpen()) : null, Boolean.TRUE);
    }

    @RestrictTo({EnumC0546d.f12493b})
    public final boolean isOpenInternal() {
        InterfaceC0674b interfaceC0674b = this.mDatabase;
        return interfaceC0674b != null && interfaceC0674b.isOpen();
    }

    @JvmOverloads
    @NotNull
    public final Cursor query(@NotNull k0.i query) {
        Intrinsics.checkNotNullParameter(query, "query");
        return query$default(this, query, null, 2, null);
    }

    public void runInTransaction(@NotNull Runnable body) {
        Intrinsics.checkNotNullParameter(body, "body");
        beginTransaction();
        try {
            body.run();
            setTransactionSuccessful();
        } finally {
            endTransaction();
        }
    }

    @RestrictTo({EnumC0546d.f12493b})
    public final void setAutoMigrationSpecs(@NotNull Map<Class<Object>, Object> map) {
        Intrinsics.checkNotNullParameter(map, "<set-?>");
        this.autoMigrationSpecs = map;
    }

    @Deprecated(message = "setTransactionSuccessful() is deprecated", replaceWith = @ReplaceWith(expression = "runInTransaction(Runnable)", imports = {}))
    public void setTransactionSuccessful() {
        getOpenHelper().getWritableDatabase().setTransactionSuccessful();
    }

    @JvmOverloads
    @NotNull
    public Cursor query(@NotNull k0.i query, @Nullable CancellationSignal cancellationSignal) {
        Intrinsics.checkNotNullParameter(query, "query");
        assertNotMainThread();
        assertNotSuspendingTransaction();
        return cancellationSignal != null ? getOpenHelper().getWritableDatabase().query(query, cancellationSignal) : getOpenHelper().getWritableDatabase().query(query);
    }

    public <V> V runInTransaction(@NotNull Callable<V> body) {
        Intrinsics.checkNotNullParameter(body, "body");
        beginTransaction();
        try {
            V vCall = body.call();
            setTransactionSuccessful();
            return vCall;
        } finally {
            endTransaction();
        }
    }

    @NotNull
    public Cursor query(@NotNull String query, @Nullable Object[] objArr) {
        Intrinsics.checkNotNullParameter(query, "query");
        return getOpenHelper().getWritableDatabase().query(new C0673a(query, objArr));
    }
}
