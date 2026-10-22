package androidx.room.coroutines;

import Z8.C1165m;
import androidx.exifinterface.media.ExifInterface;
import androidx.room.B;
import androidx.room.Transactor;
import b1.C1445d;
import c1.C1485a;
import c1.C1486b;
import c1.h;
import c1.j;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import e9.InterfaceC4014c;
import g9.C4109a;
import i1.C4159a;
import i1.InterfaceC4160b;
import i1.InterfaceC4162d;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002:\u0003,\u001c\u001bB\u001f\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nJJ\u0010\u0013\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u000b2\b\u0010\r\u001a\u0004\u0018\u00010\f2(\u0010\u0012\u001a$\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u000f\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u00110\u000eH\u0082@¢\u0006\u0004\b\u0013\u0010\u0014J2\u0010\u0019\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u000b2\u0006\u0010\u0016\u001a\u00020\u00152\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00028\u00000\u0017H\u0096@¢\u0006\u0004\b\u0019\u0010\u001aJH\u0010\u001b\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u000b2\u0006\u0010\r\u001a\u00020\f2(\u0010\u0012\u001a$\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u000f\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u00110\u000eH\u0096@¢\u0006\u0004\b\u001b\u0010\u0014J\u0010\u0010\u001c\u001a\u00020\u0007H\u0096@¢\u0006\u0004\b\u001c\u0010\u001dJ\r\u0010\u001f\u001a\u00020\u001e¢\u0006\u0004\b\u001f\u0010 J\u0018\u0010!\u001a\u00020\u001e2\u0006\u0010\r\u001a\u00020\fH\u0082@¢\u0006\u0004\b!\u0010\"J\u0018\u0010$\u001a\u00020\u001e2\u0006\u0010#\u001a\u00020\u0007H\u0082@¢\u0006\u0004\b$\u0010%R\u0017\u0010\u0004\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\u001b\u0010&\u001a\u0004\b'\u0010(R\u0017\u0010\u0006\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u001c\u0010)\u001a\u0004\b*\u0010+R\u0017\u0010\b\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b,\u0010-\u001a\u0004\b.\u0010/R\u001a\u00103\u001a\b\u0012\u0004\u0012\u000201008\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0019\u00102R\u0016\u00105\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b4\u0010-R\u0014\u00108\u001a\u0002068VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b,\u00107¨\u00069"}, d2 = {"Landroidx/room/coroutines/PooledConnectionImpl;", "Landroidx/room/Transactor;", "Lc1/j;", "Lc1/b;", "connectionElementKey", "Lc1/h;", "delegate", "", "isReadOnly", "<init>", "(Lc1/b;Lc1/h;Z)V", "R", "Landroidx/room/Transactor$SQLiteTransactionType;", "type", "Lkotlin/Function2;", "Landroidx/room/B;", "Le9/c;", "", "block", "o", "(Landroidx/room/Transactor$SQLiteTransactionType;Lp9/p;Le9/c;)Ljava/lang/Object;", "", "sql", "Lkotlin/Function1;", "Li1/d;", Const.INTENT_KEY_UMID, "(Ljava/lang/String;Lp9/l;Le9/c;)Ljava/lang/Object;", Const.INTENT_KEY_APIKEY, Const.INTENT_KEY_PKGNAME, "(Le9/c;)Ljava/lang/Object;", "LY8/t;", "n", "()V", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "(Landroidx/room/Transactor$SQLiteTransactionType;Le9/c;)Ljava/lang/Object;", "success", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "(ZLe9/c;)Ljava/lang/Object;", "Lc1/b;", "k", "()Lc1/b;", "Lc1/h;", "l", "()Lc1/h;", "c", "Z", "m", "()Z", "LZ8/m;", "Landroidx/room/coroutines/PooledConnectionImpl$c;", "LZ8/m;", "transactionStack", "e", "isRecycled", "Li1/b;", "()Li1/b;", "rawConnection", "room-runtime"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes.dex */
public final class PooledConnectionImpl implements Transactor, j {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final C1486b connectionElementKey;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final h delegate;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public final boolean isReadOnly;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public final C1165m<c> transactionStack;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    public volatile boolean isRecycled;

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0011\b\u0082\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u001f\u0010\n\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u001f\u0010\r\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\fH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u000f\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0013\u001a\u00020\f2\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0018\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u0017\u0010\u001a\u001a\u00020\f2\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u001a\u0010\u0014J\u000f\u0010\u001b\u001a\u00020\u0015H\u0016¢\u0006\u0004\b\u001b\u0010\u001cJ\u000f\u0010\u001d\u001a\u00020\tH\u0016¢\u0006\u0004\b\u001d\u0010\u001eJ\u000f\u0010\u001f\u001a\u00020\tH\u0016¢\u0006\u0004\b\u001f\u0010\u001eJ\u000f\u0010 \u001a\u00020\tH\u0016¢\u0006\u0004\b \u0010\u001eR\u0014\u0010\u0002\u001a\u00020\u00018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b!\u0010\"R\u0014\u0010%\u001a\u00020\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b#\u0010$¨\u0006&"}, d2 = {"Landroidx/room/coroutines/PooledConnectionImpl$a;", "Li1/d;", "delegate", "<init>", "(Landroidx/room/coroutines/PooledConnectionImpl;Li1/d;)V", "", "index", "", UxipConstants.f30680s, "LY8/t;", "bindLong", "(IJ)V", "", "H", "(ILjava/lang/String;)V", "bindNull", "(I)V", "getLong", "(I)J", "X0", "(I)Ljava/lang/String;", "", "isNull", "(I)Z", "getColumnCount", "()I", "getColumnName", "n1", "()Z", "reset", "()V", "clearBindings", "close", Const.INTENT_KEY_APIKEY, "Li1/d;", Const.INTENT_KEY_PKGNAME, "J", "threadId", "room-runtime"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public final class a implements InterfaceC4162d {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        public final InterfaceC4162d delegate;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        public final long threadId;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ PooledConnectionImpl f14757c;

        public a(PooledConnectionImpl pooledConnectionImpl, InterfaceC4162d delegate) {
            p.i(delegate, "delegate");
            this.f14757c = pooledConnectionImpl;
            this.delegate = delegate;
            this.threadId = C1445d.b();
        }

        @Override // i1.InterfaceC4162d
        public void H(int index, String value) {
            p.i(value, "value");
            if (this.f14757c.isRecycled) {
                C4159a.b(21, "Statement is recycled");
                throw new KotlinNothingValueException();
            }
            if (this.threadId == C1445d.b()) {
                this.delegate.H(index, value);
            } else {
                C4159a.b(21, "Attempted to use statement on a different thread");
                throw new KotlinNothingValueException();
            }
        }

        @Override // i1.InterfaceC4162d
        public String X0(int index) {
            if (this.f14757c.isRecycled) {
                C4159a.b(21, "Statement is recycled");
                throw new KotlinNothingValueException();
            }
            if (this.threadId == C1445d.b()) {
                return this.delegate.X0(index);
            }
            C4159a.b(21, "Attempted to use statement on a different thread");
            throw new KotlinNothingValueException();
        }

        @Override // i1.InterfaceC4162d
        public void bindLong(int index, long value) {
            if (this.f14757c.isRecycled) {
                C4159a.b(21, "Statement is recycled");
                throw new KotlinNothingValueException();
            }
            if (this.threadId == C1445d.b()) {
                this.delegate.bindLong(index, value);
            } else {
                C4159a.b(21, "Attempted to use statement on a different thread");
                throw new KotlinNothingValueException();
            }
        }

        @Override // i1.InterfaceC4162d
        public void bindNull(int index) {
            if (this.f14757c.isRecycled) {
                C4159a.b(21, "Statement is recycled");
                throw new KotlinNothingValueException();
            }
            if (this.threadId == C1445d.b()) {
                this.delegate.bindNull(index);
            } else {
                C4159a.b(21, "Attempted to use statement on a different thread");
                throw new KotlinNothingValueException();
            }
        }

        @Override // i1.InterfaceC4162d
        public void clearBindings() {
            if (this.f14757c.isRecycled) {
                C4159a.b(21, "Statement is recycled");
                throw new KotlinNothingValueException();
            }
            if (this.threadId == C1445d.b()) {
                this.delegate.clearBindings();
            } else {
                C4159a.b(21, "Attempted to use statement on a different thread");
                throw new KotlinNothingValueException();
            }
        }

        @Override // i1.InterfaceC4162d, java.lang.AutoCloseable
        public void close() {
            if (this.f14757c.isRecycled) {
                C4159a.b(21, "Statement is recycled");
                throw new KotlinNothingValueException();
            }
            if (this.threadId == C1445d.b()) {
                this.delegate.close();
            } else {
                C4159a.b(21, "Attempted to use statement on a different thread");
                throw new KotlinNothingValueException();
            }
        }

        @Override // i1.InterfaceC4162d
        public int getColumnCount() {
            if (this.f14757c.isRecycled) {
                C4159a.b(21, "Statement is recycled");
                throw new KotlinNothingValueException();
            }
            if (this.threadId == C1445d.b()) {
                return this.delegate.getColumnCount();
            }
            C4159a.b(21, "Attempted to use statement on a different thread");
            throw new KotlinNothingValueException();
        }

        @Override // i1.InterfaceC4162d
        public String getColumnName(int index) {
            if (this.f14757c.isRecycled) {
                C4159a.b(21, "Statement is recycled");
                throw new KotlinNothingValueException();
            }
            if (this.threadId == C1445d.b()) {
                return this.delegate.getColumnName(index);
            }
            C4159a.b(21, "Attempted to use statement on a different thread");
            throw new KotlinNothingValueException();
        }

        @Override // i1.InterfaceC4162d
        public long getLong(int index) {
            if (this.f14757c.isRecycled) {
                C4159a.b(21, "Statement is recycled");
                throw new KotlinNothingValueException();
            }
            if (this.threadId == C1445d.b()) {
                return this.delegate.getLong(index);
            }
            C4159a.b(21, "Attempted to use statement on a different thread");
            throw new KotlinNothingValueException();
        }

        @Override // i1.InterfaceC4162d
        public boolean isNull(int index) {
            if (this.f14757c.isRecycled) {
                C4159a.b(21, "Statement is recycled");
                throw new KotlinNothingValueException();
            }
            if (this.threadId == C1445d.b()) {
                return this.delegate.isNull(index);
            }
            C4159a.b(21, "Attempted to use statement on a different thread");
            throw new KotlinNothingValueException();
        }

        @Override // i1.InterfaceC4162d
        public boolean n1() {
            if (this.f14757c.isRecycled) {
                C4159a.b(21, "Statement is recycled");
                throw new KotlinNothingValueException();
            }
            if (this.threadId == C1445d.b()) {
                return this.delegate.n1();
            }
            C4159a.b(21, "Attempted to use statement on a different thread");
            throw new KotlinNothingValueException();
        }

        @Override // i1.InterfaceC4162d
        public void reset() {
            if (this.f14757c.isRecycled) {
                C4159a.b(21, "Statement is recycled");
                throw new KotlinNothingValueException();
            }
            if (this.threadId == C1445d.b()) {
                this.delegate.reset();
            } else {
                C4159a.b(21, "Attempted to use statement on a different thread");
                throw new KotlinNothingValueException();
            }
        }
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0082\u0004\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u00022\u00020\u0003B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J2\u0010\f\u001a\u00028\u0001\"\u0004\b\u0001\u0010\u00062\u0006\u0010\b\u001a\u00020\u00072\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00028\u00010\tH\u0096@¢\u0006\u0004\b\f\u0010\rR\u0014\u0010\u0011\u001a\u00020\u000e8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0012"}, d2 = {"Landroidx/room/coroutines/PooledConnectionImpl$b;", ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/room/B;", "Lc1/j;", "<init>", "(Landroidx/room/coroutines/PooledConnectionImpl;)V", "R", "", "sql", "Lkotlin/Function1;", "Li1/d;", "block", Const.INTENT_KEY_UMID, "(Ljava/lang/String;Lp9/l;Le9/c;)Ljava/lang/Object;", "Li1/b;", "c", "()Li1/b;", "rawConnection", "room-runtime"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public final class b<T> implements B<T>, j {
        public b() {
        }

        @Override // c1.j
        /* renamed from: c */
        public InterfaceC4160b getDelegate() {
            return PooledConnectionImpl.this.getDelegate();
        }

        @Override // androidx.room.l
        public <R> Object d(String str, InterfaceC5074l<? super InterfaceC4162d, ? extends R> interfaceC5074l, InterfaceC4014c<? super R> interfaceC4014c) {
            return PooledConnectionImpl.this.d(str, interfaceC5074l, interfaceC4014c);
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\f\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\b\u0010\nR\"\u0010\u0005\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\u000b\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Landroidx/room/coroutines/PooledConnectionImpl$c;", "", "", "id", "", "shouldRollback", "<init>", "(IZ)V", Const.INTENT_KEY_APIKEY, "I", "()I", Const.INTENT_KEY_PKGNAME, "Z", "()Z", "setShouldRollback", "(Z)V", "room-runtime"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class c {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        public final int id;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        public boolean shouldRollback;

        public c(int i10, boolean z10) {
            this.id = i10;
            this.shouldRollback = z10;
        }

        /* renamed from: a, reason: from getter */
        public final int getId() {
            return this.id;
        }

        /* renamed from: b, reason: from getter */
        public final boolean getShouldRollback() {
            return this.shouldRollback;
        }
    }

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    public static final /* synthetic */ class d {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f14766a;

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
            f14766a = iArr;
        }
    }

    public PooledConnectionImpl(C1486b connectionElementKey, h delegate, boolean z10) {
        p.i(connectionElementKey, "connectionElementKey");
        p.i(delegate, "delegate");
        this.connectionElementKey = connectionElementKey;
        this.delegate = delegate;
        this.isReadOnly = z10;
        this.transactionStack = new C1165m<>();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0089  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0095 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:65:0x00c6  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00ca  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final <R> java.lang.Object o(androidx.room.Transactor.SQLiteTransactionType r11, p9.p<? super androidx.room.B<R>, ? super e9.InterfaceC4014c<? super R>, ? extends java.lang.Object> r12, e9.InterfaceC4014c<? super R> r13) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 203
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.room.coroutines.PooledConnectionImpl.o(androidx.room.Transactor$SQLiteTransactionType, p9.p, e9.c):java.lang.Object");
    }

    @Override // androidx.room.Transactor
    public <R> Object a(Transactor.SQLiteTransactionType sQLiteTransactionType, p9.p<? super B<R>, ? super InterfaceC4014c<? super R>, ? extends Object> pVar, InterfaceC4014c<? super R> interfaceC4014c) {
        if (this.isRecycled) {
            C4159a.b(21, "Connection is recycled");
            throw new KotlinNothingValueException();
        }
        C1485a c1485a = (C1485a) interfaceC4014c.getContext().get(getConnectionElementKey());
        if (c1485a != null && c1485a.getConnectionWrapper() == this) {
            return o(sQLiteTransactionType, pVar, interfaceC4014c);
        }
        C4159a.b(21, "Attempted to use connection on a different coroutine");
        throw new KotlinNothingValueException();
    }

    @Override // androidx.room.Transactor
    public Object b(InterfaceC4014c<? super Boolean> interfaceC4014c) {
        if (this.isRecycled) {
            C4159a.b(21, "Connection is recycled");
            throw new KotlinNothingValueException();
        }
        C1485a c1485a = (C1485a) interfaceC4014c.getContext().get(getConnectionElementKey());
        if (c1485a != null && c1485a.getConnectionWrapper() == this) {
            return C4109a.a(!this.transactionStack.isEmpty() || this.delegate.inTransaction());
        }
        C4159a.b(21, "Attempted to use connection on a different coroutine");
        throw new KotlinNothingValueException();
    }

    @Override // c1.j
    /* renamed from: c */
    public InterfaceC4160b getDelegate() {
        return this.delegate;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Type inference failed for: r7v6, types: [eb.a] */
    @Override // androidx.room.l
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public <R> java.lang.Object d(java.lang.String r7, p9.InterfaceC5074l<? super i1.InterfaceC4162d, ? extends R> r8, e9.InterfaceC4014c<? super R> r9) throws java.lang.Throwable {
        /*
            r6 = this;
            boolean r0 = r9 instanceof androidx.room.coroutines.PooledConnectionImpl$usePrepared$1
            if (r0 == 0) goto L13
            r0 = r9
            androidx.room.coroutines.PooledConnectionImpl$usePrepared$1 r0 = (androidx.room.coroutines.PooledConnectionImpl$usePrepared$1) r0
            int r1 = r0.f14783f
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f14783f = r1
            goto L18
        L13:
            androidx.room.coroutines.PooledConnectionImpl$usePrepared$1 r0 = new androidx.room.coroutines.PooledConnectionImpl$usePrepared$1
            r0.<init>(r6, r9)
        L18:
            java.lang.Object r9 = r0.f14781d
            java.lang.Object r1 = f9.C4063a.g()
            int r2 = r0.f14783f
            r3 = 1
            r4 = 0
            if (r2 == 0) goto L40
            if (r2 != r3) goto L38
            java.lang.Object r7 = r0.f14780c
            eb.a r7 = (eb.InterfaceC4021a) r7
            java.lang.Object r8 = r0.f14779b
            p9.l r8 = (p9.InterfaceC5074l) r8
            java.lang.Object r0 = r0.f14778a
            java.lang.String r0 = (java.lang.String) r0
            kotlin.C4849c.b(r9)
            r9 = r7
            r7 = r0
            goto L72
        L38:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L40:
            kotlin.C4849c.b(r9)
            boolean r9 = g(r6)
            r2 = 21
            if (r9 != 0) goto La0
            kotlin.coroutines.d r9 = r0.getContext()
            c1.b r5 = r6.getConnectionElementKey()
            kotlin.coroutines.d$b r9 = r9.get(r5)
            c1.a r9 = (c1.C1485a) r9
            if (r9 == 0) goto L95
            androidx.room.coroutines.PooledConnectionImpl r9 = r9.getConnectionWrapper()
            if (r9 != r6) goto L95
            c1.h r9 = r6.delegate
            r0.f14778a = r7
            r0.f14779b = r8
            r0.f14780c = r9
            r0.f14783f = r3
            java.lang.Object r0 = r9.m(r4, r0)
            if (r0 != r1) goto L72
            return r1
        L72:
            androidx.room.coroutines.PooledConnectionImpl$a r0 = new androidx.room.coroutines.PooledConnectionImpl$a     // Catch: java.lang.Throwable -> L88
            c1.h r1 = r6.delegate     // Catch: java.lang.Throwable -> L88
            i1.d r7 = r1.q1(r7)     // Catch: java.lang.Throwable -> L88
            r0.<init>(r6, r7)     // Catch: java.lang.Throwable -> L88
            java.lang.Object r6 = r8.invoke(r0)     // Catch: java.lang.Throwable -> L8a
            n9.C4946a.a(r0, r4)     // Catch: java.lang.Throwable -> L88
            r9.l(r4)
            return r6
        L88:
            r6 = move-exception
            goto L91
        L8a:
            r6 = move-exception
            throw r6     // Catch: java.lang.Throwable -> L8c
        L8c:
            r7 = move-exception
            n9.C4946a.a(r0, r6)     // Catch: java.lang.Throwable -> L88
            throw r7     // Catch: java.lang.Throwable -> L88
        L91:
            r9.l(r4)
            throw r6
        L95:
            java.lang.String r6 = "Attempted to use connection on a different coroutine"
            i1.C4159a.b(r2, r6)
            kotlin.KotlinNothingValueException r6 = new kotlin.KotlinNothingValueException
            r6.<init>()
            throw r6
        La0:
            java.lang.String r6 = "Connection is recycled"
            i1.C4159a.b(r2, r6)
            kotlin.KotlinNothingValueException r6 = new kotlin.KotlinNothingValueException
            r6.<init>()
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.room.coroutines.PooledConnectionImpl.d(java.lang.String, p9.l, e9.c):java.lang.Object");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Type inference failed for: r6v11, types: [eb.a] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object i(androidx.room.Transactor.SQLiteTransactionType r6, e9.InterfaceC4014c<? super Y8.t> r7) throws java.lang.Throwable {
        /*
            r5 = this;
            boolean r0 = r7 instanceof androidx.room.coroutines.PooledConnectionImpl$beginTransaction$1
            if (r0 == 0) goto L13
            r0 = r7
            androidx.room.coroutines.PooledConnectionImpl$beginTransaction$1 r0 = (androidx.room.coroutines.PooledConnectionImpl$beginTransaction$1) r0
            int r1 = r0.f14763e
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f14763e = r1
            goto L18
        L13:
            androidx.room.coroutines.PooledConnectionImpl$beginTransaction$1 r0 = new androidx.room.coroutines.PooledConnectionImpl$beginTransaction$1
            r0.<init>(r5, r7)
        L18:
            java.lang.Object r7 = r0.f14761c
            java.lang.Object r1 = f9.C4063a.g()
            int r2 = r0.f14763e
            r3 = 1
            r4 = 0
            if (r2 == 0) goto L3c
            if (r2 != r3) goto L34
            java.lang.Object r6 = r0.f14760b
            eb.a r6 = (eb.InterfaceC4021a) r6
            java.lang.Object r0 = r0.f14759a
            androidx.room.Transactor$SQLiteTransactionType r0 = (androidx.room.Transactor.SQLiteTransactionType) r0
            kotlin.C4849c.b(r7)
            r7 = r6
            r6 = r0
            goto L4e
        L34:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L3c:
            kotlin.C4849c.b(r7)
            c1.h r7 = r5.delegate
            r0.f14759a = r6
            r0.f14760b = r7
            r0.f14763e = r3
            java.lang.Object r0 = r7.m(r4, r0)
            if (r0 != r1) goto L4e
            return r1
        L4e:
            Z8.m<androidx.room.coroutines.PooledConnectionImpl$c> r0 = r5.transactionStack     // Catch: java.lang.Throwable -> L74
            int r0 = r0.size()     // Catch: java.lang.Throwable -> L74
            Z8.m<androidx.room.coroutines.PooledConnectionImpl$c> r1 = r5.transactionStack     // Catch: java.lang.Throwable -> L74
            boolean r1 = r1.isEmpty()     // Catch: java.lang.Throwable -> L74
            if (r1 == 0) goto L8c
            int[] r1 = androidx.room.coroutines.PooledConnectionImpl.d.f14766a     // Catch: java.lang.Throwable -> L74
            int r6 = r6.ordinal()     // Catch: java.lang.Throwable -> L74
            r6 = r1[r6]     // Catch: java.lang.Throwable -> L74
            if (r6 == r3) goto L84
            r1 = 2
            if (r6 == r1) goto L7c
            r1 = 3
            if (r6 != r1) goto L76
            c1.h r6 = r5.delegate     // Catch: java.lang.Throwable -> L74
            java.lang.String r1 = "BEGIN EXCLUSIVE TRANSACTION"
            i1.C4159a.a(r6, r1)     // Catch: java.lang.Throwable -> L74
            goto La7
        L74:
            r5 = move-exception
            goto Lb8
        L76:
            kotlin.NoWhenBranchMatchedException r5 = new kotlin.NoWhenBranchMatchedException     // Catch: java.lang.Throwable -> L74
            r5.<init>()     // Catch: java.lang.Throwable -> L74
            throw r5     // Catch: java.lang.Throwable -> L74
        L7c:
            c1.h r6 = r5.delegate     // Catch: java.lang.Throwable -> L74
            java.lang.String r1 = "BEGIN IMMEDIATE TRANSACTION"
            i1.C4159a.a(r6, r1)     // Catch: java.lang.Throwable -> L74
            goto La7
        L84:
            c1.h r6 = r5.delegate     // Catch: java.lang.Throwable -> L74
            java.lang.String r1 = "BEGIN DEFERRED TRANSACTION"
            i1.C4159a.a(r6, r1)     // Catch: java.lang.Throwable -> L74
            goto La7
        L8c:
            c1.h r6 = r5.delegate     // Catch: java.lang.Throwable -> L74
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L74
            r1.<init>()     // Catch: java.lang.Throwable -> L74
            java.lang.String r2 = "SAVEPOINT '"
            r1.append(r2)     // Catch: java.lang.Throwable -> L74
            r1.append(r0)     // Catch: java.lang.Throwable -> L74
            r2 = 39
            r1.append(r2)     // Catch: java.lang.Throwable -> L74
            java.lang.String r1 = r1.toString()     // Catch: java.lang.Throwable -> L74
            i1.C4159a.a(r6, r1)     // Catch: java.lang.Throwable -> L74
        La7:
            Z8.m<androidx.room.coroutines.PooledConnectionImpl$c> r5 = r5.transactionStack     // Catch: java.lang.Throwable -> L74
            androidx.room.coroutines.PooledConnectionImpl$c r6 = new androidx.room.coroutines.PooledConnectionImpl$c     // Catch: java.lang.Throwable -> L74
            r1 = 0
            r6.<init>(r0, r1)     // Catch: java.lang.Throwable -> L74
            r5.addLast(r6)     // Catch: java.lang.Throwable -> L74
            Y8.t r5 = Y8.t.f7040a     // Catch: java.lang.Throwable -> L74
            r7.l(r4)
            return r5
        Lb8:
            r7.l(r4)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.room.coroutines.PooledConnectionImpl.i(androidx.room.Transactor$SQLiteTransactionType, e9.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object j(boolean r6, e9.InterfaceC4014c<? super Y8.t> r7) throws java.lang.Throwable {
        /*
            r5 = this;
            boolean r0 = r7 instanceof androidx.room.coroutines.PooledConnectionImpl$endTransaction$1
            if (r0 == 0) goto L13
            r0 = r7
            androidx.room.coroutines.PooledConnectionImpl$endTransaction$1 r0 = (androidx.room.coroutines.PooledConnectionImpl$endTransaction$1) r0
            int r1 = r0.f14771e
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f14771e = r1
            goto L18
        L13:
            androidx.room.coroutines.PooledConnectionImpl$endTransaction$1 r0 = new androidx.room.coroutines.PooledConnectionImpl$endTransaction$1
            r0.<init>(r5, r7)
        L18:
            java.lang.Object r7 = r0.f14769c
            java.lang.Object r1 = f9.C4063a.g()
            int r2 = r0.f14771e
            r3 = 1
            r4 = 0
            if (r2 == 0) goto L38
            if (r2 != r3) goto L30
            boolean r6 = r0.f14767a
            java.lang.Object r0 = r0.f14768b
            eb.a r0 = (eb.InterfaceC4021a) r0
            kotlin.C4849c.b(r7)
            goto L4b
        L30:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L38:
            kotlin.C4849c.b(r7)
            c1.h r7 = r5.delegate
            r0.f14768b = r7
            r0.f14767a = r6
            r0.f14771e = r3
            java.lang.Object r0 = r7.m(r4, r0)
            if (r0 != r1) goto L4a
            return r1
        L4a:
            r0 = r7
        L4b:
            Z8.m<androidx.room.coroutines.PooledConnectionImpl$c> r7 = r5.transactionStack     // Catch: java.lang.Throwable -> L75
            boolean r7 = r7.isEmpty()     // Catch: java.lang.Throwable -> L75
            if (r7 != 0) goto Lc8
            Z8.m<androidx.room.coroutines.PooledConnectionImpl$c> r7 = r5.transactionStack     // Catch: java.lang.Throwable -> L75
            java.lang.Object r7 = Z8.A.N(r7)     // Catch: java.lang.Throwable -> L75
            androidx.room.coroutines.PooledConnectionImpl$c r7 = (androidx.room.coroutines.PooledConnectionImpl.c) r7     // Catch: java.lang.Throwable -> L75
            r1 = 39
            if (r6 == 0) goto L95
            boolean r6 = r7.getShouldRollback()     // Catch: java.lang.Throwable -> L75
            if (r6 != 0) goto L95
            Z8.m<androidx.room.coroutines.PooledConnectionImpl$c> r6 = r5.transactionStack     // Catch: java.lang.Throwable -> L75
            boolean r6 = r6.isEmpty()     // Catch: java.lang.Throwable -> L75
            if (r6 == 0) goto L77
            c1.h r5 = r5.delegate     // Catch: java.lang.Throwable -> L75
            java.lang.String r6 = "END TRANSACTION"
            i1.C4159a.a(r5, r6)     // Catch: java.lang.Throwable -> L75
            goto Lc2
        L75:
            r5 = move-exception
            goto Ld0
        L77:
            c1.h r5 = r5.delegate     // Catch: java.lang.Throwable -> L75
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L75
            r6.<init>()     // Catch: java.lang.Throwable -> L75
            java.lang.String r2 = "RELEASE SAVEPOINT '"
            r6.append(r2)     // Catch: java.lang.Throwable -> L75
            int r7 = r7.getId()     // Catch: java.lang.Throwable -> L75
            r6.append(r7)     // Catch: java.lang.Throwable -> L75
            r6.append(r1)     // Catch: java.lang.Throwable -> L75
            java.lang.String r6 = r6.toString()     // Catch: java.lang.Throwable -> L75
            i1.C4159a.a(r5, r6)     // Catch: java.lang.Throwable -> L75
            goto Lc2
        L95:
            Z8.m<androidx.room.coroutines.PooledConnectionImpl$c> r6 = r5.transactionStack     // Catch: java.lang.Throwable -> L75
            boolean r6 = r6.isEmpty()     // Catch: java.lang.Throwable -> L75
            if (r6 == 0) goto La5
            c1.h r5 = r5.delegate     // Catch: java.lang.Throwable -> L75
            java.lang.String r6 = "ROLLBACK TRANSACTION"
            i1.C4159a.a(r5, r6)     // Catch: java.lang.Throwable -> L75
            goto Lc2
        La5:
            c1.h r5 = r5.delegate     // Catch: java.lang.Throwable -> L75
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L75
            r6.<init>()     // Catch: java.lang.Throwable -> L75
            java.lang.String r2 = "ROLLBACK TRANSACTION TO SAVEPOINT '"
            r6.append(r2)     // Catch: java.lang.Throwable -> L75
            int r7 = r7.getId()     // Catch: java.lang.Throwable -> L75
            r6.append(r7)     // Catch: java.lang.Throwable -> L75
            r6.append(r1)     // Catch: java.lang.Throwable -> L75
            java.lang.String r6 = r6.toString()     // Catch: java.lang.Throwable -> L75
            i1.C4159a.a(r5, r6)     // Catch: java.lang.Throwable -> L75
        Lc2:
            Y8.t r5 = Y8.t.f7040a     // Catch: java.lang.Throwable -> L75
            r0.l(r4)
            return r5
        Lc8:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException     // Catch: java.lang.Throwable -> L75
            java.lang.String r6 = "Not in a transaction"
            r5.<init>(r6)     // Catch: java.lang.Throwable -> L75
            throw r5     // Catch: java.lang.Throwable -> L75
        Ld0:
            r0.l(r4)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.room.coroutines.PooledConnectionImpl.j(boolean, e9.c):java.lang.Object");
    }

    /* renamed from: k, reason: from getter */
    public final C1486b getConnectionElementKey() {
        return this.connectionElementKey;
    }

    /* renamed from: l, reason: from getter */
    public final h getDelegate() {
        return this.delegate;
    }

    /* renamed from: m, reason: from getter */
    public final boolean getIsReadOnly() {
        return this.isReadOnly;
    }

    public final void n() {
        if (this.isRecycled) {
            return;
        }
        this.isRecycled = true;
        if (this.delegate.inTransaction()) {
            C4159a.a(this.delegate, "ROLLBACK TRANSACTION");
        }
    }
}
