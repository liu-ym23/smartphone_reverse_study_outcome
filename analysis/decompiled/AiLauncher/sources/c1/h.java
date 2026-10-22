package c1;

import La.H;
import Y8.t;
import Z8.F;
import androidx.collection.l;
import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import e9.InterfaceC4014c;
import eb.InterfaceC4021a;
import i1.InterfaceC4160b;
import i1.InterfaceC4162d;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u000e\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002:\u0002+)B!\u0012\u0006\u0010\u0003\u001a\u00020\u0001\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u0015\u0010\u0013\u001a\u00020\u00002\u0006\u0010\u0012\u001a\u00020\u0011¢\u0006\u0004\b\u0013\u0010\u0014J\r\u0010\u0015\u001a\u00020\u0000¢\u0006\u0004\b\u0015\u0010\u0016J\u0019\u0010\u001a\u001a\u00020\u000e2\n\u0010\u0019\u001a\u00060\u0017j\u0002`\u0018¢\u0006\u0004\b\u001a\u0010\u001bJ\u000f\u0010\u001c\u001a\u00020\tH\u0016¢\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u001f\u001a\u00020\u001eH\u0096\u0001¢\u0006\u0004\b\u001f\u0010 J\u001a\u0010#\u001a\u00020\u000e2\b\u0010\"\u001a\u0004\u0018\u00010!H\u0096A¢\u0006\u0004\b#\u0010$J\u001a\u0010%\u001a\u00020\u001e2\b\u0010\"\u001a\u0004\u0018\u00010!H\u0096\u0001¢\u0006\u0004\b%\u0010&J\u001a\u0010'\u001a\u00020\u000e2\b\u0010\"\u001a\u0004\u0018\u00010!H\u0096\u0001¢\u0006\u0004\b'\u0010(R\u0014\u0010\u0003\u001a\u00020\u00018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b)\u0010*R\u0014\u0010\u0004\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b+\u0010,R\u0018\u0010/\u001a\u0004\u0018\u00010\u00118\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b-\u0010.R\u0018\u00103\u001a\u0004\u0018\u0001008\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b1\u00102R\u001a\u00107\u001a\b\u0018\u000104R\u00020\u00008\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b5\u00106¨\u00068"}, d2 = {"Lc1/h;", "Li1/b;", "Leb/a;", "delegate", "lock", "", "preparedStatementCacheSize", "<init>", "(Li1/b;Leb/a;I)V", "", "sql", "Li1/d;", "q1", "(Ljava/lang/String;)Li1/d;", "LY8/t;", "close", "()V", "Lkotlin/coroutines/d;", "context", "G", "(Lkotlin/coroutines/d;)Lc1/h;", "J", "()Lc1/h;", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "builder", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "(Ljava/lang/StringBuilder;)V", "toString", "()Ljava/lang/String;", "", "inTransaction", "()Z", "", "owner", "m", "(Ljava/lang/Object;Le9/c;)Ljava/lang/Object;", Const.INTENT_KEY_BACKGROUND_COMMAND, "(Ljava/lang/Object;)Z", "l", "(Ljava/lang/Object;)V", Const.INTENT_KEY_APIKEY, "Li1/b;", Const.INTENT_KEY_PKGNAME, "Leb/a;", "c", "Lkotlin/coroutines/d;", "acquireCoroutineContext", "", Const.INTENT_KEY_UMID, "Ljava/lang/Throwable;", "acquireThrowable", "Lc1/h$b;", "e", "Lc1/h$b;", "preparedStatementCache", "room-runtime"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes.dex */
public final class h implements InterfaceC4160b, InterfaceC4021a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final InterfaceC4160b delegate;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final InterfaceC4021a lock;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public kotlin.coroutines.d acquireCoroutineContext;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public Throwable acquireThrowable;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    public final b preparedStatementCache;

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0011\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\"\u0010\f\u001a\u00020\u00052\b\b\u0001\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0096\u0001¢\u0006\u0004\b\f\u0010\rJ\"\u0010\u000f\u001a\u00020\u00052\b\b\u0001\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\u000eH\u0096\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u001a\u0010\u0011\u001a\u00020\u00052\b\b\u0001\u0010\t\u001a\u00020\bH\u0096\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u001a\u0010\u0013\u001a\u00020\n2\b\b\u0001\u0010\t\u001a\u00020\bH\u0096\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u001a\u0010\u0016\u001a\u00020\u00152\b\b\u0001\u0010\t\u001a\u00020\bH\u0096\u0001¢\u0006\u0004\b\u0016\u0010\u0017J\u001a\u0010\u0018\u001a\u00020\u000e2\b\b\u0001\u0010\t\u001a\u00020\bH\u0096\u0001¢\u0006\u0004\b\u0018\u0010\u0019J\u001a\u0010\u001a\u001a\u00020\u00152\b\b\u0001\u0010\t\u001a\u00020\bH\u0096\u0001¢\u0006\u0004\b\u001a\u0010\u0017J\u0010\u0010\u001b\u001a\u00020\bH\u0096\u0001¢\u0006\u0004\b\u001b\u0010\u001cJ\u001a\u0010\u001d\u001a\u00020\u000e2\b\b\u0001\u0010\t\u001a\u00020\bH\u0096\u0001¢\u0006\u0004\b\u001d\u0010\u0019J\u0010\u0010\u001e\u001a\u00020\u0015H\u0096\u0001¢\u0006\u0004\b\u001e\u0010\u001fJ\u0010\u0010 \u001a\u00020\u0005H\u0096\u0001¢\u0006\u0004\b \u0010\u0007J\u0010\u0010!\u001a\u00020\u0005H\u0096\u0001¢\u0006\u0004\b!\u0010\u0007R\u0017\u0010\u0002\u001a\u00020\u00018\u0006¢\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%¨\u0006&"}, d2 = {"Lc1/h$a;", "Li1/d;", "delegate", "<init>", "(Li1/d;)V", "LY8/t;", "close", "()V", "", "index", "", UxipConstants.f30680s, "bindLong", "(IJ)V", "", "H", "(ILjava/lang/String;)V", "bindNull", "(I)V", "getLong", "(I)J", "", "getBoolean", "(I)Z", "X0", "(I)Ljava/lang/String;", "isNull", "getColumnCount", "()I", "getColumnName", "n1", "()Z", "reset", "clearBindings", Const.INTENT_KEY_APIKEY, "Li1/d;", "getDelegate", "()Li1/d;", "room-runtime"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class a implements InterfaceC4162d {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        public final InterfaceC4162d delegate;

        public a(InterfaceC4162d delegate) {
            p.i(delegate, "delegate");
            this.delegate = delegate;
        }

        @Override // i1.InterfaceC4162d
        public void H(int index, String value) {
            p.i(value, "value");
            this.delegate.H(index, value);
        }

        @Override // i1.InterfaceC4162d
        public String X0(int index) {
            return this.delegate.X0(index);
        }

        @Override // i1.InterfaceC4162d
        public void bindLong(int index, long value) {
            this.delegate.bindLong(index, value);
        }

        @Override // i1.InterfaceC4162d
        public void bindNull(int index) {
            this.delegate.bindNull(index);
        }

        @Override // i1.InterfaceC4162d
        public void clearBindings() {
            this.delegate.clearBindings();
        }

        @Override // i1.InterfaceC4162d, java.lang.AutoCloseable
        public void close() {
            this.delegate.reset();
            this.delegate.clearBindings();
        }

        @Override // i1.InterfaceC4162d
        public boolean getBoolean(int index) {
            return this.delegate.getBoolean(index);
        }

        @Override // i1.InterfaceC4162d
        public int getColumnCount() {
            return this.delegate.getColumnCount();
        }

        @Override // i1.InterfaceC4162d
        public String getColumnName(int index) {
            return this.delegate.getColumnName(index);
        }

        @Override // i1.InterfaceC4162d
        public long getLong(int index) {
            return this.delegate.getLong(index);
        }

        @Override // i1.InterfaceC4162d
        public boolean isNull(int index) {
            return this.delegate.isNull(index);
        }

        @Override // i1.InterfaceC4162d
        public boolean n1() {
            return this.delegate.n1();
        }

        @Override // i1.InterfaceC4162d
        public void reset() {
            this.delegate.reset();
        }
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0082\u0004\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0011\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\t\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\t\u0010\nJ1\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u00032\b\u0010\u000e\u001a\u0004\u0018\u00010\u0003H\u0014¢\u0006\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"Lc1/h$b;", "Landroidx/collection/l;", "", "Li1/d;", "", "maxSize", "<init>", "(Lc1/h;I)V", "key", Const.INTENT_KEY_APIKEY, "(Ljava/lang/String;)Li1/d;", "", "evicted", "oldValue", "newValue", "LY8/t;", Const.INTENT_KEY_PKGNAME, "(ZLjava/lang/String;Li1/d;Li1/d;)V", "room-runtime"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public final class b extends l<String, InterfaceC4162d> {
        public b(int i10) {
            super(i10);
        }

        @Override // androidx.collection.l
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public InterfaceC4162d create(String key) {
            p.i(key, "key");
            return h.this.delegate.q1(key);
        }

        @Override // androidx.collection.l
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void entryRemoved(boolean evicted, String key, InterfaceC4162d oldValue, InterfaceC4162d newValue) {
            p.i(key, "key");
            p.i(oldValue, "oldValue");
            oldValue.close();
            super.entryRemoved(evicted, key, oldValue, newValue);
        }
    }

    public h(InterfaceC4160b delegate, InterfaceC4021a lock, int i10) {
        p.i(delegate, "delegate");
        p.i(lock, "lock");
        this.delegate = delegate;
        this.lock = lock;
        this.preparedStatementCache = i10 > 0 ? new b(i10) : null;
    }

    public final void A(StringBuilder builder) {
        p.i(builder, "builder");
        if (this.acquireCoroutineContext == null && this.acquireThrowable == null) {
            builder.append("\t\tStatus: Free connection");
            builder.append('\n');
        } else {
            builder.append("\t\tStatus: Acquired connection");
            builder.append('\n');
            kotlin.coroutines.d dVar = this.acquireCoroutineContext;
            if (dVar != null) {
                builder.append("\t\tCoroutine: " + dVar);
                builder.append('\n');
            }
            Throwable th = this.acquireThrowable;
            if (th != null) {
                builder.append("\t\tAcquired:");
                builder.append('\n');
                Iterator it = F.h0(H.F0(Y8.d.b(th)), 1).iterator();
                while (it.hasNext()) {
                    builder.append("\t\t" + ((String) it.next()));
                    builder.append('\n');
                }
            }
        }
        if (this.preparedStatementCache != null) {
            builder.append("\t\tPrepared Statement Cache Size: " + this.preparedStatementCache.size());
            builder.append('\n');
        }
    }

    public final h G(kotlin.coroutines.d context) {
        p.i(context, "context");
        this.acquireCoroutineContext = context;
        this.acquireThrowable = new Throwable();
        return this;
    }

    public final h J() {
        this.acquireCoroutineContext = null;
        this.acquireThrowable = null;
        return this;
    }

    @Override // i1.InterfaceC4160b, java.lang.AutoCloseable
    public void close() {
        b bVar = this.preparedStatementCache;
        if (bVar != null) {
            bVar.evictAll();
        }
        this.delegate.close();
    }

    @Override // eb.InterfaceC4021a
    public boolean g(Object owner) {
        return this.lock.g(owner);
    }

    @Override // i1.InterfaceC4160b
    public boolean inTransaction() {
        return this.delegate.inTransaction();
    }

    @Override // eb.InterfaceC4021a
    public void l(Object owner) {
        this.lock.l(owner);
    }

    @Override // eb.InterfaceC4021a
    public Object m(Object obj, InterfaceC4014c<? super t> interfaceC4014c) {
        return this.lock.m(obj, interfaceC4014c);
    }

    @Override // i1.InterfaceC4160b
    public InterfaceC4162d q1(String sql) {
        p.i(sql, "sql");
        b bVar = this.preparedStatementCache;
        if (bVar == null) {
            return this.delegate.q1(sql);
        }
        InterfaceC4162d interfaceC4162d = bVar.get(sql);
        p.f(interfaceC4162d);
        return new a(interfaceC4162d);
    }

    public String toString() {
        return this.delegate.toString();
    }

    public /* synthetic */ h(InterfaceC4160b interfaceC4160b, InterfaceC4021a interfaceC4021a, int i10, int i11, kotlin.jvm.internal.i iVar) {
        this(interfaceC4160b, (i11 & 2) != 0 ? eb.f.b(false, 1, null) : interfaceC4021a, i10);
    }
}
