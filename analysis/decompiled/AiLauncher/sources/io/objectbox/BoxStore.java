package io.objectbox;

import Q8.c;
import Q8.e;
import T8.d;
import V8.a;
import ic.C4198b;
import io.objectbox.BoxStore;
import io.objectbox.converter.PropertyConverter;
import io.objectbox.exception.DbException;
import io.objectbox.exception.DbExceptionListener;
import io.objectbox.exception.DbSchemaException;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/* loaded from: classes4.dex */
public class BoxStore implements Closeable {

    /* renamed from: A, reason: collision with root package name */
    public static final Set<String> f34296A = new HashSet();

    /* renamed from: B, reason: collision with root package name */
    public static volatile Thread f34297B;

    /* renamed from: y, reason: collision with root package name */
    public static Object f34298y;

    /* renamed from: z, reason: collision with root package name */
    public static Object f34299z;

    /* renamed from: a, reason: collision with root package name */
    public final PrintStream f34300a;

    /* renamed from: b, reason: collision with root package name */
    public final File f34301b;

    /* renamed from: c, reason: collision with root package name */
    public final String f34302c;

    /* renamed from: d, reason: collision with root package name */
    public volatile long f34303d;

    /* renamed from: j, reason: collision with root package name */
    public final int[] f34309j;

    /* renamed from: n, reason: collision with root package name */
    public final e f34313n;

    /* renamed from: o, reason: collision with root package name */
    public final boolean f34314o;

    /* renamed from: p, reason: collision with root package name */
    public final boolean f34315p;

    /* renamed from: q, reason: collision with root package name */
    public final boolean f34316q;

    /* renamed from: s, reason: collision with root package name */
    public volatile boolean f34318s;

    /* renamed from: u, reason: collision with root package name */
    public volatile int f34320u;

    /* renamed from: v, reason: collision with root package name */
    public int f34321v;

    /* renamed from: w, reason: collision with root package name */
    public final int f34322w;

    /* renamed from: x, reason: collision with root package name */
    public a f34323x;

    /* renamed from: e, reason: collision with root package name */
    public volatile boolean f34304e = false;

    /* renamed from: f, reason: collision with root package name */
    public final Map<Class<?>, String> f34305f = new HashMap();

    /* renamed from: g, reason: collision with root package name */
    public final Map<Class<?>, Integer> f34306g = new HashMap();

    /* renamed from: h, reason: collision with root package name */
    public final Map<Class<?>, EntityInfo<?>> f34307h = new HashMap();

    /* renamed from: i, reason: collision with root package name */
    public final C4198b<Class<?>> f34308i = new C4198b<>();

    /* renamed from: k, reason: collision with root package name */
    public final Map<Class<?>, Q8.a<?>> f34310k = new ConcurrentHashMap();

    /* renamed from: l, reason: collision with root package name */
    public final Set<Transaction> f34311l = Collections.newSetFromMap(new WeakHashMap());

    /* renamed from: m, reason: collision with root package name */
    public final ExecutorService f34312m = new d(this);

    /* renamed from: r, reason: collision with root package name */
    public final ThreadLocal<Transaction> f34317r = new ThreadLocal<>();

    /* renamed from: t, reason: collision with root package name */
    public final Object f34319t = new Object();

    public BoxStore(c cVar) throws InterruptedException {
        f34298y = cVar.f5443i;
        f34299z = cVar.f5444j;
        T8.c.b();
        this.f34300a = cVar.f5435a;
        File file = cVar.f5437c;
        this.f34301b = file;
        String strJ = J(file);
        this.f34302c = strJ;
        s1(strJ);
        try {
            this.f34303d = nativeCreateWithFlatOptions(cVar.d(strJ), cVar.f5436b);
            if (this.f34303d == 0) {
                throw new DbException("Could not create native store");
            }
            int i10 = cVar.f5445k;
            if (i10 != 0) {
                this.f34314o = (i10 & 1) != 0;
                this.f34315p = (i10 & 2) != 0;
            } else {
                this.f34315p = false;
                this.f34314o = false;
            }
            this.f34316q = cVar.f5446l;
            for (EntityInfo<?> entityInfo : cVar.f5457w) {
                try {
                    this.f34305f.put(entityInfo.p(), entityInfo.I());
                    int iNativeRegisterEntityClass = nativeRegisterEntityClass(this.f34303d, entityInfo.I(), entityInfo.p());
                    this.f34306g.put(entityInfo.p(), Integer.valueOf(iNativeRegisterEntityClass));
                    this.f34308i.c(iNativeRegisterEntityClass, entityInfo.p());
                    this.f34307h.put(entityInfo.p(), entityInfo);
                    Property<?>[] propertyArrO = entityInfo.o();
                    if (propertyArrO.length > 0) {
                        Property<?> property = propertyArrO[0];
                        throw null;
                    }
                } catch (RuntimeException e10) {
                    throw new RuntimeException("Could not setup up entity " + entityInfo.p(), e10);
                }
            }
            int iE = this.f34308i.e();
            this.f34309j = new int[iE];
            long[] jArrB = this.f34308i.b();
            for (int i11 = 0; i11 < iE; i11++) {
                this.f34309j[i11] = (int) jArrB[i11];
            }
            this.f34313n = new e(this);
            this.f34322w = Math.max(cVar.f5450p, 1);
        } catch (RuntimeException e11) {
            close();
            throw e11;
        }
    }

    public static boolean A(File file) {
        String strJ = J(file);
        if (T0(strJ)) {
            throw new IllegalStateException("Cannot delete files: store is still open");
        }
        T8.c.b();
        return nativeRemoveDbFiles(strJ, true);
    }

    public static boolean G(File file, String str) {
        return A(c.k(file, str));
    }

    public static String J(File file) {
        if (file.getPath().startsWith("memory:")) {
            return file.getPath();
        }
        if (file.exists()) {
            if (!file.isDirectory()) {
                throw new DbException("Is not a directory: " + file.getAbsolutePath());
            }
        } else if (!file.mkdirs()) {
            throw new DbException("Could not create directory: " + file.getAbsolutePath());
        }
        try {
            return file.getCanonicalPath();
        } catch (IOException e10) {
            throw new DbException("Could not verify dir", e10);
        }
    }

    public static boolean T0(final String str) throws InterruptedException {
        boolean zContains;
        Set<String> set = f34296A;
        synchronized (set) {
            try {
                if (!set.contains(str)) {
                    return false;
                }
                Thread thread = f34297B;
                if (thread != null && thread.isAlive()) {
                    return Y0(str, false);
                }
                Thread thread2 = new Thread(new Runnable() { // from class: Q8.b
                    @Override // java.lang.Runnable
                    public final void run() {
                        BoxStore.b(str);
                    }
                });
                thread2.setDaemon(true);
                f34297B = thread2;
                thread2.start();
                try {
                    thread2.join(500L);
                } catch (InterruptedException e10) {
                    e10.printStackTrace();
                }
                Set<String> set2 = f34296A;
                synchronized (set2) {
                    zContains = set2.contains(str);
                }
                return zContains;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static synchronized Object U() {
        return f34298y;
    }

    public static boolean Y0(String str, boolean z10) {
        boolean zContains;
        synchronized (f34296A) {
            int i10 = 0;
            while (i10 < 5) {
                try {
                    Set<String> set = f34296A;
                    if (!set.contains(str)) {
                        break;
                    }
                    i10++;
                    System.gc();
                    if (z10 && i10 > 1) {
                        System.runFinalization();
                    }
                    System.gc();
                    if (z10 && i10 > 1) {
                        System.runFinalization();
                    }
                    try {
                        set.wait(100L);
                    } catch (InterruptedException unused) {
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            zContains = f34296A.contains(str);
        }
        return zContains;
    }

    public static /* synthetic */ void b(String str) {
        Y0(str, true);
        f34297B = null;
    }

    public static native long nativeBeginReadTx(long j10);

    public static native long nativeBeginTx(long j10);

    public static native int nativeCleanStaleReadTransactions(long j10);

    public static native long nativeCreateWithFlatOptions(byte[] bArr, byte[] bArr2);

    public static native void nativeDelete(long j10);

    public static native String nativeDiagnose(long j10);

    public static native void nativeDropAllData(long j10);

    public static native String nativeGetVersion();

    public static native long nativeGloballyActiveEntityTypes();

    private static native boolean nativeHasFeature(int i10);

    public static native boolean nativeIsObjectBrowserAvailable();

    public static native boolean nativeIsReadOnly(long j10);

    public static native void nativeRegisterCustomType(long j10, int i10, int i11, String str, Class<? extends PropertyConverter> cls, Class<?> cls2);

    public static native int nativeRegisterEntityClass(long j10, String str, Class<?> cls);

    public static native boolean nativeRemoveDbFiles(String str, boolean z10);

    public static native void nativeSetDbExceptionListener(long j10, DbExceptionListener dbExceptionListener);

    public static native void nativeSetDebugFlags(long j10, int i10);

    private native String nativeStartObjectBrowser(long j10, String str, int i10);

    private native boolean nativeStopObjectBrowser(long j10);

    public static native long nativeSysProcMeminfoKb(String str);

    public static native long nativeSysProcStatusKb(String str);

    public static void s1(String str) throws InterruptedException {
        T0(str);
        Set<String> set = f34296A;
        synchronized (set) {
            try {
                if (!set.add(str)) {
                    throw new DbException("Another BoxStore is still open for this directory (" + str + "). Make sure the existing instance is explicitly closed before creating a new one.");
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static synchronized Object v0() {
        return f34299z;
    }

    public a D0() {
        return this.f34323x;
    }

    public final boolean I0() {
        Iterator<Transaction> it = this.f34311l.iterator();
        while (it.hasNext()) {
            if (it.next().n()) {
                return true;
            }
        }
        return false;
    }

    public Future<?> N0(Runnable runnable) {
        return R0().submit(runnable);
    }

    public ExecutorService R0() {
        return this.f34312m;
    }

    public Class<?> V(int i10) {
        Class<?> clsA = this.f34308i.a(i10);
        if (clsA != null) {
            return clsA;
        }
        throw new DbSchemaException("No entity registered for type ID " + i10);
    }

    public <T> EntityInfo<T> Y(Class<T> cls) {
        return (EntityInfo) this.f34307h.get(cls);
    }

    public boolean a1() {
        return this.f34303d == 0;
    }

    public boolean b1() {
        return this.f34304e;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        boolean z10;
        ArrayList arrayList;
        synchronized (this) {
            try {
                z10 = this.f34318s;
                if (!this.f34318s) {
                    if (this.f34321v != 0) {
                        try {
                            k1();
                        } catch (Throwable th) {
                            th.printStackTrace();
                        }
                    }
                    this.f34318s = true;
                    R0().shutdown();
                    m();
                    synchronized (this.f34311l) {
                        if (I0()) {
                            k0().println("Briefly waiting for active transactions before closing the Store...");
                            try {
                                this.f34311l.wait(1000L);
                            } catch (InterruptedException unused) {
                            }
                            if (I0()) {
                                e0().println("Transactions are still active: ensure that all database operations are finished before closing the Store!");
                            }
                        }
                        arrayList = new ArrayList(this.f34311l);
                    }
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        ((Transaction) it.next()).close();
                    }
                    long j10 = this.f34303d;
                    this.f34303d = 0L;
                    if (j10 != 0) {
                        nativeDelete(j10);
                        this.f34304e = true;
                    }
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        if (z10) {
            return;
        }
        Set<String> set = f34296A;
        synchronized (set) {
            set.remove(this.f34302c);
            set.notifyAll();
        }
    }

    public Transaction e() {
        int i10 = this.f34320u;
        if (this.f34314o) {
            k0().println("Begin read TX with commit count " + i10);
        }
        long jNativeBeginReadTx = nativeBeginReadTx(g0());
        if (jNativeBeginReadTx == 0) {
            throw new DbException("Could not create native read transaction");
        }
        Transaction transaction = new Transaction(this, jNativeBeginReadTx, i10);
        synchronized (this.f34311l) {
            this.f34311l.add(transaction);
        }
        return transaction;
    }

    public final PrintStream e0() {
        return this.f34300a;
    }

    public void f1(a aVar) {
        this.f34323x = aVar;
    }

    public void finalize() throws Throwable {
        close();
        super.finalize();
    }

    public Transaction g() {
        int i10 = this.f34320u;
        if (this.f34315p) {
            k0().println("Begin TX with commit count " + i10);
        }
        long jNativeBeginTx = nativeBeginTx(g0());
        if (jNativeBeginTx == 0) {
            throw new DbException("Could not create native transaction");
        }
        Transaction transaction = new Transaction(this, jNativeBeginTx, i10);
        synchronized (this.f34311l) {
            this.f34311l.add(transaction);
        }
        return transaction;
    }

    public long g0() {
        l();
        return this.f34303d;
    }

    public final boolean h1(Thread thread) {
        if (thread.getName().startsWith(d.f5871b)) {
            return true;
        }
        for (StackTraceElement stackTraceElement : thread.getStackTrace()) {
            if (stackTraceElement.getClassName().contains("objectbox")) {
                return true;
            }
        }
        return false;
    }

    public <T> Q8.a<T> i(Class<T> cls) {
        Q8.a<T> aVar;
        Q8.a<T> aVar2 = (Q8.a) this.f34310k.get(cls);
        if (aVar2 != null) {
            return aVar2;
        }
        if (!this.f34305f.containsKey(cls)) {
            throw new IllegalArgumentException(cls + " is not a known entity. Please add it and trigger generation again.");
        }
        synchronized (this.f34310k) {
            try {
                aVar = (Q8.a) this.f34310k.get(cls);
                if (aVar == null) {
                    aVar = new Q8.a<>(this, cls);
                    this.f34310k.put(cls, aVar);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return aVar;
    }

    public boolean isClosed() {
        return this.f34318s;
    }

    public final PrintStream k0() {
        return System.out;
    }

    public synchronized boolean k1() {
        if (this.f34321v == 0) {
            throw new IllegalStateException("ObjectBrowser has not been started before");
        }
        this.f34321v = 0;
        return nativeStopObjectBrowser(g0());
    }

    public final void l() {
        if (isClosed()) {
            throw new IllegalStateException("Store is closed");
        }
    }

    public void l1(Transaction transaction, int[] iArr) {
        synchronized (this.f34319t) {
            try {
                this.f34320u++;
                if (this.f34315p) {
                    PrintStream printStreamK0 = k0();
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("TX committed. New commit count: ");
                    sb2.append(this.f34320u);
                    sb2.append(", entity types affected: ");
                    sb2.append(iArr != null ? iArr.length : 0);
                    printStreamK0.println(sb2.toString());
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        Iterator<Q8.a<?>> it = this.f34310k.values().iterator();
        while (it.hasNext()) {
            it.next().n(transaction);
        }
        if (iArr != null) {
            this.f34313n.b(iArr);
        }
    }

    public final void m() {
        try {
            if (R0().awaitTermination(1L, TimeUnit.SECONDS)) {
                return;
            }
            e0().println("ObjectBox thread pool not terminated in time. Ensure all async calls have completed and subscriptions are cancelled before closing the Store.\nDumping stack traces of threads on the pool and any using ObjectBox APIs:\n=== BEGIN OF DUMP ===");
            Thread[] threadArr = new Thread[Thread.activeCount()];
            int iEnumerate = Thread.enumerate(threadArr);
            for (int i10 = 0; i10 < iEnumerate; i10++) {
                Thread thread = threadArr[i10];
                if (h1(thread)) {
                    e0().println("Thread: " + thread.getName());
                    StackTraceElement[] stackTrace = thread.getStackTrace();
                    int length = stackTrace.length;
                    for (int i11 = 0; i11 < length; i11++) {
                        StackTraceElement stackTraceElement = stackTrace[i11];
                        e0().println("\tat " + stackTraceElement);
                    }
                }
            }
            e0().println("=== END OF DUMP ===");
        } catch (InterruptedException e10) {
            e10.printStackTrace(e0());
        }
    }

    public void m1(Transaction transaction) {
        synchronized (this.f34311l) {
            try {
                this.f34311l.remove(transaction);
                if (!I0()) {
                    this.f34311l.notifyAll();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void n() {
        Iterator<Q8.a<?>> it = this.f34310k.values().iterator();
        while (it.hasNext()) {
            it.next().a();
        }
    }

    public native long nativeDbSize(long j10);

    public native long nativeDbSizeOnDisk(long j10);

    public native long nativePanicModeRemoveAllObjects(long j10, int i10);

    public native long nativeValidate(long j10, long j11, boolean z10);
}
