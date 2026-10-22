package j1;

import La.D;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.util.Log;
import android.util.Pair;
import com.autonavi.aps.amapapi.config.Const;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\bf\u0018\u00002\u00020\u0001:\u0003\u0013\u0014\u0015J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H&¢\u0006\u0004\b\u0007\u0010\bR\u0016\u0010\f\u001a\u0004\u0018\u00010\t8&X¦\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\u0010\u001a\u00020\r8&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0012\u001a\u00020\r8&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u000fø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0016À\u0006\u0001"}, d2 = {"Lj1/d;", "Ljava/io/Closeable;", "", x5.d.EXTRA_ENABLED, "LY8/t;", "setWriteAheadLoggingEnabled", "(Z)V", "close", "()V", "", "getDatabaseName", "()Ljava/lang/String;", "databaseName", "Lj1/c;", "getWritableDatabase", "()Lj1/c;", "writableDatabase", "getReadableDatabase", "readableDatabase", Const.INTENT_KEY_APIKEY, Const.INTENT_KEY_PKGNAME, "c", "sqlite"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* renamed from: j1.d, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public interface InterfaceC4757d extends Closeable {

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000e\n\u0002\b\u0005\b&\u0018\u0000 \t2\u00020\u0001:\u0001\u0015B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H&¢\u0006\u0004\b\u000b\u0010\nJ'\u0010\u000e\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u0002H&¢\u0006\u0004\b\u000e\u0010\u000fJ'\u0010\u0010\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0010\u0010\u000fJ\u0017\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0011\u0010\nJ\u0017\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0012\u0010\nJ\u0017\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\u0013H\u0002¢\u0006\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0017¨\u0006\u0018"}, d2 = {"Lj1/d$a;", "", "", "version", "<init>", "(I)V", "Lj1/c;", "db", "LY8/t;", Const.INTENT_KEY_PKGNAME, "(Lj1/c;)V", Const.INTENT_KEY_UMID, "oldVersion", "newVersion", Const.INTENT_KEY_BACKGROUND_COMMAND, "(Lj1/c;II)V", "e", "f", "c", "", "fileName", Const.INTENT_KEY_APIKEY, "(Ljava/lang/String;)V", "I", "sqlite"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* renamed from: j1.d$a */
    public static abstract class a {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        public final int version;

        public a(int i10) {
            this.version = i10;
        }

        public final void a(String fileName) {
            if (D.L(fileName, ":memory:", true)) {
                return;
            }
            int length = fileName.length() - 1;
            int i10 = 0;
            boolean z10 = false;
            while (i10 <= length) {
                boolean z11 = p.k(fileName.charAt(!z10 ? i10 : length), 32) <= 0;
                if (z10) {
                    if (!z11) {
                        break;
                    } else {
                        length--;
                    }
                } else if (z11) {
                    i10++;
                } else {
                    z10 = true;
                }
            }
            if (fileName.subSequence(i10, length + 1).toString().length() == 0) {
                return;
            }
            Log.w("SupportSQLite", "deleting the database file: " + fileName);
            try {
                SQLiteDatabase.deleteDatabase(new File(fileName));
            } catch (Exception e10) {
                Log.w("SupportSQLite", "delete failed: ", e10);
            }
        }

        public void b(InterfaceC4756c db2) {
            p.i(db2, "db");
        }

        public void c(InterfaceC4756c db2) {
            p.i(db2, "db");
            Log.e("SupportSQLite", "Corruption reported by sqlite on database: " + db2 + ".path");
            if (!db2.isOpen()) {
                String path = db2.getPath();
                if (path != null) {
                    a(path);
                    return;
                }
                return;
            }
            List<Pair<String, String>> attachedDbs = null;
            try {
                try {
                    attachedDbs = db2.getAttachedDbs();
                } catch (SQLiteException unused) {
                }
                try {
                    db2.close();
                } catch (IOException unused2) {
                }
                if (attachedDbs != null) {
                    return;
                }
            } finally {
                if (attachedDbs != null) {
                    Iterator<T> it = attachedDbs.iterator();
                    while (it.hasNext()) {
                        Object second = ((Pair) it.next()).second;
                        p.h(second, "second");
                        a((String) second);
                    }
                } else {
                    String path2 = db2.getPath();
                    if (path2 != null) {
                        a(path2);
                    }
                }
            }
        }

        public abstract void d(InterfaceC4756c db2);

        public abstract void e(InterfaceC4756c db2, int oldVersion, int newVersion);

        public abstract void f(InterfaceC4756c db2);

        public abstract void g(InterfaceC4756c db2, int oldVersion, int newVersion);
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000f\u0018\u0000 \u00162\u00020\u0001:\u0002\r\u000fB5\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\t\u001a\u00020\b\u0012\b\b\u0002\u0010\n\u001a\u00020\b¢\u0006\u0004\b\u000b\u0010\fR\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0016\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0007\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0014\u0010\t\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0014\u0010\n\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0014¨\u0006\u0017"}, d2 = {"Lj1/d$b;", "", "Landroid/content/Context;", "context", "", "name", "Lj1/d$a;", "callback", "", "useNoBackupDirectory", "allowDataLossOnRecovery", "<init>", "(Landroid/content/Context;Ljava/lang/String;Lj1/d$a;ZZ)V", Const.INTENT_KEY_APIKEY, "Landroid/content/Context;", Const.INTENT_KEY_PKGNAME, "Ljava/lang/String;", "c", "Lj1/d$a;", Const.INTENT_KEY_UMID, "Z", "e", "f", "sqlite"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* renamed from: j1.d$b */
    public static final class b {

        /* renamed from: f, reason: collision with root package name and from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        public final Context context;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        public final String name;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        public final a callback;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        public final boolean useNoBackupDirectory;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        public final boolean allowDataLossOnRecovery;

        @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0016\u0018\u00002\u00020\u0001B\u0011\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\u000b\u001a\u00020\u00002\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000f\u001a\u00020\u00002\u0006\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\u0011R\u0018\u0010\n\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000f\u0010\u0012R\u0018\u0010\u000e\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000b\u0010\u0013R\u0016\u0010\u0017\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0016\u0010\u0019\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0018\u0010\u0016¨\u0006\u001a"}, d2 = {"Lj1/d$b$a;", "", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Lj1/d$b;", Const.INTENT_KEY_APIKEY, "()Lj1/d$b;", "", "name", "c", "(Ljava/lang/String;)Lj1/d$b$a;", "Lj1/d$a;", "callback", Const.INTENT_KEY_PKGNAME, "(Lj1/d$a;)Lj1/d$b$a;", "Landroid/content/Context;", "Ljava/lang/String;", "Lj1/d$a;", "", Const.INTENT_KEY_UMID, "Z", "useNoBackupDirectory", "e", "allowDataLossOnRecovery", "sqlite"}, k = 1, mv = {2, 1, 0}, xi = 48)
        /* renamed from: j1.d$b$a */
        public static class a {

            /* renamed from: a, reason: collision with root package name and from kotlin metadata */
            public final Context context;

            /* renamed from: b, reason: collision with root package name and from kotlin metadata */
            public String name;

            /* renamed from: c, reason: collision with root package name and from kotlin metadata */
            public a callback;

            /* renamed from: d, reason: collision with root package name and from kotlin metadata */
            public boolean useNoBackupDirectory;

            /* renamed from: e, reason: collision with root package name and from kotlin metadata */
            public boolean allowDataLossOnRecovery;

            public a(Context context) {
                p.i(context, "context");
                this.context = context;
            }

            public b a() {
                String str;
                a aVar = this.callback;
                if (aVar == null) {
                    throw new IllegalArgumentException("Must set a callback to create the configuration.");
                }
                if (this.useNoBackupDirectory && ((str = this.name) == null || str.length() == 0)) {
                    throw new IllegalArgumentException("Must set a non-null database name to a configuration that uses the no backup directory.");
                }
                return new b(this.context, this.name, aVar, this.useNoBackupDirectory, this.allowDataLossOnRecovery);
            }

            public a b(a callback) {
                p.i(callback, "callback");
                this.callback = callback;
                return this;
            }

            public a c(String name) {
                this.name = name;
                return this;
            }
        }

        @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lj1/d$b$b;", "", "<init>", "()V", "Landroid/content/Context;", "context", "Lj1/d$b$a;", Const.INTENT_KEY_APIKEY, "(Landroid/content/Context;)Lj1/d$b$a;", "sqlite"}, k = 1, mv = {2, 1, 0}, xi = 48)
        /* renamed from: j1.d$b$b, reason: collision with other inner class name and from kotlin metadata */
        public static final class Companion {
            public /* synthetic */ Companion(i iVar) {
                this();
            }

            public final a a(Context context) {
                p.i(context, "context");
                return new a(context);
            }

            public Companion() {
            }
        }

        public b(Context context, String str, a callback, boolean z10, boolean z11) {
            p.i(context, "context");
            p.i(callback, "callback");
            this.context = context;
            this.name = str;
            this.callback = callback;
            this.useNoBackupDirectory = z10;
            this.allowDataLossOnRecovery = z11;
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bæ\u0080\u0001\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0007À\u0006\u0001"}, d2 = {"Lj1/d$c;", "", "Lj1/d$b;", "configuration", "Lj1/d;", "create", "(Lj1/d$b;)Lj1/d;", "sqlite"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* renamed from: j1.d$c */
    public interface c {
        InterfaceC4757d create(b configuration);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    void close();

    String getDatabaseName();

    InterfaceC4756c getReadableDatabase();

    InterfaceC4756c getWritableDatabase();

    void setWriteAheadLoggingEnabled(boolean enabled);
}
