package androidx.room.support;

import Ua.C1060i;
import Ua.M;
import Y8.t;
import android.os.SystemClock;
import androidx.exifinterface.media.ExifInterface;
import androidx.room.support.AutoCloser;
import com.autonavi.aps.amapapi.config.Const;
import j1.InterfaceC4756c;
import j1.InterfaceC4757d;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;
import kotlinx.coroutines.g;
import p9.InterfaceC5063a;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u0000 \r2\u00020\u0001:\u0002%#B!\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u0015\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\r\u0010\u000eJ\u0015\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\b\u0011\u0010\u0012J'\u0010\u0017\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u00132\u0012\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00028\u00000\u0014¢\u0006\u0004\b\u0017\u0010\u0018J\r\u0010\u0019\u001a\u00020\u0015¢\u0006\u0004\b\u0019\u0010\u001aJ\r\u0010\u001b\u001a\u00020\f¢\u0006\u0004\b\u001b\u0010\u001cJ\r\u0010\u001d\u001a\u00020\f¢\u0006\u0004\b\u001d\u0010\u001cJ\u001b\u0010 \u001a\u00020\f2\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\f0\u001e¢\u0006\u0004\b \u0010!J\u000f\u0010\"\u001a\u00020\fH\u0002¢\u0006\u0004\b\"\u0010\u001cR\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b#\u0010$R\u0016\u0010\u000b\u001a\u00020\n8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b%\u0010&R\u0016\u0010\u0010\u001a\u00020\u000f8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b'\u0010(R\u001e\u0010+\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u001e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b)\u0010*R\u0014\u0010-\u001a\u00020\u00018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\"\u0010,R\u0014\u0010/\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010.R\u0014\u00102\u001a\u0002008\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001b\u00101R\u0016\u00105\u001a\u0002038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0017\u00104R$\u0010:\u001a\u0004\u0018\u00010\u00158\u0000@\u0000X\u0081\u000e¢\u0006\u0012\n\u0004\b6\u00107\u001a\u0004\b6\u0010\u001a\"\u0004\b8\u00109R\u0016\u0010=\u001a\u00020;8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0019\u0010<R\u0018\u0010@\u001a\u0004\u0018\u00010>8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010?R\u0011\u0010C\u001a\u00020;8F¢\u0006\u0006\u001a\u0004\bA\u0010B¨\u0006D"}, d2 = {"Landroidx/room/support/AutoCloser;", "", "", "timeoutAmount", "Ljava/util/concurrent/TimeUnit;", "timeUnit", "Landroidx/room/support/AutoCloser$b;", "watch", "<init>", "(JLjava/util/concurrent/TimeUnit;Landroidx/room/support/AutoCloser$b;)V", "Lj1/d;", "delegateOpenHelper", "LY8/t;", "l", "(Lj1/d;)V", "LUa/M;", "coroutineScope", "k", "(LUa/M;)V", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "Lkotlin/Function1;", "Lj1/c;", "block", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "(Lp9/l;)Ljava/lang/Object;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "()Lj1/c;", Const.INTENT_KEY_BACKGROUND_COMMAND, "()V", "f", "Lkotlin/Function0;", "onAutoClose", "n", "(Lp9/a;)V", "e", Const.INTENT_KEY_APIKEY, "Landroidx/room/support/AutoCloser$b;", Const.INTENT_KEY_PKGNAME, "Lj1/d;", "c", "LUa/M;", Const.INTENT_KEY_UMID, "Lp9/a;", "onAutoCloseCallback", "Ljava/lang/Object;", "lock", "J", "autoCloseTimeoutInMs", "Ljava/util/concurrent/atomic/AtomicInteger;", "Ljava/util/concurrent/atomic/AtomicInteger;", "referenceCount", "Ljava/util/concurrent/atomic/AtomicLong;", "Ljava/util/concurrent/atomic/AtomicLong;", "lastDecrementRefCountTimeStamp", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "Lj1/c;", "setDelegateDatabase$room_runtime", "(Lj1/c;)V", "delegateDatabase", "", "Z", "manuallyClosed", "Lkotlinx/coroutines/g;", "Lkotlinx/coroutines/g;", "autoCloseJob", "m", "()Z", "isActive", "room-runtime"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes.dex */
public final class AutoCloser {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final b watch;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public InterfaceC4757d delegateOpenHelper;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public M coroutineScope;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public InterfaceC5063a<t> onAutoCloseCallback;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    public final Object lock;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    public final long autoCloseTimeoutInMs;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    public final AtomicInteger referenceCount;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    public AtomicLong lastDecrementRefCountTimeStamp;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    public InterfaceC4756c delegateDatabase;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    public boolean manuallyClosed;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    public g autoCloseJob;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0003\bæ\u0080\u0001\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0005À\u0006\u0001"}, d2 = {"Landroidx/room/support/AutoCloser$b;", "", "", Const.INTENT_KEY_APIKEY, "()J", "room-runtime"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public interface b {
        long a();
    }

    public AutoCloser(long j10, TimeUnit timeUnit, b watch) {
        p.i(timeUnit, "timeUnit");
        p.i(watch, "watch");
        this.watch = watch;
        this.lock = new Object();
        this.autoCloseTimeoutInMs = timeUnit.toMillis(j10);
        this.referenceCount = new AtomicInteger(0);
        this.lastDecrementRefCountTimeStamp = new AtomicLong(watch.a());
    }

    public static final long b() {
        return SystemClock.uptimeMillis();
    }

    public final void e() {
        synchronized (this.lock) {
            try {
                if (this.watch.a() - this.lastDecrementRefCountTimeStamp.get() < this.autoCloseTimeoutInMs) {
                    return;
                }
                if (this.referenceCount.get() != 0) {
                    return;
                }
                InterfaceC5063a<t> interfaceC5063a = this.onAutoCloseCallback;
                if (interfaceC5063a == null) {
                    throw new IllegalStateException("onAutoCloseCallback is null but it should  have been set before use. Please file a bug against Room at: https://issuetracker.google.com/issues/new?component=413107&template=1096568");
                }
                interfaceC5063a.invoke();
                InterfaceC4756c interfaceC4756c = this.delegateDatabase;
                if (interfaceC4756c != null && interfaceC4756c.isOpen()) {
                    interfaceC4756c.close();
                }
                this.delegateDatabase = null;
                t tVar = t.f7040a;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void f() {
        synchronized (this.lock) {
            try {
                this.manuallyClosed = true;
                g gVar = this.autoCloseJob;
                if (gVar != null) {
                    g.Y0(gVar, null, 1, null);
                }
                this.autoCloseJob = null;
                InterfaceC4756c interfaceC4756c = this.delegateDatabase;
                if (interfaceC4756c != null) {
                    interfaceC4756c.close();
                }
                this.delegateDatabase = null;
                t tVar = t.f7040a;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void g() {
        M m10;
        int iDecrementAndGet = this.referenceCount.decrementAndGet();
        if (iDecrementAndGet < 0) {
            throw new IllegalStateException("Unbalanced reference count.");
        }
        this.lastDecrementRefCountTimeStamp.set(this.watch.a());
        if (iDecrementAndGet == 0) {
            M m11 = this.coroutineScope;
            if (m11 == null) {
                p.A("coroutineScope");
                m10 = null;
            } else {
                m10 = m11;
            }
            this.autoCloseJob = C1060i.d(m10, null, null, new AutoCloser$decrementCountAndScheduleClose$2(this, null), 3, null);
        }
    }

    public final <V> V h(InterfaceC5074l<? super InterfaceC4756c, ? extends V> block) {
        p.i(block, "block");
        try {
            return block.invoke(j());
        } finally {
            g();
        }
    }

    /* renamed from: i, reason: from getter */
    public final InterfaceC4756c getDelegateDatabase() {
        return this.delegateDatabase;
    }

    public final InterfaceC4756c j() {
        g gVar = this.autoCloseJob;
        InterfaceC4757d interfaceC4757d = null;
        if (gVar != null) {
            g.Y0(gVar, null, 1, null);
        }
        this.autoCloseJob = null;
        this.referenceCount.incrementAndGet();
        if (this.manuallyClosed) {
            throw new IllegalStateException("Attempting to open already closed database.");
        }
        synchronized (this.lock) {
            InterfaceC4756c interfaceC4756c = this.delegateDatabase;
            if (interfaceC4756c != null && interfaceC4756c.isOpen()) {
                return interfaceC4756c;
            }
            InterfaceC4757d interfaceC4757d2 = this.delegateOpenHelper;
            if (interfaceC4757d2 == null) {
                p.A("delegateOpenHelper");
            } else {
                interfaceC4757d = interfaceC4757d2;
            }
            InterfaceC4756c writableDatabase = interfaceC4757d.getWritableDatabase();
            this.delegateDatabase = writableDatabase;
            return writableDatabase;
        }
    }

    public final void k(M coroutineScope) {
        p.i(coroutineScope, "coroutineScope");
        this.coroutineScope = coroutineScope;
    }

    public final void l(InterfaceC4757d delegateOpenHelper) {
        p.i(delegateOpenHelper, "delegateOpenHelper");
        if (delegateOpenHelper instanceof AutoClosingRoomOpenHelper) {
            throw new IllegalArgumentException("Failed requirement.");
        }
        this.delegateOpenHelper = delegateOpenHelper;
    }

    public final boolean m() {
        return !this.manuallyClosed;
    }

    public final void n(InterfaceC5063a<t> onAutoClose) {
        p.i(onAutoClose, "onAutoClose");
        this.onAutoCloseCallback = onAutoClose;
    }

    public /* synthetic */ AutoCloser(long j10, TimeUnit timeUnit, b bVar, int i10, i iVar) {
        this(j10, timeUnit, (i10 & 4) != 0 ? new b() { // from class: e1.a
            @Override // androidx.room.support.AutoCloser.b
            public final long a() {
                return AutoCloser.b();
            }
        } : bVar);
    }
}
