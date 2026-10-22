package androidx.room.coroutines;

import D7.p;
import H7.c;
import S7.n;
import androidx.exifinterface.media.ExifInterface;
import androidx.room.TransactionScope;
import androidx.room.Transactor;
import androidx.room.concurrent.ThreadLocal_jvmAndroidKt;
import androidx.sqlite.SQLite;
import androidx.sqlite.SQLiteConnection;
import androidx.sqlite.SQLiteStatement;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002:\u0003>?@B\u001f\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nJJ\u0010\u0013\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u000b2\b\u0010\r\u001a\u0004\u0018\u00010\f2(\u0010\u0012\u001a$\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u000f\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u00110\u000eH\u0082@¢\u0006\u0004\b\u0013\u0010\u0014J\u0018\u0010\u0016\u001a\u00020\u00152\u0006\u0010\r\u001a\u00020\fH\u0082@¢\u0006\u0004\b\u0016\u0010\u0017J\u0018\u0010\u0019\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u0007H\u0082@¢\u0006\u0004\b\u0019\u0010\u001aJ$\u0010\u001c\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u000b2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00000\u001bH\u0082H¢\u0006\u0004\b\u001c\u0010\u001dJ2\u0010\"\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u000b2\u0006\u0010\u001f\u001a\u00020\u001e2\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020!\u0012\u0004\u0012\u00028\u00000 H\u0096@¢\u0006\u0004\b\"\u0010#JH\u0010$\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u000b2\u0006\u0010\r\u001a\u00020\f2(\u0010\u0012\u001a$\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u000f\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u00110\u000eH\u0096@¢\u0006\u0004\b$\u0010\u0014J\u0010\u0010%\u001a\u00020\u0007H\u0096@¢\u0006\u0004\b%\u0010&J\r\u0010'\u001a\u00020\u0015¢\u0006\u0004\b'\u0010(R\u0017\u0010\u0004\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\u0004\u0010)\u001a\u0004\b*\u0010+R\u0017\u0010\u0006\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u0006\u0010,\u001a\u0004\b-\u0010.R\u0017\u0010\b\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\b\u0010/\u001a\u0004\b\b\u00100R\u001a\u00103\u001a\b\u0012\u0004\u0012\u000202018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b3\u00104R\u0018\u00107\u001a\u000605j\u0002`68\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b7\u00108R\u0014\u00109\u001a\u00020\u00078BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b9\u00100R\u0014\u0010=\u001a\u00020:8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b;\u0010<¨\u0006A"}, d2 = {"Landroidx/room/coroutines/PooledConnectionImpl;", "Landroidx/room/Transactor;", "Landroidx/room/coroutines/RawConnectionAccessor;", "Landroidx/room/coroutines/ConnectionElementKey;", "connectionElementKey", "Landroidx/room/coroutines/ConnectionWithLock;", "delegate", "", "isReadOnly", AppAgent.CONSTRUCT, "(Landroidx/room/coroutines/ConnectionElementKey;Landroidx/room/coroutines/ConnectionWithLock;Z)V", "R", "Landroidx/room/Transactor$SQLiteTransactionType;", "type", "Lkotlin/Function2;", "Landroidx/room/TransactionScope;", "LH7/c;", "", "block", "transaction", "(Landroidx/room/Transactor$SQLiteTransactionType;LS7/n;LH7/c;)Ljava/lang/Object;", "LC7/r;", "beginTransaction", "(Landroidx/room/Transactor$SQLiteTransactionType;LH7/c;)Ljava/lang/Object;", "success", "endTransaction", "(ZLH7/c;)Ljava/lang/Object;", "Lkotlin/Function0;", "withStateCheck", "(LS7/a;LH7/c;)Ljava/lang/Object;", "", "sql", "Lkotlin/Function1;", "Landroidx/sqlite/SQLiteStatement;", "usePrepared", "(Ljava/lang/String;LS7/k;LH7/c;)Ljava/lang/Object;", "withTransaction", "inTransaction", "(LH7/c;)Ljava/lang/Object;", "markRecycled", "()V", "Landroidx/room/coroutines/ConnectionElementKey;", "getConnectionElementKey", "()Landroidx/room/coroutines/ConnectionElementKey;", "Landroidx/room/coroutines/ConnectionWithLock;", "getDelegate", "()Landroidx/room/coroutines/ConnectionWithLock;", "Z", "()Z", "LD7/p;", "Landroidx/room/coroutines/PooledConnectionImpl$TransactionItem;", "transactionStack", "LD7/p;", "Ljava/util/concurrent/atomic/AtomicBoolean;", "Landroidx/room/concurrent/AtomicBoolean;", "_isRecycled", "Ljava/util/concurrent/atomic/AtomicBoolean;", "isRecycled", "Landroidx/sqlite/SQLiteConnection;", "getRawConnection", "()Landroidx/sqlite/SQLiteConnection;", "rawConnection", "TransactionItem", "TransactionImpl", "StatementWrapper", "room-runtime"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
final class PooledConnectionImpl implements Transactor, RawConnectionAccessor {
    private final AtomicBoolean _isRecycled;
    private final ConnectionElementKey connectionElementKey;
    private final ConnectionWithLock delegate;
    private final boolean isReadOnly;
    private final p transactionStack;

    @Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0011\b\u0082\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0003\u0010\u0004J$\u0010\b\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u00052\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006H\u0082\b¢\u0006\u0004\b\b\u0010\tJ\u001f\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u001f\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u001f\u0010\u0015\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u0014H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u001f\u0010\u0018\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u0017H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u0017\u0010\u001a\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ\u0017\u0010\u001c\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u001c\u0010\u001dJ\u0017\u0010\u001e\u001a\u00020\u00112\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u001e\u0010\u001fJ\u0017\u0010 \u001a\u00020\u00142\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b \u0010!J\u0017\u0010\"\u001a\u00020\u00172\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\"\u0010#J\u0017\u0010%\u001a\u00020$2\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b%\u0010&J\u000f\u0010'\u001a\u00020\nH\u0016¢\u0006\u0004\b'\u0010(J\u0017\u0010)\u001a\u00020\u00172\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b)\u0010#J\u0017\u0010*\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b*\u0010+J\u000f\u0010,\u001a\u00020$H\u0016¢\u0006\u0004\b,\u0010-J\u000f\u0010.\u001a\u00020\u000eH\u0016¢\u0006\u0004\b.\u0010/J\u000f\u00100\u001a\u00020\u000eH\u0016¢\u0006\u0004\b0\u0010/J\u000f\u00101\u001a\u00020\u000eH\u0016¢\u0006\u0004\b1\u0010/R\u0014\u0010\u0002\u001a\u00020\u00018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0002\u00102R\u0014\u00103\u001a\u00020\u00148\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b3\u00104¨\u00065"}, d2 = {"Landroidx/room/coroutines/PooledConnectionImpl$StatementWrapper;", "Landroidx/sqlite/SQLiteStatement;", "delegate", AppAgent.CONSTRUCT, "(Landroidx/room/coroutines/PooledConnectionImpl;Landroidx/sqlite/SQLiteStatement;)V", "R", "Lkotlin/Function0;", "block", "withStateCheck", "(LS7/a;)Ljava/lang/Object;", "", "index", "", "value", "LC7/r;", "bindBlob", "(I[B)V", "", "bindDouble", "(ID)V", "", "bindLong", "(IJ)V", "", "bindText", "(ILjava/lang/String;)V", "bindNull", "(I)V", "getBlob", "(I)[B", "getDouble", "(I)D", "getLong", "(I)J", "getText", "(I)Ljava/lang/String;", "", "isNull", "(I)Z", "getColumnCount", "()I", "getColumnName", "getColumnType", "(I)I", "step", "()Z", "reset", "()V", "clearBindings", "close", "Landroidx/sqlite/SQLiteStatement;", "threadId", "J", "room-runtime"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public final class StatementWrapper implements SQLiteStatement {
        private final SQLiteStatement delegate;
        final /* synthetic */ PooledConnectionImpl this$0;
        private final long threadId;

        public StatementWrapper(PooledConnectionImpl pooledConnectionImpl, SQLiteStatement delegate) {
            k.f(delegate, "delegate");
            this.this$0 = pooledConnectionImpl;
            this.delegate = delegate;
            this.threadId = ThreadLocal_jvmAndroidKt.currentThreadId();
        }

        private final <R> R withStateCheck(S7.a block) {
            if (this.this$0.isRecycled()) {
                throw androidx.constraintlayout.core.dsl.a.m(21, "Statement is recycled");
            }
            if (this.threadId == ThreadLocal_jvmAndroidKt.currentThreadId()) {
                return (R) block.invoke();
            }
            throw androidx.constraintlayout.core.dsl.a.m(21, "Attempted to use statement on a different thread");
        }

        @Override // androidx.sqlite.SQLiteStatement
        /* renamed from: bindBlob */
        public void mo7168bindBlob(int index, byte[] value) {
            k.f(value, "value");
            if (this.this$0.isRecycled()) {
                throw androidx.constraintlayout.core.dsl.a.m(21, "Statement is recycled");
            }
            if (this.threadId != ThreadLocal_jvmAndroidKt.currentThreadId()) {
                throw androidx.constraintlayout.core.dsl.a.m(21, "Attempted to use statement on a different thread");
            }
            this.delegate.mo7168bindBlob(index, value);
        }

        @Override // androidx.sqlite.SQLiteStatement
        /* renamed from: bindDouble */
        public void mo7169bindDouble(int index, double value) {
            if (this.this$0.isRecycled()) {
                throw androidx.constraintlayout.core.dsl.a.m(21, "Statement is recycled");
            }
            if (this.threadId != ThreadLocal_jvmAndroidKt.currentThreadId()) {
                throw androidx.constraintlayout.core.dsl.a.m(21, "Attempted to use statement on a different thread");
            }
            this.delegate.mo7169bindDouble(index, value);
        }

        @Override // androidx.sqlite.SQLiteStatement
        /* renamed from: bindLong */
        public void mo7170bindLong(int index, long value) {
            if (this.this$0.isRecycled()) {
                throw androidx.constraintlayout.core.dsl.a.m(21, "Statement is recycled");
            }
            if (this.threadId != ThreadLocal_jvmAndroidKt.currentThreadId()) {
                throw androidx.constraintlayout.core.dsl.a.m(21, "Attempted to use statement on a different thread");
            }
            this.delegate.mo7170bindLong(index, value);
        }

        @Override // androidx.sqlite.SQLiteStatement
        /* renamed from: bindNull */
        public void mo7171bindNull(int index) {
            if (this.this$0.isRecycled()) {
                throw androidx.constraintlayout.core.dsl.a.m(21, "Statement is recycled");
            }
            if (this.threadId != ThreadLocal_jvmAndroidKt.currentThreadId()) {
                throw androidx.constraintlayout.core.dsl.a.m(21, "Attempted to use statement on a different thread");
            }
            this.delegate.mo7171bindNull(index);
        }

        @Override // androidx.sqlite.SQLiteStatement
        /* renamed from: bindText */
        public void mo7172bindText(int index, String value) {
            k.f(value, "value");
            if (this.this$0.isRecycled()) {
                throw androidx.constraintlayout.core.dsl.a.m(21, "Statement is recycled");
            }
            if (this.threadId != ThreadLocal_jvmAndroidKt.currentThreadId()) {
                throw androidx.constraintlayout.core.dsl.a.m(21, "Attempted to use statement on a different thread");
            }
            this.delegate.mo7172bindText(index, value);
        }

        @Override // androidx.sqlite.SQLiteStatement
        /* renamed from: clearBindings */
        public void mo7173clearBindings() {
            if (this.this$0.isRecycled()) {
                throw androidx.constraintlayout.core.dsl.a.m(21, "Statement is recycled");
            }
            if (this.threadId != ThreadLocal_jvmAndroidKt.currentThreadId()) {
                throw androidx.constraintlayout.core.dsl.a.m(21, "Attempted to use statement on a different thread");
            }
            this.delegate.mo7173clearBindings();
        }

        @Override // androidx.sqlite.SQLiteStatement, java.lang.AutoCloseable
        public void close() {
            if (this.this$0.isRecycled()) {
                throw androidx.constraintlayout.core.dsl.a.m(21, "Statement is recycled");
            }
            if (this.threadId != ThreadLocal_jvmAndroidKt.currentThreadId()) {
                throw androidx.constraintlayout.core.dsl.a.m(21, "Attempted to use statement on a different thread");
            }
            this.delegate.close();
        }

        @Override // androidx.sqlite.SQLiteStatement
        public byte[] getBlob(int index) {
            if (this.this$0.isRecycled()) {
                throw androidx.constraintlayout.core.dsl.a.m(21, "Statement is recycled");
            }
            if (this.threadId == ThreadLocal_jvmAndroidKt.currentThreadId()) {
                return this.delegate.getBlob(index);
            }
            throw androidx.constraintlayout.core.dsl.a.m(21, "Attempted to use statement on a different thread");
        }

        @Override // androidx.sqlite.SQLiteStatement
        public int getColumnCount() {
            if (this.this$0.isRecycled()) {
                throw androidx.constraintlayout.core.dsl.a.m(21, "Statement is recycled");
            }
            if (this.threadId == ThreadLocal_jvmAndroidKt.currentThreadId()) {
                return this.delegate.getColumnCount();
            }
            throw androidx.constraintlayout.core.dsl.a.m(21, "Attempted to use statement on a different thread");
        }

        @Override // androidx.sqlite.SQLiteStatement
        public String getColumnName(int index) {
            if (this.this$0.isRecycled()) {
                throw androidx.constraintlayout.core.dsl.a.m(21, "Statement is recycled");
            }
            if (this.threadId == ThreadLocal_jvmAndroidKt.currentThreadId()) {
                return this.delegate.getColumnName(index);
            }
            throw androidx.constraintlayout.core.dsl.a.m(21, "Attempted to use statement on a different thread");
        }

        @Override // androidx.sqlite.SQLiteStatement
        public int getColumnType(int index) {
            if (this.this$0.isRecycled()) {
                throw androidx.constraintlayout.core.dsl.a.m(21, "Statement is recycled");
            }
            if (this.threadId == ThreadLocal_jvmAndroidKt.currentThreadId()) {
                return this.delegate.getColumnType(index);
            }
            throw androidx.constraintlayout.core.dsl.a.m(21, "Attempted to use statement on a different thread");
        }

        @Override // androidx.sqlite.SQLiteStatement
        public double getDouble(int index) {
            if (this.this$0.isRecycled()) {
                throw androidx.constraintlayout.core.dsl.a.m(21, "Statement is recycled");
            }
            if (this.threadId == ThreadLocal_jvmAndroidKt.currentThreadId()) {
                return this.delegate.getDouble(index);
            }
            throw androidx.constraintlayout.core.dsl.a.m(21, "Attempted to use statement on a different thread");
        }

        @Override // androidx.sqlite.SQLiteStatement
        public long getLong(int index) {
            if (this.this$0.isRecycled()) {
                throw androidx.constraintlayout.core.dsl.a.m(21, "Statement is recycled");
            }
            if (this.threadId == ThreadLocal_jvmAndroidKt.currentThreadId()) {
                return this.delegate.getLong(index);
            }
            throw androidx.constraintlayout.core.dsl.a.m(21, "Attempted to use statement on a different thread");
        }

        @Override // androidx.sqlite.SQLiteStatement
        public String getText(int index) {
            if (this.this$0.isRecycled()) {
                throw androidx.constraintlayout.core.dsl.a.m(21, "Statement is recycled");
            }
            if (this.threadId == ThreadLocal_jvmAndroidKt.currentThreadId()) {
                return this.delegate.getText(index);
            }
            throw androidx.constraintlayout.core.dsl.a.m(21, "Attempted to use statement on a different thread");
        }

        @Override // androidx.sqlite.SQLiteStatement
        public boolean isNull(int index) {
            if (this.this$0.isRecycled()) {
                throw androidx.constraintlayout.core.dsl.a.m(21, "Statement is recycled");
            }
            if (this.threadId == ThreadLocal_jvmAndroidKt.currentThreadId()) {
                return this.delegate.isNull(index);
            }
            throw androidx.constraintlayout.core.dsl.a.m(21, "Attempted to use statement on a different thread");
        }

        @Override // androidx.sqlite.SQLiteStatement
        public void reset() {
            if (this.this$0.isRecycled()) {
                throw androidx.constraintlayout.core.dsl.a.m(21, "Statement is recycled");
            }
            if (this.threadId != ThreadLocal_jvmAndroidKt.currentThreadId()) {
                throw androidx.constraintlayout.core.dsl.a.m(21, "Attempted to use statement on a different thread");
            }
            this.delegate.reset();
        }

        @Override // androidx.sqlite.SQLiteStatement
        public boolean step() {
            if (this.this$0.isRecycled()) {
                throw androidx.constraintlayout.core.dsl.a.m(21, "Statement is recycled");
            }
            if (this.threadId == ThreadLocal_jvmAndroidKt.currentThreadId()) {
                return this.delegate.step();
            }
            throw androidx.constraintlayout.core.dsl.a.m(21, "Attempted to use statement on a different thread");
        }
    }

    @Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0001\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0082\u0004\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u00022\u00020\u0003B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J2\u0010\f\u001a\u00028\u0001\"\u0004\b\u0001\u0010\u00062\u0006\u0010\b\u001a\u00020\u00072\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00028\u00010\tH\u0096@¢\u0006\u0004\b\f\u0010\rJ@\u0010\u0011\u001a\u00028\u0001\"\u0004\b\u0001\u0010\u00062(\u0010\u000b\u001a$\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u000f\u0012\u0006\u0012\u0004\u0018\u00010\u00100\u000eH\u0096@¢\u0006\u0004\b\u0011\u0010\u0012J\u0018\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0013\u001a\u00028\u0000H\u0096@¢\u0006\u0004\b\u0015\u0010\u0016R\u0014\u0010\u001a\u001a\u00020\u00178VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019¨\u0006\u001b"}, d2 = {"Landroidx/room/coroutines/PooledConnectionImpl$TransactionImpl;", ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/room/TransactionScope;", "Landroidx/room/coroutines/RawConnectionAccessor;", AppAgent.CONSTRUCT, "(Landroidx/room/coroutines/PooledConnectionImpl;)V", "R", "", "sql", "Lkotlin/Function1;", "Landroidx/sqlite/SQLiteStatement;", "block", "usePrepared", "(Ljava/lang/String;LS7/k;LH7/c;)Ljava/lang/Object;", "Lkotlin/Function2;", "LH7/c;", "", "withNestedTransaction", "(LS7/n;LH7/c;)Ljava/lang/Object;", "result", "", "rollback", "(Ljava/lang/Object;LH7/c;)Ljava/lang/Object;", "Landroidx/sqlite/SQLiteConnection;", "getRawConnection", "()Landroidx/sqlite/SQLiteConnection;", "rawConnection", "room-runtime"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public final class TransactionImpl<T> implements TransactionScope<T>, RawConnectionAccessor {
        public TransactionImpl() {
        }

        @Override // androidx.room.coroutines.RawConnectionAccessor
        public SQLiteConnection getRawConnection() {
            return PooledConnectionImpl.this.getRawConnection();
        }

        /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
        @Override // androidx.room.TransactionScope
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public java.lang.Object rollback(T r7, H7.c<?> r8) throws androidx.room.coroutines.ConnectionPool.RollbackException {
            /*
                r6 = this;
                boolean r0 = r8 instanceof androidx.room.coroutines.PooledConnectionImpl$TransactionImpl$rollback$1
                if (r0 == 0) goto L13
                r0 = r8
                androidx.room.coroutines.PooledConnectionImpl$TransactionImpl$rollback$1 r0 = (androidx.room.coroutines.PooledConnectionImpl$TransactionImpl$rollback$1) r0
                int r1 = r0.label
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r3 = r1 & r2
                if (r3 == 0) goto L13
                int r1 = r1 - r2
                r0.label = r1
                goto L18
            L13:
                androidx.room.coroutines.PooledConnectionImpl$TransactionImpl$rollback$1 r0 = new androidx.room.coroutines.PooledConnectionImpl$TransactionImpl$rollback$1
                r0.<init>(r6, r8)
            L18:
                java.lang.Object r8 = r0.result
                kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f4909a
                int r2 = r0.label
                r3 = 1
                r4 = 0
                if (r2 == 0) goto L3a
                if (r2 == r3) goto L2c
                java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
                java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
                r6.<init>(r7)
                throw r6
            L2c:
                java.lang.Object r6 = r0.L$2
                w9.a r6 = (w9.InterfaceC2108a) r6
                java.lang.Object r7 = r0.L$1
                androidx.room.coroutines.PooledConnectionImpl r7 = (androidx.room.coroutines.PooledConnectionImpl) r7
                java.lang.Object r0 = r0.L$0
                kotlin.b.b(r8)
                goto L7d
            L3a:
                kotlin.b.b(r8)
                androidx.room.coroutines.PooledConnectionImpl r6 = androidx.room.coroutines.PooledConnectionImpl.this
                boolean r8 = androidx.room.coroutines.PooledConnectionImpl.access$isRecycled(r6)
                r2 = 21
                if (r8 != 0) goto La7
                H7.h r8 = r0.getContext()
                androidx.room.coroutines.ConnectionElementKey r5 = r6.getConnectionElementKey()
                H7.f r8 = r8.get(r5)
                androidx.room.coroutines.ConnectionElement r8 = (androidx.room.coroutines.ConnectionElement) r8
                if (r8 == 0) goto La0
                androidx.room.coroutines.PooledConnectionImpl r8 = r8.getConnectionWrapper()
                if (r8 != r6) goto La0
                D7.p r8 = androidx.room.coroutines.PooledConnectionImpl.access$getTransactionStack$p(r6)
                boolean r8 = r8.isEmpty()
                if (r8 != 0) goto L98
                androidx.room.coroutines.ConnectionWithLock r8 = r6.getDelegate()
                r0.L$0 = r7
                r0.L$1 = r6
                r0.L$2 = r8
                r0.label = r3
                java.lang.Object r0 = r8.lock(r4, r0)
                if (r0 != r1) goto L7a
                return r1
            L7a:
                r0 = r7
                r7 = r6
                r6 = r8
            L7d:
                D7.p r7 = androidx.room.coroutines.PooledConnectionImpl.access$getTransactionStack$p(r7)     // Catch: java.lang.Throwable -> L93
                java.lang.Object r7 = r7.last()     // Catch: java.lang.Throwable -> L93
                androidx.room.coroutines.PooledConnectionImpl$TransactionItem r7 = (androidx.room.coroutines.PooledConnectionImpl.TransactionItem) r7     // Catch: java.lang.Throwable -> L93
                r7.setShouldRollback(r3)     // Catch: java.lang.Throwable -> L93
                r6.unlock(r4)
                androidx.room.coroutines.ConnectionPool$RollbackException r6 = new androidx.room.coroutines.ConnectionPool$RollbackException
                r6.<init>(r0)
                throw r6
            L93:
                r7 = move-exception
                r6.unlock(r4)
                throw r7
            L98:
                java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
                java.lang.String r7 = "Not in a transaction"
                r6.<init>(r7)
                throw r6
            La0:
                java.lang.String r6 = "Attempted to use connection on a different coroutine"
                kotlin.KotlinNothingValueException r6 = androidx.constraintlayout.core.dsl.a.m(r2, r6)
                throw r6
            La7:
                java.lang.String r6 = "Connection is recycled"
                kotlin.KotlinNothingValueException r6 = androidx.constraintlayout.core.dsl.a.m(r2, r6)
                throw r6
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.room.coroutines.PooledConnectionImpl.TransactionImpl.rollback(java.lang.Object, H7.c):java.lang.Object");
        }

        @Override // androidx.room.PooledConnection
        public <R> Object usePrepared(String str, S7.k kVar, c<? super R> cVar) {
            return PooledConnectionImpl.this.usePrepared(str, kVar, cVar);
        }

        @Override // androidx.room.TransactionScope
        public <R> Object withNestedTransaction(n nVar, c<? super R> cVar) {
            PooledConnectionImpl pooledConnectionImpl = PooledConnectionImpl.this;
            if (pooledConnectionImpl.isRecycled()) {
                throw androidx.constraintlayout.core.dsl.a.m(21, "Connection is recycled");
            }
            ConnectionElement connectionElement = (ConnectionElement) cVar.getContext().get(pooledConnectionImpl.getConnectionElementKey());
            if (connectionElement == null || connectionElement.getConnectionWrapper() != pooledConnectionImpl) {
                throw androidx.constraintlayout.core.dsl.a.m(21, "Attempted to use connection on a different coroutine");
            }
            return pooledConnectionImpl.transaction(null, nVar, cVar);
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Landroidx/room/coroutines/PooledConnectionImpl$TransactionItem;", "", "id", "", "shouldRollback", "", AppAgent.CONSTRUCT, "(IZ)V", "getId", "()I", "getShouldRollback", "()Z", "setShouldRollback", "(Z)V", "room-runtime"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class TransactionItem {
        private final int id;
        private boolean shouldRollback;

        public TransactionItem(int i, boolean z10) {
            this.id = i;
            this.shouldRollback = z10;
        }

        public final int getId() {
            return this.id;
        }

        public final boolean getShouldRollback() {
            return this.shouldRollback;
        }

        public final void setShouldRollback(boolean z10) {
            this.shouldRollback = z10;
        }
    }

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Transactor.SQLiteTransactionType.values().length];
            try {
                iArr[Transactor.SQLiteTransactionType.DEFERRED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[Transactor.SQLiteTransactionType.IMMEDIATE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[Transactor.SQLiteTransactionType.EXCLUSIVE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    @J7.c(c = "androidx.room.coroutines.PooledConnectionImpl", f = "ConnectionPoolImpl.kt", l = {557}, m = "beginTransaction")
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* renamed from: androidx.room.coroutines.PooledConnectionImpl$beginTransaction$1, reason: invalid class name */
    public static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(c<? super AnonymousClass1> cVar) {
            super(cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return PooledConnectionImpl.this.beginTransaction(null, this);
        }
    }

    @J7.c(c = "androidx.room.coroutines.PooledConnectionImpl", f = "ConnectionPoolImpl.kt", l = {557}, m = "endTransaction")
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* renamed from: androidx.room.coroutines.PooledConnectionImpl$endTransaction$1, reason: invalid class name and case insensitive filesystem */
    public static final class C07931 extends ContinuationImpl {
        Object L$0;
        boolean Z$0;
        int label;
        /* synthetic */ Object result;

        public C07931(c<? super C07931> cVar) {
            super(cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return PooledConnectionImpl.this.endTransaction(false, this);
        }
    }

    @J7.c(c = "androidx.room.coroutines.PooledConnectionImpl", f = "ConnectionPoolImpl.kt", l = {392, 396, 410, 410, 410}, m = "transaction")
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* renamed from: androidx.room.coroutines.PooledConnectionImpl$transaction$1, reason: invalid class name and case insensitive filesystem */
    public static final class C07941<R> extends ContinuationImpl {
        int I$0;
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        public C07941(c<? super C07941> cVar) {
            super(cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return PooledConnectionImpl.this.transaction(null, null, this);
        }
    }

    @J7.c(c = "androidx.room.coroutines.PooledConnectionImpl", f = "ConnectionPoolImpl.kt", l = {568}, m = "usePrepared")
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* renamed from: androidx.room.coroutines.PooledConnectionImpl$usePrepared$1, reason: invalid class name and case insensitive filesystem */
    public static final class C07951<R> extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        public C07951(c<? super C07951> cVar) {
            super(cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return PooledConnectionImpl.this.usePrepared(null, null, this);
        }
    }

    public PooledConnectionImpl(ConnectionElementKey connectionElementKey, ConnectionWithLock delegate, boolean z10) {
        k.f(connectionElementKey, "connectionElementKey");
        k.f(delegate, "delegate");
        this.connectionElementKey = connectionElementKey;
        this.delegate = delegate;
        this.isReadOnly = z10;
        this.transactionStack = new p();
        this._isRecycled = new AtomicBoolean(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0015  */
    /* JADX WARN: Type inference failed for: r7v11, types: [w9.a] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object beginTransaction(androidx.room.Transactor.SQLiteTransactionType r7, H7.c<? super C7.r> r8) {
        /*
            r6 = this;
            java.lang.String r0 = "SAVEPOINT '"
            boolean r1 = r8 instanceof androidx.room.coroutines.PooledConnectionImpl.AnonymousClass1
            if (r1 == 0) goto L15
            r1 = r8
            androidx.room.coroutines.PooledConnectionImpl$beginTransaction$1 r1 = (androidx.room.coroutines.PooledConnectionImpl.AnonymousClass1) r1
            int r2 = r1.label
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r4 = r2 & r3
            if (r4 == 0) goto L15
            int r2 = r2 - r3
            r1.label = r2
            goto L1a
        L15:
            androidx.room.coroutines.PooledConnectionImpl$beginTransaction$1 r1 = new androidx.room.coroutines.PooledConnectionImpl$beginTransaction$1
            r1.<init>(r8)
        L1a:
            java.lang.Object r8 = r1.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r2 = kotlin.coroutines.intrinsics.CoroutineSingletons.f4909a
            int r3 = r1.label
            r4 = 1
            r5 = 0
            if (r3 == 0) goto L3c
            if (r3 != r4) goto L34
            java.lang.Object r7 = r1.L$1
            w9.a r7 = (w9.InterfaceC2108a) r7
            java.lang.Object r1 = r1.L$0
            androidx.room.Transactor$SQLiteTransactionType r1 = (androidx.room.Transactor.SQLiteTransactionType) r1
            kotlin.b.b(r8)
            r8 = r7
            r7 = r1
            goto L4e
        L34:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L3c:
            kotlin.b.b(r8)
            androidx.room.coroutines.ConnectionWithLock r8 = r6.delegate
            r1.L$0 = r7
            r1.L$1 = r8
            r1.label = r4
            java.lang.Object r1 = r8.lock(r5, r1)
            if (r1 != r2) goto L4e
            return r2
        L4e:
            D7.p r1 = r6.transactionStack     // Catch: java.lang.Throwable -> L74
            int r1 = r1.size()     // Catch: java.lang.Throwable -> L74
            D7.p r2 = r6.transactionStack     // Catch: java.lang.Throwable -> L74
            boolean r2 = r2.isEmpty()     // Catch: java.lang.Throwable -> L74
            if (r2 == 0) goto L8c
            int[] r0 = androidx.room.coroutines.PooledConnectionImpl.WhenMappings.$EnumSwitchMapping$0     // Catch: java.lang.Throwable -> L74
            int r7 = r7.ordinal()     // Catch: java.lang.Throwable -> L74
            r7 = r0[r7]     // Catch: java.lang.Throwable -> L74
            if (r7 == r4) goto L84
            r0 = 2
            if (r7 == r0) goto L7c
            r0 = 3
            if (r7 != r0) goto L76
            androidx.room.coroutines.ConnectionWithLock r7 = r6.delegate     // Catch: java.lang.Throwable -> L74
            java.lang.String r0 = "BEGIN EXCLUSIVE TRANSACTION"
            androidx.sqlite.SQLite.execSQL(r7, r0)     // Catch: java.lang.Throwable -> L74
            goto La2
        L74:
            r6 = move-exception
            goto Lb3
        L76:
            kotlin.NoWhenBranchMatchedException r6 = new kotlin.NoWhenBranchMatchedException     // Catch: java.lang.Throwable -> L74
            r6.<init>()     // Catch: java.lang.Throwable -> L74
            throw r6     // Catch: java.lang.Throwable -> L74
        L7c:
            androidx.room.coroutines.ConnectionWithLock r7 = r6.delegate     // Catch: java.lang.Throwable -> L74
            java.lang.String r0 = "BEGIN IMMEDIATE TRANSACTION"
            androidx.sqlite.SQLite.execSQL(r7, r0)     // Catch: java.lang.Throwable -> L74
            goto La2
        L84:
            androidx.room.coroutines.ConnectionWithLock r7 = r6.delegate     // Catch: java.lang.Throwable -> L74
            java.lang.String r0 = "BEGIN DEFERRED TRANSACTION"
            androidx.sqlite.SQLite.execSQL(r7, r0)     // Catch: java.lang.Throwable -> L74
            goto La2
        L8c:
            androidx.room.coroutines.ConnectionWithLock r7 = r6.delegate     // Catch: java.lang.Throwable -> L74
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L74
            r2.<init>(r0)     // Catch: java.lang.Throwable -> L74
            r2.append(r1)     // Catch: java.lang.Throwable -> L74
            r0 = 39
            r2.append(r0)     // Catch: java.lang.Throwable -> L74
            java.lang.String r0 = r2.toString()     // Catch: java.lang.Throwable -> L74
            androidx.sqlite.SQLite.execSQL(r7, r0)     // Catch: java.lang.Throwable -> L74
        La2:
            D7.p r6 = r6.transactionStack     // Catch: java.lang.Throwable -> L74
            androidx.room.coroutines.PooledConnectionImpl$TransactionItem r7 = new androidx.room.coroutines.PooledConnectionImpl$TransactionItem     // Catch: java.lang.Throwable -> L74
            r0 = 0
            r7.<init>(r1, r0)     // Catch: java.lang.Throwable -> L74
            r6.addLast(r7)     // Catch: java.lang.Throwable -> L74
            C7.r r6 = C7.r.f317a     // Catch: java.lang.Throwable -> L74
            r8.unlock(r5)
            return r6
        Lb3:
            r8.unlock(r5)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.room.coroutines.PooledConnectionImpl.beginTransaction(androidx.room.Transactor$SQLiteTransactionType, H7.c):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object endTransaction(boolean r8, H7.c<? super C7.r> r9) {
        /*
            r7 = this;
            java.lang.String r0 = "ROLLBACK TRANSACTION TO SAVEPOINT '"
            java.lang.String r1 = "RELEASE SAVEPOINT '"
            boolean r2 = r9 instanceof androidx.room.coroutines.PooledConnectionImpl.C07931
            if (r2 == 0) goto L17
            r2 = r9
            androidx.room.coroutines.PooledConnectionImpl$endTransaction$1 r2 = (androidx.room.coroutines.PooledConnectionImpl.C07931) r2
            int r3 = r2.label
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r5 = r3 & r4
            if (r5 == 0) goto L17
            int r3 = r3 - r4
            r2.label = r3
            goto L1c
        L17:
            androidx.room.coroutines.PooledConnectionImpl$endTransaction$1 r2 = new androidx.room.coroutines.PooledConnectionImpl$endTransaction$1
            r2.<init>(r9)
        L1c:
            java.lang.Object r9 = r2.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r3 = kotlin.coroutines.intrinsics.CoroutineSingletons.f4909a
            int r4 = r2.label
            r5 = 1
            r6 = 0
            if (r4 == 0) goto L3a
            if (r4 != r5) goto L32
            boolean r8 = r2.Z$0
            java.lang.Object r2 = r2.L$0
            w9.a r2 = (w9.InterfaceC2108a) r2
            kotlin.b.b(r9)
            goto L4d
        L32:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L3a:
            kotlin.b.b(r9)
            androidx.room.coroutines.ConnectionWithLock r9 = r7.delegate
            r2.L$0 = r9
            r2.Z$0 = r8
            r2.label = r5
            java.lang.Object r2 = r9.lock(r6, r2)
            if (r2 != r3) goto L4c
            return r3
        L4c:
            r2 = r9
        L4d:
            D7.p r9 = r7.transactionStack     // Catch: java.lang.Throwable -> L77
            boolean r9 = r9.isEmpty()     // Catch: java.lang.Throwable -> L77
            if (r9 != 0) goto Lc0
            D7.p r9 = r7.transactionStack     // Catch: java.lang.Throwable -> L77
            java.lang.Object r9 = D7.A.o0(r9)     // Catch: java.lang.Throwable -> L77
            androidx.room.coroutines.PooledConnectionImpl$TransactionItem r9 = (androidx.room.coroutines.PooledConnectionImpl.TransactionItem) r9     // Catch: java.lang.Throwable -> L77
            r3 = 39
            if (r8 == 0) goto L92
            boolean r8 = r9.getShouldRollback()     // Catch: java.lang.Throwable -> L77
            if (r8 != 0) goto L92
            D7.p r8 = r7.transactionStack     // Catch: java.lang.Throwable -> L77
            boolean r8 = r8.isEmpty()     // Catch: java.lang.Throwable -> L77
            if (r8 == 0) goto L79
            androidx.room.coroutines.ConnectionWithLock r7 = r7.delegate     // Catch: java.lang.Throwable -> L77
            java.lang.String r8 = "END TRANSACTION"
            androidx.sqlite.SQLite.execSQL(r7, r8)     // Catch: java.lang.Throwable -> L77
            goto Lba
        L77:
            r7 = move-exception
            goto Lc8
        L79:
            androidx.room.coroutines.ConnectionWithLock r7 = r7.delegate     // Catch: java.lang.Throwable -> L77
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L77
            r8.<init>(r1)     // Catch: java.lang.Throwable -> L77
            int r9 = r9.getId()     // Catch: java.lang.Throwable -> L77
            r8.append(r9)     // Catch: java.lang.Throwable -> L77
            r8.append(r3)     // Catch: java.lang.Throwable -> L77
            java.lang.String r8 = r8.toString()     // Catch: java.lang.Throwable -> L77
            androidx.sqlite.SQLite.execSQL(r7, r8)     // Catch: java.lang.Throwable -> L77
            goto Lba
        L92:
            D7.p r8 = r7.transactionStack     // Catch: java.lang.Throwable -> L77
            boolean r8 = r8.isEmpty()     // Catch: java.lang.Throwable -> L77
            if (r8 == 0) goto La2
            androidx.room.coroutines.ConnectionWithLock r7 = r7.delegate     // Catch: java.lang.Throwable -> L77
            java.lang.String r8 = "ROLLBACK TRANSACTION"
            androidx.sqlite.SQLite.execSQL(r7, r8)     // Catch: java.lang.Throwable -> L77
            goto Lba
        La2:
            androidx.room.coroutines.ConnectionWithLock r7 = r7.delegate     // Catch: java.lang.Throwable -> L77
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L77
            r8.<init>(r0)     // Catch: java.lang.Throwable -> L77
            int r9 = r9.getId()     // Catch: java.lang.Throwable -> L77
            r8.append(r9)     // Catch: java.lang.Throwable -> L77
            r8.append(r3)     // Catch: java.lang.Throwable -> L77
            java.lang.String r8 = r8.toString()     // Catch: java.lang.Throwable -> L77
            androidx.sqlite.SQLite.execSQL(r7, r8)     // Catch: java.lang.Throwable -> L77
        Lba:
            C7.r r7 = C7.r.f317a     // Catch: java.lang.Throwable -> L77
            r2.unlock(r6)
            return r7
        Lc0:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException     // Catch: java.lang.Throwable -> L77
            java.lang.String r8 = "Not in a transaction"
            r7.<init>(r8)     // Catch: java.lang.Throwable -> L77
            throw r7     // Catch: java.lang.Throwable -> L77
        Lc8:
            r2.unlock(r6)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.room.coroutines.PooledConnectionImpl.endTransaction(boolean, H7.c):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean isRecycled() {
        return this._isRecycled.get();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0093 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:65:0x00c4  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00c8  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final <R> java.lang.Object transaction(androidx.room.Transactor.SQLiteTransactionType r11, S7.n r12, H7.c<? super R> r13) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 201
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.room.coroutines.PooledConnectionImpl.transaction(androidx.room.Transactor$SQLiteTransactionType, S7.n, H7.c):java.lang.Object");
    }

    private final <R> Object withStateCheck(S7.a aVar, c<? super R> cVar) {
        if (isRecycled()) {
            throw androidx.constraintlayout.core.dsl.a.m(21, "Connection is recycled");
        }
        throw null;
    }

    public final ConnectionElementKey getConnectionElementKey() {
        return this.connectionElementKey;
    }

    public final ConnectionWithLock getDelegate() {
        return this.delegate;
    }

    @Override // androidx.room.coroutines.RawConnectionAccessor
    public SQLiteConnection getRawConnection() {
        return this.delegate;
    }

    @Override // androidx.room.Transactor
    public Object inTransaction(c<? super Boolean> cVar) {
        if (isRecycled()) {
            throw androidx.constraintlayout.core.dsl.a.m(21, "Connection is recycled");
        }
        ConnectionElement connectionElement = (ConnectionElement) cVar.getContext().get(getConnectionElementKey());
        if (connectionElement == null || connectionElement.getConnectionWrapper() != this) {
            throw androidx.constraintlayout.core.dsl.a.m(21, "Attempted to use connection on a different coroutine");
        }
        return Boolean.valueOf(!this.transactionStack.isEmpty() || this.delegate.inTransaction());
    }

    /* renamed from: isReadOnly, reason: from getter */
    public final boolean getIsReadOnly() {
        return this.isReadOnly;
    }

    public final void markRecycled() {
        if (this._isRecycled.compareAndSet(false, true) && this.delegate.inTransaction()) {
            SQLite.execSQL(this.delegate, "ROLLBACK TRANSACTION");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Type inference failed for: r7v6, types: [w9.a] */
    @Override // androidx.room.PooledConnection
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public <R> java.lang.Object usePrepared(java.lang.String r7, S7.k r8, H7.c<? super R> r9) {
        /*
            r6 = this;
            boolean r0 = r9 instanceof androidx.room.coroutines.PooledConnectionImpl.C07951
            if (r0 == 0) goto L13
            r0 = r9
            androidx.room.coroutines.PooledConnectionImpl$usePrepared$1 r0 = (androidx.room.coroutines.PooledConnectionImpl.C07951) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            androidx.room.coroutines.PooledConnectionImpl$usePrepared$1 r0 = new androidx.room.coroutines.PooledConnectionImpl$usePrepared$1
            r0.<init>(r9)
        L18:
            java.lang.Object r9 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f4909a
            int r2 = r0.label
            r3 = 1
            r4 = 0
            if (r2 == 0) goto L3e
            if (r2 != r3) goto L36
            java.lang.Object r7 = r0.L$2
            w9.a r7 = (w9.InterfaceC2108a) r7
            java.lang.Object r8 = r0.L$1
            S7.k r8 = (S7.k) r8
            java.lang.Object r0 = r0.L$0
            java.lang.String r0 = (java.lang.String) r0
            kotlin.b.b(r9)
            r9 = r7
            r7 = r0
            goto L70
        L36:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L3e:
            kotlin.b.b(r9)
            boolean r9 = access$isRecycled(r6)
            r2 = 21
            if (r9 != 0) goto L9a
            H7.h r9 = r0.getContext()
            androidx.room.coroutines.ConnectionElementKey r5 = r6.getConnectionElementKey()
            H7.f r9 = r9.get(r5)
            androidx.room.coroutines.ConnectionElement r9 = (androidx.room.coroutines.ConnectionElement) r9
            if (r9 == 0) goto L93
            androidx.room.coroutines.PooledConnectionImpl r9 = r9.getConnectionWrapper()
            if (r9 != r6) goto L93
            androidx.room.coroutines.ConnectionWithLock r9 = r6.delegate
            r0.L$0 = r7
            r0.L$1 = r8
            r0.L$2 = r9
            r0.label = r3
            java.lang.Object r0 = r9.lock(r4, r0)
            if (r0 != r1) goto L70
            return r1
        L70:
            androidx.room.coroutines.PooledConnectionImpl$StatementWrapper r0 = new androidx.room.coroutines.PooledConnectionImpl$StatementWrapper     // Catch: java.lang.Throwable -> L86
            androidx.room.coroutines.ConnectionWithLock r1 = r6.delegate     // Catch: java.lang.Throwable -> L86
            androidx.sqlite.SQLiteStatement r7 = r1.prepare(r7)     // Catch: java.lang.Throwable -> L86
            r0.<init>(r6, r7)     // Catch: java.lang.Throwable -> L86
            java.lang.Object r6 = r8.invoke(r0)     // Catch: java.lang.Throwable -> L88
            com.stepos.ability.task.executor.e.s(r0, r4)     // Catch: java.lang.Throwable -> L86
            r9.unlock(r4)
            return r6
        L86:
            r6 = move-exception
            goto L8f
        L88:
            r6 = move-exception
            throw r6     // Catch: java.lang.Throwable -> L8a
        L8a:
            r7 = move-exception
            com.stepos.ability.task.executor.e.s(r0, r6)     // Catch: java.lang.Throwable -> L86
            throw r7     // Catch: java.lang.Throwable -> L86
        L8f:
            r9.unlock(r4)
            throw r6
        L93:
            java.lang.String r6 = "Attempted to use connection on a different coroutine"
            kotlin.KotlinNothingValueException r6 = androidx.constraintlayout.core.dsl.a.m(r2, r6)
            throw r6
        L9a:
            java.lang.String r6 = "Connection is recycled"
            kotlin.KotlinNothingValueException r6 = androidx.constraintlayout.core.dsl.a.m(r2, r6)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.room.coroutines.PooledConnectionImpl.usePrepared(java.lang.String, S7.k, H7.c):java.lang.Object");
    }

    @Override // androidx.room.Transactor
    public <R> Object withTransaction(Transactor.SQLiteTransactionType sQLiteTransactionType, n nVar, c<? super R> cVar) {
        if (isRecycled()) {
            throw androidx.constraintlayout.core.dsl.a.m(21, "Connection is recycled");
        }
        ConnectionElement connectionElement = (ConnectionElement) cVar.getContext().get(getConnectionElementKey());
        if (connectionElement == null || connectionElement.getConnectionWrapper() != this) {
            throw androidx.constraintlayout.core.dsl.a.m(21, "Attempted to use connection on a different coroutine");
        }
        return transaction(sQLiteTransactionType, nVar, cVar);
    }
}
