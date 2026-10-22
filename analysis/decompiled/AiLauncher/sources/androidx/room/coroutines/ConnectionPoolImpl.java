package androidx.room.coroutines;

import Y8.t;
import android.database.SQLException;
import androidx.exifinterface.media.ExifInterface;
import androidx.room.coroutines.ConnectionPoolImpl;
import b1.C1445d;
import c1.C1485a;
import c1.C1486b;
import com.autonavi.aps.amapapi.config.Const;
import i1.C4159a;
import i1.InterfaceC4160b;
import i1.InterfaceC4161c;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.coroutines.d;
import kotlin.jvm.internal.p;
import kotlin.time.DurationUnit;
import kotlin.time.a;
import kotlin.time.b;
import p9.InterfaceC5063a;

@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000f\b\u0000\u0018\u00002\u00020\u0001B!\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tB1\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\n\u001a\u00020\u0006\u0012\u0006\u0010\u000b\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\fJB\u0010\u0015\u001a\u00028\u0000\"\u0004\b\u0000\u0010\r2\u0006\u0010\u000f\u001a\u00020\u000e2\"\u0010\u0014\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\u0011\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u00130\u0010H\u0096@¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0018\u001a\u00020\u0017H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u0017\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001b\u001a\u00020\u001aH\u0002¢\u0006\u0004\b\u001d\u0010\u001eJ\u0017\u0010\u001f\u001a\u00020\u00172\u0006\u0010\u000f\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u001f\u0010 R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b!\u0010\"R\u0014\u0010&\u001a\u00020#8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b$\u0010%R\u0014\u0010(\u001a\u00020#8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b'\u0010%R\u0014\u0010,\u001a\u00020)8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b*\u0010+R$\u00101\u001a\u0012\u0012\u0004\u0012\u00020\u001a0-j\b\u0012\u0004\u0012\u00020\u001a`.8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b/\u00100R\u0016\u00104\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b2\u00103R\"\u0010<\u001a\u0002058\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b6\u00107\u001a\u0004\b8\u00109\"\u0004\b:\u0010;R\"\u0010C\u001a\u00020\u00068\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b=\u0010>\u001a\u0004\b?\u0010@\"\u0004\bA\u0010B¨\u0006D"}, d2 = {"Landroidx/room/coroutines/ConnectionPoolImpl;", "Landroidx/room/coroutines/ConnectionPool;", "Li1/c;", "driver", "", "fileName", "", "preparedStatementCacheSize", "<init>", "(Li1/c;Ljava/lang/String;I)V", "maxNumOfReaders", "maxNumOfWriters", "(Li1/c;Ljava/lang/String;III)V", "R", "", "isReadOnly", "Lkotlin/Function2;", "Landroidx/room/Transactor;", "Le9/c;", "", "block", "y", "(ZLp9/p;Le9/c;)Ljava/lang/Object;", "LY8/t;", "close", "()V", "Landroidx/room/coroutines/PooledConnectionImpl;", "connection", "Lkotlin/coroutines/d;", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "(Landroidx/room/coroutines/PooledConnectionImpl;)Lkotlin/coroutines/d;", "G", "(Z)V", Const.INTENT_KEY_APIKEY, "Li1/c;", "Landroidx/room/coroutines/Pool;", Const.INTENT_KEY_PKGNAME, "Landroidx/room/coroutines/Pool;", "readers", "c", "writers", "Lc1/b;", Const.INTENT_KEY_UMID, "Lc1/b;", "connectionElementKey", "Ljava/lang/ThreadLocal;", "Landroidx/room/concurrent/ThreadLocal;", "e", "Ljava/lang/ThreadLocal;", "connectionThreadLocal", "f", "Z", "isClosed", "Lkotlin/time/a;", Const.INTENT_KEY_BACKGROUND_COMMAND, "J", "getTimeout-UwyO8pc$room_runtime", "()J", "setTimeout-LRDsOJo$room_runtime", "(J)V", "timeout", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "I", "getOnTimeout$room_runtime", "()I", "setOnTimeout$room_runtime", "(I)V", "onTimeout", "room-runtime"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes.dex */
public final class ConnectionPoolImpl implements ConnectionPool {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final InterfaceC4161c driver;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final Pool readers;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public final Pool writers;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public final C1486b connectionElementKey;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    public final ThreadLocal<PooledConnectionImpl> connectionThreadLocal;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    public volatile boolean isClosed;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    public long timeout;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    public int onTimeout;

    public ConnectionPoolImpl(final InterfaceC4161c driver, final String fileName, int i10) {
        p.i(driver, "driver");
        p.i(fileName, "fileName");
        this.connectionElementKey = new C1486b();
        this.connectionThreadLocal = new ThreadLocal<>();
        a.Companion companion = a.INSTANCE;
        this.timeout = b.s(30, DurationUnit.SECONDS);
        this.onTimeout = 2;
        this.driver = driver;
        Pool pool = new Pool(1, new InterfaceC5063a() { // from class: c1.f
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return ConnectionPoolImpl.l(driver, fileName);
            }
        }, i10);
        this.readers = pool;
        this.writers = pool;
    }

    public static final t J(ConnectionPoolImpl connectionPoolImpl, boolean z10) {
        connectionPoolImpl.G(z10);
        return t.f7040a;
    }

    public static final InterfaceC4160b l(InterfaceC4161c interfaceC4161c, String str) {
        return interfaceC4161c.a(str);
    }

    public static final InterfaceC4160b m(InterfaceC4161c interfaceC4161c, String str) {
        InterfaceC4160b interfaceC4160bA = interfaceC4161c.a(str);
        C4159a.a(interfaceC4160bA, "PRAGMA query_only = 1");
        return interfaceC4160bA;
    }

    public static final InterfaceC4160b n(InterfaceC4161c interfaceC4161c, String str) {
        return interfaceC4161c.a(str);
    }

    public final d A(PooledConnectionImpl connection) {
        return new C1485a(this.connectionElementKey, connection).plus(C1445d.a(this.connectionThreadLocal, connection));
    }

    public final void G(boolean isReadOnly) {
        String str = isReadOnly ? "reader" : "writer";
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Timed out attempting to acquire a " + str + " connection.");
        sb2.append('\n');
        sb2.append('\n');
        sb2.append("Writer pool:");
        sb2.append('\n');
        this.writers.d(sb2);
        sb2.append("Reader pool:");
        sb2.append('\n');
        this.readers.d(sb2);
        try {
            C4159a.b(5, sb2.toString());
            throw new KotlinNothingValueException();
        } catch (SQLException e10) {
            int i10 = this.onTimeout;
            if (i10 == 1) {
                throw e10;
            }
            if (i10 != 2) {
                return;
            }
            e10.printStackTrace();
        }
    }

    @Override // androidx.room.coroutines.ConnectionPool, java.lang.AutoCloseable
    public void close() {
        if (this.isClosed) {
            return;
        }
        this.isClosed = true;
        this.readers.c();
        this.writers.c();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:71:0x013c A[Catch: all -> 0x0176, TRY_LEAVE, TryCatch #2 {all -> 0x0176, blocks: (B:64:0x0121, B:69:0x0131, B:71:0x013c, B:81:0x017a, B:82:0x0181), top: B:101:0x0121 }] */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0164  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x001b  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x017a A[Catch: all -> 0x0176, TRY_ENTER, TryCatch #2 {all -> 0x0176, blocks: (B:64:0x0121, B:69:0x0131, B:71:0x013c, B:81:0x017a, B:82:0x0181), top: B:101:0x0121 }] */
    /* JADX WARN: Type inference failed for: r1v10, types: [T, androidx.room.coroutines.PooledConnectionImpl] */
    @Override // androidx.room.coroutines.ConnectionPool
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public <R> java.lang.Object y(boolean r18, p9.p<? super androidx.room.Transactor, ? super e9.InterfaceC4014c<? super R>, ? extends java.lang.Object> r19, e9.InterfaceC4014c<? super R> r20) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 434
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.room.coroutines.ConnectionPoolImpl.y(boolean, p9.p, e9.c):java.lang.Object");
    }

    public ConnectionPoolImpl(final InterfaceC4161c driver, final String fileName, int i10, int i11, int i12) {
        p.i(driver, "driver");
        p.i(fileName, "fileName");
        this.connectionElementKey = new C1486b();
        this.connectionThreadLocal = new ThreadLocal<>();
        a.Companion companion = a.INSTANCE;
        this.timeout = b.s(30, DurationUnit.SECONDS);
        this.onTimeout = 2;
        if (i10 <= 0) {
            throw new IllegalArgumentException("Maximum number of readers must be greater than 0");
        }
        if (i11 > 0) {
            this.driver = driver;
            this.readers = new Pool(i10, new InterfaceC5063a() { // from class: c1.c
                @Override // p9.InterfaceC5063a
                public final Object invoke() {
                    return ConnectionPoolImpl.m(driver, fileName);
                }
            }, i12);
            this.writers = new Pool(i11, new InterfaceC5063a() { // from class: c1.d
                @Override // p9.InterfaceC5063a
                public final Object invoke() {
                    return ConnectionPoolImpl.n(driver, fileName);
                }
            }, i12);
            return;
        }
        throw new IllegalArgumentException("Maximum number of writers must be greater than 0");
    }
}
