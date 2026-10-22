package androidx.sqlite.db;

import android.content.Context;
import android.database.sqlite.SQLiteException;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import com.obric.aiagent.apm.impl.BuildConfig;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: compiled from: SupportSQLiteOpenHelper.java */
/* JADX INFO: loaded from: classes.dex */
public interface d extends Closeable {

    /* JADX INFO: compiled from: SupportSQLiteOpenHelper.java */
    public static abstract class a {
        private static final String TAG = "SupportSQLite";

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f2732b;

        public void a(androidx.sqlite.db.c r2) {
            androidx.sqlite.db.c r1 = (androidx.sqlite.db.c) ZeusTransformUtils.wrapperContextForParams(r2, androidx.sqlite.db.c.class, "com.obric.aiagent.plugin");
        }

        public abstract void a(androidx.sqlite.db.c r1, int r2, int r3);

        public abstract void b(androidx.sqlite.db.c r1);

        public void c(androidx.sqlite.db.c r2) {
            androidx.sqlite.db.c r1 = (androidx.sqlite.db.c) ZeusTransformUtils.wrapperContextForParams(r2, androidx.sqlite.db.c.class, "com.obric.aiagent.plugin");
        }

        public a(int r1) {
            this.f2732b = r1;
        }

        public void b(androidx.sqlite.db.c r2, int r3, int r4) {
            androidx.sqlite.db.c r1 = (androidx.sqlite.db.c) ZeusTransformUtils.wrapperContextForParams(r2, androidx.sqlite.db.c.class, "com.obric.aiagent.plugin");
            throw new SQLiteException("Can't downgrade database from version " + r3 + " to " + r4);
        }

        public void d(androidx.sqlite.db.c r5) {
            androidx.sqlite.db.c r6 = (androidx.sqlite.db.c) ZeusTransformUtils.wrapperContextForParams(r5, androidx.sqlite.db.c.class, "com.obric.aiagent.plugin");
            a(TAG, "Corruption reported by sqlite on database: " + r6.h());
            if (r6.g() == true) goto L6;
            a(r6.h());
            return;
        L6:
            List<Pair<String, String>> r0 = null;
            r0 = r6.j();     // Catch: Throwable -> L9 SQLiteException -> L27
        L9:
            th = move-exception;
            if (r0 == null) goto L18;
            Iterator<Pair<String, String>> r7 = r0.iterator();
        L16:
            if (r7.hasNext() == false) goto L19;
            a((String) ZeusTransformUtils.preCheckCast(((Pair) ZeusTransformUtils.preCheckCast(r7.next(), Pair.class, "com.obric.aiagent.plugin")).second, String.class, "com.obric.aiagent.plugin"));
        L19:
            throw th;
        L18:
            a(r6.h());
        L32:
            r6.close();     // Catch: Throwable -> L9 IOException -> L28
        L20:
            if (r0 == null) goto L25;
            Iterator<Pair<String, String>> r8 = r0.iterator();
        L23:
            if (r8.hasNext() == false) goto L35;
            a((String) ZeusTransformUtils.preCheckCast(((Pair) ZeusTransformUtils.preCheckCast(r8.next(), Pair.class, "com.obric.aiagent.plugin")).second, String.class, "com.obric.aiagent.plugin"));
            goto L23
        L35:
            return;
        L25:
            a(r6.h());
        }

        private void a(String r3) {
            if (r3.equalsIgnoreCase(":memory:") == false) goto L5;
            return;
        L5:
            if (r3.trim().length() == 0) goto L29;
            b(TAG, "deleting the database file: " + r3);
        L19:
            e = move-exception;
            b(TAG, "delete failed: ", e);
            return;
        L9:
            if (Build.VERSION.SDK_INT < 16) goto L22;
            androidx.sqlite.db.b.a.a(new File(r3));     // Catch: Exception -> L19
        L24:
            return;
        L22:
        L16:
            e = move-exception;
            a(TAG, "error while deleting corrupted database file", e);     // Catch: Exception -> L19
            goto L24
        L13:
            if (new File(r3).delete() == true) goto L24;
            a(TAG, "Could not delete the database file " + r3);     // Catch: Exception -> L16
        }

        @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
        public static int b(String r1, String r2) {
            if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
            return 0;
        L5:
            return Log.w(r1, r2);
        }

        @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
        public static int b(String r1, String r2, Throwable r3) {
            if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
            return 0;
        L5:
            return Log.w(r1, r2, r3);
        }

        @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
        public static int a(String r0, String r1) {
            return Log.e(r0, r1);
        }

        @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
        public static int a(String r0, String r1, Throwable r2) {
            return Log.e(r0, r1, r2);
        }
    }

    /* JADX INFO: compiled from: SupportSQLiteOpenHelper.java */
    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Context f2733a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f2734b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final a f2735c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final boolean f2736d;

        /* JADX INFO: compiled from: SupportSQLiteOpenHelper.java */
        public static class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            Context f2737a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            String f2738b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            a f2739c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            boolean f2740d;

            public b a() {
                if (this.f2739c == null) goto L18;
                if (this.f2737a == null) goto L16;
                if (this.f2740d == false) goto L14;
                if (TextUtils.isEmpty(this.f2738b) == false) goto L14;
                throw new IllegalArgumentException("Must set a non-null database name to a configuration that uses the no backup directory.");
            L14:
                return new b(this.f2737a, this.f2738b, this.f2739c, this.f2740d);
            L16:
                throw new IllegalArgumentException("Must set a non-null context to create the configuration.");
            L18:
                throw new IllegalArgumentException("Must set a callback to create the configuration.");
            }

            a(Context r3) {
                this.f2737a = ZeusTransformUtils.wrapperContext((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin"), "com.obric.aiagent.plugin");
            }

            public a a(String r1) {
                this.f2738b = r1;
                return this;
            }

            public a a(a r1) {
                this.f2739c = r1;
                return this;
            }
        }

        b(Context r3, String r4, a r5, boolean r6) {
            this.f2733a = ZeusTransformUtils.wrapperContext((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin"), "com.obric.aiagent.plugin");
            this.f2734b = r4;
            this.f2735c = r5;
            this.f2736d = r6;
        }

        public static a a(Context r2) {
            return new a((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: SupportSQLiteOpenHelper.java */
    public interface c {
        d b(b r1);
    }

    String a();

    void a(boolean r1);

    androidx.sqlite.db.c b();

    androidx.sqlite.db.c c();

    @Override // java.io.Closeable, java.lang.AutoCloseable
    void close();
}
