package d1;

import com.autonavi.aps.amapapi.config.Const;
import i1.InterfaceC4160b;
import j1.InterfaceC4756c;
import kotlin.Metadata;
import kotlin.NotImplementedError;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b&\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000e\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0010R\u0014\u0010\u0004\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0010¨\u0006\u0011"}, d2 = {"Ld1/a;", "", "", "startVersion", "endVersion", "<init>", "(II)V", "Lj1/c;", "db", "LY8/t;", Const.INTENT_KEY_PKGNAME, "(Lj1/c;)V", "Li1/b;", "connection", Const.INTENT_KEY_APIKEY, "(Li1/b;)V", "I", "room-runtime"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* renamed from: d1.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC3942a {
    public final int endVersion;
    public final int startVersion;

    public AbstractC3942a(int i10, int i11) {
        this.startVersion = i10;
        this.endVersion = i11;
    }

    public void a(InterfaceC4160b connection) {
        p.i(connection, "connection");
        if (!(connection instanceof androidx.sqlite.driver.a)) {
            throw new NotImplementedError("Migration functionality with a provided SQLiteDriver requires overriding the migrate(SQLiteConnection) function.");
        }
        b(((androidx.sqlite.driver.a) connection).getDb());
    }

    public void b(InterfaceC4756c db2) {
        p.i(db2, "db");
        throw new NotImplementedError("Migration functionality with a SupportSQLiteDatabase (without a provided SQLiteDriver) requires overriding the migrate(SupportSQLiteDatabase) function.");
    }
}
