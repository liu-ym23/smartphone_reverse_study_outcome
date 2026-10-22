package androidx.room;

import androidx.sqlite.db.SupportSQLiteStatement;
import com.bytedance.apm.constant.CommonKey;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
public final class m0 implements SupportSQLiteStatement {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SupportSQLiteStatement f4612a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f4613b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Executor f4614c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final RoomDatabase.QueryCallback f4615d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final List f4616e;

    public m0(SupportSQLiteStatement r10, String r11, Executor r12, RoomDatabase.QueryCallback r13) {
        kotlin.jvm.internal.q.g(r10, "delegate");
        kotlin.jvm.internal.q.g(r11, "sqlStatement");
        kotlin.jvm.internal.q.g(r12, "queryCallbackExecutor");
        kotlin.jvm.internal.q.g(r13, "queryCallback");
        this.f4612a = r10;
        this.f4613b = r11;
        this.f4614c = r12;
        this.f4615d = r13;
        this.f4616e = new ArrayList();
    }

    public static /* synthetic */ void a(m0 r10) {
        k(r10);
    }

    public static /* synthetic */ void b(m0 r10) {
        j(r10);
    }

    public static /* synthetic */ void c(m0 r10) {
        f(r10);
    }

    public static /* synthetic */ void d(m0 r10) {
        g(r10);
    }

    public static /* synthetic */ void e(m0 r10) {
        h(r10);
    }

    public static final void f(m0 r10) {
        kotlin.jvm.internal.q.g(r10, "this$0");
        r10.f4615d.onQuery(r10.f4613b, r10.f4616e);
    }

    public static final void g(m0 r10) {
        kotlin.jvm.internal.q.g(r10, "this$0");
        r10.f4615d.onQuery(r10.f4613b, r10.f4616e);
    }

    public static final void h(m0 r10) {
        kotlin.jvm.internal.q.g(r10, "this$0");
        r10.f4615d.onQuery(r10.f4613b, r10.f4616e);
    }

    private final void i(int r10, Object r11) {
        int r12 = r10 - 1;
        if (r12 < this.f4616e.size()) goto L7;
        int r13 = (r12 - this.f4616e.size()) + 1;
        int r14 = 0;
    L5:
        if (r14 >= r13) goto L7;
        this.f4616e.add(null);
        r14 = r14 + 1;
    L7:
        this.f4616e.set(r12, r11);
    }

    public static final void j(m0 r10) {
        kotlin.jvm.internal.q.g(r10, "this$0");
        r10.f4615d.onQuery(r10.f4613b, r10.f4616e);
    }

    public static final void k(m0 r10) {
        kotlin.jvm.internal.q.g(r10, "this$0");
        r10.f4615d.onQuery(r10.f4613b, r10.f4616e);
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public void bindBlob(int r10, byte[] r11) {
        kotlin.jvm.internal.q.g(r11, CommonKey.KEY_VALUE);
        i(r10, r11);
        this.f4612a.bindBlob(r10, r11);
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public void bindDouble(int r10, double r11) {
        i(r10, Double.valueOf(r11));
        this.f4612a.bindDouble(r10, r11);
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public void bindLong(int r10, long r11) {
        i(r10, Long.valueOf(r11));
        this.f4612a.bindLong(r10, r11);
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public void bindNull(int r10) {
        i(r10, null);
        this.f4612a.bindNull(r10);
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public void bindString(int r10, String r11) {
        kotlin.jvm.internal.q.g(r11, CommonKey.KEY_VALUE);
        i(r10, r11);
        this.f4612a.bindString(r10, r11);
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public void clearBindings() {
        this.f4616e.clear();
        this.f4612a.clearBindings();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f4612a.close();
    }

    @Override // androidx.sqlite.db.SupportSQLiteStatement
    public void execute() {
        this.f4614c.execute(new k0(this));
        this.f4612a.execute();
    }

    @Override // androidx.sqlite.db.SupportSQLiteStatement
    public long executeInsert() {
        this.f4614c.execute(new i0(this));
        return this.f4612a.executeInsert();
    }

    @Override // androidx.sqlite.db.SupportSQLiteStatement
    public int executeUpdateDelete() {
        this.f4614c.execute(new l0(this));
        return this.f4612a.executeUpdateDelete();
    }

    @Override // androidx.sqlite.db.SupportSQLiteStatement
    public long simpleQueryForLong() {
        this.f4614c.execute(new h0(this));
        return this.f4612a.simpleQueryForLong();
    }

    @Override // androidx.sqlite.db.SupportSQLiteStatement
    public String simpleQueryForString() {
        this.f4614c.execute(new j0(this));
        return this.f4612a.simpleQueryForString();
    }
}
