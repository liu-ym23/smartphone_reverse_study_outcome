package androidx.sqlite.driver;

import com.autonavi.aps.amapapi.config.Const;
import i1.C4159a;
import i1.InterfaceC4160b;
import i1.InterfaceC4162d;
import j1.InterfaceC4756c;
import java.io.IOException;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"Landroidx/sqlite/driver/a;", "Li1/b;", "Lj1/c;", "db", "<init>", "(Lj1/c;)V", "", "inTransaction", "()Z", "", "sql", "Li1/d;", "q1", "(Ljava/lang/String;)Li1/d;", "LY8/t;", "close", "()V", Const.INTENT_KEY_APIKEY, "Lj1/c;", Const.INTENT_KEY_PKGNAME, "()Lj1/c;", "sqlite-framework"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes.dex */
public final class a implements InterfaceC4160b {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final InterfaceC4756c db;

    public a(InterfaceC4756c db2) {
        p.i(db2, "db");
        this.db = db2;
    }

    /* renamed from: b, reason: from getter */
    public final InterfaceC4756c getDb() {
        return this.db;
    }

    @Override // i1.InterfaceC4160b, java.lang.AutoCloseable
    public void close() throws IOException {
        this.db.close();
    }

    @Override // i1.InterfaceC4160b
    public boolean inTransaction() {
        return this.db.inTransaction();
    }

    @Override // i1.InterfaceC4160b
    public InterfaceC4162d q1(String sql) {
        p.i(sql, "sql");
        if (this.db.isOpen()) {
            return SupportSQLiteStatement.INSTANCE.a(this.db, sql);
        }
        C4159a.b(21, "connection is closed");
        throw new KotlinNothingValueException();
    }
}
