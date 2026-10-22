package androidx.room;

import Z8.C1172u;
import androidx.exifinterface.media.ExifInterface;
import androidx.room.AbstractC1405a;
import androidx.room.RoomDatabase;
import androidx.room.w;
import b1.C1443b;
import com.autonavi.aps.amapapi.config.Const;
import d1.AbstractC3942a;
import f1.C4037g;
import i1.C4159a;
import i1.InterfaceC4160b;
import i1.InterfaceC4161c;
import i1.InterfaceC4162d;
import io.ktor.http.ContentDisposition;
import java.util.Iterator;
import java.util.List;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import n9.C4946a;
import p9.InterfaceC5063a;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\b'\u0018\u0000 92\u00020\u0001:\u0002*'B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\t\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\t\u0010\bJ\u0017\u0010\n\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\n\u0010\bJ\u0017\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u000b\u0010\bJ\u0017\u0010\f\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\f\u0010\bJ\u0017\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0010\u0010\bJ\u0017\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0011\u0010\bJ\u0017\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0012\u0010\bJ\u0017\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0013\u0010\bJ\u0017\u0010\u0014\u001a\u00020\r2\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0014\u0010\u000fJ\u0017\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0015\u0010\bJ\u0017\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0016\u0010\bJ\u0017\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0017\u0010\bJ\u0017\u0010\u001a\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0018H\u0010¢\u0006\u0004\b\u001a\u0010\u001bJ\u0017\u0010\u001c\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0004¢\u0006\u0004\b\u001c\u0010\bJ'\u0010 \u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u001f\u001a\u00020\u001dH\u0004¢\u0006\u0004\b \u0010!J\u0017\u0010\"\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0004¢\u0006\u0004\b\"\u0010\bJ\u0013\u0010$\u001a\u00020\u001d*\u00020#H\u0004¢\u0006\u0004\b$\u0010%J\u0013\u0010&\u001a\u00020\u001d*\u00020#H\u0004¢\u0006\u0004\b&\u0010%R\u0016\u0010)\u001a\u00020\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b'\u0010(R\u0016\u0010+\u001a\u00020\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b*\u0010(R\u0014\u0010/\u001a\u00020,8$X¤\u0004¢\u0006\u0006\u001a\u0004\b-\u0010.R\u0014\u00103\u001a\u0002008$X¤\u0004¢\u0006\u0006\u001a\u0004\b1\u00102R\u001a\u00108\u001a\b\u0012\u0004\u0012\u000205048$X¤\u0004¢\u0006\u0006\u001a\u0004\b6\u00107¨\u0006:"}, d2 = {"Landroidx/room/a;", "", "<init>", "()V", "Li1/b;", "connection", "LY8/t;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "(Li1/b;)V", Const.INTENT_KEY_BACKGROUND_COMMAND, Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "k", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "", "s", "(Li1/b;)Z", "B", "l", "m", "f", "t", "u", "v", "w", "", "fileName", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "(Ljava/lang/String;)Ljava/lang/String;", "x", "", "oldVersion", "newVersion", "y", "(Li1/b;II)V", "z", "Landroidx/room/RoomDatabase$JournalMode;", "p", "(Landroidx/room/RoomDatabase$JournalMode;)I", "q", Const.INTENT_KEY_APIKEY, "Z", "isConfigured", Const.INTENT_KEY_PKGNAME, "isInitializing", "Landroidx/room/c;", "o", "()Landroidx/room/c;", "configuration", "Landroidx/room/w;", "r", "()Landroidx/room/w;", "openDelegate", "", "Landroidx/room/RoomDatabase$b;", "n", "()Ljava/util/List;", "callbacks", "c", "room-runtime"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* renamed from: androidx.room.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC1405a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public boolean isConfigured;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public boolean isInitializing;

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0084\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\u000b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u000b\u0010\tR\u0014\u0010\u0002\u001a\u00020\u00018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\fR\u0014\u0010\u0010\u001a\u00020\r8WX\u0096\u0005¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0011"}, d2 = {"Landroidx/room/a$b;", "Li1/c;", "actual", "<init>", "(Landroidx/room/a;Li1/c;)V", "", "fileName", "Li1/b;", Const.INTENT_KEY_APIKEY, "(Ljava/lang/String;)Li1/b;", ContentDisposition.Parameters.FileName, Const.INTENT_KEY_UMID, "Li1/c;", "", Const.INTENT_KEY_PKGNAME, "()Z", "hasConnectionPool", "room-runtime"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* renamed from: androidx.room.a$b */
    public final class b implements InterfaceC4161c {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        public final InterfaceC4161c actual;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ AbstractC1405a f14629b;

        @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
        /* renamed from: androidx.room.a$b$a, reason: collision with other inner class name */
        public static final class C0179a implements InterfaceC5074l {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ String f14630a;

            public C0179a(String str) {
                this.f14630a = str;
            }

            @Override // p9.InterfaceC5074l
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final Void invoke(Throwable error) {
                kotlin.jvm.internal.p.i(error, "error");
                throw new IllegalStateException("Unable to open database '" + this.f14630a + "'. Was a proper path / name used in Room's database builder?", error);
            }
        }

        public b(AbstractC1405a abstractC1405a, InterfaceC4161c actual) {
            kotlin.jvm.internal.p.i(actual, "actual");
            this.f14629b = abstractC1405a;
            this.actual = actual;
        }

        public static final InterfaceC4160b e(AbstractC1405a abstractC1405a, b bVar, String str) throws Exception {
            if (abstractC1405a.isInitializing) {
                throw new IllegalStateException("Recursive database initialization detected. Did you try to use the database instance during initialization? Maybe in one of the callbacks?");
            }
            InterfaceC4160b interfaceC4160bA = bVar.actual.a(str);
            if (abstractC1405a.isConfigured) {
                abstractC1405a.g(interfaceC4160bA);
                return interfaceC4160bA;
            }
            try {
                abstractC1405a.isInitializing = true;
                abstractC1405a.i(interfaceC4160bA);
                return interfaceC4160bA;
            } finally {
                abstractC1405a.isInitializing = false;
            }
        }

        @Override // i1.InterfaceC4161c
        public InterfaceC4160b a(String fileName) {
            kotlin.jvm.internal.p.i(fileName, "fileName");
            return d(this.f14629b.A(fileName));
        }

        @Override // i1.InterfaceC4161c
        public boolean b() {
            return this.actual.b();
        }

        public final InterfaceC4160b d(final String filename) {
            C1443b c1443b = new C1443b(filename, (this.f14629b.isConfigured || this.f14629b.isInitializing || kotlin.jvm.internal.p.d(filename, ":memory:")) ? false : true);
            final AbstractC1405a abstractC1405a = this.f14629b;
            return (InterfaceC4160b) c1443b.b(new InterfaceC5063a() { // from class: androidx.room.b
                @Override // p9.InterfaceC5063a
                public final Object invoke() {
                    return AbstractC1405a.b.e(abstractC1405a, this, filename);
                }
            }, new C0179a(filename));
        }
    }

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* renamed from: androidx.room.a$c */
    public static final /* synthetic */ class c {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f14631a;

        static {
            int[] iArr = new int[RoomDatabase.JournalMode.values().length];
            try {
                iArr[RoomDatabase.JournalMode.TRUNCATE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[RoomDatabase.JournalMode.WRITE_AHEAD_LOGGING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            f14631a = iArr;
        }
    }

    public abstract String A(String fileName);

    public final void B(InterfaceC4160b connection) {
        l(connection);
        C4159a.a(connection, v.a(getOpenDelegate().getIdentityHash()));
    }

    public final void f(InterfaceC4160b connection) throws Exception {
        Object objB;
        w.a aVarJ;
        if (t(connection)) {
            InterfaceC4162d interfaceC4162dQ1 = connection.q1("SELECT identity_hash FROM room_master_table WHERE id = 42 LIMIT 1");
            try {
                String strX0 = interfaceC4162dQ1.n1() ? interfaceC4162dQ1.X0(0) : null;
                C4946a.a(interfaceC4162dQ1, null);
                if (kotlin.jvm.internal.p.d(getOpenDelegate().getIdentityHash(), strX0) || kotlin.jvm.internal.p.d(getOpenDelegate().getLegacyIdentityHash(), strX0)) {
                    return;
                }
                throw new IllegalStateException(("Room cannot verify the data integrity. Looks like you've changed schema but forgot to update the version number. You can simply fix this by increasing the version number. Expected identity hash: " + getOpenDelegate().getIdentityHash() + ", found: " + strX0).toString());
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    C4946a.a(interfaceC4162dQ1, th);
                    throw th2;
                }
            }
        }
        C4159a.a(connection, "BEGIN EXCLUSIVE TRANSACTION");
        try {
            Result.Companion companion = Result.INSTANCE;
            aVarJ = getOpenDelegate().j(connection);
        } catch (Throwable th3) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th3));
        }
        if (!aVarJ.isValid) {
            throw new IllegalStateException(("Pre-packaged database has an invalid schema: " + aVarJ.expectedFoundMsg).toString());
        }
        getOpenDelegate().h(connection);
        B(connection);
        objB = Result.b(Y8.t.f7040a);
        if (Result.h(objB)) {
            C4159a.a(connection, "END TRANSACTION");
        }
        Throwable thE = Result.e(objB);
        if (thE == null) {
            Result.a(objB);
        } else {
            C4159a.a(connection, "ROLLBACK TRANSACTION");
            throw thE;
        }
    }

    public final void g(InterfaceC4160b connection) throws Exception {
        h(connection);
        k(connection);
        getOpenDelegate().g(connection);
    }

    public final void h(InterfaceC4160b connection) throws Exception {
        InterfaceC4162d interfaceC4162dQ1 = connection.q1("PRAGMA busy_timeout");
        try {
            interfaceC4162dQ1.n1();
            long j10 = interfaceC4162dQ1.getLong(0);
            C4946a.a(interfaceC4162dQ1, null);
            if (j10 < 3000) {
                C4159a.a(connection, "PRAGMA busy_timeout = 3000");
            }
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                C4946a.a(interfaceC4162dQ1, th);
                throw th2;
            }
        }
    }

    public final void i(InterfaceC4160b connection) throws Exception {
        Object objB;
        h(connection);
        j(connection);
        k(connection);
        InterfaceC4162d interfaceC4162dQ1 = connection.q1("PRAGMA user_version");
        try {
            interfaceC4162dQ1.n1();
            int i10 = (int) interfaceC4162dQ1.getLong(0);
            C4946a.a(interfaceC4162dQ1, null);
            if (i10 != getOpenDelegate().getVersion()) {
                C4159a.a(connection, "BEGIN EXCLUSIVE TRANSACTION");
                try {
                    Result.Companion companion = Result.INSTANCE;
                    if (i10 == 0) {
                        x(connection);
                    } else {
                        y(connection, i10, getOpenDelegate().getVersion());
                    }
                    C4159a.a(connection, "PRAGMA user_version = " + getOpenDelegate().getVersion());
                    objB = Result.b(Y8.t.f7040a);
                } catch (Throwable th) {
                    Result.Companion companion2 = Result.INSTANCE;
                    objB = Result.b(C4849c.a(th));
                }
                if (Result.h(objB)) {
                    C4159a.a(connection, "END TRANSACTION");
                }
                Throwable thE = Result.e(objB);
                if (thE != null) {
                    C4159a.a(connection, "ROLLBACK TRANSACTION");
                    throw thE;
                }
            }
            z(connection);
        } finally {
        }
    }

    public final void j(InterfaceC4160b connection) {
        if (getConfiguration().journalMode == RoomDatabase.JournalMode.WRITE_AHEAD_LOGGING) {
            C4159a.a(connection, "PRAGMA journal_mode = WAL");
        } else {
            C4159a.a(connection, "PRAGMA journal_mode = TRUNCATE");
        }
    }

    public final void k(InterfaceC4160b connection) {
        if (getConfiguration().journalMode == RoomDatabase.JournalMode.WRITE_AHEAD_LOGGING) {
            C4159a.a(connection, "PRAGMA synchronous = NORMAL");
        } else {
            C4159a.a(connection, "PRAGMA synchronous = FULL");
        }
    }

    public final void l(InterfaceC4160b connection) {
        C4159a.a(connection, "CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
    }

    public final void m(InterfaceC4160b connection) throws Exception {
        if (!getConfiguration().allowDestructiveMigrationForAllTables) {
            getOpenDelegate().b(connection);
            return;
        }
        InterfaceC4162d interfaceC4162dQ1 = connection.q1("SELECT name, type FROM sqlite_master WHERE type = 'table' OR type = 'view'");
        try {
            List listC = C1172u.c();
            while (interfaceC4162dQ1.n1()) {
                String strX0 = interfaceC4162dQ1.X0(0);
                if (!La.D.X(strX0, "sqlite_", false, 2, null) && !kotlin.jvm.internal.p.d(strX0, "android_metadata")) {
                    listC.add(Y8.j.a(strX0, Boolean.valueOf(kotlin.jvm.internal.p.d(interfaceC4162dQ1.X0(1), "view"))));
                }
            }
            List<Pair> listA = C1172u.a(listC);
            C4946a.a(interfaceC4162dQ1, null);
            for (Pair pair : listA) {
                String str = (String) pair.a();
                if (((Boolean) pair.b()).booleanValue()) {
                    C4159a.a(connection, "DROP VIEW IF EXISTS `" + str + '`');
                } else {
                    C4159a.a(connection, "DROP TABLE IF EXISTS `" + str + '`');
                }
            }
        } finally {
        }
    }

    public abstract List<RoomDatabase.b> n();

    /* renamed from: o */
    public abstract C1407c getConfiguration();

    public final int p(RoomDatabase.JournalMode journalMode) {
        kotlin.jvm.internal.p.i(journalMode, "<this>");
        int i10 = c.f14631a[journalMode.ordinal()];
        if (i10 == 1) {
            return 1;
        }
        if (i10 == 2) {
            return 4;
        }
        throw new IllegalStateException(("Can't get max number of reader for journal mode '" + journalMode + '\'').toString());
    }

    public final int q(RoomDatabase.JournalMode journalMode) {
        kotlin.jvm.internal.p.i(journalMode, "<this>");
        int i10 = c.f14631a[journalMode.ordinal()];
        if (i10 == 1 || i10 == 2) {
            return 1;
        }
        throw new IllegalStateException(("Can't get max number of writers for journal mode '" + journalMode + '\'').toString());
    }

    /* renamed from: r */
    public abstract w getOpenDelegate();

    public final boolean s(InterfaceC4160b connection) throws Exception {
        InterfaceC4162d interfaceC4162dQ1 = connection.q1("SELECT count(*) FROM sqlite_master WHERE name != 'android_metadata'");
        try {
            boolean z10 = false;
            if (interfaceC4162dQ1.n1()) {
                if (interfaceC4162dQ1.getLong(0) == 0) {
                    z10 = true;
                }
            }
            C4946a.a(interfaceC4162dQ1, null);
            return z10;
        } finally {
        }
    }

    public final boolean t(InterfaceC4160b connection) throws Exception {
        InterfaceC4162d interfaceC4162dQ1 = connection.q1("SELECT 1 FROM sqlite_master WHERE type = 'table' AND name = 'room_master_table'");
        try {
            boolean z10 = false;
            if (interfaceC4162dQ1.n1()) {
                if (interfaceC4162dQ1.getLong(0) != 0) {
                    z10 = true;
                }
            }
            C4946a.a(interfaceC4162dQ1, null);
            return z10;
        } finally {
        }
    }

    public final void u(InterfaceC4160b connection) {
        Iterator<T> it = n().iterator();
        while (it.hasNext()) {
            ((RoomDatabase.b) it.next()).a(connection);
        }
    }

    public final void v(InterfaceC4160b connection) {
        Iterator<T> it = n().iterator();
        while (it.hasNext()) {
            ((RoomDatabase.b) it.next()).c(connection);
        }
    }

    public final void w(InterfaceC4160b connection) {
        Iterator<T> it = n().iterator();
        while (it.hasNext()) {
            ((RoomDatabase.b) it.next()).e(connection);
        }
    }

    public final void x(InterfaceC4160b connection) {
        kotlin.jvm.internal.p.i(connection, "connection");
        boolean zS = s(connection);
        getOpenDelegate().a(connection);
        if (!zS) {
            w.a aVarJ = getOpenDelegate().j(connection);
            if (!aVarJ.isValid) {
                throw new IllegalStateException(("Pre-packaged database has an invalid schema: " + aVarJ.expectedFoundMsg).toString());
            }
        }
        B(connection);
        getOpenDelegate().f(connection);
        u(connection);
    }

    public final void y(InterfaceC4160b connection, int oldVersion, int newVersion) {
        kotlin.jvm.internal.p.i(connection, "connection");
        List<AbstractC3942a> listB = C4037g.b(getConfiguration().migrationContainer, oldVersion, newVersion);
        if (listB == null) {
            if (!C4037g.d(getConfiguration(), oldVersion, newVersion)) {
                m(connection);
                v(connection);
                getOpenDelegate().a(connection);
                return;
            } else {
                throw new IllegalStateException(("A migration from " + oldVersion + " to " + newVersion + " was required but not found. Please provide the necessary Migration path via RoomDatabase.Builder.addMigration(...) or allow for destructive migrations via one of the RoomDatabase.Builder.fallbackToDestructiveMigration* functions.").toString());
            }
        }
        getOpenDelegate().i(connection);
        Iterator<T> it = listB.iterator();
        while (it.hasNext()) {
            ((AbstractC3942a) it.next()).a(connection);
        }
        w.a aVarJ = getOpenDelegate().j(connection);
        if (aVarJ.isValid) {
            getOpenDelegate().h(connection);
            B(connection);
        } else {
            throw new IllegalStateException(("Migration didn't properly handle: " + aVarJ.expectedFoundMsg).toString());
        }
    }

    public final void z(InterfaceC4160b connection) {
        kotlin.jvm.internal.p.i(connection, "connection");
        f(connection);
        getOpenDelegate().g(connection);
        w(connection);
        this.isConfigured = true;
    }
}
