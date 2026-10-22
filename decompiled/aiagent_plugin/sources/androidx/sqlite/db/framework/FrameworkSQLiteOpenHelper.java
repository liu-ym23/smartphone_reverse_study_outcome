package androidx.sqlite.db.framework;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;

/* JADX INFO: loaded from: classes.dex */
class FrameworkSQLiteOpenHelper implements androidx.sqlite.db.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f2741a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f2742b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final androidx.sqlite.db.d.a f2743c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final boolean f2744d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Object f2745e;
    private OpenHelper f;
    private boolean g;

    static class OpenHelper extends SQLiteOpenHelper {
        final androidx.sqlite.db.d.a mCallback;
        final a[] mDbRef;
        private boolean mMigrated;

        OpenHelper(Context r7, String r8, final a[] r9, final androidx.sqlite.db.d.a r10) {
            super((Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.aiagent.plugin"), r8, null, r10.f2732b, new AnonymousClass1(r10, r9));
            this.mCallback = r10;
            this.mDbRef = r9;
        }

        synchronized androidx.sqlite.db.c getWritableSupportDatabase() {
            monitor-enter(this);
            this.mMigrated = false;     // Catch: Throwable -> L12
            SQLiteDatabase r0 = super.getWritableDatabase();     // Catch: Throwable -> L12
            if (this.mMigrated == false) goto L9;
            close();     // Catch: Throwable -> L12
            androidx.sqlite.db.c r1 = getWritableSupportDatabase();     // Catch: Throwable -> L12
            monitor-exit(this);
            return r1;
        L9:
            a r2 = getWrappedDb(r0);     // Catch: Throwable -> L12
            monitor-exit(this);
            return r2;
        L12:
            th = move-exception;
            throw th;
        }

        synchronized androidx.sqlite.db.c getReadableSupportDatabase() {
            monitor-enter(this);
            this.mMigrated = false;     // Catch: Throwable -> L12
            SQLiteDatabase r0 = super.getReadableDatabase();     // Catch: Throwable -> L12
            if (this.mMigrated == false) goto L9;
            close();     // Catch: Throwable -> L12
            androidx.sqlite.db.c r1 = getReadableSupportDatabase();     // Catch: Throwable -> L12
            monitor-exit(this);
            return r1;
        L9:
            a r2 = getWrappedDb(r0);     // Catch: Throwable -> L12
            monitor-exit(this);
            return r2;
        L12:
            th = move-exception;
            throw th;
        }

        a getWrappedDb(SQLiteDatabase r1) {
            return getWrappedDb(this.mDbRef, r1);
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onCreate(SQLiteDatabase r2) {
            this.mCallback.b(getWrappedDb(r2));
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onUpgrade(SQLiteDatabase r2, int r3, int r4) {
            this.mMigrated = true;
            this.mCallback.a(getWrappedDb(r2), r3, r4);
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onConfigure(SQLiteDatabase r2) {
            this.mCallback.a(getWrappedDb(r2));
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onDowngrade(SQLiteDatabase r2, int r3, int r4) {
            this.mMigrated = true;
            this.mCallback.b(getWrappedDb(r2), r3, r4);
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onOpen(SQLiteDatabase r2) {
            if (this.mMigrated == true) goto L6;
            this.mCallback.c(getWrappedDb(r2));
            return;
        }

        @Override // android.database.sqlite.SQLiteOpenHelper, java.lang.AutoCloseable
        public synchronized void close() {
            monitor-enter(this);
            super.close();     // Catch: Throwable -> L6
            this.mDbRef[0] = null;     // Catch: Throwable -> L6
            monitor-exit(this);
            return;
        L6:
            th = move-exception;
            throw th;
        }

        static a getWrappedDb(a[] r2, SQLiteDatabase r3) {
            a r1 = r2[0];
            if (r1 != null) goto L5;
        L6:
            r2[0] = new a(r3);
        L8:
            return r2[0];
        L5:
            if (r1.a(r3) == true) goto L8;
            goto L6
        }
    }

    FrameworkSQLiteOpenHelper(Context r3, String r4, androidx.sqlite.db.d.a r5, boolean r6) {
        this.f2741a = ZeusTransformUtils.wrapperContext((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin"), "com.obric.aiagent.plugin");
        this.f2742b = r4;
        this.f2743c = r5;
        this.f2744d = r6;
        this.f2745e = new Object();
    }

    private OpenHelper d() {
        Object r0 = this.f2745e;
        monitor-enter(r0);
    L20:
        th = move-exception;
        throw th;
    L5:
        if (this.f != null) goto L17;
        a[] r1 = new a[1];     // Catch: Throwable -> L20
        if (Build.VERSION.SDK_INT >= 23) goto L9;
    L13:
        this.f = new OpenHelper(this.f2741a, this.f2742b, r1, this.f2743c);     // Catch: Throwable -> L20
    L15:
        if (Build.VERSION.SDK_INT < 16) goto L17;
        androidx.sqlite.db.b.a.a(this.f, this.g);     // Catch: Throwable -> L20
        goto L17
    L9:
        if (this.f2742b == null) goto L13;
        if (this.f2744d == false) goto L13;
        File r2 = new File(androidx.sqlite.db.b.c.a(this.f2741a), this.f2742b);     // Catch: Throwable -> L20
        this.f = new OpenHelper(this.f2741a, r2.getAbsolutePath(), r1, this.f2743c);     // Catch: Throwable -> L20
    L17:
        OpenHelper r6 = this.f;     // Catch: Throwable -> L20
        monitor-exit(r0);     // Catch: Throwable -> L20
        return r6;
    }

    @Override // androidx.sqlite.db.d
    public String a() {
        return this.f2742b;
    }

    @Override // androidx.sqlite.db.d
    public void a(boolean r3) {
        Object r0 = this.f2745e;
        monitor-enter(r0);
        OpenHelper r1 = this.f;     // Catch: Throwable -> L10
        if (r1 == null) goto L7;
        androidx.sqlite.db.b.a.a(r1, r3);     // Catch: Throwable -> L10
    L7:
        this.g = r3;     // Catch: Throwable -> L10
        monitor-exit(r0);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        throw th;
    }

    @Override // androidx.sqlite.db.d
    public androidx.sqlite.db.c b() {
        return d().getWritableSupportDatabase();
    }

    @Override // androidx.sqlite.db.d
    public androidx.sqlite.db.c c() {
        return d().getReadableSupportDatabase();
    }

    @Override // androidx.sqlite.db.d, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        d().close();
    }
}
