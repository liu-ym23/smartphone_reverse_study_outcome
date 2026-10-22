package androidx.sqlite.db;

import android.content.Context;
import android.database.sqlite.SQLiteException;
import android.util.Log;
import android.util.Pair;
import androidx.annotation.RequiresApi;
import com.monitor.cloudmessage.consts.CloudControlInf;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import kotlin.text.o;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\bf\u0018\u00002\u00020\u0001:\u0003\u0013\u0014\u0015J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H&¢\u0006\u0004\b\u0007\u0010\bR\u0016\u0010\f\u001a\u0004\u0018\u00010\t8&X¦\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\u0010\u001a\u00020\r8&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0012\u001a\u00020\r8&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u000fø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0016À\u0006\u0001"}, d2 = {"Landroidx/sqlite/db/SupportSQLiteOpenHelper;", "Ljava/io/Closeable;", "", "enabled", "", "setWriteAheadLoggingEnabled", "(Z)V", "close", "()V", "", "getDatabaseName", "()Ljava/lang/String;", "databaseName", "Landroidx/sqlite/db/SupportSQLiteDatabase;", "getWritableDatabase", "()Landroidx/sqlite/db/SupportSQLiteDatabase;", "writableDatabase", "getReadableDatabase", "readableDatabase", "a", "b", "Factory", "sqlite_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface SupportSQLiteOpenHelper extends Closeable {

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bæ\u0080\u0001\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0007À\u0006\u0001"}, d2 = {"Landroidx/sqlite/db/SupportSQLiteOpenHelper$Factory;", "", "Landroidx/sqlite/db/SupportSQLiteOpenHelper$b;", "configuration", "Landroidx/sqlite/db/SupportSQLiteOpenHelper;", "create", "(Landroidx/sqlite/db/SupportSQLiteOpenHelper$b;)Landroidx/sqlite/db/SupportSQLiteOpenHelper;", "sqlite_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public interface Factory {
        @NotNull
        SupportSQLiteOpenHelper create(@NotNull b r10);
    }

    public static abstract class a {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final C0049a f4779b = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f4780a;

        /* JADX INFO: renamed from: androidx.sqlite.db.SupportSQLiteOpenHelper$a$a, reason: collision with other inner class name */
        public static final class C0049a {
            public /* synthetic */ C0049a(DefaultConstructorMarker r10) {
                this();
            }

            public C0049a() {
            }
        }

        static {
            f4779b = new C0049a(null);
        }

        public a(int r10) {
            this.f4780a = r10;
        }

        public final void a(String r10) {
            if (o.p(r10, ":memory:", true) == true) goto L41;
            int r11 = r10.length() - 1;
            int r12 = 0;
            boolean r13 = false;
        L5:
            if (r12 > r11) goto L21;
            if (r13 == true) goto L8;
            int r14 = r12;
        L10:
            if (q.i(r10.charAt(r14), 32) > 0) goto L12;
            boolean r15 = true;
        L13:
            if (r13 == false) goto L14;
            if (r15 == false) goto L21;
            r11 = r11 - 1;
            goto L5
        L14:
            if (r15 == false) goto L15;
            r12 = r12 + 1;
            goto L5
        L15:
            r13 = true;
            goto L5
        L12:
            r15 = false;
            goto L13
        L8:
            r14 = r11;
        L21:
            if (r10.subSequence(r12, r11 + 1).toString().length() == 0) goto L42;
            Log.w("SupportSQLite", "deleting the database file: " + r10);
            c0.b.c(new File(r10));     // Catch: Exception -> L26
            return;
        L26:
            e = move-exception;
            Log.w("SupportSQLite", "delete failed: ", e);
            return;
        L42:
            return;
        }

        public void b(SupportSQLiteDatabase r10) {
            q.g(r10, CloudControlInf.DB);
        }

        public void c(SupportSQLiteDatabase r10) {
            q.g(r10, CloudControlInf.DB);
            Log.e("SupportSQLite", "Corruption reported by sqlite on database: " + r10 + ".path");
            if (r10.isOpen() == true) goto L8;
            String r11 = r10.getPath();
            if (r11 == null) goto L41;
            a(r11);
            return;
        L41:
            return;
        L8:
            List<Pair<String, String>> r12 = null;
            r12 = r10.getAttachedDbs();     // Catch: Throwable -> L11 SQLiteException -> L33
        L11:
            th = move-exception;
            if (r12 == null) goto L20;
            Iterator<T> r13 = r12.iterator();
        L18:
            if (r13.hasNext() == false) goto L23;
            Object r14 = ((Pair) r13.next()).second;
            q.f(r14, "p.second");
            a((String) r14);
        L23:
            throw th;
        L20:
            String r15 = r10.getPath();
            if (r15 == null) goto L23;
            a(r15);
        L37:
            r10.close();     // Catch: Throwable -> L11 IOException -> L34
        L24:
            if (r12 == null) goto L29;
            Iterator<T> r16 = r12.iterator();
        L27:
            if (r16.hasNext() == false) goto L43;
            Object r17 = ((Pair) r16.next()).second;
            q.f(r17, "p.second");
            a((String) r17);
            goto L27
        L43:
            return;
        L29:
            String r18 = r10.getPath();
            if (r18 == null) goto L42;
            a(r18);
            return;
        }

        public abstract void d(SupportSQLiteDatabase r10);

        public abstract void e(SupportSQLiteDatabase r10, int r11, int r12);

        public void f(SupportSQLiteDatabase r10) {
            q.g(r10, CloudControlInf.DB);
        }

        public abstract void g(SupportSQLiteDatabase r10, int r11, int r12);
    }

    public static final class b {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final C0050b f4781f = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Context f4782a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f4783b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final a f4784c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final boolean f4785d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final boolean f4786e;

        public static class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final Context f4787a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public String f4788b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public a f4789c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public boolean f4790d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            public boolean f4791e;

            public a(Context r10) {
                q.g(r10, "context");
                this.f4787a = r10;
            }

            public a a(boolean r10) {
                this.f4791e = r10;
                return this;
            }

            public b b() {
                a r10 = this.f4789c;
                if (r10 == null) goto L16;
                if (this.f4790d == false) goto L14;
                String r11 = this.f4788b;
                if (r11 == null) goto L12;
                if (r11.length() != 0) goto L14;
            L12:
                throw new IllegalArgumentException("Must set a non-null database name to a configuration that uses the no backup directory.");
            L14:
                return new b(this.f4787a, this.f4788b, r10, this.f4790d, this.f4791e);
            L16:
                throw new IllegalArgumentException("Must set a callback to create the configuration.");
            }

            public a c(a r10) {
                q.g(r10, "callback");
                this.f4789c = r10;
                return this;
            }

            public a d(String r10) {
                this.f4788b = r10;
                return this;
            }

            public a e(boolean r10) {
                this.f4790d = r10;
                return this;
            }
        }

        /* JADX INFO: renamed from: androidx.sqlite.db.SupportSQLiteOpenHelper$b$b, reason: collision with other inner class name */
        public static final class C0050b {
            public /* synthetic */ C0050b(DefaultConstructorMarker r10) {
                this();
            }

            public final a a(Context r10) {
                q.g(r10, "context");
                return new a(r10);
            }

            public C0050b() {
            }
        }

        static {
            f4781f = new C0050b(null);
        }

        public b(Context r10, String r11, a r12, boolean r13, boolean r14) {
            q.g(r10, "context");
            q.g(r12, "callback");
            this.f4782a = r10;
            this.f4783b = r11;
            this.f4784c = r12;
            this.f4785d = r13;
            this.f4786e = r14;
        }

        public static final a a(Context r10) {
            return f4781f.a(r10);
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    void close();

    @Nullable
    String getDatabaseName();

    @NotNull
    SupportSQLiteDatabase getReadableDatabase();

    @NotNull
    SupportSQLiteDatabase getWritableDatabase();

    @RequiresApi(api = 16)
    void setWriteAheadLoggingEnabled(boolean r10);
}
