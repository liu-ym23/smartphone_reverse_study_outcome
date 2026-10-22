package androidx.room.coroutines;

import C7.r;
import D7.v;
import H7.c;
import H7.h;
import S0.b;
import androidx.sqlite.SQLiteConnection;
import androidx.sqlite.SQLiteStatement;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import j9.m;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.k;
import v9.InterfaceC2073b;
import w9.InterfaceC2108a;

@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u000b\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u0019\u0012\u0006\u0010\u0003\u001a\u00020\u0001\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0015\u0010\t\u001a\u00020\u00002\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ\r\u0010\u000b\u001a\u00020\u0000¢\u0006\u0004\b\u000b\u0010\fJ\u0019\u0010\u0011\u001a\u00020\u00102\n\u0010\u000f\u001a\u00060\rj\u0002`\u000e¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0014\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0017\u001a\u00020\u0016H\u0096\u0001¢\u0006\u0004\b\u0017\u0010\u0018J\u0018\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u0019\u001a\u00020\u0013H\u0096\u0001¢\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u001d\u001a\u00020\u0010H\u0096\u0001¢\u0006\u0004\b\u001d\u0010\u001eJ\u0018\u0010!\u001a\u00020\u00162\u0006\u0010 \u001a\u00020\u001fH\u0096\u0001¢\u0006\u0004\b!\u0010\"J\u001a\u0010\u0004\u001a\u00020\u00102\b\u0010 \u001a\u0004\u0018\u00010\u001fH\u0096A¢\u0006\u0004\b\u0004\u0010#J\u001a\u0010$\u001a\u00020\u00162\b\u0010 \u001a\u0004\u0018\u00010\u001fH\u0096\u0001¢\u0006\u0004\b$\u0010\"J\u001a\u0010%\u001a\u00020\u00102\b\u0010 \u001a\u0004\u0018\u00010\u001fH\u0096\u0001¢\u0006\u0004\b%\u0010&R\u0014\u0010\u0003\u001a\u00020\u00018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010'R\u0014\u0010\u0004\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010(R\u0018\u0010)\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b)\u0010*R\u0018\u0010,\u001a\u0004\u0018\u00010+8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b,\u0010-R\u0014\u0010.\u001a\u00020\u00168\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\b.\u0010\u0018R\"\u00102\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u001f\u0012\u0004\u0012\u00020\u00020/8\u0016X\u0097\u0005¢\u0006\u0006\u001a\u0004\b0\u00101¨\u00063"}, d2 = {"Landroidx/room/coroutines/ConnectionWithLock;", "Landroidx/sqlite/SQLiteConnection;", "Lw9/a;", "delegate", "lock", AppAgent.CONSTRUCT, "(Landroidx/sqlite/SQLiteConnection;Lw9/a;)V", "LH7/h;", "context", "markAcquired", "(LH7/h;)Landroidx/room/coroutines/ConnectionWithLock;", "markReleased", "()Landroidx/room/coroutines/ConnectionWithLock;", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "builder", "LC7/r;", "dump", "(Ljava/lang/StringBuilder;)V", "", "toString", "()Ljava/lang/String;", "", "inTransaction", "()Z", "sql", "Landroidx/sqlite/SQLiteStatement;", "prepare", "(Ljava/lang/String;)Landroidx/sqlite/SQLiteStatement;", "close", "()V", "", "owner", "holdsLock", "(Ljava/lang/Object;)Z", "(Ljava/lang/Object;LH7/c;)Ljava/lang/Object;", "tryLock", "unlock", "(Ljava/lang/Object;)V", "Landroidx/sqlite/SQLiteConnection;", "Lw9/a;", "acquireCoroutineContext", "LH7/h;", "", "acquireThrowable", "Ljava/lang/Throwable;", "isLocked", "Lv9/b;", "getOnLock", "()Lv9/b;", "onLock", "room-runtime"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
final class ConnectionWithLock implements SQLiteConnection, InterfaceC2108a {
    private h acquireCoroutineContext;
    private Throwable acquireThrowable;
    private final SQLiteConnection delegate;
    private final InterfaceC2108a lock;

    public ConnectionWithLock(SQLiteConnection sQLiteConnection, InterfaceC2108a interfaceC2108a, int i, e eVar) {
        this(sQLiteConnection, (i & 2) != 0 ? new kotlinx.coroutines.sync.a() : interfaceC2108a);
    }

    @Override // androidx.sqlite.SQLiteConnection, java.lang.AutoCloseable
    public void close() {
        this.delegate.close();
    }

    public final void dump(StringBuilder builder) {
        k.f(builder, "builder");
        if (this.acquireCoroutineContext == null && this.acquireThrowable == null) {
            builder.append("\t\tStatus: Free connection");
            builder.append('\n');
            return;
        }
        builder.append("\t\tStatus: Acquired connection");
        builder.append('\n');
        h hVar = this.acquireCoroutineContext;
        if (hVar != null) {
            builder.append("\t\tCoroutine: " + hVar);
            builder.append('\n');
        }
        Throwable th = this.acquireThrowable;
        if (th != null) {
            builder.append("\t\tAcquired:");
            builder.append('\n');
            Iterator it = v.w0(m.w0(b.p1(th)), 1).iterator();
            while (it.hasNext()) {
                builder.append("\t\t" + ((String) it.next()));
                builder.append('\n');
            }
        }
    }

    @Override // w9.InterfaceC2108a
    public InterfaceC2073b getOnLock() {
        return this.lock.getOnLock();
    }

    @Override // w9.InterfaceC2108a
    public boolean holdsLock(Object owner) {
        k.f(owner, "owner");
        return this.lock.holdsLock(owner);
    }

    @Override // androidx.sqlite.SQLiteConnection
    public boolean inTransaction() {
        return this.delegate.inTransaction();
    }

    @Override // w9.InterfaceC2108a
    public boolean isLocked() {
        return this.lock.isLocked();
    }

    @Override // w9.InterfaceC2108a
    public Object lock(Object obj, c<? super r> cVar) {
        return this.lock.lock(obj, cVar);
    }

    public final ConnectionWithLock markAcquired(h context) {
        k.f(context, "context");
        this.acquireCoroutineContext = context;
        this.acquireThrowable = new Throwable();
        return this;
    }

    public final ConnectionWithLock markReleased() {
        this.acquireCoroutineContext = null;
        this.acquireThrowable = null;
        return this;
    }

    @Override // androidx.sqlite.SQLiteConnection
    public SQLiteStatement prepare(String sql) {
        k.f(sql, "sql");
        return this.delegate.prepare(sql);
    }

    public String toString() {
        return this.delegate.toString();
    }

    @Override // w9.InterfaceC2108a
    public boolean tryLock(Object owner) {
        return this.lock.tryLock(owner);
    }

    @Override // w9.InterfaceC2108a
    public void unlock(Object owner) {
        this.lock.unlock(owner);
    }

    public ConnectionWithLock(SQLiteConnection delegate, InterfaceC2108a lock) {
        k.f(delegate, "delegate");
        k.f(lock, "lock");
        this.delegate = delegate;
        this.lock = lock;
    }
}
